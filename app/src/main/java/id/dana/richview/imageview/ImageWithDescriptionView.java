package id.dana.richview.imageview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import com.alibaba.griver.api.constants.GriverEvents;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010+\u001a\u00020\u0002¢\u0006\u0004\b,\u0010-B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\u0006\u0010.\u001a\u00020\u0002¢\u0006\u0004\b,\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u000fJ\u0015\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\f¢\u0006\u0004\b\u0013\u0010\u000fJ\u000f\u0010\u0014\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u000fR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010!\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010\u001cR\u0017\u0010(\u001a\u0006*\u00020%0%X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010*\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010\u001c"}, d2 = {"Lid/dana/richview/imageview/ImageWithDescriptionView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "description", "setDescription", "(Ljava/lang/String;)V", "note", "setNote", "title", GriverEvents.EVENT_SET_TITLE, "setup", "()V", "Landroid/graphics/drawable/Drawable;", "src", "showImage", "(Landroid/graphics/drawable/Drawable;)V", "url", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "MyBillsEntityDataFactory", "Landroid/graphics/drawable/Drawable;", "Lcom/bumptech/glide/load/MultiTransformation;", "Landroid/graphics/Bitmap;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lcom/bumptech/glide/load/MultiTransformation;", "moveToNextValue", "getAuthRequestContext", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "lookAheadTest", "Lkotlin/Lazy;", "PlaceComponentResult", "getErrorConfigVersion", "scheduleImpl", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageWithDescriptionView extends BaseRichView {
    public static final byte[] PlaceComponentResult = {113, 46, 115, -60, -21, 2, -22, -5, -2, -3, 46, -61, -20, -7, -14, 7, -17, -14, 62, -29, -52, -7, -14, 7, -27, -4};
    public static final int getAuthRequestContext = 224;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    private MultiTransformation<Bitmap> KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Drawable BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private String scheduleImpl;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private final Lazy PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWithDescriptionView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWithDescriptionView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_image_with_description;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithDescriptionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.richview.imageview.ImageWithDescriptionView$skeletonLogo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(ImageWithDescriptionView.this._$_findCachedViewById(R.id.view_sku_logo_skeleton));
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_sku_logo_skeleton;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1000;
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                return viewSkeletonScreen;
            }
        });
    }

    public /* synthetic */ ImageWithDescriptionView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithDescriptionView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.richview.imageview.ImageWithDescriptionView$skeletonLogo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(ImageWithDescriptionView.this._$_findCachedViewById(R.id.view_sku_logo_skeleton));
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_sku_logo_skeleton;
                BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = 1000;
                BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = true;
                BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.lookAheadTest.getContext(), R.color.f27082131100491);
                BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = 20;
                ViewSkeletonScreen viewSkeletonScreen = new ViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
                viewSkeletonScreen.MyBillsEntityDataFactory();
                return viewSkeletonScreen;
            }
        });
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new MultiTransformation<>(new CenterCrop(), new RoundedCorners(getContext().getResources().getDimensionPixelSize(R.dimen.f28142131165293)));
        Drawable drawable = this.BuiltInFictitiousFunctionClassFactory;
        if (drawable != null) {
            showImage(drawable);
        }
        String str = this.scheduleImpl;
        if (str != null) {
            setTitle(str);
        }
        String str2 = this.MyBillsEntityDataFactory;
        if (str2 != null) {
            setDescription(str2);
        }
        String str3 = this.getAuthRequestContext;
        if (str3 != null) {
            setNote(str3);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.NewMerchantCategoryAdapter);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 2);
                this.scheduleImpl = obtainStyledAttributes.getString(3);
                this.MyBillsEntityDataFactory = obtainStyledAttributes.getString(0);
                this.getAuthRequestContext = obtainStyledAttributes.getString(1);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void showImage(Drawable src) {
        Intrinsics.checkNotNullParameter(src, "");
        GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().getErrorConfigVersion((int) R.drawable.ic_placeholder_merchant).BuiltInFictitiousFunctionClassFactory(src).PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult((int) R.drawable.ic_placeholder_merchant).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat)));
    }

    public final void showImage(String url) {
        Executor executor;
        Intrinsics.checkNotNullParameter(url, "");
        GlideRequest<Bitmap> PlaceComponentResult2 = GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().getErrorConfigVersion((int) R.drawable.ic_placeholder_merchant).BuiltInFictitiousFunctionClassFactory(url).PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2).PlaceComponentResult((int) R.drawable.ic_placeholder_merchant);
        final View _$_findCachedViewById = _$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat);
        CustomViewTarget<AppCompatImageView, Bitmap> customViewTarget = new CustomViewTarget<AppCompatImageView, Bitmap>(_$_findCachedViewById) { // from class: id.dana.richview.imageview.ImageWithDescriptionView$showImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((AppCompatImageView) _$_findCachedViewById);
            }

            @Override // com.bumptech.glide.request.target.Target
            public final /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                Bitmap bitmap = (Bitmap) obj;
                Intrinsics.checkNotNullParameter(bitmap, "");
                ImageWithDescriptionView.access$getSkeletonLogo(ImageWithDescriptionView.this).PlaceComponentResult();
                ((AppCompatImageView) ImageWithDescriptionView.this._$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat)).setImageBitmap(bitmap);
            }

            @Override // com.bumptech.glide.request.target.CustomViewTarget
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Drawable p0) {
                ImageWithDescriptionView.access$getSkeletonLogo(ImageWithDescriptionView.this).MyBillsEntityDataFactory();
                super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // com.bumptech.glide.request.target.Target
            public final void onLoadFailed(Drawable p0) {
                ImageWithDescriptionView.access$getSkeletonLogo(ImageWithDescriptionView.this).PlaceComponentResult();
                ((AppCompatImageView) ImageWithDescriptionView.this._$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat)).setImageDrawable(p0);
            }

            @Override // com.bumptech.glide.request.target.CustomViewTarget
            public final void MyBillsEntityDataFactory(Drawable p0) {
                ImageWithDescriptionView.access$getSkeletonLogo(ImageWithDescriptionView.this).PlaceComponentResult();
                ((AppCompatImageView) ImageWithDescriptionView.this._$_findCachedViewById(R.id.res_0x7f0a09f1_access_setbufferat)).setImageDrawable(p0);
            }
        };
        executor = Executors.PlaceComponentResult;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(customViewTarget, null, PlaceComponentResult2, executor);
    }

    public final void setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.getLogSourceName);
        if (textView != null) {
            textView.setText(title);
        }
    }

    public final void setDescription(String description) {
        Intrinsics.checkNotNullParameter(description, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.isHelperTextDisplayed);
        if (textView != null) {
            textView.setText(description);
        }
    }

    public final void setNote(String note) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.FriendListPresenter_Factory);
        if (textView != null) {
            String str = note;
            textView.setText(str);
            textView.setVisibility((str == null || str.length() == 0) ^ true ? 0 : 8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x0048). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.richview.imageview.ImageWithDescriptionView.PlaceComponentResult
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 97
            r4 = 0
            r5 = 4
            if (r0 != 0) goto L17
            r5 = r1
            r6 = 22
            r7 = 4
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L48
        L17:
            r3 = r1
            r5 = 97
            r6 = 4
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            byte r8 = (byte) r5
            r3[r7] = r8
            int r8 = r7 + 1
            if (r7 != r2) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r10 = r1.isInstance(r10)
            if (r10 == 0) goto L3c
            android.content.Context r11 = (android.content.Context) r11
            android.graphics.drawable.Drawable r10 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r11, r0)
            return r10
        L3c:
            android.graphics.drawable.Drawable r10 = r11.getDrawable(r0)
            return r10
        L41:
            r7 = r1[r6]
            r9 = r5
            r5 = r3
            r3 = r7
            r7 = r6
            r6 = r9
        L48:
            int r3 = -r3
            int r6 = r6 + r3
            int r3 = r6 + (-8)
            int r6 = r7 + 1
            r7 = r8
            r9 = r5
            r5 = r3
            r3 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.imageview.ImageWithDescriptionView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public static final /* synthetic */ ViewSkeletonScreen access$getSkeletonLogo(ImageWithDescriptionView imageWithDescriptionView) {
        return (ViewSkeletonScreen) imageWithDescriptionView.PlaceComponentResult.getValue();
    }
}
