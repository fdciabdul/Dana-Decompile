package id.dana.riskChallenges.ui.verifypin.shared;

/* loaded from: classes5.dex */
public final /* synthetic */ class VerifyPinShared$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ VerifyPinShared PlaceComponentResult;

    public /* synthetic */ VerifyPinShared$$ExternalSyntheticLambda1(VerifyPinShared verifyPinShared) {
        this.PlaceComponentResult = verifyPinShared;
    }

    @Override // java.lang.Runnable
    public final void run() {
        VerifyPinShared.getAuthRequestContext(this.PlaceComponentResult);
    }
}
