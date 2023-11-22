package id.dana.lib.gcontainer.extension;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import com.alibaba.griver.core.jsapi.device.location.RequestPermission;
import com.ap.zoloz.hummer.biz.HummerConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u001b\u0010\u0004\u001a\u00020\u0003*\u0004\u0018\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a!\u0010\n\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a\u0019\u0010\f\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\t\u001a\u00020\u0000¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Landroid/content/Intent;", "Landroid/content/Context;", HummerConstants.CONTEXT, "", "hasActivityHandler", "(Landroid/content/Intent;Landroid/content/Context;)Z", "Landroid/app/Activity;", "", RequestPermission.REQUEST_CODE, "intent", "startActivityForResultSafely", "(Landroid/app/Activity;ILandroid/content/Intent;)Z", "startActivitySafely", "(Landroid/content/Context;Landroid/content/Intent;)Z"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ContentExtKt {
    public static final boolean hasActivityHandler(Intent intent, Context context) {
        Intrinsics.checkNotNullParameter(context, "");
        return (intent == null ? null : intent.resolveActivity(context.getPackageManager())) != null;
    }

    public static final boolean startActivitySafely(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(intent, "");
        try {
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public static final boolean startActivityForResultSafely(Activity activity, int i, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(intent, "");
        try {
            activity.startActivityForResult(intent, i);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }
}
