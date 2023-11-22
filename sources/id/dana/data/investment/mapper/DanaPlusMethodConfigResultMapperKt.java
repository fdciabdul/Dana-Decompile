package id.dana.data.investment.mapper;

import id.dana.data.investment.repository.source.split.response.DanaPlusMethodConfigResult;
import id.dana.domain.investment.model.DanaPlusMethodConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/investment/repository/source/split/response/DanaPlusMethodConfigResult;", "Lid/dana/domain/investment/model/DanaPlusMethodConfig;", "getAuthRequestContext", "(Lid/dana/data/investment/repository/source/split/response/DanaPlusMethodConfigResult;)Lid/dana/domain/investment/model/DanaPlusMethodConfig;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaPlusMethodConfigResultMapperKt {
    public static final DanaPlusMethodConfig getAuthRequestContext(DanaPlusMethodConfigResult danaPlusMethodConfigResult) {
        Intrinsics.checkNotNullParameter(danaPlusMethodConfigResult, "");
        String str = danaPlusMethodConfigResult.getAuthRequestContext;
        if (str == null) {
            str = "";
        }
        String str2 = danaPlusMethodConfigResult.MyBillsEntityDataFactory;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = danaPlusMethodConfigResult.BuiltInFictitiousFunctionClassFactory;
        return new DanaPlusMethodConfig(str, str2, str3 != null ? str3 : "");
    }
}
