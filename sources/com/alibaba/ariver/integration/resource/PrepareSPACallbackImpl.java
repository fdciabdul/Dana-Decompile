package com.alibaba.ariver.integration.resource;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.AppManager;
import com.alibaba.ariver.app.api.EntryInfo;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.proxy.RVSinglePageAppProxy;
import com.alibaba.ariver.integration.CreatePageCallback;
import com.alibaba.ariver.integration.ipc.server.RVAppRecord;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.prepare.PrepareCallbackParam;
import com.alibaba.ariver.resource.api.prepare.PrepareContext;
import com.alibaba.ariver.resource.api.prepare.PrepareData;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alibaba.ariver.resource.content.ResourceUtils;

/* loaded from: classes6.dex */
public class PrepareSPACallbackImpl extends PrepareCallbackImpl {

    /* renamed from: a  reason: collision with root package name */
    private CreatePageCallback f6065a;
    private Activity b;

    @Override // com.alibaba.ariver.integration.resource.PrepareCallbackImpl, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void showLoading(boolean z, EntryInfo entryInfo) {
    }

    public PrepareSPACallbackImpl(Activity activity, RVAppRecord rVAppRecord, PrepareContext prepareContext, CreatePageCallback createPageCallback) {
        super(rVAppRecord, prepareContext);
        this.f6065a = createPageCallback;
        this.b = activity;
    }

    @Override // com.alibaba.ariver.integration.resource.PrepareCallbackImpl, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void prepareFail(PrepareData prepareData, PrepareException prepareException) {
        if (this.f6065a != null) {
            RVLogger.e("AriverInt:PrepareSPACallbackImpl", "PrepareSPACallbackImpl prepareFail: ", prepareException);
        }
    }

    @Override // com.alibaba.ariver.integration.resource.PrepareCallbackImpl, com.alibaba.ariver.resource.api.prepare.PrepareCallback
    public void startApp(PrepareCallbackParam prepareCallbackParam) {
        if (this.mAlreadyStarted) {
            return;
        }
        this.mAlreadyStarted = true;
        Bundle sceneParams = this.mAppRecord.getSceneParams();
        if (prepareCallbackParam.appInfo != null) {
            sceneParams.putParcelable("appInfo", prepareCallbackParam.appInfo);
            this.mAppRecord.setAppModel(prepareCallbackParam.appInfo);
        }
        if (!TextUtils.isEmpty(this.mPrepareContext.appType)) {
            sceneParams.putString("appType", this.mPrepareContext.appType);
        }
        EntryInfo entryInfo = this.mPrepareContext.getEntryInfo();
        if (entryInfo == null) {
            entryInfo = ResourceUtils.getEntryInfo(prepareCallbackParam.appInfo);
        }
        if (entryInfo != null) {
            sceneParams.putParcelable(RVConstants.EXTRA_ENTRY_INFO, entryInfo);
        }
        sceneParams.putLong(RVConstants.EXTRA_PREPARE_START_CLIENT_TIME, SystemClock.elapsedRealtime());
        Bundle bundle = prepareCallbackParam.startParams;
        Bundle sceneParams2 = this.mAppRecord.getSceneParams();
        App startApp = ((AppManager) RVProxy.get(AppManager.class)).startApp(BundleUtils.getString(bundle, "appId"), bundle, sceneParams2);
        startApp.addPageReadyListener(new App.PageReadyListener() { // from class: com.alibaba.ariver.integration.resource.PrepareSPACallbackImpl.1
            @Override // com.alibaba.ariver.app.api.App.PageReadyListener
            public void onPageReady(Page page) {
                StringBuilder sb = new StringBuilder();
                sb.append("startApp PageReadyListener onPageReady ");
                sb.append(page);
                RVLogger.d("AriverInt:PrepareSPACallbackImpl", sb.toString());
                if (PrepareSPACallbackImpl.this.f6065a != null) {
                    PrepareSPACallbackImpl.this.f6065a.onPageCreate(page);
                }
            }
        });
        startApp.bindContext(((RVSinglePageAppProxy) RVProxy.get(RVSinglePageAppProxy.class)).createAppContext(startApp, this.b));
        startApp.start();
    }
}
