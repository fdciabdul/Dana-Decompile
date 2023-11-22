package id.dana.splitbill;

import id.dana.domain.DefaultObserver;
import id.dana.domain.featureconfig.interactor.GetSplitBillConfig;
import id.dana.domain.featureconfig.model.SplitBillConfig;
import id.dana.splitbill.SplitBillSectionContract;
import javax.inject.Inject;

/* loaded from: classes9.dex */
public class SplitBillSectionPresenter implements SplitBillSectionContract.Presenter {
    private final SplitBillSectionContract.View BuiltInFictitiousFunctionClassFactory;
    private final GetSplitBillConfig MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public SplitBillSectionPresenter(SplitBillSectionContract.View view, GetSplitBillConfig getSplitBillConfig) {
        this.BuiltInFictitiousFunctionClassFactory = view;
        this.MyBillsEntityDataFactory = getSplitBillConfig;
    }

    @Override // id.dana.splitbill.SplitBillSectionContract.Presenter
    public final void MyBillsEntityDataFactory() {
        this.MyBillsEntityDataFactory.execute(new DefaultObserver<SplitBillConfig>() { // from class: id.dana.splitbill.SplitBillSectionPresenter.1
            @Override // id.dana.domain.DefaultObserver, io.reactivex.Observer
            public /* synthetic */ void onNext(Object obj) {
                SplitBillSectionPresenter.this.BuiltInFictitiousFunctionClassFactory.onFinishGetSplitBillConfig((SplitBillConfig) obj);
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.MyBillsEntityDataFactory.dispose();
    }
}
