package id.dana.domain.mybills;

import id.dana.domain.mybills.model.BizProduct;
import id.dana.domain.mybills.model.BizProductDestination;
import id.dana.domain.mybills.model.BizProductOrder;
import id.dana.domain.mybills.model.BizProductOrderRequest;
import id.dana.domain.mybills.model.HighlightTransactionPay;
import id.dana.domain.mybills.model.HighlightTransactionPayRequest;
import id.dana.domain.mybills.model.MyBillPaylater;
import id.dana.domain.mybills.model.MyBillsHighlight;
import id.dana.domain.mybills.model.MyBillsHighlightRequestModel;
import id.dana.domain.mybills.model.MyBillsMonthlyAmount;
import io.reactivex.Observable;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u00042\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00042\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H&¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00190\u00042\u0006\u0010\u0018\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H&¢\u0006\u0004\b\u001c\u0010\u001dJ-\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u00042\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0012H&¢\u0006\u0004\b\"\u0010#J)\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0\u00190\u00042\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120\u0019H&¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u00042\u0006\u0010(\u001a\u00020\u0012H&¢\u0006\u0004\b*\u0010+ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/domain/mybills/MyBillsRepository;", "", "Lid/dana/domain/mybills/model/BizProductOrderRequest;", "bizProductOrderRequest", "Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/BizProductOrder;", "getCreateBizProductOrder", "(Lid/dana/domain/mybills/model/BizProductOrderRequest;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/MyBillsHighlightRequestModel;", "highlightSubscriptionRequest", "Lid/dana/domain/mybills/model/MyBillsHighlight;", "getHighlightSubscription", "(Lid/dana/domain/mybills/model/MyBillsHighlightRequestModel;)Lio/reactivex/Observable;", "Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;", "highlightTransactionPayRequest", "Lid/dana/domain/mybills/model/HighlightTransactionPay;", "getHighlightTransactionPay", "(Lid/dana/domain/mybills/model/HighlightTransactionPayRequest;)Lio/reactivex/Observable;", "", "goodsId", "bizParam", "Lid/dana/domain/mybills/model/BizProductDestination;", "getInquirySubscriptionDestination", "(Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "type", "", "listIds", "Lid/dana/domain/mybills/model/MyBillPaylater;", "getListBillsByBillsIds", "(Ljava/lang/String;Ljava/util/List;)Lio/reactivex/Observable;", "ipRoleId", "goodsType", "recurringType", "Lid/dana/domain/mybills/model/MyBillsMonthlyAmount;", "getMonthlyAmountSubscription", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lio/reactivex/Observable;", "profileKeys", "Lid/dana/domain/mybills/model/BizProduct;", "getQuickBuySubscription", "(Ljava/util/List;)Lio/reactivex/Observable;", "service", "", "isServiceEnable", "(Ljava/lang/String;)Lio/reactivex/Observable;"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface MyBillsRepository {
    Observable<BizProductOrder> getCreateBizProductOrder(BizProductOrderRequest bizProductOrderRequest);

    Observable<MyBillsHighlight> getHighlightSubscription(MyBillsHighlightRequestModel highlightSubscriptionRequest);

    Observable<HighlightTransactionPay> getHighlightTransactionPay(HighlightTransactionPayRequest highlightTransactionPayRequest);

    Observable<BizProductDestination> getInquirySubscriptionDestination(String goodsId, String bizParam);

    Observable<List<MyBillPaylater>> getListBillsByBillsIds(String type, List<String> listIds);

    Observable<MyBillsMonthlyAmount> getMonthlyAmountSubscription(String ipRoleId, String goodsType, String recurringType);

    Observable<List<BizProduct>> getQuickBuySubscription(List<String> profileKeys);

    Observable<Boolean> isServiceEnable(String service);
}
