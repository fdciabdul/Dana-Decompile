package id.dana.contract.user;

import dagger.Lazy;
import id.dana.contract.user.GetUserInfoContract;
import id.dana.di.PerActivity;
import id.dana.domain.user.UserInfoResponse;
import id.dana.domain.user.interactor.GetUserInfo;
import id.dana.myprofile.UserInfoMapper;
import javax.inject.Inject;
import kotlin.jvm.functions.Function1;

@PerActivity
/* loaded from: classes4.dex */
public class GetUserInfoPresenter implements GetUserInfoContract.Presenter {
    private final Lazy<GetUserInfo> BuiltInFictitiousFunctionClassFactory;
    final Lazy<UserInfoMapper> KClassImpl$Data$declaredNonStaticMembers$2;
    final Lazy<GetUserInfoContract.View> MyBillsEntityDataFactory;

    @Inject
    public GetUserInfoPresenter(Lazy<GetUserInfoContract.View> lazy, Lazy<GetUserInfo> lazy2, Lazy<UserInfoMapper> lazy3) {
        this.MyBillsEntityDataFactory = lazy;
        this.BuiltInFictitiousFunctionClassFactory = lazy2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = lazy3;
    }

    @Override // id.dana.contract.user.GetUserInfoContract.Presenter
    public final void PlaceComponentResult(boolean z) {
        this.MyBillsEntityDataFactory.get().showProgress();
        this.BuiltInFictitiousFunctionClassFactory.get().execute(new GetUserInfo.Param(z), new Function1() { // from class: id.dana.contract.user.GetUserInfoPresenter$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetUserInfoPresenter getUserInfoPresenter = GetUserInfoPresenter.this;
                getUserInfoPresenter.MyBillsEntityDataFactory.get().dismissProgress();
                getUserInfoPresenter.MyBillsEntityDataFactory.get().KClassImpl$Data$declaredNonStaticMembers$2(getUserInfoPresenter.KClassImpl$Data$declaredNonStaticMembers$2.get().MyBillsEntityDataFactory((UserInfoResponse) obj));
                return null;
            }
        }, new Function1() { // from class: id.dana.contract.user.GetUserInfoPresenter$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                GetUserInfoPresenter getUserInfoPresenter = GetUserInfoPresenter.this;
                getUserInfoPresenter.MyBillsEntityDataFactory.get().dismissProgress();
                getUserInfoPresenter.MyBillsEntityDataFactory.get().onError(((Throwable) obj).getMessage());
                return null;
            }
        });
    }

    @Override // id.dana.base.AbstractContract.AbstractPresenter
    public void onDestroy() {
        this.BuiltInFictitiousFunctionClassFactory.get().dispose();
    }
}
