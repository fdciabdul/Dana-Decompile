package com.alibaba.griver.core.common.monitor;

import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.monitor.GriverMonitor;
import com.alibaba.griver.base.common.monitor.MonitorMap;

/* loaded from: classes6.dex */
public class UrlContentDecoderMonitorHelper {

    /* loaded from: classes6.dex */
    public enum Scene {
        CanDecodeURL("canDecodeURL"),
        DecodeURL("decodeURL");

        private String sceneName;

        Scene(String str) {
            this.sceneName = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.sceneName;
        }
    }

    /* loaded from: classes6.dex */
    public enum ErrorType {
        NetworkError(GriverMonitorConstants.MESSAGE_HTTP_REQUEST_NETWORK_ERROR),
        ServerError("server exception"),
        TimeoutError("canDecodeURL handle timeout");

        private String typeValue;

        ErrorType(String str) {
            this.typeValue = str;
        }

        @Override // java.lang.Enum
        public final String toString() {
            return this.typeValue;
        }
    }

    public static void monitor(Scene scene, ErrorType errorType, String str) {
        if (str == null) {
            str = "";
        }
        MonitorMap.Builder builder = new MonitorMap.Builder();
        builder.append("scene", scene.toString()).append("errorType", errorType.toString()).append("message", str);
        GriverMonitor.event(GriverMonitorConstants.URL_CONTENT_DECODER_EXCEPTION, "GriverAppContainer", builder.build());
    }
}
