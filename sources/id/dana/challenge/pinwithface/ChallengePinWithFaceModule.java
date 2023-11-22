package id.dana.challenge.pinwithface;

import dagger.Module;
import dagger.Provides;
import id.dana.challenge.pinwithface.ChallengePinWithFaceContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes4.dex */
public class ChallengePinWithFaceModule {
    private ChallengePinWithFaceContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ChallengePinWithFaceContract.Presenter KClassImpl$Data$declaredNonStaticMembers$2(ChallengePinWithFacePresenter challengePinWithFacePresenter) {
        return challengePinWithFacePresenter;
    }

    public ChallengePinWithFaceModule(ChallengePinWithFaceContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ChallengePinWithFaceContract.View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getAuthRequestContext;
    }
}
