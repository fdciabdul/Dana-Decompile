package id.dana.cashier.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ap.zoloz.hummer.biz.HummerConstants;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.R;
import id.dana.cashier.adapter.TopUpAndPayMethodAdapter;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.core.ui.BaseViewBindingRichView;
import id.dana.databinding.ViewTopUpAndPayMethodBinding;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001'B/\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\b\u0012\b\b\u0002\u0010$\u001a\u00020\b¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J#\u0010\u000b\u001a\u00020\n2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R.\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\u00158\u0007@\u0007X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u001c8\u0002@\u0002X\u0083.¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e"}, d2 = {"Lid/dana/cashier/view/TopUpAndPayMethodView;", "Lid/dana/core/ui/BaseViewBindingRichView;", "Lid/dana/databinding/ViewTopUpAndPayMethodBinding;", "inflateViewBinding", "()Lid/dana/databinding/ViewTopUpAndPayMethodBinding;", "", "Lid/dana/cashier/model/CashierPayMethodModel;", FirebaseAnalytics.Param.ITEMS, "", "viewType", "", "setItems", "(Ljava/util/List;I)V", "p0", "getAuthRequestContext", "(I)V", "setup", "()V", "MyBillsEntityDataFactory", "Ljava/util/List;", "PlaceComponentResult", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "getOnClickTopUpAndPayMethodListener", "()Lkotlin/jvm/functions/Function1;", "setOnClickTopUpAndPayMethodListener", "(Lkotlin/jvm/functions/Function1;)V", "onClickTopUpAndPayMethodListener", "Lid/dana/cashier/adapter/TopUpAndPayMethodAdapter;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/cashier/adapter/TopUpAndPayMethodAdapter;", "Landroid/content/Context;", HummerConstants.CONTEXT, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TopUpAndPayMethodView extends BaseViewBindingRichView<ViewTopUpAndPayMethodBinding> {
    private TopUpAndPayMethodAdapter KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private List<? extends CashierPayMethodModel> PlaceComponentResult;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private Function1<? super CashierPayMethodModel, Unit> onClickTopUpAndPayMethodListener;
    public Map<Integer, View> _$_findViewCache;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopUpAndPayMethodView(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopUpAndPayMethodView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TopUpAndPayMethodView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "");
    }

    public static void __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(AppCompatImageView appCompatImageView, int i) {
        if (appCompatImageView instanceof ImageView) {
            InstrumentInjector.Resources_setImageResource(appCompatImageView, i);
        } else {
            appCompatImageView.setImageResource(i);
        }
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
    public TopUpAndPayMethodView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "");
        this._$_findViewCache = new LinkedHashMap();
        this.PlaceComponentResult = CollectionsKt.emptyList();
        this.onClickTopUpAndPayMethodListener = new Function1<CashierPayMethodModel, Unit>() { // from class: id.dana.cashier.view.TopUpAndPayMethodView$onClickTopUpAndPayMethodListener$1
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPayMethodModel cashierPayMethodModel) {
                Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPayMethodModel cashierPayMethodModel) {
                invoke2(cashierPayMethodModel);
                return Unit.INSTANCE;
            }
        };
    }

    public /* synthetic */ TopUpAndPayMethodView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final ViewTopUpAndPayMethodBinding inflateViewBinding() {
        ViewTopUpAndPayMethodBinding authRequestContext = ViewTopUpAndPayMethodBinding.getAuthRequestContext(LayoutInflater.from(getContext()));
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    @JvmName(name = "getOnClickTopUpAndPayMethodListener")
    public final Function1<CashierPayMethodModel, Unit> getOnClickTopUpAndPayMethodListener() {
        return this.onClickTopUpAndPayMethodListener;
    }

    @JvmName(name = "setOnClickTopUpAndPayMethodListener")
    public final void setOnClickTopUpAndPayMethodListener(Function1<? super CashierPayMethodModel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "");
        this.onClickTopUpAndPayMethodListener = function1;
    }

    private final void getAuthRequestContext(int p0) {
        Integer valueOf;
        Integer valueOf2;
        Integer num = null;
        if (p0 == 0) {
            num = Integer.valueOf((int) R.string.topup_and_pay_via_other_bank_card_title);
            valueOf = Integer.valueOf((int) R.string.topup_and_pay_via_other_bank_card_description);
            valueOf2 = Integer.valueOf((int) R.string.btn_see_more_cards);
        } else if (p0 == 3) {
            num = Integer.valueOf((int) R.string.topup_and_pay_via_other_bank_title);
            valueOf = Integer.valueOf((int) R.string.topup_and_pay_via_other_bank_description);
            valueOf2 = Integer.valueOf((int) R.string.btn_see_more_banks);
        } else if (p0 != 4) {
            valueOf = null;
            valueOf2 = null;
        } else {
            num = Integer.valueOf((int) R.string.topup_and_pay_via_other_agent_title);
            valueOf = Integer.valueOf((int) R.string.topup_and_pay_via_other_agent_description);
            valueOf2 = Integer.valueOf((int) R.string.btn_see_more_agents);
        }
        if (num != null) {
            getBinding().MyBillsEntityDataFactory.setText(getContext().getString(num.intValue()));
        }
        if (valueOf != null) {
            getBinding().getAuthRequestContext.setText(getContext().getString(valueOf.intValue()));
        }
        if (valueOf2 != null) {
            getBinding().PlaceComponentResult.setContentDescription(getContext().getString(valueOf2.intValue()));
        }
    }

    public final void setItems(List<? extends CashierPayMethodModel> items, final int viewType) {
        Integer valueOf;
        Intrinsics.checkNotNullParameter(items, "");
        if (!items.isEmpty()) {
            TopUpAndPayMethodAdapter topUpAndPayMethodAdapter = null;
            if (viewType == 0) {
                valueOf = Integer.valueOf((int) R.string.topup_and_pay_via_bank_card_title);
            } else if (viewType == 3) {
                valueOf = Integer.valueOf((int) R.string.topup_and_pay_via_bank_transfer_title);
            } else {
                valueOf = viewType != 4 ? null : Integer.valueOf((int) R.string.topup_and_pay_via_agent_title);
            }
            if (valueOf != null) {
                getBinding().moveToNextValue.setText(getContext().getString(valueOf.intValue()));
            }
            this.PlaceComponentResult = items;
            if (items.size() > 2) {
                ConstraintLayout constraintLayout = getBinding().PlaceComponentResult;
                Intrinsics.checkNotNullExpressionValue(constraintLayout, "");
                constraintLayout.setVisibility(0);
                final ViewTopUpAndPayMethodBinding binding = getBinding();
                binding.PlaceComponentResult.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.view.TopUpAndPayMethodView$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        TopUpAndPayMethodView.$r8$lambda$c2ECjyE17lDaxG4T7PZtk3uB6bs(TopUpAndPayMethodView.this, binding, viewType, view);
                    }
                });
                getAuthRequestContext(viewType);
                TopUpAndPayMethodAdapter topUpAndPayMethodAdapter2 = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (topUpAndPayMethodAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("");
                } else {
                    topUpAndPayMethodAdapter = topUpAndPayMethodAdapter2;
                }
                topUpAndPayMethodAdapter.setItems(this.PlaceComponentResult.subList(0, 2));
                return;
            }
            ConstraintLayout constraintLayout2 = getBinding().PlaceComponentResult;
            Intrinsics.checkNotNullExpressionValue(constraintLayout2, "");
            constraintLayout2.setVisibility(8);
            TopUpAndPayMethodAdapter topUpAndPayMethodAdapter3 = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (topUpAndPayMethodAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                topUpAndPayMethodAdapter = topUpAndPayMethodAdapter3;
            }
            topUpAndPayMethodAdapter.setItems(this.PlaceComponentResult);
            return;
        }
        setVisibility(8);
    }

    public static /* synthetic */ void $r8$lambda$c2ECjyE17lDaxG4T7PZtk3uB6bs(TopUpAndPayMethodView topUpAndPayMethodView, ViewTopUpAndPayMethodBinding viewTopUpAndPayMethodBinding, int i, View view) {
        Intrinsics.checkNotNullParameter(topUpAndPayMethodView, "");
        Intrinsics.checkNotNullParameter(viewTopUpAndPayMethodBinding, "");
        TopUpAndPayMethodAdapter topUpAndPayMethodAdapter = topUpAndPayMethodView.KClassImpl$Data$declaredNonStaticMembers$2;
        TopUpAndPayMethodAdapter topUpAndPayMethodAdapter2 = null;
        if (topUpAndPayMethodAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            topUpAndPayMethodAdapter = null;
        }
        if (topUpAndPayMethodAdapter.getPlaceComponentResult() > 2) {
            TopUpAndPayMethodAdapter topUpAndPayMethodAdapter3 = topUpAndPayMethodView.KClassImpl$Data$declaredNonStaticMembers$2;
            if (topUpAndPayMethodAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("");
            } else {
                topUpAndPayMethodAdapter2 = topUpAndPayMethodAdapter3;
            }
            topUpAndPayMethodAdapter2.setItems(topUpAndPayMethodView.PlaceComponentResult.subList(0, 2));
            __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(viewTopUpAndPayMethodBinding.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_down_chevron);
            topUpAndPayMethodView.getAuthRequestContext(i);
            return;
        }
        TopUpAndPayMethodAdapter topUpAndPayMethodAdapter4 = topUpAndPayMethodView.KClassImpl$Data$declaredNonStaticMembers$2;
        if (topUpAndPayMethodAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
        } else {
            topUpAndPayMethodAdapter2 = topUpAndPayMethodAdapter4;
        }
        topUpAndPayMethodAdapter2.setItems(topUpAndPayMethodView.PlaceComponentResult);
        __fsTypeCheck_c52aa2dbefd88c9ae00028cadc29fb43(viewTopUpAndPayMethodBinding.BuiltInFictitiousFunctionClassFactory, R.drawable.ic_up_chevron);
        topUpAndPayMethodView.getBinding().MyBillsEntityDataFactory.setText(topUpAndPayMethodView.getContext().getString(R.string.topup_and_pay_show_less_title));
        topUpAndPayMethodView.getBinding().getAuthRequestContext.setText(topUpAndPayMethodView.getContext().getString(R.string.topup_and_pay_show_less_description));
    }

    @Override // id.dana.core.ui.BaseViewBindingRichView
    public final void setup() {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = new TopUpAndPayMethodAdapter(new Function1<CashierPayMethodModel, Unit>() { // from class: id.dana.cashier.view.TopUpAndPayMethodView$initTopUpAndPayMethodAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* bridge */ /* synthetic */ Unit invoke(CashierPayMethodModel cashierPayMethodModel) {
                invoke2(cashierPayMethodModel);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(CashierPayMethodModel cashierPayMethodModel) {
                Intrinsics.checkNotNullParameter(cashierPayMethodModel, "");
                TopUpAndPayMethodView.this.getOnClickTopUpAndPayMethodListener().invoke(cashierPayMethodModel);
            }
        });
        RecyclerView recyclerView = getBinding().KClassImpl$Data$declaredNonStaticMembers$2;
        TopUpAndPayMethodAdapter topUpAndPayMethodAdapter = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (topUpAndPayMethodAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("");
            topUpAndPayMethodAdapter = null;
        }
        recyclerView.setAdapter(topUpAndPayMethodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), 1);
        Drawable PlaceComponentResult = ContextCompat.PlaceComponentResult(recyclerView.getContext(), (int) R.drawable.divider_drawable_grey30);
        if (PlaceComponentResult != null) {
            if (PlaceComponentResult == null) {
                throw new IllegalArgumentException("Drawable cannot be null.");
            }
            dividerItemDecoration.MyBillsEntityDataFactory = PlaceComponentResult;
        }
        recyclerView.addItemDecoration(dividerItemDecoration);
    }
}
