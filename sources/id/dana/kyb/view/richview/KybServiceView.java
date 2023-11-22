package id.dana.kyb.view.richview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.ethanhua.skeleton.RecyclerViewSkeletonScreen;
import com.ethanhua.skeleton.Skeleton;
import com.ethanhua.skeleton.SkeletonScreen;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.BaseRichView;
import id.dana.kyb.adapter.KybServiceAdapter;
import id.dana.kyb.model.KybServiceModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\n\b\u0002\u0010/\u001a\u0004\u0018\u00010.\u0012\b\b\u0002\u00100\u001a\u00020\b¢\u0006\u0004\b1\u00102B+\b\u0016\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00100\u001a\u00020\b\u0012\u0006\u00103\u001a\u00020\b¢\u0006\u0004\b1\u00104J\u001b\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\r\u0010\u000b\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u00052\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\rj\u0002`\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\r\u0010\u0013\u001a\u00020\u0005¢\u0006\u0004\b\u0013\u0010\fJ\r\u0010\u0014\u001a\u00020\u0005¢\u0006\u0004\b\u0014\u0010\fR\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0016\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0018\u0010\u001aR\u0016\u0010\u001c\u001a\u00020\u001b8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR&\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\rj\u0002`\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\u001e\u001a\u00020!8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b \u0010\"R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010$\u001a\u00020'8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010+\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b*\u0010\u001aR\u0016\u0010(\u001a\u00020\u00198\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b&\u0010\u001a"}, d2 = {"Lid/dana/kyb/view/richview/KybServiceView;", "Lid/dana/component/BaseRichView;", "", "Lid/dana/kyb/model/KybServiceModel;", "kybServiceList", "", "bindKybServiceList", "(Ljava/util/List;)V", "", "getLayout", "()I", "hideSkeleton", "()V", "Lkotlin/Function1;", "Lid/dana/kyb/helper/service/listener/KybServiceClickListener;", "kybServiceClickListener", "setKybServiceClickListener", "(Lkotlin/jvm/functions/Function1;)V", "setup", "showEmptyState", "showSkeleton", "Lid/dana/kyb/adapter/KybServiceAdapter;", "MyBillsEntityDataFactory", "Lid/dana/kyb/adapter/KybServiceAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "Landroid/view/ViewGroup;", "Landroid/widget/ImageView;", "BuiltInFictitiousFunctionClassFactory", "Landroid/widget/ImageView;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "getAuthRequestContext", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/ethanhua/skeleton/SkeletonScreen;", "scheduleImpl", "Lcom/ethanhua/skeleton/SkeletonScreen;", "NetworkUserEntityData$$ExternalSyntheticLambda0", "Landroid/widget/TextView;", "lookAheadTest", "Landroid/widget/TextView;", "moveToNextValue", "getErrorConfigVersion", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KybServiceView extends BaseRichView {
    private ImageView BuiltInFictitiousFunctionClassFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private ViewGroup MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private KybServiceAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private ViewGroup lookAheadTest;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function1<? super KybServiceModel, Unit> getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private RecyclerView PlaceComponentResult;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private TextView scheduleImpl;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private ViewGroup getErrorConfigVersion;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private SkeletonScreen NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybServiceView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public KybServiceView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_kyb_service;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybServiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = KybServiceView$kybServiceClickListener$1.INSTANCE;
    }

    public /* synthetic */ KybServiceView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KybServiceView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.getAuthRequestContext = KybServiceView$kybServiceClickListener$1.INSTANCE;
    }

    public final void bindKybServiceList(List<KybServiceModel> kybServiceList) {
        Intrinsics.checkNotNullParameter(kybServiceList, "");
        hideSkeleton();
        if (kybServiceList.isEmpty()) {
            showEmptyState();
            return;
        }
        ViewGroup viewGroup = this.getErrorConfigVersion;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        ViewGroup viewGroup3 = this.lookAheadTest;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup3 = null;
        }
        viewGroup3.setVisibility(0);
        KybServiceAdapter kybServiceAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (kybServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            kybServiceAdapter = null;
        }
        kybServiceAdapter.setItems(kybServiceList);
        ViewGroup viewGroup4 = this.MyBillsEntityDataFactory;
        if (viewGroup4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            viewGroup2 = viewGroup4;
        }
        viewGroup2.setVisibility(kybServiceList.size() > 4 ? 0 : 8);
    }

    public final void setKybServiceClickListener(Function1<? super KybServiceModel, Unit> kybServiceClickListener) {
        Intrinsics.checkNotNullParameter(kybServiceClickListener, "");
        this.getAuthRequestContext = kybServiceClickListener;
    }

    public final void showSkeleton() {
        Unit unit;
        ViewGroup viewGroup = this.MyBillsEntityDataFactory;
        KybServiceAdapter kybServiceAdapter = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup = null;
        }
        viewGroup.setVisibility(8);
        SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (skeletonScreen != null) {
            skeletonScreen.MyBillsEntityDataFactory();
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            RecyclerView recyclerView = this.PlaceComponentResult;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                recyclerView = null;
            }
            RecyclerViewSkeletonScreen.Builder BuiltInFictitiousFunctionClassFactory = Skeleton.BuiltInFictitiousFunctionClassFactory(recyclerView);
            KybServiceAdapter kybServiceAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (kybServiceAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                kybServiceAdapter = kybServiceAdapter2;
            }
            BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2 = kybServiceAdapter;
            BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory = R.layout.item_kyb_service_shimmer;
            BuiltInFictitiousFunctionClassFactory.getAuthRequestContext = 8;
            BuiltInFictitiousFunctionClassFactory.getErrorConfigVersion = ContextCompat.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.getContext(), R.color.f27082131100491);
            BuiltInFictitiousFunctionClassFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = 1500;
            BuiltInFictitiousFunctionClassFactory.lookAheadTest = 0;
            BuiltInFictitiousFunctionClassFactory.PlaceComponentResult = true;
            RecyclerViewSkeletonScreen recyclerViewSkeletonScreen = new RecyclerViewSkeletonScreen(BuiltInFictitiousFunctionClassFactory, (byte) 0);
            recyclerViewSkeletonScreen.MyBillsEntityDataFactory();
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = recyclerViewSkeletonScreen;
        }
    }

    public final void hideSkeleton() {
        SkeletonScreen skeletonScreen = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        if (skeletonScreen != null) {
            skeletonScreen.PlaceComponentResult();
        }
    }

    public final void showEmptyState() {
        ViewGroup viewGroup = this.getErrorConfigVersion;
        ViewGroup viewGroup2 = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup = null;
        }
        viewGroup.setVisibility(0);
        ViewGroup viewGroup3 = this.lookAheadTest;
        if (viewGroup3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            viewGroup2 = viewGroup3;
        }
        viewGroup2.setVisibility(8);
    }

    public static /* synthetic */ void $r8$lambda$G0GEXfw2MZ54DHFCf6w5WuSZgV4(KybServiceView kybServiceView, View view) {
        Intrinsics.checkNotNullParameter(kybServiceView, "");
        KybServiceAdapter kybServiceAdapter = kybServiceView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (kybServiceAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            kybServiceAdapter = null;
        }
        kybServiceAdapter.getAuthRequestContext();
    }

    /* renamed from: $r8$lambda$Vamqcdw_zd2Ot3s-3xijQ1ssRBY  reason: not valid java name */
    public static /* synthetic */ void m2636$r8$lambda$Vamqcdw_zd2Ot3s3xijQ1ssRBY(KybServiceView kybServiceView, KybServiceAdapter kybServiceAdapter, int i) {
        Intrinsics.checkNotNullParameter(kybServiceView, "");
        Intrinsics.checkNotNullParameter(kybServiceAdapter, "");
        KybServiceModel item = kybServiceAdapter.getItem(i);
        Intrinsics.checkNotNullExpressionValue(item, "");
        kybServiceView.getAuthRequestContext.invoke(item);
    }

    public static final /* synthetic */ void access$onRecyclerViewExpanded(KybServiceView kybServiceView, boolean z) {
        ImageView imageView = null;
        if (z) {
            TextView textView = kybServiceView.scheduleImpl;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                textView = null;
            }
            textView.setText(R.string.kyb_service_hide);
            ImageView imageView2 = kybServiceView.BuiltInFictitiousFunctionClassFactory;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                imageView = imageView2;
            }
            InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_chevron_up_18dp_blue50);
            return;
        }
        TextView textView2 = kybServiceView.scheduleImpl;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            textView2 = null;
        }
        textView2.setText(R.string.kyb_service_show);
        ImageView imageView3 = kybServiceView.BuiltInFictitiousFunctionClassFactory;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            imageView = imageView3;
        }
        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.ic_chevron_down_18dp_blue50);
    }

    @Override // id.dana.component.BaseRichView
    public final void setup() {
        View findViewById = findViewById(R.id.vg_filled_service);
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View findViewById2 = viewGroup.findViewById(R.id.rv_kyb_service);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "");
        this.PlaceComponentResult = (RecyclerView) findViewById2;
        View findViewById3 = viewGroup.findViewById(R.id.ll_kyb_service_expand);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "");
        this.MyBillsEntityDataFactory = (ViewGroup) findViewById3;
        View findViewById4 = viewGroup.findViewById(R.id.tv_kyb_service_expand);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "");
        this.scheduleImpl = (TextView) findViewById4;
        View findViewById5 = viewGroup.findViewById(R.id.iv_kyb_service_expand);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "");
        this.BuiltInFictitiousFunctionClassFactory = (ImageView) findViewById5;
        Intrinsics.checkNotNullExpressionValue(findViewById, "");
        this.lookAheadTest = viewGroup;
        View findViewById6 = findViewById(R.id.vg_empty_service);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "");
        this.getErrorConfigVersion = (ViewGroup) findViewById6;
        ViewGroup viewGroup2 = this.MyBillsEntityDataFactory;
        KybServiceAdapter kybServiceAdapter = null;
        if (viewGroup2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            viewGroup2 = null;
        }
        viewGroup2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.kyb.view.richview.KybServiceView$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KybServiceView.$r8$lambda$G0GEXfw2MZ54DHFCf6w5WuSZgV4(KybServiceView.this, view);
            }
        });
        final KybServiceAdapter kybServiceAdapter2 = new KybServiceAdapter(0, 0, false, 7, null);
        kybServiceAdapter2.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.kyb.view.richview.KybServiceView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                KybServiceView.m2636$r8$lambda$Vamqcdw_zd2Ot3s3xijQ1ssRBY(KybServiceView.this, kybServiceAdapter2, i);
            }
        });
        KybServiceView$initRecyclerView$1$2 kybServiceView$initRecyclerView$1$2 = new KybServiceView$initRecyclerView$1$2(this);
        Intrinsics.checkNotNullParameter(kybServiceView$initRecyclerView$1$2, "");
        kybServiceAdapter2.getAuthRequestContext = kybServiceView$initRecyclerView$1$2;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = kybServiceAdapter2;
        RecyclerView recyclerView = this.PlaceComponentResult;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            recyclerView = null;
        }
        final Context context = getContext();
        recyclerView.setLayoutManager(new GridLayoutManager(context) { // from class: id.dana.kyb.view.richview.KybServiceView$initRecyclerView$2$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public final boolean canScrollVertically() {
                return false;
            }
        });
        KybServiceAdapter kybServiceAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (kybServiceAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            kybServiceAdapter = kybServiceAdapter3;
        }
        recyclerView.setAdapter(kybServiceAdapter);
    }
}
