package id.dana.danapoly.domain.config.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/danapoly/domain/config/model/DanapolyEvent;", "", "", "eventId", "Ljava/lang/String;", "getEventId", "()Ljava/lang/String;", "", "expiryDate", "Ljava/lang/Long;", "getExpiryDate", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/String;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DanapolyEvent {
    private final String eventId;
    private final Long expiryDate;

    public DanapolyEvent(String str, Long l) {
        Intrinsics.checkNotNullParameter(str, "");
        this.eventId = str;
        this.expiryDate = l;
    }

    public /* synthetic */ DanapolyEvent(String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : l);
    }

    @JvmName(name = "getEventId")
    public final String getEventId() {
        return this.eventId;
    }

    @JvmName(name = "getExpiryDate")
    public final Long getExpiryDate() {
        return this.expiryDate;
    }
}
