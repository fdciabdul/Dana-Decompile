package id.dana.domain.uploadfiles;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0018\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJX\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0015\u001a\u00020\fHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u0019\u001a\u00020\f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\"\u0010\u0010\u001a\u00020\u00028\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u001f\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\"R\"\u0010\u0012\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u001f\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\"R$\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010\u000b\"\u0004\b'\u0010(R\"\u0010\u0011\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010\"R\"\u0010\u0015\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010+\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b,\u0010-R\"\u0010\u0013\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u001f\u001a\u0004\b.\u0010\u0004\"\u0004\b/\u0010\"R\"\u0010\u000f\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u001f\u001a\u0004\b0\u0010\u0004\"\u0004\b1\u0010\""}, d2 = {"Lid/dana/domain/uploadfiles/UploadFilesEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()[B", "", "component7", "()Z", "uri", "contentType", "fileName", "contentUrl", GriverMonitorConstants.KEY_SIZE, "file", "isHeic", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)Lid/dana/domain/uploadfiles/UploadFilesEntity;", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getContentType", "setContentType", "(Ljava/lang/String;)V", "getContentUrl", "setContentUrl", "[B", "getFile", "setFile", "([B)V", "getFileName", "setFileName", "Z", "setHeic", "(Z)V", "getSize", "setSize", "getUri", "setUri", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[BZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UploadFilesEntity {
    public String contentType;
    public String contentUrl;
    public byte[] file;
    public String fileName;
    public boolean isHeic;
    public String size;
    public String uri;

    public /* synthetic */ UploadFilesEntity() {
    }

    public static /* synthetic */ UploadFilesEntity copy$default(UploadFilesEntity uploadFilesEntity, String str, String str2, String str3, String str4, String str5, byte[] bArr, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = uploadFilesEntity.uri;
        }
        if ((i & 2) != 0) {
            str2 = uploadFilesEntity.contentType;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = uploadFilesEntity.fileName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = uploadFilesEntity.contentUrl;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = uploadFilesEntity.size;
        }
        String str9 = str5;
        if ((i & 32) != 0) {
            bArr = uploadFilesEntity.file;
        }
        byte[] bArr2 = bArr;
        if ((i & 64) != 0) {
            z = uploadFilesEntity.isHeic;
        }
        return uploadFilesEntity.copy(str, str6, str7, str8, str9, bArr2, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getUri() {
        return this.uri;
    }

    /* renamed from: component2  reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getContentUrl() {
        return this.contentUrl;
    }

    /* renamed from: component5  reason: from getter */
    public final String getSize() {
        return this.size;
    }

    /* renamed from: component6  reason: from getter */
    public final byte[] getFile() {
        return this.file;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getIsHeic() {
        return this.isHeic;
    }

    public final UploadFilesEntity copy(String uri, String contentType, String fileName, String contentUrl, String size, byte[] file, boolean isHeic) {
        Intrinsics.checkNotNullParameter(uri, "");
        Intrinsics.checkNotNullParameter(contentType, "");
        Intrinsics.checkNotNullParameter(fileName, "");
        Intrinsics.checkNotNullParameter(contentUrl, "");
        Intrinsics.checkNotNullParameter(size, "");
        return new UploadFilesEntity(uri, contentType, fileName, contentUrl, size, file, isHeic);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof UploadFilesEntity) {
            UploadFilesEntity uploadFilesEntity = (UploadFilesEntity) other;
            return Intrinsics.areEqual(this.uri, uploadFilesEntity.uri) && Intrinsics.areEqual(this.contentType, uploadFilesEntity.contentType) && Intrinsics.areEqual(this.fileName, uploadFilesEntity.fileName) && Intrinsics.areEqual(this.contentUrl, uploadFilesEntity.contentUrl) && Intrinsics.areEqual(this.size, uploadFilesEntity.size) && Intrinsics.areEqual(this.file, uploadFilesEntity.file) && this.isHeic == uploadFilesEntity.isHeic;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.uri.hashCode();
        int hashCode2 = this.contentType.hashCode();
        int hashCode3 = this.fileName.hashCode();
        int hashCode4 = this.contentUrl.hashCode();
        int hashCode5 = this.size.hashCode();
        byte[] bArr = this.file;
        int hashCode6 = bArr == null ? 0 : Arrays.hashCode(bArr);
        boolean z = this.isHeic;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("UploadFilesEntity(uri=");
        sb.append(this.uri);
        sb.append(", contentType=");
        sb.append(this.contentType);
        sb.append(", fileName=");
        sb.append(this.fileName);
        sb.append(", contentUrl=");
        sb.append(this.contentUrl);
        sb.append(", size=");
        sb.append(this.size);
        sb.append(", file=");
        sb.append(Arrays.toString(this.file));
        sb.append(", isHeic=");
        sb.append(this.isHeic);
        sb.append(')');
        return sb.toString();
    }

    public UploadFilesEntity(String str, String str2, String str3, String str4, String str5, byte[] bArr, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.uri = str;
        this.contentType = str2;
        this.fileName = str3;
        this.contentUrl = str4;
        this.size = str5;
        this.file = bArr;
        this.isHeic = z;
    }

    public /* synthetic */ UploadFilesEntity(String str, String str2, String str3, String str4, String str5, byte[] bArr, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, bArr, (i & 64) != 0 ? false : z);
    }

    @JvmName(name = "getUri")
    public final String getUri() {
        return this.uri;
    }

    @JvmName(name = "setUri")
    public final void setUri(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.uri = str;
    }

    @JvmName(name = "getContentType")
    public final String getContentType() {
        return this.contentType;
    }

    @JvmName(name = "setContentType")
    public final void setContentType(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.contentType = str;
    }

    @JvmName(name = "getFileName")
    public final String getFileName() {
        return this.fileName;
    }

    @JvmName(name = "setFileName")
    public final void setFileName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.fileName = str;
    }

    @JvmName(name = "getContentUrl")
    public final String getContentUrl() {
        return this.contentUrl;
    }

    @JvmName(name = "setContentUrl")
    public final void setContentUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.contentUrl = str;
    }

    @JvmName(name = "getSize")
    public final String getSize() {
        return this.size;
    }

    @JvmName(name = "setSize")
    public final void setSize(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.size = str;
    }

    @JvmName(name = "getFile")
    public final byte[] getFile() {
        return this.file;
    }

    @JvmName(name = "setFile")
    public final void setFile(byte[] bArr) {
        this.file = bArr;
    }

    @JvmName(name = "isHeic")
    public final boolean isHeic() {
        return this.isHeic;
    }

    @JvmName(name = "setHeic")
    public final void setHeic(boolean z) {
        this.isHeic = z;
    }
}
