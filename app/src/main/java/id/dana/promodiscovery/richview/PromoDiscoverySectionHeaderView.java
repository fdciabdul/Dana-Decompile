package id.dana.promodiscovery.richview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRichView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010*\u001a\u00020\u0002¢\u0006\u0004\b+\u0010,B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010*\u001a\u00020\u0002\u0012\u0006\u0010-\u001a\u00020\u0002¢\u0006\u0004\b+\u0010.J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u001d\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010)\u001a\u0004\u0018\u00010\u00128\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0014\u001a\u0004\b'\u0010\u0016\"\u0004\b(\u0010\u0018"}, d2 = {"Lid/dana/promodiscovery/richview/PromoDiscoverySectionHeaderView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "isVisible", "renderSeeAllButton", "(Z)V", "setup", "()V", "", "PlaceComponentResult", "Ljava/lang/String;", "getCategory", "()Ljava/lang/String;", "setCategory", "(Ljava/lang/String;)V", "category", "MyBillsEntityDataFactory", "getFilterOption", "setFilterOption", "filterOption", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "getAuthRequestContext", "Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "getSectionListener", "()Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;", "setSectionListener", "(Lid/dana/promodiscovery/richview/PromoDiscoverySectionListener;)V", "sectionListener", "KClassImpl$Data$declaredNonStaticMembers$2", "getSortOption", "setSortOption", "sortOption", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PromoDiscoverySectionHeaderView extends BaseRichView {

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private String sortOption;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String filterOption;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String category;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private PromoDiscoverySectionListener sectionListener;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromoDiscoverySectionHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PromoDiscoverySectionHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
        return R.layout.view_promo_discovery_section_header;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoDiscoverySectionHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PromoDiscoverySectionHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PromoDiscoverySectionHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    @JvmName(name = "getSectionListener")
    public final PromoDiscoverySectionListener getSectionListener() {
        return this.sectionListener;
    }

    @JvmName(name = "setSectionListener")
    public final void setSectionListener(PromoDiscoverySectionListener promoDiscoverySectionListener) {
        this.sectionListener = promoDiscoverySectionListener;
    }

    @JvmName(name = "getCategory")
    public final String getCategory() {
        return this.category;
    }

    @JvmName(name = "setCategory")
    public final void setCategory(String str) {
        this.category = str;
    }

    @JvmName(name = "getSortOption")
    public final String getSortOption() {
        return this.sortOption;
    }

    @JvmName(name = "setSortOption")
    public final void setSortOption(String str) {
        this.sortOption = str;
    }

    @JvmName(name = "getFilterOption")
    public final String getFilterOption() {
        return this.filterOption;
    }

    @JvmName(name = "setFilterOption")
    public final void setFilterOption(String str) {
        this.filterOption = str;
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (context == null || attrs == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.getNrCsiRsrp);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        setStyledAttributes(context, attrs, R.styleable.getNrCsiRsrp);
        try {
            AppCompatImageView appCompatImageView = (AppCompatImageView) _$_findCachedViewById(R.id.headerIcon);
            if (appCompatImageView != null) {
                __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(appCompatImageView, getStyledAttributes().getResourceId(0, 0));
            }
            boolean z = getStyledAttributes().getBoolean(2, true);
            AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.btnSeeAll);
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "");
            appCompatTextView.setVisibility(z ? 0 : 8);
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) _$_findCachedViewById(R.id.addOnItemTouchListener);
            if (appCompatTextView2 != null) {
                appCompatTextView2.setText(getStyledAttributes().getText(1));
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.btnSeeAll);
        if (appCompatTextView != null) {
            appCompatTextView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.promodiscovery.richview.PromoDiscoverySectionHeaderView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PromoDiscoverySectionHeaderView.m2784$r8$lambda$nvyQbUEWYwYar2haDHlsNEFjo(PromoDiscoverySectionHeaderView.this, view);
                }
            });
        }
    }

    public final void renderSeeAllButton(boolean isVisible) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) _$_findCachedViewById(R.id.btnSeeAll);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(isVisible ? 0 : 8);
        }
    }

    /* renamed from: $r8$lambda$nvyQb-UE-WYwYar2haDHlsNEFjo  reason: not valid java name */
    public static /* synthetic */ void m2784$r8$lambda$nvyQbUEWYwYar2haDHlsNEFjo(PromoDiscoverySectionHeaderView promoDiscoverySectionHeaderView, View view) {
        Intrinsics.checkNotNullParameter(promoDiscoverySectionHeaderView, "");
        PromoDiscoverySectionListener promoDiscoverySectionListener = promoDiscoverySectionHeaderView.sectionListener;
        if (promoDiscoverySectionListener != null) {
            AppCompatTextView appCompatTextView = (AppCompatTextView) promoDiscoverySectionHeaderView._$_findCachedViewById(R.id.addOnItemTouchListener);
            String valueOf = String.valueOf(appCompatTextView != null ? appCompatTextView.getText() : null);
            String str = promoDiscoverySectionHeaderView.category;
            String str2 = promoDiscoverySectionHeaderView.sortOption;
            String str3 = promoDiscoverySectionHeaderView.filterOption;
            promoDiscoverySectionListener.BuiltInFictitiousFunctionClassFactory(valueOf, str, str2);
        }
    }
}
