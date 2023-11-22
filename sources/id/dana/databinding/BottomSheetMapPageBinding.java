package id.dana.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes8.dex */
public final class BottomSheetMapPageBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final FrameLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final AppCompatImageView PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    private final FrameLayout getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final LinearLayout moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private BottomSheetMapPageBinding(FrameLayout frameLayout, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonPrimaryView danaButtonPrimaryView, AppCompatImageView appCompatImageView, FrameLayout frameLayout2, AppCompatImageView appCompatImageView2, LinearLayout linearLayout, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.getErrorConfigVersion = frameLayout;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.PlaceComponentResult = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = frameLayout2;
        this.getAuthRequestContext = appCompatImageView2;
        this.moveToNextValue = linearLayout;
        this.scheduleImpl = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
    }

    public static BottomSheetMapPageBinding getAuthRequestContext(View view) {
        int i = R.id.btnChooseAnotherAddress;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnChooseAnotherAddress);
        if (danaButtonSecondaryView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnChooseThisLocation);
            if (danaButtonPrimaryView != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnRetry);
                if (appCompatImageView != null) {
                    FrameLayout frameLayout = (FrameLayout) view;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivPin);
                    if (appCompatImageView2 != null) {
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llMapAction);
                        if (linearLayout != null) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvStreet);
                            if (appCompatTextView != null) {
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvStreetDetail);
                                if (appCompatTextView2 != null) {
                                    return new BottomSheetMapPageBinding(frameLayout, danaButtonSecondaryView, danaButtonPrimaryView, appCompatImageView, frameLayout, appCompatImageView2, linearLayout, appCompatTextView, appCompatTextView2);
                                }
                                i = R.id.tvStreetDetail;
                            } else {
                                i = R.id.tvStreet;
                            }
                        } else {
                            i = R.id.llMapAction;
                        }
                    } else {
                        i = R.id.ivPin;
                    }
                } else {
                    i = R.id.btnRetry;
                }
            } else {
                i = R.id.btnChooseThisLocation;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
