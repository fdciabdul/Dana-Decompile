package id.dana.contract.nearbyme;

import dagger.internal.Factory;
import id.dana.contract.nearbyme.OtherStoreListContract;
import id.dana.domain.nearbyme.interactor.GetNearbyShopsPromo;
import id.dana.domain.nearbyme.interactor.GetOtherStoreList;
import id.dana.nearbyme.NearbyPromoModelMapper;
import id.dana.nearbyme.mapper.OtherStoreListResultModelMapper;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class OtherStoreListPresenter_Factory implements Factory<OtherStoreListPresenter> {
    private final Provider<OtherStoreListResultModelMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetNearbyShopsPromo> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<GetOtherStoreList> MyBillsEntityDataFactory;
    private final Provider<OtherStoreListContract.View> PlaceComponentResult;
    private final Provider<NearbyPromoModelMapper> getAuthRequestContext;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new OtherStoreListPresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
