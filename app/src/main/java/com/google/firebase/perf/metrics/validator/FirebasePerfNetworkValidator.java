package com.google.firebase.perf.metrics.validator;

import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.URLAllowlist;
import com.google.firebase.perf.v1.NetworkRequestMetric;
import java.net.URI;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class FirebasePerfNetworkValidator extends PerfMetricValidator {
    private static final int EMPTY_PORT = -1;
    private static final String HTTPS = "https";
    private static final String HTTP_SCHEMA = "http";
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final Context appContext;
    private final NetworkRequestMetric networkMetric;

    private boolean isValidHttpResponseCode(int i) {
        return i > 0;
    }

    private boolean isValidPayload(long j) {
        return j >= 0;
    }

    private boolean isValidPort(int i) {
        return i == -1 || i > 0;
    }

    private boolean isValidTime(long j) {
        return j >= 0;
    }

    private boolean isValidUserInfo(String str) {
        return str == null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebasePerfNetworkValidator(NetworkRequestMetric networkRequestMetric, Context context) {
        this.appContext = context;
        this.networkMetric = networkRequestMetric;
    }

    @Override // com.google.firebase.perf.metrics.validator.PerfMetricValidator
    public final boolean isValidPerfMetric() {
        if (isEmptyUrl(this.networkMetric.getUrl())) {
            AndroidLogger androidLogger = logger;
            StringBuilder sb = new StringBuilder();
            sb.append("URL is missing:");
            sb.append(this.networkMetric.getUrl());
            androidLogger.warn(sb.toString());
            return false;
        }
        URI resultUrl = getResultUrl(this.networkMetric.getUrl());
        if (resultUrl == null) {
            logger.warn("URL cannot be parsed");
            return false;
        } else if (!isAllowlisted(resultUrl, this.appContext)) {
            AndroidLogger androidLogger2 = logger;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("URL fails allowlist rule: ");
            sb2.append(resultUrl);
            androidLogger2.warn(sb2.toString());
            return false;
        } else if (!isValidHost(resultUrl.getHost())) {
            logger.warn("URL host is null or invalid");
            return false;
        } else if (!isValidScheme(resultUrl.getScheme())) {
            logger.warn("URL scheme is null or invalid");
            return false;
        } else if (!isValidUserInfo(resultUrl.getUserInfo())) {
            logger.warn("URL user info is null");
            return false;
        } else if (!isValidPort(resultUrl.getPort())) {
            logger.warn("URL port is less than or equal to 0");
            return false;
        } else {
            if (!isValidHttpMethod(this.networkMetric.hasHttpMethod() ? this.networkMetric.getHttpMethod() : null)) {
                AndroidLogger androidLogger3 = logger;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("HTTP Method is null or invalid: ");
                sb3.append(this.networkMetric.getHttpMethod());
                androidLogger3.warn(sb3.toString());
                return false;
            } else if (this.networkMetric.hasHttpResponseCode() && !isValidHttpResponseCode(this.networkMetric.getHttpResponseCode())) {
                AndroidLogger androidLogger4 = logger;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("HTTP ResponseCode is a negative value:");
                sb4.append(this.networkMetric.getHttpResponseCode());
                androidLogger4.warn(sb4.toString());
                return false;
            } else if (this.networkMetric.hasRequestPayloadBytes() && !isValidPayload(this.networkMetric.getRequestPayloadBytes())) {
                AndroidLogger androidLogger5 = logger;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("Request Payload is a negative value:");
                sb5.append(this.networkMetric.getRequestPayloadBytes());
                androidLogger5.warn(sb5.toString());
                return false;
            } else if (this.networkMetric.hasResponsePayloadBytes() && !isValidPayload(this.networkMetric.getResponsePayloadBytes())) {
                AndroidLogger androidLogger6 = logger;
                StringBuilder sb6 = new StringBuilder();
                sb6.append("Response Payload is a negative value:");
                sb6.append(this.networkMetric.getResponsePayloadBytes());
                androidLogger6.warn(sb6.toString());
                return false;
            } else if (!this.networkMetric.hasClientStartTimeUs() || this.networkMetric.getClientStartTimeUs() <= 0) {
                AndroidLogger androidLogger7 = logger;
                StringBuilder sb7 = new StringBuilder();
                sb7.append("Start time of the request is null, or zero, or a negative value:");
                sb7.append(this.networkMetric.getClientStartTimeUs());
                androidLogger7.warn(sb7.toString());
                return false;
            } else if (this.networkMetric.hasTimeToRequestCompletedUs() && !isValidTime(this.networkMetric.getTimeToRequestCompletedUs())) {
                AndroidLogger androidLogger8 = logger;
                StringBuilder sb8 = new StringBuilder();
                sb8.append("Time to complete the request is a negative value:");
                sb8.append(this.networkMetric.getTimeToRequestCompletedUs());
                androidLogger8.warn(sb8.toString());
                return false;
            } else if (this.networkMetric.hasTimeToResponseInitiatedUs() && !isValidTime(this.networkMetric.getTimeToResponseInitiatedUs())) {
                AndroidLogger androidLogger9 = logger;
                StringBuilder sb9 = new StringBuilder();
                sb9.append("Time from the start of the request to the start of the response is null or a negative value:");
                sb9.append(this.networkMetric.getTimeToResponseInitiatedUs());
                androidLogger9.warn(sb9.toString());
                return false;
            } else if (!this.networkMetric.hasTimeToResponseCompletedUs() || this.networkMetric.getTimeToResponseCompletedUs() <= 0) {
                AndroidLogger androidLogger10 = logger;
                StringBuilder sb10 = new StringBuilder();
                sb10.append("Time from the start of the request to the end of the response is null, negative or zero:");
                sb10.append(this.networkMetric.getTimeToResponseCompletedUs());
                androidLogger10.warn(sb10.toString());
                return false;
            } else if (this.networkMetric.hasHttpResponseCode()) {
                return true;
            } else {
                logger.warn("Did not receive a HTTP Response Code");
                return false;
            }
        }
    }

    private boolean isEmptyUrl(String str) {
        return isBlank(str);
    }

    private URI getResultUrl(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URI.create(str);
        } catch (IllegalArgumentException | IllegalStateException e) {
            logger.warn("getResultUrl throws exception %s", e.getMessage());
            return null;
        }
    }

    private boolean isAllowlisted(URI uri, Context context) {
        if (uri == null) {
            return false;
        }
        return URLAllowlist.isURLAllowlisted(uri, context);
    }

    private boolean isValidHost(String str) {
        return (str == null || isBlank(str) || str.length() > 255) ? false : true;
    }

    private boolean isValidScheme(String str) {
        if (str == null) {
            return false;
        }
        return "http".equalsIgnoreCase(str) || "https".equalsIgnoreCase(str);
    }

    final boolean isValidHttpMethod(NetworkRequestMetric.HttpMethod httpMethod) {
        return (httpMethod == null || httpMethod == NetworkRequestMetric.HttpMethod.HTTP_METHOD_UNKNOWN) ? false : true;
    }

    private boolean isBlank(String str) {
        if (str == null) {
            return true;
        }
        return str.trim().isEmpty();
    }
}
