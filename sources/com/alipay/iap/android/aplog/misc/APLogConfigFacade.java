package com.alipay.iap.android.aplog.misc;

import android.app.Application;
import android.text.TextUtils;
import com.alipay.iap.android.aplog.core.LoggerFactory;
import com.alipay.iap.android.aplog.core.filter.LogCustomizeControl;
import com.alipay.iap.android.aplog.core.filter.LogUploadInfo;
import com.alipay.iap.android.aplog.core.filter.LogWriteInfo;
import com.alipay.iap.android.aplog.core.filter.StrategyManager;
import com.alipay.iap.android.aplog.core.filter.UploadResultInfo;
import com.alipay.iap.android.aplog.core.logger.TraceLogger;
import com.alipay.iap.android.common.product.delegate.IAPLoginUserInfo;
import com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver;
import com.alipay.iap.android.common.product.delegate.UserInfoManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class APLogConfigFacade {
    public static final String TAG = "APLogConfigFacade";
    private static APLogConfigData configData = null;
    private static boolean logEnable = true;
    private List<String> configkeywords;
    private List<String[]> keylists = new ArrayList();
    private static long configRefreshInterval = TimeUnit.MINUTES.toMillis(30);
    private static APLogConfigFacade apLogFacade = new APLogConfigFacade();

    public static APLogConfigFacade getInstance() {
        return apLogFacade;
    }

    private void initFilter() {
        LoggerFactory.getLogContext().setLogCustomizeControl(new LogCustomizeControl() { // from class: com.alipay.iap.android.aplog.misc.APLogConfigFacade.1
            @Override // com.alipay.iap.android.aplog.core.filter.LogCustomizeControl
            public boolean shouldQueryStrategy() {
                return true;
            }

            {
                APLogConfigFacade.this = this;
            }

            @Override // com.alipay.iap.android.aplog.core.filter.LogCustomizeControl
            public boolean isLogWrite(LogWriteInfo logWriteInfo) {
                if (logWriteInfo == null || TextUtils.isEmpty(logWriteInfo.logCategory) || !APLogConfigFacade.logEnable) {
                    return false;
                }
                if (APLogConfigFacade.configData == null) {
                    return true;
                }
                if (APLogConfigFacade.configData.logTypes == null || APLogConfigFacade.configData.logTypes.size() == 0 || !APLogConfigFacade.configData.logTypes.contains(logWriteInfo.logCategory)) {
                    return false;
                }
                return APLogConfigFacade.this.handleKeyWord(logWriteInfo);
            }

            @Override // com.alipay.iap.android.aplog.core.filter.LogCustomizeControl
            public UploadResultInfo isLogUpload(LogUploadInfo logUploadInfo) {
                UploadResultInfo uploadResultInfo = new UploadResultInfo();
                uploadResultInfo.isUpload = true;
                return uploadResultInfo;
            }
        });
    }

    public void init(Application application) {
        addUserInfoListener();
        initFilter();
    }

    private void addUserInfoListener() {
        UserInfoManager.instance().addUserChangeObserver(new IAPUserChangeObserver() { // from class: com.alipay.iap.android.aplog.misc.APLogConfigFacade.2
            {
                APLogConfigFacade.this = this;
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public void onUserChanged(IAPLoginUserInfo iAPLoginUserInfo) {
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("onUserChanged");
                sb.append(iAPLoginUserInfo.userID);
                traceLogger.debug(APLogConfigFacade.TAG, sb.toString());
                LoggerFactory.getLogContext().setUserID(iAPLoginUserInfo.userID);
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public void onUserLogin(IAPLoginUserInfo iAPLoginUserInfo) {
                TraceLogger traceLogger = LoggerFactory.getTraceLogger();
                StringBuilder sb = new StringBuilder();
                sb.append("onUserLogin");
                sb.append(iAPLoginUserInfo.userID);
                traceLogger.debug(APLogConfigFacade.TAG, sb.toString());
                LoggerFactory.getLogContext().setUserID(iAPLoginUserInfo.userID);
            }

            @Override // com.alipay.iap.android.common.product.delegate.IAPUserChangeObserver
            public void onUserLogout() {
                LoggerFactory.getLogContext().setUserID(null);
            }
        });
    }

    public boolean handleKeyWord(LogWriteInfo logWriteInfo) {
        for (String[] strArr : this.keylists) {
            if (strArr[0].equals(logWriteInfo.logCategory)) {
                String[] split = logWriteInfo.logContent.split("\\,");
                int parseInt = Integer.parseInt(strArr[1]);
                if (split.length > parseInt && strArr[2].equals(split[parseInt])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setAliveInterval(Long l) {
        LoggerFactory.getLogContext().setLogAliveInterval(l);
    }

    public long getConfigRefreshInterval() {
        return configRefreshInterval;
    }

    public void setConfigRefreshInterval(Long l) {
        StrategyManager.getInstance().setConfigRequestTimeSpan(l.longValue());
        configRefreshInterval = l.longValue();
    }

    private void handleConfig(APLogConfigData aPLogConfigData) {
        if (aPLogConfigData == null) {
            return;
        }
        this.keylists.clear();
        configData = aPLogConfigData;
        setConfigRefreshInterval(Long.valueOf(aPLogConfigData.configRefreshInterval));
        setAliveInterval(Long.valueOf(configData.reportActiveInterval));
        logEnable = configData.logEnable;
        if (configData.keywords != null) {
            ArrayList<String> arrayList = configData.keywords;
            this.configkeywords = arrayList;
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String[] split = it.next().split("\\^");
                if (split != null && split.length > 2) {
                    this.keylists.add(split);
                }
            }
        }
    }
}
