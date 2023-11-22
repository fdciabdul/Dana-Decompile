package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;

/* loaded from: classes5.dex */
public final class BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory implements Factory<BottomSheetAddAssetContract.View> {
    private final BottomSheetAddAssetModule module;

    public BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory(BottomSheetAddAssetModule bottomSheetAddAssetModule) {
        this.module = bottomSheetAddAssetModule;
    }

    @Override // javax.inject.Provider
    public final BottomSheetAddAssetContract.View get() {
        return provideView$app_productionRelease(this.module);
    }

    public static BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory create(BottomSheetAddAssetModule bottomSheetAddAssetModule) {
        return new BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory(bottomSheetAddAssetModule);
    }

    public static BottomSheetAddAssetContract.View provideView$app_productionRelease(BottomSheetAddAssetModule bottomSheetAddAssetModule) {
        return (BottomSheetAddAssetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(bottomSheetAddAssetModule.getView());
    }
}
