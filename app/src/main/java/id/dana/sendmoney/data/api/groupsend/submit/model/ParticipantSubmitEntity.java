package id.dana.sendmoney.data.api.groupsend.submit.model;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b$\u0010%J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0007JX\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u0007R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\u0010\u0010\u001c\u001a\u0004\b\u001d\u0010\u0007R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u001c\u001a\u0004\b\u001e\u0010\u0007R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b\u001f\u0010\u0007R\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010 \u001a\u0004\b!\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\"\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001c\u001a\u0004\b#\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;", "component1", "()Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;", "", "component2", "()Ljava/lang/String;", "component3", "component4", "component5", "component6", "participantInfo", "groupDetailId", "subBizType", "transferAmount", "chargeAmount", "extendInfo", "copy", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getChargeAmount", "getExtendInfo", "getGroupDetailId", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;", "getParticipantInfo", "getSubBizType", "getTransferAmount", "<init>", "(Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantInfoSubmitEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantSubmitEntity {
    private final String chargeAmount;
    private final String extendInfo;
    private final String groupDetailId;
    private final ParticipantInfoSubmitEntity participantInfo;
    private final String subBizType;
    private final String transferAmount;

    public static /* synthetic */ ParticipantSubmitEntity copy$default(ParticipantSubmitEntity participantSubmitEntity, ParticipantInfoSubmitEntity participantInfoSubmitEntity, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            participantInfoSubmitEntity = participantSubmitEntity.participantInfo;
        }
        if ((i & 2) != 0) {
            str = participantSubmitEntity.groupDetailId;
        }
        String str6 = str;
        if ((i & 4) != 0) {
            str2 = participantSubmitEntity.subBizType;
        }
        String str7 = str2;
        if ((i & 8) != 0) {
            str3 = participantSubmitEntity.transferAmount;
        }
        String str8 = str3;
        if ((i & 16) != 0) {
            str4 = participantSubmitEntity.chargeAmount;
        }
        String str9 = str4;
        if ((i & 32) != 0) {
            str5 = participantSubmitEntity.extendInfo;
        }
        return participantSubmitEntity.copy(participantInfoSubmitEntity, str6, str7, str8, str9, str5);
    }

    /* renamed from: component1  reason: from getter */
    public final ParticipantInfoSubmitEntity getParticipantInfo() {
        return this.participantInfo;
    }

    /* renamed from: component2  reason: from getter */
    public final String getGroupDetailId() {
        return this.groupDetailId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getSubBizType() {
        return this.subBizType;
    }

    /* renamed from: component4  reason: from getter */
    public final String getTransferAmount() {
        return this.transferAmount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getChargeAmount() {
        return this.chargeAmount;
    }

    /* renamed from: component6  reason: from getter */
    public final String getExtendInfo() {
        return this.extendInfo;
    }

    public final ParticipantSubmitEntity copy(ParticipantInfoSubmitEntity participantInfo, String groupDetailId, String subBizType, String transferAmount, String chargeAmount, String extendInfo) {
        return new ParticipantSubmitEntity(participantInfo, groupDetailId, subBizType, transferAmount, chargeAmount, extendInfo);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ParticipantSubmitEntity) {
            ParticipantSubmitEntity participantSubmitEntity = (ParticipantSubmitEntity) other;
            return Intrinsics.areEqual(this.participantInfo, participantSubmitEntity.participantInfo) && Intrinsics.areEqual(this.groupDetailId, participantSubmitEntity.groupDetailId) && Intrinsics.areEqual(this.subBizType, participantSubmitEntity.subBizType) && Intrinsics.areEqual(this.transferAmount, participantSubmitEntity.transferAmount) && Intrinsics.areEqual(this.chargeAmount, participantSubmitEntity.chargeAmount) && Intrinsics.areEqual(this.extendInfo, participantSubmitEntity.extendInfo);
        }
        return false;
    }

    public final int hashCode() {
        ParticipantInfoSubmitEntity participantInfoSubmitEntity = this.participantInfo;
        int hashCode = participantInfoSubmitEntity == null ? 0 : participantInfoSubmitEntity.hashCode();
        String str = this.groupDetailId;
        int hashCode2 = str == null ? 0 : str.hashCode();
        String str2 = this.subBizType;
        int hashCode3 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.transferAmount;
        int hashCode4 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.chargeAmount;
        int hashCode5 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.extendInfo;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (str5 != null ? str5.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantSubmitEntity(participantInfo=");
        sb.append(this.participantInfo);
        sb.append(", groupDetailId=");
        sb.append(this.groupDetailId);
        sb.append(", subBizType=");
        sb.append(this.subBizType);
        sb.append(", transferAmount=");
        sb.append(this.transferAmount);
        sb.append(", chargeAmount=");
        sb.append(this.chargeAmount);
        sb.append(", extendInfo=");
        sb.append(this.extendInfo);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantSubmitEntity(ParticipantInfoSubmitEntity participantInfoSubmitEntity, String str, String str2, String str3, String str4, String str5) {
        this.participantInfo = participantInfoSubmitEntity;
        this.groupDetailId = str;
        this.subBizType = str2;
        this.transferAmount = str3;
        this.chargeAmount = str4;
        this.extendInfo = str5;
    }

    @JvmName(name = "getParticipantInfo")
    public final ParticipantInfoSubmitEntity getParticipantInfo() {
        return this.participantInfo;
    }

    @JvmName(name = "getGroupDetailId")
    public final String getGroupDetailId() {
        return this.groupDetailId;
    }

    @JvmName(name = "getSubBizType")
    public final String getSubBizType() {
        return this.subBizType;
    }

    @JvmName(name = "getTransferAmount")
    public final String getTransferAmount() {
        return this.transferAmount;
    }

    @JvmName(name = "getChargeAmount")
    public final String getChargeAmount() {
        return this.chargeAmount;
    }

    @JvmName(name = "getExtendInfo")
    public final String getExtendInfo() {
        return this.extendInfo;
    }
}
