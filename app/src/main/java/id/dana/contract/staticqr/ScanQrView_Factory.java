package id.dana.contract.staticqr;

import android.app.Activity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ScanQrView_Factory implements Factory<ScanQrView> {
    private final Provider<Activity> BuiltInFictitiousFunctionClassFactory;

    private ScanQrView_Factory(Provider<Activity> provider) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
    }

    public static ScanQrView_Factory MyBillsEntityDataFactory(Provider<Activity> provider) {
        return new ScanQrView_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ScanQrView(this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
