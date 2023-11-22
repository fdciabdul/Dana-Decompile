package id.dana.globalsearch.view.sku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.base.BaseRichView;
import id.dana.globalsearch.view.sku.adapter.SKUItemAdapter;
import id.dana.globalsearch.view.sku.model.SKUModel;
import id.dana.utils.EdgeDecorator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001dB+\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\u0002¢\u0006\u0004\b\u001c\u0010\u001fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001d\u0010\t\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nJ!\u0010\r\u001a\u00020\b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0011\u001a\u00020\u00148\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016"}, d2 = {"Lid/dana/globalsearch/view/sku/SKUItemView;", "Lid/dana/base/BaseRichView;", "", "getLayout", "()I", "", "Lid/dana/globalsearch/view/sku/model/SKUModel;", "skuModels", "", "setData", "(Ljava/util/List;)V", "Lkotlin/Function1;", "onItemClickCallback", "setItemClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "setup", "()V", "MyBillsEntityDataFactory", "Lkotlin/jvm/functions/Function1;", "PlaceComponentResult", "Lid/dana/globalsearch/view/sku/adapter/SKUItemAdapter;", "BuiltInFictitiousFunctionClassFactory", "Lid/dana/globalsearch/view/sku/adapter/SKUItemAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SKUItemView extends BaseRichView {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private SKUItemAdapter MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private Function1<? super Integer, Unit> PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SKUItemView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SKUItemView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_service;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SKUItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ SKUItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SKUItemView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public final void setData(List<SKUModel> skuModels) {
        SKUItemAdapter sKUItemAdapter = this.MyBillsEntityDataFactory;
        SKUItemAdapter sKUItemAdapter2 = null;
        if (sKUItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            sKUItemAdapter = null;
        }
        sKUItemAdapter.setItems(skuModels);
        SKUItemAdapter sKUItemAdapter3 = this.MyBillsEntityDataFactory;
        if (sKUItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            sKUItemAdapter2 = sKUItemAdapter3;
        }
        sKUItemAdapter2.notifyDataSetChanged();
    }

    public final void setItemClickCallback(Function1<? super Integer, Unit> onItemClickCallback) {
        Intrinsics.checkNotNullParameter(onItemClickCallback, "");
        this.PlaceComponentResult = onItemClickCallback;
    }

    public static /* synthetic */ void $r8$lambda$5py5GvcoOvaRzfBxbIVuy3ucTuY(SKUItemView sKUItemView, int i) {
        Intrinsics.checkNotNullParameter(sKUItemView, "");
        Function1<? super Integer, Unit> function1 = sKUItemView.PlaceComponentResult;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        SKUItemAdapter sKUItemAdapter = new SKUItemAdapter();
        sKUItemAdapter.setOnItemClickListener(new BaseRecyclerViewHolder.OnItemClickListener() { // from class: id.dana.globalsearch.view.sku.SKUItemView$$ExternalSyntheticLambda0
            @Override // id.dana.base.BaseRecyclerViewHolder.OnItemClickListener
            public final void onItemClick(int i) {
                SKUItemView.$r8$lambda$5py5GvcoOvaRzfBxbIVuy3ucTuY(SKUItemView.this, i);
            }
        });
        this.MyBillsEntityDataFactory = sKUItemAdapter;
        RecyclerView recyclerView = (RecyclerView) _$_findCachedViewById(R.id.res_0x7f0a10fe_descriptorvisibilities_8);
        if (recyclerView != null) {
            SKUItemAdapter sKUItemAdapter2 = this.MyBillsEntityDataFactory;
            if (sKUItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                sKUItemAdapter2 = null;
            }
            recyclerView.setAdapter(sKUItemAdapter2);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            recyclerView.addItemDecoration(new EdgeDecorator(getResources().getDimensionPixelOffset(R.dimen.f28172131165296), getResources().getDimensionPixelOffset(R.dimen.f28162131165295), getResources().getDimensionPixelOffset(R.dimen.f28162131165295)));
        }
    }
}
