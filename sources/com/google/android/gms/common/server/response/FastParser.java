package com.google.android.gms.common.server.response;

import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.Base64Utils;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import kotlin.text.Typography;

/* loaded from: classes7.dex */
public class FastParser<T extends FastJsonResponse> {
    private static final char[] zaa = {'u', 'l', 'l'};
    private static final char[] zab = {'r', 'u', 'e'};
    private static final char[] zac = {'r', 'u', 'e', Typography.quote};
    private static final char[] zad = {'a', 'l', 's', 'e'};
    private static final char[] zae = {'a', 'l', 's', 'e', Typography.quote};
    private static final char[] zaf = {'\n'};
    private static final zai<Integer> zag = new zaa();
    private static final zai<Long> zah = new zab();
    private static final zai<Float> zai = new zac();
    private static final zai<Double> zaj = new zad();
    private static final zai<Boolean> zak = new zae();
    private static final zai<String> zal = new zaf();
    private static final zai<BigInteger> zam = new zag();
    private static final zai<BigDecimal> zan = new zah();
    private final char[] zao = new char[1];
    private final char[] zap = new char[32];
    private final char[] zaq = new char[1024];
    private final StringBuilder zar = new StringBuilder(32);
    private final StringBuilder zas = new StringBuilder(1024);
    private final Stack<Integer> zat = new Stack<>();

