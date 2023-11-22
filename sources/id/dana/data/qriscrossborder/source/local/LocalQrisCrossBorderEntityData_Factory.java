package id.dana.data.qriscrossborder.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalQrisCrossBorderEntityData_Factory implements Factory<LocalQrisCrossBorderEntityData> {
    private final Provider<Context> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Provider<QrisCrossBorderPreference> PlaceComponentResult;
    private final Provider<Serializer> getAuthRequestContext;

    private LocalQrisCrossBorderEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<QrisCrossBorderPreference> provider3) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
    }

    public static LocalQrisCrossBorderEntityData_Factory MyBillsEntityDataFactory(Provider<Context> provider, Provider<Serializer> provider2, Provider<QrisCrossBorderPreference> provider3) {
        return new LocalQrisCrossBorderEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalQrisCrossBorderEntityData(this.KClassImpl$Data$declaredNonStaticMembers$2.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get());
    }
}
