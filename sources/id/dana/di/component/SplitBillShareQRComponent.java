package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.SplitBillShareQRModule;
import id.dana.splitbill.view.SplitBillShareQrActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {SplitBillShareQRModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SplitBillShareQRComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(SplitBillShareQrActivity splitBillShareQrActivity);
}
