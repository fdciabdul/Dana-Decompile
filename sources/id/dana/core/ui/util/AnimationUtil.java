package id.dana.core.ui.util;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import at.wirecube.additiveanimations.additive_animator.AdditiveAnimator;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/AnimationUtil;", "", "Landroid/view/View;", "p0", "", "PlaceComponentResult", "(Landroid/view/View;)V", "getAuthRequestContext", "<init>", "()V", "AnimationListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AnimationUtil {
    public static final AnimationUtil INSTANCE = new AnimationUtil();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/core/ui/util/AnimationUtil$AnimationListener;", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", DynamicLayerModel.FOR_ANIMATION, "", "onAnimationEnd", "(Landroid/view/animation/Animation;)V", "onAnimationRepeat", "onAnimationStart", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static class AnimationListener implements Animation.AnimationListener {
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation r2) {
            Intrinsics.checkNotNullParameter(r2, "");
        }
    }

    private AnimationUtil() {
    }

    public static void PlaceComponentResult(View p0) {
        ((AdditiveAnimator) AdditiveAnimator.getAuthRequestContext(p0).BuiltInFictitiousFunctionClassFactory(0).MyBillsEntityDataFactory(300L)).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static void getAuthRequestContext(View p0) {
        if (p0 == null) {
            return;
        }
        ((AdditiveAnimator) AdditiveAnimator.getAuthRequestContext(p0).BuiltInFictitiousFunctionClassFactory(8).MyBillsEntityDataFactory(300L)).KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public static /* synthetic */ void getAuthRequestContext(View view, int i, long j, boolean z, final Function0 function0, final Function0 function02, final Function0 function03, int i2) {
        if ((i2 & 4) != 0) {
            z = true;
        }
        if ((i2 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: id.dana.core.ui.util.AnimationUtil$playAnimation$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i2 & 16) != 0) {
            function02 = new Function0<Unit>() { // from class: id.dana.core.ui.util.AnimationUtil$playAnimation$2
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        if ((i2 & 32) != 0) {
            function03 = new Function0<Unit>() { // from class: id.dana.core.ui.util.AnimationUtil$playAnimation$3
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        Intrinsics.checkNotNullParameter(function0, "");
        Intrinsics.checkNotNullParameter(function02, "");
        Intrinsics.checkNotNullParameter(function03, "");
        if (view != null) {
            view.clearAnimation();
            Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i);
            loadAnimation.setFillAfter(z);
            loadAnimation.setDuration(j);
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: id.dana.core.ui.util.AnimationUtil$playAnimation$4$1
                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationStart(Animation p0) {
                    function0.invoke();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationEnd(Animation p0) {
                    function02.invoke();
                }

                @Override // android.view.animation.Animation.AnimationListener
                public final void onAnimationRepeat(Animation p0) {
                    function03.invoke();
                }
            });
            view.setAnimation(loadAnimation);
            view.startAnimation(view.getAnimation());
        }
    }
}
