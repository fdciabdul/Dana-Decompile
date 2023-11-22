package com.alibaba.griver.core.jsapi.device.network;

import android.text.TextUtils;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingCallback;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingNode;
import com.alibaba.ariver.engine.api.bridge.extension.annotation.BindingParam;
import com.alibaba.ariver.kernel.api.annotation.ActionFilter;
import com.alibaba.ariver.kernel.api.annotation.ThreadType;
import com.alibaba.ariver.kernel.api.extension.bridge.SimpleBridgeExtension;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;
import com.alibaba.griver.base.common.utils.RequestAPIConfigUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class RequestBridgeExtension extends SimpleBridgeExtension {
    private static final int CODE_DECODING_ERROR = 14;
    private static final int CODE_HTTP_ERROR = 19;
    private static final int CODE_NETWORK_ERROR = 12;
    private static final int CODE_PERMISSION_ERROR = 11;
    private static final int CODE_REQUEST_NOT_ALLOWED = 2;
    private static final int CODE_TIMEOUT_ERROR = 13;
    private static final String TAG = "RequestBridgeExtension";

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void httpRequest(@BindingNode(Page.class) Page page, @BindingParam(name = {"url"}) String str, @BindingParam(name = {"headers"}) Object obj, @BindingParam(name = {"method"}) String str2, @BindingParam(name = {"data"}) String str3, @BindingParam(name = {"timeout"}) int i, @BindingParam(name = {"dataType"}) String str4, @BindingCallback BridgeCallback bridgeCallback) {
        if (!RequestAPIConfigUtils.canSendRequest(page, str, bridgeCallback)) {
            monitorException(page, str, null, "request call is not allowed to send", "2");
        } else {
            sendHttp(page, str, obj, str2, str3, i, str4, bridgeCallback, true);
        }
    }

    @ThreadType(ExecutorType.NETWORK)
    @ActionFilter
    public void request(@BindingNode(Page.class) Page page, @BindingParam(name = {"url"}) String str, @BindingParam(name = {"headers"}) Object obj, @BindingParam(name = {"method"}) String str2, @BindingParam(name = {"data"}) String str3, @BindingParam(name = {"timeout"}) int i, @BindingParam(name = {"dataType"}) String str4, @BindingCallback BridgeCallback bridgeCallback) {
        if (!RequestAPIConfigUtils.canSendRequest(page, str, bridgeCallback)) {
            monitorException(page, str, null, "request call is not allowed to send", "2");
        } else {
            sendHttp(page, str, obj, str2, str3, i, str4, bridgeCallback, false);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:163:0x0408
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void sendHttp(com.alibaba.ariver.app.api.Page r24, java.lang.String r25, java.lang.Object r26, java.lang.String r27, java.lang.String r28, int r29, java.lang.String r30, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 1211
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.core.jsapi.device.network.RequestBridgeExtension.sendHttp(com.alibaba.ariver.app.api.Page, java.lang.String, java.lang.Object, java.lang.String, java.lang.String, int, java.lang.String, com.alibaba.ariver.engine.api.bridge.extension.BridgeCallback, boolean):void");
    }

    private static Map<String, List<String>> fixEmptyKeyHeader(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        for (String str : map.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                hashMap.put(str, map.get(str));
            }
        }
        return hashMap;
    }

    private void monitorException(Page page, String str, Throwable th, String str2, String str3) {
        GriverMonitor.error(GriverMonitorConstants.ERROR_HTTP_REQUEST_EXCEPTION, "GriverAppContainer", new MonitorMap.Builder().appId(page.getApp().getAppId()).version(page.getApp()).url(str).requestUrl(str).pageUrl(page.getOriginalURI()).exception(th).message(str2).code(str3).needAsynAppType(true).build());
    }
}
