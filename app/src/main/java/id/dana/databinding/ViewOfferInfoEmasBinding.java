package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.card.MaterialCardView;
import id.dana.R;
import id.dana.component.dividercomponent.DanaDividerView;
import id.dana.richview.CurrencyTextView;

/* loaded from: classes8.dex */
public final class ViewOfferInfoEmasBinding implements ViewBinding {
    public final MaterialCardView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView DatabaseTableConfigUtil;
    public final DanaDividerView GetContactSyncConfig;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final AppCompatImageView MyBillsEntityDataFactory;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final ConstraintLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final AppCompatTextView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatImageView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView initRecordTimeStamp;
    public final AppCompatTextView lookAheadTest;
    public final CurrencyTextView moveToNextValue;
    public final AppCompatImageView scheduleImpl;

    private ViewOfferInfoEmasBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, MaterialCardView materialCardView, AppCompatImageView appCompatImageView, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, AppCompatImageView appCompatImageView4, AppCompatTextView appCompatTextView, CurrencyTextView currencyTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, AppCompatTextView appCompatTextView4, AppCompatTextView appCompatTextView5, AppCompatTextView appCompatTextView6, DanaDividerView danaDividerView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = constraintLayout;
        this.PlaceComponentResult = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = materialCardView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.MyBillsEntityDataFactory = appCompatImageView2;
        this.getAuthRequestContext = appCompatImageView3;
        this.scheduleImpl = appCompatImageView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatTextView;
        this.moveToNextValue = currencyTextView;
        this.lookAheadTest = appCompatTextView2;
        this.getErrorConfigVersion = appCompatTextView3;
        this.initRecordTimeStamp = appCompatTextView4;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = appCompatTextView5;
        this.DatabaseTableConfigUtil = appCompatTextView6;
        this.GetContactSyncConfig = danaDividerView;
    }

    public static ViewOfferInfoEmasBinding PlaceComponentResult(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.view_offer_info_emas, (ViewGroup) null, false);
        int i = R.id.cl_offer_info;
        ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_offer_info);
        if (constraintLayout != null) {
            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cv_product_detail);
            if (materialCardView != null) {
                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_bappebti);
                if (appCompatImageView != null) {
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_emas);
                    if (appCompatImageView2 != null) {
                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_offer_express_purchase);
                        if (appCompatImageView3 != null) {
                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_partner);
                            if (appCompatImageView4 != null) {
                                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_powered_by);
                                if (appCompatTextView != null) {
                                    CurrencyTextView currencyTextView = (CurrencyTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_product_detail_price);
                                    if (currencyTextView != null) {
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_product_detail_tnc);
                                        if (appCompatTextView2 != null) {
                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_product_detail_unit);
                                            if (appCompatTextView3 != null) {
                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_subtitle_offer);
                                                if (appCompatTextView4 != null) {
                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_supervised_by);
                                                    if (appCompatTextView5 != null) {
                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title_offer);
                                                        if (appCompatTextView6 != null) {
                                                            DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.v_product_detail_divider);
                                                            if (danaDividerView != null) {
                                                                return new ViewOfferInfoEmasBinding((ConstraintLayout) inflate, constraintLayout, materialCardView, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatTextView, currencyTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, danaDividerView);
                                                            }
                                                            i = R.id.v_product_detail_divider;
                                                        } else {
                                                            i = R.id.tv_title_offer;
                                                        }
                                                    } else {
                                                        i = R.id.tv_supervised_by;
                                                    }
                                                } else {
                                                    i = R.id.tv_subtitle_offer;
                                                }
                                            } else {
                                                i = R.id.tv_product_detail_unit;
                                            }
                                        } else {
                                            i = R.id.tv_product_detail_tnc;
                                        }
                                    } else {
                                        i = R.id.tv_product_detail_price;
                                    }
                                } else {
                                    i = R.id.tv_powered_by;
                                }
                            } else {
                                i = R.id.iv_partner;
                            }
                        } else {
                            i = R.id.iv_offer_express_purchase;
                        }
                    } else {
                        i = R.id.iv_emas;
                    }
                } else {
                    i = R.id.iv_bappebti;
                }
            } else {
                i = R.id.cv_product_detail;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
