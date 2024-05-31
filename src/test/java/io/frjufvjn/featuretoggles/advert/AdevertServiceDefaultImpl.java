package io.frjufvjn.featuretoggles.advert;

import io.frjufvjn.featuretoggles.FeatureOption;
import org.springframework.stereotype.Service;

@FeatureOption(defaultFeature = true)
@Service
public class AdevertServiceDefaultImpl implements AdeverService {
    @Override
    public String findAdvert() {
        return "default";
    }
}
