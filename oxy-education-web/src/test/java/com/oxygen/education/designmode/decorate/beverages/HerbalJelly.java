package com.oxygen.education.designmode.decorate.beverages;

import java.math.BigDecimal;

/**
 * 烧仙草
 */
public class HerbalJelly implements MilkTea{
    @Override
    public String getDescription() {
        return "烧仙草";
    }

    @Override
    public BigDecimal cost() {
        return new BigDecimal(7.0);
    }
}
