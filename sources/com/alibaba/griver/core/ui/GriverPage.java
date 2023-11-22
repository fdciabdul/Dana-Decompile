package com.alibaba.griver.core.ui;

import android.os.Bundle;
import android.os.Parcel;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.PageContext;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.H5Data;
import com.alibaba.griver.base.api.H5DataProvider;
import com.alibaba.griver.base.api.H5EmbededViewProvider;
import com.alibaba.griver.base.api.INebulaPage;
import com.alibaba.griver.base.nebula.H5MemData;
import com.alibaba.griver.core.embedview.H5EmbededViewProviderImpl;
import com.alibaba.griver.core.jsapi.logging.RVPerformanceLogHelper;
import com.alibaba.griver.core.render.GriverWebRenderImpl;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class GriverPage extends PageNode implements H5DataProvider, INebulaPage {

    /* renamed from: a  reason: collision with root package name */
    private boolean f6462a;
    private H5EmbededViewProvider b;
    private boolean c;
    private Map<String, Object> d;
    private long e;
    protected INebulaPage.H5PageHandler h5PageHandler;
    protected H5Data mH5Data;

    public GriverPage(App app, String str, Bundle bundle, Bundle bundle2) {
        super(app, str, bundle, bundle2);
        this.e = 0L;
        this.d = new ConcurrentHashMap();
        this.mH5Data = new H5MemData();
    }

    public GriverPage(App app, String str, Bundle bundle, Bundle bundle2, boolean z) {
        super(app, str, bundle, bundle2, z);
        this.e = 0L;
        this.d = new ConcurrentHashMap();
        this.mH5Data = new H5MemData();
    }

    public GriverPage(App app, String str, Bundle bundle, Bundle bundle2, EmbedType embedType) {
        super(app, str, bundle, bundle2, embedType);
        this.e = 0L;
        this.d = new ConcurrentHashMap();
        this.mH5Data = new H5MemData();
    }

    public GriverPage(Parcel parcel) {
        super(parcel);
        this.e = 0L;
        this.d = new ConcurrentHashMap();
        this.mH5Data = new H5MemData();
    }

    @Override // com.alibaba.ariver.app.PageNode, com.alibaba.ariver.app.api.Page
    public void bindContext(PageContext pageContext) {
        super.bindContext(pageContext);
        this.b = new H5EmbededViewProviderImpl(pageContext.getActivity(), this);
        this.f6462a = false;
        this.c = false;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public boolean ifContainsEmbedView() {
        return this.f6462a;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public void setContainsEmbedView(boolean z) {
        this.f6462a = z;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public H5EmbededViewProvider getEmbededViewProvider() {
        return this.b;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public void setExtra(String str, Object obj) {
        RVPerformanceLogHelper.safelyFillForConcurrentMap(str, obj, this.d);
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public Object getExtra(String str) {
        return this.d.get(str);
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public void setHandler(INebulaPage.H5PageHandler h5PageHandler) {
        this.h5PageHandler = h5PageHandler;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public APWebView getWebView() {
        Render render = getRender();
        if (render instanceof GriverWebRenderImpl) {
            return ((GriverWebRenderImpl) render).getApWebView();
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public boolean ifContainsEmbedSurfaceView() {
        return this.c;
    }

    @Override // com.alibaba.griver.base.api.INebulaPage
    public void setContainsEmbedSurfaceView(boolean z) {
        this.c = z;
    }

    @Override // com.alibaba.griver.base.api.H5DataProvider
    public H5Data getData() {
        return this.mH5Data;
    }

    @Override // com.alibaba.griver.base.api.H5DataProvider
    public void setData(H5Data h5Data) {
        this.mH5Data = h5Data;
    }

    public void setPageStartTime(long j) {
        this.e = j;
    }

    public long getPageStartTime() {
        return this.e;
    }

    @Override // com.alibaba.ariver.app.PageNode
    public void onDestroy() {
        Map<String, Object> map = this.d;
        if (map != null) {
            map.clear();
        }
        H5EmbededViewProvider h5EmbededViewProvider = this.b;
        if (h5EmbededViewProvider != null) {
            h5EmbededViewProvider.releaseView();
        }
        if (this.mPageContext != null) {
            this.mPageContext.destroy();
            this.mPageContext = null;
        }
        super.onDestroy();
    }
}
