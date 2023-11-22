package com.alibaba.ariver.app.api.point.app;

import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes6.dex */
public interface AppCreateMenuPoint extends Extension {

    /* loaded from: classes6.dex */
    public static class Action {
        public String method;
        public JSONObject params;
    }

    /* loaded from: classes6.dex */
    public enum Type {
        ABOUT
    }

    Action createMenuAction(App app, Type type);
}
