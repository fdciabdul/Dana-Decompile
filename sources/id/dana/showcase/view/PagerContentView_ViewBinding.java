package id.dana.showcase.view;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.popup.LockableViewPager;

/* loaded from: classes9.dex */
public class PagerContentView_ViewBinding implements Unbinder {
    private PagerContentView MyBillsEntityDataFactory;

    public PagerContentView_ViewBinding(PagerContentView pagerContentView, View view) {
        this.MyBillsEntityDataFactory = pagerContentView;
        pagerContentView.ivClose = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.RecurringAnnouncementEntity, "field 'ivClose'", ImageView.class);
        pagerContentView.viewPager = (LockableViewPager) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_pager, "field 'viewPager'", LockableViewPager.class);
        pagerContentView.btnLeft = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_left, "field 'btnLeft'", Button.class);
        pagerContentView.btnRight = (Button) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.btn_right, "field 'btnRight'", Button.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        PagerContentView pagerContentView = this.MyBillsEntityDataFactory;
        if (pagerContentView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        pagerContentView.ivClose = null;
        pagerContentView.viewPager = null;
        pagerContentView.btnLeft = null;
        pagerContentView.btnRight = null;
    }
}
