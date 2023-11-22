package id.dana.data.expresspurchase.source;

import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityData;", "", "getExpressPurchase", "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "addonId", "", CashierKeyParams.CASHIER_ORDER_ID, "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ExpressPurchaseOfferEntityData {
    Observable<GetExpressPurchaseResponse> getExpressPurchase(String addonId, String cashierOrderId);

    /* renamed from: id.dana.data.expresspurchase.source.ExpressPurchaseOfferEntityData$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static Observable $default$getExpressPurchase(ExpressPurchaseOfferEntityData expressPurchaseOfferEntityData, String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            throw new UnsupportedOperationException();
        }
    }
}
