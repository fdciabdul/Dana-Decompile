package id.dana.promocode.utils;

import android.app.Activity;
import id.dana.R;
import id.dana.promocode.views.PromoCodeBottomSheet;
import id.dana.riskChallenges.constant.RiskChallengeValue;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\f\u0010\bJ)\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\rJ\u0017\u0010\u0007\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u0011"}, d2 = {"Lid/dana/promocode/utils/PromoCodeUtil;", "", "Landroid/app/Activity;", "p0", "", "p1", "Lid/dana/promocode/views/PromoCodeBottomSheet;", "MyBillsEntityDataFactory", "(Landroid/app/Activity;Ljava/lang/String;)Lid/dana/promocode/views/PromoCodeBottomSheet;", "p2", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Lid/dana/promocode/views/PromoCodeBottomSheet;", "getAuthRequestContext", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "(Ljava/lang/String;)I", "PlaceComponentResult", "(Landroid/app/Activity;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoCodeUtil {
    public static final PromoCodeUtil INSTANCE = new PromoCodeUtil();

    private PromoCodeUtil() {
    }

    @JvmStatic
    public static final PromoCodeBottomSheet getAuthRequestContext(Activity p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(p0, "CODE_SUCCESS", p1);
    }

    @JvmStatic
    public static final PromoCodeBottomSheet MyBillsEntityDataFactory(Activity p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        return KClassImpl$Data$declaredNonStaticMembers$2(p0, p1, null);
    }

    private static int MyBillsEntityDataFactory(String p0) {
        String upperCase = p0.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        switch (upperCase.hashCode()) {
            case -1452302473:
                if (upperCase.equals("LIMIT_EXCEEDED")) {
                    return R.drawable.img_promocode_claimed;
                }
                break;
            case -1049996093:
                if (upperCase.equals("QUOTA_NOT_ENOUGH")) {
                    return R.drawable.img_promocode_out_of_time;
                }
                break;
            case -915868802:
                if (upperCase.equals("CODE_NOT_VALID")) {
                    return R.drawable.img_promocode_code_invalid;
                }
                break;
            case 212273935:
                if (upperCase.equals(RiskChallengeValue.RISK_REJECT)) {
                    return R.drawable.img_promocode_risk_reject;
                }
                break;
            case 404085649:
                if (upperCase.equals("CODE_SUCCESS")) {
                    return R.drawable.img_promo_code_success;
                }
                break;
            case 962020019:
                if (upperCase.equals("CODE_EXPIRED")) {
                    return R.drawable.img_promocode_code_expired;
                }
                break;
        }
        return R.drawable.img_promo_code_general_error;
    }

    private static String KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, String p1) {
        String upperCase = p1.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        switch (upperCase.hashCode()) {
            case -1452302473:
                if (upperCase.equals("LIMIT_EXCEEDED")) {
                    String string = p0.getString(R.string.promocode_bottomsheet_claimed_title);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    return string;
                }
                break;
            case -1049996093:
                if (upperCase.equals("QUOTA_NOT_ENOUGH")) {
                    String string2 = p0.getString(R.string.promocode_bottomsheet_quota_not_enough_title);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    return string2;
                }
                break;
            case -915868802:
                if (upperCase.equals("CODE_NOT_VALID")) {
                    String string3 = p0.getString(R.string.promocode_bottomsheet_invalid_title);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    return string3;
                }
                break;
            case 212273935:
                if (upperCase.equals(RiskChallengeValue.RISK_REJECT)) {
                    String string4 = p0.getString(R.string.promocode_bottomsheet_risk_reject_title);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    return string4;
                }
                break;
            case 404085649:
                if (upperCase.equals("CODE_SUCCESS")) {
                    String string5 = p0.getString(R.string.promocode_bottomsheet_success_title);
                    Intrinsics.checkNotNullExpressionValue(string5, "");
                    return string5;
                }
                break;
            case 962020019:
                if (upperCase.equals("CODE_EXPIRED")) {
                    String string6 = p0.getString(R.string.promocode_bottomsheet_expired_title);
                    Intrinsics.checkNotNullExpressionValue(string6, "");
                    return string6;
                }
                break;
        }
        String string7 = p0.getString(R.string.promocode_bottomsheet_general_error_title);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        return string7;
    }

    private static String MyBillsEntityDataFactory(Activity p0, String p1, String p2) {
        String upperCase = p1.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        switch (upperCase.hashCode()) {
            case -1452302473:
                if (upperCase.equals("LIMIT_EXCEEDED")) {
                    String string = p0.getString(R.string.promocode_bottomsheet_claimed_desc);
                    Intrinsics.checkNotNullExpressionValue(string, "");
                    return string;
                }
                break;
            case -1049996093:
                if (upperCase.equals("QUOTA_NOT_ENOUGH")) {
                    String string2 = p0.getString(R.string.promocode_bottomsheet_quota_not_enough_desc);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    return string2;
                }
                break;
            case -915868802:
                if (upperCase.equals("CODE_NOT_VALID")) {
                    String string3 = p0.getString(R.string.promocode_bottomsheet_invalid_desc);
                    Intrinsics.checkNotNullExpressionValue(string3, "");
                    return string3;
                }
                break;
            case 212273935:
                if (upperCase.equals(RiskChallengeValue.RISK_REJECT)) {
                    String string4 = p0.getString(R.string.promocode_bottomsheet_risk_reject_desc);
                    Intrinsics.checkNotNullExpressionValue(string4, "");
                    return string4;
                }
                break;
            case 404085649:
                if (upperCase.equals("CODE_SUCCESS")) {
                    String string5 = p0.getString(R.string.promocode_bottomsheet_success_desc, p2);
                    Intrinsics.checkNotNullExpressionValue(string5, "");
                    return string5;
                }
                break;
            case 962020019:
                if (upperCase.equals("CODE_EXPIRED")) {
                    String string6 = p0.getString(R.string.promocode_bottomsheet_expired_desc);
                    Intrinsics.checkNotNullExpressionValue(string6, "");
                    return string6;
                }
                break;
        }
        String string7 = p0.getString(R.string.promocode_bottomsheet_general_error_desc);
        Intrinsics.checkNotNullExpressionValue(string7, "");
        return string7;
    }

    private static String PlaceComponentResult(Activity p0, String p1) {
        String upperCase = p1.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        if (Intrinsics.areEqual(upperCase, "CODE_SUCCESS")) {
            String string = p0.getString(R.string.promocode_bottomsheet_success_positive_button);
            Intrinsics.checkNotNullExpressionValue(string, "");
            return string;
        }
        String string2 = p0.getString(R.string.promocode_try_again);
        Intrinsics.checkNotNullExpressionValue(string2, "");
        return string2;
    }

    private static PromoCodeBottomSheet KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, String p1, String p2) {
        String str = Intrinsics.areEqual(p1, "CODE_SUCCESS") ? "CODE_SUCCESS" : new PromoCodeErrorMapStrategy().getAuthRequestContext(p1).PlaceComponentResult;
        PromoCodeBottomSheet.Companion companion = PromoCodeBottomSheet.INSTANCE;
        int MyBillsEntityDataFactory = MyBillsEntityDataFactory(str);
        String KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(p0, str);
        String MyBillsEntityDataFactory2 = MyBillsEntityDataFactory(p0, str, p2);
        String PlaceComponentResult = PlaceComponentResult(p0, str);
        Intrinsics.checkNotNullParameter(KClassImpl$Data$declaredNonStaticMembers$2, "");
        Intrinsics.checkNotNullParameter(MyBillsEntityDataFactory2, "");
        Intrinsics.checkNotNullParameter(PlaceComponentResult, "");
        return PromoCodeBottomSheet.Companion.getAuthRequestContext(MyBillsEntityDataFactory, KClassImpl$Data$declaredNonStaticMembers$2, MyBillsEntityDataFactory2, PlaceComponentResult);
    }
}
