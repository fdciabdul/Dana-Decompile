package com.alibaba.griver.lottie.parser.moshi;

import com.alibaba.griver.lottie.okio.Buffer;
import com.alibaba.griver.lottie.okio.BufferedSource;
import com.alibaba.griver.lottie.okio.ByteString;
import com.alibaba.griver.lottie.parser.moshi.JsonReader;
import id.dana.sendmoney.summary.SummaryActivity;
import java.io.EOFException;
import java.io.IOException;

/* loaded from: classes6.dex */
final class JsonUtf8Reader extends JsonReader {
    private static final long MIN_INCOMPLETE_INTEGER = -922337203685477580L;
    private static final int NUMBER_CHAR_DECIMAL = 3;
    private static final int NUMBER_CHAR_DIGIT = 2;
    private static final int NUMBER_CHAR_EXP_DIGIT = 7;
    private static final int NUMBER_CHAR_EXP_E = 5;
    private static final int NUMBER_CHAR_EXP_SIGN = 6;
    private static final int NUMBER_CHAR_FRACTION_DIGIT = 4;
    private static final int NUMBER_CHAR_NONE = 0;
    private static final int NUMBER_CHAR_SIGN = 1;
    private static final int PEEKED_BEGIN_ARRAY = 3;
    private static final int PEEKED_BEGIN_OBJECT = 1;
    private static final int PEEKED_BUFFERED = 11;
    private static final int PEEKED_BUFFERED_NAME = 15;
    private static final int PEEKED_DOUBLE_QUOTED = 9;
    private static final int PEEKED_DOUBLE_QUOTED_NAME = 13;
    private static final int PEEKED_END_ARRAY = 4;
    private static final int PEEKED_END_OBJECT = 2;
    private static final int PEEKED_EOF = 18;
    private static final int PEEKED_FALSE = 6;
    private static final int PEEKED_LONG = 16;
    private static final int PEEKED_NONE = 0;
    private static final int PEEKED_NULL = 7;
    private static final int PEEKED_NUMBER = 17;
    private static final int PEEKED_SINGLE_QUOTED = 8;
    private static final int PEEKED_SINGLE_QUOTED_NAME = 12;
    private static final int PEEKED_TRUE = 5;
    private static final int PEEKED_UNQUOTED = 10;
    private static final int PEEKED_UNQUOTED_NAME = 14;
    private final Buffer buffer;
    private int peeked = 0;
    private long peekedLong;
    private int peekedNumberLength;
    private String peekedString;
    private final BufferedSource source;
    private static final ByteString SINGLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("'\\");
    private static final ByteString DOUBLE_QUOTE_OR_SLASH = ByteString.encodeUtf8("\"\\");
    private static final ByteString UNQUOTED_STRING_TERMINALS = ByteString.encodeUtf8("{}[]:, \n\t\r\f/\\;#=");
    private static final ByteString LINEFEED_OR_CARRIAGE_RETURN = ByteString.encodeUtf8("\n\r");
    private static final ByteString CLOSING_BLOCK_COMMENT = ByteString.encodeUtf8("*/");

