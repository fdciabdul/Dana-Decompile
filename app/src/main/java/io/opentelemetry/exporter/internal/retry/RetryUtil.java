package io.opentelemetry.exporter.internal.retry;

import com.alibaba.wireless.security.SecExceptionCode;
import id.dana.data.here.HereOauthManager;
import io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder;
import io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes9.dex */
public class RetryUtil {
    private static final Set<String> RETRYABLE_GRPC_STATUS_CODES;
    private static final Set<Integer> RETRYABLE_HTTP_STATUS_CODES = Collections.unmodifiableSet(new HashSet(Arrays.asList(Integer.valueOf((int) HereOauthManager.TOO_MANY_REQUEST_CODE), 502, 503, Integer.valueOf((int) SecExceptionCode.SEC_ERROR_DYN_STORE_GET_DATA_FILE_KEY_FAILED))));

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("1");
        hashSet.add("4");
        hashSet.add("8");
        hashSet.add("10");
        hashSet.add("11");
        hashSet.add("14");
        hashSet.add("15");
        RETRYABLE_GRPC_STATUS_CODES = Collections.unmodifiableSet(hashSet);
    }

    private RetryUtil() {
    }

    public static Set<String> retryableGrpcStatusCodes() {
        return RETRYABLE_GRPC_STATUS_CODES;
    }

    public static Set<Integer> retryableHttpResponseCodes() {
        return RETRYABLE_HTTP_STATUS_CODES;
    }

    public static void setRetryPolicyOnDelegate(Object obj, RetryPolicy retryPolicy) {
        try {
            Field declaredField = obj.getClass().getDeclaredField("delegate");
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 instanceof GrpcExporterBuilder) {
                ((GrpcExporterBuilder) obj2).setRetryPolicy(retryPolicy);
            } else if (obj2 instanceof OkHttpExporterBuilder) {
                ((OkHttpExporterBuilder) obj2).setRetryPolicy(retryPolicy);
            } else {
                throw new IllegalArgumentException("delegate field is not type DefaultGrpcExporterBuilder or OkHttpGrpcExporterBuilder");
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            throw new IllegalArgumentException("Unable to access delegate reflectively.", e);
        }
    }
}
