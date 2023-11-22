package id.dana.pay.card;

import id.dana.R;
import id.dana.pay.PayCardViewItem;

/* loaded from: classes5.dex */
public class MaybankCard {
    private MaybankCard() {
    }

    public static PayCardViewItem getAuthRequestContext() {
        PayCardViewItem.Builder PlaceComponentResult = PayCardViewItem.PlaceComponentResult();
        PlaceComponentResult.getErrorConfigVersion = R.drawable.bg_mabkc1id_vertical;
        PlaceComponentResult.PlaceComponentResult = R.drawable.bg_mabkc1id_horizontal;
        PlaceComponentResult.MyBillsEntityDataFactory = R.drawable.logo_mabkc1id;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
        PlaceComponentResult.lookAheadTest = R.color.black_text;
        return PlaceComponentResult.PlaceComponentResult();
    }
}
