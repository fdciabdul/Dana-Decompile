package id.dana.databinding;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputLayout;
import id.dana.R;
import id.dana.component.edittextcomponent.DanaEditTextView;
import id.dana.richview.CircleImageSelectionView;

/* loaded from: classes4.dex */
public final class FamilyQuestionerViewBinding implements ViewBinding {
    public final CircleImageSelectionView BuiltInFictitiousFunctionClassFactory;
    public final View DatabaseTableConfigUtil;
    public final TextView GetContactSyncConfig;
    public final DanaEditTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ConstraintLayout MyBillsEntityDataFactory;
    public final Spinner NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda7;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final Spinner getErrorConfigVersion;
    public final View initRecordTimeStamp;
    public final View isLayoutRequested;
    public final TextView lookAheadTest;
    public final TextInputLayout moveToNextValue;
    public final TextView scheduleImpl;

    private FamilyQuestionerViewBinding(ConstraintLayout constraintLayout, CircleImageSelectionView circleImageSelectionView, ConstraintLayout constraintLayout2, DanaEditTextView danaEditTextView, AppCompatImageView appCompatImageView, Spinner spinner, Spinner spinner2, TextInputLayout textInputLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view, View view2, View view3, View view4) {
        this.MyBillsEntityDataFactory = constraintLayout;
        this.BuiltInFictitiousFunctionClassFactory = circleImageSelectionView;
        this.PlaceComponentResult = constraintLayout2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaEditTextView;
        this.getAuthRequestContext = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = spinner;
        this.getErrorConfigVersion = spinner2;
        this.moveToNextValue = textInputLayout;
        this.lookAheadTest = textView;
        this.scheduleImpl = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView4;
        this.GetContactSyncConfig = textView5;
        this.DatabaseTableConfigUtil = view;
        this.initRecordTimeStamp = view2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = view3;
        this.isLayoutRequested = view4;
    }

    public static FamilyQuestionerViewBinding PlaceComponentResult(View view) {
        CircleImageSelectionView circleImageSelectionView = (CircleImageSelectionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cisvDisplayPhoto);
        int i = R.id.etOther;
        if (circleImageSelectionView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clAvailableServices);
            if (constraintLayout != null) {
                DanaEditTextView danaEditTextView = (DanaEditTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.etOther);
                if (danaEditTextView != null) {
                    AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivClose);
                    if (appCompatImageView != null) {
                        Spinner spinner = (Spinner) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.spinnerAddress);
                        if (spinner != null) {
                            Spinner spinner2 = (Spinner) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.spinnerRelation);
                            if (spinner2 != null) {
                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tilEtOther);
                                if (textInputLayout != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAddress);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAvailableServices);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvName);
                                            if (textView3 != null) {
                                                TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvNumber);
                                                if (textView4 != null) {
                                                    TextView textView5 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvRelation);
                                                    if (textView5 != null) {
                                                        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDivider);
                                                        if (BuiltInFictitiousFunctionClassFactory != null) {
                                                            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDivider2);
                                                            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                                View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDivider3);
                                                                if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                                    View BuiltInFictitiousFunctionClassFactory4 = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.viewDivider4);
                                                                    if (BuiltInFictitiousFunctionClassFactory4 != null) {
                                                                        return new FamilyQuestionerViewBinding((ConstraintLayout) view, circleImageSelectionView, constraintLayout, danaEditTextView, appCompatImageView, spinner, spinner2, textInputLayout, textView, textView2, textView3, textView4, textView5, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3, BuiltInFictitiousFunctionClassFactory4);
                                                                    }
                                                                    i = R.id.viewDivider4;
                                                                } else {
                                                                    i = R.id.viewDivider3;
                                                                }
                                                            } else {
                                                                i = R.id.viewDivider2;
                                                            }
                                                        } else {
                                                            i = R.id.viewDivider;
                                                        }
                                                    } else {
                                                        i = R.id.tvRelation;
                                                    }
                                                } else {
                                                    i = R.id.tvNumber;
                                                }
                                            } else {
                                                i = R.id.tvName;
                                            }
                                        } else {
                                            i = R.id.tvAvailableServices;
                                        }
                                    } else {
                                        i = R.id.tvAddress;
                                    }
                                } else {
                                    i = R.id.tilEtOther;
                                }
                            } else {
                                i = R.id.spinnerRelation;
                            }
                        } else {
                            i = R.id.spinnerAddress;
                        }
                    } else {
                        i = R.id.ivClose;
                    }
                }
            } else {
                i = R.id.clAvailableServices;
            }
        } else {
            i = R.id.cisvDisplayPhoto;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.MyBillsEntityDataFactory;
    }
}
