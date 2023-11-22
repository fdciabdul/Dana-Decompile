package id.dana.mybills.data.model.response;

import id.dana.mybills.domain.model.ExtendInfoQuerySubscription;
import id.dana.mybills.domain.model.QuerySubscription;
import id.dana.mybills.domain.model.SubscriptionInfo;
import id.dana.mybills.ui.model.MoneyViewModel;
import id.dana.utils.extension.JSONExtKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/mybills/data/model/response/ExtendInfoQuerySubscriptionResult;", "Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "toExtendInfoQuerySubscription", "(Lid/dana/mybills/data/model/response/ExtendInfoQuerySubscriptionResult;)Lid/dana/mybills/domain/model/ExtendInfoQuerySubscription;", "Lid/dana/mybills/data/model/response/QuerySubscriptionResult;", "Lid/dana/mybills/domain/model/QuerySubscription;", "toQuerySubscription", "(Lid/dana/mybills/data/model/response/QuerySubscriptionResult;)Lid/dana/mybills/domain/model/QuerySubscription;", "Lid/dana/mybills/data/model/response/SubscriptionInfoResult;", "Lid/dana/mybills/domain/model/SubscriptionInfo;", "toSubscriptionInfo", "(Lid/dana/mybills/data/model/response/SubscriptionInfoResult;)Lid/dana/mybills/domain/model/SubscriptionInfo;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QuerySubscriptionResultKt {
    public static final QuerySubscription toQuerySubscription(QuerySubscriptionResult querySubscriptionResult) {
        Intrinsics.checkNotNullParameter(querySubscriptionResult, "");
        return new QuerySubscription(toSubscriptionInfo(querySubscriptionResult.getSubscriptionInfo()));
    }

    public static final SubscriptionInfo toSubscriptionInfo(SubscriptionInfoResult subscriptionInfoResult) {
        Object obj;
        ExtendInfoQuerySubscription extendInfoQuerySubscription;
        Intrinsics.checkNotNullParameter(subscriptionInfoResult, "");
        String subscriptionId = subscriptionInfoResult.getSubscriptionId();
        String bizType = subscriptionInfoResult.getBizType();
        String billerId = subscriptionInfoResult.getBillerId();
        String goodsId = subscriptionInfoResult.getGoodsId();
        String title = subscriptionInfoResult.getTitle();
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(subscriptionInfoResult.getExtendInfo(), (Class<Object>) ExtendInfoQuerySubscriptionResult.class);
        } catch (Exception unused) {
            obj = null;
        }
        ExtendInfoQuerySubscriptionResult extendInfoQuerySubscriptionResult = (ExtendInfoQuerySubscriptionResult) obj;
        return new SubscriptionInfo(subscriptionId, bizType, billerId, goodsId, title, (extendInfoQuerySubscriptionResult == null || (extendInfoQuerySubscription = toExtendInfoQuerySubscription(extendInfoQuerySubscriptionResult)) == null) ? new ExtendInfoQuerySubscription(null, null, null, 7, null) : extendInfoQuerySubscription, subscriptionInfoResult.getRecurringType(), subscriptionInfoResult.getGmtDueDate(), subscriptionInfoResult.getScheduleTime(), subscriptionInfoResult.getStartPeriod(), subscriptionInfoResult.getEndPeriod());
    }

    public static final ExtendInfoQuerySubscription toExtendInfoQuerySubscription(ExtendInfoQuerySubscriptionResult extendInfoQuerySubscriptionResult) {
        Object obj;
        Intrinsics.checkNotNullParameter(extendInfoQuerySubscriptionResult, "");
        try {
            obj = JSONExtKt.PlaceComponentResult().fromJson(extendInfoQuerySubscriptionResult.getTotalAmount(), (Class<Object>) MoneyViewModel.class);
        } catch (Exception unused) {
            obj = null;
        }
        MoneyViewModel moneyViewModel = (MoneyViewModel) obj;
        if (moneyViewModel == null) {
            moneyViewModel = new MoneyViewModel(null, null, null, 7, null);
        }
        return new ExtendInfoQuerySubscription(moneyViewModel, extendInfoQuerySubscriptionResult.getNickname(), extendInfoQuerySubscriptionResult.getProvider());
    }
}
