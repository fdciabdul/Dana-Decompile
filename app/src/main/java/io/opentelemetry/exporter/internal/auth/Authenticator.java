package io.opentelemetry.exporter.internal.auth;

import io.opentelemetry.exporter.internal.grpc.GrpcExporterBuilder;
import io.opentelemetry.exporter.internal.okhttp.OkHttpExporterBuilder;
import java.lang.reflect.Field;
import java.util.Map;

/* loaded from: classes9.dex */
public interface Authenticator {
    Map<String, String> getHeaders();

    /* renamed from: io.opentelemetry.exporter.internal.auth.Authenticator$-CC  reason: invalid class name */
    /* loaded from: classes9.dex */
    public final /* synthetic */ class CC {
        public static void setAuthenticatorOnDelegate(Object obj, Authenticator authenticator) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("delegate");
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (obj2 instanceof GrpcExporterBuilder) {
                    throw new IllegalArgumentException("GrpcExporterBuilder not supported yet.");
                }
                if (obj2 instanceof OkHttpExporterBuilder) {
                    ((OkHttpExporterBuilder) obj2).setAuthenticator(authenticator);
                    return;
                }
                throw new IllegalArgumentException("Delegate field is not type DefaultGrpcExporterBuilder or OkHttpGrpcExporterBuilder.");
            } catch (IllegalAccessException | NoSuchFieldException e) {
                throw new IllegalArgumentException("Unable to access delegate reflectively.", e);
            }
        }
    }
}
