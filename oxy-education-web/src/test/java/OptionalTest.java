import lombok.Data;
import org.junit.Test;

import java.util.Optional;

public class OptionalTest {

    @Test
    public void test1() {
        Order order = initOrder(false);
        String goodsName = order.getOrderItem().getGoods().getGoodsName();
        System.out.println(goodsName);
    }

    /**
     * 空指针判断
     */
    @Test
    public void test2() {
        Order order = initOrder(true);
        String goodsName = null;
        if(order != null
                && order.getOrderItem() != null
                && order.getOrderItem().getGoods() != null){

            goodsName = order.getOrderItem().getGoods().getGoodsName();
        }
        System.out.println(goodsName);
    }



    /**
     * Optional 获取商品名称 为空则赋默认值
     */
    @Test
    public void test3() {
        Order order = initOrder(false);
        String goodsName = Optional.ofNullable(order)
                .map(Order::getOrderItem)
                .map(OrderItem::getGoods)
                .map(Goods::getGoodsName)
                .orElse("无商品");

        System.out.println(goodsName);
    }


    /**
     * Optional 获取商品名称 为空则抛出异常
     */
    @Test
    public void test4() {
        Order order = initOrder(false);
        String goodsName = Optional.ofNullable(order)
                .map(Order::getOrderItem)
                .map(OrderItem::getGoods)
                .map(Goods::getGoodsName)
                .orElseThrow(() -> new RuntimeException("商品数据为空"));
        System.out.println(goodsName);
    }









    public Order initOrder(Boolean isNull){
        Order order = new Order();
        order.setOrderNo("4444444");
        order.setOrderItem(initOrderItem(isNull));
        return order;
    }

    public OrderItem initOrderItem(Boolean isNull){
        OrderItem orderItem = new OrderItem();
        orderItem.setOrderItemId(11L);
        orderItem.setGoods(initGoods(isNull));
        return orderItem;
    }

    public Goods initGoods(Boolean isNull){
        if(isNull){
            return null;
        }
        Goods goods = new Goods();
        goods.setGoodsName("深入JVM");
        goods.setGoodsId(66L);
        return goods;
    }

}


@Data
class Order {
    private String orderNo;

    private OrderItem orderItem;
}

@Data
class OrderItem {
    private Long orderItemId;
    private Goods goods;

}

@Data
class Goods {
    private Long goodsId;
    private String goodsName;
}