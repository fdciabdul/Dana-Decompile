package com.alibaba.ariver.app.api.model;

import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class PluginParamModel {
    public static final String PLUGIN_PAGE_PREFIX = "plugin-private://";

    /* renamed from: a  reason: collision with root package name */
    private final JSONObject f5966a = new JSONObject();

    public void putPluginConfig(String str, AppConfigModel appConfigModel) {
        for (String str2 : appConfigModel.getPageLaunchParams().keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(PLUGIN_PAGE_PREFIX);
            sb.append(str);
            String combinePath = FileUtils.combinePath(sb.toString(), str2);
            Object obj = appConfigModel.getPageLaunchParams().get(str2);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("put plugin page param: ");
            sb2.append(combinePath);
            sb2.append(", ");
            sb2.append(obj);
            RVLogger.d(RVConstants.RESOURCE_TAG, sb2.toString());
            this.f5966a.put(combinePath, obj);
        }
    }

    public JSONObject getStartupParams() {
        return this.f5966a;
    }
}
