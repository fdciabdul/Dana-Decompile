package id.dana.sendmoney.data.api.groupsend.detail.model;

import id.dana.domain.qrbarcode.DecodedScanBizInfoKey;
import id.dana.sendmoney.data.api.groupsend.submit.model.MilestoneEntity;
import id.dana.wallet_v3.constant.WalletConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\b\u0018\u00002\u00020\u0001BÁ\u0001\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0002\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\b\u0010%\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010*\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\bI\u0010JJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0018\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0004J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0004J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0004J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0004J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0004J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0004Jî\u0001\u0010+\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b+\u0010,J\u001a\u0010/\u001a\u00020.2\b\u0010-\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00104\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b4\u0010\u0004R\u0019\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u001a\u00105\u001a\u0004\b6\u0010\u0004R\u001c\u0010 \u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b \u00105\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u00105\u001a\u0004\b8\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u00105\u001a\u0004\b9\u0010\u0004R\u001c\u0010(\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b(\u00105\u001a\u0004\b:\u0010\u0004R\u001c\u0010!\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b!\u00105\u001a\u0004\b;\u0010\u0004R\u001c\u0010\"\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\"\u00105\u001a\u0004\b<\u0010\u0004R\u001c\u0010#\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b#\u00105\u001a\u0004\b=\u0010\u0004R\u001c\u0010)\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b)\u00105\u001a\u0004\b>\u0010\u0004R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b'\u00105\u001a\u0004\b?\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u00105\u001a\u0004\b@\u0010\u0004R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010A\u001a\u0004\bB\u0010\nR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u00105\u001a\u0004\bC\u0010\u0004R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b&\u00105\u001a\u0004\bD\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u00105\u001a\u0004\bE\u0010\u0004R\u001c\u0010%\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b%\u00105\u001a\u0004\bF\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u00105\u001a\u0004\bG\u0010\u0004R\u001c\u0010*\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b*\u00105\u001a\u0004\bH\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantInfoDetailEntity;", "", "", "component1", "()Ljava/lang/String;", "component10", "component11", "", "Lid/dana/sendmoney/data/api/groupsend/submit/model/MilestoneEntity;", "component12", "()Ljava/util/List;", "component13", "component14", "component15", "component16", "component17", "component18", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "userId", "avatar", "phoneNumber", "nickName", "contactName", "maskedLoginId", DecodedScanBizInfoKey.COMMENT, WalletConstant.CARD_INDEX_NO, "formattedHolderName", "holderFirstName", "holderLastName", "milestoneList", "senderName", "payMethod", "maskedCardNo", "externalSystemId", "instLocalName", "withdrawInstId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/sendmoney/data/api/groupsend/detail/model/ParticipantInfoDetailEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAvatar", "getCardIndexNo", "getComment", "getContactName", "getExternalSystemId", "getFormattedHolderName", "getHolderFirstName", "getHolderLastName", "getInstLocalName", "getMaskedCardNo", "getMaskedLoginId", "Ljava/util/List;", "getMilestoneList", "getNickName", "getPayMethod", "getPhoneNumber", "getSenderName", "getUserId", "getWithdrawInstId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ParticipantInfoDetailEntity {
    private final String avatar;
    private final String cardIndexNo;
    private final String comment;
    private final String contactName;
    private final String externalSystemId;
    private final String formattedHolderName;
    private final String holderFirstName;
    private final String holderLastName;
    private final String instLocalName;
    private final String maskedCardNo;
    private final String maskedLoginId;
    private final List<MilestoneEntity> milestoneList;
    private final String nickName;
    private final String payMethod;
    private final String phoneNumber;
    private final String senderName;
    private final String userId;
    private final String withdrawInstId;

    /* renamed from: component1  reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    /* renamed from: component10  reason: from getter */
    public final String getHolderFirstName() {
        return this.holderFirstName;
    }

    /* renamed from: component11  reason: from getter */
    public final String getHolderLastName() {
        return this.holderLastName;
    }

    public final List<MilestoneEntity> component12() {
        return this.milestoneList;
    }

    /* renamed from: component13  reason: from getter */
    public final String getSenderName() {
        return this.senderName;
    }

    /* renamed from: component14  reason: from getter */
    public final String getPayMethod() {
        return this.payMethod;
    }

    /* renamed from: component15  reason: from getter */
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    /* renamed from: component16  reason: from getter */
    public final String getExternalSystemId() {
        return this.externalSystemId;
    }

    /* renamed from: component17  reason: from getter */
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    /* renamed from: component18  reason: from getter */
    public final String getWithdrawInstId() {
        return this.withdrawInstId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getAvatar() {
        return this.avatar;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    /* renamed from: component4  reason: from getter */
    public final String getNickName() {
        return this.nickName;
    }

    /* renamed from: component5  reason: from getter */
    public final String getContactName() {
        return this.contactName;
    }

    /* renamed from: component6  reason: from getter */
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    /* renamed from: component7  reason: from getter */
    public final String getComment() {
        return this.comment;
    }

    /* renamed from: component8  reason: from getter */
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    /* renamed from: component9  reason: from getter */
    public final String getFormattedHolderName() {
        return this.formattedHolderName;
    }

    public final ParticipantInfoDetailEntity copy(String userId, String avatar, String phoneNumber, String nickName, String contactName, String maskedLoginId, String comment, String cardIndexNo, String formattedHolderName, String holderFirstName, String holderLastName, List<MilestoneEntity> milestoneList, String senderName, String payMethod, String maskedCardNo, String externalSystemId, String instLocalName, String withdrawInstId) {
        return new ParticipantInfoDetailEntity(userId, avatar, phoneNumber, nickName, contactName, maskedLoginId, comment, cardIndexNo, formattedHolderName, holderFirstName, holderLastName, milestoneList, senderName, payMethod, maskedCardNo, externalSystemId, instLocalName, withdrawInstId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ParticipantInfoDetailEntity) {
            ParticipantInfoDetailEntity participantInfoDetailEntity = (ParticipantInfoDetailEntity) other;
            return Intrinsics.areEqual(this.userId, participantInfoDetailEntity.userId) && Intrinsics.areEqual(this.avatar, participantInfoDetailEntity.avatar) && Intrinsics.areEqual(this.phoneNumber, participantInfoDetailEntity.phoneNumber) && Intrinsics.areEqual(this.nickName, participantInfoDetailEntity.nickName) && Intrinsics.areEqual(this.contactName, participantInfoDetailEntity.contactName) && Intrinsics.areEqual(this.maskedLoginId, participantInfoDetailEntity.maskedLoginId) && Intrinsics.areEqual(this.comment, participantInfoDetailEntity.comment) && Intrinsics.areEqual(this.cardIndexNo, participantInfoDetailEntity.cardIndexNo) && Intrinsics.areEqual(this.formattedHolderName, participantInfoDetailEntity.formattedHolderName) && Intrinsics.areEqual(this.holderFirstName, participantInfoDetailEntity.holderFirstName) && Intrinsics.areEqual(this.holderLastName, participantInfoDetailEntity.holderLastName) && Intrinsics.areEqual(this.milestoneList, participantInfoDetailEntity.milestoneList) && Intrinsics.areEqual(this.senderName, participantInfoDetailEntity.senderName) && Intrinsics.areEqual(this.payMethod, participantInfoDetailEntity.payMethod) && Intrinsics.areEqual(this.maskedCardNo, participantInfoDetailEntity.maskedCardNo) && Intrinsics.areEqual(this.externalSystemId, participantInfoDetailEntity.externalSystemId) && Intrinsics.areEqual(this.instLocalName, participantInfoDetailEntity.instLocalName) && Intrinsics.areEqual(this.withdrawInstId, participantInfoDetailEntity.withdrawInstId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.userId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.avatar;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.phoneNumber;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.nickName;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.contactName;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.maskedLoginId;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.comment;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.cardIndexNo;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.formattedHolderName;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.holderFirstName;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.holderLastName;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        List<MilestoneEntity> list = this.milestoneList;
        int hashCode12 = list == null ? 0 : list.hashCode();
        String str12 = this.senderName;
        int hashCode13 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.payMethod;
        int hashCode14 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.maskedCardNo;
        int hashCode15 = str14 == null ? 0 : str14.hashCode();
        String str15 = this.externalSystemId;
        int hashCode16 = str15 == null ? 0 : str15.hashCode();
        String str16 = this.instLocalName;
        int hashCode17 = str16 == null ? 0 : str16.hashCode();
        String str17 = this.withdrawInstId;
        return (((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + hashCode14) * 31) + hashCode15) * 31) + hashCode16) * 31) + hashCode17) * 31) + (str17 != null ? str17.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ParticipantInfoDetailEntity(userId=");
        sb.append(this.userId);
        sb.append(", avatar=");
        sb.append(this.avatar);
        sb.append(", phoneNumber=");
        sb.append(this.phoneNumber);
        sb.append(", nickName=");
        sb.append(this.nickName);
        sb.append(", contactName=");
        sb.append(this.contactName);
        sb.append(", maskedLoginId=");
        sb.append(this.maskedLoginId);
        sb.append(", comment=");
        sb.append(this.comment);
        sb.append(", cardIndexNo=");
        sb.append(this.cardIndexNo);
        sb.append(", formattedHolderName=");
        sb.append(this.formattedHolderName);
        sb.append(", holderFirstName=");
        sb.append(this.holderFirstName);
        sb.append(", holderLastName=");
        sb.append(this.holderLastName);
        sb.append(", milestoneList=");
        sb.append(this.milestoneList);
        sb.append(", senderName=");
        sb.append(this.senderName);
        sb.append(", payMethod=");
        sb.append(this.payMethod);
        sb.append(", maskedCardNo=");
        sb.append(this.maskedCardNo);
        sb.append(", externalSystemId=");
        sb.append(this.externalSystemId);
        sb.append(", instLocalName=");
        sb.append(this.instLocalName);
        sb.append(", withdrawInstId=");
        sb.append(this.withdrawInstId);
        sb.append(')');
        return sb.toString();
    }

    public ParticipantInfoDetailEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, List<MilestoneEntity> list, String str12, String str13, String str14, String str15, String str16, String str17) {
        this.userId = str;
        this.avatar = str2;
        this.phoneNumber = str3;
        this.nickName = str4;
        this.contactName = str5;
        this.maskedLoginId = str6;
        this.comment = str7;
        this.cardIndexNo = str8;
        this.formattedHolderName = str9;
        this.holderFirstName = str10;
        this.holderLastName = str11;
        this.milestoneList = list;
        this.senderName = str12;
        this.payMethod = str13;
        this.maskedCardNo = str14;
        this.externalSystemId = str15;
        this.instLocalName = str16;
        this.withdrawInstId = str17;
    }

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "getAvatar")
    public final String getAvatar() {
        return this.avatar;
    }

    @JvmName(name = "getPhoneNumber")
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @JvmName(name = "getNickName")
    public final String getNickName() {
        return this.nickName;
    }

    @JvmName(name = "getContactName")
    public final String getContactName() {
        return this.contactName;
    }

    @JvmName(name = "getMaskedLoginId")
    public final String getMaskedLoginId() {
        return this.maskedLoginId;
    }

    @JvmName(name = "getComment")
    public final String getComment() {
        return this.comment;
    }

    @JvmName(name = "getCardIndexNo")
    public final String getCardIndexNo() {
        return this.cardIndexNo;
    }

    @JvmName(name = "getFormattedHolderName")
    public final String getFormattedHolderName() {
        return this.formattedHolderName;
    }

    @JvmName(name = "getHolderFirstName")
    public final String getHolderFirstName() {
        return this.holderFirstName;
    }

    @JvmName(name = "getHolderLastName")
    public final String getHolderLastName() {
        return this.holderLastName;
    }

    @JvmName(name = "getMilestoneList")
    public final List<MilestoneEntity> getMilestoneList() {
        return this.milestoneList;
    }

    @JvmName(name = "getSenderName")
    public final String getSenderName() {
        return this.senderName;
    }

    @JvmName(name = "getPayMethod")
    public final String getPayMethod() {
        return this.payMethod;
    }

    @JvmName(name = "getMaskedCardNo")
    public final String getMaskedCardNo() {
        return this.maskedCardNo;
    }

    @JvmName(name = "getExternalSystemId")
    public final String getExternalSystemId() {
        return this.externalSystemId;
    }

    @JvmName(name = "getInstLocalName")
    public final String getInstLocalName() {
        return this.instLocalName;
    }

    @JvmName(name = "getWithdrawInstId")
    public final String getWithdrawInstId() {
        return this.withdrawInstId;
    }
}
