package id.dana.data.saving.repository.source.local;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class DefaultSavingWithdrawEntityData_Factory implements Factory<DefaultSavingWithdrawEntityData> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public DefaultSavingWithdrawEntityData_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final DefaultSavingWithdrawEntityData get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static DefaultSavingWithdrawEntityData_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new DefaultSavingWithdrawEntityData_Factory(provider, provider2);
    }

    public static DefaultSavingWithdrawEntityData newInstance(Context context, Serializer serializer) {
        return new DefaultSavingWithdrawEntityData(context, serializer);
    }
}
