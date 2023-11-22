package id.dana.data.uploadfiles;

import dagger.internal.Factory;
import id.dana.data.uploadfiles.model.UploadFilesPreference;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UploadFilesEntityRepository_Factory implements Factory<UploadFilesEntityRepository> {
    private final Provider<UploadFilesApi> uploadFilesApiProvider;
    private final Provider<UploadFilesPreference> uploadFilesPreferenceProvider;

    public UploadFilesEntityRepository_Factory(Provider<UploadFilesApi> provider, Provider<UploadFilesPreference> provider2) {
        this.uploadFilesApiProvider = provider;
        this.uploadFilesPreferenceProvider = provider2;
    }

    @Override // javax.inject.Provider
    public final UploadFilesEntityRepository get() {
        return newInstance(this.uploadFilesApiProvider.get(), this.uploadFilesPreferenceProvider.get());
    }

    public static UploadFilesEntityRepository_Factory create(Provider<UploadFilesApi> provider, Provider<UploadFilesPreference> provider2) {
        return new UploadFilesEntityRepository_Factory(provider, provider2);
    }

    public static UploadFilesEntityRepository newInstance(UploadFilesApi uploadFilesApi, UploadFilesPreference uploadFilesPreference) {
        return new UploadFilesEntityRepository(uploadFilesApi, uploadFilesPreference);
    }
}
