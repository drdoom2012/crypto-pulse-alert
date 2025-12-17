package cz.erebos.cpa.integration.bybit;

import cz.erebos.cpa.integration.bybit.dto.BybitTicker;
import cz.erebos.cpa.integration.bybit.dto.BybitTickerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

@Service
public class BybitPriceService {

    private static final Logger log = LoggerFactory.getLogger(BybitPriceService.class);

    private final RestTemplate restTemplate;

    public BybitPriceService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public double loadPrice(String url) {
        try {
            ResponseEntity<BybitTickerResponse> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            BybitTickerResponse.class
                    );

            BybitTickerResponse body = response.getBody();

            if (body == null || body.getResult() == null || body.getResult().getList().isEmpty()) {
                throw new IllegalStateException("Invalid Bybit response");
            }

            BybitTicker ticker = body.getResult().getList().get(0);
            double price = ticker.getLastPriceAsDouble();

            log.info("{} -> price {}", url, price);
            return price;

        } catch (RestClientResponseException e) {
            log.warn(
                    "🔴 {} -> HTTP {} {}",
                    url,
                    e.getStatusCode(),
                    e.getStatusText()
            );
            throw e;

        } catch (RestClientException e) {
            log.warn(
                    "🔴 {} -> CLIENT ERROR: {}",
                    url,
                    e.getMessage()
            );
            throw e;
        }
    }
}