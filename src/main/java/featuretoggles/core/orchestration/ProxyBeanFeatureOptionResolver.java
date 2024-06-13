package featuretoggles.core.orchestration;

import featuretoggles.core.FeatureOption;

public class ProxyBeanFeatureOptionResolver {
    private static ProxyBeanFeatureOptionExtractor extractor;

    public ProxyBeanFeatureOptionResolver(ProxyBeanFeatureOptionExtractor proxyBeanFeatureOptionExtractor) {
        ProxyBeanFeatureOptionResolver.extractor = proxyBeanFeatureOptionExtractor;
    }

    public static void setFeatureOptionExtractor(ProxyBeanFeatureOptionExtractor proxyBeanFeatureOptionExtractor) {
        extractor = proxyBeanFeatureOptionExtractor;
    }

    public static FeatureOption getFeatureOptionIfProxyBean(Object proxy) {
        if (extractor != null) {
            return extractor.getFeatureOption(proxy);
        }
        return null;
    }
}
