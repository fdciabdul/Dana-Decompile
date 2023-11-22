package io.opentelemetry.sdk.trace.data;

import io.opentelemetry.api.trace.StatusCode;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
public interface StatusData {
    String getDescription();

    StatusCode getStatusCode();

    /* renamed from: io.opentelemetry.sdk.trace.data.StatusData$-CC  reason: invalid class name */
    /* loaded from: classes6.dex */
    public final /* synthetic */ class CC {
        public static StatusData ok() {
            return ImmutableStatusData.OK;
        }

        public static StatusData unset() {
            return ImmutableStatusData.UNSET;
        }

        public static StatusData error() {
            return ImmutableStatusData.ERROR;
        }

        public static StatusData create(StatusCode statusCode, @Nullable String str) {
            if (str == null) {
                str = "";
            }
            return ImmutableStatusData.create(statusCode, str);
        }
    }
}
