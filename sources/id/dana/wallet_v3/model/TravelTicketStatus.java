package id.dana.wallet_v3.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010"}, d2 = {"Lid/dana/wallet_v3/model/TravelTicketStatus;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "DEPARTURE_CODE", "ARRIVAL_CODE", "TRAIN_NAME", "PLANE_NAME", "DEPARTURE_AIRPORT", "ARRIVAL_AIRPORT", "DEPARTURE_TERMINAL", "ARRIVAL_TERMINAL"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public enum TravelTicketStatus {
    DEPARTURE_CODE("DEPARTURE_CODE"),
    ARRIVAL_CODE("ARRIVAL_CODE"),
    TRAIN_NAME("TRAIN_NAME"),
    PLANE_NAME("PLANE_NAME"),
    DEPARTURE_AIRPORT("DEPARTURE_AIRPORT"),
    ARRIVAL_AIRPORT("ARRIVAL_AIRPORT"),
    DEPARTURE_TERMINAL("DEPARTURE_TERMINAL"),
    ARRIVAL_TERMINAL("ARRIVAL_TERMINAL");

    private final String value;

    TravelTicketStatus(String str) {
        this.value = str;
    }

    @JvmName(name = "getValue")
    public final String getValue() {
        return this.value;
    }
}
