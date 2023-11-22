package id.dana.promoquest.handler.nativepage;

import android.content.Context;
import android.content.Intent;
import id.dana.service.ServicesActivity;

/* loaded from: classes5.dex */
public class ServicesPromoQuestHandler extends BasePromoQuestNativeHandler<ServicesActivity> {
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    private String PlaceComponentResult;

    public ServicesPromoQuestHandler(Context context, String str, boolean z) {
        super(context);
        this.PlaceComponentResult = str;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = z;
    }

    @Override // id.dana.promoquest.handler.nativepage.BasePromoQuestNativeHandler
    protected final Class<ServicesActivity> PlaceComponentResult() {
        return ServicesActivity.class;
    }

    @Override // id.dana.promoquest.handler.nativepage.BasePromoQuestNativeHandler
    protected final Intent MyBillsEntityDataFactory(Intent intent) {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2) {
            intent.putExtra(ServicesActivity.FILTER_SERVICES, this.PlaceComponentResult);
            intent.putExtra("FILTER_BY", "name");
        }
        return intent;
    }

    @Override // id.dana.promoquest.handler.PromoQuestActionHandler
    public final void KClassImpl$Data$declaredNonStaticMembers$2() {
        getAuthRequestContext();
    }
}
