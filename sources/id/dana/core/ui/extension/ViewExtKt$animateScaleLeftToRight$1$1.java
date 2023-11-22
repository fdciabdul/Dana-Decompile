package id.dana.core.ui.extension;

import android.view.View;
import android.view.animation.Animation;
import id.dana.core.ui.util.AnimationUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/core/ui/extension/ViewExtKt$animateScaleLeftToRight$1$1;", "Lid/dana/core/ui/util/AnimationUtil$AnimationListener;", "Landroid/view/animation/Animation;", "p0", "", "onAnimationEnd", "(Landroid/view/animation/Animation;)V", "onAnimationStart"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ViewExtKt$animateScaleLeftToRight$1$1 extends AnimationUtil.AnimationListener {
    final /* synthetic */ int KClassImpl$Data$declaredNonStaticMembers$2;
    final /* synthetic */ boolean MyBillsEntityDataFactory;
    final /* synthetic */ View getAuthRequestContext;

    @Override // id.dana.core.ui.util.AnimationUtil.AnimationListener, android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.setVisibility(this.MyBillsEntityDataFactory ? this.KClassImpl$Data$declaredNonStaticMembers$2 : 0);
    }

    @Override // id.dana.core.ui.util.AnimationUtil.AnimationListener, android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.getAuthRequestContext.setVisibility(this.MyBillsEntityDataFactory ? 0 : this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
