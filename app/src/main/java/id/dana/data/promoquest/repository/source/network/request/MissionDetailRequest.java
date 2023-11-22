package id.dana.data.promoquest.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/data/promoquest/repository/source/network/request/MissionDetailRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", BranchLinkConstant.Params.MISSION_ID, "Ljava/lang/String;", "getMissionId", "()Ljava/lang/String;", "userId", "getUserId", "", "withMissionInfo", "Z", "getWithMissionInfo", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MissionDetailRequest extends BaseRpcRequest {
    private final String missionId;
    private final String userId;
    private final boolean withMissionInfo;

    public MissionDetailRequest() {
        this(null, null, false, 7, null);
    }

    public /* synthetic */ MissionDetailRequest(String str, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? false : z);
    }

    @JvmName(name = "getMissionId")
    public final String getMissionId() {
        return this.missionId;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getWithMissionInfo")
    public final boolean getWithMissionInfo() {
        return this.withMissionInfo;
    }

    public MissionDetailRequest(String str, String str2, boolean z) {
        this.missionId = str;
        this.userId = str2;
        this.withMissionInfo = z;
    }
}
