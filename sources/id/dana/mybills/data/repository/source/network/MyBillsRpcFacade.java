package id.dana.mybills.data.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
import id.dana.mybills.data.model.request.CreateOrderRequest;
import id.dana.mybills.data.model.request.CreateSubscriptionRequestEntity;
import id.dana.mybills.data.model.request.CumulateDueDatePaylaterRequest;
import id.dana.mybills.data.model.request.DeleteSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightSubscriptionRequest;
import id.dana.mybills.data.model.request.HighlightTransactionPayRequestEntity;
import id.dana.mybills.data.model.request.InquiryBizDestinationRequest;
import id.dana.mybills.data.model.request.ListPaylaterByBillRequest;
import id.dana.mybills.data.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.mybills.data.model.request.QuerySubscriptionRequest;
import id.dana.mybills.data.model.request.QuickBuyRequest;
import id.dana.mybills.data.model.request.UniqueValueRequest;
import id.dana.mybills.data.model.request.UpdateSubscriptionRequest;
import id.dana.mybills.data.model.response.CreateOrderResult;
import id.dana.mybills.data.model.response.CreateSubscriptionResult;
import id.dana.mybills.data.model.response.CumulateDueDatePaylaterResult;
import id.dana.mybills.data.model.response.DeleteSubscriptionResult;
import id.dana.mybills.data.model.response.HighlightSubscriptionResult;
import id.dana.mybills.data.model.response.HighlightTransactionPayResult;
import id.dana.mybills.data.model.response.InquiryBizDestinationResult;
import id.dana.mybills.data.model.response.ListBillPaylaterResult;
import id.dana.mybills.data.model.response.MonthlyAmountSubscriptionResult;
import id.dana.mybills.data.model.response.QuerySubscriptionResult;
import id.dana.mybills.data.model.response.QuickBuyResult;
import id.dana.mybills.data.model.response.UniqueValueResult;
import id.dana.mybills.data.model.response.UpdateSubscriptionResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 72\u00020\u0001:\u00017J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u001fH'¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020#H'¢\u0006\u0004\b%\u0010&J\u0017\u0010)\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020'H'¢\u0006\u0004\b)\u0010*J\u0017\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020+H'¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u0002002\u0006\u0010\u0003\u001a\u00020/H'¢\u0006\u0004\b1\u00102J\u0017\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u000203H'¢\u0006\u0004\b5\u00106ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/mybills/data/repository/source/network/MyBillsRpcFacade;", "", "Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;", "request", "Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "bizDestinationInquiry", "(Lid/dana/mybills/data/model/request/InquiryBizDestinationRequest;)Lid/dana/mybills/data/model/response/InquiryBizDestinationResult;", "Lid/dana/mybills/data/model/request/UniqueValueRequest;", "Lid/dana/mybills/data/model/response/UniqueValueResult;", "checkUniqueValue", "(Lid/dana/mybills/data/model/request/UniqueValueRequest;)Lid/dana/mybills/data/model/response/UniqueValueResult;", "Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;", "Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "consultHiglightTransactionPay", "(Lid/dana/mybills/data/model/request/HighlightTransactionPayRequestEntity;)Lid/dana/mybills/data/model/response/HighlightTransactionPayResult;", "Lid/dana/mybills/data/model/request/CreateOrderRequest;", "Lid/dana/mybills/data/model/response/CreateOrderResult;", "createBizProductOrder", "(Lid/dana/mybills/data/model/request/CreateOrderRequest;)Lid/dana/mybills/data/model/response/CreateOrderResult;", "Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;", "Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "deleteSubscriptionBill", "(Lid/dana/mybills/data/model/request/DeleteSubscriptionRequest;)Lid/dana/mybills/data/model/response/DeleteSubscriptionResult;", "Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;", "Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "getCumulateDueDatePaylater", "(Lid/dana/mybills/data/model/request/CumulateDueDatePaylaterRequest;)Lid/dana/mybills/data/model/response/CumulateDueDatePaylaterResult;", "Lid/dana/mybills/data/model/request/ListPaylaterByBillRequest;", "Lid/dana/mybills/data/model/response/ListBillPaylaterResult;", "listPaylaterByBill", "(Lid/dana/mybills/data/model/request/ListPaylaterByBillRequest;)Lid/dana/mybills/data/model/response/ListBillPaylaterResult;", "Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/mybills/data/model/response/MonthlyAmountSubscriptionResult;", "monthlyAmountSubscription", "(Lid/dana/mybills/data/model/request/MonthlyAmountSubscriptionRequest;)Lid/dana/mybills/data/model/response/MonthlyAmountSubscriptionResult;", "Lid/dana/mybills/data/model/request/QuickBuyRequest;", "Lid/dana/mybills/data/model/response/QuickBuyResult;", "quickBuy", "(Lid/dana/mybills/data/model/request/QuickBuyRequest;)Lid/dana/mybills/data/model/response/QuickBuyResult;", "Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;", "Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "saveSubscription", "(Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;)Lid/dana/mybills/data/model/response/CreateSubscriptionResult;", "Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;", "Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "subscriptionConsultView", "(Lid/dana/mybills/data/model/request/HighlightSubscriptionRequest;)Lid/dana/mybills/data/model/response/HighlightSubscriptionResult;", "Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "subscriptionQueryById", "(Lid/dana/mybills/data/model/request/QuerySubscriptionRequest;)Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;", "Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "updateSubscriptionBill", "(Lid/dana/mybills/data/model/request/UpdateSubscriptionRequest;)Lid/dana/mybills/data/model/response/UpdateSubscriptionResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface MyBillsRpcFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.MyBillsEntityDataFactory;

    @OperationType("alipayplus.mobilewallet.product.inquire.biz.destination")
    @SignCheck
    InquiryBizDestinationResult bizDestinationInquiry(InquiryBizDestinationRequest request);

    @OperationType("id.dana.recurring.subscription.queryUniqueValue")
    @SignCheck
    UniqueValueResult checkUniqueValue(UniqueValueRequest request);

    @OperationType("id.dana.recurring.transaction.pay")
    @SignCheck
    HighlightTransactionPayResult consultHiglightTransactionPay(HighlightTransactionPayRequestEntity request);

    @OperationType("alipayplus.mobilewallet.product.order")
    @SignCheck
    CreateOrderResult createBizProductOrder(CreateOrderRequest request);

    @OperationType("id.dana.recurring.subscription.terminate")
    @SignCheck
    DeleteSubscriptionResult deleteSubscriptionBill(DeleteSubscriptionRequest request);

    @OperationType("id.dana.mobilebizpaylaterprod.loan.query.cumulate.duedate")
    @SignCheck
    CumulateDueDatePaylaterResult getCumulateDueDatePaylater(CumulateDueDatePaylaterRequest request);

    @OperationType("id.dana.mobilebizpaylaterprod.bill.list.query")
    @SignCheck
    ListBillPaylaterResult listPaylaterByBill(ListPaylaterByBillRequest request);

    @OperationType("id.dana.recurring.subscription.queryMonthlyAmount")
    @SignCheck
    MonthlyAmountSubscriptionResult monthlyAmountSubscription(MonthlyAmountSubscriptionRequest request);

    @OperationType("alipayplus.mobilewallet.product.query.successful.biz.ids")
    @SignCheck
    QuickBuyResult quickBuy(QuickBuyRequest request);

    @OperationType("id.dana.recurring.subscription.create")
    @SignCheck
    CreateSubscriptionResult saveSubscription(CreateSubscriptionRequestEntity request);

    @OperationType("id.dana.recurring.subscription.consult.view")
    @SignCheck
    HighlightSubscriptionResult subscriptionConsultView(HighlightSubscriptionRequest request);

    @OperationType("id.dana.recurring.subscription.querybyid")
    @SignCheck
    QuerySubscriptionResult subscriptionQueryById(QuerySubscriptionRequest request);

    @OperationType("id.dana.recurring.subscription.update")
    @SignCheck
    UpdateSubscriptionResult updateSubscriptionBill(UpdateSubscriptionRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/mybills/data/repository/source/network/MyBillsRpcFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        static final /* synthetic */ Companion MyBillsEntityDataFactory = new Companion();

        private Companion() {
        }
    }
}
