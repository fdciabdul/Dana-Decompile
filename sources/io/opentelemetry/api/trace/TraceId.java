package io.opentelemetry.api.trace;

import io.opentelemetry.api.internal.OtelEncodingUtils;
import io.opentelemetry.api.internal.TemporaryBuffers;
import io.opentelemetry.api.internal.ValidationUtil;

/* loaded from: classes.dex */
public final class TraceId {
    private static final int BYTES_LENGTH = 16;
    private static final int HEX_LENGTH = 32;
    private static final String INVALID = "00000000000000000000000000000000";

    public static String getInvalid() {
        return INVALID;
    }

    public static int getLength() {
        return 32;
    }

    private TraceId() {
    }

    public static boolean isValid(CharSequence charSequence) {
        return charSequence != null && charSequence.length() == 32 && !INVALID.contentEquals(charSequence) && OtelEncodingUtils.isValidBase16String(charSequence);
    }

    public static String fromBytes(byte[] bArr) {
        if (bArr == null || bArr.length < 16) {
            ValidationUtil.log("traceIdBytes is null or too short");
            return INVALID;
        }
        char[] chars = TemporaryBuffers.chars(32);
        OtelEncodingUtils.bytesToBase16(bArr, chars, 16);
        return new String(chars, 0, 32);
    }

    public static String fromLongs(long j, long j2) {
        if (j == 0 && j2 == 0) {
            return getInvalid();
        }
        char[] chars = TemporaryBuffers.chars(32);
        OtelEncodingUtils.longToBase16String(j, chars, 0);
        OtelEncodingUtils.longToBase16String(j2, chars, 16);
        return new String(chars, 0, 32);
    }
}
