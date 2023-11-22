package com.alibaba.griver.core.extensions;

import android.app.Activity;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.Render;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeResponse;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.engine.api.embedview.IEmbedView;
import com.alibaba.ariver.engine.api.embedview.IEmbedViewManager;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.AutoCallback;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.DimensionUtil;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.common.config.ConfigUtils;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.ReflectUtils;
import com.alibaba.griver.base.nebula.WebViewType;
import com.alibaba.griver.core.jsapi.embedview.EmbedViewBridgeExtension;
import com.alibaba.griver.core.render.BaseGriverRender;
import com.alibaba.griver.core.render.H5WebView;
import com.alibaba.griver.core.webview.AndroidWebView;
import java.util.Collections;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class GriverEmbedViewBridgeExtension extends EmbedViewBridgeExtension {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f6407a = !"NO".equalsIgnoreCase(GriverInnerConfig.getConfigWithProcessCache(GriverConfigConstants.KEY_MP_USE_SYSTEM_EMBED_VIEW, ""));

    @Override // com.alibaba.griver.core.jsapi.embedview.EmbedViewBridgeExtension
    @ThreadType(ExecutorType.UI)
    @ActionFilter("NBComponent.render")
    public void render(@BindingParam({"element"}) final String str, @BindingParam({"props"}) final JSONObject jSONObject, @BindingParam({"data"}) final JSONObject jSONObject2, @BindingParam({"version"}) final String str2, @BindingCallback final BridgeCallback bridgeCallback, @BindingNode(Page.class) final Page page) {
        if (!this.f6407a) {
            super.render(str, jSONObject, jSONObject2, str2, bridgeCallback, page);
            return;
        }
        Render render = page.getRender();
        if (render instanceof BaseGriverRender) {
            H5WebView h5WebView = ((BaseGriverRender) render).getH5WebView();
            if (h5WebView.getType() == WebViewType.SYSTEM_BUILD_IN) {
                RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "NBComponent.render with android webview!");
                final AndroidWebView androidWebView = (AndroidWebView) h5WebView.getInternalContentView();
                androidWebView.tryRenderEmbedView(str, new AndroidWebView.EmbedViewRenderCallback() { // from class: com.alibaba.griver.core.extensions.GriverEmbedViewBridgeExtension.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
                    /* JADX WARN: Type inference failed for: r2v1 */
                    /* JADX WARN: Type inference failed for: r2v12 */
                    /* JADX WARN: Type inference failed for: r2v13 */
                    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
                    @Override // com.alibaba.griver.core.webview.AndroidWebView.EmbedViewRenderCallback
                    public void onRender(String str3, String str4, int i, int i2, int i3, int i4) {
                        Object obj;
                        String str5 = i;
                        StringBuilder sb = new StringBuilder();
                        sb.append("onRender ");
                        sb.append(str3);
                        sb.append(" ");
                        sb.append(str4);
                        sb.append(" x: ");
                        sb.append((int) str5);
                        sb.append(", y: ");
                        sb.append(i2);
                        sb.append(", w: ");
                        sb.append(i3);
                        sb.append(", h: ");
                        sb.append(i4);
                        RVLogger.d("Griver:GriverEmbedViewBridgeExtension", sb.toString());
                        try {
                            try {
                                if (!page.isExited() && page.getPageContext() != null) {
                                    Activity activity = page.getPageContext().getActivity();
                                    int dip2px = DimensionUtil.dip2px(activity, (float) str5);
                                    int dip2px2 = DimensionUtil.dip2px(activity, i2);
                                    int dip2px3 = DimensionUtil.dip2px(activity, i3);
                                    int dip2px4 = DimensionUtil.dip2px(activity, i4);
                                    IEmbedViewManager embedViewManager = page.getPageContext().getEmbedViewManager();
                                    ?? equals = "video".equals(str4);
                                    try {
                                        if (equals == 0 && !"live-player".equals(str4)) {
                                            if (embedViewManager.findViewById(str) == null) {
                                                RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "render in fist time, createView!");
                                                IEmbedView createView = embedViewManager.createView(str, str4);
                                                if (createView == null) {
                                                    RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "onRender createEmbedView null!");
                                                    bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                                    return;
                                                }
                                                obj = "Griver:GriverEmbedViewBridgeExtension";
                                                androidWebView.addEmbedView(str3, createView.getView(dip2px3, dip2px4, str3, str4, Collections.EMPTY_MAP), dip2px3, dip2px4, dip2px2, dip2px);
                                            } else {
                                                obj = "Griver:GriverEmbedViewBridgeExtension";
                                                androidWebView.addEmbedView(str3, null, dip2px3, dip2px4, dip2px2, dip2px);
                                            }
                                            GriverEmbedViewBridgeExtension.super.render(str, jSONObject, jSONObject2, str2, bridgeCallback, page);
                                            return;
                                        }
                                        if (!ReflectUtils.classExist("com.alibaba.griver.video.H5BeeVideoPlayerView") && "video".equals(str4)) {
                                            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                            return;
                                        } else if (!ReflectUtils.classExist("com.alibaba.griver.media.live.view.GRVLivePlayerView") && "live-player".equals(str4)) {
                                            bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                            return;
                                        } else {
                                            RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "render in fist time, createView!");
                                            boolean canUseWhiteList = ConfigUtils.canUseWhiteList(GriverInnerConfig.getConfig(GriverConfigConstants.KEY_GRV_VIDEO_CONFIG), page.getApp().getAppId(), true);
                                            HashMap hashMap = new HashMap();
                                            hashMap.put("CAN_USE_VIDEO", String.valueOf(canUseWhiteList));
                                            try {
                                                if (embedViewManager.findViewById(str) == null) {
                                                    IEmbedView createView2 = embedViewManager.createView(str, str4);
                                                    if (createView2 == null) {
                                                        RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "onRender createEmbedView null!");
                                                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                                        return;
                                                    }
                                                    androidWebView.addEmbedView(str3, createView2.getView(dip2px3, dip2px4, str3, str4, hashMap), dip2px3, dip2px4, dip2px2, dip2px);
                                                } else {
                                                    IEmbedView createView3 = embedViewManager.createView(str, str4);
                                                    if (createView3 == null) {
                                                        RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "onRender createEmbedView null!");
                                                        bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                                        return;
                                                    }
                                                    createView3.getView(dip2px3, dip2px4, str3, str4, hashMap);
                                                    androidWebView.addEmbedView(str3, null, dip2px3, dip2px4, dip2px2, dip2px);
                                                }
                                                GriverEmbedViewBridgeExtension.super.render(str, jSONObject, jSONObject2, str2, bridgeCallback, page);
                                                return;
                                            } catch (Throwable th) {
                                                th = th;
                                                str5 = 1;
                                                GriverLogger.e(str5, th.getMessage());
                                                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                                                return;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        str5 = equals;
                                    }
                                }
                                RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "onRender but exited!");
                                bridgeCallback.sendBridgeResponse(BridgeResponse.UNKNOWN_ERROR);
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            str5 = "Griver:GriverEmbedViewBridgeExtension";
                        }
                    }

                    @Override // com.alibaba.griver.core.webview.AndroidWebView.EmbedViewRenderCallback
                    public void onError(String str3) {
                        bridgeCallback.sendBridgeResponse(BridgeResponse.newError(5, str3));
                    }
                });
                return;
            }
        }
        super.render(str, jSONObject, jSONObject2, str2, bridgeCallback, page);
    }

    @Override // com.alibaba.griver.core.jsapi.embedview.EmbedViewBridgeExtension
    @ThreadType(ExecutorType.UI)
    @ActionFilter("NBComponent.remove")
    @AutoCallback
    public BridgeResponse remove(@BindingParam({"element"}) String str, @BindingParam({"version"}) String str2, @BindingCallback BridgeCallback bridgeCallback, @BindingNode(Page.class) Page page) {
        if (!this.f6407a) {
            return super.remove(str, str2, bridgeCallback, page);
        }
        Render render = page.getRender();
        if (render instanceof BaseGriverRender) {
            H5WebView h5WebView = ((BaseGriverRender) render).getH5WebView();
            if (h5WebView.getType() == WebViewType.SYSTEM_BUILD_IN) {
                RVLogger.d("Griver:GriverEmbedViewBridgeExtension", "NBComponent.remove with android webview!");
                ((AndroidWebView) h5WebView.getInternalContentView()).removeEmbedView(str);
                return BridgeResponse.SUCCESS;
            }
        }
        return super.remove(str, str2, bridgeCallback, page);
    }
}
