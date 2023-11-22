package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.CustomDecoratedBarcodeView;
import id.dana.richview.EllipseTextView;

/* loaded from: classes8.dex */
public final class ActivityScanQrLoyaltyBinding implements ViewBinding {
    public final CustomDecoratedBarcodeView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final ImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ImageView MyBillsEntityDataFactory;
    public final ImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final RelativeLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final RelativeLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final Group PlaceComponentResult;
    public final EllipseTextView getAuthRequestContext;
    public final LinearLayout getErrorConfigVersion;
    public final RelativeLayout initRecordTimeStamp;
    public final ImageView lookAheadTest;
    public final ImageView moveToNextValue;
    public final ImageView scheduleImpl;

    private ActivityScanQrLoyaltyBinding(ConstraintLayout constraintLayout, CustomDecoratedBarcodeView customDecoratedBarcodeView, EllipseTextView ellipseTextView, Group group, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, LinearLayout linearLayout, RelativeLayout relativeLayout, RelativeLayout relativeLayout2, RelativeLayout relativeLayout3, TextView textView) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = customDecoratedBarcodeView;
        this.getAuthRequestContext = ellipseTextView;
        this.PlaceComponentResult = group;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = imageView;
        this.MyBillsEntityDataFactory = imageView2;
        this.lookAheadTest = imageView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = imageView4;
        this.scheduleImpl = imageView5;
        this.moveToNextValue = imageView6;
        this.getErrorConfigVersion = linearLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = relativeLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = relativeLayout2;
        this.initRecordTimeStamp = relativeLayout3;
        this.GetContactSyncConfig = textView;
    }

    public static ActivityScanQrLoyaltyBinding getAuthRequestContext(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_scan_qr_loyalty, (ViewGroup) null, false);
        int i = R.id.barcode_scanner;
        CustomDecoratedBarcodeView customDecoratedBarcodeView = (CustomDecoratedBarcodeView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.barcode_scanner);
        if (customDecoratedBarcodeView != null) {
            EllipseTextView ellipseTextView = (EllipseTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etv_note_scanner);
            if (ellipseTextView != null) {
                Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.group_loading_scanner);
                if (group != null) {
                    ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ic_image);
                    if (imageView != null) {
                        ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ic_image_fg);
                        if (imageView2 != null) {
                            ImageView imageView3 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.img_gallery_scan_qr);
                            if (imageView3 != null) {
                                ImageView imageView4 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.img_help_scan_qr);
                                if (imageView4 != null) {
                                    ImageView imageView5 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.img_light_scan_qr);
                                    if (imageView5 != null) {
                                        ImageView imageView6 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_scan_gallery);
                                        if (imageView6 != null) {
                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ll_scanner_tools);
                                            if (linearLayout != null) {
                                                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rl_help_scan_qr);
                                                if (relativeLayout != null) {
                                                    RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rl_light_scan_qr);
                                                    if (relativeLayout2 != null) {
                                                        RelativeLayout relativeLayout3 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rl_scan_gallery);
                                                        if (relativeLayout3 != null) {
                                                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_done_scan);
                                                            if (textView != null) {
                                                                return new ActivityScanQrLoyaltyBinding((ConstraintLayout) inflate, customDecoratedBarcodeView, ellipseTextView, group, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, linearLayout, relativeLayout, relativeLayout2, relativeLayout3, textView);
                                                            }
                                                            i = R.id.tv_done_scan;
                                                        } else {
                                                            i = R.id.rl_scan_gallery;
                                                        }
                                                    } else {
                                                        i = R.id.rl_light_scan_qr;
                                                    }
                                                } else {
                                                    i = R.id.rl_help_scan_qr;
                                                }
                                            } else {
                                                i = R.id.ll_scanner_tools;
                                            }
                                        } else {
                                            i = R.id.iv_scan_gallery;
                                        }
                                    } else {
                                        i = R.id.img_light_scan_qr;
                                    }
                                } else {
                                    i = R.id.img_help_scan_qr;
                                }
                            } else {
                                i = R.id.img_gallery_scan_qr;
                            }
                        } else {
                            i = R.id.ic_image_fg;
                        }
                    } else {
                        i = R.id.ic_image;
                    }
                } else {
                    i = R.id.group_loading_scanner;
                }
            } else {
                i = R.id.etv_note_scanner;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
