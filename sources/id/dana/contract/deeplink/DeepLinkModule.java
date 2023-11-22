package id.dana.contract.deeplink;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import id.dana.contract.deeplink.DeepLinkContract;
import id.dana.contract.deeplink.ReadLinkPropertiesContract;
import id.dana.contract.services.ServicesModule;
import id.dana.contract.shortener.RestoreUrlModule;
import id.dana.contract.staticqr.ScanQrModule;
import id.dana.di.PerActivity;
import id.dana.di.modules.AnnouncementModule;
import id.dana.di.modules.DeeplinkTrackerModule;
import id.dana.di.modules.OauthModule;
import id.dana.utils.danah5.DanaH5Listener;

@Module(includes = {ScanQrModule.class, RestoreUrlModule.class, FeatureModule.class, OauthModule.class, ServicesModule.class, AnnouncementModule.class, DeeplinkTrackerModule.class})
/* loaded from: classes.dex */
public class DeepLinkModule {
    private Builder MyBillsEntityDataFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ReadLinkPropertiesContract.Presenter BuiltInFictitiousFunctionClassFactory(ReadLinkPropertiesPresenter readLinkPropertiesPresenter) {
        return readLinkPropertiesPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public DeepLinkContract.Presenter PlaceComponentResult(DeepLinkPresenter deepLinkPresenter) {
        return deepLinkPresenter;
    }

    public /* synthetic */ DeepLinkModule(Builder builder, byte b) {
        this(builder);
    }

    private DeepLinkModule(Builder builder) {
        this.MyBillsEntityDataFactory = builder;
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public DeepLinkContract.View KClassImpl$Data$declaredNonStaticMembers$2(DeepLinkView deepLinkView) {
        if (this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory == null) {
            deepLinkView.PlaceComponentResult(this.MyBillsEntityDataFactory.PlaceComponentResult);
            deepLinkView.BuiltInFictitiousFunctionClassFactory(this.MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            deepLinkView.PlaceComponentResult(this.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2);
            deepLinkView.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory.getAuthRequestContext);
            return deepLinkView;
        }
        return this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        private DeepLinkContract.View BuiltInFictitiousFunctionClassFactory;
        public DeepLinkCallback KClassImpl$Data$declaredNonStaticMembers$2;
        public Activity MyBillsEntityDataFactory;
        public DanaH5Listener PlaceComponentResult;
        public String getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }
}
