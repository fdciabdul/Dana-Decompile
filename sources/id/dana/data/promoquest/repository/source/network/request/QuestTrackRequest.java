package id.dana.data.promoquest.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.BranchLinkConstant;
import id.dana.domain.social.ExtendInfoUtilKt;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006"}, d2 = {"Lid/dana/data/promoquest/repository/source/network/request/QuestTrackRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", ExtendInfoUtilKt.EXTEND_INFO_ACTIVITY_ID, "Ljava/lang/String;", "getActivityId", "()Ljava/lang/String;", "", "autoRedeem", "Z", "getAutoRedeem", "()Z", "bizType", "getBizType", BranchLinkConstant.Params.MISSION_ID, "getMissionId", "questId", "getQuestId", "<init>", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class QuestTrackRequest extends BaseRpcRequest {
    private final String activityId;
    private final boolean autoRedeem;
    private final String bizType;
    private final String missionId;
    private final String questId;

    public QuestTrackRequest() {
        this(false, null, null, null, null, 31, null);
    }

    public /* synthetic */ QuestTrackRequest(boolean z, String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : str, (i & 4) == 0 ? str2 : null, (i & 8) != 0 ? "" : str3, (i & 16) != 0 ? "" : str4);
    }

    @JvmName(name = "getAutoRedeem")
    public final boolean getAutoRedeem() {
        return this.autoRedeem;
    }

    @JvmName(name = "getMissionId")
    public final String getMissionId() {
        return this.missionId;
    }

    @JvmName(name = "getQuestId")
    public final String getQuestId() {
        return this.questId;
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getActivityId")
    public final String getActivityId() {
        return this.activityId;
    }

    public QuestTrackRequest(boolean z, String str, String str2, String str3, String str4) {
        this.autoRedeem = z;
        this.missionId = str;
        this.questId = str2;
        this.bizType = str3;
        this.activityId = str4;
    }
}
