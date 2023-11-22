package id.dana.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.R;
import id.dana.component.dividercomponent.DanaDividerView;

/* loaded from: classes4.dex */
public final class ViewKybCpmInputAmountBinding implements ViewBinding {
    public final DanaDividerView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatTextView KClassImpl$Data$declaredNonStaticMembers$2;
    public final ShapeableImageView MyBillsEntityDataFactory;
    public final AppCompatTextView PlaceComponentResult;
    public final LayoutAmountViewBinding getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ViewKybCpmInputAmountBinding(ConstraintLayout constraintLayout, LayoutAmountViewBinding layoutAmountViewBinding, ShapeableImageView shapeableImageView, DanaDividerView danaDividerView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2) {
        this.lookAheadTest = constraintLayout;
        this.getAuthRequestContext = layoutAmountViewBinding;
        this.MyBillsEntityDataFactory = shapeableImageView;
        this.BuiltInFictitiousFunctionClassFactory = danaDividerView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatTextView;
        this.PlaceComponentResult = appCompatTextView2;
    }

    public static ViewKybCpmInputAmountBinding KClassImpl$Data$declaredNonStaticMembers$2(View view) {
        int i = R.id.amountView;
        View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.amountView);
        if (BuiltInFictitiousFunctionClassFactory != null) {
            LayoutAmountViewBinding KClassImpl$Data$declaredNonStaticMembers$2 = LayoutAmountViewBinding.KClassImpl$Data$declaredNonStaticMembers$2(BuiltInFictitiousFunctionClassFactory);
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.ivKybCpm);
            if (shapeableImageView != null) {
                DanaDividerView danaDividerView = (DanaDividerView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.separator);
                if (danaDividerView != null) {
                    AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvKybCpmBody);
                    if (appCompatTextView != null) {
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(view, R.id.tvKybCpmTitle);
                        if (appCompatTextView2 != null) {
                            return new ViewKybCpmInputAmountBinding((ConstraintLayout) view, KClassImpl$Data$declaredNonStaticMembers$2, shapeableImageView, danaDividerView, appCompatTextView, appCompatTextView2);
                        }
                        i = R.id.tvKybCpmTitle;
                    } else {
                        i = R.id.tvKybCpmBody;
                    }
                } else {
                    i = R.id.separator;
                }
            } else {
                i = R.id.ivKybCpm;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
