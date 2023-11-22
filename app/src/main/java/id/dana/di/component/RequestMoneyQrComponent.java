package id.dana.di.component;

import dagger.Component;
import id.dana.contract.deeplink.generation.GenerateDeepLinkModule;
import id.dana.contract.staticqr.GetStaticQrModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.RequestMoneyQrModule;
import id.dana.requestmoney.balance.RequestMoneyBalanceQrCardFragment;
import id.dana.sendmoney_v2.landing.di.module.SendMoneyTrackerModule;

@Component(dependencies = {ApplicationComponent.class}, modules = {RequestMoneyQrModule.class, GetStaticQrModule.class, GenerateDeepLinkModule.class, SendMoneyTrackerModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface RequestMoneyQrComponent {
    void BuiltInFictitiousFunctionClassFactory(RequestMoneyBalanceQrCardFragment requestMoneyBalanceQrCardFragment);
}
