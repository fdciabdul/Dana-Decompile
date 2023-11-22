package id.dana.danapoly.ui.model;

import id.dana.danapoly.ui.dailycheck.adapter.DailyCheckItemState;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\u0006\u0010\n\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\"\u0010\r\u001a\u00020\f8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/ui/model/DailyCheckItemModel;", "", "", "isActive", "()Z", "", "point", "I", "getPoint", "()I", "position", "getPosition", "Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;", "state", "Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;", "getState", "()Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;", "setState", "(Lid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;)V", "<init>", "(ILid/dana/danapoly/ui/dailycheck/adapter/DailyCheckItemState;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class DailyCheckItemModel {
    private final int point;
    private final int position;
    private DailyCheckItemState state;

    public DailyCheckItemModel(int i, DailyCheckItemState dailyCheckItemState, int i2) {
        Intrinsics.checkNotNullParameter(dailyCheckItemState, "");
        this.point = i;
        this.state = dailyCheckItemState;
        this.position = i2;
    }

    @JvmName(name = "getPoint")
    public final int getPoint() {
        return this.point;
    }

    public /* synthetic */ DailyCheckItemModel(int i, DailyCheckItemState dailyCheckItemState, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i3 & 2) != 0 ? DailyCheckItemState.UPCOMING : dailyCheckItemState, i2);
    }

    @JvmName(name = "getState")
    public final DailyCheckItemState getState() {
        return this.state;
    }

    @JvmName(name = "setState")
    public final void setState(DailyCheckItemState dailyCheckItemState) {
        Intrinsics.checkNotNullParameter(dailyCheckItemState, "");
        this.state = dailyCheckItemState;
    }

    @JvmName(name = "getPosition")
    public final int getPosition() {
        return this.position;
    }

    public final boolean isActive() {
        return this.state == DailyCheckItemState.ACTIVE;
    }
}
