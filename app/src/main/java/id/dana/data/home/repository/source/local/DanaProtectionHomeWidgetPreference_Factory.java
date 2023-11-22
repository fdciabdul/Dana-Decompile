package id.dana.data.home.repository.source.local;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DanaProtectionHomeWidgetPreference_Factory implements Factory<DanaProtectionHomeWidgetPreference> {
    private final Provider<Serializer> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Gson> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private DanaProtectionHomeWidgetPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static DanaProtectionHomeWidgetPreference_Factory getAuthRequestContext(Provider<Context> provider, Provider<Serializer> provider2, Provider<Gson> provider3) {
        return new DanaProtectionHomeWidgetPreference_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new DanaProtectionHomeWidgetPreference(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.MyBillsEntityDataFactory.get());
    }
}
