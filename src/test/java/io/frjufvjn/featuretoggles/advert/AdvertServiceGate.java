package io.frjufvjn.featuretoggles.advert;

import io.frjufvjn.featuretoggles.orchestration.FeatureOrchestration;
import io.frjufvjn.featuretoggles.router.FeatureCoreRouter;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class AdvertServiceGate {
    private final Map<String, AdeverService> adeverServiceMap;
    private final FeatureCoreRouter featureCoreRouter;
    private static final String FEATURE = "advert";

    public AdvertServiceGate(Set<AdeverService> adeverServiceMap, FeatureCoreRouter featureCoreRouter) {
        this.adeverServiceMap = FeatureOrchestration.compose(FEATURE, adeverServiceMap);
        this.featureCoreRouter = featureCoreRouter;
    }

    public String findAdvert() {
        return getActiveInstance().findAdvert();
    }

    private AdeverService getActiveInstance() {
        return featureCoreRouter.getInstance(FEATURE, adeverServiceMap);
    }
}
