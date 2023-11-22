package id.dana.data.expresspurchase.source;

import id.dana.data.expresspurchase.source.network.pojo.response.DealsQueryShopResponse;
import io.reactivex.Observable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J.\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\tÀ\u0006\u0001"}, d2 = {"Lid/dana/data/expresspurchase/source/DealsExpressPurchaseData;", "", "dealsQueryShopLocation", "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/response/DealsQueryShopResponse;", "goodsId", "", "latitude", "longitude", "data_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface DealsExpressPurchaseData {
    Observable<DealsQueryShopResponse> dealsQueryShopLocation(String goodsId, String latitude, String longitude);

    /* renamed from: id.dana.data.expresspurchase.source.DealsExpressPurchaseData$-CC  reason: invalid class name */
    /* loaded from: classes8.dex */
    public final /* synthetic */ class CC {
        public static /* synthetic */ Observable dealsQueryShopLocation$default(DealsExpressPurchaseData dealsExpressPurchaseData, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "";
                }
                if ((i & 4) != 0) {
                    str3 = "";
                }
                return dealsExpressPurchaseData.dealsQueryShopLocation(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: dealsQueryShopLocation");
        }
    }
}
