package id.dana.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.rd.PageIndicatorView;
import id.dana.R;
import id.dana.popup.WrapContentHeightViewPager;

/* loaded from: classes4.dex */
public final class ActivityRequestMoneyBinding implements ViewBinding {
    public final LayoutToolbarBinding BuiltInFictitiousFunctionClassFactory;
    public final FloatingActionButton KClassImpl$Data$declaredNonStaticMembers$2;
    public final FloatingActionButton MyBillsEntityDataFactory;
    public final TextView NetworkUserEntityData$$ExternalSyntheticLambda0;
    public final PageIndicatorView PlaceComponentResult;
    public final ScrollView getAuthRequestContext;
    public final View getErrorConfigVersion;
    private final LinearLayout lookAheadTest;
    public final LayoutAddBankBannerBinding moveToNextValue;
    public final WrapContentHeightViewPager scheduleImpl;

    private ActivityRequestMoneyBinding(LinearLayout linearLayout, FloatingActionButton floatingActionButton, FloatingActionButton floatingActionButton2, PageIndicatorView pageIndicatorView, LayoutToolbarBinding layoutToolbarBinding, ScrollView scrollView, View view, TextView textView, LayoutAddBankBannerBinding layoutAddBankBannerBinding, WrapContentHeightViewPager wrapContentHeightViewPager) {
        this.lookAheadTest = linearLayout;
        this.MyBillsEntityDataFactory = floatingActionButton;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = floatingActionButton2;
        this.PlaceComponentResult = pageIndicatorView;
        this.BuiltInFictitiousFunctionClassFactory = layoutToolbarBinding;
        this.getAuthRequestContext = scrollView;
        this.getErrorConfigVersion = view;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = textView;
        this.moveToNextValue = layoutAddBankBannerBinding;
        this.scheduleImpl = wrapContentHeightViewPager;
    }

    public static ActivityRequestMoneyBinding MyBillsEntityDataFactory(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(R.layout.activity_request_money, (ViewGroup) null, false);
        int i = R.id.fabLeft;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fabLeft);
        if (floatingActionButton != null) {
            FloatingActionButton floatingActionButton2 = (FloatingActionButton) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.fabRight);
            if (floatingActionButton2 != null) {
                PageIndicatorView pageIndicatorView = (PageIndicatorView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.indicator);
                if (pageIndicatorView != null) {
                    View BuiltInFictitiousFunctionClassFactory = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.layoutToolbar);
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        LayoutToolbarBinding MyBillsEntityDataFactory = LayoutToolbarBinding.MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory);
                        ScrollView scrollView = (ScrollView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.scroll_view);
                        if (scrollView != null) {
                            View BuiltInFictitiousFunctionClassFactory2 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.top_blue);
                            if (BuiltInFictitiousFunctionClassFactory2 != null) {
                                TextView textView = (TextView) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.tvAddBankUserBannerTitle);
                                if (textView != null) {
                                    View BuiltInFictitiousFunctionClassFactory3 = ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.viewAddBankSection);
                                    if (BuiltInFictitiousFunctionClassFactory3 != null) {
                                        LayoutAddBankBannerBinding authRequestContext = LayoutAddBankBannerBinding.getAuthRequestContext(BuiltInFictitiousFunctionClassFactory3);
                                        WrapContentHeightViewPager wrapContentHeightViewPager = (WrapContentHeightViewPager) ViewBindings.BuiltInFictitiousFunctionClassFactory(inflate, R.id.vp_reqmoney_card);
                                        if (wrapContentHeightViewPager != null) {
                                            return new ActivityRequestMoneyBinding((LinearLayout) inflate, floatingActionButton, floatingActionButton2, pageIndicatorView, MyBillsEntityDataFactory, scrollView, BuiltInFictitiousFunctionClassFactory2, textView, authRequestContext, wrapContentHeightViewPager);
                                        }
                                        i = R.id.vp_reqmoney_card;
                                    } else {
                                        i = R.id.viewAddBankSection;
                                    }
                                } else {
                                    i = R.id.tvAddBankUserBannerTitle;
                                }
                            } else {
                                i = R.id.top_blue;
                            }
                        } else {
                            i = R.id.scroll_view;
                        }
                    } else {
                        i = R.id.layoutToolbar;
                    }
                } else {
                    i = R.id.indicator;
                }
            } else {
                i = R.id.fabRight;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
    }

    @Override // androidx.viewbinding.ViewBinding
    public final /* bridge */ /* synthetic */ View KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.lookAheadTest;
    }
}
