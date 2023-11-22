package id.dana.danapoly.ui.model.play;

import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.danapoly.ui.board.view.DanapolyBoardView;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0006\u001a\u00020\u00058\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u0010\u0010\tR\u001a\u0010\u0012\u001a\u00020\u00118\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lid/dana/danapoly/ui/model/play/PositionModel;", "", "Lid/dana/danapoly/ui/board/view/DanapolyBoardView$PawnMovementType;", "getMovementType", "()Lid/dana/danapoly/ui/board/view/DanapolyBoardView$PawnMovementType;", "", "current", "I", "getCurrent", "()I", "", "movingType", "Ljava/lang/String;", "getMovingType", "()Ljava/lang/String;", HummerConstants.HUMMER_NEXT, "getNext", "", "overlapCount", "Z", "getOverlapCount", "()Z", "<init>", "(Ljava/lang/String;IIZ)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PositionModel {
    private final int current;
    private final String movingType;
    private final int next;
    private final boolean overlapCount;

    public PositionModel() {
        this(null, 0, 0, false, 15, null);
    }

    public PositionModel(String str, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        this.movingType = str;
        this.current = i;
        this.next = i2;
        this.overlapCount = z;
    }

    public /* synthetic */ PositionModel(String str, int i, int i2, boolean z, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? false : z);
    }

    @JvmName(name = "getMovingType")
    public final String getMovingType() {
        return this.movingType;
    }

    @JvmName(name = "getCurrent")
    public final int getCurrent() {
        return this.current;
    }

    @JvmName(name = "getNext")
    public final int getNext() {
        return this.next;
    }

    @JvmName(name = "getOverlapCount")
    public final boolean getOverlapCount() {
        return this.overlapCount;
    }

    public final DanapolyBoardView.PawnMovementType getMovementType() {
        if (Intrinsics.areEqual(this.movingType, DanapolyBoardView.PawnMovementType.BACKWARD.getMovement())) {
            return DanapolyBoardView.PawnMovementType.BACKWARD;
        }
        return DanapolyBoardView.PawnMovementType.FORWARD;
    }
}
