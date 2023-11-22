package id.dana.nearbyme.merchantdetail.viewcomponent;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.animation.RoundedCornersTransformation;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.core.ui.svg.SvgLoader;
import id.dana.utils.ShimmeringUtil;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010/\u001a\u00020\u000b¢\u0006\u0004\b0\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\b\u0010\u0007J#\u0010\r\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\r\u0010\u0010\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0007R\u0014\u0010\u0013\u001a\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R*\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR.\u0010#\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001c8\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010'\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0016\u001a\u0004\b%\u0010\u0018\"\u0004\b&\u0010\u001aR*\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00148\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001aR\u0018\u0010(\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b-\u0010."}, d2 = {"Lid/dana/nearbyme/merchantdetail/viewcomponent/MerchantSummaryInfoView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "hideShimmer", "()V", "onAttachedToWindow", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setup", "showShimmer", "BuiltInFictitiousFunctionClassFactory", "Landroid/util/AttributeSet;", "MyBillsEntityDataFactory", "", "value", "Ljava/lang/String;", "getMerchantCategory", "()Ljava/lang/String;", "setMerchantCategory", "(Ljava/lang/String;)V", "merchantCategory", "Landroid/graphics/drawable/Drawable;", "PlaceComponentResult", "Landroid/graphics/drawable/Drawable;", "getMerchantLogoDrawable", "()Landroid/graphics/drawable/Drawable;", "setMerchantLogoDrawable", "(Landroid/graphics/drawable/Drawable;)V", "merchantLogoDrawable", "getAuthRequestContext", "getMerchantLogoUrl", "setMerchantLogoUrl", "merchantLogoUrl", "KClassImpl$Data$declaredNonStaticMembers$2", "getMerchantName", "setMerchantName", "merchantName", "Lcom/ethanhua/skeleton/SkeletonScreen;", "scheduleImpl", "Lcom/ethanhua/skeleton/SkeletonScreen;", "attributeSet", "<init>"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantSummaryInfoView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final AttributeSet MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String merchantName;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String merchantCategory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Drawable merchantLogoDrawable;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String merchantLogoUrl;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SkeletonScreen KClassImpl$Data$declaredNonStaticMembers$2;

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
        return R.layout.view_merchant_summary_info;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantSummaryInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(attributeSet, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = attributeSet;
        this.merchantName = "";
        this.merchantCategory = "";
    }

    @JvmName(name = "getMerchantName")
    public final String getMerchantName() {
        return this.merchantName;
    }

    @JvmName(name = "setMerchantName")
    public final void setMerchantName(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_merchant_name);
        if (textView != null) {
            textView.setText(str);
        }
        this.merchantName = str;
    }

    @JvmName(name = "getMerchantCategory")
    public final String getMerchantCategory() {
        return this.merchantCategory;
    }

    @JvmName(name = "setMerchantCategory")
    public final void setMerchantCategory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tv_merchant_category);
        if (textView != null) {
            textView.setText(str);
        }
        this.merchantCategory = str;
    }

    @JvmName(name = "getMerchantLogoUrl")
    public final String getMerchantLogoUrl() {
        return this.merchantLogoUrl;
    }

    @JvmName(name = "getMerchantLogoDrawable")
    public final Drawable getMerchantLogoDrawable() {
        return this.merchantLogoDrawable;
    }

    public final void showShimmer() {
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
        }
    }

    public final void hideShimmer() {
        SkeletonScreen skeletonScreen = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    @Override // id.dana.base.BaseRichView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.KClassImpl$Data$declaredNonStaticMembers$2 = ShimmeringUtil.PlaceComponentResult((ImageView) _$_findCachedViewById(R.id.iv_merchant_logo), R.layout.view_skeleton_merchant_logo);
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context r3, AttributeSet attrs) {
        if (r3 != null) {
            TypedArray obtainStyledAttributes = r3.obtainStyledAttributes(attrs, R.styleable.setValuePrefixBytes);
            String string = obtainStyledAttributes.getString(2);
            if (string == null) {
                string = "";
            }
            setMerchantName(string);
            String string2 = obtainStyledAttributes.getString(0);
            setMerchantCategory(string2 != null ? string2 : "");
            setMerchantLogoDrawable(ResourcesCompat.BuiltInFictitiousFunctionClassFactory(obtainStyledAttributes.getResources(), obtainStyledAttributes.getResourceId(1, R.drawable.ic_merchant_logo_null), null));
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    @JvmName(name = "setMerchantLogoDrawable")
    public final void setMerchantLogoDrawable(Drawable drawable) {
        RequestBuilder<Drawable> MyBillsEntityDataFactory = Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).MyBillsEntityDataFactory(drawable);
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.BuiltInFictitiousFunctionClassFactory(R.drawable.ic_merchant_logo_null);
        requestOptions.getAuthRequestContext(new CenterCrop(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 1, RoundedCornersTransformation.CornerType.ALL));
        MyBillsEntityDataFactory.MyBillsEntityDataFactory((BaseRequestOptions<?>) requestOptions).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_merchant_logo));
        this.merchantLogoDrawable = drawable;
    }

    @JvmName(name = "setMerchantLogoUrl")
    public final void setMerchantLogoUrl(String str) {
        byte b = 0;
        if (SvgLoader.getAuthRequestContext(str)) {
            SvgLoader.Builder KClassImpl$Data$declaredNonStaticMembers$2 = SvgLoader.KClassImpl$Data$declaredNonStaticMembers$2(getContext());
            KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory = str;
            KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult = (ImageView) _$_findCachedViewById(R.id.iv_merchant_photo);
            new SvgLoader(KClassImpl$Data$declaredNonStaticMembers$2, b);
        } else {
            GlideRequest<Drawable> MyBillsEntityDataFactory = GlideApp.getAuthRequestContext(getContext()).PlaceComponentResult(str).PlaceComponentResult((int) R.drawable.ic_merchant_logo_null).MyBillsEntityDataFactory(DiskCacheStrategy.getAuthRequestContext);
            RequestOptions requestOptions = new RequestOptions();
            requestOptions.getAuthRequestContext(new CenterCrop(), new RoundedCornersTransformation(getContext().getResources().getDimensionPixelSize(R.dimen.f28552131165359), 1, RoundedCornersTransformation.CornerType.ALL));
            MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory((BaseRequestOptions<?>) requestOptions).MyBillsEntityDataFactory((ImageView) _$_findCachedViewById(R.id.iv_merchant_logo));
        }
        this.merchantLogoUrl = str;
    }
}
