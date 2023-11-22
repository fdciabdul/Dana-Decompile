package id.dana.myprofile;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.QRView;

/* loaded from: classes9.dex */
public class ShareQrDialog_ViewBinding implements Unbinder {
    private View BuiltInFictitiousFunctionClassFactory;
    private ShareQrDialog KClassImpl$Data$declaredNonStaticMembers$2;
    private View getAuthRequestContext;

    public ShareQrDialog_ViewBinding(final ShareQrDialog shareQrDialog, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shareQrDialog;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.button_share, "field 'buttonShare' and method 'onShareButtonClick'");
        shareQrDialog.buttonShare = (Button) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.button_share, "field 'buttonShare'", Button.class);
        this.BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.ShareQrDialog_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                shareQrDialog.onShareButtonClick(view2);
            }
        });
        shareQrDialog.ivDanaLogo = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dana_logo_request_dana, "field 'ivDanaLogo'", ImageView.class);
        shareQrDialog.layoutFooter = (LinearLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.static_qr_footer, "field 'layoutFooter'", LinearLayout.class);
        shareQrDialog.layoutQr = (QRView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.layout_qr, "field 'layoutQr'", QRView.class);
        shareQrDialog.nsvStaticQr = (NestedScrollView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.nsv_static_qr, "field 'nsvStaticQr'", NestedScrollView.class);
        shareQrDialog.tvNote = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.request_dana_note, "field 'tvNote'", TextView.class);
        shareQrDialog.tvQrTitle = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.view_title, "field 'tvQrTitle'", TextView.class);
        shareQrDialog.tvUserIDStatic = (TextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.f4537tv_userid_static, "field 'tvUserIDStatic'", TextView.class);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.f3668cl_main_qr_profile, "method 'onParentClick'");
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.myprofile.ShareQrDialog_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                shareQrDialog.onParentClick(view2);
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        ShareQrDialog shareQrDialog = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (shareQrDialog == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        shareQrDialog.buttonShare = null;
        shareQrDialog.ivDanaLogo = null;
        shareQrDialog.layoutFooter = null;
        shareQrDialog.layoutQr = null;
        shareQrDialog.nsvStaticQr = null;
        shareQrDialog.tvNote = null;
        shareQrDialog.tvQrTitle = null;
        shareQrDialog.tvUserIDStatic = null;
        this.BuiltInFictitiousFunctionClassFactory.setOnClickListener(null);
        this.BuiltInFictitiousFunctionClassFactory = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
    }
}
