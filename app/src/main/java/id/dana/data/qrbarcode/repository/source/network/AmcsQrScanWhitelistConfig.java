package id.dana.data.qrbarcode.repository.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.foundation.amcs.AMCSManager;
import id.dana.data.qrbarcode.repository.source.QrScanWhitelistEntityData;
import io.reactivex.Observable;
import java.util.List;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.getCallingPid;

@Singleton
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/AmcsQrScanWhitelistConfig;", "Lid/dana/data/qrbarcode/repository/source/QrScanWhitelistEntityData;", "Lio/reactivex/Observable;", "", "", "getWhitelistedQrH5Container", "()Lio/reactivex/Observable;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/data/foundation/amcs/AMCSManager;", "amcsManager", "<init>", "(Landroid/content/Context;Lid/dana/data/foundation/amcs/AMCSManager;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class AmcsQrScanWhitelistConfig implements QrScanWhitelistEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static char MyBillsEntityDataFactory = 42065;
    private static int PlaceComponentResult;
    private static char[] getAuthRequestContext = {37307, 37308, 37283, 37282, 37281, 37310, 37294, 37290, 37264, 37292, 37291, 37309, 37304, 37286, 37280, 37287};

    public static /* synthetic */ List $r8$lambda$MjtLsQbChGqV_Rx4LNnmQy8DERQ() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 25;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? '0' : 'S') != '0') {
            return m1693getWhitelistedQrH5Container$lambda0();
        }
        int i2 = 16 / 0;
        return m1693getWhitelistedQrH5Container$lambda0();
    }

    @Inject
    public AmcsQrScanWhitelistConfig(Context context, AMCSManager aMCSManager) {
        try {
            Intrinsics.checkNotNullParameter(context, "");
            Intrinsics.checkNotNullParameter(aMCSManager, "");
            aMCSManager.MyBillsEntityDataFactory(context, "prod");
        } catch (Exception e) {
            throw e;
        }
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrScanWhitelistEntityData
    public final Observable<List<String>> getWhitelistedQrH5Container() {
        Observable<List<String>> fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig$$ExternalSyntheticLambda0
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return AmcsQrScanWhitelistConfig.$r8$lambda$MjtLsQbChGqV_Rx4LNnmQy8DERQ();
            }
        });
        Intrinsics.checkNotNullExpressionValue(fromCallable, "");
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 57;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        return fromCallable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004a, code lost:
    
        if ((r0 != null ? '1' : 11) == '1') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0075, code lost:
    
        if (r0 != null) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0077, code lost:
    
        r0 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r0);
        r2 = id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.KClassImpl$Data$declaredNonStaticMembers$2 + 63;
        id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.PlaceComponentResult = r2 % 128;
        r2 = r2 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0084, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x008c, code lost:
    
        throw new id.dana.utils.exception.CallableReturnNullError("AmcsQrScanWhitelistConfig#getWhitelistedQrH5Container");
     */
    /* renamed from: getWhitelistedQrH5Container$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1693getWhitelistedQrH5Container$lambda0() {
        /*
            int r0 = id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.PlaceComponentResult
            int r0 = r0 + 111
            int r1 = r0 % 128
            id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            r1 = 63
            if (r0 != 0) goto L11
            r0 = 63
            goto L13
        L11:
            r0 = 62
        L13:
            r2 = 28
            r3 = 1
            java.lang.String r4 = ""
            r5 = 0
            if (r0 == r1) goto L4d
            com.iap.ac.config.lite.ConfigCenter r0 = com.iap.ac.config.lite.ConfigCenter.getInstance()
            char[] r6 = new char[r2]
            r6 = {x008e: FILL_ARRAY_DATA , data: [7, 11, 8, 10, 14, 7, 8, 4, 9, 4, 8, 9, 14, 2, 2, 7, 12, 5, 12, 0, 12, 14, 3, 4, 1, 14, 2, 1} // fill-array
            int r7 = android.graphics.Color.red(r5)
            int r7 = r7 + 19
            byte r7 = (byte) r7
            int r4 = android.text.TextUtils.indexOf(r4, r4, r5)
            int r2 = r2 - r4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            a(r6, r7, r2, r3)
            r2 = r3[r5]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            org.json.JSONArray r0 = r0.getJSONArrayConfig(r2)
            r2 = 49
            if (r0 == 0) goto L48
            r3 = 49
            goto L4a
        L48:
            r3 = 11
        L4a:
            if (r3 != r2) goto L85
            goto L77
        L4d:
            com.iap.ac.config.lite.ConfigCenter r0 = com.iap.ac.config.lite.ConfigCenter.getInstance()
            char[] r2 = new char[r2]
            r2 = {x00ae: FILL_ARRAY_DATA , data: [7, 11, 8, 10, 14, 7, 8, 4, 9, 4, 8, 9, 14, 2, 2, 7, 12, 5, 12, 0, 12, 14, 3, 4, 1, 14, 2, 1} // fill-array
            int r6 = android.graphics.Color.red(r3)
            int r6 = 23 - r6
            byte r6 = (byte) r6
            r7 = 122(0x7a, float:1.71E-43)
            int r4 = android.text.TextUtils.indexOf(r4, r4, r3)
            int r7 = r7 / r4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            a(r2, r6, r7, r3)
            r2 = r3[r5]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            org.json.JSONArray r0 = r0.getJSONArrayConfig(r2)
            if (r0 == 0) goto L85
        L77:
            java.util.List r0 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r0)
            int r2 = id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.KClassImpl$Data$declaredNonStaticMembers$2
            int r2 = r2 + r1
            int r1 = r2 % 128
            id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.PlaceComponentResult = r1
            int r2 = r2 % 2
            return r0
        L85:
            id.dana.utils.exception.CallableReturnNullError r0 = new id.dana.utils.exception.CallableReturnNullError
            java.lang.String r1 = "AmcsQrScanWhitelistConfig#getWhitelistedQrH5Container"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrbarcode.repository.source.network.AmcsQrScanWhitelistConfig.m1693getWhitelistedQrH5Container$lambda0():java.util.List");
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        getCallingPid getcallingpid = new getCallingPid();
        char[] cArr2 = getAuthRequestContext;
        if (cArr2 != null) {
            int length = cArr2.length;
            char[] cArr3 = new char[length];
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                try {
                    int i4 = $10 + 39;
                    $11 = i4 % 128;
                    if ((i4 % 2 == 0 ? 'b' : (char) 11) == 'b') {
                        cArr3[i3] = (char) (cArr2[i3] / (-1549216646985767851L));
                        i3 *= 0;
                    } else {
                        cArr3[i3] = (char) (cArr2[i3] ^ (-1549216646985767851L));
                        i3++;
                    }
                } catch (Exception e) {
                    throw e;
                }
            }
            int i5 = $11 + 29;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cArr2 = cArr3;
        }
        char c = (char) ((-1549216646985767851L) ^ MyBillsEntityDataFactory);
        char[] cArr4 = new char[i];
        if (i % 2 != 0) {
            i2 = i - 1;
            cArr4[i2] = (char) (cArr[i2] - b);
        } else {
            i2 = i;
        }
        if (i2 > 1) {
            int i7 = $10 + 9;
            $11 = i7 % 128;
            int i8 = i7 % 2;
            getcallingpid.getAuthRequestContext = 0;
            while (true) {
                if ((getcallingpid.getAuthRequestContext < i2 ? '@' : (char) 6) != '@') {
                    break;
                }
                getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                if (getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult) {
                    cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                    cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                } else {
                    getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                    getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                    getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                    getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                    if ((getcallingpid.scheduleImpl == getcallingpid.lookAheadTest ? (char) 14 : (char) 31) != 31) {
                        getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                        getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                        int i9 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                        int i10 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                        cArr4[getcallingpid.getAuthRequestContext] = cArr2[i9];
                        cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i10];
                    } else {
                        try {
                            if (getcallingpid.BuiltInFictitiousFunctionClassFactory == getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2) {
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i11];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i12];
                            } else {
                                int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr2[i13];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr2[i14];
                            }
                        } catch (Exception e2) {
                            throw e2;
                        }
                    }
                }
                getcallingpid.getAuthRequestContext += 2;
            }
        }
        int i15 = $11 + 11;
        $10 = i15 % 128;
        int i16 = i15 % 2;
        for (int i17 = 0; i17 < i; i17++) {
            cArr4[i17] = (char) (cArr4[i17] ^ 13722);
        }
        objArr[0] = new String(cArr4);
    }
}
