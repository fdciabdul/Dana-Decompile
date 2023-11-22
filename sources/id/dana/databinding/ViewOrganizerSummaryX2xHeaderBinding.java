package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ViewOrganizerSummaryX2xHeaderBinding implements ViewBinding {
    public final ShapeableImageView BuiltInFictitiousFunctionClassFactory;
    public final ShapeableImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Guideline MyBillsEntityDataFactory;
    public final ShapeableImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final ImageView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    private final ConstraintLayout moveToNextValue;
    public final TextView scheduleImpl;

    private ViewOrganizerSummaryX2xHeaderBinding(ConstraintLayout constraintLayout, Guideline guideline, ImageView imageView, ImageView imageView2, ShapeableImageView shapeableImageView, ShapeableImageView shapeableImageView2, ShapeableImageView shapeableImageView3, TextView textView, TextView textView2, TextView textView3) {
        this.moveToNextValue = constraintLayout;
        this.MyBillsEntityDataFactory = guideline;
        this.getAuthRequestContext = imageView;
        this.PlaceComponentResult = imageView2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shapeableImageView;
        this.BuiltInFictitiousFunctionClassFactory = shapeableImageView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = shapeableImageView3;
        this.lookAheadTest = textView;
        this.getErrorConfigVersion = textView2;
        this.scheduleImpl = textView3;
    }

    public static ViewOrganizerSummaryX2xHeaderBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_organizer_summary_x2x_header, (ViewGroup) null, false);
        int i = R.id.gCenter;
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.gCenter);
        if (guideline != null) {
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivArrow);
            if (imageView != null) {
                ImageView imageView2 = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivHeaderBackground);
                if (imageView2 != null) {
                    ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivPaymentType);
                    if (shapeableImageView != null) {
                        ShapeableImageView shapeableImageView2 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivSummaryMember);
                        if (shapeableImageView2 != null) {
                            ShapeableImageView shapeableImageView3 = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivSummaryReceiver);
                            if (shapeableImageView3 != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvPaymentType);
                                if (textView != null) {
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSummaryMemberName);
                                    if (textView2 != null) {
                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSummaryReceiverName);
                                        if (textView3 != null) {
                                            return new ViewOrganizerSummaryX2xHeaderBinding((ConstraintLayout) inflate, guideline, imageView, imageView2, shapeableImageView, shapeableImageView2, shapeableImageView3, textView, textView2, textView3);
                                        }
                                        i = R.id.tvSummaryReceiverName;
                                    } else {
                                        i = R.id.tvSummaryMemberName;
                                    }
                                } else {
                                    i = R.id.tvPaymentType;
                                }
                            } else {
                                i = R.id.ivSummaryReceiver;
                            }
                        } else {
                            i = R.id.ivSummaryMember;
                        }
                    } else {
                        i = R.id.ivPaymentType;
                    }
                } else {
                    i = R.id.ivHeaderBackground;
                }
            } else {
                i = R.id.ivArrow;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
