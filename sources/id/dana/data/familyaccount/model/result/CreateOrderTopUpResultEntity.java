package id.dana.data.familyaccount.model.result;

import com.alipayplus.mobile.component.domain.model.result.BaseRpcResult;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0006\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bHÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0004"}, d2 = {"Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "Lcom/alipayplus/mobile/component/domain/model/result/BaseRpcResult;", "", "component1", "()Ljava/lang/String;", "checkoutUrl", "copy", "(Ljava/lang/String;)Lid/dana/data/familyaccount/model/result/CreateOrderTopUpResultEntity;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getCheckoutUrl", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class CreateOrderTopUpResultEntity extends BaseRpcResult {
    private final String checkoutUrl;

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v0, types: [kotlin.jvm.internal.DefaultConstructorMarker, java.lang.String] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public CreateOrderTopUpResultEntity() {
        /*
            r2 = this;
            r0 = 0
            r1 = 1
            r2.<init>(r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.familyaccount.model.result.CreateOrderTopUpResultEntity.<init>():void");
    }

    public static /* synthetic */ CreateOrderTopUpResultEntity copy$default(CreateOrderTopUpResultEntity createOrderTopUpResultEntity, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = createOrderTopUpResultEntity.checkoutUrl;
        }
        return createOrderTopUpResultEntity.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public final CreateOrderTopUpResultEntity copy(String checkoutUrl) {
        return new CreateOrderTopUpResultEntity(checkoutUrl);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof CreateOrderTopUpResultEntity) && Intrinsics.areEqual(this.checkoutUrl, ((CreateOrderTopUpResultEntity) other).checkoutUrl);
    }

    public final int hashCode() {
        String str = this.checkoutUrl;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CreateOrderTopUpResultEntity(checkoutUrl=");
        sb.append(this.checkoutUrl);
        sb.append(')');
        return sb.toString();
    }

    public /* synthetic */ CreateOrderTopUpResultEntity(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str);
    }

    @JvmName(name = "getCheckoutUrl")
    public final String getCheckoutUrl() {
        return this.checkoutUrl;
    }

    public CreateOrderTopUpResultEntity(String str) {
        this.checkoutUrl = str;
    }
}
