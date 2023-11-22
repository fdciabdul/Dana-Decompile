package com.alibaba.griver.mobilecommon.multimedia.api.data;

import com.alibaba.fastjson.annotation.JSONField;

/* loaded from: classes2.dex */
public class APMultimediaTaskModel {
    public static final String F_CLOUD_ID = "cloud_id";
    public static final String F_CREATE_TIME = "create_time";
    public static final String F_TASK_STATUS = "status";
    public static final int STATUS_CANCEL = 2;
    public static final int STATUS_FAIL = 3;
    public static final int STATUS_RUNNING = 1;
    public static final int STATUS_SUCCESS = 4;
    public static final int STATUS_WAIT = 0;
    @JSONField(name = "cacheId")
    private String cacheId;
    @JSONField(name = "cloudId")
    private String cloudId;
    @JSONField(name = "creatTime")
    private long creatTime;
    @JSONField(name = "currentSize")
    private long currentSize;
    @JSONField(name = "destPath")
    private String destPath;
    @JSONField(deserialize = false, serialize = false)
    public boolean loadTaskStatusFromDb;
    @JSONField(name = "sourcePath")
    private String sourcePath;
    @JSONField(name = "taskId")
    private String taskId;
    @JSONField(name = "totalSize")
    private long totalSize;
    @JSONField(name = "updateTime")
    private long updateTime;
    @JSONField(name = "status")
    private int status = 0;
    @JSONField(deserialize = false, serialize = false)
    public boolean loadFromMemCache = false;

    public String getCloudId() {
        return this.cloudId;
    }

    public void setCloudId(String str) {
        this.cloudId = str;
    }

    public String getTaskId() {
        return this.taskId;
    }

    public void setTaskId(String str) {
        this.taskId = str;
    }

    public long getCreatTime() {
        return this.creatTime;
    }

    public void setCreatTime(long j) {
        this.creatTime = j;
    }

    public long getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(long j) {
        this.updateTime = j;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int i) {
        this.status = i;
    }

    public String getSourcePath() {
        return this.sourcePath;
    }

    public void setSourcePath(String str) {
        this.sourcePath = str;
    }

    public String getDestPath() {
        return this.destPath;
    }

    public void setDestPath(String str) {
        this.destPath = str;
    }

    public long getTotalSize() {
        return this.totalSize;
    }

    public void setTotalSize(long j) {
        this.totalSize = j;
    }

    public long getCurrentSize() {
        return this.currentSize;
    }

    public void setCurrentSize(long j) {
        this.currentSize = j;
    }

    public String getCacheId() {
        return this.cacheId;
    }

    public void setCacheId(String str) {
        this.cacheId = str;
    }

    public int getPercent() {
        long j = this.totalSize;
        if (j > 0) {
            return (int) ((((float) this.currentSize) * 100.0f) / ((float) j));
        }
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("APMultimediaTaskModel{taskId='");
        sb.append(this.taskId);
        sb.append('\'');
        sb.append(", creatTime=");
        sb.append(this.creatTime);
        sb.append(", updateTime=");
        sb.append(this.updateTime);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", sourcePath='");
        sb.append(this.sourcePath);
        sb.append('\'');
        sb.append(", destPath='");
        sb.append(this.destPath);
        sb.append('\'');
        sb.append(", totalSize=");
        sb.append(this.totalSize);
        sb.append(", currentSize=");
        sb.append(this.currentSize);
        sb.append(", cacheId='");
        sb.append(this.cacheId);
        sb.append('\'');
        sb.append(", cloudId='");
        sb.append(this.cloudId);
        sb.append('\'');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.taskId.equals(((APMultimediaTaskModel) obj).taskId);
    }

    public int hashCode() {
        return super.hashCode();
    }
}
