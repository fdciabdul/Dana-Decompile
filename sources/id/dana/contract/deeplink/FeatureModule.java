package id.dana.contract.deeplink;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import id.dana.base.BaseActivity;
import id.dana.contract.deeplink.path.FeatureCallback;
import id.dana.contract.deeplink.path.FeatureContract;
import id.dana.contract.deeplink.path.FeaturePresenter;
import id.dana.contract.deeplink.path.FeatureView;
import id.dana.di.PerActivity;

@Module
/* loaded from: classes.dex */
public class FeatureModule {
    private Builder BuiltInFictitiousFunctionClassFactory;

    @Provides
    @PerActivity
    public FeatureContract.Presenter BuiltInFictitiousFunctionClassFactory(FeaturePresenter featurePresenter) {
        return featurePresenter;
    }

    public /* synthetic */ FeatureModule(Builder builder, byte b) {
        this(builder);
    }

    private FeatureModule(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder;
    }

    public static Builder MyBillsEntityDataFactory() {
        return new Builder((byte) 0);
    }

    @Provides
    @PerActivity
    public FeatureContract.View KClassImpl$Data$declaredNonStaticMembers$2(FeatureView featureView) {
        if (this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory == null) {
            Activity activity = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
            featureView.PlaceComponentResult = activity;
            if (activity instanceof BaseActivity) {
                featureView.getAuthRequestContext = (BaseActivity) activity;
            }
            featureView.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
            featureView.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
            return featureView;
        }
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public Activity BuiltInFictitiousFunctionClassFactory;
        private FeatureContract.View MyBillsEntityDataFactory;
        public String PlaceComponentResult;
        public FeatureCallback getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }
}
