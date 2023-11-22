package com.google.firebase.perf.metrics;

import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.application.AppStateUpdateHandler;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.network.NetworkRequestMetricBuilderUtil;
import com.google.firebase.perf.session.PerfSession;
import com.google.firebase.perf.session.SessionAwareObject;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.session.gauges.GaugeManager;
import com.google.firebase.perf.transport.TransportManager;
import com.google.firebase.perf.util.Utils;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class NetworkRequestMetricBuilder extends AppStateUpdateHandler implements SessionAwareObject {
    private static final char HIGHEST_ASCII_CHAR = 127;
    private static final char HIGHEST_CONTROL_CHAR = 31;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final NetworkRequestMetric.Builder builder;
    private final GaugeManager gaugeManager;
    private boolean isManualNetworkRequestMetric;
    private boolean isReportSent;
    private final List<PerfSession> sessions;
    private final TransportManager transportManager;
    private String userAgent;
    private final WeakReference<SessionAwareObject> weakReference;

    @Override // com.google.firebase.perf.session.SessionAwareObject
    public final void updateSession(PerfSession perfSession) {
        if (perfSession == null) {
            logger.warn("Unable to add new SessionId to the Network Trace. Continuing without it.");
        } else if (!hasStarted() || isStopped()) {
        } else {
            this.sessions.add(perfSession);
        }
    }

    public static NetworkRequestMetricBuilder builder(TransportManager transportManager) {
        return new NetworkRequestMetricBuilder(transportManager);
    }

    private NetworkRequestMetricBuilder(TransportManager transportManager) {
        this(transportManager, AppStateMonitor.getInstance(), GaugeManager.getInstance());
    }

    public NetworkRequestMetricBuilder(TransportManager transportManager, AppStateMonitor appStateMonitor, GaugeManager gaugeManager) {
        super(appStateMonitor);
        this.builder = NetworkRequestMetric.newBuilder();
        this.weakReference = new WeakReference<>(this);
        this.transportManager = transportManager;
        this.gaugeManager = gaugeManager;
        this.sessions = Collections.synchronizedList(new ArrayList());
        registerForAppState();
    }

    public final void setManualNetworkRequestMetric() {
        this.isManualNetworkRequestMetric = true;
    }

    public final NetworkRequestMetricBuilder setUrl(String str) {
        if (str != null) {
            this.builder.setUrl(Utils.truncateURL(Utils.stripSensitiveInfo(str), 2000));
        }
        return this;
    }

    public final String getUrl() {
        return this.builder.getUrl();
    }

    public final NetworkRequestMetricBuilder setUserAgent(String str) {
        this.userAgent = str;
        return this;
    }

    public final NetworkRequestMetricBuilder setHttpMethod(String str) {
        NetworkRequestMetric.HttpMethod httpMethod;
        if (str != null) {
            NetworkRequestMetric.HttpMethod httpMethod2 = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
            String upperCase = str.toUpperCase();
            upperCase.hashCode();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case -531492226:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.OPTIONS)) {
                        c = 0;
                        break;
                    }
                    break;
                case 70454:
                    if (upperCase.equals("GET")) {
                        c = 1;
                        break;
                    }
                    break;
                case 79599:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.PUT)) {
                        c = 2;
                        break;
                    }
                    break;
                case 2213344:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.HEAD)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2461856:
                    if (upperCase.equals("POST")) {
                        c = 4;
                        break;
                    }
                    break;
                case 75900968:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.PATCH)) {
                        c = 5;
                        break;
                    }
                    break;
                case 80083237:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.TRACE)) {
                        c = 6;
                        break;
                    }
                    break;
                case 1669334218:
                    if (upperCase.equals(FirebasePerformance.HttpMethod.CONNECT)) {
                        c = 7;
                        break;
                    }
                    break;
                case 2012838315:
                    if (upperCase.equals("DELETE")) {
                        c = '\b';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    httpMethod = NetworkRequestMetric.HttpMethod.OPTIONS;
                    break;
                case 1:
                    httpMethod = NetworkRequestMetric.HttpMethod.GET;
                    break;
                case 2:
                    httpMethod = NetworkRequestMetric.HttpMethod.PUT;
                    break;
                case 3:
                    httpMethod = NetworkRequestMetric.HttpMethod.HEAD;
                    break;
                case 4:
                    httpMethod = NetworkRequestMetric.HttpMethod.POST;
                    break;
                case 5:
                    httpMethod = NetworkRequestMetric.HttpMethod.PATCH;
                    break;
                case 6:
                    httpMethod = NetworkRequestMetric.HttpMethod.TRACE;
                    break;
                case 7:
                    httpMethod = NetworkRequestMetric.HttpMethod.CONNECT;
                    break;
                case '\b':
                    httpMethod = NetworkRequestMetric.HttpMethod.DELETE;
                    break;
                default:
                    httpMethod = NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN;
                    break;
            }
            this.builder.setHttpMethod(httpMethod);
        }
        return this;
    }

    public final NetworkRequestMetricBuilder setHttpResponseCode(int i) {
        this.builder.setHttpResponseCode(i);
        return this;
    }

    public final boolean hasHttpResponseCode() {
        return this.builder.hasHttpResponseCode();
    }

    public final NetworkRequestMetricBuilder setRequestPayloadBytes(long j) {
        this.builder.setRequestPayloadBytes(j);
        return this;
    }

    public final NetworkRequestMetricBuilder setCustomAttributes(Map<String, String> map) {
        this.builder.clearCustomAttributes().putAllCustomAttributes(map);
        return this;
    }

    public final NetworkRequestMetricBuilder setRequestStartTimeMicros(long j) {
        PerfSession perfSession = SessionManager.getInstance().perfSession();
        SessionManager.getInstance().registerForSessionUpdates(this.weakReference);
        this.builder.setClientStartTimeUs(j);
        updateSession(perfSession);
        if (perfSession.isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(perfSession.getTimer());
        }
        return this;
    }

    public final NetworkRequestMetricBuilder setTimeToRequestCompletedMicros(long j) {
        this.builder.setTimeToRequestCompletedUs(j);
        return this;
    }

    public final NetworkRequestMetricBuilder setTimeToResponseInitiatedMicros(long j) {
        this.builder.setTimeToResponseInitiatedUs(j);
        return this;
    }

    public final long getTimeToResponseInitiatedMicros() {
        return this.builder.getTimeToResponseInitiatedUs();
    }

    public final NetworkRequestMetricBuilder setTimeToResponseCompletedMicros(long j) {
        this.builder.setTimeToResponseCompletedUs(j);
        if (SessionManager.getInstance().perfSession().isGaugeAndEventCollectionEnabled()) {
            this.gaugeManager.collectGaugeMetricOnce(SessionManager.getInstance().perfSession().getTimer());
        }
        return this;
    }

    public final NetworkRequestMetricBuilder setResponsePayloadBytes(long j) {
        this.builder.setResponsePayloadBytes(j);
        return this;
    }

    public final NetworkRequestMetricBuilder setResponseContentType(String str) {
        if (str == null) {
            this.builder.clearResponseContentType();
            return this;
        }
        if (isValidContentType(str)) {
            this.builder.setResponseContentType(str);
        } else {
            AndroidLogger androidLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("The content type of the response is not a valid content-type:");
            sb.append(str);
            androidLogger.warn(sb.toString());
        }
        return this;
    }

    public final NetworkRequestMetricBuilder setNetworkClientErrorReason() {
        this.builder.setNetworkClientErrorReason(NetworkRequestMetric.NetworkClientErrorReason.GENERIC_CLIENT_ERROR);
        return this;
    }

    public final NetworkRequestMetric build() {
        SessionManager.getInstance().unregisterForSessionUpdates(this.weakReference);
        unregisterForAppState();
        com.google.firebase.perf.v1.PerfSession[] buildAndSort = PerfSession.buildAndSort(getSessions());
        if (buildAndSort != null) {
            this.builder.addAllPerfSessions(Arrays.asList(buildAndSort));
        }
        NetworkRequestMetric build = this.builder.build();
        if (!NetworkRequestMetricBuilderUtil.isAllowedUserAgent(this.userAgent)) {
            logger.debug("Dropping network request from a 'User-Agent' that is not allowed");
            return build;
        } else if (!this.isReportSent) {
            this.transportManager.log(build, getAppState());
            this.isReportSent = true;
            return build;
        } else {
            if (this.isManualNetworkRequestMetric) {
                logger.debug("This metric has already been queued for transmission.  Please create a new HttpMetric for each request/response");
            }
            return build;
        }
    }

    private boolean isStopped() {
        return this.builder.hasTimeToResponseCompletedUs();
    }

    private boolean hasStarted() {
        return this.builder.hasClientStartTimeUs();
    }

    final List<PerfSession> getSessions() {
        List<PerfSession> unmodifiableList;
        synchronized (this.sessions) {
            ArrayList arrayList = new ArrayList();
            for (PerfSession perfSession : this.sessions) {
                if (perfSession != null) {
                    arrayList.add(perfSession);
                }
            }
            unmodifiableList = Collections.unmodifiableList(arrayList);
        }
        return unmodifiableList;
    }

    final boolean isReportSent() {
        return this.isReportSent;
    }

    final void setReportSent() {
        this.isReportSent = true;
    }

    final void clearBuilderFields() {
        this.builder.clear();
    }

    private static boolean isValidContentType(String str) {
        if (str.length() > 128) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt <= 31 || charAt > 127) {
                return false;
            }
        }
        return true;
    }
}
