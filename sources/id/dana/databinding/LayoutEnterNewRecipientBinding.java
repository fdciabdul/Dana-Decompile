package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.richview.SearchView;

/* loaded from: classes4.dex */
public final class LayoutEnterNewRecipientBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final Group KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatImageView PlaceComponentResult;
    public final Barrier getAuthRequestContext;
    public final SearchView getErrorConfigVersion;
    public final View lookAheadTest;
    public final TextView moveToNextValue;
    private final ConstraintLayout scheduleImpl;

    private LayoutEnterNewRecipientBinding(ConstraintLayout constraintLayout, Barrier barrier, Group group, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, View view, TextView textView, TextView textView2, SearchView searchView) {
        this.scheduleImpl = constraintLayout;
        this.getAuthRequestContext = barrier;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = group;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.PlaceComponentResult = appCompatImageView2;
        this.MyBillsEntityDataFactory = appCompatImageView3;
        this.lookAheadTest = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.moveToNextValue = textView2;
        this.getErrorConfigVersion = searchView;
    }

    public static LayoutEnterNewRecipientBinding BuiltInFictitiousFunctionClassFactory(View view) {
        int i = R.id.barrier3;
        Barrier barrier = (Barrier) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.barrier3);
        if (barrier != null) {
            Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.groupNewRecipient);
            if (group != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivDisplayPhoto);
                if (appCompatImageView != null) {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a0a2f_securitysettingsactivity_createpinlauncher_2_1);
                    if (appCompatImageView2 != null) {
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivScan);
                        if (appCompatImageView3 != null) {
                            View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.separator);
                            if (BuiltInFictitiousFunctionClassFactory != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvCancel);
                                if (textView != null) {
                                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvEnterNew);
                                    if (textView2 != null) {
                                        SearchView searchView = (SearchView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.parseLineAndAppendValue);
                                        if (searchView != null) {
                                            return new LayoutEnterNewRecipientBinding((ConstraintLayout) view, barrier, group, appCompatImageView, appCompatImageView2, appCompatImageView3, BuiltInFictitiousFunctionClassFactory, textView, textView2, searchView);
                                        }
                                        i = R.id.parseLineAndAppendValue;
                                    } else {
                                        i = R.id.tvEnterNew;
                                    }
                                } else {
                                    i = R.id.tvCancel;
                                }
                            } else {
                                i = R.id.separator;
                            }
                        } else {
                            i = R.id.ivScan;
                        }
                    } else {
                        i = R.id.res_0x7f0a0a2f_securitysettingsactivity_createpinlauncher_2_1;
                    }
                } else {
                    i = R.id.ivDisplayPhoto;
                }
            } else {
                i = R.id.groupNewRecipient;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
