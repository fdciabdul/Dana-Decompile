package id.dana.core.ui.util;

import android.app.Activity;
import android.content.Context;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/ContextUtil;", "", "Landroid/content/Context;", "p0", "", "getAuthRequestContext", "(Landroid/content/Context;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ContextUtil {
    public static final ContextUtil INSTANCE = new ContextUtil();

    private ContextUtil() {
    }

    public static boolean getAuthRequestContext(Context p0) {
        if (!(p0 instanceof Activity)) {
            return p0 != null;
        }
        Activity activity = (Activity) p0;
        return (activity.isDestroyed() || activity.isFinishing()) ? false : true;
    }
}
