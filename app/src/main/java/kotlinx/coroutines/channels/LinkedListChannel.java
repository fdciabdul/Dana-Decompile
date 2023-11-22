package kotlinx.coroutines.channels;

import com.alibaba.griver.beehive.lottie.player.LottieParams;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.channels.AbstractSendChannel;
import kotlinx.coroutines.internal.AtomicKt;
import kotlinx.coroutines.internal.OnUndeliveredElementKt;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002B)\u0012 \u0010\u001c\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u00002\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0014¢\u0006\u0004\b\t\u0010\nJ,\u0010\u0013\u001a\u00020\u00102\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0014ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00148EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0018\u001a\u00020\u00148EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00148EX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001"}, d2 = {"Lkotlinx/coroutines/channels/LinkedListChannel;", "E", "Lkotlinx/coroutines/channels/AbstractChannel;", LottieParams.KEY_ELEMENT_ID, "", "offerInternal", "(Ljava/lang/Object;)Ljava/lang/Object;", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "offerSelectInternal", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/InlineList;", "Lkotlinx/coroutines/channels/Send;", "list", "Lkotlinx/coroutines/channels/Closed;", "closed", "", "onCancelIdempotentList-w-w6eGU", "(Ljava/lang/Object;Lkotlinx/coroutines/channels/Closed;)V", "onCancelIdempotentList", "", "isBufferAlwaysEmpty", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "onUndeliveredElement", "<init>", "(Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public class LinkedListChannel<E> extends AbstractChannel<E> {
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @JvmName(name = "isBufferAlwaysEmpty")
    protected final boolean isBufferAlwaysEmpty() {
        return true;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferAlwaysFull")
    protected final boolean isBufferAlwaysFull() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractChannel
    @JvmName(name = "isBufferEmpty")
    public final boolean isBufferEmpty() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    @JvmName(name = "isBufferFull")
    public final boolean isBufferFull() {
        return false;
    }

    public LinkedListChannel(Function1<? super E, Unit> function1) {
        super(function1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerInternal(E element) {
        ReceiveOrClosed<?> sendBuffered;
        do {
            Object offerInternal = super.offerInternal(element);
            if (offerInternal == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if (offerInternal == AbstractChannelKt.OFFER_FAILED) {
                sendBuffered = sendBuffered(element);
                if (sendBuffered == null) {
                    return AbstractChannelKt.OFFER_SUCCESS;
                }
            } else if (offerInternal instanceof Closed) {
                return offerInternal;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid offerInternal result ");
                sb.append(offerInternal);
                throw new IllegalStateException(sb.toString().toString());
            }
        } while (!(sendBuffered instanceof Closed));
        return sendBuffered;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerSelectInternal(E element, SelectInstance<?> select) {
        Object performAtomicTrySelect;
        while (true) {
            if (getHasReceiveOrClosed()) {
                performAtomicTrySelect = super.offerSelectInternal(element, select);
            } else {
                performAtomicTrySelect = select.performAtomicTrySelect(describeSendBuffered(element));
                if (performAtomicTrySelect == null) {
                    performAtomicTrySelect = AbstractChannelKt.OFFER_SUCCESS;
                }
            }
            if (performAtomicTrySelect == SelectKt.getALREADY_SELECTED()) {
                return SelectKt.getALREADY_SELECTED();
            }
            if (performAtomicTrySelect == AbstractChannelKt.OFFER_SUCCESS) {
                return AbstractChannelKt.OFFER_SUCCESS;
            }
            if (performAtomicTrySelect != AbstractChannelKt.OFFER_FAILED && performAtomicTrySelect != AtomicKt.RETRY_ATOMIC) {
                if (performAtomicTrySelect instanceof Closed) {
                    return performAtomicTrySelect;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Invalid result ");
                sb.append(performAtomicTrySelect);
                throw new IllegalStateException(sb.toString().toString());
            }
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractChannel
    /* renamed from: onCancelIdempotentList-w-w6eGU */
    protected void mo4631onCancelIdempotentListww6eGU(Object list, Closed<?> closed) {
        UndeliveredElementException undeliveredElementException = null;
        if (list != null) {
            if (!(list instanceof ArrayList)) {
                Send send = (Send) list;
                if (send instanceof AbstractSendChannel.SendBuffered) {
                    Function1<E, Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null) {
                        undeliveredElementException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, ((AbstractSendChannel.SendBuffered) send).element, null);
                    }
                } else {
                    send.resumeSendClosed(closed);
                }
            } else if (list != null) {
                ArrayList arrayList = (ArrayList) list;
                UndeliveredElementException undeliveredElementException2 = null;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    Send send2 = (Send) arrayList.get(size);
                    if (send2 instanceof AbstractSendChannel.SendBuffered) {
                        Function1<E, Unit> function12 = this.onUndeliveredElement;
                        undeliveredElementException2 = function12 != null ? OnUndeliveredElementKt.callUndeliveredElementCatchingException(function12, ((AbstractSendChannel.SendBuffered) send2).element, undeliveredElementException2) : null;
                    } else {
                        send2.resumeSendClosed(closed);
                    }
                }
                undeliveredElementException = undeliveredElementException2;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>{ kotlin.collections.TypeAliasesKt.ArrayList<E of kotlinx.coroutines.internal.InlineList> }");
            }
        }
        if (undeliveredElementException != null) {
            throw undeliveredElementException;
        }
    }
}
