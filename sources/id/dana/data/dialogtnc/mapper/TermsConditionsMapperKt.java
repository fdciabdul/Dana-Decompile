package id.dana.data.dialogtnc.mapper;

import id.dana.data.config.source.amcs.result.TermsConditionsResult;
import id.dana.domain.tncsummary.model.TermsConditionsResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/source/amcs/result/TermsConditionsResult;", "Lid/dana/domain/tncsummary/model/TermsConditionsResponse;", "toTermsConditionsResponse", "(Lid/dana/data/config/source/amcs/result/TermsConditionsResult;)Lid/dana/domain/tncsummary/model/TermsConditionsResponse;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TermsConditionsMapperKt {
    public static final TermsConditionsResponse toTermsConditionsResponse(TermsConditionsResult termsConditionsResult) {
        Intrinsics.checkNotNullParameter(termsConditionsResult, "");
        boolean isEnable = termsConditionsResult.isEnable();
        return new TermsConditionsResponse(Boolean.valueOf(isEnable), termsConditionsResult.getSpaceCode());
    }
}
