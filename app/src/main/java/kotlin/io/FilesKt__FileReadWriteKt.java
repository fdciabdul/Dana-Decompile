package kotlin.io;

import id.dana.data.socialshare.ShareAppKey;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a#\u0010\n\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000b\u001a(\u0010\u000f\u001a\u00020\u000e*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u000f\u0010\u0010\u001a(\u0010\u0012\u001a\u00020\u0011*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0086\b¢\u0006\u0004\b\u0012\u0010\u0013\u001aM\u0010\u001a\u001a\u00020\u0003*\u00020\u00002:\u0010\u0019\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0004\b\u001a\u0010\u001b\u001aU\u0010\u001a\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u001c\u001a\u00020\f2:\u0010\u0019\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00030\u0014¢\u0006\u0004\b\u001a\u0010\u001d\u001a@\u0010 \u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2#\u0010\u0019\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0006¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00030\u001e¢\u0006\u0004\b \u0010!\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u0000H\u0086\b¢\u0006\u0004\b#\u0010$\u001a\u0014\u0010&\u001a\u00020%*\u00020\u0000H\u0086\b¢\u0006\u0004\b&\u0010'\u001a\u001e\u0010)\u001a\u00020(*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b)\u0010*\u001a\u0011\u0010+\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b+\u0010,\u001a!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00060-*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b.\u0010/\u001a\u001b\u00100\u001a\u00020\u0006*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b0\u00101\u001a\u001e\u00103\u001a\u000202*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b3\u00104\u001aA\u00108\u001a\u00028\u0000\"\u0004\b\u0000\u00105*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\b2\u0018\u00107\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000606\u0012\u0004\u0012\u00028\u00000\u001eH\u0086\bø\u0001\u0000¢\u0006\u0004\b8\u00109\u001a\u0019\u0010:\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b:\u0010\u0005\u001a#\u0010;\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b;\u0010\u000b\u001a\u001e\u0010=\u001a\u00020<*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b=\u0010>\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Ljava/io/File;", "", "array", "", "appendBytes", "(Ljava/io/File;[B)V", "", "text", "Ljava/nio/charset/Charset;", "charset", "appendText", "(Ljava/io/File;Ljava/lang/String;Ljava/nio/charset/Charset;)V", "", "bufferSize", "Ljava/io/BufferedReader;", "bufferedReader", "(Ljava/io/File;Ljava/nio/charset/Charset;I)Ljava/io/BufferedReader;", "Ljava/io/BufferedWriter;", "bufferedWriter", "(Ljava/io/File;Ljava/nio/charset/Charset;I)Ljava/io/BufferedWriter;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "buffer", "bytesRead", "action", "forEachBlock", "(Ljava/io/File;Lkotlin/jvm/functions/Function2;)V", "blockSize", "(Ljava/io/File;ILkotlin/jvm/functions/Function2;)V", "Lkotlin/Function1;", ShareAppKey.LINE, "forEachLine", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)V", "Ljava/io/FileInputStream;", "inputStream", "(Ljava/io/File;)Ljava/io/FileInputStream;", "Ljava/io/FileOutputStream;", "outputStream", "(Ljava/io/File;)Ljava/io/FileOutputStream;", "Ljava/io/PrintWriter;", "printWriter", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/io/PrintWriter;", "readBytes", "(Ljava/io/File;)[B", "", "readLines", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/util/List;", "readText", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/lang/String;", "Ljava/io/InputStreamReader;", "reader", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/io/InputStreamReader;", "T", "Lkotlin/sequences/Sequence;", "block", "useLines", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "writeText", "Ljava/io/OutputStreamWriter;", "writer", "(Ljava/io/File;Ljava/nio/charset/Charset;)Ljava/io/OutputStreamWriter;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/io/FilesKt")
/* loaded from: classes6.dex */
public class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    static /* synthetic */ InputStreamReader reader$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    private static final InputStreamReader reader(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new InputStreamReader(new FileInputStream(file), charset);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i);
    }

    private static final BufferedReader bufferedReader(File file, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), i);
    }

    static /* synthetic */ OutputStreamWriter writer$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    private static final OutputStreamWriter writer(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new OutputStreamWriter(new FileOutputStream(file), charset);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(File file, Charset charset, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i);
    }

    private static final BufferedWriter bufferedWriter(File file, Charset charset, int i) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), i);
    }

    static /* synthetic */ PrintWriter printWriter$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    private static final PrintWriter printWriter(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset), 8192));
    }

    public static final byte[] readBytes(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            long length = file.length();
            if (length > 2147483647L) {
                StringBuilder sb = new StringBuilder();
                sb.append("File ");
                sb.append(file);
                sb.append(" is too big (");
                sb.append(length);
                sb.append(" bytes) to fit in memory.");
                throw new OutOfMemoryError(sb.toString());
            }
            int i = (int) length;
            byte[] bArr = new byte[i];
            int i2 = i;
            int i3 = 0;
            while (i2 > 0) {
                int read = fileInputStream2.read(bArr, i3, i2);
                if (read < 0) {
                    break;
                }
                i2 -= read;
                i3 += read;
            }
            if (i2 > 0) {
                bArr = Arrays.copyOf(bArr, i3);
                Intrinsics.checkNotNullExpressionValue(bArr, "");
            } else {
                int read2 = fileInputStream2.read();
                if (read2 != -1) {
                    ExposingBufferByteArrayOutputStream exposingBufferByteArrayOutputStream = new ExposingBufferByteArrayOutputStream(8193);
                    exposingBufferByteArrayOutputStream.write(read2);
                    ByteStreamsKt.copyTo$default(fileInputStream2, exposingBufferByteArrayOutputStream, 0, 2, null);
                    int size = exposingBufferByteArrayOutputStream.size() + i;
                    if (size < 0) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("File ");
                        sb2.append(file);
                        sb2.append(" is too big to fit in memory.");
                        throw new OutOfMemoryError(sb2.toString());
                    }
                    byte[] buffer = exposingBufferByteArrayOutputStream.getBuffer();
                    byte[] copyOf = Arrays.copyOf(bArr, size);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "");
                    bArr = ArraysKt.copyInto(buffer, copyOf, i, 0, exposingBufferByteArrayOutputStream.size());
                }
            }
            CloseableKt.closeFinally(fileInputStream, null);
            return bArr;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeBytes(File file, byte[] bArr) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public static final void appendBytes(File file, byte[] bArr) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        try {
            fileOutputStream.write(bArr);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } finally {
        }
    }

    public static final String readText(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), charset);
        try {
            String readText = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, null);
            return readText;
        } finally {
        }
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readText(file, charset);
    }

    public static final void writeText(File file, String str, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        FilesKt.writeBytes(file, bytes);
    }

    public static /* synthetic */ void writeText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.writeText(file, str, charset);
    }

    public static final void appendText(File file, String str, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        FilesKt.appendBytes(file, bytes);
    }

    public static /* synthetic */ void appendText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.appendText(file, str, charset);
    }

    public static final void forEachBlock(File file, Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(function2, "");
        FilesKt.forEachBlock(file, 4096, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.lang.Object, byte[]] */
    public static final void forEachBlock(File file, int i, Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(function2, "");
        ?? r3 = new byte[RangesKt.coerceAtLeast(i, 512)];
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            while (true) {
                int read = fileInputStream2.read(r3);
                if (read > 0) {
                    function2.invoke(r3, Integer.valueOf(read));
                } else {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
            }
        } finally {
        }
    }

    public static /* synthetic */ void forEachLine$default(File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file, charset, function1);
    }

    public static final void forEachLine(File file, Charset charset, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(function1, "");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
    }

    private static final FileInputStream inputStream(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        return new FileInputStream(file);
    }

    private static final FileOutputStream outputStream(File file) {
        Intrinsics.checkNotNullParameter(file, "");
        return new FileOutputStream(file);
    }

    public static /* synthetic */ List readLines$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readLines(file, charset);
    }

    public static final List<String> readLines(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        final ArrayList arrayList = new ArrayList();
        FilesKt.forEachLine(file, charset, new Function1<String, Unit>() { // from class: kotlin.io.FilesKt__FileReadWriteKt$readLines$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                Intrinsics.checkNotNullParameter(str, "");
                arrayList.add(str);
            }
        });
        return arrayList;
    }

    public static /* synthetic */ Object useLines$default(File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            Object invoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    public static final <T> T useLines(File file, Charset charset, Function1<? super Sequence<String>, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(file, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset), 8192);
        try {
            T invoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }
}
