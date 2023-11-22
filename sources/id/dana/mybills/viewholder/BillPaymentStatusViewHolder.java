package id.dana.mybills.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.component.formcomponent.DanaCheckboxButtonView;
import id.dana.core.ui.glide.GlideApp;
import id.dana.extension.view.InputExtKt;
import id.dana.mybills.listener.GroupedBillPaymentsListener;
import id.dana.mybills.model.BillPaymentAdapterModel;
import id.dana.mybills.model.BillPaymentStatusModel;
import id.dana.mybills.ui.constant.RecurringType;
import id.dana.nearbyme.merchantdetail.model.MoneyViewModel;
import id.dana.richview.CurrencyTextView;
import id.dana.utils.DateTimeUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0013\u001a\u00020\u0012X\u0006¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014"}, d2 = {"Lid/dana/mybills/viewholder/BillPaymentStatusViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/mybills/model/BillPaymentAdapterModel;", "Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;", "p0", "", "setOnItemClickListener", "(Lid/dana/base/BaseRecyclerViewHolder$OnItemClickListener;)V", "", "BuiltInFictitiousFunctionClassFactory", "(Z)V", "", "PlaceComponentResult", "Ljava/lang/String;", "MyBillsEntityDataFactory", "", "getAuthRequestContext", "I", "Landroid/view/ViewGroup;", "KClassImpl$Data$declaredNonStaticMembers$2", "Landroid/view/ViewGroup;", "<init>", "(Landroid/view/ViewGroup;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BillPaymentStatusViewHolder extends BaseRecyclerViewHolder<BillPaymentAdapterModel> {
    public final ViewGroup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private String MyBillsEntityDataFactory;
    private int getAuthRequestContext;

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final /* synthetic */ void bindData(BillPaymentAdapterModel billPaymentAdapterModel) {
        BillPaymentStatusModel billPaymentStatusModel;
        BillPaymentAdapterModel billPaymentAdapterModel2 = billPaymentAdapterModel;
        View view = this.itemView;
        if (billPaymentAdapterModel2 == null || (billPaymentStatusModel = billPaymentAdapterModel2.BuiltInFictitiousFunctionClassFactory) == null) {
            return;
        }
        CircleImageView circleImageView = (CircleImageView) view.findViewById(R.id.ArrayTable$2);
        if (circleImageView != null) {
            Intrinsics.checkNotNullExpressionValue(circleImageView, "");
            CircleImageView circleImageView2 = circleImageView;
            GlideApp.getAuthRequestContext(circleImageView2.getContext()).PlaceComponentResult(billPaymentStatusModel.getErrorConfigVersion).SubSequence().MyBillsEntityDataFactory((ImageView) circleImageView2);
        }
        CircleImageView circleImageView3 = (CircleImageView) view.findViewById(R.id.WithdrawSavedCardChannelView);
        if (circleImageView3 != null) {
            Intrinsics.checkNotNullExpressionValue(circleImageView3, "");
            CircleImageView circleImageView4 = circleImageView3;
            String str = billPaymentStatusModel.DatabaseTableConfigUtil;
            if (str == null) {
                str = "";
            }
            GlideApp.getAuthRequestContext(circleImageView4.getContext()).PlaceComponentResult(Integer.valueOf(Intrinsics.areEqual(str, RecurringType.REMINDER) ? R.drawable.ic_mybills_reminder : R.drawable.ic_mybills_auto_deduction)).SubSequence().MyBillsEntityDataFactory((ImageView) circleImageView4);
        }
        TextView textView = (TextView) view.findViewById(R.id.DocumentFileUtils$copyFolderTo$$inlined$awaitUiResultWithPending$1$1);
        if (textView != null) {
            textView.setText(billPaymentStatusModel.NetworkUserEntityData$$ExternalSyntheticLambda1);
        }
        TextView textView2 = (TextView) view.findViewById(R.id.FeatureOauth_Factory);
        if (textView2 != null) {
            textView2.setText(billPaymentStatusModel.getAuthRequestContext);
        }
        CurrencyTextView currencyTextView = (CurrencyTextView) view.findViewById(R.id.getBackDisposition);
        if (currencyTextView != null) {
            MoneyViewModel moneyViewModel = billPaymentStatusModel.initRecordTimeStamp;
            currencyTextView.setText(moneyViewModel != null ? moneyViewModel.PlaceComponentResult : null);
        }
        Locale locale = Locale.getDefault();
        Long l = billPaymentStatusModel.lookAheadTest;
        String BuiltInFictitiousFunctionClassFactory = DateTimeUtil.BuiltInFictitiousFunctionClassFactory("d MMM", locale, l != null ? l.longValue() : -1L);
        Intrinsics.checkNotNullExpressionValue(view, "");
        if (billPaymentStatusModel.DatabaseTableConfigUtil != null && Intrinsics.areEqual(billPaymentStatusModel.DatabaseTableConfigUtil, RecurringType.REMINDER)) {
            if (billPaymentStatusModel.scheduleImpl != null && billPaymentStatusModel.scheduleImpl.longValue() > 0) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = view.getContext().getString(R.string.next_schedule_payment_late);
                Intrinsics.checkNotNullExpressionValue(string, "");
                String format = String.format(string, Arrays.copyOf(new Object[]{billPaymentStatusModel.scheduleImpl}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "");
                this.MyBillsEntityDataFactory = format;
                this.getAuthRequestContext = R.color.f26712131100373;
                BuiltInFictitiousFunctionClassFactory(false);
            } else {
                Long l2 = billPaymentStatusModel.scheduleImpl;
                if (l2 != null && l2.longValue() == 0) {
                    String string2 = view.getContext().getString(R.string.next_schedule_payment_today);
                    Intrinsics.checkNotNullExpressionValue(string2, "");
                    this.MyBillsEntityDataFactory = string2;
                    this.getAuthRequestContext = R.color.f27152131100507;
                }
                BuiltInFictitiousFunctionClassFactory(true);
            }
        }
        String str2 = this.MyBillsEntityDataFactory;
        if (str2.length() > 0) {
            TextView textView3 = (TextView) view.findViewById(R.id.createDefaultAppReviewInfo);
            if (textView3 != null) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String format2 = String.format("%s • %s", Arrays.copyOf(new Object[]{str2, BuiltInFictitiousFunctionClassFactory}, 2));
                Intrinsics.checkNotNullExpressionValue(format2, "");
                textView3.setText(format2);
            }
            TextView textView4 = (TextView) view.findViewById(R.id.createDefaultAppReviewInfo);
            Intrinsics.checkNotNullExpressionValue(textView4, "");
            InputExtKt.getAuthRequestContext(textView4, this.getAuthRequestContext, str2, false, new Function0<Unit>() { // from class: id.dana.mybills.viewholder.BillPaymentStatusViewHolder$bindData$1$1$1
                /* renamed from: invoke  reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public final /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            });
            return;
        }
        TextView textView5 = (TextView) view.findViewById(R.id.createDefaultAppReviewInfo);
        if (textView5 != null) {
            textView5.setText(BuiltInFictitiousFunctionClassFactory);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillPaymentStatusViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext(), R.layout.item_bill_payment_status, viewGroup);
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = viewGroup;
        this.MyBillsEntityDataFactory = "";
    }

    @Override // id.dana.base.BaseRecyclerViewHolder
    public final void setOnItemClickListener(final BaseRecyclerViewHolder.OnItemClickListener p0) {
        if (p0 instanceof GroupedBillPaymentsListener) {
            ((DanaCheckboxButtonView) this.itemView.findViewById(R.id.LimitedDispatcher)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: id.dana.mybills.viewholder.BillPaymentStatusViewHolder$$ExternalSyntheticLambda0
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    BillPaymentStatusViewHolder.KClassImpl$Data$declaredNonStaticMembers$2(BaseRecyclerViewHolder.OnItemClickListener.this, this, z);
                }
            });
            ((ConstraintLayout) this.itemView.findViewById(R.id.DaggerPromoDiscoveryComponent$PromoDiscoveryComponentImpl$AccountRepositoryProvider)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.viewholder.BillPaymentStatusViewHolder$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BillPaymentStatusViewHolder.PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
            ((ImageView) this.itemView.findViewById(R.id.getKeyProgressIncrement)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.viewholder.BillPaymentStatusViewHolder$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BillPaymentStatusViewHolder.BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
            ((CircleImageView) this.itemView.findViewById(R.id.WithdrawSavedCardChannelView)).setOnClickListener(new View.OnClickListener() { // from class: id.dana.mybills.viewholder.BillPaymentStatusViewHolder$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BillPaymentStatusViewHolder.MyBillsEntityDataFactory(BaseRecyclerViewHolder.OnItemClickListener.this, this);
                }
            });
        }
    }

    private final void BuiltInFictitiousFunctionClassFactory(boolean p0) {
        DanaCheckboxButtonView danaCheckboxButtonView = (DanaCheckboxButtonView) this.itemView.findViewById(R.id.LimitedDispatcher);
        Intrinsics.checkNotNullExpressionValue(danaCheckboxButtonView, "");
        danaCheckboxButtonView.setVisibility(p0 ? 0 : 8);
        ImageView imageView = (ImageView) this.itemView.findViewById(R.id.getKeyProgressIncrement);
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        imageView.setVisibility(p0 ^ true ? 0 : 8);
    }

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, BillPaymentStatusViewHolder billPaymentStatusViewHolder) {
        Intrinsics.checkNotNullParameter(billPaymentStatusViewHolder, "");
        ((GroupedBillPaymentsListener) onItemClickListener).KClassImpl$Data$declaredNonStaticMembers$2(billPaymentStatusViewHolder.getBindingAdapterPosition());
    }

    public static /* synthetic */ void PlaceComponentResult(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, BillPaymentStatusViewHolder billPaymentStatusViewHolder) {
        Intrinsics.checkNotNullParameter(billPaymentStatusViewHolder, "");
        ((GroupedBillPaymentsListener) onItemClickListener).onItemClick(billPaymentStatusViewHolder.getBindingAdapterPosition());
    }

    public static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, BillPaymentStatusViewHolder billPaymentStatusViewHolder, boolean z) {
        Intrinsics.checkNotNullParameter(billPaymentStatusViewHolder, "");
        ((GroupedBillPaymentsListener) onItemClickListener).PlaceComponentResult(billPaymentStatusViewHolder.getBindingAdapterPosition(), z);
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(BaseRecyclerViewHolder.OnItemClickListener onItemClickListener, BillPaymentStatusViewHolder billPaymentStatusViewHolder) {
        Intrinsics.checkNotNullParameter(billPaymentStatusViewHolder, "");
        ((GroupedBillPaymentsListener) onItemClickListener).MyBillsEntityDataFactory(billPaymentStatusViewHolder.getBindingAdapterPosition());
    }
}
