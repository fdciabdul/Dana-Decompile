package kotlinx.coroutines.internal;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.huawei.hms.opendevice.i;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u0015\u001a\u00020\u0010¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0006\u001a\u00020\u00052\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\t\u001a\u00020\b8\u0006¢\u0006\u0006\n\u0004\b\t\u0010\fR$\u0010\u000e\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lkotlinx/coroutines/internal/ThreadState;", "", "Lkotlinx/coroutines/ThreadContextElement;", LottieParams.KEY_ELEMENT_ID, "value", "", "append", "(Lkotlinx/coroutines/ThreadContextElement;Ljava/lang/Object;)V", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "restore", "(Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/coroutines/CoroutineContext;", "", "elements", "[Lkotlinx/coroutines/ThreadContextElement;", "", i.MyBillsEntityDataFactory, "I", "values", "[Ljava/lang/Object;", "n", "<init>", "(Lkotlin/coroutines/CoroutineContext;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ThreadState {
    public final CoroutineContext context;
    private final ThreadContextElement<Object>[] elements;
    private int i;
    private final Object[] values;

    public ThreadState(CoroutineContext coroutineContext, int i) {
        this.context = coroutineContext;
        this.values = new Object[i];
        this.elements = new ThreadContextElement[i];
    }

    public final void append(ThreadContextElement<?> element, Object value) {
        Object[] objArr = this.values;
        int i = this.i;
        objArr[i] = value;
        ThreadContextElement<Object>[] threadContextElementArr = this.elements;
        this.i = i + 1;
        threadContextElementArr[i] = element;
    }

    public final void restore(CoroutineContext context) {
        int length = this.elements.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            ThreadContextElement<Object> threadContextElement = this.elements[length];
            Intrinsics.checkNotNull(threadContextElement);
            threadContextElement.restoreThreadContext(context, this.values[length]);
            if (i < 0) {
                return;
            }
            length = i;
        }
    }
}
