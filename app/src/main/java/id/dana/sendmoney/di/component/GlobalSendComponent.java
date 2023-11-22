package id.dana.sendmoney.di.component;

import dagger.Subcomponent;
import id.dana.sendmoney.di.module.globalsend.GlobalSendApiModule;
import id.dana.sendmoney.di.module.globalsend.GlobalSendDataModule;
import id.dana.sendmoney.di.module.globalsend.GlobalSendViewModelModule;
import id.dana.sendmoney.di.scope.GlobalSendScope;
import id.dana.sendmoney.ui.globalsend.form.fragment.AmountFormFragment;
import id.dana.sendmoney.ui.globalsend.form.fragment.ReceiverFormFragment;
import id.dana.sendmoney.ui.globalsend.form.view.ConfirmationBottomSheetDialogFragment;
import id.dana.sendmoney.ui.globalsend.form.view.SelectCountryBottomSheet;
import id.dana.sendmoney.ui.globalsend.landing.activity.GlobalSendLandingActivity;
import kotlin.Metadata;

@GlobalSendScope
@Subcomponent(modules = {GlobalSendApiModule.class, GlobalSendDataModule.class, GlobalSendViewModelModule.class})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\n\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH&¢\u0006\u0004\b\u0005\u0010\u000fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/di/component/GlobalSendComponent;", "", "Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/globalsend/form/fragment/AmountFormFragment;)V", "Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment;", "(Lid/dana/sendmoney/ui/globalsend/form/fragment/ReceiverFormFragment;)V", "Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetDialogFragment;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/globalsend/form/view/ConfirmationBottomSheetDialogFragment;)V", "Lid/dana/sendmoney/ui/globalsend/form/view/SelectCountryBottomSheet;", "(Lid/dana/sendmoney/ui/globalsend/form/view/SelectCountryBottomSheet;)V", "Lid/dana/sendmoney/ui/globalsend/landing/activity/GlobalSendLandingActivity;", "(Lid/dana/sendmoney/ui/globalsend/landing/activity/GlobalSendLandingActivity;)V", "Factory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GlobalSendComponent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/di/component/GlobalSendComponent$Factory;", "", "Lid/dana/sendmoney/di/component/GlobalSendComponent;", "getAuthRequestContext", "()Lid/dana/sendmoney/di/component/GlobalSendComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: classes.dex */
    public interface Factory {
        GlobalSendComponent getAuthRequestContext();
    }

    void KClassImpl$Data$declaredNonStaticMembers$2(ConfirmationBottomSheetDialogFragment p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(SelectCountryBottomSheet p0);

    void MyBillsEntityDataFactory(AmountFormFragment p0);

    void MyBillsEntityDataFactory(ReceiverFormFragment p0);

    void MyBillsEntityDataFactory(GlobalSendLandingActivity p0);
}
