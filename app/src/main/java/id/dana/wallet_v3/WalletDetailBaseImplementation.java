package id.dana.wallet_v3;

import android.app.Activity;
import android.net.Uri;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.animation.HomeTabActivity;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import id.dana.wallet_v3.identity.view.IdentityWalletDetailFragment;
import id.dana.wallet_v3.investment.view.InvestmentWalletDetailFragment;
import id.dana.wallet_v3.listener.WalletDetailBaseFunction;
import id.dana.wallet_v3.loyalty.view.LoyaltyWalletDetailFragment;
import id.dana.wallet_v3.payment.view.PaymentWalletDetailFragment;
import id.dana.wallet_v3.view.NewWalletFragment;
import id.dana.wallet_v3.vouchersandtickets.view.VouchersAndTicketsDetailFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018"}, d2 = {"Lid/dana/wallet_v3/WalletDetailBaseImplementation;", "Lid/dana/wallet_v3/listener/WalletDetailBaseFunction;", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "tag", "", "backFromSearch", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", HomeTabActivity.WALLET_SECTION, "backToMainPage", "(Landroidx/recyclerview/widget/RecyclerView;Landroidx/fragment/app/FragmentManager;I)V", "backToNewWalletFragment", "(Landroidx/fragment/app/FragmentManager;I)V", "Lid/dana/wallet_v3/view/NewWalletFragment;", "getWalletFragment", "(Landroidx/fragment/app/FragmentManager;)Lid/dana/wallet_v3/view/NewWalletFragment;", "Landroid/app/Activity;", AkuEventParamsKey.KEY_ACTIVITY, "", "isFromDeeplinkWallet", "(Landroid/app/Activity;)Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WalletDetailBaseImplementation implements WalletDetailBaseFunction {
    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backToMainPage(RecyclerView recyclerView, final FragmentManager fragmentManager, final int r6) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager != null && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) {
            backToNewWalletFragment(fragmentManager, r6);
            return;
        }
        if (recyclerView != null) {
            recyclerView.smoothScrollToPosition(0);
        }
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: id.dana.wallet_v3.WalletDetailBaseImplementation$backToMainPage$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public final void onScrollStateChanged(RecyclerView recyclerView2, int newState) {
                    Intrinsics.checkNotNullParameter(recyclerView2, "");
                    super.onScrollStateChanged(recyclerView2, newState);
                    if (newState == 0) {
                        WalletDetailBaseImplementation.this.backToNewWalletFragment(fragmentManager, r6);
                        recyclerView2.removeOnScrollListener(this);
                    }
                }
            });
        }
    }

    public final void backToNewWalletFragment(FragmentManager fragmentManager, int r4) {
        fragmentManager.popBackStack(HomeTabFragment.FragmentTag.WALLET_FRAGMENT, 1);
        NewWalletFragment walletFragment = getWalletFragment(fragmentManager);
        if (walletFragment != null) {
            walletFragment.onCollapse(r4);
        }
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final NewWalletFragment getWalletFragment(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(HomeTabFragment.FragmentTag.WALLET_FRAGMENT);
        if (findFragmentByTag instanceof NewWalletFragment) {
            return (NewWalletFragment) findFragmentByTag;
        }
        return null;
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final void backFromSearch(FragmentManager fragmentManager, String tag) {
        Intrinsics.checkNotNullParameter(fragmentManager, "");
        Intrinsics.checkNotNullParameter(tag, "");
        fragmentManager.popBackStack();
        Fragment findFragmentByTag = fragmentManager.findFragmentByTag(tag);
        if (findFragmentByTag instanceof InvestmentWalletDetailFragment) {
            ((InvestmentWalletDetailFragment) findFragmentByTag).onCollapseFromSearch();
        } else if (findFragmentByTag instanceof LoyaltyWalletDetailFragment) {
            ((LoyaltyWalletDetailFragment) findFragmentByTag).onCollapseFromSearch();
        } else if (findFragmentByTag instanceof IdentityWalletDetailFragment) {
            ((IdentityWalletDetailFragment) findFragmentByTag).onCollapseFromSearch();
        } else if (findFragmentByTag instanceof PaymentWalletDetailFragment) {
            ((PaymentWalletDetailFragment) findFragmentByTag).onCollapseFromSearch();
        } else if (findFragmentByTag instanceof VouchersAndTicketsDetailFragment) {
            ((VouchersAndTicketsDetailFragment) findFragmentByTag).onCollapseFromSearch();
        } else if (findFragmentByTag instanceof NewWalletFragment) {
            ((NewWalletFragment) findFragmentByTag).onCollapseFromSearch();
        }
    }

    @Override // id.dana.wallet_v3.listener.WalletDetailBaseFunction
    public final boolean isFromDeeplinkWallet(Activity r5) {
        String encodedPath;
        String str = "";
        Intrinsics.checkNotNullParameter(r5, "");
        Uri data = r5.getIntent().getData();
        if (data != null && (encodedPath = data.getEncodedPath()) != null) {
            str = encodedPath;
        }
        return StringsKt.startsWith$default(str, HomeTabActivity.DEEPLINK_WALLET_PATH, false, 2, (Object) null);
    }
}
