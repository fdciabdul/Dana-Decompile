package id.dana.mybills.data.repository.source.network;

import id.dana.mybills.data.model.request.ProductQueryRequestEntity;
import id.dana.mybills.data.model.response.GeneralProductResult;
import id.dana.mybills.data.model.response.MobileRechargeProductResult;
import id.dana.mybills.domain.model.ProductQueryRequest;
import id.dana.network.base.ResultResponse;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \f2\u00020\u0001:\u0001\fJ#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H§@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\b\b\u0001\u0010\u0003\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0001\u0082\u0002\n\n\u0002\b\u0019\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade;", "", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "p0", "Lid/dana/network/base/ResultResponse;", "Lid/dana/mybills/data/model/response/GeneralProductResult;", "getAuthRequestContext", "(Lid/dana/mybills/domain/model/ProductQueryRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;", "Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MyBillsRestFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.KClassImpl$Data$declaredNonStaticMembers$2;

    @POST("wallet/api/alipayplus.mobilewallet.product.mobilerecharge.load.json")
    Object BuiltInFictitiousFunctionClassFactory(@Body ProductQueryRequestEntity productQueryRequestEntity, Continuation<? super ResultResponse<MobileRechargeProductResult>> continuation);

    @POST("wallet/api/alipayplus.mobilewallet.product.load.json")
    Object getAuthRequestContext(@Body ProductQueryRequest productQueryRequest, Continuation<? super ResultResponse<GeneralProductResult>> continuation);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion KClassImpl$Data$declaredNonStaticMembers$2 = new Companion();

        private Companion() {
        }
    }
}
