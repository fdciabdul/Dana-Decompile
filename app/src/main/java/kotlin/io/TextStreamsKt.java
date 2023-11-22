package kotlin.io;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001e\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001e\u0010\u0004\u001a\u00020\u0007*\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0004\u0010\b\u001a#\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\f\u001a%\u0010\u0011\u001a\u00020\u000f*\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013*\u00020\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u0011\u0010\u0018\u001a\u00020\u0017*\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019\u001a\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001a*\u00020\u0000¢\u0006\u0004\b\u001b\u0010\u001c\u001a\u0011\u0010\u001d\u001a\u00020\u000e*\u00020\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a\u001e\u0010\u001d\u001a\u00020\u000e*\u00020\u00162\b\b\u0002\u0010 \u001a\u00020\u001fH\u0086\b¢\u0006\u0004\b\u001d\u0010!\u001a\u0014\u0010#\u001a\u00020\"*\u00020\u000eH\u0086\b¢\u0006\u0004\b#\u0010$\u001a7\u0010'\u001a\u00028\u0000\"\u0004\b\u0000\u0010%*\u00020\u00002\u0018\u0010&\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u0013\u0012\u0004\u0012\u00028\u00000\rH\u0086\bø\u0001\u0000¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001"}, d2 = {"Ljava/io/Reader;", "", "bufferSize", "Ljava/io/BufferedReader;", "buffered", "(Ljava/io/Reader;I)Ljava/io/BufferedReader;", "Ljava/io/Writer;", "Ljava/io/BufferedWriter;", "(Ljava/io/Writer;I)Ljava/io/BufferedWriter;", "out", "", "copyTo", "(Ljava/io/Reader;Ljava/io/Writer;I)J", "Lkotlin/Function1;", "", "", "action", "forEachLine", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/sequences/Sequence;", "lineSequence", "(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;", "Ljava/net/URL;", "", "readBytes", "(Ljava/net/URL;)[B", "", "readLines", "(Ljava/io/Reader;)Ljava/util/List;", "readText", "(Ljava/io/Reader;)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "(Ljava/net/URL;Ljava/nio/charset/Charset;)Ljava/lang/String;", "Ljava/io/StringReader;", "reader", "(Ljava/lang/String;)Ljava/io/StringReader;", "T", "block", "useLines", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class TextStreamsKt {
    static /* synthetic */ BufferedReader buffered$default(Reader reader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(reader, "");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    private static final BufferedReader buffered(Reader reader, int i) {
        Intrinsics.checkNotNullParameter(reader, "");
        return reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, i);
    }

    static /* synthetic */ BufferedWriter buffered$default(Writer writer, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        Intrinsics.checkNotNullParameter(writer, "");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    private static final BufferedWriter buffered(Writer writer, int i) {
        Intrinsics.checkNotNullParameter(writer, "");
        return writer instanceof BufferedWriter ? (BufferedWriter) writer : new BufferedWriter(writer, i);
    }

    public static final List<String> readLines(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "");
        final ArrayList arrayList = new ArrayList();
        forEachLine(reader, new Function1<String, Unit>() { // from class: kotlin.io.TextStreamsKt$readLines$1
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

    public static final <T> T useLines(Reader reader, Function1<? super Sequence<String>, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(reader, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            T invoke = function1.invoke(lineSequence(bufferedReader));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    private static final StringReader reader(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return new StringReader(str);
    }

    public static final Sequence<String> lineSequence(BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "");
        return SequencesKt.constrainOnce(new LinesSequence(bufferedReader));
    }

    public static final String readText(Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String obj = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(reader, writer, i);
    }

    public static final long copyTo(Reader reader, Writer writer, int i) {
        Intrinsics.checkNotNullParameter(reader, "");
        Intrinsics.checkNotNullParameter(writer, "");
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += read;
            read = reader.read(cArr);
        }
        return j;
    }

    private static final String readText(URL url, Charset charset) {
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new String(readBytes(url), charset);
    }

    static /* synthetic */ String readText$default(URL url, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(url, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new String(readBytes(url), charset);
    }

    public static final byte[] readBytes(URL url) {
        Intrinsics.checkNotNullParameter(url, "");
        InputStream openStream = FirebasePerfUrlConnection.openStream(url);
        try {
            InputStream inputStream = openStream;
            Intrinsics.checkNotNullExpressionValue(inputStream, "");
            byte[] readBytes = ByteStreamsKt.readBytes(inputStream);
            CloseableKt.closeFinally(openStream, null);
            return readBytes;
        } finally {
        }
    }

    public static final void forEachLine(Reader reader, Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(reader, "");
        Intrinsics.checkNotNullParameter(function1, "");
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator<String> it = lineSequence(bufferedReader).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader, null);
        } finally {
        }
    }
}
