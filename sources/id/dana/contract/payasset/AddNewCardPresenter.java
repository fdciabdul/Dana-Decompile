package id.dana.contract.payasset;

import id.dana.contract.payasset.AddNewCardContract;
import id.dana.di.PerActivity;
import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.CheckEnableExpressPayFeature;
import id.dana.domain.featureconfig.model.ExpressPayInfo;
import javax.inject.Inject;

@PerActivity
/* loaded from: classes4.dex */
public class AddNewCardPresenter implements AddNewCardContract.Presenter {
    private final CheckEnableExpressPayFeature BuiltInFictitiousFunctionClassFactory;
    private final AddNewCardContract.View getAuthRequestContext;

    @Inject
    public AddNewCardPresenter(AddNewCardContract.View view, CheckEnableExpressPayFeature checkEnableExpressPayFeature) {
        this.getAuthRequestContext = view;
        this.BuiltInFictitiousFunctionClassFactory = checkEnableExpressPayFeature;
    }

    @Override // id.dana.contract.payasset.AddNewCardContract.Presenter
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.BuiltInFictitiousFunctionClassFactory.execute(new DefaultObserver<ExpressPayInfo>() { // from class: id.dana.contract.payasset.AddNewCardPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                AddNewCardPresenter.this.getAuthRequestContext.PlaceComponentResult(Boolean.valueOf(((ExpressPayInfo) obj).isEnableInQR()));
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.dispose();
    }
}
