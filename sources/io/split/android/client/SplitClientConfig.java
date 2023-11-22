package io.split.android.client;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.network.DevelopmentSslConfig;
import io.split.android.client.network.HttpProxy;
import io.split.android.client.service.impressions.ImpressionsMode;
import io.split.android.client.shared.UserConsent;
import io.split.android.client.telemetry.TelemetryHelperImpl;
import io.split.android.client.utils.logger.Logger;
import java.net.URI;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Authenticator;

/* loaded from: classes6.dex */
public class SplitClientConfig {
    private static final int DEFAULT_BACKGROUND_SYNC_PERIOD_MINUTES = 15;
    private static final int DEFAULT_CONNECTION_TIMEOUT_SECS = 10000;
    private static final String DEFAULT_DATA_FOLDER = "split_data";
    private static final int DEFAULT_EVENTS_FLUSH_INTERVAL = 1800;
    private static final int DEFAULT_EVENTS_PER_PUSH = 2000;
    private static final int DEFAULT_EVENTS_QUEUE_SIZE = 10000;
    private static final int DEFAULT_FEATURES_REFRESH_RATE_SECS = 3600;
    private static final int DEFAULT_IMPRESSIONS_CHUNK_SIZE = 2048;
    private static final int DEFAULT_IMPRESSIONS_PER_PUSH = 2000;
    private static final int DEFAULT_IMPRESSIONS_QUEUE_SIZE = 30000;
    private static final int DEFAULT_IMPRESSIONS_REFRESH_RATE_SECS = 1800;
    private static final int DEFAULT_IMP_COUNTERS_REFRESH_RATE_SECS = 1800;
    private static final int DEFAULT_MTK_PER_PUSH = 30000;
    private static final int DEFAULT_READY = -1;
    private static final int DEFAULT_READ_TIMEOUT_SECS = 10000;
    private static final int DEFAULT_SEGMENTS_REFRESH_RATE_SECS = 1800;
    private static final int MAXIMUM_KEY_LENGTH = 250;
    private static final int MIN_CONNECTION_TIMEOUT = 0;
    private static final int MIN_FEATURES_REFRESH_RATE = 30;
    private static final int MIN_IMPRESSIONS_CHUNK_SIZE = 0;
    private static final int MIN_IMPRESSIONS_QUEUE_SIZE = 0;
    private static final int MIN_IMPRESSIONS_REFRESH_RATE = 30;
    private static final int MIN_MY_SEGMENTS_REFRESH_RATE = 30;
    private static final int MIN_READ_TIMEOUT = 0;
    private static final long SPLITS_CACHE_EXPIRATION_IN_SECONDS = 864000;
    private static final String TRACK_EVENT_NAME_PATTERN = "^[a-zA-Z0-9][-_.:a-zA-Z0-9]{0,79}$";
    public static String splitSdkVersion;
    private final String mAuthServiceUrl;
    private final long mBackgroundSyncPeriod;
    private final boolean mBackgroundSyncWhenBatteryNotLow;
    private final boolean mBackgroundSyncWhenWifiOnly;
    private final int mConnectionTimeout;
    private final long mDefaultSSEConnectionDelayInSecs;
    private final DevelopmentSslConfig mDevelopmentSslConfig;
    private boolean mEncryptionEnabled;
    private final String mEndpoint;
    private final long mEventFlushInterval;
    private final String mEventsEndpoint;
    private final int mEventsPerPush;
    private final int mEventsQueueSize;
    private final int mFeaturesRefreshRate;
    private final String mHostname;
    private final int mImpCountersRefreshRate;
    private final ImpressionListener mImpressionListener;
    private final long mImpressionsChunkSize;
    private final ImpressionsMode mImpressionsMode;
    private final int mImpressionsPerPush;
    private final int mImpressionsQueueSize;
    private final int mImpressionsRefreshRate;
    private final String mIp;
    private final boolean mIsPersistentAttributesEnabled;
    private final boolean mLabelsEnabled;
    private final boolean mLlegacyStorageMigrationEnabled;
    private int mLogLevel;
    private final int mMtkPerPush;
    private final int mMtkRefreshRate;
    private final int mOfflineRefreshRate;
    private final HttpProxy mProxy;
    private final Authenticator mProxyAuthenticator;
    private final int mReadTimeout;
    private final int mReady;
    private final long mSSEDisconnectionDelayInSecs;
    private final int mSegmentsRefreshRate;
    private boolean mShouldRecordTelemetry;
    private final boolean mStreamingEnabled;
    private final String mStreamingServiceUrl;
    private final SyncConfig mSyncConfig;
    private boolean mSyncEnabled;
    private final boolean mSynchronizeInBackground;
    private final String mTelemetryEndpoint;
    private final long mTelemetryRefreshRate;
    private final String mTrafficType;
    private UserConsent mUserConsent;

