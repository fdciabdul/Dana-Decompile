package id.dana.data.mybills.repository.source.network;

import android.content.Context;
import id.dana.data.foundation.facade.ApSecurityFacade;
import id.dana.data.foundation.utils.CookieUtil;
import id.dana.data.mybills.model.request.CreateOrderRequest;
import id.dana.data.mybills.model.request.HighlightSubscriptionRequest;
import id.dana.data.mybills.model.request.HighlightTransactionPayRequestEntity;
import id.dana.data.mybills.model.request.InquiryBizDestinationRequest;
import id.dana.data.mybills.model.request.ListPaylaterByBillRequest;
import id.dana.data.mybills.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.data.mybills.model.request.QuickBuyRequest;
import id.dana.data.mybills.model.result.CreateOrderResult;
import id.dana.data.mybills.model.result.HighlightSubscriptionResult;
import id.dana.data.mybills.model.result.HighlightTransactionPayResult;
import id.dana.data.mybills.model.result.InquiryBizDestinationResult;
import id.dana.data.mybills.model.result.ListBillPaylaterResult;
import id.dana.data.mybills.model.result.MonthlyAmountSubscriptionResult;
import id.dana.data.mybills.model.result.QuickBuyResult;
import id.dana.data.mybills.repository.MyBillsEntityData;
import id.dana.network.base.BaseNetwork;
import id.dana.network.base.SecureBaseNetwork;
import id.dana.network.rpc.RpcConnector;
import id.dana.utils.concurrent.ThreadExecutor;
import io.reactivex.Observable;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Singleton
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B)\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020#\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010'\u001a\u00020&\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00062\u0006\u0010\u0005\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0014¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00062\u0006\u0010\u0005\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00160\u00062\u0006\u0010\u0005\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\f\u0010\u0017J\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00190\u00062\u0006\u0010\u0005\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\b\u0010\u001aJ\u001d\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00062\u0006\u0010\u0005\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020!0\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016¢\u0006\u0004\b\u0013\u0010\""}, d2 = {"Lid/dana/data/mybills/repository/source/network/NetworkMyBillsEntityData;", "Lid/dana/network/base/SecureBaseNetwork;", "Lid/dana/data/mybills/repository/source/network/MyBillsFacade;", "Lid/dana/data/mybills/repository/MyBillsEntityData;", "Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/result/HighlightTransactionPayResult;", "getAuthRequestContext", "(Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/CreateOrderRequest;", "Lid/dana/data/mybills/model/result/CreateOrderResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/mybills/model/request/CreateOrderRequest;)Lio/reactivex/Observable;", "Ljava/lang/Class;", "getFacadeClass", "()Ljava/lang/Class;", "Lid/dana/data/mybills/model/request/HighlightSubscriptionRequest;", "Lid/dana/data/mybills/model/result/HighlightSubscriptionResult;", "MyBillsEntityDataFactory", "(Lid/dana/data/mybills/model/request/HighlightSubscriptionRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;", "Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "(Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/ListPaylaterByBillRequest;", "Lid/dana/data/mybills/model/result/ListBillPaylaterResult;", "(Lid/dana/data/mybills/model/request/ListPaylaterByBillRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "PlaceComponentResult", "(Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;)Lio/reactivex/Observable;", "", "", "Lid/dana/data/mybills/model/result/QuickBuyResult;", "(Ljava/util/List;)Lio/reactivex/Observable;", "Lid/dana/network/rpc/RpcConnector;", "Lid/dana/utils/concurrent/ThreadExecutor;", "p1", "Lid/dana/data/foundation/facade/ApSecurityFacade;", "p2", "Landroid/content/Context;", "p3", "<init>", "(Lid/dana/network/rpc/RpcConnector;Lid/dana/utils/concurrent/ThreadExecutor;Lid/dana/data/foundation/facade/ApSecurityFacade;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class NetworkMyBillsEntityData extends SecureBaseNetwork<MyBillsFacade> implements MyBillsEntityData {
    @Override // id.dana.network.base.BaseNetwork
    public final Class<MyBillsFacade> getFacadeClass() {
        return MyBillsFacade.class;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @Inject
    public NetworkMyBillsEntityData(RpcConnector rpcConnector, ThreadExecutor threadExecutor, ApSecurityFacade apSecurityFacade, Context context) {
        super(rpcConnector, threadExecutor, apSecurityFacade, context);
        Intrinsics.checkNotNullParameter(rpcConnector, "");
        Intrinsics.checkNotNullParameter(threadExecutor, "");
        Intrinsics.checkNotNullParameter(apSecurityFacade, "");
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<MonthlyAmountSubscriptionResult> PlaceComponentResult(final MonthlyAmountSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda2
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.BuiltInFictitiousFunctionClassFactory(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<HighlightSubscriptionResult> MyBillsEntityDataFactory(final HighlightSubscriptionRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda3
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.PlaceComponentResult(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<QuickBuyResult> MyBillsEntityDataFactory(final List<String> p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda5
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.getAuthRequestContext(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<CreateOrderResult> KClassImpl$Data$declaredNonStaticMembers$2(final CreateOrderRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda6
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.getAuthRequestContext(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<HighlightTransactionPayResult> getAuthRequestContext(final HighlightTransactionPayRequestEntity p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda1
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.BuiltInFictitiousFunctionClassFactory(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<ListBillPaylaterResult> getAuthRequestContext(final ListPaylaterByBillRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda0
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.getAuthRequestContext(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    @Override // id.dana.data.mybills.repository.MyBillsEntityData
    public final Observable<InquiryBizDestinationResult> KClassImpl$Data$declaredNonStaticMembers$2(final InquiryBizDestinationRequest p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        Observable wrapper = wrapper(new BaseNetwork.FacadeProcessor() { // from class: id.dana.data.mybills.repository.source.network.NetworkMyBillsEntityData$$ExternalSyntheticLambda4
            @Override // id.dana.network.base.BaseNetwork.FacadeProcessor
            public final Object processFacade(Object obj) {
                return NetworkMyBillsEntityData.getAuthRequestContext(NetworkMyBillsEntityData.this, p0, (MyBillsFacade) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(wrapper, "");
        return wrapper;
    }

    public static /* synthetic */ InquiryBizDestinationResult getAuthRequestContext(NetworkMyBillsEntityData networkMyBillsEntityData, InquiryBizDestinationRequest inquiryBizDestinationRequest, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(inquiryBizDestinationRequest, "");
        InquiryBizDestinationRequest inquiryBizDestinationRequest2 = inquiryBizDestinationRequest;
        inquiryBizDestinationRequest2.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        InquiryBizDestinationRequest inquiryBizDestinationRequest3 = inquiryBizDestinationRequest2;
        Map<String, String> map = inquiryBizDestinationRequest3.extParams;
        Intrinsics.checkNotNullExpressionValue(map, "");
        map.put("ctoken", CookieUtil.getAuthRequestContext().toString());
        return myBillsFacade.bizDestinationInquiry(inquiryBizDestinationRequest3);
    }

    public static /* synthetic */ QuickBuyResult getAuthRequestContext(NetworkMyBillsEntityData networkMyBillsEntityData, List list, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(list, "");
        QuickBuyRequest quickBuyRequest = new QuickBuyRequest(list);
        quickBuyRequest.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return myBillsFacade.quickBuy(quickBuyRequest);
    }

    public static /* synthetic */ MonthlyAmountSubscriptionResult BuiltInFictitiousFunctionClassFactory(NetworkMyBillsEntityData networkMyBillsEntityData, MonthlyAmountSubscriptionRequest monthlyAmountSubscriptionRequest, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(monthlyAmountSubscriptionRequest, "");
        MonthlyAmountSubscriptionRequest monthlyAmountSubscriptionRequest2 = monthlyAmountSubscriptionRequest;
        monthlyAmountSubscriptionRequest2.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return myBillsFacade.monthlyAmountSubscription(monthlyAmountSubscriptionRequest2);
    }

    public static /* synthetic */ HighlightSubscriptionResult PlaceComponentResult(NetworkMyBillsEntityData networkMyBillsEntityData, HighlightSubscriptionRequest highlightSubscriptionRequest, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(highlightSubscriptionRequest, "");
        HighlightSubscriptionRequest highlightSubscriptionRequest2 = highlightSubscriptionRequest;
        highlightSubscriptionRequest2.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return myBillsFacade.subscriptionConsultView(highlightSubscriptionRequest2);
    }

    public static /* synthetic */ CreateOrderResult getAuthRequestContext(NetworkMyBillsEntityData networkMyBillsEntityData, CreateOrderRequest createOrderRequest, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(createOrderRequest, "");
        CreateOrderRequest createOrderRequest2 = createOrderRequest;
        createOrderRequest2.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return myBillsFacade.createBizProductOrder(createOrderRequest2);
    }

    public static /* synthetic */ ListBillPaylaterResult getAuthRequestContext(NetworkMyBillsEntityData networkMyBillsEntityData, ListPaylaterByBillRequest listPaylaterByBillRequest, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(listPaylaterByBillRequest, "");
        ListPaylaterByBillRequest listPaylaterByBillRequest2 = listPaylaterByBillRequest;
        listPaylaterByBillRequest2.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return myBillsFacade.listPaylaterByBill(listPaylaterByBillRequest2);
    }

    public static /* synthetic */ HighlightTransactionPayResult BuiltInFictitiousFunctionClassFactory(NetworkMyBillsEntityData networkMyBillsEntityData, HighlightTransactionPayRequestEntity highlightTransactionPayRequestEntity, MyBillsFacade myBillsFacade) {
        Intrinsics.checkNotNullParameter(networkMyBillsEntityData, "");
        Intrinsics.checkNotNullParameter(highlightTransactionPayRequestEntity, "");
        HighlightTransactionPayRequestEntity highlightTransactionPayRequestEntity2 = highlightTransactionPayRequestEntity;
        highlightTransactionPayRequestEntity2.envInfo = networkMyBillsEntityData.generateMobileEnvInfo();
        return myBillsFacade.consultHiglightTransactionPay(highlightTransactionPayRequestEntity2);
    }
}
