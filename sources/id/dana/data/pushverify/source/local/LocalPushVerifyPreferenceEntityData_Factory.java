package id.dana.data.pushverify.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LocalPushVerifyPreferenceEntityData_Factory implements Factory<LocalPushVerifyPreferenceEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public LocalPushVerifyPreferenceEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final LocalPushVerifyPreferenceEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static LocalPushVerifyPreferenceEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new LocalPushVerifyPreferenceEntityData_Factory(provider, provider2);
    }

    public static LocalPushVerifyPreferenceEntityData newInstance(Context context, Serializer serializer) {
        return new LocalPushVerifyPreferenceEntityData(context, serializer);
    }
}
