package id.dana.cardbinding.view;

import id.dana.cardbinding.view.DisclaimerView;
import io.reactivex.subjects.Subject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/cardbinding/view/BottomSheetCardBindingView$initDisclaimerView$1;", "Lid/dana/cardbinding/view/DisclaimerView$OnCheckboxListener;", "", "p0", "", "PlaceComponentResult", "(Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class BottomSheetCardBindingView$initDisclaimerView$1 implements DisclaimerView.OnCheckboxListener {
    final /* synthetic */ BottomSheetCardBindingView MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BottomSheetCardBindingView$initDisclaimerView$1(BottomSheetCardBindingView bottomSheetCardBindingView) {
        this.MyBillsEntityDataFactory = bottomSheetCardBindingView;
    }

    @Override // id.dana.cardbinding.view.DisclaimerView.OnCheckboxListener
    public final void PlaceComponentResult(boolean p0) {
        Subject subject;
        Subject subject2;
        subject = this.MyBillsEntityDataFactory.GetContactSyncConfig;
        subject.onNext(Boolean.valueOf(p0));
        subject2 = this.MyBillsEntityDataFactory.NetworkUserEntityData$$ExternalSyntheticLambda2;
        subject2.onNext(Boolean.valueOf(p0));
    }
}
