package com.iap.ac.android.biz.common.internal.foundation.facade;

import android.content.Context;
import android.text.TextUtils;
import com.iap.ac.android.biz.accommon.a.a;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.configcenter.Constant;
import com.iap.ac.android.biz.common.configcenter.LogConfigCenter;
import com.iap.ac.android.biz.common.constants.Constants;
import com.iap.ac.android.biz.common.model.CommonConfig;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.config.ACConfig;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.log.ACMonitor;
import com.iap.ac.android.common.log.IACMonitor;
import com.iap.ac.android.common.log.event.LogEvent;
import com.iap.ac.android.common.log.event.LogEventType;
import com.iap.ac.android.common.log.event.PageLogEvent;
import com.iap.ac.android.loglite.api.AnalyticsConfig;
import com.iap.ac.android.loglite.api.CommonAnalyticsAgent;
import com.iap.ac.android.loglite.core.AnalyticsContext;
import com.iap.android.iaptinylog.IAPTinyLogger;
import com.iap.android.iaptinylog.data.IAPTinyLog;
import com.iap.android.iaptinylog.data.IAPTinyLogType;
import com.iap.android.starter.IAPTinyLoggerStarter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LogFacade extends BaseFacade {
    public static boolean mInitialized;
    public CommonAnalyticsAgent commonAnalyticsAgent;

    /* renamed from: com.iap.ac.android.biz.common.internal.foundation.facade.LogFacade$3 */
    /* loaded from: classes3.dex */
    public static /* synthetic */ class AnonymousClass3 {
        public static final /* synthetic */ int[] $SwitchMap$com$iap$ac$android$common$log$event$LogEventType;
        public static final /* synthetic */ int[] $SwitchMap$com$iap$ac$android$common$log$event$PageLogEvent$PageEvent;

        static {
            int[] iArr = new int[PageLogEvent.PageEvent.values().length];
            $SwitchMap$com$iap$ac$android$common$log$event$PageLogEvent$PageEvent = iArr;
            try {
                iArr[PageLogEvent.PageEvent.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$log$event$PageLogEvent$PageEvent[PageLogEvent.PageEvent.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$log$event$PageLogEvent$PageEvent[PageLogEvent.PageEvent.DESTORY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LogEventType.values().length];
            $SwitchMap$com$iap$ac$android$common$log$event$LogEventType = iArr2;
            try {
                iArr2[LogEventType.CRUCIAL_LOG.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$log$event$LogEventType[LogEventType.PERFORMANCE_LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$iap$ac$android$common$log$event$LogEventType[LogEventType.BEHAVIOR_LOG.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public IAPTinyLogType convertLogType(LogEventType logEventType) {
        if (logEventType == null) {
            return IAPTinyLogType.LOG_TYPE_EVENT;
        }
        int i = AnonymousClass3.$SwitchMap$com$iap$ac$android$common$log$event$LogEventType[logEventType.ordinal()];
        if (i != 1) {
            if (i != 2 && i != 3) {
                return IAPTinyLogType.LOG_TYPE_EVENT;
            }
            return IAPTinyLogType.LOG_TYPE_EVENT;
        }
        return IAPTinyLogType.LOG_TYPE_EXCEPTION;
    }

    public boolean isTinyLogExist() {
        return Utils.checkClassExist("com.iap.android.starter.IAPTinyLoggerStarter") && IAPTinyLoggerStarter.getInstance().isTinyLogLoaded();
    }

    private void setEmptyProxy(String str) {
        ACMonitor.setACMonitorImpl(new IACMonitor() { // from class: com.iap.ac.android.biz.common.internal.foundation.facade.LogFacade.1
            {
                LogFacade.this = this;
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void flush() {
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void logEvent(LogEvent logEvent) {
                StringBuilder a2 = a.a("method:logEvent->");
                a2.append(logEvent.bizCode);
                ACLog.i(Constants.TAG, a2.toString());
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void logPageEvent(PageLogEvent pageLogEvent) {
                StringBuilder a2 = a.a("method:logPageEvent->");
                a2.append(pageLogEvent.bizCode);
                ACLog.i(Constants.TAG, a2.toString());
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void setGlobalParameters(Map<String, String> map) {
            }
        }, str);
    }

    public static void setLogGateWayUrl() {
        StringBuilder a2 = a.a("status:");
        a2.append(mInitialized);
        ACLog.e("LogFacade", a2.toString());
        if (mInitialized) {
            JSONObject sectionConfig = ACConfig.getInstance("ac_biz").getSectionConfig(Constant.SECTION_LOG_CONFIG);
            StringBuilder a3 = a.a("config:");
            a3.append(sectionConfig == null ? "null" : sectionConfig.toString());
            ACLog.e("LogFacade", a3.toString());
            Map map = LogConfigCenter.getInstance().getMap(sectionConfig, Constant.KEY_LOGUPLOADURLCONFIG, new HashMap());
            if (map != null) {
                for (String str : map.keySet()) {
                    if (str != null) {
                        Object obj = map.get(str);
                        if (obj instanceof String) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("url:");
                            sb.append(sectionConfig);
                            ACLog.e("LogFacade", sb.toString() == null ? "null" : sectionConfig.toString());
                            AnalyticsConfig.registerBizTypeToUploadUrl(str, (String) obj);
                        }
                    }
                }
            }
        }
    }

    private void setLogProxy(final String str) {
        String str2 = "";
        String str3 = ACManager.getInstance().getCommonConfig() == null ? "" : ACManager.getInstance().getCommonConfig().envType;
        if (!TextUtils.isEmpty(str3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("_");
            sb.append(str3);
            str2 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(ACManager.getInstance().getAppId());
        sb2.append(str2);
        sb2.append("_Android");
        final IAPTinyLogger iAPTinyLogger = new IAPTinyLogger(sb2.toString(), str);
        ACMonitor.setACMonitorImpl(new IACMonitor() { // from class: com.iap.ac.android.biz.common.internal.foundation.facade.LogFacade.2
            {
                LogFacade.this = this;
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void flush() {
                if (LogFacade.this.commonAnalyticsAgent == null) {
                    return;
                }
                LogFacade.this.commonAnalyticsAgent.flushLogs();
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void logEvent(LogEvent logEvent) {
                if (logEvent == null) {
                    ACLog.i(Constants.TAG, "sendBehavior log error, event is null");
                    return;
                }
                StringBuilder a2 = a.a("logBehavior to lite log, bizCode:");
                a2.append(logEvent.bizCode);
                ACLog.i(Constants.TAG, a2.toString());
                if (!LogFacade.this.isTinyLogExist() || !"ac_biz".equals(str)) {
                    if (LogFacade.this.commonAnalyticsAgent == null) {
                        ACLog.i(Constants.TAG, "commonAnalyticsAgent is null");
                        return;
                    }
                    int i = AnonymousClass3.$SwitchMap$com$iap$ac$android$common$log$event$LogEventType[logEvent.eventType.ordinal()];
                    if (i == 1) {
                        LogFacade.this.commonAnalyticsAgent.sendKeyBizExceptionLog(logEvent.eventName, logEvent.bizCode, logEvent.params);
                        return;
                    } else if (i != 2) {
                        LogFacade.this.commonAnalyticsAgent.sendBehaviorLog(logEvent.eventName, logEvent.bizCode, logEvent.params);
                        return;
                    } else {
                        LogFacade.this.commonAnalyticsAgent.sendPerformanceLog(logEvent.eventName, logEvent.bizCode, logEvent.params);
                        return;
                    }
                }
                IAPTinyLog iAPTinyLog = new IAPTinyLog();
                iAPTinyLog.parameters = logEvent.params;
                iAPTinyLog.name = logEvent.eventName;
                iAPTinyLog.type = LogFacade.this.convertLogType(logEvent.eventType);
                IAPTinyLogger.PlaceComponentResult(iAPTinyLog);
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void logPageEvent(PageLogEvent pageLogEvent) {
                if (pageLogEvent == null) {
                    ACLog.e(Constants.TAG, "LogFacade, logPageEvent null");
                } else if (LogFacade.this.commonAnalyticsAgent == null) {
                    ACLog.i(Constants.TAG, "commonAnalyticsAgent is null");
                } else {
                    int i = AnonymousClass3.$SwitchMap$com$iap$ac$android$common$log$event$PageLogEvent$PageEvent[pageLogEvent.event.ordinal()];
                    if (i == 1) {
                        LogFacade.this.commonAnalyticsAgent.onPageStart(pageLogEvent.page, pageLogEvent.pageId);
                    } else if (i == 2) {
                        LogFacade.this.commonAnalyticsAgent.onPageEnd(pageLogEvent.page, pageLogEvent.pageId, pageLogEvent.bizCode, pageLogEvent.params);
                    } else if (i == 3) {
                        LogFacade.this.commonAnalyticsAgent.onPageDestroy(pageLogEvent.page);
                    }
                }
            }

            @Override // com.iap.ac.android.common.log.IACMonitor
            public void setGlobalParameters(Map<String, String> map) {
                if (LogFacade.mInitialized) {
                    AnalyticsContext.getInstance().setGlobalExtParam(map);
                }
            }
        }, str);
    }

    public static void setLogStrategy(String str) {
        if (mInitialized && !TextUtils.isEmpty(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("setLogStrategy to Log component: ");
            sb.append(str);
            ACLog.i(Constants.TAG, sb.toString());
            AnalyticsConfig.setStrategyConfig(str);
        }
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public void initComponent(Context context, String str, CommonConfig commonConfig) {
        super.initComponent(context, str, commonConfig);
        synchronized (this) {
            mInitialized = false;
            if (Utils.checkClassExist("com.iap.ac.android.loglite.api.AnalyticsConfig") && Utils.checkClassExist("com.iap.ac.android.loglite.api.AnalyticsHelper")) {
                AnalyticsConfig.init(context, commonConfig.getLogProductId(), commonConfig.logGatewayUrl);
                Set<String> set = commonConfig.crashWhiteListSet;
                if (set != null && set.size() > 0) {
                    Iterator<String> it = set.iterator();
                    while (it.hasNext()) {
                        AnalyticsConfig.addCrashWhiteList(it.next());
                    }
                }
                AnalyticsConfig.registerBizTypeToUploadUrl("iapconnect_center", commonConfig.logGatewayUrl);
                AnalyticsConfig.registerBizTypeToUploadUrl("crash", commonConfig.logGatewayUrl);
                AnalyticsConfig.registerBizTypeToUploadUrl("AMCS-LITE", commonConfig.logGatewayUrl);
                ACLog.i(Constants.TAG, "Log component initialize finish");
                this.commonAnalyticsAgent = new CommonAnalyticsAgent(str);
                if (commonConfig.acLogDisabled) {
                    setEmptyProxy(str);
                } else {
                    setLogProxy(str);
                }
                mInitialized = true;
                return;
            }
            ACLog.e(Constants.TAG, "lite log init error, without dependent libraries");
            setLogProxy(str);
        }
    }

    @Override // com.iap.ac.android.biz.common.internal.foundation.facade.BaseFacade
    public boolean isInitialized() {
        return mInitialized;
    }
}
