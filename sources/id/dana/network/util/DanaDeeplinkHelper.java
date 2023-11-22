package id.dana.network.util;

import android.content.Context;
import android.content.Intent;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.iap.ac.android.biz.common.utils.log.LogConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ%\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\u000b"}, d2 = {"Lid/dana/network/util/DanaDeeplinkHelper;", "", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "url", "source", "", LogConstants.Mpm.EndNodeType.OPEN_URL, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "DEEPLINK_SOURCE", "Ljava/lang/String;", "DEEPLINK_URL", "PACKAGE_DEEPLINK_NAVIGATOR_ACTIVITY", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DanaDeeplinkHelper {
    public static final String DEEPLINK_SOURCE = "source";
    public static final String DEEPLINK_URL = "url";
    public static final DanaDeeplinkHelper INSTANCE = new DanaDeeplinkHelper();
    private static final String PACKAGE_DEEPLINK_NAVIGATOR_ACTIVITY = "id.dana.deeplink.DeeplinkNavigatorActivity";

    private DanaDeeplinkHelper() {
    }

    public final void openUrl(Context context, String url, String source) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(source, "");
        try {
            Intent className = new Intent("android.intent.action.VIEW").setClassName(context.getPackageName(), PACKAGE_DEEPLINK_NAVIGATOR_ACTIVITY);
            Intrinsics.checkNotNullExpressionValue(className, "");
            className.putExtra("url", url);
            className.putExtra("source", source);
            context.startActivity(className);
        } catch (Exception e) {
        }
    }
}