    /* JADX INFO: Access modifiers changed from: package-private */
    public JsonUtf8Reader(BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        this.source = bufferedSource;
        this.buffer = bufferedSource.getBuffer();
        pushScope(6);
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final void beginArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 3) {
            pushScope(1);
            this.pathIndices[this.stackSize - 1] = 0;
            this.peeked = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_ARRAY but was ");
        sb.append(peek());
        sb.append(" at path ");
        sb.append(getPath());
        throw new JsonDataException(sb.toString());
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final void endArray() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 4) {
            this.stackSize--;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_ARRAY but was ");
        sb.append(peek());
        sb.append(" at path ");
        sb.append(getPath());
        throw new JsonDataException(sb.toString());
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final void beginObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 1) {
            pushScope(3);
            this.peeked = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected BEGIN_OBJECT but was ");
        sb.append(peek());
        sb.append(" at path ");
        sb.append(getPath());
        throw new JsonDataException(sb.toString());
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final void endObject() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 2) {
            this.stackSize--;
            this.pathNames[this.stackSize] = null;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            this.peeked = 0;
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected END_OBJECT but was ");
        sb.append(peek());
        sb.append(" at path ");
        sb.append(getPath());
        throw new JsonDataException(sb.toString());
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final boolean hasNext() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        return (i == 2 || i == 4 || i == 18) ? false : true;
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final JsonReader.Token peek() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        switch (i) {
            case 1:
                return JsonReader.Token.BEGIN_OBJECT;
            case 2:
                return JsonReader.Token.END_OBJECT;
            case 3:
                return JsonReader.Token.BEGIN_ARRAY;
            case 4:
                return JsonReader.Token.END_ARRAY;
            case 5:
            case 6:
                return JsonReader.Token.BOOLEAN;
            case 7:
                return JsonReader.Token.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonReader.Token.STRING;
            case 12:
            case 13:
            case 14:
            case 15:
                return JsonReader.Token.NAME;
            case 16:
            case 17:
                return JsonReader.Token.NUMBER;
            case 18:
                return JsonReader.Token.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    private int doPeek() throws IOException {
        int i = this.scopes[this.stackSize - 1];
        if (i == 1) {
            this.scopes[this.stackSize - 1] = 2;
        } else if (i == 2) {
            int nextNonWhitespace = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace != 44) {
                if (nextNonWhitespace != 59) {
                    if (nextNonWhitespace == 93) {
                        this.peeked = 4;
                        return 4;
                    }
                    throw syntaxError("Unterminated array");
                }
                checkLenient();
            }
        } else if (i == 3 || i == 5) {
            this.scopes[this.stackSize - 1] = 4;
            if (i == 5) {
                int nextNonWhitespace2 = nextNonWhitespace(true);
                this.buffer.readByte();
                if (nextNonWhitespace2 != 44) {
                    if (nextNonWhitespace2 != 59) {
                        if (nextNonWhitespace2 == 125) {
                            this.peeked = 2;
                            return 2;
                        }
                        throw syntaxError("Unterminated object");
                    }
                    checkLenient();
                }
            }
            int nextNonWhitespace3 = nextNonWhitespace(true);
            if (nextNonWhitespace3 == 34) {
                this.buffer.readByte();
                this.peeked = 13;
                return 13;
            } else if (nextNonWhitespace3 == 39) {
                this.buffer.readByte();
                checkLenient();
                this.peeked = 12;
                return 12;
            } else if (nextNonWhitespace3 != 125) {
                checkLenient();
                if (isLiteral((char) nextNonWhitespace3)) {
                    this.peeked = 14;
                    return 14;
                }
                throw syntaxError("Expected name");
            } else if (i != 5) {
                this.buffer.readByte();
                this.peeked = 2;
                return 2;
            } else {
                throw syntaxError("Expected name");
            }
        } else if (i == 4) {
            this.scopes[this.stackSize - 1] = 5;
            int nextNonWhitespace4 = nextNonWhitespace(true);
            this.buffer.readByte();
            if (nextNonWhitespace4 != 58) {
                if (nextNonWhitespace4 == 61) {
                    checkLenient();
                    if (this.source.request(1L) && this.buffer.getByte(0L) == 62) {
                        this.buffer.readByte();
                    }
                } else {
                    throw syntaxError("Expected ':'");
                }
            }
        } else if (i == 6) {
            this.scopes[this.stackSize - 1] = 7;
        } else if (i == 7) {
            if (nextNonWhitespace(false) == -1) {
                this.peeked = 18;
                return 18;
            }
            checkLenient();
        } else if (i == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int nextNonWhitespace5 = nextNonWhitespace(true);
        if (nextNonWhitespace5 == 34) {
            this.buffer.readByte();
            this.peeked = 9;
            return 9;
        } else if (nextNonWhitespace5 == 39) {
            checkLenient();
            this.buffer.readByte();
            this.peeked = 8;
            return 8;
        } else {
            if (nextNonWhitespace5 != 44 && nextNonWhitespace5 != 59) {
                if (nextNonWhitespace5 == 91) {
                    this.buffer.readByte();
                    this.peeked = 3;
                    return 3;
                } else if (nextNonWhitespace5 != 93) {
                    if (nextNonWhitespace5 == 123) {
                        this.buffer.readByte();
                        this.peeked = 1;
                        return 1;
                    }
                    int peekKeyword = peekKeyword();
                    if (peekKeyword != 0) {
                        return peekKeyword;
                    }
                    int peekNumber = peekNumber();
                    if (peekNumber != 0) {
                        return peekNumber;
                    }
                    if (!isLiteral(this.buffer.getByte(0L))) {
                        throw syntaxError("Expected value");
                    }
                    checkLenient();
                    this.peeked = 10;
                    return 10;
                } else if (i == 1) {
                    this.buffer.readByte();
                    this.peeked = 4;
                    return 4;
                }
            }
            if (i == 1 || i == 2) {
                checkLenient();
                this.peeked = 7;
                return 7;
            }
            throw syntaxError("Unexpected value");
        }
    }

    private int peekKeyword() throws IOException {
        int i;
        String str;
        String str2;
        byte b = this.buffer.getByte(0L);
        if (b == 116 || b == 84) {
            i = 5;
            str = SummaryActivity.CHECKED;
            str2 = "TRUE";
        } else if (b == 102 || b == 70) {
            i = 6;
            str = "false";
            str2 = "FALSE";
        } else if (b != 110 && b != 78) {
            return 0;
        } else {
            i = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            int i3 = i2 + 1;
            if (!this.source.request(i3)) {
                return 0;
            }
            byte b2 = this.buffer.getByte(i2);
            if (b2 != str.charAt(i2) && b2 != str2.charAt(i2)) {
                return 0;
            }
            i2 = i3;
        }
        if (this.source.request(length + 1) && isLiteral(this.buffer.getByte(length))) {
            return 0;
        }
        this.buffer.skip(length);
        this.peeked = i;
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x007d, code lost:
    
        if (isLiteral(r11) != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0080, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00a2, code lost:
    
        if (r6 != 2) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00a4, code lost:
    
        if (r7 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00aa, code lost:
    
        if (r9 != Long.MIN_VALUE) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ac, code lost:
    
        if (r8 == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00b2, code lost:
    
        if (r9 != 0) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00b4, code lost:
    
        if (r8 != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00b6, code lost:
    
        if (r8 != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00b8, code lost:
    
        r9 = -r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00b9, code lost:
    
        r16.peekedLong = r9;
        r16.buffer.skip(r5);
        r16.peeked = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c5, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c6, code lost:
    
        if (r6 == 2) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00c9, code lost:
    
        if (r6 == 4) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00cc, code lost:
    
        if (r6 == 7) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00ce, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00cf, code lost:
    
        r16.peekedNumberLength = r5;
        r16.peeked = 17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00d5, code lost:
    
        return 17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int peekNumber() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.parser.moshi.JsonUtf8Reader.peekNumber():int");
    }

    private boolean isLiteral(int i) throws IOException {
        if (i == 9 || i == 10 || i == 12 || i == 13 || i == 32) {
            return false;
        }
        if (i != 35) {
            if (i == 44) {
                return false;
            }
            if (i != 47 && i != 61) {
                if (i == 123 || i == 125 || i == 58) {
                    return false;
                }
                if (i != 59) {
                    switch (i) {
                        case 91:
                        case 93:
                            return false;
                        case 92:
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        checkLenient();
        return false;
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final String nextName() throws IOException {
        String str;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            str = nextUnquotedValue();
        } else if (i == 13) {
            str = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 12) {
            str = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i == 15) {
            str = this.peekedString;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a name but was ");
            sb.append(peek());
            sb.append(" at path ");
            sb.append(getPath());
            throw new JsonDataException(sb.toString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = str;
        return str;
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final int selectName(JsonReader.Options options) throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i < 12 || i > 15) {
            return -1;
        }
        if (i == 15) {
            return findName(this.peekedString, options);
        }
        int select = this.source.select(options.doubleQuoteSuffix);
        if (select != -1) {
            this.peeked = 0;
            this.pathNames[this.stackSize - 1] = options.strings[select];
            return select;
        }
        String str = this.pathNames[this.stackSize - 1];
        String nextName = nextName();
        int findName = findName(nextName, options);
        if (findName == -1) {
            this.peeked = 15;
            this.peekedString = nextName;
            this.pathNames[this.stackSize - 1] = str;
        }
        return findName;
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final void skipName() throws IOException {
        if (this.failOnUnknown) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot skip unexpected ");
            sb.append(peek());
            sb.append(" at ");
            sb.append(getPath());
            throw new JsonDataException(sb.toString());
        }
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 14) {
            skipUnquotedValue();
        } else if (i == 13) {
            skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 12) {
            skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i != 15) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected a name but was ");
            sb2.append(peek());
            sb2.append(" at path ");
            sb2.append(getPath());
            throw new JsonDataException(sb2.toString());
        }
        this.peeked = 0;
        this.pathNames[this.stackSize - 1] = "null";
    }

    private int findName(String str, JsonReader.Options options) {
        int length = options.strings.length;
        for (int i = 0; i < length; i++) {
            if (str.equals(options.strings[i])) {
                this.peeked = 0;
                this.pathNames[this.stackSize - 1] = str;
                return i;
            }
        }
        return -1;
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final String nextString() throws IOException {
        String readUtf8;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 10) {
            readUtf8 = nextUnquotedValue();
        } else if (i == 9) {
            readUtf8 = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 8) {
            readUtf8 = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i == 11) {
            readUtf8 = this.peekedString;
            this.peekedString = null;
        } else if (i == 16) {
            readUtf8 = Long.toString(this.peekedLong);
        } else if (i == 17) {
            readUtf8 = this.buffer.readUtf8(this.peekedNumberLength);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a string but was ");
            sb.append(peek());
            sb.append(" at path ");
            sb.append(getPath());
            throw new JsonDataException(sb.toString());
        }
        this.peeked = 0;
        int[] iArr = this.pathIndices;
        int i2 = this.stackSize - 1;
        iArr[i2] = iArr[i2] + 1;
        return readUtf8;
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final boolean nextBoolean() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 5) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return true;
        } else if (i == 6) {
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return false;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a boolean but was ");
            sb.append(peek());
            sb.append(" at path ");
            sb.append(getPath());
            throw new JsonDataException(sb.toString());
        }
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final double nextDouble() throws IOException {
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 16) {
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i2 = this.stackSize - 1;
            iArr[i2] = iArr[i2] + 1;
            return this.peekedLong;
        }
        if (i == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (i == 9) {
            this.peekedString = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
        } else if (i == 8) {
            this.peekedString = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
        } else if (i == 10) {
            this.peekedString = nextUnquotedValue();
        } else if (i != 11) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected a double but was ");
            sb.append(peek());
            sb.append(" at path ");
            sb.append(getPath());
            throw new JsonDataException(sb.toString());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            if (!this.lenient && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("JSON forbids NaN and infinities: ");
                sb2.append(parseDouble);
                sb2.append(" at path ");
                sb2.append(getPath());
                throw new JsonEncodingException(sb2.toString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr2 = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr2[i3] = iArr2[i3] + 1;
            return parseDouble;
        } catch (NumberFormatException unused) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Expected a double but was ");
            sb3.append(this.peekedString);
            sb3.append(" at path ");
            sb3.append(getPath());
            throw new JsonDataException(sb3.toString());
        }
    }

    private String nextQuotedValue(ByteString byteString) throws IOException {
        StringBuilder sb = null;
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw syntaxError("Unterminated string");
            }
            if (this.buffer.getByte(indexOfElement) != 92) {
                if (sb == null) {
                    String readUtf8 = this.buffer.readUtf8(indexOfElement);
                    this.buffer.readByte();
                    return readUtf8;
                }
                sb.append(this.buffer.readUtf8(indexOfElement));
                this.buffer.readByte();
                return sb.toString();
            }
            if (sb == null) {
                sb = new StringBuilder();
            }
            sb.append(this.buffer.readUtf8(indexOfElement));
            this.buffer.readByte();
            sb.append(readEscapeCharacter());
        }
    }

    private String nextUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        return indexOfElement != -1 ? this.buffer.readUtf8(indexOfElement) : this.buffer.readUtf8();
    }

    private void skipQuotedValue(ByteString byteString) throws IOException {
        while (true) {
            long indexOfElement = this.source.indexOfElement(byteString);
            if (indexOfElement == -1) {
                throw syntaxError("Unterminated string");
            }
            if (this.buffer.getByte(indexOfElement) == 92) {
                this.buffer.skip(indexOfElement + 1);
                readEscapeCharacter();
            } else {
                this.buffer.skip(indexOfElement + 1);
                return;
            }
        }
    }

    private void skipUnquotedValue() throws IOException {
        long indexOfElement = this.source.indexOfElement(UNQUOTED_STRING_TERMINALS);
        Buffer buffer = this.buffer;
        if (indexOfElement == -1) {
            indexOfElement = buffer.size();
        }
        buffer.skip(indexOfElement);
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final int nextInt() throws IOException {
        String nextQuotedValue;
        int i = this.peeked;
        if (i == 0) {
            i = doPeek();
        }
        if (i == 16) {
            long j = this.peekedLong;
            int i2 = (int) j;
            if (j != i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("Expected an int but was ");
                sb.append(this.peekedLong);
                sb.append(" at path ");
                sb.append(getPath());
                throw new JsonDataException(sb.toString());
            }
            this.peeked = 0;
            int[] iArr = this.pathIndices;
            int i3 = this.stackSize - 1;
            iArr[i3] = iArr[i3] + 1;
            return i2;
        }
        if (i == 17) {
            this.peekedString = this.buffer.readUtf8(this.peekedNumberLength);
        } else if (i == 9 || i == 8) {
            if (i == 9) {
                nextQuotedValue = nextQuotedValue(DOUBLE_QUOTE_OR_SLASH);
            } else {
                nextQuotedValue = nextQuotedValue(SINGLE_QUOTE_OR_SLASH);
            }
            this.peekedString = nextQuotedValue;
            try {
                int parseInt = Integer.parseInt(nextQuotedValue);
                this.peeked = 0;
                int[] iArr2 = this.pathIndices;
                int i4 = this.stackSize - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        } else if (i != 11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Expected an int but was ");
            sb2.append(peek());
            sb2.append(" at path ");
            sb2.append(getPath());
            throw new JsonDataException(sb2.toString());
        }
        this.peeked = 11;
        try {
            double parseDouble = Double.parseDouble(this.peekedString);
            int i5 = (int) parseDouble;
            if (i5 != parseDouble) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Expected an int but was ");
                sb3.append(this.peekedString);
                sb3.append(" at path ");
                sb3.append(getPath());
                throw new JsonDataException(sb3.toString());
            }
            this.peekedString = null;
            this.peeked = 0;
            int[] iArr3 = this.pathIndices;
            int i6 = this.stackSize - 1;
            iArr3[i6] = iArr3[i6] + 1;
            return i5;
        } catch (NumberFormatException unused2) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("Expected an int but was ");
            sb4.append(this.peekedString);
            sb4.append(" at path ");
            sb4.append(getPath());
            throw new JsonDataException(sb4.toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.peeked = 0;
        this.scopes[0] = 8;
        this.stackSize = 1;
        this.buffer.clear();
        this.source.close();
    }

    @Override // com.alibaba.griver.lottie.parser.moshi.JsonReader
    public final void skipValue() throws IOException {
        if (this.failOnUnknown) {
            StringBuilder sb = new StringBuilder();
            sb.append("Cannot skip unexpected ");
            sb.append(peek());
            sb.append(" at ");
            sb.append(getPath());
            throw new JsonDataException(sb.toString());
        }
        int i = 0;
        do {
            int i2 = this.peeked;
            if (i2 == 0) {
                i2 = doPeek();
            }
            if (i2 == 3) {
                pushScope(1);
            } else if (i2 == 1) {
                pushScope(3);
            } else {
                if (i2 == 4) {
                    i--;
                    if (i < 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected a value but was ");
                        sb2.append(peek());
                        sb2.append(" at path ");
                        sb2.append(getPath());
                        throw new JsonDataException(sb2.toString());
                    }
                    this.stackSize--;
                } else if (i2 == 2) {
                    i--;
                    if (i < 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("Expected a value but was ");
                        sb3.append(peek());
                        sb3.append(" at path ");
                        sb3.append(getPath());
                        throw new JsonDataException(sb3.toString());
                    }
                    this.stackSize--;
                } else if (i2 == 14 || i2 == 10) {
                    skipUnquotedValue();
                } else if (i2 == 9 || i2 == 13) {
                    skipQuotedValue(DOUBLE_QUOTE_OR_SLASH);
                } else if (i2 == 8 || i2 == 12) {
                    skipQuotedValue(SINGLE_QUOTE_OR_SLASH);
                } else if (i2 == 17) {
                    this.buffer.skip(this.peekedNumberLength);
                } else if (i2 == 18) {
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Expected a value but was ");
                    sb4.append(peek());
                    sb4.append(" at path ");
                    sb4.append(getPath());
                    throw new JsonDataException(sb4.toString());
                }
                this.peeked = 0;
            }
            i++;
            this.peeked = 0;
        } while (i != 0);
        int[] iArr = this.pathIndices;
        int i3 = this.stackSize - 1;
        iArr[i3] = iArr[i3] + 1;
        this.pathNames[this.stackSize - 1] = "null";
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
    
        r5.buffer.skip((long) (r2 - 1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
    
        if (r0 != 47) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0037, code lost:
    
        if (r5.source.request(2) != false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0039, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003a, code lost:
    
        checkLenient();
        r2 = r5.buffer.getByte(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0047, code lost:
    
        if (r2 == 42) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        if (r2 == 47) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004c, code lost:
    
        r5.buffer.readByte();
        r5.buffer.readByte();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005a, code lost:
    
        r5.buffer.readByte();
        r5.buffer.readByte();
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0068, code lost:
    
        if (skipToEndOfBlockComment() == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0071, code lost:
    
        throw syntaxError("Unterminated comment");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0074, code lost:
    
        if (r0 != 35) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0076, code lost:
    
        checkLenient();
        skipToEndOfLine();
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x007d, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int nextNonWhitespace(boolean r6) throws java.io.IOException {
        /*
            r5 = this;
        L0:
            r0 = 0
        L1:
            com.alibaba.griver.lottie.okio.BufferedSource r1 = r5.source
            int r2 = r0 + 1
            long r3 = (long) r2
            boolean r1 = r1.request(r3)
            if (r1 == 0) goto L80
            com.alibaba.griver.lottie.okio.Buffer r1 = r5.buffer
            long r3 = (long) r0
            byte r0 = r1.getByte(r3)
            r1 = 10
            if (r0 == r1) goto L7e
            r1 = 32
            if (r0 == r1) goto L7e
            r1 = 13
            if (r0 == r1) goto L7e
            r1 = 9
            if (r0 == r1) goto L7e
            com.alibaba.griver.lottie.okio.Buffer r1 = r5.buffer
            int r2 = r2 + (-1)
            long r2 = (long) r2
            r1.skip(r2)
            r1 = 47
            if (r0 != r1) goto L72
            com.alibaba.griver.lottie.okio.BufferedSource r2 = r5.source
            r3 = 2
            boolean r2 = r2.request(r3)
            if (r2 != 0) goto L3a
            return r0
        L3a:
            r5.checkLenient()
            com.alibaba.griver.lottie.okio.Buffer r2 = r5.buffer
            r3 = 1
            byte r2 = r2.getByte(r3)
            r3 = 42
            if (r2 == r3) goto L5a
            if (r2 == r1) goto L4c
            return r0
        L4c:
            com.alibaba.griver.lottie.okio.Buffer r0 = r5.buffer
            r0.readByte()
            com.alibaba.griver.lottie.okio.Buffer r0 = r5.buffer
            r0.readByte()
            r5.skipToEndOfLine()
            goto L0
        L5a:
            com.alibaba.griver.lottie.okio.Buffer r0 = r5.buffer
            r0.readByte()
            com.alibaba.griver.lottie.okio.Buffer r0 = r5.buffer
            r0.readByte()
            boolean r0 = r5.skipToEndOfBlockComment()
            if (r0 == 0) goto L6b
            goto L0
        L6b:
            java.lang.String r6 = "Unterminated comment"
            com.alibaba.griver.lottie.parser.moshi.JsonEncodingException r6 = r5.syntaxError(r6)
            throw r6
        L72:
            r1 = 35
            if (r0 != r1) goto L7d
            r5.checkLenient()
            r5.skipToEndOfLine()
            goto L0
        L7d:
            return r0
        L7e:
            r0 = r2
            goto L1
        L80:
            if (r6 != 0) goto L84
            r6 = -1
            return r6
        L84:
            java.io.EOFException r6 = new java.io.EOFException
            java.lang.String r0 = "End of input"
            r6.<init>(r0)
            goto L8d
        L8c:
            throw r6
        L8d:
            goto L8c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.lottie.parser.moshi.JsonUtf8Reader.nextNonWhitespace(boolean):int");
    }

    private void checkLenient() throws IOException {
        if (!this.lenient) {
            throw syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void skipToEndOfLine() throws IOException {
        long indexOfElement = this.source.indexOfElement(LINEFEED_OR_CARRIAGE_RETURN);
        Buffer buffer = this.buffer;
        buffer.skip(indexOfElement != -1 ? indexOfElement + 1 : buffer.size());
    }

    private boolean skipToEndOfBlockComment() throws IOException {
        long indexOf = this.source.indexOf(CLOSING_BLOCK_COMMENT);
        boolean z = indexOf != -1;
        Buffer buffer = this.buffer;
        buffer.skip(z ? indexOf + r1.size() : buffer.size());
        return z;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JsonReader(");
        sb.append(this.source);
        sb.append(")");
        return sb.toString();
    }

    private char readEscapeCharacter() throws IOException {
        int i;
        int i2;
        if (!this.source.request(1L)) {
            throw syntaxError("Unterminated escape sequence");
        }
        byte readByte = this.buffer.readByte();
        if (readByte == 10 || readByte == 34 || readByte == 39 || readByte == 47 || readByte == 92) {
            return (char) readByte;
        }
        if (readByte != 98) {
            if (readByte != 102) {
                if (readByte != 110) {
                    if (readByte != 114) {
                        if (readByte != 116) {
                            if (readByte == 117) {
                                if (!this.source.request(4L)) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("Unterminated escape sequence at path ");
                                    sb.append(getPath());
                                    throw new EOFException(sb.toString());
                                }
                                char c = 0;
                                for (int i3 = 0; i3 < 4; i3++) {
                                    byte b = this.buffer.getByte(i3);
                                    char c2 = (char) (c << 4);
                                    if (b < 48 || b > 57) {
                                        if (b >= 97 && b <= 102) {
                                            i = b - 97;
                                        } else if (b < 65 || b > 70) {
                                            StringBuilder sb2 = new StringBuilder();
                                            sb2.append("\\u");
                                            sb2.append(this.buffer.readUtf8(4L));
                                            throw syntaxError(sb2.toString());
                                        } else {
                                            i = b - 65;
                                        }
                                        i2 = i + 10;
                                    } else {
                                        i2 = b - 48;
                                    }
                                    c = (char) (c2 + i2);
                                }
                                this.buffer.skip(4L);
                                return c;
                            } else if (this.lenient) {
                                return (char) readByte;
                            } else {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Invalid escape sequence: \\");
                                sb3.append((char) readByte);
                                throw syntaxError(sb3.toString());
                            }
                        }
                        return '\t';
                    }
                    return '\r';
                }
                return '\n';
            }
            return '\f';
        }
        return '\b';
    }
}
