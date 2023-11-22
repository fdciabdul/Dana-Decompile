package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class ClientMetrics {
    private static final ClientMetrics DEFAULT_INSTANCE = new Builder().build();
    private final String app_namespace_;
    private final GlobalMetrics global_metrics_;
    private final List<LogSourceMetrics> log_source_metrics_;
    private final TimeWindow window_;

    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.window_ = timeWindow;
        this.log_source_metrics_ = list;
        this.global_metrics_ = globalMetrics;
        this.app_namespace_ = str;
    }

    public final byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    public final void writeTo(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.encode(this, outputStream);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Encodable.Ignore
    public final TimeWindow getWindow() {
        TimeWindow timeWindow = this.window_;
        return timeWindow == null ? TimeWindow.getDefaultInstance() : timeWindow;
    }

    @Encodable.Field(name = "window")
    public final TimeWindow getWindowInternal() {
        return this.window_;
    }

    @Encodable.Field(name = "logSourceMetrics")
    public final List<LogSourceMetrics> getLogSourceMetricsList() {
        return this.log_source_metrics_;
    }

    @Encodable.Ignore
    public final GlobalMetrics getGlobalMetrics() {
        GlobalMetrics globalMetrics = this.global_metrics_;
        return globalMetrics == null ? GlobalMetrics.getDefaultInstance() : globalMetrics;
    }

    @Encodable.Field(name = "globalMetrics")
    public final GlobalMetrics getGlobalMetricsInternal() {
        return this.global_metrics_;
    }

    public final String getAppNamespace() {
        return this.app_namespace_;
    }

    public static ClientMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private TimeWindow window_ = null;
        private List<LogSourceMetrics> log_source_metrics_ = new ArrayList();
        private GlobalMetrics global_metrics_ = null;
        private String app_namespace_ = "";

        Builder() {
        }

        public final ClientMetrics build() {
            return new ClientMetrics(this.window_, Collections.unmodifiableList(this.log_source_metrics_), this.global_metrics_, this.app_namespace_);
        }

        public final Builder setWindow(TimeWindow timeWindow) {
            this.window_ = timeWindow;
            return this;
        }

        public final Builder addLogSourceMetrics(LogSourceMetrics logSourceMetrics) {
            this.log_source_metrics_.add(logSourceMetrics);
            return this;
        }

        public final Builder setLogSourceMetricsList(List<LogSourceMetrics> list) {
            this.log_source_metrics_ = list;
            return this;
        }

        public final Builder setGlobalMetrics(GlobalMetrics globalMetrics) {
            this.global_metrics_ = globalMetrics;
            return this;
        }

        public final Builder setAppNamespace(String str) {
            this.app_namespace_ = str;
            return this;
        }
    }
}
