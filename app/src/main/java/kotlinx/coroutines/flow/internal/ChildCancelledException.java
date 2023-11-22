package kotlinx.coroutines.flow.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/flow/internal/ChildCancelledException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ChildCancelledException extends CancellationException {
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {Ascii.ETB, -59, 18, 83, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 66;

    public ChildCancelledException() {
        super("Child of the scoped flow was cancelled");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004c -> B:15:0x0052). Please submit an issue!!! */
    @Override // java.lang.Throwable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Throwable fillInStackTrace() {
        /*
            r10 = this;
            boolean r0 = kotlinx.coroutines.DebugKt.getDEBUG()
            if (r0 == 0) goto Lb
            java.lang.Throwable r0 = super.fillInStackTrace()
            return r0
        Lb:
            byte[] r0 = kotlinx.coroutines.flow.internal.ChildCancelledException.KClassImpl$Data$declaredNonStaticMembers$2
            r1 = 16
            r1 = r0[r1]
            byte r1 = (byte) r1
            byte r2 = (byte) r1
            byte r3 = (byte) r2
            int r2 = r2 * 3
            int r2 = 4 - r2
            int r1 = r1 * 3
            int r1 = 27 - r1
            int r3 = r3 * 3
            int r3 = 106 - r3
            byte[] r4 = new byte[r1]
            int r1 = r1 + (-1)
            r5 = 0
            r7 = r10
            if (r0 != 0) goto L2d
            r6 = r3
            r8 = 0
            r3 = r2
            r2 = r1
            goto L52
        L2d:
            r6 = 0
        L2e:
            byte r8 = (byte) r3
            r4[r6] = r8
            int r8 = r6 + 1
            if (r6 != r1) goto L4c
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4, r5)
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r5)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0
            r7.setStackTrace(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            return r7
        L4c:
            r6 = r0[r2]
            r9 = r2
            r2 = r1
            r1 = r3
            r3 = r9
        L52:
            int r3 = r3 + 1
            int r6 = -r6
            int r1 = r1 + r6
            int r1 = r1 + 2
            r6 = r8
            r9 = r3
            r3 = r1
            r1 = r2
            r2 = r9
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.ChildCancelledException.fillInStackTrace():java.lang.Throwable");
    }
}
