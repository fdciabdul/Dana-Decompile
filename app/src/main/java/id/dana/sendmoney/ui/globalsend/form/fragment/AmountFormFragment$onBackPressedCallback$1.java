package id.dana.sendmoney.ui.globalsend.form.fragment;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.view.OnBackPressedCallback;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.sendmoney.ui.globalsend.form.GlobalSendFormActivity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment$onBackPressedCallback$1;", "Landroidx/activity/OnBackPressedCallback;", "", "handleOnBackPressed", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AmountFormFragment$onBackPressedCallback$1 extends OnBackPressedCallback {
    final /* synthetic */ AmountFormFragment KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AmountFormFragment$onBackPressedCallback$1(AmountFormFragment amountFormFragment) {
        super(true);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = amountFormFragment;
    }

    @Override // androidx.view.OnBackPressedCallback
    public final void handleOnBackPressed() {
        if (isEnabled()) {
            BottomSheetBehavior<View> bottomSheetBehavior = this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult;
            if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 3) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(false);
                return;
            }
            setEnabled(false);
            FragmentActivity activity = this.KClassImpl$Data$declaredNonStaticMembers$2.getActivity();
            GlobalSendFormActivity globalSendFormActivity = activity instanceof GlobalSendFormActivity ? (GlobalSendFormActivity) activity : null;
            if (globalSendFormActivity != null && globalSendFormActivity.getIsNewTransaction()) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.requireActivity().setResult(-1);
            }
            this.KClassImpl$Data$declaredNonStaticMembers$2.requireActivity().finish();
        }
    }
}
