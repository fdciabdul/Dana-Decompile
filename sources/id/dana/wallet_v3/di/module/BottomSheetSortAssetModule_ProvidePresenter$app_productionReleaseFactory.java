package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetPresenter;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BottomSheetSortAssetModule_ProvidePresenter$app_productionReleaseFactory implements Factory<BottomSheetSortAssetContract.Presenter> {
    private final BottomSheetSortAssetModule module;
    private final Provider<BottomSheetSortAssetPresenter> presenterProvider;

    public BottomSheetSortAssetModule_ProvidePresenter$app_productionReleaseFactory(BottomSheetSortAssetModule bottomSheetSortAssetModule, Provider<BottomSheetSortAssetPresenter> provider) {
        this.module = bottomSheetSortAssetModule;
        this.presenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BottomSheetSortAssetContract.Presenter get() {
        return providePresenter$app_productionRelease(this.module, this.presenterProvider.get());
    }

    public static BottomSheetSortAssetModule_ProvidePresenter$app_productionReleaseFactory create(BottomSheetSortAssetModule bottomSheetSortAssetModule, Provider<BottomSheetSortAssetPresenter> provider) {
        return new BottomSheetSortAssetModule_ProvidePresenter$app_productionReleaseFactory(bottomSheetSortAssetModule, provider);
    }

    public static BottomSheetSortAssetContract.Presenter providePresenter$app_productionRelease(BottomSheetSortAssetModule bottomSheetSortAssetModule, BottomSheetSortAssetPresenter bottomSheetSortAssetPresenter) {
        return (BottomSheetSortAssetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(bottomSheetSortAssetModule.providePresenter$app_productionRelease(bottomSheetSortAssetPresenter));
    }
}
