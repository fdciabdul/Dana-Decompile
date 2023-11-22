package id.dana.domain.devicestats.storage;

import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.domain.devicestats.storage.model.FileDirectoriesModel;
import id.dana.domain.devicestats.storage.model.FileDirectoriesSizeReportModel;
import id.dana.domain.social.Result;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J#\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ#\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0086\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/domain/devicestats/storage/FileDirectorySizeReportExecutor;", "", "", GriverMonitorConstants.KEY_SIZE, "formatByteToMb", "(D)D", "", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "filteredFileDirectoriesInBytes", "getLargestDirectories", "(Ljava/util/List;)Ljava/util/List;", "getLargestFiles", "directoriesSizes", "getTotalAppSizeInBytes", "(Ljava/util/List;)D", "Lid/dana/domain/social/Result;", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;", BridgeDSL.INVOKE, "()Lid/dana/domain/social/Result;", "Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "fileDirectoriesSizeRepository", "Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "<init>", "(Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileDirectorySizeReportExecutor {
    private final FileDirectoriesSizeRepository fileDirectoriesSizeRepository;

    private final double formatByteToMb(double size) {
        return size / 1048576.0d;
    }

    @Inject
    public FileDirectorySizeReportExecutor(FileDirectoriesSizeRepository fileDirectoriesSizeRepository) {
        Intrinsics.checkNotNullParameter(fileDirectoriesSizeRepository, "");
        this.fileDirectoriesSizeRepository = fileDirectoriesSizeRepository;
    }

    public final Result<FileDirectoriesSizeReportModel> invoke() {
        FileDirectoriesSizeReportModel fileDirectoriesSizeReportModel;
        try {
            if (!this.fileDirectoriesSizeRepository.isTrackingEnable()) {
                return new Result.Error(new TrackingDisabledException());
            }
            if (!this.fileDirectoriesSizeRepository.isDaysRangeForRetrackingPassed()) {
                return new Result.Error(new StillCoolDownException());
            }
            List<FileDirectoriesModel> directoriesSizeInBytes = this.fileDirectoriesSizeRepository.getDirectoriesSizeInBytes();
            int minimumFileSizeInBytes = this.fileDirectoriesSizeRepository.getMinimumFileSizeInBytes();
            ArrayList arrayList = new ArrayList();
            for (Object obj : directoriesSizeInBytes) {
                if (((FileDirectoriesModel) obj).getSize() > ((double) minimumFileSizeInBytes)) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = arrayList;
            if (this.fileDirectoriesSizeRepository.detailTrackingIsEnabled()) {
                fileDirectoriesSizeReportModel = new FileDirectoriesSizeReportModel(Double.valueOf(getTotalAppSizeInBytes(directoriesSizeInBytes)), getLargestDirectories(arrayList2), getLargestFiles(arrayList2), null, 8, null);
            } else {
                fileDirectoriesSizeReportModel = new FileDirectoriesSizeReportModel(Double.valueOf(getTotalAppSizeInBytes(directoriesSizeInBytes)), CollectionsKt.emptyList(), CollectionsKt.emptyList(), null, 8, null);
            }
            FileDirectoriesSizeRepository fileDirectoriesSizeRepository = this.fileDirectoriesSizeRepository;
            fileDirectoriesSizeRepository.sendReportToAnalytic(fileDirectoriesSizeReportModel);
            fileDirectoriesSizeRepository.saveTimeTracking();
            return new Result.Success(fileDirectoriesSizeReportModel);
        } catch (Exception e) {
            this.fileDirectoriesSizeRepository.sendReportToAnalytic(new FileDirectoriesSizeReportModel(null, null, null, e.getMessage(), 7, null));
            return new Result.Error(e);
        }
    }

    private final List<FileDirectoriesModel> getLargestFiles(List<FileDirectoriesModel> filteredFileDirectoriesInBytes) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : filteredFileDirectoriesInBytes) {
            if (((FileDirectoriesModel) obj).isFile()) {
                arrayList.add(obj);
            }
        }
        List<FileDirectoriesModel> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.domain.devicestats.storage.FileDirectorySizeReportExecutor$getLargestFiles$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Double.valueOf(((FileDirectoriesModel) t2).getSize()), Double.valueOf(((FileDirectoriesModel) t).getSize()));
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (FileDirectoriesModel fileDirectoriesModel : sortedWith) {
            arrayList2.add(FileDirectoriesModel.copy$default(fileDirectoriesModel, null, formatByteToMb(fileDirectoriesModel.getSize()), false, 5, null));
        }
        return arrayList2;
    }

    private final List<FileDirectoriesModel> getLargestDirectories(List<FileDirectoriesModel> filteredFileDirectoriesInBytes) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : filteredFileDirectoriesInBytes) {
            if ((!((FileDirectoriesModel) obj).isFile()) != false) {
                arrayList.add(obj);
            }
        }
        List<FileDirectoriesModel> sortedWith = CollectionsKt.sortedWith(arrayList, new Comparator() { // from class: id.dana.domain.devicestats.storage.FileDirectorySizeReportExecutor$getLargestDirectories$$inlined$sortedByDescending$1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Double.valueOf(((FileDirectoriesModel) t2).getSize()), Double.valueOf(((FileDirectoriesModel) t).getSize()));
            }
        });
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sortedWith, 10));
        for (FileDirectoriesModel fileDirectoriesModel : sortedWith) {
            arrayList2.add(FileDirectoriesModel.copy$default(fileDirectoriesModel, null, formatByteToMb(fileDirectoriesModel.getSize()), false, 5, null));
        }
        return arrayList2;
    }

    private final double getTotalAppSizeInBytes(List<FileDirectoriesModel> directoriesSizes) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : directoriesSizes) {
            if (((FileDirectoriesModel) obj).isFile()) {
                arrayList.add(obj);
            }
        }
        double d = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d += ((FileDirectoriesModel) it.next()).getSize();
        }
        return formatByteToMb(d);
    }
}
