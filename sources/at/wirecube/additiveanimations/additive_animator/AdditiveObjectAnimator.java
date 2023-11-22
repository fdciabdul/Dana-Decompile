package at.wirecube.additiveanimations.additive_animator;

/* loaded from: classes6.dex */
public class AdditiveObjectAnimator<V> extends BaseAdditiveAnimator<AdditiveObjectAnimator<V>, V> {
    private Runnable NetworkUserEntityData$$ExternalSyntheticLambda0 = null;

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final Float MyBillsEntityDataFactory() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final /* bridge */ /* synthetic */ BaseAdditiveAnimator MyBillsEntityDataFactory(BaseAdditiveAnimator baseAdditiveAnimator) {
        AdditiveObjectAnimator additiveObjectAnimator = (AdditiveObjectAnimator) super.MyBillsEntityDataFactory((AdditiveObjectAnimator) baseAdditiveAnimator);
        additiveObjectAnimator.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        return additiveObjectAnimator;
    }

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    public final void PlaceComponentResult() {
        Runnable runnable = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // at.wirecube.additiveanimations.additive_animator.BaseAdditiveAnimator
    protected final /* synthetic */ BaseAdditiveAnimator getAuthRequestContext() {
        return new AdditiveObjectAnimator();
    }
}
