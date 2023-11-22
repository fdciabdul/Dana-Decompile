package id.dana.domain.devicestats.storage.model;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import id.dana.biometric.domain.model.BiometricDataSize$$ExternalSyntheticBackport0;
import id.dana.sendmoney.summary.SummaryActivity;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ.\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0017\u0010\r\u001a\u00020\b8\u0007¢\u0006\f\n\u0004\b\r\u0010\u0017\u001a\u0004\b\r\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001a\u0010\f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007"}, d2 = {"Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "", "", "component1", "()Ljava/lang/String;", "", "component2", "()D", "", "component3", "()Z", "path", GriverMonitorConstants.KEY_SIZE, "isFile", "copy", "(Ljava/lang/String;DZ)Lid/dana/domain/devicestats/storage/model/FileDirectoriesModel;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "Ljava/lang/String;", "getPath", SummaryActivity.DAYS, "getSize", "<init>", "(Ljava/lang/String;DZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class FileDirectoriesModel {
    private final boolean isFile;
    private final String path;
    private final double size;

    public static /* synthetic */ FileDirectoriesModel copy$default(FileDirectoriesModel fileDirectoriesModel, String str, double d, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = fileDirectoriesModel.path;
        }
        if ((i & 2) != 0) {
            d = fileDirectoriesModel.size;
        }
        if ((i & 4) != 0) {
            z = fileDirectoriesModel.isFile;
        }
        return fileDirectoriesModel.copy(str, d, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPath() {
        return this.path;
    }

    /* renamed from: component2  reason: from getter */
    public final double getSize() {
        return this.size;
    }

    /* renamed from: component3  reason: from getter */
    public final boolean getIsFile() {
        return this.isFile;
    }

    public final FileDirectoriesModel copy(String path, double size, boolean isFile) {
        Intrinsics.checkNotNullParameter(path, "");
        return new FileDirectoriesModel(path, size, isFile);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof FileDirectoriesModel) {
            FileDirectoriesModel fileDirectoriesModel = (FileDirectoriesModel) other;
            return Intrinsics.areEqual(this.path, fileDirectoriesModel.path) && Intrinsics.areEqual((Object) Double.valueOf(this.size), (Object) Double.valueOf(fileDirectoriesModel.size)) && this.isFile == fileDirectoriesModel.isFile;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.path.hashCode();
        int KClassImpl$Data$declaredNonStaticMembers$2 = BiometricDataSize$$ExternalSyntheticBackport0.KClassImpl$Data$declaredNonStaticMembers$2(this.size);
        boolean z = this.isFile;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((hashCode * 31) + KClassImpl$Data$declaredNonStaticMembers$2) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FileDirectoriesModel(path=");
        sb.append(this.path);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", isFile=");
        sb.append(this.isFile);
        sb.append(')');
        return sb.toString();
    }

    public FileDirectoriesModel(String str, double d, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.path = str;
        this.size = d;
        this.isFile = z;
    }

    @JvmName(name = "getPath")
    public final String getPath() {
        return this.path;
    }

    @JvmName(name = "getSize")
    public final double getSize() {
        return this.size;
    }

    @JvmName(name = "isFile")
    public final boolean isFile() {
        return this.isFile;
    }
}
