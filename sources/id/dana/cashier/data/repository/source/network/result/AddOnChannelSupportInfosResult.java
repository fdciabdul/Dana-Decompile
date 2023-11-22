package id.dana.cashier.data.repository.source.network.result;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r"}, d2 = {"Lid/dana/cashier/data/repository/source/network/result/AddOnChannelSupportInfosResult;", "", "", "disableReason", "Ljava/lang/String;", "getDisableReason", "()Ljava/lang/String;", "goodsId", "getGoodsId", "", "status", "Ljava/lang/Boolean;", "getStatus", "()Ljava/lang/Boolean;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class AddOnChannelSupportInfosResult {
    private final String disableReason;
    private final String goodsId;
    private final Boolean status;

    public AddOnChannelSupportInfosResult(Boolean bool, String str, String str2) {
        this.status = bool;
        this.goodsId = str;
        this.disableReason = str2;
    }

    @JvmName(name = "getStatus")
    public final Boolean getStatus() {
        return this.status;
    }

    @JvmName(name = "getGoodsId")
    public final String getGoodsId() {
        return this.goodsId;
    }

    @JvmName(name = "getDisableReason")
    public final String getDisableReason() {
        return this.disableReason;
    }
}
