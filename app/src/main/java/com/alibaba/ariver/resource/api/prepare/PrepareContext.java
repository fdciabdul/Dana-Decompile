package com.alibaba.ariver.resource.api.prepare;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.ParamUtils;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.immutable.ImmutableBundle;
import com.alibaba.ariver.kernel.common.multiinstance.InstanceType;
import com.alibaba.ariver.kernel.common.multiinstance.MultiInstanceUtils;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoQuery;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONObject;

/* loaded from: classes3.dex */
public class PrepareContext {

    /* renamed from: a  reason: collision with root package name */
    private AppInfoQuery f6215a;
    public String appType;
    private String b;
    private String c;
    private long d;
    public String degradeUrl;
    private Bundle e;
    private Bundle f;
    private ImmutableBundle g;
    private boolean h;
    public boolean hasDegradePkg;
    private Context i;
    public boolean isUsePresetPopmenu;
    private AppModel j;
    private EntryInfo k;
    private PrepareData l;
    private long m;
    private StepType n;
    public OfflineMode offlineMode;
    public UpdateMode updateMode;

    public StepType getAppCreateStepType() {
        return this.n;
    }

    public void setAppCreateStepType(StepType stepType) {
        this.n = stepType;
    }

    public PrepareContext(String str) {
        this(null, str, new Bundle(), new Bundle());
    }

    public PrepareContext(Context context, String str, Bundle bundle, Bundle bundle2) {
        this.updateMode = UpdateMode.ASYNC;
        this.offlineMode = OfflineMode.ASYNC;
        this.m = 30000L;
        this.g = new ImmutableBundle(bundle);
        this.i = context;
        this.b = str;
        this.d = BundleUtils.getLong(bundle2, RVConstants.EXTRA_START_TOKEN);
        this.e = this.g.mutable();
        this.f = bundle2;
        PrepareData prepareData = new PrepareData();
        this.l = prepareData;
        prepareData.clear();
    }

    public long getStartToken() {
        return this.d;
    }

    public ImmutableBundle getOriginStartParams() {
        return this.g;
    }

    public PrepareData getPrepareData() {
        return this.l;
    }

    public Bundle getStartParams() {
        return this.e;
    }

    public Bundle getSceneParams() {
        return this.f;
    }

    public String getAppVersion() {
        return this.c;
    }

    public String getAppId() {
        return this.b;
    }

    public boolean isOriginHasAppInfo() {
        return this.h;
    }

    public void setOriginHasAppInfo(boolean z) {
        this.h = z;
    }

    public AppModel getAppModel() {
        return this.j;
    }

    public void setStartContext(Context context) {
        this.i = context;
    }

    public Context getStartContext() {
        return this.i;
    }

    public void setTimeout(long j) {
        this.m = j;
    }

    public long getTimeout() {
        return this.m;
    }

    public EntryInfo getEntryInfo() {
        return this.k;
    }

    public void setEntryInfo(EntryInfo entryInfo) {
        this.k = entryInfo;
    }

    public AppInfoQuery getAppInfoQuery() {
        return this.f6215a;
    }

    public void setAppInfoQuery(AppInfoQuery appInfoQuery) {
        this.f6215a = appInfoQuery;
    }

    private void a() {
        this.e = this.g.mutable();
    }

    public void setupAppInfo(AppModel appModel) {
        JSONObject jSONObject;
        StringBuilder sb = new StringBuilder();
        sb.append("setupAppInfo: ");
        sb.append(appModel);
        RVLogger.d(RVConstants.RESOURCE_TAG, sb.toString());
        a();
        this.j = appModel;
        this.f.putParcelable("appInfo", appModel);
        if (appModel.getExtendInfos() != null) {
            String string = JSONUtils.getString(appModel.getExtendInfos(), "usePresetPopmenu");
            if (TextUtils.isEmpty(string) && MultiInstanceUtils.getInstanceTypeFromParam(this.e) == InstanceType.TAOBAO) {
                appModel.getExtendInfos().put("usePresetPopmenu", "YES");
                this.isUsePresetPopmenu = true;
            } else {
                this.isUsePresetPopmenu = TextUtils.equals("YES", string);
            }
        }
        if (appModel.getContainerInfo() != null) {
            ParamUtils.mergeParams(this.e, appModel.getContainerInfo().getLaunchParams());
        }
        if (appModel.getExtendInfos() != null && (jSONObject = JSONUtils.getJSONObject(appModel.getExtendInfos(), RVConstants.EXTRA_RES_LAUNCH_PARAMS, null)) != null) {
            ParamUtils.mergeParams(this.e, jSONObject);
        }
        ParamUtils.unify(this.e, RVStartParams.LONG_NB_UPDATE, false);
        ParamUtils.unify(this.e, RVStartParams.LONG_NB_OFFLINE, false);
        ParamUtils.unify(this.e, RVStartParams.LONG_NB_URL, false);
        ParamUtils.unify(this.e, RVStartParams.LONG_NB_VERSION, false);
        ParamUtils.unify(this.e, RVParams.LONG_NB_OFFMODE, false);
        ParamUtils.unify(this.e, "url", false);
        String string2 = this.g.getString("url", null);
        if (TextUtils.isEmpty(string2)) {
            string2 = this.g.getString("u", null);
        }
        if (TextUtils.isEmpty(string2)) {
            string2 = appModel.getAppInfoModel().getMainUrl();
            this.e.putString("url", string2);
        }
        if (TextUtils.isEmpty(BundleUtils.getString(this.e, "appxRouteFramework"))) {
            this.e.putString("appxRouteFramework", "NO");
        }
        this.e.putString("onlineHost", appModel.getAppInfoModel().getVhost());
        ParamUtils.parseMagicOptions(this.e, string2);
        String version = appModel.getAppInfoModel().getVersion();
        this.c = version;
        this.l.setVersion(version);
        if (this.h) {
            return;
        }
        this.offlineMode = OfflineMode.fromString(BundleUtils.getString(this.e, RVStartParams.LONG_NB_OFFLINE), BundleUtils.getString(this.e, RVParams.LONG_NB_OFFMODE));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PrepareContext{\nappId=");
        sb.append(this.b);
        sb.append("\noriginStartParam=");
        sb.append(this.g);
        sb.append("\nupdateMode=");
        sb.append(this.updateMode);
        sb.append("\nofflineMode=");
        sb.append(this.offlineMode);
        sb.append('}');
        return sb.toString();
    }
}
