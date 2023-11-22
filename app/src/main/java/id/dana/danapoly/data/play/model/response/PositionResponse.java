package id.dana.danapoly.data.play.model.response;

import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B/\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012"}, d2 = {"Lid/dana/danapoly/data/play/model/response/PositionResponse;", "", "", "current", "Ljava/lang/Integer;", "getCurrent", "()Ljava/lang/Integer;", "", "movingType", "Ljava/lang/String;", "getMovingType", "()Ljava/lang/String;", HummerConstants.HUMMER_NEXT, "getNext", "", "overlapCount", "Ljava/lang/Boolean;", "getOverlapCount", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PositionResponse {
    @SerializedName("current")
    private final Integer current;
    @SerializedName("movingType")
    private final String movingType;
    @SerializedName(HummerConstants.HUMMER_NEXT)
    private final Integer next;
    @SerializedName("overlapCount")
    private final Boolean overlapCount;

    public PositionResponse(String str, Integer num, Integer num2, Boolean bool) {
        this.movingType = str;
        this.current = num;
        this.next = num2;
        this.overlapCount = bool;
    }

    @JvmName(name = "getMovingType")
    public final String getMovingType() {
        return this.movingType;
    }

    @JvmName(name = "getCurrent")
    public final Integer getCurrent() {
        return this.current;
    }

    @JvmName(name = "getNext")
    public final Integer getNext() {
        return this.next;
    }

    @JvmName(name = "getOverlapCount")
    public final Boolean getOverlapCount() {
        return this.overlapCount;
    }
}
