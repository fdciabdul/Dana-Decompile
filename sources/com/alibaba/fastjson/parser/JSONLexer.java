package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.DesugarTimeZone;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class JSONLexer {
    public static final char[] CA;
    public static final int END = 4;
    public static final char EOI = 26;
    static final int[] IA;
    public static final int NOT_MATCH = -1;
    public static final int NOT_MATCH_NAME = -2;
    public static final int UNKNOWN = 0;
    private static boolean V6 = false;
    public static final int VALUE = 3;
    protected static final int[] digits;
    public static final boolean[] firstIdentifierFlags;
    public static final boolean[] identifierFlags;
    private static final ThreadLocal<char[]> sbufLocal;
    protected int bp;
    public Calendar calendar;
    protected char ch;
    public boolean disableCircularReferenceDetect;
    protected int eofPos;
    protected boolean exp;
    public int features;
    protected long fieldHash;
    protected boolean hasSpecial;
    protected boolean isDouble;
    protected final int len;
    public Locale locale;
    public int matchStat;
    protected int np;
    protected int pos;
    protected char[] sbuf;
    protected int sp;
    protected String stringDefaultValue;
    protected final String text;
    public TimeZone timeZone;
    protected int token;

    static boolean checkDate(char c, char c2, char c3, char c4, char c5, char c6, int i, int i2) {
        if (c >= '1' && c <= '3' && c2 >= '0' && c2 <= '9' && c3 >= '0' && c3 <= '9' && c4 >= '0' && c4 <= '9') {
            if (c5 == '0') {
                if (c6 < '1' || c6 > '9') {
                    return false;
                }
            } else if (c5 != '1' || (c6 != '0' && c6 != '1' && c6 != '2')) {
                return false;
            }
            if (i == 48) {
                return i2 >= 49 && i2 <= 57;
            } else if (i != 49 && i != 50) {
                return i == 51 && (i2 == 48 || i2 == 49);
            } else if (i2 >= 48 && i2 <= 57) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x001d, code lost:
    
        if (r5 <= '4') goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static boolean checkTime(char r4, char r5, char r6, char r7, char r8, char r9) {
        /*
            r0 = 57
            r1 = 0
            r2 = 48
            if (r4 != r2) goto Lc
            if (r5 < r2) goto Lb
            if (r5 <= r0) goto L1f
        Lb:
            return r1
        Lc:
            r3 = 49
            if (r4 != r3) goto L15
            if (r5 < r2) goto L14
            if (r5 <= r0) goto L1f
        L14:
            return r1
        L15:
            r3 = 50
            if (r4 != r3) goto L41
            if (r5 < r2) goto L41
            r4 = 52
            if (r5 > r4) goto L41
        L1f:
            r4 = 53
            r5 = 54
            if (r6 < r2) goto L2c
            if (r6 > r4) goto L2c
            if (r7 < r2) goto L2b
            if (r7 <= r0) goto L31
        L2b:
            return r1
        L2c:
            if (r6 != r5) goto L41
            if (r7 == r2) goto L31
            return r1
        L31:
            if (r8 < r2) goto L3a
            if (r8 > r4) goto L3a
            if (r9 < r2) goto L39
            if (r9 <= r0) goto L3f
        L39:
            return r1
        L3a:
            if (r8 != r5) goto L41
            if (r9 == r2) goto L3f
            return r1
        L3f:
            r4 = 1
            return r4
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.checkTime(char, char, char, char, char, char):boolean");
    }

    static {
        int i;
        try {
            i = Class.forName("android.os.Build$VERSION").getField("SDK_INT").getInt(null);
        } catch (Exception unused) {
            i = -1;
        }
        char c = 0;
        V6 = i >= 23;
        sbufLocal = new ThreadLocal<>();
        digits = new int[103];
        for (int i2 = 48; i2 <= 57; i2++) {
            digits[i2] = i2 - 48;
        }
        for (int i3 = 97; i3 <= 102; i3++) {
            digits[i3] = (i3 - 97) + 10;
        }
        for (int i4 = 65; i4 <= 70; i4++) {
            digits[i4] = (i4 - 65) + 10;
        }
        char[] charArray = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        CA = charArray;
        int[] iArr = new int[256];
        IA = iArr;
        Arrays.fill(iArr, -1);
        int length = charArray.length;
        for (int i5 = 0; i5 < length; i5++) {
            IA[CA[i5]] = i5;
        }
        IA[61] = 0;
        firstIdentifierFlags = new boolean[256];
        char c2 = 0;
        while (true) {
            boolean[] zArr = firstIdentifierFlags;
            if (c2 >= zArr.length) {
                break;
            }
            if (c2 >= 'A' && c2 <= 'Z') {
                zArr[c2] = true;
            } else if (c2 >= 'a' && c2 <= 'z') {
                zArr[c2] = true;
            } else if (c2 == '_') {
                zArr[c2] = true;
            }
            c2 = (char) (c2 + 1);
        }
        identifierFlags = new boolean[256];
        while (true) {
            boolean[] zArr2 = identifierFlags;
            if (c >= zArr2.length) {
                return;
            }
            if (c >= 'A' && c <= 'Z') {
                zArr2[c] = true;
            } else if (c >= 'a' && c <= 'z') {
                zArr2[c] = true;
            } else if (c == '_') {
                zArr2[c] = true;
            } else if (c >= '0' && c <= '9') {
                zArr2[c] = true;
            }
            c = (char) (c + 1);
        }
    }

    public JSONLexer(String str) {
        this(str, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i) {
        this(cArr, i, JSON.DEFAULT_PARSER_FEATURE);
    }

    public JSONLexer(char[] cArr, int i, int i2) {
        this(new String(cArr, 0, i), i2);
    }

    public JSONLexer(String str, int i) {
        this.features = JSON.DEFAULT_PARSER_FEATURE;
        this.exp = false;
        this.isDouble = false;
        this.timeZone = JSON.defaultTimeZone;
        this.locale = JSON.defaultLocale;
        this.calendar = null;
        this.matchStat = 0;
        char[] cArr = sbufLocal.get();
        this.sbuf = cArr;
        if (cArr == null) {
            this.sbuf = new char[512];
        }
        this.features = i;
        this.text = str;
        int length = str.length();
        this.len = length;
        this.bp = 0;
        char charAt = length <= 0 ? EOI : str.charAt(0);
        this.ch = charAt;
        if (charAt == 65279) {
            next();
        }
        this.stringDefaultValue = (Feature.InitStringFieldAsEmpty.mask & i) != 0 ? "" : null;
        this.disableCircularReferenceDetect = (Feature.DisableCircularReferenceDetect.mask & i) != 0;
    }

    public final int token() {
        return this.token;
    }

    public final void close() {
        char[] cArr = this.sbuf;
        if (cArr.length <= 8196) {
            sbufLocal.set(cArr);
        }
        this.sbuf = null;
    }

    public final char next() {
        int i = this.bp + 1;
        this.bp = i;
        char charAt = i >= this.len ? EOI : this.text.charAt(i);
        this.ch = charAt;
        return charAt;
    }

    public final void config(Feature feature, boolean z) {
        if (z) {
            this.features |= feature.mask;
        } else {
            this.features &= feature.mask ^ (-1);
        }
        if (feature == Feature.InitStringFieldAsEmpty) {
            this.stringDefaultValue = z ? "" : null;
        }
        this.disableCircularReferenceDetect = (this.features & Feature.DisableCircularReferenceDetect.mask) != 0;
    }

    public final boolean isEnabled(Feature feature) {
        return (feature.mask & this.features) != 0;
    }

    public final void nextTokenWithChar(char c) {
        this.sp = 0;
        while (true) {
            char c2 = this.ch;
            if (c2 == c) {
                int i = this.bp + 1;
                this.bp = i;
                this.ch = i >= this.len ? EOI : this.text.charAt(i);
                nextToken();
                return;
            } else if (c2 == ' ' || c2 == '\n' || c2 == '\r' || c2 == '\t' || c2 == '\f' || c2 == '\b') {
                next();
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("not match ");
                sb.append(c);
                sb.append(" - ");
                sb.append(this.ch);
                throw new JSONException(sb.toString());
            }
        }
    }

    public final String numberString() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        return subString(this.np, i);
    }

    protected final char charAt(int i) {
        return i >= this.len ? EOI : this.text.charAt(i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0027, code lost:
    
        scanNumber();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x0104, code lost:
    
        scanIdent();
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0107, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void nextToken() {
        /*
            Method dump skipped, instructions count: 502
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.nextToken():void");
    }

    public final void nextToken(int i) {
        this.sp = 0;
        while (true) {
            if (i != 2) {
                char c = EOI;
                if (i == 4) {
                    char c2 = this.ch;
                    if (c2 == '\"') {
                        this.pos = this.bp;
                        scanString();
                        return;
                    } else if (c2 >= '0' && c2 <= '9') {
                        this.pos = this.bp;
                        scanNumber();
                        return;
                    } else if (c2 == '{') {
                        this.token = 12;
                        int i2 = this.bp + 1;
                        this.bp = i2;
                        if (i2 < this.len) {
                            c = this.text.charAt(i2);
                        }
                        this.ch = c;
                        return;
                    }
                } else if (i == 12) {
                    char c3 = this.ch;
                    if (c3 == '{') {
                        this.token = 12;
                        int i3 = this.bp + 1;
                        this.bp = i3;
                        if (i3 < this.len) {
                            c = this.text.charAt(i3);
                        }
                        this.ch = c;
                        return;
                    } else if (c3 == '[') {
                        this.token = 14;
                        int i4 = this.bp + 1;
                        this.bp = i4;
                        if (i4 < this.len) {
                            c = this.text.charAt(i4);
                        }
                        this.ch = c;
                        return;
                    }
                } else if (i != 18) {
                    if (i != 20) {
                        switch (i) {
                            case 14:
                                char c4 = this.ch;
                                if (c4 == '[') {
                                    this.token = 14;
                                    next();
                                    return;
                                } else if (c4 == '{') {
                                    this.token = 12;
                                    next();
                                    return;
                                }
                                break;
                            case 15:
                                if (this.ch == ']') {
                                    this.token = 15;
                                    next();
                                    return;
                                }
                                break;
                            case 16:
                                char c5 = this.ch;
                                if (c5 == ',') {
                                    this.token = 16;
                                    int i5 = this.bp + 1;
                                    this.bp = i5;
                                    if (i5 < this.len) {
                                        c = this.text.charAt(i5);
                                    }
                                    this.ch = c;
                                    return;
                                } else if (c5 == '}') {
                                    this.token = 13;
                                    int i6 = this.bp + 1;
                                    this.bp = i6;
                                    if (i6 < this.len) {
                                        c = this.text.charAt(i6);
                                    }
                                    this.ch = c;
                                    return;
                                } else if (c5 == ']') {
                                    this.token = 15;
                                    int i7 = this.bp + 1;
                                    this.bp = i7;
                                    if (i7 < this.len) {
                                        c = this.text.charAt(i7);
                                    }
                                    this.ch = c;
                                    return;
                                } else if (c5 == 26) {
                                    this.token = 20;
                                    return;
                                }
                                break;
                        }
                    }
                    if (this.ch == 26) {
                        this.token = 20;
                        return;
                    }
                } else {
                    nextIdent();
                    return;
                }
            } else {
                char c6 = this.ch;
                if (c6 >= '0' && c6 <= '9') {
                    this.pos = this.bp;
                    scanNumber();
                    return;
                } else if (c6 == '\"') {
                    this.pos = this.bp;
                    scanString();
                    return;
                } else if (c6 == '[') {
                    this.token = 14;
                    next();
                    return;
                } else if (c6 == '{') {
                    this.token = 12;
                    next();
                    return;
                }
            }
            char c7 = this.ch;
            if (c7 == ' ' || c7 == '\n' || c7 == '\r' || c7 == '\t' || c7 == '\f' || c7 == '\b') {
                next();
            } else {
                nextToken();
                return;
            }
        }
    }

    public final void nextIdent() {
        char c;
        while (true) {
            c = this.ch;
            if (!(c <= ' ' && (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b'))) {
                break;
            }
            next();
        }
        if (c == '_' || Character.isLetter(c)) {
            scanIdent();
        } else {
            nextToken();
        }
    }

    public final Number integerValue() throws NumberFormatException {
        char c;
        long j;
        boolean z;
        long j2;
        int i = this.np;
        int i2 = this.sp + i;
        int i3 = i2 - 1;
        char charAt = i3 >= this.len ? EOI : this.text.charAt(i3);
        if (charAt == 'B') {
            i2 = i3;
            c = 'B';
        } else if (charAt == 'L') {
            i2 = i3;
            c = 'L';
        } else if (charAt != 'S') {
            c = InputCardNumberView.DIVIDER;
        } else {
            i2 = i3;
            c = 'S';
        }
        int i4 = this.np;
        if ((i4 >= this.len ? EOI : this.text.charAt(i4)) == '-') {
            j = Long.MIN_VALUE;
            i++;
            z = true;
        } else {
            j = -9223372036854775807L;
            z = false;
        }
        if (i < i2) {
            j2 = -((i >= this.len ? EOI : this.text.charAt(i)) - '0');
            i++;
        } else {
            j2 = 0;
        }
        while (i < i2) {
            char charAt2 = i >= this.len ? EOI : this.text.charAt(i);
            if (j2 < -922337203685477580L) {
                return new BigInteger(numberString());
            }
            long j3 = j2 * 10;
            long j4 = (long) (charAt2 - '0');
            if (j3 < j + j4) {
                return new BigInteger(numberString());
            }
            j2 = j3 - j4;
            i++;
        }
        if (!z) {
            long j5 = -j2;
            if (j5 > 2147483647L || c == 'L') {
                return Long.valueOf(j5);
            }
            if (c == 'S') {
                return Short.valueOf((short) j5);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j5);
            }
            return Integer.valueOf((int) j5);
        } else if (i > this.np + 1) {
            if (j2 < -2147483648L || c == 'L') {
                return Long.valueOf(j2);
            }
            if (c == 'S') {
                return Short.valueOf((short) j2);
            }
            if (c == 'B') {
                return Byte.valueOf((byte) j2);
            }
            return Integer.valueOf((int) j2);
        } else {
            throw new NumberFormatException(numberString());
        }
    }

    public final String scanSymbol(SymbolTable symbolTable) {
        char c;
        while (true) {
            c = this.ch;
            if (c != ' ' && c != '\n' && c != '\r' && c != '\t' && c != '\f' && c != '\b') {
                break;
            }
            next();
        }
        if (c == '\"') {
            return scanSymbol(symbolTable, Typography.quote);
        }
        if (c == '\'') {
            return scanSymbol(symbolTable, '\'');
        }
        if (c == '}') {
            next();
            this.token = 13;
            return null;
        } else if (c == ',') {
            next();
            this.token = 16;
            return null;
        } else if (c == 26) {
            this.token = 20;
            return null;
        } else {
            return scanSymbolUnQuoted(symbolTable);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String scanSymbol(com.alibaba.fastjson.parser.SymbolTable r11, char r12) {
        /*
            r10 = this;
            int r0 = r10.bp
            r1 = 1
            int r0 = r0 + r1
            java.lang.String r2 = r10.text
            int r2 = r2.indexOf(r12, r0)
            r3 = -1
            if (r2 == r3) goto L93
            int r0 = r2 - r0
            int r3 = r10.bp
            int r3 = r3 + r1
            char[] r3 = r10.sub_chars(r3, r0)
            r4 = 0
            r5 = 0
        L18:
            r6 = 92
            if (r0 <= 0) goto L5a
            int r7 = r0 + (-1)
            char r7 = r3[r7]
            if (r7 != r6) goto L5a
            int r7 = r0 + (-2)
            r8 = 1
        L25:
            if (r7 < 0) goto L30
            char r9 = r3[r7]
            if (r9 != r6) goto L30
            int r8 = r8 + 1
            int r7 = r7 + (-1)
            goto L25
        L30:
            int r8 = r8 % 2
            if (r8 == 0) goto L5a
            java.lang.String r5 = r10.text
            int r6 = r2 + 1
            int r5 = r5.indexOf(r12, r6)
            int r6 = r5 - r2
            int r6 = r6 + r0
            int r7 = r3.length
            if (r6 < r7) goto L51
            int r7 = r3.length
            int r7 = r7 * 3
            int r7 = r7 / 2
            if (r7 >= r6) goto L4a
            r7 = r6
        L4a:
            char[] r7 = new char[r7]
            int r8 = r3.length
            java.lang.System.arraycopy(r3, r4, r7, r4, r8)
            r3 = r7
        L51:
            java.lang.String r7 = r10.text
            r7.getChars(r2, r5, r3, r0)
            r2 = r5
            r0 = r6
            r5 = 1
            goto L18
        L5a:
            if (r5 != 0) goto L7c
            r12 = 0
            r7 = 0
        L5e:
            if (r12 >= r0) goto L6b
            char r8 = r3[r12]
            int r7 = r7 * 31
            int r7 = r7 + r8
            if (r8 != r6) goto L68
            r5 = 1
        L68:
            int r12 = r12 + 1
            goto L5e
        L6b:
            if (r5 != 0) goto L7c
            r12 = 20
            if (r0 >= r12) goto L76
            java.lang.String r11 = r11.addSymbol(r3, r4, r0, r7)
            goto L80
        L76:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r3, r4, r0)
            goto L80
        L7c:
            java.lang.String r11 = readString(r3, r0)
        L80:
            int r2 = r2 + r1
            r10.bp = r2
            int r12 = r10.len
            if (r2 < r12) goto L8a
            r12 = 26
            goto L90
        L8a:
            java.lang.String r12 = r10.text
            char r12 = r12.charAt(r2)
        L90:
            r10.ch = r12
            return r11
        L93:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r12 = "unclosed str, "
            r11.append(r12)
            java.lang.String r12 = r10.info()
            r11.append(r12)
            com.alibaba.fastjson.JSONException r12 = new com.alibaba.fastjson.JSONException
            java.lang.String r11 = r11.toString()
            r12.<init>(r11)
            goto Lb0
        Laf:
            throw r12
        Lb0:
            goto Laf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanSymbol(com.alibaba.fastjson.parser.SymbolTable, char):java.lang.String");
    }

    private static String readString(char[] cArr, int i) {
        int i2;
        char[] cArr2 = new char[i];
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            char c = cArr[i3];
            if (c != '\\') {
                cArr2[i4] = c;
                i4++;
            } else {
                i3++;
                char c2 = cArr[i3];
                if (c2 == '\"') {
                    i2 = i4 + 1;
                    cArr2[i4] = Typography.quote;
                } else if (c2 != '\'') {
                    if (c2 != 'F') {
                        if (c2 == '\\') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\\';
                        } else if (c2 == 'b') {
                            i2 = i4 + 1;
                            cArr2[i4] = '\b';
                        } else if (c2 != 'f') {
                            if (c2 == 'n') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\n';
                            } else if (c2 == 'r') {
                                i2 = i4 + 1;
                                cArr2[i4] = '\r';
                            } else if (c2 != 'x') {
                                switch (c2) {
                                    case '/':
                                        i2 = i4 + 1;
                                        cArr2[i4] = '/';
                                        break;
                                    case '0':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 0;
                                        break;
                                    case '1':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 1;
                                        break;
                                    case '2':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 2;
                                        break;
                                    case '3':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 3;
                                        break;
                                    case '4':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 4;
                                        break;
                                    case '5':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 5;
                                        break;
                                    case '6':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 6;
                                        break;
                                    case '7':
                                        i2 = i4 + 1;
                                        cArr2[i4] = 7;
                                        break;
                                    default:
                                        switch (c2) {
                                            case 't':
                                                i2 = i4 + 1;
                                                cArr2[i4] = '\t';
                                                break;
                                            case 'u':
                                                i2 = i4 + 1;
                                                int i5 = i3 + 1;
                                                int i6 = i5 + 1;
                                                int i7 = i6 + 1;
                                                i3 = i7 + 1;
                                                cArr2[i4] = (char) Integer.parseInt(new String(new char[]{cArr[i5], cArr[i6], cArr[i7], cArr[i3]}), 16);
                                                break;
                                            case 'v':
                                                i2 = i4 + 1;
                                                cArr2[i4] = 11;
                                                break;
                                            default:
                                                throw new JSONException("unclosed.str.lit");
                                        }
                                }
                            } else {
                                i2 = i4 + 1;
                                int[] iArr = digits;
                                int i8 = i3 + 1;
                                int i9 = iArr[cArr[i8]];
                                i3 = i8 + 1;
                                cArr2[i4] = (char) ((i9 * 16) + iArr[cArr[i3]]);
                            }
                        }
                    }
                    i2 = i4 + 1;
                    cArr2[i4] = '\f';
                } else {
                    i2 = i4 + 1;
                    cArr2[i4] = '\'';
                }
                i4 = i2;
            }
            i3++;
        }
        return new String(cArr2, 0, i4);
    }

    public final String info() {
        StringBuilder sb = new StringBuilder();
        sb.append("pos ");
        sb.append(this.bp);
        sb.append(", json : ");
        sb.append(this.len < 65536 ? this.text : this.text.substring(0, 65536));
        return sb.toString();
    }

    protected final void skipComment() {
        next();
        char c = this.ch;
        if (c != '/') {
            if (c == '*') {
                next();
                while (true) {
                    char c2 = this.ch;
                    if (c2 == 26) {
                        return;
                    }
                    if (c2 == '*') {
                        next();
                        if (this.ch == '/') {
                            next();
                            return;
                        }
                    } else {
                        next();
                    }
                }
            } else {
                throw new JSONException("invalid comment");
            }
        }
        do {
            next();
        } while (this.ch != '\n');
        next();
    }

    public final String scanSymbolUnQuoted(SymbolTable symbolTable) {
        int i = this.ch;
        boolean[] zArr = firstIdentifierFlags;
        if (!(i >= zArr.length || zArr[i])) {
            StringBuilder sb = new StringBuilder();
            sb.append("illegal identifier : ");
            sb.append(this.ch);
            sb.append(", ");
            sb.append(info());
            throw new JSONException(sb.toString());
        }
        this.np = this.bp;
        this.sp = 1;
        while (true) {
            char next = next();
            boolean[] zArr2 = identifierFlags;
            if (next < zArr2.length && !zArr2[next]) {
                break;
            }
            i = (i * 31) + next;
            this.sp++;
        }
        this.ch = charAt(this.bp);
        this.token = 18;
        if (this.sp == 4 && this.text.startsWith("null", this.np)) {
            return null;
        }
        return symbolTable.addSymbol(this.text, this.np, this.sp, i);
    }

    public final void scanString() {
        char c = this.ch;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("unclosed str, ");
            sb.append(info());
            throw new JSONException(sb.toString());
        }
        int i2 = indexOf - i;
        char[] sub_chars = sub_chars(this.bp + 1, i2);
        boolean z = false;
        while (i2 > 0 && sub_chars[i2 - 1] == '\\') {
            int i3 = 1;
            for (int i4 = i2 - 2; i4 >= 0 && sub_chars[i4] == '\\'; i4--) {
                i3++;
            }
            if (i3 % 2 == 0) {
                break;
            }
            int indexOf2 = this.text.indexOf(c, indexOf + 1);
            int i5 = (indexOf2 - indexOf) + i2;
            if (i5 >= sub_chars.length) {
                int length = (sub_chars.length * 3) / 2;
                if (length < i5) {
                    length = i5;
                }
                char[] cArr = new char[length];
                System.arraycopy(sub_chars, 0, cArr, 0, sub_chars.length);
                sub_chars = cArr;
            }
            this.text.getChars(indexOf, indexOf2, sub_chars, i2);
            indexOf = indexOf2;
            i2 = i5;
            z = true;
        }
        if (!z) {
            for (int i6 = 0; i6 < i2; i6++) {
                if (sub_chars[i6] == '\\') {
                    z = true;
                }
            }
        }
        this.sbuf = sub_chars;
        this.sp = i2;
        this.np = this.bp;
        this.hasSpecial = z;
        int i7 = indexOf + 1;
        this.bp = i7;
        this.ch = i7 >= this.len ? EOI : this.text.charAt(i7);
        this.token = 4;
    }

    public final String scanStringValue(char c) {
        String str;
        int i = this.bp + 1;
        int indexOf = this.text.indexOf(c, i);
        if (indexOf == -1) {
            StringBuilder sb = new StringBuilder();
            sb.append("unclosed str, ");
            sb.append(info());
            throw new JSONException(sb.toString());
        }
        if (V6) {
            str = this.text.substring(i, indexOf);
        } else {
            int i2 = indexOf - i;
            str = new String(sub_chars(this.bp + 1, i2), 0, i2);
        }
        if (str.indexOf(92) != -1) {
            while (true) {
                int i3 = 0;
                for (int i4 = indexOf - 1; i4 >= 0 && this.text.charAt(i4) == '\\'; i4--) {
                    i3++;
                }
                if (i3 % 2 == 0) {
                    break;
                }
                indexOf = this.text.indexOf(c, indexOf + 1);
            }
            int i5 = indexOf - i;
            str = readString(sub_chars(this.bp + 1, i5), i5);
        }
        int i6 = indexOf + 1;
        this.bp = i6;
        this.ch = i6 >= this.len ? EOI : this.text.charAt(i6);
        return str;
    }

    public final int intValue() {
        int i;
        boolean z;
        int i2 = this.np;
        int i3 = this.sp + i2;
        int i4 = 0;
        if ((i2 >= this.len ? EOI : this.text.charAt(i2)) == '-') {
            i = Integer.MIN_VALUE;
            i2++;
            z = true;
        } else {
            i = -2147483647;
            z = false;
        }
        if (i2 < i3) {
            i4 = -((i2 >= this.len ? EOI : this.text.charAt(i2)) - '0');
            i2++;
        }
        while (i2 < i3) {
            int i5 = i2 + 1;
            char charAt = i2 >= this.len ? EOI : this.text.charAt(i2);
            if (charAt == 'L' || charAt == 'S' || charAt == 'B') {
                i2 = i5;
                break;
            }
            int i6 = charAt - '0';
            if (i4 < -214748364) {
                throw new NumberFormatException(numberString());
            }
            int i7 = i4 * 10;
            if (i7 < i + i6) {
                throw new NumberFormatException(numberString());
            }
            i4 = i7 - i6;
            i2 = i5;
        }
        if (z) {
            if (i2 > this.np + 1) {
                return i4;
            }
            throw new NumberFormatException(numberString());
        }
        return -i4;
    }

    public final byte[] bytesValue() {
        return decodeFast(this.text, this.np + 1, this.sp);
    }

    private void scanIdent() {
        this.np = this.bp - 1;
        this.hasSpecial = false;
        do {
            this.sp++;
            next();
        } while (Character.isLetterOrDigit(this.ch));
        String stringVal = stringVal();
        if (stringVal.equals("null")) {
            this.token = 8;
        } else if (stringVal.equals(SummaryActivity.CHECKED)) {
            this.token = 6;
        } else if (stringVal.equals("false")) {
            this.token = 7;
        } else if (stringVal.equals("new")) {
            this.token = 9;
        } else if (stringVal.equals("undefined")) {
            this.token = 23;
        } else if (stringVal.equals("Set")) {
            this.token = 21;
        } else if (stringVal.equals("TreeSet")) {
            this.token = 22;
        } else {
            this.token = 18;
        }
    }

    public final String stringVal() {
        if (this.hasSpecial) {
            return readString(this.sbuf, this.sp);
        }
        return subString(this.np + 1, this.sp);
    }

    private final String subString(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i + i2, cArr, 0);
            return new String(this.sbuf, 0, i2);
        }
        char[] cArr2 = new char[i2];
        this.text.getChars(i, i2 + i, cArr2, 0);
        return new String(cArr2);
    }

    final char[] sub_chars(int i, int i2) {
        char[] cArr = this.sbuf;
        if (i2 < cArr.length) {
            this.text.getChars(i, i2 + i, cArr, 0);
            return this.sbuf;
        }
        char[] cArr2 = new char[i2];
        this.sbuf = cArr2;
        this.text.getChars(i, i2 + i, cArr2, 0);
        return cArr2;
    }

    public final boolean isBlankInput() {
        int i = 0;
        while (true) {
            char charAt = charAt(i);
            boolean z = true;
            if (charAt == 26) {
                return true;
            }
            if (charAt > ' ' || (charAt != ' ' && charAt != '\n' && charAt != '\r' && charAt != '\t' && charAt != '\f' && charAt != '\b')) {
                z = false;
            }
            if (!z) {
                return false;
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void skipWhitespace() {
        while (true) {
            char c = this.ch;
            if (c > '/') {
                return;
            }
            if (c == ' ' || c == '\r' || c == '\n' || c == '\t' || c == '\f' || c == '\b') {
                next();
            } else if (c != '/') {
                return;
            } else {
                skipComment();
            }
        }
    }

    public final void scanNumber() {
        char c;
        char c2;
        int i = this.bp;
        this.np = i;
        this.exp = false;
        if (this.ch == '-') {
            this.sp++;
            int i2 = i + 1;
            this.bp = i2;
            this.ch = i2 >= this.len ? EOI : this.text.charAt(i2);
        }
        while (true) {
            c = this.ch;
            if (c < '0' || c > '9') {
                break;
            }
            this.sp++;
            int i3 = this.bp + 1;
            this.bp = i3;
            this.ch = i3 >= this.len ? EOI : this.text.charAt(i3);
        }
        this.isDouble = false;
        if (c == '.') {
            this.sp++;
            int i4 = this.bp + 1;
            this.bp = i4;
            this.ch = i4 >= this.len ? EOI : this.text.charAt(i4);
            this.isDouble = true;
            while (true) {
                char c3 = this.ch;
                if (c3 < '0' || c3 > '9') {
                    break;
                }
                this.sp++;
                int i5 = this.bp + 1;
                this.bp = i5;
                this.ch = i5 >= this.len ? EOI : this.text.charAt(i5);
            }
        }
        char c4 = this.ch;
        if (c4 == 'L') {
            this.sp++;
            next();
        } else if (c4 == 'S') {
            this.sp++;
            next();
        } else if (c4 == 'B') {
            this.sp++;
            next();
        } else if (c4 == 'F') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c4 == 'D') {
            this.sp++;
            next();
            this.isDouble = true;
        } else if (c4 == 'e' || c4 == 'E') {
            this.sp++;
            int i6 = this.bp + 1;
            this.bp = i6;
            char charAt = i6 >= this.len ? EOI : this.text.charAt(i6);
            this.ch = charAt;
            if (charAt == '+' || charAt == '-') {
                this.sp++;
                int i7 = this.bp + 1;
                this.bp = i7;
                this.ch = i7 >= this.len ? EOI : this.text.charAt(i7);
            }
            while (true) {
                c2 = this.ch;
                if (c2 < '0' || c2 > '9') {
                    break;
                }
                this.sp++;
                int i8 = this.bp + 1;
                this.bp = i8;
                this.ch = i8 >= this.len ? EOI : this.text.charAt(i8);
            }
            if (c2 == 'D' || c2 == 'F') {
                this.sp++;
                next();
            }
            this.exp = true;
            this.isDouble = true;
        }
        if (this.isDouble) {
            this.token = 3;
        } else {
            this.token = 2;
        }
    }

    public final boolean scanBoolean() {
        boolean z = false;
        int i = 1;
        if (this.text.startsWith("false", this.bp)) {
            i = 5;
        } else if (this.text.startsWith(SummaryActivity.CHECKED, this.bp)) {
            z = true;
            i = 4;
        } else {
            char c = this.ch;
            if (c == '1') {
                z = true;
            } else if (c != '0') {
                this.matchStat = -1;
                return false;
            }
        }
        int i2 = this.bp + i;
        this.bp = i2;
        this.ch = charAt(i2);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0245 A[Catch: NumberFormatException -> 0x0253, TryCatch #0 {NumberFormatException -> 0x0253, blocks: (B:116:0x01f8, B:121:0x0203, B:123:0x0207, B:141:0x0236, B:120:0x0200, B:143:0x023b, B:145:0x0245, B:146:0x024a), top: B:152:0x01f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x024a A[Catch: NumberFormatException -> 0x0253, TRY_LEAVE, TryCatch #0 {NumberFormatException -> 0x0253, blocks: (B:116:0x01f8, B:121:0x0203, B:123:0x0207, B:141:0x0236, B:120:0x0200, B:143:0x023b, B:145:0x0245, B:146:0x024a), top: B:152:0x01f4 }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x014f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Number scanNumberValue() {
        /*
            Method dump skipped, instructions count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanNumberValue():java.lang.Number");
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c2, code lost:
    
        if (r0 != false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c5, code lost:
    
        return -r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:?, code lost:
    
        return r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long scanLongValue() {
        /*
            r13 = this;
            r0 = 0
            r13.np = r0
            char r1 = r13.ch
            r2 = 1
            r3 = 45
            if (r1 != r3) goto L3e
            r13.np = r2
            int r0 = r13.bp
            int r0 = r0 + r2
            r13.bp = r0
            int r1 = r13.len
            if (r0 >= r1) goto L22
            java.lang.String r1 = r13.text
            char r0 = r1.charAt(r0)
            r13.ch = r0
            r0 = -9223372036854775808
            r3 = r0
            r0 = 1
            goto L43
        L22:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "syntax error, "
            r0.append(r1)
            java.lang.String r1 = r13.info()
            r0.append(r1)
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        L3e:
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L43:
            r5 = 0
        L45:
            char r1 = r13.ch
            r7 = 48
            if (r1 < r7) goto Lc2
            r7 = 57
            if (r1 > r7) goto Lc2
            r7 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            java.lang.String r9 = ", "
            java.lang.String r10 = "error long value, "
            int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r11 < 0) goto La3
            r7 = 10
            long r5 = r5 * r7
            int r1 = r1 + (-48)
            long r7 = (long) r1
            long r11 = r3 + r7
            int r1 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r1 < 0) goto L84
            long r5 = r5 - r7
            int r1 = r13.np
            int r1 = r1 + r2
            r13.np = r1
            int r1 = r13.bp
            int r1 = r1 + r2
            r13.bp = r1
            int r7 = r13.len
            if (r1 < r7) goto L7b
            r1 = 26
            goto L81
        L7b:
            java.lang.String r7 = r13.text
            char r1 = r7.charAt(r1)
        L81:
            r13.ch = r1
            goto L45
        L84:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            r0.append(r5)
            r0.append(r9)
            java.lang.String r1 = r13.info()
            r0.append(r1)
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        La3:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r10)
            r0.append(r5)
            r0.append(r9)
            java.lang.String r1 = r13.info()
            r0.append(r1)
            com.alibaba.fastjson.JSONException r1 = new com.alibaba.fastjson.JSONException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            throw r1
        Lc2:
            if (r0 != 0) goto Lc5
            long r5 = -r5
        Lc5:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanLongValue():long");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005d -> B:8:0x0026). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long longValue() throws java.lang.NumberFormatException {
        /*
            r13 = this;
            int r0 = r13.np
            int r1 = r13.sp
            int r1 = r1 + r0
            char r2 = r13.charAt(r0)
            r3 = 1
            r4 = 45
            if (r2 != r4) goto L14
            r4 = -9223372036854775808
            int r0 = r0 + 1
            r2 = 1
            goto L1a
        L14:
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r2 = 0
        L1a:
            if (r0 >= r1) goto L28
            int r6 = r0 + 1
            char r0 = r13.charAt(r0)
            int r0 = r0 + (-48)
            int r0 = -r0
            long r7 = (long) r0
        L26:
            r0 = r6
            goto L2a
        L28:
            r7 = 0
        L2a:
            if (r0 >= r1) goto L74
            int r6 = r0 + 1
            int r9 = r13.len
            if (r0 < r9) goto L35
            r0 = 26
            goto L3b
        L35:
            java.lang.String r9 = r13.text
            char r0 = r9.charAt(r0)
        L3b:
            r9 = 76
            if (r0 == r9) goto L73
            r9 = 83
            if (r0 == r9) goto L73
            r9 = 66
            if (r0 == r9) goto L73
            r9 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r11 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r11 < 0) goto L69
            r9 = 10
            long r7 = r7 * r9
            int r0 = r0 + (-48)
            long r9 = (long) r0
            long r11 = r4 + r9
            int r0 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r0 < 0) goto L5f
            long r7 = r7 - r9
            goto L26
        L5f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L69:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L73:
            r0 = r6
        L74:
            if (r2 == 0) goto L86
            int r1 = r13.np
            int r1 = r1 + r3
            if (r0 <= r1) goto L7c
            return r7
        L7c:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = r13.numberString()
            r0.<init>(r1)
            throw r0
        L86:
            long r0 = -r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.longValue():long");
    }

    public final Number decimalValue(boolean z) {
        char[] cArr;
        boolean z2;
        int i = (this.np + this.sp) - 1;
        char charAt = i >= this.len ? EOI : this.text.charAt(i);
        try {
            if (charAt == 'F') {
                return Float.valueOf(Float.parseFloat(numberString()));
            }
            if (charAt == 'D') {
                return Double.valueOf(Double.parseDouble(numberString()));
            }
            if (z) {
                return decimalValue();
            }
            char charAt2 = this.text.charAt((this.np + this.sp) - 1);
            int i2 = this.sp;
            if (charAt2 == 'L' || charAt2 == 'S' || charAt2 == 'B' || charAt2 == 'F' || charAt2 == 'D') {
                i2--;
            }
            int i3 = this.np;
            char[] cArr2 = this.sbuf;
            int i4 = 0;
            if (i2 < cArr2.length) {
                this.text.getChars(i3, i3 + i2, cArr2, 0);
                cArr = this.sbuf;
            } else {
                char[] cArr3 = new char[i2];
                this.text.getChars(i3, i3 + i2, cArr3, 0);
                cArr = cArr3;
            }
            if (i2 <= 9 && !this.exp) {
                char c = cArr[0];
                int i5 = 2;
                if (c == '-') {
                    c = cArr[1];
                    z2 = true;
                } else {
                    if (c == '+') {
                        c = cArr[1];
                    } else {
                        i5 = 1;
                    }
                    z2 = false;
                }
                int i6 = c - '0';
                while (i5 < i2) {
                    char c2 = cArr[i5];
                    if (c2 == '.') {
                        i4 = 1;
                    } else {
                        i6 = (i6 * 10) + (c2 - '0');
                        if (i4 != 0) {
                            i4 *= 10;
                        }
                    }
                    i5++;
                }
                double d = i6;
                double d2 = i4;
                Double.isNaN(d);
                Double.isNaN(d2);
                double d3 = d / d2;
                if (z2) {
                    d3 = -d3;
                }
                return Double.valueOf(d3);
            }
            return Double.valueOf(Double.parseDouble(new String(cArr, 0, i2)));
        } catch (NumberFormatException e) {
            StringBuilder sb = new StringBuilder();
            sb.append(e.getMessage());
            sb.append(", ");
            sb.append(info());
            throw new JSONException(sb.toString());
        }
    }

    public final BigDecimal decimalValue() {
        char charAt = this.text.charAt((this.np + this.sp) - 1);
        int i = this.sp;
        if (charAt == 'L' || charAt == 'S' || charAt == 'B' || charAt == 'F' || charAt == 'D') {
            i--;
        }
        int i2 = this.np;
        char[] cArr = this.sbuf;
        if (i < cArr.length) {
            this.text.getChars(i2, i2 + i, cArr, 0);
            return new BigDecimal(this.sbuf, 0, i);
        }
        char[] cArr2 = new char[i];
        this.text.getChars(i2, i + i2, cArr2, 0);
        return new BigDecimal(cArr2);
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean matchField(long r20) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.matchField(long):boolean");
    }

    private int matchFieldHash(long j) {
        char c = this.ch;
        int i = 1;
        while (c != '\"' && c != '\'') {
            if (c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == '\f' || c == '\b') {
                int i2 = this.bp + i;
                c = i2 >= this.len ? EOI : this.text.charAt(i2);
                i++;
            } else {
                this.fieldHash = 0L;
                this.matchStat = -2;
                return 0;
            }
        }
        long j2 = -3750763034362895579L;
        int i3 = this.bp + i;
        while (true) {
            if (i3 >= this.len) {
                break;
            }
            char charAt = this.text.charAt(i3);
            if (charAt == c) {
                i += (i3 - this.bp) - i;
                break;
            }
            j2 = (charAt ^ j2) * 1099511628211L;
            i3++;
        }
        if (j2 != j) {
            this.fieldHash = j2;
            this.matchStat = -2;
            return 0;
        }
        int i4 = i + 1;
        int i5 = this.bp + i4;
        char charAt2 = i5 >= this.len ? EOI : this.text.charAt(i5);
        while (charAt2 != ':') {
            if (charAt2 <= ' ') {
                if (charAt2 != ' ' && charAt2 != '\n' && charAt2 != '\r' && charAt2 != '\t') {
                    if (charAt2 != '\f' && charAt2 != '\b') {
                    }
                }
                int i6 = this.bp + i4;
                charAt2 = i6 >= this.len ? EOI : this.text.charAt(i6);
                i4++;
            }
            throw new JSONException("match feild error expect ':'");
        }
        return i4 + 1;
    }

    public final int scanFieldInt(long j) {
        int i;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.bp + matchFieldHash;
        int i4 = this.len;
        char c = EOI;
        char charAt2 = i3 >= i4 ? EOI : this.text.charAt(i3);
        boolean z = charAt2 == '\"';
        if (z) {
            int i5 = this.bp + i2;
            charAt2 = i5 >= this.len ? EOI : this.text.charAt(i5);
            i2++;
            z = true;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            int i6 = this.bp + i2;
            charAt2 = i6 >= this.len ? EOI : this.text.charAt(i6);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0;
        }
        int i7 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            int i8 = this.bp + i2;
            charAt = i8 >= this.len ? EOI : this.text.charAt(i8);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i7 = (i7 * 10) + (charAt - '0');
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0;
        }
        if (charAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0;
            }
            int i9 = this.bp + i;
            charAt = i9 >= this.len ? EOI : this.text.charAt(i9);
            i++;
        }
        if (i7 < 0) {
            this.matchStat = -1;
            return 0;
        }
        while (charAt != ',') {
            if (charAt > ' ' || !(charAt == ' ' || charAt == '\n' || charAt == '\r' || charAt == '\t' || charAt == '\f' || charAt == '\b')) {
                if (charAt == '}') {
                    int i10 = i + 1;
                    char charAt3 = charAt(this.bp + i);
                    if (charAt3 == ',') {
                        this.token = 16;
                        int i11 = this.bp + (i10 - 1) + 1;
                        this.bp = i11;
                        if (i11 < this.len) {
                            c = this.text.charAt(i11);
                        }
                        this.ch = c;
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        int i12 = this.bp + (i10 - 1) + 1;
                        this.bp = i12;
                        if (i12 < this.len) {
                            c = this.text.charAt(i12);
                        }
                        this.ch = c;
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        int i13 = this.bp + (i10 - 1) + 1;
                        this.bp = i13;
                        if (i13 < this.len) {
                            c = this.text.charAt(i13);
                        }
                        this.ch = c;
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i10 - 1;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return 0;
                    }
                    this.matchStat = 4;
                    return z2 ? -i7 : i7;
                }
                this.matchStat = -1;
                return 0;
            }
            int i14 = this.bp + i;
            charAt = i14 >= this.len ? EOI : this.text.charAt(i14);
            i++;
        }
        int i15 = this.bp + (i - 1) + 1;
        this.bp = i15;
        if (i15 < this.len) {
            c = this.text.charAt(i15);
        }
        this.ch = c;
        this.matchStat = 3;
        this.token = 16;
        return z2 ? -i7 : i7;
    }

    public final int[] scanFieldIntArray(long j) {
        boolean z;
        int[] iArr;
        int i;
        int i2;
        char charAt;
        int i3;
        int i4;
        char charAt2;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        int[] iArr2 = null;
        if (matchFieldHash == 0) {
            return null;
        }
        int i5 = matchFieldHash + 1;
        int i6 = this.bp + matchFieldHash;
        if ((i6 >= this.len ? EOI : this.text.charAt(i6)) != '[') {
            this.matchStat = -1;
            return null;
        }
        int i7 = i5 + 1;
        int i8 = this.bp + i5;
        char charAt3 = i8 >= this.len ? EOI : this.text.charAt(i8);
        int[] iArr3 = new int[16];
        if (charAt3 == ']') {
            i4 = i7 + 1;
            int i9 = this.bp + i7;
            charAt2 = i9 >= this.len ? EOI : this.text.charAt(i9);
            i3 = 0;
        } else {
            int i10 = 0;
            while (true) {
                if (charAt3 == '-') {
                    int i11 = this.bp + i7;
                    charAt3 = i11 >= this.len ? EOI : this.text.charAt(i11);
                    i7++;
                    z = true;
                } else {
                    z = false;
                }
                if (charAt3 < '0') {
                    iArr = iArr2;
                    i = -1;
                    break;
                } else if (charAt3 > '9') {
                    i = -1;
                    iArr = null;
                    break;
                } else {
                    int i12 = charAt3 - '0';
                    while (true) {
                        i2 = i7 + 1;
                        int i13 = this.bp + i7;
                        charAt = i13 >= this.len ? EOI : this.text.charAt(i13);
                        if (charAt < '0' || charAt > '9') {
                            break;
                        }
                        i12 = (i12 * 10) + (charAt - '0');
                        i7 = i2;
                    }
                    if (i10 >= iArr3.length) {
                        int[] iArr4 = new int[(iArr3.length * 3) / 2];
                        System.arraycopy(iArr3, 0, iArr4, 0, i10);
                        iArr3 = iArr4;
                    }
                    i3 = i10 + 1;
                    if (z) {
                        i12 = -i12;
                    }
                    iArr3[i10] = i12;
                    if (charAt == ',') {
                        int i14 = this.bp + i2;
                        i2++;
                        charAt = i14 >= this.len ? EOI : this.text.charAt(i14);
                    } else if (charAt == ']') {
                        i4 = i2 + 1;
                        int i15 = this.bp + i2;
                        charAt2 = i15 >= this.len ? EOI : this.text.charAt(i15);
                    }
                    i10 = i3;
                    charAt3 = charAt;
                    iArr2 = null;
                    i7 = i2;
                }
            }
            this.matchStat = i;
            return iArr;
        }
        if (i3 != iArr3.length) {
            int[] iArr5 = new int[i3];
            System.arraycopy(iArr3, 0, iArr5, 0, i3);
            iArr3 = iArr5;
        }
        if (charAt2 == ',') {
            this.bp += i4 - 1;
            next();
            this.matchStat = 3;
            this.token = 16;
            return iArr3;
        } else if (charAt2 == '}') {
            int i16 = i4 + 1;
            char charAt4 = charAt(this.bp + i4);
            if (charAt4 == ',') {
                this.token = 16;
                this.bp += i16 - 1;
                next();
            } else if (charAt4 == ']') {
                this.token = 15;
                this.bp += i16 - 1;
                next();
            } else if (charAt4 == '}') {
                this.token = 13;
                this.bp += i16 - 1;
                next();
            } else if (charAt4 == 26) {
                this.bp += i16 - 1;
                this.token = 20;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return iArr3;
        } else {
            this.matchStat = -1;
            return null;
        }
    }

    public final long scanFieldLong(long j) {
        int i;
        char charAt;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i2 = matchFieldHash + 1;
        int i3 = this.bp + matchFieldHash;
        char charAt2 = i3 >= this.len ? EOI : this.text.charAt(i3);
        boolean z = charAt2 == '\"';
        if (z) {
            int i4 = this.bp + i2;
            charAt2 = i4 >= this.len ? EOI : this.text.charAt(i4);
            i2++;
        }
        boolean z2 = charAt2 == '-';
        if (z2) {
            int i5 = this.bp + i2;
            charAt2 = i5 >= this.len ? EOI : this.text.charAt(i5);
            i2++;
        }
        if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return 0L;
        }
        long j2 = charAt2 - '0';
        while (true) {
            i = i2 + 1;
            int i6 = this.bp + i2;
            charAt = i6 >= this.len ? EOI : this.text.charAt(i6);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            j2 = (j2 * 10) + ((long) (charAt - '0'));
            i2 = i;
        }
        if (charAt == '.') {
            this.matchStat = -1;
            return 0L;
        }
        if (charAt == '\"') {
            if (!z) {
                this.matchStat = -1;
                return 0L;
            }
            int i7 = this.bp + i;
            charAt = i7 >= this.len ? EOI : this.text.charAt(i7);
            i++;
        }
        if (j2 < 0) {
            this.matchStat = -1;
            return 0L;
        } else if (charAt == ',') {
            int i8 = this.bp + (i - 1) + 1;
            this.bp = i8;
            this.ch = i8 >= this.len ? EOI : this.text.charAt(i8);
            this.matchStat = 3;
            this.token = 16;
            return z2 ? -j2 : j2;
        } else if (charAt == '}') {
            int i9 = i + 1;
            char charAt3 = charAt(this.bp + i);
            if (charAt3 == ',') {
                this.token = 16;
                int i10 = this.bp + (i9 - 1) + 1;
                this.bp = i10;
                this.ch = i10 >= this.len ? EOI : this.text.charAt(i10);
            } else if (charAt3 == ']') {
                this.token = 15;
                int i11 = this.bp + (i9 - 1) + 1;
                this.bp = i11;
                this.ch = i11 >= this.len ? EOI : this.text.charAt(i11);
            } else if (charAt3 == '}') {
                this.token = 13;
                int i12 = this.bp + (i9 - 1) + 1;
                this.bp = i12;
                this.ch = i12 >= this.len ? EOI : this.text.charAt(i12);
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i9 - 1;
                this.ch = EOI;
            } else {
                this.matchStat = -1;
                return 0L;
            }
            this.matchStat = 4;
            return z2 ? -j2 : j2;
        } else {
            this.matchStat = -1;
            return 0L;
        }
    }

    public final String scanFieldString(long j) {
        String str;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return null;
        }
        int i = matchFieldHash + 1;
        int i2 = this.bp + matchFieldHash;
        if (i2 >= this.len) {
            StringBuilder sb = new StringBuilder();
            sb.append("unclosed str, ");
            sb.append(info());
            throw new JSONException(sb.toString());
        } else if (this.text.charAt(i2) != '\"') {
            this.matchStat = -1;
            return this.stringDefaultValue;
        } else {
            int i3 = this.bp + i;
            int indexOf = this.text.indexOf(34, i3);
            if (indexOf == -1) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("unclosed str, ");
                sb2.append(info());
                throw new JSONException(sb2.toString());
            }
            if (V6) {
                str = this.text.substring(i3, indexOf);
            } else {
                int i4 = indexOf - i3;
                str = new String(sub_chars(this.bp + i, i4), 0, i4);
            }
            if (str.indexOf(92) != -1) {
                boolean z = false;
                while (true) {
                    int i5 = indexOf - 1;
                    int i6 = 0;
                    while (i5 >= 0 && this.text.charAt(i5) == '\\') {
                        i6++;
                        i5--;
                        z = true;
                    }
                    if (i6 % 2 == 0) {
                        break;
                    }
                    indexOf = this.text.indexOf(34, indexOf + 1);
                }
                int i7 = indexOf - i3;
                char[] sub_chars = sub_chars(this.bp + i, i7);
                if (z) {
                    str = readString(sub_chars, i7);
                } else {
                    str = new String(sub_chars, 0, i7);
                    if (str.indexOf(92) != -1) {
                        str = readString(sub_chars, i7);
                    }
                }
            }
            int i8 = indexOf + 1;
            int i9 = this.len;
            char c = EOI;
            char charAt = i8 >= i9 ? EOI : this.text.charAt(i8);
            if (charAt == ',') {
                int i10 = i8 + 1;
                this.bp = i10;
                if (i10 < this.len) {
                    c = this.text.charAt(i10);
                }
                this.ch = c;
                this.matchStat = 3;
                this.token = 16;
                return str;
            } else if (charAt == '}') {
                int i11 = i8 + 1;
                char charAt2 = i11 >= this.len ? EOI : this.text.charAt(i11);
                if (charAt2 == ',') {
                    this.token = 16;
                    this.bp = i11;
                    next();
                } else if (charAt2 == ']') {
                    this.token = 15;
                    this.bp = i11;
                    next();
                } else if (charAt2 == '}') {
                    this.token = 13;
                    this.bp = i11;
                    next();
                } else if (charAt2 == 26) {
                    this.token = 20;
                    this.bp = i11;
                    this.ch = EOI;
                } else {
                    this.matchStat = -1;
                    return this.stringDefaultValue;
                }
                this.matchStat = 4;
                return str;
            } else {
                this.matchStat = -1;
                return this.stringDefaultValue;
            }
        }
    }

    public final Date scanFieldDate(long j) {
        int i;
        char charAt;
        char c;
        int i2;
        Date date;
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return null;
        }
        int i3 = this.bp;
        char c2 = this.ch;
        int i4 = matchFieldHash + 1;
        int i5 = matchFieldHash + i3;
        int i6 = this.len;
        char c3 = EOI;
        char charAt2 = i5 >= i6 ? EOI : this.text.charAt(i5);
        if (charAt2 == '\"') {
            int i7 = this.bp + i4;
            int i8 = i4 + 1;
            int i9 = this.len;
            int indexOf = this.text.indexOf(34, this.bp + i8);
            if (indexOf == -1) {
                throw new JSONException("unclosed str");
            }
            int i10 = indexOf - i7;
            this.bp = i7;
            if (scanISO8601DateIfMatch(false, i10)) {
                date = this.calendar.getTime();
                int i11 = i8 + i10;
                i2 = i11 + 1;
                c = charAt(i11 + i3);
                this.bp = i3;
            } else {
                this.bp = i3;
                this.matchStat = -1;
                return null;
            }
        } else if (charAt2 < '0' || charAt2 > '9') {
            this.matchStat = -1;
            return null;
        } else {
            long j2 = charAt2 - '0';
            while (true) {
                i = i4 + 1;
                int i12 = this.bp + i4;
                charAt = i12 >= this.len ? EOI : this.text.charAt(i12);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                j2 = (j2 * 10) + ((long) (charAt - '0'));
                i4 = i;
            }
            if (charAt == '.') {
                this.matchStat = -1;
                return null;
            }
            if (charAt == '\"') {
                int i13 = this.bp + i;
                charAt = i13 >= this.len ? EOI : this.text.charAt(i13);
                i++;
            }
            c = charAt;
            i2 = i;
            if (j2 < 0) {
                this.matchStat = -1;
                return null;
            }
            date = new Date(j2);
        }
        if (c == ',') {
            int i14 = this.bp + (i2 - 1) + 1;
            this.bp = i14;
            if (i14 < this.len) {
                c3 = this.text.charAt(i14);
            }
            this.ch = c3;
            this.matchStat = 3;
            this.token = 16;
            return date;
        } else if (c == '}') {
            int i15 = i2 + 1;
            char charAt3 = charAt(this.bp + i2);
            if (charAt3 == ',') {
                this.token = 16;
                int i16 = this.bp + (i15 - 1) + 1;
                this.bp = i16;
                if (i16 < this.len) {
                    c3 = this.text.charAt(i16);
                }
                this.ch = c3;
            } else if (charAt3 == ']') {
                this.token = 15;
                int i17 = this.bp + (i15 - 1) + 1;
                this.bp = i17;
                if (i17 < this.len) {
                    c3 = this.text.charAt(i17);
                }
                this.ch = c3;
            } else if (charAt3 == '}') {
                this.token = 13;
                int i18 = this.bp + (i15 - 1) + 1;
                this.bp = i18;
                if (i18 < this.len) {
                    c3 = this.text.charAt(i18);
                }
                this.ch = c3;
            } else if (charAt3 == 26) {
                this.token = 20;
                this.bp += i15 - 1;
                this.ch = EOI;
            } else {
                this.bp = i3;
                this.ch = c2;
                this.matchStat = -1;
                return null;
            }
            this.matchStat = 4;
            return date;
        } else {
            this.bp = i3;
            this.ch = c2;
            this.matchStat = -1;
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean scanFieldBoolean(long r13) {
        /*
            Method dump skipped, instructions count: 350
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldBoolean(long):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x00ad -> B:50:0x00ae). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float scanFieldFloat(long r18) {
        /*
            Method dump skipped, instructions count: 323
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloat(long):float");
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x0216, code lost:
    
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0218, code lost:
    
        return r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
    
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ce, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0122  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x010d -> B:82:0x0110). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x011f -> B:82:0x0110). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[] scanFieldFloatArray(long r19) {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray(long):float[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0290, code lost:
    
        r12 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0293, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e4, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float[][] scanFieldFloatArray2(long r21) {
        /*
            Method dump skipped, instructions count: 663
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldFloatArray2(long):float[][]");
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00b7 A[ADDED_TO_REGION] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:50:0x00b4 -> B:51:0x00b5). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double scanFieldDouble(long r19) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDouble(long):double");
    }

    /* JADX WARN: Code restructure failed: missing block: B:141:0x021d, code lost:
    
        r5 = r3;
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0220, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00cc, code lost:
    
        r18.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ce, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0122  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x010d -> B:82:0x0110). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x011f -> B:82:0x0110). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[] scanFieldDoubleArray(long r19) {
        /*
            Method dump skipped, instructions count: 545
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray(long):double[]");
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x0296, code lost:
    
        r12 = r3;
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0299, code lost:
    
        return r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        r20.matchStat = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00e4, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final double[][] scanFieldDoubleArray2(long r21) {
        /*
            Method dump skipped, instructions count: 671
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanFieldDoubleArray2(long):double[][]");
    }

    public final long scanFieldSymbol(long j) {
        this.matchStat = 0;
        int matchFieldHash = matchFieldHash(j);
        if (matchFieldHash == 0) {
            return 0L;
        }
        int i = matchFieldHash + 1;
        int i2 = this.bp + matchFieldHash;
        int i3 = this.len;
        char c = EOI;
        if ((i2 >= i3 ? EOI : this.text.charAt(i2)) != '\"') {
            this.matchStat = -1;
            return 0L;
        }
        long j2 = -3750763034362895579L;
        while (true) {
            int i4 = i + 1;
            int i5 = this.bp + i;
            char charAt = i5 >= this.len ? EOI : this.text.charAt(i5);
            if (charAt == '\"') {
                int i6 = i4 + 1;
                int i7 = this.bp + i4;
                char charAt2 = i7 >= this.len ? EOI : this.text.charAt(i7);
                if (charAt2 == ',') {
                    int i8 = this.bp + (i6 - 1) + 1;
                    this.bp = i8;
                    if (i8 < this.len) {
                        c = this.text.charAt(i8);
                    }
                    this.ch = c;
                    this.matchStat = 3;
                    return j2;
                } else if (charAt2 == '}') {
                    int i9 = i6 + 1;
                    int i10 = this.bp + i6;
                    char charAt3 = i10 >= this.len ? EOI : this.text.charAt(i10);
                    if (charAt3 == ',') {
                        this.token = 16;
                        this.bp += i9 - 1;
                        next();
                    } else if (charAt3 == ']') {
                        this.token = 15;
                        this.bp += i9 - 1;
                        next();
                    } else if (charAt3 == '}') {
                        this.token = 13;
                        this.bp += i9 - 1;
                        next();
                    } else if (charAt3 == 26) {
                        this.token = 20;
                        this.bp += i9 - 1;
                        this.ch = EOI;
                    } else {
                        this.matchStat = -1;
                        return 0L;
                    }
                    this.matchStat = 4;
                    return j2;
                } else {
                    this.matchStat = -1;
                    return 0L;
                }
            }
            j2 = (j2 ^ charAt) * 1099511628211L;
            if (charAt == '\\') {
                this.matchStat = -1;
                return 0L;
            }
            i = i4;
        }
    }

    public final boolean scanISO8601DateIfMatch(boolean z) {
        return scanISO8601DateIfMatch(z, this.len - this.bp);
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01ef A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean scanISO8601DateIfMatch(boolean r36, int r37) {
        /*
            Method dump skipped, instructions count: 1576
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.fastjson.parser.JSONLexer.scanISO8601DateIfMatch(boolean, int):boolean");
    }

    protected final void setTime(char c, char c2, char c3, char c4, char c5, char c6) {
        this.calendar.set(11, ((c - '0') * 10) + (c2 - '0'));
        this.calendar.set(12, ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(13, ((c5 - '0') * 10) + (c6 - '0'));
    }

    protected final void setTimeZone(char c, char c2, char c3) {
        int i = (((c2 - '0') * 10) + (c3 - '0')) * 3600 * 1000;
        if (c == '-') {
            i = -i;
        }
        if (this.calendar.getTimeZone().getRawOffset() != i) {
            String[] availableIDs = TimeZone.getAvailableIDs(i);
            if (availableIDs.length > 0) {
                this.calendar.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory(availableIDs[0]));
            }
        }
    }

    private void setCalendar(char c, char c2, char c3, char c4, char c5, char c6, char c7, char c8) {
        Calendar calendar = Calendar.getInstance(this.timeZone, this.locale);
        this.calendar = calendar;
        calendar.set(1, ((c - '0') * 1000) + ((c2 - '0') * 100) + ((c3 - '0') * 10) + (c4 - '0'));
        this.calendar.set(2, (((c5 - '0') * 10) + (c6 - '0')) - 1);
        this.calendar.set(5, ((c7 - '0') * 10) + (c8 - '0'));
    }

    public static final byte[] decodeFast(String str, int i, int i2) {
        int i3;
        int i4 = 0;
        if (i2 == 0) {
            return new byte[0];
        }
        int i5 = (i + i2) - 1;
        int i6 = i;
        while (i6 < i5 && IA[str.charAt(i6)] < 0) {
            i6++;
        }
        while (i5 > 0 && IA[str.charAt(i5)] < 0) {
            i5--;
        }
        int i7 = str.charAt(i5) == '=' ? str.charAt(i5 + (-1)) == '=' ? 2 : 1 : 0;
        int i8 = (i5 - i6) + 1;
        if (i2 > 76) {
            i3 = (str.charAt(76) == '\r' ? i8 / 78 : 0) << 1;
        } else {
            i3 = 0;
        }
        int i9 = (((i8 - i3) * 6) >> 3) - i7;
        byte[] bArr = new byte[i9];
        int i10 = i9 / 3;
        int i11 = 0;
        int i12 = 0;
        while (i11 < i10 * 3) {
            int[] iArr = IA;
            int i13 = i6 + 1;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            int i16 = i15 + 1;
            int i17 = (iArr[str.charAt(i6)] << 18) | (iArr[str.charAt(i13)] << 12) | (iArr[str.charAt(i14)] << 6) | iArr[str.charAt(i15)];
            int i18 = i11 + 1;
            bArr[i11] = (byte) (i17 >> 16);
            int i19 = i18 + 1;
            bArr[i18] = (byte) (i17 >> 8);
            bArr[i19] = (byte) i17;
            if (i3 <= 0 || (i12 = i12 + 1) != 19) {
                i6 = i16;
            } else {
                i6 = i16 + 2;
                i12 = 0;
            }
            i11 = i19 + 1;
        }
        if (i11 < i9) {
            int i20 = 0;
            while (i6 <= i5 - i7) {
                i4 |= IA[str.charAt(i6)] << (18 - (i20 * 6));
                i20++;
                i6++;
            }
            int i21 = 16;
            while (i11 < i9) {
                bArr[i11] = (byte) (i4 >> i21);
                i21 -= 8;
                i11++;
            }
        }
        return bArr;
    }
}
