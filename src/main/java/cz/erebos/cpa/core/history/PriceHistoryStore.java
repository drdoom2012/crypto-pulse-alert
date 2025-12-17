package cz.erebos.cpa.core.history;

import cz.erebos.cpa.config.HistoryProps;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class PriceHistoryStore {

    private final Map<String, BoundedFifo<PriceSample>> history = new ConcurrentHashMap<>();
    private final int capacity;

    public PriceHistoryStore(HistoryProps props) {
        this.capacity = props.getCapacity();
    }

    public void addPrice(String key, double price) {
        BoundedFifo<PriceSample> fifo = history.computeIfAbsent(key, k -> new BoundedFifo<>(capacity));
        fifo.add(new PriceSample(System.currentTimeMillis(), price));
    }

    public BoundedFifo<PriceSample> getHistory(String key) {
        return history.get(key);
    }
}
