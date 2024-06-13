package featuretoggles.core.orchestration;

import featuretoggles.core.FeatureOption;

public interface ProxyBeanFeatureOptionExtractor {
    FeatureOption getFeatureOption(Object proxy);
}
