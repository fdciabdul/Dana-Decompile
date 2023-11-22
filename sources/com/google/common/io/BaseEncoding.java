package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public abstract class BaseEncoding {
    private static final BaseEncoding BASE64 = new Base64Encoding("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    private static final BaseEncoding BASE64_URL = new Base64Encoding("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    private static final BaseEncoding BASE32 = new StandardBaseEncoding("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    private static final BaseEncoding BASE32_HEX = new StandardBaseEncoding("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    private static final BaseEncoding BASE16 = new Base16Encoding("base16()", "0123456789ABCDEF");

    public abstract boolean canDecode(CharSequence charSequence);

    abstract int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException;

    public abstract InputStream decodingStream(Reader reader);

    abstract void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException;

    public abstract OutputStream encodingStream(Writer writer);

    public abstract BaseEncoding ignoreCase();

    public abstract BaseEncoding lowerCase();

    abstract int maxDecodedSize(int i);

    abstract int maxEncodedSize(int i);

    public abstract BaseEncoding omitPadding();

    public abstract BaseEncoding upperCase();

    public abstract BaseEncoding withPadChar(char c);

    public abstract BaseEncoding withSeparator(String str, int i);

    BaseEncoding() {
    }

    /* loaded from: classes7.dex */
    public static final class DecodingException extends IOException {
        public DecodingException(String str) {
            super(str);
        }

        DecodingException(Throwable th) {
            super(th);
        }
    }

    public String encode(byte[] bArr) {
        return encode(bArr, 0, bArr.length);
    }

    public final String encode(byte[] bArr, int i, int i2) {
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(maxEncodedSize(i2));
        try {
            encodeTo(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public final ByteSink encodingSink(final CharSink charSink) {
        Preconditions.checkNotNull(charSink);
        return new ByteSink() { // from class: com.google.common.io.BaseEncoding.1
            @Override // com.google.common.io.ByteSink
            public OutputStream openStream() throws IOException {
                return BaseEncoding.this.encodingStream(charSink.openStream());
            }
        };
    }

    private static byte[] extract(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public final byte[] decode(CharSequence charSequence) {
        try {
            return decodeChecked(charSequence);
        } catch (DecodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    final byte[] decodeChecked(CharSequence charSequence) throws DecodingException {
        CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
        byte[] bArr = new byte[maxDecodedSize(trimTrailingPadding.length())];
        return extract(bArr, decodeTo(bArr, trimTrailingPadding));
    }

    public final ByteSource decodingSource(final CharSource charSource) {
        Preconditions.checkNotNull(charSource);
        return new ByteSource() { // from class: com.google.common.io.BaseEncoding.2
            @Override // com.google.common.io.ByteSource
            public InputStream openStream() throws IOException {
                return BaseEncoding.this.decodingStream(charSource.openStream());
            }
        };
    }

    CharSequence trimTrailingPadding(CharSequence charSequence) {
        return (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    public static BaseEncoding base64() {
        return BASE64;
    }

    public static BaseEncoding base64Url() {
        return BASE64_URL;
    }

    public static BaseEncoding base32() {
        return BASE32;
    }

    public static BaseEncoding base32Hex() {
        return BASE32_HEX;
    }

    public static BaseEncoding base16() {
        return BASE16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static final class Alphabet {
        final int bitsPerChar;
        final int bytesPerChunk;
        private final char[] chars;
        final int charsPerChunk;
        private final byte[] decodabet;
        private final boolean ignoreCase;
        final int mask;
        private final String name;
        private final boolean[] validPadding;

        Alphabet(String str, char[] cArr) {
            this(str, cArr, decodabetFor(cArr), false);
        }

        private Alphabet(String str, char[] cArr, byte[] bArr, boolean z) {
            this.name = (String) Preconditions.checkNotNull(str);
            this.chars = (char[]) Preconditions.checkNotNull(cArr);
            try {
                int log2 = IntMath.log2(cArr.length, RoundingMode.UNNECESSARY);
                this.bitsPerChar = log2;
                int numberOfTrailingZeros = Integer.numberOfTrailingZeros(log2);
                int i = 1 << (3 - numberOfTrailingZeros);
                this.charsPerChunk = i;
                this.bytesPerChunk = log2 >> numberOfTrailingZeros;
                this.mask = cArr.length - 1;
                this.decodabet = bArr;
                boolean[] zArr = new boolean[i];
                for (int i2 = 0; i2 < this.bytesPerChunk; i2++) {
                    zArr[IntMath.divide(i2 * 8, this.bitsPerChar, RoundingMode.CEILING)] = true;
                }
                this.validPadding = zArr;
                this.ignoreCase = z;
            } catch (ArithmeticException e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal alphabet length ");
                sb.append(cArr.length);
                throw new IllegalArgumentException(sb.toString(), e);
            }
        }

        private static byte[] decodabetFor(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i = 0; i < cArr.length; i++) {
                char c = cArr[i];
                boolean z = true;
                Preconditions.checkArgument(c < 128, "Non-ASCII character: %s", c);
                if (bArr[c] != -1) {
                    z = false;
                }
                Preconditions.checkArgument(z, "Duplicate character: %s", c);
                bArr[c] = (byte) i;
            }
            return bArr;
        }

        final Alphabet ignoreCase() {
            if (this.ignoreCase) {
                return this;
            }
            byte[] bArr = this.decodabet;
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            int i = 65;
            while (true) {
                if (i <= 90) {
                    int i2 = i | 32;
                    byte[] bArr2 = this.decodabet;
                    byte b = bArr2[i];
                    byte b2 = bArr2[i2];
                    if (b == -1) {
                        copyOf[i] = b2;
                    } else {
                        Preconditions.checkState(b2 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i, (char) i2);
                        copyOf[i2] = b;
                    }
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.name);
                    sb.append(".ignoreCase()");
                    return new Alphabet(sb.toString(), this.chars, copyOf, true);
                }
            }
        }

        final char encode(int i) {
            return this.chars[i];
        }

        final boolean isValidPaddingStartPosition(int i) {
            return this.validPadding[i % this.charsPerChunk];
        }

        final boolean canDecode(char c) {
            return c <= 127 && this.decodabet[c] != -1;
        }

        final int decode(char c) throws DecodingException {
            if (c > 127) {
                StringBuilder sb = new StringBuilder();
                sb.append("Unrecognized character: 0x");
                sb.append(Integer.toHexString(c));
                throw new DecodingException(sb.toString());
            }
            byte b = this.decodabet[c];
            if (b == -1) {
                if (c <= ' ' || c == 127) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Unrecognized character: 0x");
                    sb2.append(Integer.toHexString(c));
                    throw new DecodingException(sb2.toString());
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Unrecognized character: ");
                sb3.append(c);
                throw new DecodingException(sb3.toString());
            }
            return b;
        }

        private boolean hasLowerCase() {
            for (char c : this.chars) {
                if (Ascii.isLowerCase(c)) {
                    return true;
                }
            }
            return false;
        }

        private boolean hasUpperCase() {
            for (char c : this.chars) {
                if (Ascii.isUpperCase(c)) {
                    return true;
                }
            }
            return false;
        }

        final Alphabet upperCase() {
            if (hasLowerCase()) {
                Preconditions.checkState(!hasUpperCase(), "Cannot call upperCase() on a mixed-case alphabet");
                char[] cArr = new char[this.chars.length];
                int i = 0;
                while (true) {
                    char[] cArr2 = this.chars;
                    if (i >= cArr2.length) {
                        break;
                    }
                    cArr[i] = Ascii.toUpperCase(cArr2[i]);
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.name);
                sb.append(".upperCase()");
                Alphabet alphabet = new Alphabet(sb.toString(), cArr);
                return this.ignoreCase ? alphabet.ignoreCase() : alphabet;
            }
            return this;
        }

        final Alphabet lowerCase() {
            if (hasUpperCase()) {
                Preconditions.checkState(!hasLowerCase(), "Cannot call lowerCase() on a mixed-case alphabet");
                char[] cArr = new char[this.chars.length];
                int i = 0;
                while (true) {
                    char[] cArr2 = this.chars;
                    if (i >= cArr2.length) {
                        break;
                    }
                    cArr[i] = Ascii.toLowerCase(cArr2[i]);
                    i++;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.name);
                sb.append(".lowerCase()");
                Alphabet alphabet = new Alphabet(sb.toString(), cArr);
                return this.ignoreCase ? alphabet.ignoreCase() : alphabet;
            }
            return this;
        }

        public final boolean matches(char c) {
            byte[] bArr = this.decodabet;
            return c < bArr.length && bArr[c] != -1;
        }

        public final String toString() {
            return this.name;
        }

        public final boolean equals(@CheckForNull Object obj) {
            if (obj instanceof Alphabet) {
                Alphabet alphabet = (Alphabet) obj;
                return this.ignoreCase == alphabet.ignoreCase && Arrays.equals(this.chars, alphabet.chars);
            }
            return false;
        }

        public final int hashCode() {
            return Arrays.hashCode(this.chars) + (this.ignoreCase ? 1231 : 1237);
        }
    }

    /* loaded from: classes7.dex */
    static class StandardBaseEncoding extends BaseEncoding {
        final Alphabet alphabet;
        @CheckForNull
        @LazyInit
        private volatile BaseEncoding ignoreCase;
        @CheckForNull
        @LazyInit
        private volatile BaseEncoding lowerCase;
        @CheckForNull
        final Character paddingChar;
        @CheckForNull
        @LazyInit
        private volatile BaseEncoding upperCase;

        StandardBaseEncoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        StandardBaseEncoding(Alphabet alphabet, @CheckForNull Character ch) {
            this.alphabet = (Alphabet) Preconditions.checkNotNull(alphabet);
            Preconditions.checkArgument(ch == null || !alphabet.matches(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.paddingChar = ch;
        }

        @Override // com.google.common.io.BaseEncoding
        int maxEncodedSize(int i) {
            return this.alphabet.charsPerChunk * IntMath.divide(i, this.alphabet.bytesPerChunk, RoundingMode.CEILING);
        }

        @Override // com.google.common.io.BaseEncoding
        public OutputStream encodingStream(final Writer writer) {
            Preconditions.checkNotNull(writer);
            return new OutputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.1
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int writtenChars = 0;

                @Override // java.io.OutputStream
                public void write(int i) throws IOException {
                    this.bitBuffer = (i & 255) | (this.bitBuffer << 8);
                    this.bitBufferLength += 8;
                    while (this.bitBufferLength >= StandardBaseEncoding.this.alphabet.bitsPerChar) {
                        writer.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer >> (this.bitBufferLength - StandardBaseEncoding.this.alphabet.bitsPerChar)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        this.bitBufferLength -= StandardBaseEncoding.this.alphabet.bitsPerChar;
                    }
                }

                @Override // java.io.OutputStream, java.io.Flushable
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    if (this.bitBufferLength > 0) {
                        writer.write(StandardBaseEncoding.this.alphabet.encode((this.bitBuffer << (StandardBaseEncoding.this.alphabet.bitsPerChar - this.bitBufferLength)) & StandardBaseEncoding.this.alphabet.mask));
                        this.writtenChars++;
                        if (StandardBaseEncoding.this.paddingChar != null) {
                            while (this.writtenChars % StandardBaseEncoding.this.alphabet.charsPerChunk != 0) {
                                writer.write(StandardBaseEncoding.this.paddingChar.charValue());
                                this.writtenChars++;
                            }
                        }
                    }
                    writer.close();
                }
            };
        }

        @Override // com.google.common.io.BaseEncoding
        void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                encodeChunkTo(appendable, bArr, i + i3, Math.min(this.alphabet.bytesPerChunk, i2 - i3));
                i3 += this.alphabet.bytesPerChunk;
            }
        }

        void encodeChunkTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            int i3 = 0;
            Preconditions.checkArgument(i2 <= this.alphabet.bytesPerChunk);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | (bArr[i + i4] & 255)) << 8;
            }
            int i5 = this.alphabet.bitsPerChar;
            while (i3 < i2 * 8) {
                appendable.append(this.alphabet.encode(((int) (j >>> ((((i2 + 1) * 8) - i5) - i3))) & this.alphabet.mask));
                i3 += this.alphabet.bitsPerChar;
            }
            if (this.paddingChar != null) {
                while (i3 < this.alphabet.bytesPerChunk * 8) {
                    appendable.append(this.paddingChar.charValue());
                    i3 += this.alphabet.bitsPerChar;
                }
            }
        }

        @Override // com.google.common.io.BaseEncoding
        int maxDecodedSize(int i) {
            return (int) (((this.alphabet.bitsPerChar * i) + 7) / 8);
        }

        @Override // com.google.common.io.BaseEncoding
        CharSequence trimTrailingPadding(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            Character ch = this.paddingChar;
            if (ch == null) {
                return charSequence;
            }
            char charValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == charValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        @Override // com.google.common.io.BaseEncoding
        public boolean canDecode(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                for (int i = 0; i < trimTrailingPadding.length(); i++) {
                    if (!this.alphabet.canDecode(trimTrailingPadding.charAt(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        @Override // com.google.common.io.BaseEncoding
        int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid input length ");
                sb.append(trimTrailingPadding.length());
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < trimTrailingPadding.length()) {
                long j = 0;
                int i3 = 0;
                for (int i4 = 0; i4 < this.alphabet.charsPerChunk; i4++) {
                    j <<= this.alphabet.bitsPerChar;
                    if (i + i4 < trimTrailingPadding.length()) {
                        j |= this.alphabet.decode(trimTrailingPadding.charAt(i3 + i));
                        i3++;
                    }
                }
                int i5 = this.alphabet.bytesPerChunk;
                int i6 = this.alphabet.bitsPerChar;
                int i7 = (this.alphabet.bytesPerChunk - 1) * 8;
                while (i7 >= (i5 * 8) - (i3 * i6)) {
                    bArr[i2] = (byte) ((j >>> i7) & 255);
                    i7 -= 8;
                    i2++;
                }
                i += this.alphabet.charsPerChunk;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding
        public InputStream decodingStream(final Reader reader) {
            Preconditions.checkNotNull(reader);
            return new InputStream() { // from class: com.google.common.io.BaseEncoding.StandardBaseEncoding.2
                int bitBuffer = 0;
                int bitBufferLength = 0;
                int readChars = 0;
                boolean hitPadding = false;

                /* JADX WARN: Code restructure failed: missing block: B:23:0x0061, code lost:
                
                    r0 = new java.lang.StringBuilder();
                    r0.append("Padding cannot start at index ");
                    r0.append(r3.readChars);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
                
                    throw new com.google.common.io.BaseEncoding.DecodingException(r0.toString());
                 */
                @Override // java.io.InputStream
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public int read() throws java.io.IOException {
                    /*
                        r3 = this;
                    L0:
                        java.io.Reader r0 = r2
                        int r0 = r0.read()
                        r1 = -1
                        if (r0 != r1) goto L34
                        boolean r0 = r3.hitPadding
                        if (r0 != 0) goto L33
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.alphabet
                        int r2 = r3.readChars
                        boolean r0 = r0.isValidPaddingStartPosition(r2)
                        if (r0 == 0) goto L1a
                        goto L33
                    L1a:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "Invalid input length "
                        r0.append(r1)
                        int r1 = r3.readChars
                        r0.append(r1)
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.String r0 = r0.toString()
                        r1.<init>(r0)
                        throw r1
                    L33:
                        return r1
                    L34:
                        int r1 = r3.readChars
                        r2 = 1
                        int r1 = r1 + r2
                        r3.readChars = r1
                        char r0 = (char) r0
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.paddingChar
                        if (r1 == 0) goto L7d
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        java.lang.Character r1 = r1.paddingChar
                        char r1 = r1.charValue()
                        if (r1 != r0) goto L7d
                        boolean r0 = r3.hitPadding
                        if (r0 != 0) goto L7a
                        int r0 = r3.readChars
                        if (r0 == r2) goto L61
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r0 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r0 = r0.alphabet
                        int r1 = r3.readChars
                        int r1 = r1 - r2
                        boolean r0 = r0.isValidPaddingStartPosition(r1)
                        if (r0 == 0) goto L61
                        goto L7a
                    L61:
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = "Padding cannot start at index "
                        r0.append(r1)
                        int r1 = r3.readChars
                        r0.append(r1)
                        com.google.common.io.BaseEncoding$DecodingException r1 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.String r0 = r0.toString()
                        r1.<init>(r0)
                        throw r1
                    L7a:
                        r3.hitPadding = r2
                        goto L0
                    L7d:
                        boolean r1 = r3.hitPadding
                        if (r1 != 0) goto Lb1
                        int r1 = r3.bitBuffer
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r2 = r2.bitsPerChar
                        int r1 = r1 << r2
                        r3.bitBuffer = r1
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r2 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r2 = r2.alphabet
                        int r0 = r2.decode(r0)
                        r0 = r0 | r1
                        r3.bitBuffer = r0
                        int r0 = r3.bitBufferLength
                        com.google.common.io.BaseEncoding$StandardBaseEncoding r1 = com.google.common.io.BaseEncoding.StandardBaseEncoding.this
                        com.google.common.io.BaseEncoding$Alphabet r1 = r1.alphabet
                        int r1 = r1.bitsPerChar
                        int r0 = r0 + r1
                        r3.bitBufferLength = r0
                        r1 = 8
                        if (r0 < r1) goto L0
                        int r0 = r0 + (-8)
                        r3.bitBufferLength = r0
                        int r1 = r3.bitBuffer
                        int r0 = r1 >> r0
                        r0 = r0 & 255(0xff, float:3.57E-43)
                        return r0
                    Lb1:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        r1.<init>()
                        java.lang.String r2 = "Expected padding character but found '"
                        r1.append(r2)
                        r1.append(r0)
                        java.lang.String r0 = "' at index "
                        r1.append(r0)
                        int r0 = r3.readChars
                        r1.append(r0)
                        com.google.common.io.BaseEncoding$DecodingException r0 = new com.google.common.io.BaseEncoding$DecodingException
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        goto Ld3
                    Ld2:
                        throw r0
                    Ld3:
                        goto Ld2
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.BaseEncoding.StandardBaseEncoding.AnonymousClass2.read():int");
                }

                @Override // java.io.InputStream
                public int read(byte[] bArr, int i, int i2) throws IOException {
                    int i3 = i2 + i;
                    Preconditions.checkPositionIndexes(i, i3, bArr.length);
                    int i4 = i;
                    while (i4 < i3) {
                        int read = read();
                        if (read == -1) {
                            int i5 = i4 - i;
                            if (i5 == 0) {
                                return -1;
                            }
                            return i5;
                        }
                        bArr[i4] = (byte) read;
                        i4++;
                    }
                    return i4 - i;
                }

                @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    reader.close();
                }
            };
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding omitPadding() {
            return this.paddingChar == null ? this : newInstance(this.alphabet, null);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withPadChar(char c) {
            Character ch;
            return (8 % this.alphabet.bitsPerChar == 0 || ((ch = this.paddingChar) != null && ch.charValue() == c)) ? this : newInstance(this.alphabet, Character.valueOf(c));
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding withSeparator(String str, int i) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                Preconditions.checkArgument(!this.alphabet.matches(str.charAt(i2)), "Separator (%s) cannot contain alphabet characters", str);
            }
            Character ch = this.paddingChar;
            if (ch != null) {
                Preconditions.checkArgument(str.indexOf(ch.charValue()) < 0, "Separator (%s) cannot contain padding character", str);
            }
            return new SeparatedBaseEncoding(this, str, i);
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding upperCase() {
            BaseEncoding baseEncoding = this.upperCase;
            if (baseEncoding == null) {
                Alphabet upperCase = this.alphabet.upperCase();
                baseEncoding = upperCase == this.alphabet ? this : newInstance(upperCase, this.paddingChar);
                this.upperCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding lowerCase() {
            BaseEncoding baseEncoding = this.lowerCase;
            if (baseEncoding == null) {
                Alphabet lowerCase = this.alphabet.lowerCase();
                baseEncoding = lowerCase == this.alphabet ? this : newInstance(lowerCase, this.paddingChar);
                this.lowerCase = baseEncoding;
            }
            return baseEncoding;
        }

        @Override // com.google.common.io.BaseEncoding
        public BaseEncoding ignoreCase() {
            BaseEncoding baseEncoding = this.ignoreCase;
            if (baseEncoding == null) {
                Alphabet ignoreCase = this.alphabet.ignoreCase();
                baseEncoding = ignoreCase == this.alphabet ? this : newInstance(ignoreCase, this.paddingChar);
                this.ignoreCase = baseEncoding;
            }
            return baseEncoding;
        }

        BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new StandardBaseEncoding(alphabet, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.alphabet);
            if (8 % this.alphabet.bitsPerChar != 0) {
                if (this.paddingChar == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.paddingChar);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof StandardBaseEncoding) {
                StandardBaseEncoding standardBaseEncoding = (StandardBaseEncoding) obj;
                return this.alphabet.equals(standardBaseEncoding.alphabet) && Objects.equals(this.paddingChar, standardBaseEncoding.paddingChar);
            }
            return false;
        }

        public int hashCode() {
            return this.alphabet.hashCode() ^ Objects.hashCode(this.paddingChar);
        }
    }

    /* loaded from: classes7.dex */
    static final class Base16Encoding extends StandardBaseEncoding {
        final char[] encoding;

        Base16Encoding(String str, String str2) {
            this(new Alphabet(str, str2.toCharArray()));
        }

        private Base16Encoding(Alphabet alphabet) {
            super(alphabet, null);
            this.encoding = new char[512];
            Preconditions.checkArgument(alphabet.chars.length == 16);
            for (int i = 0; i < 256; i++) {
                this.encoding[i] = alphabet.encode(i >>> 4);
                this.encoding[i | 256] = alphabet.encode(i & 15);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        final void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.encoding[i4]);
                appendable.append(this.encoding[i4 | 256]);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        final int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            if (charSequence.length() % 2 == 1) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid input length ");
                sb.append(charSequence.length());
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((this.alphabet.decode(charSequence.charAt(i)) << 4) | this.alphabet.decode(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        final BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base16Encoding(alphabet);
        }
    }

    /* loaded from: classes7.dex */
    static final class Base64Encoding extends StandardBaseEncoding {
        Base64Encoding(String str, String str2, @CheckForNull Character ch) {
            this(new Alphabet(str, str2.toCharArray()), ch);
        }

        private Base64Encoding(Alphabet alphabet, @CheckForNull Character ch) {
            super(alphabet, ch);
            Preconditions.checkArgument(alphabet.chars.length == 64);
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        final void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            Preconditions.checkNotNull(appendable);
            int i3 = i + i2;
            Preconditions.checkPositionIndexes(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 1;
                int i5 = i4 + 1;
                int i6 = ((bArr[i] & 255) << 16) | ((bArr[i4] & 255) << 8) | (bArr[i5] & 255);
                appendable.append(this.alphabet.encode(i6 >>> 18));
                appendable.append(this.alphabet.encode((i6 >>> 12) & 63));
                appendable.append(this.alphabet.encode((i6 >>> 6) & 63));
                appendable.append(this.alphabet.encode(i6 & 63));
                i2 -= 3;
                i = i5 + 1;
            }
            if (i < i3) {
                encodeChunkTo(appendable, bArr, i, i3 - i);
            }
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding, com.google.common.io.BaseEncoding
        final int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            Preconditions.checkNotNull(bArr);
            CharSequence trimTrailingPadding = trimTrailingPadding(charSequence);
            if (!this.alphabet.isValidPaddingStartPosition(trimTrailingPadding.length())) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid input length ");
                sb.append(trimTrailingPadding.length());
                throw new DecodingException(sb.toString());
            }
            int i = 0;
            int i2 = 0;
            while (i < trimTrailingPadding.length()) {
                int i3 = i + 1;
                int i4 = i3 + 1;
                int decode = (this.alphabet.decode(trimTrailingPadding.charAt(i)) << 18) | (this.alphabet.decode(trimTrailingPadding.charAt(i3)) << 12);
                int i5 = i2 + 1;
                bArr[i2] = (byte) (decode >>> 16);
                if (i4 < trimTrailingPadding.length()) {
                    int i6 = i4 + 1;
                    int decode2 = decode | (this.alphabet.decode(trimTrailingPadding.charAt(i4)) << 6);
                    i2 = i5 + 1;
                    bArr[i5] = (byte) ((decode2 >>> 8) & 255);
                    if (i6 < trimTrailingPadding.length()) {
                        i4 = i6 + 1;
                        bArr[i2] = (byte) ((decode2 | this.alphabet.decode(trimTrailingPadding.charAt(i6))) & 255);
                        i2++;
                    } else {
                        i = i6;
                    }
                } else {
                    i2 = i5;
                }
                i = i4;
            }
            return i2;
        }

        @Override // com.google.common.io.BaseEncoding.StandardBaseEncoding
        final BaseEncoding newInstance(Alphabet alphabet, @CheckForNull Character ch) {
            return new Base64Encoding(alphabet, ch);
        }
    }

    static Reader ignoringReader(final Reader reader, final String str) {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(str);
        return new Reader() { // from class: com.google.common.io.BaseEncoding.3
            @Override // java.io.Reader
            public int read() throws IOException {
                int read;
                do {
                    read = reader.read();
                    if (read == -1) {
                        break;
                    }
                } while (str.indexOf((char) read) >= 0);
                return read;
            }

            @Override // java.io.Reader
            public int read(char[] cArr, int i, int i2) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                reader.close();
            }
        };
    }

    static Appendable separatingAppendable(Appendable appendable, String str, int i) {
        Preconditions.checkNotNull(appendable);
        Preconditions.checkNotNull(str);
        Preconditions.checkArgument(i > 0);
        return new Appendable(i, appendable, str) { // from class: com.google.common.io.BaseEncoding.4
            int charsUntilSeparator;
            final /* synthetic */ int val$afterEveryChars;
            final /* synthetic */ Appendable val$delegate;
            final /* synthetic */ String val$separator;

            {
                this.val$afterEveryChars = i;
                this.val$delegate = appendable;
                this.val$separator = str;
                this.charsUntilSeparator = i;
            }

            @Override // java.lang.Appendable
            public Appendable append(char c) throws IOException {
                if (this.charsUntilSeparator == 0) {
                    this.val$delegate.append(this.val$separator);
                    this.charsUntilSeparator = this.val$afterEveryChars;
                }
                this.val$delegate.append(c);
                this.charsUntilSeparator--;
                return this;
            }

            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence, int i2, int i3) {
                throw new UnsupportedOperationException();
            }

            @Override // java.lang.Appendable
            public Appendable append(@CheckForNull CharSequence charSequence) {
                throw new UnsupportedOperationException();
            }
        };
    }

    static Writer separatingWriter(final Writer writer, String str, int i) {
        final Appendable separatingAppendable = separatingAppendable(writer, str, i);
        return new Writer() { // from class: com.google.common.io.BaseEncoding.5
            @Override // java.io.Writer
            public void write(int i2) throws IOException {
                separatingAppendable.append((char) i2);
            }

            @Override // java.io.Writer
            public void write(char[] cArr, int i2, int i3) throws IOException {
                throw new UnsupportedOperationException();
            }

            @Override // java.io.Writer, java.io.Flushable
            public void flush() throws IOException {
                writer.flush();
            }

            @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                writer.close();
            }
        };
    }

    /* loaded from: classes7.dex */
    static final class SeparatedBaseEncoding extends BaseEncoding {
        private final int afterEveryChars;
        private final BaseEncoding delegate;
        private final String separator;

        SeparatedBaseEncoding(BaseEncoding baseEncoding, String str, int i) {
            this.delegate = (BaseEncoding) Preconditions.checkNotNull(baseEncoding);
            this.separator = (String) Preconditions.checkNotNull(str);
            this.afterEveryChars = i;
            Preconditions.checkArgument(i > 0, "Cannot add a separator after every %s chars", i);
        }

        @Override // com.google.common.io.BaseEncoding
        final CharSequence trimTrailingPadding(CharSequence charSequence) {
            return this.delegate.trimTrailingPadding(charSequence);
        }

        @Override // com.google.common.io.BaseEncoding
        final int maxEncodedSize(int i) {
            int maxEncodedSize = this.delegate.maxEncodedSize(i);
            return maxEncodedSize + (this.separator.length() * IntMath.divide(Math.max(0, maxEncodedSize - 1), this.afterEveryChars, RoundingMode.FLOOR));
        }

        @Override // com.google.common.io.BaseEncoding
        public final OutputStream encodingStream(Writer writer) {
            return this.delegate.encodingStream(separatingWriter(writer, this.separator, this.afterEveryChars));
        }

        @Override // com.google.common.io.BaseEncoding
        final void encodeTo(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            this.delegate.encodeTo(separatingAppendable(appendable, this.separator, this.afterEveryChars), bArr, i, i2);
        }

        @Override // com.google.common.io.BaseEncoding
        final int maxDecodedSize(int i) {
            return this.delegate.maxDecodedSize(i);
        }

        @Override // com.google.common.io.BaseEncoding
        public final boolean canDecode(CharSequence charSequence) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.canDecode(sb);
        }

        @Override // com.google.common.io.BaseEncoding
        final int decodeTo(byte[] bArr, CharSequence charSequence) throws DecodingException {
            StringBuilder sb = new StringBuilder(charSequence.length());
            for (int i = 0; i < charSequence.length(); i++) {
                char charAt = charSequence.charAt(i);
                if (this.separator.indexOf(charAt) < 0) {
                    sb.append(charAt);
                }
            }
            return this.delegate.decodeTo(bArr, sb);
        }

        @Override // com.google.common.io.BaseEncoding
        public final InputStream decodingStream(Reader reader) {
            return this.delegate.decodingStream(ignoringReader(reader, this.separator));
        }

        @Override // com.google.common.io.BaseEncoding
        public final BaseEncoding omitPadding() {
            return this.delegate.omitPadding().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public final BaseEncoding withPadChar(char c) {
            return this.delegate.withPadChar(c).withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public final BaseEncoding withSeparator(String str, int i) {
            throw new UnsupportedOperationException("Already have a separator");
        }

        @Override // com.google.common.io.BaseEncoding
        public final BaseEncoding upperCase() {
            return this.delegate.upperCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public final BaseEncoding lowerCase() {
            return this.delegate.lowerCase().withSeparator(this.separator, this.afterEveryChars);
        }

        @Override // com.google.common.io.BaseEncoding
        public final BaseEncoding ignoreCase() {
            return this.delegate.ignoreCase().withSeparator(this.separator, this.afterEveryChars);
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.delegate);
            sb.append(".withSeparator(\"");
            sb.append(this.separator);
            sb.append("\", ");
            sb.append(this.afterEveryChars);
            sb.append(")");
            return sb.toString();
        }
    }
}
