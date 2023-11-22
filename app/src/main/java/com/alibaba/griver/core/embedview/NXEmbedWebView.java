package com.alibaba.griver.core.embedview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.PageNode;
import com.alibaba.ariver.app.api.EmbedType;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.PageContainer;
import com.alibaba.ariver.engine.api.EngineUtils;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.model.LoadParams;
import com.alibaba.ariver.integration.embedview.BaseEmbedView;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.api.INebulaPage;
import com.alibaba.griver.base.common.constants.GriverBaseConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.ui.GriverPage;
import com.alipay.mobile.zebra.data.ZebraData;
import java.util.Map;

/* loaded from: classes3.dex */
public class NXEmbedWebView extends BaseEmbedView {
    public static final String MINI_WEB_VIEW_TAG = "MINI-PROGRAM-MINI-WEB-VIEW-TAG";
    public static final String ON_TO_WEBVIEW_MESSAGE = "onToWebViewMessage";
    public static final String POST_MESSAGE_ACTION_TYPE = "postMessage";
    public static final String WEB_VIEW_FILL = "MINI-PROGRAM-WEB-VIEW-FILL";
    public static final String WEB_VIEW_PAGE_TAG = "MINI-PROGRAM-WEB-VIEW-PAGE-TAG";
    public static final String WEB_VIEW_TAG = "MINI-PROGRAM-WEB-VIEW-TAG";
    public static final String WEB_VIEW_WORK_ID = "MINI-PROGRAM-WEB-VIEW-WORKID";

