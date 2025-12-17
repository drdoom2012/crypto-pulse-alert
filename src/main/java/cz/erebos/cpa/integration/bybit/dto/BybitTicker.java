package cz.erebos.cpa.integration.bybit.dto;

public class BybitTicker {

    private String symbol;
    private String bid1Price;
    private String ask1Price;
    private String lastPrice;
    private String price24hPcnt;
    private String highPrice24h;
    private String lowPrice24h;
    private String volume24h;

    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }

    public String getBid1Price() { return bid1Price; }
    public void setBid1Price(String bid1Price) { this.bid1Price = bid1Price; }

    public String getAsk1Price() { return ask1Price; }
    public void setAsk1Price(String ask1Price) { this.ask1Price = ask1Price; }

    public String getLastPrice() { return lastPrice; }
    public void setLastPrice(String lastPrice) { this.lastPrice = lastPrice; }

    public String getPrice24hPcnt() { return price24hPcnt; }
    public void setPrice24hPcnt(String price24hPcnt) { this.price24hPcnt = price24hPcnt; }

    public String getHighPrice24h() { return highPrice24h; }
    public void setHighPrice24h(String highPrice24h) { this.highPrice24h = highPrice24h; }

    public String getLowPrice24h() { return lowPrice24h; }
    public void setLowPrice24h(String lowPrice24h) { this.lowPrice24h = lowPrice24h; }

    public String getVolume24h() { return volume24h; }
    public void setVolume24h(String volume24h) { this.volume24h = volume24h; }

    public double getLastPriceAsDouble() {
        return Double.parseDouble(lastPrice);
    }
}