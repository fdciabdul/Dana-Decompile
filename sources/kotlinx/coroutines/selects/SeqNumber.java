package kotlinx.coroutines.selects;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/selects/SeqNumber;", "", "", HummerConstants.HUMMER_NEXT, "()J", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class SeqNumber {
    private static final /* synthetic */ AtomicLongFieldUpdater number$FU = AtomicLongFieldUpdater.newUpdater(SeqNumber.class, "number");
    private volatile /* synthetic */ long number = 1;

    public final long next() {
        return number$FU.incrementAndGet(this);
    }
}
