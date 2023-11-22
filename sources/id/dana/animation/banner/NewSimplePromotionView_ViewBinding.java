package id.dana.animation.banner;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class NewSimplePromotionView_ViewBinding implements Unbinder {
    private NewSimplePromotionView MyBillsEntityDataFactory;

    public NewSimplePromotionView_ViewBinding(NewSimplePromotionView newSimplePromotionView, View view) {
        this.MyBillsEntityDataFactory = newSimplePromotionView;
        newSimplePromotionView.promotionImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.promotion_image, "field 'promotionImage'", ImageView.class);
        newSimplePromotionView.shimmerView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.shimmer_view, "field 'shimmerView'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        NewSimplePromotionView newSimplePromotionView = this.MyBillsEntityDataFactory;
        if (newSimplePromotionView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        newSimplePromotionView.promotionImage = null;
        newSimplePromotionView.shimmerView = null;
    }
}
