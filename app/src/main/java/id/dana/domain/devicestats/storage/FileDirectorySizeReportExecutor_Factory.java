package id.dana.domain.devicestats.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class FileDirectorySizeReportExecutor_Factory implements Factory<FileDirectorySizeReportExecutor> {
    private final Provider<FileDirectoriesSizeRepository> fileDirectoriesSizeRepositoryProvider;

    public FileDirectorySizeReportExecutor_Factory(Provider<FileDirectoriesSizeRepository> provider) {
        this.fileDirectoriesSizeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FileDirectorySizeReportExecutor get() {
        return newInstance(this.fileDirectoriesSizeRepositoryProvider.get());
    }

    public static FileDirectorySizeReportExecutor_Factory create(Provider<FileDirectoriesSizeRepository> provider) {
        return new FileDirectorySizeReportExecutor_Factory(provider);
    }

    public static FileDirectorySizeReportExecutor newInstance(FileDirectoriesSizeRepository fileDirectoriesSizeRepository) {
        return new FileDirectorySizeReportExecutor(fileDirectoriesSizeRepository);
    }
}
