package id.dana.animation.tab;

import androidx.fragment.app.Fragment;
import id.dana.wallet_v3.listener.WalletTabListener;
import id.dana.wallet_v3.view.NewWalletFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0003\u0010\fR\u0014\u0010\u0003\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f"}, d2 = {"Lid/dana/home/tab/WalletFragmentManager;", "", "", "MyBillsEntityDataFactory", "()V", "Lid/dana/wallet_v3/listener/WalletTabListener;", "p0", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/wallet_v3/listener/WalletTabListener;)V", "", "", "p1", "(Ljava/lang/String;I)V", "Landroidx/fragment/app/Fragment;", "PlaceComponentResult", "Landroidx/fragment/app/Fragment;", "<init>", "(Landroidx/fragment/app/Fragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WalletFragmentManager {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    public final Fragment MyBillsEntityDataFactory;

    public WalletFragmentManager(Fragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "");
        this.MyBillsEntityDataFactory = fragment;
    }

    public final void MyBillsEntityDataFactory() {
        Fragment fragment = this.MyBillsEntityDataFactory;
        NewWalletFragment newWalletFragment = fragment instanceof NewWalletFragment ? (NewWalletFragment) fragment : null;
        if (newWalletFragment != null) {
            newWalletFragment.onSelected();
        }
        if (newWalletFragment != null) {
            newWalletFragment.setSkipLoadData(true);
        }
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(WalletTabListener p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Fragment fragment = this.MyBillsEntityDataFactory;
        NewWalletFragment newWalletFragment = fragment instanceof NewWalletFragment ? (NewWalletFragment) fragment : null;
        if (newWalletFragment != null) {
            newWalletFragment.setWalletTabListener(p0);
        }
    }

    public final void MyBillsEntityDataFactory(String p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        Fragment fragment = this.MyBillsEntityDataFactory;
        NewWalletFragment newWalletFragment = fragment instanceof NewWalletFragment ? (NewWalletFragment) fragment : null;
        if (newWalletFragment != null) {
            newWalletFragment.trackWalletOpen(p0, p1);
        }
    }
}
