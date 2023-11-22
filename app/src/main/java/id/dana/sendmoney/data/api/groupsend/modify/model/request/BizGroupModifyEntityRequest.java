package id.dana.sendmoney.data.api.groupsend.modify.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJX\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0017\u0010\r\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001e\u001a\u0004\b\"\u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b#\u0010\u0004R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b%\u0010\f"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantModifyEntity;", "component6", "()Ljava/util/List;", "bizType", "groupId", "changeType", "groupName", "groupLogo", "participants", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)Lid/dana/sendmoney/data/api/groupsend/modify/model/request/BizGroupModifyEntityRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "getChangeType", "getGroupId", "getGroupLogo", "getGroupName", "Ljava/util/List;", "getParticipants", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupModifyEntityRequest extends BaseRpcRequest {
    private final String bizType;
    private final String changeType;
    private final String groupId;
    private final String groupLogo;
    private final String groupName;
    private final List<ParticipantModifyEntity> participants;

    public static /* synthetic */ BizGroupModifyEntityRequest copy$default(BizGroupModifyEntityRequest bizGroupModifyEntityRequest, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizGroupModifyEntityRequest.bizType;
        }
        if ((i & 2) != 0) {
            str2 = bizGroupModifyEntityRequest.groupId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = bizGroupModifyEntityRequest.changeType;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = bizGroupModifyEntityRequest.groupName;
        }
        String str8 = str4;
        if ((i & 16) != 0) {
            str5 = bizGroupModifyEntityRequest.groupLogo;
        }
        String str9 = str5;
        List<ParticipantModifyEntity> list2 = list;
        if ((i & 32) != 0) {
            list2 = bizGroupModifyEntityRequest.participants;
        }
        return bizGroupModifyEntityRequest.copy(str, str6, str7, str8, str9, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBizType() {
        return this.bizType;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getChangeType() {
        return this.changeType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGroupLogo() {
        return this.groupLogo;
    }

    public final List<ParticipantModifyEntity> component6() {
        return this.participants;
    }

    public final BizGroupModifyEntityRequest copy(String bizType, String groupId, String changeType, String groupName, String groupLogo, List<ParticipantModifyEntity> participants) {
        Intrinsics.checkNotNullParameter(bizType, "");
        Intrinsics.checkNotNullParameter(groupId, "");
        Intrinsics.checkNotNullParameter(changeType, "");
        return new BizGroupModifyEntityRequest(bizType, groupId, changeType, groupName, groupLogo, participants);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizGroupModifyEntityRequest) {
            BizGroupModifyEntityRequest bizGroupModifyEntityRequest = (BizGroupModifyEntityRequest) other;
            return Intrinsics.areEqual(this.bizType, bizGroupModifyEntityRequest.bizType) && Intrinsics.areEqual(this.groupId, bizGroupModifyEntityRequest.groupId) && Intrinsics.areEqual(this.changeType, bizGroupModifyEntityRequest.changeType) && Intrinsics.areEqual(this.groupName, bizGroupModifyEntityRequest.groupName) && Intrinsics.areEqual(this.groupLogo, bizGroupModifyEntityRequest.groupLogo) && Intrinsics.areEqual(this.participants, bizGroupModifyEntityRequest.participants);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.bizType.hashCode();
        int hashCode2 = this.groupId.hashCode();
        int hashCode3 = this.changeType.hashCode();
        String str = this.groupName;
        int hashCode4 = str == null ? 0 : str.hashCode();
        String str2 = this.groupLogo;
        int hashCode5 = str2 == null ? 0 : str2.hashCode();
        List<ParticipantModifyEntity> list = this.participants;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupModifyEntityRequest(bizType=");
        sb.append(this.bizType);
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(", changeType=");
        sb.append(this.changeType);
        sb.append(", groupName=");
        sb.append(this.groupName);
        sb.append(", groupLogo=");
        sb.append(this.groupLogo);
        sb.append(", participants=");
        sb.append(this.participants);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ BizGroupModifyEntityRequest(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : list);
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getGroupId")
    public final String getGroupId() {
        return this.groupId;
    }

    @JvmName(name = "getChangeType")
    public final String getChangeType() {
        return this.changeType;
    }

    @JvmName(name = "getGroupName")
    public final String getGroupName() {
        return this.groupName;
    }

    @JvmName(name = "getGroupLogo")
    public final String getGroupLogo() {
        return this.groupLogo;
    }

    @JvmName(name = "getParticipants")
    public final List<ParticipantModifyEntity> getParticipants() {
        return this.participants;
    }

    public BizGroupModifyEntityRequest(String str, String str2, String str3, String str4, String str5, List<ParticipantModifyEntity> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.bizType = str;
        this.groupId = str2;
        this.changeType = str3;
        this.groupName = str4;
        this.groupLogo = str5;
        this.participants = list;
    }
}
