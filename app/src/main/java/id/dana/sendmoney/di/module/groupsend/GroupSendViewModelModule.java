package id.dana.sendmoney.di.module.groupsend;

import androidx.view.ViewModel;
import androidx.view.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import id.dana.core.ui.di.module.ViewModelFactory;
import id.dana.core.ui.di.module.ViewModelKey;
import id.dana.sendmoney.di.scope.GroupSendScope;
import id.dana.sendmoney.ui.groupsend.groupdetail.viewmodel.GroupDetailViewModel;
import id.dana.sendmoney.ui.groupsend.landing.viewmodel.GroupSendLandingViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.viewmodel.GroupRecipientViewModel;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendImagePickerViewModel;
import id.dana.sendmoney.ui.groupsend.summary.viewmodel.GroupSendSummaryViewModel;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH'¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH'¢\u0006\u0004\b\b\u0010\rJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000eH'¢\u0006\u0004\b\b\u0010\u000fJ\u0017\u0010\u0005\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0010H'¢\u0006\u0004\b\u0005\u0010\u0012"}, d2 = {"Lid/dana/sendmoney/di/module/groupsend/GroupSendViewModelModule;", "", "Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailViewModel;", "p0", "Landroidx/lifecycle/ViewModel;", "getAuthRequestContext", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/viewmodel/GroupDetailViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerViewModel;", "PlaceComponentResult", "(Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendImagePickerViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientViewModel;", "(Lid/dana/sendmoney/ui/groupsend/recipient/viewmodel/GroupRecipientViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingViewModel;", "(Lid/dana/sendmoney/ui/groupsend/landing/viewmodel/GroupSendLandingViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryViewModel;", "(Lid/dana/sendmoney/ui/groupsend/summary/viewmodel/GroupSendSummaryViewModel;)Landroidx/lifecycle/ViewModel;", "Lid/dana/core/ui/di/module/ViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "(Lid/dana/core/ui/di/module/ViewModelFactory;)Landroidx/lifecycle/ViewModelProvider$Factory;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Module
/* loaded from: classes9.dex */
public abstract class GroupSendViewModelModule {
    @Binds
    @GroupSendScope
    @IntoMap
    @ViewModelKey(GroupSendLandingViewModel.class)
    public abstract ViewModel PlaceComponentResult(GroupSendLandingViewModel p0);

    @Binds
    @GroupSendScope
    @IntoMap
    @ViewModelKey(GroupRecipientViewModel.class)
    public abstract ViewModel PlaceComponentResult(GroupRecipientViewModel p0);

    @Binds
    @GroupSendScope
    @IntoMap
    @ViewModelKey(GroupSendImagePickerViewModel.class)
    public abstract ViewModel PlaceComponentResult(GroupSendImagePickerViewModel p0);

    @Binds
    @GroupSendScope
    @IntoMap
    @ViewModelKey(GroupSendSummaryViewModel.class)
    public abstract ViewModel PlaceComponentResult(GroupSendSummaryViewModel p0);

    @Binds
    @GroupSendScope
    @IntoMap
    @ViewModelKey(GroupDetailViewModel.class)
    public abstract ViewModel getAuthRequestContext(GroupDetailViewModel p0);

    @Binds
    @GroupSendScope
    public abstract ViewModelProvider.Factory getAuthRequestContext(ViewModelFactory p0);
}
