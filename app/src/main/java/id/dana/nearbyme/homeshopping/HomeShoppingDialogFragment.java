package id.dana.nearbyme.homeshopping;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import id.dana.R;
import id.dana.base.DefaultBottomSheetDialogFragment;
import id.dana.component.navigationcomponent.DanaNavigationTabLayoutView;
import id.dana.extension.view.ViewPagerExtKt;
import id.dana.nearbyme.extension.NearbyViewExtKt;
import id.dana.nearbyme.homeshopping.adapter.HomeShoppingTabAdapter;
import id.dana.nearbyme.homeshopping.model.HomeShoppingModel;
import id.dana.nearbyme.merchantdetail.model.MerchantDetailViewState;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u000b\u0010\f"}, d2 = {"Lid/dana/nearbyme/homeshopping/HomeShoppingDialogFragment;", "Lid/dana/base/DefaultBottomSheetDialogFragment;", "Landroid/view/View;", "getAuthRequestContext", "()Landroid/view/View;", "Landroid/os/Bundle;", "p0", "", "onActivityCreated", "(Landroid/os/Bundle;)V", "Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;", "scheduleImpl", "Lid/dana/nearbyme/homeshopping/model/HomeShoppingModel;", "MyBillsEntityDataFactory", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HomeShoppingDialogFragment extends DefaultBottomSheetDialogFragment {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public Map<Integer, View> lookAheadTest = new LinkedHashMap();

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private HomeShoppingModel MyBillsEntityDataFactory;

    @Override // id.dana.base.DefaultBottomSheetDialogFragment
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.lookAheadTest.clear();
    }

    @Override // id.dana.base.DefaultBottomSheetDialogFragment
    public final View KClassImpl$Data$declaredNonStaticMembers$2(int i) {
        View findViewById;
        Map<Integer, View> map = this.lookAheadTest;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View getAuthRequestContext = getGetAuthRequestContext();
            if (getAuthRequestContext == null || (findViewById = getAuthRequestContext.findViewById(i)) == null) {
                return null;
            }
            map.put(Integer.valueOf(i), findViewById);
            return findViewById;
        }
        return view;
    }

    public HomeShoppingDialogFragment() {
        super(R.layout.view_home_shopping, 0, 2, null);
    }

    @Override // id.dana.base.DefaultBottomSheetDialogFragment
    public final View getAuthRequestContext() {
        LinearLayout linearLayout = (LinearLayout) KClassImpl$Data$declaredNonStaticMembers$2(R.id.res_0x7f0a0742_flowablesequenceequal_equalcoordinator);
        Intrinsics.checkNotNullExpressionValue(linearLayout, "");
        return linearLayout;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/nearbyme/homeshopping/HomeShoppingDialogFragment$Companion;", "", "Landroidx/fragment/app/FragmentManager;", "p0", "Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;", "p1", "KClassImpl$Data$declaredNonStaticMembers$2", "(Landroidx/fragment/app/FragmentManager;Lid/dana/nearbyme/merchantdetail/model/MerchantDetailViewState;)Ljava/lang/Object;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public static Object KClassImpl$Data$declaredNonStaticMembers$2(FragmentManager p0, MerchantDetailViewState p1) {
            Intrinsics.checkNotNullParameter(p0, "");
            Intrinsics.checkNotNullParameter(p1, "");
            Fragment findFragmentByTag = p0.findFragmentByTag("HomeShoppingDialogFragment");
            if (findFragmentByTag == null) {
                HomeShoppingDialogFragment homeShoppingDialogFragment = new HomeShoppingDialogFragment();
                Pair[] pairArr = new Pair[1];
                String str = p1.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda3;
                String str2 = str == null ? "" : str;
                String str3 = p1.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda6;
                String str4 = str3 == null ? "" : str3;
                String str5 = p1.PlaceComponentResult.newProxyInstance;
                String str6 = str5 == null ? "" : str5;
                String str7 = p1.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda8;
                String str8 = str7 == null ? "" : str7;
                String authRequestContext = p1.PlaceComponentResult.getAuthRequestContext(false, ", ");
                pairArr[0] = TuplesKt.to("HOME_SHOPPING_DIALOG_DATA_KEY", new HomeShoppingModel(str2, str4, str6, str8, authRequestContext == null ? "" : authRequestContext, p1.KClassImpl$Data$declaredNonStaticMembers$2(), p1.MyBillsEntityDataFactory));
                homeShoppingDialogFragment.setArguments(BundleKt.PlaceComponentResult(pairArr));
                homeShoppingDialogFragment.show(p0, "HomeShoppingDialogFragment");
                return Unit.INSTANCE;
            }
            return findFragmentByTag;
        }
    }

    public static final /* synthetic */ Unit getAuthRequestContext(HomeShoppingDialogFragment homeShoppingDialogFragment, TabLayout.Tab tab) {
        Context context = homeShoppingDialogFragment.getContext();
        if (context != null) {
            tab.setIcon(ContextCompat.PlaceComponentResult(context, (int) R.drawable.ic_info_stateful));
            tab.setText(homeShoppingDialogFragment.getString(R.string.home_shopping_tab_tnc));
            return Unit.INSTANCE;
        }
        return null;
    }

    public static final /* synthetic */ Unit BuiltInFictitiousFunctionClassFactory(HomeShoppingDialogFragment homeShoppingDialogFragment, TabLayout.Tab tab) {
        Context context = homeShoppingDialogFragment.getContext();
        if (context != null) {
            tab.setIcon(ContextCompat.PlaceComponentResult(context, (int) R.drawable.ic_shopping_cart_stateful));
            tab.setText(homeShoppingDialogFragment.getString(R.string.home_shopping_tab_tutorial));
            return Unit.INSTANCE;
        }
        return null;
    }

    @Override // id.dana.base.DefaultBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle p0) {
        Unit unit;
        HomeShoppingModel homeShoppingModel;
        Bundle arguments = getArguments();
        HomeShoppingModel homeShoppingModel2 = null;
        if (arguments == null || (homeShoppingModel = (HomeShoppingModel) arguments.getParcelable("HOME_SHOPPING_DIALOG_DATA_KEY")) == null) {
            unit = null;
        } else {
            this.MyBillsEntityDataFactory = homeShoppingModel;
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            dismiss();
        }
        HomeShoppingModel homeShoppingModel3 = this.MyBillsEntityDataFactory;
        if (homeShoppingModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            homeShoppingModel3 = null;
        }
        AppCompatImageView appCompatImageView = (AppCompatImageView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.iv_shop_logo);
        if (appCompatImageView != null) {
            Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
            NearbyViewExtKt.MyBillsEntityDataFactory(appCompatImageView, homeShoppingModel3.getAuthRequestContext);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tv_shop_name);
        if (appCompatTextView != null) {
            appCompatTextView.setText(homeShoppingModel3.BuiltInFictitiousFunctionClassFactory);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tv_shop_category);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(homeShoppingModel3.moveToNextValue);
        }
        ViewPager2 viewPager2 = (ViewPager2) KClassImpl$Data$declaredNonStaticMembers$2(R.id.vp_content);
        if (viewPager2 != null) {
            HomeShoppingDialogFragment homeShoppingDialogFragment = this;
            HomeShoppingModel homeShoppingModel4 = this.MyBillsEntityDataFactory;
            if (homeShoppingModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                homeShoppingModel2 = homeShoppingModel4;
            }
            viewPager2.setAdapter(new HomeShoppingTabAdapter(homeShoppingDialogFragment, homeShoppingModel2));
        }
        DanaNavigationTabLayoutView danaNavigationTabLayoutView = (DanaNavigationTabLayoutView) KClassImpl$Data$declaredNonStaticMembers$2(R.id.tl_home_shopping);
        if (danaNavigationTabLayoutView != null) {
            ViewPager2 viewPager22 = (ViewPager2) KClassImpl$Data$declaredNonStaticMembers$2(R.id.vp_content);
            Intrinsics.checkNotNullExpressionValue(viewPager22, "");
            ViewPagerExtKt.getAuthRequestContext(danaNavigationTabLayoutView, viewPager22, new Function2<TabLayout.Tab, Integer, Unit>() { // from class: id.dana.nearbyme.homeshopping.HomeShoppingDialogFragment$setupTabLayout$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
                    invoke(tab, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(TabLayout.Tab tab, int i) {
                    Intrinsics.checkNotNullParameter(tab, "");
                    if (i == 0) {
                        HomeShoppingDialogFragment.BuiltInFictitiousFunctionClassFactory(HomeShoppingDialogFragment.this, tab);
                    } else if (i == 1) {
                        HomeShoppingDialogFragment.getAuthRequestContext(HomeShoppingDialogFragment.this, tab);
                    }
                }
            });
            Unit unit2 = Unit.INSTANCE;
        }
        super.onActivityCreated(p0);
    }

    @Override // id.dana.base.DefaultBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        this.lookAheadTest.clear();
    }
}
