package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

/* loaded from: classes3.dex */
public interface TelemetryLoggingClient extends HasApiKey<TelemetryLoggingOptions> {
    Task<Void> log(TelemetryData telemetryData);
}
