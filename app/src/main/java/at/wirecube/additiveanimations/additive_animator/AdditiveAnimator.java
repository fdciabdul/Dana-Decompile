package at.wirecube.additiveanimations.additive_animator;

import android.view.View;

/* loaded from: classes3.dex */
public final class AdditiveAnimator extends SubclassableAdditiveViewAnimator<AdditiveAnimator> {
    public static AdditiveAnimator getAuthRequestContext(View view) {
        return new AdditiveAnimator(view);
    }

    private AdditiveAnimator(View view) {
        BuiltInFictitiousFunctionClassFactory(view);
    }

    public AdditiveAnimator() {
    }

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    protected final /* synthetic */ BaseAdditiveAnimator getAuthRequestContext() {
        return new AdditiveAnimator();
    }
}
