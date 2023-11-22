package id.dana.splitbill;

import dagger.internal.Factory;
import id.dana.domain.splitbill.interactor.ClosePayers;
import id.dana.domain.splitbill.interactor.GetSplitBillDetail;
import id.dana.splitbill.SplitBillDetailContract;
import id.dana.splitbill.mapper.SplitBillDetailMapper;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class SplitBillDetailPresenter_Factory implements Factory<SplitBillDetailPresenter> {
    private final Provider<SplitBillDetailMapper> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetSplitBillDetail> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<SplitBillDetailContract.View> MyBillsEntityDataFactory;
    private final Provider<ClosePayers> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new SplitBillDetailPresenter(this.MyBillsEntityDataFactory.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get());
    }
}
