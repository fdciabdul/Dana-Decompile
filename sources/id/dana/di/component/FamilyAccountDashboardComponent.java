package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.FamilyAccountDashboardModule;
import id.dana.familyaccount.di.FamilyAccountTrackerModule;
import id.dana.familyaccount.view.dashboard.MemberDashboardActivity;
import id.dana.familyaccount.view.dashboard.OrganizerDashboardActivity;
import kotlin.Metadata;

@Component(dependencies = {ApplicationComponent.class}, modules = {BottomSheetOnBoardingModule.class, FamilyAccountDashboardModule.class, FamilyAccountTrackerModule.class})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/di/component/FamilyAccountDashboardComponent;", "", "Lid/dana/familyaccount/view/dashboard/MemberDashboardActivity;", "p0", "", "getAuthRequestContext", "(Lid/dana/familyaccount/view/dashboard/MemberDashboardActivity;)V", "Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/familyaccount/view/dashboard/OrganizerDashboardActivity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PerActivity
/* loaded from: classes4.dex */
public interface FamilyAccountDashboardComponent {
    void KClassImpl$Data$declaredNonStaticMembers$2(OrganizerDashboardActivity p0);

    void getAuthRequestContext(MemberDashboardActivity p0);
}
