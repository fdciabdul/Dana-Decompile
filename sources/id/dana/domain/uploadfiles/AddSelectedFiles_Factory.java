package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class AddSelectedFiles_Factory implements Factory<AddSelectedFiles> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public AddSelectedFiles_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final AddSelectedFiles get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static AddSelectedFiles_Factory create(Provider<UploadFilesRepository> provider) {
        return new AddSelectedFiles_Factory(provider);
    }

    public static AddSelectedFiles newInstance(UploadFilesRepository uploadFilesRepository) {
        return new AddSelectedFiles(uploadFilesRepository);
    }
}
