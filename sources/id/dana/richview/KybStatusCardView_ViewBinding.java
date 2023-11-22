package id.dana.richview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class KybStatusCardView_ViewBinding implements Unbinder {
    private KybStatusCardView getAuthRequestContext;

    public KybStatusCardView_ViewBinding(KybStatusCardView kybStatusCardView, View view) {
        this.getAuthRequestContext = kybStatusCardView;
        kybStatusCardView.dot = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dot, "field 'dot'", ImageView.class);
        kybStatusCardView.icKyb = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.ic_image, "field 'icKyb'", ImageView.class);
        kybStatusCardView.kybImageArrow = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.kyb_image_arrow, "field 'kybImageArrow'", ImageView.class);
        kybStatusCardView.labelKybStatus = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.kyb_status_label, "field 'labelKybStatus'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        KybStatusCardView kybStatusCardView = this.getAuthRequestContext;
        if (kybStatusCardView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        kybStatusCardView.dot = null;
        kybStatusCardView.icKyb = null;
        kybStatusCardView.kybImageArrow = null;
        kybStatusCardView.labelKybStatus = null;
    }
}
