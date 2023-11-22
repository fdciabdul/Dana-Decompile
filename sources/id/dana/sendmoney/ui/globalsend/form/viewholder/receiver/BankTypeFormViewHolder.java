package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.google.android.material.chip.ChipGroup;
import id.dana.sendmoney.databinding.ItemBankTypeFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/BankTypeFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemBankTypeFormBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "<init>", "(Lid/dana/sendmoney/databinding/ItemBankTypeFormBinding;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BankTypeFormViewHolder extends BaseGlobalSendFormViewHolder<ItemBankTypeFormBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        Intrinsics.checkNotNullParameter(globalSendFormModel, "");
        ((ItemBankTypeFormBinding) this.MyBillsEntityDataFactory).BuiltInFictitiousFunctionClassFactory.setOnCheckedChangeListener(new ChipGroup.OnCheckedChangeListener() { // from class: id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.BankTypeFormViewHolder$$ExternalSyntheticLambda0
            @Override // com.google.android.material.chip.ChipGroup.OnCheckedChangeListener
            public final void onCheckedChanged(ChipGroup chipGroup, int i) {
                BankTypeFormViewHolder.BuiltInFictitiousFunctionClassFactory();
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BankTypeFormViewHolder(ItemBankTypeFormBinding itemBankTypeFormBinding) {
        super(itemBankTypeFormBinding);
        Intrinsics.checkNotNullParameter(itemBankTypeFormBinding, "");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/BankTypeFormViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemBankTypeFormBinding;", "PlaceComponentResult", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemBankTypeFormBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemBankTypeFormBinding PlaceComponentResult(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemBankTypeFormBinding BuiltInFictitiousFunctionClassFactory = ItemBankTypeFormBinding.BuiltInFictitiousFunctionClassFactory(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(BuiltInFictitiousFunctionClassFactory, "");
            return BuiltInFictitiousFunctionClassFactory;
        }
    }
}
