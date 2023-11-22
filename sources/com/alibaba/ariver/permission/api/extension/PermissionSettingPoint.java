package com.alibaba.ariver.permission.api.extension;

import com.alibaba.ariver.kernel.api.extension.Extension;
import com.alibaba.ariver.kernel.api.extension.ExtensionOpt;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.iap.ac.android.acs.plugin.utils.Constants;

/* loaded from: classes6.dex */
public interface PermissionSettingPoint extends Extension {
    JSONObject getSetting(String str);

    /* loaded from: classes6.dex */
    public static class Inner {
        public static void setupMethodInvokeOptimizer() {
            ExtensionOpt.setupMethodInvokeOptimizer(PermissionSettingPoint.class, new ExtensionOpt.MethodInvokeOptimizer() { // from class: com.alibaba.ariver.permission.api.extension.PermissionSettingPoint.Inner.1
                @Override // com.alibaba.ariver.kernel.api.extension.ExtensionOpt.MethodInvokeOptimizer
                public final Object doMethodInvoke(String str, Extension extension, Object[] objArr) throws Throwable {
                    str.hashCode();
                    if (str.equals(Constants.JS_API_GET_SETTING)) {
                        return ((PermissionSettingPoint) extension).getSetting((String) objArr[0]);
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(str);
                    sb.append(AUScreenAdaptTool.PREFIX_ID);
                    sb.append(extension.getClass().getName());
                    throw new ExtensionOpt.MismatchMethodException(sb.toString());
                }
            });
        }
    }
}
