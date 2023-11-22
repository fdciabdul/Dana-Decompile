package id.dana.network.util;

import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/network/util/DanaH5Helper;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "url", "", LogConstants.Mpm.EndNodeType.OPEN_URL, "(Landroid/content/Context;Ljava/lang/String;)V", "PACKAGE_NAVIGATOR_ACTIVITY", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DanaH5Helper {
    public static final DanaH5Helper INSTANCE = new DanaH5Helper();
    private static final String PACKAGE_NAVIGATOR_ACTIVITY = "id.dana.danah5.navigator.DanaH5NavigatorActivity";

    private DanaH5Helper() {
    }

    public final void openUrl(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(url, "");
        try {
            Intent className = new Intent("android.intent.action.VIEW").setClassName(context.getPackageName(), PACKAGE_NAVIGATOR_ACTIVITY);
            Intrinsics.checkNotNullExpressionValue(className, "");
            className.putExtra("url", url);
            context.startActivity(className);
        } catch (Exception e) {
        }
    }
}
