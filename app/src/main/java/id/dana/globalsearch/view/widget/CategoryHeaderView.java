package id.dana.globalsearch.view.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.globalsearch.view.SeeAllActivity;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010&\u001a\u00020\u0002¢\u0006\u0004\b'\u0010(B+\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010&\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0002¢\u0006\u0004\b'\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\n\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\f¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0016\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u001a\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001d\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u001d\u0010\u0011J\r\u0010\u001e\u001a\u00020\t¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\tH\u0016¢\u0006\u0004\b \u0010\u001fR\u0016\u0010!\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$"}, d2 = {"Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "categoryName", "", "hasSeeAll", "setCategory", "(Ljava/lang/String;Z)V", "categoryNameContentDescription", "hasSeeAllContentDescription", "setCategoryHeaderContentDescription", "(Ljava/lang/String;Ljava/lang/String;)V", "setCategoryName", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "isSeeAllClickListener", "setHasSeeAll", "(ZLkotlin/jvm/functions/Function0;)V", "category", "setOnCLickSeeAll", "setVisibilityHeader", "()V", "setup", "getAuthRequestContext", "Ljava/lang/String;", "PlaceComponentResult", "Z", "BuiltInFictitiousFunctionClassFactory", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CategoryHeaderView extends BaseRichView {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;
    public Map<Integer, View> _$_findViewCache;
    private String getAuthRequestContext;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategoryHeaderView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CategoryHeaderView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_category_header;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryHeaderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = "";
    }

    public /* synthetic */ CategoryHeaderView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = "";
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        setCategory(this.getAuthRequestContext, this.BuiltInFictitiousFunctionClassFactory);
    }

    @Override // id.dana.base.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.G);
            String str = "";
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                String string = obtainStyledAttributes.getString(1);
                if (string != null) {
                    str = string;
                }
                this.getAuthRequestContext = str;
                this.BuiltInFictitiousFunctionClassFactory = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public static /* synthetic */ void setCategory$default(CategoryHeaderView categoryHeaderView, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        categoryHeaderView.setCategory(str, z);
    }

    public final void setCategory(String categoryName, boolean hasSeeAll) {
        Intrinsics.checkNotNullParameter(categoryName, "");
        setCategoryName(categoryName);
        setHasSeeAll$default(this, hasSeeAll, null, 2, null);
        setOnCLickSeeAll(categoryName, hasSeeAll);
    }

    public final void setCategoryName(String categoryName) {
        Intrinsics.checkNotNullParameter(categoryName, "");
        this.getAuthRequestContext = categoryName;
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvCategoryName);
        if (textView != null) {
            textView.setText(categoryName);
        }
        setVisibilityHeader();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void setHasSeeAll$default(CategoryHeaderView categoryHeaderView, boolean z, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        categoryHeaderView.setHasSeeAll(z, function0);
    }

    public final void setHasSeeAll(boolean hasSeeAll, final Function0<Unit> isSeeAllClickListener) {
        TextView textView = (TextView) _$_findCachedViewById(R.id.getInstalledPath);
        if (textView != null) {
            textView.setVisibility(hasSeeAll ? 0 : 8);
            textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.widget.CategoryHeaderView$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CategoryHeaderView.m2610$r8$lambda$FPCB8OuXJiF4QFGeBJ1FeuY0n4(Function0.this, view);
                }
            });
        }
    }

    public final void setVisibilityHeader() {
        RelativeLayout relativeLayout = (RelativeLayout) _$_findCachedViewById(R.id.getThumbnailHeight);
        if (relativeLayout != null) {
            relativeLayout.setVisibility(this.getAuthRequestContext.length() == 0 ? 8 : 0);
        }
    }

    public final void setOnCLickSeeAll(final String category, boolean hasSeeAll) {
        TextView textView;
        String str = category;
        if ((str == null || str.length() == 0) || !hasSeeAll || (textView = (TextView) _$_findCachedViewById(R.id.getInstalledPath)) == null) {
            return;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.globalsearch.view.widget.CategoryHeaderView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                CategoryHeaderView.m2611$r8$lambda$O2Pfp_bGzZIJ0mQFOYpMjqKJPk(CategoryHeaderView.this, category, view);
            }
        });
    }

    public final void setCategoryHeaderContentDescription(String categoryNameContentDescription, String hasSeeAllContentDescription) {
        Intrinsics.checkNotNullParameter(categoryNameContentDescription, "");
        Intrinsics.checkNotNullParameter(hasSeeAllContentDescription, "");
        TextView textView = (TextView) _$_findCachedViewById(R.id.tvCategoryName);
        if (textView != null) {
            textView.setContentDescription(categoryNameContentDescription);
        }
        TextView textView2 = (TextView) _$_findCachedViewById(R.id.getInstalledPath);
        if (textView2 != null) {
            textView2.setContentDescription(hasSeeAllContentDescription);
        }
    }

    /* renamed from: $r8$lambda$FPCB8OuXJiF4QFGeBJ1FeuY0n-4  reason: not valid java name */
    public static /* synthetic */ void m2610$r8$lambda$FPCB8OuXJiF4QFGeBJ1FeuY0n4(Function0 function0, View view) {
        if (function0 != null) {
            function0.invoke();
        }
    }

    /* renamed from: $r8$lambda$O2Pfp_bGzZIJ0mQF-OYpMjqKJPk  reason: not valid java name */
    public static /* synthetic */ void m2611$r8$lambda$O2Pfp_bGzZIJ0mQFOYpMjqKJPk(CategoryHeaderView categoryHeaderView, String str, View view) {
        Intrinsics.checkNotNullParameter(categoryHeaderView, "");
        Intent intent = new Intent(categoryHeaderView.getContext(), SeeAllActivity.class);
        intent.putExtra(SeeAllActivity.GLOBAL_SEARCH_CATEGORY, str);
        categoryHeaderView.getContext().startActivity(intent);
    }
}
