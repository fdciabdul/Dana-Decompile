package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import id.dana.R;
import id.dana.component.buttoncomponent.DanaButtonPrimaryView;
import id.dana.component.dividercomponent.DanaDividerView;

/* loaded from: classes8.dex */
public final class BottomSheetPhotoTipsBinding implements ViewBinding {
    public final AppCompatImageView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView DatabaseTableConfigUtil;
    public final RelativeLayout GetContactSyncConfig;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final DanaDividerView MyBillsEntityDataFactory;
    public final AppCompatImageView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final CoordinatorLayout NetworkUserEntityData$$ExternalSyntheticLambda1;
    public final RecyclerView NetworkUserEntityData$$ExternalSyntheticLambda2;
    public final DanaDividerView PlaceComponentResult;
    public final DanaButtonPrimaryView getAuthRequestContext;
    public final LinearLayoutCompat getErrorConfigVersion;
    public final NestedScrollView initRecordTimeStamp;
    public final AppCompatImageView lookAheadTest;
    public final LinearLayoutCompat moveToNextValue;
    public final LinearLayoutCompat scheduleImpl;

    private BottomSheetPhotoTipsBinding(CoordinatorLayout coordinatorLayout, AppCompatImageView appCompatImageView, DanaButtonPrimaryView danaButtonPrimaryView, ConstraintLayout constraintLayout, DanaDividerView danaDividerView, DanaDividerView danaDividerView2, LinearLayoutCompat linearLayoutCompat, AppCompatImageView appCompatImageView2, AppCompatImageView appCompatImageView3, LinearLayoutCompat linearLayoutCompat2, LinearLayoutCompat linearLayoutCompat3, NestedScrollView nestedScrollView, RelativeLayout relativeLayout, RecyclerView recyclerView, AppCompatTextView appCompatTextView) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = coordinatorLayout;
        this.BuiltInFictitiousFunctionClassFactory = appCompatImageView;
        this.getAuthRequestContext = danaButtonPrimaryView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout;
        this.MyBillsEntityDataFactory = danaDividerView;
        this.PlaceComponentResult = danaDividerView2;
        this.getErrorConfigVersion = linearLayoutCompat;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = appCompatImageView2;
        this.lookAheadTest = appCompatImageView3;
        this.moveToNextValue = linearLayoutCompat2;
        this.scheduleImpl = linearLayoutCompat3;
        this.initRecordTimeStamp = nestedScrollView;
        this.GetContactSyncConfig = relativeLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = recyclerView;
        this.DatabaseTableConfigUtil = appCompatTextView;
    }

    public static BottomSheetPhotoTipsBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.bottom_sheet_photo_tips, viewGroup, false);
        int i = R.id.btn_close_top;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.btn_close_top);
        if (appCompatImageView != null) {
            DanaButtonPrimaryView danaButtonPrimaryView = (DanaButtonPrimaryView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.PlaceComponentResult_res_0x7f0a01e4);
            if (danaButtonPrimaryView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.cl_header_tips);
                if (constraintLayout != null) {
                    DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ddv_bottom_tips);
                    if (danaDividerView != null) {
                        DanaDividerView danaDividerView2 = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ddv_header_tips);
                        if (danaDividerView2 != null) {
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.footer);
                            if (linearLayoutCompat != null) {
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_content_tips);
                                if (appCompatImageView2 != null) {
                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_top_arrow);
                                    if (appCompatImageView3 != null) {
                                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.ll_content_tips);
                                        if (linearLayoutCompat2 != null) {
                                            LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.llc_header_tips);
                                            if (linearLayoutCompat3 != null) {
                                                NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.nsv_content_tips);
                                                if (nestedScrollView != null) {
                                                    RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rl_photo_tips);
                                                    if (relativeLayout != null) {
                                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.rv_content_tips);
                                                        if (recyclerView != null) {
                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_title_tips);
                                                            if (appCompatTextView != null) {
                                                                return new BottomSheetPhotoTipsBinding((CoordinatorLayout) inflate, appCompatImageView, danaButtonPrimaryView, constraintLayout, danaDividerView, danaDividerView2, linearLayoutCompat, appCompatImageView2, appCompatImageView3, linearLayoutCompat2, linearLayoutCompat3, nestedScrollView, relativeLayout, recyclerView, appCompatTextView);
                                                            }
                                                            i = R.id.tv_title_tips;
                                                        } else {
                                                            i = R.id.rv_content_tips;
                                                        }
                                                    } else {
                                                        i = R.id.rl_photo_tips;
                                                    }
                                                } else {
                                                    i = R.id.nsv_content_tips;
                                                }
                                            } else {
                                                i = R.id.llc_header_tips;
                                            }
                                        } else {
                                            i = R.id.ll_content_tips;
                                        }
                                    } else {
                                        i = R.id.iv_top_arrow;
                                    }
                                } else {
                                    i = R.id.iv_content_tips;
                                }
                            } else {
                                i = R.id.footer;
                            }
                        } else {
                            i = R.id.ddv_header_tips;
                        }
                    } else {
                        i = R.id.ddv_bottom_tips;
                    }
                } else {
                    i = R.id.cl_header_tips;
                }
            } else {
                i = R.id.PlaceComponentResult_res_0x7f0a01e4;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda1;
    }
}
