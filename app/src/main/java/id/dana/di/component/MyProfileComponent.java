package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.user.GetBalanceModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.MyProfileModule;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.SessionModule;
import id.dana.di.modules.UserStatementModule;
import id.dana.myprofile.MyProfileFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {MyProfileModule.class, GetBalanceModule.class, GetStaticQrModule.class, GenerateDeepLinkModule.class, ChangePhoneNumberH5EventModule.class, QueryPayMethodModule.class, BottomSheetOnBoardingModule.class, UserStatementModule.class, SavingModule.class, InvestmentModule.class, SessionModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface MyProfileComponent {
    void getAuthRequestContext(MyProfileFragment myProfileFragment);
}
