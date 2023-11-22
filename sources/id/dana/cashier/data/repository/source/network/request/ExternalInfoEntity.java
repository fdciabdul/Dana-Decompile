package id.dana.cashier.data.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b!\u0010\"J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJL\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\b8\u0007¢\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\nR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001e\u0010\u0004R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0004R\u001c\u0010\r\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u001c\u001a\u0004\b \u0010\u0004"}, d2 = {"Lid/dana/cashier/data/repository/source/network/request/ExternalInfoEntity;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "", "component5", "()Ljava/lang/Boolean;", "mid", "bizNo", "timestamp", "sign", "addOn", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lid/dana/cashier/data/repository/source/network/request/ExternalInfoEntity;", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/Boolean;", "getAddOn", "Ljava/lang/String;", "getBizNo", "getMid", "getSign", "getTimestamp", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes8.dex */
public final /* data */ class ExternalInfoEntity extends BaseRpcRequest {
    private final Boolean addOn;
    private final String bizNo;
    private final String mid;
    private final String sign;
    private final String timestamp;

    public static /* synthetic */ ExternalInfoEntity copy$default(ExternalInfoEntity externalInfoEntity, String str, String str2, String str3, String str4, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = externalInfoEntity.mid;
        }
        if ((i & 2) != 0) {
            str2 = externalInfoEntity.bizNo;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = externalInfoEntity.timestamp;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = externalInfoEntity.sign;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            bool = externalInfoEntity.addOn;
        }
        return externalInfoEntity.copy(str, str5, str6, str7, bool);
    }

    /* renamed from: component1  reason: from getter */
    public final String getMid() {
        return this.mid;
    }

    /* renamed from: component2  reason: from getter */
    public final String getBizNo() {
        return this.bizNo;
    }

    /* renamed from: component3  reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    /* renamed from: component4  reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    /* renamed from: component5  reason: from getter */
    public final Boolean getAddOn() {
        return this.addOn;
    }

    public final ExternalInfoEntity copy(String mid, String bizNo, String timestamp, String sign, Boolean addOn) {
        return new ExternalInfoEntity(mid, bizNo, timestamp, sign, addOn);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExternalInfoEntity) {
            ExternalInfoEntity externalInfoEntity = (ExternalInfoEntity) other;
            return Intrinsics.areEqual(this.mid, externalInfoEntity.mid) && Intrinsics.areEqual(this.bizNo, externalInfoEntity.bizNo) && Intrinsics.areEqual(this.timestamp, externalInfoEntity.timestamp) && Intrinsics.areEqual(this.sign, externalInfoEntity.sign) && Intrinsics.areEqual(this.addOn, externalInfoEntity.addOn);
        }
        return false;
    }

    public final int hashCode() {
        String str = this.mid;
        int hashCode = str == null ? 0 : str.hashCode();
        String str2 = this.bizNo;
        int hashCode2 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.timestamp;
        int hashCode3 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.sign;
        int hashCode4 = str4 == null ? 0 : str4.hashCode();
        Boolean bool = this.addOn;
        return (((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + (bool != null ? bool.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ExternalInfoEntity(mid=");
        sb.append(this.mid);
        sb.append(", bizNo=");
        sb.append(this.bizNo);
        sb.append(", timestamp=");
        sb.append(this.timestamp);
        sb.append(", sign=");
        sb.append(this.sign);
        sb.append(", addOn=");
        sb.append(this.addOn);
        sb.append(')');
        return sb.toString();
    }

    @JvmName(name = "getMid")
    public final String getMid() {
        return this.mid;
    }

    @JvmName(name = "getBizNo")
    public final String getBizNo() {
        return this.bizNo;
    }

    @JvmName(name = "getTimestamp")
    public final String getTimestamp() {
        return this.timestamp;
    }

    @JvmName(name = "getSign")
    public final String getSign() {
        return this.sign;
    }

    @JvmName(name = "getAddOn")
    public final Boolean getAddOn() {
        return this.addOn;
    }

    public ExternalInfoEntity(String str, String str2, String str3, String str4, Boolean bool) {
        this.mid = str;
        this.bizNo = str2;
        this.timestamp = str3;
        this.sign = str4;
        this.addOn = bool;
    }
}
