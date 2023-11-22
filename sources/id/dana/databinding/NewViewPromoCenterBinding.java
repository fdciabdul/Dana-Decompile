package id.dana.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.buttoncomponent.DanaButtonSecondaryView;
import id.dana.promocenter.views.PromoCenterSeePromosView;

/* loaded from: classes4.dex */
public final class NewViewPromoCenterBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final RelativeLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaButtonPrimaryView MyBillsEntityDataFactory;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final LinearLayout NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final MaterialCardView PlaceComponentResult;
    public final DanaButtonSecondaryView getAuthRequestContext;
    public final PromoCenterSeePromosView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final AppCompatTextView moveToNextValue;
    public final AppCompatTextView scheduleImpl;

    private NewViewPromoCenterBinding(LinearLayout linearLayout, DanaButtonPrimaryView danaButtonPrimaryView, DanaButtonSecondaryView danaButtonSecondaryView, RelativeLayout relativeLayout, MaterialCardView materialCardView, AppCompatImageView appCompatImageView, RecyclerView recyclerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, PromoCenterSeePromosView promoCenterSeePromosView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = linearLayout;
        this.MyBillsEntityDataFactory = danaButtonPrimaryView;
        this.getAuthRequestContext = danaButtonSecondaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = relativeLayout;
        this.PlaceComponentResult = materialCardView;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerView;
        this.scheduleImpl = appCompatTextView;
        this.moveToNextValue = appCompatTextView2;
        this.lookAheadTest = appCompatTextView3;
        this.getErrorConfigVersion = promoCenterSeePromosView;
    }

    public static NewViewPromoCenterBinding getAuthRequestContext(View view) {
        int i = R.id.btn_retry_news;
        DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_retry_news);
        if (danaButtonPrimaryView != null) {
            DanaButtonSecondaryView danaButtonSecondaryView = (DanaButtonSecondaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.btn_view_all_news);
            if (danaButtonSecondaryView != null) {
                RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cl_promo_banner_header);
                if (relativeLayout != null) {
                    MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.cv_error_load_news);
                    if (materialCardView != null) {
                        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.iv_error_news);
                        if (appCompatImageView != null) {
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.rv_news_list);
                            if (recyclerView != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_error_news);
                                if (appCompatTextView != null) {
                                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_promo_banner_widget_description);
                                    if (appCompatTextView2 != null) {
                                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tv_promo_banner_widget_title);
                                        if (appCompatTextView3 != null) {
                                            PromoCenterSeePromosView promoCenterSeePromosView = (PromoCenterSeePromosView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.view_custom_button_see_all_promo);
                                            if (promoCenterSeePromosView != null) {
                                                return new NewViewPromoCenterBinding((LinearLayout) view, danaButtonPrimaryView, danaButtonSecondaryView, relativeLayout, materialCardView, appCompatImageView, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, promoCenterSeePromosView);
                                            }
                                            i = R.id.view_custom_button_see_all_promo;
                                        } else {
                                            i = R.id.tv_promo_banner_widget_title;
                                        }
                                    } else {
                                        i = R.id.tv_promo_banner_widget_description;
                                    }
                                } else {
                                    i = R.id.tv_error_news;
                                }
                            } else {
                                i = R.id.rv_news_list;
                            }
                        } else {
                            i = R.id.iv_error_news;
                        }
                    } else {
                        i = R.id.cv_error_load_news;
                    }
                } else {
                    i = R.id.cl_promo_banner_header;
                }
            } else {
                i = R.id.btn_view_all_news;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda2;
    }
}
