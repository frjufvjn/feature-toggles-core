package io.frjufvjn.featuretoggles;

import io.frjufvjn.featuretoggles.router.FeatureCoreRouter;
import io.frjufvjn.featuretoggles.router.FeatureDataResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {
    @Bean
    public FeatureDataResolver featureDataResolver() {
        return new FeatureDataResolver();
    }

    @Bean
    public FeatureCoreRouter featureCoreRouter(FeatureDataResolver featureDataResolver) {
        return new FeatureCoreRouter(featureDataResolver);
    }
}
