package com.alibaba.griver.base.t2;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;

/* loaded from: classes3.dex */
public class JSScriptBuildHelper {
    public static final String TAG = "JSScriptBuildHelper";

    public static String buildJSStringEndOfBody(String str, boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("var script,body=document.body||document.documentElement;script=document.createElement(\"script\");script.async=true;script.charset=\"UTF-8\";script.src=\"");
            sb.append(str);
            sb.append("\";");
            sb.append(getCrossOrigin(str));
            sb.append("body.appendChild(script);");
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("var script,body=document.body||document.documentElement;script=document.createElement(\"script\");script.async=false;script.charset=\"UTF-8\";script.src=\"");
        sb2.append(str);
        sb2.append("\";");
        sb2.append(getCrossOrigin(str));
        sb2.append("body.appendChild(script);");
        return sb2.toString();
    }

    public static String getCrossOrigin(String str) {
        return (TextUtils.isEmpty(str) || !str.contains("nebula-addcors")) ? "" : "script.setAttribute('crossorigin','');";
    }

    public static String buildJSStringOfHeader(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("var script,head=document.head||document.documentElement;script=document.createElement(\"script\");script.async=false;script.charset=\"UTF-8\";script.src=\"");
        sb.append(str);
        sb.append("\";");
        sb.append(getCrossOrigin(str));
        sb.append("head.appendChild(script);");
        return sb.toString();
    }

    public static String buildScriptString(String str) {
        String format = String.format("<script type='text/javascript' charset='utf-8' src='%s' %s >%s</script>", str, (TextUtils.isEmpty(str) || !str.contains("nebula-addcors")) ? "" : "'crossorigin'", "");
        StringBuilder sb = new StringBuilder();
        sb.append("buildScriptString load end end");
        sb.append(format);
        RVLogger.d("JSScriptBuildHelper", sb.toString());
        return format;
    }
}
