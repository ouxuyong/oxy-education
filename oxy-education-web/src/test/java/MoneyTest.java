import com.oxygen.education.model.UserModel;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * 金额测试类
 */
public class MoneyTest {

    @Test
    public void test1(){
        //商品价格1
        double a1 = 5.00d;
        //商品价格2
        double a2 = 5.12d;
        //商品价格3
        double a3 = 5.05d;

        System.out.println("总金额金额："+(a1+a2+a3));


        //商品价格1
        BigDecimal b1 = BigDecimal.valueOf(a1);
        //商品价格2
        BigDecimal b2 = BigDecimal.valueOf(a2);
        //商品价格
        BigDecimal b3 = BigDecimal.valueOf(a3);

        System.out.println("BigDecimal 计算总金额："+ b1.add(b2).add(b3));
        cxyhxx();
        xgyhxx();
    }


    /**
     * 常见金额存储数据库的方式
     */
    public void test2(){
        //todo 方式1 入库时使用 varchar 字符串类型，在代码中计算时将字符串转换为BigDecimal

        //todo 方式2 入库时使用 decimal 类型进行存储

        // todo 方式3 用 bigint 类型存储，将1元存储100分


    }


    /**
     * 查询用户信息
     * @return
     */
    public UserModel cxyhxx(){
        //todo 方式1 入库时使用 varchar 字符串类型，在代码中计算时将字符串转换为BigDecimal

        //todo 方式2 入库时使用 decimal 类型进行存储

        // todo 方式3 用 bigint 类型存储，将1元存储100分
        return null;
    }


    /**
     * 修改用户信息
     * @return
     */
    public int xgyhxx(){
        //todo 方式1 入库时使用 varchar 字符串类型，在代码中计算时将字符串转换为BigDecimal

        //todo 方式2 入库时使用 decimal 类型进行存储
        // todo 方式3 用 bigint 类型存储，将1元存储100分
        return 0;
    }




















}
