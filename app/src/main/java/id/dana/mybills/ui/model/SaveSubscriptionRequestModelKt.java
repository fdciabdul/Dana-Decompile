package id.dana.mybills.ui.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.mybills.danah5.BillerPortalBridge;
import id.dana.mybills.domain.model.CreateSubscriptionExtendInfo;
import id.dana.mybills.domain.model.CreateSubscriptionRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0011\u0010\u0006\u001a\u00020\u0005*\u00020\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0011\u0010\n\u001a\u00020\t*\u00020\b¢\u0006\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;", "saveRequestModel", "Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "setExtendInfo", "(Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;)Lid/dana/mybills/domain/model/CreateSubscriptionExtendInfo;", "Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "toCreateSubscriptionRequest", "(Lid/dana/mybills/ui/model/SaveSubscriptionRequestModel;)Lid/dana/mybills/domain/model/CreateSubscriptionRequest;", "Lid/dana/mybills/ui/model/MoneyViewModel;", "Lid/dana/domain/nearbyme/model/MoneyView;", "toMoneyView", "(Lid/dana/mybills/ui/model/MoneyViewModel;)Lid/dana/domain/nearbyme/model/MoneyView;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class SaveSubscriptionRequestModelKt {
    public static final CreateSubscriptionRequest toCreateSubscriptionRequest(SaveSubscriptionRequestModel saveSubscriptionRequestModel) {
        Intrinsics.checkNotNullParameter(saveSubscriptionRequestModel, "");
        return new CreateSubscriptionRequest(saveSubscriptionRequestModel.getTitle(), saveSubscriptionRequestModel.getSubscriptionDayOfMonth(), saveSubscriptionRequestModel.getGoodsId(), saveSubscriptionRequestModel.getBillerId(), saveSubscriptionRequestModel.getBizType(), saveSubscriptionRequestModel.getRecurringType(), saveSubscriptionRequestModel.getSubscriptionIntervalType(), saveSubscriptionRequestModel.getSubscriptionIntervalValue(), saveSubscriptionRequestModel.getSubscriptionHourOfDay(), saveSubscriptionRequestModel.getSubscriptionMonthOfYear(), saveSubscriptionRequestModel.getMessage(), saveSubscriptionRequestModel.getSecurityId(), saveSubscriptionRequestModel.getValidateData(), saveSubscriptionRequestModel.getVerificationMethod(), saveSubscriptionRequestModel.getSendStrategy(), saveSubscriptionRequestModel.getPhoneNumber(), setExtendInfo(saveSubscriptionRequestModel));
    }

    public static final CreateSubscriptionExtendInfo setExtendInfo(SaveSubscriptionRequestModel saveSubscriptionRequestModel) {
        Intrinsics.checkNotNullParameter(saveSubscriptionRequestModel, "");
        String cardIndexNo = saveSubscriptionRequestModel.getCardIndexNo();
        String provider = saveSubscriptionRequestModel.getProvider();
        String paymentMethod = saveSubscriptionRequestModel.getPaymentMethod();
        String payMode = saveSubscriptionRequestModel.getPayMode();
        MoneyViewModel denom = saveSubscriptionRequestModel.getDenom();
        MoneyView moneyView = denom != null ? toMoneyView(denom) : null;
        MoneyViewModel totalAmount = saveSubscriptionRequestModel.getTotalAmount();
        CreateSubscriptionExtendInfo createSubscriptionExtendInfo = new CreateSubscriptionExtendInfo(cardIndexNo, provider, paymentMethod, payMode, moneyView, totalAmount != null ? toMoneyView(totalAmount) : null, saveSubscriptionRequestModel.getTimezone(), saveSubscriptionRequestModel.getType(), saveSubscriptionRequestModel.getExtendInfoTitle(), saveSubscriptionRequestModel.getProductTitle(), null, null, 3072, null);
        if (saveSubscriptionRequestModel.getExtendInfo().containsKey(BillerPortalBridge.Event.Info.KEY_QUERY_URL_PROVIDER)) {
            createSubscriptionExtendInfo.setQueryUrlProvider(String.valueOf(saveSubscriptionRequestModel.getExtendInfo().get(BillerPortalBridge.Event.Info.KEY_QUERY_URL_PROVIDER)));
        }
        if (saveSubscriptionRequestModel.getExtendInfo().containsKey(BillerPortalBridge.Event.Info.KEY_BILLER_DENOM_TEXT)) {
            createSubscriptionExtendInfo.setBillerDenomText(String.valueOf(saveSubscriptionRequestModel.getExtendInfo().get(BillerPortalBridge.Event.Info.KEY_BILLER_DENOM_TEXT)));
        }
        return createSubscriptionExtendInfo;
    }

    public static final MoneyView toMoneyView(MoneyViewModel moneyViewModel) {
        Intrinsics.checkNotNullParameter(moneyViewModel, "");
        return new MoneyView(moneyViewModel.getAmount(), moneyViewModel.getCurrency(), moneyViewModel.getCurrencyCode());
    }
}
