package id.dana.data.home;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HomePassiveBioPreference_Factory implements Factory<HomePassiveBioPreference> {
    private final Provider<Serializer> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private HomePassiveBioPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.getAuthRequestContext = provider;
        this.MyBillsEntityDataFactory = provider2;
    }

    public static HomePassiveBioPreference_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<Context> provider, Provider<Serializer> provider2) {
        return new HomePassiveBioPreference_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new HomePassiveBioPreference(this.getAuthRequestContext.get(), this.MyBillsEntityDataFactory.get());
    }
}
