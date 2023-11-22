package id.dana.data.devicestats;

import id.dana.data.devicestats.entity.FileSystemStorageEntity;
import id.dana.data.devicestats.model.FileDirectoriesInMbModel;
import id.dana.data.util.DateTimeUtil;
import id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository;
import id.dana.domain.devicestats.storage.model.FileDirectoriesModel;
import id.dana.domain.devicestats.storage.model.FileDirectoriesSizeReportModel;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\"\u0012\u0006\u0010$\u001a\u00020\u0019\u0012\u0006\u0010%\u001a\u00020\u001c\u0012\u0006\u0010&\u001a\u00020\u0015\u0012\u0006\u0010'\u001a\u00020\u001f¢\u0006\u0004\b(\u0010)J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0004J\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001b\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010 R\u0014\u0010\u0016\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010#"}, d2 = {"Lid/dana/data/devicestats/FileSystemStatsRepository;", "Lid/dana/domain/devicestats/storage/FileDirectoriesSizeRepository;", "", "detailTrackingIsEnabled", "()Z", "", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "getDirectoriesSizeInBytes", "()Ljava/util/List;", "", "getMinimumFileSizeInBytes", "()I", "isDaysRangeForRetrackingPassed", "isTrackingEnable", "", "saveTimeTracking", "()J", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;", "p0", "sendReportToAnalytic", "(Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;)Z", "Lid/dana/data/devicestats/DeviceStatsAnalyticsEntityData;", "getAuthRequestContext", "Lid/dana/data/devicestats/DeviceStatsAnalyticsEntityData;", "PlaceComponentResult", "Lid/dana/data/devicestats/DeviceStatsConfigEntityData;", "Lid/dana/data/devicestats/DeviceStatsConfigEntityData;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/data/devicestats/DeviceStatsPreferenceEntityData;", "Lid/dana/data/devicestats/DeviceStatsPreferenceEntityData;", "MyBillsEntityDataFactory", "Lid/dana/data/devicestats/FileDirectoriesSizeMapper;", "Lid/dana/data/devicestats/FileDirectoriesSizeMapper;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/data/devicestats/entity/FileSystemStorageEntity;", "Lid/dana/data/devicestats/entity/FileSystemStorageEntity;", "p1", "p2", "p3", "p4", "<init>", "(Lid/dana/data/devicestats/entity/FileSystemStorageEntity;Lid/dana/data/devicestats/DeviceStatsConfigEntityData;Lid/dana/data/devicestats/DeviceStatsPreferenceEntityData;Lid/dana/data/devicestats/DeviceStatsAnalyticsEntityData;Lid/dana/data/devicestats/FileDirectoriesSizeMapper;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FileSystemStatsRepository implements FileDirectoriesSizeRepository {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final FileSystemStorageEntity getAuthRequestContext;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final DeviceStatsPreferenceEntityData MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final FileDirectoriesSizeMapper BuiltInFictitiousFunctionClassFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final DeviceStatsConfigEntityData KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final DeviceStatsAnalyticsEntityData PlaceComponentResult;

    @Inject
    public FileSystemStatsRepository(FileSystemStorageEntity fileSystemStorageEntity, DeviceStatsConfigEntityData deviceStatsConfigEntityData, DeviceStatsPreferenceEntityData deviceStatsPreferenceEntityData, DeviceStatsAnalyticsEntityData deviceStatsAnalyticsEntityData, FileDirectoriesSizeMapper fileDirectoriesSizeMapper) {
        Intrinsics.checkNotNullParameter(fileSystemStorageEntity, "");
        Intrinsics.checkNotNullParameter(deviceStatsConfigEntityData, "");
        Intrinsics.checkNotNullParameter(deviceStatsPreferenceEntityData, "");
        Intrinsics.checkNotNullParameter(deviceStatsAnalyticsEntityData, "");
        Intrinsics.checkNotNullParameter(fileDirectoriesSizeMapper, "");
        this.getAuthRequestContext = fileSystemStorageEntity;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = deviceStatsConfigEntityData;
        this.MyBillsEntityDataFactory = deviceStatsPreferenceEntityData;
        this.PlaceComponentResult = deviceStatsAnalyticsEntityData;
        this.BuiltInFictitiousFunctionClassFactory = fileDirectoriesSizeMapper;
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final boolean isTrackingEnable() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final List<FileDirectoriesModel> getDirectoriesSizeInBytes() {
        FileSystemStorageEntity fileSystemStorageEntity = this.getAuthRequestContext;
        ArrayList arrayList = new ArrayList();
        File parentFile = fileSystemStorageEntity.PlaceComponentResult.getApplicationContext().getFilesDir().getParentFile();
        if (parentFile != null) {
            fileSystemStorageEntity.PlaceComponentResult(parentFile, arrayList);
        }
        return arrayList;
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final int getMinimumFileSizeInBytes() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory();
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final boolean isDaysRangeForRetrackingPassed() {
        long BuiltInFictitiousFunctionClassFactory = this.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory();
        return BuiltInFictitiousFunctionClassFactory == 0 || ((DateTimeUtil.getCurrentTimeMillis() - BuiltInFictitiousFunctionClassFactory) / 86400000) - ((long) this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory()) >= 0;
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final boolean sendReportToAnalytic(FileDirectoriesSizeReportModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        DeviceStatsAnalyticsEntityData deviceStatsAnalyticsEntityData = this.PlaceComponentResult;
        Intrinsics.checkNotNullParameter(p0, "");
        List<FileDirectoriesInMbModel> authRequestContext = FileDirectoriesSizeMapper.getAuthRequestContext("Largest Directories in MB", p0.getLargestDirectories());
        List<FileDirectoriesInMbModel> authRequestContext2 = FileDirectoriesSizeMapper.getAuthRequestContext("Largest Files in MB", p0.getLargestFiles());
        Double appSizeInMb = p0.getAppSizeInMb();
        String error = p0.getError();
        JSONObject jSONObject = new JSONObject();
        if (error != null) {
            jSONObject.put("Error", error);
        }
        if (appSizeInMb != null) {
            jSONObject.put("Data Folder Size in MB", FileDirectoriesSizeMapper.BuiltInFictitiousFunctionClassFactory(appSizeInMb.doubleValue()));
        }
        if (authRequestContext != null) {
            for (FileDirectoriesInMbModel fileDirectoriesInMbModel : authRequestContext) {
                jSONObject.put(fileDirectoriesInMbModel.MyBillsEntityDataFactory, fileDirectoriesInMbModel.PlaceComponentResult);
            }
        }
        if (authRequestContext2 != null) {
            for (FileDirectoriesInMbModel fileDirectoriesInMbModel2 : authRequestContext2) {
                jSONObject.put(fileDirectoriesInMbModel2.MyBillsEntityDataFactory, fileDirectoriesInMbModel2.PlaceComponentResult);
            }
        }
        return deviceStatsAnalyticsEntityData.BuiltInFictitiousFunctionClassFactory(jSONObject);
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final long saveTimeTracking() {
        long currentTimeMillis = DateTimeUtil.getCurrentTimeMillis();
        this.MyBillsEntityDataFactory.MyBillsEntityDataFactory(currentTimeMillis);
        return currentTimeMillis;
    }

    @Override // id.dana.domain.devicestats.storage.FileDirectoriesSizeRepository
    public final boolean detailTrackingIsEnabled() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext();
    }
}
