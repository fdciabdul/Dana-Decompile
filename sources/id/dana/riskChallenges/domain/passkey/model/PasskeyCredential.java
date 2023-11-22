package id.dana.riskChallenges.domain.passkey.model;

import androidx.credentials.webauthn.Cbor$Arg$$ExternalSyntheticBackport0;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;
import id.dana.domain.social.ExtendInfoUtilKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\b\b\u0001\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u0002\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0001\u0010\u0017\u001a\u00020\u0002\u0012\u000e\b\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\b\b\u0001\u0010\u0019\u001a\u00020\u0002¢\u0006\u0004\b0\u00101J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\f\u0010\u0004J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004Jp\u0010\u001a\u001a\u00020\u00002\b\b\u0003\u0010\u0011\u001a\u00020\u00022\b\b\u0003\u0010\u0012\u001a\u00020\u00022\b\b\u0003\u0010\u0013\u001a\u00020\u00062\b\b\u0003\u0010\u0014\u001a\u00020\u00062\b\b\u0003\u0010\u0015\u001a\u00020\u00022\b\b\u0003\u0010\u0016\u001a\u00020\u00062\b\b\u0003\u0010\u0017\u001a\u00020\u00022\u000e\b\u0003\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\b\b\u0003\u0010\u0019\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u0004R\u001a\u0010\u0011\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010$\u001a\u0004\b%\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010$\u001a\u0004\b&\u0010\u0004R\u001a\u0010\u0013\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\bR\u001a\u0010\u0014\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010'\u001a\u0004\b)\u0010\bR\u001a\u0010\u0015\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010$\u001a\u0004\b*\u0010\u0004R\u001a\u0010\u0016\u001a\u00020\u00068\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010'\u001a\u0004\b+\u0010\bR\u001a\u0010\u0017\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010$\u001a\u0004\b,\u0010\u0004R \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010-\u001a\u0004\b.\u0010\u000fR\u001a\u0010\u0019\u001a\u00020\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010$\u001a\u0004\b/\u0010\u0004"}, d2 = {"Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()J", "component4", "component5", "component6", "component7", "", "component8", "()Ljava/util/List;", "component9", "credentialId", ExtendInfoUtilKt.DISPLAY_NAME_KEY, "gmtCreate", "gmtModified", "publicUserId", "signatureCount", "sourcePlatform", "transports", "userName", "copy", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)Lid/dana/riskChallenges/domain/passkey/model/PasskeyCredential;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCredentialId", "getDisplayName", "J", "getGmtCreate", "getGmtModified", "getPublicUserId", "getSignatureCount", "getSourcePlatform", "Ljava/util/List;", "getTransports", "getUserName", "<init>", "(Ljava/lang/String;Ljava/lang/String;JJLjava/lang/String;JLjava/lang/String;Ljava/util/List;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class PasskeyCredential {
    @SerializedName("credentialId")
    private final String credentialId;
    @SerializedName(ExtendInfoUtilKt.DISPLAY_NAME_KEY)
    private final String displayName;
    @SerializedName("gmtCreate")
    private final long gmtCreate;
    @SerializedName("gmtModified")
    private final long gmtModified;
    @SerializedName("publicUserId")
    private final String publicUserId;
    @SerializedName("signatureCount")
    private final long signatureCount;
    @SerializedName("sourcePlatform")
    private final String sourcePlatform;
    @SerializedName("transports")
    private final List<String> transports;
    @SerializedName("userName")
    private final String userName;

    /* renamed from: component1  reason: from getter */
    public final String getCredentialId() {
        return this.credentialId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* renamed from: component3  reason: from getter */
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    /* renamed from: component4  reason: from getter */
    public final long getGmtModified() {
        return this.gmtModified;
    }

    /* renamed from: component5  reason: from getter */
    public final String getPublicUserId() {
        return this.publicUserId;
    }

    /* renamed from: component6  reason: from getter */
    public final long getSignatureCount() {
        return this.signatureCount;
    }

    /* renamed from: component7  reason: from getter */
    public final String getSourcePlatform() {
        return this.sourcePlatform;
    }

    public final List<String> component8() {
        return this.transports;
    }

    /* renamed from: component9  reason: from getter */
    public final String getUserName() {
        return this.userName;
    }

    public final PasskeyCredential copy(@JSONField(name = "credentialId") String credentialId, @JSONField(name = "displayName") String displayName, @JSONField(name = "gmtCreate") long gmtCreate, @JSONField(name = "gmtModified") long gmtModified, @JSONField(name = "publicUserId") String publicUserId, @JSONField(name = "signatureCount") long signatureCount, @JSONField(name = "sourcePlatform") String sourcePlatform, @JSONField(name = "transports") List<String> transports, @JSONField(name = "userName") String userName) {
        Intrinsics.checkNotNullParameter(credentialId, "");
        Intrinsics.checkNotNullParameter(displayName, "");
        Intrinsics.checkNotNullParameter(publicUserId, "");
        Intrinsics.checkNotNullParameter(sourcePlatform, "");
        Intrinsics.checkNotNullParameter(transports, "");
        Intrinsics.checkNotNullParameter(userName, "");
        return new PasskeyCredential(credentialId, displayName, gmtCreate, gmtModified, publicUserId, signatureCount, sourcePlatform, transports, userName);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof PasskeyCredential) {
            PasskeyCredential passkeyCredential = (PasskeyCredential) other;
            return Intrinsics.areEqual(this.credentialId, passkeyCredential.credentialId) && Intrinsics.areEqual(this.displayName, passkeyCredential.displayName) && this.gmtCreate == passkeyCredential.gmtCreate && this.gmtModified == passkeyCredential.gmtModified && Intrinsics.areEqual(this.publicUserId, passkeyCredential.publicUserId) && this.signatureCount == passkeyCredential.signatureCount && Intrinsics.areEqual(this.sourcePlatform, passkeyCredential.sourcePlatform) && Intrinsics.areEqual(this.transports, passkeyCredential.transports) && Intrinsics.areEqual(this.userName, passkeyCredential.userName);
        }
        return false;
    }

    public final int hashCode() {
        return (((((((((((((((this.credentialId.hashCode() * 31) + this.displayName.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtCreate)) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.gmtModified)) * 31) + this.publicUserId.hashCode()) * 31) + Cbor$Arg$$ExternalSyntheticBackport0.m(this.signatureCount)) * 31) + this.sourcePlatform.hashCode()) * 31) + this.transports.hashCode()) * 31) + this.userName.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PasskeyCredential(credentialId=");
        sb.append(this.credentialId);
        sb.append(", displayName=");
        sb.append(this.displayName);
        sb.append(", gmtCreate=");
        sb.append(this.gmtCreate);
        sb.append(", gmtModified=");
        sb.append(this.gmtModified);
        sb.append(", publicUserId=");
        sb.append(this.publicUserId);
        sb.append(", signatureCount=");
        sb.append(this.signatureCount);
        sb.append(", sourcePlatform=");
        sb.append(this.sourcePlatform);
        sb.append(", transports=");
        sb.append(this.transports);
        sb.append(", userName=");
        sb.append(this.userName);
        sb.append(')');
        return sb.toString();
    }

    public PasskeyCredential(@JSONField(name = "credentialId") String str, @JSONField(name = "displayName") String str2, @JSONField(name = "gmtCreate") long j, @JSONField(name = "gmtModified") long j2, @JSONField(name = "publicUserId") String str3, @JSONField(name = "signatureCount") long j3, @JSONField(name = "sourcePlatform") String str4, @JSONField(name = "transports") List<String> list, @JSONField(name = "userName") String str5) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str5, "");
        this.credentialId = str;
        this.displayName = str2;
        this.gmtCreate = j;
        this.gmtModified = j2;
        this.publicUserId = str3;
        this.signatureCount = j3;
        this.sourcePlatform = str4;
        this.transports = list;
        this.userName = str5;
    }

    @JvmName(name = "getCredentialId")
    public final String getCredentialId() {
        return this.credentialId;
    }

    @JvmName(name = "getDisplayName")
    public final String getDisplayName() {
        return this.displayName;
    }

    @JvmName(name = "getGmtCreate")
    public final long getGmtCreate() {
        return this.gmtCreate;
    }

    @JvmName(name = "getGmtModified")
    public final long getGmtModified() {
        return this.gmtModified;
    }

    @JvmName(name = "getPublicUserId")
    public final String getPublicUserId() {
        return this.publicUserId;
    }

    @JvmName(name = "getSignatureCount")
    public final long getSignatureCount() {
        return this.signatureCount;
    }

    @JvmName(name = "getSourcePlatform")
    public final String getSourcePlatform() {
        return this.sourcePlatform;
    }

    public /* synthetic */ PasskeyCredential(String str, String str2, long j, long j2, String str3, long j3, String str4, List list, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, j2, str3, j3, str4, (i & 128) != 0 ? CollectionsKt.emptyList() : list, str5);
    }

    @JvmName(name = "getTransports")
    public final List<String> getTransports() {
        return this.transports;
    }

    @JvmName(name = "getUserName")
    public final String getUserName() {
        return this.userName;
    }
}
