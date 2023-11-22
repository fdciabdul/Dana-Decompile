package id.dana.backgroundwork;

import dagger.MembersInjector;
import id.dana.domain.devicestats.storage.FileDirectorySizeReportExecutor;

/* loaded from: classes.dex */
public final class DeviceStatsReportWorker_MembersInjector implements MembersInjector<DeviceStatsReportWorker> {
    public static void PlaceComponentResult(DeviceStatsReportWorker deviceStatsReportWorker, FileDirectorySizeReportExecutor fileDirectorySizeReportExecutor) {
        deviceStatsReportWorker.postInstallAppSizeExecutor = fileDirectorySizeReportExecutor;
    }
}
