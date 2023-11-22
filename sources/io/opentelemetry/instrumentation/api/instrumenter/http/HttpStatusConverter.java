package io.opentelemetry.instrumentation.api.instrumenter.http;

import io.opentelemetry.api.trace.StatusCode;

/* loaded from: classes6.dex */
enum HttpStatusConverter {
    SERVER { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpStatusConverter.1
        @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpStatusConverter
        final StatusCode statusFromHttpStatus(int i) {
            if (i >= 100 && i < 500) {
                return StatusCode.UNSET;
            }
            return StatusCode.ERROR;
        }
    },
    CLIENT { // from class: io.opentelemetry.instrumentation.api.instrumenter.http.HttpStatusConverter.2
        @Override // io.opentelemetry.instrumentation.api.instrumenter.http.HttpStatusConverter
        final StatusCode statusFromHttpStatus(int i) {
            if (i >= 100 && i < 400) {
                return StatusCode.UNSET;
            }
            return StatusCode.ERROR;
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StatusCode statusFromHttpStatus(int i);
}
