package id.dana.domain.devicestats.storage;

import id.dana.domain.devicestats.storage.model.FileDirectoriesModel;
import id.dana.domain.devicestats.storage.model.FileDirectoriesSizeReportModel;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H&¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H&¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "", "", "detailTrackingIsEnabled", "()Z", "", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "getDirectoriesSizeInBytes", "()Ljava/util/List;", "", "getMinimumFileSizeInBytes", "()I", "isDaysRangeForRetrackingPassed", "isTrackingEnable", "", "saveTimeTracking", "()J", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;", "fileDirectoriesSizeReportModel", "sendReportToAnalytic", "(Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;)Z"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FileDirectoriesSizeRepository {
    boolean detailTrackingIsEnabled();

    List<FileDirectoriesModel> getDirectoriesSizeInBytes();

    int getMinimumFileSizeInBytes();

    boolean isDaysRangeForRetrackingPassed();

    boolean isTrackingEnable();

    long saveTimeTracking();

    boolean sendReportToAnalytic(FileDirectoriesSizeReportModel fileDirectoriesSizeReportModel);
}
