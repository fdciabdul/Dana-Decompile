package kotlinx.coroutines.rx2;

import com.ap.zoloz.hummer.biz.HummerConstants;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.concurrent.CancellationException;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.CoroutineExceptionHandlerKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "cause", "Lkotlin/coroutines/CoroutineContext;", HummerConstants.CONTEXT, "", "handleUndeliverableException", "(Ljava/lang/Throwable;Lkotlin/coroutines/CoroutineContext;)V"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RxCancellableKt {
    public static final void handleUndeliverableException(Throwable th, CoroutineContext coroutineContext) {
        if (th instanceof CancellationException) {
            return;
        }
        try {
            RxJavaPlugins.PlaceComponentResult(th);
        } catch (Throwable th2) {
            ExceptionsKt.addSuppressed(th, th2);
            CoroutineExceptionHandlerKt.handleCoroutineException(coroutineContext, th);
        }
    }
}
