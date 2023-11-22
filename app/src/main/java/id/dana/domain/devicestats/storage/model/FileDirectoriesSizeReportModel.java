package id.dana.domain.devicestats.storage.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\"\u0010#J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJL\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001a\u0010\fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b\u001e\u0010\fR\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001f\u001a\u0004\b \u0010\bR\"\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b!\u0010\b"}, d2 = {"Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;", "", "", "component1", "()Ljava/lang/Double;", "", "Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "component2", "()Ljava/util/List;", "component3", "", "component4", "()Ljava/lang/String;", "appSizeInMb", "largestDirectories", "largestFiles", "error", "copy", "(Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)Lid/dana/domain/devicestats/storage/model/FileDirectoriesSizeReportModel;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Double;", "getAppSizeInMb", "Ljava/lang/String;", "getError", "Ljava/util/List;", "getLargestDirectories", "getLargestFiles", "<init>", "(Ljava/lang/Double;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FileDirectoriesSizeReportModel {
    private final Double appSizeInMb;
    private final String error;
    private final List<FileDirectoriesModel> largestDirectories;
    private final List<FileDirectoriesModel> largestFiles;

    public FileDirectoriesSizeReportModel() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileDirectoriesSizeReportModel copy$default(FileDirectoriesSizeReportModel fileDirectoriesSizeReportModel, Double d, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            d = fileDirectoriesSizeReportModel.appSizeInMb;
        }
        if ((i & 2) != 0) {
            list = fileDirectoriesSizeReportModel.largestDirectories;
        }
        if ((i & 4) != 0) {
            list2 = fileDirectoriesSizeReportModel.largestFiles;
        }
        if ((i & 8) != 0) {
            str = fileDirectoriesSizeReportModel.error;
        }
        return fileDirectoriesSizeReportModel.copy(d, list, list2, str);
    }

    /* renamed from: component1  reason: from getter */
    public final Double getAppSizeInMb() {
        return this.appSizeInMb;
    }

    public final List<FileDirectoriesModel> component2() {
        return this.largestDirectories;
    }

    public final List<FileDirectoriesModel> component3() {
        return this.largestFiles;
    }

    /* renamed from: component4  reason: from getter */
    public final String getError() {
        return this.error;
    }

    public final FileDirectoriesSizeReportModel copy(Double appSizeInMb, List<FileDirectoriesModel> largestDirectories, List<FileDirectoriesModel> largestFiles, String error) {
        return new FileDirectoriesSizeReportModel(appSizeInMb, largestDirectories, largestFiles, error);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FileDirectoriesSizeReportModel) {
            FileDirectoriesSizeReportModel fileDirectoriesSizeReportModel = (FileDirectoriesSizeReportModel) other;
            return Intrinsics.areEqual((Object) this.appSizeInMb, (Object) fileDirectoriesSizeReportModel.appSizeInMb) && Intrinsics.areEqual(this.largestDirectories, fileDirectoriesSizeReportModel.largestDirectories) && Intrinsics.areEqual(this.largestFiles, fileDirectoriesSizeReportModel.largestFiles) && Intrinsics.areEqual(this.error, fileDirectoriesSizeReportModel.error);
        }
        return false;
    }

    public final int hashCode() {
        Double d = this.appSizeInMb;
        int hashCode = d == null ? 0 : d.hashCode();
        List<FileDirectoriesModel> list = this.largestDirectories;
        int hashCode2 = list == null ? 0 : list.hashCode();
        List<FileDirectoriesModel> list2 = this.largestFiles;
        int hashCode3 = list2 == null ? 0 : list2.hashCode();
        String str = this.error;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDirectoriesSizeReportModel(appSizeInMb=");
        sb.append(this.appSizeInMb);
        sb.append(", largestDirectories=");
        sb.append(this.largestDirectories);
        sb.append(", largestFiles=");
        sb.append(this.largestFiles);
        sb.append(", error=");
        sb.append(this.error);
        sb.append(')');
        return sb.toString();
    }

    public FileDirectoriesSizeReportModel(Double d, List<FileDirectoriesModel> list, List<FileDirectoriesModel> list2, String str) {
        this.appSizeInMb = d;
        this.largestDirectories = list;
        this.largestFiles = list2;
        this.error = str;
    }

    public /* synthetic */ FileDirectoriesSizeReportModel(Double d, List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : list2, (i & 8) != 0 ? null : str);
    }

    @JvmName(name = "getAppSizeInMb")
    public final Double getAppSizeInMb() {
        return this.appSizeInMb;
    }

    @JvmName(name = "getLargestDirectories")
    public final List<FileDirectoriesModel> getLargestDirectories() {
        return this.largestDirectories;
    }

    @JvmName(name = "getLargestFiles")
    public final List<FileDirectoriesModel> getLargestFiles() {
        return this.largestFiles;
    }

    @JvmName(name = "getError")
    public final String getError() {
        return this.error;
    }
}
