package kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001a\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0006\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0003\u0010\b\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u0003\u0010\n\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\u0003\u0010\f\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u0003\u0010\u000e\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000fH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0010\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0012\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0013H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0014\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0016\u001a\u0010\u0010\u0017\u001a\u00020\u0002H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u001a\u0010\u0017\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0004\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0006\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0017\u0010\b\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\tH\u0086\b¢\u0006\u0004\b\u0017\u0010\n\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\u0017\u0010\f\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\rH\u0086\b¢\u0006\u0004\b\u0017\u0010\u000e\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u000fH\u0086\b¢\u0006\u0004\b\u0017\u0010\u0010\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0011H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0012\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0013H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0014\u001a\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0015H\u0086\b¢\u0006\u0004\b\u0017\u0010\u0016\u001a\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001b\u001a\r\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001c\u0010\u001b\u001a\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001d\u0010\u001b"}, d2 = {"", "message", "", "print", "(Ljava/lang/Object;)V", "", "(Z)V", "", "(B)V", "", "(C)V", "", "([C)V", "", "(D)V", "", "(F)V", "", "(I)V", "", "(J)V", "", "(S)V", "println", "()V", "", "readLine", "()Ljava/lang/String;", "readln", "readlnOrNull"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class ConsoleKt {
    private static final void print(Object obj) {
        System.out.print(obj);
    }

    private static final void print(int i) {
        System.out.print(i);
    }

    private static final void print(long j) {
        System.out.print(j);
    }

    private static final void print(byte b) {
        System.out.print(Byte.valueOf(b));
    }

    private static final void print(short s) {
        System.out.print(Short.valueOf(s));
    }

    private static final void print(char c) {
        System.out.print(c);
    }

    private static final void print(boolean z) {
        System.out.print(z);
    }

    private static final void print(float f) {
        System.out.print(f);
    }

    private static final void print(double d) {
        System.out.print(d);
    }

    private static final void print(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "");
        System.out.print(cArr);
    }

    private static final void println(Object obj) {
        System.out.println(obj);
    }

    private static final void println(int i) {
        System.out.println(i);
    }

    private static final void println(long j) {
        System.out.println(j);
    }

    private static final void println(byte b) {
        System.out.println(Byte.valueOf(b));
    }

    private static final void println(short s) {
        System.out.println(Short.valueOf(s));
    }

    private static final void println(char c) {
        System.out.println(c);
    }

    private static final void println(boolean z) {
        System.out.println(z);
    }

    private static final void println(float f) {
        System.out.println(f);
    }

    private static final void println(double d) {
        System.out.println(d);
    }

    private static final void println(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "");
        System.out.println(cArr);
    }

    private static final void println() {
        System.out.println();
    }

    public static final String readln() {
        String readlnOrNull = readlnOrNull();
        if (readlnOrNull != null) {
            return readlnOrNull;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    public static final String readlnOrNull() {
        return readLine();
    }

    public static final String readLine() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "");
        Charset defaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(defaultCharset, "");
        return lineReader.readLine(inputStream, defaultCharset);
    }
}
