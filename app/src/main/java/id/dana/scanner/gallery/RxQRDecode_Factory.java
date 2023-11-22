package id.dana.scanner.gallery;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes5.dex */
public final class RxQRDecode_Factory implements Factory<RxQRDecode> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private RxQRDecode_Factory(Provider<Context> provider) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
    }

    public static RxQRDecode_Factory MyBillsEntityDataFactory(Provider<Context> provider) {
        return new RxQRDecode_Factory(provider);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new RxQRDecode(this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
