package id.dana.di.modules;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import id.dana.contract.deeplink.path.OauthContract;
import id.dana.contract.deeplink.path.OauthPresenter;
import id.dana.contract.deeplink.path.OauthView;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes2.dex */
public class OauthModule {
    private Builder MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public OauthContract.Presenter getAuthRequestContext(OauthPresenter oauthPresenter) {
        return oauthPresenter;
    }

    public /* synthetic */ OauthModule(Builder builder, byte b) {
        this(builder);
    }

    private OauthModule(Builder builder) {
        this.MyBillsEntityDataFactory = builder;
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public OauthContract.View KClassImpl$Data$declaredNonStaticMembers$2(OauthView oauthView) {
        if (this.MyBillsEntityDataFactory.getAuthRequestContext != null) {
            return this.MyBillsEntityDataFactory.getAuthRequestContext;
        }
        oauthView.getAuthRequestContext = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
        return oauthView;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public Activity BuiltInFictitiousFunctionClassFactory;
        private OauthContract.View getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }
}
