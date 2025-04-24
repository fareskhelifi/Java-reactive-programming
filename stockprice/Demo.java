package io.adad.stockprice;

import io.adad.common.Util;

public class Demo {
    public static void main(String[] args) {

        var client = new ExternalServiceClient();
        client.getPriceChanges().subscribe(new StockPriceObserver());


        Util.sleepSeconds(20000);
    }
}
