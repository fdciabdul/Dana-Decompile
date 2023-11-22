package id.dana.myprofile.mapper;

import android.content.Context;
import id.dana.R;
import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.utils.ResourceUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001a)\u0010\n\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Landroid/content/Context;", "p0", "Lid/dana/domain/profilemenu/model/SettingModel;", "p1", "", "getAuthRequestContext", "(Landroid/content/Context;Lid/dana/domain/profilemenu/model/SettingModel;)Ljava/lang/String;", "Lid/dana/investment/model/UserInvestmentModel;", "Lid/dana/domain/investment/model/UserInvestmentInfo;", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/investment/model/UserInvestmentModel;Landroid/content/Context;Lid/dana/domain/investment/model/UserInvestmentInfo;Lid/dana/domain/profilemenu/model/SettingModel;)Lid/dana/domain/profilemenu/model/SettingModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaPlusSummaryMapperKt {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] getAuthRequestContext;

        static {
            int[] iArr = new int[AccountInvestmentStatus.values().length];
            iArr[AccountInvestmentStatus.ACTIVE.ordinal()] = 1;
            getAuthRequestContext = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
    
        if (r2 == null) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final id.dana.domain.profilemenu.model.SettingModel KClassImpl$Data$declaredNonStaticMembers$2(id.dana.investment.model.UserInvestmentModel r6, android.content.Context r7, id.dana.domain.investment.model.UserInvestmentInfo r8, id.dana.domain.profilemenu.model.SettingModel r9) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.myprofile.mapper.DanaPlusSummaryMapperKt.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.investment.model.UserInvestmentModel, android.content.Context, id.dana.domain.investment.model.UserInvestmentInfo, id.dana.domain.profilemenu.model.SettingModel):id.dana.domain.profilemenu.model.SettingModel");
    }

    private static final String getAuthRequestContext(Context context, SettingModel settingModel) {
        String PlaceComponentResult;
        String title = settingModel.getTitle();
        if (title == null || title.length() == 0) {
            PlaceComponentResult = context.getResources().getString(R.string.dana_plus);
        } else {
            String title2 = settingModel.getTitle();
            Intrinsics.checkNotNullExpressionValue(title2, "");
            String lowerCase = title2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            PlaceComponentResult = ResourceUtils.PlaceComponentResult(context, lowerCase, title2);
        }
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }
}
