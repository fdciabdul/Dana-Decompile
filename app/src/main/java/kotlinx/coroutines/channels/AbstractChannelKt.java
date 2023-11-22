package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0000\"\u0014\u0010\u0001\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0001\u0010\u0002\"\u0014\u0010\u0003\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0002\"\u0014\u0010\u0004\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0002\"\u0014\u0010\u0005\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0002\"\u0014\u0010\u0006\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0002\"\u0014\u0010\u0007\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0002*(\b\u0000\u0010\u000b\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b2\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\n0\b"}, d2 = {"Lkotlinx/coroutines/internal/Symbol;", "EMPTY", "Lkotlinx/coroutines/internal/Symbol;", "ENQUEUE_FAILED", "HANDLER_INVOKED", "OFFER_FAILED", "OFFER_SUCCESS", "POLL_FAILED", "Lkotlin/Function1;", "", "", "Handler"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AbstractChannelKt {
    public static final Symbol EMPTY = new Symbol("EMPTY");
    public static final Symbol OFFER_SUCCESS = new Symbol("OFFER_SUCCESS");
    public static final Symbol OFFER_FAILED = new Symbol("OFFER_FAILED");
    public static final Symbol POLL_FAILED = new Symbol("POLL_FAILED");
    public static final Symbol ENQUEUE_FAILED = new Symbol("ENQUEUE_FAILED");
    public static final Symbol HANDLER_INVOKED = new Symbol("ON_CLOSE_HANDLER_INVOKED");
}
