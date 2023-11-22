package id.dana.myprofile.mapper;

import id.dana.savings.model.SavingSummaryModel;
import id.dana.utils.BalanceUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/myprofile/mapper/SavingSummarySettingMapper;", "", "Lid/dana/savings/model/SavingSummaryModel;", "p0", "", "p1", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/savings/model/SavingSummaryModel;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SavingSummarySettingMapper {
    public static final SavingSummarySettingMapper INSTANCE = new SavingSummarySettingMapper();

    private SavingSummarySettingMapper() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(SavingSummaryModel p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (p0.scheduleImpl.isEmpty() || p0.moveToNextValue.PlaceComponentResult(1L)) {
            return p1;
        }
        String KClassImpl$Data$declaredNonStaticMembers$2 = BalanceUtil.KClassImpl$Data$declaredNonStaticMembers$2(p0.moveToNextValue.PlaceComponentResult);
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
