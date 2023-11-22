package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.promocenter.views.PromoCenterActivity;
import id.dana.promodiscovery.views.PromoDiscoveryActivity;
import kotlin.Metadata;
import o.E;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ:\u0010\t\u001a\u00020\b2\r\u0010\u0004\u001a\t\u0018\u00010\u0002¢\u0006\u0002\b\u00032\u0019\u0010\u0007\u001a\u0015\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\b\u0003H\u0087\u0002¢\u0006\u0004\b\t\u0010\nJ!\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\t\u0010\u000bJ\u0017\u0010\f\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/contract/deeplink/path/FeaturePromoCenter;", "", "Landroid/app/Activity;", "Lorg/jetbrains/annotations/NotNull;", "p0", "", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;Ljava/util/Map;)V", "(Landroid/app/Activity;Ljava/lang/String;)V", "getAuthRequestContext", "(Landroid/app/Activity;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeaturePromoCenter {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = 0;
    public static final FeaturePromoCenter INSTANCE;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int MyBillsEntityDataFactory = 0;
    private static char getAuthRequestContext = 0;
    private static int lookAheadTest = 1;

    static {
        KClassImpl$Data$declaredNonStaticMembers$2();
        INSTANCE = new FeaturePromoCenter();
        int i = lookAheadTest + 93;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext = (char) 13492;
        BuiltInFictitiousFunctionClassFactory = 4360990799332652212L;
        KClassImpl$Data$declaredNonStaticMembers$2 = -1587654280;
    }

    private FeaturePromoCenter() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0086, code lost:
    
        if ((r0 != null) != false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0088, code lost:
    
        r0 = kotlin.text.StringsKt.trim((java.lang.CharSequence) r0).toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0092, code lost:
    
        if (r0 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
    
        r0 = java.lang.Integer.parseInt(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0099, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x004e, code lost:
    
        if (r0 != null) goto L15;
     */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void BuiltInFictitiousFunctionClassFactory(android.app.Activity r14, java.util.Map<java.lang.String, java.lang.String> r15) {
        /*
            int r0 = id.dana.contract.deeplink.path.FeaturePromoCenter.MyBillsEntityDataFactory
            int r0 = r0 + 7
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeaturePromoCenter.lookAheadTest = r1
            r1 = 2
            int r0 = r0 % r1
            r2 = 69
            if (r0 != 0) goto L11
            r0 = 59
            goto L13
        L11:
            r0 = 69
        L13:
            r3 = 20
            r4 = 4
            java.lang.String r5 = ""
            r6 = 1
            r7 = 0
            if (r0 == r2) goto L51
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r5)
            char[] r8 = new char[r3]
            r8 = {x00b8: FILL_ARRAY_DATA , data: [-20709, 8826, -4693, 12491, 20734, 29205, -1429, 6090, -1132, 21415, 2090, -8819, 10113, -14424, -26451, 5530, 24803, 20768, -15234, 4260} // fill-array
            char[] r9 = new char[r4]
            r9 = {x00d0: FILL_ARRAY_DATA , data: [-2373, 2492, 11187, 21346} // fill-array
            int r0 = android.view.View.combineMeasuredStates(r7, r7)
            char r10 = (char) r0
            char[] r11 = new char[r4]
            r11 = {x00d8: FILL_ARRAY_DATA , data: [0, 0, 0, 0} // fill-array
            int r12 = android.view.View.combineMeasuredStates(r7, r6)
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r13 = r0
            a(r8, r9, r10, r11, r12, r13)
            r0 = r0[r7]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.Object r0 = r15.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L99
            goto L88
        L51:
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r5)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r5)
            char[] r8 = new char[r3]
            r8 = {x00e0: FILL_ARRAY_DATA , data: [-20709, 8826, -4693, 12491, 20734, 29205, -1429, 6090, -1132, 21415, 2090, -8819, 10113, -14424, -26451, 5530, 24803, 20768, -15234, 4260} // fill-array
            char[] r9 = new char[r4]
            r9 = {x00f8: FILL_ARRAY_DATA , data: [-2373, 2492, 11187, 21346} // fill-array
            int r0 = android.view.View.combineMeasuredStates(r7, r7)
            char r10 = (char) r0
            char[] r11 = new char[r4]
            r11 = {x0100: FILL_ARRAY_DATA , data: [0, 0, 0, 0} // fill-array
            int r12 = android.view.View.combineMeasuredStates(r7, r7)
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r13 = r0
            a(r8, r9, r10, r11, r12, r13)
            r0 = r0[r7]
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r0 = r0.intern()
            java.lang.Object r0 = r15.get(r0)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L86
            r7 = 1
        L86:
            if (r7 == 0) goto L99
        L88:
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            java.lang.CharSequence r0 = kotlin.text.StringsKt.trim(r0)
            java.lang.String r0 = r0.toString()
            if (r0 == 0) goto L99
            int r0 = java.lang.Integer.parseInt(r0)
            goto L9a
        L99:
            r0 = 1
        L9a:
            if (r0 == r6) goto La2
            if (r0 != r1) goto Lb6
            getAuthRequestContext(r14)
            return
        La2:
            java.lang.String r0 = "categoryId"
            java.lang.Object r15 = r15.get(r0)
            java.lang.String r15 = (java.lang.String) r15
            BuiltInFictitiousFunctionClassFactory(r14, r15)
            int r14 = id.dana.contract.deeplink.path.FeaturePromoCenter.MyBillsEntityDataFactory
            int r14 = r14 + 95
            int r15 = r14 % 128
            id.dana.contract.deeplink.path.FeaturePromoCenter.lookAheadTest = r15
            int r14 = r14 % r1
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeaturePromoCenter.BuiltInFictitiousFunctionClassFactory(android.app.Activity, java.util.Map):void");
    }

    private static void BuiltInFictitiousFunctionClassFactory(Activity p0, String p1) {
        Intent intent = new Intent(p0, PromoCenterActivity.class);
        intent.putExtra("categoryId", p1);
        p0.startActivity(intent);
        try {
            int i = lookAheadTest + 63;
            MyBillsEntityDataFactory = i % 128;
            if ((i % 2 != 0 ? '9' : (char) 11) != '9') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void getAuthRequestContext(Activity p0) {
        int i = MyBillsEntityDataFactory + 11;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            PromoDiscoveryActivity.Companion companion = PromoDiscoveryActivity.INSTANCE;
            try {
                PromoDiscoveryActivity.Companion.getAuthRequestContext(p0);
                int i3 = MyBillsEntityDataFactory + 103;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private static void a(char[] cArr, char[] cArr2, char c, char[] cArr3, int i, Object[] objArr) {
        E e = new E();
        int length = cArr2.length;
        char[] cArr4 = new char[length];
        int length2 = cArr3.length;
        char[] cArr5 = new char[length2];
        System.arraycopy(cArr2, 0, cArr4, 0, length);
        System.arraycopy(cArr3, 0, cArr5, 0, length2);
        cArr4[0] = (char) (cArr4[0] ^ c);
        cArr5[2] = (char) (cArr5[2] + ((char) i));
        int length3 = cArr.length;
        char[] cArr6 = new char[length3];
        e.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
        int i2 = $11 + 35;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (e.KClassImpl$Data$declaredNonStaticMembers$2 < length3) {
            int i4 = $10 + 41;
            $11 = i4 % 128;
            int i5 = i4 % 2;
            int i6 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i7 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i6]) % 65535);
            cArr5[i7] = (char) (((cArr4[i7] * 32718) + cArr5[i6]) / 65535);
            cArr4[i7] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i7] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (BuiltInFictitiousFunctionClassFactory ^ 4360990799332652212L)) ^ ((int) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        String str = new String(cArr6);
        int i8 = $11 + 53;
        $10 = i8 % 128;
        if (!(i8 % 2 != 0)) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
