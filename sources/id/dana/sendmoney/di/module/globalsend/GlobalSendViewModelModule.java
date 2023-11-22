package id.dana.sendmoney.di.module.globalsend;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.di.module.ViewModelKey;
import id.dana.sendmoney.di.scope.GlobalSendScope;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.AmountFormViewModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ConfirmationBottomSheetDialogViewModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.ReceiverFormViewModel;
import id.dana.sendmoney.ui.globalsend.form.viewmodel.SelectCountryDestinationViewModel;
import id.dana.sendmoney.ui.globalsend.landing.viewmodel.GlobalSendLandingViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\rH'¢\u0006\u0004\b\u000b\u0010\u000eJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u000b\u0010\u0010J\u0017\u0010\u000b\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u0011H'¢\u0006\u0004\b\u000b\u0010\u0013"}, d2 = {"Lid/dana/sendmoney/di/module/globalsend/GlobalSendViewModelModule;", "", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/ui/globalsend/form/viewmodel/AmountFormViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogViewModel;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ConfirmationBottomSheetDialogViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingViewModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/globalsend/landing/viewmodel/GlobalSendLandingViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormViewModel;", "(Lid/dana/sendmoney/ui/globalsend/form/viewmodel/ReceiverFormViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationViewModel;", "(Lid/dana/sendmoney/ui/globalsend/form/viewmodel/SelectCountryDestinationViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lid/dana/core/ui/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes9.dex */
public abstract class GlobalSendViewModelModule {
    @GlobalSendScope
    @Binds
    @IntoMap
    @ViewModelKey(ReceiverFormViewModel.class)
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(ReceiverFormViewModel p0);

    @GlobalSendScope
    @Binds
    @IntoMap
    @ViewModelKey(SelectCountryDestinationViewModel.class)
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(SelectCountryDestinationViewModel p0);

    @GlobalSendScope
    @Binds
    @IntoMap
    @ViewModelKey(GlobalSendLandingViewModel.class)
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(GlobalSendLandingViewModel p0);

    @GlobalSendScope
    @Binds
    public abstract ViewModelProvider.Factory BuiltInFictitiousFunctionClassFactory(ViewModelFactory p0);

    @GlobalSendScope
    @Binds
    @IntoMap
    @ViewModelKey(ConfirmationBottomSheetDialogViewModel.class)
    public abstract ViewModel MyBillsEntityDataFactory(ConfirmationBottomSheetDialogViewModel p0);

    @GlobalSendScope
    @Binds
    @IntoMap
    @ViewModelKey(AmountFormViewModel.class)
    public abstract ViewModel getAuthRequestContext(AmountFormViewModel p0);
}
