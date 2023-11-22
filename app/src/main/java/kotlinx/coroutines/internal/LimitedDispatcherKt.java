package kotlinx.coroutines.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"", "", "checkParallelism", "(I)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class LimitedDispatcherKt {
    public static final void checkParallelism(int i) {
        if (i > 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Expected positive parallelism level, but got ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString().toString());
    }
}
