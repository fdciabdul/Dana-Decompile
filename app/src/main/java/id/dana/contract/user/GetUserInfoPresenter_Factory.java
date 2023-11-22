package id.dana.contract.user;

import dagger.internal.DoubleCheck;
import dagger.internal.Factory;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.myprofile.UserInfoMapper;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class GetUserInfoPresenter_Factory implements Factory<GetUserInfoPresenter> {
    private final Provider<GetUserInfoContract.View> MyBillsEntityDataFactory;
    private final Provider<GetUserInfo> PlaceComponentResult;
    private final Provider<UserInfoMapper> getAuthRequestContext;

    private GetUserInfoPresenter_Factory(Provider<GetUserInfoContract.View> provider, Provider<GetUserInfo> provider2, Provider<UserInfoMapper> provider3) {
        this.MyBillsEntityDataFactory = provider;
        this.PlaceComponentResult = provider2;
        this.getAuthRequestContext = provider3;
    }

    public static GetUserInfoPresenter_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<GetUserInfoContract.View> provider, Provider<GetUserInfo> provider2, Provider<UserInfoMapper> provider3) {
        return new GetUserInfoPresenter_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new GetUserInfoPresenter(DoubleCheck.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory), DoubleCheck.MyBillsEntityDataFactory(this.PlaceComponentResult), DoubleCheck.MyBillsEntityDataFactory(this.getAuthRequestContext));
    }
}
