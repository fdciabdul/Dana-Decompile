package id.dana.animation;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class SlidingBannerAdapter_ViewBinding implements Unbinder {
    private SlidingBannerAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    public SlidingBannerAdapter_ViewBinding(SlidingBannerAdapter slidingBannerAdapter, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = slidingBannerAdapter;
        slidingBannerAdapter.ivPromotion = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.imagePromotion, "field 'ivPromotion'", ImageView.class);
        slidingBannerAdapter.lParent = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.layout_parent, "field 'lParent'", RelativeLayout.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SlidingBannerAdapter slidingBannerAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (slidingBannerAdapter == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        slidingBannerAdapter.ivPromotion = null;
        slidingBannerAdapter.lParent = null;
    }
}
