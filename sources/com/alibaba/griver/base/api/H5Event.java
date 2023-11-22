package com.alibaba.griver.base.api;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class H5Event {
    public static final String FROM_WORK = "fromWork";
    public static final String TYPE_CALL = "call";
    public static final String TYPE_CALL_BACK = "callback";

    /* renamed from: a  reason: collision with root package name */
    private String f6278a;
    private Node b;
    private String c;
    private boolean d;
    private JSONObject e;
    private boolean f;
    private String g;
    private Object h;
    private String i;
    private boolean j;
    private H5CallBack k;
    private boolean l;

    /* loaded from: classes2.dex */
    public enum Error {
        NONE,
        NOT_FOUND,
        INVALID_PARAM,
        UNKNOWN_ERROR,
        FORBIDDEN
    }

    private H5Event(Builder builder) {
        this.j = false;
        this.f6278a = builder.f6279a;
        this.c = builder.c;
        this.d = builder.d;
        this.k = builder.g;
        this.g = builder.h;
        this.f = builder.f;
        this.e = builder.e;
        this.b = builder.b;
        this.h = builder.i;
        this.l = builder.j;
        this.i = builder.k;
        this.j = builder.l;
    }

    public String getEventSource() {
        return this.i;
    }

    public void setEventSource(String str) {
        this.i = str;
    }

    public boolean isDispatcherOnWorkerThread() {
        return this.l;
    }

    public H5CallBack getCallBack() {
        return this.k;
    }

    public void setCallBack(H5CallBack h5CallBack) {
        this.k = h5CallBack;
    }

    public final String getAction() {
        return this.f6278a;
    }

    public void setAction(String str) {
        this.f6278a = str;
    }

    public final boolean isCanceled() {
        return this.d;
    }

    public final void cancel() {
        this.d = true;
    }

    public final Node getTarget() {
        return this.b;
    }

    public final void setTarget(Node node) {
        this.b = node;
    }

    public final Activity getActivity() {
        Node node = this.b;
        if (node instanceof Page) {
            Page page = (Page) node;
            if (page.getPageContext() == null) {
                return null;
            }
            Activity activity = page.getPageContext().getActivity();
            if (activity instanceof Activity) {
                return activity;
            }
            return null;
        }
        return null;
    }

    public final Page getH5page() {
        Node node = this.b;
        if (node instanceof Page) {
            return (Page) node;
        }
        return null;
    }

    public final String getId() {
        return this.c;
    }

    public void setId(String str) {
        this.c = str;
    }

    public JSONObject getParam() {
        return this.e;
    }

    public void setParam(JSONObject jSONObject) {
        this.e = jSONObject;
    }

    public String getType() {
        return this.g;
    }

    public void setType(String str) {
        this.g = str;
    }

    public boolean isKeepCallback() {
        return this.f;
    }

    public Object getExtra() {
        return this.h;
    }

    public void setExtra(Object obj) {
        this.h = obj;
    }

    public boolean isSyncJsApi() {
        return this.j;
    }

    public void setIsSyncJsApi(boolean z) {
        this.j = z;
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f6279a;
        private Node b;
        private String c;
        private boolean d;
        private JSONObject e;
        private boolean f;
        private H5CallBack g;
        private String h;
        private Object i;
        private boolean j;
        private String k;
        private boolean l;

        public Builder() {
            StringBuilder sb = new StringBuilder();
            sb.append("native_");
            sb.append(System.currentTimeMillis());
            this.c = sb.toString();
            this.f = false;
            this.h = "call";
            this.l = false;
        }

        public Builder(H5Event h5Event) {
            StringBuilder sb = new StringBuilder();
            sb.append("native_");
            sb.append(System.currentTimeMillis());
            this.c = sb.toString();
            this.f = false;
            this.h = "call";
            this.l = false;
            this.f6279a = h5Event.f6278a;
            this.c = h5Event.c;
            this.d = h5Event.d;
            this.g = h5Event.k;
            this.h = h5Event.g;
            this.f = h5Event.f;
            this.e = h5Event.e;
            this.b = h5Event.b;
            this.i = h5Event.h;
            this.j = h5Event.l;
            this.k = h5Event.i;
            this.l = h5Event.j;
        }

        public Builder action(String str) {
            this.f6279a = str;
            return this;
        }

        public Builder target(Node node) {
            this.b = node;
            return this;
        }

        public Builder id(String str) {
            this.c = str;
            return this;
        }

        public Builder param(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public Builder type(String str) {
            this.h = str;
            return this;
        }

        public Builder callback(H5CallBack h5CallBack) {
            this.g = h5CallBack;
            return this;
        }

        public Builder cancel(boolean z) {
            this.d = z;
            return this;
        }

        public Builder keepCallback(boolean z) {
            this.f = z;
            return this;
        }

        public Builder dispatcherOnWorkerThread(boolean z) {
            this.j = z;
            return this;
        }

        public Builder eventSource(String str) {
            this.k = str;
            return this;
        }

        public Builder extra(Object obj) {
            this.i = obj;
            return this;
        }

        public Builder syncJsApi(Boolean bool) {
            this.l = bool.booleanValue();
            return this;
        }

        public H5Event build() {
            return new H5Event(this);
        }
    }
}
