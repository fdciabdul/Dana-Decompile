package id.dana.data.danaprotection.mapper;

import id.dana.data.danaprotection.repository.source.network.result.DanaProtectionInfoResult;
import id.dana.domain.danaprotection.model.DanaProtectionInfoModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;", "Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;", "PlaceComponentResult", "(Lid/dana/data/danaprotection/repository/source/network/result/DanaProtectionInfoResult;)Lid/dana/domain/danaprotection/model/DanaProtectionInfoModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanaProtectionInfoMapperKt {
    public static final DanaProtectionInfoModel PlaceComponentResult(DanaProtectionInfoResult danaProtectionInfoResult) {
        Intrinsics.checkNotNullParameter(danaProtectionInfoResult, "");
        Integer protectedActivity = danaProtectionInfoResult.getProtectedActivity();
        int intValue = protectedActivity != null ? protectedActivity.intValue() : 0;
        Integer suspiciousActivity = danaProtectionInfoResult.getSuspiciousActivity();
        int intValue2 = suspiciousActivity != null ? suspiciousActivity.intValue() : 0;
        Integer timeRange = danaProtectionInfoResult.getTimeRange();
        return new DanaProtectionInfoModel(intValue, intValue2, timeRange != null ? timeRange.intValue() : 0);
    }
}
