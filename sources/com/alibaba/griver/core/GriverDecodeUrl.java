package com.alibaba.griver.core;

import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.api.callback.GriverDecodeUrlCallback;
import com.alibaba.griver.api.common.config.GriverConfigConstants;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.config.GriverInnerConfig;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.rpc.OnRpcResultListener;
import com.alibaba.griver.core.common.monitor.UrlContentDecoderMonitorHelper;
import com.alibaba.griver.core.model.codec.UrlCodecRequest;
import com.alibaba.griver.core.model.codec.UrlCodecResult;
import com.alibaba.griver.core.model.codec.cancodec.UrlCanCodecRequest;
import com.alibaba.griver.core.rpc.GriverRpcContants;
import com.alibaba.griver.core.rpc.MiniProgramProcessor;
import com.fullstory.instrumentation.InstrumentInjector;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes6.dex */
public class GriverDecodeUrl {
    public static void decodeUrlContent(final String str, final GriverDecodeUrlCallback griverDecodeUrlCallback) {
        synchronized (GriverDecodeUrl.class) {
            if (!Griver.alreadyInitialized()) {
                InstrumentInjector.log_e("DecodeUrlUtils", "Please initialize Griver first!");
                griverDecodeUrlCallback.onDecodeFailed(2, "SDK is not initialized.");
            } else if (TextUtils.isEmpty(str)) {
                griverDecodeUrlCallback.onDecodeFailed(0, "invalid url.");
                MonitorMap.Builder builder = new MonitorMap.Builder();
                builder.append("operationType", GriverRpcContants.APP_CODEC_ROUTE).url(str).code("0").message("invalid url.");
                GriverMonitor.error(GriverMonitorConstants.ERROR_RPC_EXCEPTION, "GriverAppContainer", builder.build());
            } else {
                new MiniProgramProcessor().getUrlCodec(new UrlCodecRequest(str), new OnRpcResultListener<UrlCodecResult>() { // from class: com.alibaba.griver.core.GriverDecodeUrl.1
                    @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
                    public final void onResultSuccess(final UrlCodecResult urlCodecResult) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onResultSuccess == ");
                        sb.append(JSON.toJSONString(urlCodecResult));
                        GriverLogger.d("DecodeUrlUtils", sb.toString());
                        if (urlCodecResult != null && urlCodecResult.success && !TextUtils.isEmpty(urlCodecResult.getSchema())) {
                            GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.GriverDecodeUrl.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    GriverDecodeUrlCallback.this.onDecodeSuccess(urlCodecResult.getSchema());
                                }
                            });
                            return;
                        }
                        onResultFailed(1, "decode failed.");
                        if (urlCodecResult == null || !urlCodecResult.success) {
                            UrlContentDecoderMonitorHelper.monitor(UrlContentDecoderMonitorHelper.Scene.DecodeURL, UrlContentDecoderMonitorHelper.ErrorType.ServerError, urlCodecResult == null ? "" : urlCodecResult.errorMessage);
                        }
                    }

                    @Override // com.alibaba.griver.base.common.rpc.OnRpcResultListener
                    public final void onResultFailed(final int i, final String str2) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("onResultFailed errorCode == ");
                        sb.append(i);
                        GriverLogger.e("DecodeUrlUtils", sb.toString());
                        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.core.GriverDecodeUrl.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                GriverDecodeUrlCallback.this.onDecodeFailed(i, str2);
                            }
                        });
                        MonitorMap.Builder builder2 = new MonitorMap.Builder();
                        builder2.append("operationType", GriverRpcContants.APP_CODEC_ROUTE).url(str).code(String.valueOf(i)).message(str2);
                        GriverMonitor.error(GriverMonitorConstants.ERROR_RPC_EXCEPTION, "GriverAppContainer", builder2.build());
                        UrlContentDecoderMonitorHelper.monitor(UrlContentDecoderMonitorHelper.Scene.DecodeURL, UrlContentDecoderMonitorHelper.ErrorType.NetworkError, str2);
                    }
                });
            }
        }
    }

    public static boolean canDecodeUrl(String str) {
        synchronized (GriverDecodeUrl.class) {
            boolean z = false;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (!a()) {
                return a(str);
            }
            try {
                try {
                    z = new MiniProgramProcessor().getUrlCanDecode(new UrlCanCodecRequest(str)).get(b(), TimeUnit.SECONDS).booleanValue();
                } catch (TimeoutException e) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("parse url decode config failed,Server timeout: ");
                    sb.append(e);
                    GriverLogger.e("DecodeUrlUtils", sb.toString());
                    UrlContentDecoderMonitorHelper.monitor(UrlContentDecoderMonitorHelper.Scene.CanDecodeURL, UrlContentDecoderMonitorHelper.ErrorType.TimeoutError, e.getMessage());
                }
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("parse url decode config failed,Server request error: ");
                sb2.append(e2);
                GriverLogger.e("DecodeUrlUtils", sb2.toString());
                UrlContentDecoderMonitorHelper.monitor(UrlContentDecoderMonitorHelper.Scene.CanDecodeURL, UrlContentDecoderMonitorHelper.ErrorType.ServerError, e2.getMessage());
            }
            if (!z) {
                z = a(str);
            }
            return z;
        }
    }

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("mini-qr");
    }

    private static boolean a() {
        String c = c();
        try {
            JSONObject parseObject = JSON.parseObject(c);
            if (parseObject.containsKey(GriverConfigConstants.PARAM_CAN_DECODE_USE_SERVER)) {
                return parseObject.getBoolean(GriverConfigConstants.PARAM_CAN_DECODE_USE_SERVER).booleanValue();
            }
            return false;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse url decode config failed, config: ");
            sb.append(c);
            GriverLogger.e("DecodeUrlUtils", sb.toString(), e);
            return false;
        }
    }

    private static int b() {
        String c = c();
        int i = 5;
        try {
            JSONObject parseObject = JSON.parseObject(c);
            if (parseObject.containsKey(GriverConfigConstants.PARAM_CAN_DECODE_HANDLE_TIME_INTERVAL)) {
                i = parseObject.getIntValue(GriverConfigConstants.PARAM_CAN_DECODE_HANDLE_TIME_INTERVAL);
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse url decode config failed, config: ");
            sb.append(c);
            GriverLogger.e("DecodeUrlUtils", sb.toString(), e);
        }
        return Math.max(i, 1);
    }

    private static String c() {
        String config = GriverInnerConfig.getConfig(GriverConfigConstants.KEY_URL_CONTENT_DECODE_CONFIG);
        return TextUtils.isEmpty(config) ? GriverConfigConstants.DEFAULT_URL_CONTENT_DECODE_CONFIG : config;
    }
}
