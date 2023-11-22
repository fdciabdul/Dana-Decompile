package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetPresenter;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class BottomSheetAddAssetModule_ProvidePresenter$app_productionReleaseFactory implements Factory<BottomSheetAddAssetContract.Presenter> {
    private final Provider<BottomSheetAddAssetPresenter> KClassImpl$Data$declaredNonStaticMembers$2;
    private final BottomSheetAddAssetModule getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BottomSheetAddAssetContract.Presenter) Preconditions.BuiltInFictitiousFunctionClassFactory(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory(this.KClassImpl$Data$declaredNonStaticMembers$2.get()));
    }
}
