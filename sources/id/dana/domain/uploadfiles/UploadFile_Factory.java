package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class UploadFile_Factory implements Factory<UploadFile> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public UploadFile_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final UploadFile get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static UploadFile_Factory create(Provider<UploadFilesRepository> provider) {
        return new UploadFile_Factory(provider);
    }

    public static UploadFile newInstance(UploadFilesRepository uploadFilesRepository) {
        return new UploadFile(uploadFilesRepository);
    }
}
