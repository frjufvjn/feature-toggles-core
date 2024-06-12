package com.github.frjufvjn.featuretoggles.advert;

import com.github.frjufvjn.featuretoggles.FeatureOption;
import org.springframework.stereotype.Service;

@FeatureOption(name = "release")
@Service
public class AdvertServiceReleaseImpl implements AdeverService {
    @Override
    public String findAdvert() {
        return "release";
    }
}