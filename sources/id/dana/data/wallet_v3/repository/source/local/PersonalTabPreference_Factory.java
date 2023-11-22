package id.dana.data.wallet_v3.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class PersonalTabPreference_Factory implements Factory<PersonalTabPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public PersonalTabPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final PersonalTabPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static PersonalTabPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new PersonalTabPreference_Factory(provider, provider2);
    }

    public static PersonalTabPreference newInstance(Context context, Serializer serializer) {
        return new PersonalTabPreference(context, serializer);
    }
}
