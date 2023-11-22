package id.dana.richview.wallet;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.android.material.card.MaterialCardView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.iap.ac.android.region.cdp.util.CdpConstants;
import id.dana.R;
import id.dana.component.utils.SizeUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 22\u00020\u0001:\u000223B'\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\b\b\u0002\u0010-\u001a\u00020\t¢\u0006\u0004\b.\u0010/B+\b\u0016\u0012\u0006\u0010*\u001a\u00020)\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\u0006\u0010-\u001a\u00020\t\u0012\u0006\u00100\u001a\u00020\t¢\u0006\u0004\b.\u00101J(\u0010\u0007\u001a\u00020\u00042\u0019\u0010\u0006\u001a\u0015\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0002\b\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\tH&¢\u0006\u0004\b\u000f\u0010\u000bJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\tH\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001c\u0010\u0015J\u000f\u0010\u001d\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u001d\u0010\u0015J\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\fH\u0004¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\fH\u0004¢\u0006\u0004\b\"\u0010 J\u000f\u0010#\u001a\u00020\u0004H\u0016¢\u0006\u0004\b#\u0010\u0015J\u000f\u0010$\u001a\u00020\u0004H\u0014¢\u0006\u0004\b$\u0010\u0015J\u0019\u0010'\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010%H\u0004¢\u0006\u0004\b'\u0010("}, d2 = {"Lid/dana/richview/wallet/BaseWalletDefaultCardView;", "Lid/dana/richview/wallet/BaseWalletCardView;", "Lkotlin/Function1;", "Lcom/google/android/material/card/MaterialCardView;", "", "Lkotlin/ExtensionFunctionType;", "apply", "customCard", "(Lkotlin/jvm/functions/Function1;)V", "", "getBackgroundDrawableRes", "()I", "", "getBackgroundUrl", "()Ljava/lang/String;", "getCardContentLayout", "getLayout", "Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "getWalletCardListener", "()Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "initListener", "()V", "initOnCardHold", "invokeListeners", "color", "", "isDark", "(I)Z", "onAttachedToWindow", "setCardBackground", "value", "setCardContentDescription", "(Ljava/lang/String;)V", "ratio", "setCustomCardRatio", "setup", "setupMiniCard", "Landroid/graphics/Bitmap;", "backgroundBitmap", "updateTextColor", "(Landroid/graphics/Bitmap;)V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion", "WalletCardListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseWalletDefaultCardView extends BaseWalletCardView {
    private static final double COLOR_LUMINANCE_THRESHOLD = 0.5d;
    private static final int RADIUS_CARD = 16;
    private static final int RADIUS_MINI_CARD = 10;
    private static final int WIDTH_CARD = 114;
    public Map<Integer, View> _$_findViewCache;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lid/dana/richview/wallet/BaseWalletDefaultCardView$WalletCardListener;", "", "onCardClicked", "", "onCardHold", "onUpdateTextColor", CdpConstants.CONTENT_TEXT_COLOR, "", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface WalletCardListener {

        /* renamed from: id.dana.richview.wallet.BaseWalletDefaultCardView$WalletCardListener$-CC  reason: invalid class name */
        /* loaded from: classes5.dex */
        public final /* synthetic */ class CC {
            public static void BuiltInFictitiousFunctionClassFactory() {
            }

            public static void KClassImpl$Data$declaredNonStaticMembers$2() {
            }

            public static void PlaceComponentResult() {
            }
        }

        void onCardClicked();

        void onCardHold();

        void onUpdateTextColor(int textColor);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWalletDefaultCardView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseWalletDefaultCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public View _$_findCachedViewById(int i) {
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

    public abstract int getBackgroundDrawableRes();

    public abstract String getBackgroundUrl();

    public abstract int getCardContentLayout();

    @Override // id.dana.component.BaseRichView
    public int getLayout() {
        return R.layout.view_base_wallet_card;
    }

    public abstract WalletCardListener getWalletCardListener();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWalletDefaultCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ BaseWalletDefaultCardView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseWalletDefaultCardView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @Override // id.dana.component.BaseRichView
    public void setup() {
        View inflate = LayoutInflater.from(getContext()).inflate(getCardContentLayout(), (ViewGroup) null);
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0592_nearbysearchpresenter_getnearbytrendingkeyword_2);
        if (materialCardView != null) {
            materialCardView.addView(inflate);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setCardBackground();
        initListener();
    }

    protected void initListener() {
        initOnCardHold();
    }

    @Override // id.dana.richview.wallet.BaseWalletCardView
    public void invokeListeners() {
        getWalletCardListener().onCardClicked();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCustomCardRatio(String ratio) {
        Intrinsics.checkNotNullParameter(ratio, "");
        ViewGroup.LayoutParams layoutParams = ((MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0592_nearbysearchpresenter_getnearbytrendingkeyword_2)).getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ((ConstraintLayout.LayoutParams) layoutParams).GetContactSyncConfig = ratio;
    }

    private final void initOnCardHold() {
        setOnLongClickListener(new View.OnLongClickListener() { // from class: id.dana.richview.wallet.BaseWalletDefaultCardView$$ExternalSyntheticLambda0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean m2864initOnCardHold$lambda0;
                m2864initOnCardHold$lambda0 = BaseWalletDefaultCardView.m2864initOnCardHold$lambda0(BaseWalletDefaultCardView.this, view);
                return m2864initOnCardHold$lambda0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initOnCardHold$lambda-0  reason: not valid java name */
    public static final boolean m2864initOnCardHold$lambda0(BaseWalletDefaultCardView baseWalletDefaultCardView, View view) {
        Intrinsics.checkNotNullParameter(baseWalletDefaultCardView, "");
        baseWalletDefaultCardView.getWalletCardListener().onCardHold();
        return true;
    }

    protected void setCardBackground() {
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0592_nearbysearchpresenter_getnearbytrendingkeyword_2);
        if (materialCardView != null) {
            materialCardView.setRadius(SizeUtil.PlaceComponentResult(16));
        }
        Glide.KClassImpl$Data$declaredNonStaticMembers$2(getContext()).PlaceComponentResult().PlaceComponentResult(getBackgroundUrl()).BuiltInFictitiousFunctionClassFactory(getBackgroundDrawableRes()).getAuthRequestContext(new RequestListener<Bitmap>() { // from class: id.dana.richview.wallet.BaseWalletDefaultCardView$setCardBackground$1
            @Override // com.bumptech.glide.request.RequestListener
            public final boolean onLoadFailed(GlideException p0, Object p1, Target<Bitmap> p2, boolean p3) {
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public final /* synthetic */ boolean onResourceReady(Bitmap bitmap, Object obj, Target<Bitmap> target, DataSource dataSource, boolean z) {
                return BuiltInFictitiousFunctionClassFactory(bitmap);
            }

            private boolean BuiltInFictitiousFunctionClassFactory(Bitmap bitmap) {
                BaseWalletDefaultCardView.this.updateTextColor(bitmap);
                return false;
            }
        }).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c6e_daggerstickysummarycomponent_stickysummarycomponentimpl_postexecutionthreadprovider)));
    }

    public final void customCard(Function1<? super MaterialCardView, Unit> apply) {
        Intrinsics.checkNotNullParameter(apply, "");
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0592_nearbysearchpresenter_getnearbytrendingkeyword_2);
        Intrinsics.checkNotNullExpressionValue(materialCardView, "");
        apply.invoke(materialCardView);
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [androidx.palette.graphics.Palette$Builder$1] */
    public final void updateTextColor(Bitmap backgroundBitmap) {
        if (backgroundBitmap != null) {
            final Palette.Builder PlaceComponentResult = Palette.PlaceComponentResult(backgroundBitmap);
            final Palette.PaletteAsyncListener paletteAsyncListener = new Palette.PaletteAsyncListener() { // from class: id.dana.richview.wallet.BaseWalletDefaultCardView$$ExternalSyntheticLambda1
                @Override // androidx.palette.graphics.Palette.PaletteAsyncListener
                public final void BuiltInFictitiousFunctionClassFactory(Palette palette) {
                    BaseWalletDefaultCardView.m2865updateTextColor$lambda2$lambda1(BaseWalletDefaultCardView.this, palette);
                }
            };
            new AsyncTask<Bitmap, Void, Palette>() { // from class: androidx.palette.graphics.Palette.Builder.1
                @Override // android.os.AsyncTask
                protected /* synthetic */ Palette doInBackground(Bitmap[] bitmapArr) {
                    return MyBillsEntityDataFactory();
                }

                @Override // android.os.AsyncTask
                protected /* synthetic */ void onPostExecute(Palette palette) {
                    paletteAsyncListener.BuiltInFictitiousFunctionClassFactory(palette);
                }

                private Palette MyBillsEntityDataFactory() {
                    List<Swatch> list;
                    int max;
                    int i;
                    Filter[] filterArr;
                    try {
                        Builder builder = PlaceComponentResult;
                        Bitmap bitmap = builder.MyBillsEntityDataFactory;
                        char c = 0;
                        if (bitmap == null) {
                            list = builder.scheduleImpl;
                            if (list == null) {
                                throw new AssertionError();
                            }
                        } else {
                            double d = -1.0d;
                            if (builder.PlaceComponentResult > 0) {
                                int width = bitmap.getWidth() * bitmap.getHeight();
                                int i2 = builder.PlaceComponentResult;
                                if (width > i2) {
                                    double d2 = i2;
                                    double d3 = width;
                                    Double.isNaN(d2);
                                    Double.isNaN(d3);
                                    d = Math.sqrt(d2 / d3);
                                }
                            } else if (builder.getErrorConfigVersion > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i = builder.getErrorConfigVersion)) {
                                double d4 = i;
                                double d5 = max;
                                Double.isNaN(d4);
                                Double.isNaN(d5);
                                d = d4 / d5;
                            }
                            if (d > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                double width2 = bitmap.getWidth();
                                Double.isNaN(width2);
                                int ceil = (int) Math.ceil(width2 * d);
                                double height = bitmap.getHeight();
                                Double.isNaN(height);
                                bitmap = Bitmap.createScaledBitmap(bitmap, ceil, (int) Math.ceil(height * d), false);
                            }
                            Rect rect = builder.BuiltInFictitiousFunctionClassFactory;
                            if (bitmap != builder.MyBillsEntityDataFactory && rect != null) {
                                double width3 = bitmap.getWidth();
                                double width4 = builder.MyBillsEntityDataFactory.getWidth();
                                Double.isNaN(width3);
                                Double.isNaN(width4);
                                double d6 = width3 / width4;
                                double d7 = rect.left;
                                Double.isNaN(d7);
                                rect.left = (int) Math.floor(d7 * d6);
                                double d8 = rect.top;
                                Double.isNaN(d8);
                                rect.top = (int) Math.floor(d8 * d6);
                                double d9 = rect.right;
                                Double.isNaN(d9);
                                rect.right = Math.min((int) Math.ceil(d9 * d6), bitmap.getWidth());
                                double d10 = rect.bottom;
                                Double.isNaN(d10);
                                rect.bottom = Math.min((int) Math.ceil(d10 * d6), bitmap.getHeight());
                            }
                            int width5 = bitmap.getWidth();
                            int height2 = bitmap.getHeight();
                            int[] iArr = new int[width5 * height2];
                            bitmap.getPixels(iArr, 0, width5, 0, 0, width5, height2);
                            Rect rect2 = builder.BuiltInFictitiousFunctionClassFactory;
                            if (rect2 != null) {
                                int width6 = rect2.width();
                                int height3 = builder.BuiltInFictitiousFunctionClassFactory.height();
                                int[] iArr2 = new int[width6 * height3];
                                for (int i3 = 0; i3 < height3; i3++) {
                                    System.arraycopy(iArr, ((builder.BuiltInFictitiousFunctionClassFactory.top + i3) * width5) + builder.BuiltInFictitiousFunctionClassFactory.left, iArr2, i3 * width6, width6);
                                }
                                iArr = iArr2;
                            }
                            int i4 = builder.getAuthRequestContext;
                            if (builder.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                                filterArr = null;
                            } else {
                                List<Filter> list2 = builder.KClassImpl$Data$declaredNonStaticMembers$2;
                                filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                            }
                            ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(iArr, i4, filterArr);
                            if (bitmap != builder.MyBillsEntityDataFactory) {
                                bitmap.recycle();
                            }
                            list = colorCutQuantizer.KClassImpl$Data$declaredNonStaticMembers$2;
                        }
                        Palette palette = new Palette(list, builder.NetworkUserEntityData$$ExternalSyntheticLambda0);
                        int size = palette.MyBillsEntityDataFactory.size();
                        int i5 = 0;
                        while (i5 < size) {
                            Target target = palette.MyBillsEntityDataFactory.get(i5);
                            int length = target.lookAheadTest.length;
                            float f = 0.0f;
                            float f2 = 0.0f;
                            for (int i6 = 0; i6 < length; i6++) {
                                float f3 = target.lookAheadTest[i6];
                                if (f3 > 0.0f) {
                                    f2 += f3;
                                }
                            }
                            if (f2 != 0.0f) {
                                int length2 = target.lookAheadTest.length;
                                for (int i7 = 0; i7 < length2; i7++) {
                                    float[] fArr = target.lookAheadTest;
                                    float f4 = fArr[i7];
                                    if (f4 > 0.0f) {
                                        fArr[i7] = f4 / f2;
                                    }
                                }
                            }
                            Map<Target, Swatch> map = palette.BuiltInFictitiousFunctionClassFactory;
                            int size2 = palette.getAuthRequestContext.size();
                            int i8 = 0;
                            Swatch swatch = null;
                            float f5 = 0.0f;
                            while (i8 < size2) {
                                Swatch swatch2 = palette.getAuthRequestContext.get(i8);
                                if (palette.getAuthRequestContext(swatch2, target)) {
                                    float[] PlaceComponentResult2 = swatch2.PlaceComponentResult();
                                    Swatch swatch3 = palette.KClassImpl$Data$declaredNonStaticMembers$2;
                                    float abs = (target.lookAheadTest[c] > f ? target.lookAheadTest[c] * (1.0f - Math.abs(PlaceComponentResult2[1] - target.getErrorConfigVersion[1])) : 0.0f) + (target.lookAheadTest[1] > f ? target.lookAheadTest[1] * (1.0f - Math.abs(PlaceComponentResult2[2] - target.moveToNextValue[1])) : 0.0f) + (target.lookAheadTest[2] > 0.0f ? target.lookAheadTest[2] * (swatch2.getAuthRequestContext / (swatch3 != null ? swatch3.getAuthRequestContext : 1)) : 0.0f);
                                    if (swatch == null || abs > f5) {
                                        f5 = abs;
                                        swatch = swatch2;
                                    }
                                }
                                i8++;
                                c = 0;
                                f = 0.0f;
                            }
                            if (swatch != null && target.BuiltInFictitiousFunctionClassFactory()) {
                                palette.getErrorConfigVersion.append(swatch.PlaceComponentResult, true);
                            }
                            map.put(target, swatch);
                            i5++;
                            c = 0;
                        }
                        palette.getErrorConfigVersion.clear();
                        return palette;
                    } catch (Exception e) {
                        InstrumentInjector.log_e("Palette", "Exception thrown during async generate", e);
                        return null;
                    }
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, PlaceComponentResult.MyBillsEntityDataFactory);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateTextColor$lambda-2$lambda-1  reason: not valid java name */
    public static final void m2865updateTextColor$lambda2$lambda1(BaseWalletDefaultCardView baseWalletDefaultCardView, Palette palette) {
        Palette.Swatch swatch;
        Intrinsics.checkNotNullParameter(baseWalletDefaultCardView, "");
        Context context = baseWalletDefaultCardView.getContext();
        int i = R.color.f24002131099997;
        int BuiltInFictitiousFunctionClassFactory = ContextCompat.BuiltInFictitiousFunctionClassFactory(context, R.color.f24002131099997);
        if (palette != null && (swatch = palette.KClassImpl$Data$declaredNonStaticMembers$2) != null) {
            BuiltInFictitiousFunctionClassFactory = swatch.PlaceComponentResult;
        }
        Context context2 = baseWalletDefaultCardView.getContext();
        if (baseWalletDefaultCardView.isDark(BuiltInFictitiousFunctionClassFactory)) {
            i = R.color.f27072131100488;
        }
        baseWalletDefaultCardView.getWalletCardListener().onUpdateTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(context2, i));
    }

    private final boolean isDark(int color) {
        return ColorUtils.MyBillsEntityDataFactory(color) < COLOR_LUMINANCE_THRESHOLD;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setCardContentDescription(String value) {
        Intrinsics.checkNotNullParameter(value, "");
        AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.res_0x7f0a0c6e_daggerstickysummarycomponent_stickysummarycomponentimpl_postexecutionthreadprovider);
        if (appCompatImageView != null) {
            appCompatImageView.setContentDescription(value);
        }
    }

    protected void setupMiniCard() {
        ViewGroup.LayoutParams layoutParams;
        ConstraintLayout constraintLayout = (ConstraintLayout) _$_findCachedViewById(R.id.res_0x7f0a0402_r8_lambda_7jse_jj0etbd9voomli6zmuqla0);
        if (constraintLayout != null && (layoutParams = constraintLayout.getLayoutParams()) != null) {
            layoutParams.width = SizeUtil.PlaceComponentResult(114);
        }
        MaterialCardView materialCardView = (MaterialCardView) _$_findCachedViewById(R.id.res_0x7f0a0592_nearbysearchpresenter_getnearbytrendingkeyword_2);
        if (materialCardView != null) {
            materialCardView.setRadius(SizeUtil.PlaceComponentResult(10));
        }
    }
}
