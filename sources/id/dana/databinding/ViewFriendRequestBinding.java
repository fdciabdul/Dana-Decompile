package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewFriendRequestBinding implements ViewBinding {
    public final Group BuiltInFictitiousFunctionClassFactory;
    public final ShapeableImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CircularProgressIndicator MyBillsEntityDataFactory;
    public final DanaButtonPrimaryView PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    private final ConstraintLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView scheduleImpl;

    private ViewFriendRequestBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, ShapeableImageView shapeableImageView, Group group, CircularProgressIndicator circularProgressIndicator, TextView textView, TextView textView2) {
        this.getErrorConfigVersion = constraintLayout;
        this.PlaceComponentResult = danaButtonPrimaryView;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = shapeableImageView;
        this.BuiltInFictitiousFunctionClassFactory = group;
        this.MyBillsEntityDataFactory = circularProgressIndicator;
        this.lookAheadTest = textView;
        this.scheduleImpl = textView2;
    }

    public static ViewFriendRequestBinding MyBillsEntityDataFactory(View view) {
        int i = R.id.btnApprove;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnApprove);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btnDecline);
            if (danaButtonSecondaryView != null) {
                ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f3568civProfileAvatar);
                if (shapeableImageView != null) {
                    Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.groupButtons);
                    if (group != null) {
                        CircularProgressIndicator circularProgressIndicator = (CircularProgressIndicator) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.f4033lpvLoading);
                        if (circularProgressIndicator != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvDate);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvName);
                                if (textView2 != null) {
                                    return new ViewFriendRequestBinding((ConstraintLayout) view, danaButtonPrimaryView, danaButtonSecondaryView, shapeableImageView, group, circularProgressIndicator, textView, textView2);
                                }
                                i = R.id.tvName;
                            } else {
                                i = R.id.tvDate;
                            }
                        } else {
                            i = R.id.f4033lpvLoading;
                        }
                    } else {
                        i = R.id.groupButtons;
                    }
                } else {
                    i = R.id.f3568civProfileAvatar;
                }
            } else {
                i = R.id.btnDecline;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.getErrorConfigVersion;
    }
}
