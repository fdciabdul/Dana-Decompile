package kotlinx.coroutines;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/Active;", "Lkotlinx/coroutines/NotCompleted;", "", "toString", "()Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
final class Active implements NotCompleted {
    public static final Active INSTANCE = new Active();

    public final String toString() {
        return "Active";
    }

    private Active() {
    }
}
