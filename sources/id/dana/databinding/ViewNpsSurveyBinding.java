package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.cashier.view.DiscreteSurveySlider;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;

/* loaded from: classes4.dex */
public final class ViewNpsSurveyBinding implements ViewBinding {
    public final ChipGroup BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final DiscreteSurveySlider KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final TextInputEditText PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final LinearLayout getErrorConfigVersion;
    public final TextView lookAheadTest;
    public final TextInputLayout moveToNextValue;
    public final LinearLayout scheduleImpl;

    private ViewNpsSurveyBinding(ConstraintLayout constraintLayout, DanaButtonPrimaryView danaButtonPrimaryView, ChipGroup chipGroup, ConstraintLayout constraintLayout2, DiscreteSurveySlider discreteSurveySlider, TextInputEditText textInputEditText, AppCompatImageView appCompatImageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextInputLayout textInputLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintLayout;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.BuiltInFictitiousFunctionClassFactory = chipGroup;
        this.MyBillsEntityDataFactory = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = discreteSurveySlider;
        this.PlaceComponentResult = textInputEditText;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView;
        this.scheduleImpl = linearLayout;
        this.getErrorConfigVersion = linearLayout2;
        this.moveToNextValue = textInputLayout;
        this.lookAheadTest = textView;
        this.GetContactSyncConfig = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView3;
        this.DatabaseTableConfigUtil = textView4;
    }

    public static ViewNpsSurveyBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_nps_survey, (ViewGroup) null, false);
        int i = R.id.f3496btnSubmitSurvey;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3496btnSubmitSurvey);
        if (danaButtonPrimaryView != null) {
            ChipGroup chipGroup = (ChipGroup) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cgTagSelection);
            if (chipGroup != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.clTagSelection);
                if (constraintLayout != null) {
                    DiscreteSurveySlider discreteSurveySlider = (DiscreteSurveySlider) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3744setRightEdgeEffectColor_res_0x7f0a063b);
                    if (discreteSurveySlider != null) {
                        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.etSuggestionSurvey);
                        if (textInputEditText != null) {
                            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivSuccessLogo);
                            if (appCompatImageView != null) {
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llSubmitSuccess);
                                if (linearLayout != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llSurveyAction);
                                    if (linearLayout2 != null) {
                                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tilSuggestionSurvey);
                                        if (textInputLayout != null) {
                                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvHeadTitle);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvSuccessSubmit);
                                                if (textView2 != null) {
                                                    TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTagSelectionQuestionTitle);
                                                    if (textView3 != null) {
                                                        TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvTitleQuestion);
                                                        if (textView4 != null) {
                                                            return new ViewNpsSurveyBinding((ConstraintLayout) inflate, danaButtonPrimaryView, chipGroup, constraintLayout, discreteSurveySlider, textInputEditText, appCompatImageView, linearLayout, linearLayout2, textInputLayout, textView, textView2, textView3, textView4);
                                                        }
                                                        i = R.id.tvTitleQuestion;
                                                    } else {
                                                        i = R.id.tvTagSelectionQuestionTitle;
                                                    }
                                                } else {
                                                    i = R.id.tvSuccessSubmit;
                                                }
                                            } else {
                                                i = R.id.tvHeadTitle;
                                            }
                                        } else {
                                            i = R.id.tilSuggestionSurvey;
                                        }
                                    } else {
                                        i = R.id.llSurveyAction;
                                    }
                                } else {
                                    i = R.id.llSubmitSuccess;
                                }
                            } else {
                                i = R.id.ivSuccessLogo;
                            }
                        } else {
                            i = R.id.etSuggestionSurvey;
                        }
                    } else {
                        i = R.id.f3744setRightEdgeEffectColor_res_0x7f0a063b;
                    }
                } else {
                    i = R.id.clTagSelection;
                }
            } else {
                i = R.id.cgTagSelection;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
