package id.dana.lib.logger;

import android.text.TextUtils;
import com.alipay.iap.android.aplog.api.LogHelper;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.log.behavior.AliveReportLog;
import com.alipay.iap.android.aplog.log.behavior.BehaviourLog;
import com.alipay.iap.android.common.log.ILogger;
import com.alipay.iap.android.common.log.IMonitor;
import com.alipay.iap.android.common.log.LoggerWrapper;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes9.dex */
public final class ApLogFacade {
    private static final String KClassImpl$Data$declaredNonStaticMembers$2 = "ApLogFacade";

    static /* synthetic */ boolean getAuthRequestContext() {
        return PlaceComponentResult();
    }

    private ApLogFacade() {
    }

    private static boolean PlaceComponentResult() {
        return (LoggerFactory.getLogContext() == null || LoggerFactory.getLogContext().getSpmMonitor() == null) ? false : true;
    }

    /* renamed from: id.dana.lib.logger.ApLogFacade$1  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass1 implements IMonitor {
        AnonymousClass1() {
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        @Deprecated
        public final void performance(String str, String str2, String str3, Map<String, String> map) {
            LoggerWrapper.e(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, "MonitorWrapper-->performance -- Deprecated");
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void aliveReport() {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, "MonitorWrapper-->aliveReport");
            ApLogFacade.BuiltInFictitiousFunctionClassFactory();
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void behaviour(String str, Map<String, String> map) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("behaviour: [seedId= %s]", str));
            behaviour(str, null, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void behaviour(String str, String str2, Map<String, String> map) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("behaviour: [seedId= %s\t , bizType= %s]", str, str2));
            ApLogFacade.BuiltInFictitiousFunctionClassFactory(str, str2, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void flush() {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, "MonitorWrapper-->flush");
            ApLogFacade.MyBillsEntityDataFactory();
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void pageOnStart(Object obj, String str) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("MonitorWrapper-->pageOnStart: [page= %s\t , spmId= %s]", obj, str));
            if (ApLogFacade.getAuthRequestContext()) {
                LoggerFactory.getLogContext().getSpmMonitor().pageOnStart(obj, str);
            }
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void pageOnEnd(Object obj, String str, String str2, Map<String, String> map) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("MonitorWrapper-->pageOnEnd: [page= %s\t ,spmId= %s\t , bizCode= %s]", obj, str, str2));
            ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2(obj, str, str2, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void pageOnDestroy(Object obj) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("MonitorWrapper-->pageOnDestroy: [page= %s]", obj));
            ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2(obj);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void spmClick(Object obj, String str, String str2, Map<String, String> map) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("spmClick: [page= %s\t ,spmId= %s\t , bizCode= %s]", obj, str, str2));
            ApLogFacade.MyBillsEntityDataFactory(obj, str, str2, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void spmExpose(Object obj, String str, String str2, Map<String, String> map) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("spmExpose: [page = %s,spmId = %s\t , bizCode = %s]", obj, str, str2));
            ApLogFacade.getAuthRequestContext(obj, str, str2, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        @Deprecated
        public final void exception(String str, String str2, Map<String, String> map) {
            if (map == null) {
                map = new HashMap<>();
            }
            map.put("exceptionType", str);
            exception(str2, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void exception(String str, Map<String, String> map) {
            LogHelper.exception(str, map);
        }

        @Override // com.alipay.iap.android.common.log.IMonitor
        public final void performance(String str, String str2, Map<String, String> map) {
            LoggerWrapper.d(ApLogFacade.KClassImpl$Data$declaredNonStaticMembers$2, String.format("MonitorWrapper-->performance: [performanceID= %s\t ,subType= %s\t ,extparams= %s]", str, str2, map));
            LogHelper.performance(str, str2, map);
        }
    }

    /* renamed from: id.dana.lib.logger.ApLogFacade$2  reason: invalid class name */
    /* loaded from: classes9.dex */
    static final class AnonymousClass2 implements ILogger {
        @Override // com.alipay.iap.android.common.log.ILogger
        public final boolean isLoggable() {
            return true;
        }

        AnonymousClass2() {
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void v(String str, String str2) {
            LoggerFactory.getTraceLogger().verbose(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void v(String str, String str2, Throwable th) {
            LoggerFactory.getTraceLogger().verbose(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void i(String str, String str2) {
            LoggerFactory.getTraceLogger().info(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void i(String str, String str2, Throwable th) {
            LoggerFactory.getTraceLogger().info(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void d(String str, String str2) {
            LoggerFactory.getTraceLogger().debug(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void d(String str, String str2, Throwable th) {
            LoggerFactory.getTraceLogger().debug(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void w(String str, String str2) {
            LoggerFactory.getTraceLogger().warn(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void w(String str, String str2, Throwable th) {
            LoggerFactory.getTraceLogger().warn(str, str2, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void w(String str, Throwable th) {
            LoggerFactory.getTraceLogger().warn(str, th);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void e(String str, String str2) {
            LoggerFactory.getTraceLogger().error(str, str2);
        }

        @Override // com.alipay.iap.android.common.log.ILogger
        public final void e(String str, String str2, Throwable th) {
            LoggerFactory.getTraceLogger().error(str, str2, th);
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        if (LoggerFactory.getLogContext() != null) {
            LoggerFactory.getLogContext().appendLog(new AliveReportLog());
        }
    }

    static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(String str, String str2, Map map) {
        BehaviourLog behaviourLog = new BehaviourLog();
        behaviourLog.setSeedID(str);
        behaviourLog.setBizType(str2);
        if (map != null && map.size() > 0) {
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    behaviourLog.putExtParam(str3, str4);
                }
            }
        }
        if (LoggerFactory.getLogContext() != null) {
            LoggerFactory.getLogContext().appendLog(behaviourLog);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory() {
        if (LoggerFactory.getLogContext() != null) {
            LoggerFactory.getLogContext().flush();
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, String str2, Map map) {
        if (PlaceComponentResult()) {
            LoggerFactory.getLogContext().getSpmMonitor().pageOnEnd(obj, str, str2, map);
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Object obj) {
        if (PlaceComponentResult()) {
            LoggerFactory.getLogContext().getSpmMonitor().pageOnDestroy(obj);
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(Object obj, String str, String str2, Map map) {
        if (PlaceComponentResult()) {
            LoggerFactory.getLogContext().getSpmMonitor().spmClick(obj, str, str2, map);
        }
    }

    static /* synthetic */ void getAuthRequestContext(Object obj, String str, String str2, Map map) {
        if (PlaceComponentResult()) {
            LoggerFactory.getLogContext().getSpmMonitor().spmExpose(obj, str, str2, map);
        }
    }
}
