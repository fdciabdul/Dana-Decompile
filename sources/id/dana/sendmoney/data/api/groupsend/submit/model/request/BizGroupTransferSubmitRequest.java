package id.dana.sendmoney.data.api.groupsend.submit.model.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.UrlParam;
import id.dana.sendmoney.data.api.groupsend.submit.model.ParticipantSubmitEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004JX\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\r\u0010\u001e\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001e\u001a\u0004\b \u0010\u0004R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u001e\u001a\u0004\b!\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001e\u001a\u0004\b\"\u0010\u0004R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u001e\u001a\u0004\b%\u0010\u0004"}, d2 = {"Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "Lid/dana/sendmoney/data/api/groupsend/submit/model/ParticipantSubmitEntity;", "component5", "()Ljava/util/List;", "component6", "bizType", "groupId", "groupName", "groupLogo", "participants", UrlParam.REQUEST_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/sendmoney/data/api/groupsend/submit/model/request/BizGroupTransferSubmitRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizType", "getGroupId", "getGroupLogo", "getGroupName", "Ljava/util/List;", "getParticipants", "getRequestId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BizGroupTransferSubmitRequest extends BaseRpcRequest {
    private final String bizType;
    private final String groupId;
    private final String groupLogo;
    private final String groupName;
    private final List<ParticipantSubmitEntity> participants;
    private final String requestId;

    public static /* synthetic */ BizGroupTransferSubmitRequest copy$default(BizGroupTransferSubmitRequest bizGroupTransferSubmitRequest, String str, String str2, String str3, String str4, List list, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bizGroupTransferSubmitRequest.bizType;
        }
        if ((i & 2) != 0) {
            str2 = bizGroupTransferSubmitRequest.groupId;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            str3 = bizGroupTransferSubmitRequest.groupName;
        }
        String str7 = str3;
        if ((i & 8) != 0) {
            str4 = bizGroupTransferSubmitRequest.groupLogo;
        }
        String str8 = str4;
        List<ParticipantSubmitEntity> list2 = list;
        if ((i & 16) != 0) {
            list2 = bizGroupTransferSubmitRequest.participants;
        }
        List list3 = list2;
        if ((i & 32) != 0) {
            str5 = bizGroupTransferSubmitRequest.requestId;
        }
        return bizGroupTransferSubmitRequest.copy(str, str6, str7, str8, list3, str5);
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
    public final String getGroupName() {
        return this.groupName;
    }

    /* renamed from: component4  reason: from getter */
    public final String getGroupLogo() {
        return this.groupLogo;
    }

    public final List<ParticipantSubmitEntity> component5() {
        return this.participants;
    }

    /* renamed from: component6  reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final BizGroupTransferSubmitRequest copy(String bizType, String groupId, String groupName, String groupLogo, List<ParticipantSubmitEntity> participants, String requestId) {
        Intrinsics.checkNotNullParameter(groupName, "");
        Intrinsics.checkNotNullParameter(participants, "");
        Intrinsics.checkNotNullParameter(requestId, "");
        return new BizGroupTransferSubmitRequest(bizType, groupId, groupName, groupLogo, participants, requestId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BizGroupTransferSubmitRequest) {
            BizGroupTransferSubmitRequest bizGroupTransferSubmitRequest = (BizGroupTransferSubmitRequest) other;
            return Intrinsics.areEqual(this.bizType, bizGroupTransferSubmitRequest.bizType) && Intrinsics.areEqual(this.groupId, bizGroupTransferSubmitRequest.groupId) && Intrinsics.areEqual(this.groupName, bizGroupTransferSubmitRequest.groupName) && Intrinsics.areEqual(this.groupLogo, bizGroupTransferSubmitRequest.groupLogo) && Intrinsics.areEqual(this.participants, bizGroupTransferSubmitRequest.participants) && Intrinsics.areEqual(this.requestId, bizGroupTransferSubmitRequest.requestId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.bizType;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.groupId;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        int hashCode3 = this.groupName.hashCode();
        String str3 = this.groupLogo;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str3 != null ? str3.hashCode() : 0)) * 31) + this.participants.hashCode()) * 31) + this.requestId.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BizGroupTransferSubmitRequest(bizType=");
        sb.append(this.bizType);
        sb.append(", groupId=");
        sb.append(this.groupId);
        sb.append(", groupName=");
        sb.append(this.groupName);
        sb.append(", groupLogo=");
        sb.append(this.groupLogo);
        sb.append(", participants=");
        sb.append(this.participants);
        sb.append(", requestId=");
        sb.append(this.requestId);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getBizType")
    public final String getBizType() {
        return this.bizType;
    }

    @JvmName(name = "getGroupId")
    public final String getGroupId() {
        return this.groupId;
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
    public final List<ParticipantSubmitEntity> getParticipants() {
        return this.participants;
    }

    @JvmName(name = "getRequestId")
    public final String getRequestId() {
        return this.requestId;
    }

    public BizGroupTransferSubmitRequest(String str, String str2, String str3, String str4, List<ParticipantSubmitEntity> list, String str5) {
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.bizType = str;
        this.groupId = str2;
        this.groupName = str3;
        this.groupLogo = str4;
        this.participants = list;
        this.requestId = str5;
    }
}
