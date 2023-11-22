package id.dana.sendmoney.recipienthome;

import id.dana.base.AbstractContract;
import id.dana.base.AbstractContractKt;
import id.dana.model.SendMoneyScenarioModel;
import java.util.List;

/* loaded from: classes5.dex */
public interface SendMoneyScenariosContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void PlaceComponentResult();
    }

    /* loaded from: classes5.dex */
    public interface View extends AbstractContractKt.AbstractView {
        void PlaceComponentResult(List<SendMoneyScenarioModel> list);
    }
}
