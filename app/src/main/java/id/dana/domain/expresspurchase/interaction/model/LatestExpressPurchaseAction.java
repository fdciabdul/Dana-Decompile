package id.dana.domain.expresspurchase.interaction.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006"}, d2 = {"Lid/dana/domain/expresspurchase/interaction/model/LatestExpressPurchaseAction;", "", "", "dismissTimestamp", "J", "getDismissTimestamp", "()J", "successTimestamp", "getSuccessTimestamp", "<init>", "(JJ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LatestExpressPurchaseAction {
    private final long dismissTimestamp;
    private final long successTimestamp;

    public LatestExpressPurchaseAction(long j, long j2) {
        this.dismissTimestamp = j;
        this.successTimestamp = j2;
    }

    @JvmName(name = "getDismissTimestamp")
    public final long getDismissTimestamp() {
        return this.dismissTimestamp;
    }

    @JvmName(name = "getSuccessTimestamp")
    public final long getSuccessTimestamp() {
        return this.successTimestamp;
    }
}
