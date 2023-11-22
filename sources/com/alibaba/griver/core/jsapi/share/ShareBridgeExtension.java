package com.alibaba.griver.core.jsapi.share;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.ui.titlebar.TitleBar;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.FileUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.api.models.AppInfoScene;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.exthub.BuildConfig;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.api.resource.appinfo.AppInfoConstants;
import com.alibaba.griver.api.ui.share.GriverShareExtension;
import com.alibaba.griver.api.ui.share.GriverShareMenu4PageExtension;
import com.alibaba.griver.api.ui.share.GriverShareSchemeExtension;
import com.alibaba.griver.api.ui.share.GriverShareURLCreatorExtension;
import com.alibaba.griver.api.ui.share.ShareParam;
import com.alibaba.griver.api.ui.share.ShareResultListener;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.core.GriverParams;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

/* loaded from: classes2.dex */
public class ShareBridgeExtension extends SimpleBridgeExtension {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String JS_GET_OG_PARAMS_FROM_DOM = "javascript:(function () {var ogInfos = {}; for (let meta of document.head.getElementsByTagName('meta')) { if (meta) {let property = meta.getAttribute('property'); if (['og:title', 'og:description', 'og:image'].includes(property)) { ogInfos[property] = meta.getAttribute('content'); } } } return ogInfos; })()";
    private static final String KEY_OG_DESC = "og:description";
    private static final String KEY_OG_IMAGE_URL = "og:image";
    private static final String KEY_OG_TITLE = "og:title";
    private static int MyBillsEntityDataFactory = 1;
    private static final String PARAM_ELAPSED_TIME = "elapsedTime";
    private static final String TAG = "ShareBridgeExtension";
    private static long getAuthRequestContext = -4811978442658822738L;

