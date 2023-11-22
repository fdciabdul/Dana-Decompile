package id.dana.mybills.di.component;

import dagger.Subcomponent;
import id.dana.mybills.di.module.MyBillsDataModule;
import id.dana.mybills.di.module.MyBillsSourceModule;
import id.dana.mybills.di.module.MyBillsViewModelModule;
import id.dana.mybills.di.scope.MyBillsScope;
import id.dana.mybills.ui.v2.MyBillsHomeActivity;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsFragment;
import id.dana.mybills.ui.v2.addnewbills.services.DigitalVoucherBottomSheetFragment;
import id.dana.mybills.ui.v2.addnewbills.services.ElectricityBillsBottomSheetFragment;
import id.dana.mybills.ui.v2.addnewbills.services.GeneralBillsBottomSheetFragment;
import id.dana.mybills.ui.v2.addnewbills.services.MobileRechargeBottomSheetFragment;
import id.dana.mybills.ui.v2.dashboard.MyBillsDashboardFragment;
import id.dana.mybills.ui.v2.dashboard.MyBillsPaymentConfirmationFragment;
import id.dana.mybills.ui.v2.dashboard.SinglePayBillBottomSheetFragment;
import id.dana.mybills.ui.v2.managebills.ManageBillsFragment;
import kotlin.Metadata;

@Subcomponent(modules = {MyBillsSourceModule.class, MyBillsViewModelModule.class, MyBillsDataModule.class})
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u001cJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0014H&¢\u0006\u0004\b\u0005\u0010\u0015J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0016H&¢\u0006\u0004\b\n\u0010\u0017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0018H&¢\u0006\u0004\b\u0005\u0010\u0019J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u001aH&¢\u0006\u0004\b\u0012\u0010\u001bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/di/component/MyBillsComponent;", "", "Lid/dana/mybills/ui/v2/MyBillsHomeActivity;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/ui/v2/MyBillsHomeActivity;)V", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsFragment;", "(Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsFragment;)V", "Lid/dana/mybills/ui/v2/addnewbills/services/DigitalVoucherBottomSheetFragment;", "PlaceComponentResult", "(Lid/dana/mybills/ui/v2/addnewbills/services/DigitalVoucherBottomSheetFragment;)V", "Lid/dana/mybills/ui/v2/addnewbills/services/ElectricityBillsBottomSheetFragment;", "(Lid/dana/mybills/ui/v2/addnewbills/services/ElectricityBillsBottomSheetFragment;)V", "Lid/dana/mybills/ui/v2/addnewbills/services/GeneralBillsBottomSheetFragment;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/ui/v2/addnewbills/services/GeneralBillsBottomSheetFragment;)V", "Lid/dana/mybills/ui/v2/addnewbills/services/MobileRechargeBottomSheetFragment;", "getAuthRequestContext", "(Lid/dana/mybills/ui/v2/addnewbills/services/MobileRechargeBottomSheetFragment;)V", "Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment;", "(Lid/dana/mybills/ui/v2/dashboard/MyBillsDashboardFragment;)V", "Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragment;", "(Lid/dana/mybills/ui/v2/dashboard/MyBillsPaymentConfirmationFragment;)V", "Lid/dana/mybills/ui/v2/dashboard/SinglePayBillBottomSheetFragment;", "(Lid/dana/mybills/ui/v2/dashboard/SinglePayBillBottomSheetFragment;)V", "Lid/dana/mybills/ui/v2/managebills/ManageBillsFragment;", "(Lid/dana/mybills/ui/v2/managebills/ManageBillsFragment;)V", "Factory"}, k = 1, mv = {1, 6, 0}, xi = 48)
@MyBillsScope
/* loaded from: classes2.dex */
public interface MyBillsComponent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/di/component/MyBillsComponent$Factory;", "", "Lid/dana/mybills/di/component/MyBillsComponent;", "getAuthRequestContext", "()Lid/dana/mybills/di/component/MyBillsComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: classes.dex */
    public interface Factory {
        MyBillsComponent getAuthRequestContext();
    }

    void BuiltInFictitiousFunctionClassFactory(GeneralBillsBottomSheetFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsHomeActivity p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(AddNewBillsFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(MyBillsDashboardFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(SinglePayBillBottomSheetFragment p0);

    void PlaceComponentResult(DigitalVoucherBottomSheetFragment p0);

    void PlaceComponentResult(ElectricityBillsBottomSheetFragment p0);

    void PlaceComponentResult(MyBillsPaymentConfirmationFragment p0);

    void getAuthRequestContext(MobileRechargeBottomSheetFragment p0);

    void getAuthRequestContext(ManageBillsFragment p0);
}
