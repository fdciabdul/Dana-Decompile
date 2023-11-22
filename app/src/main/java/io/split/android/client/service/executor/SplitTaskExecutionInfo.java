package io.split.android.client.service.executor;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class SplitTaskExecutionInfo {
    public static final String NON_SENT_BYTES = "NON_SENT_BYTES";
    public static final String NON_SENT_RECORDS = "NON_SENT_RECORDS";
    private final Map<String, Object> data;
    private final SplitTaskExecutionStatus status;
    private final SplitTaskType taskType;

    public static SplitTaskExecutionInfo success(SplitTaskType splitTaskType) {
        return new SplitTaskExecutionInfo(splitTaskType, SplitTaskExecutionStatus.SUCCESS, new HashMap());
    }

    public static SplitTaskExecutionInfo success(SplitTaskType splitTaskType, Map<String, Object> map) {
        return new SplitTaskExecutionInfo(splitTaskType, SplitTaskExecutionStatus.SUCCESS, map);
    }

    public static SplitTaskExecutionInfo error(SplitTaskType splitTaskType) {
        return new SplitTaskExecutionInfo(splitTaskType, SplitTaskExecutionStatus.ERROR, new HashMap());
    }

    public static SplitTaskExecutionInfo error(SplitTaskType splitTaskType, Map<String, Object> map) {
        return new SplitTaskExecutionInfo(splitTaskType, SplitTaskExecutionStatus.ERROR, map);
    }

    private SplitTaskExecutionInfo(SplitTaskType splitTaskType, SplitTaskExecutionStatus splitTaskExecutionStatus, Map<String, Object> map) {
        this.taskType = (SplitTaskType) Preconditions.checkNotNull(splitTaskType);
        this.status = (SplitTaskExecutionStatus) Preconditions.checkNotNull(splitTaskExecutionStatus);
        this.data = (Map) Preconditions.checkNotNull(map);
    }

    public SplitTaskExecutionStatus getStatus() {
        return this.status;
    }

    public SplitTaskType getTaskType() {
        return this.taskType;
    }

    public Integer getIntegerValue(String str) {
        Object obj = this.data.get(str);
        if (obj != null) {
            return Integer.valueOf(Integer.parseInt(obj.toString()));
        }
        return null;
    }

    public Long getLongValue(String str) {
        Object obj = this.data.get(str);
        if (obj != null) {
            return Long.valueOf(Long.parseLong(obj.toString()));
        }
        return null;
    }

    public String getStringValue(String str) {
        Object obj = this.data.get(str);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }

    public Boolean getBoolValue(String str) {
        Object obj = this.data.get(str);
        if (obj != null) {
            return Boolean.valueOf(Boolean.parseBoolean(obj.toString()));
        }
        return null;
    }

    public Object getObjectValue(String str) {
        return this.data.get(str);
    }
}
