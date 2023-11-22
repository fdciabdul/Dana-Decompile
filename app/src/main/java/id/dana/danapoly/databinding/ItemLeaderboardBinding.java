package id.dana.danapoly.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.imageview.ShapeableImageView;
import id.dana.danapoly.R;

/* loaded from: classes4.dex */
public final class ItemLeaderboardBinding implements ViewBinding {
    public final Guideline BuiltInFictitiousFunctionClassFactory;
    public final ConstraintLayout KClassImpl$Data$declaredNonStaticMembers$2;
    public final ShapeableImageView MyBillsEntityDataFactory;
    public final ConstraintLayout PlaceComponentResult;
    public final AppCompatTextView getAuthRequestContext;
    public final AppCompatTextView getErrorConfigVersion;
    public final AppCompatTextView lookAheadTest;
    public final View scheduleImpl;

    private ItemLeaderboardBinding(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, Guideline guideline, ShapeableImageView shapeableImageView, AppCompatTextView appCompatTextView, AppCompatTextView appCompatTextView2, AppCompatTextView appCompatTextView3, View view) {
        this.PlaceComponentResult = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = constraintLayout2;
        this.BuiltInFictitiousFunctionClassFactory = guideline;
        this.MyBillsEntityDataFactory = shapeableImageView;
        this.getAuthRequestContext = appCompatTextView;
        this.lookAheadTest = appCompatTextView2;
        this.getErrorConfigVersion = appCompatTextView3;
        this.scheduleImpl = view;
    }

    public static ItemLeaderboardBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View BuiltInFictitiousFunctionClassFactory;
        View inflate = layoutInflater.inflate(R.layout.item_leaderboard, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate;
        int i = R.id.res_0x7f0a0606_summaryvoucherview_externalsyntheticlambda0;
        Guideline guideline = (Guideline) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (guideline != null) {
            i = R.id.h;
            ShapeableImageView shapeableImageView = (ShapeableImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (shapeableImageView != null) {
                i = R.id.isTmpDetached_res_0x7f0a14af;
                AppCompatTextView appCompatTextView = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (appCompatTextView != null) {
                    i = R.id.res_0x7f0a152c_typetoken_typeset;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (appCompatTextView2 != null) {
                        i = R.id.f5769$r8$lambda$Z7cCkiMOpRjsRTg6ix8npYCDM;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (appCompatTextView3 != null && (BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, (i = R.id.access$getFeaturedBankListAdapter$p))) != null) {
                            return new ItemLeaderboardBinding(constraintLayout, constraintLayout, guideline, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, BuiltInFictitiousFunctionClassFactory);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.PlaceComponentResult;
    }
}
