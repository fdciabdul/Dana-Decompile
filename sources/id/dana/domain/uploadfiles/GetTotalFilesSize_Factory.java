package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class GetTotalFilesSize_Factory implements Factory<GetTotalFilesSize> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public GetTotalFilesSize_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final GetTotalFilesSize get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static GetTotalFilesSize_Factory create(Provider<UploadFilesRepository> provider) {
        return new GetTotalFilesSize_Factory(provider);
    }

    public static GetTotalFilesSize newInstance(UploadFilesRepository uploadFilesRepository) {
        return new GetTotalFilesSize(uploadFilesRepository);
    }
}
