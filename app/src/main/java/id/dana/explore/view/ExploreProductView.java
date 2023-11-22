package id.dana.explore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.danah5.DanaH5;
import id.dana.domain.globalsearch.model.ProductBizId;
import id.dana.explore.adapter.ExploreProductAdapter;
import id.dana.explore.model.ExploreProductModel;
import id.dana.explore.model.ExploreProductWrapper;
import id.dana.explore.utils.ExploreUtils;
import id.dana.explore.view.ExploreDanaFragment;
import id.dana.mybills.tracker.MyBillsTrackerKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import o.getOnBoardingScenario;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ$\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0002J\u001c\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010!\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010#\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002J\u0018\u0010$\u001a\u00020\u001d2\u000e\u0010%\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000eH\u0002J\u001a\u0010&\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010'\u001a\u00020\rH\u0002J\u0012\u0010(\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002J\u0012\u0010)\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002J\u0010\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\rH\u0002J\u000e\u0010,\u001a\u00020\u00172\u0006\u0010-\u001a\u00020\rJ\u0014\u0010.\u001a\u00020\u00172\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00190\u000eJ6\u00100\u001a\u00020\u00172.\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e`\u000fJ\b\u00101\u001a\u00020\u0017H\u0016J\u000e\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\nR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R6\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e0\fj\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u000e`\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lid/dana/explore/view/ExploreProductView;", "Lid/dana/base/BaseRichView;", HummerConstants.CONTEXT, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "exploreDanaFragmentListener", "Lid/dana/explore/view/ExploreDanaFragment$ExploreDanaFragmentListener;", "postPaidProfileKeyHashMap", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "productAdapter", "Lid/dana/explore/adapter/ExploreProductAdapter;", "buildPostPaidUrl", "baseUrl", "bizParam", "goodsId", "checkKey", "", "exploreProductModel", "Lid/dana/explore/model/ExploreProductModel;", "getLayout", "initProductRecyclerView", MyBillsTrackerKey.MyBillsProperties.IS_PAYMENT, "", "bizId", "Lid/dana/domain/globalsearch/model/ProductBizId;", "link", "isPostPaid", "item", "isPostPaidKeyValid", "isPrePaid", "prePaidKey", "isTelkom", "key", "navigateToPostPaidPage", "navigateToPrePaidPage", "navigateToServicePage", DanaH5.SERVICE_KEY, "openH5Container", "url", "setItems", "defaultSku", "setPostPaidProfileKey", "setup", "setupExploreDanaListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExploreProductView extends BaseRichView {
    private static int $10 = 0;
    private static int $11 = 1;
    private static long BuiltInFictitiousFunctionClassFactory = -6319618968611425906L;
    private static int KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static int getErrorConfigVersion = 1;
    private HashMap<String, List<String>> MyBillsEntityDataFactory;
    private ExploreProductAdapter PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;
    private ExploreDanaFragment.ExploreDanaFragmentListener getAuthRequestContext;

    /* renamed from: $r8$lambda$UdFcLhybOfC_X0e-16K502y3jZ0 */
    public static /* synthetic */ void m2581$r8$lambda$UdFcLhybOfC_X0e16K502y3jZ0(ExploreProductView exploreProductView, int i) {
        try {
            int i2 = getErrorConfigVersion + 3;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
                char c = i2 % 2 != 0 ? (char) 16 : (char) 5;
                MyBillsEntityDataFactory(exploreProductView, i);
                if (c != 5) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExploreProductView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ExploreProductView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public final void _$_clearFindViewByIdCache() {
        try {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 117;
            try {
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
                this._$_findViewCache.clear();
                int i3 = getErrorConfigVersion + 31;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x0030, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003b, code lost:
    
        if (r1 != null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x003d, code lost:
    
        r0.put(java.lang.Integer.valueOf(r6), r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0045, code lost:
    
        r1 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.view.View _$_findCachedViewById(int r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.Integer, android.view.View> r0 = r5._$_findViewCache
            java.lang.Integer r1 = java.lang.Integer.valueOf(r6)
            java.lang.Object r1 = r0.get(r1)
            android.view.View r1 = (android.view.View) r1
            r2 = 94
            if (r1 != 0) goto L13
            r3 = 94
            goto L14
        L13:
            r3 = 5
        L14:
            r4 = 0
            if (r3 == r2) goto L18
            goto L46
        L18:
            int r1 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 81
            int r2 = r1 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r2
            int r1 = r1 % 2
            r2 = 13
            if (r1 != 0) goto L29
            r1 = 13
            goto L2a
        L29:
            r1 = 1
        L2a:
            if (r1 == r2) goto L33
            android.view.View r1 = r5.findViewById(r6)
            if (r1 == 0) goto L45
            goto L3d
        L33:
            android.view.View r1 = r5.findViewById(r6)
            r2 = 96
            int r2 = r2 / 0
            if (r1 == 0) goto L45
        L3d:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r0.put(r6, r1)
            goto L46
        L45:
            r1 = r4
        L46:
            int r6 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion     // Catch: java.lang.Exception -> L57
            int r6 = r6 + 121
            int r0 = r6 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r0     // Catch: java.lang.Exception -> L57
            int r6 = r6 % 2
            if (r6 == 0) goto L56
            int r6 = r4.length     // Catch: java.lang.Throwable -> L54
            return r1
        L54:
            r6 = move-exception
            throw r6
        L56:
            return r1
        L57:
            r6 = move-exception
            throw r6
        L59:
            r6 = move-exception
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView._$_findCachedViewById(int):android.view.View");
    }

    @Override // id.dana.base.BaseRichView
    public final int getLayout() {
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        getErrorConfigVersion = i % 128;
        if ((i % 2 == 0 ? '.' : 'R') != 'R') {
            Object obj = null;
            obj.hashCode();
        }
        int i2 = getErrorConfigVersion + 1;
        KClassImpl$Data$declaredNonStaticMembers$2 = i2 % 128;
        if ((i2 % 2 != 0 ? '/' : 'H') != '/') {
            return R.layout.view_explore_product;
        }
        int i3 = 68 / 0;
        return R.layout.view_explore_product;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExploreProductView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ ExploreProductView(android.content.Context r2, android.util.AttributeSet r3, int r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r1 = this;
            r6 = r5 & 2
            r0 = 66
            if (r6 == 0) goto L9
            r6 = 66
            goto Lb
        L9:
            r6 = 29
        Lb:
            if (r6 == r0) goto Le
            goto L23
        Le:
            int r3 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r3 = r3 + 25
            int r6 = r3 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r6
            int r3 = r3 % 2
            r3 = 0
            int r6 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2
            int r6 = r6 + 67
            int r0 = r6 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r0
            int r6 = r6 % 2
        L23:
            r6 = 4
            r5 = r5 & r6
            r0 = 84
            if (r5 == 0) goto L2c
            r5 = 43
            goto L2e
        L2c:
            r5 = 84
        L2e:
            if (r5 == r0) goto L45
            int r4 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 55
            int r5 = r4 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r5
            int r4 = r4 % 2
            if (r4 != 0) goto L3e
            r4 = 4
            goto L40
        L3e:
            r4 = 48
        L40:
            if (r4 == r6) goto L44
            r4 = 0
            goto L45
        L44:
            r4 = 1
        L45:
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.<init>(android.content.Context, android.util.AttributeSet, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        try {
            int i = getErrorConfigVersion + 109;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
            MyBillsEntityDataFactory();
            int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
            getErrorConfigVersion = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private final void MyBillsEntityDataFactory() {
        Context context = getContext();
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.rv_explore_product);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
        ExploreProductAdapter exploreProductAdapter = new ExploreProductAdapter();
        this.PlaceComponentResult = exploreProductAdapter;
        recyclerView.setAdapter(exploreProductAdapter);
        recyclerView.setNestedScrollingEnabled(false);
        ExploreProductAdapter exploreProductAdapter2 = this.PlaceComponentResult;
        ExploreProductAdapter exploreProductAdapter3 = null;
        if ((exploreProductAdapter2 == null ? (char) 28 : '8') == 28) {
            int i = KClassImpl$Data$declaredNonStaticMembers$2 + 75;
            getErrorConfigVersion = i % 128;
            int i2 = i % 2;
            try {
                Intrinsics.throwUninitializedPropertyAccessException("");
                int i3 = getErrorConfigVersion + 107;
                KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
                int i4 = i3 % 2;
                exploreProductAdapter2 = null;
            } catch (Exception e) {
                throw e;
            }
        }
        exploreProductAdapter2.getItems().clear();
        String str = null;
        exploreProductAdapter2.getItems().add(new ExploreProductWrapper(1, new ExploreProductModel(null, null, null, null, null, null, str, str, null, null, null, null, null, null, 16383, null)));
        exploreProductAdapter2.getItems().add(new ExploreProductWrapper(1, new ExploreProductModel(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null)));
        exploreProductAdapter2.notifyDataSetChanged();
        ExploreProductAdapter exploreProductAdapter4 = this.PlaceComponentResult;
        if (exploreProductAdapter4 != null) {
            exploreProductAdapter3 = exploreProductAdapter4;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        exploreProductAdapter3.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.explore.view.ExploreProductView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i5) {
                ExploreProductView.m2581$r8$lambda$UdFcLhybOfC_X0e16K502y3jZ0(ExploreProductView.this, i5);
            }
        });
        int i5 = getErrorConfigVersion + 69;
        KClassImpl$Data$declaredNonStaticMembers$2 = i5 % 128;
        int i6 = i5 % 2;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void MyBillsEntityDataFactory(id.dana.explore.view.ExploreProductView r6, int r7) {
        /*
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            id.dana.explore.adapter.ExploreProductAdapter r1 = r6.PlaceComponentResult
            r2 = 0
            if (r1 != 0) goto L27
            int r1 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L24
            int r1 = r1 + 5
            int r3 = r1 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r3     // Catch: java.lang.Exception -> L24
            int r1 = r1 % 2
            if (r1 != 0) goto L1f
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            r2.hashCode()     // Catch: java.lang.Throwable -> L1d
            goto L22
        L1d:
            r6 = move-exception
            throw r6
        L1f:
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
        L22:
            r1 = r2
            goto L27
        L24:
            r6 = move-exception
            goto L96
        L27:
            java.lang.Object r7 = r1.getItem(r7)
            id.dana.explore.model.ExploreProductWrapper r7 = (id.dana.explore.model.ExploreProductWrapper) r7
            id.dana.explore.model.ExploreProductModel r7 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            id.dana.domain.globalsearch.model.ProductBizId r1 = r7.KClassImpl$Data$declaredNonStaticMembers$2
            if (r1 == 0) goto L41
            int r2 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r2 = r2 + 35
            int r3 = r2 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            java.lang.String r2 = r1.getBizId()
        L41:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r1 = 25
            if (r2 == 0) goto L4a
            r3 = 9
            goto L4c
        L4a:
            r3 = 25
        L4c:
            r4 = 0
            r5 = 1
            if (r3 == r1) goto L6b
            int r1 = r2.length()
            r2 = 39
            if (r1 == 0) goto L5b
            r1 = 58
            goto L5d
        L5b:
            r1 = 39
        L5d:
            if (r1 == r2) goto L6b
            int r1 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r1 = r1 + 41
            int r2 = r1 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            r1 = 0
            goto L6c
        L6b:
            r1 = 1
        L6c:
            if (r1 != 0) goto L72
            r6.KClassImpl$Data$declaredNonStaticMembers$2(r7)
            return
        L72:
            java.lang.String r7 = r7.NetworkUserEntityData$$ExternalSyntheticLambda0
            if (r7 != 0) goto L77
            goto L78
        L77:
            r4 = 1
        L78:
            if (r4 == r5) goto L87
            int r7 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion     // Catch: java.lang.Exception -> L85
            int r7 = r7 + 15
            int r1 = r7 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r1     // Catch: java.lang.Exception -> L85
            int r7 = r7 % 2
            goto L88
        L85:
            r6 = move-exception
            throw r6
        L87:
            r0 = r7
        L88:
            r6.PlaceComponentResult(r0)
            int r6 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion     // Catch: java.lang.Exception -> L24
            int r6 = r6 + 73
            int r7 = r6 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r7     // Catch: java.lang.Exception -> L24
            int r6 = r6 % 2
            return
        L96:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.MyBillsEntityDataFactory(id.dana.explore.view.ExploreProductView, int):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0045, code lost:
    
        if (r3 != 930525159) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x004f, code lost:
    
        if ((r3 == 930525159) != false) goto L119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0057, code lost:
    
        if (r0.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.ELECTRICITY) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0059, code lost:
    
        r12 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 + 99;
        id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r12 % 128;
        r12 = r12 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0067, code lost:
    
        if (r3 == 2038502419) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0069, code lost:
    
        r12 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion + 61;
        id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r12 % 128;
        r12 = r12 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0073, code lost:
    
        r7 = new java.lang.Object[1];
        a(33851 - (android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(0) > com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (android.telephony.cdma.CdmaCellLocation.convertQuartSecToDecDegrees(0) == com.google.firebase.remoteconfig.FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), new char[]{41150, 9363, 43209, 11274, 45128, 13705, 47562, 15631, 33144, 1713, 35553, 3629, 37477, 5719, 39813, 8157, 58142, 26446, 60554, 28894, 62518, 30847}, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0097, code lost:
    
        if (r0.equals(((java.lang.String) r7[0]).intern()) != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0099, code lost:
    
        r12 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 + 87;
        id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r12 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00a3, code lost:
    
        if ((r12 % 2) != 0) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x00a5, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x00a7, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x00a8, code lost:
    
        if (r12 == false) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x00bb, code lost:
    
        if ((r0.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.MOBILE_POSTPAID) ? '[' : 16) != 16) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x00bd, code lost:
    
        r3 = r11.MyBillsEntityDataFactory;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x00bf, code lost:
    
        if (r3 != null) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x00c1, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
        r3 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x00c7, code lost:
    
        r0 = r3.get(r0);
        r12 = r12.KClassImpl$Data$declaredNonStaticMembers$2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x00cf, code lost:
    
        if (r12 == null) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x00d1, code lost:
    
        r6 = r12.getProfileKey();
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x00d5, code lost:
    
        r12 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x00d8, code lost:
    
        if (r12 == null) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x00de, code lost:
    
        if (r12.isEmpty() != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x00e0, code lost:
    
        r12 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 + 49;
        id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r12 % 128;
        r12 = r12 % 2;
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x00ec, code lost:
    
        r12 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion + 3;
        id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r12 % 128;
        r12 = r12 % 2;
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x00f7, code lost:
    
        if (r12 != false) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x00f9, code lost:
    
        r12 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x00fb, code lost:
    
        r12 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x00fc, code lost:
    
        if (r12 == true) goto L155;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0100, code lost:
    
        r12 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0105, code lost:
    
        if (r12 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0107, code lost:
    
        r4 = '8';
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x010a, code lost:
    
        r4 = 'F';
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x010c, code lost:
    
        if (r4 == '8') goto L161;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x010f, code lost:
    
        r3 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 + 65;
        id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r3 % 128;
        r3 = r3 % 2;
        r12 = r12.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x011d, code lost:
    
        if (r3 != 0) goto L169;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x0121, code lost:
    
        r3 = 52 / 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0122, code lost:
    
        if (r12 != 0) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0129, code lost:
    
        if (r12 != 0) goto L172;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x012c, code lost:
    
        r5 = '\f';
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x012e, code lost:
    
        if (r5 == '\f') goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x0130, code lost:
    
        r12 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r12 % 128;
        r12 = r12 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x013b, code lost:
    
        r1 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x013c, code lost:
    
        if (r1 == false) goto L178;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0144, code lost:
    
        return r0.contains(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:?, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean BuiltInFictitiousFunctionClassFactory(id.dana.explore.model.ExploreProductModel r12) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.BuiltInFictitiousFunctionClassFactory(id.dana.explore.model.ExploreProductModel):boolean");
    }

    private static boolean getAuthRequestContext(List<String> list) {
        boolean z = false;
        if (!(list != null)) {
            int i = getErrorConfigVersion + 19;
            KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
            int i2 = i % 2;
        } else {
            try {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 79;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                try {
                    z = !list.isEmpty();
                } catch (Exception e) {
                    throw e;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
        getErrorConfigVersion = i5 % 128;
        int i6 = i5 % 2;
        return z;
    }

    private final void PlaceComponentResult(ExploreProductModel exploreProductModel) {
        String str;
        int i = KClassImpl$Data$declaredNonStaticMembers$2 + 27;
        getErrorConfigVersion = i % 128;
        ExploreDanaFragment.ExploreDanaFragmentListener exploreDanaFragmentListener = null;
        if (i % 2 != 0) {
            if ((exploreProductModel != null ? '^' : ',') != '^') {
                return;
            }
        } else {
            exploreDanaFragmentListener.hashCode();
            if (exploreProductModel == null) {
                return;
            }
        }
        List<String> list = exploreProductModel.initRecordTimeStamp;
        if (!(list != null)) {
            return;
        }
        int i2 = KClassImpl$Data$declaredNonStaticMembers$2 + 109;
        getErrorConfigVersion = i2 % 128;
        if (i2 % 2 == 0) {
            str = (String) CollectionsKt.firstOrNull((List) list);
            exploreDanaFragmentListener.hashCode();
            if (str == null) {
                return;
            }
        } else {
            try {
                str = (String) CollectionsKt.firstOrNull((List) list);
                if (str == null) {
                    return;
                }
            } catch (Exception e) {
                throw e;
            }
        }
        ExploreDanaFragment.ExploreDanaFragmentListener exploreDanaFragmentListener2 = this.getAuthRequestContext;
        if (exploreDanaFragmentListener2 == null) {
            int i3 = getErrorConfigVersion + 103;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            exploreDanaFragmentListener = exploreDanaFragmentListener2;
        }
        exploreDanaFragmentListener.BuiltInFictitiousFunctionClassFactory(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x006f A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.globalsearch.model.ProductBizId r4, java.lang.String r5) {
        /*
            if (r4 == 0) goto L7
            java.lang.String r4 = r4.getBizId()
            goto L8
        L7:
            r4 = 0
        L8:
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L36
            int r2 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r2 = r2 + 43
            int r3 = r2 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r3
            int r2 = r2 % 2
            int r4 = r4.length()     // Catch: java.lang.Exception -> L34
            r2 = 11
            if (r4 == 0) goto L23
            r4 = 11
            goto L25
        L23:
            r4 = 99
        L25:
            if (r4 == r2) goto L28
            goto L36
        L28:
            int r4 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion     // Catch: java.lang.Exception -> L34
            int r4 = r4 + 115
            int r2 = r4 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r2     // Catch: java.lang.Exception -> L34
            int r4 = r4 % 2
            r4 = 0
            goto L37
        L34:
            r4 = move-exception
            goto L6e
        L36:
            r4 = 1
        L37:
            if (r4 != 0) goto L6f
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L3f
            r4 = 1
            goto L40
        L3f:
            r4 = 0
        L40:
            if (r4 == r1) goto L43
            goto L55
        L43:
            int r4 = r5.length()
            if (r4 == 0) goto L55
            int r4 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r4 = r4 + 115
            int r5 = r4 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
            r4 = 0
            goto L60
        L55:
            int r4 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion     // Catch: java.lang.Exception -> L34
            int r4 = r4 + 65
            int r5 = r4 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r5     // Catch: java.lang.Exception -> L34
            int r4 = r4 % 2
            r4 = 1
        L60:
            if (r4 != 0) goto L6f
            int r4 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r4 = r4 + 37
            int r5 = r4 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r4 = r4 % 2
            r0 = 1
            goto L6f
        L6e:
            throw r4
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.domain.globalsearch.model.ProductBizId, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x00e5, code lost:
    
        if ((r0.equals(id.dana.mybills.ui.constant.MyBillsServiceKey.MOBILE_POSTPAID)) != false) goto L152;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void MyBillsEntityDataFactory(id.dana.explore.model.ExploreProductModel r13) {
        /*
            Method dump skipped, instructions count: 338
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.MyBillsEntityDataFactory(id.dana.explore.model.ExploreProductModel):void");
    }

    public final void setItems(List<ExploreProductModel> defaultSku) {
        ExploreProductAdapter exploreProductAdapter;
        Iterator<T> it;
        ExploreProductModel exploreProductModel;
        ExploreProductAdapter exploreProductAdapter2;
        try {
            Intrinsics.checkNotNullParameter(defaultSku, "");
            try {
                ExploreProductAdapter exploreProductAdapter3 = this.PlaceComponentResult;
                exploreProductAdapter = null;
                if (exploreProductAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    exploreProductAdapter3 = null;
                }
                List<ExploreProductWrapper> items = exploreProductAdapter3.getItems();
                Intrinsics.checkNotNullExpressionValue(items, "");
                CollectionsKt.removeAll((List) items, (Function1) new Function1<ExploreProductWrapper, Boolean>() { // from class: id.dana.explore.adapter.ExploreProductAdapter$hideLoadingSkeleton$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Boolean invoke(ExploreProductWrapper exploreProductWrapper) {
                        return Boolean.valueOf(exploreProductWrapper.BuiltInFictitiousFunctionClassFactory == 1);
                    }
                });
                exploreProductAdapter3.notifyDataSetChanged();
                ExploreProductAdapter exploreProductAdapter4 = this.PlaceComponentResult;
                if (exploreProductAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                    exploreProductAdapter4 = null;
                }
                exploreProductAdapter4.getItems().clear();
                it = defaultSku.iterator();
                int i = KClassImpl$Data$declaredNonStaticMembers$2 + 19;
                getErrorConfigVersion = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
        while (true) {
            if ((it.hasNext() ? '\'' : Typography.dollar) == '$') {
                break;
            }
            int i3 = getErrorConfigVersion + 89;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            if (i3 % 2 != 0) {
                exploreProductModel = (ExploreProductModel) it.next();
                exploreProductAdapter2 = this.PlaceComponentResult;
                exploreProductAdapter.hashCode();
                if (exploreProductAdapter2 != null) {
                    exploreProductAdapter2.getItems().add(new ExploreProductWrapper(0, exploreProductModel));
                }
                int i4 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                getErrorConfigVersion = i4 % 128;
                int i5 = i4 % 2;
                Intrinsics.throwUninitializedPropertyAccessException("");
                exploreProductAdapter2 = null;
                exploreProductAdapter2.getItems().add(new ExploreProductWrapper(0, exploreProductModel));
            } else {
                exploreProductModel = (ExploreProductModel) it.next();
                exploreProductAdapter2 = this.PlaceComponentResult;
                if (!(exploreProductAdapter2 == null)) {
                    exploreProductAdapter2.getItems().add(new ExploreProductWrapper(0, exploreProductModel));
                }
                int i42 = KClassImpl$Data$declaredNonStaticMembers$2 + 29;
                getErrorConfigVersion = i42 % 128;
                int i52 = i42 % 2;
                Intrinsics.throwUninitializedPropertyAccessException("");
                exploreProductAdapter2 = null;
                exploreProductAdapter2.getItems().add(new ExploreProductWrapper(0, exploreProductModel));
            }
            throw e2;
        }
        ExploreProductAdapter exploreProductAdapter5 = this.PlaceComponentResult;
        if (exploreProductAdapter5 != null) {
            exploreProductAdapter = exploreProductAdapter5;
        } else {
            Intrinsics.throwUninitializedPropertyAccessException("");
        }
        exploreProductAdapter.notifyDataSetChanged();
        int i6 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        getErrorConfigVersion = i6 % 128;
        int i7 = i6 % 2;
    }

    public final void setupExploreDanaListener(ExploreDanaFragment.ExploreDanaFragmentListener r4) {
        try {
            int i = getErrorConfigVersion + 65;
            try {
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                if ((i % 2 != 0 ? 'J' : (char) 28) == 28) {
                    Intrinsics.checkNotNullParameter(r4, "");
                    this.getAuthRequestContext = r4;
                    return;
                }
                Intrinsics.checkNotNullParameter(r4, "");
                this.getAuthRequestContext = r4;
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private final void PlaceComponentResult(String str) {
        ExploreDanaFragment.ExploreDanaFragmentListener exploreDanaFragmentListener = this.getAuthRequestContext;
        if ((exploreDanaFragmentListener == null ? (char) 18 : 'O') != 'O') {
            Intrinsics.throwUninitializedPropertyAccessException("");
            exploreDanaFragmentListener = null;
            try {
                int i = getErrorConfigVersion + 11;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        }
        ExploreUtils exploreUtils = ExploreUtils.INSTANCE;
        exploreDanaFragmentListener.PlaceComponentResult(ExploreUtils.getAuthRequestContext(str));
        int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 9;
        getErrorConfigVersion = i3 % 128;
        int i4 = i3 % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x001a, code lost:
    
        if (((r4 & 4) != 0) != false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x001f, code lost:
    
        if ((r4 | 3) != 0) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0021, code lost:
    
        r3 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.String buildPostPaidUrl$default(id.dana.explore.view.ExploreProductView r0, java.lang.String r1, java.lang.String r2, java.lang.String r3, int r4, java.lang.Object r5) {
        /*
            int r0 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r0 = r0 + 41
            int r5 = r0 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r5
            int r0 = r0 % 2
            r5 = 3
            if (r0 == 0) goto Lf
            r0 = 3
            goto L11
        Lf:
            r0 = 76
        L11:
            if (r0 == r5) goto L1d
            r0 = r4 & 4
            if (r0 == 0) goto L19
            r0 = 1
            goto L1a
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L22
            goto L21
        L1d:
            r0 = r4 | 3
            if (r0 == 0) goto L22
        L21:
            r3 = 0
        L22:
            java.lang.String r0 = PlaceComponentResult(r1, r2, r3)     // Catch: java.lang.Exception -> L31
            int r1 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r1 = r1 + 85
            int r2 = r1 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r1 = r1 % 2
            return r0
        L31:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.buildPostPaidUrl$default(id.dana.explore.view.ExploreProductView, java.lang.String, java.lang.String, java.lang.String, int, java.lang.Object):java.lang.String");
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0035, code lost:
    
        if ((r9 != null ? 'Q' : '7') != '7') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0053, code lost:
    
        if ((r9 != null) != true) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0056, code lost:
    
        r8 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion + 7;
        id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r8 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0062, code lost:
    
        if ((r8 % 2) == 0) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0064, code lost:
    
        r1 = 'a';
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0068, code lost:
    
        if (r1 == 'a') goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x006a, code lost:
    
        r7.appendQueryParameter("goodsId", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x006e, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x006f, code lost:
    
        throw r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0070, code lost:
    
        r7.appendQueryParameter("goodsId", r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0073, code lost:
    
        r2.hashCode();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String PlaceComponentResult(java.lang.String r7, java.lang.String r8, java.lang.String r9) {
        /*
            int r0 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            r1 = 25
            int r0 = r0 + r1
            int r2 = r0 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r2
            int r0 = r0 % 2
            r2 = 0
            java.lang.String r3 = "bizParam"
            java.lang.String r4 = "true"
            java.lang.String r5 = "autoInquiry"
            java.lang.String r6 = ""
            if (r0 == 0) goto L3a
            android.net.Uri r7 = android.net.Uri.parse(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            android.net.Uri$Builder r7 = r7.buildUpon()
            android.net.Uri$Builder r7 = r7.appendQueryParameter(r5, r4)
            android.net.Uri$Builder r7 = r7.appendQueryParameter(r3, r8)
            r2.hashCode()     // Catch: java.lang.Throwable -> L38
            r8 = 55
            if (r9 == 0) goto L33
            r0 = 81
            goto L35
        L33:
            r0 = 55
        L35:
            if (r0 == r8) goto L76
            goto L56
        L38:
            r7 = move-exception
            throw r7
        L3a:
            android.net.Uri r7 = android.net.Uri.parse(r7)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            android.net.Uri$Builder r7 = r7.buildUpon()
            android.net.Uri$Builder r7 = r7.appendQueryParameter(r5, r4)
            android.net.Uri$Builder r7 = r7.appendQueryParameter(r3, r8)
            r8 = 1
            if (r9 == 0) goto L52
            r0 = 1
            goto L53
        L52:
            r0 = 0
        L53:
            if (r0 == r8) goto L56
            goto L76
        L56:
            int r8 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r8 = r8 + 7
            int r0 = r8 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r0
            int r8 = r8 % 2
            r0 = 97
            if (r8 == 0) goto L66
            r1 = 97
        L66:
            java.lang.String r8 = "goodsId"
            if (r1 == r0) goto L70
            r7.appendQueryParameter(r8, r9)     // Catch: java.lang.Exception -> L6e
            goto L76
        L6e:
            r7 = move-exception
            throw r7
        L70:
            r7.appendQueryParameter(r8, r9)
            r2.hashCode()     // Catch: java.lang.Throwable -> L82
        L76:
            android.net.Uri r7 = r7.build()
            java.lang.String r7 = r7.toString()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            return r7
        L82:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.PlaceComponentResult(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public final void openH5Container(String url) {
        int i = getErrorConfigVersion + 79;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        int i2 = i % 2;
        Intrinsics.checkNotNullParameter(url, "");
        DanaH5.startContainerFullUrl(url);
        int i3 = getErrorConfigVersion + 59;
        KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
        int i4 = i3 % 2;
    }

    public final void setPostPaidProfileKey(HashMap<String, List<String>> postPaidProfileKeyHashMap) {
        int i = getErrorConfigVersion + 19;
        KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
        if (i % 2 == 0) {
            Intrinsics.checkNotNullParameter(postPaidProfileKeyHashMap, "");
            this.MyBillsEntityDataFactory = postPaidProfileKeyHashMap;
        } else {
            Intrinsics.checkNotNullParameter(postPaidProfileKeyHashMap, "");
            this.MyBillsEntityDataFactory = postPaidProfileKeyHashMap;
            int i2 = 75 / 0;
        }
        try {
            int i3 = getErrorConfigVersion + 85;
            KClassImpl$Data$declaredNonStaticMembers$2 = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:117:0x0038, code lost:
    
        if (r0 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x003f, code lost:
    
        if (r0 == null) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0041, code lost:
    
        kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException("");
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x0045, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v1, types: [id.dana.explore.view.ExploreDanaFragment$ExploreDanaFragmentListener] */
    /* JADX WARN: Type inference failed for: r3v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void KClassImpl$Data$declaredNonStaticMembers$2(id.dana.explore.model.ExploreProductModel r9) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2(id.dana.explore.model.ExploreProductModel):void");
    }

    private static boolean BuiltInFictitiousFunctionClassFactory(ProductBizId productBizId, String str) {
        String bizId;
        boolean z;
        if ((Intrinsics.areEqual(str, "service_telkom") ? '1' : '0') != '0') {
            if (productBizId == null) {
                bizId = null;
            } else {
                int i = getErrorConfigVersion + 29;
                KClassImpl$Data$declaredNonStaticMembers$2 = i % 128;
                int i2 = i % 2;
                try {
                    bizId = productBizId.getBizId();
                } catch (Exception e) {
                    throw e;
                }
            }
            String str2 = bizId;
            if (str2 == null || str2.length() == 0) {
                int i3 = KClassImpl$Data$declaredNonStaticMembers$2 + 1;
                getErrorConfigVersion = i3 % 128;
                int i4 = i3 % 2;
                z = true;
            } else {
                z = false;
            }
            if (!(z)) {
                return true;
            }
        }
        int i5 = KClassImpl$Data$declaredNonStaticMembers$2 + 55;
        getErrorConfigVersion = i5 % 128;
        int i6 = i5 % 2;
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:90:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean getAuthRequestContext(id.dana.explore.model.ExploreProductModel r7) {
        /*
            r6 = this;
            int r0 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2
            int r0 = r0 + 93
            int r1 = r0 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r1
            int r0 = r0 % 2
            if (r7 == 0) goto L10
            java.util.List<java.lang.String> r0 = r7.moveToNextValue
            if (r0 != 0) goto L1e
        L10:
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()     // Catch: java.lang.Exception -> L9d
            int r1 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2
            int r1 = r1 + 29
            int r2 = r1 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r2
            int r1 = r1 % 2
        L1e:
            java.util.HashMap<java.lang.String, java.util.List<java.lang.String>> r1 = r6.MyBillsEntityDataFactory
            r2 = 0
            if (r1 != 0) goto L29
            java.lang.String r1 = ""
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)     // Catch: java.lang.Exception -> L9d
            r1 = r2
        L29:
            java.util.Map r1 = (java.util.Map) r1
            if (r7 == 0) goto L2f
            java.lang.String r2 = r7.NetworkUserEntityData$$ExternalSyntheticLambda0
        L2f:
            java.lang.Object r7 = r1.get(r2)
            java.util.List r7 = (java.util.List) r7
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            r2 = 1
            r1 = r1 ^ r2
            r3 = 0
            if (r1 == 0) goto L43
            r1 = 0
            goto L44
        L43:
            r1 = 1
        L44:
            if (r1 == r2) goto L9b
            r1 = r7
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L6e
            int r4 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2
            int r4 = r4 + 119
            int r5 = r4 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r5
            int r4 = r4 % 2
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Exception -> L9d
            if (r1 != 0) goto L5d
            r1 = 1
            goto L5e
        L5d:
            r1 = 0
        L5e:
            if (r1 == 0) goto L6e
            int r1 = id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2     // Catch: java.lang.Exception -> L6c
            int r1 = r1 + 75
            int r4 = r1 % 128
            id.dana.explore.view.ExploreProductView.getErrorConfigVersion = r4     // Catch: java.lang.Exception -> L6c
            int r1 = r1 % 2
            r1 = 0
            goto L6f
        L6c:
            r7 = move-exception
            throw r7
        L6e:
            r1 = 1
        L6f:
            r4 = 73
            if (r1 != 0) goto L76
            r1 = 87
            goto L78
        L76:
            r1 = 73
        L78:
            if (r1 == r4) goto L9b
            int r1 = id.dana.explore.view.ExploreProductView.getErrorConfigVersion
            int r1 = r1 + 99
            int r4 = r1 % 128
            id.dana.explore.view.ExploreProductView.KClassImpl$Data$declaredNonStaticMembers$2 = r4
            int r1 = r1 % 2
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Set r7 = kotlin.collections.CollectionsKt.intersect(r7, r0)
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r1 == 0) goto L98
            r7 = r7 & r3
            if (r7 != 0) goto L9c
            goto L9b
        L98:
            r7 = r7 ^ r2
            if (r7 != 0) goto L9c
        L9b:
            r2 = 0
        L9c:
            return r2
        L9d:
            r7 = move-exception
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.explore.view.ExploreProductView.getAuthRequestContext(id.dana.explore.model.ExploreProductModel):boolean");
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        getOnBoardingScenario getonboardingscenario = new getOnBoardingScenario();
        getonboardingscenario.MyBillsEntityDataFactory = i;
        int length = cArr.length;
        long[] jArr = new long[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            if (getonboardingscenario.getAuthRequestContext >= cArr.length) {
                break;
            }
            try {
                int i2 = $10 + 109;
                $11 = i2 % 128;
                int i3 = i2 % 2;
                jArr[getonboardingscenario.getAuthRequestContext] = (cArr[getonboardingscenario.getAuthRequestContext] ^ (getonboardingscenario.getAuthRequestContext * getonboardingscenario.MyBillsEntityDataFactory)) ^ (BuiltInFictitiousFunctionClassFactory ^ 4796183387843776835L);
                getonboardingscenario.getAuthRequestContext++;
                int i4 = $11 + 37;
                $10 = i4 % 128;
                int i5 = i4 % 2;
            } catch (Exception e) {
                throw e;
            }
            throw e;
        }
        char[] cArr2 = new char[length];
        getonboardingscenario.getAuthRequestContext = 0;
        while (true) {
            try {
                if (!(getonboardingscenario.getAuthRequestContext < cArr.length)) {
                    objArr[0] = new String(cArr2);
                    return;
                } else {
                    cArr2[getonboardingscenario.getAuthRequestContext] = (char) jArr[getonboardingscenario.getAuthRequestContext];
                    getonboardingscenario.getAuthRequestContext++;
                }
            } catch (Exception e2) {
                throw e2;
            }
        }
    }
}
