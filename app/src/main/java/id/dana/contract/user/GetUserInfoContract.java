package id.dana.contract.user;

import id.dana.base.AbstractContract;
import id.dana.model.UserInfo;

/* loaded from: classes4.dex */
public interface GetUserInfoContract {

    /* loaded from: classes4.dex */
    public interface Presenter extends AbstractContract.AbstractPresenter {
        void PlaceComponentResult(boolean z);
    }

    /* loaded from: classes4.dex */
    public interface View extends AbstractContract.AbstractView {
        void KClassImpl$Data$declaredNonStaticMembers$2(UserInfo userInfo);
    }
}
