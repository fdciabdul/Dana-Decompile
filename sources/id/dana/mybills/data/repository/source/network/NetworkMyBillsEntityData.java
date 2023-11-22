package id.dana.mybills.data.repository.source.network;

import android.content.Context;
import com.alipayplus.mobile.component.domain.model.request.BaseRpcRequest;
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
import id.dana.mybills.data.model.request.QuickBuyRequest;
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
import id.dana.mybills.data.repository.source.MyBillsEntityData;
import id.dana.mybills.di.scope.MyBillsScope;
import id.dana.mybills.domain.model.ProductQueryRequest;
import id.dana.network.base.SecureBaseNetworkFlow;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.foundation.facede.ApSecurity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020?\u0012\u0006\u0010A\u001a\u00020@\u0012\u0006\u0010C\u001a\u00020B\u0012\u0006\u0010D\u001a\u00020=¢\u0006\u0004\bE\u0010FJ\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00062\u0006\u0010\u0005\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\f\u0010\u0010J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\b\u0010\u0013J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00062\u0006\u0010\u0005\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u0018H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u0005\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u0016\u0010\u001dJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00062\u0006\u0010\u0005\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\f\u0010 J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\"0\u00062\u0006\u0010\u0005\u001a\u00020!H\u0016¢\u0006\u0004\b\b\u0010#J\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020%0\u00062\u0006\u0010\u0005\u001a\u00020$H\u0016¢\u0006\u0004\b\u0016\u0010&J\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020(0\u00062\u0006\u0010\u0005\u001a\u00020'H\u0016¢\u0006\u0004\b)\u0010*J\u0015\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0006H\u0016¢\u0006\u0004\b,\u0010-J#\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002000\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020/0.H\u0016¢\u0006\u0004\b\u0016\u00101J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u0002020\u00062\u0006\u0010\u0005\u001a\u00020/H\u0016¢\u0006\u0004\b\b\u00103J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u0002050\u00062\u0006\u0010\u0005\u001a\u000204H\u0016¢\u0006\u0004\b\f\u00106J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u0002080\u00062\u0006\u0010\u0005\u001a\u000207H\u0016¢\u0006\u0004\b\b\u00109J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020;0\u00062\u0006\u0010\u0005\u001a\u00020:H\u0016¢\u0006\u0004\b\b\u0010<R\u0014\u0010,\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010>"}, d2 = {"Lid/dana/mybills/data/repository/source/network/NetworkMyBillsEntityData;", "Lid/dana/network/base/SecureBaseNetworkFlow;", "Lid/dana/mybills/data/repository/source/network/MyBillsRpcFacade;", "Lid/dana/mybills/data/repository/source/MyBillsEntityData;", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "p0", "Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/response/UniqueValueResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "(Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CreateOrderRequest;", "Lid/dana/mybills/data/model/response/CreateOrderResult;", "(Lid/dana/mybills/data/model/request/CreateOrderRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "getAuthRequestContext", "(Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;)Lkotlinx/coroutines/flow/Flow;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/mybills/domain/model/ProductQueryRequest;", "Lid/dana/mybills/data/model/response/GeneralProductResult;", "(Lid/dana/mybills/domain/model/ProductQueryRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "(Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;", "Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "(Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;", "Lid/dana/mybills/data/model/response/MobileRechargeProductResult;", "(Lid/dana/mybills/data/model/request/ProductQueryRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/mybills/data/model/response/MonthlyAmountSubscriptionResult;", "MyBillsEntityDataFactory", "(Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/response/ConfigInfoRangeDateResult;", "PlaceComponentResult", "()Lkotlinx/coroutines/flow/Flow;", "", "", "Lid/dana/mybills/data/model/response/QuickBuyResult;", "(Ljava/util/List;)Lkotlinx/coroutines/flow/Flow;", "", "(Ljava/lang/String;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;", "Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "(Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)Lkotlinx/coroutines/flow/Flow;", "Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade;", "Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/foundation/facede/ApSecurity;", "p1", "Landroid/content/Context;", "p2", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/foundation/facede/ApSecurity;Landroid/content/Context;Lid/dana/mybills/data/repository/source/network/MyBillsRestFacade;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
@MyBillsScope
/* loaded from: classes5.dex */
public final class NetworkMyBillsEntityData extends SecureBaseNetworkFlow<MyBillsRpcFacade> implements MyBillsEntityData {

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private final MyBillsRestFacade PlaceComponentResult;

    @Override // id.dana.network.base.BaseNetworkFlow
    public final Class<MyBillsRpcFacade> getFacadeClass() {
        return MyBillsRpcFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkMyBillsEntityData(RpcConnector rpcConnector, ApSecurity apSecurity, Context context, MyBillsRestFacade myBillsRestFacade) {
        super(apSecurity, context, rpcConnector);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(apSecurity, "");
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(myBillsRestFacade, "");
        this.PlaceComponentResult = myBillsRestFacade;
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<MonthlyAmountSubscriptionResult> MyBillsEntityDataFactory(final MonthlyAmountSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, MonthlyAmountSubscriptionResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMonthlyAmountSubscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final MonthlyAmountSubscriptionResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.monthlyAmountSubscription((MonthlyAmountSubscriptionRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<HighlightSubscriptionResult> BuiltInFictitiousFunctionClassFactory(final HighlightSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, HighlightSubscriptionResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getHighlightSubscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final HighlightSubscriptionResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.subscriptionConsultView((HighlightSubscriptionRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<QuickBuyResult> getAuthRequestContext(final List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, QuickBuyResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getQuickBuySubscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final QuickBuyResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.quickBuy((QuickBuyRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, new QuickBuyRequest(p0)));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<CreateOrderResult> KClassImpl$Data$declaredNonStaticMembers$2(final CreateOrderRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, CreateOrderResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getCreateBizProductOrder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CreateOrderResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.createBizProductOrder((CreateOrderRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<HighlightTransactionPayResult> BuiltInFictitiousFunctionClassFactory(final HighlightTransactionPayRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, HighlightTransactionPayResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$consultHighlightTransactionPay$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final HighlightTransactionPayResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.consultHiglightTransactionPay((HighlightTransactionPayRequestEntity) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<InquiryBizDestinationResult> KClassImpl$Data$declaredNonStaticMembers$2(final InquiryBizDestinationRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, InquiryBizDestinationResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getInquiryBizDestination$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final InquiryBizDestinationResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.bizDestinationInquiry((InquiryBizDestinationRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<Boolean> KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<CreateSubscriptionResult> BuiltInFictitiousFunctionClassFactory(final CreateSubscriptionRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, CreateSubscriptionResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$saveSubscription$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CreateSubscriptionResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.saveSubscription((CreateSubscriptionRequestEntity) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<MobileRechargeProductResult> getAuthRequestContext(ProductQueryRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow flow = FlowKt.flow(new NetworkMyBillsEntityData$getMobileRechargeProducts$1(this, p0, null));
        final Flow<MobileRechargeProductResult> flow2 = new Flow<MobileRechargeProductResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super MobileRechargeProductResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1$2", f = "NetworkMyBillsEntityData.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.network.base.ResultResponse r5 = (id.dana.network.base.ResultResponse) r5
                        java.lang.Object r5 = r5.getResult()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        return new Flow<MobileRechargeProductResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super MobileRechargeProductResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $KClassImpl$Data$declaredNonStaticMembers$2;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2$2", f = "NetworkMyBillsEntityData.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$KClassImpl$Data$declaredNonStaticMembers$2 = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2$2$1 r0 = (id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2$2$1 r0 = new id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L55
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$KClassImpl$Data$declaredNonStaticMembers$2
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.MobileRechargeProductResult r6 = (id.dana.mybills.data.model.response.MobileRechargeProductResult) r6
                        id.dana.network.base.ExceptionParserFlow r2 = new id.dana.network.base.ExceptionParserFlow
                        r2.<init>()
                        java.lang.String r4 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r6 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r6
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r6 = r2.apply(r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L55
                        return r1
                    L55:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getMobileRechargeProducts$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<UpdateSubscriptionResult> KClassImpl$Data$declaredNonStaticMembers$2(final UpdateSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, UpdateSubscriptionResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$updateSubscriptionBill$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UpdateSubscriptionResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.updateSubscriptionBill((UpdateSubscriptionRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<UniqueValueResult> KClassImpl$Data$declaredNonStaticMembers$2(final UniqueValueRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, UniqueValueResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$checkUniqueValue$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final UniqueValueResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.checkUniqueValue((UniqueValueRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<GeneralProductResult> getAuthRequestContext(ProductQueryRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        final Flow flow = FlowKt.flow(new NetworkMyBillsEntityData$getGeneralProducts$1(this, p0, null));
        final Flow<GeneralProductResult> flow2 = new Flow<GeneralProductResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super GeneralProductResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $BuiltInFictitiousFunctionClassFactory;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1$2", f = "NetworkMyBillsEntityData.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$BuiltInFictitiousFunctionClassFactory = flowCollector;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r6
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1$2$1 r0 = (id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r6 = r0.label
                        int r6 = r6 + r2
                        r0.label = r6
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1$2$1 r0 = new id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1$2$1
                        r0.<init>(r6)
                    L19:
                        java.lang.Object r6 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L49
                    L2a:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L32:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.$BuiltInFictitiousFunctionClassFactory
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.network.base.ResultResponse r5 = (id.dana.network.base.ResultResponse) r5
                        java.lang.Object r5 = r5.getResult()
                        r0.label = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L49
                        return r1
                    L49:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
        return new Flow<GeneralProductResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2
            @Override // kotlinx.coroutines.flow.Flow
            public final Object collect(FlowCollector<? super GeneralProductResult> flowCollector, Continuation continuation) {
                Object collect = Flow.this.collect(new AnonymousClass2(flowCollector), continuation);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }

            @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0002\u001a\u00028\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "R", "p0", "", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2$2  reason: invalid class name */
            /* loaded from: classes5.dex */
            public static final class AnonymousClass2<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $PlaceComponentResult;

                @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
                @DebugMetadata(c = "id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2$2", f = "NetworkMyBillsEntityData.kt", i = {}, l = {224}, m = "emit", n = {}, s = {})
                /* renamed from: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2$2$1  reason: invalid class name */
                /* loaded from: classes5.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.$PlaceComponentResult = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r6, kotlin.coroutines.Continuation r7) {
                    /*
                        r5 = this;
                        boolean r0 = r7 instanceof id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r7
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2$2$1 r0 = (id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r7 = r0.label
                        int r7 = r7 + r2
                        r0.label = r7
                        goto L19
                    L14:
                        id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2$2$1 r0 = new id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2$2$1
                        r0.<init>(r7)
                    L19:
                        java.lang.Object r7 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L32
                        if (r2 != r3) goto L2a
                        kotlin.ResultKt.throwOnFailure(r7)
                        goto L55
                    L2a:
                        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                        java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                        r6.<init>(r7)
                        throw r6
                    L32:
                        kotlin.ResultKt.throwOnFailure(r7)
                        kotlinx.coroutines.flow.FlowCollector r7 = r5.$PlaceComponentResult
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        id.dana.mybills.data.model.response.GeneralProductResult r6 = (id.dana.mybills.data.model.response.GeneralProductResult) r6
                        id.dana.network.base.ExceptionParserFlow r2 = new id.dana.network.base.ExceptionParserFlow
                        r2.<init>()
                        java.lang.String r4 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r4)
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r6 = (com.alipayplus.mobile.component.domain.model.result.BaseRpcResult) r6
                        com.alipayplus.mobile.component.domain.model.result.BaseRpcResult r6 = r2.apply(r6)
                        r0.label = r3
                        java.lang.Object r6 = r7.emit(r6, r0)
                        if (r6 != r1) goto L55
                        return r1
                    L55:
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getGeneralProducts$$inlined$map$2.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }
        };
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<DeleteSubscriptionResult> BuiltInFictitiousFunctionClassFactory(final DeleteSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, DeleteSubscriptionResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$deleteSubscriptionBill$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DeleteSubscriptionResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.deleteSubscriptionBill((DeleteSubscriptionRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<QuerySubscriptionResult> KClassImpl$Data$declaredNonStaticMembers$2(final QuerySubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, QuerySubscriptionResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$subscriptionQueryById$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final QuerySubscriptionResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.subscriptionQueryById((QuerySubscriptionRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<ConfigInfoRangeDateResult> PlaceComponentResult() {
        throw new UnsupportedOperationException();
    }

    @Override // id.dana.mybills.data.repository.source.MyBillsEntityData
    public final Flow<CumulateDueDatePaylaterResult> getAuthRequestContext(final CumulateDueDatePaylaterRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        return wrapper(new Function1<MyBillsRpcFacade, CumulateDueDatePaylaterResult>() { // from class: id.dana.mybills.data.repository.source.network.NetworkMyBillsEntityData$getCumulateDueDatePaylater$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final CumulateDueDatePaylaterResult invoke(MyBillsRpcFacade myBillsRpcFacade) {
                Intrinsics.checkNotNullParameter(myBillsRpcFacade, "");
                return myBillsRpcFacade.getCumulateDueDatePaylater((CumulateDueDatePaylaterRequest) NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0));
            }
        });
    }

    public static final /* synthetic */ BaseRpcRequest PlaceComponentResult(NetworkMyBillsEntityData networkMyBillsEntityData, BaseRpcRequest baseRpcRequest) {
        baseRpcRequest.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return baseRpcRequest;
    }
}