    /* loaded from: classes7.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super("Error instantiating inner object", th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        throw new com.google.android.gms.common.server.response.FastParser.ParseException("Unexpected control character while reading string");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String zaA(java.io.BufferedReader r8, char[] r9, java.lang.StringBuilder r10, char[] r11) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            r0 = 0
            r10.setLength(r0)
            int r1 = r9.length
            r8.mark(r1)
            r1 = 0
            r2 = 0
        La:
            int r3 = r8.read(r9)
            r4 = -1
            if (r3 == r4) goto L66
            r4 = 0
        L12:
            if (r4 >= r3) goto L5e
            char r5 = r9[r4]
            boolean r6 = java.lang.Character.isISOControl(r5)
            if (r6 == 0) goto L30
            if (r11 == 0) goto L28
            r6 = 0
        L1f:
            if (r6 > 0) goto L28
            char r7 = r11[r6]
            if (r7 == r5) goto L30
            int r6 = r6 + 1
            goto L1f
        L28:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected control character while reading string"
            r8.<init>(r9)
            throw r8
        L30:
            r6 = 34
            r7 = 1
            if (r5 != r6) goto L52
            if (r1 != 0) goto L5a
            r10.append(r9, r0, r4)
            r8.reset()
            int r4 = r4 + r7
            long r0 = (long) r4
            r8.skip(r0)
            if (r2 == 0) goto L4d
            java.lang.String r8 = r10.toString()
            java.lang.String r8 = com.google.android.gms.common.util.JsonUtils.unescapeString(r8)
            return r8
        L4d:
            java.lang.String r8 = r10.toString()
            return r8
        L52:
            r6 = 92
            if (r5 != r6) goto L5a
            r1 = r1 ^ 1
            r2 = 1
            goto L5b
        L5a:
            r1 = 0
        L5b:
            int r4 = r4 + 1
            goto L12
        L5e:
            r10.append(r9, r0, r3)
            int r3 = r9.length
            r8.mark(r3)
            goto La
        L66:
            com.google.android.gms.common.server.response.FastParser$ParseException r8 = new com.google.android.gms.common.server.response.FastParser$ParseException
            java.lang.String r9 = "Unexpected EOF while parsing string"
            r8.<init>(r9)
            goto L6f
        L6e:
            throw r8
        L6f:
            goto L6e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.zaA(java.io.BufferedReader, char[], java.lang.StringBuilder, char[]):java.lang.String");
    }

    private final char zai(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.zao) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.zao[0])) {
            if (bufferedReader.read(this.zao) == -1) {
                return (char) 0;
            }
        }
        return this.zao[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double zaj(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        return zam2 == 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : Double.parseDouble(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float zak(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int zal(BufferedReader bufferedReader) throws ParseException, IOException {
        int i;
        int i2;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            char c = cArr[0];
            int i3 = c == '-' ? Integer.MIN_VALUE : -2147483647;
            int i4 = c == '-' ? 1 : 0;
            if (i4 < zam2) {
                i = i4 + 1;
                int digit = Character.digit(cArr[i4], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                i2 = -digit;
            } else {
                i = i4;
                i2 = 0;
            }
            while (i < zam2) {
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (i2 < -214748364) {
                    throw new ParseException("Number too large");
                }
                int i5 = i2 * 10;
                if (i5 < i3 + digit2) {
                    throw new ParseException("Number too large");
                }
                i2 = i5 - digit2;
                i++;
            }
            if (i4 != 0) {
                if (i > 1) {
                    return i2;
                }
                throw new ParseException("No digits to parse");
            }
            return -i2;
        }
        throw new ParseException("No number to parse");
    }

    private final int zam(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i;
        char zai2 = zai(bufferedReader);
        if (zai2 != 0) {
            if (zai2 != ',') {
                if (zai2 == 'n') {
                    zax(bufferedReader, zaa);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (zai2 == '\"') {
                    i = 0;
                    boolean z = false;
                    while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                        char c = cArr[i];
                        if (Character.isISOControl(c)) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                        if (c == '\"') {
                            if (!z) {
                                bufferedReader.reset();
                                bufferedReader.skip(i + 1);
                                return i;
                            }
                        } else if (c == '\\') {
                            z = !z;
                            i++;
                        }
                        z = false;
                        i++;
                    }
                } else {
                    cArr[0] = zai2;
                    i = 1;
                    while (i < 1024 && bufferedReader.read(cArr, i, 1) != -1) {
                        char c2 = cArr[i];
                        if (c2 == '}' || c2 == ',' || Character.isWhitespace(c2) || cArr[i] == ']') {
                            bufferedReader.reset();
                            bufferedReader.skip((long) (i - 1));
                            cArr[i] = 0;
                            return i;
                        }
                        i++;
                    }
                }
                if (i == 1024) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zan(BufferedReader bufferedReader) throws ParseException, IOException {
        long j;
        int i;
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return 0L;
        }
        char[] cArr = this.zaq;
        if (zam2 > 0) {
            char c = cArr[0];
            long j2 = c == '-' ? Long.MIN_VALUE : -9223372036854775807L;
            int i2 = c == '-' ? 1 : 0;
            if (i2 < zam2) {
                i = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                j = -digit;
            } else {
                j = 0;
                i = i2;
            }
            while (i < zam2) {
                int digit2 = Character.digit(cArr[i], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (j < -922337203685477580L) {
                    throw new ParseException("Number too large");
                }
                long j3 = j * 10;
                long j4 = digit2;
                if (j3 < j2 + j4) {
                    throw new ParseException("Number too large");
                }
                j = j3 - j4;
                i++;
            }
            if (i2 != 0) {
                if (i > 1) {
                    return j;
                }
                throw new ParseException("No digits to parse");
            }
            return -j;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zao(BufferedReader bufferedReader) throws ParseException, IOException {
        return zap(bufferedReader, this.zap, this.zar, null);
    }

    private final String zap(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 != '\"') {
            if (zai2 == 'n') {
                zax(bufferedReader, zaa);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return zaA(bufferedReader, cArr, sb, cArr2);
    }

    private final String zaq(BufferedReader bufferedReader) throws ParseException, IOException {
        this.zat.push(2);
        char zai2 = zai(bufferedReader);
        if (zai2 == '\"') {
            this.zat.push(3);
            String zaA = zaA(bufferedReader, this.zap, this.zar, null);
            zaw(3);
            if (zai(bufferedReader) == ':') {
                return zaA;
            }
            throw new ParseException("Expected key/value separator");
        } else if (zai2 == ']') {
            zaw(2);
            zaw(1);
            zaw(5);
            return null;
        } else if (zai2 == '}') {
            zaw(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(zai2);
            throw new ParseException(sb.toString());
        }
    }

    private final String zar(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char zai2 = zai(bufferedReader);
        int i = 1;
        if (zai2 == '\"') {
            if (bufferedReader.read(this.zao) != -1) {
                char c = this.zao[0];
                boolean z = false;
                do {
                    if (c == '\"') {
                        if (z) {
                            c = Typography.quote;
                            z = true;
                        }
                    }
                    z = c == '\\' ? !z : false;
                    if (bufferedReader.read(this.zao) != -1) {
                        c = this.zao[0];
                    } else {
                        throw new ParseException("Unexpected EOF while parsing string");
                    }
                } while (!Character.isISOControl(c));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException("Unexpected EOF while parsing string");
        } else if (zai2 == ',') {
            throw new ParseException("Missing value");
        } else {
            if (zai2 == '[') {
                this.zat.push(5);
                bufferedReader.mark(32);
                if (zai(bufferedReader) == ']') {
                    zaw(5);
                } else {
                    bufferedReader.reset();
                    boolean z2 = false;
                    loop1: while (true) {
                        boolean z3 = false;
                        while (i > 0) {
                            char zai3 = zai(bufferedReader);
                            if (zai3 != 0) {
                                if (Character.isISOControl(zai3)) {
                                    throw new ParseException("Unexpected control character while reading array");
                                }
                                if (zai3 == '\"') {
                                    if (!z3) {
                                        z2 = !z2;
                                    }
                                    zai3 = Typography.quote;
                                }
                                if (zai3 == '[') {
                                    if (!z2) {
                                        i++;
                                    }
                                    zai3 = '[';
                                }
                                if (zai3 == ']' && !z2) {
                                    i--;
                                }
                                if (zai3 == '\\' && z2) {
                                    z3 = !z3;
                                }
                            } else {
                                throw new ParseException("Unexpected EOF while parsing array");
                            }
                        }
                        zaw(5);
                        break loop1;
                    }
                }
            } else if (zai2 == '{') {
                this.zat.push(1);
                bufferedReader.mark(32);
                char zai4 = zai(bufferedReader);
                if (zai4 == '}') {
                    zaw(1);
                } else if (zai4 == '\"') {
                    bufferedReader.reset();
                    zaq(bufferedReader);
                    do {
                    } while (zar(bufferedReader) != null);
                    zaw(1);
                } else {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append("Unexpected token ");
                    sb.append(zai4);
                    throw new ParseException(sb.toString());
                }
            } else {
                bufferedReader.reset();
                zam(bufferedReader, this.zaq);
            }
        }
        char zai5 = zai(bufferedReader);
        if (zai5 == ',') {
            zaw(2);
            return zaq(bufferedReader);
        } else if (zai5 == '}') {
            zaw(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(zai5);
            throw new ParseException(sb2.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal zas(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.zaq, 0, zam2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger zat(BufferedReader bufferedReader) throws ParseException, IOException {
        int zam2 = zam(bufferedReader, this.zaq);
        if (zam2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.zaq, 0, zam2));
    }

    private final <O> ArrayList<O> zau(BufferedReader bufferedReader, zai<O> zaiVar) throws ParseException, IOException {
        char zai2 = zai(bufferedReader);
        if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            return null;
        } else if (zai2 != '[') {
            throw new ParseException("Expected start of array");
        } else {
            this.zat.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char zai3 = zai(bufferedReader);
                if (zai3 == 0) {
                    throw new ParseException("Unexpected EOF");
                }
                if (zai3 != ',') {
                    if (zai3 != ']') {
                        bufferedReader.reset();
                        arrayList.add(zaiVar.zaa(this, bufferedReader));
                    } else {
                        zaw(5);
                        return arrayList;
                    }
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends FastJsonResponse> ArrayList<T> zav(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        char zai2 = zai(bufferedReader);
        if (zai2 == ']') {
            zaw(5);
            return arrayList;
        } else if (zai2 == 'n') {
            zax(bufferedReader, zaa);
            zaw(5);
            return null;
        } else if (zai2 == '{') {
            this.zat.push(1);
            while (true) {
                try {
                    FastJsonResponse zad2 = field.zad();
                    if (!zaz(bufferedReader, zad2)) {
                        return arrayList;
                    }
                    arrayList.add(zad2);
                    char zai3 = zai(bufferedReader);
                    if (zai3 != ',') {
                        if (zai3 == ']') {
                            zaw(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zai3);
                        throw new ParseException(sb.toString());
                    } else if (zai(bufferedReader) == '{') {
                        this.zat.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (IllegalAccessException e) {
                    throw new ParseException("Error instantiating inner object", e);
                } catch (InstantiationException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(zai2);
            throw new ParseException(sb2.toString());
        }
    }

    private final void zaw(int i) throws ParseException {
        if (this.zat.isEmpty()) {
            StringBuilder sb = new StringBuilder(46);
            sb.append("Expected state ");
            sb.append(i);
            sb.append(" but had empty stack");
            throw new ParseException(sb.toString());
        }
        int intValue = this.zat.pop().intValue();
        if (intValue == i) {
            return;
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i);
        sb2.append(" but had ");
        sb2.append(intValue);
        throw new ParseException(sb2.toString());
    }

    private final void zax(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i = 0;
        while (true) {
            int length = cArr.length;
            if (i >= length) {
                return;
            }
            int read = bufferedReader.read(this.zap, 0, length - i);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i2 = 0; i2 < read; i2++) {
                if (cArr[i2 + i] != this.zap[i2]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean zay(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        char[] cArr;
        while (true) {
            char zai2 = zai(bufferedReader);
            if (zai2 != '\"') {
                if (zai2 == 'f') {
                    if (z) {
                        cArr = zae;
                    } else {
                        cArr = zad;
                    }
                    zax(bufferedReader, cArr);
                    return false;
                } else if (zai2 == 'n') {
                    zax(bufferedReader, zaa);
                    return false;
                } else if (zai2 == 't') {
                    zax(bufferedReader, z ? zac : zab);
                    return true;
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(zai2);
                    throw new ParseException(sb.toString());
                }
            } else if (z) {
                throw new ParseException("No boolean value found in string");
            } else {
                z = true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean zaz(BufferedReader bufferedReader, FastJsonResponse fastJsonResponse) throws ParseException, IOException {
        HashMap hashMap;
        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = fastJsonResponse.getFieldMappings();
        String zaq = zaq(bufferedReader);
        if (zaq != null) {
            while (zaq != null) {
                FastJsonResponse.Field<?, ?> field = fieldMappings.get(zaq);
                if (field == null) {
                    zaq = zar(bufferedReader);
                } else {
                    this.zat.push(4);
                    int i = field.zaa;
                    switch (i) {
                        case 0:
                            if (field.zab) {
                                fastJsonResponse.zav(field, zau(bufferedReader, zag));
                                break;
                            } else {
                                fastJsonResponse.zau(field, zal(bufferedReader));
                                break;
                            }
                        case 1:
                            if (field.zab) {
                                fastJsonResponse.zag(field, zau(bufferedReader, zam));
                                break;
                            } else {
                                fastJsonResponse.zae(field, zat(bufferedReader));
                                break;
                            }
                        case 2:
                            if (field.zab) {
                                fastJsonResponse.zay(field, zau(bufferedReader, zah));
                                break;
                            } else {
                                fastJsonResponse.zax(field, zan(bufferedReader));
                                break;
                            }
                        case 3:
                            if (field.zab) {
                                fastJsonResponse.zas(field, zau(bufferedReader, zai));
                                break;
                            } else {
                                fastJsonResponse.zaq(field, zak(bufferedReader));
                                break;
                            }
                        case 4:
                            if (field.zab) {
                                fastJsonResponse.zao(field, zau(bufferedReader, zaj));
                                break;
                            } else {
                                fastJsonResponse.zam(field, zaj(bufferedReader));
                                break;
                            }
                        case 5:
                            if (field.zab) {
                                fastJsonResponse.zac(field, zau(bufferedReader, zan));
                                break;
                            } else {
                                fastJsonResponse.zaa(field, zas(bufferedReader));
                                break;
                            }
                        case 6:
                            if (field.zab) {
                                fastJsonResponse.zaj(field, zau(bufferedReader, zak));
                                break;
                            } else {
                                fastJsonResponse.zai(field, zay(bufferedReader, false));
                                break;
                            }
                        case 7:
                            if (field.zab) {
                                fastJsonResponse.zaC(field, zau(bufferedReader, zal));
                                break;
                            } else {
                                fastJsonResponse.zaA(field, zao(bufferedReader));
                                break;
                            }
                        case 8:
                            fastJsonResponse.zal(field, Base64Utils.decode(zap(bufferedReader, this.zaq, this.zas, zaf)));
                            break;
                        case 9:
                            fastJsonResponse.zal(field, Base64Utils.decodeUrlSafe(zap(bufferedReader, this.zaq, this.zas, zaf)));
                            break;
                        case 10:
                            char zai2 = zai(bufferedReader);
                            if (zai2 == 'n') {
                                zax(bufferedReader, zaa);
                                hashMap = null;
                            } else if (zai2 == '{') {
                                this.zat.push(1);
                                hashMap = new HashMap();
                                while (true) {
                                    char zai3 = zai(bufferedReader);
                                    if (zai3 == 0) {
                                        throw new ParseException("Unexpected EOF");
                                    }
                                    if (zai3 == '\"') {
                                        String zaA = zaA(bufferedReader, this.zap, this.zar, null);
                                        if (zai(bufferedReader) == ':') {
                                            if (zai(bufferedReader) == '\"') {
                                                hashMap.put(zaA, zaA(bufferedReader, this.zap, this.zar, null));
                                                char zai4 = zai(bufferedReader);
                                                if (zai4 != ',') {
                                                    if (zai4 == '}') {
                                                        zaw(1);
                                                    } else {
                                                        StringBuilder sb = new StringBuilder(48);
                                                        sb.append("Unexpected character while parsing string map: ");
                                                        sb.append(zai4);
                                                        throw new ParseException(sb.toString());
                                                    }
                                                }
                                            } else {
                                                String valueOf = String.valueOf(zaA);
                                                throw new ParseException(valueOf.length() != 0 ? "Expected String value for key ".concat(valueOf) : new String("Expected String value for key "));
                                            }
                                        } else {
                                            String valueOf2 = String.valueOf(zaA);
                                            throw new ParseException(valueOf2.length() != 0 ? "No map value found for key ".concat(valueOf2) : new String("No map value found for key "));
                                        }
                                    } else if (zai3 == '}') {
                                        zaw(1);
                                    }
                                }
                            } else {
                                throw new ParseException("Expected start of a map object");
                            }
                            fastJsonResponse.zaB(field, hashMap);
                            break;
                        case 11:
                            if (field.zab) {
                                char zai5 = zai(bufferedReader);
                                if (zai5 == 'n') {
                                    zax(bufferedReader, zaa);
                                    fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, null);
                                    break;
                                } else {
                                    this.zat.push(5);
                                    if (zai5 == '[') {
                                        fastJsonResponse.addConcreteTypeArrayInternal(field, field.zae, zav(bufferedReader, field));
                                        break;
                                    } else {
                                        throw new ParseException("Expected array start");
                                    }
                                }
                            } else {
                                char zai6 = zai(bufferedReader);
                                if (zai6 == 'n') {
                                    zax(bufferedReader, zaa);
                                    fastJsonResponse.addConcreteTypeInternal(field, field.zae, null);
                                    break;
                                } else {
                                    this.zat.push(1);
                                    if (zai6 == '{') {
                                        try {
                                            FastJsonResponse zad2 = field.zad();
                                            zaz(bufferedReader, zad2);
                                            fastJsonResponse.addConcreteTypeInternal(field, field.zae, zad2);
                                            break;
                                        } catch (IllegalAccessException e) {
                                            throw new ParseException("Error instantiating inner object", e);
                                        } catch (InstantiationException e2) {
                                            throw new ParseException("Error instantiating inner object", e2);
                                        }
                                    } else {
                                        throw new ParseException("Expected start of object");
                                    }
                                }
                            }
                        default:
                            StringBuilder sb2 = new StringBuilder(30);
                            sb2.append("Invalid field type ");
                            sb2.append(i);
                            throw new ParseException(sb2.toString());
                    }
                    zaw(4);
                    zaw(2);
                    char zai7 = zai(bufferedReader);
                    if (zai7 == ',') {
                        zaq = zaq(bufferedReader);
                    } else if (zai7 != '}') {
                        StringBuilder sb3 = new StringBuilder(55);
                        sb3.append("Expected end of object or field separator, but found: ");
                        sb3.append(zai7);
                        throw new ParseException(sb3.toString());
                    } else {
                        zaq = null;
                    }
                }
            }
            zaw(1);
            return true;
        }
        zaw(1);
        return false;
    }

    public void parse(InputStream inputStream, T t) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.zat.push(0);
                char zai2 = zai(bufferedReader);
                if (zai2 != 0) {
                    if (zai2 == '[') {
                        this.zat.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t.getFieldMappings();
                        if (fieldMappings.size() != 1) {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                        FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                        t.addConcreteTypeArrayInternal(value, value.zae, zav(bufferedReader, value));
                    } else if (zai2 == '{') {
                        this.zat.push(1);
                        zaz(bufferedReader, t);
                    } else {
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(zai2);
                        throw new ParseException(sb.toString());
                    }
                    zaw(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        InstrumentInjector.log_w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e) {
                throw new ParseException(e);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                InstrumentInjector.log_w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
