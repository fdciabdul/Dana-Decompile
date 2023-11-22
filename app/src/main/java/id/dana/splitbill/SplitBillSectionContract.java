package id.dana.splitbill;

import id.dana.base.AbstractContract;
import id.dana.domain.featureconfig.model.SplitBillConfig;

/* loaded from: classes9.dex */
public interface SplitBillSectionContract {

    /* loaded from: classes9.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory();
    }

    /* loaded from: classes9.dex */
    public interface View {
        void onFinishGetSplitBillConfig(SplitBillConfig splitBillConfig);
    }
}
