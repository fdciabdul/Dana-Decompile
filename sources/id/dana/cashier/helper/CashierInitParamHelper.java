package id.dana.cashier.helper;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.cashier.domain.model.CheckoutExternalInfo;
import id.dana.cashier.model.CashierCheckoutRequestModel;
import id.dana.cashier.model.CashierMerchantModel;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.domain.deeplink.ParamConstantsKt;
import id.dana.domain.qrbarcode.DecodeQrBizType;
import id.dana.domain.qrbarcode.DecodedScan;
import id.dana.sendmoney.summary.SummaryActivity;
import id.dana.utils.UrlUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\"\u0010#J!\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJO\u0010\u0005\u001a\u00020\u00152\"\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u000fj\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002`\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0005\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u0019\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0019\u0010\u000bJ\u0017\u0010\u001a\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\u00132\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u001e\u0010\u001bJ\u0011\u0010\u001f\u001a\u00020\u0013*\u00020\u0002¢\u0006\u0004\b\u001f\u0010\u001bJ\u0011\u0010 \u001a\u00020\u0013*\u00020\u0002¢\u0006\u0004\b \u0010\u001bJ\u0011\u0010!\u001a\u00020\u0013*\u00020\u0002¢\u0006\u0004\b!\u0010\u001b"}, d2 = {"Lid/dana/cashier/helper/CashierInitParamHelper;", "", "", "p0", "Lkotlin/Pair;", "PlaceComponentResult", "(Ljava/lang/String;)Lkotlin/Pair;", "Lid/dana/cashier/model/CashierCheckoutRequestModel;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/cashier/model/CashierCheckoutRequestModel;", "getAuthRequestContext", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/domain/qrbarcode/DecodedScan;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)Lid/dana/domain/qrbarcode/DecodedScan;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "p1", "p2", "", "p3", "Lid/dana/cashier/model/CashierMerchantModel;", "(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/model/CashierMerchantModel;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Lid/dana/cashier/model/CashierMerchantModel;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "(Ljava/lang/String;)Z", "lookAheadTest", "initRecordTimeStamp", "GetContactSyncConfig", "getErrorConfigVersion", "scheduleImpl", "NetworkUserEntityData$$ExternalSyntheticLambda2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierInitParamHelper {
    public static final CashierInitParamHelper INSTANCE = new CashierInitParamHelper();

    private CashierInitParamHelper() {
    }

    public static CashierMerchantModel MyBillsEntityDataFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, String> DatabaseTableConfigUtil = UrlUtil.DatabaseTableConfigUtil(p0);
        String str = DatabaseTableConfigUtil.get("merchantQrCode");
        String str2 = str == null ? "" : str;
        String str3 = DatabaseTableConfigUtil.get("merchantId");
        String str4 = str3 == null ? "" : str3;
        String str5 = DatabaseTableConfigUtil.get("merchantType");
        String str6 = str5 == null ? "" : str5;
        String str7 = DatabaseTableConfigUtil.get("merchantName");
        String str8 = str7 == null ? "" : str7;
        String str9 = DatabaseTableConfigUtil.get("merchantAddress");
        String str10 = str9 == null ? "" : str9;
        String str11 = DatabaseTableConfigUtil.get("bizType");
        String str12 = str11 == null ? "" : str11;
        String str13 = DatabaseTableConfigUtil.get("cacheKey");
        String str14 = str13 == null ? "" : str13;
        String str15 = DatabaseTableConfigUtil.get(RemoteConfigConstants.RequestFieldKey.COUNTRY_CODE);
        String str16 = str15 == null ? "" : str15;
        String str17 = DatabaseTableConfigUtil.get(SummaryActivity.FIRST_STATE_SHARE_FEED);
        String str18 = str17 == null ? "" : str17;
        String str19 = DatabaseTableConfigUtil.get("transactionAmount");
        String str20 = str19 == null ? "" : str19;
        String str21 = DatabaseTableConfigUtil.get("acquirerName");
        String str22 = str21 == null ? "" : str21;
        String str23 = DatabaseTableConfigUtil.get("merchantCity");
        String str24 = str23 == null ? "" : str23;
        String str25 = DatabaseTableConfigUtil.get("merchantPan");
        String str26 = str25 == null ? "" : str25;
        String str27 = DatabaseTableConfigUtil.get("postalCode");
        String str28 = str27 == null ? "" : str27;
        String str29 = DatabaseTableConfigUtil.get("crossBorder");
        return new CashierMerchantModel(str2, str4, str6, str8, str10, str12, str14, str16, str18, str20, null, null, false, null, str22, str24, str26, str28, Intrinsics.areEqual(str29 != null ? str29 : "", SummaryActivity.CHECKED), 15360, null);
    }

    public static CashierMerchantModel PlaceComponentResult(HashMap<String, String> p0, String p1, String p2, Boolean p3) {
        Intrinsics.checkNotNullParameter(p0, "");
        Set<String> keySet = p0.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "");
        String str = "";
        for (String str2 : keySet) {
            Intrinsics.checkNotNullExpressionValue(str2, "");
            if (GetContactSyncConfig(str2)) {
                str = str2;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("02");
        return new CashierMerchantModel(p2, p0.get(sb.toString()), null, p0.get("59"), p0.get("60"), null, null, p0.get("58"), null, p0.get("54"), null, null, p3 != null ? p3.booleanValue() : false, p1, p0.get("2600"), p0.get("60"), p0.get("2601"), p0.get("61"), false, 265572, null);
    }

    private static boolean GetContactSyncConfig(String p0) {
        try {
            int parseInt = Integer.parseInt(p0);
            return 26 <= parseInt && parseInt < 46;
        } catch (Exception unused) {
            return false;
        }
    }

    public static CashierCheckoutRequestModel BuiltInFictitiousFunctionClassFactory(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, String> DatabaseTableConfigUtil = UrlUtil.DatabaseTableConfigUtil(p0);
        String str = DatabaseTableConfigUtil.get(CashierKeyParams.CASHIER_ORDER_ID);
        String str2 = DatabaseTableConfigUtil.get("reloadRequest");
        Boolean valueOf = str2 != null ? Boolean.valueOf(Boolean.parseBoolean(str2)) : null;
        String str3 = DatabaseTableConfigUtil.get("mid");
        String str4 = DatabaseTableConfigUtil.get("bizNo");
        String str5 = DatabaseTableConfigUtil.get("timestamp");
        String str6 = DatabaseTableConfigUtil.get("sign");
        String str7 = DatabaseTableConfigUtil.get("addOn");
        CheckoutExternalInfo checkoutExternalInfo = new CheckoutExternalInfo(str3, str4, str5, str6, str7 != null ? Boolean.valueOf(Boolean.parseBoolean(str7)) : null, null, 32, null);
        String str8 = DatabaseTableConfigUtil.get("payMethodFilter");
        String str9 = DatabaseTableConfigUtil.get("epAddonId");
        String str10 = str9 == null ? "" : str9;
        String str11 = DatabaseTableConfigUtil.get("paylaterRepaymentSource");
        String str12 = str11 == null ? "" : str11;
        String str13 = DatabaseTableConfigUtil.get(ParamConstantsKt.IS_DEEPLINK_PAYMENT);
        boolean parseBoolean = str13 != null ? Boolean.parseBoolean(str13) : false;
        String str14 = DatabaseTableConfigUtil.get("bizScenario");
        return new CashierCheckoutRequestModel(str, valueOf, checkoutExternalInfo, str8, str10, null, str12, null, null, null, DatabaseTableConfigUtil.get("transType"), parseBoolean, str14 == null ? "" : str14, PDF417Common.MAX_CODEWORDS_IN_BARCODE, null);
    }

    public static String getAuthRequestContext(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return UrlUtil.DatabaseTableConfigUtil(p0).get("orderId");
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda0(String p0) {
        String str;
        String str2 = p0;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        Map<String, String> DatabaseTableConfigUtil = UrlUtil.DatabaseTableConfigUtil(p0);
        String str3 = DatabaseTableConfigUtil.get("merchantId");
        if (!(str3 == null || str3.length() == 0)) {
            str = DatabaseTableConfigUtil.get("merchantId");
        } else {
            str = DatabaseTableConfigUtil.get("mid");
        }
        return str == null ? "" : str;
    }

    public static boolean lookAheadTest(String p0) {
        String str = p0;
        if (str == null || str.length() == 0) {
            return false;
        }
        return Intrinsics.areEqual(UrlUtil.DatabaseTableConfigUtil(p0).get("forceToH5"), SummaryActivity.CHECKED);
    }

    public static boolean moveToNextValue(String p0) {
        String str = p0;
        if (str == null || str.length() == 0) {
            return false;
        }
        return Intrinsics.areEqual(UrlUtil.DatabaseTableConfigUtil(p0).get("crossBorder"), SummaryActivity.CHECKED);
    }

    public static Pair<String, String> PlaceComponentResult(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Map<String, String> DatabaseTableConfigUtil = UrlUtil.DatabaseTableConfigUtil(p0);
        String str = DatabaseTableConfigUtil.get(CashierKeyParams.CASHIER_ORDER_ID);
        String str2 = DatabaseTableConfigUtil.get("reloadRequest");
        if (str == null) {
            str = "";
        }
        return new Pair<>(str, str2 != null ? str2 : "");
    }

    public static boolean initRecordTimeStamp(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return NetworkUserEntityData$$ExternalSyntheticLambda2(p0) || scheduleImpl(p0) || getErrorConfigVersion(p0);
    }

    public static boolean scheduleImpl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.startsWith$default(str, "https://m.dana.id/m/portal/pay-merchant", false, 2, (Object) null);
    }

    public static boolean NetworkUserEntityData$$ExternalSyntheticLambda2(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.startsWith$default(str, "https://m.dana.id/m/portal/cashier/checkout", false, 2, (Object) null);
    }

    public static boolean getErrorConfigVersion(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.startsWith$default(str, "https://m.dana.id/m/portal/payment-link", false, 2, (Object) null);
    }

    public static DecodedScan KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DecodedScan decodedScan = new DecodedScan();
        HashMap hashMap = new HashMap();
        hashMap.put("url", p0);
        decodedScan.setBizInfo(hashMap);
        decodedScan.setBizType(DecodeQrBizType.MERCHANT_CODE);
        decodedScan.setSuccess(true);
        return decodedScan;
    }
}
