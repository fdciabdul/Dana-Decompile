package id.dana.bank.viewholder;

import android.widget.ImageView;
import com.alibaba.ariver.kernel.api.extension.bridge.BridgeDSL;
import id.dana.R;
import id.dana.core.ui.glide.GlideApp;
import id.dana.core.ui.recyclerview.BaseViewBindingViewHolder;
import id.dana.databinding.ItemAllBankListBinding;
import id.dana.sendmoney.model.BankModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u001a\b\u0002\u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005"}, d2 = {"Lid/dana/bank/viewholder/BankListViewHolder;", "Lid/dana/core/ui/recyclerview/BaseViewBindingViewHolder;", "Lid/dana/sendmoney/model/BankModel;", "Lid/dana/databinding/ItemAllBankListBinding;", "KClassImpl$Data$declaredNonStaticMembers$2", "Lid/dana/databinding/ItemAllBankListBinding;", "p0", "Lkotlin/Function2;", "", "", "p1", "<init>", "(Lid/dana/databinding/ItemAllBankListBinding;Lkotlin/jvm/functions/Function2;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BankListViewHolder extends BaseViewBindingViewHolder<BankModel> {
    private final ItemAllBankListBinding KClassImpl$Data$declaredNonStaticMembers$2;

    @Override // id.dana.core.ui.recyclerview.BaseViewBindingViewHolder
    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(BankModel bankModel, int i) {
        BankModel bankModel2 = bankModel;
        Intrinsics.checkNotNullParameter(bankModel2, "");
        super.KClassImpl$Data$declaredNonStaticMembers$2((BankListViewHolder) bankModel2, i);
        this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.setText(bankModel2.scheduleImpl);
        ImageView imageView = this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext;
        Intrinsics.checkNotNullExpressionValue(imageView, "");
        GlideApp.getAuthRequestContext(imageView.getContext()).PlaceComponentResult(bankModel2.PlaceComponentResult()).getErrorConfigVersion((int) R.drawable.ic_bank_placeholder).PlaceComponentResult((int) R.drawable.ic_bank_placeholder).SubSequence().MyBillsEntityDataFactory(imageView);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/model/BankModel;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", BridgeDSL.INVOKE, "(Lid/dana/sendmoney/model/BankModel;I)V"}, k = 3, mv = {1, 6, 0}, xi = 48)
    /* renamed from: id.dana.bank.viewholder.BankListViewHolder$1 */
    /* loaded from: classes4.dex */
    static final class AnonymousClass1 extends Lambda implements Function2<BankModel, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(2);
        }

        public final void invoke(BankModel bankModel, int i) {
            Intrinsics.checkNotNullParameter(bankModel, "");
        }

        @Override // kotlin.jvm.functions.Function2
        public final /* synthetic */ Unit invoke(BankModel bankModel, Integer num) {
            invoke(bankModel, num.intValue());
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankListViewHolder(ItemAllBankListBinding itemAllBankListBinding, Function2<? super BankModel, ? super Integer, Unit> function2) {
        super(itemAllBankListBinding, function2);
        Intrinsics.checkNotNullParameter(itemAllBankListBinding, "");
        Intrinsics.checkNotNullParameter(function2, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = itemAllBankListBinding;
    }
}
