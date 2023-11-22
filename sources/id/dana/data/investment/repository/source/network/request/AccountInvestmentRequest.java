package id.dana.data.investment.repository.source.network.request;

import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b"}, d2 = {"Lid/dana/data/investment/repository/source/network/request/AccountInvestmentRequest;", "Lcom/alipayplus/mobile/component/domain/model/request/BaseRpcRequest;", "", "goodsId", "Ljava/lang/String;", "getGoodsId", "()Ljava/lang/String;", "setGoodsId", "(Ljava/lang/String;)V", "userId", "getUserId", "setUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AccountInvestmentRequest extends BaseRpcRequest {
    private String goodsId;
    private String userId;

    @JvmName(name = "getUserId")
    public final String getUserId() {
        return this.userId;
    }

    @JvmName(name = "setUserId")
    public final void setUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.userId = str;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "setGoodsId")
    public final void setGoodsId(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.goodsId = str;
    }

    public AccountInvestmentRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        this.userId = str;
        this.goodsId = str2;
    }
}
