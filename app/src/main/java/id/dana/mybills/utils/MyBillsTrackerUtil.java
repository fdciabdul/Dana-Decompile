package id.dana.mybills.utils;

import com.iap.ac.android.container.adapter.griver.extension.CustomMenuExtensionImpl;
import id.dana.mybills.ui.constant.RecurringType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lid/dana/mybills/utils/MyBillsTrackerUtil;", "", "()V", RecurringType.REMINDER, "", "SUBSCRIPTION", "getProductIdResult", "isBillActive", "", "inquiryCode", "getRecurringTypeTrackerName", "recurringType", "getServiceNameByGoodsType", "goodsType", "feature-mybills_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class MyBillsTrackerUtil {
    public static final MyBillsTrackerUtil getAuthRequestContext = new MyBillsTrackerUtil();

    private MyBillsTrackerUtil() {
    }

    public static String getAuthRequestContext(boolean z, String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return (z || !Intrinsics.areEqual(str, "20")) ? (z && (Intrinsics.areEqual(str, "25") || Intrinsics.areEqual(str, "26"))) ? "Already Registered And No Bills To Pay" : (z || !(Intrinsics.areEqual(str, "25") || Intrinsics.areEqual(str, "26"))) ? z ? "ID Already Registered" : "Successful" : "No Bills Yet" : "Invalid ID";
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return Intrinsics.areEqual(str, RecurringType.REMINDER) ? "Reminder" : CustomMenuExtensionImpl.TYPE_SUBSCRIPTION;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0076 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x008c A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getAuthRequestContext(java.lang.String r3) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            int r0 = r3.hashCode()
            java.lang.String r1 = "BPJS"
            java.lang.String r2 = "PGN"
            switch(r0) {
                case -1435322694: goto L8f;
                case -1183873455: goto L84;
                case -932963067: goto L79;
                case -691577239: goto L6e;
                case 79159: goto L66;
                case 2045463: goto L5e;
                case 2263385: goto L53;
                case 76105038: goto L48;
                case 82365687: goto L3d;
                case 216862158: goto L34;
                case 868637213: goto L2a;
                case 1046672193: goto L1e;
                case 1353037633: goto L12;
                default: goto L10;
            }
        L10:
            goto L99
        L12:
            java.lang.String r0 = "INTERNET"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Internet & TV Cable"
            goto L99
        L1e:
            java.lang.String r0 = "GAME_VOUCHER"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Digital Voucher"
            goto L99
        L2a:
            java.lang.String r0 = "MOBILE_POST"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L76
            goto L99
        L34:
            java.lang.String r0 = "ELECTRICITY_POST"
            boolean r0 = r3.equals(r0)
            if (r0 != 0) goto L8c
            goto L99
        L3d:
            java.lang.String r0 = "WATER"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Water"
            goto L99
        L48:
            java.lang.String r0 = "PHONE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Telkom"
            goto L99
        L53:
            java.lang.String r0 = "INSTALLMENT"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Installment"
            goto L99
        L5e:
            boolean r0 = r3.equals(r1)
            if (r0 == 0) goto L99
            r3 = r1
            goto L99
        L66:
            boolean r0 = r3.equals(r2)
            if (r0 == 0) goto L99
            r3 = r2
            goto L99
        L6e:
            java.lang.String r0 = "MOBILE_POSTPAID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
        L76:
            java.lang.String r3 = "Mobile Postpaid"
            goto L99
        L79:
            java.lang.String r0 = "PULSA_PREPAID"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Mobile Recharge"
            goto L99
        L84:
            java.lang.String r0 = "ELECTRICITY"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
        L8c:
            java.lang.String r3 = "Electricity"
            goto L99
        L8f:
            java.lang.String r0 = "INSURANCE"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L99
            java.lang.String r3 = "Insurance"
        L99:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.utils.MyBillsTrackerUtil.getAuthRequestContext(java.lang.String):java.lang.String");
    }
}
