package okhttp3.internal.tls;

import id.dana.cashier.view.InputCardNumberView;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes9.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;
    private final String dn;
    private int end;
    private final int length;
    private int pos;

    DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.dn = name;
        this.length = name.length();
    }

    private String nextAT() {
        int i;
        int i2;
        int i3;
        int i4;
        char c;
        int i5;
        int i6;
        char c2;
        char c3;
        while (true) {
            i = this.pos;
            i2 = this.length;
            if (i >= i2 || this.chars[i] != ' ') {
                break;
            }
            this.pos = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.beg = i;
        this.pos = i + 1;
        while (true) {
            i3 = this.pos;
            i4 = this.length;
            if (i3 >= i4 || (c3 = this.chars[i3]) == '=' || c3 == ' ') {
                break;
            }
            this.pos = i3 + 1;
        }
        if (i3 >= i4) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected end of DN: ");
            sb.append(this.dn);
            throw new IllegalStateException(sb.toString());
        }
        this.end = i3;
        if (this.chars[i3] == ' ') {
            while (true) {
                i5 = this.pos;
                i6 = this.length;
                if (i5 >= i6 || (c2 = this.chars[i5]) == '=' || c2 != ' ') {
                    break;
                }
                this.pos = i5 + 1;
            }
            if (this.chars[i5] != '=' || i5 == i6) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unexpected end of DN: ");
                sb2.append(this.dn);
                throw new IllegalStateException(sb2.toString());
            }
        }
        this.pos++;
        while (true) {
            int i7 = this.pos;
            if (i7 >= this.length || this.chars[i7] != ' ') {
                break;
            }
            this.pos = i7 + 1;
        }
        int i8 = this.end;
        int i9 = this.beg;
        if (i8 - i9 > 4) {
            char[] cArr = this.chars;
            if (cArr[i9 + 3] == '.' && ((c = cArr[i9]) == 'O' || c == 'o')) {
                int i10 = i9 + 1;
                if (cArr[i10] == 'I' || cArr[i10] == 'i') {
                    int i11 = i9 + 2;
                    if (cArr[i11] == 'D' || cArr[i11] == 'd') {
                        this.beg = i9 + 4;
                    }
                }
            }
        }
        char[] cArr2 = this.chars;
        int i12 = this.beg;
        return new String(cArr2, i12, i8 - i12);
    }

    private String quotedAV() {
        int i = this.pos + 1;
        this.pos = i;
        this.beg = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 == this.length) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unexpected end of DN: ");
                sb.append(this.dn);
                throw new IllegalStateException(sb.toString());
            }
            char[] cArr = this.chars;
            char c = cArr[i2];
            if (c == '\"') {
                this.pos = i2 + 1;
                while (true) {
                    int i3 = this.pos;
                    if (i3 >= this.length || this.chars[i3] != ' ') {
                        break;
                    }
                    this.pos = i3 + 1;
                }
                char[] cArr2 = this.chars;
                int i4 = this.beg;
                return new String(cArr2, i4, this.end - i4);
            }
            if (c == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = c;
            }
            this.pos++;
            this.end++;
        }
    }

    private String hexAV() {
        int i;
        char[] cArr;
        char c;
        int i2 = this.pos;
        if (i2 + 4 >= this.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected end of DN: ");
            sb.append(this.dn);
            throw new IllegalStateException(sb.toString());
        }
        this.beg = i2;
        this.pos = i2 + 1;
        while (true) {
            i = this.pos;
            if (i == this.length || (c = (cArr = this.chars)[i]) == '+' || c == ',' || c == ';') {
                break;
            } else if (c == ' ') {
                this.end = i;
                this.pos = i + 1;
                while (true) {
                    int i3 = this.pos;
                    if (i3 >= this.length || this.chars[i3] != ' ') {
                        break;
                    }
                    this.pos = i3 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i] = (char) (c + InputCardNumberView.DIVIDER);
                }
                this.pos = i + 1;
            }
        }
        this.end = i;
        int i4 = this.end;
        int i5 = this.beg;
        int i6 = i4 - i5;
        if (i6 < 5 || (i6 & 1) == 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Unexpected end of DN: ");
            sb2.append(this.dn);
            throw new IllegalStateException(sb2.toString());
        }
        int i7 = i6 / 2;
        byte[] bArr = new byte[i7];
        int i8 = i5 + 1;
        for (int i9 = 0; i9 < i7; i9++) {
            bArr[i9] = (byte) getByte(i8);
            i8 += 2;
        }
        return new String(this.chars, this.beg, i6);
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x009b, code lost:
    
        return new java.lang.String(r0, r1, r8.cur - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String escapedAV() {
        /*
            r8 = this;
            int r0 = r8.pos
            r8.beg = r0
            r8.end = r0
        L6:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 < r1) goto L19
            char[] r0 = r8.chars
            int r1 = r8.beg
            java.lang.String r2 = new java.lang.String
            int r3 = r8.end
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            return r2
        L19:
            char[] r1 = r8.chars
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r3 = r8.end
            int r4 = r3 + 1
            r8.end = r4
            r1[r3] = r2
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L3e:
            int r0 = r8.end
            int r2 = r0 + 1
            r8.end = r2
            char r2 = r8.getEscaped()
            r1[r0] = r2
            int r0 = r8.pos
            int r0 = r0 + 1
            r8.pos = r0
            goto L6
        L51:
            int r0 = r8.beg
            java.lang.String r2 = new java.lang.String
            int r3 = r8.end
            int r3 = r3 - r0
            r2.<init>(r1, r0, r3)
            return r2
        L5c:
            int r2 = r8.end
            r8.cur = r2
            int r0 = r0 + 1
            r8.pos = r0
            int r0 = r2 + 1
            r8.end = r0
            r1[r2] = r6
        L6a:
            int r0 = r8.pos
            int r1 = r8.length
            if (r0 >= r1) goto L83
            char[] r2 = r8.chars
            char r7 = r2[r0]
            if (r7 != r6) goto L83
            int r1 = r8.end
            int r7 = r1 + 1
            r8.end = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.pos = r0
            goto L6a
        L83:
            if (r0 == r1) goto L8f
            char[] r1 = r8.chars
            char r0 = r1[r0]
            if (r0 == r3) goto L8f
            if (r0 == r4) goto L8f
            if (r0 != r5) goto L6
        L8f:
            char[] r0 = r8.chars
            int r1 = r8.beg
            java.lang.String r2 = new java.lang.String
            int r3 = r8.cur
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.tls.DistinguishedNameParser.escapedAV():java.lang.String");
    }

    private char getEscaped() {
        int i = this.pos + 1;
        this.pos = i;
        if (i == this.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Unexpected end of DN: ");
            sb.append(this.dn);
            throw new IllegalStateException(sb.toString());
        }
        char c = this.chars[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return getUTF8();
                }
        }
    }

    private char getUTF8() {
        int i;
        int i2;
        int i3 = getByte(this.pos);
        this.pos++;
        if (i3 < 128) {
            return (char) i3;
        }
        if (i3 < 192 || i3 > 247) {
            return '?';
        }
        if (i3 <= 223) {
            i2 = i3 & 31;
            i = 1;
        } else if (i3 <= 239) {
            i = 2;
            i2 = i3 & 15;
        } else {
            i = 3;
            i2 = i3 & 7;
        }
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = this.pos + 1;
            this.pos = i5;
            if (i5 == this.length || this.chars[i5] != '\\') {
                return '?';
            }
            int i6 = i5 + 1;
            this.pos = i6;
            int i7 = getByte(i6);
            this.pos++;
            if ((i7 & 192) != 128) {
                return '?';
            }
            i2 = (i2 << 6) + (i7 & 63);
        }
        return (char) i2;
    }

    private int getByte(int i) {
        int i2;
        int i3;
        int i4 = i + 1;
        if (i4 >= this.length) {
            StringBuilder sb = new StringBuilder();
            sb.append("Malformed DN: ");
            sb.append(this.dn);
            throw new IllegalStateException(sb.toString());
        }
        char[] cArr = this.chars;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else if (c < 'A' || c > 'F') {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Malformed DN: ");
            sb2.append(this.dn);
            throw new IllegalStateException(sb2.toString());
        } else {
            i2 = c - '7';
        }
        char c2 = cArr[i4];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Malformed DN: ");
            sb3.append(this.dn);
            throw new IllegalStateException(sb3.toString());
        } else {
            i3 = c2 - '7';
        }
        return (i2 << 4) + i3;
    }

    public final String findMostSpecific(String str) {
        String quotedAV;
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.dn.toCharArray();
        String nextAT = nextAT();
        if (nextAT == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.chars[i];
            if (c == '\"') {
                quotedAV = quotedAV();
            } else if (c == '#') {
                quotedAV = hexAV();
            } else {
                quotedAV = (c == '+' || c == ',' || c == ';') ? "" : escapedAV();
            }
            if (str.equalsIgnoreCase(nextAT)) {
                return quotedAV;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char c2 = this.chars[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                StringBuilder sb = new StringBuilder();
                sb.append("Malformed DN: ");
                sb.append(this.dn);
                throw new IllegalStateException(sb.toString());
            }
            this.pos = i2 + 1;
            nextAT = nextAT();
        } while (nextAT != null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Malformed DN: ");
        sb2.append(this.dn);
        throw new IllegalStateException(sb2.toString());
    }
}
