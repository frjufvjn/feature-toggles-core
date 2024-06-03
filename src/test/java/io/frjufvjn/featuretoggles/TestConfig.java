package io.frjufvjn.featuretoggles;

import io.frjufvjn.featuretoggles.router.FeatureCoreRouter;
import io.frjufvjn.featuretoggles.router.FeatureDataCoreProvider;
import io.frjufvjn.featuretoggles.router.FeatureDataFetcher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public FeatureDataCoreProvider featureDataResolver() {
        return new FeatureDataFetcher();
    }

    @Bean
    public FeatureCoreRouter featureCoreRouter() {
        return new FeatureCoreRouter(new FeatureDataFetcher());
    }
}
