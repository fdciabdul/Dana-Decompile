package id.dana.nearbyme.merchantreview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.component.BaseRichView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00011B\u0019\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b0\u0010\rJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0014¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\f\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u000e\u0010\u0007J\u0015\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u000f\u0010\u0014\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0014\u0010\u0007R*\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004\"\u0004\b\u0019\u0010\u001aR*\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0004\"\u0004\b\u001e\u0010\u001aR*\u0010\"\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b \u0010\u0004\"\u0004\b!\u0010\u001aR*\u0010%\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0017\u001a\u0004\b#\u0010\u0004\"\u0004\b$\u0010\u001aR\u0016\u0010\u000e\u001a\u00020\u000f8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b&\u0010'R*\u0010+\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00028\u0007@GX\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010\u0017\u001a\u0004\b)\u0010\u0004\"\u0004\b*\u0010\u001aR\u001d\u0010&\u001a\f\u0012\b\u0012\u0006*\u00020-0-0,X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b.\u0010/"}, d2 = {"Lid/dana/nearbyme/merchantreview/ViewRatingStarBar;", "Lid/dana/component/BaseRichView;", "", "getLayout", "()I", "", "onAttachedToWindow", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "getAuthRequestContext", "Lid/dana/nearbyme/merchantreview/ViewRatingStarBar$ClickListener;", "clickListener", "setOnStarClickListener", "(Lid/dana/nearbyme/merchantreview/ViewRatingStarBar$ClickListener;)V", "setup", "BuiltInFictitiousFunctionClassFactory", "value", "KClassImpl$Data$declaredNonStaticMembers$2", "I", "getInnerBottomPadding", "setInnerBottomPadding", "(I)V", "innerBottomPadding", "PlaceComponentResult", "getInnerLeftPadding", "setInnerLeftPadding", "innerLeftPadding", "getInnerRightPadding", "setInnerRightPadding", "innerRightPadding", "getInnerTopPadding", "setInnerTopPadding", "innerTopPadding", "MyBillsEntityDataFactory", "Lid/dana/nearbyme/merchantreview/ViewRatingStarBar$ClickListener;", "scheduleImpl", "getStarSelected", "setStarSelected", "starSelected", "", "Landroidx/appcompat/widget/AppCompatImageView;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Lkotlin/Lazy;", "<init>", "ClickListener"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ViewRatingStarBar extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private int innerTopPadding;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private int innerBottomPadding;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private ClickListener getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private final Lazy MyBillsEntityDataFactory;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private int innerLeftPadding;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int innerRightPadding;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private int starSelected;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001À\u0006\u0001"}, d2 = {"Lid/dana/nearbyme/merchantreview/ViewRatingStarBar$ClickListener;", "", "", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public interface ClickListener {
        void KClassImpl$Data$declaredNonStaticMembers$2(int p0);
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

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.view_rating_star_bar;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewRatingStarBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = LazyKt.lazy(new Function0<List<? extends AppCompatImageView>>() { // from class: id.dana.nearbyme.merchantreview.ViewRatingStarBar$stars$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends AppCompatImageView> invoke() {
                return CollectionsKt.listOf((Object[]) new AppCompatImageView[]{(AppCompatImageView) ViewRatingStarBar.this._$_findCachedViewById(R.id.getNearbyMeByRadius), (AppCompatImageView) ViewRatingStarBar.this._$_findCachedViewById(R.id.iv_second_star), (AppCompatImageView) ViewRatingStarBar.this._$_findCachedViewById(R.id.iv_third_star), (AppCompatImageView) ViewRatingStarBar.this._$_findCachedViewById(R.id.iv_fourth_star), (AppCompatImageView) ViewRatingStarBar.this._$_findCachedViewById(R.id.iv_fifth_star)});
            }
        });
    }

    @JvmName(name = "getInnerTopPadding")
    public final int getInnerTopPadding() {
        return this.innerTopPadding;
    }

    @JvmName(name = "setInnerTopPadding")
    public final void setInnerTopPadding(int i) {
        this.innerTopPadding = i;
        BuiltInFictitiousFunctionClassFactory();
    }

    @JvmName(name = "getInnerBottomPadding")
    public final int getInnerBottomPadding() {
        return this.innerBottomPadding;
    }

    @JvmName(name = "setInnerBottomPadding")
    public final void setInnerBottomPadding(int i) {
        this.innerBottomPadding = i;
        BuiltInFictitiousFunctionClassFactory();
    }

    @JvmName(name = "getInnerLeftPadding")
    public final int getInnerLeftPadding() {
        return this.innerLeftPadding;
    }

    @JvmName(name = "setInnerLeftPadding")
    public final void setInnerLeftPadding(int i) {
        this.innerLeftPadding = i;
        BuiltInFictitiousFunctionClassFactory();
    }

    @JvmName(name = "getInnerRightPadding")
    public final int getInnerRightPadding() {
        return this.innerRightPadding;
    }

    @JvmName(name = "setInnerRightPadding")
    public final void setInnerRightPadding(int i) {
        this.innerRightPadding = i;
        BuiltInFictitiousFunctionClassFactory();
    }

    @JvmName(name = "getStarSelected")
    public final int getStarSelected() {
        return this.starSelected;
    }

    @JvmName(name = "setStarSelected")
    public final void setStarSelected(int i) {
        this.starSelected = i;
        getAuthRequestContext();
    }

    public final void setOnStarClickListener(ClickListener clickListener) {
        Intrinsics.checkNotNullParameter(clickListener, "");
        this.getAuthRequestContext = clickListener;
        final int i = 0;
        for (Object obj : (List) this.MyBillsEntityDataFactory.getValue()) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) obj;
            if (appCompatImageView != null) {
                appCompatImageView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.nearbyme.merchantreview.ViewRatingStarBar$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ViewRatingStarBar.$r8$lambda$jtMX2lMzJN8cwyi_YNJuSgs1KBs(ViewRatingStarBar.this, i, view);
                    }
                });
            }
            i++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAuthRequestContext();
    }

    private final void BuiltInFictitiousFunctionClassFactory() {
        LinearLayout linearLayout = (LinearLayout) _$_findCachedViewById(R.id.PromoExploreModule_ProvidesPresenterFactory_res_0x7f0a04a1);
        if (linearLayout != null) {
            linearLayout.setPadding(this.innerLeftPadding, this.innerTopPadding, this.innerRightPadding, this.innerBottomPadding);
        }
    }

    @Override // id.dana.component.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attrs, R.styleable.DeserializedCallableMemberDescriptor) : null;
        if (obtainStyledAttributes != null) {
            try {
                setInnerTopPadding((int) obtainStyledAttributes.getDimension(3, 0.0f));
                setInnerBottomPadding((int) obtainStyledAttributes.getDimension(0, 0.0f));
                setInnerLeftPadding((int) obtainStyledAttributes.getDimension(1, 0.0f));
                setInnerRightPadding((int) obtainStyledAttributes.getDimension(2, 0.0f));
            } finally {
                if (obtainStyledAttributes != null) {
                    obtainStyledAttributes.recycle();
                }
            }
        }
    }

    public static /* synthetic */ void $r8$lambda$jtMX2lMzJN8cwyi_YNJuSgs1KBs(ViewRatingStarBar viewRatingStarBar, int i, View view) {
        Intrinsics.checkNotNullParameter(viewRatingStarBar, "");
        viewRatingStarBar.setStarSelected(i + 1);
        ClickListener clickListener = viewRatingStarBar.getAuthRequestContext;
        if (clickListener == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            clickListener = null;
        }
        clickListener.KClassImpl$Data$declaredNonStaticMembers$2(viewRatingStarBar.starSelected);
    }

    private final void getAuthRequestContext() {
        int i = 0;
        for (Object obj : (List) this.MyBillsEntityDataFactory.getValue()) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Glide.getAuthRequestContext(this).PlaceComponentResult().getAuthRequestContext(Integer.valueOf(i < this.starSelected ? R.drawable.ic_star_filled : R.drawable.ic_star)).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) obj));
            i++;
        }
    }
}
