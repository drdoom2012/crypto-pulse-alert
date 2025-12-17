package cz.erebos.cpa.jobs;

import cz.erebos.cpa.integration.bybit.BybitPriceService;
import cz.erebos.cpa.config.UrlCheckProperties;
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
    private final UrlCheckProperties props;
    private final ExecutorService executor;

    public UrlCheckScheduler(BybitPriceService bybitPriceService,
                             UrlCheckProperties props,
                             ExecutorService urlCheckExecutor) {
        this.bybitPriceService = bybitPriceService;
        this.props = props;
        this.executor = urlCheckExecutor;
    }

    @Scheduled(fixedDelayString = "${crypto.check.interval-ms:10000}")
    public void run() {
        List<String> urls = props.getUrls();
        if (urls == null || urls.isEmpty()) {
            log.info("🟡 No URLs configured for checking");
            return;
        }

        for (final String url : urls) {
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    bybitPriceService.loadPrice(url);
                }
            });
        }
    }
}