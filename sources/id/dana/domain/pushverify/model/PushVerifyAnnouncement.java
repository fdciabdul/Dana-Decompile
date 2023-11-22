package id.dana.domain.pushverify.model;

import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J.\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0004R\u0017\u0010\t\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u0011\u0010\u0016\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0018\u0010\u0004R\u001a\u0010\u0007\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0014\u001a\u0004\b\u0019\u0010\u0004"}, d2 = {"Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "", "", "component1", "()Ljava/lang/String;", "component2", "component3", BranchLinkConstant.PushVerifyParams.TRANSACTION_ID, "token", "cacheKey", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/domain/pushverify/model/PushVerifyAnnouncement;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCacheKey", "isValid", "()Z", "getToken", "getTrxId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class PushVerifyAnnouncement {
    private final String cacheKey;
    private final String token;
    private final String trxId;

    public PushVerifyAnnouncement() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PushVerifyAnnouncement copy$default(PushVerifyAnnouncement pushVerifyAnnouncement, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = pushVerifyAnnouncement.trxId;
        }
        if ((i & 2) != 0) {
            str2 = pushVerifyAnnouncement.token;
        }
        if ((i & 4) != 0) {
            str3 = pushVerifyAnnouncement.cacheKey;
        }
        return pushVerifyAnnouncement.copy(str, str2, str3);
    }

    /* renamed from: component1  reason: from getter */
    public final String getTrxId() {
        return this.trxId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getToken() {
        return this.token;
    }

    /* renamed from: component3  reason: from getter */
    public final String getCacheKey() {
        return this.cacheKey;
    }

    public final PushVerifyAnnouncement copy(String trxId, String token, String cacheKey) {
        Intrinsics.checkNotNullParameter(trxId, "");
        Intrinsics.checkNotNullParameter(token, "");
        Intrinsics.checkNotNullParameter(cacheKey, "");
        return new PushVerifyAnnouncement(trxId, token, cacheKey);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PushVerifyAnnouncement) {
            PushVerifyAnnouncement pushVerifyAnnouncement = (PushVerifyAnnouncement) other;
            return Intrinsics.areEqual(this.trxId, pushVerifyAnnouncement.trxId) && Intrinsics.areEqual(this.token, pushVerifyAnnouncement.token) && Intrinsics.areEqual(this.cacheKey, pushVerifyAnnouncement.cacheKey);
        }
        return false;
    }

    public final int hashCode() {
        return (((this.trxId.hashCode() * 31) + this.token.hashCode()) * 31) + this.cacheKey.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PushVerifyAnnouncement(trxId=");
        sb.append(this.trxId);
        sb.append(", token=");
        sb.append(this.token);
        sb.append(", cacheKey=");
        sb.append(this.cacheKey);
        sb.append(')');
        return sb.toString();
    }

    public PushVerifyAnnouncement(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.trxId = str;
        this.token = str2;
        this.cacheKey = str3;
    }

    public /* synthetic */ PushVerifyAnnouncement(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3);
    }

    @JvmName(name = "getTrxId")
    public final String getTrxId() {
        return this.trxId;
    }

    @JvmName(name = "getToken")
    public final String getToken() {
        return this.token;
    }

    @JvmName(name = "getCacheKey")
    public final String getCacheKey() {
        return this.cacheKey;
    }

    @JvmName(name = "isValid")
    public final boolean isValid() {
        return (StringsKt.isBlank(this.trxId) ^ true) && (StringsKt.isBlank(this.token) ^ true) && (StringsKt.isBlank(this.cacheKey) ^ true);
    }
}
