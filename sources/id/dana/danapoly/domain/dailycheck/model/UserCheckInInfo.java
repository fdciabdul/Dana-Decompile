package id.dana.danapoly.domain.dailycheck.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danapoly/domain/dailycheck/model/UserCheckInInfo;", "", "", "checkInDate", "J", "getCheckInDate", "()J", "", "position", "I", "getPosition", "()I", "", "status", "Ljava/lang/String;", "getStatus", "()Ljava/lang/String;", "<init>", "(ILjava/lang/String;J)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class UserCheckInInfo {
    private final long checkInDate;
    private final int position;
    private final String status;

    public UserCheckInInfo() {
        this(0, null, 0L, 7, null);
    }

    public UserCheckInInfo(int i, String str, long j) {
        Intrinsics.checkNotNullParameter(str, "");
        this.position = i;
        this.status = str;
        this.checkInDate = j;
    }

    public /* synthetic */ UserCheckInInfo(int i, String str, long j, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? 0L : j);
    }

    @JvmName(name = "getPosition")
    public final int getPosition() {
        return this.position;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getCheckInDate")
    public final long getCheckInDate() {
        return this.checkInDate;
    }
}
