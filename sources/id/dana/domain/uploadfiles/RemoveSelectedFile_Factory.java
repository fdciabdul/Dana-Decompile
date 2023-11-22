package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class RemoveSelectedFile_Factory implements Factory<RemoveSelectedFile> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public RemoveSelectedFile_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final RemoveSelectedFile get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static RemoveSelectedFile_Factory create(Provider<UploadFilesRepository> provider) {
        return new RemoveSelectedFile_Factory(provider);
    }

    public static RemoveSelectedFile newInstance(UploadFilesRepository uploadFilesRepository) {
        return new RemoveSelectedFile(uploadFilesRepository);
    }
}
