package id.dana.data.user;

import id.dana.domain.home.HomeWidgetRepository;
import id.dana.domain.user.CurrencyAmount;
import io.reactivex.functions.Consumer;

/* loaded from: classes4.dex */
public final /* synthetic */ class UserEntityRepository$$ExternalSyntheticLambda34 implements Consumer {
    public final /* synthetic */ HomeWidgetRepository f$0;

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object obj) {
        this.f$0.saveBalanceIntoPersistence((CurrencyAmount) obj);
    }
}
