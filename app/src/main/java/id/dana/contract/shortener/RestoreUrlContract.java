package id.dana.contract.shortener;

import id.dana.base.AbstractContract;

/* loaded from: classes4.dex */
public interface RestoreUrlContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void getAuthRequestContext(String str, String str2);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void PlaceComponentResult(String str, String str2);
    }
}
