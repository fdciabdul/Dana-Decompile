package id.dana.promoquest.handler.nativepage;

import android.content.Context;
import id.dana.sendmoney_v2.landing.SendMoneyActivity;

/* loaded from: classes5.dex */
public class SendMoneyPromoQuestHandler extends BasePromoQuestNativeHandler<SendMoneyActivity> {
    public SendMoneyPromoQuestHandler(Context context) {
        super(context);
    }

    @Override // id.dana.promoquest.handler.PromoQuestActionHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext();
    }

    @Override // id.dana.promoquest.handler.nativepage.BasePromoQuestNativeHandler
    protected final Class<SendMoneyActivity> PlaceComponentResult() {
        return SendMoneyActivity.class;
    }
}
