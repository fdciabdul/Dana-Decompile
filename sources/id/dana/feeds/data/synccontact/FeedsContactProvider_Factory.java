package id.dana.feeds.data.synccontact;

import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FeedsContactProvider_Factory implements Factory<FeedsContactProvider> {
    private final Provider<ContentResolver> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;

    private FeedsContactProvider_Factory(Provider<Context> provider, Provider<ContentResolver> provider2) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
    }

    public static FeedsContactProvider_Factory getAuthRequestContext(Provider<Context> provider, Provider<ContentResolver> provider2) {
        return new FeedsContactProvider_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new FeedsContactProvider(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
