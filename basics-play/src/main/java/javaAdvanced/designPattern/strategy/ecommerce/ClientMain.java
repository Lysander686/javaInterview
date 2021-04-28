package javaAdvanced.designPattern.strategy.ecommerce;

public class ClientMain {

    public static void main(String[] args) {
        //选择并创建需要使用的策略对象
        MemberStrategy strategy = new AdvancedMemberStrategy();
        //创建环境
        PriceCalculation c = new PriceCalculation(strategy);
        //计算价格
        double actualPrice = c.quote(300);
        System.out.println("图书的最终价格为：" + actualPrice);
    }

}