package id.dana.mybills.di;

import dagger.Component;
import id.dana.contract.deeplink.DeepLinkModule;
import id.dana.contract.services.ServicesModule;
import id.dana.di.PerActivity;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.CheckoutH5EventModule;
import id.dana.di.modules.GlobalNetworkModule;
import id.dana.di.modules.MyBillsModule;
import id.dana.di.modules.PlayStoreReviewModules;
import id.dana.mybills.MyBillsActivity;
import id.dana.mybills.view.AddNewBillsActivity;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {MyBillsModule.class, DeepLinkModule.class, ServicesModule.class, PlayStoreReviewModules.class, CheckoutH5EventModule.class, BottomSheetOnBoardingModule.class, GlobalNetworkModule.class})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/di/MyBillsComponent;", "", "Lid/dana/mybills/MyBillsActivity;", "p0", "", "PlaceComponentResult", "(Lid/dana/mybills/MyBillsActivity;)V", "Lid/dana/mybills/view/AddNewBillsActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/view/AddNewBillsActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes5.dex */
public interface MyBillsComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsActivity p0);

    void PlaceComponentResult(MyBillsActivity p0);
}
