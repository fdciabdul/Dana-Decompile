package id.dana.domain.devicestats.storage;

import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class ScheduleDeviceStatsReport_Factory implements Factory<ScheduleDeviceStatsReport> {
    private final Provider<FileDirectorySizeReportScheduler> fileDirectorySizeReportSchedulerProvider;

    public ScheduleDeviceStatsReport_Factory(Provider<FileDirectorySizeReportScheduler> provider) {
        this.fileDirectorySizeReportSchedulerProvider = provider;
    }

    @Override // javax.inject.Provider
    public final ScheduleDeviceStatsReport get() {
        return newInstance(this.fileDirectorySizeReportSchedulerProvider.get());
    }

    public static ScheduleDeviceStatsReport_Factory create(Provider<FileDirectorySizeReportScheduler> provider) {
        return new ScheduleDeviceStatsReport_Factory(provider);
    }

    public static ScheduleDeviceStatsReport newInstance(FileDirectorySizeReportScheduler fileDirectorySizeReportScheduler) {
        return new ScheduleDeviceStatsReport(fileDirectorySizeReportScheduler);
    }
}
