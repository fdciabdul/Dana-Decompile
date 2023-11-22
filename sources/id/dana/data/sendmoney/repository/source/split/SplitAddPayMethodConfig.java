package id.dana.data.sendmoney.repository.source.split;

import com.google.common.base.Ascii;
import id.dana.data.sendmoney.AddPayMethodConfigEntityData;
import id.dana.data.toggle.SplitFacade;
import id.dana.data.toggle.traffictype.BaseTrafficType;
import id.dana.domain.sendmoney.model.AddPayMethod;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import o.B;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0011\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/data/sendmoney/repository/source/split/SplitAddPayMethodConfig;", "Lid/dana/data/sendmoney/AddPayMethodConfigEntityData;", "Lio/reactivex/Observable;", "", "", "Lid/dana/domain/sendmoney/model/AddPayMethod;", "getAddPayMethodConfig", "()Lio/reactivex/Observable;", "Lid/dana/data/toggle/SplitFacade;", "splitFacade", "Lid/dana/data/toggle/SplitFacade;", "<init>", "(Lid/dana/data/toggle/SplitFacade;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SplitAddPayMethodConfig implements AddPayMethodConfigEntityData {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String EMPTY_JSON_ARRAY = "[]";
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static byte[] PlaceComponentResult = null;
    private static short[] getAuthRequestContext = null;
    private static int lookAheadTest = 1;
    private static int scheduleImpl;
    private final SplitFacade splitFacade;

    public static /* synthetic */ Map $r8$lambda$r3I4gUsMIktrpBzp9kDktdmlc_U(BaseTrafficType baseTrafficType) {
        int i = scheduleImpl + 103;
        lookAheadTest = i % 128;
        char c = i % 2 == 0 ? 'L' : 'W';
        Map m1927getAddPayMethodConfig$lambda1 = m1927getAddPayMethodConfig$lambda1(baseTrafficType);
        if (c == 'L') {
            Object[] objArr = null;
            int length = objArr.length;
        }
        return m1927getAddPayMethodConfig$lambda1;
    }

    static {
        BuiltInFictitiousFunctionClassFactory();
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        int i = lookAheadTest + 27;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            return;
        }
        defaultConstructorMarker.hashCode();
    }

    static void BuiltInFictitiousFunctionClassFactory() {
        BuiltInFictitiousFunctionClassFactory = 1257195770;
        MyBillsEntityDataFactory = -19220235;
        PlaceComponentResult = new byte[]{-6, 3, -16, Ascii.DC4, -5, -9, 17, -2, -16, 2, -15, 10, -3, -15, Ascii.GS, -12, Ascii.DC4, -2, 5, 6, 7, -29, 17, -14, -6, 7, 12, -13, 12, -9, -97};
        KClassImpl$Data$declaredNonStaticMembers$2 = -1150063884;
    }

    @Inject
    public SplitAddPayMethodConfig(SplitFacade splitFacade) {
        Intrinsics.checkNotNullParameter(splitFacade, "");
        this.splitFacade = splitFacade;
    }

    @Override // id.dana.data.sendmoney.AddPayMethodConfigEntityData
    public final Observable<Map<String, AddPayMethod>> getAddPayMethodConfig() {
        Observable map = this.splitFacade.KClassImpl$Data$declaredNonStaticMembers$2().map(new Function() { // from class: id.dana.data.sendmoney.repository.source.split.SplitAddPayMethodConfig$$ExternalSyntheticLambda0
            @Override // io.reactivex.functions.Function
            public final Object apply(Object obj) {
                return SplitAddPayMethodConfig.$r8$lambda$r3I4gUsMIktrpBzp9kDktdmlc_U((BaseTrafficType) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "");
        int i = lookAheadTest + 43;
        scheduleImpl = i % 128;
        if (!(i % 2 != 0)) {
            return map;
        }
        Object obj = null;
        obj.hashCode();
        return map;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:35|36|37|38|(2:40|29)|23|24|(3:26|27|28)(1:30)|29) */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
    
        if ((r4 == null ? '2' : 'R') != 'R') goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0070, code lost:
    
        if (r4 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0072, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0073, code lost:
    
        r1 = (java.util.List) new org.json.JSONArray(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0119, code lost:
    
        r4 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:68:0x011c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b8 A[SYNTHETIC] */
    /* renamed from: getAddPayMethodConfig$lambda-1  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.util.Map m1927getAddPayMethodConfig$lambda1(id.dana.data.toggle.traffictype.BaseTrafficType r11) {
        /*
            Method dump skipped, instructions count: 306
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.sendmoney.repository.source.split.SplitAddPayMethodConfig.m1927getAddPayMethodConfig$lambda1(id.dana.data.toggle.traffictype.BaseTrafficType):java.util.Map");
    }

    private static void a(int i, int i2, short s, int i3, byte b, Object[] objArr) {
        int i4;
        B b2 = new B();
        StringBuilder sb = new StringBuilder();
        try {
            int i5 = i2 + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L));
            boolean z = i5 == -1;
            if (z) {
                byte[] bArr = PlaceComponentResult;
                if (bArr != null) {
                    int length = bArr.length;
                    byte[] bArr2 = new byte[length];
                    for (int i6 = 0; i6 < length; i6++) {
                        bArr2[i6] = (byte) (bArr[i6] ^ 3097486228508854431L);
                    }
                    bArr = bArr2;
                }
                if (bArr == null) {
                    i5 = (short) (((short) (getAuthRequestContext[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
                    int i7 = $10 + 71;
                    $11 = i7 % 128;
                    int i8 = i7 % 2;
                } else {
                    int i9 = $10 + 13;
                    $11 = i9 % 128;
                    int i10 = i9 % 2;
                    i5 = (byte) (((byte) (PlaceComponentResult[i + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L))] ^ 3097486228508854431L)) + ((int) (BuiltInFictitiousFunctionClassFactory ^ 3097486228508854431L)));
                }
            }
            if (i5 > 0) {
                int i11 = ((i + i5) - 2) + ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 3097486228508854431L));
                if (z) {
                    int i12 = $10 + 47;
                    $11 = i12 % 128;
                    int i13 = i12 % 2;
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                b2.getAuthRequestContext = i11 + i4;
                b2.MyBillsEntityDataFactory = (char) (i3 + ((int) (MyBillsEntityDataFactory ^ 3097486228508854431L)));
                sb.append(b2.MyBillsEntityDataFactory);
                b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                byte[] bArr3 = PlaceComponentResult;
                if ((bArr3 != null ? 'b' : 'I') == 'b') {
                    int length2 = bArr3.length;
                    byte[] bArr4 = new byte[length2];
                    int i14 = 0;
                    while (true) {
                        if (!(i14 < length2)) {
                            break;
                        }
                        bArr4[i14] = (byte) (bArr3[i14] ^ 3097486228508854431L);
                        i14++;
                    }
                    bArr3 = bArr4;
                }
                boolean z2 = bArr3 != null;
                b2.KClassImpl$Data$declaredNonStaticMembers$2 = 1;
                while (b2.KClassImpl$Data$declaredNonStaticMembers$2 < i5) {
                    if ((z2 ? '\r' : '4') != '\r') {
                        short[] sArr = getAuthRequestContext;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((short) (((short) (sArr[r10] ^ 3097486228508854431L)) + s)) ^ b));
                    } else {
                        byte[] bArr5 = PlaceComponentResult;
                        b2.getAuthRequestContext = b2.getAuthRequestContext - 1;
                        b2.MyBillsEntityDataFactory = (char) (b2.PlaceComponentResult + (((byte) (((byte) (bArr5[r10] ^ 3097486228508854431L)) + s)) ^ b));
                    }
                    sb.append(b2.MyBillsEntityDataFactory);
                    b2.PlaceComponentResult = b2.MyBillsEntityDataFactory;
                    b2.KClassImpl$Data$declaredNonStaticMembers$2++;
                }
            }
            objArr[0] = sb.toString();
        } catch (Exception e) {
            throw e;
        }
    }
}
