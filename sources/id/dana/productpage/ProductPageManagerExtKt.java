package id.dana.productpage;

import android.app.Activity;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import id.dana.danah5.DanaH5;
import id.dana.lib.bio.faceauth.exception.DanaBioException;
import id.dana.lib.bio.productpage.OpenPageCallback;
import id.dana.lib.bio.productpage.ProductPageManager;
import id.dana.lib.bio.productpage.common.ConstantsKt;
import id.dana.utils.foundation.logger.log.DanaLog;
import id.dana.utils.foundation.logger.log.DanaLogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o.whenAvailable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/lib/bio/productpage/ProductPageManager;", "Landroid/app/Activity;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/lib/bio/productpage/ProductPageManager;Landroid/app/Activity;)V", "", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/lib/bio/productpage/ProductPageManager;Landroid/app/Activity;Ljava/lang/String;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ProductPageManagerExtKt {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 1;
    private static int PlaceComponentResult;
    private static char[] getAuthRequestContext = {62245, 15943, 27085};
    private static long MyBillsEntityDataFactory = -7723075558075449794L;

    public static final void BuiltInFictitiousFunctionClassFactory(ProductPageManager productPageManager, Activity activity) {
        String userId;
        int i = BuiltInFictitiousFunctionClassFactory + 49;
        PlaceComponentResult = i % 128;
        if ((i % 2 != 0 ? (char) 6 : '/') != 6) {
            Intrinsics.checkNotNullParameter(productPageManager, "");
            Intrinsics.checkNotNullParameter(activity, "");
            userId = UserInfoManager.instance().getUserId();
            if (userId == null) {
                return;
            }
        } else {
            try {
                Intrinsics.checkNotNullParameter(productPageManager, "");
                Intrinsics.checkNotNullParameter(activity, "");
                userId = UserInfoManager.instance().getUserId();
                int i2 = 76 / 0;
                if (userId == null) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        String str = userId;
        productPageManager.MyBillsEntityDataFactory(activity, str, ConstantsKt.PlaceComponentResult(str), null, new OpenPageCallback() { // from class: id.dana.productpage.ProductPageManagerExtKt$openSecurityQuestionPage$1
            @Override // id.dana.lib.bio.productpage.OpenPageCallback
            public final void MyBillsEntityDataFactory(String str2) {
                if (str2 != null) {
                    if (str2.length() > 0) {
                        DanaH5.startContainerFullUrl(str2);
                    }
                }
            }

            @Override // id.dana.lib.bio.productpage.OpenPageCallback
            public final void MyBillsEntityDataFactory(DanaBioException.OpenPageException p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                DanaLog.BuiltInFictitiousFunctionClassFactory(DanaLogConstants.BizType.SECURITY_SETTINGS, DanaLogConstants.ExceptionType.SECURITY_SETTING_QUERY_EXCEPTION, p0.getMessage().length() > 0 ? p0.getMessage() : "open security questions page failed");
            }
        });
        int i3 = BuiltInFictitiousFunctionClassFactory + 53;
        PlaceComponentResult = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x002d, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0045, code lost:
    
        if (r0 == null) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0047, code lost:
    
        r11 = id.dana.productpage.ProductPageManagerExtKt.PlaceComponentResult + 31;
        id.dana.productpage.ProductPageManagerExtKt.BuiltInFictitiousFunctionClassFactory = r11 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0050, code lost:
    
        if ((r11 % 2) != 0) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0052, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0053, code lost:
    
        if (r3 == false) goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0055, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0056, code lost:
    
        r11 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0057, code lost:
    
        r11.hashCode();
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x005d, code lost:
    
        r6 = id.dana.lib.bio.productpage.common.ConstantsKt.MyBillsEntityDataFactory();
        r1 = new java.lang.StringBuilder();
        r1.append("https://m.dana.id");
        r1.append(r13);
        r10 = new java.lang.Object[1];
        a(android.view.MotionEvent.axisFromString("") + 1, android.view.View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (char) (android.media.AudioTrack.getMinVolume() > 0.0f ? 1 : (android.media.AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), r10);
        r7 = ((java.lang.String) r10[0]).intern();
        r1 = r1.toString();
        r10 = new java.lang.Object[1];
        a(android.view.ViewConfiguration.getKeyRepeatTimeout() >> 16, 3 - (android.view.ViewConfiguration.getKeyRepeatDelay() >> 16), (char) ((-1) - android.os.Process.getGidForName("")), r10);
        r11.MyBillsEntityDataFactory(r12, r0, r6, id.dana.lib.bio.productpage.common.ConstantsKt.KClassImpl$Data$declaredNonStaticMembers$2(kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new id.dana.lib.bio.productpage.model.SecuritySettingQueryExtended[]{new id.dana.lib.bio.productpage.model.SecuritySettingQueryExtended("email", "https://m.dana.id/m/portal/emailSettings", "email"), new id.dana.lib.bio.productpage.model.SecuritySettingQueryExtended(r7, r1, ((java.lang.String) r10[0]).intern())})), new id.dana.productpage.ProductPageManagerExtKt$openSecuritySettingPage$1());
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00e1, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.lib.bio.productpage.ProductPageManager r11, android.app.Activity r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.productpage.ProductPageManagerExtKt.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.lib.bio.productpage.ProductPageManager, android.app.Activity, java.lang.String):void");
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        int i3;
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if (!(whenavailable.BuiltInFictitiousFunctionClassFactory < i2)) {
                break;
            }
            jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (getAuthRequestContext[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i4 = $11 + 35;
            $10 = i4 % 128;
            int i5 = i4 % 2;
        }
        char[] cArr = new char[i2];
        try {
            whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
            while (true) {
                try {
                    if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'a' : 'A') == 'A') {
                        objArr[0] = new String(cArr);
                        return;
                    }
                    int i6 = $11 + 47;
                    $10 = i6 % 128;
                    if (i6 % 2 != 0) {
                        cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                        i3 = whenavailable.BuiltInFictitiousFunctionClassFactory >> 0;
                    } else {
                        cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
                        i3 = whenavailable.BuiltInFictitiousFunctionClassFactory + 1;
                    }
                    whenavailable.BuiltInFictitiousFunctionClassFactory = i3;
                } catch (Exception e) {
                    throw e;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
