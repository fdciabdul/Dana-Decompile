package id.dana.social.fragment;

import dagger.MembersInjector;
import id.dana.social.contract.BlockedFragmentContract;

/* loaded from: classes5.dex */
public final class BlockedFragment_MembersInjector implements MembersInjector<BlockedFragment> {
    public static void PlaceComponentResult(BlockedFragment blockedFragment, BlockedFragmentContract.Presenter presenter) {
        blockedFragment.presenter = presenter;
    }
}
