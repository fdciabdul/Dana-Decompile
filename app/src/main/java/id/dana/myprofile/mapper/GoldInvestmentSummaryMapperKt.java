package id.dana.myprofile.mapper;

import android.content.Context;
import id.dana.R;
import id.dana.domain.investment.AccountInvestmentStatus;
import id.dana.domain.profilemenu.model.SettingModel;
import id.dana.investment.model.MultiCurrencyMoneyViewModel;
import id.dana.investment.model.UserInvestmentModel;
import id.dana.utils.LocaleUtil;
import id.dana.utils.NumberFormatterUtil;
import id.dana.utils.ResourceUtils;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a!\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/investment/model/UserInvestmentModel;", "Landroid/content/Context;", "p0", "Lid/dana/domain/profilemenu/model/SettingModel;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/investment/model/UserInvestmentModel;Landroid/content/Context;Lid/dana/domain/profilemenu/model/SettingModel;)Lid/dana/domain/profilemenu/model/SettingModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GoldInvestmentSummaryMapperKt {
    public static final SettingModel KClassImpl$Data$declaredNonStaticMembers$2(UserInvestmentModel userInvestmentModel, Context context, SettingModel settingModel) {
        Intrinsics.checkNotNullParameter(userInvestmentModel, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(settingModel, "");
        settingModel.setViewType(7);
        String string = context.getString(R.string.emas_title);
        Intrinsics.checkNotNullExpressionValue(string, "");
        String title = settingModel.getTitle();
        if (!(title == null || StringsKt.isBlank(title))) {
            String title2 = settingModel.getTitle();
            Intrinsics.checkNotNullExpressionValue(title2, "");
            String lowerCase = title2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "");
            settingModel.setTitle(ResourceUtils.PlaceComponentResult(context, lowerCase, settingModel.getTitle()));
        } else {
            settingModel.setTitle(string);
        }
        String string2 = context.getString(R.string.emas_subtitle);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        String subtitle = settingModel.getSubtitle();
        if (!(subtitle == null || StringsKt.isBlank(subtitle))) {
            String subtitle2 = settingModel.getSubtitle();
            Intrinsics.checkNotNullExpressionValue(subtitle2, "");
            String lowerCase2 = subtitle2.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "");
            settingModel.setSubtitle(ResourceUtils.PlaceComponentResult(context, lowerCase2, settingModel.getSubtitle()));
        } else {
            settingModel.setSubtitle(string2);
        }
        if (!userInvestmentModel.getAuthRequestContext() && AccountInvestmentStatus.ACTIVE == userInvestmentModel.PlaceComponentResult) {
            MultiCurrencyMoneyViewModel multiCurrencyMoneyViewModel = userInvestmentModel.MyBillsEntityDataFactory;
            if (multiCurrencyMoneyViewModel != null) {
                Long l = multiCurrencyMoneyViewModel.BuiltInFictitiousFunctionClassFactory;
                String str = null;
                if (l != null) {
                    if (!(((int) l.longValue()) != 0)) {
                        l = null;
                    }
                    if (l != null) {
                        str = NumberFormatterUtil.BuiltInFictitiousFunctionClassFactory(LocaleUtil.getAuthRequestContext(), l.longValue(), multiCurrencyMoneyViewModel.KClassImpl$Data$declaredNonStaticMembers$2);
                    }
                }
                if (str == null) {
                    str = string2;
                }
                if (str != null) {
                    string2 = str;
                }
            }
            settingModel.setSubtitle(string2);
        }
        return settingModel;
    }
}
