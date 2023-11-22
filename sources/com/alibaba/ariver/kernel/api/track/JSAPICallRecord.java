package com.alibaba.ariver.kernel.api.track;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class JSAPICallRecord {
    private String mAction;
    private long mEnd;
    private String mEventId;
    private String mTrackId;
    private long mStart = -1;
    private final Map<String, Object> mMap = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    public JSAPICallRecord(String str, String str2, String str3) {
        this.mTrackId = str;
        this.mAction = str2;
        this.mEventId = str3;
    }

    public String getEventId() {
        return this.mEventId;
    }

    public void setStart(long j) {
        this.mStart = j;
    }

    public long getStart() {
        return this.mStart;
    }

    public long getEnd() {
        return this.mEnd;
    }

    public void setEnd(long j) {
        this.mEnd = j;
    }

    public String getTrackId() {
        return this.mTrackId;
    }

    public String getAction() {
        return this.mAction;
    }

    public void putExtra(String str, Object obj) {
        this.mMap.put(str, obj);
    }

    public Object getExtra(String str) {
        return this.mMap.get(str);
    }

    private <T> T getValue(String str, T t) {
        T t2 = (T) this.mMap.get(str);
        return t2 != null ? t2 : t;
    }

    public int getExtraInt(String str) {
        return ((Integer) getValue(str, 0)).intValue();
    }

    public long getExtraLong(String str) {
        return ((Long) getValue(str, 0L)).longValue();
    }

    public String getExtraString(String str) {
        return (String) getValue(str, "");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if (this.mStart > 0) {
            sb.append("start");
            sb.append("=");
            sb.append(this.mStart);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        if (this.mEnd > this.mStart) {
            sb.append("end");
            sb.append("=");
            sb.append(this.mEnd);
            sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        }
        for (Map.Entry<String, Object> entry : this.mMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value != null) {
                sb.append(key);
                sb.append("=");
                sb.append(value);
                sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
