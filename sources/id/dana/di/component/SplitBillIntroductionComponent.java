package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.di.modules.SplitBillAnalyticModule;
import id.dana.di.modules.SplitBillIntroductionModule;
import id.dana.splitbill.view.SplitBillIntroductionActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {SplitBillIntroductionModule.class, BottomSheetOnBoardingModule.class, SplitBillAnalyticModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface SplitBillIntroductionComponent {
    void getAuthRequestContext(SplitBillIntroductionActivity splitBillIntroductionActivity);
}
