package at.wirecube.additiveanimations.additive_animator;

/* loaded from: classes3.dex */
public final /* synthetic */ class BaseAdditiveAnimator$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ BaseAdditiveAnimator KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ long PlaceComponentResult;

    public /* synthetic */ BaseAdditiveAnimator$$ExternalSyntheticLambda3(BaseAdditiveAnimator baseAdditiveAnimator, long j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = baseAdditiveAnimator;
        this.PlaceComponentResult = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(this.PlaceComponentResult);
    }
}
