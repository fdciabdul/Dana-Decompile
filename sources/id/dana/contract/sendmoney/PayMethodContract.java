package id.dana.contract.sendmoney;

import id.dana.base.AbstractContract;
import id.dana.domain.sendmoney.model.TransferInit;
import id.dana.model.PayMethodModel;
import java.util.List;

/* loaded from: classes4.dex */
public interface PayMethodContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void KClassImpl$Data$declaredNonStaticMembers$2();

        void PlaceComponentResult(String str, TransferInit transferInit);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void onGetDefaultCardError();

        void onGetDefaultCardSuccess(String str);

        void onGetPayMethodError();

        void onGetPayMethodListSuccess(List<PayMethodModel> list, String str);
    }
}
