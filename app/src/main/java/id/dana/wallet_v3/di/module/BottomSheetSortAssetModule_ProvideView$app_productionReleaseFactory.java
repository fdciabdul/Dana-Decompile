package id.dana.wallet_v3.di.module;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.sort.presenter.BottomSheetSortAssetContract;

/* loaded from: classes5.dex */
public final class BottomSheetSortAssetModule_ProvideView$app_productionReleaseFactory implements Factory<BottomSheetSortAssetContract.View> {
    private final BottomSheetSortAssetModule module;

    public BottomSheetSortAssetModule_ProvideView$app_productionReleaseFactory(BottomSheetSortAssetModule bottomSheetSortAssetModule) {
        this.module = bottomSheetSortAssetModule;
    }

    @Override // javax.inject.Provider
    public final BottomSheetSortAssetContract.View get() {
        return provideView$app_productionRelease(this.module);
    }

    public static BottomSheetSortAssetModule_ProvideView$app_productionReleaseFactory create(BottomSheetSortAssetModule bottomSheetSortAssetModule) {
        return new BottomSheetSortAssetModule_ProvideView$app_productionReleaseFactory(bottomSheetSortAssetModule);
    }

    public static BottomSheetSortAssetContract.View provideView$app_productionRelease(BottomSheetSortAssetModule bottomSheetSortAssetModule) {
        return (BottomSheetSortAssetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(bottomSheetSortAssetModule.getView());
    }
}
