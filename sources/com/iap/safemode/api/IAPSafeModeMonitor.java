package com.iap.safemode.api;

import android.app.Application;
import com.fullstory.instrumentation.InstrumentInjector;
import com.iap.safemode.core.IAPSafeModeContext;
import com.iap.safemode.handler.IAPSafeModeHandlerRegistrator;
import com.iap.safemode.storage.IAPStorageManager;
import com.iap.safemode.utils.FileUtil;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes3.dex */
public class IAPSafeModeMonitor {
    public static void KClassImpl$Data$declaredNonStaticMembers$2(Application application, IAPSafeModeTraceListener iAPSafeModeTraceListener) {
        final IAPSafeModeContext authRequestContext = IAPSafeModeContext.getAuthRequestContext();
        authRequestContext.getAuthRequestContext = application;
        authRequestContext.moveToNextValue = new IAPSafeModeHandlerRegistrator(application);
        authRequestContext.getErrorConfigVersion = new IAPStorageManager(application);
        authRequestContext.lookAheadTest = iAPSafeModeTraceListener;
        try {
            if (IAPStorageManager.getAuthRequestContext(application, "safemode_marker").equals("")) {
                IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2 = 0;
            } else {
                IAPStorageManager iAPStorageManager = authRequestContext.getErrorConfigVersion;
                IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2 = Integer.parseInt(IAPStorageManager.getAuthRequestContext(application, "safemode_marker"));
            }
            synchronized (authRequestContext) {
                if (IAPSafeModeContext.MyBillsEntityDataFactory) {
                    return;
                }
                IAPSafeModeContext.MyBillsEntityDataFactory = false;
                int i = IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2;
                if (i <= 4) {
                    IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2 = i + 1;
                    String str = authRequestContext.BuiltInFictitiousFunctionClassFactory;
                    StringBuilder sb = new StringBuilder();
                    sb.append("This time marker is  ");
                    sb.append(IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2);
                    sb.append("!");
                    InstrumentInjector.log_d(str, sb.toString());
                    IAPStorageManager iAPStorageManager2 = authRequestContext.getErrorConfigVersion;
                    IAPStorageManager.getAuthRequestContext(authRequestContext.getAuthRequestContext, "safemode_marker", String.valueOf(IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2));
                    if (IAPSafeModeContext.KClassImpl$Data$declaredNonStaticMembers$2 > 2) {
                        IAPSafeModeHandlerRegistrator iAPSafeModeHandlerRegistrator = authRequestContext.moveToNextValue;
                        synchronized (iAPSafeModeHandlerRegistrator) {
                            List<String> authRequestContext2 = FileUtil.getAuthRequestContext(iAPSafeModeHandlerRegistrator.MyBillsEntityDataFactory);
                            for (int i2 = 0; i2 < authRequestContext2.size(); i2++) {
                                try {
                                    ((IAPSafeHandler) Class.forName(authRequestContext2.get(i2)).newInstance()).recover(iAPSafeModeHandlerRegistrator.MyBillsEntityDataFactory);
                                } catch (Throwable th) {
                                    InstrumentInjector.log_e(IAPSafeModeHandlerRegistrator.BuiltInFictitiousFunctionClassFactory, th.toString());
                                }
                            }
                        }
                        IAPSafeModeContext.PlaceComponentResult = "triggerSafeModeRecover";
                    }
                    authRequestContext.scheduleImpl = new Timer();
                    authRequestContext.scheduleImpl.schedule(new TimerTask() { // from class: com.iap.safemode.core.IAPSafeModeContext.1
                        @Override // java.util.TimerTask, java.lang.Runnable
                        public void run() {
                            authRequestContext.BuiltInFictitiousFunctionClassFactory();
                        }
                    }, 10000L);
                    authRequestContext.getAuthRequestContext.registerActivityLifecycleCallbacks(authRequestContext);
                }
            }
        } catch (Exception unused) {
        }
    }
}
