package id.dana.scanner;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.Group;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;
import id.dana.richview.EllipseTextView;

/* loaded from: classes9.dex */
public class ScannerFragment_ViewBinding implements Unbinder {
    private ScannerFragment BuiltInFictitiousFunctionClassFactory;
    private View KClassImpl$Data$declaredNonStaticMembers$2;
    private View MyBillsEntityDataFactory;
    private View NetworkUserEntityData$$ExternalSyntheticLambda0;
    private View getAuthRequestContext;

    public ScannerFragment_ViewBinding(final ScannerFragment scannerFragment, View view) {
        this.BuiltInFictitiousFunctionClassFactory = scannerFragment;
        scannerFragment.icImageFg = (ImageView) Utils.PlaceComponentResult(view, R.id.ic_image_fg, "field 'icImageFg'", ImageView.class);
        scannerFragment.imgScanGallery = (ImageView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.iv_scan_gallery, "field 'imgScanGallery'", ImageView.class);
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_scan_gallery, "field 'rlScanGallery' and method 'openGallery'");
        scannerFragment.rlScanGallery = (RelativeLayout) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.rl_scan_gallery, "field 'rlScanGallery'", RelativeLayout.class);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.scanner.ScannerFragment_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                scannerFragment.openGallery();
            }
        });
        scannerFragment.rlScanner = (Group) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.group_loading_scanner, "field 'rlScanner'", Group.class);
        scannerFragment.tvNoteScanner = (EllipseTextView) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.etv_note_scanner, "field 'tvNoteScanner'", EllipseTextView.class);
        View BuiltInFictitiousFunctionClassFactory2 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_help_scan_qr, "field 'rlHelpScanQr' and method 'onHelpClicked'");
        scannerFragment.rlHelpScanQr = (RelativeLayout) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory2, R.id.rl_help_scan_qr, "field 'rlHelpScanQr'", RelativeLayout.class);
        this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2;
        BuiltInFictitiousFunctionClassFactory2.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.scanner.ScannerFragment_ViewBinding.2
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                scannerFragment.onHelpClicked();
            }
        });
        scannerFragment.rlBarcodeScanner = (RelativeLayout) Utils.KClassImpl$Data$declaredNonStaticMembers$2(view, R.id.rlBarcodeScanner, "field 'rlBarcodeScanner'", RelativeLayout.class);
        View BuiltInFictitiousFunctionClassFactory3 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.rl_light_scan_qr, "method 'setTorch'");
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory3;
        BuiltInFictitiousFunctionClassFactory3.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.scanner.ScannerFragment_ViewBinding.3
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                scannerFragment.setTorch();
            }
        });
        View BuiltInFictitiousFunctionClassFactory4 = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_done_scan, "method 'doneScan'");
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = BuiltInFictitiousFunctionClassFactory4;
        BuiltInFictitiousFunctionClassFactory4.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.scanner.ScannerFragment_ViewBinding.4
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                scannerFragment.doneScan();
            }
        });
    }

    @Override // butterknife.Unbinder
    public void getAuthRequestContext() {
        ScannerFragment scannerFragment = this.BuiltInFictitiousFunctionClassFactory;
        if (scannerFragment == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.BuiltInFictitiousFunctionClassFactory = null;
        scannerFragment.icImageFg = null;
        scannerFragment.imgScanGallery = null;
        scannerFragment.rlScanGallery = null;
        scannerFragment.rlScanner = null;
        scannerFragment.tvNoteScanner = null;
        scannerFragment.rlHelpScanQr = null;
        scannerFragment.rlBarcodeScanner = null;
        this.KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(null);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.getAuthRequestContext.setOnClickListener(null);
        this.getAuthRequestContext = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.setOnClickListener(null);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = null;
    }
}
