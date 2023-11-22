package kotlinx.coroutines;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.google.common.base.Ascii;
import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlinx.coroutines.EventLoopImplBase;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u000b8%X¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r"}, d2 = {"Lkotlinx/coroutines/EventLoopImplPlatform;", "Lkotlinx/coroutines/EventLoop;", "", "now", "Lkotlinx/coroutines/EventLoopImplBase$DelayedTask;", "delayedTask", "", "reschedule", "(JLkotlinx/coroutines/EventLoopImplBase$DelayedTask;)V", "unpark", "()V", "Ljava/lang/Thread;", "getThread", "()Ljava/lang/Thread;", "thread", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class EventLoopImplPlatform extends EventLoop {
    public static final byte[] MyBillsEntityDataFactory = {95, 98, 60, -42, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
    public static final int getAuthRequestContext = 26;

    private static void a(int i, short s, short s2, Object[] objArr) {
        byte[] bArr = MyBillsEntityDataFactory;
        int i2 = 106 - (s2 * 7);
        int i3 = 16 - (s * 3);
        int i4 = 15 - (i * 12);
        byte[] bArr2 = new byte[i3];
        int i5 = -1;
        int i6 = i3 - 1;
        if (bArr == null) {
            i2 = i6 + (-i2) + 2;
            i6 = i6;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i2;
            i4++;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i2;
            int i8 = i6;
            i2 = i7 + (-bArr[i4]) + 2;
            i6 = i8;
        }
    }

    @JvmName(name = "getThread")
    protected abstract Thread getThread();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void unpark() {
        Thread thread = getThread();
        try {
            byte b = (byte) (MyBillsEntityDataFactory[15] + 1);
            byte b2 = b;
            Object[] objArr = new Object[1];
            a(b, b2, b2, objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (-MyBillsEntityDataFactory[15]);
            byte b4 = b3;
            Object[] objArr2 = new Object[1];
            a(b3, b4, b4, objArr2);
            Unit unit = null;
            if (cls.getMethod((String) objArr2[0], null).invoke(null, null) != thread) {
                AbstractTimeSource timeSource = AbstractTimeSourceKt.getTimeSource();
                if (timeSource != null) {
                    timeSource.unpark(thread);
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    LockSupport.unpark(thread);
                }
            }
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reschedule(long now, EventLoopImplBase.DelayedTask delayedTask) {
        DefaultExecutor.INSTANCE.schedule(now, delayedTask);
    }
}
