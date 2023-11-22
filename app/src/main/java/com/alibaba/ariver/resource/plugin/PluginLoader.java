package com.alibaba.ariver.resource.plugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.engine.api.bridge.model.ApiContext;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.appinfo.AppUpdaterFactory;
import com.alibaba.ariver.resource.api.appinfo.IAppUpdater;
import com.alibaba.ariver.resource.api.appinfo.UpdateAppException;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback;
import com.alibaba.ariver.resource.api.appinfo.UpdatePluginParam;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.ariver.resource.api.proxy.RVPluginResourceManager;
import com.alibaba.ariver.resource.content.ResourceUtils;
import com.alibaba.ariver.tools.utils.RVToolsCommonUtil;
import com.alibaba.griver.beehive.lottie.player.TimeUtils;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes6.dex */
public class PluginLoader {
    final PluginResponse pluginResponse = new PluginResponse(null);

    /* loaded from: classes6.dex */
    public class PluginResponse {

        /* renamed from: a  reason: collision with root package name */
        private PluginModel f6234a;
        String errorCode;
        String errorMessage;

        public PluginModel getPluginModelResult() {
            return this.f6234a;
        }

        public void setPluginModelResult(PluginModel pluginModel) {
            this.f6234a = pluginModel;
        }

        public String getErrorCode() {
            return this.errorCode;
        }

        public void setErrorCode(String str) {
            this.errorCode = str;
        }

        public String getErrorMessage() {
            return this.errorMessage;
        }

        public void setErrorMessage(String str) {
            this.errorMessage = str;
        }

        public PluginResponse(PluginModel pluginModel) {
            this.f6234a = pluginModel;
        }
    }

    public PluginResponse requestPlugin(String str, String str2, String str3, App app, ApiContext apiContext, Bundle bundle) {
        String string;
        RVPluginResourceManager rVPluginResourceManager = (RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class);
        if (ResourceUtils.movePluginRefreshTimeToSp()) {
            string = rVPluginResourceManager.getPluginLastUpdateTime(str2);
            if (TextUtils.isEmpty(string)) {
                KVStorageProxy kVStorageProxy = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
                StringBuilder sb = new StringBuilder();
                sb.append("requestPluginModel_");
                sb.append(str2);
                string = kVStorageProxy.getString(str, sb.toString());
            }
        } else {
            KVStorageProxy kVStorageProxy2 = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("requestPluginModel_");
            sb2.append(str2);
            string = kVStorageProxy2.getString(str, sb2.toString());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("requestPluginModel got rate: ");
        sb3.append(string == null ? "" : string);
        RVLogger.d("AriverAPI:PluginLoader", sb3.toString());
        if (app != null && AppInfoScene.isDevSource(app.getStartParams()) && !AppInfoScene.extractScene(app.getStartParams()).isOnline()) {
            RVLogger.d("AriverAPI:PluginLoader", "requestPluginModel main package is debug");
        } else {
            PluginModel a2 = a(str2, str3, string);
            if (a2 != null && !ResourceUtils.needForceUpdate(a2)) {
                this.pluginResponse.setPluginModelResult(a2);
                return this.pluginResponse;
            }
        }
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        IAppUpdater createUpdater = AppUpdaterFactory.createUpdater(str, app == null ? null : app.getStartParams());
        if (createUpdater != null) {
            UpdatePluginParam updatePluginParam = new UpdatePluginParam(str, str2);
            updatePluginParam.setRequiredVersion(str3);
            if (bundle != null) {
                updatePluginParam.setRequestParams(bundle);
            }
            updatePluginParam.setApp(app);
            updatePluginParam.setApiContext(apiContext);
            createUpdater.updatePlugin(updatePluginParam, new UpdatePluginCallback() { // from class: com.alibaba.ariver.resource.plugin.PluginLoader.1
                @Override // com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback
                public void onSuccess(PluginModel pluginModel) {
                    PluginLoader.this.pluginResponse.f6234a = pluginModel;
                    countDownLatch.countDown();
                }

                @Override // com.alibaba.ariver.resource.api.appinfo.UpdatePluginCallback
                public void onError(UpdateAppException updateAppException) {
                    PluginLoader.this.pluginResponse.setErrorCode(updateAppException.getCode());
                    PluginLoader.this.pluginResponse.setErrorMessage(updateAppException.getMessage());
                    countDownLatch.countDown();
                }
            });
            try {
                countDownLatch.await();
            } catch (Throwable unused) {
                RVLogger.w("AriverAPI:PluginLoader", "AWAIT EXCEPTION!");
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("requestPlugin pluginId: ");
            sb4.append(str2);
            sb4.append(" requiredVersion: ");
            sb4.append(str3);
            sb4.append(" result: ");
            sb4.append(this.pluginResponse.f6234a);
            RVLogger.d("AriverAPI:PluginLoader", sb4.toString());
            if (this.pluginResponse.f6234a != null) {
                if (ResourceUtils.movePluginRefreshTimeToSp()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str3);
                    sb5.append(",");
                    sb5.append(System.currentTimeMillis());
                    rVPluginResourceManager.refreshPluginUpdateTime(str2, sb5.toString());
                } else {
                    KVStorageProxy kVStorageProxy3 = (KVStorageProxy) RVProxy.get(KVStorageProxy.class);
                    StringBuilder sb6 = new StringBuilder();
                    sb6.append("requestPluginModel_");
                    sb6.append(str2);
                    String obj = sb6.toString();
                    StringBuilder sb7 = new StringBuilder();
                    sb7.append(str3);
                    sb7.append(",");
                    sb7.append(System.currentTimeMillis());
                    kVStorageProxy3.putString(str, obj, sb7.toString());
                }
            }
            return this.pluginResponse;
        }
        return null;
    }

    private PluginModel a(String str, String str2, String str3) {
        long j;
        if (str3 != null && str3.length() != 0) {
            String[] split = str3.split(",");
            if (split.length < 2) {
                return null;
            }
            String str4 = split[0];
            try {
                j = Long.valueOf(split[1]).longValue();
            } catch (Exception e) {
                j = 0;
                RVLogger.e("AriverAPI:PluginLoader", "Long.valueOf ", e);
            }
            if (TextUtils.equals(str2, str4)) {
                if (System.currentTimeMillis() - j > RVToolsCommonUtil.safeParseLong(JSONUtils.getString(JSONUtils.parseObject(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfigWithProcessCache("h5_pluginExpireTime", "")), "time"), (long) TimeUtils.DAY_TO_SECOND) * 1000) {
                    RVLogger.d("AriverAPI:PluginLoader", "requestPluginModel out of req rate, just request!");
                } else {
                    PluginModel requiredPlugin = ((RVPluginResourceManager) RVProxy.get(RVPluginResourceManager.class)).getRequiredPlugin(str, str2);
                    if (requiredPlugin != null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("requestPluginModel in req rate, just use requiredVersion: ");
                        sb.append(str2);
                        RVLogger.d("AriverAPI:PluginLoader", sb.toString());
                        return requiredPlugin;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("requestPluginModel in req rate, but not found version: ");
                    sb2.append(str2);
                    RVLogger.d("AriverAPI:PluginLoader", sb2.toString());
                }
            }
        }
        return null;
    }
}
