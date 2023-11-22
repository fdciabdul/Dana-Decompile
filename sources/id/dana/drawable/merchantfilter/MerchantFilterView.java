package id.dana.drawable.merchantfilter;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.SkeletonScreen;
import id.dana.R;
import id.dana.animation.HorizontalEvenlyItemDecoration;
import id.dana.component.BaseRichView;
import id.dana.nearbyme.OnCategoryCheckedListener;
import id.dana.nearbyme.model.MerchantCategoryModel;
import id.dana.utils.ShimmeringUtil;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B'\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u00108\u001a\u00020\u0003¢\u0006\u0004\b9\u0010:B+\b\u0016\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00108\u001a\u00020\u0003\u0012\u0006\u0010;\u001a\u00020\u0003¢\u0006\u0004\b9\u0010<J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ#\u0010\r\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0015\u001a\u00020\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\bJ\r\u0010\u0018\u001a\u00020\u0006¢\u0006\u0004\b\u0018\u0010\bR*\u0010!\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00198\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\u00028\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u00104\u001a\u0004\u0018\u00010-8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u0010&\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b%\u00106R\u0016\u0010#\u001a\u00020\u00198\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b7\u0010\u001c"}, d2 = {"Lid/dana/nearbyrevamp/merchantfilter/MerchantFilterView;", "Lid/dana/component/BaseRichView;", "Lid/dana/nearbyme/OnCategoryCheckedListener;", "", "getLayout", "()I", "", "hideShimmer", "()V", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "parseAttrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "type", "setFilterType", "(I)V", "", "Lid/dana/nearbyme/model/MerchantCategoryModel;", "categories", "setMerchantCategories", "(Ljava/util/List;)V", "setup", "showShimmer", "", "value", "MyBillsEntityDataFactory", "Z", "getFilterEnabled", "()Z", "setFilterEnabled", "(Z)V", "filterEnabled", "Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter;", "PlaceComponentResult", "Lid/dana/nearbyrevamp/merchantfilter/NewMerchantCategoryAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/nearbyme/OnCategoryCheckedListener;", "getOnCategoryCheckedListener", "()Lid/dana/nearbyme/OnCategoryCheckedListener;", "setOnCategoryCheckedListener", "(Lid/dana/nearbyme/OnCategoryCheckedListener;)V", "onCategoryCheckedListener", "", "getAuthRequestContext", "Ljava/lang/String;", "getPreselectedCategoryId", "()Ljava/lang/String;", "setPreselectedCategoryId", "(Ljava/lang/String;)V", "preselectedCategoryId", "Lcom/ethanhua/skeleton/SkeletonScreen;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "moveToNextValue", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MerchantFilterView extends BaseRichView implements OnCategoryCheckedListener {
    public static final int BOTTOMSHEET = 1;
    public static final int MAPS = 0;

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private OnCategoryCheckedListener onCategoryCheckedListener;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private SkeletonScreen BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private boolean filterEnabled;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private NewMerchantCategoryAdapter KClassImpl$Data$declaredNonStaticMembers$2;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private String preselectedCategoryId;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantFilterView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MerchantFilterView(Context context, AttributeSet attributeSet) {
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

    @Override // id.dana.component.BaseRichView
    public final int getLayout() {
        return R.layout.view_merchant_filter;
    }

    @Override // id.dana.nearbyme.OnCategoryCheckedListener
    public final /* synthetic */ void onCategoryClick(MerchantCategoryModel merchantCategoryModel) {
        OnCategoryCheckedListener.CC.BuiltInFictitiousFunctionClassFactory(merchantCategoryModel);
    }

    @Override // id.dana.nearbyme.OnCategoryCheckedListener
    public final /* synthetic */ void onMulitpleCategorySelected(List list) {
        Intrinsics.checkNotNullParameter(list, "");
    }

    @Override // id.dana.nearbyme.OnCategoryCheckedListener
    public final /* synthetic */ void onMulitpleCategorySelected(List list, boolean z) {
        OnCategoryCheckedListener.CC.PlaceComponentResult(list);
    }

    @JvmName(name = "getFilterEnabled")
    public final boolean getFilterEnabled() {
        return this.filterEnabled;
    }

    @JvmName(name = "setFilterEnabled")
    public final void setFilterEnabled(boolean z) {
        this.filterEnabled = z;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMerchantCategories);
        if (recyclerView != null) {
            recyclerView.setVisibility(this.filterEnabled ? 0 : 8);
        }
    }

    @JvmName(name = "getOnCategoryCheckedListener")
    public final OnCategoryCheckedListener getOnCategoryCheckedListener() {
        return this.onCategoryCheckedListener;
    }

    @JvmName(name = "setOnCategoryCheckedListener")
    public final void setOnCategoryCheckedListener(OnCategoryCheckedListener onCategoryCheckedListener) {
        this.onCategoryCheckedListener = onCategoryCheckedListener;
    }

    @JvmName(name = "getPreselectedCategoryId")
    public final String getPreselectedCategoryId() {
        return this.preselectedCategoryId;
    }

    @JvmName(name = "setPreselectedCategoryId")
    public final void setPreselectedCategoryId(String str) {
        this.preselectedCategoryId = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.filterEnabled = true;
    }

    public /* synthetic */ MerchantFilterView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MerchantFilterView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.filterEnabled = true;
    }

    @Override // id.dana.component.BaseRichView
    public final void parseAttrs(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attrs, R.styleable.murmurHash64WithSeed);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
            try {
                this.PlaceComponentResult = obtainStyledAttributes.getBoolean(0, false);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void setMerchantCategories(final List<? extends MerchantCategoryModel> categories) {
        MerchantCategoryModel merchantCategoryModel;
        RecyclerView recyclerView;
        Object obj;
        Intrinsics.checkNotNullParameter(categories, "");
        hideShimmer();
        NewMerchantCategoryAdapter newMerchantCategoryAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        NewMerchantCategoryAdapter newMerchantCategoryAdapter2 = null;
        if (newMerchantCategoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantCategoryAdapter = null;
        }
        Intrinsics.checkNotNullParameter(categories, "");
        Set<MerchantCategoryModel> set = newMerchantCategoryAdapter.MyBillsEntityDataFactory;
        int i = 0;
        if (!(set == null || set.isEmpty()) && !newMerchantCategoryAdapter.MyBillsEntityDataFactory.contains(newMerchantCategoryAdapter.PlaceComponentResult) && CollectionsKt.removeAll(newMerchantCategoryAdapter.MyBillsEntityDataFactory, new Function1<MerchantCategoryModel, Boolean>() { // from class: id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter$checkIfCheckedCategoriesValid$anyCategoryRemoved$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(MerchantCategoryModel merchantCategoryModel2) {
                Intrinsics.checkNotNullParameter(merchantCategoryModel2, "");
                return Boolean.valueOf(!categories.contains(merchantCategoryModel2));
            }
        })) {
            if (newMerchantCategoryAdapter.MyBillsEntityDataFactory.isEmpty()) {
                Set<MerchantCategoryModel> set2 = newMerchantCategoryAdapter.MyBillsEntityDataFactory;
                MerchantCategoryModel merchantCategoryModel2 = newMerchantCategoryAdapter.PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(merchantCategoryModel2, "");
                set2.add(merchantCategoryModel2);
            }
            OnCategoryCheckedListener onCategoryCheckedListener = newMerchantCategoryAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
            if (onCategoryCheckedListener != null) {
                onCategoryCheckedListener.onMulitpleCategorySelected(CollectionsKt.toMutableList((Collection) newMerchantCategoryAdapter.MyBillsEntityDataFactory), true);
            }
        }
        newMerchantCategoryAdapter.setItems(categories);
        String str = this.preselectedCategoryId;
        if (str != null) {
            List<MerchantCategoryModel> items = newMerchantCategoryAdapter.getItems();
            if (items != null) {
                Iterator<T> it = items.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual(((MerchantCategoryModel) obj).MyBillsEntityDataFactory, str)) {
                        break;
                    }
                }
                merchantCategoryModel = (MerchantCategoryModel) obj;
            } else {
                merchantCategoryModel = null;
            }
            if (merchantCategoryModel != null) {
                Intrinsics.checkNotNullParameter(merchantCategoryModel, "");
                newMerchantCategoryAdapter.BuiltInFictitiousFunctionClassFactory(merchantCategoryModel);
                List<MerchantCategoryModel> mutableListOf = CollectionsKt.mutableListOf(merchantCategoryModel);
                OnCategoryCheckedListener onCategoryCheckedListener2 = newMerchantCategoryAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
                if (onCategoryCheckedListener2 != null) {
                    onCategoryCheckedListener2.onMulitpleCategorySelected(mutableListOf, true);
                }
                NewMerchantCategoryAdapter newMerchantCategoryAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (newMerchantCategoryAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    newMerchantCategoryAdapter3 = null;
                }
                Intrinsics.checkNotNullParameter(merchantCategoryModel, "");
                newMerchantCategoryAdapter3.BuiltInFictitiousFunctionClassFactory(merchantCategoryModel);
                List<MerchantCategoryModel> mutableListOf2 = CollectionsKt.mutableListOf(merchantCategoryModel);
                OnCategoryCheckedListener onCategoryCheckedListener3 = newMerchantCategoryAdapter3.KClassImpl$Data$declaredNonStaticMembers$2;
                if (onCategoryCheckedListener3 != null) {
                    onCategoryCheckedListener3.onMulitpleCategorySelected(mutableListOf2, true);
                }
                NewMerchantCategoryAdapter newMerchantCategoryAdapter4 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (newMerchantCategoryAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    newMerchantCategoryAdapter2 = newMerchantCategoryAdapter4;
                }
                if (merchantCategoryModel == null || newMerchantCategoryAdapter2.getItems() == null) {
                    i = -1;
                } else if (newMerchantCategoryAdapter2.MyBillsEntityDataFactory()) {
                    if (!Intrinsics.areEqual(merchantCategoryModel, newMerchantCategoryAdapter2.PlaceComponentResult)) {
                        i = newMerchantCategoryAdapter2.getItems().indexOf(merchantCategoryModel) + 1;
                    }
                } else {
                    i = newMerchantCategoryAdapter2.getItems().indexOf(merchantCategoryModel);
                }
                if (i < 0 || (recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMerchantCategories)) == null) {
                    return;
                }
                recyclerView.smoothScrollToPosition(i);
            }
        }
    }

    public final void showShimmer() {
        Unit unit;
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            this.BuiltInFictitiousFunctionClassFactory = ShimmeringUtil.PlaceComponentResult((ConstraintLayout) _$_findCachedViewById(R.id.allowedTargets), R.layout.view_merchant_filter_skeleton);
        }
    }

    public final void hideShimmer() {
        SkeletonScreen skeletonScreen = this.BuiltInFictitiousFunctionClassFactory;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public final void setFilterType(int type) {
        NewMerchantCategoryAdapter newMerchantCategoryAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (newMerchantCategoryAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            newMerchantCategoryAdapter = null;
        }
        newMerchantCategoryAdapter.BuiltInFictitiousFunctionClassFactory = type;
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new NewMerchantCategoryAdapter(this.PlaceComponentResult);
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rvMerchantCategories);
        if (recyclerView != null) {
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            recyclerView.addItemDecoration(new HorizontalEvenlyItemDecoration());
            NewMerchantCategoryAdapter newMerchantCategoryAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (newMerchantCategoryAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                newMerchantCategoryAdapter = null;
            }
            OnCategoryCheckedListener onCategoryCheckedListener = new OnCategoryCheckedListener() { // from class: id.dana.nearbyrevamp.merchantfilter.MerchantFilterView$getOnCategoryCheckedListener$1
                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final /* synthetic */ void onMulitpleCategorySelected(List list) {
                    Intrinsics.checkNotNullParameter(list, "");
                }

                /* JADX WARN: Removed duplicated region for block: B:33:0x0084  */
                /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final void onMulitpleCategorySelected(java.util.List<id.dana.nearbyme.model.MerchantCategoryModel> r7, boolean r8) {
                    /*
                        r6 = this;
                        java.lang.String r0 = ""
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r1 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter r1 = id.dana.drawable.merchantfilter.MerchantFilterView.access$getMerchantCategoryAdapter$p(r1)
                        r2 = 0
                        if (r1 != 0) goto L12
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        r1 = r2
                    L12:
                        id.dana.nearbyme.model.MerchantCategoryModel r1 = r1.PlaceComponentResult
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r3 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter r3 = id.dana.drawable.merchantfilter.MerchantFilterView.access$getMerchantCategoryAdapter$p(r3)
                        if (r3 != 0) goto L20
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        r3 = r2
                    L20:
                        java.util.Set<id.dana.nearbyme.model.MerchantCategoryModel> r3 = r3.MyBillsEntityDataFactory
                        java.util.Collection r3 = (java.util.Collection) r3
                        r4 = 0
                        r5 = 1
                        if (r3 == 0) goto L30
                        boolean r3 = r3.isEmpty()
                        if (r3 != 0) goto L30
                        r3 = 0
                        goto L31
                    L30:
                        r3 = 1
                    L31:
                        if (r3 != 0) goto L57
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r3 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter r3 = id.dana.drawable.merchantfilter.MerchantFilterView.access$getMerchantCategoryAdapter$p(r3)
                        if (r3 != 0) goto L3f
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        r3 = r2
                    L3f:
                        java.util.Set<id.dana.nearbyme.model.MerchantCategoryModel> r3 = r3.MyBillsEntityDataFactory
                        boolean r1 = r3.contains(r1)
                        if (r1 == 0) goto L57
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r0 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        int r1 = id.dana.R.id.rvMerchantCategories
                        android.view.View r0 = r0._$_findCachedViewById(r1)
                        androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
                        if (r0 == 0) goto L7c
                        r0.smoothScrollToPosition(r4)
                        goto L7c
                    L57:
                        if (r8 == 0) goto L7c
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r1 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        int r3 = id.dana.R.id.rvMerchantCategories
                        android.view.View r1 = r1._$_findCachedViewById(r3)
                        androidx.recyclerview.widget.RecyclerView r1 = (androidx.recyclerview.widget.RecyclerView) r1
                        if (r1 == 0) goto L7c
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r3 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        id.dana.nearbyrevamp.merchantfilter.NewMerchantCategoryAdapter r3 = id.dana.drawable.merchantfilter.MerchantFilterView.access$getMerchantCategoryAdapter$p(r3)
                        if (r3 != 0) goto L71
                        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
                        goto L72
                    L71:
                        r2 = r3
                    L72:
                        java.util.Set<id.dana.nearbyme.model.MerchantCategoryModel> r0 = r2.MyBillsEntityDataFactory
                        int r0 = r0.size()
                        int r0 = r0 - r5
                        r1.smoothScrollToPosition(r0)
                    L7c:
                        id.dana.nearbyrevamp.merchantfilter.MerchantFilterView r0 = id.dana.drawable.merchantfilter.MerchantFilterView.this
                        id.dana.nearbyme.OnCategoryCheckedListener r0 = r0.getOnCategoryCheckedListener()
                        if (r0 == 0) goto L87
                        r0.onMulitpleCategorySelected(r7, r8)
                    L87:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: id.dana.drawable.merchantfilter.MerchantFilterView$getOnCategoryCheckedListener$1.onMulitpleCategorySelected(java.util.List, boolean):void");
                }

                @Override // id.dana.nearbyme.OnCategoryCheckedListener
                public final void onCategoryClick(MerchantCategoryModel p0) {
                    Intrinsics.checkNotNullParameter(p0, "");
                    OnCategoryCheckedListener onCategoryCheckedListener2 = MerchantFilterView.this.getOnCategoryCheckedListener();
                    if (onCategoryCheckedListener2 != null) {
                        onCategoryCheckedListener2.onCategoryClick(p0);
                    }
                }
            };
            Intrinsics.checkNotNullParameter(onCategoryCheckedListener, "");
            newMerchantCategoryAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = onCategoryCheckedListener;
            recyclerView.setAdapter(newMerchantCategoryAdapter);
        }
    }
}
