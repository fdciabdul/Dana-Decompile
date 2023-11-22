package id.dana.cashier.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import id.dana.R;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.cashier.adapter.PayMethodSelectionTryAgainAdapter;
import id.dana.cashier.model.AssetCardModel;
import id.dana.cashier.model.CashierPayMethodModel;
import id.dana.cashier.model.CashierPayMethodModelKt;
import id.dana.extension.view.ViewExtKt;
import id.dana.model.PayMethodModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\n¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u000e"}, d2 = {"Lid/dana/cashier/adapter/PayMethodSelectionTryAgainAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/cashier/adapter/PayMethodSelectionTryAgainAdapter$PayMethodSelectionResultViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "p0", "", "p1", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/cashier/adapter/PayMethodSelectionTryAgainAdapter$PayMethodSelectionResultViewHolder;I)V", "Lid/dana/cashier/adapter/CashierPayMethodListener;", "Lid/dana/cashier/adapter/CashierPayMethodListener;", "MyBillsEntityDataFactory", "getAuthRequestContext", "I", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "<init>", "(Lid/dana/cashier/adapter/CashierPayMethodListener;)V", "PayMethodSelectionResultViewHolder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PayMethodSelectionTryAgainAdapter extends BaseRecyclerViewAdapter<PayMethodSelectionResultViewHolder, CashierPayMethodModel> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final CashierPayMethodListener MyBillsEntityDataFactory;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private int PlaceComponentResult;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    private int KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "");
        return new PayMethodSelectionResultViewHolder(viewGroup, new Function1<Integer, Unit>() { // from class: id.dana.cashier.adapter.PayMethodSelectionTryAgainAdapter$onCreateViewHolder$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i2) {
                CashierPayMethodListener cashierPayMethodListener;
                int i3;
                int i4;
                int i5;
                int i6;
                CashierPayMethodModel cashierPayMethodModel = PayMethodSelectionTryAgainAdapter.this.getItems().get(i2);
                if (cashierPayMethodModel != null) {
                    PayMethodSelectionTryAgainAdapter payMethodSelectionTryAgainAdapter = PayMethodSelectionTryAgainAdapter.this;
                    cashierPayMethodListener = payMethodSelectionTryAgainAdapter.MyBillsEntityDataFactory;
                    cashierPayMethodListener.KClassImpl$Data$declaredNonStaticMembers$2(cashierPayMethodModel);
                    i3 = payMethodSelectionTryAgainAdapter.PlaceComponentResult;
                    payMethodSelectionTryAgainAdapter.PlaceComponentResult = i2;
                    i4 = payMethodSelectionTryAgainAdapter.KClassImpl$Data$declaredNonStaticMembers$2;
                    i5 = payMethodSelectionTryAgainAdapter.PlaceComponentResult;
                    if (i4 != i5) {
                        payMethodSelectionTryAgainAdapter.KClassImpl$Data$declaredNonStaticMembers$2 = i2;
                    }
                    payMethodSelectionTryAgainAdapter.notifyItemChanged(i3);
                    i6 = payMethodSelectionTryAgainAdapter.PlaceComponentResult;
                    payMethodSelectionTryAgainAdapter.notifyItemChanged(i6);
                }
            }
        });
    }

    public PayMethodSelectionTryAgainAdapter(CashierPayMethodListener cashierPayMethodListener) {
        Intrinsics.checkNotNullParameter(cashierPayMethodListener, "");
        this.MyBillsEntityDataFactory = cashierPayMethodListener;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public void onBindViewHolder(PayMethodSelectionResultViewHolder p0, int p1) {
        Intrinsics.checkNotNullParameter(p0, "");
        getItem(p1).NetworkUserEntityData$$ExternalSyntheticLambda0 = this.KClassImpl$Data$declaredNonStaticMembers$2 == p1;
        super.onBindViewHolder((PayMethodSelectionTryAgainAdapter) p0, p1);
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B#\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/cashier/adapter/PayMethodSelectionTryAgainAdapter$PayMethodSelectionResultViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/cashier/model/CashierPayMethodModel;", "Landroid/view/ViewGroup;", "p0", "Lkotlin/Function1;", "", "", "p1", "<init>", "(Landroid/view/ViewGroup;Lkotlin/jvm/functions/Function1;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class PayMethodSelectionResultViewHolder extends BaseRecyclerViewHolder<CashierPayMethodModel> {
        @Override // id.dana.base.BaseRecyclerViewHolder
        public final /* synthetic */ void bindData(CashierPayMethodModel cashierPayMethodModel) {
            Drawable PlaceComponentResult;
            AssetCardModel assetCardModel;
            CashierPayMethodModel cashierPayMethodModel2 = cashierPayMethodModel;
            if (cashierPayMethodModel2 != null) {
                View view = this.itemView;
                CashierPayMethodModel.CardPayMethod MyBillsEntityDataFactory = CashierPayMethodModelKt.MyBillsEntityDataFactory(cashierPayMethodModel2);
                boolean z = false;
                boolean areEqual = (MyBillsEntityDataFactory == null || (assetCardModel = MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2) == null) ? false : Intrinsics.areEqual(assetCardModel.PlaceComponentResult, Boolean.FALSE);
                if (CashierPayMethodModelKt.GetContactSyncConfig(cashierPayMethodModel2)) {
                    TextView textView = (TextView) view.findViewById(R.id.addProductAssembly);
                    if (textView != null) {
                        textView.setText(PayMethodModel.CashierSectionTitle.BANK_CARD);
                    }
                    TextView textView2 = (TextView) view.findViewById(R.id.tvDescriptionSource);
                    if (textView2 != null) {
                        textView2.setText(view.getContext().getString(R.string.add_new_card));
                    }
                } else {
                    TextView textView3 = (TextView) view.findViewById(R.id.addProductAssembly);
                    if (textView3 != null) {
                        textView3.setText(cashierPayMethodModel2.DatabaseTableConfigUtil());
                    }
                    TextView textView4 = (TextView) view.findViewById(R.id.tvDescriptionSource);
                    if (textView4 != null) {
                        textView4.setText(cashierPayMethodModel2.getMyBillsEntityDataFactory());
                    }
                    z = areEqual;
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(R.id.res_0x7f0a09d3_r8_lambda_uwkm_rjxsrv4lu7ffxkvei54dnk);
                if (appCompatImageView != null) {
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView, "");
                    Glide.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView.getContext()).getAuthRequestContext(Integer.valueOf(cashierPayMethodModel2.getKClassImpl$Data$declaredNonStaticMembers$2())).BuiltInFictitiousFunctionClassFactory((int) R.drawable.ic_landscape_small_default_bank).MyBillsEntityDataFactory((ImageView) ((AppCompatImageView) appCompatImageView.findViewById(R.id.res_0x7f0a09d3_r8_lambda_uwkm_rjxsrv4lu7ffxkvei54dnk)));
                }
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) view.findViewById(R.id.res_0x7f0a09d3_r8_lambda_uwkm_rjxsrv4lu7ffxkvei54dnk);
                if (appCompatImageView2 != null) {
                    Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "");
                    AppCompatImageView appCompatImageView3 = appCompatImageView2;
                    if (z) {
                        ViewExtKt.KClassImpl$Data$declaredNonStaticMembers$2(appCompatImageView3);
                    } else {
                        ViewExtKt.getAuthRequestContext((ImageView) appCompatImageView3);
                    }
                }
                boolean z2 = !z;
                view.setClickable(z2);
                RadioButton radioButton = (RadioButton) view.findViewById(R.id.res_0x7f0a1072_descriptorvisibilities_2);
                if (radioButton != null) {
                    Intrinsics.checkNotNullExpressionValue(radioButton, "");
                    radioButton.setClickable(z2);
                    boolean networkUserEntityData$$ExternalSyntheticLambda0 = cashierPayMethodModel2.getNetworkUserEntityData$$ExternalSyntheticLambda0();
                    if (z) {
                        PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_general_radio_disabled);
                    } else if (!z && !networkUserEntityData$$ExternalSyntheticLambda0) {
                        PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_button_radio_unselected);
                    } else {
                        PlaceComponentResult = ContextCompat.PlaceComponentResult(getContext(), (int) R.drawable.ic_cashier_button_radio_active_ext);
                    }
                    radioButton.setButtonDrawable(PlaceComponentResult);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PayMethodSelectionResultViewHolder(ViewGroup viewGroup, final Function1<? super Integer, Unit> function1) {
            super(viewGroup.getContext(), R.layout.item_payment_method_selection, viewGroup);
            Intrinsics.checkNotNullParameter(viewGroup, "");
            Intrinsics.checkNotNullParameter(function1, "");
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.adapter.PayMethodSelectionTryAgainAdapter$PayMethodSelectionResultViewHolder$$ExternalSyntheticLambda0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PayMethodSelectionTryAgainAdapter.PayMethodSelectionResultViewHolder.PlaceComponentResult(Function1.this, this);
                }
            });
            RadioButton radioButton = (RadioButton) this.itemView.findViewById(R.id.res_0x7f0a1072_descriptorvisibilities_2);
            if (radioButton != null) {
                radioButton.setOnClickListener(new View.OnClickListener() { // from class: id.dana.cashier.adapter.PayMethodSelectionTryAgainAdapter$PayMethodSelectionResultViewHolder$$ExternalSyntheticLambda1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        PayMethodSelectionTryAgainAdapter.PayMethodSelectionResultViewHolder.getAuthRequestContext(Function1.this, this);
                    }
                });
            }
        }

        public static /* synthetic */ void getAuthRequestContext(Function1 function1, PayMethodSelectionResultViewHolder payMethodSelectionResultViewHolder) {
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(payMethodSelectionResultViewHolder, "");
            function1.invoke(Integer.valueOf(payMethodSelectionResultViewHolder.getAbsoluteAdapterPosition()));
        }

        public static /* synthetic */ void PlaceComponentResult(Function1 function1, PayMethodSelectionResultViewHolder payMethodSelectionResultViewHolder) {
            Intrinsics.checkNotNullParameter(function1, "");
            Intrinsics.checkNotNullParameter(payMethodSelectionResultViewHolder, "");
            function1.invoke(Integer.valueOf(payMethodSelectionResultViewHolder.getAbsoluteAdapterPosition()));
        }
    }
}
