package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewholderFriendSearchItemBinding implements ViewBinding {
    public final DanaButtonSecondaryView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final DanaButtonPrimaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Barrier PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    public final ShapeableImageView getErrorConfigVersion;
    private final ConstraintLayout initRecordTimeStamp;
    public final ConstraintLayout lookAheadTest;
    public final TextView moveToNextValue;
    public final CircularProgressIndicator scheduleImpl;

    private ViewholderFriendSearchItemBinding(ConstraintLayout constraintLayout, Barrier barrier, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonPrimaryView danaButtonPrimaryView2, DanaButtonSecondaryView danaButtonSecondaryView, DanaButtonSecondaryView danaButtonSecondaryView2, ShapeableImageView shapeableImageView, ConstraintLayout constraintLayout2, View view, CircularProgressIndicator circularProgressIndicator, TextView textView, TextView textView2) {
        this.initRecordTimeStamp = constraintLayout;
        this.PlaceComponentResult = barrier;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonPrimaryView2;
        this.BuiltInFictitiousFunctionClassFactory = danaButtonSecondaryView;
        this.getAuthRequestContext = danaButtonSecondaryView2;
        this.getErrorConfigVersion = shapeableImageView;
        this.lookAheadTest = constraintLayout2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = view;
        this.scheduleImpl = circularProgressIndicator;
        this.moveToNextValue = textView;
        this.DatabaseTableConfigUtil = textView2;
    }

    public static ViewholderFriendSearchItemBinding PlaceComponentResult(View view) {
        int i = R.id.barrierButton;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.barrierButton);
        if (barrier != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnAdd);
            if (danaButtonPrimaryView != null) {
                DanaButtonPrimaryView danaButtonPrimaryView2 = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnApprove);
                if (danaButtonPrimaryView2 != null) {
                    DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnCancel);
                    if (danaButtonSecondaryView != null) {
                        DanaButtonSecondaryView danaButtonSecondaryView2 = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnDecline);
                        if (danaButtonSecondaryView2 != null) {
                            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3568civProfileAvatar);
                            if (shapeableImageView != null) {
                                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider);
                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                    CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4033lpvLoading);
                                    if (circularProgressIndicator != null) {
                                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvName);
                                        if (textView != null) {
                                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvUsername);
                                            if (textView2 != null) {
                                                return new ViewholderFriendSearchItemBinding(constraintLayout, barrier, danaButtonPrimaryView, danaButtonPrimaryView2, danaButtonSecondaryView, danaButtonSecondaryView2, shapeableImageView, constraintLayout, BuiltInFictitiousFunctionClassFactory, circularProgressIndicator, textView, textView2);
                                            }
                                            i = R.id.tvUsername;
                                        } else {
                                            i = R.id.tvName;
                                        }
                                    } else {
                                        i = R.id.f4033lpvLoading;
                                    }
                                } else {
                                    i = R.id.divider;
                                }
                            } else {
                                i = R.id.f3568civProfileAvatar;
                            }
                        } else {
                            i = R.id.btnDecline;
                        }
                    } else {
                        i = R.id.btnCancel;
                    }
                } else {
                    i = R.id.btnApprove;
                }
            } else {
                i = R.id.btnAdd;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.initRecordTimeStamp;
    }
}
