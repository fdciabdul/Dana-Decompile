package id.dana.danah5.globalnetwork.manager;

import id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData;
import id.dana.data.h5event.sendmoney.CheckoutFinishEntity;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0004\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\nJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danah5/globalnetwork/manager/CheckoutFinishGnEventPluginManager;", "", "", "status", "getPayStatus$app_productionRelease", "(Ljava/lang/String;)Ljava/lang/String;", "Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;", "checkoutFinishEntity", "", "isAcCashierGnScenario", "(Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)Z", "isGnScenario", "", "sendCallbackResult", "(Lid/dana/data/h5event/sendmoney/CheckoutFinishEntity;)V", "sendCallbackResultWithoutCallback", "Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "remoteGnPaymentEntityData", "Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;", "<init>", "(Lid/dana/data/globalnetwork/source/remote/RemoteGnPaymentEntityData;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CheckoutFinishGnEventPluginManager {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    public static final String GN_NETWORK_CASHIER_SCENARIO = "CASHIER_ISSUER";
    public static final String GN_NETWORK_INFO_NAME = "GN";
    public static final String GN_NETWORK_INFO_NAME_LOCAL_MP = "ALIPAY";
    public static final String GN_NETWORK_INFO_SCENE = "ACIS";
    public static final String GN_NETWORK_INFO_SCENE_LOCAL_MP = "GLOCAL";
    private static long KClassImpl$Data$declaredNonStaticMembers$2;
    private static int getAuthRequestContext;
    private final RemoteGnPaymentEntityData remoteGnPaymentEntityData;

    static {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2 = -2319710507409958861L;
            INSTANCE = new Companion(null);
            int i = getAuthRequestContext + 85;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public CheckoutFinishGnEventPluginManager(RemoteGnPaymentEntityData remoteGnPaymentEntityData) {
        Intrinsics.checkNotNullParameter(remoteGnPaymentEntityData, "");
        this.remoteGnPaymentEntityData = remoteGnPaymentEntityData;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002f, code lost:
    
        if (r8 != null) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isGnScenario(id.dana.data.h5event.sendmoney.CheckoutFinishEntity r8) {
        /*
            r7 = this;
            int r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 81
            if (r0 == 0) goto L11
            r0 = 24
            goto L13
        L11:
            r0 = 81
        L13:
            java.lang.String r3 = ""
            r4 = 1
            r5 = 0
            if (r0 == r2) goto L28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r3)
            id.dana.data.h5event.sendmoney.PayQueryResponse r8 = r8.getPayQueryResponse()
            if (r8 == 0) goto L24
            r0 = 0
            goto L25
        L24:
            r0 = 1
        L25:
            if (r0 == r4) goto La0
            goto L31
        L28:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r3)
            id.dana.data.h5event.sendmoney.PayQueryResponse r8 = r8.getPayQueryResponse()
            if (r8 == 0) goto L9f
        L31:
            id.dana.data.h5event.sendmoney.Attributes r8 = r8.getAttributes()
            if (r8 == 0) goto L9f
            int r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext
            int r0 = r0 + 123
            int r2 = r0 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % r1
            java.lang.String r0 = r8.getNetworkInfoName()
            int r2 = android.text.TextUtils.indexOf(r3, r3)
            int r2 = r2 + 23719
            char[] r3 = new char[r1]
            r3 = {x00a2: FILL_ARRAY_DATA , data: [18743, 5529} // fill-array
            java.lang.Object[] r6 = new java.lang.Object[r4]
            a(r2, r3, r6)
            r2 = r6[r5]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r2)
            if (r0 == 0) goto L7d
            int r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext
            int r0 = r0 + 117
            int r2 = r0 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory = r2
            int r0 = r0 % r1
            java.lang.String r0 = r8.getNetworkInfoScene()
            java.lang.String r1 = "ACIS"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L79
            r0 = 0
            goto L7a
        L79:
            r0 = 1
        L7a:
            if (r0 == 0) goto L7d
            goto La0
        L7d:
            java.lang.String r0 = r8.getNetworkInfoName()
            java.lang.String r1 = "ALIPAY"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            r1 = 72
            if (r0 == 0) goto L8e
            r0 = 9
            goto L90
        L8e:
            r0 = 72
        L90:
            if (r0 == r1) goto L9f
            java.lang.String r8 = r8.getNetworkInfoScene()
            java.lang.String r0 = "GLOCAL"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual(r8, r0)
            if (r8 == 0) goto L9f
            goto La0
        L9f:
            r4 = 0
        La0:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.isGnScenario(id.dana.data.h5event.sendmoney.CheckoutFinishEntity):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0027, code lost:
    
        if ((r4 != null ? 19 : '+') != 19) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0035, code lost:
    
        if (r4 != null) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0037, code lost:
    
        r4 = r4.getAttributes();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003b, code lost:
    
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
    
        r4 = r4.getNetworkScenario();
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0041, code lost:
    
        if (r4 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0043, code lost:
    
        r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext + 71;
        id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0054, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return kotlin.jvm.internal.Intrinsics.areEqual(r4, id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.GN_NETWORK_CASHIER_SCENARIO);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isAcCashierGnScenario(id.dana.data.h5event.sendmoney.CheckoutFinishEntity r4) {
        /*
            r3 = this;
            int r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext
            int r0 = r0 + 35
            int r1 = r0 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 9
            if (r0 != 0) goto L11
            r0 = 9
            goto L13
        L11:
            r0 = 55
        L13:
            java.lang.String r2 = ""
            if (r0 == r1) goto L2a
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)
            id.dana.data.h5event.sendmoney.PayQueryResponse r4 = r4.getPayQueryResponse()
            r0 = 19
            if (r4 == 0) goto L25
            r1 = 19
            goto L27
        L25:
            r1 = 43
        L27:
            if (r1 == r0) goto L37
            goto L54
        L2a:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r2)     // Catch: java.lang.Exception -> L5a
            id.dana.data.h5event.sendmoney.PayQueryResponse r4 = r4.getPayQueryResponse()     // Catch: java.lang.Exception -> L58
            r0 = 0
            r0.hashCode()     // Catch: java.lang.Throwable -> L56
            if (r4 == 0) goto L54
        L37:
            id.dana.data.h5event.sendmoney.Attributes r4 = r4.getAttributes()
            if (r4 == 0) goto L54
            java.lang.String r4 = r4.getNetworkScenario()
            if (r4 == 0) goto L54
            int r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext     // Catch: java.lang.Exception -> L5a
            int r0 = r0 + 71
            int r1 = r0 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L5a
            int r0 = r0 % 2
            java.lang.String r0 = "CASHIER_ISSUER"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r0)
            goto L55
        L54:
            r4 = 0
        L55:
            return r4
        L56:
            r4 = move-exception
            throw r4
        L58:
            r4 = move-exception
            goto L5c
        L5a:
            r4 = move-exception
            throw r4
        L5c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.isAcCashierGnScenario(id.dana.data.h5event.sendmoney.CheckoutFinishEntity):boolean");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0031
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public final void sendCallbackResult(id.dana.data.h5event.sendmoney.CheckoutFinishEntity r3) {
        /*
            r2 = this;
            int r0 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 31
            int r1 = r0 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext = r1
            int r0 = r0 % 2
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)     // Catch: java.lang.Exception -> L2f
            id.dana.data.globalnetwork.source.remote.RemoteGnPaymentEntityData r0 = r2.remoteGnPaymentEntityData     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r3.getProcessingStatus()     // Catch: java.lang.Exception -> L2f
            java.lang.String r1 = r2.getPayStatus$app_productionRelease(r1)     // Catch: java.lang.Exception -> L2f
            boolean r3 = r3.getApiSuccess()     // Catch: java.lang.Exception -> L2f
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch: java.lang.Exception -> L2f
            r0.setResultPayment(r1, r3)     // Catch: java.lang.Exception -> L2f
            int r3 = id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.getAuthRequestContext
            int r3 = r3 + 45
            int r0 = r3 % 128
            id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.BuiltInFictitiousFunctionClassFactory = r0
            int r3 = r3 % 2
            return
        L2f:
            r3 = move-exception
            throw r3
        L31:
            r3 = move-exception
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.danah5.globalnetwork.manager.CheckoutFinishGnEventPluginManager.sendCallbackResult(id.dana.data.h5event.sendmoney.CheckoutFinishEntity):void");
    }

    public final void sendCallbackResultWithoutCallback(CheckoutFinishEntity checkoutFinishEntity) {
        int i = getAuthRequestContext + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            Intrinsics.checkNotNullParameter(checkoutFinishEntity, "");
            this.remoteGnPaymentEntityData.setResultPaymentWithoutCallback(getPayStatus$app_productionRelease(checkoutFinishEntity.getProcessingStatus()), String.valueOf(checkoutFinishEntity.getApiSuccess()));
            int i3 = getAuthRequestContext + 11;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public final String getPayStatus$app_productionRelease(String status) {
        String upperCase;
        String str;
        if ((status != null ? '`' : '8') != '`') {
            upperCase = null;
        } else {
            int i = BuiltInFictitiousFunctionClassFactory + 45;
            getAuthRequestContext = i % 128;
            if ((i % 2 != 0 ? Typography.less : (char) 5) != 5) {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "");
                upperCase = status.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "");
                int i2 = 40 / 0;
            } else {
                Locale locale2 = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale2, "");
                upperCase = status.toUpperCase(locale2);
                Intrinsics.checkNotNullExpressionValue(upperCase, "");
            }
        }
        if (upperCase != null) {
            int hashCode = upperCase.hashCode();
            if (hashCode == -1149187101) {
                if (!(upperCase.equals("SUCCESS") ? false : true)) {
                    str = "9000";
                }
            } else if (hashCode != -137465490) {
                int i3 = getAuthRequestContext + 107;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
                if (hashCode == 35394935) {
                    if ((upperCase.equals("PENDING") ? 'a' : 'O') != 'O') {
                        str = "8000";
                    }
                }
            } else if (upperCase.equals("USER_CANCEL")) {
                int i5 = BuiltInFictitiousFunctionClassFactory + 123;
                getAuthRequestContext = i5 % 128;
                if (i5 % 2 != 0) {
                    int i6 = 91 / 0;
                }
                str = "6001";
            }
            int i7 = BuiltInFictitiousFunctionClassFactory + 45;
            getAuthRequestContext = i7 % 128;
            int i8 = i7 % 2;
            return str;
        }
        str = "4000";
        int i72 = BuiltInFictitiousFunctionClassFactory + 45;
        getAuthRequestContext = i72 % 128;
        int i82 = i72 % 2;
        return str;
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                break;
            }
            try {
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
                int i2 = $11 + 101;
                $10 = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (getonboardingscenario.getAuthRequestContext < cArr.length) {
            int i4 = $11 + 31;
            $10 = i4 % 128;
            if (!(i4 % 2 != 0)) {
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } else {
                try {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext /= 0;
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        String str = new String(cArr2);
        int i5 = $11 + 15;
        $10 = i5 % 128;
        if (i5 % 2 == 0) {
            objArr[0] = str;
            return;
        }
        Object[] objArr2 = null;
        int length2 = objArr2.length;
        objArr[0] = str;
    }
}
