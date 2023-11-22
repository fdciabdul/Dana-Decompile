package id.dana.pay.card;

import id.dana.R;
import id.dana.pay.PayCardViewItem;

/* loaded from: classes5.dex */
public class BukopinCard {
    private BukopinCard() {
    }

    public static PayCardViewItem PlaceComponentResult() {
        PayCardViewItem.Builder PlaceComponentResult = PayCardViewItem.PlaceComponentResult();
        PlaceComponentResult.getErrorConfigVersion = R.drawable.bg_bbkpc1id_vertical;
        PlaceComponentResult.PlaceComponentResult = R.drawable.bg_bbkpc1id_horizontal;
        PlaceComponentResult.MyBillsEntityDataFactory = R.drawable.logo_bbkpc1id;
        PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.expresspay_light;
        PlaceComponentResult.lookAheadTest = R.color.f27072131100488;
        return PlaceComponentResult.PlaceComponentResult();
    }
}
