package io.opentelemetry.exporter.internal.grpc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes9.dex */
final class GrpcExporterUtil {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void logUnimplemented(Logger logger, String str, @Nullable String str2) {
        char c;
        String str3;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == -1077545552) {
            if (str.equals("metric")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 107332) {
            if (hashCode == 3536714 && str.equals("span")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals("log")) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            str3 = "OTEL_METRICS_EXPORTER";
        } else if (c == 1) {
            str3 = "OTEL_LOGS_EXPORTER";
        } else if (c != 2) {
            throw new IllegalStateException("Unrecognized type, this is a programming bug in the OpenTelemetry SDK");
        } else {
            str3 = "OTEL_TRACES_EXPORTER";
        }
        Level level = Level.SEVERE;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to export ");
        sb.append(str);
        sb.append("s. Server responded with UNIMPLEMENTED. This usually means that your collector is not configured with an otlp receiver in the \"pipelines\" section of the configuration. If export is not desired and you are using OpenTelemetry autoconfiguration or the javaagent, disable export by setting ");
        sb.append(str3);
        sb.append("=none. Full error message: ");
        sb.append(str2);
        logger.log(level, sb.toString());
    }

    private GrpcExporterUtil() {
    }
}
