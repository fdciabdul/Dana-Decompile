package id.dana.domain.uploadfiles;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes8.dex */
public final class SetTotalFilesSize_Factory implements Factory<SetTotalFilesSize> {
    private final Provider<UploadFilesRepository> uploadFilesRepositoryProvider;

    public SetTotalFilesSize_Factory(Provider<UploadFilesRepository> provider) {
        this.uploadFilesRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final SetTotalFilesSize get() {
        return newInstance(this.uploadFilesRepositoryProvider.get());
    }

    public static SetTotalFilesSize_Factory create(Provider<UploadFilesRepository> provider) {
        return new SetTotalFilesSize_Factory(provider);
    }

    public static SetTotalFilesSize newInstance(UploadFilesRepository uploadFilesRepository) {
        return new SetTotalFilesSize(uploadFilesRepository);
    }
}
