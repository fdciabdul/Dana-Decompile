package com.alipay.iap.android.aplog.log;

import com.alipay.iap.android.aplog.util.TraceIdUtil;
import com.huawei.hms.framework.common.ContainerUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class BaseLogInfo {
    private String DeviceID;
    private String UUID;
    private String appVersion;
    private HashMap<String, String> extParam;
    private HashMap<String, String> hardwareInfo;
    private Locale locale;
    private String network;
    private String recordTime;
    private String sequenceID;
    private String tenantID;
    private String userID;

    public abstract String getLogCategory();

    public void generateSequenceID() {
        this.sequenceID = TraceIdUtil.getNewTraceId();
    }

    public String getSequenceID() {
        return this.sequenceID;
    }

    public HashMap<String, String> getExtParam() {
        return this.extParam;
    }

    public void putExtParam(String str, String str2) {
        if (this.extParam == null) {
            this.extParam = new HashMap<>();
        }
        this.extParam.put(str, str2);
    }

    public String getDeviceID() {
        return this.DeviceID;
    }

    public void setDeviceID(String str) {
        this.DeviceID = str;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public void setAppVersion(String str) {
        this.appVersion = str;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setUserID(String str) {
        this.userID = str;
    }

    public String getTenantID() {
        return this.tenantID;
    }

    public void setTenantID(String str) {
        this.tenantID = str;
    }

    public String getRecordTime() {
        return this.recordTime;
    }

    public void setRecordTime(String str) {
        this.recordTime = str;
    }

    public String getUUID() {
        return this.UUID;
    }

    public void setUUID(String str) {
        this.UUID = str;
    }

    public String getNetwork() {
        return this.network;
    }

    public void setNetwork(String str) {
        this.network = str;
    }

    public HashMap<String, String> getHardwareInfo() {
        return this.hardwareInfo;
    }

    public void setHardwareInfo(HashMap<String, String> hashMap) {
        this.hardwareInfo = hashMap;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public void putAllExtParam(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            putExtParam(entry.getKey(), entry.getValue());
        }
    }

    public void putExtMapParam(String str, Map<String, String> map) {
        if (map == null || map.size() <= 0 || str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (value == null) {
                value = "";
            }
            if (key != null) {
                sb.append(key);
                sb.append(":");
                sb.append(value);
                sb.append(ContainerUtils.FIELD_DELIMITER);
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        putExtParam(str, sb.toString());
    }

    public void putExtListParam(String str, List<String> list) {
        if (list == null || list.size() <= 0 || str == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        sb.append("\n");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append("\n");
        }
        sb.append(")");
        putExtParam(str, sb.toString());
    }
}
