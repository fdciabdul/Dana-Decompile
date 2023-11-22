package id.dana.data.promoquest.repository.source.network.request;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0001HÂ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\n\u001a\u00020\u0001HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rHÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0007¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0006R\u0014\u0010\n\u001a\u00020\u00018\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019"}, d2 = {"Lid/dana/data/promoquest/repository/source/network/request/MissionRequestWithStatus;", "Lid/dana/data/promoquest/repository/source/network/request/MissionRequest;", "Ljava/io/Serializable;", "", "", "component1", "()Ljava/util/List;", "component2", "()Lid/dana/data/promoquest/repository/source/network/request/MissionRequest;", "listOfStatus", "missionRequest", "copy", "(Ljava/util/List;Lid/dana/data/promoquest/repository/source/network/request/MissionRequest;)Lid/dana/data/promoquest/repository/source/network/request/MissionRequestWithStatus;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "()Ljava/lang/String;", "Ljava/util/List;", "getListOfStatus", "Lid/dana/data/promoquest/repository/source/network/request/MissionRequest;", "<init>", "(Ljava/util/List;Lid/dana/data/promoquest/repository/source/network/request/MissionRequest;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MissionRequestWithStatus extends MissionRequest implements Serializable {
    private final List<String> listOfStatus;
    private final MissionRequest missionRequest;

    /* renamed from: component2  reason: from getter */
    private final MissionRequest getMissionRequest() {
        return this.missionRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MissionRequestWithStatus copy$default(MissionRequestWithStatus missionRequestWithStatus, List list, MissionRequest missionRequest, int i, Object obj) {
        if ((i & 1) != 0) {
            list = missionRequestWithStatus.listOfStatus;
        }
        if ((i & 2) != 0) {
            missionRequest = missionRequestWithStatus.missionRequest;
        }
        return missionRequestWithStatus.copy(list, missionRequest);
    }

    public final List<String> component1() {
        return this.listOfStatus;
    }

    public final MissionRequestWithStatus copy(List<String> listOfStatus, MissionRequest missionRequest) {
        Intrinsics.checkNotNullParameter(listOfStatus, "");
        Intrinsics.checkNotNullParameter(missionRequest, "");
        return new MissionRequestWithStatus(listOfStatus, missionRequest);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MissionRequestWithStatus) {
            MissionRequestWithStatus missionRequestWithStatus = (MissionRequestWithStatus) other;
            return Intrinsics.areEqual(this.listOfStatus, missionRequestWithStatus.listOfStatus) && Intrinsics.areEqual(this.missionRequest, missionRequestWithStatus.missionRequest);
        }
        return false;
    }

    public final int hashCode() {
        return (this.listOfStatus.hashCode() * 31) + this.missionRequest.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MissionRequestWithStatus(listOfStatus=");
        sb.append(this.listOfStatus);
        sb.append(", missionRequest=");
        sb.append(this.missionRequest);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getListOfStatus")
    public final List<String> getListOfStatus() {
        return this.listOfStatus;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MissionRequestWithStatus(List<String> list, MissionRequest missionRequest) {
        super(missionRequest.envInfo, missionRequest.pageNumber, missionRequest.pageSize);
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(missionRequest, "");
        this.listOfStatus = list;
        this.missionRequest = missionRequest;
    }
}
