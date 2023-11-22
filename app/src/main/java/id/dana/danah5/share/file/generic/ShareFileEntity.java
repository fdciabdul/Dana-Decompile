package id.dana.danah5.share.file.generic;

import android.text.TextUtils;

/* loaded from: classes2.dex */
public class ShareFileEntity {
    private static final String DEFAULT_NAME;
    private static final long MINIMUM_STORAGE_AVAILABLE = 100;
    private String fileName;
    private String filePath;
    private String fileType;
    private long minStorageAvailable;
    private String source;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("DANA_");
        sb.append(Math.random());
        DEFAULT_NAME = sb.toString();
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public String getFileType() {
        return this.fileType;
    }

    public void setFileType(String str) {
        this.fileType = str;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public String getFileName() {
        String replaceAll;
        if (TextUtils.isEmpty(this.fileName)) {
            return DEFAULT_NAME;
        }
        replaceAll = this.fileName.replaceAll("[^A-Za-z0-9]", "");
        return replaceAll;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public String getExtension(String str) {
        return str.substring(str.lastIndexOf(46));
    }

    public long getMinStorageAvailable() {
        long j = this.minStorageAvailable;
        if (j == 0) {
            return 100L;
        }
        return j;
    }

    public void setMinStorageAvailable(long j) {
        this.minStorageAvailable = j;
    }
}
