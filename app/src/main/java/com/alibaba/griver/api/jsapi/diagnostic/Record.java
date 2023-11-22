package com.alibaba.griver.api.jsapi.diagnostic;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public class Record {
    private String errorNum;
    private Map<String, String> parameters;
    private long timeStamp;
    private String uuid;

    private Record(Builder builder) {
        this.timeStamp = System.currentTimeMillis();
        this.errorNum = builder.errorNum;
        this.parameters = builder.parameters;
        this.uuid = UUID.randomUUID().toString();
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public String getErrorNum() {
        return this.errorNum;
    }

    public Map<String, String> getParameters() {
        return this.parameters;
    }

    public String getUuid() {
        return this.uuid;
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        private String errorNum;
        private Map<String, String> parameters = new HashMap();

        public Builder(String str) {
            this.errorNum = str;
        }

        public Builder append(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.parameters.put(str, str2);
            }
            return this;
        }

        public Builder append(Map<String, String> map) {
            if (map != null) {
                for (String str : map.keySet()) {
                    append(str, map.get(str));
                }
            }
            return this;
        }

        public Record build() {
            return new Record(this);
        }
    }
}
