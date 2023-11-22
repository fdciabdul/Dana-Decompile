package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetSelectedFiles_Factory implements Factory<GetSelectedFiles> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public GetSelectedFiles_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetSelectedFiles get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static GetSelectedFiles_Factory create(Provider<UploadFilesRepository> provider) {
        return new GetSelectedFiles_Factory(provider);
    }

    public static GetSelectedFiles newInstance(UploadFilesRepository uploadFilesRepository) {
        return new GetSelectedFiles(uploadFilesRepository);
    }
}
