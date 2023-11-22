package kotlinx.coroutines;

import java.lang.Throwable;
import kotlin.Metadata;
import kotlinx.coroutines.CopyableThrowable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000*\u0012\b\u0000\u0010\u0002*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00002\u00020\u0003J\u0011\u0010\u0004\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lkotlinx/coroutines/CopyableThrowable;", "", "T", "", "createCopy", "()Ljava/lang/Throwable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public interface CopyableThrowable<T extends Throwable & CopyableThrowable<T>> {
    T createCopy();
}
