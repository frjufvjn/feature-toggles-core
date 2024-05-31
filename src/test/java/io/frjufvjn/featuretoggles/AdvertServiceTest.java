package io.frjufvjn.featuretoggles;

import io.frjufvjn.featuretoggles.advert.AdvertServiceGate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = TestMain.class)
public class AdvertServiceTest {
    @Autowired
    private AdvertServiceGate advertServiceGate;

    /**
     * {@link io.frjufvjn.featuretoggles.router.FeatureDataResolver} 에 'release' 토글을 반환하는 시나리오가 있다.
     */
    @DisplayName("feature 데이터에 토글이 'release'로 설정이 되어 잇다면")
    @Test
    void releaseToggleTest() {
        String result = advertServiceGate.findAdvert();
        assertThat(result).isEqualTo("release");
    }
}
