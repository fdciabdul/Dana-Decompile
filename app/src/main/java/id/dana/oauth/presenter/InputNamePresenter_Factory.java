package id.dana.oauth.presenter;

import dagger.internal.Factory;
import id.dana.domain.user.interactor.GetUserInfoWithKyc;
import id.dana.domain.userprofileinfo.interactor.CheckSkipButtonMerchantList;
import id.dana.domain.userprofileinfo.interactor.UpdateNicknameProfile;
import id.dana.oauth.InputNameContract;
import javax.inject.Provider;

/* loaded from: classes9.dex */
public final class InputNamePresenter_Factory implements Factory<InputNamePresenter> {
    private final Provider<InputNameContract.View> BuiltInFictitiousFunctionClassFactory;
    private final Provider<GetUserInfoWithKyc> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<CheckSkipButtonMerchantList> MyBillsEntityDataFactory;
    private final Provider<UpdateNicknameProfile> PlaceComponentResult;

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new InputNamePresenter(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
