package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;

/* loaded from: classes4.dex */
public final class LayoutSenderViewBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    private final ConstraintLayout DatabaseTableConfigUtil;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Group MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Group PlaceComponentResult;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private LayoutSenderViewBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, Group group2, TextView textView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4) {
        this.DatabaseTableConfigUtil = constraintLayout;
        this.getAuthRequestContext = constraintLayout2;
        this.PlaceComponentResult = group;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.MyBillsEntityDataFactory = group2;
        this.getErrorConfigVersion = textView;
        this.moveToNextValue = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView3;
        this.scheduleImpl = appCompatTextView4;
    }

    public static LayoutSenderViewBinding getAuthRequestContext(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = R.id.existingRecipientGroup;
        Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.existingRecipientGroup);
        if (group != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0994_flowablekt_toiterable_1);
            if (appCompatImageView != null) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.applyTrimPathIfNeeded_res_0x7f0a0a24);
                if (appCompatImageView2 != null) {
                    Group group2 = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.newRecipientGroup);
                    if (group2 != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNewBadge);
                        if (textView != null) {
                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNewRecipientSubtitle);
                            if (appCompatTextView != null) {
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNewRecipientTitle);
                                if (appCompatTextView2 != null) {
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvRecipientSubtitle);
                                    if (appCompatTextView3 != null) {
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvRecipientTitle);
                                        if (appCompatTextView4 != null) {
                                            return new LayoutSenderViewBinding(constraintLayout, constraintLayout, group, appCompatImageView, appCompatImageView2, group2, textView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4);
                                        }
                                        i = R.id.tvRecipientTitle;
                                    } else {
                                        i = R.id.tvRecipientSubtitle;
                                    }
                                } else {
                                    i = R.id.tvNewRecipientTitle;
                                }
                            } else {
                                i = R.id.tvNewRecipientSubtitle;
                            }
                        } else {
                            i = R.id.tvNewBadge;
                        }
                    } else {
                        i = R.id.newRecipientGroup;
                    }
                } else {
                    i = R.id.applyTrimPathIfNeeded_res_0x7f0a0a24;
                }
            } else {
                i = R.id.res_0x7f0a0994_flowablekt_toiterable_1;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.DatabaseTableConfigUtil;
    }
}
