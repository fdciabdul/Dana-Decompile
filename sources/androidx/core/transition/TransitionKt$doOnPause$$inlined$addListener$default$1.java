package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006¸\u0006\u000b"}, d2 = {"Landroidx/core/transition/TransitionKt$addListener$listener$1;", "Landroid/transition/Transition$TransitionListener;", "Landroid/transition/Transition;", "p0", "", "onTransitionCancel", "(Landroid/transition/Transition;)V", "onTransitionEnd", "onTransitionPause", "onTransitionResume", "onTransitionStart", "androidx/core/transition/TransitionKt$addListener$listener$1"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* loaded from: classes6.dex */
public final class TransitionKt$doOnPause$$inlined$addListener$default$1 implements Transition.TransitionListener {
    final /* synthetic */ Function1 MyBillsEntityDataFactory;

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition p0) {
        Intrinsics.checkNotNullParameter(p0, "");
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        this.MyBillsEntityDataFactory.invoke(p0);
    }
}
