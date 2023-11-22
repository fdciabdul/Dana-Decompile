package id.dana.data.userconfig.model;

import id.dana.domain.userconfig.model.StoreConfig;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/data/userconfig/model/KtpPopUpStoreConfig;", "Lid/dana/domain/userconfig/model/StoreConfig;", "Lid/dana/data/userconfig/model/KtpPopUpUserConfig;", "content", "Lid/dana/data/userconfig/model/KtpPopUpUserConfig;", "getContent", "()Lid/dana/data/userconfig/model/KtpPopUpUserConfig;", "<init>", "(Lid/dana/data/userconfig/model/KtpPopUpUserConfig;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class KtpPopUpStoreConfig extends StoreConfig<KtpPopUpUserConfig> {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 1;
    private static int getAuthRequestContext;
    private final KtpPopUpUserConfig content;
    private static char[] PlaceComponentResult = {27240, 9212, 63809, 46783, 19495, 1423, 54241, 26992, 9921, 64544, 46468, 17183, 6527, 54993, 27667, 9639, 62235, 35195, 18147, 7252, 54700, 25356, 14488, 63168, 35922, 17872, 4922};
    private static long MyBillsEntityDataFactory = -3983511488116573479L;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KtpPopUpStoreConfig(id.dana.data.userconfig.model.KtpPopUpUserConfig r7) {
        /*
            r6 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r0 = 0
            r1 = 0
            float r2 = android.util.TypedValue.complexToFraction(r0, r1, r1)
            java.lang.String r3 = "show_user_consult_pop_up"
            int r1 = (r2 > r1 ? 1 : (r2 == r1 ? 0 : -1))
            int r2 = android.view.ViewConfiguration.getScrollBarSize()
            int r2 = r2 >> 8
            int r2 = 27 - r2
            r4 = 39232(0x9940, float:5.4976E-41)
            int r5 = android.view.ViewConfiguration.getMaximumDrawingCacheSize()
            int r5 = r5 >> 24
            int r4 = r4 - r5
            char r4 = (char) r4
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            a(r1, r2, r4, r5)
            r0 = r5[r0]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            r6.<init>(r3, r0, r7)
            r6.content = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.userconfig.model.KtpPopUpStoreConfig.<init>(id.dana.data.userconfig.model.KtpPopUpUserConfig):void");
    }

    @JvmName(name = "getContent")
    public final KtpPopUpUserConfig getContent() {
        int i = getAuthRequestContext + 103;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if ((i % 2 == 0 ? (char) 4 : '`') != '`') {
            KtpPopUpUserConfig ktpPopUpUserConfig = this.content;
            Object[] objArr = null;
            int length = objArr.length;
            return ktpPopUpUserConfig;
        }
        return this.content;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'F' : (char) 16) != 'F') {
                break;
            }
            int i3 = $10 + 95;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (PlaceComponentResult[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (whenavailable.BuiltInFictitiousFunctionClassFactory < i2) {
            int i5 = $11 + 41;
            $10 = i5 % 128;
            int i6 = i5 % 2;
            cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i7 = $10 + 41;
            $11 = i7 % 128;
            int i8 = i7 % 2;
        }
        objArr[0] = new String(cArr);
    }
}
