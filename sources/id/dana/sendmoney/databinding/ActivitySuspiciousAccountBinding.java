package id.dana.sendmoney.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import id.dana.core.ui.richview.StoryProgressBar;
import id.dana.sendmoney.R;

/* loaded from: classes5.dex */
public final class ActivitySuspiciousAccountBinding implements ViewBinding {
    public final ViewPager2 BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final StoryProgressBar MyBillsEntityDataFactory;
    public final TextView PlaceComponentResult;
    public final ImageView getAuthRequestContext;
    private final ConstraintLayout lookAheadTest;

    private ActivitySuspiciousAccountBinding(ConstraintLayout constraintLayout, AppCompatImageView appCompatImageView, ImageView imageView, StoryProgressBar storyProgressBar, TextView textView, ViewPager2 viewPager2) {
        this.lookAheadTest = constraintLayout;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.getAuthRequestContext = imageView;
        this.MyBillsEntityDataFactory = storyProgressBar;
        this.PlaceComponentResult = textView;
        this.BuiltInFictitiousFunctionClassFactory = viewPager2;
    }

    public static ActivitySuspiciousAccountBinding KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_suspicious_account, (ViewGroup) null, false);
        int i = R.id.ReferralMapper_Factory;
        AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
        if (appCompatImageView != null) {
            i = R.id.NewMerchantCategoryAdapter_res_0x7f0a0996;
            ImageView imageView = (ImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
            if (imageView != null) {
                i = R.id.spbSuspiciousAccount;
                StoryProgressBar storyProgressBar = (StoryProgressBar) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                if (storyProgressBar != null) {
                    i = R.id.tvSuspiciousTitle;
                    TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                    if (textView != null) {
                        i = R.id.res_0x7f0a1bbe_spansuppressionstrategy_1;
                        ViewPager2 viewPager2 = (ViewPager2) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, i);
                        if (viewPager2 != null) {
                            return new ActivitySuspiciousAccountBinding((ConstraintLayout) inflate, appCompatImageView, imageView, storyProgressBar, textView, viewPager2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
