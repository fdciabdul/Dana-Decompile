package id.dana.cashier.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.R;
import id.dana.base.viewbinding.ViewBindingRichView;
import id.dana.cashier.adapter.CashierAddOnAdapter;
import id.dana.cashier.bottomsheet.CashierAddonInfoBottomSheetDialog;
import id.dana.cashier.model.CashierAddOnModalContentModel;
import id.dana.cashier.model.CashierAddOnModalTooltipModel;
import id.dana.cashier.model.CashierOrderGoodModel;
import id.dana.cashier.viewholder.CashierAddOnPriorityViewHolder;
import id.dana.cashier.viewholder.CashierAddOnViewHolder;
import id.dana.databinding.ViewPayConfirmationAddOnBinding;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\b\u0016\u0012\u0006\u0010T\u001a\u00020S\u0012\n\b\u0002\u0010V\u001a\u0004\u0018\u00010U\u0012\b\b\u0002\u0010W\u001a\u00020\u000f¢\u0006\u0004\bX\u0010YB+\b\u0016\u0012\u0006\u0010T\u001a\u00020S\u0012\b\u0010V\u001a\u0004\u0018\u00010U\u0012\u0006\u0010Z\u001a\u00020\u000f\u0012\u0006\u0010[\u001a\u00020\u000f¢\u0006\u0004\bX\u0010\\J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0018\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aH\u0014¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020\u0005¢\u0006\u0004\b#\u0010$J\r\u0010%\u001a\u00020\u0005¢\u0006\u0004\b%\u0010$J\u001b\u0010)\u001a\u00020\u00052\f\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010$J\u001b\u0010-\u001a\u00020\u00052\f\u0010,\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u0004\b-\u0010*R\u0014\u00100\u001a\u00020.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010/R\u0013\u0010\n\u001a\u000201X\u0082\u0080\u0002¢\u0006\u0006\n\u0004\b0\u00102R\"\u00105\u001a\u0002038\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u0016\u0010\r\u001a\u0002038\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u0010\u00104R\"\u0010>\u001a\u00020\u00038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010\u0007R\"\u0010B\u001a\u0002038\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u00104\u001a\u0004\b@\u00106\"\u0004\bA\u00108R4\u0010J\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00050C8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010E\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IRF\u0010R\u001a&\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050K8\u0007@\u0007X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010Q"}, d2 = {"Lid/dana/cashier/view/CashierAddOnView;", "Lid/dana/base/viewbinding/ViewBindingRichView;", "Lid/dana/databinding/ViewPayConfirmationAddOnBinding;", "", "selectedAddOnId", "", "doFallbackAddOnCheckBox", "(Ljava/lang/String;)V", "p0", "Lid/dana/cashier/viewholder/CashierAddOnPriorityViewHolder;", "getAuthRequestContext", "(Ljava/lang/String;)Lid/dana/cashier/viewholder/CashierAddOnPriorityViewHolder;", "Lid/dana/cashier/viewholder/CashierAddOnViewHolder;", "BuiltInFictitiousFunctionClassFactory", "(Ljava/lang/String;)Lid/dana/cashier/viewholder/CashierAddOnViewHolder;", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;)I", "getLayout", "()I", "Lid/dana/cashier/model/CashierAddOnModalTooltipModel;", "cashierAddOnModalTooltipModel", "Lid/dana/cashier/model/CashierAddOnModalContentModel;", "cashierAddOnModalContentModel", "initCashierAddOnInfoDialog", "(Lid/dana/cashier/model/CashierAddOnModalTooltipModel;Lid/dana/cashier/model/CashierAddOnModalContentModel;)V", "Landroid/view/View;", "view", "initViewBinding", "(Landroid/view/View;)Lid/dana/databinding/ViewPayConfirmationAddOnBinding;", "image", "title", "content", "initcashierAddOnInfoDialogFromCdn", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "resetCheckboxState", "()V", "reverLastClickedCheck", "", "Lid/dana/cashier/model/CashierOrderGoodModel;", "cashierOrderGoodModels", "setItems", "(Ljava/util/List;)V", "setup", FirebaseAnalytics.Param.ITEMS, "updateItems", "Lid/dana/cashier/adapter/CashierAddOnAdapter;", "Lid/dana/cashier/adapter/CashierAddOnAdapter;", "MyBillsEntityDataFactory", "Lid/dana/cashier/bottomsheet/CashierAddonInfoBottomSheetDialog;", "Lkotlin/Lazy;", "", "Z", "isCashierOrderGoodExists", "()Z", "setCashierOrderGoodExists", "(Z)V", "PlaceComponentResult", "Ljava/lang/String;", "getLastAddOnIdClicked", "()Ljava/lang/String;", "setLastAddOnIdClicked", "lastAddOnIdClicked", "NetworkUserEntityData$$ExternalSyntheticLambda0", "getLastStateAddOnChecked", "setLastStateAddOnChecked", "lastStateAddOnChecked", "Lkotlin/Function2;", "lookAheadTest", "Lkotlin/jvm/functions/Function2;", "getOnCheckBoxAddOnClicked", "()Lkotlin/jvm/functions/Function2;", "setOnCheckBoxAddOnClicked", "(Lkotlin/jvm/functions/Function2;)V", "onCheckBoxAddOnClicked", "Lkotlin/Function5;", "moveToNextValue", "Lkotlin/jvm/functions/Function5;", "getOnClickCashierAddOnInfo", "()Lkotlin/jvm/functions/Function5;", "setOnClickCashierAddOnInfo", "(Lkotlin/jvm/functions/Function5;)V", "onClickCashierAddOnInfo", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleAttr", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CashierAddOnView extends ViewBindingRichView<ViewPayConfirmationAddOnBinding> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CashierAddOnAdapter MyBillsEntityDataFactory;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Lazy getAuthRequestContext;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean lastStateAddOnChecked;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String lastAddOnIdClicked;
    public Map<Integer, View> _$_findViewCache;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private boolean isCashierOrderGoodExists;

    /* renamed from: lookAheadTest  reason: from kotlin metadata */
    private Function2<? super String, ? super Boolean, Unit> onCheckBoxAddOnClicked;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private Function5<? super String, ? super String, ? super String, ? super Boolean, ? super String, Unit> onClickCashierAddOnInfo;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierAddOnView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CashierAddOnView(Context context, AttributeSet attributeSet) {
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
        return R.layout.view_pay_confirmation_add_on;
    }

    @Override // id.dana.base.BaseRichView
    public final void setup() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierAddOnView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onCheckBoxAddOnClicked = CashierAddOnView$onCheckBoxAddOnClicked$1.INSTANCE;
        this.onClickCashierAddOnInfo = CashierAddOnView$onClickCashierAddOnInfo$1.INSTANCE;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.lastAddOnIdClicked = "";
        this.MyBillsEntityDataFactory = new CashierAddOnAdapter(new Function2<String, Boolean, Unit>() { // from class: id.dana.cashier.view.CashierAddOnView$addOnAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "");
                CashierAddOnView.this.setLastAddOnIdClicked(str);
                CashierAddOnView.this.setLastStateAddOnChecked(z);
                CashierAddOnView.this.getOnCheckBoxAddOnClicked().invoke(str, Boolean.valueOf(z));
            }
        }, new Function5<String, String, String, Boolean, String, Unit>() { // from class: id.dana.cashier.view.CashierAddOnView$addOnAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final /* synthetic */ Unit invoke(String str, String str2, String str3, Boolean bool, String str4) {
                invoke(str, str2, str3, bool.booleanValue(), str4);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, String str2, String str3, boolean z, String str4) {
                boolean z2;
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str4, "");
                z2 = CashierAddOnView.this.BuiltInFictitiousFunctionClassFactory;
                if (z2) {
                    CashierAddOnView.this.getOnClickCashierAddOnInfo().invoke(str, str2, str3, Boolean.valueOf(z), str4);
                }
                CashierAddOnView.this.BuiltInFictitiousFunctionClassFactory = true;
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(CashierAddOnView$cashierAddonInfoBottomSheetDialog$2.INSTANCE);
    }

    public /* synthetic */ CashierAddOnView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CashierAddOnView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.onCheckBoxAddOnClicked = CashierAddOnView$onCheckBoxAddOnClicked$1.INSTANCE;
        this.onClickCashierAddOnInfo = CashierAddOnView$onClickCashierAddOnInfo$1.INSTANCE;
        this.BuiltInFictitiousFunctionClassFactory = true;
        this.lastAddOnIdClicked = "";
        this.MyBillsEntityDataFactory = new CashierAddOnAdapter(new Function2<String, Boolean, Unit>() { // from class: id.dana.cashier.view.CashierAddOnView$addOnAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final /* synthetic */ Unit invoke(String str, Boolean bool) {
                invoke(str, bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(String str, boolean z) {
                Intrinsics.checkNotNullParameter(str, "");
                CashierAddOnView.this.setLastAddOnIdClicked(str);
                CashierAddOnView.this.setLastStateAddOnChecked(z);
                CashierAddOnView.this.getOnCheckBoxAddOnClicked().invoke(str, Boolean.valueOf(z));
            }
        }, new Function5<String, String, String, Boolean, String, Unit>() { // from class: id.dana.cashier.view.CashierAddOnView$addOnAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(5);
            }

            @Override // kotlin.jvm.functions.Function5
            public final /* synthetic */ Unit invoke(String str, String str2, String str3, Boolean bool, String str4) {
                invoke(str, str2, str3, bool.booleanValue(), str4);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, String str2, String str3, boolean z, String str4) {
                boolean z2;
                Intrinsics.checkNotNullParameter(str, "");
                Intrinsics.checkNotNullParameter(str2, "");
                Intrinsics.checkNotNullParameter(str3, "");
                Intrinsics.checkNotNullParameter(str4, "");
                z2 = CashierAddOnView.this.BuiltInFictitiousFunctionClassFactory;
                if (z2) {
                    CashierAddOnView.this.getOnClickCashierAddOnInfo().invoke(str, str2, str3, Boolean.valueOf(z), str4);
                }
                CashierAddOnView.this.BuiltInFictitiousFunctionClassFactory = true;
            }
        });
        this.getAuthRequestContext = LazyKt.lazy(CashierAddOnView$cashierAddonInfoBottomSheetDialog$2.INSTANCE);
    }

    @JvmName(name = "getOnCheckBoxAddOnClicked")
    public final Function2<String, Boolean, Unit> getOnCheckBoxAddOnClicked() {
        return this.onCheckBoxAddOnClicked;
    }

    @JvmName(name = "setOnCheckBoxAddOnClicked")
    public final void setOnCheckBoxAddOnClicked(Function2<? super String, ? super Boolean, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "");
        this.onCheckBoxAddOnClicked = function2;
    }

    @JvmName(name = "getOnClickCashierAddOnInfo")
    public final Function5<String, String, String, Boolean, String, Unit> getOnClickCashierAddOnInfo() {
        return this.onClickCashierAddOnInfo;
    }

    @JvmName(name = "setOnClickCashierAddOnInfo")
    public final void setOnClickCashierAddOnInfo(Function5<? super String, ? super String, ? super String, ? super Boolean, ? super String, Unit> function5) {
        Intrinsics.checkNotNullParameter(function5, "");
        this.onClickCashierAddOnInfo = function5;
    }

    @JvmName(name = "isCashierOrderGoodExists")
    /* renamed from: isCashierOrderGoodExists  reason: from getter */
    public final boolean getIsCashierOrderGoodExists() {
        return this.isCashierOrderGoodExists;
    }

    @JvmName(name = "setCashierOrderGoodExists")
    public final void setCashierOrderGoodExists(boolean z) {
        this.isCashierOrderGoodExists = z;
    }

    @JvmName(name = "getLastAddOnIdClicked")
    public final String getLastAddOnIdClicked() {
        return this.lastAddOnIdClicked;
    }

    @JvmName(name = "setLastAddOnIdClicked")
    public final void setLastAddOnIdClicked(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.lastAddOnIdClicked = str;
    }

    @JvmName(name = "getLastStateAddOnChecked")
    public final boolean getLastStateAddOnChecked() {
        return this.lastStateAddOnChecked;
    }

    @JvmName(name = "setLastStateAddOnChecked")
    public final void setLastStateAddOnChecked(boolean z) {
        this.lastStateAddOnChecked = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // id.dana.base.viewbinding.ViewBindingRichView
    public final ViewPayConfirmationAddOnBinding initViewBinding(View view) {
        Intrinsics.checkNotNullParameter(view, "");
        ViewPayConfirmationAddOnBinding authRequestContext = ViewPayConfirmationAddOnBinding.getAuthRequestContext(view);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public final void setItems(List<CashierOrderGoodModel> cashierOrderGoodModels) {
        Intrinsics.checkNotNullParameter(cashierOrderGoodModels, "");
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        recyclerView.setAdapter(this.MyBillsEntityDataFactory);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setNestedScrollingEnabled(false);
        this.MyBillsEntityDataFactory.setItems(cashierOrderGoodModels);
        this.isCashierOrderGoodExists = !cashierOrderGoodModels.isEmpty();
    }

    public final void updateItems(List<CashierOrderGoodModel> items) {
        Intrinsics.checkNotNullParameter(items, "");
        this.MyBillsEntityDataFactory.setItems(items);
    }

    public final void doFallbackAddOnCheckBox(String selectedAddOnId) {
        Object obj;
        Intrinsics.checkNotNullParameter(selectedAddOnId, "");
        this.BuiltInFictitiousFunctionClassFactory = false;
        List<CashierOrderGoodModel> items = this.MyBillsEntityDataFactory.getItems();
        Intrinsics.checkNotNullExpressionValue(items, "");
        Iterator<T> it = items.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((CashierOrderGoodModel) obj).MyBillsEntityDataFactory, selectedAddOnId)) {
                break;
            }
        }
        CashierOrderGoodModel cashierOrderGoodModel = (CashierOrderGoodModel) obj;
        if (cashierOrderGoodModel != null) {
            if (cashierOrderGoodModel.newProxyInstance == 2) {
                CashierAddOnPriorityViewHolder authRequestContext = getAuthRequestContext(selectedAddOnId);
                if (authRequestContext != null) {
                    authRequestContext.getBinding().KClassImpl$Data$declaredNonStaticMembers$2.setChecked(!r4.isChecked());
                    return;
                }
                return;
            }
            CashierAddOnViewHolder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(selectedAddOnId);
            if (BuiltInFictitiousFunctionClassFactory != null) {
                BuiltInFictitiousFunctionClassFactory.getBinding().PlaceComponentResult.setChecked(!r4.isChecked());
            }
        }
    }

    public final void reverLastClickedCheck() {
        if (this.isCashierOrderGoodExists && (!StringsKt.isBlank(this.lastAddOnIdClicked)) == true) {
            doFallbackAddOnCheckBox(this.lastAddOnIdClicked);
        }
    }

    public final void resetCheckboxState() {
        List<CashierOrderGoodModel> items = this.MyBillsEntityDataFactory.getItems();
        if (items != null) {
            for (CashierOrderGoodModel cashierOrderGoodModel : items) {
                this.BuiltInFictitiousFunctionClassFactory = false;
                if (cashierOrderGoodModel.newProxyInstance == 2) {
                    String str = cashierOrderGoodModel.MyBillsEntityDataFactory;
                    CashierAddOnPriorityViewHolder authRequestContext = getAuthRequestContext(str != null ? str : "");
                    if (authRequestContext != null) {
                        AppCompatCheckBox appCompatCheckBox = authRequestContext.getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
                        if (appCompatCheckBox.isEnabled()) {
                            appCompatCheckBox.setChecked(false);
                        }
                    }
                } else {
                    String str2 = cashierOrderGoodModel.MyBillsEntityDataFactory;
                    CashierAddOnViewHolder BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory(str2 != null ? str2 : "");
                    if (BuiltInFictitiousFunctionClassFactory != null) {
                        AppCompatCheckBox appCompatCheckBox2 = BuiltInFictitiousFunctionClassFactory.getBinding().PlaceComponentResult;
                        if (appCompatCheckBox2.isEnabled()) {
                            appCompatCheckBox2.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    private final CashierAddOnViewHolder BuiltInFictitiousFunctionClassFactory(String p0) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.findViewHolderForLayoutPosition(KClassImpl$Data$declaredNonStaticMembers$2(p0));
        if (findViewHolderForLayoutPosition instanceof CashierAddOnViewHolder) {
            return (CashierAddOnViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    private final CashierAddOnPriorityViewHolder getAuthRequestContext(String p0) {
        RecyclerView.ViewHolder findViewHolderForLayoutPosition = getBinding().KClassImpl$Data$declaredNonStaticMembers$2.findViewHolderForLayoutPosition(KClassImpl$Data$declaredNonStaticMembers$2(p0));
        if (findViewHolderForLayoutPosition instanceof CashierAddOnPriorityViewHolder) {
            return (CashierAddOnPriorityViewHolder) findViewHolderForLayoutPosition;
        }
        return null;
    }

    private final int KClassImpl$Data$declaredNonStaticMembers$2(String p0) {
        List<CashierOrderGoodModel> items = this.MyBillsEntityDataFactory.getItems();
        if (items != null) {
            int i = 0;
            Iterator<CashierOrderGoodModel> it = items.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().MyBillsEntityDataFactory, p0)) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        return -1;
    }

    public final void initCashierAddOnInfoDialog(CashierAddOnModalTooltipModel cashierAddOnModalTooltipModel, CashierAddOnModalContentModel cashierAddOnModalContentModel) {
        ((CashierAddonInfoBottomSheetDialog) this.getAuthRequestContext.getValue()).setCancelable(false);
        CashierAddonInfoBottomSheetDialog cashierAddonInfoBottomSheetDialog = (CashierAddonInfoBottomSheetDialog) this.getAuthRequestContext.getValue();
        cashierAddonInfoBottomSheetDialog.getAuthRequestContext = cashierAddOnModalTooltipModel;
        cashierAddonInfoBottomSheetDialog.MyBillsEntityDataFactory = cashierAddOnModalContentModel;
        ((CashierAddonInfoBottomSheetDialog) this.getAuthRequestContext.getValue()).show(getBaseActivity().getSupportFragmentManager(), "CashierAddonInfoBottomSheetDialog");
    }

    public final void initcashierAddOnInfoDialogFromCdn(String image, String title, String content) {
        Intrinsics.checkNotNullParameter(image, "");
        Intrinsics.checkNotNullParameter(title, "");
        Intrinsics.checkNotNullParameter(content, "");
        CashierAddonInfoBottomSheetDialog cashierAddonInfoBottomSheetDialog = (CashierAddonInfoBottomSheetDialog) this.getAuthRequestContext.getValue();
        cashierAddonInfoBottomSheetDialog.setCancelable(false);
        cashierAddonInfoBottomSheetDialog.getErrorConfigVersion = true;
        Intrinsics.checkNotNullParameter(content, "");
        cashierAddonInfoBottomSheetDialog.PlaceComponentResult = content;
        Intrinsics.checkNotNullParameter(title, "");
        cashierAddonInfoBottomSheetDialog.scheduleImpl = title;
        Intrinsics.checkNotNullParameter(image, "");
        cashierAddonInfoBottomSheetDialog.lookAheadTest = image;
        ((CashierAddonInfoBottomSheetDialog) this.getAuthRequestContext.getValue()).show(getBaseActivity().getSupportFragmentManager(), "CashierAddonInfoBottomSheetDialog");
    }
}
