package cz.erebos.cpa.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(UrlCheckProperties.class)
public class PropsConfig {}