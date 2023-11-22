package id.dana.drawable.merchantbanner;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.ViewPager;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.rd.PageIndicatorView;
import id.dana.R;
import id.dana.base.BaseActivity;
import id.dana.base.BaseRichView;
import id.dana.nearbyme.extension.NearbyViewExtKt;
import id.dana.nearbyme.merchantdetail.mediaviewer.MerchantPhotoGalleryActivity;
import id.dana.nearbyme.merchantdetail.model.MerchantImageModel;
import id.dana.nearbyme.model.ShopModel;
import id.dana.onboarding.view.SimplePagerAdapter;
import id.dana.onboarding.view.SimpleView;
import id.dana.utils.ShimmeringUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B'\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0002¢\u0006\u0004\b*\u0010+B+\b\u0016\u0012\u0006\u0010&\u001a\u00020%\u0012\b\u0010(\u001a\u0004\u0018\u00010'\u0012\u0006\u0010)\u001a\u00020\u0002\u0012\u0006\u0010,\u001a\u00020\u0002¢\u0006\u0004\b*\u0010-J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0011\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\bR\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001a\u001a\u00020\u001d8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001eR\u0018\u0010!\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010#\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/nearbyrevamp/merchantbanner/MerchantBannerView;", "Lid/dana/base/BaseRichView;", "", "getCurrentPos", "()I", "getLayout", "", "reset", "()V", "Lkotlin/Function0;", "onClose", "setCloseListener", "(Lkotlin/jvm/functions/Function0;)V", "", "Lid/dana/nearbyme/merchantdetail/model/MerchantImageModel;", "merchantImages", "currentSelectedPage", "setMerchantImages", "(Ljava/util/List;I)V", "Lid/dana/nearbyme/model/ShopModel;", "shopModel", "setShopModel", "(Lid/dana/nearbyme/model/ShopModel;)V", "setup", "showLoading", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "getAuthRequestContext", "Lid/dana/nearbyrevamp/merchantbanner/MerchantBannerPagerAdapter;", "Lid/dana/nearbyrevamp/merchantbanner/MerchantBannerPagerAdapter;", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/model/ShopModel;", "PlaceComponentResult", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "BuiltInFictitiousFunctionClassFactory", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantBannerView extends BaseRichView {
    private ViewSkeletonScreen BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private List<MerchantImageModel> getAuthRequestContext;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ShopModel PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private MerchantBannerPagerAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantBannerView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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
        return R.layout.view_merchant_banner;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = new ArrayList();
    }

    public /* synthetic */ MerchantBannerView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantBannerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = new ArrayList();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.resolveActivity);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantbanner.MerchantBannerView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantBannerView.$r8$lambda$EybI6e1ljCijBV4DDHoLrSxUjkE(MerchantBannerView.this, view);
                }
            });
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "");
        MerchantBannerPagerAdapter merchantBannerPagerAdapter = new MerchantBannerPagerAdapter(context);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = merchantBannerPagerAdapter;
        merchantBannerPagerAdapter.PlaceComponentResult = new SimplePagerAdapter.OnItemClickListener() { // from class: id.dana.nearbyrevamp.merchantbanner.MerchantBannerView$initViewPager$1
            @Override // id.dana.onboarding.view.SimplePagerAdapter.OnItemClickListener
            public final void BuiltInFictitiousFunctionClassFactory(int p0) {
                MerchantBannerView.access$openMerchantPhotoViewerDialog(MerchantBannerView.this, p0);
            }
        };
        final ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.setFixedLengthStreamingMode);
        if (viewPager != null) {
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: id.dana.nearbyrevamp.merchantbanner.MerchantBannerView$initViewPager$2$1
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageScrollStateChanged(int p0) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageScrolled(int p0, float p1, int p2) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public final void onPageSelected(int p0) {
                    PageIndicatorView pageIndicatorView = (PageIndicatorView) ViewPager.this.findViewById(R.id.GetBottomSheetOnBoarding_Factory);
                    if (pageIndicatorView != null) {
                        pageIndicatorView.setSelected(p0);
                    }
                }
            });
            viewPager.setOffscreenPageLimit(5);
            MerchantBannerPagerAdapter merchantBannerPagerAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (merchantBannerPagerAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                merchantBannerPagerAdapter2 = null;
            }
            viewPager.setAdapter(merchantBannerPagerAdapter2);
        }
    }

    public static /* synthetic */ void setMerchantImages$default(MerchantBannerView merchantBannerView, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        merchantBannerView.setMerchantImages(list, i);
    }

    public final void setCloseListener(final Function0<Unit> onClose) {
        Intrinsics.checkNotNullParameter(onClose, "");
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id._release);
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyrevamp.merchantbanner.MerchantBannerView$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MerchantBannerView.m2746$r8$lambda$vPyRBb4AxRzu_Ov6pF_idRzni0(Function0.this, view);
                }
            });
        }
    }

    public final void setShopModel(ShopModel shopModel) {
        Intrinsics.checkNotNullParameter(shopModel, "");
        this.PlaceComponentResult = shopModel;
    }

    public final void reset() {
        this.PlaceComponentResult = null;
        setMerchantImages$default(this, CollectionsKt.emptyList(), 0, 2, null);
        ViewSkeletonScreen viewSkeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.PlaceComponentResult();
        }
    }

    public final int getCurrentPos() {
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.setFixedLengthStreamingMode);
        if (viewPager != null) {
            return viewPager.getCurrentItem();
        }
        return 0;
    }

    public static /* synthetic */ void $r8$lambda$EybI6e1ljCijBV4DDHoLrSxUjkE(MerchantBannerView merchantBannerView, View view) {
        Intrinsics.checkNotNullParameter(merchantBannerView, "");
        ShopModel shopModel = merchantBannerView.PlaceComponentResult;
        if (shopModel != null) {
            MerchantPhotoGalleryActivity.Companion companion = MerchantPhotoGalleryActivity.INSTANCE;
            Context context = merchantBannerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "");
            String str = shopModel.NetworkUserEntityData$$ExternalSyntheticLambda3;
            Intrinsics.checkNotNullExpressionValue(str, "");
            String str2 = shopModel.BottomSheetCardBindingView$watcherCardNumberView$1;
            Intrinsics.checkNotNullExpressionValue(str2, "");
            String str3 = shopModel.newProxyInstance;
            merchantBannerView.getContext().startActivity(MerchantPhotoGalleryActivity.Companion.KClassImpl$Data$declaredNonStaticMembers$2(context, str, str2, str3 != null ? str3 : ""));
        }
    }

    /* renamed from: $r8$lambda$vPyRBb4AxRzu_-Ov6pF_idRzni0 */
    public static /* synthetic */ void m2746$r8$lambda$vPyRBb4AxRzu_Ov6pF_idRzni0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "");
        function0.invoke();
    }

    public static final /* synthetic */ void access$openMerchantPhotoViewerDialog(MerchantBannerView merchantBannerView, int i) {
        BaseActivity baseActivity;
        if (merchantBannerView.PlaceComponentResult == null || (baseActivity = merchantBannerView.getBaseActivity()) == null) {
            return;
        }
        ShopModel shopModel = merchantBannerView.PlaceComponentResult;
        Intrinsics.checkNotNull(shopModel);
        NearbyViewExtKt.PlaceComponentResult(baseActivity, shopModel, i, merchantBannerView.getAuthRequestContext);
    }

    public final void setMerchantImages(List<MerchantImageModel> merchantImages, int currentSelectedPage) {
        List<? extends SimpleView> list;
        Intrinsics.checkNotNullParameter(merchantImages, "");
        ViewSkeletonScreen viewSkeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.PlaceComponentResult();
        }
        List<MerchantImageModel> list2 = merchantImages;
        if (list2.isEmpty()) {
            this.getAuthRequestContext.clear();
        } else {
            this.getAuthRequestContext = CollectionsKt.toMutableList((Collection) list2);
        }
        if (this.getAuthRequestContext.isEmpty()) {
            list = CollectionsKt.emptyList();
        } else {
            List<MerchantImageModel> list3 = this.getAuthRequestContext;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
            Iterator<T> it = list3.iterator();
            while (it.hasNext()) {
                arrayList.add(new MerchantBannerItemView(((MerchantImageModel) it.next()).BuiltInFictitiousFunctionClassFactory));
            }
            list = CollectionsKt.toList(arrayList);
        }
        MerchantBannerPagerAdapter merchantBannerPagerAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        MerchantBannerPagerAdapter merchantBannerPagerAdapter2 = null;
        if (merchantBannerPagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            merchantBannerPagerAdapter = null;
        }
        merchantBannerPagerAdapter.KClassImpl$Data$declaredNonStaticMembers$2(list);
        MerchantBannerPagerAdapter merchantBannerPagerAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (merchantBannerPagerAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            merchantBannerPagerAdapter2 = merchantBannerPagerAdapter3;
        }
        merchantBannerPagerAdapter2.notifyDataSetChanged();
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.resolveActivity);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(list.size() > 1 ? 0 : 8);
        }
        ImageView imageView = (ImageView) _$_findCachedViewById(R.id.ivMerchantBannerEmptyState);
        if (imageView != null) {
            imageView.setVisibility(list2.isEmpty() ? 0 : 8);
        }
        ViewPager viewPager = (ViewPager) _$_findCachedViewById(R.id.setFixedLengthStreamingMode);
        if (viewPager != null) {
            viewPager.setCurrentItem(currentSelectedPage);
        }
    }

    public final void showLoading() {
        Unit unit;
        ViewSkeletonScreen viewSkeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (viewSkeletonScreen != null) {
            viewSkeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult((ViewPager) _$_findCachedViewById(R.id.setFixedLengthStreamingMode), R.layout.view_merchant_banner_skeleton);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.resolveActivity);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(4);
        }
    }
}
