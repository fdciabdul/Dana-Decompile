package id.dana.core.ui.util;

import android.app.Activity;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lid/dana/core/ui/util/ImageResizeUtil;", "", "Landroid/app/Activity;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Landroid/app/Activity;)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ImageResizeUtil {
    public static final ImageResizeUtil INSTANCE = new ImageResizeUtil();

    private ImageResizeUtil() {
    }

    public static int BuiltInFictitiousFunctionClassFactory(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManagerUtil windowManagerUtil = WindowManagerUtil.INSTANCE;
        WindowManagerUtil.MyBillsEntityDataFactory(activity, displayMetrics);
        return (int) Math.ceil(displayMetrics.density * 56.0f);
    }
}
