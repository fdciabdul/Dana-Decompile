package com.alibaba.ariver.resource.api.prepare;

import android.os.Bundle;
import com.alibaba.ariver.app.api.activity.StartAction;
import com.alibaba.ariver.resource.api.models.AppModel;

/* loaded from: classes3.dex */
public class PrepareCallbackParam {
    public StartAction action;
    public AppModel appInfo;
    public boolean needWaitIpc;
    public Bundle sceneParams;
    public Bundle startParams;

    public PrepareCallbackParam(PrepareContext prepareContext) {
        this.appInfo = prepareContext.getAppModel();
        this.startParams = prepareContext.getStartParams();
        this.sceneParams = prepareContext.getSceneParams();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrepareCallbackParam{, needWaitIpc=");
        sb.append(this.needWaitIpc);
        sb.append(", action=");
        sb.append(this.action);
        sb.append('}');
        return sb.toString();
    }
}
