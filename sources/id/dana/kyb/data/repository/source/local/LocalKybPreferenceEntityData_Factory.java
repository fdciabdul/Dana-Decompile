package id.dana.kyb.data.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalKybPreferenceEntityData_Factory implements Factory<LocalKybPreferenceEntityData> {
    private final Provider<Serializer> BuiltInFictitiousFunctionClassFactory;
    private final Provider<KybPreference> MyBillsEntityDataFactory;
    private final Provider<Context> getAuthRequestContext;

    private LocalKybPreferenceEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2, Provider<KybPreference> provider3) {
        this.getAuthRequestContext = provider;
        this.BuiltInFictitiousFunctionClassFactory = provider2;
        this.MyBillsEntityDataFactory = provider3;
    }

    public static LocalKybPreferenceEntityData_Factory BuiltInFictitiousFunctionClassFactory(Provider<Context> provider, Provider<Serializer> provider2, Provider<KybPreference> provider3) {
        return new LocalKybPreferenceEntityData_Factory(provider, provider2, provider3);
    }

    @Override // javax.inject.Provider
    public final /* synthetic */ Object get() {
        return new LocalKybPreferenceEntityData(this.getAuthRequestContext.get(), this.BuiltInFictitiousFunctionClassFactory.get(), this.MyBillsEntityDataFactory.get());
    }
}
