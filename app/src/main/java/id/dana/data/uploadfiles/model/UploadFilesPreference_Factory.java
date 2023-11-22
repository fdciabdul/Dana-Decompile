package id.dana.data.uploadfiles.model;

import android.content.Context;
import dagger.internal.Factory;
import id.dana.data.storage.Serializer;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UploadFilesPreference_Factory implements Factory<UploadFilesPreference> {
    private final Provider<Context> contextProvider;
    private final Provider<Serializer> serializerProvider;

    public UploadFilesPreference_Factory(Provider<Context> provider, Provider<Serializer> provider2) {
        this.contextProvider = provider;
        this.serializerProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UploadFilesPreference get() {
        return newInstance(this.contextProvider.get(), this.serializerProvider.get());
    }

    public static UploadFilesPreference_Factory create(Provider<Context> provider, Provider<Serializer> provider2) {
        return new UploadFilesPreference_Factory(provider, provider2);
    }

    public static UploadFilesPreference newInstance(Context context, Serializer serializer) {
        return new UploadFilesPreference(context, serializer);
    }
}
