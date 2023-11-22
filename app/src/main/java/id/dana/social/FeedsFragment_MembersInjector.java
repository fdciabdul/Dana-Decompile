package id.dana.social;

import dagger.MembersInjector;
import id.dana.social.contract.RelationshipBottomSheetContract;

/* loaded from: classes5.dex */
public final class FeedsFragment_MembersInjector implements MembersInjector<FeedsFragment> {
    public static void MyBillsEntityDataFactory(FeedsFragment feedsFragment, RelationshipBottomSheetContract.Presenter presenter) {
        feedsFragment.settingPresenter = presenter;
    }
}
