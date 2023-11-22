package id.dana.promoquest.handler.nativepage;

import android.content.Context;
import id.dana.animation.SwipeDelegateListener;
import id.dana.promoquest.handler.PromoQuestActionHandler;

/* loaded from: classes5.dex */
public class PromoQuestNativePageHandler implements PromoQuestActionHandler {
    private PromoQuestNativeActionFactory KClassImpl$Data$declaredNonStaticMembers$2;
    private String MyBillsEntityDataFactory;

    public PromoQuestNativePageHandler(Context context, String str, SwipeDelegateListener swipeDelegateListener) {
        this.MyBillsEntityDataFactory = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new PromoQuestNativeActionFactory(context, swipeDelegateListener);
    }

    @Override // id.dana.promoquest.handler.PromoQuestActionHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        char c;
        PromoQuestActionHandler sendMoneyPromoQuestHandler;
        PromoQuestNativeActionFactory promoQuestNativeActionFactory = this.KClassImpl$Data$declaredNonStaticMembers$2;
        String str = this.MyBillsEntityDataFactory;
        str.hashCode();
        int hashCode = str.hashCode();
        if (hashCode == -2071753431) {
            if (str.equals(NativePageType.SEND_MONEY)) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != -1666006237) {
            if (hashCode == 873321820 && str.equals(NativePageType.ALL_SERVICES)) {
                c = 2;
            }
            c = 65535;
        } else {
            if (str.equals(NativePageType.SCAN_QR)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            sendMoneyPromoQuestHandler = new SendMoneyPromoQuestHandler(promoQuestNativeActionFactory.KClassImpl$Data$declaredNonStaticMembers$2);
        } else if (c == 1) {
            sendMoneyPromoQuestHandler = new ScanQrPromoQuestHandler(promoQuestNativeActionFactory.KClassImpl$Data$declaredNonStaticMembers$2, promoQuestNativeActionFactory.BuiltInFictitiousFunctionClassFactory);
        } else if (c == 2) {
            sendMoneyPromoQuestHandler = new ServicesPromoQuestHandler(promoQuestNativeActionFactory.KClassImpl$Data$declaredNonStaticMembers$2, str, false);
        } else {
            sendMoneyPromoQuestHandler = new ServicesPromoQuestHandler(promoQuestNativeActionFactory.KClassImpl$Data$declaredNonStaticMembers$2, str, true);
        }
        sendMoneyPromoQuestHandler.KClassImpl$Data$declaredNonStaticMembers$2();
    }
}
