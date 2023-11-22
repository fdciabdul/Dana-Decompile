package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.richview.socialshare.SocialShareContract;
import id.dana.richview.socialshare.presenter.SocialSharePresenter;

@Module
/* loaded from: classes4.dex */
public class SocialShareModule {
    private SocialShareContract.View getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SocialShareContract.Presenter PlaceComponentResult(SocialSharePresenter socialSharePresenter) {
        return socialSharePresenter;
    }

    public SocialShareModule(SocialShareContract.View view) {
        this.getAuthRequestContext = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    public SocialShareContract.View PlaceComponentResult() {
        return this.getAuthRequestContext;
    }
}
