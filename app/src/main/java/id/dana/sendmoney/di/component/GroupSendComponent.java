package id.dana.sendmoney.di.component;

import dagger.Subcomponent;
import id.dana.sendmoney.di.module.groupsend.GroupSendDataModule;
import id.dana.sendmoney.di.module.groupsend.GroupSendViewModelModule;
import id.dana.sendmoney.di.scope.GroupSendScope;
import id.dana.sendmoney.ui.groupsend.groupdetail.activity.GroupDetailActivity;
import id.dana.sendmoney.ui.groupsend.landing.activity.GroupSendLandingActivity;
import id.dana.sendmoney.ui.groupsend.recipient.activity.GroupRecipientActivity;
import id.dana.sendmoney.ui.groupsend.summary.activity.GroupSendSummaryActivity;
import id.dana.sendmoney.ui.groupsend.summary.view.BottomSheetImagePickerDialogFragment;
import kotlin.Metadata;

@Subcomponent(modules = {GroupSendDataModule.class, GroupSendViewModelModule.class})
@GroupSendScope
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0011J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\b\u0010\u0010ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/di/component/GroupSendComponent;", "", "Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/GroupDetailActivity;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/activity/GroupDetailActivity;)V", "Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendLandingActivity;", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/groupsend/landing/activity/GroupSendLandingActivity;)V", "Lid/dana/sendmoney/ui/groupsend/recipient/activity/GroupRecipientActivity;", "(Lid/dana/sendmoney/ui/groupsend/recipient/activity/GroupRecipientActivity;)V", "Lid/dana/sendmoney/ui/groupsend/summary/activity/GroupSendSummaryActivity;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/groupsend/summary/activity/GroupSendSummaryActivity;)V", "Lid/dana/sendmoney/ui/groupsend/summary/view/BottomSheetImagePickerDialogFragment;", "(Lid/dana/sendmoney/ui/groupsend/summary/view/BottomSheetImagePickerDialogFragment;)V", "Factory"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface GroupSendComponent {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/sendmoney/di/component/GroupSendComponent$Factory;", "", "Lid/dana/sendmoney/di/component/GroupSendComponent;", "getAuthRequestContext", "()Lid/dana/sendmoney/di/component/GroupSendComponent;"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Subcomponent.Factory
    /* loaded from: classes.dex */
    public interface Factory {
        GroupSendComponent getAuthRequestContext();
    }

    void BuiltInFictitiousFunctionClassFactory(GroupSendSummaryActivity p0);

    void KClassImpl$Data$declaredNonStaticMembers$2(GroupDetailActivity p0);

    void MyBillsEntityDataFactory(GroupSendLandingActivity p0);

    void MyBillsEntityDataFactory(GroupRecipientActivity p0);

    void MyBillsEntityDataFactory(BottomSheetImagePickerDialogFragment p0);
}
