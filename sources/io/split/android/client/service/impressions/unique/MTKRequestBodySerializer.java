package io.split.android.client.service.impressions.unique;

import io.split.android.client.service.http.HttpRequestBodySerializer;
import io.split.android.client.utils.Json;

/* loaded from: classes6.dex */
public class MTKRequestBodySerializer implements HttpRequestBodySerializer<MTK> {
    @Override // io.split.android.client.service.http.HttpRequestBodySerializer
    public String serialize(MTK mtk) {
        return Json.toJson(mtk);
    }
}
