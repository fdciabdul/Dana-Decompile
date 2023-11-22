package id.dana.di.modules;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import id.dana.wallet_v3.view.addasset.presenter.BottomSheetAddAssetContract;

/* loaded from: classes8.dex */
public final class BottomSheetAddAssetModule_ProvideView$app_productionReleaseFactory implements Factory<BottomSheetAddAssetContract.View> {
    private final BottomSheetAddAssetModule MyBillsEntityDataFactory;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return (BottomSheetAddAssetContract.View) Preconditions.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.getKClassImpl$Data$declaredNonStaticMembers$2());
    }
}
