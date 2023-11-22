package id.dana.wallet_v3.factory;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import id.dana.R;
import id.dana.animation.tab.HomeTabFragment;
import id.dana.data.foundation.logger.log.LoginTrackingConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0007"}, d2 = {"Lid/dana/wallet_v3/factory/WalletIntentFactory;", "", "Landroidx/fragment/app/Fragment;", "from", LoginTrackingConstants.LoginParam.TO, "", "openNewFragment", "(Landroidx/fragment/app/Fragment;Landroidx/fragment/app/Fragment;)V", "openNewFragmentWithAnimation", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WalletIntentFactory {
    public static final WalletIntentFactory INSTANCE = new WalletIntentFactory();

    private WalletIntentFactory() {
    }

    public final void openNewFragment(Fragment from, Fragment to) {
        Intrinsics.checkNotNullParameter(from, "");
        Intrinsics.checkNotNullParameter(to, "");
        FragmentTransaction beginTransaction = from.getParentFragmentManager().beginTransaction();
        beginTransaction.isLayoutRequested = true;
        FragmentTransaction PlaceComponentResult = beginTransaction.PlaceComponentResult(from);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(R.id.fragment_container_view, to, null, 1);
        if (!PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        PlaceComponentResult.scheduleImpl = true;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = HomeTabFragment.FragmentTag.WALLET_FRAGMENT;
        PlaceComponentResult.getAuthRequestContext();
    }

    public final void openNewFragmentWithAnimation(Fragment from, Fragment to) {
        Intrinsics.checkNotNullParameter(from, "");
        Intrinsics.checkNotNullParameter(to, "");
        FragmentTransaction beginTransaction = from.getParentFragmentManager().beginTransaction();
        beginTransaction.isLayoutRequested = true;
        beginTransaction.NetworkUserEntityData$$ExternalSyntheticLambda2 = R.anim.f4702130772011;
        beginTransaction.GetContactSyncConfig = R.anim.f4712130772012;
        beginTransaction.newProxyInstance = 0;
        beginTransaction.PrepareContext = 0;
        FragmentTransaction PlaceComponentResult = beginTransaction.PlaceComponentResult(from);
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2(R.id.fragment_container_view, to, null, 1);
        if (!PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda0) {
            throw new IllegalStateException("This FragmentTransaction is not allowed to be added to the back stack.");
        }
        PlaceComponentResult.scheduleImpl = true;
        PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8 = HomeTabFragment.FragmentTag.WALLET_FRAGMENT;
        PlaceComponentResult.getAuthRequestContext();
    }
}
