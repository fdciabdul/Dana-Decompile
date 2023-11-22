package at.wirecube.additiveanimations.additive_animator;

/* loaded from: classes3.dex */
public final /* synthetic */ class BaseAdditiveAnimator$$ExternalSyntheticLambda8 implements Runnable {
    public final /* synthetic */ BaseAdditiveAnimator KClassImpl$Data$declaredNonStaticMembers$2;
    public final /* synthetic */ int PlaceComponentResult;

    public /* synthetic */ BaseAdditiveAnimator$$ExternalSyntheticLambda8(BaseAdditiveAnimator baseAdditiveAnimator, int i) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = baseAdditiveAnimator;
        this.PlaceComponentResult = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(this.PlaceComponentResult);
    }
}
