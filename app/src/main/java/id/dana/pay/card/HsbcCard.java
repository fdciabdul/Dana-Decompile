package id.dana.pay.card;

import id.dana.R;
import id.dana.pay.PayCardViewItem;

/* loaded from: classes5.dex */
public class HsbcCard {
    private HsbcCard() {
    }

    public static PayCardViewItem PlaceComponentResult() {
        PayCardViewItem.Builder PlaceComponentResult = PayCardViewItem.PlaceComponentResult();
        PlaceComponentResult.getErrorConfigVersion = R.drawable.bg_hsbcc1id_vertical;
        PlaceComponentResult.PlaceComponentResult = R.drawable.bg_hsbcc1id_horizontal;
        PlaceComponentResult.MyBillsEntityDataFactory = R.drawable.logo_hsbcc1id;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_dark;
        PlaceComponentResult.lookAheadTest = R.color.black_text;
        return PlaceComponentResult.PlaceComponentResult();
    }
}
