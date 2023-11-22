package id.dana.data.paylater.repository.mapper;

import id.dana.data.paylater.repository.source.network.result.PaylaterCicilMethodConfigResult;
import id.dana.domain.paylater.model.PaylaterCicilMethodConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/paylater/repository/source/network/result/PaylaterCicilMethodConfigResult;", "Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;", "toPaylaterMethodConfig", "(Lid/dana/data/paylater/repository/source/network/result/PaylaterCicilMethodConfigResult;)Lid/dana/domain/paylater/model/PaylaterCicilMethodConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterCicilMethodConfigResultMapperKt {
    public static final PaylaterCicilMethodConfig toPaylaterMethodConfig(PaylaterCicilMethodConfigResult paylaterCicilMethodConfigResult) {
        Intrinsics.checkNotNullParameter(paylaterCicilMethodConfigResult, "");
        String paymethodName = paylaterCicilMethodConfigResult.getPaymethodName();
        String str = paymethodName == null ? "" : paymethodName;
        String paymethodDescription = paylaterCicilMethodConfigResult.getPaymethodDescription();
        String str2 = paymethodDescription == null ? "" : paymethodDescription;
        String onboardingSpaceCode = paylaterCicilMethodConfigResult.getOnboardingSpaceCode();
        String str3 = onboardingSpaceCode == null ? "" : onboardingSpaceCode;
        List<String> tncSpaceCode = paylaterCicilMethodConfigResult.getTncSpaceCode();
        if (tncSpaceCode == null) {
            tncSpaceCode = CollectionsKt.emptyList();
        }
        List<String> list = tncSpaceCode;
        String mid = paylaterCicilMethodConfigResult.getMid();
        String str4 = mid == null ? "" : mid;
        Integer cacheTime = paylaterCicilMethodConfigResult.getCacheTime();
        int intValue = cacheTime != null ? cacheTime.intValue() : 0;
        Integer thresholdDue = paylaterCicilMethodConfigResult.getThresholdDue();
        int intValue2 = thresholdDue != null ? thresholdDue.intValue() : 0;
        String onBoardingImageUrl = paylaterCicilMethodConfigResult.getOnBoardingImageUrl();
        String str5 = onBoardingImageUrl == null ? "" : onBoardingImageUrl;
        String promoRibbonDesc = paylaterCicilMethodConfigResult.getPromoRibbonDesc();
        String str6 = promoRibbonDesc == null ? "" : promoRibbonDesc;
        String promoRibbonSelectedDesc = paylaterCicilMethodConfigResult.getPromoRibbonSelectedDesc();
        String str7 = promoRibbonSelectedDesc == null ? "" : promoRibbonSelectedDesc;
        String payMethodUnregistDesc = paylaterCicilMethodConfigResult.getPayMethodUnregistDesc();
        String str8 = payMethodUnregistDesc == null ? "" : payMethodUnregistDesc;
        Integer maxCountShowRegistration = paylaterCicilMethodConfigResult.getMaxCountShowRegistration();
        int intValue3 = maxCountShowRegistration != null ? maxCountShowRegistration.intValue() : 0;
        Integer delayShowRegistration = paylaterCicilMethodConfigResult.getDelayShowRegistration();
        return new PaylaterCicilMethodConfig(str, str2, str3, list, str4, intValue, intValue2, str5, str6, str7, str8, intValue3, delayShowRegistration != null ? delayShowRegistration.intValue() : 0);
    }
}
