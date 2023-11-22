package id.dana.promoquest.handler.deeplink;

import id.dana.promoquest.handler.PromoQuestActionHandler;

/* loaded from: classes5.dex */
public class PromoQuestDeeplinkHandler implements PromoQuestActionHandler {
    private PromoQuestDeeplinkActionListener BuiltInFictitiousFunctionClassFactory;
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    public PromoQuestDeeplinkHandler(String str, PromoQuestDeeplinkActionListener promoQuestDeeplinkActionListener) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
        this.BuiltInFictitiousFunctionClassFactory = promoQuestDeeplinkActionListener;
    }

    @Override // id.dana.promoquest.handler.PromoQuestActionHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        PromoQuestDeeplinkActionListener promoQuestDeeplinkActionListener = this.BuiltInFictitiousFunctionClassFactory;
        if (promoQuestDeeplinkActionListener != null) {
            promoQuestDeeplinkActionListener.MyBillsEntityDataFactory(this.KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }
}
