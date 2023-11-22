package com.alibaba.griver.ui.splash;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.ui.loading.SplashView;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.api.ui.GVSplashView;
import com.alibaba.griver.api.ui.splash.GriverSplashFragmentExtension;
import com.alibaba.griver.api.ui.splash.SplashEntryInfo;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitor;
import com.alibaba.griver.base.stagemonitor.GriverStageMonitorManager;
import com.alibaba.griver.base.stagemonitor.impl.GriverFullLinkStageMonitor;
import com.alibaba.griver.ui.R;
import java.util.Map;

/* loaded from: classes3.dex */
public class GriverSplashView extends BaseSplashView {

    /* renamed from: a */
    private JSONObject f6753a;
    private int b;
    private FragmentManager c;
    private GriverSplashFragmentExtension.AbstractSplashFragment d;
    private SplashView.Status e;
    private App f;
    private AppModel g;

    public GriverSplashView(FragmentManager fragmentManager, App app, AppModel appModel) {
        super(app);
        this.c = fragmentManager;
        this.f = app;
        this.b = R.id.splash_container;
        this.e = SplashView.Status.WAITING;
        this.g = appModel == null ? new AppModel() : appModel;
    }

    @Override // com.alibaba.griver.ui.splash.BaseSplashView, com.alibaba.ariver.app.api.ui.loading.SplashView
    public void showLoading(final EntryInfo entryInfo) {
        if (entryInfo == null) {
            return;
        }
        super.showLoading(entryInfo);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.splash.GriverSplashView.1
            {
                GriverSplashView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GriverSplashView.this.f != null && !GriverSplashView.this.f.isDestroyed()) {
                    if (GriverSplashView.this.e != SplashView.Status.ERROR && GriverSplashView.this.e != SplashView.Status.LOADING) {
                        GriverSplashView.this.e = SplashView.Status.LOADING;
                        GriverSplashView.this.a();
                        SplashEntryInfo a2 = GriverSplashView.this.a(entryInfo);
                        StringBuilder sb = new StringBuilder();
                        sb.append("showLoading with loadingFragment added ");
                        sb.append(GriverSplashView.this.d.isAdded());
                        sb.append(" and loadingInfo:");
                        sb.append(a2);
                        RVLogger.d("SplashView", sb.toString());
                        try {
                            Bundle bundle = GriverSplashView.this.d.getArguments() == null ? new Bundle() : GriverSplashView.this.d.getArguments();
                            if (!GriverSplashView.this.d.isAdded()) {
                                bundle.putString("usePresetPopmenu", BundleUtils.getString(GriverSplashView.this.f.getSceneParams(), "usePresetPopmenu"));
                                bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, a2);
                                bundle.putParcelable("appInfo", GriverSplashView.this.g);
                                GriverSplashView.this.d.setArguments(bundle);
                                return;
                            }
                            if (a2.needRefresh) {
                                GriverSplashView.this.d.updateLoadingInfo(a2);
                            }
                            GriverSplashView.this.d.updateProgress(a2);
                            return;
                        } catch (Throwable th) {
                            RVLogger.e("SplashView", "showLoading with loadingFragment exception", th);
                            return;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("showLoading not work on ");
                    sb2.append(GriverSplashView.this.e);
                    sb2.append(" Status");
                    RVLogger.w("SplashView", sb2.toString());
                    return;
                }
                RVLogger.w("SplashView", "app has been destroyed");
            }
        });
    }

    private int a(String str) {
        try {
            if (this.f6753a == null) {
                this.f6753a = JSON.parseObject(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_DEFAULT_SPLASH_VIEW_LOADING_STYLE));
            }
            JSONObject jSONObject = this.f6753a;
            if (jSONObject != null) {
                boolean z = JSONUtils.getBoolean(jSONObject, GriverConfigConstants.PARAM_ALL_USE_PROGRESS_STYLE, true);
                JSONArray jSONArray = JSONUtils.getJSONArray(this.f6753a, GriverConfigConstants.PARAM_SPECIFIC_APPIDS, new JSONArray());
                if (z) {
                    return 1;
                }
                return !jSONArray.contains(str) ? 0 : 1;
            }
            return 1;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("get splash config error: ");
            sb.append(e);
            GriverLogger.w("SplashView", sb.toString());
            return 1;
        }
    }

    public SplashEntryInfo a(EntryInfo entryInfo) {
        SplashEntryInfo splashEntryInfo = new SplashEntryInfo();
        App app = this.f;
        if (app != null) {
            splashEntryInfo.appId = app.getAppId();
        }
        if (entryInfo != null) {
            splashEntryInfo.appName = entryInfo.title;
            splashEntryInfo.slogan = entryInfo.slogan;
            splashEntryInfo.desc = entryInfo.desc;
            splashEntryInfo.iconUrl = entryInfo.iconUrl;
            if (entryInfo.extraInfo != null) {
                splashEntryInfo.progress = entryInfo.extraInfo.getInteger("progress").intValue();
                splashEntryInfo.needRefresh = entryInfo.extraInfo.getBoolean(SplashEntryInfo.NEED_REFRESH).booleanValue();
            }
        }
        return splashEntryInfo;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void update(final EntryInfo entryInfo) {
        if (this.e != SplashView.Status.LOADING) {
            RVLogger.w("SplashView", "updateLoading before showLoading would not working!");
            return;
        }
        final SplashEntryInfo a2 = a(entryInfo);
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.splash.GriverSplashView.2
            {
                GriverSplashView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (GriverSplashView.this.d != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("updateLoading with loadingFragment isAdded: ");
                    sb.append(GriverSplashView.this.d.isAdded());
                    sb.append(" and loadingInfo:");
                    sb.append(entryInfo);
                    RVLogger.d("SplashView", sb.toString());
                    Bundle bundle = GriverSplashView.this.d.getArguments() == null ? new Bundle() : GriverSplashView.this.d.getArguments();
                    if (!GriverSplashView.this.d.isAdded()) {
                        bundle.putParcelable(RVConstants.EXTRA_ENTRY_INFO, a2);
                        GriverSplashView.this.d.setArguments(bundle);
                        return;
                    }
                    if (a2.needRefresh) {
                        GriverSplashView.this.d.updateLoadingInfo(a2);
                    }
                    GriverSplashView.this.d.updateProgress(a2);
                }
            }
        });
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public void showError(final String str, final String str2, Map<String, String> map) {
        this.e = SplashView.Status.ERROR;
        Fragment findFragmentByTag = this.c.findFragmentByTag(SplashFragment.FRAGMENT_TAG);
        StringBuilder sb = new StringBuilder();
        sb.append("showError with loadingFragment: ");
        sb.append(findFragmentByTag);
        RVLogger.d("SplashView", sb.toString());
        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.ui.splash.GriverSplashView.3
            {
                GriverSplashView.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                GriverSplashView.this.a();
                if (GriverSplashView.this.d != null) {
                    Bundle bundle = GriverSplashView.this.d.getArguments() == null ? new Bundle() : GriverSplashView.this.d.getArguments();
                    if (GriverSplashView.this.d.isAdded() || GriverSplashView.this.d.isStateSaved()) {
                        GriverSplashView.this.d.showError(str, str2);
                        return;
                    }
                    bundle.putBoolean("showError", true);
                    bundle.putString("errorCode", str);
                    bundle.putString("errorMessage", str2);
                    GriverSplashView.this.d.setArguments(bundle);
                }
            }
        });
    }

    public void a() {
        if (this.d == null) {
            GriverSplashFragmentExtension.AbstractSplashFragment createSplashFragment = ((GriverSplashFragmentExtension) RVProxy.get(GriverSplashFragmentExtension.class)).createSplashFragment();
            this.d = createSplashFragment;
            if (createSplashFragment == null) {
                GriverLogger.e("SplashView", "splash fragment is null, can not show loading");
                return;
            }
            FragmentTransaction beginTransaction = this.c.beginTransaction();
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2(this.b, this.d, SplashFragment.FRAGMENT_TAG, 1);
            beginTransaction.KClassImpl$Data$declaredNonStaticMembers$2();
            this.d.setReloadListener(new GVSplashView.OnReloadListener() { // from class: com.alibaba.griver.ui.splash.GriverSplashView.4
                {
                    GriverSplashView.this = this;
                }

                @Override // com.alibaba.griver.api.ui.GVSplashView.OnReloadListener
                public void onReload() {
                    GriverSplashView.this.e = SplashView.Status.WAITING;
                    GriverSplashView.this.reload();
                }
            });
            StringBuilder sb = new StringBuilder();
            sb.append(GriverFullLinkStageMonitor.MONITOR_TOKEN);
            sb.append(this.f.getAppId());
            sb.append(this.f.getStartToken());
            String obj = sb.toString();
            GriverStageMonitor stageMonitor = GriverStageMonitorManager.getInstance().getStageMonitor(obj);
            if (stageMonitor == null) {
                stageMonitor = new GriverFullLinkStageMonitor();
                GriverStageMonitorManager.getInstance().registerStageMonitor(obj, stageMonitor);
            }
            if (this.f.isTinyApp()) {
                if (this.d instanceof SplashFragment) {
                    if (a(this.f.getAppId()) == 0) {
                        stageMonitor.addParam(GriverMonitorConstants.KEY_SPLASH_LOADING_STYLE, 0);
                        return;
                    } else {
                        stageMonitor.addParam(GriverMonitorConstants.KEY_SPLASH_LOADING_STYLE, 1);
                        return;
                    }
                }
                stageMonitor.addParam(GriverMonitorConstants.KEY_SPLASH_LOADING_STYLE, 2);
                return;
            }
            stageMonitor.addParam(GriverMonitorConstants.KEY_SPLASH_LOADING_STYLE, -1);
        }
    }

    /* renamed from: com.alibaba.griver.ui.splash.GriverSplashView$5 */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$alibaba$ariver$app$api$ui$loading$SplashView$Status;

        static {
            int[] iArr = new int[SplashView.Status.values().length];
            $SwitchMap$com$alibaba$ariver$app$api$ui$loading$SplashView$Status = iArr;
            try {
                iArr[SplashView.Status.WAITING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$ui$loading$SplashView$Status[SplashView.Status.EXIT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$ui$loading$SplashView$Status[SplashView.Status.LOADING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$alibaba$ariver$app$api$ui$loading$SplashView$Status[SplashView.Status.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.alibaba.griver.ui.splash.BaseSplashView, com.alibaba.ariver.app.api.ui.loading.SplashView
    public void exit(SplashView.ExitListener exitListener) {
        super.exit(exitListener);
        int i = AnonymousClass5.$SwitchMap$com$alibaba$ariver$app$api$ui$loading$SplashView$Status[this.e.ordinal()];
        if (i == 1 || i == 2) {
            if (exitListener != null) {
                exitListener.onExit();
            }
        } else if (i == 3 || i == 4) {
            Fragment findFragmentByTag = this.c.findFragmentByTag(SplashFragment.FRAGMENT_TAG);
            StringBuilder sb = new StringBuilder();
            sb.append("exitLoading with loadingFragment: ");
            sb.append(findFragmentByTag);
            RVLogger.d("SplashView", sb.toString());
            if (findFragmentByTag instanceof GriverSplashFragmentExtension.AbstractSplashFragment) {
                ((GriverSplashFragmentExtension.AbstractSplashFragment) findFragmentByTag).exit();
                this.c.beginTransaction().KClassImpl$Data$declaredNonStaticMembers$2(findFragmentByTag).KClassImpl$Data$declaredNonStaticMembers$2();
            }
            if (exitListener != null) {
                exitListener.onExit();
            }
        }
        this.e = SplashView.Status.EXIT;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public SplashView.Status getStatus() {
        return this.e;
    }

    @Override // com.alibaba.ariver.app.api.ui.loading.SplashView
    public boolean backPressed() {
        if (this.e == SplashView.Status.LOADING || this.e == SplashView.Status.ERROR) {
            this.f.exit();
            return true;
        }
        return false;
    }

    public GriverSplashFragmentExtension.AbstractSplashFragment getSplashFragment() {
        return this.d;
    }
}
