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
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;
import com.bumptech.glide.util.Executors;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.ViewSkeletonScreen;
import com.google.common.base.Ascii;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.glide.GlideRequest;
import id.dana.extension.view.ViewExtKt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b'\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\r\u0010\f\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000f¢\u0006\u0004\b\u0014\u0010\u0012J\u000f\u0010\u0015\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0015\u0010\rJ\u0015\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0018\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000f2\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u001cR\u0017\u0010 \u001a\u0006*\u00020\u001d0\u001dX\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010!\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010#\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010$"}, d2 = {"Lid/dana/richview/imageview/ImageWithRibbonView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "removeImageGreyscale", "()V", "setImageGreyscale", "", "description", "setRibbonTextLineBottom", "(Ljava/lang/String;)V", "title", "setRibbonTextLineTop", "setup", "Landroid/graphics/drawable/Drawable;", "src", "showImage", "(Landroid/graphics/drawable/Drawable;)V", "url", "placeholderDrawable", "(Ljava/lang/String;I)V", "Lcom/ethanhua/skeleton/ViewSkeletonScreen;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lkotlin/Lazy;", "MyBillsEntityDataFactory", "BuiltInFictitiousFunctionClassFactory", "Landroid/graphics/drawable/Drawable;", "getAuthRequestContext", "Ljava/lang/String;", "moveToNextValue", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ImageWithRibbonView extends BaseRichView {
    public static final byte[] MyBillsEntityDataFactory = {8, 17, -121, -18, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int PlaceComponentResult = 246;
    private Drawable BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;
    public Map<Integer, View> _$_findViewCache;
    private String getAuthRequestContext;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private String KClassImpl$Data$declaredNonStaticMembers$2;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWithRibbonView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImageWithRibbonView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_image_with_ribbon;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithRibbonView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.richview.imageview.ImageWithRibbonView$skeletonLogo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(ImageWithRibbonView.this._$_findCachedViewById(R.id.getDeviceRamSizeKb));
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_merchant_logo_skeleton;
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

    public /* synthetic */ ImageWithRibbonView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImageWithRibbonView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<ViewSkeletonScreen>() { // from class: id.dana.richview.imageview.ImageWithRibbonView$skeletonLogo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewSkeletonScreen invoke() {
                ViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(ImageWithRibbonView.this._$_findCachedViewById(R.id.getDeviceRamSizeKb));
                BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = R.layout.view_merchant_logo_skeleton;
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
        Drawable drawable = this.BuiltInFictitiousFunctionClassFactory;
        if (drawable != null) {
            showImage(drawable);
        }
        String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (str != null) {
            setRibbonTextLineTop(str);
        }
        String str2 = this.getAuthRequestContext;
        if (str2 != null) {
            setRibbonTextLineBottom(str2);
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.FlowableKt$toIterable$1);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                this.BuiltInFictitiousFunctionClassFactory = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 2);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getString(1);
                this.getAuthRequestContext = obtainStyledAttributes.getString(0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void showImage(Drawable src) {
        Intrinsics.checkNotNullParameter(src, "");
        GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().getErrorConfigVersion((int) R.drawable.ic_placeholder_merchant).BuiltInFictitiousFunctionClassFactory(src).PlaceComponentResult((int) R.drawable.ic_placeholder_merchant).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.requiresTunnel)));
    }

    public static /* synthetic */ void showImage$default(ImageWithRibbonView imageWithRibbonView, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = R.drawable.ic_placeholder_merchant;
        }
        imageWithRibbonView.showImage(str, i);
    }

    public final void showImage(String url, int placeholderDrawable) {
        Executor executor;
        Intrinsics.checkNotNullParameter(url, "");
        GlideRequest<Bitmap> PlaceComponentResult2 = GlideApp.getAuthRequestContext(getContext()).MyBillsEntityDataFactory().getErrorConfigVersion(placeholderDrawable).BuiltInFictitiousFunctionClassFactory(url).PlaceComponentResult(placeholderDrawable);
        final View _$_findCachedViewById = _$_findCachedViewById(R.id.requiresTunnel);
        CustomViewTarget<AppCompatImageView, Bitmap> customViewTarget = new CustomViewTarget<AppCompatImageView, Bitmap>(_$_findCachedViewById) { // from class: id.dana.richview.imageview.ImageWithRibbonView$showImage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super((AppCompatImageView) _$_findCachedViewById);
            }

            @Override // com.bumptech.glide.request.target.Target
            public final /* synthetic */ void onResourceReady(Object obj, Transition transition) {
                Bitmap bitmap = (Bitmap) obj;
                Intrinsics.checkNotNullParameter(bitmap, "");
                ImageWithRibbonView.access$getSkeletonLogo(ImageWithRibbonView.this).PlaceComponentResult();
                ((AppCompatImageView) ImageWithRibbonView.this._$_findCachedViewById(R.id.requiresTunnel)).setImageBitmap(bitmap);
            }

            @Override // com.bumptech.glide.request.target.CustomViewTarget
            public final void KClassImpl$Data$declaredNonStaticMembers$2(Drawable p0) {
                ImageWithRibbonView.access$getSkeletonLogo(ImageWithRibbonView.this).MyBillsEntityDataFactory();
                super.KClassImpl$Data$declaredNonStaticMembers$2(p0);
            }

            @Override // com.bumptech.glide.request.target.Target
            public final void onLoadFailed(Drawable p0) {
                ImageWithRibbonView.access$getSkeletonLogo(ImageWithRibbonView.this).PlaceComponentResult();
                ((AppCompatImageView) ImageWithRibbonView.this._$_findCachedViewById(R.id.requiresTunnel)).setImageDrawable(p0);
            }

            @Override // com.bumptech.glide.request.target.CustomViewTarget
            public final void MyBillsEntityDataFactory(Drawable p0) {
                ImageWithRibbonView.access$getSkeletonLogo(ImageWithRibbonView.this).PlaceComponentResult();
                ((AppCompatImageView) ImageWithRibbonView.this._$_findCachedViewById(R.id.requiresTunnel)).setImageDrawable(p0);
            }
        };
        executor = Executors.PlaceComponentResult;
        PlaceComponentResult2.BuiltInFictitiousFunctionClassFactory(customViewTarget, null, PlaceComponentResult2, executor);
    }

    public final void setRibbonTextLineTop(String title) {
        Intrinsics.checkNotNullParameter(title, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.millisToJulianDay);
        if (textView != null) {
            textView.setText(title);
        }
    }

    public final void setRibbonTextLineBottom(String description) {
        Intrinsics.checkNotNullParameter(description, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.millisToJulianDay);
        if (textView != null) {
            textView.setText(description);
        }
    }

    public final void setImageGreyscale() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.requiresTunnel);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView);
    }

    public final void removeImageGreyscale() {
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.requiresTunnel);
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
        ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x0041 -> B:15:0x004b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r10, int r11) {
        /*
            byte[] r0 = id.dana.richview.imageview.ImageWithRibbonView.MyBillsEntityDataFactory
            r1 = 23
            byte[] r1 = new byte[r1]
            r2 = 22
            r3 = 0
            r4 = 97
            r5 = 3
            if (r0 != 0) goto L17
            r5 = r1
            r6 = 22
            r7 = 3
            r8 = 0
            r1 = r0
            r0 = r11
            r11 = r10
            goto L4b
        L17:
            r4 = r1
            r5 = 97
            r6 = 3
            r7 = 0
            r1 = r0
            r0 = r11
            r11 = r10
        L1f:
            int r6 = r6 + 1
            byte r8 = (byte) r5
            r4[r7] = r8
            if (r7 != r2) goto L41
            java.lang.String r1 = new java.lang.String
            r1.<init>(r4, r3)
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
            int r7 = r7 + 1
            r8 = r1[r6]
            r9 = r5
            r5 = r4
            r4 = r8
            r8 = r7
            r7 = r6
            r6 = r9
        L4b:
            int r6 = r6 + r4
            int r4 = r6 + (-8)
            r6 = r7
            r7 = r8
            r9 = r5
            r5 = r4
            r4 = r9
            goto L1f
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.imageview.ImageWithRibbonView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }

    public static final /* synthetic */ ViewSkeletonScreen access$getSkeletonLogo(ImageWithRibbonView imageWithRibbonView) {
        return (ViewSkeletonScreen) imageWithRibbonView.MyBillsEntityDataFactory.getValue();
    }
}
