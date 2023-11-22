package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager.widget.ViewPager;
import com.rd.PageIndicatorView;
import id.dana.R;

/* loaded from: classes4.dex */
public final class ActivityIntroductionBinding implements ViewBinding {
    public final TextView BuiltInFictitiousFunctionClassFactory;
    public final AppCompatImageView KClassImpl$Data$declaredNonStaticMembers$2;
    public final TextView MyBillsEntityDataFactory;
    public final ViewPager NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final PageIndicatorView PlaceComponentResult;
    public final TextView getAuthRequestContext;
    public final RelativeLayout moveToNextValue;
    private final LinearLayout scheduleImpl;

    private ActivityIntroductionBinding(LinearLayout linearLayout, PageIndicatorView pageIndicatorView, AppCompatImageView appCompatImageView, TextView textView, TextView textView2, TextView textView3, RelativeLayout relativeLayout, ViewPager viewPager) {
        this.scheduleImpl = linearLayout;
        this.PlaceComponentResult = pageIndicatorView;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = appCompatImageView;
        this.BuiltInFictitiousFunctionClassFactory = textView;
        this.MyBillsEntityDataFactory = textView2;
        this.getAuthRequestContext = textView3;
        this.moveToNextValue = relativeLayout;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = viewPager;
    }

    public static ActivityIntroductionBinding BuiltInFictitiousFunctionClassFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_introduction, (ViewGroup) null, false);
        int i = R.id.indicator;
        PageIndicatorView pageIndicatorView = (PageIndicatorView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.indicator);
        if (pageIndicatorView != null) {
            AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.iv_phone_number_flag);
            if (appCompatImageView != null) {
                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_intro_phone_number_label);
                if (textView != null) {
                    TextView textView2 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_phone_number_country_code);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tv_phone_number_placeholder);
                        if (textView3 != null) {
                            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vg_intro_action);
                            if (relativeLayout != null) {
                                ViewPager viewPager = (ViewPager) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewpager);
                                if (viewPager != null) {
                                    return new ActivityIntroductionBinding((LinearLayout) inflate, pageIndicatorView, appCompatImageView, textView, textView2, textView3, relativeLayout, viewPager);
                                }
                                i = R.id.viewpager;
                            } else {
                                i = R.id.vg_intro_action;
                            }
                        } else {
                            i = R.id.tv_phone_number_placeholder;
                        }
                    } else {
                        i = R.id.tv_phone_number_country_code;
                    }
                } else {
                    i = R.id.tv_intro_phone_number_label;
                }
            } else {
                i = R.id.iv_phone_number_flag;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.scheduleImpl;
    }
}
