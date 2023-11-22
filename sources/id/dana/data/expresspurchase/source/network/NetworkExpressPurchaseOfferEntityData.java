package id.dana.data.expresspurchase.source.network;

import android.content.Context;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.utils.CashierKeyParams;
import id.dana.data.expresspurchase.source.ExpressPurchaseOfferEntityData;
import id.dana.data.expresspurchase.source.network.pojo.request.GetExpressPurchaseRequest;
import id.dana.data.expresspurchase.source.network.pojo.response.GetExpressPurchaseResponse;
import id.dana.network.base.BaseSecureRestNetwork;
import id.dana.network.base.ResultResponse;
import id.dana.utils.foundation.facede.ApSecurity;
import io.reactivex.Observable;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B!\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J%\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/data/expresspurchase/source/network/NetworkExpressPurchaseOfferEntityData;", "Lid/dana/network/base/BaseSecureRestNetwork;", "Lid/dana/data/expresspurchase/source/network/ExpressPurchaseOfferApi;", "Lid/dana/data/expresspurchase/source/ExpressPurchaseOfferEntityData;", "", "addonId", CashierKeyParams.CASHIER_ORDER_ID, "Lio/reactivex/Observable;", "Lid/dana/data/expresspurchase/source/network/pojo/response/GetExpressPurchaseResponse;", "getExpressPurchase", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "expressPurchaseOfferApi", "Lid/dana/data/expresspurchase/source/network/ExpressPurchaseOfferApi;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Lid/dana/utils/foundation/facede/ApSecurity;", "apSecurity", "<init>", "(Landroid/content/Context;Lid/dana/utils/foundation/facede/ApSecurity;Lid/dana/data/expresspurchase/source/network/ExpressPurchaseOfferApi;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkExpressPurchaseOfferEntityData extends BaseSecureRestNetwork<ExpressPurchaseOfferApi> implements ExpressPurchaseOfferEntityData {
    private final ExpressPurchaseOfferApi expressPurchaseOfferApi;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkExpressPurchaseOfferEntityData(Context context, ApSecurity apSecurity, ExpressPurchaseOfferApi expressPurchaseOfferApi) {
        super(context, apSecurity);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(expressPurchaseOfferApi, "");
        this.expressPurchaseOfferApi = expressPurchaseOfferApi;
    }

    @Override // id.dana.data.expresspurchase.source.ExpressPurchaseOfferEntityData
    public final Observable<GetExpressPurchaseResponse> getExpressPurchase(String addonId, String cashierOrderId) {
        Intrinsics.checkNotNullParameter(addonId, "");
        Intrinsics.checkNotNullParameter(cashierOrderId, "");
        final GetExpressPurchaseRequest getExpressPurchaseRequest = new GetExpressPurchaseRequest(addonId, cashierOrderId, NetworkExpressPurchaseEntityData.FLEXIBLE_CAPABILITY);
        return wrapper(this.expressPurchaseOfferApi, new Function1<ExpressPurchaseOfferApi, Observable<ResultResponse<GetExpressPurchaseResponse>>>() { // from class: id.dana.data.expresspurchase.source.network.NetworkExpressPurchaseOfferEntityData$getExpressPurchase$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Observable<ResultResponse<GetExpressPurchaseResponse>> invoke(ExpressPurchaseOfferApi expressPurchaseOfferApi) {
                Intrinsics.checkNotNullParameter(expressPurchaseOfferApi, "");
                return expressPurchaseOfferApi.getExpressPurchase(GetExpressPurchaseRequest.this);
            }
        });
    }
}
