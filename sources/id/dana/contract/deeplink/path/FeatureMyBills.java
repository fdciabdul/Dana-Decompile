package id.dana.contract.deeplink.path;

import android.app.Activity;
import android.content.Intent;
import id.dana.mybills.MyBillsActivity;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.E;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\t\b\u0007¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J)\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/contract/deeplink/path/FeatureMyBills;", "", "", "", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/util/Map;)Ljava/lang/String;", "Landroid/app/Activity;", "p1", "", "PlaceComponentResult", "(Landroid/app/Activity;Ljava/util/Map;)V", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class FeatureMyBills {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int KClassImpl$Data$declaredNonStaticMembers$2;
    private static int MyBillsEntityDataFactory;
    private static long PlaceComponentResult;
    private static char getAuthRequestContext;

    /* JADX WARN: Type inference failed for: r1v0, types: [kotlin.jvm.internal.DefaultConstructorMarker] */
    static {
        try {
            KClassImpl$Data$declaredNonStaticMembers$2();
            ?? r1 = 0;
            try {
                INSTANCE = new Companion(r1);
                int i = BuiltInFictitiousFunctionClassFactory + 97;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 != 0 ? 'Q' : (char) 2) != 'Q') {
                    return;
                }
                int length = r1.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext = (char) 13492;
        PlaceComponentResult = 4360990799332652212L;
        MyBillsEntityDataFactory = -1028332502;
    }

    @Inject
    public FeatureMyBills() {
    }

    public static void PlaceComponentResult(Activity p0, Map<String, String> p1) {
        boolean z;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        String str = p1.get("version");
        boolean z2 = false;
        if ((str != null ? '.' : '#') == '#' || !str.equals("1.0")) {
            z = false;
        } else {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 33;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            z = true;
        }
        if (z) {
            p0.startActivity(new Intent(p0, MyBillsActivity.class));
            return;
        }
        if ((str != null ? 'B' : (char) 31) != 31) {
            if (str.equals("2.0")) {
                int i3 = BuiltInFictitiousFunctionClassFactory + 57;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                z2 = true;
            }
        }
        if (z2) {
            Intent className = new Intent("android.intent.action.VIEW").setClassName(p0.getPackageName(), "id.dana.mybills.ui.v2.MyBillsHomeActivity");
            className.putExtra(MyBillsHomeActivity.MY_BILLS_SUBSCRIPTION_LIST_OPEN_TRACKER_SOURCE, KClassImpl$Data$declaredNonStaticMembers$2(p1));
            p0.startActivity(className);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if (r0 != null) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        switch(r0.hashCode()) {
            case -35689810: goto L30;
            case 759553291: goto L24;
            case 1443853438: goto L21;
            case 1982491468: goto L18;
            default: goto L35;
        };
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
    
        if (r0.equals(id.dana.analytics.tracker.TrackerKey.SourceType.BANNER) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0041, code lost:
    
        r13 = new java.lang.Object[1];
        a(new char[]{548, 563, 43153, 62708, 20178, 28780}, new char[]{61419, 55910, 48826, 7004}, (char) ((android.view.ViewConfiguration.getMinimumFlingVelocity() >> 16) + 23742), new char[]{0, 0, 0, 0}, android.graphics.Color.argb(0, 0, 0, 0), r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x006d, code lost:
    
        r1 = new java.lang.Object[1];
        a(new char[]{30371, 48417, 20939, 59606, 12273, 2318, 34347, 8306}, new char[]{5097, 52630, 31158, 23851}, (char) android.text.TextUtils.getCapsMode("", 0, 0), new char[]{0, 0, 0, 0}, android.view.View.MeasureSpec.makeMeasureSpec(0, 0), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x009b, code lost:
    
        if (r0.equals(((java.lang.String) r1[0]).intern()) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x009d, code lost:
    
        return "All Services";
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00a8, code lost:
    
        if (r0.equals("Notification") == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00aa, code lost:
    
        r0 = '0';
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00ad, code lost:
    
        r0 = kotlin.text.Typography.amp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00af, code lost:
    
        if (r0 == '&') goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b1, code lost:
    
        r13 = id.dana.contract.deeplink.path.FeatureMyBills.KClassImpl$Data$declaredNonStaticMembers$2 + 3;
        id.dana.contract.deeplink.path.FeatureMyBills.BuiltInFictitiousFunctionClassFactory = r13 % 128;
        r13 = r13 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        if (r0.equals(id.dana.analytics.tracker.TrackerKey.SourceType.DEEP_LINK) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c4, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c5, code lost:
    
        if (r3 == false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00c8, code lost:
    
        r0 = id.dana.contract.deeplink.path.FeatureMyBills.BuiltInFictitiousFunctionClassFactory + 87;
        id.dana.contract.deeplink.path.FeatureMyBills.KClassImpl$Data$declaredNonStaticMembers$2 = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00da, code lost:
    
        return java.lang.String.valueOf(r13.get("source"));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
    
        return ((java.lang.String) r13[0]).intern();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:?, code lost:
    
        return "Push Notification";
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return id.dana.analytics.tracker.TrackerKey.SourceType.DEEP_LINK;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0020, code lost:
    
        if ((r0 != null ? 0 : 'c') != 0) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String KClassImpl$Data$declaredNonStaticMembers$2(java.util.Map<java.lang.String, java.lang.String> r13) {
        /*
            int r0 = id.dana.contract.deeplink.path.FeatureMyBills.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 75
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeatureMyBills.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
            java.lang.String r1 = "Deep Link"
            java.lang.String r2 = "source"
            r3 = 0
            if (r0 == 0) goto L26
            java.lang.Object r0 = r13.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            r4 = 77
            int r4 = r4 / r3
            if (r0 == 0) goto L1e
            r4 = 0
            goto L20
        L1e:
            r4 = 99
        L20:
            if (r4 == 0) goto L2e
            goto Ld2
        L24:
            r13 = move-exception
            throw r13
        L26:
            java.lang.Object r0 = r13.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto Ld2
        L2e:
            int r4 = r0.hashCode()
            r5 = 1
            r6 = 4
            switch(r4) {
                case -35689810: goto Lbe;
                case 759553291: goto La0;
                case 1443853438: goto L6d;
                case 1982491468: goto L39;
                default: goto L37;
            }
        L37:
            goto Lc8
        L39:
            java.lang.String r1 = "Banner"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ld2
            r13 = 6
            char[] r7 = new char[r13]
            r7 = {x00ee: FILL_ARRAY_DATA , data: [548, 563, -22383, -2828, 20178, 28780} // fill-array
            char[] r8 = new char[r6]
            r8 = {x00f8: FILL_ARRAY_DATA , data: [-4117, -9626, -16710, 7004} // fill-array
            int r13 = android.view.ViewConfiguration.getMinimumFlingVelocity()
            int r13 = r13 >> 16
            int r13 = r13 + 23742
            char r9 = (char) r13
            char[] r10 = new char[r6]
            r10 = {x0100: FILL_ARRAY_DATA , data: [0, 0, 0, 0} // fill-array
            int r11 = android.graphics.Color.argb(r3, r3, r3, r3)
            java.lang.Object[] r13 = new java.lang.Object[r5]
            r12 = r13
            a(r7, r8, r9, r10, r11, r12)
            r13 = r13[r3]
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r1 = r13.intern()
            goto Lda
        L6d:
            r1 = 8
            char[] r7 = new char[r1]
            r7 = {x0108: FILL_ARRAY_DATA , data: [30371, -17119, 20939, -5930, 12273, 2318, -31189, 8306} // fill-array
            char[] r8 = new char[r6]
            r8 = {x0114: FILL_ARRAY_DATA , data: [5097, -12906, 31158, 23851} // fill-array
            java.lang.String r1 = ""
            int r1 = android.text.TextUtils.getCapsMode(r1, r3, r3)
            char r9 = (char) r1
            char[] r10 = new char[r6]
            r10 = {x011c: FILL_ARRAY_DATA , data: [0, 0, 0, 0} // fill-array
            int r11 = android.view.View.MeasureSpec.makeMeasureSpec(r3, r3)
            java.lang.Object[] r1 = new java.lang.Object[r5]
            r12 = r1
            a(r7, r8, r9, r10, r11, r12)
            r1 = r1[r3]
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r1 = r1.intern()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto Ld2
            java.lang.String r1 = "All Services"
            goto Lda
        La0:
            java.lang.String r1 = "Notification"
            boolean r0 = r0.equals(r1)
            r1 = 38
            if (r0 == 0) goto Lad
            r0 = 48
            goto Laf
        Lad:
            r0 = 38
        Laf:
            if (r0 == r1) goto Ld2
            int r13 = id.dana.contract.deeplink.path.FeatureMyBills.KClassImpl$Data$declaredNonStaticMembers$2
            int r13 = r13 + 3
            int r0 = r13 % 128
            id.dana.contract.deeplink.path.FeatureMyBills.BuiltInFictitiousFunctionClassFactory = r0
            int r13 = r13 % 2
            java.lang.String r1 = "Push Notification"
            goto Lda
        Lbe:
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto Lc5
            r3 = 1
        Lc5:
            if (r3 == 0) goto Lda
            goto Ld2
        Lc8:
            int r0 = id.dana.contract.deeplink.path.FeatureMyBills.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            id.dana.contract.deeplink.path.FeatureMyBills.KClassImpl$Data$declaredNonStaticMembers$2 = r1
            int r0 = r0 % 2
        Ld2:
            java.lang.Object r13 = r13.get(r2)
            java.lang.String r1 = java.lang.String.valueOf(r13)
        Lda:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.contract.deeplink.path.FeatureMyBills.KClassImpl$Data$declaredNonStaticMembers$2(java.util.Map):java.lang.String");
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
        while (true) {
            if (!(e.KClassImpl$Data$declaredNonStaticMembers$2 < length3)) {
                break;
            }
            int i2 = $10 + 83;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            int i4 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 2) % 4;
            int i5 = (e.KClassImpl$Data$declaredNonStaticMembers$2 + 3) % 4;
            e.MyBillsEntityDataFactory = (char) (((cArr4[e.KClassImpl$Data$declaredNonStaticMembers$2 % 4] * 32718) + cArr5[i4]) % 65535);
            cArr5[i5] = (char) (((cArr4[i5] * 32718) + cArr5[i4]) / 65535);
            cArr4[i5] = e.MyBillsEntityDataFactory;
            cArr6[e.KClassImpl$Data$declaredNonStaticMembers$2] = (char) ((((cArr4[i5] ^ cArr[e.KClassImpl$Data$declaredNonStaticMembers$2]) ^ (PlaceComponentResult ^ 4360990799332652212L)) ^ ((int) (MyBillsEntityDataFactory ^ 4360990799332652212L))) ^ ((char) (getAuthRequestContext ^ 4360990799332652212L)));
            e.KClassImpl$Data$declaredNonStaticMembers$2++;
        }
        String str = new String(cArr6);
        int i6 = $10 + 89;
        $11 = i6 % 128;
        if (!(i6 % 2 == 0)) {
            objArr[0] = str;
            return;
        }
        Object obj = null;
        obj.hashCode();
        objArr[0] = str;
    }
}
