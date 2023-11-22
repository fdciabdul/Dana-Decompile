package kotlin;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\u001a\u0019\u0010\u0003\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\b\u001a\u00020\u0007H\u0086\b¢\u0006\u0004\b\u0005\u0010\t\u001a\u001c\u0010\u0005\u001a\u00020\u0002*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\nH\u0086\b¢\u0006\u0004\b\u0005\u0010\f\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u00020\u00008G¢\u0006\f\u0012\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0012\u0010\u0013\"!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00000\u0016*\u00020\u00008G¢\u0006\f\u0012\u0004\b\u0019\u0010\u0006\u001a\u0004\b\u0017\u0010\u0018"}, d2 = {"", "exception", "", "addSuppressed", "(Ljava/lang/Throwable;Ljava/lang/Throwable;)V", "printStackTrace", "(Ljava/lang/Throwable;)V", "Ljava/io/PrintStream;", "stream", "(Ljava/lang/Throwable;Ljava/io/PrintStream;)V", "Ljava/io/PrintWriter;", "writer", "(Ljava/lang/Throwable;Ljava/io/PrintWriter;)V", "", "stackTraceToString", "(Ljava/lang/Throwable;)Ljava/lang/String;", "", "Ljava/lang/StackTraceElement;", "getStackTrace", "(Ljava/lang/Throwable;)[Ljava/lang/StackTraceElement;", "getStackTrace$annotations", "stackTrace", "", "getSuppressedExceptions", "(Ljava/lang/Throwable;)Ljava/util/List;", "getSuppressedExceptions$annotations", "suppressedExceptions"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/ExceptionsKt")
/* loaded from: classes.dex */
public class ExceptionsKt__ExceptionsKt {
    public static /* synthetic */ void getStackTrace$annotations(Throwable th) {
    }

    public static /* synthetic */ void getSuppressedExceptions$annotations(Throwable th) {
    }

    private static final void printStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
    }

    private static final void printStackTrace(Throwable th, PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(printWriter, "");
        th.printStackTrace(printWriter);
    }

    private static final void printStackTrace(Throwable th, PrintStream printStream) {
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(printStream, "");
        th.printStackTrace(printStream);
    }

    @JvmName(name = "getStackTrace")
    public static final StackTraceElement[] getStackTrace(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        StackTraceElement[] stackTrace = th.getStackTrace();
        Intrinsics.checkNotNull(stackTrace);
        return stackTrace;
    }

    public static final String stackTraceToString(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String obj = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final void addSuppressed(Throwable th, Throwable th2) {
        Intrinsics.checkNotNullParameter(th, "");
        Intrinsics.checkNotNullParameter(th2, "");
        if (th != th2) {
            PlatformImplementationsKt.IMPLEMENTATIONS.addSuppressed(th, th2);
        }
    }

    @JvmName(name = "getSuppressedExceptions")
    public static final List<Throwable> getSuppressedExceptions(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getSuppressed(th);
    }
}
