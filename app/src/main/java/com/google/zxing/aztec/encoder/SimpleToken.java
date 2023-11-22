package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import com.j256.ormlite.stmt.query.SimpleComparison;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleToken(Token token, int i, int i2) {
        super(token);
        this.value = (short) i;
        this.bitCount = (short) i2;
    }

    @Override // com.google.zxing.aztec.encoder.Token
    final void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public final String toString() {
        short s = this.value;
        short s2 = this.bitCount;
        StringBuilder sb = new StringBuilder(SimpleComparison.LESS_THAN_OPERATION);
        int i = 1 << s2;
        sb.append(Integer.toBinaryString((s & (i - 1)) | i | (1 << this.bitCount)).substring(1));
        sb.append(Typography.greater);
        return sb.toString();
    }
}
