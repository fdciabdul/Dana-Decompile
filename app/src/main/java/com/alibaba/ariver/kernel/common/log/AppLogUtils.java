package com.alibaba.ariver.kernel.common.log;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.api.node.DataNode;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.log.PageLog;

/* loaded from: classes3.dex */
public class AppLogUtils {
    public static String getParentId(Node node) {
        AppLogContext appLogContext;
        if (node == null) {
            return "";
        }
        if ((node instanceof DataNode) && (appLogContext = (AppLogContext) ((DataNode) node).getData(AppLogContext.class)) != null) {
            String pageLogToken = appLogContext.getPageLogToken();
            if (!TextUtils.isEmpty(pageLogToken)) {
                return pageLogToken;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(node.getNodeId());
        return sb.toString();
    }

    public static void generatePageTag(Node node, String str) {
        AppLogContext appLogContext;
        String str2;
        if (node == null || !(node instanceof DataNode) || (appLogContext = (AppLogContext) ((DataNode) node).getData(AppLogContext.class)) == null || appLogContext.isAlreadyRecordTagLog()) {
            return;
        }
        appLogContext.setAlreadyRecordTagLog(true);
        PageLog.Builder builder = new PageLog.Builder();
        builder.setState(PageLog.PAGE_LOG_TAGS).setParentId(appLogContext.getPageLogToken());
        String str3 = "";
        if (appLogContext.hasJSAPIError()) {
            StringBuilder sb = new StringBuilder();
            sb.append(" API");
            str2 = sb.toString();
        } else {
            str2 = "";
        }
        if (appLogContext.hasJSError()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            sb2.append(" JS");
            str2 = sb2.toString();
        }
        if (appLogContext.hasResourceError()) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str2);
            sb3.append(" Res");
            str2 = sb3.toString();
        }
        builder.setErrMsg(str2);
        if (appLogContext.hasWhiteScreen()) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(" 白屏");
            str3 = sb4.toString();
        }
        if (AppLogger.getQosLevel() == 4) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str3);
            sb5.append(" 弱网");
            str3 = sb5.toString();
        }
        if (appLogContext.hasScreenShot()) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(str3);
            sb6.append(" 用户截屏");
            str3 = sb6.toString();
        }
        if (TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2)) {
            return;
        }
        builder.setWarningMsg(str3);
        builder.setTitle(str);
        AppLogger.log(builder.build());
    }
}
