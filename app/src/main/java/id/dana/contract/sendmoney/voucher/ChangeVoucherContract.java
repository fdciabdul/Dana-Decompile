package id.dana.contract.sendmoney.voucher;

import id.dana.base.AbstractContract;
import id.dana.sendmoney.model.VoucherModel;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public interface ChangeVoucherContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(String str, String str2);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void getAuthRequestContext(ArrayList<VoucherModel> arrayList);
    }
}
