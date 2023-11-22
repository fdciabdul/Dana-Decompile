package id.dana.richview.servicescard.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.common.base.Ascii;
import id.dana.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001KB\u0011\b\u0016\u0012\u0006\u0010E\u001a\u00020\u0005¢\u0006\u0004\bF\u0010GB\u001b\b\u0016\u0012\u0006\u0010E\u001a\u00020\u0005\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\bF\u0010\nB#\b\u0016\u0012\u0006\u0010E\u001a\u00020\u0005\u0012\b\u0010H\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010I\u001a\u00020\u000f¢\u0006\u0004\bF\u0010JJ\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00022\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u0012J\u0015\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000f¢\u0006\u0004\b\u0019\u0010\u0012J\u0015\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b\u001f\u0010\u0012J\u0015\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u000f¢\u0006\u0004\b \u0010\u0012J\u0015\u0010#\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0002¢\u0006\u0004\b%\u0010\u0004R0\u0010*\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b2\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b8\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u0010&\u001a\u00020\u000f8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0018\u00106\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b4\u00105R$\u0010:\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f8\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b7\u00103\u001a\u0004\b8\u00109R$\u0010=\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f8\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b;\u00103\u001a\u0004\b<\u00109R\u001d\u0010@\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000b8G¢\u0006\f\u0012\u0004\b?\u0010\u0004\u001a\u0004\b>\u0010)R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bA\u0010,R\u0018\u00107\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\bC\u0010D"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceShimmerRecycleView;", "Landroidx/recyclerview/widget/RecyclerView;", "", "hideShimmerAdapter", "()V", "Landroid/content/Context;", "p0", "Landroid/util/AttributeSet;", "p1", "getAuthRequestContext", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "setAdapter", "(Landroidx/recyclerview/widget/RecyclerView$Adapter;)V", "", "count", "setGridChildCount", "(I)V", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "manager", "setLayoutManager", "(Landroidx/recyclerview/widget/RecyclerView$LayoutManager;)V", "setShimmerChildCount", "duration", "setShimmerDuration", "Lid/dana/richview/servicescard/adapter/ServiceShimmerRecycleView$LayoutManagerType;", "type", "setShimmerLayoutManager", "(Lid/dana/richview/servicescard/adapter/ServiceShimmerRecycleView$LayoutManagerType;)V", "mLayoutReference", "setShimmerLayoutPromotedServiceReference", "setShimmerLayoutServiceReference", "", "maskWidth", "setShimmerMaskWidth", "(F)V", "showShimmerAdapter", "MyBillsEntityDataFactory", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getActualAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "actualAdapter", "scheduleImpl", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "lookAheadTest", "Z", "PlaceComponentResult", "NetworkUserEntityData$$ExternalSyntheticLambda0", "I", "moveToNextValue", "Lid/dana/richview/servicescard/adapter/ServiceShimmerRecycleView$LayoutManagerType;", "BuiltInFictitiousFunctionClassFactory", "getErrorConfigVersion", "getLayoutReference", "()I", "layoutReference", "GetContactSyncConfig", "getPromotedLayoutReference", "promotedLayoutReference", "getShimmerAdapter", "getShimmerAdapter$annotations", "shimmerAdapter", "NetworkUserEntityData$$ExternalSyntheticLambda1", "Lid/dana/richview/servicescard/adapter/ShimmerServiceAdapter;", "DatabaseTableConfigUtil", "Lid/dana/richview/servicescard/adapter/ShimmerServiceAdapter;", HummerConstants.CONTEXT, "<init>", "(Landroid/content/Context;)V", "attrs", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LayoutManagerType"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ServiceShimmerRecycleView extends RecyclerView {
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {108, -22, 67, 3, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4};
    public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 14;

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private ShimmerServiceAdapter getErrorConfigVersion;

    /* renamed from: GetContactSyncConfig  reason: from kotlin metadata */
    private int promotedLayoutReference;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private RecyclerView.Adapter<?> actualAdapter;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private int MyBillsEntityDataFactory;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private RecyclerView.LayoutManager getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    private int layoutReference;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private boolean PlaceComponentResult;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private LayoutManagerType BuiltInFictitiousFunctionClassFactory;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private RecyclerView.LayoutManager KClassImpl$Data$declaredNonStaticMembers$2;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006"}, d2 = {"Lid/dana/richview/servicescard/adapter/ServiceShimmerRecycleView$LayoutManagerType;", "", "<init>", "(Ljava/lang/String;I)V", "LINEAR_VERTICAL", "LINEAR_HORIZONTAL", "GRID"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum LayoutManagerType {
        LINEAR_VERTICAL,
        LINEAR_HORIZONTAL,
        GRID
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] PlaceComponentResult;

        static {
            int[] iArr = new int[LayoutManagerType.values().length];
            iArr[LayoutManagerType.LINEAR_VERTICAL.ordinal()] = 1;
            iArr[LayoutManagerType.LINEAR_HORIZONTAL.ordinal()] = 2;
            iArr[LayoutManagerType.GRID.ordinal()] = 3;
            PlaceComponentResult = iArr;
        }
    }

    public static /* synthetic */ void getShimmerAdapter$annotations() {
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

    @JvmName(name = "getActualAdapter")
    public final RecyclerView.Adapter<?> getActualAdapter() {
        return this.actualAdapter;
    }

    @JvmName(name = "getLayoutReference")
    public final int getLayoutReference() {
        return this.layoutReference;
    }

    @JvmName(name = "getPromotedLayoutReference")
    public final int getPromotedLayoutReference() {
        return this.promotedLayoutReference;
    }

    @JvmName(name = "getShimmerAdapter")
    public final RecyclerView.Adapter<?> getShimmerAdapter() {
        return this.getErrorConfigVersion;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceShimmerRecycleView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        getAuthRequestContext(context, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceShimmerRecycleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        getAuthRequestContext(context, attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServiceShimmerRecycleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        getAuthRequestContext(context, attributeSet);
    }

    private final void getAuthRequestContext(Context p0, AttributeSet p1) {
        int i;
        ShimmerServiceAdapter shimmerServiceAdapter;
        this.getErrorConfigVersion = new ShimmerServiceAdapter();
        TypedArray obtainStyledAttributes = p0.obtainStyledAttributes(p1, R.styleable.saveNickname, 0, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "");
        try {
            setShimmerLayoutServiceReference(obtainStyledAttributes.getResourceId(6, R.layout.viewholder_service_layout));
            setShimmerLayoutPromotedServiceReference(obtainStyledAttributes.getResourceId(7, R.layout.viewholder_promoted_service_layout));
            setShimmerChildCount(obtainStyledAttributes.getInteger(1, 8));
            setGridChildCount(obtainStyledAttributes.getInteger(3, 4));
            int integer = obtainStyledAttributes.getInteger(4, LayoutManagerType.LINEAR_VERTICAL.ordinal());
            if (integer == LayoutManagerType.LINEAR_VERTICAL.ordinal()) {
                setShimmerLayoutManager(LayoutManagerType.LINEAR_VERTICAL);
            } else if (integer == LayoutManagerType.LINEAR_HORIZONTAL.ordinal()) {
                setShimmerLayoutManager(LayoutManagerType.LINEAR_HORIZONTAL);
            } else if (integer == LayoutManagerType.GRID.ordinal()) {
                setShimmerLayoutManager(LayoutManagerType.GRID);
            } else {
                throw new IllegalArgumentException("The value for layout manager not valid!");
            }
            int integer2 = obtainStyledAttributes.getInteger(0, 0);
            if (Build.VERSION.SDK_INT >= 23) {
                i = getContext().getColor(R.color.f23952131099990);
            } else {
                getResources();
                i = -1842205;
            }
            int color = obtainStyledAttributes.getColor(9, i);
            Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(obtainStyledAttributes, 10);
            int integer3 = obtainStyledAttributes.getInteger(2, 1500);
            float f = obtainStyledAttributes.getFloat(5, 0.5f);
            boolean z = obtainStyledAttributes.getBoolean(8, false);
            obtainStyledAttributes.recycle();
            ShimmerServiceAdapter shimmerServiceAdapter2 = this.getErrorConfigVersion;
            if (shimmerServiceAdapter2 != null) {
                shimmerServiceAdapter2.getAuthRequestContext = integer2;
            }
            ShimmerServiceAdapter shimmerServiceAdapter3 = this.getErrorConfigVersion;
            if (shimmerServiceAdapter3 != null) {
                shimmerServiceAdapter3.getErrorConfigVersion = color;
            }
            ShimmerServiceAdapter shimmerServiceAdapter4 = this.getErrorConfigVersion;
            if (shimmerServiceAdapter4 != null) {
                shimmerServiceAdapter4.moveToNextValue = f;
            }
            ShimmerServiceAdapter shimmerServiceAdapter5 = this.getErrorConfigVersion;
            if (shimmerServiceAdapter5 != null) {
                shimmerServiceAdapter5.lookAheadTest = integer3;
            }
            ShimmerServiceAdapter shimmerServiceAdapter6 = this.getErrorConfigVersion;
            if (shimmerServiceAdapter6 != null) {
                shimmerServiceAdapter6.MyBillsEntityDataFactory = z;
            }
            if (__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d != null && (shimmerServiceAdapter = this.getErrorConfigVersion) != null) {
                Intrinsics.checkNotNullParameter(__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d, "");
                shimmerServiceAdapter.scheduleImpl = __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d;
            }
            showShimmerAdapter();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void setGridChildCount(int count) {
        this.MyBillsEntityDataFactory = count;
    }

    public final void setShimmerLayoutManager(LayoutManagerType type) {
        Intrinsics.checkNotNullParameter(type, "");
        this.BuiltInFictitiousFunctionClassFactory = type;
    }

    public final void setShimmerChildCount(int count) {
        ShimmerServiceAdapter shimmerServiceAdapter = this.getErrorConfigVersion;
        if (shimmerServiceAdapter != null) {
            shimmerServiceAdapter.PlaceComponentResult = count;
        }
    }

    public final void setShimmerDuration(int duration) {
        ShimmerServiceAdapter shimmerServiceAdapter = this.getErrorConfigVersion;
        if (shimmerServiceAdapter != null) {
            shimmerServiceAdapter.lookAheadTest = duration;
        }
    }

    public final void setShimmerMaskWidth(float maskWidth) {
        ShimmerServiceAdapter shimmerServiceAdapter = this.getErrorConfigVersion;
        if (shimmerServiceAdapter != null) {
            shimmerServiceAdapter.moveToNextValue = maskWidth;
        }
    }

    public final void showShimmerAdapter() {
        this.PlaceComponentResult = false;
        if (this.getAuthRequestContext == null) {
            LayoutManagerType layoutManagerType = this.BuiltInFictitiousFunctionClassFactory;
            int i = layoutManagerType == null ? -1 : WhenMappings.PlaceComponentResult[layoutManagerType.ordinal()];
            if (i == 1) {
                final Context context = getContext();
                this.getAuthRequestContext = new LinearLayoutManager(context) { // from class: id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView$initShimmerManager$1
                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public final boolean canScrollVertically() {
                        boolean z;
                        z = ServiceShimmerRecycleView.this.PlaceComponentResult;
                        return z;
                    }
                };
            } else if (i == 2) {
                final Context context2 = getContext();
                this.getAuthRequestContext = new LinearLayoutManager(context2) { // from class: id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView$initShimmerManager$2
                    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
                    public final boolean canScrollHorizontally() {
                        boolean z;
                        z = ServiceShimmerRecycleView.this.PlaceComponentResult;
                        return z;
                    }
                };
            } else if (i == 3) {
                GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), this.MyBillsEntityDataFactory);
                gridLayoutManager.moveToNextValue = new GridLayoutManager.SpanSizeLookup() { // from class: id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView$initShimmerManager$3
                    @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
                    public final int PlaceComponentResult(int p0) {
                        int i2;
                        if (p0 == 0) {
                            i2 = ServiceShimmerRecycleView.this.MyBillsEntityDataFactory;
                            return i2;
                        }
                        return 1;
                    }
                };
                this.getAuthRequestContext = gridLayoutManager;
            }
        }
        setLayoutManager(this.getAuthRequestContext);
        setAdapter(this.getErrorConfigVersion);
    }

    public final void hideShimmerAdapter() {
        this.PlaceComponentResult = true;
        setLayoutManager(this.KClassImpl$Data$declaredNonStaticMembers$2);
        setAdapter(this.actualAdapter);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void setLayoutManager(RecyclerView.LayoutManager manager) {
        if (manager == null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        } else if (!Intrinsics.areEqual(manager, this.getAuthRequestContext)) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = manager;
        }
        super.setLayoutManager(manager);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void setAdapter(RecyclerView.Adapter<?> adapter) {
        if (adapter == null) {
            this.actualAdapter = null;
        } else if (!Intrinsics.areEqual(adapter, this.getErrorConfigVersion)) {
            this.actualAdapter = adapter;
        }
        super.setAdapter(adapter);
    }

    public final void setShimmerLayoutServiceReference(int mLayoutReference) {
        this.layoutReference = mLayoutReference;
        ShimmerServiceAdapter shimmerServiceAdapter = this.getErrorConfigVersion;
        if (shimmerServiceAdapter != null) {
            shimmerServiceAdapter.BuiltInFictitiousFunctionClassFactory = mLayoutReference;
        }
    }

    public final void setShimmerLayoutPromotedServiceReference(int mLayoutReference) {
        this.promotedLayoutReference = mLayoutReference;
        ShimmerServiceAdapter shimmerServiceAdapter = this.getErrorConfigVersion;
        if (shimmerServiceAdapter != null) {
            shimmerServiceAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = mLayoutReference;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x003f -> B:15:0x0044). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.drawable.Drawable __fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray r11, int r12) {
        /*
            byte[] r0 = id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView.BuiltInFictitiousFunctionClassFactory
            r1 = 23
            byte[] r2 = new byte[r1]
            r3 = 4
            r4 = 0
            r5 = 97
            if (r0 != 0) goto L15
            r5 = r2
            r6 = 97
            r7 = 4
            r9 = 0
            r2 = r0
            r0 = r12
            r12 = r11
            goto L44
        L15:
            r3 = r2
            r5 = 4
            r6 = 97
            r7 = 0
            r2 = r0
            r0 = r12
            r12 = r11
        L1d:
            byte r8 = (byte) r6
            int r9 = r7 + 1
            r3[r7] = r8
            if (r9 != r1) goto L3f
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3, r4)
            java.lang.Class r1 = java.lang.Class.forName(r1)
            boolean r11 = r1.isInstance(r11)
            if (r11 == 0) goto L3a
            android.content.Context r12 = (android.content.Context) r12
            android.graphics.drawable.Drawable r11 = com.fullstory.instrumentation.InstrumentInjector.Resources_getDrawable(r12, r0)
            return r11
        L3a:
            android.graphics.drawable.Drawable r11 = r12.getDrawable(r0)
            return r11
        L3f:
            r7 = r2[r5]
            r10 = r5
            r5 = r3
            r3 = r10
        L44:
            int r3 = r3 + 1
            int r6 = r6 + r7
            int r6 = r6 + (-8)
            r7 = r9
            r10 = r5
            r5 = r3
            r3 = r10
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.richview.servicescard.adapter.ServiceShimmerRecycleView.__fsTypeCheck_9006fe4ec1394eae9d20ad9ddd1cb05d(android.content.res.TypedArray, int):android.graphics.drawable.Drawable");
    }
}
