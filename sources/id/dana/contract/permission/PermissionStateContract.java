package id.dana.contract.permission;

import id.dana.base.AbstractContract;

/* loaded from: classes4.dex */
public interface PermissionStateContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void MyBillsEntityDataFactory(boolean z);

        void PlaceComponentResult();
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void PlaceComponentResult(boolean z);
    }
}
