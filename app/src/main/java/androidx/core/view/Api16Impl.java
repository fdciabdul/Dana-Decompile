package androidx.core.view;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Landroidx/core/view/Api16Impl;", "", "Landroid/view/View;", "p0", "Ljava/lang/Runnable;", "p1", "", "p2", "", "PlaceComponentResult", "(Landroid/view/View;Ljava/lang/Runnable;J)V", "<init>", "()V"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes6.dex */
final class Api16Impl {
    public static final Api16Impl INSTANCE = new Api16Impl();

    private Api16Impl() {
    }

    @JvmStatic
    public static final void PlaceComponentResult(View p0, Runnable p1, long p2) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p0.postOnAnimationDelayed(p1, p2);
    }
}
