package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ClearFiles_Factory implements Factory<ClearFiles> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public ClearFiles_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ClearFiles get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static ClearFiles_Factory create(Provider<UploadFilesRepository> provider) {
        return new ClearFiles_Factory(provider);
    }

    public static ClearFiles newInstance(UploadFilesRepository uploadFilesRepository) {
        return new ClearFiles(uploadFilesRepository);
    }
}
