package com.github.frjufvjn.featuretoggles.advert;

import com.github.frjufvjn.featuretoggles.FeatureOption;
import org.springframework.stereotype.Service;

@FeatureOption(defaultFeature = true)
@Service
public class AdevertServiceDefaultImpl implements AdeverService {
    @Override
    public String findAdvert() {
        return "default";
    }
}
