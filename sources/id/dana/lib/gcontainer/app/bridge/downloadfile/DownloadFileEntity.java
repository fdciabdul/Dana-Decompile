package id.dana.lib.gcontainer.app.bridge.downloadfile;

import com.alibaba.fastjson.annotation.JSONField;
import id.dana.lib.gcontainer.app.bridge.constant.BridgeKey;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R$\u0010\u0005\u001a\u0004\u0018\u00010\u00028G@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\u0004\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\u0004\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0004\b\u000f\u0010\tR$\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\u0004\"\u0004\b\u0012\u0010\tR$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\u0004\"\u0004\b\u0015\u0010\tR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\u0004\"\u0004\b\u0018\u0010\tR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u001a\u0010\u0004\"\u0004\b\u001b\u0010\t"}, d2 = {"Lid/dana/lib/gcontainer/app/bridge/downloadfile/DownloadFileEntity;", "", "", "getCleanFileName", "()Ljava/lang/String;", "businessName", "Ljava/lang/String;", "getBusinessName", "setBusinessName", "(Ljava/lang/String;)V", "fileFormat", "getFileFormat", "setFileFormat", "fileName", "getFileName", "setFileName", BridgeKey.FILE_PATH, "getFilePath", "setFilePath", "fileType", "getFileType", "setFileType", "source", "getSource", "setSource", "url", "getUrl", "setUrl", "<init>", "()V"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class DownloadFileEntity {
    @JSONField(name = "businessName")
    private String businessName;
    @JSONField(name = "fileFormat")
    private String fileFormat;
    @JSONField(name = "filename")
    private String fileName;
    @JSONField(name = BridgeKey.FILE_PATH)
    private String filePath;
    @JSONField(name = "fileType")
    private String fileType;
    @JSONField(name = "source")
    private String source;
    @JSONField(name = "url")
    private String url;

    @JvmName(name = "getUrl")
    public final String getUrl() {
        return this.url;
    }

    @JvmName(name = "setUrl")
    public final void setUrl(String str) {
        this.url = str;
    }

    @JvmName(name = "getFilePath")
    public final String getFilePath() {
        return this.filePath;
    }

    @JvmName(name = "setFilePath")
    public final void setFilePath(String str) {
        this.filePath = str;
    }

    @JvmName(name = "getSource")
    public final String getSource() {
        return this.source;
    }

    @JvmName(name = "setSource")
    public final void setSource(String str) {
        this.source = str;
    }

    @JvmName(name = "getFileType")
    public final String getFileType() {
        return this.fileType;
    }

    @JvmName(name = "setFileType")
    public final void setFileType(String str) {
        this.fileType = str;
    }

    @JvmName(name = "getFileFormat")
    public final String getFileFormat() {
        return this.fileFormat;
    }

    @JvmName(name = "setFileFormat")
    public final void setFileFormat(String str) {
        this.fileFormat = str;
    }

    @JvmName(name = "getFileName")
    public final String getFileName() {
        return this.fileName;
    }

    @JvmName(name = "setFileName")
    public final void setFileName(String str) {
        this.fileName = str;
    }

    @JvmName(name = "setBusinessName")
    public final void setBusinessName(String str) {
        this.businessName = str;
    }

    @JvmName(name = "getBusinessName")
    public final String getBusinessName() {
        String str = this.businessName;
        if (str == null) {
            return null;
        }
        return new Regex("[^A-Za-z0-9]").replace(str, "");
    }

    public final String getCleanFileName() {
        String replaceAll;
        replaceAll = this.fileName.replaceAll("[^A-Za-z0-9]", "");
        return replaceAll == null ? "" : replaceAll;
    }
}
