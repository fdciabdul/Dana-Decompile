package com.alibaba.griver.core.jsapi.device.system;

import android.app.Activity;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.DisplayUtils;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.remotedebug.utils.TinyAppLogUtil;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.bridge.GriverAppLanguageExtension;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.preload.GriverOnPreloadExtension;
import com.alipay.mobile.embedview.mapbiz.core.H5MapRenderOptimizer;
import id.dana.lib.gcontainer.app.bridge.logging.H5GetLogInfoBridge;
import io.reactivex.annotations.SchedulerSupport;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class SystemInfoBridgeExtension implements BridgeExtension {
    private static final float DEFAULT_TEXT_SIZE = 16.0f;
    private static final String GET_SYSTEM_INFO = "getSystemInfo";
    private static final String KEY_CACHE_TIME = "time";
    private static final int SYSTEM_INFO_CACHE_TIME = 60000;
    private static final String TAG = "SystemInfoBridge";
    private BatteryBroadcastReceiver mBroadcastReceiver;
    private int mCachedBatteryPercentage;
    private Map<String, JSONObject> mCachedResult = new ConcurrentHashMap();
    private boolean mBatteryBroadcastRegistered = false;

    private float getFontSizeSetting() {
        return 16.0f;
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private static String getInternalMemorySize() {
        if (Build.VERSION.SDK_INT < 18) {
            return "";
        }
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return FileUtils.formatFileSize(statFs.getBlockCountLong() * statFs.getBlockSizeLong());
        } catch (Throwable th) {
            RVLogger.e(TAG, "getInternalMemorySize...", th);
            return "";
        }
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
        RVLogger.d(TAG, "onInitialized");
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
        BatteryBroadcastReceiver batteryBroadcastReceiver;
        RVLogger.d(TAG, "onFinalized");
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null || (batteryBroadcastReceiver = this.mBroadcastReceiver) == null) {
            return;
        }
        applicationContext.unregisterReceiver(batteryBroadcastReceiver);
        this.mBroadcastReceiver = null;
    }

    @ThreadType(ExecutorType.NORMAL)
    @ActionFilter
    @AutoCallback
    public BridgeResponse getSystemInfo(@BindingNode(App.class) App app, @BindingNode(Page.class) Page page, @BindingParam(booleanDefault = true, value = {"needCache"}) boolean z) {
        RVLogger.d(TAG, "nebulaX getSystemInfo");
        if (app == null) {
            RVLogger.e(TAG, "getSystemInfo app null");
            return BridgeResponse.INVALID_PARAM;
        }
        Application applicationContext = GriverEnv.getApplicationContext();
        if (applicationContext == null) {
            RVLogger.e(TAG, "getSystemInfo getContext null");
            return BridgeResponse.INVALID_PARAM;
        }
        if (z) {
            JSONObject jSONObject = this.mCachedResult.get("getSystemInfo");
            long j = JSONUtils.getLong(jSONObject, "time", -1L);
            if (j > 0 && System.currentTimeMillis() - j < 60000) {
                StringBuilder sb = new StringBuilder();
                sb.append("getSystemInfo return cache cacheTime ");
                sb.append(j);
                RVLogger.d(TAG, sb.toString());
                return new BridgeResponse(jSONObject.getJSONObject("data"));
            }
        }
        JSONObject systemInfoInner = getSystemInfoInner(applicationContext, app, page);
        if (z) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("time", (Object) Long.valueOf(System.currentTimeMillis()));
            jSONObject2.put("data", (Object) systemInfoInner);
            this.mCachedResult.put("getSystemInfo", jSONObject2);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getSystemInfo  ");
        sb2.append(systemInfoInner.toJSONString());
        RVLogger.e(TAG, sb2.toString());
        return new BridgeResponse(systemInfoInner);
    }

    private JSONObject getSystemInfoInner(Context context, App app, Page page) {
        float f;
        int i;
        JSONObject jSONObject = new JSONObject();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Activity activity = (Activity) app.getAppContext().getContext();
        Boolean bool = Boolean.FALSE;
        if (displayMetrics != null) {
            f = displayMetrics.density;
            i = Math.round(displayMetrics.widthPixels / f);
            jSONObject.put("screenWidth", (Object) Integer.valueOf(displayMetrics.widthPixels));
            jSONObject.put("screenHeight", (Object) Integer.valueOf(displayMetrics.heightPixels));
        } else {
            f = 0.0f;
            i = 0;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Build.MANUFACTURER);
        sb.append(" ");
        sb.append(Build.MODEL);
        jSONObject.put(H5GetLogInfoBridge.RESULT_MODEL, (Object) sb.toString());
        jSONObject.put("pixelRatio", (Object) Float.valueOf(f));
        jSONObject.put("windowWidth", (Object) Integer.valueOf(i));
        jSONObject.put("windowHeight", (Object) Integer.valueOf(getHeight(page, activity, f, displayMetrics)));
        jSONObject.put("system", (Object) Build.VERSION.RELEASE);
        jSONObject.put(TinyAppLogUtil.TINY_APP_STANDARD_EXTRA_PLATFORM, "Android");
        jSONObject.put("apiLevel", (Object) Integer.valueOf(Build.VERSION.SDK_INT));
        jSONObject.put("storage", (Object) getInternalMemorySize());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(getCurrentBatteryPercentage(context));
        sb2.append("%");
        jSONObject.put("currentBattery", (Object) sb2.toString());
        jSONObject.put(H5GetLogInfoBridge.RESULT_BRAND, (Object) Build.BRAND);
        if (page == null) {
            jSONObject.put("transparentTitle", (Object) bool);
        } else {
            String string = BundleUtils.getString(page.getStartParams(), "transparentTitle");
            if (TextUtils.equals(string, "auto") || TextUtils.equals(string, RVStartParams.TRANSPARENT_TITLE_ALWAYS) || TextUtils.equals(string, SchedulerSupport.CUSTOM)) {
                jSONObject.put("transparentTitle", (Object) Boolean.TRUE);
            } else {
                jSONObject.put("transparentTitle", (Object) bool);
            }
        }
        jSONObject.put("titleBarHeight", (Object) Integer.valueOf(getTitleBarHeight(activity)));
        jSONObject.put("statusBarHeight", (Object) Integer.valueOf(getStatusBarHeight(activity)));
        appendExtraSystemInfo(jSONObject);
        return jSONObject;
    }

    private void appendExtraSystemInfo(JSONObject jSONObject) {
        jSONObject.put("language", (Object) ((GriverAppLanguageExtension) RVProxy.get(GriverAppLanguageExtension.class)).getAppLanguage());
        jSONObject.put("fontSizeSetting", (Object) Float.valueOf(getFontSizeSetting()));
        RVEnvironmentService rVEnvironmentService = (RVEnvironmentService) RVProxy.get(RVEnvironmentService.class);
        jSONObject.put("version", (Object) (rVEnvironmentService != null ? rVEnvironmentService.getProductVersion() : ""));
        jSONObject.put(GriverOnPreloadExtension.PARAMS_APP, (Object) GriverEnv.getAppName());
        jSONObject.put("griverVersion", "2.52.0");
    }

    private int getHeight(Page page, Activity activity, float f, DisplayMetrics displayMetrics) {
        Render render;
        int round;
        int round2 = displayMetrics != null ? Math.round((displayMetrics.heightPixels - DisplayUtils.getTitleAndStatusBarHeight(activity)) / f) : 0;
        return (page == null || (render = page.getRender()) == null || (round = Math.round(((float) render.getView().getHeight()) / f)) <= 0) ? round2 : round;
    }

    private int getTitleBarHeight(Activity activity) {
        return Math.round(DimensionUtil.dip2px(activity, 1.0f) > 0 ? DimensionUtil.dip2px(activity, 48.0f) / r0 : 0.0f);
    }

    private int getStatusBarHeight(Activity activity) {
        if (activity != null) {
            int dip2px = DimensionUtil.dip2px(activity, 1.0f);
            Rect rect = new Rect();
            if (dip2px > 0) {
                activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                if (rect.top > 0) {
                    return rect.top / dip2px;
                }
                return 0;
            }
            return 0;
        }
        return 0;
    }

    private int getCurrentBatteryPercentage(Context context) {
        if (this.mBatteryBroadcastRegistered) {
            return this.mCachedBatteryPercentage;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            BroadcastReceiver broadcastReceiver = this.mBroadcastReceiver;
            if (broadcastReceiver != null) {
                context.unregisterReceiver(broadcastReceiver);
                this.mBroadcastReceiver = null;
            }
            BatteryBroadcastReceiver batteryBroadcastReceiver = new BatteryBroadcastReceiver();
            this.mBroadcastReceiver = batteryBroadcastReceiver;
            Intent registerReceiver = context.registerReceiver(batteryBroadcastReceiver, intentFilter);
            this.mBatteryBroadcastRegistered = true;
            int parseBatteryPercentage = parseBatteryPercentage(registerReceiver);
            if (parseBatteryPercentage > 0) {
                this.mCachedBatteryPercentage = parseBatteryPercentage;
            }
            return this.mCachedBatteryPercentage;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("getCurrentBatteryPercentage...e=");
            sb.append(e);
            RVLogger.e(sb.toString());
            return this.mCachedBatteryPercentage;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int parseBatteryPercentage(Intent intent) {
        if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
            return (intent.getIntExtra("level", 0) * 100) / intent.getIntExtra(H5MapRenderOptimizer.KEY_SCALE, 100);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class BatteryBroadcastReceiver extends BroadcastReceiver {
        private BatteryBroadcastReceiver() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int parseBatteryPercentage = SystemInfoBridgeExtension.this.parseBatteryPercentage(intent);
            if (parseBatteryPercentage > 0) {
                SystemInfoBridgeExtension.this.mCachedBatteryPercentage = parseBatteryPercentage;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("ACTION_BATTERY_CHANGED...");
            sb.append(SystemInfoBridgeExtension.this.mCachedBatteryPercentage);
            RVLogger.d(SystemInfoBridgeExtension.TAG, sb.toString());
        }
    }
}
