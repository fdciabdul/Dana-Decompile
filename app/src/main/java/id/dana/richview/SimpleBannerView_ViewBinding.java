package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SimpleBannerView_ViewBinding implements Unbinder {
    private SimpleBannerView MyBillsEntityDataFactory;

    public SimpleBannerView_ViewBinding(SimpleBannerView simpleBannerView, View view) {
        this.MyBillsEntityDataFactory = simpleBannerView;
        simpleBannerView.imagePromotion = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.imagePromotion, "field 'imagePromotion'", ImageView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SimpleBannerView simpleBannerView = this.MyBillsEntityDataFactory;
        if (simpleBannerView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        simpleBannerView.imagePromotion = null;
    }
}
