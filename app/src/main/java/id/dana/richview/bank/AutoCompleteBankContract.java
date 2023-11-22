package id.dana.richview.bank;

import id.dana.base.AbstractContract;
import id.dana.sendmoney.model.BankModel;
import java.util.List;

/* loaded from: classes9.dex */
public interface AutoCompleteBankContract {

    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void PlaceComponentResult();
    }

    /* loaded from: classes9.dex */
    public interface View {
        void onGetAvailableBanksFail(String str);

        void onGetAvailableBanksSuccess(List<BankModel> list);

        void onGetSenderNameSuccess(boolean z);
    }
}
