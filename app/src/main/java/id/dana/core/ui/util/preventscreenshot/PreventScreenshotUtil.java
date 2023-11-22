package id.dana.core.ui.util.preventscreenshot;

import android.app.Activity;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\n\u0010\t"}, d2 = {"Lid/dana/core/ui/util/preventscreenshot/PreventScreenshotUtil;", "", "Landroid/app/Activity;", "p0", "", "", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Ljava/util/List;)V", "getAuthRequestContext", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PreventScreenshotUtil {
    public static final PreventScreenshotUtil INSTANCE = new PreventScreenshotUtil();

    private PreventScreenshotUtil() {
    }

    public static void getAuthRequestContext(Activity p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (CollectionsKt.contains(p1, Reflection.getOrCreateKotlinClass(p0.getClass()).getSimpleName())) {
            p0.getWindow().setFlags(8192, 8192);
        }
    }

    public static void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, List<String> p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        if (CollectionsKt.contains(p1, Reflection.getOrCreateKotlinClass(p0.getClass()).getSimpleName())) {
            p0.getWindow().clearFlags(8192);
        }
    }
}
