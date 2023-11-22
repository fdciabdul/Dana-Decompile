package id.dana.sendmoney.data.api.groupsend.modify.model.request;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ4\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0004R\u0019\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0019\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u001a\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantModifyEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;", "component3", "()Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;", "groupDetailId", "subBizType", "participantInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;)Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantModifyEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getGroupDetailId", "Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;", "getParticipantInfo", "getSubBizType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lid/dana/sendmoney/data/api/groupsend/modify/model/request/ParticipantInfoModifyEntity;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantModifyEntity {
    private final String groupDetailId;
    private final ParticipantInfoModifyEntity participantInfo;
    private final String subBizType;

    public ParticipantModifyEntity() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ ParticipantModifyEntity copy$default(ParticipantModifyEntity participantModifyEntity, String str, String str2, ParticipantInfoModifyEntity participantInfoModifyEntity, int i, Object obj) {
        if ((i & 1) != 0) {
            str = participantModifyEntity.groupDetailId;
        }
        if ((i & 2) != 0) {
            str2 = participantModifyEntity.subBizType;
        }
        if ((i & 4) != 0) {
            participantInfoModifyEntity = participantModifyEntity.participantInfo;
        }
        return participantModifyEntity.copy(str, str2, participantInfoModifyEntity);
    }

    /* renamed from: component1  reason: from getter */
    public final String getGroupDetailId() {
        return this.groupDetailId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSubBizType() {
        return this.subBizType;
    }

    /* renamed from: component3  reason: from getter */
    public final ParticipantInfoModifyEntity getParticipantInfo() {
        return this.participantInfo;
    }

    public final ParticipantModifyEntity copy(String groupDetailId, String subBizType, ParticipantInfoModifyEntity participantInfo) {
        return new ParticipantModifyEntity(groupDetailId, subBizType, participantInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ParticipantModifyEntity) {
            ParticipantModifyEntity participantModifyEntity = (ParticipantModifyEntity) other;
            return Intrinsics.areEqual(this.groupDetailId, participantModifyEntity.groupDetailId) && Intrinsics.areEqual(this.subBizType, participantModifyEntity.subBizType) && Intrinsics.areEqual(this.participantInfo, participantModifyEntity.participantInfo);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.groupDetailId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.subBizType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        ParticipantInfoModifyEntity participantInfoModifyEntity = this.participantInfo;
        return (((hashCode * 31) + hashCode2) * 31) + (participantInfoModifyEntity != null ? participantInfoModifyEntity.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantModifyEntity(groupDetailId=");
        sb.append(this.groupDetailId);
        sb.append(", subBizType=");
        sb.append(this.subBizType);
        sb.append(", participantInfo=");
        sb.append(this.participantInfo);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantModifyEntity(String str, String str2, ParticipantInfoModifyEntity participantInfoModifyEntity) {
        this.groupDetailId = str;
        this.subBizType = str2;
        this.participantInfo = participantInfoModifyEntity;
    }

    public /* synthetic */ ParticipantModifyEntity(String str, String str2, ParticipantInfoModifyEntity participantInfoModifyEntity, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : participantInfoModifyEntity);
    }

    @JvmName(name = "getGroupDetailId")
    public final String getGroupDetailId() {
        return this.groupDetailId;
    }

    @JvmName(name = "getSubBizType")
    public final String getSubBizType() {
        return this.subBizType;
    }

    @JvmName(name = "getParticipantInfo")
    public final ParticipantInfoModifyEntity getParticipantInfo() {
        return this.participantInfo;
    }
}