    static /* synthetic */ void access$000(ShareBridgeExtension shareBridgeExtension, Page page, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, BridgeCallback bridgeCallback) {
        int i = MyBillsEntityDataFactory + 107;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 != 0 ? '9' : '\f';
        Object obj = null;
        shareBridgeExtension.processShare(page, str, str2, str3, str4, str5, str6, str7, str8, bridgeCallback);
        if (c == '9') {
            obj.hashCode();
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 67;
            MyBillsEntityDataFactory = i2 % 128;
            if ((i2 % 2 == 0 ? 'H' : Typography.quote) != 'H') {
                return;
            }
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$100(ShareBridgeExtension shareBridgeExtension, ShareParam shareParam, BridgeCallback bridgeCallback) {
        try {
            int i = MyBillsEntityDataFactory + 1;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                shareBridgeExtension.startShare(shareParam, bridgeCallback);
                int i3 = BuiltInFictitiousFunctionClassFactory + 13;
                MyBillsEntityDataFactory = i3 % 128;
                if ((i3 % 2 == 0 ? '3' : 'F') != 'F') {
                    int i4 = 10 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$200(ShareBridgeExtension shareBridgeExtension, BridgeCallback bridgeCallback, String str, boolean z) {
        int i = MyBillsEntityDataFactory + 99;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 != 0 ? 'C' : (char) 27;
        shareBridgeExtension.sendShareResult(bridgeCallback, str, z);
        if (c != 27) {
            int i2 = 71 / 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x00fa, code lost:
    
        if ((android.text.TextUtils.isEmpty(r23) ? 25 : '0') != 25) goto L171;
     */
    @com.alibaba.ariver.kernel.api.annotation.ThreadType(com.alibaba.ariver.kernel.common.service.executor.ExecutorType.UI)
    @com.alibaba.ariver.kernel.api.annotation.ActionFilter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void shareTinyAppMsg(@com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode(com.alibaba.ariver.app.api.Page.class) final com.alibaba.ariver.app.api.Page r17, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"page"}) final java.lang.String r18, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"path"}) final java.lang.String r19, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"title"}) final java.lang.String r20, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"desc"}) final java.lang.String r21, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"content"}) final java.lang.String r22, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"imageUrl"}) final java.lang.String r23, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"bgImgUrl"}) final java.lang.String r24, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam({"from"}) final java.lang.String r25, @com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback final com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r26) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.shareTinyAppMsg(com.alibaba.ariver.app.api.Page, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback):void");
    }

    private void processShare(Page page, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, final BridgeCallback bridgeCallback) {
        String str9;
        String str10;
        String str11;
        final ShareParam shareParam;
        String str12;
        String str13;
        String urlForParams;
        int i = BuiltInFictitiousFunctionClassFactory + 51;
        MyBillsEntityDataFactory = i % 128;
        int i2 = i % 2;
        if (page != null) {
            if (page.getPageContext() != null) {
                if ((page.getApp() != null ? Typography.greater : '*') == '>') {
                    AppModel appModel = (AppModel) page.getApp().getData(AppModel.class);
                    if (!(appModel != null)) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        return;
                    }
                    Activity activity = page.getPageContext().getActivity();
                    if (activity == null) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                        return;
                    }
                    Bundle startParams = page.getApp().getStartParams();
                    if (TextUtils.isEmpty(str3)) {
                        int i3 = BuiltInFictitiousFunctionClassFactory + 11;
                        MyBillsEntityDataFactory = i3 % 128;
                        if ((i3 % 2 == 0 ? 'T' : 'W') != 'T') {
                            str9 = appModel.getAppInfoModel().getName();
                        } else {
                            str9 = appModel.getAppInfoModel().getName();
                            Object obj = null;
                            obj.hashCode();
                        }
                    } else {
                        str9 = str3;
                    }
                    if (TextUtils.isEmpty(str4)) {
                        TitleBar titleBar = getTitleBar(page);
                        if (titleBar != null) {
                            int i4 = BuiltInFictitiousFunctionClassFactory + 7;
                            MyBillsEntityDataFactory = i4 % 128;
                            int i5 = i4 % 2;
                            str10 = titleBar.getTitle();
                        } else {
                            str10 = str4;
                        }
                        try {
                            if (TextUtils.isEmpty(str10)) {
                                str10 = appModel.getAppInfoModel().getDesc();
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        str10 = str4;
                    }
                    if (TextUtils.isEmpty(str6)) {
                        int i6 = MyBillsEntityDataFactory + 81;
                        BuiltInFictitiousFunctionClassFactory = i6 % 128;
                        int i7 = i6 % 2;
                        str11 = appModel.getAppInfoModel().getLogo();
                    } else {
                        str11 = str6;
                    }
                    String appId = appModel.getAppId();
                    ShareParam shareParam2 = new ShareParam();
                    String str14 = TextUtils.isEmpty(str) ? str2 : str;
                    String str15 = str11;
                    String str16 = str10;
                    if (RVProxy.get(GriverShareURLCreatorExtension.class, true) == null) {
                        String encodeURIComponent = encodeURIComponent(str14);
                        StringBuilder sb = new StringBuilder();
                        sb.append(((GriverShareSchemeExtension) RVProxy.get(GriverShareSchemeExtension.class)).getScheme());
                        sb.append("?");
                        sb.append("_ariver_appid");
                        sb.append("=");
                        sb.append(appId);
                        String obj2 = sb.toString();
                        if (!TextUtils.isEmpty(encodeURIComponent)) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(obj2);
                            sb2.append(ContainerUtils.FIELD_DELIMITER);
                            sb2.append("_ariver_path");
                            sb2.append("=");
                            sb2.append(encodeURIComponent);
                            obj2 = sb2.toString();
                        }
                        if (AppInfoScene.isDevSource(startParams)) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(obj2);
                            sb3.append(ContainerUtils.FIELD_DELIMITER);
                            sb3.append("_ariver_source");
                            sb3.append("=debug&");
                            sb3.append("_ariver_scene");
                            sb3.append("=");
                            sb3.append(startParams.getString(AppInfoScene.PARAM_SCENE));
                            sb3.append(ContainerUtils.FIELD_DELIMITER);
                            sb3.append("_ariver_token");
                            sb3.append("=");
                            sb3.append(startParams.getString(AppInfoConstants.ARIVER_TOKEN));
                            obj2 = sb3.toString();
                        }
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(obj2);
                        sb4.append(ContainerUtils.FIELD_DELIMITER);
                        sb4.append("_ariver_version");
                        sb4.append("=");
                        sb4.append(appModel.getAppVersion());
                        String obj3 = sb4.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(obj3);
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append("title");
                        sb5.append("=");
                        sb5.append(str9);
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append("desc");
                        sb5.append("=");
                        sb5.append(str16);
                        sb5.append(ContainerUtils.FIELD_DELIMITER);
                        sb5.append(GriverParams.ShareParams.IMAGE_URL);
                        sb5.append("=");
                        sb5.append(encodeURIComponent(str15));
                        urlForParams = sb5.toString();
                        shareParam = shareParam2;
                        str12 = str16;
                        str13 = str15;
                    } else {
                        shareParam = shareParam2;
                        shareParam.params = new HashMap();
                        shareParam.params.put("_ariver_appid", appId);
                        if ((!TextUtils.isEmpty(str14) ? '*' : JSONLexer.EOI) != 26) {
                            shareParam.params.put("_ariver_path", str14);
                        }
                        if (AppInfoScene.isDevSource(startParams)) {
                            shareParam.params.put("_ariver_source", BuildConfig.BUILD_TYPE);
                            shareParam.params.put("_ariver_scene", startParams.getString(AppInfoScene.PARAM_SCENE));
                            shareParam.params.put("_ariver_token", startParams.getString(AppInfoConstants.ARIVER_TOKEN));
                        }
                        shareParam.params.put("_ariver_version", appModel.getAppVersion());
                        shareParam.params.put("title", str9);
                        str12 = str16;
                        shareParam.params.put("desc", str12);
                        str13 = str15;
                        shareParam.params.put(GriverParams.ShareParams.IMAGE_URL, str13);
                        urlForParams = ((GriverShareURLCreatorExtension) RVProxy.get(GriverShareURLCreatorExtension.class)).urlForParams(shareParam.params);
                    }
                    shareParam.page = page;
                    shareParam.activity = activity;
                    shareParam.title = str9;
                    shareParam.desc = str12;
                    shareParam.content = str5;
                    shareParam.imageUrl = str13;
                    shareParam.url = urlForParams;
                    shareParam.bgImgUrl = str7;
                    shareParam.from = str8;
                    if (TextUtils.isEmpty(str7)) {
                        final Bitmap captureScreen = captureScreen(activity);
                        GriverExecutors.getExecutor(ExecutorType.IO).execute(new Runnable() { // from class: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.2
                            {
                                ShareBridgeExtension.this = this;
                            }

                            @Override // java.lang.Runnable
                            public void run() {
                                String imageTempDir = ImageUtils.getImageTempDir(GriverEnv.getApplicationContext());
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(System.currentTimeMillis());
                                sb6.append(".png");
                                String obj4 = sb6.toString();
                                FileUtils.mkdirs(imageTempDir, true);
                                Bitmap.CompressFormat compressFormat = Bitmap.CompressFormat.PNG;
                                Bitmap bitmap = captureScreen;
                                StringBuilder sb7 = new StringBuilder();
                                sb7.append(imageTempDir);
                                sb7.append(obj4);
                                ImageUtils.writeImage(bitmap, compressFormat, sb7.toString());
                                ShareParam shareParam3 = shareParam;
                                StringBuilder sb8 = new StringBuilder();
                                sb8.append(imageTempDir);
                                sb8.append(obj4);
                                shareParam3.bgImgUrl = sb8.toString();
                                GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.2.1
                                    {
                                        AnonymousClass2.this = this;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        ShareBridgeExtension.access$100(ShareBridgeExtension.this, shareParam, bridgeCallback);
                                    }
                                });
                            }
                        });
                        return;
                    }
                    startShare(shareParam, bridgeCallback);
                    return;
                }
            }
        }
        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0018, code lost:
    
        if ((r0) != false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x002c, code lost:
    
        if ((com.alibaba.griver.base.common.utils.PWAUtils.isPwaApp(r4) ? '+' : ':') != '+') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x002e, code lost:
    
        r4 = com.alibaba.griver.base.common.utils.AppTypeUtils.isEmbedPage(r4.getEmbedPage());
        r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory + 81;
        com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0040, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0041, code lost:
    
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0042, code lost:
    
        throw r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0043, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean isNonDSLPage(com.alibaba.ariver.app.api.Page r4) {
        /*
            r3 = this;
            int r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory
            int r0 = r0 + 103
            int r1 = r0 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory = r1
            int r0 = r0 % 2
            r1 = 1
            if (r0 == 0) goto L1f
            boolean r0 = com.alibaba.griver.base.common.utils.PWAUtils.isPwaApp(r4)     // Catch: java.lang.Exception -> L1d
            r2 = 0
            int r2 = r2.length     // Catch: java.lang.Throwable -> L1b
            if (r0 == 0) goto L17
            r0 = 1
            goto L18
        L17:
            r0 = 0
        L18:
            if (r0 == 0) goto L2e
            goto L43
        L1b:
            r4 = move-exception
            throw r4
        L1d:
            r4 = move-exception
            throw r4
        L1f:
            boolean r0 = com.alibaba.griver.base.common.utils.PWAUtils.isPwaApp(r4)
            r2 = 43
            if (r0 == 0) goto L2a
            r0 = 43
            goto L2c
        L2a:
            r0 = 58
        L2c:
            if (r0 == r2) goto L43
        L2e:
            com.alibaba.ariver.app.api.Page r4 = r4.getEmbedPage()     // Catch: java.lang.Exception -> L41
            boolean r4 = com.alibaba.griver.base.common.utils.AppTypeUtils.isEmbedPage(r4)     // Catch: java.lang.Exception -> L41
            int r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory     // Catch: java.lang.Exception -> L41
            int r0 = r0 + 81
            int r1 = r0 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory = r1     // Catch: java.lang.Exception -> L41
            int r0 = r0 % 2
            return r4
        L41:
            r4 = move-exception
            throw r4
        L43:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.isNonDSLPage(com.alibaba.ariver.app.api.Page):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x005e, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x005f, code lost:
    
        r0 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0060, code lost:
    
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0036, code lost:
    
        if (r1 != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0041, code lost:
    
        if ((r0 instanceof com.alibaba.griver.core.ui.GriverPage) != false) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x0043, code lost:
    
        r4 = ((com.alibaba.griver.core.ui.GriverPage) r0).getWebView();
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0049, code lost:
    
        r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory + 75;
        com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x0055, code lost:
    
        if ((r0 % 2) != 0) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0057, code lost:
    
        r0 = '#';
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x005a, code lost:
    
        r0 = 'R';
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x005c, code lost:
    
        if (r0 == '#') goto L129;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.griver.base.api.APWebView findWebViewFromNonDSLPage(com.alibaba.ariver.app.api.Page r4) {
        /*
            r3 = this;
            boolean r0 = com.alibaba.griver.base.common.utils.PWAUtils.isPwaAppAndLoadNewWay(r4)
            r1 = 90
            if (r0 == 0) goto Lb
            r0 = 90
            goto Ld
        Lb:
            r0 = 83
        Ld:
            r2 = 0
            if (r0 == r1) goto L11
            goto L1b
        L11:
            boolean r0 = r4 instanceof com.alibaba.griver.core.ui.GriverPage
            r1 = 1
            if (r0 == 0) goto L18
            r0 = 0
            goto L19
        L18:
            r0 = 1
        L19:
            if (r0 == 0) goto L83
        L1b:
            boolean r0 = com.alibaba.griver.base.common.utils.PWAUtils.isPwaAppAndLoadOldWay(r4)
            if (r0 == 0) goto L63
            int r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 87
            int r1 = r0 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L3b
            com.alibaba.ariver.app.api.Page r0 = r4.getEmbedPage()
            boolean r1 = r0 instanceof com.alibaba.griver.core.ui.GriverPage
            r2.hashCode()     // Catch: java.lang.Throwable -> L39
            if (r1 == 0) goto L63
            goto L43
        L39:
            r4 = move-exception
            throw r4
        L3b:
            com.alibaba.ariver.app.api.Page r0 = r4.getEmbedPage()
            boolean r1 = r0 instanceof com.alibaba.griver.core.ui.GriverPage
            if (r1 == 0) goto L63
        L43:
            com.alibaba.griver.core.ui.GriverPage r0 = (com.alibaba.griver.core.ui.GriverPage) r0     // Catch: java.lang.Exception -> La8
            com.alibaba.griver.base.api.APWebView r4 = r0.getWebView()     // Catch: java.lang.Exception -> La8
            int r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            r1 = 35
            if (r0 != 0) goto L5a
            r0 = 35
            goto L5c
        L5a:
            r0 = 82
        L5c:
            if (r0 == r1) goto L5f
            return r4
        L5f:
            int r0 = r2.length     // Catch: java.lang.Throwable -> L61
            return r4
        L61:
            r4 = move-exception
            throw r4
        L63:
            com.alibaba.ariver.app.api.Page r4 = r4.getEmbedPage()
            boolean r0 = com.alibaba.griver.base.common.utils.AppTypeUtils.isEmbedPage(r4)
            if (r0 == 0) goto L82
            boolean r0 = r4 instanceof com.alibaba.griver.core.ui.GriverPage
            if (r0 == 0) goto L82
            com.alibaba.griver.core.ui.GriverPage r4 = (com.alibaba.griver.core.ui.GriverPage) r4
            com.alibaba.griver.base.api.APWebView r4 = r4.getWebView()
            int r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory
            int r0 = r0 + 3
            int r1 = r0 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory = r1
            int r0 = r0 % 2
            return r4
        L82:
            return r2
        L83:
            int r0 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> La8
            int r0 = r0 + r1
            int r1 = r0 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory = r1     // Catch: java.lang.Exception -> La8
            int r0 = r0 % 2
            r1 = 44
            if (r0 != 0) goto L93
            r0 = 55
            goto L95
        L93:
            r0 = 44
        L95:
            if (r0 == r1) goto La1
            com.alibaba.griver.core.ui.GriverPage r4 = (com.alibaba.griver.core.ui.GriverPage) r4     // Catch: java.lang.Exception -> La8
            com.alibaba.griver.base.api.APWebView r4 = r4.getWebView()
            int r0 = r2.length     // Catch: java.lang.Throwable -> L9f
            return r4
        L9f:
            r4 = move-exception
            throw r4
        La1:
            com.alibaba.griver.core.ui.GriverPage r4 = (com.alibaba.griver.core.ui.GriverPage) r4
            com.alibaba.griver.base.api.APWebView r4 = r4.getWebView()
            return r4
        La8:
            r4 = move-exception
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.findWebViewFromNonDSLPage(com.alibaba.ariver.app.api.Page):com.alibaba.griver.base.api.APWebView");
    }

    public Bitmap captureScreen(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.buildDrawingCache();
            Rect rect = new Rect();
            decorView.getWindowVisibleDisplayFrame(rect);
            int i = rect.top;
            decorView.setDrawingCacheEnabled(true);
            Bitmap drawingCache = decorView.getDrawingCache();
            Bitmap createBitmap = Bitmap.createBitmap(drawingCache, 0, i, drawingCache.getWidth(), drawingCache.getHeight() - i);
            decorView.destroyDrawingCache();
            int i2 = MyBillsEntityDataFactory + 43;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return createBitmap;
        } catch (Exception e) {
            RVLogger.e(TAG, e);
            return null;
        }
    }

    private void startShare(ShareParam shareParam, final BridgeCallback bridgeCallback) {
        ((GriverShareExtension) RVProxy.get(GriverShareExtension.class)).startShare(shareParam, ((GriverShareMenu4PageExtension) RVProxy.get(GriverShareMenu4PageExtension.class)).getShareItems(shareParam.page), new ShareResultListener() { // from class: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.3
            {
                ShareBridgeExtension.this = this;
            }

            @Override // com.alibaba.griver.api.ui.share.ShareResultListener
            public void success(String str) {
                ShareBridgeExtension.access$200(ShareBridgeExtension.this, bridgeCallback, str, true);
            }

            @Override // com.alibaba.griver.api.ui.share.ShareResultListener
            public void cancel() {
                ShareBridgeExtension.access$200(ShareBridgeExtension.this, bridgeCallback, null, false);
            }

            @Override // com.alibaba.griver.api.ui.share.ShareResultListener
            public void fail(String str, String str2, String str3) {
                ShareBridgeExtension.access$200(ShareBridgeExtension.this, bridgeCallback, str, false);
            }
        });
        int i = MyBillsEntityDataFactory + 25;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? 'b' : (char) 0) != 'b') {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    private void sendShareResult(BridgeCallback bridgeCallback, String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("shareResult", (Object) Boolean.valueOf(z));
        if ((!TextUtils.isEmpty(str) ? '_' : '\'') != '\'') {
            try {
                int i = MyBillsEntityDataFactory + 23;
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                jSONObject.put("channelName", (Object) str);
                int i3 = MyBillsEntityDataFactory + 125;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            bridgeCallback.sendJSONResponse(jSONObject);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private String encodeURIComponent(String str) {
        String str2;
        String intern;
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        MyBillsEntityDataFactory = i % 128;
        try {
            if (i % 2 == 0) {
                Object[] objArr = new Object[1];
                a(14580 >>> (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{5304, 10710, 28277, 44173, 57705}, objArr);
                intern = ((String) objArr[0]).intern();
            } else {
                Object[] objArr2 = new Object[1];
                a(15728 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), new char[]{5304, 10710, 28277, 44173, 57705}, objArr2);
                intern = ((String) objArr2[0]).intern();
            }
            str2 = URLEncoder.encode(str, intern);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("shareTinyAppMsg...e=");
            sb.append(th);
            GriverLogger.e(TAG, sb.toString());
            str2 = str;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 61;
        MyBillsEntityDataFactory = i2 % 128;
        int i3 = i2 % 2;
        return str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x001f, code lost:
    
        if ((r2 != null) != true) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x002b, code lost:
    
        if ((r6.getPageContext() != null) != true) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0040, code lost:
    
        return r6.getPageContext().getTitleBar();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.alibaba.ariver.app.api.ui.titlebar.TitleBar getTitleBar(com.alibaba.ariver.app.api.Page r6) {
        /*
            r5 = this;
            r0 = 0
            r1 = 1
            if (r6 == 0) goto L6
            r2 = 1
            goto L7
        L6:
            r2 = 0
        L7:
            r3 = 0
            if (r2 == r1) goto Lb
            goto L2d
        Lb:
            int r2 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory     // Catch: java.lang.Exception -> L43
            int r2 = r2 + 53
            int r4 = r2 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory = r4     // Catch: java.lang.Exception -> L41
            int r2 = r2 % 2
            if (r2 != 0) goto L24
            com.alibaba.ariver.app.api.PageContext r2 = r6.getPageContext()
            int r4 = r3.length     // Catch: java.lang.Throwable -> L22
            if (r2 == 0) goto L1f
            r0 = 1
        L1f:
            if (r0 == r1) goto L38
            goto L2d
        L22:
            r6 = move-exception
            throw r6
        L24:
            com.alibaba.ariver.app.api.PageContext r2 = r6.getPageContext()     // Catch: java.lang.Exception -> L41
            if (r2 == 0) goto L2b
            r0 = 1
        L2b:
            if (r0 == r1) goto L38
        L2d:
            int r6 = com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.MyBillsEntityDataFactory
            int r6 = r6 + 37
            int r0 = r6 % 128
            com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.BuiltInFictitiousFunctionClassFactory = r0
            int r6 = r6 % 2
            return r3
        L38:
            com.alibaba.ariver.app.api.PageContext r6 = r6.getPageContext()
            com.alibaba.ariver.app.api.ui.titlebar.TitleBar r6 = r6.getTitleBar()
            return r6
        L41:
            r6 = move-exception
            throw r6
        L43:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.share.ShareBridgeExtension.getTitleBar(com.alibaba.ariver.app.api.Page):com.alibaba.ariver.app.api.ui.titlebar.TitleBar");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if ((getonboardingscenario.getAuthRequestContext < cArr.length ? 'G' : '*') == '*') {
                break;
            }
            int i2 = $10 + 89;
            $11 = i2 % 128;
            int i3 = i2 % 2;
            jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (getAuthRequestContext ^ 4796183387843776835L);
            getonboardingscenario.getAuthRequestContext++;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        int i4 = $11 + 65;
        $10 = i4 % 128;
        int i5 = i4 % 2;
        while (true) {
            try {
                if ((getonboardingscenario.getAuthRequestContext < cArr.length ? (char) 15 : 'N') == 'N') {
                    objArr[0] = new String(cArr2);
                    return;
                }
                int i6 = $11 + 35;
                $10 = i6 % 128;
                int i7 = i6 % 2;
                cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                getonboardingscenario.getAuthRequestContext++;
            } catch (Exception e) {
                throw e;
            }
        }
    }
}
