package id.dana.animation.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes8.dex */
public class ZoomDialog_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private ZoomDialog getAuthRequestContext;

    public ZoomDialog_ViewBinding(final ZoomDialog zoomDialog, View view) {
        this.getAuthRequestContext = zoomDialog;
        zoomDialog.ivBarcodeZoom = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_zoom_barcode, "field 'ivBarcodeZoom'", ImageView.class);
        zoomDialog.ivLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.SendMoneyHomePresenter, "field 'ivLogo'", ImageView.class);
        zoomDialog.ivQrZoom = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_zoom_qr, "field 'ivQrZoom'", ImageView.class);
        zoomDialog.layoutBarcodeZoom = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.layout_zoom_barcode, "field 'layoutBarcodeZoom'", LinearLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_zoom, "field 'layoutParent' and method 'onParentLayoutClicked'");
        zoomDialog.layoutParent = (RelativeLayout) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.rl_zoom, "field 'layoutParent'", RelativeLayout.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.home.view.ZoomDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                zoomDialog.onParentLayoutClicked();
            }
        });
        zoomDialog.layoutQrZoom = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.layout_zoom_qr, "field 'layoutQrZoom'", RelativeLayout.class);
        zoomDialog.tvCode = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_zoom_code, "field 'tvCode'", TextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ZoomDialog zoomDialog = this.getAuthRequestContext;
        if (zoomDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        zoomDialog.ivBarcodeZoom = null;
        zoomDialog.ivLogo = null;
        zoomDialog.ivQrZoom = null;
        zoomDialog.layoutBarcodeZoom = null;
        zoomDialog.layoutParent = null;
        zoomDialog.layoutQrZoom = null;
        zoomDialog.tvCode = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
    }
}
