package id.dana.di.modules;

import dagger.Module;
import dagger.Provides;
import id.dana.contract.oauth.OauthGrantContract;
import id.dana.contract.oauth.OauthGrantPresenter;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class OauthGrantModule {
    private OauthGrantContract.View KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public OauthGrantContract.Presenter getAuthRequestContext(OauthGrantPresenter oauthGrantPresenter) {
        return oauthGrantPresenter;
    }

    public OauthGrantModule(OauthGrantContract.View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public OauthGrantContract.View PlaceComponentResult() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
