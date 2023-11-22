package id.dana.mybills.domain.model;

import com.google.gson.Gson;
import id.dana.data.wallet.mapper.UserAssetsMapperKt;
import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.data.model.request.CreateSubscriptionExtendInfoEntity;
import id.dana.mybills.data.model.request.CreateSubscriptionRequestEntity;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "Lid/dana/mybills/data/model/request/CreateSubscriptionExtendInfoEntity;", "toCreateSubscriptionExtendInfoEntity", "(Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;)Lid/dana/mybills/data/model/request/CreateSubscriptionExtendInfoEntity;", "Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;", "toCreateSubscriptionRequestEntity", "(Lid/dana/mybills/domain/model/CreateSubscriptionRequest;)Lid/dana/mybills/data/model/request/CreateSubscriptionRequestEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CreateSubscriptionRequestKt {
    public static final CreateSubscriptionRequestEntity toCreateSubscriptionRequestEntity(CreateSubscriptionRequest createSubscriptionRequest) {
        Intrinsics.checkNotNullParameter(createSubscriptionRequest, "");
        String title = createSubscriptionRequest.getTitle();
        String subscriptionDayOfMonth = createSubscriptionRequest.getSubscriptionDayOfMonth();
        String goodsId = createSubscriptionRequest.getGoodsId();
        String billerId = createSubscriptionRequest.getBillerId();
        String bizType = createSubscriptionRequest.getBizType();
        String recurringType = createSubscriptionRequest.getRecurringType();
        String subscriptionIntervalType = createSubscriptionRequest.getSubscriptionIntervalType();
        String subscriptionIntervalValue = createSubscriptionRequest.getSubscriptionIntervalValue();
        String subscriptionHourOfDay = createSubscriptionRequest.getSubscriptionHourOfDay();
        String subscriptionMonthOfYear = createSubscriptionRequest.getSubscriptionMonthOfYear();
        String message = createSubscriptionRequest.getMessage();
        String securityId = createSubscriptionRequest.getSecurityId();
        String validateData = createSubscriptionRequest.getValidateData();
        String verificationMethod = createSubscriptionRequest.getVerificationMethod();
        String sendStrategy = createSubscriptionRequest.getSendStrategy();
        String phoneNumber = createSubscriptionRequest.getPhoneNumber();
        CreateSubscriptionExtendInfo extendInfo = createSubscriptionRequest.getExtendInfo();
        String json = new Gson().toJson(extendInfo != null ? toCreateSubscriptionExtendInfoEntity(extendInfo) : null);
        Intrinsics.checkNotNullExpressionValue(json, "");
        return new CreateSubscriptionRequestEntity(title, subscriptionDayOfMonth, goodsId, billerId, bizType, recurringType, subscriptionIntervalType, subscriptionIntervalValue, subscriptionHourOfDay, subscriptionMonthOfYear, message, securityId, validateData, verificationMethod, sendStrategy, phoneNumber, json);
    }

    private static final CreateSubscriptionExtendInfoEntity toCreateSubscriptionExtendInfoEntity(CreateSubscriptionExtendInfo createSubscriptionExtendInfo) {
        String cardIndexNo = createSubscriptionExtendInfo.getCardIndexNo();
        String provider = createSubscriptionExtendInfo.getProvider();
        String paymentMethod = createSubscriptionExtendInfo.getPaymentMethod();
        String payMode = createSubscriptionExtendInfo.getPayMode();
        MoneyView denom = createSubscriptionExtendInfo.getDenom();
        MoneyViewEntity authRequestContext = denom != null ? UserAssetsMapperKt.getAuthRequestContext(denom) : null;
        MoneyView totalAmount = createSubscriptionExtendInfo.getTotalAmount();
        return new CreateSubscriptionExtendInfoEntity(cardIndexNo, provider, paymentMethod, payMode, authRequestContext, createSubscriptionExtendInfo.getTimezone(), createSubscriptionExtendInfo.getType(), createSubscriptionExtendInfo.getTitle(), totalAmount != null ? UserAssetsMapperKt.getAuthRequestContext(totalAmount) : null, createSubscriptionExtendInfo.getProductTitle(), createSubscriptionExtendInfo.getQueryUrlProvider(), createSubscriptionExtendInfo.getBillerDenomText());
    }
}
