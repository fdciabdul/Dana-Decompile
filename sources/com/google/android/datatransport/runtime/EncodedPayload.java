package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import java.util.Arrays;

/* loaded from: classes7.dex */
public final class EncodedPayload {
    private final byte[] bytes;
    private final Encoding encoding;

    public EncodedPayload(Encoding encoding, byte[] bArr) {
        if (encoding == null) {
            throw new NullPointerException("encoding is null");
        }
        if (bArr == null) {
            throw new NullPointerException("bytes is null");
        }
        this.encoding = encoding;
        this.bytes = bArr;
    }

    public final Encoding getEncoding() {
        return this.encoding;
    }

    public final byte[] getBytes() {
        return this.bytes;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EncodedPayload) {
            EncodedPayload encodedPayload = (EncodedPayload) obj;
            if (this.encoding.equals(encodedPayload.encoding)) {
                return Arrays.equals(this.bytes, encodedPayload.bytes);
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.encoding.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.bytes);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EncodedPayload{encoding=");
        sb.append(this.encoding);
        sb.append(", bytes=[...]}");
        return sb.toString();
    }
}
