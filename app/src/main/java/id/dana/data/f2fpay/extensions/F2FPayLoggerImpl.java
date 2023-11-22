package id.dana.data.f2fpay.extensions;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.log.behavior.BehaviourLog;
import com.alipay.iap.android.f2fpay.extension.IF2FPayLogger;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.Map;

/* loaded from: classes8.dex */
public class F2FPayLoggerImpl implements IF2FPayLogger {
    @Override // com.alipay.iap.android.f2fpay.extension.IF2FPayLogger
    public void event(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("behavior_log,eventId:");
        sb.append(str);
        sb.append(",");
        if (map != null) {
            BehaviourLog behaviourLog = new BehaviourLog();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    behaviourLog.putExtParam(entry.getKey(), entry.getValue());
                    sb.append(entry.getKey());
                    sb.append(":");
                    sb.append(entry.getValue());
                    sb.append(",");
                }
            }
            behaviourLog.setSeedID(str);
            behaviourLog.setSourceID("sourceID");
            LoggerFactory.getLogContext().appendLog(behaviourLog);
            DanaLog.getAuthRequestContext("F2FPayLoggerImpl", sb.toString());
        }
    }
}