    public long cacheExpirationInSeconds() {
        return 864000L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String defaultDataFolder() {
        return DEFAULT_DATA_FOLDER;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int maximumKeyLength() {
        return 250;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String trackEventNamePattern() {
        return TRACK_EVENT_NAME_PATTERN;
    }

    public static Builder builder() {
        return new Builder();
    }

    private SplitClientConfig(String str, String str2, int i, int i2, int i3, int i4, long j, int i5, int i6, int i7, int i8, boolean z, ImpressionListener impressionListener, String str3, String str4, HttpProxy httpProxy, Authenticator authenticator, int i9, int i10, long j2, String str5, boolean z2, long j3, boolean z3, boolean z4, boolean z5, String str6, String str7, DevelopmentSslConfig developmentSslConfig, SyncConfig syncConfig, boolean z6, ImpressionsMode impressionsMode, int i11, boolean z7, int i12, String str8, long j4, boolean z8, boolean z9, int i13, int i14, int i15, UserConsent userConsent, boolean z10, long j5, long j6) {
        this.mEndpoint = str;
        this.mEventsEndpoint = str2;
        this.mTelemetryEndpoint = str8;
        this.mFeaturesRefreshRate = i;
        this.mSegmentsRefreshRate = i2;
        this.mImpressionsRefreshRate = i3;
        this.mImpressionsQueueSize = i4;
        this.mImpressionsPerPush = i5;
        this.mImpCountersRefreshRate = i11;
        this.mMtkRefreshRate = i15;
        this.mConnectionTimeout = i6;
        this.mReadTimeout = i7;
        this.mReady = i8;
        this.mLabelsEnabled = z;
        this.mImpressionListener = impressionListener;
        this.mImpressionsChunkSize = j;
        this.mHostname = str3;
        this.mIp = str4;
        this.mProxy = httpProxy;
        this.mProxyAuthenticator = authenticator;
        this.mEventsQueueSize = i9;
        this.mEventsPerPush = i10;
        this.mEventFlushInterval = j2;
        this.mTrafficType = str5;
        this.mSynchronizeInBackground = z2;
        this.mBackgroundSyncPeriod = j3;
        this.mBackgroundSyncWhenBatteryNotLow = z3;
        this.mBackgroundSyncWhenWifiOnly = z4;
        this.mStreamingEnabled = z5;
        this.mAuthServiceUrl = str6;
        this.mStreamingServiceUrl = str7;
        this.mDevelopmentSslConfig = developmentSslConfig;
        this.mSyncConfig = syncConfig;
        this.mLlegacyStorageMigrationEnabled = z6;
        this.mImpressionsMode = impressionsMode;
        this.mIsPersistentAttributesEnabled = z7;
        this.mOfflineRefreshRate = i12;
        this.mTelemetryRefreshRate = j4;
        this.mSyncEnabled = z9;
        this.mLogLevel = i13;
        this.mUserConsent = userConsent;
        splitSdkVersion = "Android-3.3.0";
        this.mShouldRecordTelemetry = z8;
        this.mMtkPerPush = i14;
        this.mEncryptionEnabled = z10;
        this.mDefaultSSEConnectionDelayInSecs = j5;
        this.mSSEDisconnectionDelayInSecs = j6;
        Logger.instance().setLevel(this.mLogLevel);
    }

    public String trafficType() {
        return this.mTrafficType;
    }

    public long eventFlushInterval() {
        return this.mEventFlushInterval;
    }

    public int eventsQueueSize() {
        return this.mEventsQueueSize;
    }

    public int eventsPerPush() {
        return this.mEventsPerPush;
    }

    public String endpoint() {
        return this.mEndpoint;
    }

    public String eventsEndpoint() {
        return this.mEventsEndpoint;
    }

    public String telemetryEndpoint() {
        return this.mTelemetryEndpoint;
    }

    public int featuresRefreshRate() {
        return this.mFeaturesRefreshRate;
    }

    public int segmentsRefreshRate() {
        return this.mSegmentsRefreshRate;
    }

    public int impressionsRefreshRate() {
        return this.mImpressionsRefreshRate;
    }

    public int impressionsQueueSize() {
        return this.mImpressionsQueueSize;
    }

    public long impressionsChunkSize() {
        return this.mImpressionsChunkSize;
    }

    public int impressionsPerPush() {
        return this.mImpressionsPerPush;
    }

    public int connectionTimeout() {
        return this.mConnectionTimeout;
    }

    public int readTimeout() {
        return this.mReadTimeout;
    }

    public boolean labelsEnabled() {
        return this.mLabelsEnabled;
    }

    public int blockUntilReady() {
        return this.mReady;
    }

    public ImpressionListener impressionListener() {
        return this.mImpressionListener;
    }

    public HttpProxy proxy() {
        return this.mProxy;
    }

    public Authenticator proxyAuthenticator() {
        return this.mProxyAuthenticator;
    }

    public String hostname() {
        return this.mHostname;
    }

    public int logLevel() {
        return this.mLogLevel;
    }

    public String ip() {
        return this.mIp;
    }

    public boolean synchronizeInBackground() {
        return this.mSynchronizeInBackground;
    }

    public long backgroundSyncPeriod() {
        return this.mBackgroundSyncPeriod;
    }

    public boolean backgroundSyncWhenBatteryNotLow() {
        return this.mBackgroundSyncWhenBatteryNotLow;
    }

    public boolean backgroundSyncWhenBatteryWifiOnly() {
        return this.mBackgroundSyncWhenWifiOnly;
    }

    public boolean streamingEnabled() {
        return this.mStreamingEnabled;
    }

    public String authServiceUrl() {
        return this.mAuthServiceUrl;
    }

    public String streamingServiceUrl() {
        return this.mStreamingServiceUrl;
    }

    public Authenticator authenticator() {
        return this.mProxyAuthenticator;
    }

    public DevelopmentSslConfig developmentSslConfig() {
        return this.mDevelopmentSslConfig;
    }

    public SyncConfig syncConfig() {
        return this.mSyncConfig;
    }

    public boolean isStorageMigrationEnabled() {
        return this.mLlegacyStorageMigrationEnabled;
    }

    public ImpressionsMode impressionsMode() {
        return this.mImpressionsMode;
    }

    public int impressionsCounterRefreshRate() {
        return this.mImpCountersRefreshRate;
    }

    public boolean persistentAttributesEnabled() {
        return this.mIsPersistentAttributesEnabled;
    }

    public int offlineRefreshRate() {
        return this.mOfflineRefreshRate;
    }

    public boolean shouldRecordTelemetry() {
        return this.mShouldRecordTelemetry;
    }

    public long telemetryRefreshRate() {
        return this.mTelemetryRefreshRate;
    }

    public boolean syncEnabled() {
        return this.mSyncEnabled;
    }

    public int mtkPerPush() {
        return this.mMtkPerPush;
    }

    public int mtkRefreshRate() {
        return this.mMtkRefreshRate;
    }

    public UserConsent userConsent() {
        return this.mUserConsent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setUserConsent(UserConsent userConsent) {
        this.mUserConsent = userConsent;
    }

    public boolean encryptionEnabled() {
        return this.mEncryptionEnabled;
    }

    public long defaultSSEConnectionDelay() {
        return this.mDefaultSSEConnectionDelayInSecs;
    }

    public long sseDisconnectionDelay() {
        return this.mSSEDisconnectionDelayInSecs;
    }

    private void enableTelemetry() {
        this.mShouldRecordTelemetry = true;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {
        static final int DEFAULT_TELEMETRY_REFRESH_RATE = 3600;
        static final int OFFLINE_REFRESH_RATE_DEFAULT = -1;
        static final int PROXY_PORT_DEFAULT = 80;
        private DevelopmentSslConfig mDevelopmentSslConfig;
        private ImpressionListener mImpressionListener;
        private ServiceEndpoints mServiceEndpoints;
        private int mFeaturesRefreshRate = DEFAULT_TELEMETRY_REFRESH_RATE;
        private int mSegmentsRefreshRate = 1800;
        private int mImpressionsRefreshRate = 1800;
        private int mImpressionsQueueSize = 30000;
        private int mImpressionsPerPush = 2000;
        private int mImpCountersRefreshRate = 1800;
        private int mConnectionTimeout = 10000;
        private int mReadTimeout = 10000;
        private int mReady = -1;
        private boolean mLabelsEnabled = true;
        private long mImpressionsChunkSize = 2048;
        private boolean mIsPersistentAttributesEnabled = false;
        private int mEventsQueueSize = 10000;
        private long mEventFlushInterval = 1800;
        private int mEventsPerPush = 2000;
        private String mTrafficType = null;
        private String mHostname = "unknown";
        private String mIp = "unknown";
        private String mProxyHost = null;
        private Authenticator mProxyAuthenticator = null;
        private boolean mSynchronizeInBackground = false;
        private long mBackgroundSyncPeriod = 15;
        private boolean mBackgroundSyncWhenBatteryNotLow = true;
        private boolean mBackgroundSyncWhenWifiOnly = false;
        private boolean mStreamingEnabled = true;
        private SyncConfig mSyncConfig = SyncConfig.builder().build();
        private boolean mLegacyStorageMigrationEnabled = false;
        private ImpressionsMode mImpressionsMode = ImpressionsMode.OPTIMIZED;
        private int mOfflineRefreshRate = -1;
        private long mTelemetryRefreshRate = 3600;
        private boolean mSyncEnabled = true;
        private int mLogLevel = -100;
        private final int mMtkPerPush = 30000;
        private final int mMtkRefreshRate = SecExceptionCode.SEC_ERROR_UMID_VALID;
        private UserConsent mUserConsent = UserConsent.GRANTED;
        private boolean mEncryptionEnabled = false;
        private final long mDefaultSSEConnectionDelayInSecs = 60;
        private final long mSSEDisconnectionDelayInSecs = 60;

        public Builder() {
            this.mServiceEndpoints = null;
            this.mServiceEndpoints = ServiceEndpoints.builder().build();
        }

        public final Builder trafficType(String str) {
            this.mTrafficType = str;
            return this;
        }

        public final Builder eventsQueueSize(int i) {
            this.mEventsQueueSize = i;
            return this;
        }

        public final Builder eventsPerPush(int i) {
            this.mEventsPerPush = i;
            return this;
        }

        public final Builder eventFlushInterval(long j) {
            this.mEventFlushInterval = j;
            return this;
        }

        public final Builder featuresRefreshRate(int i) {
            this.mFeaturesRefreshRate = i;
            return this;
        }

        public final Builder segmentsRefreshRate(int i) {
            this.mSegmentsRefreshRate = i;
            return this;
        }

        public final Builder impressionsRefreshRate(int i) {
            this.mImpressionsRefreshRate = i;
            return this;
        }

        public final Builder impressionsQueueSize(int i) {
            this.mImpressionsQueueSize = i;
            return this;
        }

        public final Builder impressionsPerPush(int i) {
            this.mImpressionsPerPush = i;
            return this;
        }

        public final Builder impressionListener(ImpressionListener impressionListener) {
            this.mImpressionListener = impressionListener;
            return this;
        }

        public final Builder connectionTimeout(int i) {
            this.mConnectionTimeout = i;
            return this;
        }

        public final Builder readTimeout(int i) {
            this.mReadTimeout = i;
            return this;
        }

        public final Builder logLevel(int i) {
            this.mLogLevel = i;
            return this;
        }

        public final Builder disableLabels() {
            this.mLabelsEnabled = false;
            return this;
        }

        public final Builder ready(int i) {
            this.mReady = i;
            return this;
        }

        public final Builder proxyHost(String str) {
            if (str != null && str.endsWith("/")) {
                this.mProxyHost = str.substring(0, str.length() - 1);
            } else {
                this.mProxyHost = str;
            }
            return this;
        }

        public final Builder proxyAuthenticator(Authenticator authenticator) {
            this.mProxyAuthenticator = authenticator;
            return this;
        }

        public final Builder impressionsChunkSize(long j) {
            this.mImpressionsChunkSize = j;
            return this;
        }

        public final Builder hostname(String str) {
            this.mHostname = str;
            return this;
        }

        public final Builder ip(String str) {
            this.mIp = str;
            return this;
        }

        public final Builder synchronizeInBackground(boolean z) {
            this.mSynchronizeInBackground = z;
            return this;
        }

        public final Builder synchronizeInBackgroundPeriod(long j) {
            this.mBackgroundSyncPeriod = j;
            return this;
        }

        public final Builder backgroundSyncWhenBatteryNotLow(boolean z) {
            this.mBackgroundSyncWhenBatteryNotLow = z;
            return this;
        }

        public final Builder backgroundSyncWhenWifiOnly(boolean z) {
            this.mBackgroundSyncWhenWifiOnly = z;
            return this;
        }

        public final Builder streamingEnabled(boolean z) {
            this.mStreamingEnabled = z;
            return this;
        }

        public final Builder serviceEndpoints(ServiceEndpoints serviceEndpoints) {
            this.mServiceEndpoints = serviceEndpoints;
            return this;
        }

        public final Builder developmentSslConfig(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, HostnameVerifier hostnameVerifier) {
            this.mDevelopmentSslConfig = new DevelopmentSslConfig((SSLSocketFactory) Preconditions.checkNotNull(sSLSocketFactory), (X509TrustManager) Preconditions.checkNotNull(x509TrustManager), (HostnameVerifier) Preconditions.checkNotNull(hostnameVerifier));
            return this;
        }

        public final Builder syncConfig(SyncConfig syncConfig) {
            this.mSyncConfig = syncConfig;
            return this;
        }

        public final Builder legacyStorageMigrationEnabled(boolean z) {
            this.mLegacyStorageMigrationEnabled = z;
            return this;
        }

        public final Builder impressionsMode(ImpressionsMode impressionsMode) {
            this.mImpressionsMode = impressionsMode;
            return this;
        }

        public final Builder impressionsMode(String str) {
            this.mImpressionsMode = ImpressionsMode.fromString(str);
            return this;
        }

        public final Builder persistentAttributesEnabled(boolean z) {
            this.mIsPersistentAttributesEnabled = z;
            return this;
        }

        public final Builder offlineRefreshRate(int i) {
            this.mOfflineRefreshRate = i;
            return this;
        }

        public final Builder telemetryRefreshRate(long j) {
            this.mTelemetryRefreshRate = j;
            return this;
        }

        public final Builder syncEnabled(boolean z) {
            this.mSyncEnabled = z;
            return this;
        }

        public final Builder userConsent(UserConsent userConsent) {
            this.mUserConsent = userConsent;
            StringBuilder sb = new StringBuilder();
            sb.append("User consent has been set to ");
            sb.append(userConsent.toString());
            Logger.v(sb.toString());
            return this;
        }

        public final Builder encryptionEnabled(boolean z) {
            this.mEncryptionEnabled = z;
            return this;
        }

        public final SplitClientConfig build() {
            if (this.mFeaturesRefreshRate < 30) {
                Logger.w("Features refresh rate is lower than allowed. Setting to default value.");
                this.mFeaturesRefreshRate = DEFAULT_TELEMETRY_REFRESH_RATE;
            }
            if (this.mSegmentsRefreshRate < 30) {
                Logger.w("Segments refresh rate is lower than allowed. Setting to default value.");
                this.mSegmentsRefreshRate = 1800;
            }
            if (this.mImpressionsRefreshRate < 30) {
                Logger.w("Impressions refresh rate is lower than allowed. Setting to default value.");
                this.mImpressionsRefreshRate = 1800;
            }
            if (this.mImpressionsQueueSize <= 0) {
                Logger.w("Impressions queue size is lower than allowed. Setting to default value.");
                this.mImpressionsQueueSize = 30000;
            }
            if (this.mImpressionsChunkSize <= 0) {
                Logger.w("Impressions chunk size is lower than allowed. Setting to default value.");
                this.mImpressionsChunkSize = 2048L;
            }
            if (this.mConnectionTimeout <= 0) {
                Logger.w("Connection timeout is lower than allowed. Setting to default value.");
                this.mConnectionTimeout = 10000;
            }
            if (this.mReadTimeout <= 0) {
                Logger.w("Read timeout is lower than allowed. Setting to default value.");
                this.mReadTimeout = 10000;
            }
            if (this.mBackgroundSyncPeriod < 15) {
                Logger.w("Background sync period is lower than allowed. Setting to default value.");
                this.mBackgroundSyncPeriod = 15L;
            }
            if (this.mTelemetryRefreshRate < 60) {
                Logger.w("Telemetry refresh rate is lower than allowed. Setting to default value.");
                this.mTelemetryRefreshRate = 3600L;
            }
            return new SplitClientConfig(this.mServiceEndpoints.getSdkEndpoint(), this.mServiceEndpoints.getEventsEndpoint(), this.mFeaturesRefreshRate, this.mSegmentsRefreshRate, this.mImpressionsRefreshRate, this.mImpressionsQueueSize, this.mImpressionsChunkSize, this.mImpressionsPerPush, this.mConnectionTimeout, this.mReadTimeout, this.mReady, this.mLabelsEnabled, this.mImpressionListener, this.mHostname, this.mIp, parseProxyHost(this.mProxyHost), this.mProxyAuthenticator, this.mEventsQueueSize, this.mEventsPerPush, this.mEventFlushInterval, this.mTrafficType, this.mSynchronizeInBackground, this.mBackgroundSyncPeriod, this.mBackgroundSyncWhenBatteryNotLow, this.mBackgroundSyncWhenWifiOnly, this.mStreamingEnabled, this.mServiceEndpoints.getAuthServiceEndpoint(), this.mServiceEndpoints.getStreamingServiceEndpoint(), this.mDevelopmentSslConfig, this.mSyncConfig, this.mLegacyStorageMigrationEnabled, this.mImpressionsMode, this.mImpCountersRefreshRate, this.mIsPersistentAttributesEnabled, this.mOfflineRefreshRate, this.mServiceEndpoints.getTelemetryEndpoint(), this.mTelemetryRefreshRate, new TelemetryHelperImpl().shouldRecordTelemetry(), this.mSyncEnabled, this.mLogLevel, 30000, SecExceptionCode.SEC_ERROR_UMID_VALID, this.mUserConsent, this.mEncryptionEnabled, 60L, 60L);
        }

        private HttpProxy parseProxyHost(String str) {
            String str2;
            String str3 = null;
            if (Strings.isNullOrEmpty(str)) {
                return null;
            }
            try {
                URI create = URI.create(str);
                int port = create.getPort() != -1 ? create.getPort() : 80;
                String userInfo = create.getUserInfo();
                if (!Strings.isNullOrEmpty(userInfo)) {
                    String[] split = userInfo.split(":");
                    if (split.length > 1) {
                        str3 = split[0];
                        str2 = split[1];
                        return new HttpProxy(String.format("%s%s", create.getHost(), create.getPath()), port, str3, str2);
                    }
                }
                str2 = null;
                return new HttpProxy(String.format("%s%s", create.getHost(), create.getPath()), port, str3, str2);
            } catch (IllegalArgumentException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Proxy URI not valid: ");
                sb.append(e.getLocalizedMessage());
                Logger.e(sb.toString());
                throw new IllegalArgumentException();
            } catch (Exception e2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unknown error while parsing proxy URI: ");
                sb2.append(e2.getLocalizedMessage());
                Logger.e(sb2.toString());
                throw new IllegalArgumentException();
            }
        }
    }
}
