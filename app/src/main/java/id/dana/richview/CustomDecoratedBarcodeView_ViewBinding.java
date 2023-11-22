package id.dana.richview;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import id.dana.R;

/* loaded from: classes9.dex */
public class CustomDecoratedBarcodeView_ViewBinding implements Unbinder {
    private CustomDecoratedBarcodeView MyBillsEntityDataFactory;

    public CustomDecoratedBarcodeView_ViewBinding(CustomDecoratedBarcodeView customDecoratedBarcodeView, View view) {
        this.MyBillsEntityDataFactory = customDecoratedBarcodeView;
        customDecoratedBarcodeView.decoratedBarcodeView = (DecoratedBarcodeView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.dbv_barcode_view, "field 'decoratedBarcodeView'", DecoratedBarcodeView.class);
        customDecoratedBarcodeView.cvQrisSupported = (CardView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.cv_qris_dana_supported, "field 'cvQrisSupported'", CardView.class);
        customDecoratedBarcodeView.bvBubbleStatus = (BubbleView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.bv_bubble_status, "field 'bvBubbleStatus'", BubbleView.class);
        customDecoratedBarcodeView.ivQrisLogo = (AppCompatImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_qris_logo, "field 'ivQrisLogo'", AppCompatImageView.class);
        customDecoratedBarcodeView.ivDanaCicilLogo = (AppCompatImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_dana_cicil_logo, "field 'ivDanaCicilLogo'", AppCompatImageView.class);
        customDecoratedBarcodeView.tvUseDanaCicil = (AppCompatTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.tv_use_dana_cicil, "field 'tvUseDanaCicil'", AppCompatTextView.class);
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        CustomDecoratedBarcodeView customDecoratedBarcodeView = this.MyBillsEntityDataFactory;
        if (customDecoratedBarcodeView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.MyBillsEntityDataFactory = null;
        customDecoratedBarcodeView.decoratedBarcodeView = null;
        customDecoratedBarcodeView.cvQrisSupported = null;
        customDecoratedBarcodeView.bvBubbleStatus = null;
        customDecoratedBarcodeView.ivQrisLogo = null;
        customDecoratedBarcodeView.ivDanaCicilLogo = null;
        customDecoratedBarcodeView.tvUseDanaCicil = null;
    }
}
