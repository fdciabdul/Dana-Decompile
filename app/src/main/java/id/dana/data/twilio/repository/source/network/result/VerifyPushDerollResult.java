package id.dana.data.twilio.repository.source.network.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import id.dana.danah5.bioutility.BioUtilityBridge;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0004R\u0019\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\b\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00058\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0007"}, d2 = {"Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "", "component2", "()Ljava/util/List;", BioUtilityBridge.SECURITY_ID, "verificationMethodInfos", "copy", "(Ljava/lang/String;Ljava/util/List;)Lid/dana/data/twilio/repository/source/network/result/VerifyPushDerollResult;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getSecurityId", "Ljava/util/List;", "getVerificationMethodInfos", "<init>", "(Ljava/lang/String;Ljava/util/List;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class VerifyPushDerollResult extends BaseRpcResult {
    private final String securityId;
    private final List<String> verificationMethodInfos;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List, kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public VerifyPushDerollResult() {
        /*
            r2 = this;
            r0 = 0
            r1 = 3
            r2.<init>(r0, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.twilio.repository.source.network.result.VerifyPushDerollResult.<init>():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ VerifyPushDerollResult copy$default(VerifyPushDerollResult verifyPushDerollResult, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = verifyPushDerollResult.securityId;
        }
        if ((i & 2) != 0) {
            list = verifyPushDerollResult.verificationMethodInfos;
        }
        return verifyPushDerollResult.copy(str, list);
    }

    /* renamed from: component1  reason: from getter */
    public final String getSecurityId() {
        return this.securityId;
    }

    public final List<String> component2() {
        return this.verificationMethodInfos;
    }

    public final VerifyPushDerollResult copy(String securityId, List<String> verificationMethodInfos) {
        return new VerifyPushDerollResult(securityId, verificationMethodInfos);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof VerifyPushDerollResult) {
            VerifyPushDerollResult verifyPushDerollResult = (VerifyPushDerollResult) other;
            return Intrinsics.areEqual(this.securityId, verifyPushDerollResult.securityId) && Intrinsics.areEqual(this.verificationMethodInfos, verifyPushDerollResult.verificationMethodInfos);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.securityId;
        int hashCode = str == null ? 0 : str.hashCode();
        List<String> list = this.verificationMethodInfos;
        return (hashCode * 31) + (list != null ? list.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VerifyPushDerollResult(securityId=");
        sb.append(this.securityId);
        sb.append(", verificationMethodInfos=");
        sb.append(this.verificationMethodInfos);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getSecurityId")
    public final String getSecurityId() {
        return this.securityId;
    }

    public /* synthetic */ VerifyPushDerollResult(String str, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }

    @JvmName(name = "getVerificationMethodInfos")
    public final List<String> getVerificationMethodInfos() {
        return this.verificationMethodInfos;
    }

    public VerifyPushDerollResult(String str, List<String> list) {
        this.securityId = str;
        this.verificationMethodInfos = list;
    }
}
