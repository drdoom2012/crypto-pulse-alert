package cz.erebos.cpa.core.history;

public final class PriceSample {

    private final long timestampMs;
    private final double price;

    public PriceSample(long timestampMs, double price) {
        this.timestampMs = timestampMs;
        this.price = price;
    }

    public long getTimestampMs() {
        return timestampMs;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "PriceSample{" +
                "timestampMs=" + timestampMs +
                ", price=" + price +
                '}';
    }
}