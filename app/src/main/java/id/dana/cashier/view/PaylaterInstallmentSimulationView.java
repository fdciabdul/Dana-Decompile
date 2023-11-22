package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.adapter.PaylaterInstallmentSimulationAdapter;
import id.dana.cashier.model.RepaymentInfoModel;
import id.dana.databinding.ViewPaylaterInstallmentSimulationBinding;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001bB+\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\u0006\u0010\u001c\u001a\u00020\u0003\u0012\u0006\u0010\u001d\u001a\u00020\u0003¢\u0006\u0004\b\u001a\u0010\u001eJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/cashier/view/PaylaterInstallmentSimulationView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewPaylaterInstallmentSimulationBinding;", "", "getLayout", "()I", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewPaylaterInstallmentSimulationBinding;", "", "Lid/dana/cashier/model/RepaymentInfoModel;", "repaymentInfos", "", "setInstallmentSimulationItems", "(Ljava/util/List;)V", "setup", "()V", "Lid/dana/cashier/adapter/PaylaterInstallmentSimulationAdapter;", "PlaceComponentResult", "Lid/dana/cashier/adapter/PaylaterInstallmentSimulationAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PaylaterInstallmentSimulationView extends ViewBindingRichView<ViewPaylaterInstallmentSimulationBinding> {
    private PaylaterInstallmentSimulationAdapter PlaceComponentResult;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentSimulationView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentSimulationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.base.viewbinding.ViewBindingRichView
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
        return R.layout.view_paylater_installment_simulation;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentSimulationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ PaylaterInstallmentSimulationView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PaylaterInstallmentSimulationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewPaylaterInstallmentSimulationBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewPaylaterInstallmentSimulationBinding MyBillsEntityDataFactory = ViewPaylaterInstallmentSimulationBinding.MyBillsEntityDataFactory(view);
        Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
        return MyBillsEntityDataFactory;
    }

    public final void setInstallmentSimulationItems(List<RepaymentInfoModel> repaymentInfos) {
        Intrinsics.checkNotNullParameter(repaymentInfos, "");
        PaylaterInstallmentSimulationAdapter paylaterInstallmentSimulationAdapter = this.PlaceComponentResult;
        PaylaterInstallmentSimulationAdapter paylaterInstallmentSimulationAdapter2 = null;
        if (paylaterInstallmentSimulationAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            paylaterInstallmentSimulationAdapter = null;
        }
        paylaterInstallmentSimulationAdapter.setItems(repaymentInfos);
        PaylaterInstallmentSimulationAdapter paylaterInstallmentSimulationAdapter3 = this.PlaceComponentResult;
        if (paylaterInstallmentSimulationAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            paylaterInstallmentSimulationAdapter2 = paylaterInstallmentSimulationAdapter3;
        }
        paylaterInstallmentSimulationAdapter2.notifyDataSetChanged();
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
        RecyclerView recyclerView = getBinding().getAuthRequestContext;
        PaylaterInstallmentSimulationAdapter paylaterInstallmentSimulationAdapter = new PaylaterInstallmentSimulationAdapter();
        recyclerView.setAdapter(paylaterInstallmentSimulationAdapter);
        this.PlaceComponentResult = paylaterInstallmentSimulationAdapter;
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
    }
}
