package id.dana.data.electronicmoney.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.transactionstatus.TransactionStatusBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u001f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b:\u0010;J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u0004J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u0004J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0004J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0004J¸\u0001\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\"HÖ\u0003¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'HÖ\u0001¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b*\u0010\u0004R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0015\u0010+\u001a\u0004\b,\u0010\u0004R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010+\u001a\u0004\b-\u0010\u0004R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010+\u001a\u0004\b.\u0010\u0004R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010+\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010+\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010+\u001a\u0004\b1\u0010\u0004R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010+\u001a\u0004\b2\u0010\u0004R\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010+\u001a\u0004\b3\u0010\u0004R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b4\u0010\u0004R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010+\u001a\u0004\b5\u0010\u0004R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010+\u001a\u0004\b6\u0010\u0004R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010+\u001a\u0004\b7\u0010\u0004R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010+\u001a\u0004\b8\u0010\u0004R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010+\u001a\u0004\b9\u0010\u0004"}, d2 = {"Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "approvalCode", "apiVersion", "message", "amount", "cardNumber", "reversalCount", "state", TransactionStatusBridge.Companion.TransactionStatusParamKey.TRANSACTION_ID, "typeCard", "pendingTopup", "session", "lastBalance", "responseFromSam", "status", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/electronicmoney/network/response/EmoneyDataEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getAmount", "getApiVersion", "getApprovalCode", "getCardNumber", "getLastBalance", "getMessage", "getPendingTopup", "getResponseFromSam", "getReversalCount", "getSession", "getState", "getStatus", "getTransactionId", "getTypeCard", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class EmoneyDataEntity extends BaseRpcResult {
    private final String amount;
    private final String apiVersion;
    private final String approvalCode;
    private final String cardNumber;
    private final String lastBalance;
    private final String message;
    private final String pendingTopup;
    private final String responseFromSam;
    private final String reversalCount;
    private final String session;
    private final String state;
    private final String status;
    private final String transactionId;
    private final String typeCard;

    public EmoneyDataEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
    }

    /* renamed from: component1  reason: from getter */
    public final String getApprovalCode() {
        return this.approvalCode;
    }

    /* renamed from: component10  reason: from getter */
    public final String getPendingTopup() {
        return this.pendingTopup;
    }

    /* renamed from: component11  reason: from getter */
    public final String getSession() {
        return this.session;
    }

    /* renamed from: component12  reason: from getter */
    public final String getLastBalance() {
        return this.lastBalance;
    }

    /* renamed from: component13  reason: from getter */
    public final String getResponseFromSam() {
        return this.responseFromSam;
    }

    /* renamed from: component14  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2  reason: from getter */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component4  reason: from getter */
    public final String getAmount() {
        return this.amount;
    }

    /* renamed from: component5  reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component6  reason: from getter */
    public final String getReversalCount() {
        return this.reversalCount;
    }

    /* renamed from: component7  reason: from getter */
    public final String getState() {
        return this.state;
    }

    /* renamed from: component8  reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    /* renamed from: component9  reason: from getter */
    public final String getTypeCard() {
        return this.typeCard;
    }

    public final EmoneyDataEntity copy(String approvalCode, String apiVersion, String message, String amount, String cardNumber, String reversalCount, String state, String transactionId, String typeCard, String pendingTopup, String session, String lastBalance, String responseFromSam, String status) {
        return new EmoneyDataEntity(approvalCode, apiVersion, message, amount, cardNumber, reversalCount, state, transactionId, typeCard, pendingTopup, session, lastBalance, responseFromSam, status);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof EmoneyDataEntity) {
            EmoneyDataEntity emoneyDataEntity = (EmoneyDataEntity) other;
            return Intrinsics.areEqual(this.approvalCode, emoneyDataEntity.approvalCode) && Intrinsics.areEqual(this.apiVersion, emoneyDataEntity.apiVersion) && Intrinsics.areEqual(this.message, emoneyDataEntity.message) && Intrinsics.areEqual(this.amount, emoneyDataEntity.amount) && Intrinsics.areEqual(this.cardNumber, emoneyDataEntity.cardNumber) && Intrinsics.areEqual(this.reversalCount, emoneyDataEntity.reversalCount) && Intrinsics.areEqual(this.state, emoneyDataEntity.state) && Intrinsics.areEqual(this.transactionId, emoneyDataEntity.transactionId) && Intrinsics.areEqual(this.typeCard, emoneyDataEntity.typeCard) && Intrinsics.areEqual(this.pendingTopup, emoneyDataEntity.pendingTopup) && Intrinsics.areEqual(this.session, emoneyDataEntity.session) && Intrinsics.areEqual(this.lastBalance, emoneyDataEntity.lastBalance) && Intrinsics.areEqual(this.responseFromSam, emoneyDataEntity.responseFromSam) && Intrinsics.areEqual(this.status, emoneyDataEntity.status);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.approvalCode;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.apiVersion;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.message;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.amount;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.cardNumber;
        int hashCode5 = str5 == null ? 0 : str5.hashCode();
        String str6 = this.reversalCount;
        int hashCode6 = str6 == null ? 0 : str6.hashCode();
        String str7 = this.state;
        int hashCode7 = str7 == null ? 0 : str7.hashCode();
        String str8 = this.transactionId;
        int hashCode8 = str8 == null ? 0 : str8.hashCode();
        String str9 = this.typeCard;
        int hashCode9 = str9 == null ? 0 : str9.hashCode();
        String str10 = this.pendingTopup;
        int hashCode10 = str10 == null ? 0 : str10.hashCode();
        String str11 = this.session;
        int hashCode11 = str11 == null ? 0 : str11.hashCode();
        String str12 = this.lastBalance;
        int hashCode12 = str12 == null ? 0 : str12.hashCode();
        String str13 = this.responseFromSam;
        int hashCode13 = str13 == null ? 0 : str13.hashCode();
        String str14 = this.status;
        return (((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + hashCode7) * 31) + hashCode8) * 31) + hashCode9) * 31) + hashCode10) * 31) + hashCode11) * 31) + hashCode12) * 31) + hashCode13) * 31) + (str14 != null ? str14.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EmoneyDataEntity(approvalCode=");
        sb.append(this.approvalCode);
        sb.append(", apiVersion=");
        sb.append(this.apiVersion);
        sb.append(", message=");
        sb.append(this.message);
        sb.append(", amount=");
        sb.append(this.amount);
        sb.append(", cardNumber=");
        sb.append(this.cardNumber);
        sb.append(", reversalCount=");
        sb.append(this.reversalCount);
        sb.append(", state=");
        sb.append(this.state);
        sb.append(", transactionId=");
        sb.append(this.transactionId);
        sb.append(", typeCard=");
        sb.append(this.typeCard);
        sb.append(", pendingTopup=");
        sb.append(this.pendingTopup);
        sb.append(", session=");
        sb.append(this.session);
        sb.append(", lastBalance=");
        sb.append(this.lastBalance);
        sb.append(", responseFromSam=");
        sb.append(this.responseFromSam);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ EmoneyDataEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? "" : str6, (i & 64) != 0 ? "" : str7, (i & 128) != 0 ? "" : str8, (i & 256) != 0 ? "" : str9, (i & 512) != 0 ? "" : str10, (i & 1024) != 0 ? "" : str11, (i & 2048) != 0 ? "" : str12, (i & 4096) != 0 ? "" : str13, (i & 8192) == 0 ? str14 : "");
    }

    @JvmName(name = "getApprovalCode")
    public final String getApprovalCode() {
        return this.approvalCode;
    }

    @JvmName(name = "getApiVersion")
    public final String getApiVersion() {
        return this.apiVersion;
    }

    @JvmName(name = "getMessage")
    public final String getMessage() {
        return this.message;
    }

    @JvmName(name = "getAmount")
    public final String getAmount() {
        return this.amount;
    }

    @JvmName(name = "getCardNumber")
    public final String getCardNumber() {
        return this.cardNumber;
    }

    @JvmName(name = "getReversalCount")
    public final String getReversalCount() {
        return this.reversalCount;
    }

    @JvmName(name = "getState")
    public final String getState() {
        return this.state;
    }

    @JvmName(name = "getTransactionId")
    public final String getTransactionId() {
        return this.transactionId;
    }

    @JvmName(name = "getTypeCard")
    public final String getTypeCard() {
        return this.typeCard;
    }

    @JvmName(name = "getPendingTopup")
    public final String getPendingTopup() {
        return this.pendingTopup;
    }

    @JvmName(name = "getSession")
    public final String getSession() {
        return this.session;
    }

    @JvmName(name = "getLastBalance")
    public final String getLastBalance() {
        return this.lastBalance;
    }

    @JvmName(name = "getResponseFromSam")
    public final String getResponseFromSam() {
        return this.responseFromSam;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    public EmoneyDataEntity(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.approvalCode = str;
        this.apiVersion = str2;
        this.message = str3;
        this.amount = str4;
        this.cardNumber = str5;
        this.reversalCount = str6;
        this.state = str7;
        this.transactionId = str8;
        this.typeCard = str9;
        this.pendingTopup = str10;
        this.session = str11;
        this.lastBalance = str12;
        this.responseFromSam = str13;
        this.status = str14;
    }
}
