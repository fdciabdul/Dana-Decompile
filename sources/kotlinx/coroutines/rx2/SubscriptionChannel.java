package kotlinx.coroutines.rx2;

import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import io.reactivex.MaybeObserver;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0007¢\u0006\u0004\b\u0018\u0010\u000bJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0012"}, d2 = {"Lkotlinx/coroutines/rx2/SubscriptionChannel;", "T", "Lkotlinx/coroutines/channels/LinkedListChannel;", "Lio/reactivex/Observer;", "Lio/reactivex/MaybeObserver;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "onComplete", "()V", "", e.PlaceComponentResult, RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V", SecurityConstants.KEY_TEXT, "onNext", "(Ljava/lang/Object;)V", "Lio/reactivex/disposables/Disposable;", "sub", "onSubscribe", "(Lio/reactivex/disposables/Disposable;)V", "onSuccess", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SubscriptionChannel<T> extends LinkedListChannel<T> implements Observer<T>, MaybeObserver<T> {
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    private volatile /* synthetic */ Object _subscription;

    public SubscriptionChannel() {
        super(null);
        this._subscription = null;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final void onClosedIdempotent(LockFreeLinkedListNode closed) {
        Disposable disposable = (Disposable) _subscription$FU.getAndSet(this, null);
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(Disposable sub) {
        this._subscription = sub;
    }

    @Override // io.reactivex.MaybeObserver
    public final void onSuccess(T r1) {
        mo42trySendJP2dKIU(r1);
        close(null);
    }

    @Override // io.reactivex.Observer
    public final void onNext(T r1) {
        mo42trySendJP2dKIU(r1);
    }

    @Override // io.reactivex.Observer
    public final void onComplete() {
        close(null);
    }

    @Override // io.reactivex.Observer
    public final void onError(Throwable th) {
        close(th);
    }
}
