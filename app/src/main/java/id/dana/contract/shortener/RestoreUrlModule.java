package id.dana.contract.shortener;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import id.dana.base.BaseActivity;
import id.dana.contract.shortener.RestoreUrlContract;
import id.dana.di.PerActivity;
import id.dana.utils.danah5.DanaH5Listener;

@Module
/* loaded from: classes.dex */
public class RestoreUrlModule {
    private Builder getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RestoreUrlContract.Presenter getAuthRequestContext(RestoreUrlPresenter restoreUrlPresenter) {
        return restoreUrlPresenter;
    }

    public /* synthetic */ RestoreUrlModule(Builder builder, byte b) {
        this(builder);
    }

    private RestoreUrlModule(Builder builder) {
        this.getAuthRequestContext = builder;
    }

    public static Builder KClassImpl$Data$declaredNonStaticMembers$2() {
        return new Builder((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public RestoreUrlContract.View getAuthRequestContext(RestoreUrlView restoreUrlView) {
        if (this.getAuthRequestContext.PlaceComponentResult != null) {
            return this.getAuthRequestContext.PlaceComponentResult;
        }
        restoreUrlView.getAuthRequestContext = this.getAuthRequestContext.MyBillsEntityDataFactory;
        Activity activity = this.getAuthRequestContext.getAuthRequestContext;
        restoreUrlView.PlaceComponentResult = activity;
        if (activity instanceof BaseActivity) {
            restoreUrlView.BuiltInFictitiousFunctionClassFactory = (BaseActivity) activity;
        }
        return restoreUrlView;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public DanaH5Listener MyBillsEntityDataFactory;
        private RestoreUrlContract.View PlaceComponentResult;
        public Activity getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }
}
