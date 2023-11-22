package id.dana.data.nearbyme.model;

import id.dana.domain.nearbyme.model.MoneyView;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u0004\u0018\u00010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/network/response/expresspurchase/MoneyViewEntity;", "Lid/dana/domain/nearbyme/model/MoneyView;", "toMoneyView", "(Lid/dana/network/response/expresspurchase/MoneyViewEntity;)Lid/dana/domain/nearbyme/model/MoneyView;", "toMoneyViewEntity", "(Lid/dana/domain/nearbyme/model/MoneyView;)Lid/dana/network/response/expresspurchase/MoneyViewEntity;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class MoneyViewEntityMapperKt {
    public static final MoneyView toMoneyView(MoneyViewEntity moneyViewEntity) {
        if (moneyViewEntity == null) {
            return new MoneyView(null, null, null, 7, null);
        }
        String amount = moneyViewEntity.getAmount();
        if (amount == null) {
            amount = "";
        }
        String currency = moneyViewEntity.getCurrency();
        if (currency == null) {
            currency = "";
        }
        String currencyCode = moneyViewEntity.getCurrencyCode();
        return new MoneyView(amount, currency, currencyCode != null ? currencyCode : "");
    }

    public static final MoneyViewEntity toMoneyViewEntity(MoneyView moneyView) {
        if (moneyView == null) {
            return new MoneyViewEntity(null, null, null, 7, null);
        }
        return new MoneyViewEntity(moneyView.getAmount(), moneyView.getCurrency(), moneyView.getCurrencyCode());
    }
}
