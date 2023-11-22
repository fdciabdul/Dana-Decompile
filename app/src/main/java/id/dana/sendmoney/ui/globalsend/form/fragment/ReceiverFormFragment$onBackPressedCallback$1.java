package id.dana.sendmoney.ui.globalsend.form.fragment;

import androidx.view.OnBackPressedCallback;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment$onBackPressedCallback$1;", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ReceiverFormFragment$onBackPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ ReceiverFormFragment getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReceiverFormFragment$onBackPressedCallback$1(ReceiverFormFragment receiverFormFragment) {
        super(true);
        this.getAuthRequestContext = receiverFormFragment;
    }

    @Override // androidx.view.OnBackPressedCallback
    public final void handleOnBackPressed() {
        boolean z;
        if (isEnabled()) {
            z = this.getAuthRequestContext.getErrorConfigVersion;
            if (z) {
                setEnabled(false);
                this.getAuthRequestContext.requireActivity().getOnBackPressedDispatcher().KClassImpl$Data$declaredNonStaticMembers$2();
                return;
            }
            ReceiverFormFragment.moveToNextValue(this.getAuthRequestContext).show();
        }
    }
}
