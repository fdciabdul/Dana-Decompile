package id.dana.data.familyaccount.model.result;

import com.alibaba.griver.api.jsapi.diagnostic.RecordError;
import id.dana.danah5.bioutility.BioUtilityBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J(\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0004R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;", "", "", "component1", "()Ljava/lang/String;", "component2", RecordError.KEY_PUB_KEY, BioUtilityBridge.SECURITY_ID, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/familyaccount/model/result/SecurityContextAttributesEntity;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getPubKey", "getSecurityId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class SecurityContextAttributesEntity {
    private final String pubKey;
    private final String securityId;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public SecurityContextAttributesEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.familyaccount.model.result.SecurityContextAttributesEntity.<init>():void");
    }

    public static /* synthetic */ SecurityContextAttributesEntity copy$default(SecurityContextAttributesEntity securityContextAttributesEntity, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = securityContextAttributesEntity.pubKey;
        }
        if ((i & 2) != 0) {
            str2 = securityContextAttributesEntity.securityId;
        }
        return securityContextAttributesEntity.copy(str, str2);
    }

    /* renamed from: component1  reason: from getter */
    public final String getPubKey() {
        return this.pubKey;
    }

    /* renamed from: component2  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final SecurityContextAttributesEntity copy(String pubKey, String securityId) {
        return new SecurityContextAttributesEntity(pubKey, securityId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof SecurityContextAttributesEntity) {
            SecurityContextAttributesEntity securityContextAttributesEntity = (SecurityContextAttributesEntity) other;
            return Intrinsics.areEqual(this.pubKey, securityContextAttributesEntity.pubKey) && Intrinsics.areEqual(this.securityId, securityContextAttributesEntity.securityId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.pubKey;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.securityId;
        return (hashCode * 31) + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SecurityContextAttributesEntity(pubKey=");
        sb.append(this.pubKey);
        sb.append(", securityId=");
        sb.append(this.securityId);
        sb.append(')');
        return sb.toString();
    }

    public SecurityContextAttributesEntity(String str, String str2) {
        this.pubKey = str;
        this.securityId = str2;
    }

    public /* synthetic */ SecurityContextAttributesEntity(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2);
    }

    @JvmName(name = "getPubKey")
    public final String getPubKey() {
        return this.pubKey;
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }
}
