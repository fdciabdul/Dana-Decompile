package id.dana.mybills.di.module;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.mybills.di.scope.MyBillsScope;
import id.dana.mybills.ui.v2.MyBillsViewModel;
import id.dana.mybills.ui.v2.addnewbills.AddNewBillsViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/mybills/di/module/MyBillsViewModelModule;", "", "Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/ui/v2/addnewbills/AddNewBillsViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/mybills/ui/v2/MyBillsViewModel;", "getAuthRequestContext", "(Lid/dana/mybills/ui/v2/MyBillsViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/mybills/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "PlaceComponentResult", "(Lid/dana/mybills/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes9.dex */
public abstract class MyBillsViewModelModule {
    @ViewModelKey(AddNewBillsViewModel.class)
    @Binds
    @MyBillsScope
    @IntoMap
    public abstract ViewModel BuiltInFictitiousFunctionClassFactory(AddNewBillsViewModel p0);

    @Binds
    @MyBillsScope
    public abstract ViewModelProvider.Factory PlaceComponentResult(ViewModelFactory p0);

    @ViewModelKey(MyBillsViewModel.class)
    @Binds
    @MyBillsScope
    @IntoMap
    public abstract ViewModel getAuthRequestContext(MyBillsViewModel p0);
}
