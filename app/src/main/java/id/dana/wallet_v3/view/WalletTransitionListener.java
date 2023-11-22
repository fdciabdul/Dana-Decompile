package id.dana.wallet_v3.view;

import androidx.constraintlayout.motion.widget.MotionLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u001a\u0010\u000b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\"\u0010\r\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J*\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/wallet_v3/view/WalletTransitionListener;", "Landroidx/constraintlayout/motion/widget/MotionLayout$TransitionListener;", "onTransitionChange", "", "motionLayout", "Landroidx/constraintlayout/motion/widget/MotionLayout;", "startId", "", "endId", "progress", "", "onTransitionCompleted", "currentId", "onTransitionStarted", "onTransitionTrigger", "triggerId", "positive", "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface WalletTransitionListener extends MotionLayout.TransitionListener {

    /* renamed from: id.dana.wallet_v3.view.WalletTransitionListener$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static void $default$onTransitionChange(WalletTransitionListener walletTransitionListener, MotionLayout motionLayout, int i, int i2, float f) {
        }

        public static void $default$onTransitionCompleted(WalletTransitionListener walletTransitionListener, MotionLayout motionLayout, int i) {
        }

        public static void $default$onTransitionStarted(WalletTransitionListener walletTransitionListener, MotionLayout motionLayout, int i, int i2) {
        }

        public static void $default$onTransitionTrigger(WalletTransitionListener walletTransitionListener, MotionLayout motionLayout, int i, boolean z, float f) {
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    void onTransitionChange(MotionLayout motionLayout, int startId, int endId, float progress);

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    void onTransitionCompleted(MotionLayout motionLayout, int currentId);

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    void onTransitionStarted(MotionLayout motionLayout, int startId, int endId);

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    void onTransitionTrigger(MotionLayout motionLayout, int triggerId, boolean positive, float progress);
}
