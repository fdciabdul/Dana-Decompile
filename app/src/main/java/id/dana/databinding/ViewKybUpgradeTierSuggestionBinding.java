package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;

/* loaded from: classes4.dex */
public final class ViewKybUpgradeTierSuggestionBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final View GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final Group MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final Group PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextView moveToNextValue;
    public final ConstraintLayout scheduleImpl;

    private ViewKybUpgradeTierSuggestionBinding(ConstraintLayout constraintLayout, DanaButtonSecondaryView danaButtonSecondaryView, Group group, Group group2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, View view) {
        this.scheduleImpl = constraintLayout;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.PlaceComponentResult = group;
        this.MyBillsEntityDataFactory = group2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView2;
        this.getErrorConfigVersion = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.lookAheadTest = textView3;
        this.moveToNextValue = textView4;
        this.GetContactSyncConfig = view;
    }

    public static ViewKybUpgradeTierSuggestionBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_kyb_upgrade_tier_suggestion, (ViewGroup) null, false);
        int i = R.id.btn_kyb_upgrade_tier;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_kyb_upgrade_tier);
        if (danaButtonSecondaryView != null) {
            Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container_high_urgency_suggestion);
            if (group != null) {
                Group group2 = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container_low_urgency_suggestion);
                if (group2 != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_low_urgency_suggestion);
                    if (appCompatImageView != null) {
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_low_urgency_suggestion_right_arrow);
                        if (appCompatImageView2 != null) {
                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_high_urgency_suggestion_body);
                            if (textView != null) {
                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_high_urgency_suggestion_title);
                                if (textView2 != null) {
                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_low_urgency_suggestion_body);
                                    if (textView3 != null) {
                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_low_urgency_suggestion_title);
                                        if (textView4 != null) {
                                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_top_line);
                                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                                return new ViewKybUpgradeTierSuggestionBinding((ConstraintLayout) inflate, danaButtonSecondaryView, group, group2, appCompatImageView, appCompatImageView2, textView, textView2, textView3, textView4, BuiltInFictitiousFunctionClassFactory);
                                            }
                                            i = R.id.view_top_line;
                                        } else {
                                            i = R.id.tv_low_urgency_suggestion_title;
                                        }
                                    } else {
                                        i = R.id.tv_low_urgency_suggestion_body;
                                    }
                                } else {
                                    i = R.id.tv_high_urgency_suggestion_title;
                                }
                            } else {
                                i = R.id.tv_high_urgency_suggestion_body;
                            }
                        } else {
                            i = R.id.iv_low_urgency_suggestion_right_arrow;
                        }
                    } else {
                        i = R.id.iv_low_urgency_suggestion;
                    }
                } else {
                    i = R.id.container_low_urgency_suggestion;
                }
            } else {
                i = R.id.container_high_urgency_suggestion;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
