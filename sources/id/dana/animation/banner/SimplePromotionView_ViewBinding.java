package id.dana.animation.banner;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class SimplePromotionView_ViewBinding implements Unbinder {
    private SimplePromotionView getAuthRequestContext;

    public SimplePromotionView_ViewBinding(SimplePromotionView simplePromotionView, View view) {
        this.getAuthRequestContext = simplePromotionView;
        simplePromotionView.promotionImage = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.promotion_image, "field 'promotionImage'", ImageView.class);
        simplePromotionView.shimmerView = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.shimmer_view, "field 'shimmerView'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SimplePromotionView simplePromotionView = this.getAuthRequestContext;
        if (simplePromotionView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        simplePromotionView.promotionImage = null;
        simplePromotionView.shimmerView = null;
    }
}
