package com.alibaba.ariver.engine.api.bridge.model;

import com.alibaba.ariver.engine.api.Render;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class RenderCallContext {
    public static final String TYPE_CALL = "call";
    public static final String TYPE_CALLBACK = "callback";

    /* renamed from: a  reason: collision with root package name */
    private String f6022a;
    private String b;
    private JSONObject c;
    private String d;
    private Render e;
    private boolean f;

    public RenderCallContext(Builder builder) {
        this.f6022a = builder.f6023a;
        this.b = builder.b;
        JSONObject jSONObject = builder.c;
        this.c = jSONObject;
        if (jSONObject == null) {
            this.c = new JSONObject();
        }
        this.d = builder.d;
        this.f = builder.f;
        this.e = builder.e;
    }

    public Render getTarget() {
        return this.e;
    }

    public String getEventId() {
        return this.f6022a;
    }

    public void setEventId(String str) {
        this.f6022a = str;
    }

    public String getAction() {
        return this.b;
    }

    public void setAction(String str) {
        this.b = str;
    }

    public JSONObject getParam() {
        return this.c;
    }

    public void setParam(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public String getType() {
        return this.d;
    }

    public void setType(String str) {
        this.d = str;
    }

    public boolean getKeep() {
        return this.f;
    }

    public void setKeep(boolean z) {
        this.f = z;
    }

    public static Builder newBuilder(Render render) {
        return new Builder(render);
    }

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f6023a;
        private String b;
        private JSONObject c;
        private String d;
        private Render e;
        private boolean f;

        public Builder(Render render) {
            StringBuilder sb = new StringBuilder();
            sb.append("native_");
            sb.append(System.currentTimeMillis());
            this.f6023a = sb.toString();
            this.e = render;
        }

        public Builder eventId(String str) {
            this.f6023a = str;
            return this;
        }

        public Builder action(String str) {
            this.b = str;
            return this;
        }

        public Builder param(JSONObject jSONObject) {
            this.c = jSONObject;
            return this;
        }

        public Builder type(String str) {
            this.d = str;
            return this;
        }

        public Builder keep(boolean z) {
            this.f = z;
            return this;
        }

        public RenderCallContext build() {
            return new RenderCallContext(this);
        }
    }
}
