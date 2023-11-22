package id.dana.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.cellcomponent.DanaCellLeftView;
import id.dana.component.dividercomponent.DanaDividerView;

/* loaded from: classes4.dex */
public final class ViewBottomSheetManageBankAccountBinding implements ViewBinding {
    public final DanaCellLeftView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaCellLeftView MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final DanaCellLeftView PlaceComponentResult;
    public final DanaCellLeftView getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final AppCompatImageView lookAheadTest;
    public final DanaDividerView moveToNextValue;
    public final ConstraintLayout scheduleImpl;

    private ViewBottomSheetManageBankAccountBinding(ConstraintLayout constraintLayout, DanaCellLeftView danaCellLeftView, DanaCellLeftView danaCellLeftView2, DanaCellLeftView danaCellLeftView3, DanaCellLeftView danaCellLeftView4, ConstraintLayout constraintLayout2, DanaDividerView danaDividerView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
        this.scheduleImpl = constraintLayout;
        this.MyBillsEntityDataFactory = danaCellLeftView;
        this.PlaceComponentResult = danaCellLeftView2;
        this.BuiltInFictitiousFunctionClassFactory = danaCellLeftView3;
        this.getAuthRequestContext = danaCellLeftView4;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.moveToNextValue = danaDividerView;
        this.lookAheadTest = appCompatImageView;
        this.getErrorConfigVersion = textView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = textView3;
        this.DatabaseTableConfigUtil = textView4;
    }

    public static ViewBottomSheetManageBankAccountBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.res_0x7f0a02c2_networkuserentitydata_externalsyntheticlambda6;
        DanaCellLeftView danaCellLeftView = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a02c2_networkuserentitydata_externalsyntheticlambda6);
        if (danaCellLeftView != null) {
            DanaCellLeftView danaCellLeftView2 = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a02c3);
            if (danaCellLeftView2 != null) {
                DanaCellLeftView danaCellLeftView3 = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cellRenameBankAccount);
                if (danaCellLeftView3 != null) {
                    DanaCellLeftView danaCellLeftView4 = (DanaCellLeftView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cellUnFavoriteAction);
                    if (danaCellLeftView4 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.clHeaderGrouping);
                        if (constraintLayout != null) {
                            DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.divider);
                            if (danaDividerView != null) {
                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivCloseSheetManage);
                                if (appCompatImageView != null) {
                                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvAccountNumber);
                                    if (textView != null) {
                                        TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.res_0x7f0a13c0_fontscontractcompat_fontrequestcallback);
                                        if (textView2 != null) {
                                            TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvSeparator);
                                            if (textView3 != null) {
                                                TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvTitleManageSheet);
                                                if (textView4 != null) {
                                                    return new ViewBottomSheetManageBankAccountBinding((ConstraintLayout) view, danaCellLeftView, danaCellLeftView2, danaCellLeftView3, danaCellLeftView4, constraintLayout, danaDividerView, appCompatImageView, textView, textView2, textView3, textView4);
                                                }
                                                i = R.id.tvTitleManageSheet;
                                            } else {
                                                i = R.id.tvSeparator;
                                            }
                                        } else {
                                            i = R.id.res_0x7f0a13c0_fontscontractcompat_fontrequestcallback;
                                        }
                                    } else {
                                        i = R.id.tvAccountNumber;
                                    }
                                } else {
                                    i = R.id.ivCloseSheetManage;
                                }
                            } else {
                                i = R.id.divider;
                            }
                        } else {
                            i = R.id.clHeaderGrouping;
                        }
                    } else {
                        i = R.id.cellUnFavoriteAction;
                    }
                } else {
                    i = R.id.cellRenameBankAccount;
                }
            } else {
                i = R.id.FragmentBottomSheetPaymentSettingBinding_res_0x7f0a02c3;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
