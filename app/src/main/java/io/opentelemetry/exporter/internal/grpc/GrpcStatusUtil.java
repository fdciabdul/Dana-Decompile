package io.opentelemetry.exporter.internal.grpc;

import io.opentelemetry.exporter.internal.marshal.CodedInputStream;
import java.io.IOException;

/* loaded from: classes9.dex */
public final class GrpcStatusUtil {
    public static final String GRPC_STATUS_ABORTED = "10";
    public static final String GRPC_STATUS_CANCELLED = "1";
    public static final String GRPC_STATUS_DATA_LOSS = "15";
    public static final String GRPC_STATUS_DEADLINE_EXCEEDED = "4";
    public static final String GRPC_STATUS_OUT_OF_RANGE = "11";
    public static final String GRPC_STATUS_RESOURCE_EXHAUSTED = "8";
    public static final String GRPC_STATUS_UNAVAILABLE = "14";
    public static final String GRPC_STATUS_UNIMPLEMENTED = "12";

    public static String getStatusMessage(byte[] bArr) throws IOException {
        CodedInputStream newInstance = CodedInputStream.newInstance(bArr);
        boolean z = false;
        while (!z) {
            int readTag = newInstance.readTag();
            if (readTag == 0) {
                z = true;
            } else if (readTag == 18) {
                return newInstance.readStringRequireUtf8();
            } else {
                newInstance.skipField(readTag);
            }
        }
        return "";
    }

    private GrpcStatusUtil() {
    }
}
