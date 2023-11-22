package id.dana.data.carrieridentification;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.carrieridentification.source.CarrierIdentificationDataFactory;
import id.dana.data.registration.RegistrationProcessManager;
import id.dana.data.registration.source.RegistrationEntityDataFactory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CarrierIdentificationEntityRepository_Factory implements Factory<CarrierIdentificationEntityRepository> {
    private final Provider<RegistrationEntityDataFactory> BuiltInFictitiousFunctionClassFactory;
    private final Provider<Context> MyBillsEntityDataFactory;
    private final Provider<CarrierIdentificationDataFactory> PlaceComponentResult;
    private final Provider<RegistrationProcessManager> getAuthRequestContext;

    private CarrierIdentificationEntityRepository_Factory(Provider<Context> provider, Provider<RegistrationProcessManager> provider2, Provider<CarrierIdentificationDataFactory> provider3, Provider<RegistrationEntityDataFactory> provider4) {
        this.MyBillsEntityDataFactory = provider;
        this.getAuthRequestContext = provider2;
        this.PlaceComponentResult = provider3;
        this.BuiltInFictitiousFunctionClassFactory = provider4;
    }

    public static CarrierIdentificationEntityRepository_Factory PlaceComponentResult(Provider<Context> provider, Provider<RegistrationProcessManager> provider2, Provider<CarrierIdentificationDataFactory> provider3, Provider<RegistrationEntityDataFactory> provider4) {
        return new CarrierIdentificationEntityRepository_Factory(provider, provider2, provider3, provider4);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new CarrierIdentificationEntityRepository(this.MyBillsEntityDataFactory.get(), this.getAuthRequestContext.get(), this.PlaceComponentResult.get(), this.BuiltInFictitiousFunctionClassFactory.get());
    }
}
