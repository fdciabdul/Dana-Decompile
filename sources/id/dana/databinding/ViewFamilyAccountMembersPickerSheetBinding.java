package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.richview.SearchView;
import id.dana.richview.contactselector.ContactSelectorView;

/* loaded from: classes4.dex */
public final class ViewFamilyAccountMembersPickerSheetBinding implements ViewBinding {
    public final LinearLayout BuiltInFictitiousFunctionClassFactory;
    public final DanaButtonSecondaryView KClassImpl$Data$declaredNonStaticMembers$2;
    public final CardView MyBillsEntityDataFactory;
    public final SearchView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CoordinatorLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final ContactSelectorView lookAheadTest;
    private final CoordinatorLayout moveToNextValue;
    public final TextView scheduleImpl;

    private ViewFamilyAccountMembersPickerSheetBinding(CoordinatorLayout coordinatorLayout, DanaButtonSecondaryView danaButtonSecondaryView, CoordinatorLayout coordinatorLayout2, CardView cardView, AppCompatImageView appCompatImageView, LinearLayout linearLayout, TextView textView, TextView textView2, ContactSelectorView contactSelectorView, SearchView searchView) {
        this.moveToNextValue = coordinatorLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = danaButtonSecondaryView;
        this.PlaceComponentResult = coordinatorLayout2;
        this.MyBillsEntityDataFactory = cardView;
        this.getAuthRequestContext = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = linearLayout;
        this.getErrorConfigVersion = textView;
        this.scheduleImpl = textView2;
        this.lookAheadTest = contactSelectorView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = searchView;
    }

    public static ViewFamilyAccountMembersPickerSheetBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_family_account_members_picker_sheet, (ViewGroup) null, false);
        int i = R.id.btnCancel;
        DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btnCancel);
        if (danaButtonSecondaryView != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            CardView cardView = (CardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cvPayerSelection);
            if (cardView != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ivScanInvite);
                if (appCompatImageView != null) {
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llBtnContainer);
                    if (linearLayout != null) {
                        TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvBillPayerHeaderMsg);
                        if (textView != null) {
                            TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvCancel);
                            if (textView2 != null) {
                                ContactSelectorView contactSelectorView = (ContactSelectorView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewContactSelector);
                                if (contactSelectorView != null) {
                                    SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.parseLineAndAppendValue);
                                    if (searchView != null) {
                                        return new ViewFamilyAccountMembersPickerSheetBinding(coordinatorLayout, danaButtonSecondaryView, coordinatorLayout, cardView, appCompatImageView, linearLayout, textView, textView2, contactSelectorView, searchView);
                                    }
                                    i = R.id.parseLineAndAppendValue;
                                } else {
                                    i = R.id.viewContactSelector;
                                }
                            } else {
                                i = R.id.tvCancel;
                            }
                        } else {
                            i = R.id.tvBillPayerHeaderMsg;
                        }
                    } else {
                        i = R.id.llBtnContainer;
                    }
                } else {
                    i = R.id.ivScanInvite;
                }
            } else {
                i = R.id.cvPayerSelection;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.moveToNextValue;
    }
}
