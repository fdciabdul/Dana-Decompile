package com.google.zxing.datamatrix.encoder;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class C40Encoder implements Encoder {
    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public int getEncodingMode() {
        return 1;
    }

    @Override // com.google.zxing.datamatrix.encoder.Encoder
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, sb);
            int codewordCount = encoderContext.getCodewordCount() + ((sb.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (!encoderContext.hasMoreCharacters()) {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
                while (sb.length() % 3 == 1 && ((encodeChar <= 3 && dataCapacity != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb, sb2, encodeChar);
                }
            } else if (sb.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        handleEOD(encoderContext, sb);
    }

    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb2);
        encoderContext.resetSymbolInfo();
        return encodeChar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb) {
        encoderContext.writeCodewords(encodeToCodewords(sb, 0));
        sb.delete(0, 3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0067, code lost:
    
        if (r8.hasMoreCharacters() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0035, code lost:
    
        if (r8.hasMoreCharacters() != false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void handleEOD(com.google.zxing.datamatrix.encoder.EncoderContext r8, java.lang.StringBuilder r9) {
        /*
            r7 = this;
            int r0 = r9.length()
            r1 = 3
            int r0 = r0 / r1
            int r2 = r9.length()
            int r2 = r2 % r1
            int r3 = r8.getCodewordCount()
            r4 = 1
            int r0 = r0 << r4
            int r3 = r3 + r0
            r8.updateSymbolInfo(r3)
            com.google.zxing.datamatrix.encoder.SymbolInfo r0 = r8.getSymbolInfo()
            int r0 = r0.getDataCapacity()
            int r0 = r0 - r3
            r3 = 254(0xfe, float:3.56E-43)
            r5 = 0
            r6 = 2
            if (r2 != r6) goto L38
            r9.append(r5)
        L27:
            int r0 = r9.length()
            if (r0 < r1) goto L31
            writeNextTriplet(r8, r9)
            goto L27
        L31:
            boolean r9 = r8.hasMoreCharacters()
            if (r9 == 0) goto L6c
            goto L69
        L38:
            if (r0 != r4) goto L55
            if (r2 != r4) goto L55
        L3c:
            int r0 = r9.length()
            if (r0 < r1) goto L46
            writeNextTriplet(r8, r9)
            goto L3c
        L46:
            boolean r9 = r8.hasMoreCharacters()
            if (r9 == 0) goto L4f
            r8.writeCodeword(r3)
        L4f:
            int r9 = r8.pos
            int r9 = r9 - r4
            r8.pos = r9
            goto L6c
        L55:
            if (r2 != 0) goto L70
        L57:
            int r2 = r9.length()
            if (r2 < r1) goto L61
            writeNextTriplet(r8, r9)
            goto L57
        L61:
            if (r0 > 0) goto L69
            boolean r9 = r8.hasMoreCharacters()
            if (r9 == 0) goto L6c
        L69:
            r8.writeCodeword(r3)
        L6c:
            r8.signalEncoderChange(r5)
            return
        L70:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "Unexpected case. Please report!"
            r8.<init>(r9)
            goto L79
        L78:
            throw r8
        L79:
            goto L78
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.datamatrix.encoder.C40Encoder.handleEOD(com.google.zxing.datamatrix.encoder.EncoderContext, java.lang.StringBuilder):void");
    }

    int encodeChar(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append((char) 3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append((char) 0);
            sb.append(c);
            return 2;
        } else if (c >= '!' && c <= '/') {
            sb.append((char) 1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c >= ':' && c <= '@') {
            sb.append((char) 1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c >= '[' && c <= '_') {
            sb.append((char) 1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c >= '`' && c <= 127) {
            sb.append((char) 2);
            sb.append((char) (c - '`'));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return encodeChar((char) (c - 128), sb) + 2;
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i) {
        int charAt = (charSequence.charAt(i) * 1600) + (charSequence.charAt(i + 1) * '(') + charSequence.charAt(i + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
