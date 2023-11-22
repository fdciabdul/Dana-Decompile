package kotlinx.coroutines.sync;

import kotlin.Metadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00018\u0006¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006"}, d2 = {"Lkotlinx/coroutines/sync/Empty;", "", "", "toString", "()Ljava/lang/String;", "locked", "Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Empty {
    public final Object locked;

    public Empty(Object obj) {
        this.locked = obj;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty[");
        sb.append(this.locked);
        sb.append(']');
        return sb.toString();
    }
}
