package id.dana.pay;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.scanner.ScannerFragment_ViewBinding;

/* loaded from: classes9.dex */
public final class PayScannerFragment_ViewBinding extends ScannerFragment_ViewBinding {
    private PayScannerFragment BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;

    public PayScannerFragment_ViewBinding(final PayScannerFragment payScannerFragment, View view) {
        super(payScannerFragment, view);
        this.BuiltInFictitiousFunctionClassFactory = payScannerFragment;
        payScannerFragment.tvDoneScan = (TextView) Utils.PlaceComponentResult(view, R.id.tv_done_scan, "field 'tvDoneScan'", TextView.class);
        payScannerFragment.llScannerTools = (LinearLayout) Utils.PlaceComponentResult(view, R.id.ll_scanner_tools, "field 'llScannerTools'", LinearLayout.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_flash, "method 'onIvFlashClicked'");
        payScannerFragment.ivFlash = (ImageView) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.iv_flash, "field 'ivFlash'", ImageView.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.pay.PayScannerFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                payScannerFragment.onIvFlashClicked();
            }
        });
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_gallery, "method 'onIvGalleryClicked'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.pay.PayScannerFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                payScannerFragment.onIvGalleryClicked();
            }
        });
    }

    @Override // id.dana.scanner.ScannerFragment_ViewBinding, butterknife.Unbinder
    public final void getAuthRequestContext() {
        PayScannerFragment payScannerFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (payScannerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        payScannerFragment.tvDoneScan = null;
        payScannerFragment.llScannerTools = null;
        payScannerFragment.ivFlash = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        super.getAuthRequestContext();
    }
}
