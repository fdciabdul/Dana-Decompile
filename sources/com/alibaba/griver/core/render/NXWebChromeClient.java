package com.alibaba.griver.core.render;

import android.app.Activity;
import android.app.Dialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.VideoView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.point.dialog.CreateDialogParam;
import com.alibaba.ariver.app.api.point.dialog.DialogPoint;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.alibaba.ariver.engine.api.bridge.model.RenderCallContext;
import com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback;
import com.alibaba.ariver.engine.api.bridge.model.SendToRenderCallback;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.kernel.api.extension.ExtensionPoint;
import com.alibaba.ariver.kernel.api.node.Node;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVEnvironmentService;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.JSONUtils;
import com.alibaba.ariver.kernel.common.utils.ProcessUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.webview.GriverFullScreenEvent;
import com.alibaba.griver.api.h5.file.GriverChooseFileExtension;
import com.alibaba.griver.api.stauts.PageStatus;
import com.alibaba.griver.api.ui.dialog.GriverDialogExtension;
import com.alibaba.griver.api.webview.GriverGeoLocationExtension;
import com.alibaba.griver.base.api.APJsPromptResult;
import com.alibaba.griver.base.api.APJsResult;
import com.alibaba.griver.base.api.APWebChromeClient;
import com.alibaba.griver.base.api.APWebView;
import com.alibaba.griver.base.api.PageProcessPoint;
import com.alibaba.griver.base.api.ReceivedTitlePoint;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppTypeUtils;
import com.alibaba.griver.base.t2.T2PageInfo;
import com.alibaba.griver.core.GriverParam;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.ui.activity.GriverFileChooserActivity;
import com.alibaba.griver.core.ui.view.H5PromptDialog;
import com.alibaba.griver.core.utils.GriverWebRenderUtils;
import com.alibaba.griver.file.jsapi.ChooseFileBridgeExtension;
import com.iap.ac.android.container.js.ACJSBridge;
import id.dana.mybills.ui.constant.MyBillsPurposeAction;

/* loaded from: classes3.dex */
public class NXWebChromeClient implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnPreparedListener, APWebChromeClient {
    public static final String FILE_CHOOSER_RESULT = "FILE_CHOOSER_RESULT";

    /* renamed from: a */
    private static JSONArray f6457a;
    public String TAG;
    private Page b;
    private BroadcastReceiver c;
    private boolean d;
    private boolean e;
    private boolean f;
    private Node g;
    private Page h;
    private Dialog i;
    private APJsResult j;
    private Dialog k;
    private APJsResult l;
    private H5PromptDialog m;
    public APWebChromeClient.CustomViewCallback mCustomViewCallback;
    private APJsPromptResult n;

    /* renamed from: o */
    private GriverWebRenderImpl f6458o;
    private boolean p;
    private H5ScriptLoader q;
    private boolean r;
    private View s;
    private ViewGroup t;
    private FrameLayout u;
    private APWebChromeClient.CustomViewCallback v;

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public View getVideoLoadingProgressView() {
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void getVisitedHistory(ValueCallback<String[]> valueCallback) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onCloseWindow(APWebView aPWebView) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onCreateWindow(APWebView aPWebView, boolean z, boolean z2, Message message) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onRequestFocus(APWebView aPWebView) {
    }

    public NXWebChromeClient(Page page, GriverWebRenderImpl griverWebRenderImpl, H5ScriptLoader h5ScriptLoader, boolean z) {
        this.TAG = "NXWebChromeClient";
        this.d = false;
        this.e = true;
        this.f = false;
        this.p = z;
        this.g = page;
        this.h = page;
        this.f6458o = griverWebRenderImpl;
        this.q = h5ScriptLoader;
        this.s = page.getPageContext().getActivity().findViewById(R.id.fragment_container);
        this.t = (ViewGroup) page.getPageContext().getActivity().findViewById(R.id.videoLayout);
        StringBuilder sb = new StringBuilder();
        sb.append(this.TAG);
        sb.append(hashCode());
        this.TAG = sb.toString();
        if (page != null && BundleUtils.getBoolean(page.getStartParams(), GriverParam.LONG_ISPRERENDER, false)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.TAG);
            sb2.append("_preRender");
            this.TAG = sb2.toString();
        }
        this.b = page;
        if ("NO".equals(GriverConfig.getConfigWithProcessCache("h5_asyncConsoleMessage", ""))) {
            this.d = false;
        }
        if ("NO".equalsIgnoreCase(GriverConfig.getConfigWithProcessCache("h5_handleUncaughtJsError", ""))) {
            this.e = false;
        }
        if ("1".equalsIgnoreCase(GriverConfig.getConfigWithProcessCache("ta_interceptInternalAPI", ""))) {
            this.f = true;
        }
    }

