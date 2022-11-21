package com.oxygen;

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

/**
 * @author oxy
 */
@SpringBootTest
@Slf4j
//@RunWith(SpringRunner.class)
public class OxyEducationWebTest {

    @Test
    public void test(){
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("通过out-gateway查询用友接口数据");
        ExpressionParser parser = new SpelExpressionParser();
        Expression exp = parser.parseExpression("1 + 10");
        Integer message = (Integer) exp.getValue();
        stopWatch.stop();
        System.out.println(message);
        log.info(stopWatch.prettyPrint());
//        System.out.println(stopWatch.prettyPrint());
        log.info("所有任务总耗时：{} ms" ,stopWatch.getTotalTimeMillis() );
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
