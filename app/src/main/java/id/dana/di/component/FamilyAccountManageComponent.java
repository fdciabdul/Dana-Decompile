package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.FamilyAccountManageModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.view.managefamily.ManageMemberActivity;
import id.dana.familyaccount.view.managefamily.ManageOrganizerActivity;
import id.dana.familyaccount.view.memberlimit.ManageMemberLimitActivity;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {FamilyAccountManageModule.class, FamilyAccountTrackerModule.class})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\nH&¢\u0006\u0004\b\b\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/FamilyAccountManageComponent;", "", "Lid/dana/familyaccount/view/managefamily/ManageMemberActivity;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/familyaccount/view/managefamily/ManageMemberActivity;)V", "Lid/dana/familyaccount/view/managefamily/ManageOrganizerActivity;", "MyBillsEntityDataFactory", "(Lid/dana/familyaccount/view/managefamily/ManageOrganizerActivity;)V", "Lid/dana/familyaccount/view/memberlimit/ManageMemberLimitActivity;", "(Lid/dana/familyaccount/view/memberlimit/ManageMemberLimitActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public interface FamilyAccountManageComponent {
    void BuiltInFictitiousFunctionClassFactory(ManageMemberActivity p0);

    void MyBillsEntityDataFactory(ManageOrganizerActivity p0);

    void MyBillsEntityDataFactory(ManageMemberLimitActivity p0);
}
