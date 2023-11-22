package id.dana.kyb.domain.model;

import id.dana.domain.homeinfo.KybResponse;
import id.dana.domain.user.UserInfoResponse;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00058\u0007¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u0011\u0010\u001d\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0019R\u0011\u0010\u001f\u001a\u00020\u00178G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\nR\u001a\u0010\u000b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\"\u001a\u0004\b#\u0010\u0004"}, d2 = {"Lid/dana/kyb/domain/model/KybCompleteInfo;", "", "Lid/dana/domain/user/UserInfoResponse;", "component1", "()Lid/dana/domain/user/UserInfoResponse;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "component2", "()Lid/dana/kyb/domain/model/KybMerchantInfo;", "Lid/dana/kyb/domain/model/QueryLatestOrder;", "component3", "()Lid/dana/kyb/domain/model/QueryLatestOrder;", "userInfoResponse", "kybMerchantInfo", "queryLatestOrder", "copy", "(Lid/dana/domain/user/UserInfoResponse;Lid/dana/kyb/domain/model/KybMerchantInfo;Lid/dana/kyb/domain/model/QueryLatestOrder;)Lid/dana/kyb/domain/model/KybCompleteInfo;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "Lid/dana/kyb/domain/model/KybMerchantInfo;", "getKybMerchantInfo", "getMerchantId", "merchantId", "getMerchantTier", "merchantTier", "Lid/dana/kyb/domain/model/QueryLatestOrder;", "getQueryLatestOrder", "Lid/dana/domain/user/UserInfoResponse;", "getUserInfoResponse", "<init>", "(Lid/dana/domain/user/UserInfoResponse;Lid/dana/kyb/domain/model/KybMerchantInfo;Lid/dana/kyb/domain/model/QueryLatestOrder;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class KybCompleteInfo {
    private final KybMerchantInfo kybMerchantInfo;
    private final QueryLatestOrder queryLatestOrder;
    private final UserInfoResponse userInfoResponse;

    public static /* synthetic */ KybCompleteInfo copy$default(KybCompleteInfo kybCompleteInfo, UserInfoResponse userInfoResponse, KybMerchantInfo kybMerchantInfo, QueryLatestOrder queryLatestOrder, int i, Object obj) {
        if ((i & 1) != 0) {
            userInfoResponse = kybCompleteInfo.userInfoResponse;
        }
        if ((i & 2) != 0) {
            kybMerchantInfo = kybCompleteInfo.kybMerchantInfo;
        }
        if ((i & 4) != 0) {
            queryLatestOrder = kybCompleteInfo.queryLatestOrder;
        }
        return kybCompleteInfo.copy(userInfoResponse, kybMerchantInfo, queryLatestOrder);
    }

    /* renamed from: component1  reason: from getter */
    public final UserInfoResponse getUserInfoResponse() {
        return this.userInfoResponse;
    }

    /* renamed from: component2  reason: from getter */
    public final KybMerchantInfo getKybMerchantInfo() {
        return this.kybMerchantInfo;
    }

    /* renamed from: component3  reason: from getter */
    public final QueryLatestOrder getQueryLatestOrder() {
        return this.queryLatestOrder;
    }

    public final KybCompleteInfo copy(UserInfoResponse userInfoResponse, KybMerchantInfo kybMerchantInfo, QueryLatestOrder queryLatestOrder) {
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        return new KybCompleteInfo(userInfoResponse, kybMerchantInfo, queryLatestOrder);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof KybCompleteInfo) {
            KybCompleteInfo kybCompleteInfo = (KybCompleteInfo) other;
            return Intrinsics.areEqual(this.userInfoResponse, kybCompleteInfo.userInfoResponse) && Intrinsics.areEqual(this.kybMerchantInfo, kybCompleteInfo.kybMerchantInfo) && Intrinsics.areEqual(this.queryLatestOrder, kybCompleteInfo.queryLatestOrder);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.userInfoResponse.hashCode();
        KybMerchantInfo kybMerchantInfo = this.kybMerchantInfo;
        int hashCode2 = kybMerchantInfo == null ? 0 : kybMerchantInfo.hashCode();
        QueryLatestOrder queryLatestOrder = this.queryLatestOrder;
        return (((hashCode * 31) + hashCode2) * 31) + (queryLatestOrder != null ? queryLatestOrder.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("KybCompleteInfo(userInfoResponse=");
        sb.append(this.userInfoResponse);
        sb.append(", kybMerchantInfo=");
        sb.append(this.kybMerchantInfo);
        sb.append(", queryLatestOrder=");
        sb.append(this.queryLatestOrder);
        sb.append(')');
        return sb.toString();
    }

    public KybCompleteInfo(UserInfoResponse userInfoResponse, KybMerchantInfo kybMerchantInfo, QueryLatestOrder queryLatestOrder) {
        Intrinsics.checkNotNullParameter(userInfoResponse, "");
        this.userInfoResponse = userInfoResponse;
        this.kybMerchantInfo = kybMerchantInfo;
        this.queryLatestOrder = queryLatestOrder;
    }

    public /* synthetic */ KybCompleteInfo(UserInfoResponse userInfoResponse, KybMerchantInfo kybMerchantInfo, QueryLatestOrder queryLatestOrder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(userInfoResponse, (i & 2) != 0 ? null : kybMerchantInfo, (i & 4) != 0 ? null : queryLatestOrder);
    }

    @JvmName(name = "getUserInfoResponse")
    public final UserInfoResponse getUserInfoResponse() {
        return this.userInfoResponse;
    }

    @JvmName(name = "getKybMerchantInfo")
    public final KybMerchantInfo getKybMerchantInfo() {
        return this.kybMerchantInfo;
    }

    @JvmName(name = "getQueryLatestOrder")
    public final QueryLatestOrder getQueryLatestOrder() {
        return this.queryLatestOrder;
    }

    @JvmName(name = "getMerchantId")
    public final String getMerchantId() {
        KybMerchantInfo kybMerchantInfo = this.kybMerchantInfo;
        String merchantId = kybMerchantInfo != null ? kybMerchantInfo.getMerchantId() : null;
        return merchantId == null ? "" : merchantId;
    }

    @JvmName(name = "getMerchantTier")
    public final String getMerchantTier() {
        KybResponse kybResponse = this.userInfoResponse.getKybResponse();
        String certificateTier = kybResponse != null ? kybResponse.getCertificateTier() : null;
        return certificateTier == null ? "" : certificateTier;
    }
}