    /* renamed from: a  reason: collision with root package name */
    private GriverPage f6403a;
    private View b;
    private Map<String, String> c;
    private FrameLayout e;
    private String f;
    private String h;
    private boolean i;
    private long d = 16;
    private boolean g = false;
    private View.OnLayoutChangeListener j = new View.OnLayoutChangeListener() { // from class: com.alibaba.griver.core.embedview.NXEmbedWebView.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            StringBuilder sb = new StringBuilder();
            sb.append("onLayoutChange! l: ");
            sb.append(i);
            sb.append(", t: ");
            sb.append(i2);
            sb.append(", r: ");
            sb.append(i3);
            sb.append(", b: ");
            sb.append(i4);
            RVLogger.d("Griver:NXEmbedWebView", sb.toString());
            ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.embedview.NXEmbedWebView.1.1
                @Override // java.lang.Runnable
                public void run() {
                    ViewGroup.LayoutParams layoutParams;
                    if (NXEmbedWebView.this.i) {
                        try {
                            RVLogger.d("Griver:NXEmbedWebView", "onLayoutChange ,check fill status");
                            Page outerPage = NXEmbedWebView.this.getOuterPage();
                            if (outerPage != null && outerPage.getRender() != null && outerPage.getRender().getView() != null) {
                                int width = outerPage.getRender().getView().getWidth();
                                int height = outerPage.getRender().getView().getHeight();
                                if ((NXEmbedWebView.this.b.getWidth() == width && NXEmbedWebView.this.b.getHeight() == height) || (layoutParams = NXEmbedWebView.this.b.getLayoutParams()) == null) {
                                    return;
                                }
                                if (layoutParams.width == width && layoutParams.height == height) {
                                    return;
                                }
                                layoutParams.width = width;
                                layoutParams.height = height;
                                NXEmbedWebView.this.b.setLayoutParams(layoutParams);
                                return;
                            }
                            RVLogger.e("Griver:NXEmbedWebView", "onLayoutChange ,view is null ");
                        } catch (Exception e) {
                            RVLogger.e("Griver:NXEmbedWebView", "layout adjust error", e);
                        }
                    }
                }
            }, NXEmbedWebView.this.d);
        }
    };

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public String getType() {
        return "webview";
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDetachedToWebView() {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onEmbedViewVisibilityChanged(int i) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onRequestPermissionResult(int i, String[] strArr, int[] iArr) {
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public View getView(int i, int i2, String str, String str2, Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("get NXEmbedWebView ...width=");
        sb.append(i);
        sb.append(", height");
        sb.append(i2);
        sb.append(", viewId=");
        sb.append(str);
        sb.append(", type=");
        sb.append(str2);
        sb.append(",param=");
        sb.append(StringUtils.map2String(map));
        RVLogger.d("Griver:NXEmbedWebView", sb.toString());
        if (this.b == null) {
            if (this.mOuterApp == null) {
                GriverLogger.e("Griver:NXEmbedWebView", "NXEmbedWebView#getView, outPage destroyed, create embedWebView error.");
                return null;
            }
            this.c = map;
            this.f = map != null ? map.get("appId") : null;
            this.g = map != null && Boolean.parseBoolean(map.get("mini"));
            Bundle bundle = new Bundle();
            Bundle startParams = (this.mOuterPage == null || !(this.mOuterPage instanceof PageNode)) ? null : this.mOuterPage.getStartParams();
            String string = BundleUtils.getString(startParams, "appId");
            bundle.putString("MINI-PROGRAM-WEB-VIEW-TAG", string);
            bundle.putString(RVStartParams.KEY_FRAGMENT_TYPE, RVStartParams.FRAGMENT_TYPE_SUB_TAB);
            bundle.putString(LottieParams.KEY_ELEMENT_ID, map.get("id"));
            bundle.putString(RVConstants.EXTRA_PARENT_APP_ID, string);
            bundle.putString("parentPackageNick", BundleUtils.getString(startParams, "package_nick"));
            bundle.putString("parentVersion", BundleUtils.getString(startParams, "appVersion"));
            bundle.putString("enablePolyfillWorker", BundleUtils.getString(startParams, "enablePolyfillWorker"));
            bundle.putString("isRemoteDebug", BundleUtils.getString(startParams, "isRemoteDebug"));
            bundle.putString(AppInfoScene.PARAM_SCENE, BundleUtils.getString(startParams, AppInfoScene.PARAM_SCENE));
            bundle.putString(AppInfoScene.PARAM_SOURCE, BundleUtils.getString(startParams, AppInfoScene.PARAM_SOURCE));
            bundle.putBoolean("ignoreWebViewDomainCheck", BundleUtils.getBoolean(startParams, "ignoreWebViewDomainCheck", false));
            Bundle bundle2 = new Bundle();
            bundle2.putString(RVConstants.EXTRA_EMBED_VIEW_ID, this.mViewId);
            bundle2.putString("viewId", str);
            bundle2.putBoolean("isEmbedView", true);
            if (this.g) {
                bundle.putString(MINI_WEB_VIEW_TAG, string);
            }
            this.f6403a = new GriverPage(this.mOuterApp, "", bundle, bundle2, this.g ? EmbedType.MINI : EmbedType.FULL);
            if (this.mOuterPage != null && (this.mOuterPage instanceof PageNode)) {
                ((PageNode) this.mOuterPage).setEmbedPage(this.f6403a);
                this.f6403a.bindContext(new SinglePageContext(this.mOuterApp, this.mOuterPage));
            }
            this.f6403a.setHandler(new INebulaPage.H5PageHandler() { // from class: com.alibaba.griver.core.embedview.NXEmbedWebView.2
                @Override // com.alibaba.griver.base.api.INebulaPage.H5PageHandler
                public boolean shouldExit() {
                    return false;
                }
            });
            if (!this.g) {
                b();
            }
            this.f6403a.setExtra(WEB_VIEW_PAGE_TAG, this.mOuterPage);
            if (this.mOuterPage != null && (this.mOuterPage instanceof GriverPage)) {
                ((GriverPage) this.mOuterPage).setExtra(WEB_VIEW_PAGE_TAG, this.f6403a);
            }
            Render render = this.f6403a.getRender();
            if (render == null) {
                return null;
            }
            this.b = render.getView();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("new  embedWebView ");
            sb2.append(this.b);
            RVLogger.d("Griver:NXEmbedWebView", sb2.toString());
            if (this.g) {
                this.e.addView(this.b);
                this.b = this.e;
            }
            this.b.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.alibaba.griver.core.embedview.NXEmbedWebView.3
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alibaba.griver.core.embedview.NXEmbedWebView.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewGroup.LayoutParams layoutParams;
                            if (NXEmbedWebView.this.g) {
                                return;
                            }
                            try {
                                RVLogger.d("Griver:NXEmbedWebView", "onLayoutChange ,check fill status");
                                Page outerPage = NXEmbedWebView.this.getOuterPage();
                                if (outerPage != null && outerPage.getRender() != null && outerPage.getRender().getView() != null) {
                                    int width = outerPage.getRender().getView().getWidth();
                                    int height = outerPage.getRender().getView().getHeight();
                                    if ((NXEmbedWebView.this.b.getWidth() == width && NXEmbedWebView.this.b.getHeight() == height) || (layoutParams = NXEmbedWebView.this.b.getLayoutParams()) == null) {
                                        return;
                                    }
                                    if (layoutParams.width == width && layoutParams.height == height) {
                                        return;
                                    }
                                    layoutParams.width = width;
                                    layoutParams.height = height;
                                    NXEmbedWebView.this.b.setLayoutParams(layoutParams);
                                    return;
                                }
                                RVLogger.e("Griver:NXEmbedWebView", "onLayoutChange ,view is null ");
                            } catch (Exception e) {
                                RVLogger.e("Griver:NXEmbedWebView", "layout adjust error", e);
                            }
                        }
                    }, NXEmbedWebView.this.d);
                }
            });
        } else {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("reuse  embedWebView ");
            sb3.append(this.b);
            RVLogger.d("Griver:NXEmbedWebView", sb3.toString());
        }
        return this.b;
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedMessage(String str, JSONObject jSONObject, BridgeCallback bridgeCallback) {
        if (!POST_MESSAGE_ACTION_TYPE.equals(str)) {
            StringBuilder sb = new StringBuilder();
            sb.append("onReceivedMessage...need not process actionType=");
            sb.append(str);
            RVLogger.d("Griver:NXEmbedWebView", sb.toString());
        } else if (this.f6403a == null) {
            RVLogger.d("Griver:NXEmbedWebView", "onReceivedMessage...mEmbedPage is null");
        } else if (jSONObject == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceivedMessage...actionType=");
            sb2.append(str);
            RVLogger.d("Griver:NXEmbedWebView", sb2.toString());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("error", (Object) 2);
            jSONObject2.put("errorMessage", (Object) "data is null");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("data", (Object) jSONObject2);
            EngineUtils.sendToRender(this.f6403a.getRender(), "onToWebViewMessage", jSONObject3, null);
        } else {
            JSONObject jSONObject4 = new JSONObject();
            int i = JSONUtils.getInt(jSONObject, "callback");
            JSONObject jSONObject5 = JSONUtils.getJSONObject(jSONObject, "res", null);
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("callback", (Object) Integer.valueOf(i));
            jSONObject6.put("res", (Object) jSONObject5);
            jSONObject4.put("data", (Object) jSONObject6);
            EngineUtils.sendToRender(this.f6403a.getRender(), "onToWebViewMessage", jSONObject4, null);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onReceivedRender(JSONObject jSONObject, BridgeCallback bridgeCallback) {
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedRender ");
        sb.append(jSONObject);
        RVLogger.d("Griver:NXEmbedWebView", sb.toString());
        if (this.f6403a == null) {
            RVLogger.d("Griver:NXEmbedWebView", "onReceivedRender..webview mEmbedPage is null");
        } else if (jSONObject == null) {
            RVLogger.d("Griver:NXEmbedWebView", "onReceivedRender..params is null");
        } else {
            String string = JSONUtils.getString(jSONObject, "src");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onReceivedRender...url=");
            sb2.append(string);
            RVLogger.d("Griver:NXEmbedWebView", sb2.toString());
            if (TextUtils.equals(GriverBaseConstants.GRIVER_EMBEDDED_MOCK_URL, string) && this.f6403a.getApp() != null) {
                AppModel appModel = (AppModel) this.f6403a.getApp().getData(AppModel.class);
                if (this.f6403a.getApp().getStartParams() != null) {
                    String string2 = this.f6403a.getApp().getStartParams().getString("query");
                    if (!TextUtils.isEmpty(string2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(AppInfoUtils.getEmbeddedAppMainUrl(appModel));
                        sb3.append("?");
                        sb3.append(string2);
                        string = sb3.toString();
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("onReceivedRender real url=");
                        sb4.append(string);
                        RVLogger.d("Griver:NXEmbedWebView", sb4.toString());
                    }
                }
                string = AppInfoUtils.getEmbeddedAppMainUrl(appModel);
                StringBuilder sb42 = new StringBuilder();
                sb42.append("onReceivedRender real url=");
                sb42.append(string);
                RVLogger.d("Griver:NXEmbedWebView", sb42.toString());
            }
            if (this.g) {
                b(string);
            } else {
                a(string);
            }
        }
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void triggerPreSnapshot() {
        RVLogger.d("Griver:NXEmbedWebView", "triggerPreSnapshot...");
        LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(this.mOuterApp.getAppContext().getContext());
        Intent intent = new Intent();
        intent.setAction("embedview.snapshot.complete");
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewResume() {
        RVLogger.e("Griver:NXEmbedWebView", "onWebViewResume ");
        if (this.f6403a == null) {
            RVLogger.e("Griver:NXEmbedWebView", "onWebViewResume mEmbedPage is null");
        } else if (this.mOuterApp == null || !(this.mOuterApp instanceof GriverPage)) {
            RVLogger.e("Griver:NXEmbedWebView", "onWebViewResume mOuterApp is null or not instanceof NebulaApp");
        } else {
            JSONObject jSONObject = new JSONObject();
            GriverPage griverPage = (GriverPage) this.mOuterApp;
            if (griverPage.getData() != null) {
                String str = griverPage.getData().get(GriverParam.H5_SESSION_POP_PARAM);
                String str2 = griverPage.getData().get(GriverParam.H5_SESSION_RESUME_PARAM);
                if (!TextUtils.isEmpty(str)) {
                    JSONObject parseObject = JSONUtils.parseObject(str);
                    if (parseObject != null) {
                        jSONObject.put("data", (Object) parseObject);
                    } else {
                        JSONArray parseArray = JSONUtils.parseArray(str);
                        if (parseArray != null) {
                            jSONObject.put("data", (Object) parseArray);
                        } else {
                            jSONObject.put("data", (Object) str);
                        }
                    }
                }
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("resumeParams", (Object) JSONUtils.parseObject(str2));
                }
            }
            EngineUtils.sendToRender(this.f6403a.getRender(), "resume", jSONObject, null);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onWebViewPause() {
        RVLogger.d("Griver:NXEmbedWebView", "onWebViewPause");
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onAttachedToWebView() {
        RVLogger.d("Griver:NXEmbedWebView", "onAttachedToWebView");
        try {
            a(this.c);
        } catch (Throwable th) {
            RVLogger.e("Griver:NXEmbedWebView", "onAttachedToWebView ", th);
        }
    }

    @Override // com.alibaba.ariver.engine.api.embedview.IEmbedView
    public Bitmap getSnapshot() {
        return a(this.b);
    }

    @Override // com.alibaba.ariver.integration.embedview.BaseEmbedView, com.alibaba.ariver.engine.api.embedview.IEmbedView
    public void onDestroy() {
        super.onDestroy();
        GriverPage griverPage = this.f6403a;
        if (griverPage != null) {
            griverPage.setHandler(null);
            this.f6403a.exit(false);
        }
        this.b = null;
        this.f6403a = null;
    }

    private void a(String str) {
        if (!TextUtils.isEmpty(this.f) || TextUtils.isEmpty(str)) {
            return;
        }
        LoadParams loadParams = new LoadParams();
        loadParams.url = str;
        this.f6403a.getRender().load(loadParams);
    }

    private void b(String str) {
        if (TextUtils.isEmpty(this.f) && !TextUtils.isEmpty(str) && !str.equalsIgnoreCase(this.h)) {
            LoadParams loadParams = new LoadParams();
            loadParams.url = str;
            this.f6403a.getRender().load(loadParams);
            this.h = str;
        }
        try {
            this.b.setScrollContainer(false);
            this.b.setHorizontalScrollBarEnabled(false);
            this.b.setVerticalScrollBarEnabled(false);
        } catch (Throwable th) {
            RVLogger.e("Griver:NXEmbedWebView", "set mini web-view no scroll ", th);
        }
    }

    private void a(Map<String, String> map) {
        View view;
        boolean z;
        boolean z2;
        String[] split;
        if (map == null || !a()) {
            RVLogger.d("Griver:NXEmbedWebView", "don't check WebViewFill");
            return;
        }
        String str = map.get(ZebraData.ATTR_STYLE);
        StringBuilder sb = new StringBuilder();
        sb.append("style: ");
        sb.append(str);
        RVLogger.d("Griver:NXEmbedWebView", sb.toString());
        if (!TextUtils.isEmpty(str)) {
            String[] split2 = str.split(";");
            if (split2 != null && split2.length > 0) {
                z = false;
                z2 = false;
                for (String str2 : split2) {
                    if (z && z2) {
                        break;
                    }
                    String trim = str2.trim();
                    if (trim.startsWith("width:")) {
                        String[] split3 = trim.split(":");
                        if (split3 != null && split3.length == 2) {
                            z = TextUtils.equals(split3[1].trim(), "100%");
                        }
                    } else if (trim.startsWith("height:") && (split = trim.split(":")) != null && split.length == 2) {
                        z2 = TextUtils.equals(split[1].trim(), "100%");
                    }
                }
            } else {
                z = false;
                z2 = false;
            }
            boolean z3 = z && z2;
            this.i = z3;
            if (z3 && this.mOuterPage != null && (this.mOuterPage instanceof GriverPage)) {
                ((GriverPage) this.mOuterPage).setExtra(WEB_VIEW_FILL, "yes");
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("prepareCheckWebViewFill ");
        sb2.append(this.i);
        sb2.append(", mRealView != null? ");
        sb2.append(this.b != null);
        RVLogger.d("Griver:NXEmbedWebView", sb2.toString());
        if (!this.i || (view = this.b) == null) {
            return;
        }
        view.removeOnLayoutChangeListener(this.j);
        this.b.addOnLayoutChangeListener(this.j);
    }

    private boolean a() {
        return "1".equals(((RVConfigService) RVProxy.get(RVConfigService.class)).getConfig("ta_webview_fill_check", ""));
    }

    private Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        view.layout(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        Drawable background = view.getBackground();
        if (background != null) {
            background.draw(canvas);
        } else {
            canvas.drawColor(-1);
        }
        view.draw(canvas);
        return createBitmap;
    }

    private void b() {
        if (this.mOuterPage == null) {
            GriverLogger.e("Griver:NXEmbedWebView", "NXEmbedWebView#prepareContainerView, mOutPage is null");
        } else {
            a(this.mOuterPage);
        }
    }

    private PageContainer a(Page page) {
        return page.getPageContext().getPageContainer();
    }

    public Page getEmbedPage() {
        return this.f6403a;
    }
}
