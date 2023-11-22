package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.payasset.QueryPayMethodModule;
import id.dana.contract.paylater.PayLaterModule;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.contract.user.GetBalanceModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.ChangePhoneNumberH5EventModule;
import id.dana.di.modules.DanaPlusModule;
import id.dana.di.modules.GoldInvestmentModule;
import id.dana.di.modules.InvestmentModule;
import id.dana.di.modules.MyProfileModule;
import id.dana.di.modules.SavingModule;
import id.dana.di.modules.SessionModule;
import id.dana.di.modules.UserStatementModule;
import id.dana.myprofile.NewMyProfileFragment;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {MyProfileModule.class, GetBalanceModule.class, GetStaticQrModule.class, GenerateDeepLinkModule.class, ChangePhoneNumberH5EventModule.class, QueryPayMethodModule.class, BottomSheetOnBoardingModule.class, UserStatementModule.class, SavingModule.class, InvestmentModule.class, GoldInvestmentModule.class, DeepLinkModule.class, SessionModule.class, PayLaterModule.class, DanaPlusModule.class})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/NewMyProfileComponent;", "", "Lid/dana/myprofile/NewMyProfileFragment;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/myprofile/NewMyProfileFragment;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes2.dex */
public interface NewMyProfileComponent {
    void MyBillsEntityDataFactory(NewMyProfileFragment p0);
}
