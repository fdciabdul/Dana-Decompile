package com.alipay.plus.android.config.sdk.a;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.iap.android.common.errorcode.IAPError;
import com.alipay.iap.android.common.errorcode.IAPException;
import com.alipay.iap.android.common.log.LoggerWrapper;
import com.alipay.iap.android.common.utils.MiscUtils;
import com.alipay.iap.android.f2fpay.components.defaults.DefaultInitializeComponent;
import com.alipay.mobile.common.rpc.RpcException;
import com.alipay.plus.android.config.sdk.ConfigCenterContext;
import com.alipay.plus.android.config.sdk.delegate.ConfigIdentifierProvider;
import com.alipay.plus.android.config.sdk.facade.request.AmcsConfigByKeysLiteRpcRequest;
import com.alipay.plus.android.config.sdk.fetcher.FetchException;
import com.alipay.plus.android.config.sdk.retry.DistributionNode;
import id.dana.danah5.akulaku.AkuEventParamsKey;
import java.lang.reflect.UndeclaredThrowableException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7363a = a("SdkUtils");

    public static AmcsConfigByKeysLiteRpcRequest a(ConfigCenterContext configCenterContext, String str, String str2, String str3, List<String> list, Map<String, Object> map) {
        AmcsConfigByKeysLiteRpcRequest amcsConfigByKeysLiteRpcRequest = new AmcsConfigByKeysLiteRpcRequest();
        amcsConfigByKeysLiteRpcRequest.keys = list;
        amcsConfigByKeysLiteRpcRequest.lastResponseTime = "0";
        amcsConfigByKeysLiteRpcRequest.appId = str;
        amcsConfigByKeysLiteRpcRequest.tntInstId = str2;
        amcsConfigByKeysLiteRpcRequest.workspaceId = str3;
        Context context = configCenterContext.getContext();
        ConfigIdentifierProvider identifierProvider = configCenterContext.getIdentifierProvider();
        String versionName = MiscUtils.getVersionName(configCenterContext.getContext());
        if (TextUtils.isEmpty(versionName)) {
            versionName = "1.0";
        }
        amcsConfigByKeysLiteRpcRequest.addParameter("utdid", identifierProvider.getUtdId(context));
        amcsConfigByKeysLiteRpcRequest.addParameter("reference ", identifierProvider.getConfigUserId(context));
        amcsConfigByKeysLiteRpcRequest.addParameter("mobileModel ", Build.MODEL);
        amcsConfigByKeysLiteRpcRequest.addParameter("mobileBrand ", Build.BRAND);
        amcsConfigByKeysLiteRpcRequest.addParameter("manufacturer ", Build.MANUFACTURER);
        amcsConfigByKeysLiteRpcRequest.addParameter("osVersion ", a());
        amcsConfigByKeysLiteRpcRequest.addParameter("clientVersion ", versionName);
        amcsConfigByKeysLiteRpcRequest.addParameter("systemType ", DefaultInitializeComponent.PLATFORM_TYPE);
        amcsConfigByKeysLiteRpcRequest.addParameters(map);
        return amcsConfigByKeysLiteRpcRequest;
    }

    public static FetchException a(Throwable th, boolean z) {
        Throwable undeclaredThrowable;
        while (!(th instanceof FetchException)) {
            if (th instanceof RpcException) {
                RpcException rpcException = (RpcException) th;
                return new FetchException(String.valueOf(rpcException.getCode()), a(rpcException.getMsg(), "unknown_rpc_exception"));
            }
            if (th instanceof IAPException) {
                IAPError error = ((IAPException) th).getError();
                if (error != null) {
                    return new FetchException(error.errorCode, a(error.errorMessage, "unknown_iap_error"));
                }
            } else if ((th instanceof UndeclaredThrowableException) && z && (undeclaredThrowable = ((UndeclaredThrowableException) th).getUndeclaredThrowable()) != null) {
                th = undeclaredThrowable;
                z = false;
            }
            String message = th.getMessage();
            if (TextUtils.isEmpty(message)) {
                message = "unknown_fetch_exception";
            }
            return new FetchException(message);
        }
        return (FetchException) th;
    }

    public static <T> T a(T t, Class<T> cls) {
        if (t == null) {
            return null;
        }
        try {
            return (T) JSONObject.parseObject(JSONObject.toJSONString(t), cls);
        } catch (Throwable th) {
            String str = f7363a;
            StringBuilder sb = new StringBuilder();
            sb.append("copyModelObject failed: ");
            sb.append(th.getMessage());
            LoggerWrapper.e(str, sb.toString());
            return null;
        }
    }

    public static String a() {
        return Build.VERSION.RELEASE;
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    public static String a(DistributionNode distributionNode, ConfigCenterContext configCenterContext) {
        String str;
        String str2;
        if (configCenterContext != null) {
            str2 = MiscUtils.getVersionName(configCenterContext.getContext());
            str = configCenterContext.getIdentifierProvider().getConfigUserId(configCenterContext.getContext());
        } else {
            str = null;
            str2 = null;
        }
        return String.format("%s_%s_%s_%s", distributionNode != null ? distributionNode.url : null, str2, a(), str);
    }

    public static String a(Iterable<? extends CharSequence> iterable, char c) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<? extends CharSequence> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(c);
        }
        if (sb.length() <= 0) {
            return null;
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }

    public static String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("Amcs-");
        sb.append(str);
        return sb.toString();
    }

    private static String a(String str, String str2) {
        return !TextUtils.isEmpty(str) ? str : str2;
    }

    public static boolean a(Context context) {
        ActivityManager activityManager;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            activityManager = (ActivityManager) context.getSystemService(AkuEventParamsKey.KEY_ACTIVITY);
        } catch (Throwable th) {
            String str = f7363a;
            StringBuilder sb = new StringBuilder();
            sb.append("isAppInForeground error: ");
            sb.append(th.getMessage());
            LoggerWrapper.e(str, sb.toString());
        }
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.processName.equals(packageName) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }
}
