package id.dana.data.mybills.repository;

import id.dana.data.mybills.model.request.CreateOrderRequest;
import id.dana.data.mybills.model.request.HighlightSubscriptionRequest;
import id.dana.data.mybills.model.request.HighlightTransactionPayRequestEntity;
import id.dana.data.mybills.model.request.InquiryBizDestinationRequest;
import id.dana.data.mybills.model.request.ListPaylaterByBillRequest;
import id.dana.data.mybills.model.request.MonthlyAmountSubscriptionRequest;
import id.dana.data.mybills.model.result.CreateOrderResult;
import id.dana.data.mybills.model.result.HighlightSubscriptionResult;
import id.dana.data.mybills.model.result.HighlightTransactionPayResult;
import id.dana.data.mybills.model.result.InquiryBizDestinationResult;
import id.dana.data.mybills.model.result.ListBillPaylaterResult;
import id.dana.data.mybills.model.result.MonthlyAmountSubscriptionResult;
import id.dana.data.mybills.model.result.QuickBuyResult;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0003\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00042\u0006\u0010\u0003\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00110\u00042\u0006\u0010\u0003\u001a\u00020\u0010H&¢\u0006\u0004\b\n\u0010\u0012J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00140\u00042\u0006\u0010\u0003\u001a\u00020\u0013H&¢\u0006\u0004\b\u0006\u0010\u0015J\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\u0006\u0010\u0003\u001a\u00020\u0016H&¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00042\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH&¢\u0006\u0004\b\u000e\u0010\u001dø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/data/mybills/repository/MyBillsEntityData;", "", "Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;", "p0", "Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/result/HighlightTransactionPayResult;", "getAuthRequestContext", "(Lid/dana/data/mybills/model/request/HighlightTransactionPayRequestEntity;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/CreateOrderRequest;", "Lid/dana/data/mybills/model/result/CreateOrderResult;", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/data/mybills/model/request/CreateOrderRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/HighlightSubscriptionRequest;", "Lid/dana/data/mybills/model/result/HighlightSubscriptionResult;", "MyBillsEntityDataFactory", "(Lid/dana/data/mybills/model/request/HighlightSubscriptionRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;", "Lid/dana/data/mybills/model/result/InquiryBizDestinationResult;", "(Lid/dana/data/mybills/model/request/InquiryBizDestinationRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/ListPaylaterByBillRequest;", "Lid/dana/data/mybills/model/result/ListBillPaylaterResult;", "(Lid/dana/data/mybills/model/request/ListPaylaterByBillRequest;)Lio/reactivex/Observable;", "Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;", "Lid/dana/data/mybills/model/result/MonthlyAmountSubscriptionResult;", "PlaceComponentResult", "(Lid/dana/data/mybills/model/request/MonthlyAmountSubscriptionRequest;)Lio/reactivex/Observable;", "", "", "Lid/dana/data/mybills/model/result/QuickBuyResult;", "(Ljava/util/List;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MyBillsEntityData {
    Observable<CreateOrderResult> KClassImpl$Data$declaredNonStaticMembers$2(CreateOrderRequest p0);

    Observable<InquiryBizDestinationResult> KClassImpl$Data$declaredNonStaticMembers$2(InquiryBizDestinationRequest p0);

    Observable<HighlightSubscriptionResult> MyBillsEntityDataFactory(HighlightSubscriptionRequest p0);

    Observable<QuickBuyResult> MyBillsEntityDataFactory(List<String> p0);

    Observable<MonthlyAmountSubscriptionResult> PlaceComponentResult(MonthlyAmountSubscriptionRequest p0);

    Observable<HighlightTransactionPayResult> getAuthRequestContext(HighlightTransactionPayRequestEntity p0);

    Observable<ListBillPaylaterResult> getAuthRequestContext(ListPaylaterByBillRequest p0);
}
