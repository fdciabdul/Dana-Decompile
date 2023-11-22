package com.alibaba.griver.core.jsapi.device.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeExtension;
import com.alibaba.ariver.kernel.api.security.Permission;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.remotedebug.utils.RemoteDebugMessageUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.account.GriverAccount;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.security.GriverSecurityManager;
import com.alibaba.griver.base.common.utils.AppTypeUtils;
import com.alibaba.griver.base.common.utils.MD5Util;
import com.alibaba.griver.base.utils.RemoteDebugCompatUtils;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.proxy.BridgeResponseUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.huawei.hms.utils.FileUtil;
import id.dana.data.here.HereOauthManager;
import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class StorageBridgeExtension implements BridgeExtension {
    private static final long AR_LOCAL_STORAGE_LIMIT = 10485760;
    private static final int EXCEPTION_KEY_NOT_EXIST = 11;
    private static final int EXCEPTION_MAXIMUM_LIMIT = 12;
    private static final int EXCEPTION_PARAM_EMPTY = 2;
    private static final int EXCEPTION_SINGLE_LENGTH = 14;
    private static final int EXCEPTION_STORAGE = 13;
    private static final int MINIPROGRAM_ID_LEN = 16;
    private static final String PLUGIN_PRESTR = "plugin-private://";
    private static final long SINGLE_STORAGE_LIMIT = 204800;
    private static final String TAG = "StorageBridgeExtension";

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onFinalized() {
    }

    @Override // com.alibaba.ariver.kernel.api.extension.Extension
    public void onInitialized() {
    }

    @Override // com.alibaba.ariver.kernel.api.security.Guard
    public Permission permit() {
        return null;
    }

    private static SharedPreferences getSharedPreferenceForApp(Context context, Page page, String str) {
        String appId = (page == null || page.getApp() == null) ? "" : page.getApp().getAppId();
        if (AppTypeUtils.isEmbedPage(page)) {
            StringBuilder sb = new StringBuilder();
            sb.append(appId);
            sb.append("_web-view");
            appId = sb.toString();
        }
        if (str != null && str.contains("/")) {
            str = MD5Util.getMD5String(str);
        }
        if (context != null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("rv_local_storage_");
            sb2.append(appId);
            sb2.append("_");
            sb2.append(str);
            return context.getSharedPreferences(sb2.toString(), 4);
        }
        return null;
    }

    private static JSONObject getSharedPreferenceInfo(Context context, Page page) {
        SharedPreferences sharedPreferenceForApp = getSharedPreferenceForApp(context, page, getUsrIdOfSp(page));
        if (sharedPreferenceForApp != null) {
            JSONObject jSONObject = new JSONObject();
            Map<String, ?> all = sharedPreferenceForApp.getAll();
            double totalSize = getTotalSize(sharedPreferenceForApp);
            jSONObject.put(UserMetadata.KEYDATA_FILENAME, (Object) all.keySet());
            Double.isNaN(totalSize);
            jSONObject.put("currentSize", (Object) Double.valueOf(totalSize / 1024.0d));
            jSONObject.put("limitSize", (Object) Long.valueOf((long) FileUtil.LOCAL_REPORT_FILE_MAX_SIZE));
            return jSONObject;
        }
        return null;
    }

    private static long getTotalSize(SharedPreferences sharedPreferences) {
        long j = 0;
        if (sharedPreferences == null) {
            return 0L;
        }
        for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
            int i = 0;
            try {
                i = 0 + ((String) entry.getValue()).getBytes(HereOauthManager.ENC).length;
                i += entry.getKey().getBytes(HereOauthManager.ENC).length;
            } catch (UnsupportedEncodingException unused) {
            }
            j += i;
        }
        return j;
    }

    private static String getUsrIdOfSp(Page page) {
        String userId = GriverAccount.getUserId();
        String originalURI = page.getOriginalURI();
        if (originalURI.contains("plugin-private://")) {
            int indexOf = originalURI.indexOf("plugin-private://") + 17;
            String substring = originalURI.substring(indexOf, indexOf + 16);
            StringBuilder sb = new StringBuilder();
            sb.append(userId);
            sb.append("_");
            sb.append(substring);
            return sb.toString();
        }
        return userId;
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void setTinyLocalStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {"key"}) String str, @BindingParam(name = {"data"}) Object obj, @BindingCallback BridgeCallback bridgeCallback) {
        String encrypt;
        synchronized (this) {
            String usrIdOfSp = getUsrIdOfSp(page);
            Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
            SharedPreferences sharedPreferenceForApp = getSharedPreferenceForApp(applicationContext, page, usrIdOfSp);
            if (sharedPreferenceForApp == null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
            } else if (TextUtils.isEmpty(str)) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, applicationContext.getString(R.string.griver_core_required_key_empty)));
            } else {
                String str2 = null;
                if (obj instanceof String) {
                    str2 = (String) obj;
                } else if (obj instanceof JSONObject) {
                    str2 = ((JSONObject) obj).toJSONString();
                }
                if (TextUtils.isEmpty(str2) || str2 == null) {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, applicationContext.getString(R.string.griver_core_required_key_empty)));
                } else if (str2.length() > SINGLE_STORAGE_LIMIT) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("current length: ");
                    sb.append(str2.getBytes().length);
                    GriverLogger.w(TAG, sb.toString());
                    bridgeCallback.sendBridgeResponse(BridgeResponse.newError(14, applicationContext.getString(R.string.griver_core_data_exceeds_200)));
                } else {
                    long totalSize = getTotalSize(sharedPreferenceForApp);
                    long length = str.getBytes().length + str2.getBytes().length;
                    if (sharedPreferenceForApp.contains(str)) {
                        if ((totalSize - (str.getBytes().length + sharedPreferenceForApp.getString(str, "").getBytes().length)) + length > AR_LOCAL_STORAGE_LIMIT) {
                            bridgeCallback.sendBridgeResponse(BridgeResponse.newError(12, applicationContext.getString(R.string.griver_core_set_stroage_exceed_limit)));
                            return;
                        }
                    } else if (totalSize + length > AR_LOCAL_STORAGE_LIMIT) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(12, applicationContext.getString(R.string.griver_core_set_stroage_exceed_limit)));
                        return;
                    }
                    try {
                        encrypt = GriverSecurityManager.encrypt(str2);
                    } catch (Exception e) {
                        GriverLogger.e(TAG, "encrypt exception", e);
                        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
                    }
                    if (encrypt == null) {
                        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
                        return;
                    }
                    sharedPreferenceForApp.edit().putString(str, encrypt).commit();
                    sendStorageToRemote(page, sharedPreferenceForApp);
                    bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                }
            }
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getTinyLocalStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {"key"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            String usrIdOfSp = getUsrIdOfSp(page);
            Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
            SharedPreferences sharedPreferenceForApp = getSharedPreferenceForApp(applicationContext, page, usrIdOfSp);
            if (sharedPreferenceForApp == null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                if (sharedPreferenceForApp.contains(str)) {
                    try {
                        String decrypt = GriverSecurityManager.decrypt(sharedPreferenceForApp.getString(str, ""));
                        if (decrypt == null) {
                            bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, applicationContext.getString(R.string.griver_core_no_such_key)));
                        } else {
                            jSONObject.put("data", (Object) decrypt);
                            bridgeCallback.sendJSONResponse(BridgeResponseUtils.appendSuccess(jSONObject));
                        }
                    } catch (Exception e) {
                        GriverLogger.e(TAG, "decrypt exception", e);
                        bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
                    }
                } else {
                    bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(11, applicationContext.getString(R.string.griver_core_no_such_key)));
                }
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, applicationContext.getString(R.string.griver_core_required_key_empty)));
            }
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void removeTinyLocalStorage(@BindingNode(Page.class) Page page, @BindingParam(name = {"key"}) String str, @BindingCallback BridgeCallback bridgeCallback) {
        synchronized (this) {
            Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
            SharedPreferences sharedPreferenceForApp = getSharedPreferenceForApp(applicationContext, page, getUsrIdOfSp(page));
            if (sharedPreferenceForApp == null) {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                sharedPreferenceForApp.edit().remove(str).commit();
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                sendStorageToRemote(page, sharedPreferenceForApp);
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(2, applicationContext.getString(R.string.griver_core_required_key_empty)));
            }
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void clearTinyLocalStorage(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        synchronized (this) {
            Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
            SharedPreferences sharedPreferenceForApp = getSharedPreferenceForApp(applicationContext, page, getUsrIdOfSp(page));
            if (sharedPreferenceForApp != null) {
                sharedPreferenceForApp.edit().clear().commit();
                bridgeCallback.sendBridgeResponse(BridgeResponse.SUCCESS);
                sendStorageToRemote(page, sharedPreferenceForApp);
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
            }
        }
    }

    @ThreadType(ExecutorType.IO)
    @ActionFilter
    public void getTinyLocalStorageInfo(@BindingNode(Page.class) Page page, @BindingCallback BridgeCallback bridgeCallback) {
        synchronized (this) {
            Context applicationContext = page.getApp().getAppContext().getContext().getApplicationContext();
            JSONObject sharedPreferenceInfo = getSharedPreferenceInfo(applicationContext, page);
            if (sharedPreferenceInfo != null) {
                bridgeCallback.sendJSONResponse(BridgeResponseUtils.appendSuccess(sharedPreferenceInfo));
            } else {
                bridgeCallback.sendBridgeResponse(new BridgeResponse.Error(13, applicationContext.getString(R.string.griver_core_storage_exception)));
            }
        }
    }

    public void sendStorageToRemote(Page page, SharedPreferences sharedPreferences) {
        if (RemoteDebugCompatUtils.isInDebugMode(page.getApp())) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (sharedPreferences.getAll() != null && sharedPreferences.getAll().size() > 0) {
                for (Map.Entry<String, ?> entry : sharedPreferences.getAll().entrySet()) {
                    try {
                        String decrypt = GriverSecurityManager.decrypt(String.valueOf(entry.getValue()));
                        if (decrypt != null) {
                            linkedHashMap.put(entry.getKey(), decrypt);
                        }
                    } catch (Exception e) {
                        GriverLogger.e(TAG, "decrypt exception", e);
                    }
                }
            }
            RemoteDebugMessageUtils.sendStorage(page, linkedHashMap);
        }
    }
}
