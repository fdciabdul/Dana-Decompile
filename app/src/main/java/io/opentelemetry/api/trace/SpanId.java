package io.opentelemetry.api.trace;

import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.internal.TemporaryBuffers;
import io.opentelemetry.api.internal.ValidationUtil;

/* loaded from: classes6.dex */
public final class SpanId {
    private static final int BYTES_LENGTH = 8;
    private static final int HEX_LENGTH = 16;
    private static final String INVALID = "0000000000000000";

    public static String getInvalid() {
        return INVALID;
    }

    public static int getLength() {
        return 16;
    }

    private SpanId() {
    }

    public static boolean isValid(CharSequence charSequence) {
        return charSequence != null && charSequence.length() == 16 && !INVALID.contentEquals(charSequence) && OtelEncodingUtils.isValidBase16String(charSequence);
    }

    public static String fromBytes(byte[] bArr) {
        if (bArr == null || bArr.length < 8) {
            ValidationUtil.log("spanIdBytes is null or too short");
            return INVALID;
        }
        char[] chars = TemporaryBuffers.chars(16);
        OtelEncodingUtils.bytesToBase16(bArr, chars, 8);
        return new String(chars, 0, 16);
    }

    public static String fromLong(long j) {
        if (j == 0) {
            return getInvalid();
        }
        char[] chars = TemporaryBuffers.chars(16);
        OtelEncodingUtils.longToBase16String(j, chars, 0);
        return new String(chars, 0, 16);
    }
}
