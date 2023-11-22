package com.alipay.iap.android.aplog.core.appender;

import com.alibaba.griver.file.jsapi.FileMangerBridgeExtension;
import com.alipay.iap.android.aplog.api.LogCategory;
import com.alipay.iap.android.aplog.api.LogContext;
import com.alipay.iap.android.aplog.api.LogEventType;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.layout.LogLayout;
import com.alipay.iap.android.aplog.log.FlushLog;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class AppenderManager {
    public static final String TAG = "AppenderManager";
    private static Map<String, Appender> appenderHashMap = new ConcurrentHashMap();
    private static AppenderManager appenderManager;
    private LogContext logContext;
    private List<OnAppendLogListener> onAppendLogListeners = new ArrayList();

    private AppenderManager(LogContext logContext) {
        this.logContext = logContext;
        appenderHashMap.put(LogCategory.LOG_BEHAVIOUR_AUTO, new MdapFileLogAppender(logContext, LogCategory.LOG_BEHAVIOUR_AUTO));
        appenderHashMap.put(LogCategory.LOG_BEHAVIOUR_MANUAL, new MdapFileLogAppender(logContext, LogCategory.LOG_BEHAVIOUR_MANUAL));
        appenderHashMap.put(LogCategory.LOG_SPM, new MdapFileLogAppender(logContext, LogCategory.LOG_SPM));
        appenderHashMap.put("performance", new MdapFileLogAppender(logContext, "performance"));
        appenderHashMap.put(LogCategory.LOG_ALIVEREPORT, new MdapFileLogAppender(logContext, LogCategory.LOG_ALIVEREPORT));
        appenderHashMap.put("crash", new MdapFileLogAppender(logContext, "crash"));
        appenderHashMap.put("applog", new DiagnoseLogAppender(logContext, "applog", TimeUnit.HOURS.toMillis(1L), TimeUnit.DAYS.toMillis(7L), FileMangerBridgeExtension.MAX_FILE_SIZE, 65536));
        appenderHashMap.put("unknown", new LogFileLogAppender(logContext, "unknown", TimeUnit.HOURS.toMillis(1L), TimeUnit.DAYS.toMillis(7L), 20971520L, 65536));
    }

    public static AppenderManager createInstance(LogContext logContext) {
        if (appenderManager == null) {
            appenderManager = new AppenderManager(logContext);
        }
        return appenderManager;
    }

    public static AppenderManager getInstance() {
        AppenderManager appenderManager2 = appenderManager;
        if (appenderManager2 != null) {
            return appenderManager2;
        }
        throw new IllegalStateException("need createInstance before use");
    }

    public void addOnAppendLogListener(OnAppendLogListener onAppendLogListener) {
        this.onAppendLogListeners.add(onAppendLogListener);
    }

    public void removeOnAppendLogListener(OnAppendLogListener onAppendLogListener) {
        this.onAppendLogListeners.remove(onAppendLogListener);
    }

    public void appendLog(LogLayout logLayout) {
        Map<String, Appender> map = appenderHashMap;
        if (map != null) {
            if (map.get(logLayout.getLogCategory()) == null) {
                appenderHashMap.put(logLayout.getLogCategory(), new MdapFileLogAppender(this.logContext, logLayout.getLogCategory()));
            }
            appenderHashMap.get(logLayout.getLogCategory()).onAppend(logLayout.getContent());
            if (this.onAppendLogListeners.isEmpty()) {
                return;
            }
            for (int i = 0; i < this.onAppendLogListeners.size(); i++) {
                this.onAppendLogListeners.get(i).onAppendLog(logLayout.getContent());
            }
        }
    }

    public void appendEvent(LogEvent logEvent) {
        if (logEvent == null || logEvent.getLogEventType() == null) {
            return;
        }
        String logEventType = logEvent.getLogEventType();
        logEventType.hashCode();
        char c = 65535;
        int hashCode = logEventType.hashCode();
        if (hashCode != -998121387) {
            if (hashCode != 97532676) {
                if (hashCode == 2123940242 && logEventType.equals(LogEventType.CATEGORY_UPLOAD_BY_TYPE)) {
                    c = 2;
                }
            } else if (logEventType.equals("flush")) {
                c = 1;
            }
        } else if (logEventType.equals(LogEventType.CATEGORY_FLUSH_BY_TYPE)) {
            c = 0;
        }
        if (c == 0) {
            flush(logEvent.getLogCategory());
        } else if (c == 1) {
            flush();
        } else if (c != 2) {
        } else {
            LoggerFactory.getLogContext().upload(logEvent.getLogCategory());
        }
    }

    public void appendFlushLog(FlushLog flushLog) {
        if (flushLog == null || flushLog.getLogEventType() == null) {
            return;
        }
        String logEventType = flushLog.getLogEventType();
        logEventType.hashCode();
        if (logEventType.equals(LogEventType.CATEGORY_FLUSH_BY_TYPE)) {
            flush(flushLog.getLogCategory());
        } else if (logEventType.equals("flush")) {
            flush();
        }
    }

    public void flush(String str) {
        if (appenderHashMap.containsKey(str)) {
            appenderHashMap.get(str).flush();
        }
    }

    public void flush() {
        Iterator<String> it = appenderHashMap.keySet().iterator();
        while (it.hasNext()) {
            appenderHashMap.get(it.next()).flush();
        }
    }

    public DiagnoseLogAppender getDiagnoseLogAppender() {
        Appender appender = appenderHashMap.get("applog");
        if (appender instanceof DiagnoseLogAppender) {
            return (DiagnoseLogAppender) appender;
        }
        return null;
    }
}
