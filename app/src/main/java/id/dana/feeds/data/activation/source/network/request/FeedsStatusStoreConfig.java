package id.dana.feeds.data.activation.source.network.request;

import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import o.VerifyPinStateManager$executeRiskChallenge$2$2;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/feeds/data/activation/source/network/request/FeedsStatusStoreConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "Lid/dana/feeds/data/activation/source/network/request/FeedsStatusConfig;", "content", "Lid/dana/feeds/data/activation/source/network/request/FeedsStatusConfig;", "getContent", "()Lid/dana/feeds/data/activation/source/network/request/FeedsStatusConfig;", "<init>", "(Lid/dana/feeds/data/activation/source/network/request/FeedsStatusConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FeedsStatusStoreConfig extends StoreConfig<FeedsStatusConfig> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int PlaceComponentResult;
    private static char[] getAuthRequestContext = {35334, 35756, 35756, 35766, 35766, 35759, 35769, 35771, 35764, 35768, 35765, 35767, 35769, 35769, 35771, 35765, 35764, 35774, 35775, 35768, 35771, 35766, 35762, 35769, 35713, 35774, 35767, 35759, 35756, 35766, 35775, 35773};
    private final FeedsStatusConfig content;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public FeedsStatusStoreConfig(id.dana.feeds.data.activation.source.network.request.FeedsStatusConfig r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            r0 = 4
            int[] r0 = new int[r0]
            r0 = {x002a: FILL_ARRAY_DATA , data: [0, 32, 190, 0} // fill-array
            r1 = 32
            byte[] r1 = new byte[r1]
            r1 = {x0036: FILL_ARRAY_DATA , data: [1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1} // fill-array
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]
            a(r0, r2, r1, r3)
            r0 = 0
            r0 = r3[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.String r1 = "config_friendship_status"
            r4.<init>(r1, r0, r5)
            r4.content = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.feeds.data.activation.source.network.request.FeedsStatusStoreConfig.<init>(id.dana.feeds.data.activation.source.network.request.FeedsStatusConfig):void");
    }

    @JvmName(name = "getContent")
    public final FeedsStatusConfig getContent() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 79;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            FeedsStatusConfig feedsStatusConfig = this.content;
            int i3 = BuiltInFictitiousFunctionClassFactory + 61;
            PlaceComponentResult = i3 % 128;
            if (!(i3 % 2 != 0)) {
                return feedsStatusConfig;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return feedsStatusConfig;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int[] iArr, boolean z, byte[] bArr, Object[] objArr) {
        int i;
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$2 verifyPinStateManager$executeRiskChallenge$2$2 = new VerifyPinStateManager$executeRiskChallenge$2$2();
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = 2;
        int i7 = iArr[2];
        int i8 = iArr[3];
        char[] cArr = getAuthRequestContext;
        if ((cArr != null ? (char) 11 : (char) 20) != 20) {
            int length = cArr.length;
            char[] cArr2 = new char[length];
            int i9 = 0;
            while (true) {
                if ((i9 < length ? ':' : '2') == '2') {
                    break;
                }
                int i10 = $10 + 81;
                $11 = i10 % 128;
                if (i10 % i6 == 0) {
                    i3 = i7;
                    cArr2[i9] = (char) (cArr[i9] | 5097613533456403102L);
                    i9 += 0;
                } else {
                    i3 = i7;
                    cArr2[i9] = (char) (cArr[i9] ^ 5097613533456403102L);
                    i9++;
                }
                i7 = i3;
                i6 = 2;
            }
            i = i7;
            cArr = cArr2;
        } else {
            i = i7;
        }
        char[] cArr3 = new char[i5];
        System.arraycopy(cArr, i4, cArr3, 0, i5);
        if (bArr != null) {
            char[] cArr4 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            char c = 0;
            while (true) {
                if (!(verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5)) {
                    break;
                }
                int i11 = $11 + 83;
                $10 = i11 % 128;
                int i12 = i11 % 2;
                try {
                    if (bArr[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] == 1) {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) + 1) - c);
                    } else {
                        cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) ((cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] * 2) - c);
                    }
                    c = cArr4[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory];
                    verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
                } catch (Exception e) {
                    throw e;
                }
            }
            cArr3 = cArr4;
        }
        if (!(i8 <= 0)) {
            char[] cArr5 = new char[i5];
            System.arraycopy(cArr3, 0, cArr5, 0, i5);
            int i13 = i5 - i8;
            System.arraycopy(cArr5, 0, cArr3, i13, i8);
            System.arraycopy(cArr5, i8, cArr3, 0, i13);
        }
        if (z) {
            char[] cArr6 = new char[i5];
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                int i14 = $10 + 59;
                $11 = i14 % 128;
                int i15 = i14 % 2;
                cArr6[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = cArr3[(i5 - verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory) - 1];
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory++;
            }
            cArr3 = cArr6;
        }
        if (!(i <= 0)) {
            verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = 0;
            while (verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory < i5) {
                int i16 = $11 + 73;
                $10 = i16 % 128;
                if (i16 % 2 != 0) {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] << iArr[2]);
                    i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory % 1;
                } else {
                    cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] = (char) (cArr3[verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory] - iArr[2]);
                    i2 = verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory + 1;
                }
                verifyPinStateManager$executeRiskChallenge$2$2.BuiltInFictitiousFunctionClassFactory = i2;
            }
        }
        objArr[0] = new String(cArr3);
    }
}
