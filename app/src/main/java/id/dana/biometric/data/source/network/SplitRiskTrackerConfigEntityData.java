package id.dana.biometric.data.source.network;

import com.alibaba.fastjson.parser.JSONLexer;
import id.dana.biometric.data.source.RiskTrackerConfigEntityData;
import id.dana.biometric.data.source.local.RiskTrackerConfigEntity;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

@Singleton
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/biometric/data/source/network/SplitRiskTrackerConfigEntityData;", "Lid/dana/biometric/data/source/RiskTrackerConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/biometric/data/source/local/RiskTrackerConfigEntity;", "getRiskTrackerConfig", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SplitRiskTrackerConfigEntityData implements RiskTrackerConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static int MyBillsEntityDataFactory = 1;
    private static int[] PlaceComponentResult = {1754132062, -756443943, -1001451321, 491880814, 1434687078, -1273149775, 1137638676, 1769345772, 1183194402, 1439352144, 990024498, 168964550, -579993349, -1908255962, -1275023782, -449629040, 956988417, -449735970};
    private final SplitFacade splitFacade;

    /* renamed from: $r8$lambda$1oAthA6kGy-fRqBsEXDnRMswVZs  reason: not valid java name */
    public static /* synthetic */ ObservableSource m474$r8$lambda$1oAthA6kGyfRqBsEXDnRMswVZs(BaseTrafficType baseTrafficType) {
        try {
            int i = MyBillsEntityDataFactory + 55;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            ObservableSource m475getRiskTrackerConfig$lambda1 = m475getRiskTrackerConfig$lambda1(baseTrafficType);
            int i3 = MyBillsEntityDataFactory + 13;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return m475getRiskTrackerConfig$lambda1;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ RiskTrackerConfigEntity $r8$lambda$qdINrtlAcCLT3gGrS_WPWSJ7AC4(BaseTrafficType baseTrafficType) {
        int i = MyBillsEntityDataFactory + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        RiskTrackerConfigEntity m476getRiskTrackerConfig$lambda1$lambda0 = m476getRiskTrackerConfig$lambda1$lambda0(baseTrafficType);
        int i3 = BuiltInFictitiousFunctionClassFactory + 5;
        MyBillsEntityDataFactory = i3 % 128;
        int i4 = i3 % 2;
        return m476getRiskTrackerConfig$lambda1$lambda0;
    }

    @Inject
    public SplitRiskTrackerConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.biometric.data.source.RiskTrackerConfigEntityData
    public final Observable<RiskTrackerConfigEntity> getRiskTrackerConfig() {
        Observable flatMap = this.splitFacade.PlaceComponentResult().flatMap(new Function() { // from class: id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitRiskTrackerConfigEntityData.m474$r8$lambda$1oAthA6kGyfRqBsEXDnRMswVZs((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "");
        int i = MyBillsEntityDataFactory + 61;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '+' : '?') != '?') {
            int i2 = 16 / 0;
            return flatMap;
        }
        return flatMap;
    }

    /* renamed from: getRiskTrackerConfig$lambda-1  reason: not valid java name */
    private static final ObservableSource m475getRiskTrackerConfig$lambda1(final BaseTrafficType baseTrafficType) {
        try {
            Intrinsics.checkNotNullParameter(baseTrafficType, "");
            Observable fromCallable = Observable.fromCallable(new Callable() { // from class: id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData$$ExternalSyntheticLambda1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return SplitRiskTrackerConfigEntityData.$r8$lambda$qdINrtlAcCLT3gGrS_WPWSJ7AC4(BaseTrafficType.this);
                }
            });
            try {
                int i = MyBillsEntityDataFactory + 39;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                return fromCallable;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007e, code lost:
    
        if (r2 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r2 == null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0086, code lost:
    
        r0 = r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0087, code lost:
    
        r0 = (id.dana.biometric.data.source.local.RiskTrackerConfigEntity) new org.json.JSONArray(r0);
        r6 = id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.BuiltInFictitiousFunctionClassFactory + 47;
        id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.MyBillsEntityDataFactory = r6 % 128;
        r6 = r6 % 2;
     */
    /* renamed from: getRiskTrackerConfig$lambda-1$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.biometric.data.source.local.RiskTrackerConfigEntity m476getRiskTrackerConfig$lambda1$lambda0(id.dana.data.toggle.traffictype.BaseTrafficType r6) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            r1 = 0
            int r2 = android.view.View.resolveSize(r1, r1)
            int r2 = r2 + 32
            r3 = 16
            int[] r3 = new int[r3]
            r3 = {x00b4: FILL_ARRAY_DATA , data: [-423313821, -1963513151, -1337595231, -1704733169, 893138452, -347068808, 533135950, 691621900, 1480305546, 1493837037, -1185026684, -1824835481, 804740702, -807839003, -206104860, -294023683} // fill-array
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            a(r2, r3, r5)
            r2 = r5[r1]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            java.lang.String r2 = r6.getAuthRequestContext(r2, r1)
            java.lang.Class<id.dana.biometric.data.source.local.RiskTrackerConfigEntity> r3 = id.dana.biometric.data.source.local.RiskTrackerConfigEntity.class
            java.lang.Class<org.json.JSONArray> r5 = org.json.JSONArray.class
            boolean r3 = r3.isAssignableFrom(r5)
            if (r3 == 0) goto L31
            r3 = 1
            goto L32
        L31:
            r3 = 0
        L32:
            r5 = 0
            if (r3 == r4) goto L71
            if (r2 == 0) goto L5f
            com.google.gson.Gson r0 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> L46
            java.lang.String r2 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r2, r5)     // Catch: java.lang.Exception -> L46
            java.lang.Class<id.dana.biometric.data.source.local.RiskTrackerConfigEntity> r3 = id.dana.biometric.data.source.local.RiskTrackerConfigEntity.class
            java.lang.Object r0 = r0.fromJson(r2, r3)     // Catch: java.lang.Exception -> L46
            goto L47
        L46:
            r0 = r5
        L47:
            if (r0 == 0) goto L5f
            int r6 = id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.MyBillsEntityDataFactory
            int r6 = r6 + 41
            int r2 = r6 % 128
            id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.BuiltInFictitiousFunctionClassFactory = r2
            int r6 = r6 % 2
            if (r6 == 0) goto L57
            r6 = 0
            goto L58
        L57:
            r6 = 1
        L58:
            if (r6 == 0) goto L5b
            goto L99
        L5b:
            int r6 = r5.length     // Catch: java.lang.Throwable -> L5d
            goto L99
        L5d:
            r6 = move-exception
            throw r6
        L5f:
            android.content.Context r6 = r6.KClassImpl$Data$declaredNonStaticMembers$2
            java.lang.String r0 = "split/default-feature-device-signature-tracker.json"
            java.lang.String r6 = id.dana.data.foundation.utils.JsonUtil.PlaceComponentResult(r6, r0)
            java.lang.Class<id.dana.biometric.data.source.local.RiskTrackerConfigEntity> r0 = id.dana.biometric.data.source.local.RiskTrackerConfigEntity.class
            java.lang.Object r0 = com.alibaba.fastjson.JSON.parseObject(r6, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            goto L99
        L71:
            int r6 = id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.MyBillsEntityDataFactory
            int r6 = r6 + 7
            int r3 = r6 % 128
            id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.BuiltInFictitiousFunctionClassFactory = r3
            int r6 = r6 % 2
            if (r6 == 0) goto L83
            int r6 = r5.length     // Catch: java.lang.Throwable -> L81
            if (r2 != 0) goto L86
            goto L87
        L81:
            r6 = move-exception
            throw r6
        L83:
            if (r2 != 0) goto L86
            goto L87
        L86:
            r0 = r2
        L87:
            org.json.JSONArray r6 = new org.json.JSONArray
            r6.<init>(r0)
            r0 = r6
            id.dana.biometric.data.source.local.RiskTrackerConfigEntity r0 = (id.dana.biometric.data.source.local.RiskTrackerConfigEntity) r0
            int r6 = id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.BuiltInFictitiousFunctionClassFactory
            int r6 = r6 + 47
            int r2 = r6 % 128
            id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.MyBillsEntityDataFactory = r2
            int r6 = r6 % 2
        L99:
            id.dana.biometric.data.source.local.RiskTrackerConfigEntity r0 = (id.dana.biometric.data.source.local.RiskTrackerConfigEntity) r0
            if (r0 == 0) goto L9e
            goto L9f
        L9e:
            r1 = 1
        L9f:
            if (r1 != 0) goto Lac
            int r6 = id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.MyBillsEntityDataFactory
            int r6 = r6 + 53
            int r1 = r6 % 128
            id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.BuiltInFictitiousFunctionClassFactory = r1
            int r6 = r6 % 2
            return r0
        Lac:
            id.dana.utils.exception.CallableReturnNullError r6 = new id.dana.utils.exception.CallableReturnNullError
            java.lang.String r0 = "SplitRiskTrackerConfigEntityData#getRiskTrackerConfig"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.biometric.data.source.network.SplitRiskTrackerConfigEntityData.m476getRiskTrackerConfig$lambda1$lambda0(id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.biometric.data.source.local.RiskTrackerConfigEntity");
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char[] cArr = new char[4];
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = PlaceComponentResult;
        if ((iArr2 != null ? 'P' : (char) 5) == 'P') {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i2 = 0; i2 < length; i2++) {
                try {
                    iArr3[i2] = (int) (iArr2[i2] ^ (-3152031022165484798L));
                } catch (Exception e) {
                    throw e;
                }
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = PlaceComponentResult;
        if (iArr5 != null) {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i3 = 0;
            while (true) {
                if ((i3 < length3 ? '`' : JSONLexer.EOI) != '`') {
                    break;
                }
                int i4 = $10 + 49;
                $11 = i4 % 128;
                int i5 = i4 % 2;
                iArr6[i3] = (int) (iArr5[i3] ^ (-3152031022165484798L));
                i3++;
            }
            int i6 = $11 + 99;
            $10 = i6 % 128;
            int i7 = i6 % 2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, length2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            try {
                cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
                cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                for (int i8 = 0; i8 < 16; i8++) {
                    int i9 = $10 + 19;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i8];
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    int i11 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                    verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                    verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i11;
                }
                int i12 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i12;
                verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
                verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
                int i13 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                int i14 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
                cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
                cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
                cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
                cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
                verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
