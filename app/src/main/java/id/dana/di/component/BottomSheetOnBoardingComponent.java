package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.BottomSheetOnBoardingModule;
import id.dana.usereducation.BottomSheetOnBoardingActivity;

@Component(dependencies = {ApplicationComponent.class}, modules = {BottomSheetOnBoardingModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface BottomSheetOnBoardingComponent {
    void getAuthRequestContext(BottomSheetOnBoardingActivity bottomSheetOnBoardingActivity);
}
