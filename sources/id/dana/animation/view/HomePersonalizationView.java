package id.dana.animation.view;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import dagger.Lazy;
import dagger.internal.Preconditions;
import id.dana.R;
import id.dana.base.AbstractContractKt;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.databinding.ViewHomePersonalizationBinding;
import id.dana.di.component.ApplicationComponent;
import id.dana.di.component.DaggerHomePersonalizationComponent;
import id.dana.personalizedhome.HomePersonalizationContract;
import id.dana.personalizedhome.HomePersonalizedModule;
import id.dana.utils.LocationUtil;
import id.dana.utils.OSUtil;
import io.reactivex.functions.Consumer;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\u001b\u0012\u0006\u0010'\u001a\u00020&\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(¢\u0006\u0004\b*\u0010+J\r\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0014¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\tH\u0014¢\u0006\u0004\b\u0015\u0010\u000bJ\u000f\u0010\u0016\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0016\u0010\u0005R$\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0007@\u0007X\u0087.¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%"}, d2 = {"Lid/dana/home/view/HomePersonalizationView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewHomePersonalizationBinding;", "", "disposeByActivity", "()V", "", "getLayout", "()I", "", "KClassImpl$Data$declaredNonStaticMembers$2", "()Z", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewHomePersonalizationBinding;", "Lid/dana/di/component/ApplicationComponent;", "applicationComponent", "injectComponent", "(Lid/dana/di/component/ApplicationComponent;)V", "MyBillsEntityDataFactory", "isForRecyclerViewholder", "setup", "Lid/dana/home/view/HomePersonalizationView$HomePersonalizationListener;", "Lid/dana/home/view/HomePersonalizationView$HomePersonalizationListener;", "getHomePersonalizationListener", "()Lid/dana/home/view/HomePersonalizationView$HomePersonalizationListener;", "setHomePersonalizationListener", "(Lid/dana/home/view/HomePersonalizationView$HomePersonalizationListener;)V", "homePersonalizationListener", "Ldagger/Lazy;", "Lid/dana/personalizedhome/HomePersonalizationContract$Presenter;", "homePersonalizationPresenter", "Ldagger/Lazy;", "getHomePersonalizationPresenter", "()Ldagger/Lazy;", "setHomePersonalizationPresenter", "(Ldagger/Lazy;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "HomePersonalizationListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HomePersonalizationView extends ViewBindingRichView<ViewHomePersonalizationBinding> {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private HomePersonalizationListener homePersonalizationListener;
    public Map<Integer, View> _$_findViewCache;
    @Inject
    public Lazy<HomePersonalizationContract.Presenter> homePersonalizationPresenter;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/home/view/HomePersonalizationView$HomePersonalizationListener;", "", "", "MyBillsEntityDataFactory", "()V", "BuiltInFictitiousFunctionClassFactory"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public interface HomePersonalizationListener {
        void BuiltInFictitiousFunctionClassFactory();

        void MyBillsEntityDataFactory();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.util.AttributeSet, kotlin.jvm.internal.DefaultConstructorMarker] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HomePersonalizationView(android.content.Context r3) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 0
            r1 = 2
            r2.<init>(r3, r0, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.animation.view.HomePersonalizationView.<init>(android.content.Context):void");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view == null) {
            View findViewById = findViewById(i);
            if (findViewById != null) {
                map.put(Integer.valueOf(i), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        return R.layout.view_home_personalization;
    }

    @Override // id.dana.base.BaseRichView
    public final boolean isForRecyclerViewholder() {
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HomePersonalizationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ HomePersonalizationView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    @JvmName(name = "getHomePersonalizationPresenter")
    public final Lazy<HomePersonalizationContract.Presenter> getHomePersonalizationPresenter() {
        Lazy<HomePersonalizationContract.Presenter> lazy = this.homePersonalizationPresenter;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("");
        return null;
    }

    @JvmName(name = "setHomePersonalizationPresenter")
    public final void setHomePersonalizationPresenter(Lazy<HomePersonalizationContract.Presenter> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "");
        this.homePersonalizationPresenter = lazy;
    }

    @JvmName(name = "getHomePersonalizationListener")
    public final HomePersonalizationListener getHomePersonalizationListener() {
        return this.homePersonalizationListener;
    }

    @JvmName(name = "setHomePersonalizationListener")
    public final void setHomePersonalizationListener(HomePersonalizationListener homePersonalizationListener) {
        this.homePersonalizationListener = homePersonalizationListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewHomePersonalizationBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewHomePersonalizationBinding PlaceComponentResult = ViewHomePersonalizationBinding.PlaceComponentResult(view);
        Intrinsics.checkNotNullExpressionValue(PlaceComponentResult, "");
        return PlaceComponentResult;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        getHomePersonalizationPresenter().get().MyBillsEntityDataFactory();
        HomePersonalizationListener homePersonalizationListener = this.homePersonalizationListener;
        if (homePersonalizationListener != null) {
            homePersonalizationListener.MyBillsEntityDataFactory();
        }
        HomePersonalizationListener homePersonalizationListener2 = this.homePersonalizationListener;
        if (homePersonalizationListener2 != null) {
            homePersonalizationListener2.BuiltInFictitiousFunctionClassFactory();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void injectComponent(ApplicationComponent applicationComponent) {
        DaggerHomePersonalizationComponent.Builder MyBillsEntityDataFactory = DaggerHomePersonalizationComponent.MyBillsEntityDataFactory();
        MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2 = (ApplicationComponent) Preconditions.getAuthRequestContext(applicationComponent);
        MyBillsEntityDataFactory.PlaceComponentResult = (HomePersonalizedModule) Preconditions.getAuthRequestContext(new HomePersonalizedModule(new HomePersonalizationContract.View() { // from class: id.dana.home.view.HomePersonalizationView$injectComponent$1
            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void dismissProgress() {
                AbstractContractKt.AbstractView.CC.MyBillsEntityDataFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView
            public final /* synthetic */ String getErrorSource() {
                return AbstractContractKt.AbstractView.CC.getAuthRequestContext();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void onError(String str) {
                AbstractContractKt.AbstractView.CC.BuiltInFictitiousFunctionClassFactory();
            }

            @Override // id.dana.base.AbstractContractKt.AbstractView, id.dana.base.AbstractContract.AbstractView
            public final /* synthetic */ void showProgress() {
                AbstractContractKt.AbstractView.CC.PlaceComponentResult();
            }

            @Override // id.dana.personalizedhome.HomePersonalizationContract.View
            public final void KClassImpl$Data$declaredNonStaticMembers$2(boolean p0) {
                if (p0) {
                    HomePersonalizationView.access$showPersonalizedBackgroundAndHideViewSpacing(HomePersonalizationView.this);
                    HomePersonalizationView.access$getPersonalizedBackground(HomePersonalizationView.this);
                    return;
                }
                HomePersonalizationView.this.getHomePersonalizationPresenter().get().MyBillsEntityDataFactory("indonesia");
                HomePersonalizationView.access$showPersonalizedBackgroundAndHideViewSpacing(HomePersonalizationView.this);
            }

            @Override // id.dana.personalizedhome.HomePersonalizationContract.View
            public final void MyBillsEntityDataFactory(String p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                HomePersonalizationView.access$showPersonalizedBackgroundAndHideViewSpacing(HomePersonalizationView.this);
                HomePersonalizationView.access$setPersonalizedImageView(HomePersonalizationView.this, p0);
            }

            @Override // id.dana.personalizedhome.HomePersonalizationContract.View
            public final void PlaceComponentResult() {
                HomePersonalizationView.access$showPersonalizedBackgroundAndHideViewSpacing(HomePersonalizationView.this);
                HomePersonalizationView.access$setPersonalizedImageViewIntoIndonesia(HomePersonalizationView.this);
            }
        }));
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.PlaceComponentResult, HomePersonalizedModule.class);
        Preconditions.KClassImpl$Data$declaredNonStaticMembers$2(MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, ApplicationComponent.class);
        new DaggerHomePersonalizationComponent.HomePersonalizationComponentImpl(MyBillsEntityDataFactory.PlaceComponentResult, MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2, (byte) 0).PlaceComponentResult(this);
        registerPresenter(getHomePersonalizationPresenter().get());
    }

    private final boolean MyBillsEntityDataFactory() {
        if (OSUtil.GetContactSyncConfig()) {
            return KClassImpl$Data$declaredNonStaticMembers$2() && LocationUtil.getAuthRequestContext(getContext());
        }
        return LocationUtil.getAuthRequestContext(getContext());
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return ContextCompat.KClassImpl$Data$declaredNonStaticMembers$2(getBaseActivity(), "android.permission.ACCESS_FINE_LOCATION") == 0;
    }

    public final void disposeByActivity() {
        getHomePersonalizationPresenter().get().onDestroy();
    }

    public static /* synthetic */ void $r8$lambda$3hDRGMcPunNi1WwkEs7vAg6thn4(HomePersonalizationView homePersonalizationView, Location location) {
        Intrinsics.checkNotNullParameter(homePersonalizationView, "");
        Intrinsics.checkNotNullParameter(location, "");
        homePersonalizationView.getHomePersonalizationPresenter().get().PlaceComponentResult(location);
    }

    public static final /* synthetic */ void access$getPersonalizedBackground(final HomePersonalizationView homePersonalizationView) {
        if (homePersonalizationView.MyBillsEntityDataFactory()) {
            homePersonalizationView.addDisposable(new LocationUtil.LocationRequestBuilder((Application) homePersonalizationView.getBaseActivity().getDanaApplication()).BuiltInFictitiousFunctionClassFactory().take(2L).subscribe(new Consumer() { // from class: id.dana.home.view.HomePersonalizationView$$ExternalSyntheticLambda0
                @Override // io.reactivex.functions.Consumer
                public final void accept(Object obj) {
                    HomePersonalizationView.$r8$lambda$3hDRGMcPunNi1WwkEs7vAg6thn4(HomePersonalizationView.this, (Location) obj);
                }
            }));
        } else {
            homePersonalizationView.getHomePersonalizationPresenter().get().PlaceComponentResult(null);
        }
    }

    public static final /* synthetic */ void access$setPersonalizedImageView(HomePersonalizationView homePersonalizationView, String str) {
        byte b = 0;
        if (str.length() == 0) {
            HomePersonalizationListener homePersonalizationListener = homePersonalizationView.homePersonalizationListener;
            if (homePersonalizationListener != null) {
                homePersonalizationListener.MyBillsEntityDataFactory();
            }
            HomePersonalizationListener homePersonalizationListener2 = homePersonalizationView.homePersonalizationListener;
            if (homePersonalizationListener2 != null) {
                homePersonalizationListener2.BuiltInFictitiousFunctionClassFactory();
            }
        } else if (homePersonalizationView.getContext() != null) {
            if (SvgLoader.getAuthRequestContext(str)) {
                SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(homePersonalizationView.getContext());
                KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
                KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 = R.drawable.bg_secure_footmark;
                KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = homePersonalizationView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
                return;
            }
            GlideApp.getAuthRequestContext(homePersonalizationView).MyBillsEntityDataFactory().BuiltInFictitiousFunctionClassFactory(str).MyBillsEntityDataFactory(DiskCacheStrategy.PlaceComponentResult).getErrorConfigVersion((int) R.drawable.bg_secure_footmark).PlaceComponentResult((int) R.drawable.bg_secure_footmark).MyBillsEntityDataFactory((ImageView) homePersonalizationView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2);
        }
    }

    public static final /* synthetic */ void access$setPersonalizedImageViewIntoIndonesia(HomePersonalizationView homePersonalizationView) {
        HomePersonalizationListener homePersonalizationListener = homePersonalizationView.homePersonalizationListener;
        if (homePersonalizationListener != null) {
            homePersonalizationListener.MyBillsEntityDataFactory();
        }
        HomePersonalizationListener homePersonalizationListener2 = homePersonalizationView.homePersonalizationListener;
        if (homePersonalizationListener2 != null) {
            homePersonalizationListener2.BuiltInFictitiousFunctionClassFactory();
        }
    }

    public static final /* synthetic */ void access$showPersonalizedBackgroundAndHideViewSpacing(HomePersonalizationView homePersonalizationView) {
        homePersonalizationView.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setVisibility(0);
        HomePersonalizationListener homePersonalizationListener = homePersonalizationView.homePersonalizationListener;
        if (homePersonalizationListener != null) {
            homePersonalizationListener.MyBillsEntityDataFactory();
        }
        HomePersonalizationListener homePersonalizationListener2 = homePersonalizationView.homePersonalizationListener;
        if (homePersonalizationListener2 != null) {
            homePersonalizationListener2.BuiltInFictitiousFunctionClassFactory();
        }
    }
}
