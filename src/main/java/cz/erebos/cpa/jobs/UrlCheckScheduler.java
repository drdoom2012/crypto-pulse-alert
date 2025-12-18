package cz.erebos.cpa.jobs;

import cz.erebos.cpa.config.CryptoProperties;
import cz.erebos.cpa.integration.bybit.BybitPriceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ExecutorService;

@Component
public class UrlCheckScheduler {

    private static final Logger log = LoggerFactory.getLogger(UrlCheckScheduler.class);

    private final BybitPriceService bybitPriceService;
    private final CryptoProperties props;
    private final ExecutorService executor;

    public UrlCheckScheduler(BybitPriceService bybitPriceService,
                             CryptoProperties props,
                             ExecutorService urlCheckExecutor) {
        this.bybitPriceService = bybitPriceService;
        this.props = props;
        this.executor = urlCheckExecutor;
    }

    @Scheduled(fixedDelayString = "${crypto.check.interval-ms:10000}")
    public void run() {
        List<CryptoProperties.Asset> assets = props.getCheck().getAssets();
        if (assets == null || assets.isEmpty()) {
            log.info("🟡 No asset configured for checking");
            return;
        }

        for (final CryptoProperties.Asset asset : assets) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    bybitPriceService.loadPrice(asset.getSymbol(), asset.getUrl());
                }
            });
        }
    }
}