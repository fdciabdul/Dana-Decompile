package id.dana.di.component;

import dagger.Component;
import id.dana.contract.payasset.ChangePayMethodModule;
import id.dana.contract.payqr.OfflinePayModule;
import id.dana.contract.payqr.PayQrModule;
import id.dana.di.PerActivity;
import id.dana.pay.CardPayFragment;
import id.dana.pay.CardQrisPayFragment;

@Component(dependencies = {ApplicationComponent.class}, modules = {PayQrModule.class, ChangePayMethodModule.class, OfflinePayModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface CardPayComponent {
    void BuiltInFictitiousFunctionClassFactory(CardPayFragment cardPayFragment);

    void BuiltInFictitiousFunctionClassFactory(CardQrisPayFragment cardQrisPayFragment);
}
