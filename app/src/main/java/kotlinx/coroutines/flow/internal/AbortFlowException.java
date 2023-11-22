package kotlinx.coroutines.flow.internal;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0013\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001b\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbortFlowException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "Lkotlinx/coroutines/flow/FlowCollector;", "owner", "Lkotlinx/coroutines/flow/FlowCollector;", "getOwner", "()Lkotlinx/coroutines/flow/FlowCollector;", "<init>", "(Lkotlinx/coroutines/flow/FlowCollector;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AbortFlowException extends CancellationException {
    private final FlowCollector<?> owner;
    public static final byte[] MyBillsEntityDataFactory = {4, -20, -33, -123, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4};
    public static final int BuiltInFictitiousFunctionClassFactory = 237;

    @JvmName(name = "getOwner")
    public final FlowCollector<?> getOwner() {
        return this.owner;
    }

    public AbortFlowException(FlowCollector<?> flowCollector) {
        super("Flow was aborted, no more elements needed");
        this.owner = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004f -> B:15:0x0055). Please submit an issue!!! */
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
            byte[] r0 = kotlinx.coroutines.flow.internal.AbortFlowException.MyBillsEntityDataFactory
            r1 = 16
            r2 = r0[r1]
            byte r2 = (byte) r2
            int r3 = r2 + (-1)
            byte r3 = (byte) r3
            r1 = r0[r1]
            byte r1 = (byte) r1
            int r1 = r1 * 4
            int r1 = r1 + 106
            int r2 = r2 * 3
            int r2 = r2 + 27
            int r3 = r3 + 4
            byte[] r4 = new byte[r2]
            int r2 = r2 + (-1)
            r5 = 0
            r7 = r10
            if (r0 != 0) goto L2e
            r6 = r4
            r8 = 0
            r4 = r3
            goto L55
        L2e:
            r6 = 0
        L2f:
            int r3 = r3 + 1
            byte r8 = (byte) r1
            r4[r6] = r8
            int r8 = r6 + 1
            if (r6 != r2) goto L4f
            java.lang.String r0 = new java.lang.String
            r0.<init>(r4, r5)
            java.lang.Class r0 = java.lang.Class.forName(r0)
            java.lang.Object r0 = java.lang.reflect.Array.newInstance(r0, r5)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            java.lang.StackTraceElement[] r0 = (java.lang.StackTraceElement[]) r0
            r7.setStackTrace(r0)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            return r7
        L4f:
            r6 = r0[r3]
            r9 = r4
            r4 = r3
            r3 = r6
            r6 = r9
        L55:
            int r3 = -r3
            int r1 = r1 + r3
            int r1 = r1 + 2
            r3 = r4
            r4 = r6
            r6 = r8
            goto L2f
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.AbortFlowException.fillInStackTrace():java.lang.Throwable");
    }
}
