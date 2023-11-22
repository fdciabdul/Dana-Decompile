package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class BottomSheetAddAssetModule_ProvidePresenter$app_productionReleaseFactory implements Factory<BottomSheetAddAssetContract.Presenter> {
    private final BottomSheetAddAssetModule module;
    private final Provider<BottomSheetAddAssetPresenter> presenterProvider;

    public BottomSheetAddAssetModule_ProvidePresenter$app_productionReleaseFactory(BottomSheetAddAssetModule bottomSheetAddAssetModule, Provider<BottomSheetAddAssetPresenter> provider) {
        this.module = bottomSheetAddAssetModule;
        this.presenterProvider = provider;
    }

    @Override // javax.inject.Provider
    public final BottomSheetAddAssetContract.Presenter get() {
        return providePresenter$app_productionRelease(this.module, this.presenterProvider.get());
    }

    public static BottomSheetAddAssetModule_ProvidePresenter$app_productionReleaseFactory create(BottomSheetAddAssetModule bottomSheetAddAssetModule, Provider<BottomSheetAddAssetPresenter> provider) {
        return new BottomSheetAddAssetModule_ProvidePresenter$app_productionReleaseFactory(bottomSheetAddAssetModule, provider);
    }

    public static BottomSheetAddAssetContract.Presenter providePresenter$app_productionRelease(BottomSheetAddAssetModule bottomSheetAddAssetModule, BottomSheetAddAssetPresenter bottomSheetAddAssetPresenter) {
        return (BottomSheetAddAssetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(bottomSheetAddAssetModule.providePresenter$app_productionRelease(bottomSheetAddAssetPresenter));
    }
}
