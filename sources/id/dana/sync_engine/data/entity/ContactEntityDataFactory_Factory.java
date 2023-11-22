package id.dana.sync_engine.data.entity;

import dagger.internal.Factory;
import id.dana.sync_engine.data.source.device.ContactEntityDataDevice;
import id.dana.sync_engine.data.source.local.ContactEntityDataLocal;
import id.dana.sync_engine.data.source.network.ContactEntityDataNetwork;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ContactEntityDataFactory_Factory implements Factory<ContactEntityDataFactory> {
    private final Provider<ContactEntityDataLocal> BuiltInFictitiousFunctionClassFactory;
    private final Provider<ContactEntityDataNetwork> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<ContactEntityDataDevice> PlaceComponentResult;

    private ContactEntityDataFactory_Factory(Provider<ContactEntityDataLocal> provider, Provider<ContactEntityDataDevice> provider2, Provider<ContactEntityDataNetwork> provider3) {
        this.BuiltInFictitiousFunctionClassFactory = provider;
        this.PlaceComponentResult = provider2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider3;
    }

    public static ContactEntityDataFactory_Factory KClassImpl$Data$declaredNonStaticMembers$2(Provider<ContactEntityDataLocal> provider, Provider<ContactEntityDataDevice> provider2, Provider<ContactEntityDataNetwork> provider3) {
        return new ContactEntityDataFactory_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new ContactEntityDataFactory(this.BuiltInFictitiousFunctionClassFactory.get(), this.PlaceComponentResult.get(), this.KClassImpl$Data$declaredNonStaticMembers$2.get());
    }
}
