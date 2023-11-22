package id.dana.data.user.source.persistence;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UserInfoPreference_Factory implements Factory<UserInfoPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public UserInfoPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UserInfoPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static UserInfoPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new UserInfoPreference_Factory(provider, provider2);
    }

    public static UserInfoPreference newInstance(Context context, Serializer serializer) {
        return new UserInfoPreference(context, serializer);
    }
}
