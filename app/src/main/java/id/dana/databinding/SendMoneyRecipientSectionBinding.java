package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class SendMoneyRecipientSectionBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final RelativeLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final RelativeLayout MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final RelativeLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView moveToNextValue;
    public final View scheduleImpl;

    private SendMoneyRecipientSectionBinding(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, AppCompatImageView appCompatImageView, LinearLayout linearLayout, RelativeLayout relativeLayout3, TextView textView, TextView textView2, View view) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = relativeLayout;
        this.PlaceComponentResult = relativeLayout2;
        this.getAuthRequestContext = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.MyBillsEntityDataFactory = relativeLayout3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.moveToNextValue = textView2;
        this.scheduleImpl = view;
    }

    public static SendMoneyRecipientSectionBinding BuiltInFictitiousFunctionClassFactory(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = R.id.ivChevronSor;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivChevronSor);
        if (appCompatImageView != null) {
            LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.llSortSection);
            if (linearLayout != null) {
                RelativeLayout relativeLayout2 = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rlHeaderSection);
                if (relativeLayout2 != null) {
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvHeaderTitle);
                    if (textView != null) {
                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvSortSection);
                        if (textView2 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDivider);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                return new SendMoneyRecipientSectionBinding(relativeLayout, relativeLayout, appCompatImageView, linearLayout, relativeLayout2, textView, textView2, BuiltInFictitiousFunctionClassFactory);
                            }
                            i = R.id.viewDivider;
                        } else {
                            i = R.id.tvSortSection;
                        }
                    } else {
                        i = R.id.tvHeaderTitle;
                    }
                } else {
                    i = R.id.rlHeaderSection;
                }
            } else {
                i = R.id.llSortSection;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }
}
