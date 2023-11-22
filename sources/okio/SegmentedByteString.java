package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: classes.dex */
final class SegmentedByteString extends ByteString {
    final transient int[] directory;
    final transient byte[][] segments;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SegmentedByteString(Buffer buffer, int i) {
        super(null);
        Util.MyBillsEntityDataFactory(buffer.getAuthRequestContext, 0L, i);
        Segment segment = buffer.BuiltInFictitiousFunctionClassFactory;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment.MyBillsEntityDataFactory == segment.PlaceComponentResult) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += segment.MyBillsEntityDataFactory - segment.PlaceComponentResult;
            i4++;
            segment = segment.getAuthRequestContext;
        }
        this.segments = new byte[i4];
        this.directory = new int[i4 * 2];
        Segment segment2 = buffer.BuiltInFictitiousFunctionClassFactory;
        int i5 = 0;
        while (i2 < i) {
            this.segments[i5] = segment2.BuiltInFictitiousFunctionClassFactory;
            i2 += segment2.MyBillsEntityDataFactory - segment2.PlaceComponentResult;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.directory;
            iArr[i5] = i2;
            iArr[this.segments.length + i5] = segment2.PlaceComponentResult;
            segment2.moveToNextValue = true;
            i5++;
            segment2 = segment2.getAuthRequestContext;
        }
    }

    @Override // okio.ByteString
    public final String utf8() {
        return toByteString().utf8();
    }

    @Override // okio.ByteString
    public final String string(Charset charset) {
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public final String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public final String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public final ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public final ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public final ByteString md5() {
        return toByteString().md5();
    }

    @Override // okio.ByteString
    public final ByteString sha1() {
        return toByteString().sha1();
    }

    @Override // okio.ByteString
    public final ByteString sha256() {
        return toByteString().sha256();
    }

    @Override // okio.ByteString
    public final ByteString hmacSha1(ByteString byteString) {
        return toByteString().hmacSha1(byteString);
    }

    @Override // okio.ByteString
    public final ByteString hmacSha256(ByteString byteString) {
        return toByteString().hmacSha256(byteString);
    }

    @Override // okio.ByteString
    public final String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public final ByteString substring(int i) {
        return toByteString().substring(i);
    }

    @Override // okio.ByteString
    public final ByteString substring(int i, int i2) {
        return toByteString().substring(i, i2);
    }

    @Override // okio.ByteString
    public final byte getByte(int i) {
        Util.MyBillsEntityDataFactory(this.directory[this.segments.length - 1], i, 1L);
        int segment = segment(i);
        int i2 = segment == 0 ? 0 : this.directory[segment - 1];
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        return bArr[segment][(i - i2) + iArr[bArr.length + segment]];
    }

    private int segment(int i) {
        int binarySearch = Arrays.binarySearch(this.directory, 0, this.segments.length, i + 1);
        return binarySearch < 0 ? binarySearch ^ (-1) : binarySearch;
    }

    @Override // okio.ByteString
    public final int size() {
        return this.directory[this.segments.length - 1];
    }

    @Override // okio.ByteString
    public final byte[] toByteArray() {
        int[] iArr = this.directory;
        byte[][] bArr = this.segments;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.directory;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.segments[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // okio.ByteString
    public final ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
    }

    @Override // okio.ByteString
    public final void write(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.segments[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public final void write(Buffer buffer) {
        int length = this.segments.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.directory;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            Segment segment = new Segment(this.segments[i], i3, (i3 + i4) - i2, true, false);
            if (buffer.BuiltInFictitiousFunctionClassFactory == null) {
                segment.lookAheadTest = segment;
                segment.getAuthRequestContext = segment;
                buffer.BuiltInFictitiousFunctionClassFactory = segment;
            } else {
                Segment segment2 = buffer.BuiltInFictitiousFunctionClassFactory.lookAheadTest;
                segment.lookAheadTest = segment2;
                segment.getAuthRequestContext = segment2.getAuthRequestContext;
                segment2.getAuthRequestContext.lookAheadTest = segment;
                segment2.getAuthRequestContext = segment;
            }
            i++;
            i2 = i4;
        }
        buffer.getAuthRequestContext += i2;
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int segment = segment(i);
        while (i3 > 0) {
            int i4 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr = this.segments;
            if (!byteString.rangeEquals(i2, bArr[segment], (i - i4) + iArr[bArr.length + segment], min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int segment = segment(i);
        while (i3 > 0) {
            int i4 = segment == 0 ? 0 : this.directory[segment - 1];
            int min = Math.min(i3, ((this.directory[segment] - i4) + i4) - i);
            int[] iArr = this.directory;
            byte[][] bArr2 = this.segments;
            if (!Util.PlaceComponentResult(bArr2[segment], (i - i4) + iArr[bArr2.length + segment], bArr, i2, min)) {
                return false;
            }
            i += min;
            i2 += min;
            i3 -= min;
            segment++;
        }
        return true;
    }

    @Override // okio.ByteString
    public final int indexOf(byte[] bArr, int i) {
        return toByteString().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    public final int lastIndexOf(byte[] bArr, int i) {
        return toByteString().lastIndexOf(bArr, i);
    }

    private ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // okio.ByteString
    public final byte[] internalArray() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.segments.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr = this.segments[i2];
            int[] iArr = this.directory;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            for (int i7 = i5; i7 < (i6 - i3) + i5; i7++) {
                i4 = (i4 * 31) + bArr[i7];
            }
            i2++;
            i3 = i6;
        }
        this.hashCode = i4;
        return i4;
    }

    @Override // okio.ByteString
    public final String toString() {
        return toByteString().toString();
    }

    private Object writeReplace() {
        return toByteString();
    }
}
