package id.dana.wallet_v3.view;

import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.core.widget.NestedScrollView;
import id.dana.databinding.FragmentNewWalletBinding;
import id.dana.wallet_v3.view.WalletTransitionListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J)\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/wallet_v3/view/NewWalletFragment$openWalletVoucherAndTicketSection$2;", "Lid/dana/wallet_v3/view/WalletTransitionListener;", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "motionLayout", "", "startId", "endId", "", "onTransitionStarted", "(Landroidx/constraintlayout/motion/widget/MotionLayout;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NewWalletFragment$openWalletVoucherAndTicketSection$2 implements WalletTransitionListener {
    final /* synthetic */ NewWalletFragment this$0;

    @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final /* synthetic */ void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
        WalletTransitionListener.CC.$default$onTransitionChange(this, motionLayout, i, i2, f);
    }

    @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final /* synthetic */ void onTransitionCompleted(MotionLayout motionLayout, int i) {
        WalletTransitionListener.CC.$default$onTransitionCompleted(this, motionLayout, i);
    }

    @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final /* synthetic */ void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
        WalletTransitionListener.CC.$default$onTransitionTrigger(this, motionLayout, i, z, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public NewWalletFragment$openWalletVoucherAndTicketSection$2(NewWalletFragment newWalletFragment) {
        this.this$0 = newWalletFragment;
    }

    @Override // id.dana.wallet_v3.view.WalletTransitionListener, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public final void onTransitionStarted(MotionLayout motionLayout, int startId, int endId) {
        NestedScrollView nestedScrollView;
        FragmentNewWalletBinding access$getBinding = NewWalletFragment.access$getBinding(this.this$0);
        if (access$getBinding != null && (nestedScrollView = access$getBinding.f8082a) != null) {
            final NewWalletFragment newWalletFragment = this.this$0;
            nestedScrollView.postDelayed(new Runnable() { // from class: id.dana.wallet_v3.view.NewWalletFragment$openWalletVoucherAndTicketSection$2$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    NewWalletFragment$openWalletVoucherAndTicketSection$2.m3097onTransitionStarted$lambda0(NewWalletFragment.this);
                }
            }, 50L);
        }
        NewWalletFragment.access$setFullyExpanded(this.this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onTransitionStarted$lambda-0  reason: not valid java name */
    public static final void m3097onTransitionStarted$lambda0(NewWalletFragment newWalletFragment) {
        NestedScrollView nestedScrollView;
        Intrinsics.checkNotNullParameter(newWalletFragment, "");
        FragmentNewWalletBinding access$getBinding = NewWalletFragment.access$getBinding(newWalletFragment);
        if (access$getBinding == null || (nestedScrollView = access$getBinding.f8082a) == null) {
            return;
        }
        nestedScrollView.smoothScrollTo(0, 0, 100);
    }
}
