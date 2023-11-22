package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "run", "()V"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* renamed from: kotlinx.coroutines.android.HandlerDispatcherKt$awaitFrame$lambda-3$$inlined$Runnable$1  reason: invalid class name */
/* loaded from: classes9.dex */
public final class HandlerDispatcherKt$awaitFrame$lambda3$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $$cont$inlined;

    @Override // java.lang.Runnable
    public final void run() {
        HandlerDispatcherKt.updateChoreographerAndPostFrameCallback(this.$$cont$inlined);
    }
}
