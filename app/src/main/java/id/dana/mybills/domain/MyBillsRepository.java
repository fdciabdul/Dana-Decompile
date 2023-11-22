package id.dana.mybills.domain;

import id.dana.domain.user.CurrencyAmount;
import id.dana.mybills.data.model.request.DeleteSubscriptionRequest;
import id.dana.mybills.data.model.request.QuerySubscriptionRequest;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.GeneralProductResult;
import id.dana.mybills.data.model.response.QuerySubscriptionResult;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import id.dana.mybills.domain.model.BizProduct;
import id.dana.mybills.domain.model.BizProductDestination;
import id.dana.mybills.domain.model.BizProductOrder;
import id.dana.mybills.domain.model.BizProductOrderRequest;
import id.dana.mybills.domain.model.CheckUniqueValue;
import id.dana.mybills.domain.model.ConfigInfoRangeDate;
import id.dana.mybills.domain.model.CreateSubscription;
import id.dana.mybills.domain.model.CreateSubscriptionRequest;
import id.dana.mybills.domain.model.CumulateDueDateParamRequest;
import id.dana.mybills.domain.model.HighlightTransactionPay;
import id.dana.mybills.domain.model.HighlightTransactionPayRequest;
import id.dana.mybills.domain.model.MobileRechargeProduct;
import id.dana.mybills.domain.model.MyBillsHighlight;
import id.dana.mybills.domain.model.MyBillsHighlightRequestModel;
import id.dana.mybills.domain.model.MyBillsMonthlyAmount;
import id.dana.mybills.domain.model.ProductQueryRequest;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\u0006\u0010\u000eJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\n\u0010\u0011J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\u0006\u0010\u0014J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00160\u00042\u0006\u0010\u0003\u001a\u00020\u0015H&¢\u0006\u0004\b\u0006\u0010\u0017J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00042\u0006\u0010\u0003\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00042\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH&¢\u0006\u0004\b\u001a\u0010\u001fJ\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b!\u0010\u0014J-\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00042\u0006\u0010\u0003\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u001cH&¢\u0006\u0004\b$\u0010%J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020&0\u0004H&¢\u0006\u0004\b\u0006\u0010'J)\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001c0(H&¢\u0006\u0004\b\u001a\u0010*J\u0015\u0010$\u001a\b\u0012\u0004\u0012\u00020+0\u0004H&¢\u0006\u0004\b$\u0010'J\u001d\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020,0\u00042\u0006\u0010\u0003\u001a\u00020\u001cH&¢\u0006\u0004\b\u001a\u0010-J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020/0\u00042\u0006\u0010\u0003\u001a\u00020.H&¢\u0006\u0004\b\u0006\u00100J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u0002020\u00042\u0006\u0010\u0003\u001a\u000201H&¢\u0006\u0004\b\n\u00103J\u001d\u0010!\u001a\b\u0012\u0004\u0012\u0002050\u00042\u0006\u0010\u0003\u001a\u000204H&¢\u0006\u0004\b!\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/domain/MyBillsRepository;", "", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/CheckUniqueValue;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/BizProductOrderRequest;", "Lid/dana/mybills/domain/model/BizProductOrder;", "(Lid/dana/mybills/domain/model/BizProductOrderRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "(Lid/dana/mybills/domain/model/CumulateDueDateParamRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "Lid/dana/mybills/data/model/response/GeneralProductResult;", "(Lid/dana/mybills/domain/model/ProductQueryRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;", "Lid/dana/mybills/domain/model/MyBillsHighlight;", "(Lid/dana/mybills/domain/model/MyBillsHighlightRequestModel;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;", "Lid/dana/mybills/domain/model/HighlightTransactionPay;", "PlaceComponentResult", "(Lid/dana/mybills/domain/model/HighlightTransactionPayRequest;)Lkotlinx/coroutines/flow/Flow;", "", "p1", "Lid/dana/mybills/domain/model/BizProductDestination;", "(Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/MobileRechargeProduct;", "getAuthRequestContext", "p2", "Lid/dana/mybills/domain/model/MyBillsMonthlyAmount;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/ConfigInfoRangeDate;", "()Lkotlinx/coroutines/flow/Flow;", "", "Lid/dana/mybills/domain/model/BizProduct;", "(Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/domain/user/CurrencyAmount;", "", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "Lid/dana/mybills/domain/model/CreateSubscription;", "(Lid/dana/mybills/domain/model/CreateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "(Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MyBillsRepository {
    Flow<DeleteSubscriptionResult> BuiltInFictitiousFunctionClassFactory(DeleteSubscriptionRequest p0);

    Flow<QuerySubscriptionResult> BuiltInFictitiousFunctionClassFactory(QuerySubscriptionRequest p0);

    Flow<CumulateDueDatePaylaterResult> BuiltInFictitiousFunctionClassFactory(CumulateDueDateParamRequest p0);

    Flow<CurrencyAmount> KClassImpl$Data$declaredNonStaticMembers$2();

    Flow<MyBillsMonthlyAmount> KClassImpl$Data$declaredNonStaticMembers$2(String p0, String p1, String p2);

    Flow<ConfigInfoRangeDate> MyBillsEntityDataFactory();

    Flow<CheckUniqueValue> MyBillsEntityDataFactory(UniqueValueRequest p0);

    Flow<BizProductOrder> MyBillsEntityDataFactory(BizProductOrderRequest p0);

    Flow<CreateSubscription> MyBillsEntityDataFactory(CreateSubscriptionRequest p0);

    Flow<MyBillsHighlight> MyBillsEntityDataFactory(MyBillsHighlightRequestModel p0);

    Flow<GeneralProductResult> MyBillsEntityDataFactory(ProductQueryRequest p0);

    Flow<HighlightTransactionPay> PlaceComponentResult(HighlightTransactionPayRequest p0);

    Flow<Boolean> PlaceComponentResult(String p0);

    Flow<BizProductDestination> PlaceComponentResult(String p0, String p1);

    Flow<List<BizProduct>> PlaceComponentResult(List<String> p0);

    Flow<UpdateSubscriptionResult> getAuthRequestContext(UpdateSubscriptionRequest p0);

    Flow<MobileRechargeProduct> getAuthRequestContext(ProductQueryRequest p0);
}
