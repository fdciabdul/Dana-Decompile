package id.dana.globalsearch.basecategory;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRichView;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.model.SearchResultModel;
import id.dana.globalsearch.view.widget.CategoryHeaderView;
import id.dana.util.permission.Permission;
import id.dana.utils.LocationUtil;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\b&\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u00108\u001a\u00020$¢\u0006\u0004\b9\u0010:B+\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u00108\u001a\u00020$\u0012\u0006\u0010;\u001a\u00020$¢\u0006\u0004\b9\u0010<J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u001b\u0010\u001cJ\u001d\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010!\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u00020\u000e2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u000e0#H&¢\u0006\u0004\b&\u0010'J\u001d\u0010*\u001a\u00020\u000e2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0(H&¢\u0006\u0004\b*\u0010+J\u001b\u0010-\u001a\u00020\u000e2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0(¢\u0006\u0004\b-\u0010+J\u000f\u0010.\u001a\u00020\u000eH\u0016¢\u0006\u0004\b.\u0010\u0010J\u0017\u0010/\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b/\u0010\u001cJ\u000f\u00100\u001a\u00020\u000eH&¢\u0006\u0004\b0\u0010\u0010R\u0016\u00103\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u0010\u0013\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u0018\u00101\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u00105R\u0016\u00104\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00105R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00107"}, d2 = {"Lid/dana/globalsearch/basecategory/BaseCategoryGlobalSearchView;", "Lid/dana/base/BaseRichView;", "Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "getCategoryHeaderView", "()Lid/dana/globalsearch/view/widget/CategoryHeaderView;", "Lid/dana/globalsearch/model/SearchResultModel;", "searchResult", "", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "getLimitedItems", "(Lid/dana/globalsearch/model/SearchResultModel;)Ljava/util/List;", "Landroid/view/View;", "getPermissionLocationView", "()Landroid/view/View;", "", "hideSearchResult", "()V", "p0", "", "getAuthRequestContext", "(Lid/dana/globalsearch/model/SearchResultModel;)Z", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "setData", "(Lid/dana/globalsearch/model/SearchResultModel;)V", "", "category", "setDataSeeAll", "(Lid/dana/globalsearch/model/SearchResultModel;Ljava/lang/String;)V", "setHeaderSeeAll", "(Ljava/lang/String;)V", "Lkotlin/Function1;", "", "onItemClickCallback", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "onLoadMore", "setLoadMoreCallback", "(Lkotlin/jvm/functions/Function0;)V", "isSeeAllClickListener", "setSeeAllClickListener", "setup", "showSearchResult", "showSection", "PlaceComponentResult", "Z", "KClassImpl$Data$declaredNonStaticMembers$2", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "Lkotlin/jvm/functions/Function0;", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseCategoryGlobalSearchView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private Function0<Unit> BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private String getAuthRequestContext;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String PlaceComponentResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseCategoryGlobalSearchView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseCategoryGlobalSearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

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

    public abstract CategoryHeaderView getCategoryHeaderView();

    public abstract void hideSearchResult();

    public abstract void setItemClickCallback(Function1<? super Integer, Unit> onItemClickCallback);

    public abstract void setLoadMoreCallback(Function0<Unit> onLoadMore);

    public abstract void showSearchResult(SearchResultModel searchResult);

    public abstract void showSection();

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCategoryGlobalSearchView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
        this.getAuthRequestContext = "";
    }

    public /* synthetic */ BaseCategoryGlobalSearchView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseCategoryGlobalSearchView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.MyBillsEntityDataFactory = "";
        this.getAuthRequestContext = "";
    }

    public final View getPermissionLocationView() {
        return findViewById(R.id.f4098requestPermissionLocationPrompt);
    }

    @Override // id.dana.base.BaseRichView
    public void setup() {
        setHeader$default(this, this.PlaceComponentResult, this.KClassImpl$Data$declaredNonStaticMembers$2, null, 4, null);
        String str = this.MyBillsEntityDataFactory;
        String str2 = this.getAuthRequestContext;
        CategoryHeaderView categoryHeaderView = getCategoryHeaderView();
        if (categoryHeaderView != null) {
            categoryHeaderView.setCategoryHeaderContentDescription(str, str2);
        }
    }

    @Override // id.dana.base.BaseRichView
    public void parseAttrs(Context r3, AttributeSet attrs) {
        String str = "";
        Intrinsics.checkNotNullParameter(r3, "");
        if (attrs != null) {
            TypedArray obtainStyledAttributes = r3.obtainStyledAttributes(attrs, R.styleable.I);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                this.PlaceComponentResult = obtainStyledAttributes.getString(2);
                this.KClassImpl$Data$declaredNonStaticMembers$2 = obtainStyledAttributes.getBoolean(1, false);
                String string = obtainStyledAttributes.getString(3);
                if (string == null) {
                    string = "";
                }
                this.MyBillsEntityDataFactory = string;
                String string2 = obtainStyledAttributes.getString(0);
                if (string2 != null) {
                    str = string2;
                }
                this.getAuthRequestContext = str;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void setSeeAllClickListener(Function0<Unit> isSeeAllClickListener) {
        Intrinsics.checkNotNullParameter(isSeeAllClickListener, "");
        this.BuiltInFictitiousFunctionClassFactory = isSeeAllClickListener;
    }

    public final void setHeaderSeeAll(String category) {
        String string;
        Intrinsics.checkNotNullParameter(category, "");
        int hashCode = category.hashCode();
        if (hashCode == -1592831339) {
            if (category.equals("SERVICE")) {
                string = getResources().getString(R.string.services_title);
            }
            string = getResources().getString(R.string.nearby_merchants_title);
        } else if (hashCode != -667013580) {
            if (hashCode == 2178 && category.equals("DF")) {
                string = getResources().getString(R.string.eazy_eats_restaurant_title);
            }
            string = getResources().getString(R.string.nearby_merchants_title);
        } else {
            if (category.equals("ONLINE_MERCHANT")) {
                string = getResources().getString(R.string.online_merchant_title);
            }
            string = getResources().getString(R.string.nearby_merchants_title);
        }
        Intrinsics.checkNotNullExpressionValue(string, "");
        CategoryHeaderView categoryHeaderView = getCategoryHeaderView();
        if (categoryHeaderView != null) {
            categoryHeaderView.setCategoryName(string);
            CategoryHeaderView.setHasSeeAll$default(categoryHeaderView, false, null, 2, null);
        }
    }

    public final void setDataSeeAll(SearchResultModel searchResult, String category) {
        Intrinsics.checkNotNullParameter(searchResult, "");
        Intrinsics.checkNotNullParameter(category, "");
        setHeaderSeeAll(category);
        if ((!searchResult.getAuthRequestContext.isEmpty()) == true) {
            showSearchResult(searchResult);
        }
    }

    private static boolean getAuthRequestContext(SearchResultModel p0) {
        return p0.getPlaceComponentResult() && p0.MyBillsEntityDataFactory > 0 && p0.getAuthRequestContext.size() > p0.MyBillsEntityDataFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void setHeader$default(final BaseCategoryGlobalSearchView baseCategoryGlobalSearchView, String str, boolean z, Function0 function0, int i, Object obj) {
        CategoryHeaderView categoryHeaderView;
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeader");
        }
        if ((i & 4) != 0) {
            function0 = null;
        }
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            str = baseCategoryGlobalSearchView.PlaceComponentResult;
        }
        if (str == null || (categoryHeaderView = baseCategoryGlobalSearchView.getCategoryHeaderView()) == null) {
            return;
        }
        categoryHeaderView.setCategoryName(str);
        if (function0 != null) {
            baseCategoryGlobalSearchView.setSeeAllClickListener(function0);
        }
        categoryHeaderView.setHasSeeAll(z, new Function0<Unit>() { // from class: id.dana.globalsearch.basecategory.BaseCategoryGlobalSearchView$setHeader$1$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Function0 function02;
                function02 = BaseCategoryGlobalSearchView.this.BuiltInFictitiousFunctionClassFactory;
                if (function02 != null) {
                    function02.invoke();
                }
            }
        });
    }

    public final List<PaySearchInfoModel> getLimitedItems(SearchResultModel searchResult) {
        Intrinsics.checkNotNullParameter(searchResult, "");
        if (searchResult.MyBillsEntityDataFactory > 0) {
            return CollectionsKt.take(searchResult.getAuthRequestContext, searchResult.MyBillsEntityDataFactory);
        }
        return searchResult.getAuthRequestContext;
    }

    public final void setData(SearchResultModel searchResult) {
        Intrinsics.checkNotNullParameter(searchResult, "");
        if (searchResult.getAuthRequestContext.isEmpty()) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        setHeader$default(this, searchResult.BuiltInFictitiousFunctionClassFactory, getAuthRequestContext(searchResult), null, 4, null);
        if (searchResult.getKClassImpl$Data$declaredNonStaticMembers$2() && (!Permission.KClassImpl$Data$declaredNonStaticMembers$2(getContext(), "android.permission.ACCESS_FINE_LOCATION") || !LocationUtil.getAuthRequestContext(getContext()))) {
            showSection();
            hideSearchResult();
            CategoryHeaderView categoryHeaderView = getCategoryHeaderView();
            if (categoryHeaderView != null) {
                CategoryHeaderView.setHasSeeAll$default(categoryHeaderView, false, null, 2, null);
            }
            View permissionLocationView = getPermissionLocationView();
            if (permissionLocationView != null) {
                permissionLocationView.setVisibility(0);
                return;
            }
            return;
        }
        showSearchResult(searchResult);
    }
}
