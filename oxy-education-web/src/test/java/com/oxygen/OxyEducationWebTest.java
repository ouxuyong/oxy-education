package com.oxygen;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author oxy
 */
@SpringBootTest
@Slf4j
//@RunWith(SpringRunner.class)
public class OxyEducationWebTest {

    @Test
    public void test(){
//        BigDecimal amount = new BigDecimal(66.66);
//        BigDecimal amt = amount.multiply(new BigDecimal("100")).divide(new BigDecimal("1"), 2, BigDecimal.ROUND_HALF_UP);
//        System.out.println(amt);
//        BigDecimal bigDecimal = new BigDecimal(1.125);
//        BigDecimal bigDecimal2 = new BigDecimal(100);
//        BigDecimal divide = bigDecimal.multiply(bigDecimal2).divide(new BigDecimal("1"), 2, BigDecimal.ROUND_HALF_UP);
//        System.out.println(divide);

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("T(java.util.Collections).emptyMap()");
        Object message =  exp.getValue();

        System.out.println(message);
    }

    @Test
    public void test3(){
        StandardEvaluationContext context = new StandardEvaluationContext();
        context.setVariable("key1","66666");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("#key1");

        Object message = exp.getValue(context, Object.class);
        log.info("message ={}",message);

        System.out.println(message);
    }
    @Test
    public void test2(){
        Inventor tesla = new Inventor("Nikola Tesla", "Serbian");

        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("name");

        EvaluationContext context = new StandardEvaluationContext(tesla);
        String name = (String) exp.getValue(context);
        System.out.println(name);
    }
}

@Data
class Inventor {
    private String name;

    private String remark;

    public Inventor(String name, String remark) {
        this.name = name;
        this.remark = remark;
    }
}
