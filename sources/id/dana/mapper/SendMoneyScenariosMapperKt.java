package id.dana.mapper;

import id.dana.domain.sendmoney.model.SendMoneyScenario;
import id.dana.model.SendMoneyScenarioModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lid/dana/domain/sendmoney/model/SendMoneyScenario;", "Lid/dana/model/SendMoneyScenarioModel;", "getAuthRequestContext", "(Lid/dana/domain/sendmoney/model/SendMoneyScenario;)Lid/dana/model/SendMoneyScenarioModel;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SendMoneyScenariosMapperKt {
    public static final SendMoneyScenarioModel getAuthRequestContext(SendMoneyScenario sendMoneyScenario) {
        Intrinsics.checkNotNullParameter(sendMoneyScenario, "");
        String key = sendMoneyScenario.getKey();
        String str = key == null ? "" : key;
        String title = sendMoneyScenario.getTitle();
        String str2 = title == null ? "" : title;
        String subTitle = sendMoneyScenario.getSubTitle();
        String str3 = subTitle == null ? "" : subTitle;
        String action = sendMoneyScenario.getAction();
        String str4 = action == null ? "" : action;
        String redirectUrl = sendMoneyScenario.getRedirectUrl();
        String str5 = redirectUrl == null ? "" : redirectUrl;
        boolean isPromoActive = sendMoneyScenario.isPromoActive();
        String icon = sendMoneyScenario.getIcon();
        String str6 = icon == null ? "" : icon;
        String promoTitle = sendMoneyScenario.getPromoTitle();
        String str7 = promoTitle == null ? "" : promoTitle;
        String promoDesc = sendMoneyScenario.getPromoDesc();
        String str8 = promoDesc == null ? "" : promoDesc;
        boolean isNew = sendMoneyScenario.isNew();
        boolean hasRedDot = sendMoneyScenario.hasRedDot();
        String clientId = sendMoneyScenario.getClientId();
        String str9 = clientId == null ? "" : clientId;
        String httpMethod = sendMoneyScenario.getHttpMethod();
        String str10 = httpMethod == null ? "" : httpMethod;
        String scopes = sendMoneyScenario.getScopes();
        return new SendMoneyScenarioModel(str, str2, str3, str4, str5, isPromoActive, str6, str7, str8, hasRedDot, isNew, str9, str10, scopes == null ? "" : scopes);
    }
}
