package id.dana.sync_engine.data.source.device;

import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactEntityDataDevice_Factory implements Factory<ContactEntityDataDevice> {
    private final Provider<ContentResolver> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<Context> getAuthRequestContext;

    private ContactEntityDataDevice_Factory(Provider<Context> provider, Provider<ContentResolver> provider2) {
        this.getAuthRequestContext = provider;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider2;
    }

    public static ContactEntityDataDevice_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<ContentResolver> provider2) {
        return new ContactEntityDataDevice_Factory(provider, provider2);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactEntityDataDevice(this.getAuthRequestContext.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
