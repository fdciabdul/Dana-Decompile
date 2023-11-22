package kotlin.io.path;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.socialshare.ShareAppKey;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a,\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u000b\u0010\f\u001a,\u0010\u000b\u001a\u00020\u0000*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u000b\u0010\u000e\u001a#\u0010\u0010\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0010\u0010\u0011\u001a<\u0010\u0018\u001a\u00020\u0017*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a<\u0010\u001b\u001a\u00020\u001a*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b\u001b\u0010\u001c\u001aF\u0010#\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2#\u0010\"\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00030\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b#\u0010$\u001a(\u0010&\u001a\u00020%*\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b&\u0010'\u001a(\u0010)\u001a\u00020(*\u00020\u00002\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\u0001*\u00020\u0000H\u0086\b¢\u0006\u0004\b+\u0010,\u001a$\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001e0-*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\tH\u0086\b¢\u0006\u0004\b.\u0010/\u001a\u001b\u00100\u001a\u00020\u001e*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b0\u00101\u001a2\u00103\u001a\u000202*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b3\u00104\u001aA\u00107\u001a\u00028\u0000\"\u0004\b\u0000\u00105*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\u0018\u00106\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\r\u0012\u0004\u0012\u00028\u00000\u001dH\u0086\bø\u0001\u0000¢\u0006\u0004\b7\u00108\u001a0\u00109\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b9\u0010:\u001a@\u0010;\u001a\u00020\u0000*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b;\u0010<\u001a@\u0010;\u001a\u00020\u0000*\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\b;\u0010=\u001a7\u0010>\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015¢\u0006\u0004\b>\u0010?\u001a2\u0010A\u001a\u00020@*\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\t2\u0012\u0010\u0016\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014\"\u00020\u0015H\u0086\b¢\u0006\u0004\bA\u0010B\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Ljava/nio/file/Path;", "", "array", "", "appendBytes", "(Ljava/nio/file/Path;[B)V", "", "", "lines", "Ljava/nio/charset/Charset;", "charset", "appendLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;)Ljava/nio/file/Path;", "Lkotlin/sequences/Sequence;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;)Ljava/nio/file/Path;", "text", "appendText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;)V", "", "bufferSize", "", "Ljava/nio/file/OpenOption;", SecurityConstants.KEY_OPTIONS, "Ljava/io/BufferedReader;", "bufferedReader", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedReader;", "Ljava/io/BufferedWriter;", "bufferedWriter", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;I[Ljava/nio/file/OpenOption;)Ljava/io/BufferedWriter;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", ShareAppKey.LINE, "action", "forEachLine", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)V", "Ljava/io/InputStream;", "inputStream", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "outputStream", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStream;", "readBytes", "(Ljava/nio/file/Path;)[B", "", "readLines", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/util/List;", "readText", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;)Ljava/lang/String;", "Ljava/io/InputStreamReader;", "reader", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/InputStreamReader;", "T", "block", "useLines", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "writeBytes", "(Ljava/nio/file/Path;[B[Ljava/nio/file/OpenOption;)V", "writeLines", "(Ljava/nio/file/Path;Ljava/lang/Iterable;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "(Ljava/nio/file/Path;Lkotlin/sequences/Sequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/nio/file/Path;", "writeText", "(Ljava/nio/file/Path;Ljava/lang/CharSequence;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)V", "Ljava/io/OutputStreamWriter;", "writer", "(Ljava/nio/file/Path;Ljava/nio/charset/Charset;[Ljava/nio/file/OpenOption;)Ljava/io/OutputStreamWriter;"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
/* loaded from: classes3.dex */
public class PathsKt__PathReadWriteKt {
    static /* synthetic */ InputStreamReader reader$default(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    private static final InputStreamReader reader(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ BufferedReader bufferedReader$default(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final BufferedReader bufferedReader(Path path, Charset charset, int i, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new BufferedReader(new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    static /* synthetic */ OutputStreamWriter writer$default(Path path, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    private static final OutputStreamWriter writer(Path path, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset);
    }

    static /* synthetic */ BufferedWriter bufferedWriter$default(Path path, Charset charset, int i, OpenOption[] openOptionArr, int i2, Object obj) throws IOException {
        if ((i2 & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final BufferedWriter bufferedWriter(Path path, Charset charset, int i, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        return new BufferedWriter(new OutputStreamWriter(Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length)), charset), i);
    }

    private static final byte[] readBytes(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        byte[] readAllBytes = Files.readAllBytes(path);
        Intrinsics.checkNotNullExpressionValue(readAllBytes, "");
        return readAllBytes;
    }

    private static final void writeBytes(Path path, byte[] bArr, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        Files.write(path, bArr, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
    }

    private static final void appendBytes(Path path, byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(bArr, "");
        Files.write(path, bArr, StandardOpenOption.APPEND);
    }

    public static /* synthetic */ String readText$default(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return PathsKt.readText(path, charset);
    }

    public static final String readText(Path path, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        InputStreamReader inputStreamReader = new InputStreamReader(Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0)), charset);
        try {
            String readText = TextStreamsKt.readText(inputStreamReader);
            CloseableKt.closeFinally(inputStreamReader, null);
            return readText;
        } finally {
        }
    }

    public static /* synthetic */ void writeText$default(Path path, CharSequence charSequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.writeText(path, charSequence, charset, openOptionArr);
    }

    public static final void writeText(Path path, CharSequence charSequence, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(charSequence);
            CloseableKt.closeFinally(outputStreamWriter, null);
        } finally {
        }
    }

    public static /* synthetic */ void appendText$default(Path path, CharSequence charSequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        PathsKt.appendText(path, charSequence, charset);
    }

    public static final void appendText(Path path, CharSequence charSequence, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charset, "");
        OutputStream newOutputStream = Files.newOutputStream(path, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(newOutputStream, charset);
        try {
            outputStreamWriter.append(charSequence);
            CloseableKt.closeFinally(outputStreamWriter, null);
        } finally {
        }
    }

    static /* synthetic */ void forEachLine$default(Path path, Charset charset, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(newBufferedReader, "");
        BufferedReader bufferedReader = newBufferedReader;
        try {
            Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    private static final void forEachLine(Path path, Charset charset, Function1<? super String, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        Intrinsics.checkNotNullExpressionValue(newBufferedReader, "");
        BufferedReader bufferedReader = newBufferedReader;
        try {
            Iterator<String> it = TextStreamsKt.lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
        } finally {
        }
    }

    private static final InputStream inputStream(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        InputStream newInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "");
        return newInputStream;
    }

    private static final OutputStream outputStream(Path path, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        OutputStream newOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "");
        return newOutputStream;
    }

    static /* synthetic */ List readLines$default(Path path, Charset charset, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        List<String> readAllLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(readAllLines, "");
        return readAllLines;
    }

    private static final List<String> readLines(Path path, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        List<String> readAllLines = Files.readAllLines(path, charset);
        Intrinsics.checkNotNullExpressionValue(readAllLines, "");
        return readAllLines;
    }

    static /* synthetic */ Object useLines$default(Path path, Charset charset, Function1 function1, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            BufferedReader bufferedReader = newBufferedReader;
            Intrinsics.checkNotNullExpressionValue(bufferedReader, "");
            Object invoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(newBufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    private static final <T> T useLines(Path path, Charset charset, Function1<? super Sequence<String>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader newBufferedReader = Files.newBufferedReader(path, charset);
        try {
            BufferedReader bufferedReader = newBufferedReader;
            Intrinsics.checkNotNullExpressionValue(bufferedReader, "");
            T invoke = function1.invoke(TextStreamsKt.lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(newBufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    static /* synthetic */ Path writeLines$default(Path path, Iterable iterable, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    private static final Path writeLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        Path write = Files.write(path, iterable, charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    static /* synthetic */ Path writeLines$default(Path path, Sequence sequence, Charset charset, OpenOption[] openOptionArr, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    private static final Path writeLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset, OpenOption... openOptionArr) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Intrinsics.checkNotNullParameter(openOptionArr, "");
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    static /* synthetic */ Path appendLines$default(Path path, Iterable iterable, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    private static final Path appendLines(Path path, Iterable<? extends CharSequence> iterable, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(iterable, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Path write = Files.write(path, iterable, charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    static /* synthetic */ Path appendLines$default(Path path, Sequence sequence, Charset charset, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }

    private static final Path appendLines(Path path, Sequence<? extends CharSequence> sequence, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter(path, "");
        Intrinsics.checkNotNullParameter(sequence, "");
        Intrinsics.checkNotNullParameter(charset, "");
        Path write = Files.write(path, SequencesKt.asIterable(sequence), charset, StandardOpenOption.APPEND);
        Intrinsics.checkNotNullExpressionValue(write, "");
        return write;
    }
}
