package id.dana.mybills.data.repository.source;

import id.dana.mybills.data.model.request.CreateOrderRequest;
import id.dana.mybills.data.model.request.CreateSubscriptionRequestEntity;
import id.dana.mybills.data.model.request.CumulateDueDatePaylaterRequest;
import id.dana.mybills.data.model.request.DeleteSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightTransactionPayRequestEntity;
import id.dana.mybills.data.model.request.InquiryBizDestinationRequest;
import id.dana.mybills.data.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.mybills.data.model.request.ProductQueryRequestEntity;
import id.dana.mybills.data.model.request.QuerySubscriptionRequest;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.ConfigInfoRangeDateResult;
import id.dana.mybills.data.model.response.CreateOrderResult;
import id.dana.mybills.data.model.response.CreateSubscriptionResult;
import id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.GeneralProductResult;
import id.dana.mybills.data.model.response.HighlightSubscriptionResult;
import id.dana.mybills.data.model.response.HighlightTransactionPayResult;
import id.dana.mybills.data.model.response.InquiryBizDestinationResult;
import id.dana.mybills.data.model.response.MobileRechargeProductResult;
import id.dana.mybills.data.model.response.MonthlyAmountSubscriptionResult;
import id.dana.mybills.data.model.response.QuerySubscriptionResult;
import id.dana.mybills.data.model.response.QuickBuyResult;
import id.dana.mybills.data.model.response.UniqueValueResult;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import id.dana.mybills.domain.model.ProductQueryRequest;
import java.util.List;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\n\u0010\u000eJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00100\u00042\u0006\u0010\u0003\u001a\u00020\u000fH&¢\u0006\u0004\b\u0006\u0010\u0011J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u00042\u0006\u0010\u0003\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0003\u001a\u00020\u0016H&¢\u0006\u0004\b\u0014\u0010\u0018J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00042\u0006\u0010\u0003\u001a\u00020\u0019H&¢\u0006\u0004\b\n\u0010\u001bJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00042\u0006\u0010\u0003\u001a\u00020\u001cH&¢\u0006\u0004\b\u0006\u0010\u001eJ\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020 0\u00042\u0006\u0010\u0003\u001a\u00020\u001fH&¢\u0006\u0004\b\u0014\u0010!J\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u00042\u0006\u0010\u0003\u001a\u00020\"H&¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u0004H&¢\u0006\u0004\b'\u0010(J#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020+0\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020*0)H&¢\u0006\u0004\b\u0014\u0010,J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020-0\u00042\u0006\u0010\u0003\u001a\u00020*H&¢\u0006\u0004\b\u0006\u0010.J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u0002000\u00042\u0006\u0010\u0003\u001a\u00020/H&¢\u0006\u0004\b\n\u00101J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002030\u00042\u0006\u0010\u0003\u001a\u000202H&¢\u0006\u0004\b\u0006\u00104J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002060\u00042\u0006\u0010\u0003\u001a\u000205H&¢\u0006\u0004\b\u0006\u00107ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/response/UniqueValueResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "(Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CreateOrderRequest;", "Lid/dana/mybills/data/model/response/CreateOrderResult;", "(Lid/dana/mybills/data/model/request/CreateOrderRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "getAuthRequestContext", "(Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "Lid/dana/mybills/data/model/response/GeneralProductResult;", "(Lid/dana/mybills/domain/model/ProductQueryRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "(Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;", "Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "(Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;", "Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "(Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/mybills/data/model/response/MonthlyAmountSubscriptionResult;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "", "", "Lid/dana/mybills/data/model/response/QuickBuyResult;", "(Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;", "Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "(Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MyBillsEntityData {
    Flow<CreateSubscriptionResult> BuiltInFictitiousFunctionClassFactory(CreateSubscriptionRequestEntity p0);

    Flow<DeleteSubscriptionResult> BuiltInFictitiousFunctionClassFactory(DeleteSubscriptionRequest p0);

    Flow<HighlightSubscriptionResult> BuiltInFictitiousFunctionClassFactory(HighlightSubscriptionRequest p0);

    Flow<HighlightTransactionPayResult> BuiltInFictitiousFunctionClassFactory(HighlightTransactionPayRequestEntity p0);

    Flow<CreateOrderResult> KClassImpl$Data$declaredNonStaticMembers$2(CreateOrderRequest p0);

    Flow<InquiryBizDestinationResult> KClassImpl$Data$declaredNonStaticMembers$2(InquiryBizDestinationRequest p0);

    Flow<QuerySubscriptionResult> KClassImpl$Data$declaredNonStaticMembers$2(QuerySubscriptionRequest p0);

    Flow<UniqueValueResult> KClassImpl$Data$declaredNonStaticMembers$2(UniqueValueRequest p0);

    Flow<UpdateSubscriptionResult> KClassImpl$Data$declaredNonStaticMembers$2(UpdateSubscriptionRequest p0);

    Flow<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(String p0);

    Flow<MonthlyAmountSubscriptionResult> MyBillsEntityDataFactory(MonthlyAmountSubscriptionRequest p0);

    Flow<ConfigInfoRangeDateResult> PlaceComponentResult();

    Flow<CumulateDueDatePaylaterResult> getAuthRequestContext(CumulateDueDatePaylaterRequest p0);

    Flow<MobileRechargeProductResult> getAuthRequestContext(ProductQueryRequestEntity p0);

    Flow<GeneralProductResult> getAuthRequestContext(ProductQueryRequest p0);

    Flow<QuickBuyResult> getAuthRequestContext(List<String> p0);
}
