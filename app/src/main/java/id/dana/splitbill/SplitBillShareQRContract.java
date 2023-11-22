package id.dana.splitbill;

import id.dana.base.AbstractContract;
import id.dana.model.HomeInfo;

/* loaded from: classes5.dex */
public interface SplitBillShareQRContract {

    /* loaded from: classes5.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory();
    }

    /* loaded from: classes5.dex */
    public interface View {
        void onFinishGetHomeInfo(HomeInfo homeInfo);
    }
}
