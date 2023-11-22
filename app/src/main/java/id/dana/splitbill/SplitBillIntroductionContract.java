package id.dana.splitbill;

import id.dana.base.AbstractContract;
import id.dana.requestmoney.model.RequestMoneyInfoModel;

/* loaded from: classes5.dex */
public interface SplitBillIntroductionContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void BuiltInFictitiousFunctionClassFactory();
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContract.AbstractView {
        void onFinishGetSplitBillConfig(int i, RequestMoneyInfoModel requestMoneyInfoModel);
    }
}
