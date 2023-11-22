package id.dana.utils.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0006J!\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/utils/android/IntentUtil;", "", "", "p0", "Landroid/content/Intent;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Landroid/content/Intent;", "Landroid/net/Uri;", "getAuthRequestContext", "(Landroid/net/Uri;)Landroid/content/Intent;", "Landroid/app/Activity;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)Ljava/lang/String;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/content/Context;", "p1", "", "PlaceComponentResult", "(Landroid/content/Context;Ljava/lang/String;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class IntentUtil {
    public static final IntentUtil INSTANCE = new IntentUtil();

    private IntentUtil() {
    }

    @JvmStatic
    public static final Intent getAuthRequestContext(Uri p0) {
        Intent addFlags = new Intent("android.intent.action.SEND").putExtra("android.intent.extra.STREAM", p0).setType("image/*").addFlags(1);
        Intrinsics.checkNotNullExpressionValue(addFlags, "");
        return addFlags;
    }

    @JvmStatic
    public static final Intent KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intent putExtra = new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", p0);
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        return putExtra;
    }

    @JvmStatic
    public static final Intent MyBillsEntityDataFactory(String p0) {
        Intent putExtra = new Intent("android.intent.action.SENDTO").setType("text/plain").setData(Uri.parse("smsto:")).putExtra("sms_body", p0);
        Intrinsics.checkNotNullExpressionValue(putExtra, "");
        return putExtra;
    }

    @JvmStatic
    public static final boolean PlaceComponentResult(Context p0, String p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        String str = p1;
        if (str == null || str.length() == 0) {
            return false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                p0.getPackageManager().getPackageInfo(p1, PackageManager.PackageInfoFlags.of(0L));
            } else {
                p0.getPackageManager().getPackageInfo(p1, 1);
            }
            return true;
        } catch (PackageManager.NameNotFoundException | RuntimeException unused) {
            return false;
        }
    }

    @JvmStatic
    public static final String BuiltInFictitiousFunctionClassFactory(Activity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intent intent = p0.getIntent();
        String dataString = intent != null ? intent.getDataString() : null;
        return dataString == null ? "" : dataString;
    }
}
