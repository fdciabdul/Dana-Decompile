package id.dana.data.paylater.mapper;

import id.dana.data.config.model.PaylaterAgreementConfigResult;
import id.dana.domain.paylater.model.PaylaterAgreementConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/config/model/PaylaterAgreementConfigResult;", "Lid/dana/domain/paylater/model/PaylaterAgreementConfig;", "toPaylaterAgreementConfig", "(Lid/dana/data/config/model/PaylaterAgreementConfigResult;)Lid/dana/domain/paylater/model/PaylaterAgreementConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterAgreementConfigResultMapperKt {
    public static final PaylaterAgreementConfig toPaylaterAgreementConfig(PaylaterAgreementConfigResult paylaterAgreementConfigResult) {
        Intrinsics.checkNotNullParameter(paylaterAgreementConfigResult, "");
        Boolean enable = paylaterAgreementConfigResult.getEnable();
        boolean booleanValue = enable != null ? enable.booleanValue() : false;
        List<String> spaceCodes = paylaterAgreementConfigResult.getSpaceCodes();
        if (spaceCodes == null) {
            spaceCodes = CollectionsKt.emptyList();
        }
        return new PaylaterAgreementConfig(booleanValue, spaceCodes);
    }
}
