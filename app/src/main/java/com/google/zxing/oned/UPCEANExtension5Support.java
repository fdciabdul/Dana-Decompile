package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class UPCEANExtension5Support {
    private static final int[] CHECK_DIGIT_ENCODINGS = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
    private final int[] decodeMiddleCounters = new int[4];
    private final StringBuilder decodeRowStringBuffer = new StringBuilder();

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Result decodeRow(int i, BitArray bitArray, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.decodeRowStringBuffer;
        sb.setLength(0);
        int decodeMiddle = decodeMiddle(bitArray, iArr, sb);
        String obj = sb.toString();
        Map<ResultMetadataType, Object> parseExtensionString = parseExtensionString(obj);
        float f = i;
        Result result = new Result(obj, null, new ResultPoint[]{new ResultPoint((iArr[0] + iArr[1]) / 2.0f, f), new ResultPoint(decodeMiddle, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (parseExtensionString != null) {
            result.putAllMetadata(parseExtensionString);
        }
        return result;
    }

    private int decodeMiddle(BitArray bitArray, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.decodeMiddleCounters;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int size = bitArray.getSize();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 5 && i < size; i3++) {
            int decodeDigit = UPCEANReader.decodeDigit(bitArray, iArr2, i, UPCEANReader.L_AND_G_PATTERNS);
            sb.append((char) ((decodeDigit % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (decodeDigit >= 10) {
                i2 |= 1 << (4 - i3);
            }
            if (i3 != 4) {
                i = bitArray.getNextUnset(bitArray.getNextSet(i));
            }
        }
        if (sb.length() != 5) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (extensionChecksum(sb.toString()) == determineCheckDigit(i2)) {
            return i;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int extensionChecksum(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 2; i2 >= 0; i2 -= 2) {
            i += charSequence.charAt(i2) - '0';
        }
        int i3 = i * 3;
        for (int i4 = length - 1; i4 >= 0; i4 -= 2) {
            i3 += charSequence.charAt(i4) - '0';
        }
        return (i3 * 3) % 10;
    }

    private static int determineCheckDigit(int i) throws NotFoundException {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == CHECK_DIGIT_ENCODINGS[i2]) {
                return i2;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> parseExtensionString(String str) {
        String parseExtension5String;
        if (str.length() == 5 && (parseExtension5String = parseExtension5String(str)) != null) {
            EnumMap enumMap = new EnumMap(ResultMetadataType.class);
            enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) parseExtension5String);
            return enumMap;
        }
        return null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0038, code lost:
    
        if (r4.equals("90000") != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String parseExtension5String(java.lang.String r4) {
        /*
            r0 = 0
            char r1 = r4.charAt(r0)
            r2 = 1
            r3 = 48
            if (r1 == r3) goto L51
            r3 = 53
            if (r1 == r3) goto L4e
            r3 = 57
            if (r1 != r3) goto L4b
            r4.hashCode()
            int r1 = r4.hashCode()
            r3 = 2
            switch(r1) {
                case 54118329: goto L32;
                case 54395376: goto L28;
                case 54395377: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L3b
        L1e:
            java.lang.String r0 = "99991"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L3b
            r0 = 2
            goto L3c
        L28:
            java.lang.String r0 = "99990"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L3b
            r0 = 1
            goto L3c
        L32:
            java.lang.String r1 = "90000"
            boolean r1 = r4.equals(r1)
            if (r1 == 0) goto L3b
            goto L3c
        L3b:
            r0 = -1
        L3c:
            if (r0 == 0) goto L49
            if (r0 == r2) goto L46
            if (r0 == r3) goto L43
            goto L4b
        L43:
            java.lang.String r4 = "0.00"
            return r4
        L46:
            java.lang.String r4 = "Used"
            return r4
        L49:
            r4 = 0
            return r4
        L4b:
            java.lang.String r0 = ""
            goto L54
        L4e:
            java.lang.String r0 = "$"
            goto L54
        L51:
            java.lang.String r0 = "£"
        L54:
            java.lang.String r4 = r4.substring(r2)
            int r4 = java.lang.Integer.parseInt(r4)
            int r1 = r4 / 100
            int r4 = r4 % 100
            r2 = 10
            if (r4 >= r2) goto L6f
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r2 = "0"
            java.lang.String r4 = r2.concat(r4)
            goto L73
        L6f:
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L73:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = java.lang.String.valueOf(r1)
            r2.append(r0)
            r0 = 46
            r2.append(r0)
            r2.append(r4)
            java.lang.String r4 = r2.toString()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.UPCEANExtension5Support.parseExtension5String(java.lang.String):java.lang.String");
    }
}
