package com.alibaba.ariver.kernel.api.track;

import android.os.SystemClock;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class Event {

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f6107a;
    protected long timestamp;
    protected String trackId;

    public abstract String getValue();

    private Event() {
        this.timestamp = SystemClock.elapsedRealtime();
    }

    private Event(String str) {
        this.timestamp = SystemClock.elapsedRealtime();
        this.trackId = str;
    }

    public Event setTrackId(String str) {
        this.trackId = str;
        return this;
    }

    public String getTrackId() {
        return this.trackId;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public Event putAttr(EventAttr eventAttr, int i) {
        return putAttr(eventAttr.value(), Integer.valueOf(i));
    }

    public Event putAttr(EventAttr eventAttr, long j) {
        return putAttr(eventAttr.value(), Long.valueOf(j));
    }

    public Event putAttr(EventAttr eventAttr, String str) {
        return putAttr(eventAttr.value(), str);
    }

    public void setAttrData(Map<String, String> map) {
        this.f6107a = map;
    }

    public Map<String, String> getAttrData() {
        return this.f6107a;
    }

    public Event putAttr(String str, Object obj) {
        if (str == null || str.length() <= 0 || obj == null || str.charAt(0) == '_') {
            return this;
        }
        if (this.f6107a == null) {
            this.f6107a = new HashMap();
        }
        this.f6107a.put(str, obj.toString());
        return this;
    }

    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("_key", this.trackId);
        hashMap.put("_tms", Long.toString(this.timestamp));
        Map<String, String> map = this.f6107a;
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(this.f6107a);
        }
        return hashMap;
    }

    public String toString() {
        return StringUtils.map2String(toMap());
    }

    public String getKey() {
        return this.trackId;
    }

    /* loaded from: classes6.dex */
    public static class Stub extends Event {
        public Stub() {
            super();
        }

        public Stub(long j) {
            super();
            this.timestamp = j;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return Long.toString(this.timestamp);
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public Map<String, String> toMap() {
            Map<String, String> map = super.toMap();
            map.put("_tms", Long.toString(this.timestamp));
            return map;
        }
    }

    /* loaded from: classes6.dex */
    public static class Cost extends Event {

        /* renamed from: a  reason: collision with root package name */
        private long f6109a;

        public Cost(long j) {
            super();
            this.f6109a = j;
        }

        public long getCost() {
            return this.f6109a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return Long.toString(this.f6109a);
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public Map<String, String> toMap() {
            Map<String, String> map = super.toMap();
            map.put("_cst", Long.toString(this.f6109a));
            return map;
        }
    }

    /* loaded from: classes6.dex */
    public static class Error extends Event {

        /* renamed from: a  reason: collision with root package name */
        private String f6110a;

        public Error(String str) {
            super();
            this.f6110a = str;
        }

        public String getReason() {
            return this.f6110a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return this.f6110a;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public Map<String, String> toMap() {
            Map<String, String> map = super.toMap();
            map.put("_rsn", this.f6110a);
            return map;
        }
    }

    /* loaded from: classes6.dex */
    public static class Behavior extends Event {

        /* renamed from: a  reason: collision with root package name */
        private String f6108a;
        private String b;

        public Behavior(String str) {
            super();
            setTrackId(str);
        }

        public String getType() {
            return this.f6108a;
        }

        public Behavior setType(String str) {
            this.f6108a = str;
            return this;
        }

        public String getParam() {
            return this.b;
        }

        public Behavior setParam(String str) {
            this.b = str;
            return this;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return this.f6108a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Fatal extends Event {

        /* renamed from: a  reason: collision with root package name */
        private String f6111a;
        private String b;
        private String c;

        public Fatal(String str, String str2, String str3) {
            super(str);
            setReason(str2);
            setFailCode(str3);
        }

        public Fatal(String str, String str2, String str3, String str4) {
            super(str);
            setReason(str2);
            setType(str3);
            setFailCode(str4);
        }

        public String getReason() {
            return this.f6111a;
        }

        public void setReason(String str) {
            this.f6111a = str;
            putAttr(EventAttr.Key_fatalReason, str);
        }

        public String getType() {
            return this.b;
        }

        public void setType(String str) {
            this.b = str;
            putAttr(EventAttr.Key_fatalType, str);
        }

        public String getFailCode() {
            return this.c;
        }

        public void setFailCode(String str) {
            this.c = str;
        }

        @Override // com.alibaba.ariver.kernel.api.track.Event
        public String getValue() {
            return this.f6111a;
        }
    }
}
