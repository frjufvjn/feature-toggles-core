package featuretoggles.core.orchestration;

// import org.springframework.aop.framework.AopProxyUtils;
import featuretoggles.core.FeatureOption;

public class ProxyBeanExtractor {
    public static FeatureOption getFeatureOptionIfProxyBean(Object proxy) {
        // return AopProxyUtils.ultimateTargetClass(proxy).getAnnotation(FeatureOption.class);
        return null;
    }
}
