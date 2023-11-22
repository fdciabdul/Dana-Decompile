package at.wirecube.additiveanimations.additive_animator.view_visibility;

import android.view.View;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationAction;
import at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class ViewVisibilityAnimation extends AnimationState<View> {
    private AnimationState.AnimationEndAction<View> BuiltInFictitiousFunctionClassFactory;
    private List<AnimationAction.Animation<View>> MyBillsEntityDataFactory;
    private AnimationState.AnimationStartAction<View> PlaceComponentResult;

    public static ViewVisibilityAnimation PlaceComponentResult() {
        return new ViewVisibilityAnimation(0, Collections.singletonList(new AnimationAction.Animation(View.ALPHA, 1.0f)));
    }

    public static ViewVisibilityAnimation PlaceComponentResult(boolean z) {
        return new ViewVisibilityAnimation(z ? 8 : 4, Collections.singletonList(new AnimationAction.Animation(View.ALPHA, 0.0f)));
    }

    private ViewVisibilityAnimation(int i, List<AnimationAction.Animation<View>> list) {
        if (i == 0) {
            this.PlaceComponentResult = new AnimationState.AnimationStartAction() { // from class: at.wirecube.additiveanimations.additive_animator.view_visibility.ViewVisibilityAnimation$$ExternalSyntheticLambda0
                @Override // at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState.AnimationStartAction
                public final void getAuthRequestContext(Object obj) {
                    ((View) obj).setVisibility(0);
                }
            };
        } else if (i == 4) {
            this.BuiltInFictitiousFunctionClassFactory = new AnimationState.AnimationEndAction() { // from class: at.wirecube.additiveanimations.additive_animator.view_visibility.ViewVisibilityAnimation$$ExternalSyntheticLambda1
                @Override // at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState.AnimationEndAction
                public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                    ((View) obj).setVisibility(4);
                }
            };
        } else if (i == 8) {
            this.BuiltInFictitiousFunctionClassFactory = new AnimationState.AnimationEndAction() { // from class: at.wirecube.additiveanimations.additive_animator.view_visibility.ViewVisibilityAnimation$$ExternalSyntheticLambda2
                @Override // at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState.AnimationEndAction
                public final void BuiltInFictitiousFunctionClassFactory(Object obj) {
                    ((View) obj).setVisibility(8);
                }
            };
        }
        this.MyBillsEntityDataFactory = list;
    }

    @Override // at.wirecube.additiveanimations.additive_animator.animation_set.AnimationAction
    public final List<AnimationAction.Animation<View>> BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState
    public final AnimationState.AnimationEndAction<View> MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    @Override // at.wirecube.additiveanimations.additive_animator.animation_set.AnimationState
    public final AnimationState.AnimationStartAction<View> KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
