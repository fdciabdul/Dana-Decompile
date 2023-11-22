package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes7.dex */
public final class LogSourceMetrics {
    private static final LogSourceMetrics DEFAULT_INSTANCE = new Builder().build();
    private final List<LogEventDropped> log_event_dropped_;
    private final String log_source_;

    LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.log_source_ = str;
        this.log_event_dropped_ = list;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public final String getLogSource() {
        return this.log_source_;
    }

    @Encodable.Field(name = "logEventDropped")
    public final List<LogEventDropped> getLogEventDroppedList() {
        return this.log_event_dropped_;
    }

    public static LogSourceMetrics getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {
        private String log_source_ = "";
        private List<LogEventDropped> log_event_dropped_ = new ArrayList();

        Builder() {
        }

        public final LogSourceMetrics build() {
            return new LogSourceMetrics(this.log_source_, Collections.unmodifiableList(this.log_event_dropped_));
        }

        public final Builder setLogSource(String str) {
            this.log_source_ = str;
            return this;
        }

        public final Builder addLogEventDropped(LogEventDropped logEventDropped) {
            this.log_event_dropped_.add(logEventDropped);
            return this;
        }

        public final Builder setLogEventDroppedList(List<LogEventDropped> list) {
            this.log_event_dropped_ = list;
            return this;
        }
    }
}
