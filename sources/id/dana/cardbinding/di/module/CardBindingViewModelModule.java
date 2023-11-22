package id.dana.cardbinding.di.module;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.cardbinding.viewmodel.CardBindingViewModel;
import id.dana.cardbinding.viewmodel.OtpCardBindingViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cardbinding/di/module/CardBindingViewModelModule;", "", "Lid/dana/cardbinding/viewmodel/CardBindingViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "PlaceComponentResult", "(Lid/dana/cardbinding/viewmodel/CardBindingViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;", "getAuthRequestContext", "(Lid/dana/cardbinding/viewmodel/OtpCardBindingViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/cardbinding/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/cardbinding/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes8.dex */
public abstract class CardBindingViewModelModule {
    @Binds
    public abstract ViewModelProvider.Factory KClassImpl$Data$declaredNonStaticMembers$2(ViewModelFactory p0);

    @ViewModelKey(CardBindingViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel PlaceComponentResult(CardBindingViewModel p0);

    @ViewModelKey(OtpCardBindingViewModel.class)
    @Binds
    @IntoMap
    public abstract ViewModel getAuthRequestContext(OtpCardBindingViewModel p0);
}
