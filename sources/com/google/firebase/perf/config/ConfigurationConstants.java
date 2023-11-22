package com.google.firebase.perf.config;

import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.util.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class ConfigurationConstants {
    ConfigurationConstants() {
    }

    /* loaded from: classes.dex */
    protected static final class CollectionDeactivated extends ConfigurationFlag<Boolean> {
        private static CollectionDeactivated instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "firebase_performance_collection_deactivated";
        }

        private CollectionDeactivated() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static CollectionDeactivated getInstance() {
            CollectionDeactivated collectionDeactivated;
            synchronized (CollectionDeactivated.class) {
                if (instance == null) {
                    instance = new CollectionDeactivated();
                }
                collectionDeactivated = instance;
            }
            return collectionDeactivated;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Boolean getDefault() {
            return Boolean.FALSE;
        }
    }

    /* loaded from: classes.dex */
    protected static final class CollectionEnabled extends ConfigurationFlag<Boolean> {
        private static CollectionEnabled instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return Constants.ENABLE_DISABLE;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "firebase_performance_collection_enabled";
        }

        private CollectionEnabled() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static CollectionEnabled getInstance() {
            CollectionEnabled collectionEnabled;
            synchronized (CollectionEnabled.class) {
                if (instance == null) {
                    instance = new CollectionEnabled();
                }
                collectionEnabled = instance;
            }
            return collectionEnabled;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SdkEnabled extends ConfigurationFlag<Boolean> {
        private static SdkEnabled instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkEnabled";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_enabled";
        }

        protected SdkEnabled() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static SdkEnabled getInstance() {
            SdkEnabled sdkEnabled;
            synchronized (SdkEnabled.class) {
                if (instance == null) {
                    instance = new SdkEnabled();
                }
                sdkEnabled = instance;
            }
            return sdkEnabled;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Boolean getDefault() {
            return Boolean.TRUE;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SdkDisabledVersions extends ConfigurationFlag<String> {
        private static SdkDisabledVersions instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDefault() {
            return "";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SdkDisabledVersions";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_disabled_android_versions";
        }

        protected SdkDisabledVersions() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static SdkDisabledVersions getInstance() {
            SdkDisabledVersions sdkDisabledVersions;
            synchronized (SdkDisabledVersions.class) {
                if (instance == null) {
                    instance = new SdkDisabledVersions();
                }
                sdkDisabledVersions = instance;
            }
            return sdkDisabledVersions;
        }
    }

    /* loaded from: classes.dex */
    protected static final class TraceSamplingRate extends ConfigurationFlag<Float> {
        private static TraceSamplingRate instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceSamplingRate";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_vc_trace_sampling_rate";
        }

        private TraceSamplingRate() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static TraceSamplingRate getInstance() {
            TraceSamplingRate traceSamplingRate;
            synchronized (TraceSamplingRate.class) {
                if (instance == null) {
                    instance = new TraceSamplingRate();
                }
                traceSamplingRate = instance;
            }
            return traceSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Float getDefault() {
            return Float.valueOf(1.0f);
        }
    }

    /* loaded from: classes.dex */
    protected static final class NetworkRequestSamplingRate extends ConfigurationFlag<Float> {
        private static NetworkRequestSamplingRate instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkRequestSamplingRate";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_vc_network_request_sampling_rate";
        }

        private NetworkRequestSamplingRate() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static NetworkRequestSamplingRate getInstance() {
            NetworkRequestSamplingRate networkRequestSamplingRate;
            synchronized (NetworkRequestSamplingRate.class) {
                if (instance == null) {
                    instance = new NetworkRequestSamplingRate();
                }
                networkRequestSamplingRate = instance;
            }
            return networkRequestSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Float getDefault() {
            return Float.valueOf(1.0f);
        }
    }

    /* loaded from: classes.dex */
    protected static final class SessionsCpuCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyForegroundMs instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_fg_ms";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
        }

        private SessionsCpuCaptureFrequencyForegroundMs() {
        }

        public static SessionsCpuCaptureFrequencyForegroundMs getInstance() {
            SessionsCpuCaptureFrequencyForegroundMs sessionsCpuCaptureFrequencyForegroundMs;
            synchronized (SessionsCpuCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyForegroundMs();
                }
                sessionsCpuCaptureFrequencyForegroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyForegroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 100L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SessionsCpuCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsCpuCaptureFrequencyBackgroundMs instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "sessions_cpu_capture_frequency_bg_ms";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
        }

        private SessionsCpuCaptureFrequencyBackgroundMs() {
        }

        public static SessionsCpuCaptureFrequencyBackgroundMs getInstance() {
            SessionsCpuCaptureFrequencyBackgroundMs sessionsCpuCaptureFrequencyBackgroundMs;
            synchronized (SessionsCpuCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsCpuCaptureFrequencyBackgroundMs();
                }
                sessionsCpuCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsCpuCaptureFrequencyBackgroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 0L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SessionsMemoryCaptureFrequencyForegroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyForegroundMs instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "sessions_memory_capture_frequency_fg_ms";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_fg_ms";
        }

        private SessionsMemoryCaptureFrequencyForegroundMs() {
        }

        public static SessionsMemoryCaptureFrequencyForegroundMs getInstance() {
            SessionsMemoryCaptureFrequencyForegroundMs sessionsMemoryCaptureFrequencyForegroundMs;
            synchronized (SessionsMemoryCaptureFrequencyForegroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyForegroundMs();
                }
                sessionsMemoryCaptureFrequencyForegroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyForegroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 100L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SessionsMemoryCaptureFrequencyBackgroundMs extends ConfigurationFlag<Long> {
        private static SessionsMemoryCaptureFrequencyBackgroundMs instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "sessions_memory_capture_frequency_bg_ms";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_session_gauge_memory_capture_frequency_bg_ms";
        }

        private SessionsMemoryCaptureFrequencyBackgroundMs() {
        }

        public static SessionsMemoryCaptureFrequencyBackgroundMs getInstance() {
            SessionsMemoryCaptureFrequencyBackgroundMs sessionsMemoryCaptureFrequencyBackgroundMs;
            synchronized (SessionsMemoryCaptureFrequencyBackgroundMs.class) {
                if (instance == null) {
                    instance = new SessionsMemoryCaptureFrequencyBackgroundMs();
                }
                sessionsMemoryCaptureFrequencyBackgroundMs = instance;
            }
            return sessionsMemoryCaptureFrequencyBackgroundMs;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 0L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SessionsMaxDurationMinutes extends ConfigurationFlag<Long> {
        private static SessionsMaxDurationMinutes instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionsMaxDurationMinutes";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "sessions_max_length_minutes";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_session_max_duration_min";
        }

        private SessionsMaxDurationMinutes() {
        }

        public static SessionsMaxDurationMinutes getInstance() {
            SessionsMaxDurationMinutes sessionsMaxDurationMinutes;
            synchronized (SessionsMaxDurationMinutes.class) {
                if (instance == null) {
                    instance = new SessionsMaxDurationMinutes();
                }
                sessionsMaxDurationMinutes = instance;
            }
            return sessionsMaxDurationMinutes;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 240L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class TraceEventCountForeground extends ConfigurationFlag<Long> {
        private static TraceEventCountForeground instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountForeground";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_fg";
        }

        private TraceEventCountForeground() {
        }

        public static TraceEventCountForeground getInstance() {
            TraceEventCountForeground traceEventCountForeground;
            synchronized (TraceEventCountForeground.class) {
                if (instance == null) {
                    instance = new TraceEventCountForeground();
                }
                traceEventCountForeground = instance;
            }
            return traceEventCountForeground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 300L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class TraceEventCountBackground extends ConfigurationFlag<Long> {
        private static TraceEventCountBackground instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TraceEventCountBackground";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_rl_trace_event_count_bg";
        }

        private TraceEventCountBackground() {
        }

        public static TraceEventCountBackground getInstance() {
            TraceEventCountBackground traceEventCountBackground;
            synchronized (TraceEventCountBackground.class) {
                if (instance == null) {
                    instance = new TraceEventCountBackground();
                }
                traceEventCountBackground = instance;
            }
            return traceEventCountBackground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 30L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class NetworkEventCountForeground extends ConfigurationFlag<Long> {
        private static NetworkEventCountForeground instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountForeground";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_fg";
        }

        private NetworkEventCountForeground() {
        }

        public static NetworkEventCountForeground getInstance() {
            NetworkEventCountForeground networkEventCountForeground;
            synchronized (NetworkEventCountForeground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountForeground();
                }
                networkEventCountForeground = instance;
            }
            return networkEventCountForeground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 700L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class NetworkEventCountBackground extends ConfigurationFlag<Long> {
        private static NetworkEventCountBackground instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.NetworkEventCountBackground";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_rl_network_event_count_bg";
        }

        private NetworkEventCountBackground() {
        }

        public static NetworkEventCountBackground getInstance() {
            NetworkEventCountBackground networkEventCountBackground;
            synchronized (NetworkEventCountBackground.class) {
                if (instance == null) {
                    instance = new NetworkEventCountBackground();
                }
                networkEventCountBackground = instance;
            }
            return networkEventCountBackground;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 70L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class RateLimitSec extends ConfigurationFlag<Long> {
        private static RateLimitSec instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.TimeLimitSec";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_rl_time_limit_sec";
        }

        private RateLimitSec() {
        }

        public static RateLimitSec getInstance() {
            RateLimitSec rateLimitSec;
            synchronized (RateLimitSec.class) {
                if (instance == null) {
                    instance = new RateLimitSec();
                }
                rateLimitSec = instance;
            }
            return rateLimitSec;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Long getDefault() {
            return 600L;
        }
    }

    /* loaded from: classes.dex */
    protected static final class SessionsSamplingRate extends ConfigurationFlag<Float> {
        private static SessionsSamplingRate instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.SessionSamplingRate";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "sessions_sampling_percentage";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_vc_session_sampling_rate";
        }

        private SessionsSamplingRate() {
        }

        public static SessionsSamplingRate getInstance() {
            SessionsSamplingRate sessionsSamplingRate;
            synchronized (SessionsSamplingRate.class) {
                if (instance == null) {
                    instance = new SessionsSamplingRate();
                }
                sessionsSamplingRate = instance;
            }
            return sessionsSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Float getDefault() {
            return Float.valueOf(0.01f);
        }
    }

    /* loaded from: classes.dex */
    protected static final class LogSourceName extends ConfigurationFlag<String> {
        private static final Map<Long, String> LOG_SOURCE_MAP = Collections.unmodifiableMap(new HashMap<Long, String>() { // from class: com.google.firebase.perf.config.ConfigurationConstants.LogSourceName.1
            {
                put(461L, "FIREPERF_AUTOPUSH");
                put(462L, "FIREPERF");
                put(675L, "FIREPERF_INTERNAL_LOW");
                put(676L, "FIREPERF_INTERNAL_HIGH");
            }
        });
        private static LogSourceName instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.LogSourceName";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_log_source";
        }

        private LogSourceName() {
        }

        public static LogSourceName getInstance() {
            LogSourceName logSourceName;
            synchronized (LogSourceName.class) {
                if (instance == null) {
                    instance = new LogSourceName();
                }
                logSourceName = instance;
            }
            return logSourceName;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static String getLogSourceName(long j) {
            return LOG_SOURCE_MAP.get(Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static boolean isLogSourceKnown(long j) {
            return LOG_SOURCE_MAP.containsKey(Long.valueOf(j));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDefault() {
            return BuildConfig.TRANSPORT_LOG_SRC;
        }
    }

    /* loaded from: classes.dex */
    protected static final class FragmentSamplingRate extends ConfigurationFlag<Float> {
        private static FragmentSamplingRate instance;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getDeviceCacheFlag() {
            return "com.google.firebase.perf.FragmentSamplingRate";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getMetadataFlag() {
            return "fragment_sampling_percentage";
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final String getRemoteConfigFlag() {
            return "fpr_vc_fragment_sampling_rate";
        }

        private FragmentSamplingRate() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static FragmentSamplingRate getInstance() {
            FragmentSamplingRate fragmentSamplingRate;
            synchronized (FragmentSamplingRate.class) {
                if (instance == null) {
                    instance = new FragmentSamplingRate();
                }
                fragmentSamplingRate = instance;
            }
            return fragmentSamplingRate;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.firebase.perf.config.ConfigurationFlag
        public final Float getDefault() {
            return Float.valueOf(0.0f);
        }
    }
}
