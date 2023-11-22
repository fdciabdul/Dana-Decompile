package id.dana.data.sendmoney.model;

import com.alibaba.fastjson.annotation.JSONCreator;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001BA\b\u0007\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\n¢\u0006\u0004\b'\u0010(J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJV\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\nHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u0004R\u0017\u0010\u0013\u001a\u00020\n8\u0007¢\u0006\f\n\u0004\b\u0013\u0010\u001e\u001a\u0004\b\u001f\u0010\fR\u001a\u0010\r\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010 \u001a\u0004\b!\u0010\u0004R\u001a\u0010\u0010\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010 \u001a\u0004\b\"\u0010\u0004R\u001a\u0010\u000e\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\b#\u0010\u0004R\u001a\u0010\u000f\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010 \u001a\u0004\b$\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010 \u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b&\u0010\u0004"}, d2 = {"Lid/dana/data/sendmoney/model/BillerX2BEntity;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "component6", "", "component7", "()Z", "billerName", "instId", "prefix", "clientId", "redirectUrl", "scopes", "agreed", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lid/dana/data/sendmoney/model/BillerX2BEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Z", "getAgreed", "Ljava/lang/String;", "getBillerName", "getClientId", "getInstId", "getPrefix", "getRedirectUrl", "getScopes", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BillerX2BEntity implements Serializable {
    public boolean agreed;
    public String billerName;
    public String clientId;
    public String instId;
    public String prefix;
    public String redirectUrl;
    public String scopes;

    public /* synthetic */ BillerX2BEntity() {
    }

    public static /* synthetic */ BillerX2BEntity copy$default(BillerX2BEntity billerX2BEntity, String str, String str2, String str3, String str4, String str5, String str6, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = billerX2BEntity.billerName;
        }
        if ((i & 2) != 0) {
            str2 = billerX2BEntity.instId;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = billerX2BEntity.prefix;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = billerX2BEntity.clientId;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = billerX2BEntity.redirectUrl;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = billerX2BEntity.scopes;
        }
        String str11 = str6;
        if ((i & 64) != 0) {
            z = billerX2BEntity.agreed;
        }
        return billerX2BEntity.copy(str, str7, str8, str9, str10, str11, z);
    }

    /* renamed from: component1  reason: from getter */
    public final String getBillerName() {
        return this.billerName;
    }

    /* renamed from: component2  reason: from getter */
    public final String getInstId() {
        return this.instId;
    }

    /* renamed from: component3  reason: from getter */
    public final String getPrefix() {
        return this.prefix;
    }

    /* renamed from: component4  reason: from getter */
    public final String getClientId() {
        return this.clientId;
    }

    /* renamed from: component5  reason: from getter */
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    /* renamed from: component6  reason: from getter */
    public final String getScopes() {
        return this.scopes;
    }

    /* renamed from: component7  reason: from getter */
    public final boolean getAgreed() {
        return this.agreed;
    }

    public final BillerX2BEntity copy(String billerName, String instId, String prefix, String clientId, String redirectUrl, String scopes, boolean agreed) {
        Intrinsics.checkNotNullParameter(billerName, "");
        Intrinsics.checkNotNullParameter(instId, "");
        Intrinsics.checkNotNullParameter(prefix, "");
        Intrinsics.checkNotNullParameter(clientId, "");
        Intrinsics.checkNotNullParameter(redirectUrl, "");
        Intrinsics.checkNotNullParameter(scopes, "");
        return new BillerX2BEntity(billerName, instId, prefix, clientId, redirectUrl, scopes, agreed);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof BillerX2BEntity) {
            BillerX2BEntity billerX2BEntity = (BillerX2BEntity) other;
            return Intrinsics.areEqual(this.billerName, billerX2BEntity.billerName) && Intrinsics.areEqual(this.instId, billerX2BEntity.instId) && Intrinsics.areEqual(this.prefix, billerX2BEntity.prefix) && Intrinsics.areEqual(this.clientId, billerX2BEntity.clientId) && Intrinsics.areEqual(this.redirectUrl, billerX2BEntity.redirectUrl) && Intrinsics.areEqual(this.scopes, billerX2BEntity.scopes) && this.agreed == billerX2BEntity.agreed;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.billerName.hashCode();
        int hashCode2 = this.instId.hashCode();
        int hashCode3 = this.prefix.hashCode();
        int hashCode4 = this.clientId.hashCode();
        int hashCode5 = this.redirectUrl.hashCode();
        int hashCode6 = this.scopes.hashCode();
        boolean z = this.agreed;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        return (((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BillerX2BEntity(billerName=");
        sb.append(this.billerName);
        sb.append(", instId=");
        sb.append(this.instId);
        sb.append(", prefix=");
        sb.append(this.prefix);
        sb.append(", clientId=");
        sb.append(this.clientId);
        sb.append(", redirectUrl=");
        sb.append(this.redirectUrl);
        sb.append(", scopes=");
        sb.append(this.scopes);
        sb.append(", agreed=");
        sb.append(this.agreed);
        sb.append(')');
        return sb.toString();
    }

    @JSONCreator
    public BillerX2BEntity(String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(str5, "");
        Intrinsics.checkNotNullParameter(str6, "");
        this.billerName = str;
        this.instId = str2;
        this.prefix = str3;
        this.clientId = str4;
        this.redirectUrl = str5;
        this.scopes = str6;
        this.agreed = z;
    }

    @JvmName(name = "getBillerName")
    public final String getBillerName() {
        return this.billerName;
    }

    @JvmName(name = "getInstId")
    public final String getInstId() {
        return this.instId;
    }

    @JvmName(name = "getPrefix")
    public final String getPrefix() {
        return this.prefix;
    }

    @JvmName(name = "getClientId")
    public final String getClientId() {
        return this.clientId;
    }

    @JvmName(name = "getRedirectUrl")
    public final String getRedirectUrl() {
        return this.redirectUrl;
    }

    @JvmName(name = "getScopes")
    public final String getScopes() {
        return this.scopes;
    }

    @JvmName(name = "getAgreed")
    public final boolean getAgreed() {
        return this.agreed;
    }
}
