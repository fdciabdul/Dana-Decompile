package id.dana.network.response.expresspurchase;

import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0007¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/network/response/expresspurchase/ProductValidateStatusInfoResponse;", "", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "newPrice", "Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "getNewPrice", "()Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "", "thirdRefId", "Ljava/lang/String;", "getThirdRefId", "()Ljava/lang/String;", "<init>", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ProductValidateStatusInfoResponse {
    private final MoneyViewEntity newPrice;
    private final String thirdRefId;

    public ProductValidateStatusInfoResponse(MoneyViewEntity moneyViewEntity, String str) {
        this.newPrice = moneyViewEntity;
        this.thirdRefId = str;
    }

    @JvmName(name = "getNewPrice")
    public final MoneyViewEntity getNewPrice() {
        return this.newPrice;
    }

    @JvmName(name = "getThirdRefId")
    public final String getThirdRefId() {
        return this.thirdRefId;
    }
}
