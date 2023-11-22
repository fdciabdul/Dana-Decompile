package id.dana.data.mybills.repository.source.network;

import com.alipay.mobile.framework.service.annotation.OperationType;
import com.alipay.mobile.framework.service.annotation.SignCheck;
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
import kotlin.Metadata;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H'¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u000bH'¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u000fH'¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u0013H'¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0003\u001a\u00020\u0017H'¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001bH'¢\u0006\u0004\b\u001d\u0010\u001eø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/mybills/repository/source/network/MyBillsFacade;", "", "Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;", "request", "Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "bizDestinationInquiry", "(Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;)Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;", "Lid/dana/data/mybills/model/result/HighlightTransactionPayResult;", "consultHiglightTransactionPay", "(Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;)Lid/dana/data/mybills/model/result/HighlightTransactionPayResult;", "Lid/dana/data/mybills/model/request/CreateOrderRequest;", "Lid/dana/data/mybills/model/result/CreateOrderResult;", "createBizProductOrder", "(Lid/dana/data/mybills/model/request/CreateOrderRequest;)Lid/dana/data/mybills/model/result/CreateOrderResult;", "Lid/dana/data/mybills/model/request/ListPaylaterByBillRequest;", "Lid/dana/data/mybills/model/result/ListBillPaylaterResult;", "listPaylaterByBill", "(Lid/dana/data/mybills/model/request/ListPaylaterByBillRequest;)Lid/dana/data/mybills/model/result/ListBillPaylaterResult;", "Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "monthlyAmountSubscription", "(Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;)Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "Lid/dana/data/mybills/model/request/QuickBuyRequest;", "Lid/dana/data/mybills/model/result/QuickBuyResult;", "quickBuy", "(Lid/dana/data/mybills/model/request/QuickBuyRequest;)Lid/dana/data/mybills/model/result/QuickBuyResult;", "Lid/dana/data/mybills/model/request/HighlightSubscriptionRequest;", "Lid/dana/data/mybills/model/result/HighlightSubscriptionResult;", "subscriptionConsultView", "(Lid/dana/data/mybills/model/request/HighlightSubscriptionRequest;)Lid/dana/data/mybills/model/result/HighlightSubscriptionResult;", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface MyBillsFacade {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = Companion.getAuthRequestContext;

    @OperationType("alipayplus.mobilewallet.product.inquire.biz.destination")
    @SignCheck
    InquiryBizDestinationResult bizDestinationInquiry(InquiryBizDestinationRequest request);

    @OperationType("id.dana.recurring.transaction.pay")
    @SignCheck
    HighlightTransactionPayResult consultHiglightTransactionPay(HighlightTransactionPayRequestEntity request);

    @OperationType("alipayplus.mobilewallet.product.order")
    @SignCheck
    CreateOrderResult createBizProductOrder(CreateOrderRequest request);

    @OperationType("id.dana.mobilebizpaylaterprod.bill.list.query")
    @SignCheck
    ListBillPaylaterResult listPaylaterByBill(ListPaylaterByBillRequest request);

    @OperationType("id.dana.recurring.subscription.queryMonthlyAmount")
    @SignCheck
    MonthlyAmountSubscriptionResult monthlyAmountSubscription(MonthlyAmountSubscriptionRequest request);

    @OperationType("alipayplus.mobilewallet.product.query.successful.biz.ids")
    @SignCheck
    QuickBuyResult quickBuy(QuickBuyRequest request);

    @OperationType("id.dana.recurring.subscription.consult.view")
    @SignCheck
    HighlightSubscriptionResult subscriptionConsultView(HighlightSubscriptionRequest request);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/data/mybills/repository/source/network/MyBillsFacade$Companion;", "", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        static final /* synthetic */ Companion getAuthRequestContext = new Companion();

        private Companion() {
        }
    }
}
