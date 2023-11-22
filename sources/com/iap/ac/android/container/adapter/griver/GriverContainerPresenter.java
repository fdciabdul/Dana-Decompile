package com.iap.ac.android.container.adapter.griver;

import android.app.Activity;
import android.content.Context;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.iap.ac.android.common.container.IContainerPresenter;
import com.iap.ac.android.common.log.ACLog;
import java.util.Map;

/* loaded from: classes8.dex */
public class GriverContainerPresenter implements IContainerPresenter {

    /* renamed from: a  reason: collision with root package name */
    private Page f7554a;

    public GriverContainerPresenter(Page page) {
        this.f7554a = page;
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void setTitle(String str) {
        Page page = this.f7554a;
        if (page == null) {
            return;
        }
        page.getPageContext().getTitleBar().setTitle(str, "", "", "", false);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void reloadPage() {
        Page page = this.f7554a;
        if (page == null) {
            return;
        }
        page.getRender().reload();
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void loadUrl(String str) {
        if (this.f7554a == null) {
            return;
        }
        LoadParams loadParams = new LoadParams();
        loadParams.url = str;
        this.f7554a.getRender().load(loadParams);
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void postUrl(String str, byte[] bArr) {
        ACLog.e("GriverContainerPresenter", "postUrl not support.");
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void closeWebview() {
        Page page = this.f7554a;
        if (page == null) {
            return;
        }
        page.getApp().exit();
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public void showNetWorkCheckActivity(Map<String, String> map) {
        Page page;
        if (map == null || map.isEmpty() || (page = this.f7554a) == null || page.getPageContext().getActivity() == null) {
            return;
        }
        ACLog.e("GriverContainerPresenter", "showNetWorkCheckActivity not support.");
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public Context getContext() {
        Page page = this.f7554a;
        if (page != null) {
            return page.getPageContext().getActivity();
        }
        return null;
    }

    @Override // com.iap.ac.android.common.container.IContainerPresenter
    public Activity getActivity() {
        Page page = this.f7554a;
        if (page != null) {
            return page.getPageContext().getActivity();
        }
        return null;
    }
}
