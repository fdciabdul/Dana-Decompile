package id.dana.data.geocode.repository.config.split;

import id.dana.data.geocode.model.GeocodeReverseConfigResult;
import id.dana.data.geocode.repository.config.GeocodeConfigEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.C;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/data/geocode/repository/config/split/SplitGeocodeConfigEntityData;", "Lid/dana/data/geocode/repository/config/GeocodeConfigEntityData;", "Lio/reactivex/Observable;", "Lid/dana/data/geocode/model/GeocodeReverseConfigResult;", "getGeocodeReverseConfig", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitGeocodeConfigEntityData implements GeocodeConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char BuiltInFictitiousFunctionClassFactory = 22790;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 11952;
    private static char MyBillsEntityDataFactory = 34164;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda0 = 1;
    private static int PlaceComponentResult = 0;
    private static char getAuthRequestContext = 54500;
    private final SplitFacade splitFacade;

    public static /* synthetic */ GeocodeReverseConfigResult $r8$lambda$o__5IS4IOgf1CpZkXWfmuzZJN7Q(BaseTrafficType baseTrafficType) {
        int i = PlaceComponentResult + 17;
        NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
        boolean z = i % 2 != 0;
        GeocodeReverseConfigResult m1295getGeocodeReverseConfig$lambda0 = m1295getGeocodeReverseConfig$lambda0(baseTrafficType);
        if (!z) {
            int i2 = 9 / 0;
        }
        return m1295getGeocodeReverseConfig$lambda0;
    }

    @Inject
    public SplitGeocodeConfigEntityData(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.geocode.repository.config.GeocodeConfigEntityData
    public final Observable<GeocodeReverseConfigResult> getGeocodeReverseConfig() {
        Observable map = this.splitFacade.PlaceComponentResult().map(new Function() { // from class: id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitGeocodeConfigEntityData.$r8$lambda$o__5IS4IOgf1CpZkXWfmuzZJN7Q((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        try {
            int i = PlaceComponentResult + 37;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda0 = i % 128;
                if (!(i % 2 == 0)) {
                    return map;
                }
                int i2 = 53 / 0;
                return map;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x007b, code lost:
    
        if (r9 == null) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0085, code lost:
    
        if ((r9 == null) != false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0087, code lost:
    
        r9 = id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.PlaceComponentResult + 65;
        id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r9 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0091, code lost:
    
        if ((r9 % 2) != 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0093, code lost:
    
        r1 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0094, code lost:
    
        if (r1 == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0096, code lost:
    
        r5.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009c, code lost:
    
        r0 = r9;
     */
    /* renamed from: getGeocodeReverseConfig$lambda-0  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final id.dana.data.geocode.model.GeocodeReverseConfigResult m1295getGeocodeReverseConfig$lambda0(id.dana.data.toggle.traffictype.BaseTrafficType r9) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            id.dana.data.geocode.model.GeocodeReverseConfigResult r8 = new id.dana.data.geocode.model.GeocodeReverseConfigResult
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 7
            r7 = 0
            r1 = r8
            r1.<init>(r2, r3, r5, r6, r7)
            r1 = 0
            int r2 = android.text.TextUtils.indexOf(r0, r0, r1, r1)
            r3 = 22
            int r2 = r2 + r3
            char[] r3 = new char[r3]
            r3 = {x00a8: FILL_ARRAY_DATA , data: [31032, -20375, -7229, 6525, 3301, 4173, -17066, 15690, 30235, 18580, 13438, -31975, 17176, 24837, -17066, 15690, -14082, 20919, 573, 2928, -32291, -1543} // fill-array
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            a(r2, r3, r5)
            r2 = r5[r1]
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r2 = r2.intern()
            java.lang.String r9 = r9.getAuthRequestContext(r2, r1)
            java.lang.Class<id.dana.data.geocode.model.GeocodeReverseConfigResult> r2 = id.dana.data.geocode.model.GeocodeReverseConfigResult.class
            java.lang.Class<org.json.JSONArray> r3 = org.json.JSONArray.class
            boolean r2 = r2.isAssignableFrom(r3)
            r3 = 42
            if (r2 == 0) goto L3f
            r2 = 42
            goto L41
        L3f:
            r2 = 12
        L41:
            r5 = 0
            if (r2 == r3) goto L6c
            if (r9 == 0) goto L49
            r0 = 83
            goto L4b
        L49:
            r0 = 42
        L4b:
            if (r0 == r3) goto La5
            int r0 = id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0
            int r0 = r0 + 41
            int r1 = r0 % 128
            id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.PlaceComponentResult = r1
            int r0 = r0 % 2
            com.google.gson.Gson r0 = id.dana.utils.extension.JSONExtKt.PlaceComponentResult()     // Catch: java.lang.Exception -> L66
            java.lang.String r9 = id.dana.utils.extension.JSONExtKt.KClassImpl$Data$declaredNonStaticMembers$2(r9, r5)     // Catch: java.lang.Exception -> L66
            java.lang.Class<id.dana.data.geocode.model.GeocodeReverseConfigResult> r1 = id.dana.data.geocode.model.GeocodeReverseConfigResult.class
            java.lang.Object r5 = r0.fromJson(r9, r1)     // Catch: java.lang.Exception -> L66
            goto L67
        L66:
        L67:
            if (r5 != 0) goto L6a
            goto La5
        L6a:
            r8 = r5
            goto La5
        L6c:
            int r2 = id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.PlaceComponentResult
            int r2 = r2 + 45
            int r3 = r2 % 128
            id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r3
            int r2 = r2 % 2
            if (r2 != 0) goto L80
            r5.hashCode()     // Catch: java.lang.Throwable -> L7e
            if (r9 != 0) goto L9c
            goto L87
        L7e:
            r9 = move-exception
            throw r9
        L80:
            if (r9 != 0) goto L84
            r2 = 1
            goto L85
        L84:
            r2 = 0
        L85:
            if (r2 == 0) goto L9c
        L87:
            int r9 = id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.PlaceComponentResult
            int r9 = r9 + 65
            int r2 = r9 % 128
            id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.NetworkUserEntityData$$ExternalSyntheticLambda0 = r2
            int r9 = r9 % 2
            if (r9 != 0) goto L94
            r1 = 1
        L94:
            if (r1 == 0) goto L9d
            r5.hashCode()     // Catch: java.lang.Throwable -> L9a
            goto L9d
        L9a:
            r9 = move-exception
            throw r9
        L9c:
            r0 = r9
        L9d:
            org.json.JSONArray r9 = new org.json.JSONArray
            r9.<init>(r0)
            r8 = r9
            id.dana.data.geocode.model.GeocodeReverseConfigResult r8 = (id.dana.data.geocode.model.GeocodeReverseConfigResult) r8
        La5:
            id.dana.data.geocode.model.GeocodeReverseConfigResult r8 = (id.dana.data.geocode.model.GeocodeReverseConfigResult) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.geocode.repository.config.split.SplitGeocodeConfigEntityData.m1295getGeocodeReverseConfig$lambda0(id.dana.data.toggle.traffictype.BaseTrafficType):id.dana.data.geocode.model.GeocodeReverseConfigResult");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $11 + 117;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if (!(c.BuiltInFictitiousFunctionClassFactory >= cArr.length)) {
                int i4 = $11 + 41;
                $10 = i4 % 128;
                int i5 = i4 % 2;
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i6 = 58224;
                for (int i7 = 0; i7 < 16; i7++) {
                    int i8 = $10 + 25;
                    $11 = i8 % 128;
                    int i9 = i8 % 2;
                    cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i6) ^ ((cArr3[0] << 4) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))));
                    cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i6) ^ ((cArr3[1] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (BuiltInFictitiousFunctionClassFactory ^ 6353485791441662354L)))));
                    i6 -= 40503;
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
