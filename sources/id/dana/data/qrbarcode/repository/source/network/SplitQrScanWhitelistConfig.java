package id.dana.data.qrbarcode.repository.source.network;

import id.dana.data.qrbarcode.repository.source.QrScanWhitelistEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import o.C;

@Singleton
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/data/qrbarcode/repository/source/network/SplitQrScanWhitelistConfig;", "Lid/dana/data/qrbarcode/repository/source/QrScanWhitelistEntityData;", "Lio/reactivex/Observable;", "", "", "getWhitelistedQrH5Container", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitQrScanWhitelistConfig implements QrScanWhitelistEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 32798;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 10195;
    private static char MyBillsEntityDataFactory = 42313;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static char PlaceComponentResult = 8748;
    private static int getAuthRequestContext;
    private final SplitFacade splitFacade;

    public static /* synthetic */ Observable $r8$lambda$7mu69wLuemruQkkTNb2AHQ_XTLw(Throwable th) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 105;
        getAuthRequestContext = i % 128;
        boolean z = i % 2 != 0;
        Observable m1714getWhitelistedQrH5Container$lambda1 = m1714getWhitelistedQrH5Container$lambda1(th);
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1714getWhitelistedQrH5Container$lambda1;
    }

    public static /* synthetic */ List $r8$lambda$uVwXsY8rxYxLmEWg9hc9e4JondY(BaseTrafficType baseTrafficType) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        List m1713getWhitelistedQrH5Container$lambda0 = m1713getWhitelistedQrH5Container$lambda0(baseTrafficType);
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 43;
        getAuthRequestContext = i3 % 128;
        if (i3 % 2 == 0) {
            return m1713getWhitelistedQrH5Container$lambda0;
        }
        int i4 = 63 / 0;
        return m1713getWhitelistedQrH5Container$lambda0;
    }

    @Inject
    public SplitQrScanWhitelistConfig(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.qrbarcode.repository.source.QrScanWhitelistEntityData
    public final Observable<List<String>> getWhitelistedQrH5Container() {
        try {
            Observable<List<String>> onErrorResumeNext = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitQrScanWhitelistConfig.$r8$lambda$uVwXsY8rxYxLmEWg9hc9e4JondY((BaseTrafficType) obj);
                }
            }).onErrorResumeNext(new Function() { // from class: id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig$$ExternalSyntheticLambda1
                @Override // io.reactivex.functions.Function
                public final Object apply(Object obj) {
                    return SplitQrScanWhitelistConfig.$r8$lambda$7mu69wLuemruQkkTNb2AHQ_XTLw((Throwable) obj);
                }
            });
            Intrinsics.checkNotNullExpressionValue(onErrorResumeNext, "");
            int i = getAuthRequestContext + 49;
            NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
            int i2 = i % 2;
            return onErrorResumeNext;
        } catch (Exception e) {
            throw e;
        }
    }

    /* renamed from: getWhitelistedQrH5Container$lambda-1  reason: not valid java name */
    private static final Observable m1714getWhitelistedQrH5Container$lambda1(Throwable th) {
        Observable just;
        Intrinsics.checkNotNullParameter(th, "");
        if (!(!(th instanceof NullPointerException))) {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda0 + 85;
            getAuthRequestContext = i % 128;
            if ((i % 2 != 0 ? ')' : '=') != ')') {
                just = Observable.just(CollectionsKt.emptyList());
            } else {
                just = Observable.just(CollectionsKt.emptyList());
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = NetworkUserEntityData$$ExternalSyntheticLambda0 + 91;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            return just;
        }
        try {
            return Observable.error(th);
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x004f, code lost:
    
        if ((org.json.JSONArray.class.isAssignableFrom(org.json.JSONArray.class) ? kotlin.text.Typography.greater : '?') != '?') goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x007c, code lost:
    
        if (org.json.JSONArray.class.isAssignableFrom(org.json.JSONArray.class) != false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x007e, code lost:
    
        if (r8 != null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0081, code lost:
    
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0082, code lost:
    
        r6 = new org.json.JSONArray(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0088, code lost:
    
        if (r8 == null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x008a, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x008c, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x008d, code lost:
    
        if (r0 == true) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0090, code lost:
    
        r0 = id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig.getAuthRequestContext + 77;
        id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig.NetworkUserEntityData$$ExternalSyntheticLambda0 = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x009a, code lost:
    
        if ((r0 % 2) != 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009c, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009d, code lost:
    
        if (r5 == true) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x009f, code lost:
    
        r8 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r8, null), (java.lang.Class<java.lang.Object>) org.json.JSONArray.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ae, code lost:
    
        r8 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult().fromJson(id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r8, null), (java.lang.Class<java.lang.Object>) org.json.JSONArray.class);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bc, code lost:
    
        r0 = r6.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c0, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getWhitelistedQrH5Container$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.List m1713getWhitelistedQrH5Container$lambda0(id.dana.data.toggle.traffictype.BaseTrafficType r8) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.qrbarcode.repository.source.network.SplitQrScanWhitelistConfig.m1713getWhitelistedQrH5Container$lambda0(id.dana.data.toggle.traffictype.BaseTrafficType):java.util.List");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $10 + 59;
        $11 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? (char) 31 : '/') == 31) {
                int i4 = $11 + 125;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i6 = 58224;
                int i7 = 0;
                while (true) {
                    if (!(i7 >= 16)) {
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i6) ^ ((cArr3[0] << 4) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i6) ^ ((cArr3[1] << 4) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                        i6 -= 40503;
                        i7++;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
