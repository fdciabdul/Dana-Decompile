package com.alibaba.ariver.app.api.point.dialog;

import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface ContainerCheckPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    void onRpcResult(String str, JSONObject jSONObject);
}
