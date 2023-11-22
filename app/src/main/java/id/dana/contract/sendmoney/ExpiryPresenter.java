package id.dana.contract.sendmoney;

import id.dana.contract.sendmoney.ExpiryContract;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.GetExpiryChoices;
import id.dana.domain.featureconfig.model.ExpiryInfo;
import id.dana.sendmoney.mapper.ExpiryInfoMapper;
import java.util.List;
import javax.inject.Inject;

/* loaded from: classes4.dex */
public class ExpiryPresenter implements ExpiryContract.Presenter {
    private final GetExpiryChoices MyBillsEntityDataFactory;
    private final ExpiryInfoMapper PlaceComponentResult;
    private final ExpiryContract.View getAuthRequestContext;

    @Inject
    public ExpiryPresenter(ExpiryContract.View view, GetExpiryChoices getExpiryChoices, ExpiryInfoMapper expiryInfoMapper) {
        this.getAuthRequestContext = view;
        this.MyBillsEntityDataFactory = getExpiryChoices;
        this.PlaceComponentResult = expiryInfoMapper;
    }

    @Override // id.dana.contract.sendmoney.ExpiryContract.Presenter
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<List<ExpiryInfo>>() { // from class: id.dana.contract.sendmoney.ExpiryPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                ExpiryPresenter.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(ExpiryPresenter.this.PlaceComponentResult.apply((List) obj));
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
