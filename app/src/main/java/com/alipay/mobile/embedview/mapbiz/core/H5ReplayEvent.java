package com.alipay.mobile.embedview.mapbiz.core;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public class H5ReplayEvent {
    public static final int TYPE_MESSAGE = 2;
    public static final int TYPE_RENDER = 1;
    protected String mAction;
    protected BridgeCallback mCallback;
    protected JSONObject mData;
    protected int mType;

    private H5ReplayEvent() {
    }

    public int getType() {
        return this.mType;
    }

    public String getAction() {
        return this.mAction;
    }

    public JSONObject getData() {
        return this.mData;
    }

    public BridgeCallback getCallback() {
        return this.mCallback;
    }

    public boolean isUrgent() {
        return this.mType == 2 && TextUtils.equals(this.mAction, "calculateDistance");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("H5ReplayEvent@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(" -> ");
        int i = this.mType;
        if (i == 1) {
            sb.append("NBComponent.render");
        } else if (i == 2) {
            sb.append("NBComponent.sendMessage: ");
            sb.append(this.mAction);
        }
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        protected H5ReplayEvent event = new H5ReplayEvent();

        public Builder type(int i) {
            this.event.mType = i;
            return this;
        }

        public Builder action(String str) {
            this.event.mAction = str;
            return this;
        }

        public Builder data(JSONObject jSONObject) {
            this.event.mData = jSONObject;
            return this;
        }

        public Builder callback(BridgeCallback bridgeCallback) {
            this.event.mCallback = bridgeCallback;
            return this;
        }

        public H5ReplayEvent build() {
            return this.event;
        }
    }
}
