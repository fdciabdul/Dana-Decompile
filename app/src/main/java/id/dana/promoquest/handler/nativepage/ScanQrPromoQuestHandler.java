package id.dana.promoquest.handler.nativepage;

import android.content.Context;
import id.dana.animation.SwipeDelegateListener;

/* loaded from: classes5.dex */
public class ScanQrPromoQuestHandler extends BasePromoQuestNativeHandler<SwipeDelegateListener> {
    private SwipeDelegateListener PlaceComponentResult;

    @Override // id.dana.promoquest.handler.nativepage.BasePromoQuestNativeHandler
    public final /* bridge */ /* synthetic */ void MyBillsEntityDataFactory(SwipeDelegateListener swipeDelegateListener) {
        this.PlaceComponentResult = swipeDelegateListener;
    }

    public ScanQrPromoQuestHandler(Context context, SwipeDelegateListener swipeDelegateListener) {
        super(context, swipeDelegateListener);
    }

    @Override // id.dana.promoquest.handler.PromoQuestActionHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory();
    }
}