    public static Activity getActivityFromContext(Context context) {
        int i = 5;
        while (context != null) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            if (context instanceof ContextWrapper) {
                context = ((ContextWrapper) context).getBaseContext();
            }
            if (i <= 0) {
                break;
            }
            i--;
        }
        return null;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage != null && this.g != null) {
            String message = consoleMessage.message();
            int lineNumber = consoleMessage.lineNumber();
            String str = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onConsoleMessage : ");
            sb.append(message);
            sb.append(", ");
            sb.append(lineNumber);
            GriverLogger.d(str, sb.toString());
            return a(message);
        }
        String str2 = this.TAG;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onConsoleMessage input illegal: ");
        sb2.append(consoleMessage);
        sb2.append(", ");
        sb2.append(this.g);
        GriverLogger.d(str2, sb2.toString());
        return false;
    }

    private boolean a(String str) {
        JSONObject jSONObject;
        T2PageInfo t2PageInfo;
        SendToRenderCallback takeRenderCallback;
        if (!TextUtils.isEmpty(str) && this.h != null) {
            GriverLogger.d(this.TAG, str);
            StringBuilder sb = new StringBuilder();
            sb.append(GriverWebRenderUtils.getBridgeToken(this.h));
            sb.append(ACJSBridge.JSAPI_PREFIX);
            String obj = sb.toString();
            if (str.startsWith(obj)) {
                JSONObject parseObject = JSONUtils.parseObject(str.replaceFirst(obj, ""));
                if (parseObject != null && !parseObject.isEmpty()) {
                    final String string = JSONUtils.getString(parseObject, "clientId");
                    final String string2 = JSONUtils.getString(parseObject, "func");
                    JSONObject jSONObject2 = JSONUtils.getJSONObject(parseObject, "param", null);
                    if (TextUtils.isEmpty(string)) {
                        GriverLogger.d(this.TAG, "clientId IS empty");
                        return false;
                    }
                    String str2 = this.TAG;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("sendToNative == ");
                    sb2.append(string2);
                    GriverLogger.d(str2, sb2.toString());
                    NativeCallContext build = new NativeCallContext.Builder().name(string2).params(jSONObject2).node(this.h).id(string).render(this.h.getRender()).build();
                    if (this.h != null && jSONObject2 != null && jSONObject2.containsKey("eventExtraData") && (jSONObject = jSONObject2.getJSONObject("eventExtraData")) != null && jSONObject.containsKey("enableJsT2") && (t2PageInfo = (T2PageInfo) this.h.getData(T2PageInfo.class, false)) != null && t2PageInfo.isPageT2Switch() && (takeRenderCallback = t2PageInfo.takeRenderCallback(build.getId())) != null) {
                        takeRenderCallback.onCallBack(build.getParams());
                        return true;
                    }
                    Page page = this.h;
                    if (page != null && !page.isExited()) {
                        this.f6458o.getEngine().getBridge().sendToNative(build, new SendToNativeCallback() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.1
                            {
                                NXWebChromeClient.this = this;
                            }

                            @Override // com.alibaba.ariver.engine.api.bridge.model.SendToNativeCallback
                            public void onCallback(JSONObject jSONObject3, boolean z) {
                                NXWebChromeClient.this.f6458o.getRenderBridge().sendToRender(RenderCallContext.newBuilder(NXWebChromeClient.this.h.getRender()).action(string2).eventId(string).type("callback").keep(z).param(jSONObject3).build(), null);
                            }
                        });
                        return true;
                    }
                    GriverLogger.w(this.TAG, "handleMsgFromJs inner error, page status illegal.");
                } else {
                    GriverLogger.d(this.TAG, "msgText json object is empty");
                }
            } else {
                if (!str.startsWith("invokeJS msgType") && !str.contains("load AlipayJSBridge")) {
                    String str3 = this.TAG;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("AppId/");
                    sb3.append(this.h.getApp().getAppId());
                    sb3.append(",");
                    sb3.append(str);
                    GriverLogger.d(str3, sb3.toString());
                }
                int indexOf = str.indexOf(ACJSBridge.JSAPI_PREFIX);
                if (indexOf >= 0 && str.length() > indexOf) {
                    String substring = str.substring(0, indexOf);
                    String str4 = this.TAG;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("handleMsgFromJS token invalid! prefixStr = ");
                    sb4.append(substring);
                    GriverLogger.d(str4, sb4.toString());
                }
            }
        } else {
            String str5 = this.TAG;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleMsgFromJs error, message: ");
            sb5.append(str);
            GriverLogger.w(str5, sb5.toString());
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onProgressChanged(APWebView aPWebView, int i) {
        if (this.g == null) {
            return;
        }
        ((PageProcessPoint) ExtensionPoint.as(PageProcessPoint.class).node(this.g).create()).onProgressChanged(aPWebView.getUrl(), i);
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onReceivedTitle(APWebView aPWebView, String str) {
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onReceivedTitle [title] ");
        sb.append(str);
        sb.append(" ");
        sb.append(aPWebView.getUrl());
        GriverLogger.d(str2, sb.toString());
        ((ReceivedTitlePoint) ExtensionPoint.as(ReceivedTitlePoint.class).node(this.g).create()).onReceivedTitle(aPWebView.getUrl(), str);
        this.f6458o.updatePageStatus(PageStatus.FINISHED);
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onReceivedIcon(APWebView aPWebView, Bitmap bitmap) {
        if (GriverEnv.isDebuggable()) {
            GriverLogger.d(this.TAG, "onReceivedIcon");
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onReceivedTouchIconUrl(APWebView aPWebView, String str, boolean z) {
        if (GriverEnv.isDebuggable()) {
            String str2 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onReceivedTouchIconUrl. [url] ");
            sb.append(str);
            sb.append(" [precomposed] ");
            sb.append(z);
            GriverLogger.d(str2, sb.toString());
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsBeforeUnload(APWebView aPWebView, String str, String str2, APJsResult aPJsResult) {
        if (GriverEnv.isDebuggable()) {
            String str3 = this.TAG;
            StringBuilder sb = new StringBuilder();
            sb.append("onJsBeforeUnload [url] ");
            sb.append(str);
            sb.append(" [message] ");
            sb.append(str2);
            GriverLogger.d(str3, sb.toString());
            return false;
        }
        return false;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onGeolocationPermissionsShowPrompt ");
        sb.append(str);
        GriverLogger.d(str2, sb.toString());
        ((GriverGeoLocationExtension) RVProxy.get(GriverGeoLocationExtension.class)).onGeolocationPermissionsShowPrompt(this.h, str, callback);
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        ((GriverGeoLocationExtension) RVProxy.get(GriverGeoLocationExtension.class)).onGeolocationPermissionsHidePrompt(this.h);
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void openFileChooser(final ValueCallback valueCallback, final boolean z) {
        Page page = this.b;
        if (page == null || page.getRender().getView() == null) {
            return;
        }
        try {
            final Activity activityFromContext = getActivityFromContext(this.b.getRender().getView().getContext());
            if (activityFromContext == null) {
                return;
            }
            final LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getApplicationContext());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(FILE_CHOOSER_RESULT);
            BroadcastReceiver broadcastReceiver = this.c;
            if (broadcastReceiver != null) {
                localBroadcastManager.unregisterReceiver(broadcastReceiver);
                this.c = null;
            }
            BroadcastReceiver broadcastReceiver2 = new BroadcastReceiver() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.2
                {
                    NXWebChromeClient.this = this;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r2v4, types: [android.net.Uri[]] */
                /* JADX WARN: Type inference failed for: r4v5, types: [android.net.Uri[]] */
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context, Intent intent) {
                    LocalBroadcastManager localBroadcastManager2;
                    if (intent == null || intent.getAction() == null || intent.getExtras() == null || (localBroadcastManager2 = localBroadcastManager) == null) {
                        return;
                    }
                    localBroadcastManager2.unregisterReceiver(this);
                    Cursor cursor = null;
                    NXWebChromeClient.this.c = null;
                    String action = intent.getAction();
                    String str = NXWebChromeClient.this.TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("onReceive action ");
                    sb.append(action);
                    GriverLogger.d(str, sb.toString());
                    if (NXWebChromeClient.FILE_CHOOSER_RESULT.equals(action)) {
                        try {
                            Uri uri = (Uri) intent.getExtras().get(ChooseFileBridgeExtension.CHOOSE_FILE_RESULT_DATA_KEY);
                            if (uri == null) {
                                uri = Uri.parse("");
                            }
                            Activity activity = activityFromContext;
                            if (activity != null && !activity.isFinishing() && uri != null) {
                                cursor = activityFromContext.getContentResolver().query(uri, null, null, null, null);
                            }
                            String str2 = NXWebChromeClient.this.TAG;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("onReceive result ");
                            sb2.append(uri);
                            GriverLogger.d(str2, sb2.toString());
                            ValueCallback valueCallback2 = valueCallback;
                            if (valueCallback2 != null) {
                                if (z) {
                                    uri = new Uri[]{uri};
                                }
                                valueCallback2.onReceiveValue(uri);
                            }
                            if (cursor == null) {
                            }
                        } catch (Throwable th) {
                            try {
                                GriverLogger.e(NXWebChromeClient.this.TAG, "exception detail", th);
                                Uri parse = Uri.parse("");
                                ValueCallback valueCallback3 = valueCallback;
                                if (valueCallback3 != null) {
                                    if (z) {
                                        parse = new Uri[]{parse};
                                    }
                                    valueCallback3.onReceiveValue(parse);
                                }
                            } finally {
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                    }
                }
            };
            this.c = broadcastReceiver2;
            localBroadcastManager.registerReceiver(broadcastReceiver2, intentFilter);
            Intent intent = new Intent(activityFromContext, GriverFileChooserActivity.class);
            if (ProcessUtils.isTinyProcess() && !"yes".equalsIgnoreCase(GriverConfig.getConfig("h5_notSupportTinyChooseFile", ""))) {
                String string = BundleUtils.getString(this.b.getStartParams(), "appId");
                if (TextUtils.isEmpty(string)) {
                    string = BundleUtils.getString(this.b.getStartParams(), "MINI-PROGRAM-WEB-VIEW-TAG");
                }
                if (!TextUtils.isEmpty(string)) {
                    intent.putExtra("appId", string);
                }
            }
            activityFromContext.startActivity(intent);
        } catch (ActivityNotFoundException e) {
            GriverLogger.e(this.TAG, "exception detail", e);
        } catch (ClassCastException e2) {
            GriverLogger.e(this.TAG, "exception detail", e2);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        if (a() || AppTypeUtils.isEmbedPage(this.b)) {
            ((GriverChooseFileExtension) RVProxy.get(GriverChooseFileExtension.class)).openFileChooser(this.h, valueCallback, str, str2);
        }
    }

    private boolean a() {
        Page page = this.b;
        return page != null && BundleUtils.getBoolean(page.getStartParams(), RVParams.isH5App, false);
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onShowFileChooser(ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        if (a() || AppTypeUtils.isEmbedPage(this.b)) {
            return ((GriverChooseFileExtension) RVProxy.get(GriverChooseFileExtension.class)).onShowFileChooser(this.h, valueCallback, fileChooserParams);
        }
        return true;
    }

    public boolean isVideoFullscreen() {
        return this.r;
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onShowCustomView(View view, APWebChromeClient.CustomViewCallback customViewCallback) {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onShowCustomView [SDK Version] ");
        sb.append(Build.VERSION.SDK_INT);
        GriverLogger.d(str, sb.toString());
        if (this.b.getPageContext().getActivity().getRequestedOrientation() != 0) {
            this.b.getPageContext().getActivity().setRequestedOrientation(0);
        }
        this.b.getPageContext().getActivity().getWindow().addFlags(1024);
        this.mCustomViewCallback = customViewCallback;
        if (view instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) view;
            View focusedChild = frameLayout.getFocusedChild();
            this.r = true;
            this.u = frameLayout;
            this.v = customViewCallback;
            this.s.setVisibility(8);
            this.t.addView(this.u, new ViewGroup.LayoutParams(-1, -1));
            this.t.setVisibility(0);
            if (focusedChild instanceof VideoView) {
                VideoView videoView = (VideoView) focusedChild;
                videoView.setOnPreparedListener(this);
                videoView.setOnCompletionListener(this);
                videoView.setOnErrorListener(this);
            }
            ((GriverFullScreenEvent) ExtensionPoint.as(GriverFullScreenEvent.class).node(this.b).create()).toggledFullscreen(true);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public void onHideCustomView() {
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onShowCustomView [SDK Version] ");
        sb.append(Build.VERSION.SDK_INT);
        GriverLogger.d(str, sb.toString());
        if (this.b.getPageContext().getActivity().getRequestedOrientation() != 1) {
            this.b.getPageContext().getActivity().setRequestedOrientation(1);
        }
        this.b.getPageContext().getActivity().getWindow().clearFlags(1024);
        this.mCustomViewCallback = null;
        if (this.r) {
            this.t.setVisibility(8);
            this.t.removeView(this.u);
            this.s.setVisibility(0);
            APWebChromeClient.CustomViewCallback customViewCallback = this.v;
            if (customViewCallback != null && !customViewCallback.getClass().getName().contains(".chromium.")) {
                this.v.onCustomViewHidden();
            }
            this.r = false;
            this.u = null;
            this.v = null;
            ((GriverFullScreenEvent) ExtensionPoint.as(GriverFullScreenEvent.class).node(this.b).create()).toggledFullscreen(false);
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsAlert(APWebView aPWebView, String str, String str2, final APJsResult aPJsResult) {
        String str3 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onJsAlert ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        GriverLogger.d(str3, sb.toString());
        Page page = this.b;
        if (page == null) {
            GriverLogger.d(this.TAG, "h5Page == null");
            aPJsResult.cancel();
            return true;
        }
        Activity activity = page.getPageContext().getActivity();
        if (activity == null || activity.isFinishing()) {
            GriverLogger.d(this.TAG, " isFinishing");
            aPJsResult.cancel();
            return false;
        } else if (!this.p) {
            GriverLogger.d(this.TAG, "not H5Activity");
            aPJsResult.cancel();
            return false;
        } else {
            CreateDialogParam createDialogParam = new CreateDialogParam("", str2, GriverEnv.getResources() != null ? GriverEnv.getResources().getString(R.string.griver_base_confirm) : "Confirm", null, "");
            createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.3
                {
                    NXWebChromeClient.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    aPJsResult.confirm();
                    NXWebChromeClient.this.j = null;
                }
            };
            createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.4
                {
                    NXWebChromeClient.this = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    aPJsResult.cancel();
                    NXWebChromeClient.this.j = null;
                }
            };
            b();
            Dialog createDialog = ((DialogPoint) ExtensionPoint.as(DialogPoint.class).create()).createDialog(this.b.getPageContext().getActivity(), createDialogParam);
            this.i = createDialog;
            if (createDialog != null && !activity.isFinishing()) {
                this.i.show();
                ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).applyShow(this.i, createDialogParam);
                this.j = aPJsResult;
                return true;
            }
            aPJsResult.cancel();
            return false;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsConfirm(APWebView aPWebView, String str, String str2, final APJsResult aPJsResult) {
        String str3;
        String str4;
        String str5 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onJsConfirm ");
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        GriverLogger.d(str5, sb.toString());
        Page page = this.b;
        if (page == null) {
            GriverLogger.d(this.TAG, "h5Page == null");
            aPJsResult.cancel();
            return true;
        }
        Activity activity = page.getPageContext().getActivity();
        if (activity == null || activity.isFinishing()) {
            GriverLogger.d(this.TAG, "  isFinishing");
            aPJsResult.cancel();
            return false;
        } else if (!this.p) {
            GriverLogger.d(this.TAG, "not  H5activity");
            aPJsResult.cancel();
            return false;
        } else {
            if (GriverEnv.getResources() != null) {
                str3 = GriverEnv.getResources().getString(R.string.griver_base_confirm);
                str4 = GriverEnv.getResources().getString(R.string.griver_base_cancel);
            } else {
                str3 = "Confirm";
                str4 = MyBillsPurposeAction.CANCEL;
            }
            CreateDialogParam createDialogParam = new CreateDialogParam("", str2, str3, str4, "");
            createDialogParam.positiveListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.5
                {
                    NXWebChromeClient.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    aPJsResult.confirm();
                    NXWebChromeClient.this.l = null;
                }
            };
            createDialogParam.negativeListener = new DialogInterface.OnClickListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.6
                {
                    NXWebChromeClient.this = this;
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    aPJsResult.cancel();
                    NXWebChromeClient.this.l = null;
                }
            };
            createDialogParam.cancelListener = new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.7
                {
                    NXWebChromeClient.this = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (dialogInterface != null) {
                        dialogInterface.dismiss();
                    }
                    aPJsResult.cancel();
                    NXWebChromeClient.this.l = null;
                }
            };
            c();
            Dialog createDialog = ((DialogPoint) ExtensionPoint.as(DialogPoint.class).create()).createDialog(this.b.getPageContext().getActivity(), createDialogParam);
            this.k = createDialog;
            if (createDialog != null && !activity.isFinishing()) {
                this.k.show();
                ((GriverDialogExtension) RVProxy.get(GriverDialogExtension.class)).applyShow(this.k, createDialogParam);
                this.l = aPJsResult;
                return true;
            }
            aPJsResult.cancel();
            return false;
        }
    }

    @Override // com.alibaba.griver.base.api.APWebChromeClient
    public boolean onJsPrompt(APWebView aPWebView, String str, String str2, String str3, final APJsPromptResult aPJsPromptResult) {
        String str4 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onJsPrompt: url: ");
        sb.append(str);
        sb.append(" message: ");
        sb.append(str2);
        sb.append(" defaultValue: ");
        sb.append(str3);
        GriverLogger.d(str4, sb.toString());
        Page page = this.b;
        if (page == null) {
            aPJsPromptResult.cancel();
            return true;
        }
        Activity activity = page.getPageContext().getActivity();
        if (activity == null || activity.isFinishing()) {
            aPJsPromptResult.cancel();
            return false;
        } else if (this.p) {
            d();
            H5PromptDialog h5PromptDialog = new H5PromptDialog(activity, null, str2, ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null).getString(R.string.griver_core_default_confirm), ((RVEnvironmentService) RVProxy.get(RVEnvironmentService.class)).getResources(null).getString(R.string.griver_core_default_cancel));
            this.m = h5PromptDialog;
            h5PromptDialog.getInputContent().setText(str3);
            this.m.setPositiveListener(new H5PromptDialog.OnClickPositiveListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.8
                {
                    NXWebChromeClient.this = this;
                }

                @Override // com.alibaba.griver.core.ui.view.H5PromptDialog.OnClickPositiveListener
                public void onClick(String str5) {
                    APJsPromptResult aPJsPromptResult2 = aPJsPromptResult;
                    if (aPJsPromptResult2 != null) {
                        aPJsPromptResult2.confirm(NXWebChromeClient.this.m.getInputContent().getText().toString());
                    }
                    NXWebChromeClient.this.n = null;
                }
            });
            this.m.setNegativeListener(new H5PromptDialog.OnClickNegativeListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.9
                {
                    NXWebChromeClient.this = this;
                }

                @Override // com.alibaba.griver.core.ui.view.H5PromptDialog.OnClickNegativeListener
                public void onClick() {
                    APJsPromptResult aPJsPromptResult2 = aPJsPromptResult;
                    if (aPJsPromptResult2 != null) {
                        aPJsPromptResult2.cancel();
                    }
                    NXWebChromeClient.this.n = null;
                }
            });
            this.m.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.core.render.NXWebChromeClient.10
                {
                    NXWebChromeClient.this = this;
                }

                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    APJsPromptResult aPJsPromptResult2 = aPJsPromptResult;
                    if (aPJsPromptResult2 != null) {
                        aPJsPromptResult2.cancel();
                    }
                    NXWebChromeClient.this.n = null;
                }
            });
            if (this.m != null && !activity.isFinishing()) {
                this.m.show();
                this.n = aPJsPromptResult;
                return true;
            }
            aPJsPromptResult.cancel();
            return false;
        } else {
            return false;
        }
    }

    public void onRelease() {
        this.b = null;
        b();
        c();
        d();
    }

    private void b() {
        Dialog dialog = this.i;
        if (dialog != null) {
            dialog.dismiss();
            this.i = null;
        }
        APJsResult aPJsResult = this.j;
        if (aPJsResult != null) {
            aPJsResult.cancel();
            this.j = null;
        }
    }

    private void c() {
        Dialog dialog = this.k;
        if (dialog != null) {
            dialog.dismiss();
            this.k = null;
        }
        APJsResult aPJsResult = this.l;
        if (aPJsResult != null) {
            aPJsResult.cancel();
            this.l = null;
        }
    }

    private void d() {
        H5PromptDialog h5PromptDialog = this.m;
        if (h5PromptDialog != null) {
            h5PromptDialog.dismiss();
            this.m = null;
        }
        APJsPromptResult aPJsPromptResult = this.n;
        if (aPJsPromptResult != null) {
            aPJsPromptResult.cancel();
            this.n = null;
        }
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        onHideCustomView();
    }

    public Page getPage() {
        return this.h;
    }
}
