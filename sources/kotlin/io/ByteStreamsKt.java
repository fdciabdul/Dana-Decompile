package kotlin.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.ByteIterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0004\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\b\u001a\u001e\u0010\f\u001a\u00020\u000b*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\f\u0010\r\u001a\u001e\u0010\u000f\u001a\u00020\u000e*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u001e\u0010\u0013\u001a\u00020\u0012*\u00020\u00112\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u0017\u001a\u00020\u0016*\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0014\u0010\u001a\u001a\u00020\u0012*\u00020\u0019H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a$\u0010\u001a\u001a\u00020\u0012*\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u001a\u0010\u001e\u001a\u0014\u0010 \u001a\u00020\u001f*\u00020\u0003H\u0086\u0002¢\u0006\u0004\b \u0010!\u001a\u0011\u0010\"\u001a\u00020\u0019*\u00020\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001d\u0010\"\u001a\u00020\u0019*\u00020\u00002\b\b\u0002\u0010$\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\"\u0010%\u001a\u001e\u0010'\u001a\u00020&*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b'\u0010(\u001a\u001e\u0010*\u001a\u00020)*\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b*\u0010+"}, d2 = {"Ljava/io/InputStream;", "", "bufferSize", "Ljava/io/BufferedInputStream;", "buffered", "(Ljava/io/InputStream;I)Ljava/io/BufferedInputStream;", "Ljava/io/OutputStream;", "Ljava/io/BufferedOutputStream;", "(Ljava/io/OutputStream;I)Ljava/io/BufferedOutputStream;", "Ljava/nio/charset/Charset;", "charset", "Ljava/io/BufferedReader;", "bufferedReader", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedReader;", "Ljava/io/BufferedWriter;", "bufferedWriter", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/BufferedWriter;", "", "Ljava/io/ByteArrayInputStream;", "byteInputStream", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Ljava/io/ByteArrayInputStream;", "out", "", "copyTo", "(Ljava/io/InputStream;Ljava/io/OutputStream;I)J", "", "inputStream", "([B)Ljava/io/ByteArrayInputStream;", "offset", "length", "([BII)Ljava/io/ByteArrayInputStream;", "Lkotlin/collections/ByteIterator;", "iterator", "(Ljava/io/BufferedInputStream;)Lkotlin/collections/ByteIterator;", "readBytes", "(Ljava/io/InputStream;)[B", "estimatedSize", "(Ljava/io/InputStream;I)[B", "Ljava/io/InputStreamReader;", "reader", "(Ljava/io/InputStream;Ljava/nio/charset/Charset;)Ljava/io/InputStreamReader;", "Ljava/io/OutputStreamWriter;", "writer", "(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)Ljava/io/OutputStreamWriter;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ByteStreamsKt {
    public static final ByteIterator iterator(final BufferedInputStream bufferedInputStream) {
        Intrinsics.checkNotNullParameter(bufferedInputStream, "");
        return new ByteIterator() { // from class: kotlin.io.ByteStreamsKt$iterator$1
            private boolean finished;
            private int nextByte = -1;
            private boolean nextPrepared;

            @JvmName(name = "getNextByte")
            public final int getNextByte() {
                return this.nextByte;
            }

            @JvmName(name = "setNextByte")
            public final void setNextByte(int i) {
                this.nextByte = i;
            }

            @JvmName(name = "getNextPrepared")
            public final boolean getNextPrepared() {
                return this.nextPrepared;
            }

            @JvmName(name = "setNextPrepared")
            public final void setNextPrepared(boolean z) {
                this.nextPrepared = z;
            }

            @JvmName(name = "getFinished")
            public final boolean getFinished() {
                return this.finished;
            }

            @JvmName(name = "setFinished")
            public final void setFinished(boolean z) {
                this.finished = z;
            }

            private final void prepareNext() {
                if (this.nextPrepared || this.finished) {
                    return;
                }
                int read = bufferedInputStream.read();
                this.nextByte = read;
                this.nextPrepared = true;
                this.finished = read == -1;
            }

            @Override // java.util.Iterator
            public final boolean hasNext() {
                prepareNext();
                return !this.finished;
            }

            @Override // kotlin.collections.ByteIterator
            public final byte nextByte() {
                prepareNext();
                if (this.finished) {
                    throw new NoSuchElementException("Input stream is over.");
                }
                byte b = (byte) this.nextByte;
                this.nextPrepared = false;
                return b;
            }
        };
    }

    private static final ByteArrayInputStream byteInputStream(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        return new ByteArrayInputStream(bytes);
    }

    static /* synthetic */ ByteArrayInputStream byteInputStream$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        return new ByteArrayInputStream(bytes);
    }

    private static final ByteArrayInputStream inputStream(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return new ByteArrayInputStream(bArr);
    }

    private static final ByteArrayInputStream inputStream(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return new ByteArrayInputStream(bArr, i, i2);
    }

    static /* synthetic */ BufferedInputStream buffered$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(inputStream, "");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    private static final BufferedInputStream buffered(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "");
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i);
    }

    private static final InputStreamReader reader(InputStream inputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new InputStreamReader(inputStream, charset);
    }

    static /* synthetic */ InputStreamReader reader$default(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(inputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new InputStreamReader(inputStream, charset);
    }

    private static final BufferedReader bufferedReader(InputStream inputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(inputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(InputStream inputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(inputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedReader(new InputStreamReader(inputStream, charset), 8192);
    }

    static /* synthetic */ BufferedOutputStream buffered$default(OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(outputStream, "");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    private static final BufferedOutputStream buffered(OutputStream outputStream, int i) {
        Intrinsics.checkNotNullParameter(outputStream, "");
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i);
    }

    private static final OutputStreamWriter writer(OutputStream outputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(outputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new OutputStreamWriter(outputStream, charset);
    }

    static /* synthetic */ OutputStreamWriter writer$default(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(outputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new OutputStreamWriter(outputStream, charset);
    }

    private static final BufferedWriter bufferedWriter(OutputStream outputStream, Charset charset) {
        Intrinsics.checkNotNullParameter(outputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(OutputStream outputStream, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(outputStream, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedWriter(new OutputStreamWriter(outputStream, charset), 8192);
    }

    public static /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(inputStream, outputStream, i);
    }

    public static final long copyTo(InputStream inputStream, OutputStream outputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "");
        Intrinsics.checkNotNullParameter(outputStream, "");
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return readBytes(inputStream, i);
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "1.5", warningSince = "1.3")
    public static final byte[] readBytes(InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "");
        return byteArray;
    }

    public static final byte[] readBytes(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "");
        return byteArray;
    }
}
