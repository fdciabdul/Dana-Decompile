package kotlin;

import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005R\u0014\u0010\b\u001a\u00028\u00008'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007"}, d2 = {"Lkotlin/Lazy;", "T", "", "", "isInitialized", "()Z", "getValue", "()Ljava/lang/Object;", "value"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface Lazy<T> {
    @JvmName(name = "getValue")
    T getValue();

    boolean isInitialized();
}
