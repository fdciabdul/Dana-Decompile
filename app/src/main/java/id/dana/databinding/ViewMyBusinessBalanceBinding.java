package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.kyb.view.richview.KybTransactionLimitView;
import id.dana.kyb.view.richview.KybUpgradeTierSuggestionView;

/* loaded from: classes4.dex */
public final class ViewMyBusinessBalanceBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final TextView DatabaseTableConfigUtil;
    public final View GetContactSyncConfig;
    public final Group KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatTextView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final View NetworkUserEntityData$$ExternalSyntheticLambda8;
    public final AppCompatButton PlaceComponentResult;
    public final View PrepareContext;
    public final ConstraintLayout getAuthRequestContext;
    public final TextView getErrorConfigVersion;
    public final TextView initRecordTimeStamp;
    public final KybUpgradeTierSuggestionView lookAheadTest;
    public final KybTransactionLimitView moveToNextValue;
    private final ConstraintLayout newProxyInstance;
    public final AppCompatImageView scheduleImpl;

    private ViewMyBusinessBalanceBinding(ConstraintLayout constraintLayout, AppCompatTextView appCompatTextView, AppCompatButton appCompatButton, Group group, ConstraintLayout constraintLayout2, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, KybTransactionLimitView kybTransactionLimitView, KybUpgradeTierSuggestionView kybUpgradeTierSuggestionView, RecyclerView recyclerView, TextView textView, TextView textView2, AppCompatTextView appCompatTextView2, TextView textView3, TextView textView4, View view, View view2, View view3) {
        this.newProxyInstance = constraintLayout;
        this.MyBillsEntityDataFactory = appCompatTextView;
        this.PlaceComponentResult = appCompatButton;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = group;
        this.getAuthRequestContext = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.scheduleImpl = appCompatImageView2;
        this.moveToNextValue = kybTransactionLimitView;
        this.lookAheadTest = kybUpgradeTierSuggestionView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.getErrorConfigVersion = textView;
        this.DatabaseTableConfigUtil = textView2;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = appCompatTextView2;
        this.initRecordTimeStamp = textView3;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = textView4;
        this.GetContactSyncConfig = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = view2;
        this.PrepareContext = view3;
    }

    public static ViewMyBusinessBalanceBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_my_business_balance, (ViewGroup) null, false);
        AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.appCompatTextView2);
        int i = R.id.container_withdraw_status;
        if (appCompatTextView != null) {
            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.f3540btn_withdraw);
            if (appCompatButton != null) {
                Group group = (Group) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container_expandable);
                if (group != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.container_withdraw_status);
                    if (constraintLayout != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_click_collapse_view);
                        if (appCompatImageView != null) {
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_click_information);
                            if (appCompatImageView2 != null) {
                                KybTransactionLimitView kybTransactionLimitView = (KybTransactionLimitView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.kyb_transaction_limit);
                                if (kybTransactionLimitView != null) {
                                    KybUpgradeTierSuggestionView kybUpgradeTierSuggestionView = (KybUpgradeTierSuggestionView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.kyb_upgrade_tier_suggestion);
                                    if (kybUpgradeTierSuggestionView != null) {
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rvTopService);
                                        if (recyclerView != null) {
                                            TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.textView12);
                                            if (textView != null) {
                                                TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.textView2);
                                                if (textView2 != null) {
                                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_business_balance);
                                                    if (appCompatTextView2 != null) {
                                                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_in_process);
                                                        if (textView3 != null) {
                                                            TextView textView4 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_ready_to_withdraw);
                                                            if (textView4 != null) {
                                                                View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view3);
                                                                if (BuiltInFictitiousFunctionClassFactory != null) {
                                                                    View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_withdraw_status_bottom_line);
                                                                    if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                                                        View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.view_withdraw_status_top_line);
                                                                        if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                                                            return new ViewMyBusinessBalanceBinding((ConstraintLayout) inflate, appCompatTextView, appCompatButton, group, constraintLayout, appCompatImageView, appCompatImageView2, kybTransactionLimitView, kybUpgradeTierSuggestionView, recyclerView, textView, textView2, appCompatTextView2, textView3, textView4, BuiltInFictitiousFunctionClassFactory, BuiltInFictitiousFunctionClassFactory2, BuiltInFictitiousFunctionClassFactory3);
                                                                        }
                                                                        i = R.id.view_withdraw_status_top_line;
                                                                    } else {
                                                                        i = R.id.view_withdraw_status_bottom_line;
                                                                    }
                                                                } else {
                                                                    i = R.id.view3;
                                                                }
                                                            } else {
                                                                i = R.id.tv_ready_to_withdraw;
                                                            }
                                                        } else {
                                                            i = R.id.tv_in_process;
                                                        }
                                                    } else {
                                                        i = R.id.tv_business_balance;
                                                    }
                                                } else {
                                                    i = R.id.textView2;
                                                }
                                            } else {
                                                i = R.id.textView12;
                                            }
                                        } else {
                                            i = R.id.rvTopService;
                                        }
                                    } else {
                                        i = R.id.kyb_upgrade_tier_suggestion;
                                    }
                                } else {
                                    i = R.id.kyb_transaction_limit;
                                }
                            } else {
                                i = R.id.iv_click_information;
                            }
                        } else {
                            i = R.id.iv_click_collapse_view;
                        }
                    }
                } else {
                    i = R.id.container_expandable;
                }
            } else {
                i = R.id.f3540btn_withdraw;
            }
        } else {
            i = R.id.appCompatTextView2;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.newProxyInstance;
    }
}
