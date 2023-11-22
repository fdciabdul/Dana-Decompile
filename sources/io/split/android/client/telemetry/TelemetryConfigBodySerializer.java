package io.split.android.client.telemetry;

import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.utils.Json;

/* loaded from: classes6.dex */
public class TelemetryConfigBodySerializer implements HttpRequestBodySerializer<Config> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(Config config) {
        return Json.toJsonIgnoringNulls(config);
    }
}
