package id.dana.data.bank.model;

import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import o.D;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0015\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/data/bank/model/StoreBankQrConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "", "Lid/dana/data/bank/model/UserConfigBankQrContent;", "BuiltInFictitiousFunctionClassFactory", "[Lid/dana/data/bank/model/UserConfigBankQrContent;", "p0", "<init>", "([Lid/dana/data/bank/model/UserConfigBankQrContent;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StoreBankQrConfig extends StoreConfig<UserConfigBankQrContent[]> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long PlaceComponentResult = -5127344850563042034L;
    public final UserConfigBankQrContent[] BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public StoreBankQrConfig(id.dana.data.bank.model.UserConfigBankQrContent[] r5) {
        /*
            r4 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            float r0 = android.media.AudioTrack.getMaxVolume()
            r1 = 0
            r2 = 1
            java.lang.String r3 = "user_bank_account_qr"
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            int r0 = 1 - r0
            r1 = 30
            char[] r1 = new char[r1]
            r1 = {x002c: FILL_ARRAY_DATA , data: [28632, 28606, 27676, -11105, 13319, 17834, 31869, -29643, 22203, 18579, 24838, 22702, -22374, 21740, 3210, -22740, -14987, -18622, 10471, -31842, -7723, -27722, 13381, -4148, 7769, -482, -10335, -13712, 14886, -9598} // fill-array
            java.lang.Object[] r2 = new java.lang.Object[r2]
            a(r0, r1, r2)
            r0 = 0
            r0 = r2[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r4.<init>(r3, r0, r5)
            r4.BuiltInFictitiousFunctionClassFactory = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.bank.model.StoreBankQrConfig.<init>(id.dana.data.bank.model.UserConfigBankQrContent[]):void");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        D d = new D();
        char[] KClassImpl$Data$declaredNonStaticMembers$2 = D.KClassImpl$Data$declaredNonStaticMembers$2(PlaceComponentResult ^ 3919452569568103912L, cArr, i);
        d.MyBillsEntityDataFactory = 4;
        while (true) {
            try {
                if (d.MyBillsEntityDataFactory >= KClassImpl$Data$declaredNonStaticMembers$2.length) {
                    break;
                }
                int i2 = $10 + 45;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                d.PlaceComponentResult = d.MyBillsEntityDataFactory - 4;
                KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] = (char) ((KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory] ^ KClassImpl$Data$declaredNonStaticMembers$2[d.MyBillsEntityDataFactory % 4]) ^ (d.PlaceComponentResult * (PlaceComponentResult ^ 3919452569568103912L)));
                d.MyBillsEntityDataFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        String str = new String(KClassImpl$Data$declaredNonStaticMembers$2, 4, KClassImpl$Data$declaredNonStaticMembers$2.length - 4);
        int i4 = $10 + 53;
        $11 = i4 % 128;
        if (!(i4 % 2 == 0)) {
            objArr[0] = str;
            return;
        }
        Object[] objArr2 = null;
        int length = objArr2.length;
        objArr[0] = str;
    }
}
