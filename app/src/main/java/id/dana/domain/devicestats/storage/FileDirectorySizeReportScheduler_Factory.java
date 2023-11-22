package id.dana.domain.devicestats.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class FileDirectorySizeReportScheduler_Factory implements Factory<FileDirectorySizeReportScheduler> {
    private final Provider<FileDirectoriesSizeRepository> fileDirectoriesSizeRepositoryProvider;

    public FileDirectorySizeReportScheduler_Factory(Provider<FileDirectoriesSizeRepository> provider) {
        this.fileDirectoriesSizeRepositoryProvider = provider;
    }

    @Override // javax.inject.Provider
    public final FileDirectorySizeReportScheduler get() {
        return newInstance(this.fileDirectoriesSizeRepositoryProvider.get());
    }

    public static FileDirectorySizeReportScheduler_Factory create(Provider<FileDirectoriesSizeRepository> provider) {
        return new FileDirectorySizeReportScheduler_Factory(provider);
    }

    public static FileDirectorySizeReportScheduler newInstance(FileDirectoriesSizeRepository fileDirectoriesSizeRepository) {
        return new FileDirectorySizeReportScheduler(fileDirectoriesSizeRepository);
    }
}
