package id.dana.sendmoney.data.api.groupsend.query.model;

import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantSubmitEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0012\b\u0086\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b-\u0010.J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004Jv\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u0004R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0011\u0010\"\u001a\u0004\b#\u0010\u0004R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\"\u001a\u0004\b$\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\"\u001a\u0004\b%\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\"\u001a\u0004\b&\u0010\u0004R\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b(\u0010\fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\"\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\"\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b,\u0010\b"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Integer;", "", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "component4", "()Ljava/util/List;", "component5", "component6", "component7", "component8", "groupId", "groupName", "totalParticipant", "participants", "groupImageUrl", "subBizType", "status", "lastTransactionTime", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/data/api/groupsend/query/model/GroupEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "toString", "Ljava/lang/String;", "getGroupId", "getGroupImageUrl", "getGroupName", "getLastTransactionTime", "Ljava/util/List;", "getParticipants", "getStatus", "getSubBizType", "Ljava/lang/Integer;", "getTotalParticipant", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class GroupEntity {
    private final String groupId;
    private final String groupImageUrl;
    private final String groupName;
    private final String lastTransactionTime;
    private final List<ParticipantSubmitEntity> participants;
    private final String status;
    private final String subBizType;
    private final Integer totalParticipant;

    /* renamed from: component1  reason: from getter */
    public final String getGroupId() {
        return this.groupId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGroupName() {
        return this.groupName;
    }

    /* renamed from: component3  reason: from getter */
    public final Integer getTotalParticipant() {
        return this.totalParticipant;
    }

    public final List<ParticipantSubmitEntity> component4() {
        return this.participants;
    }

    /* renamed from: component5  reason: from getter */
    public final String getGroupImageUrl() {
        return this.groupImageUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final String getSubBizType() {
        return this.subBizType;
    }

    /* renamed from: component7  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component8  reason: from getter */
    public final String getLastTransactionTime() {
        return this.lastTransactionTime;
    }

    public final GroupEntity copy(String groupId, String groupName, Integer totalParticipant, List<ParticipantSubmitEntity> participants, String groupImageUrl, String subBizType, String status, String lastTransactionTime) {
        return new GroupEntity(groupId, groupName, totalParticipant, participants, groupImageUrl, subBizType, status, lastTransactionTime);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof GroupEntity) {
            GroupEntity groupEntity = (GroupEntity) other;
            return Intrinsics.areEqual(this.groupId, groupEntity.groupId) && Intrinsics.areEqual(this.groupName, groupEntity.groupName) && Intrinsics.areEqual(this.totalParticipant, groupEntity.totalParticipant) && Intrinsics.areEqual(this.participants, groupEntity.participants) && Intrinsics.areEqual(this.groupImageUrl, groupEntity.groupImageUrl) && Intrinsics.areEqual(this.subBizType, groupEntity.subBizType) && Intrinsics.areEqual(this.status, groupEntity.status) && Intrinsics.areEqual(this.lastTransactionTime, groupEntity.lastTransactionTime);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.groupId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.groupName;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        Integer num = this.totalParticipant;
        int hashCode3 = num == null ? 0 : num.hashCode();
        List<ParticipantSubmitEntity> list = this.participants;
        int hashCode4 = list == null ? 0 : list.hashCode();
        String str3 = this.groupImageUrl;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.subBizType;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.status;
        int hashCode7 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.lastTransactionTime;
        return (((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + (str6 != null ? str6.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupEntity(groupId=");
        sb.append(this.groupId);
        sb.append(", groupName=");
        sb.append(this.groupName);
        sb.append(", totalParticipant=");
        sb.append(this.totalParticipant);
        sb.append(", participants=");
        sb.append(this.participants);
        sb.append(", groupImageUrl=");
        sb.append(this.groupImageUrl);
        sb.append(", subBizType=");
        sb.append(this.subBizType);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", lastTransactionTime=");
        sb.append(this.lastTransactionTime);
        sb.append(')');
        return sb.toString();
    }

    public GroupEntity(String str, String str2, Integer num, List<ParticipantSubmitEntity> list, String str3, String str4, String str5, String str6) {
        this.groupId = str;
        this.groupName = str2;
        this.totalParticipant = num;
        this.participants = list;
        this.groupImageUrl = str3;
        this.subBizType = str4;
        this.status = str5;
        this.lastTransactionTime = str6;
    }

    @JvmName(name = "getGroupId")
    public final String getGroupId() {
        return this.groupId;
    }

    @JvmName(name = "getGroupName")
    public final String getGroupName() {
        return this.groupName;
    }

    @JvmName(name = "getTotalParticipant")
    public final Integer getTotalParticipant() {
        return this.totalParticipant;
    }

    @JvmName(name = "getParticipants")
    public final List<ParticipantSubmitEntity> getParticipants() {
        return this.participants;
    }

    @JvmName(name = "getGroupImageUrl")
    public final String getGroupImageUrl() {
        return this.groupImageUrl;
    }

    @JvmName(name = "getSubBizType")
    public final String getSubBizType() {
        return this.subBizType;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getLastTransactionTime")
    public final String getLastTransactionTime() {
        return this.lastTransactionTime;
    }
}
