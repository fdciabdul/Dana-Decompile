package id.dana.contract.staticqr;

import android.app.Activity;
import dagger.Module;
import dagger.Provides;
import id.dana.contract.staticqr.ScanQrContract;
import id.dana.di.PerActivity;
import id.dana.utils.danah5.DanaH5Listener;

@Module
/* loaded from: classes.dex */
public class ScanQrModule {
    private Builder BuiltInFictitiousFunctionClassFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ScanQrContract.Presenter PlaceComponentResult(ScanQrPresenter scanQrPresenter) {
        return scanQrPresenter;
    }

    public /* synthetic */ ScanQrModule(Builder builder, byte b) {
        this(builder);
    }

    private ScanQrModule(Builder builder) {
        this.BuiltInFictitiousFunctionClassFactory = builder;
    }

    public static Builder getAuthRequestContext() {
        return new Builder((byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public Activity KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Provides
    @PerActivity
    public ScanQrContract.View KClassImpl$Data$declaredNonStaticMembers$2(ScanQrView scanQrView) {
        if (this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult != null) {
            return this.BuiltInFictitiousFunctionClassFactory.PlaceComponentResult;
        }
        scanQrView.KClassImpl$Data$declaredNonStaticMembers$2 = this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2;
        scanQrView.BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext;
        scanQrView.MyBillsEntityDataFactory = this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory;
        return scanQrView;
    }

    /* loaded from: classes.dex */
    public static class Builder {
        public ScanQrContract.View BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public Activity MyBillsEntityDataFactory;
        public ScanQrContract.View PlaceComponentResult;
        public DanaH5Listener getAuthRequestContext;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }
}
