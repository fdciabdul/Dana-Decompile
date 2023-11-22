package id.dana.wallet_v3.view.sort.view;

import dagger.MembersInjector;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter;
import javax.inject.Provider;

/* loaded from: classes6.dex */
public final class BottomSheetSortAsset_MembersInjector implements MembersInjector<BottomSheetSortAsset> {
    private final Provider<BottomSheetSortAssetPresenter> bottomSheetSortAssetPresenterProvider;

    public BottomSheetSortAsset_MembersInjector(Provider<BottomSheetSortAssetPresenter> provider) {
        this.bottomSheetSortAssetPresenterProvider = provider;
    }

    public static MembersInjector<BottomSheetSortAsset> create(Provider<BottomSheetSortAssetPresenter> provider) {
        return new BottomSheetSortAsset_MembersInjector(provider);
    }

    public final void injectMembers(BottomSheetSortAsset bottomSheetSortAsset) {
        injectBottomSheetSortAssetPresenter(bottomSheetSortAsset, this.bottomSheetSortAssetPresenterProvider.get());
    }

    public static void injectBottomSheetSortAssetPresenter(BottomSheetSortAsset bottomSheetSortAsset, BottomSheetSortAssetPresenter bottomSheetSortAssetPresenter) {
        bottomSheetSortAsset.bottomSheetSortAssetPresenter = bottomSheetSortAssetPresenter;
    }
}
