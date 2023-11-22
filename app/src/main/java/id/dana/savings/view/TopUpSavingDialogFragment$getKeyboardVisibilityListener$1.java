package id.dana.savings.view;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import id.dana.utils.KeyboardHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004"}, d2 = {"Lid/dana/savings/view/TopUpSavingDialogFragment$getKeyboardVisibilityListener$1;", "Lid/dana/utils/KeyboardHelper$KeyboardVisibilityListener;", "", "MyBillsEntityDataFactory", "()V", "KClassImpl$Data$declaredNonStaticMembers$2"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TopUpSavingDialogFragment$getKeyboardVisibilityListener$1 implements KeyboardHelper.KeyboardVisibilityListener {
    final /* synthetic */ TopUpSavingDialogFragment MyBillsEntityDataFactory;

    @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
    public final void MyBillsEntityDataFactory() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TopUpSavingDialogFragment$getKeyboardVisibilityListener$1(TopUpSavingDialogFragment topUpSavingDialogFragment) {
        this.MyBillsEntityDataFactory = topUpSavingDialogFragment;
    }

    @Override // id.dana.utils.KeyboardHelper.KeyboardVisibilityListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        View view;
        view = this.MyBillsEntityDataFactory.bottomSheet;
        final TopUpSavingDialogFragment topUpSavingDialogFragment = this.MyBillsEntityDataFactory;
        view.post(new Runnable() { // from class: id.dana.savings.view.TopUpSavingDialogFragment$getKeyboardVisibilityListener$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                TopUpSavingDialogFragment$getKeyboardVisibilityListener$1.getAuthRequestContext(TopUpSavingDialogFragment.this);
            }
        });
    }

    public static /* synthetic */ void getAuthRequestContext(TopUpSavingDialogFragment topUpSavingDialogFragment) {
        BottomSheetBehavior bottomSheetBehavior;
        Intrinsics.checkNotNullParameter(topUpSavingDialogFragment, "");
        bottomSheetBehavior = topUpSavingDialogFragment.bottomSheetBehavior;
        bottomSheetBehavior.setState(3);
    }
}
