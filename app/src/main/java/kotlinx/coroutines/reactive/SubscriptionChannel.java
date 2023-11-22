package kotlinx.coroutines.reactive;

import com.alibaba.ariver.kernel.RVEvents;
import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import com.huawei.hms.push.e;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlinx.coroutines.channels.LinkedListChannel;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\nJ\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a"}, d2 = {"Lkotlinx/coroutines/reactive/SubscriptionChannel;", "T", "Lkotlinx/coroutines/channels/LinkedListChannel;", "Lorg/reactivestreams/Subscriber;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "closed", "", "onClosedIdempotent", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)V", "onComplete", "()V", "", e.PlaceComponentResult, RVEvents.EMBED_WEBVIEW_LOAD_ERROR_EVENT, "(Ljava/lang/Throwable;)V", SecurityConstants.KEY_TEXT, "onNext", "(Ljava/lang/Object;)V", "onReceiveDequeued", "onReceiveEnqueued", "Lorg/reactivestreams/Subscription;", "s", "onSubscribe", "(Lorg/reactivestreams/Subscription;)V", "", "request", "I", "<init>", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SubscriptionChannel<T> extends LinkedListChannel<T> implements Subscriber<T> {
    private volatile /* synthetic */ int _requested;
    private volatile /* synthetic */ Object _subscription;
    private final int request;
    private static final /* synthetic */ AtomicReferenceFieldUpdater _subscription$FU = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _requested$FU = AtomicIntegerFieldUpdater.newUpdater(SubscriptionChannel.class, "_requested");

    public SubscriptionChannel(int i) {
        super(null);
        this.request = i;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid request size: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString().toString());
        }
        this._subscription = null;
        this._requested = 0;
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final void onReceiveDequeued() {
        _requested$FU.incrementAndGet(this);
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public final void onClosedIdempotent(LockFreeLinkedListNode closed) {
        Subscription subscription = (Subscription) _subscription$FU.getAndSet(this, null);
        if (subscription != null) {
            subscription.cancel();
        }
    }

    @Override // org.reactivestreams.Subscriber
    public final void onSubscribe(Subscription s) {
        this._subscription = s;
        while (!isClosedForSend()) {
            int i = this._requested;
            int i2 = this.request;
            if (i >= i2) {
                return;
            }
            if (_requested$FU.compareAndSet(this, i, i2)) {
                s.request(this.request - i);
                return;
            }
        }
        s.cancel();
    }

    @Override // org.reactivestreams.Subscriber
    public final void onNext(T r2) {
        _requested$FU.decrementAndGet(this);
        mo42trySendJP2dKIU(r2);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onComplete() {
        close(null);
    }

    @Override // org.reactivestreams.Subscriber
    public final void onError(Throwable th) {
        close(th);
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    public final void onReceiveEnqueued() {
        Subscription subscription;
        int i;
        while (true) {
            int i2 = this._requested;
            subscription = (Subscription) this._subscription;
            i = i2 - 1;
            if (subscription != null && i < 0) {
                int i3 = this.request;
                if (i2 == i3 || _requested$FU.compareAndSet(this, i2, i3)) {
                    break;
                }
            } else if (_requested$FU.compareAndSet(this, i2, i)) {
                return;
            }
        }
        subscription.request(this.request - i);
    }
}
