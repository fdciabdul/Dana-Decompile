package id.dana.data.citcall.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import id.dana.data.constant.BranchLinkConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J@\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u001b\u0010\u0004"}, d2 = {"Lid/dana/data/citcall/source/network/request/MiscallRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", BranchLinkConstant.Params.LOGIN_ID, "loginIdType", "useCase", "bizId", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lid/dana/data/citcall/source/network/request/MiscallRequest;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getBizId", "getLoginId", "getLoginIdType", "getUseCase", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class MiscallRequest extends BaseRpcRequest {
    private final String bizId;
    private final String loginId;
    private final String loginIdType;
    private final String useCase;

    public MiscallRequest() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ MiscallRequest copy$default(MiscallRequest miscallRequest, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = miscallRequest.loginId;
        }
        if ((i & 2) != 0) {
            str2 = miscallRequest.loginIdType;
        }
        if ((i & 4) != 0) {
            str3 = miscallRequest.useCase;
        }
        if ((i & 8) != 0) {
            str4 = miscallRequest.bizId;
        }
        return miscallRequest.copy(str, str2, str3, str4);
    }

    /* renamed from: component1  reason: from getter */
    public final String getLoginId() {
        return this.loginId;
    }

    /* renamed from: component2  reason: from getter */
    public final String getLoginIdType() {
        return this.loginIdType;
    }

    /* renamed from: component3  reason: from getter */
    public final String getUseCase() {
        return this.useCase;
    }

    /* renamed from: component4  reason: from getter */
    public final String getBizId() {
        return this.bizId;
    }

    public final MiscallRequest copy(String loginId, String loginIdType, String useCase, String bizId) {
        return new MiscallRequest(loginId, loginIdType, useCase, bizId);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof MiscallRequest) {
            MiscallRequest miscallRequest = (MiscallRequest) other;
            return Intrinsics.areEqual(this.loginId, miscallRequest.loginId) && Intrinsics.areEqual(this.loginIdType, miscallRequest.loginIdType) && Intrinsics.areEqual(this.useCase, miscallRequest.useCase) && Intrinsics.areEqual(this.bizId, miscallRequest.bizId);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.loginId;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.loginIdType;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.useCase;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.bizId;
        return (((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MiscallRequest(loginId=");
        sb.append(this.loginId);
        sb.append(", loginIdType=");
        sb.append(this.loginIdType);
        sb.append(", useCase=");
        sb.append(this.useCase);
        sb.append(", bizId=");
        sb.append(this.bizId);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ MiscallRequest(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4);
    }

    @JvmName(name = "getLoginId")
    public final String getLoginId() {
        return this.loginId;
    }

    @JvmName(name = "getLoginIdType")
    public final String getLoginIdType() {
        return this.loginIdType;
    }

    @JvmName(name = "getUseCase")
    public final String getUseCase() {
        return this.useCase;
    }

    @JvmName(name = "getBizId")
    public final String getBizId() {
        return this.bizId;
    }

    public MiscallRequest(String str, String str2, String str3, String str4) {
        this.loginId = str;
        this.loginIdType = str2;
        this.useCase = str3;
        this.bizId = str4;
    }
}
