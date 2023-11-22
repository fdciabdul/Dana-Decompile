package id.dana.contract.user;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.user.GetProfilePictureContract;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes8.dex */
public class GetProfilePictureModule {
    private final GetProfilePictureContract.View MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetProfilePictureContract.Presenter MyBillsEntityDataFactory(GetProfilePicturePresenter getProfilePicturePresenter) {
        return getProfilePicturePresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public GetProfilePictureContract.View BuiltInFictitiousFunctionClassFactory() {
        return this.MyBillsEntityDataFactory;
    }
}
