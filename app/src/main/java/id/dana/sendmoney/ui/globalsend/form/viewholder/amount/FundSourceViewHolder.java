package id.dana.sendmoney.ui.globalsend.form.viewholder.amount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import id.dana.component.utils.SizeUtil;
import id.dana.core.ui.glide.GlideApp;
import id.dana.sendmoney.R;
import id.dana.sendmoney.databinding.ItemFundSourceBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormOptionModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u0000 \r2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\rB#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u000b\u0010\fR \u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/amount/FundSourceViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemFundSourceBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormOptionModel;", "Lkotlin/Function1;", "", "PlaceComponentResult", "Lkotlin/jvm/functions/Function1;", "BuiltInFictitiousFunctionClassFactory", "p0", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemFundSourceBinding;Lkotlin/jvm/functions/Function1;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class FundSourceViewHolder extends BaseGlobalSendFormViewHolder<ItemFundSourceBinding, GlobalSendFormOptionModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function1<GlobalSendFormOptionModel, Unit> BuiltInFictitiousFunctionClassFactory;

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormOptionModel globalSendFormOptionModel) {
        final GlobalSendFormOptionModel globalSendFormOptionModel2 = globalSendFormOptionModel;
        Intrinsics.checkNotNullParameter(globalSendFormOptionModel2, "");
        GlideApp.getAuthRequestContext(((ItemFundSourceBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.getContext()).PlaceComponentResult(globalSendFormOptionModel2.MyBillsEntityDataFactory).MyBillsEntityDataFactory(((ItemFundSourceBinding) this.MyBillsEntityDataFactory).PlaceComponentResult);
        ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setText(globalSendFormOptionModel2.BuiltInFictitiousFunctionClassFactory);
        if (globalSendFormOptionModel2.getKClassImpl$Data$declaredNonStaticMembers$2()) {
            ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory.setBackgroundResource(R.drawable.bg_card_rounded_stroke_yellow50_10dp);
            ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(((ItemFundSourceBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.getContext(), R.color.lookAheadTest));
        } else {
            ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory.setBackgroundResource(R.drawable.bg_card_rounded_stroke_grey30_10dp);
            ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).MyBillsEntityDataFactory.setTextColor(ContextCompat.BuiltInFictitiousFunctionClassFactory(((ItemFundSourceBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.getContext(), R.color.scheduleImpl));
        }
        ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory.setPadding(SizeUtil.PlaceComponentResult(10), SizeUtil.PlaceComponentResult(12), SizeUtil.PlaceComponentResult(10), SizeUtil.PlaceComponentResult(12));
        ((ItemFundSourceBinding) this.MyBillsEntityDataFactory).KClassImpl$Data$declaredNonStaticMembers$2.setOnClickListener(new View.OnClickListener() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.amount.FundSourceViewHolder$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FundSourceViewHolder.MyBillsEntityDataFactory(FundSourceViewHolder.this, globalSendFormOptionModel2);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FundSourceViewHolder(ItemFundSourceBinding itemFundSourceBinding, Function1<? super GlobalSendFormOptionModel, Unit> function1) {
        super(itemFundSourceBinding);
        Intrinsics.checkNotNullParameter(itemFundSourceBinding, "");
        Intrinsics.checkNotNullParameter(function1, "");
        this.BuiltInFictitiousFunctionClassFactory = function1;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/amount/FundSourceViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemFundSourceBinding;", "getAuthRequestContext", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemFundSourceBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemFundSourceBinding getAuthRequestContext(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemFundSourceBinding KClassImpl$Data$declaredNonStaticMembers$2 = ItemFundSourceBinding.KClassImpl$Data$declaredNonStaticMembers$2(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(KClassImpl$Data$declaredNonStaticMembers$2, "");
            return KClassImpl$Data$declaredNonStaticMembers$2;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory(FundSourceViewHolder fundSourceViewHolder, GlobalSendFormOptionModel globalSendFormOptionModel) {
        Intrinsics.checkNotNullParameter(fundSourceViewHolder, "");
        Intrinsics.checkNotNullParameter(globalSendFormOptionModel, "");
        fundSourceViewHolder.BuiltInFictitiousFunctionClassFactory.invoke(globalSendFormOptionModel);
    }
}
