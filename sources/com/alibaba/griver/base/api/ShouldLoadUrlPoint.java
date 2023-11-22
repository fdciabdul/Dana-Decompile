package com.alibaba.griver.base.api;

import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes2.dex */
public interface ShouldLoadUrlPoint extends Extension {
    @ThreadType(ExecutorType.SYNC)
    boolean shouldLoad(JSONObject jSONObject, String str);
}
