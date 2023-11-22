package com.alibaba.ariver.engine.api.common.log;

import com.alibaba.ariver.kernel.common.log.ApiLog;
import com.alibaba.ariver.kernel.common.log.AppLogger;
import com.alibaba.ariver.kernel.common.log.EventLog;
import java.util.Map;

/* loaded from: classes3.dex */
public class IgnoreLogUtils {
    public static final String TYPE_API = "api";
    public static final String TYPE_EVENT = "event";

    public static void handleIgnoreLog(String str, String str2, String str3, String str4, int i, Map<String, LogCountInfo> map, String str5) {
        if (i != 0) {
            LogCountInfo logCountInfo = map.get(str2);
            if (logCountInfo == null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append("_");
                sb.append(System.currentTimeMillis());
                logCountInfo = new LogCountInfo(0, sb.toString());
                if (map.size() < 100) {
                    map.put(str2, logCountInfo);
                }
            } else if (logCountInfo.count > i) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str2);
                sb2.append("_");
                sb2.append(System.currentTimeMillis());
                logCountInfo.groupId = sb2.toString();
                logCountInfo.count = 0;
            }
            logCountInfo.count++;
            if (str5.equals("event")) {
                EventLog.Builder groupId = new EventLog.Builder().setParentId(str).setGroupId(logCountInfo.groupId);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append(" [");
                sb3.append(str2);
                sb3.append("] ignored");
                AppLogger.log(groupId.setData(sb3.toString()).build());
                return;
            }
            ApiLog.Builder builder = new ApiLog.Builder();
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            ApiLog.Builder state = builder.setParentId(sb4.toString()).setGroupId(logCountInfo.groupId).setState(str3);
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str4);
            sb5.append(" [");
            sb5.append(str2);
            sb5.append("] ignored");
            AppLogger.log(state.setData(sb5.toString()).build());
        }
    }
}
