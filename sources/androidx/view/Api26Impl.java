package androidx.view;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/activity/Api26Impl;", "", "Landroid/app/Activity;", "p0", "Landroid/graphics/Rect;", "p1", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroid/app/Activity;Landroid/graphics/Rect;)V", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Api26Impl {
    public static final Api26Impl INSTANCE = new Api26Impl();

    private Api26Impl() {
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Activity p0, Rect p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        p0.setPictureInPictureParams(new PictureInPictureParams.Builder().setSourceRectHint(p1).build());
    }
}
