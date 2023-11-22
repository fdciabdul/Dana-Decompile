package io.split.android.client.service.sseclient.notifications;

import android.util.Base64;
import io.split.android.client.utils.MurmurHash3;
import io.split.android.client.utils.StringHelper;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class MySegmentsPayloadDecoder {
    public String hashUserKeyForMySegmentsV1(String str) {
        try {
            return Base64.encodeToString(String.valueOf(MurmurHash3.murmurhash3_x86_32(str, 0, str.length(), 0)).getBytes(StringHelper.defaultCharset()), 2);
        } catch (Exception unused) {
            Logger.e("An error occurred when encoding matching key");
            return "";
        }
    }
}
