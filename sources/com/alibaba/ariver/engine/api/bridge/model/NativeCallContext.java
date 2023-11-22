package com.alibaba.ariver.engine.api.bridge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.BridgeResponseHelper;
import com.alibaba.ariver.engine.api.proxy.RVBridgeInterceptProxy;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.exthub.bridge.BridgeDispatchCallContext;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class NativeCallContext<T extends Node> extends BridgeDispatchCallContext implements Parcelable {
    public static final String CALL_MODE_ASYNC = "async";
    public static final String CALL_MODE_SYNC = "sync";
    public static final String CALL_MODE_UNKNOWN = "unknown";
    public static final String FROM_WORKER = "fromWorker";
    private final StatData b;
    private Render c;
    private String d;
    private JSONObject e;
    private T f;
    private String g;
    private String h;
    private String i;
    private String j;
    private String k;
    private JSONObject l;
    private String m;

    /* renamed from: a  reason: collision with root package name */
    private static final AtomicLong f6020a = new AtomicLong(Process.myPid());
    public static final Parcelable.Creator<NativeCallContext> CREATOR = new Parcelable.Creator<NativeCallContext>() { // from class: com.alibaba.ariver.engine.api.bridge.model.NativeCallContext.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NativeCallContext createFromParcel(Parcel parcel) {
            return new NativeCallContext(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NativeCallContext[] newArray(int i) {
            return new NativeCallContext[i];
        }
    };

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static long generateUniqueId() {
        return System.currentTimeMillis() + f6020a.addAndGet(1L);
    }

    /* loaded from: classes3.dex */
    public static class StatData implements Parcelable {
        public static final Parcelable.Creator<StatData> CREATOR = new Parcelable.Creator<StatData>() { // from class: com.alibaba.ariver.engine.api.bridge.model.NativeCallContext.StatData.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StatData createFromParcel(Parcel parcel) {
                return new StatData(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public final StatData[] newArray(int i) {
                return new StatData[i];
            }
        };
        public long callbackTimeStamp;
        public long executeTimeStamp;
        public long triggerTimeStamp;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public StatData() {
        }

        protected StatData(Parcel parcel) {
            this.triggerTimeStamp = parcel.readLong();
            this.executeTimeStamp = parcel.readLong();
            this.callbackTimeStamp = parcel.readLong();
        }

        public void copyData(StatData statData) {
            if (statData == null) {
                return;
            }
            this.triggerTimeStamp = statData.triggerTimeStamp;
            this.executeTimeStamp = statData.executeTimeStamp;
            this.callbackTimeStamp = statData.callbackTimeStamp;
        }

        public String print() {
            StringBuilder sb = new StringBuilder();
            sb.append("total(");
            sb.append(this.callbackTimeStamp - this.triggerTimeStamp);
            sb.append(")|dispatch(");
            sb.append(this.executeTimeStamp - this.triggerTimeStamp);
            sb.append(")");
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeLong(this.triggerTimeStamp);
            parcel.writeLong(this.executeTimeStamp);
            parcel.writeLong(this.callbackTimeStamp);
        }
    }

    public static Builder newBuilder(String str) {
        return new Builder().name(str);
    }

    public NativeCallContext() {
        this.b = new StatData();
    }

    private NativeCallContext(Builder builder) {
        StatData statData = new StatData();
        this.b = statData;
        this.c = builder.render;
        this.d = builder.name;
        this.e = builder.params;
        this.f = (T) builder.node;
        this.g = builder.f6021id;
        this.h = builder.source;
        this.k = builder.originalData;
        this.l = builder.originalJsonData;
        String string = JSONUtils.getString(this.e, "__appxDomain");
        if (!TextUtils.isEmpty(string) && FROM_WORKER.equalsIgnoreCase(this.h)) {
            if (!GriverOnPreloadExtension.PARAMS_APP.equalsIgnoreCase(string) && !"appx".equalsIgnoreCase(string)) {
                this.i = string;
            }
            this.j = string;
        }
        statData.copyData(builder.statData);
        this.m = builder.callMode;
    }

    protected NativeCallContext(Parcel parcel) {
        this.b = new StatData();
        this.d = parcel.readString();
        this.g = parcel.readString();
        this.h = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            parcel.readByteArray(bArr);
            this.e = JSONUtils.unmarshallJSONObject(bArr);
        }
        this.f = (T) parcel.readParcelable(NativeCallContext.class.getClassLoader());
        this.i = parcel.readString();
        this.m = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.d);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        byte[] marshallJSONObject = JSONUtils.marshallJSONObject(this.e);
        int length = marshallJSONObject == null ? 0 : marshallJSONObject.length;
        parcel.writeInt(length);
        if (length > 0) {
            parcel.writeByteArray(marshallJSONObject, 0, length);
        }
        parcel.writeParcelable(this.f, 0);
        parcel.writeString(this.i);
        parcel.writeString(this.m);
    }

    public Render getRender() {
        return this.c;
    }

    public void setRender(Render render) {
        this.c = render;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public String getName() {
        return this.d;
    }

    public void setName(String str) {
        this.d = str;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public JSONObject getParams() {
        return this.e;
    }

    public void setParams(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public T getNode() {
        return this.f;
    }

    public void setNode(T t) {
        this.f = t;
    }

    public void setPluginId(String str) {
        this.i = str;
    }

    public String getPluginId() {
        return this.i;
    }

    public void setAppxDomain(String str) {
        this.j = str;
    }

    public String getAppxDomain() {
        return this.j;
    }

    @Override // com.alibaba.exthub.bridge.BridgeDispatchCallContext
    public String getId() {
        return this.g;
    }

    public void setId(String str) {
        this.g = str;
    }

    public String getSource() {
        return this.h;
    }

    public void setSource(String str) {
        this.h = str;
    }

    public StatData getStatData() {
        return this.b;
    }

    public String getOriginalData() {
        return this.k;
    }

    public JSONObject getOriginalJsonData() {
        return this.l;
    }

    public void setOriginalData(String str) {
        this.k = str;
    }

    public String getCallMode() {
        return this.m;
    }

    public void setCallMode(String str) {
        this.m = str;
    }

    public void setExecuteTimeStamp(long j) {
        getStatData().executeTimeStamp = SystemClock.elapsedRealtime();
    }

    public boolean bridgeInterceptPreInvoke(Node node, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper) {
        return ((RVBridgeInterceptProxy) RVProxy.get(RVBridgeInterceptProxy.class)).preInvoke(node, this, apiContext, bridgeResponseHelper);
    }

    public boolean bridgeInterceptPostInvoke(Node node, ApiContext apiContext, BridgeResponseHelper bridgeResponseHelper) {
        return ((RVBridgeInterceptProxy) RVProxy.get(RVBridgeInterceptProxy.class)).postInvoke(node, this, apiContext, bridgeResponseHelper);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NativeCallContext{name=");
        sb.append(this.d);
        sb.append(", params=");
        sb.append(this.e);
        sb.append(", id=");
        sb.append(this.g);
        if (this.i != null) {
            sb.append(", pluginId=");
            sb.append(this.i);
        }
        sb.append(", callMode=");
        sb.append(this.m);
        sb.append("}");
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class Builder {
        public String callMode;
        public boolean dispatcherOnWorkerThread;

        /* renamed from: id  reason: collision with root package name */
        public String f6021id;
        public String name;
        public Node node;
        public String originalData;
        public JSONObject originalJsonData;
        public JSONObject params;
        public Render render;
        public String source;
        public StatData statData;

        public Builder() {
            StringBuilder sb = new StringBuilder();
            sb.append("native_");
            sb.append(System.currentTimeMillis());
            this.f6021id = sb.toString();
            this.callMode = "unknown";
        }

        public Builder name(String str) {
            this.name = str;
            return this;
        }

        public Builder params(JSONObject jSONObject) {
            this.params = jSONObject;
            return this;
        }

        public Builder node(Node node) {
            this.node = node;
            return this;
        }

        public Builder render(Render render) {
            this.render = render;
            return this;
        }

        public Builder id(String str) {
            this.f6021id = str;
            return this;
        }

        public Builder source(String str) {
            this.source = str;
            return this;
        }

        public Builder originalData(String str) {
            this.originalData = str;
            return this;
        }

        public Builder originalJsonData(JSONObject jSONObject) {
            this.originalJsonData = jSONObject;
            return this;
        }

        public Builder dispatcherOnWorkerThread(boolean z) {
            this.dispatcherOnWorkerThread = z;
            return this;
        }

        public Builder generateLegacyNativeId() {
            StringBuilder sb = new StringBuilder();
            sb.append("native_");
            sb.append(System.currentTimeMillis());
            this.f6021id = sb.toString();
            return this;
        }

        public Builder callMode(String str) {
            this.callMode = str;
            return this;
        }

        public NativeCallContext build() {
            return new NativeCallContext(this);
        }
    }
}
