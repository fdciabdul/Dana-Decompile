package id.dana.danapoly.data.dailycheck.model.response;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danapoly/data/dailycheck/model/response/UserCheckInInfoResponse;", "", "", "checkInDate", "Ljava/lang/Long;", "getCheckInDate", "()Ljava/lang/Long;", "", "position", "Ljava/lang/Integer;", "getPosition", "()Ljava/lang/Integer;", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Long;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserCheckInInfoResponse {
    @SerializedName("checkInDate")
    private final Long checkInDate;
    @SerializedName("position")
    private final Integer position;
    @SerializedName("status")
    private final String status;

    public UserCheckInInfoResponse() {
        this(null, null, null, 7, null);
    }

    public UserCheckInInfoResponse(Integer num, String str, Long l) {
        this.position = num;
        this.status = str;
        this.checkInDate = l;
    }

    public /* synthetic */ UserCheckInInfoResponse(Integer num, String str, Long l, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0 : num, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? 0L : l);
    }

    @JvmName(name = "getPosition")
    public final Integer getPosition() {
        return this.position;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getCheckInDate")
    public final Long getCheckInDate() {
        return this.checkInDate;
    }
}
