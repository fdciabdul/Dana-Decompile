package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.di.PerActivity;
import id.dana.onboarding.confirmpin.ConfirmPinContract;
import id.dana.onboarding.confirmpin.ConfirmPinPresenter;

@Module
/* loaded from: classes4.dex */
public class ConfirmPinModule {
    private ConfirmPinContract.View PlaceComponentResult;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ConfirmPinContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(ConfirmPinPresenter confirmPinPresenter) {
        return confirmPinPresenter;
    }

    public ConfirmPinModule(ConfirmPinContract.View view) {
        this.PlaceComponentResult = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ConfirmPinContract.View getAuthRequestContext() {
        return this.PlaceComponentResult;
    }
}
