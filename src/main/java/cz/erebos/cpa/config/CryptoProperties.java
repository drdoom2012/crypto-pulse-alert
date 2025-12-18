package cz.erebos.cpa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@ConfigurationProperties(prefix = "crypto")
public class CryptoProperties {

    private History history = new History();
    private Check check = new Check();

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    // ---- history ----
    public static class History {
        private int capacity = 600;

        public int getCapacity() {
            return capacity;
        }

        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }
    }

    // ---- check ----
    public static class Check {
        private long intervalMs = 10_000;
        private List<Asset> assets;

        public long getIntervalMs() {
            return intervalMs;
        }

        public void setIntervalMs(long intervalMs) {
            this.intervalMs = intervalMs;
        }

        public List<Asset> getAssets() {
            return assets;
        }

        public void setAssets(List<Asset> assets) {
            this.assets = assets;
        }
    }

    // ---- asset ----
    public static class Asset {
        private String symbol;
        private String url;

        public String getSymbol() {
            return symbol;
        }

        public void setSymbol(String symbol) {
            this.symbol = symbol;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}