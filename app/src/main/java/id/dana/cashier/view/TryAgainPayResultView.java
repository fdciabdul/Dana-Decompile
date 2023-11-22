package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.cashier.adapter.CashierPayMethodListener;
import id.dana.cashier.adapter.PayMethodSelectionTryAgainAdapter;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewTryAgainResultBinding;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B/\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 ¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R:\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0007@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0018\u001a\u0004\u0018\u00010\t8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0012\u001a\u00020\u00198\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b"}, d2 = {"Lid/dana/cashier/view/TryAgainPayResultView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewTryAgainResultBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewTryAgainResultBinding;", "", "setup", "()V", "", "Lid/dana/cashier/model/CashierPayMethodModel;", "value", "BuiltInFictitiousFunctionClassFactory", "Ljava/util/List;", "getPayMethodModels", "()Ljava/util/List;", "setPayMethodModels", "(Ljava/util/List;)V", "payMethodModels", "getAuthRequestContext", "Lid/dana/cashier/model/CashierPayMethodModel;", "getSelectedPayMethod", "()Lid/dana/cashier/model/CashierPayMethodModel;", "setSelectedPayMethod", "(Lid/dana/cashier/model/CashierPayMethodModel;)V", "selectedPayMethod", "Lid/dana/cashier/adapter/PayMethodSelectionTryAgainAdapter;", "MyBillsEntityDataFactory", "Lid/dana/cashier/adapter/PayMethodSelectionTryAgainAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TryAgainPayResultView extends BaseViewBindingRichView<ViewTryAgainResultBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private List<? extends CashierPayMethodModel> payMethodModels;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private PayMethodSelectionTryAgainAdapter getAuthRequestContext;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private CashierPayMethodModel selectedPayMethod;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TryAgainPayResultView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TryAgainPayResultView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TryAgainPayResultView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TryAgainPayResultView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
    }

    public /* synthetic */ TryAgainPayResultView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @JvmName(name = "getPayMethodModels")
    public final List<CashierPayMethodModel> getPayMethodModels() {
        return this.payMethodModels;
    }

    @JvmName(name = "setPayMethodModels")
    public final void setPayMethodModels(List<? extends CashierPayMethodModel> list) {
        CashierPayMethodModel cashierPayMethodModel;
        this.payMethodModels = list;
        List<? extends CashierPayMethodModel> list2 = list;
        if (list2 == null || list2.isEmpty()) {
            return;
        }
        List<? extends CashierPayMethodModel> list3 = this.payMethodModels;
        if (list3 != null && (cashierPayMethodModel = (CashierPayMethodModel) CollectionsKt.first((List) list3)) != null) {
            cashierPayMethodModel.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
            this.selectedPayMethod = cashierPayMethodModel;
        }
        PayMethodSelectionTryAgainAdapter payMethodSelectionTryAgainAdapter = this.getAuthRequestContext;
        if (payMethodSelectionTryAgainAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            payMethodSelectionTryAgainAdapter = null;
        }
        payMethodSelectionTryAgainAdapter.setItems(this.payMethodModels);
        setVisibility(0);
    }

    @JvmName(name = "getSelectedPayMethod")
    public final CashierPayMethodModel getSelectedPayMethod() {
        return this.selectedPayMethod;
    }

    @JvmName(name = "setSelectedPayMethod")
    public final void setSelectedPayMethod(CashierPayMethodModel cashierPayMethodModel) {
        this.selectedPayMethod = cashierPayMethodModel;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewTryAgainResultBinding inflateViewBinding() {
        ViewTryAgainResultBinding KClassImpl$Data$declaredNonStaticMembers$2 = ViewTryAgainResultBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
        return KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        this.getAuthRequestContext = new PayMethodSelectionTryAgainAdapter(new CashierPayMethodListener() { // from class: id.dana.cashier.view.TryAgainPayResultView$initAdapter$1
            @Override // id.dana.cashier.adapter.CashierPayMethodListener
            public final void getAuthRequestContext() {
            }

            @Override // id.dana.cashier.adapter.CashierPayMethodListener
            public final void getAuthRequestContext(boolean p0, CashierPayMethodModel p1) {
                Intrinsics.checkNotNullParameter(p1, "");
            }

            @Override // id.dana.cashier.adapter.CashierPayMethodListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(CashierPayMethodModel p0) {
                Intrinsics.checkNotNullParameter(p0, "");
                TryAgainPayResultView.this.setSelectedPayMethod(p0);
            }
        });
        if (getContext() != null) {
            RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            PayMethodSelectionTryAgainAdapter payMethodSelectionTryAgainAdapter = this.getAuthRequestContext;
            if (payMethodSelectionTryAgainAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
                payMethodSelectionTryAgainAdapter = null;
            }
            recyclerView.setAdapter(payMethodSelectionTryAgainAdapter);
            recyclerView.setHasFixedSize(true);
        }
    }
}
