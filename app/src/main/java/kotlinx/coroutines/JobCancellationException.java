package kotlinx.coroutines;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00060\u0001j\u0002`\u00022\b\u0012\u0004\u0012\u00020\u00000\u0003B!\u0012\u0006\u0010\u0017\u001a\u00020\u0011\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u0004\u001a\u0004\u0018\u00010\u0000H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lkotlinx/coroutines/JobCancellationException;", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "Lkotlinx/coroutines/CopyableThrowable;", "createCopy", "()Lkotlinx/coroutines/JobCancellationException;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "fillInStackTrace", "()Ljava/lang/Throwable;", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lkotlinx/coroutines/Job;", "job", "Lkotlinx/coroutines/Job;", "message", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;Lkotlinx/coroutines/Job;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class JobCancellationException extends CancellationException implements CopyableThrowable<JobCancellationException> {
    public final Job job;
    public static final byte[] getAuthRequestContext = {10, Byte.MIN_VALUE, TarHeader.LF_LINK, 76, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -35, -31, Ascii.NAK, 0, -6, Ascii.EM, -28, 19, 0, 0, 34, -37, 9, -6, 10, -7, -4};
    public static final int PlaceComponentResult = 34;

    public JobCancellationException(String str, Throwable th, Job job) {
        super(str);
        this.job = job;
        if (th != null) {
            initCause(th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x004c -> B:15:0x0056). Please submit an issue!!! */
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
            byte[] r0 = kotlinx.coroutines.JobCancellationException.getAuthRequestContext
            r1 = 16
            r1 = r0[r1]
            byte r1 = (byte) r1
            byte r2 = (byte) r1
            byte r3 = (byte) r2
            int r1 = r1 * 2
            int r1 = 27 - r1
            int r3 = r3 * 4
            int r3 = 3 - r3
            int r2 = r2 * 3
            int r2 = 106 - r2
            byte[] r4 = new byte[r1]
            int r1 = r1 + (-1)
            r5 = 0
            if (r0 != 0) goto L2c
            r8 = r10
            r6 = r4
            r7 = 0
            r4 = r3
            goto L56
        L2c:
            r7 = r10
            r6 = 0
        L2e:
            int r3 = r3 + 1
            byte r8 = (byte) r2
            r4[r6] = r8
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
            int r6 = r6 + 1
            r8 = r0[r3]
            r9 = r4
            r4 = r3
            r3 = r8
            r8 = r7
            r7 = r6
            r6 = r9
        L56:
            int r3 = -r3
            int r2 = r2 + r3
            int r2 = r2 + 2
            r3 = r4
            r4 = r6
            r6 = r7
            r7 = r8
            goto L2e
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.JobCancellationException.fillInStackTrace():java.lang.Throwable");
    }

    @Override // kotlinx.coroutines.CopyableThrowable
    public final JobCancellationException createCopy() {
        if (DebugKt.getDEBUG()) {
            String message = getMessage();
            Intrinsics.checkNotNull(message);
            return new JobCancellationException(message, this, this.job);
        }
        return null;
    }

    @Override // java.lang.Throwable
    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("; job=");
        sb.append(this.job);
        return sb.toString();
    }

    public final boolean equals(Object other) {
        if (other != this) {
            if (other instanceof JobCancellationException) {
                JobCancellationException jobCancellationException = (JobCancellationException) other;
                if (!Intrinsics.areEqual(jobCancellationException.getMessage(), getMessage()) || !Intrinsics.areEqual(jobCancellationException.job, this.job) || !Intrinsics.areEqual(jobCancellationException.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    public final int hashCode() {
        String message = getMessage();
        Intrinsics.checkNotNull(message);
        int hashCode = message.hashCode();
        int hashCode2 = this.job.hashCode();
        Throwable cause = getCause();
        return (((hashCode * 31) + hashCode2) * 31) + (cause != null ? cause.hashCode() : 0);
    }
}
