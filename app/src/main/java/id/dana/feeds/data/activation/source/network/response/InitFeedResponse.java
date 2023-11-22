package id.dana.feeds.data.activation.source.network.response;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u0010JR\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00022\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\n2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\rHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u001d\u0010\fJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0004R\u0017\u0010\u0015\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0015\u0010\u001f\u001a\u0004\b \u0010\fR\u001a\u0010\u0012\u001a\u00020\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010!\u001a\u0004\b\"\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b%\u0010\u0004R \u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010&\u001a\u0004\b'\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b(\u0010\u0004"}, d2 = {"Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Z", "component3", "component4", "", "component5", "()I", "", "Lid/dana/feeds/data/activation/source/network/response/OperationLog;", "component6", "()Ljava/util/List;", "nickname", "kycStatus", "maskedPhoneNumber", "status", "initProgress", "operationLogList", "copy", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/List;)Lid/dana/feeds/data/activation/source/network/response/InitFeedResponse;", "", "other", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "I", "getInitProgress", "Z", "getKycStatus", "Ljava/lang/String;", "getMaskedPhoneNumber", "getNickname", "Ljava/util/List;", "getOperationLogList", "getStatus", "<init>", "(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class InitFeedResponse extends BaseRpcResult {
    private final int initProgress;
    private final boolean kycStatus;
    private final String maskedPhoneNumber;
    private final String nickname;
    private final List<OperationLog> operationLogList;
    private final String status;

    public static /* synthetic */ InitFeedResponse copy$default(InitFeedResponse initFeedResponse, String str, boolean z, String str2, String str3, int i, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = initFeedResponse.nickname;
        }
        if ((i2 & 2) != 0) {
            z = initFeedResponse.kycStatus;
        }
        boolean z2 = z;
        if ((i2 & 4) != 0) {
            str2 = initFeedResponse.maskedPhoneNumber;
        }
        String str4 = str2;
        if ((i2 & 8) != 0) {
            str3 = initFeedResponse.status;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            i = initFeedResponse.initProgress;
        }
        int i3 = i;
        List<OperationLog> list2 = list;
        if ((i2 & 32) != 0) {
            list2 = initFeedResponse.operationLogList;
        }
        return initFeedResponse.copy(str, z2, str4, str5, i3, list2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getNickname() {
        return this.nickname;
    }

    /* renamed from: component2  reason: from getter */
    public final boolean getKycStatus() {
        return this.kycStatus;
    }

    /* renamed from: component3  reason: from getter */
    public final String getMaskedPhoneNumber() {
        return this.maskedPhoneNumber;
    }

    /* renamed from: component4  reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component5  reason: from getter */
    public final int getInitProgress() {
        return this.initProgress;
    }

    public final List<OperationLog> component6() {
        return this.operationLogList;
    }

    public final InitFeedResponse copy(String nickname, boolean kycStatus, String maskedPhoneNumber, String status, int initProgress, List<OperationLog> operationLogList) {
        Intrinsics.checkNotNullParameter(nickname, "");
        Intrinsics.checkNotNullParameter(maskedPhoneNumber, "");
        Intrinsics.checkNotNullParameter(status, "");
        Intrinsics.checkNotNullParameter(operationLogList, "");
        return new InitFeedResponse(nickname, kycStatus, maskedPhoneNumber, status, initProgress, operationLogList);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof InitFeedResponse) {
            InitFeedResponse initFeedResponse = (InitFeedResponse) other;
            return Intrinsics.areEqual(this.nickname, initFeedResponse.nickname) && this.kycStatus == initFeedResponse.kycStatus && Intrinsics.areEqual(this.maskedPhoneNumber, initFeedResponse.maskedPhoneNumber) && Intrinsics.areEqual(this.status, initFeedResponse.status) && this.initProgress == initFeedResponse.initProgress && Intrinsics.areEqual(this.operationLogList, initFeedResponse.operationLogList);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.nickname.hashCode();
        boolean z = this.kycStatus;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((hashCode * 31) + i) * 31) + this.maskedPhoneNumber.hashCode()) * 31) + this.status.hashCode()) * 31) + this.initProgress) * 31) + this.operationLogList.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("InitFeedResponse(nickname=");
        sb.append(this.nickname);
        sb.append(", kycStatus=");
        sb.append(this.kycStatus);
        sb.append(", maskedPhoneNumber=");
        sb.append(this.maskedPhoneNumber);
        sb.append(", status=");
        sb.append(this.status);
        sb.append(", initProgress=");
        sb.append(this.initProgress);
        sb.append(", operationLogList=");
        sb.append(this.operationLogList);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getNickname")
    public final String getNickname() {
        return this.nickname;
    }

    @JvmName(name = "getKycStatus")
    public final boolean getKycStatus() {
        return this.kycStatus;
    }

    @JvmName(name = "getMaskedPhoneNumber")
    public final String getMaskedPhoneNumber() {
        return this.maskedPhoneNumber;
    }

    @JvmName(name = "getStatus")
    public final String getStatus() {
        return this.status;
    }

    @JvmName(name = "getInitProgress")
    public final int getInitProgress() {
        return this.initProgress;
    }

    public /* synthetic */ InitFeedResponse(String str, boolean z, String str2, String str3, int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, z, str2, str3, (i2 & 16) != 0 ? 0 : i, (i2 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getOperationLogList")
    public final List<OperationLog> getOperationLogList() {
        return this.operationLogList;
    }

    public InitFeedResponse(String str, boolean z, String str2, String str3, int i, List<OperationLog> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(list, "");
        this.nickname = str;
        this.kycStatus = z;
        this.maskedPhoneNumber = str2;
        this.status = str3;
        this.initProgress = i;
        this.operationLogList = list;
    }
}
