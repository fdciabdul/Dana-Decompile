package androidx.core.animation;

import android.animation.Animator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006¸\u0006\n"}, d2 = {"Landroidx/core/animation/AnimatorKt$addListener$listener$1;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "p0", "", "onAnimationCancel", "(Landroid/animation/Animator;)V", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "androidx/core/animation/AnimatorKt$addListener$listener$1"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes3.dex */
public final class AnimatorKt$doOnRepeat$$inlined$addListener$default$1 implements Animator.AnimatorListener {
    final /* synthetic */ Function1 KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2.invoke(p0);
    }
}
