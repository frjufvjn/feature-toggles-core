package io.frjufvjn.featuretoggles;

import io.frjufvjn.featuretoggles.orchestration.FeatureOrchestration;
import io.frjufvjn.featuretoggles.router.FeatureToggles;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class AdvertServiceGate {
    private final Map<String, AdeverService> adeverServiceMap;
    private final FeatureToggles featureToggles;
    private static final String FEATURE = "advert";

    public AdvertServiceGate(Set<AdeverService> adeverServiceMap,
                             FeatureToggles featureToggles) {
        this.adeverServiceMap = FeatureOrchestration.compose(FEATURE, adeverServiceMap);
        this.featureToggles = featureToggles;
    }

    public String findAdvert() {
        return getActiveInstance().findAdvert();
    }

    private AdeverService getActiveInstance() {
        return featureToggles.getInstance(FEATURE, adeverServiceMap);
    }
}
