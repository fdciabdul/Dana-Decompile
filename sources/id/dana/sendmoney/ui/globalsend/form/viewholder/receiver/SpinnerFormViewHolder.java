package id.dana.sendmoney.ui.globalsend.form.viewholder.receiver;

import id.dana.sendmoney.databinding.ItemDefaultFormBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/SpinnerFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/receiver/DefaultFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;)V", "Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;", "<init>", "(Lid/dana/sendmoney/databinding/ItemDefaultFormBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SpinnerFormViewHolder extends DefaultFormViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpinnerFormViewHolder(ItemDefaultFormBinding itemDefaultFormBinding) {
        super(itemDefaultFormBinding, 0, 0, false, 0, 30, null);
        Intrinsics.checkNotNullParameter(itemDefaultFormBinding, "");
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.DefaultFormViewHolder, id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        getAuthRequestContext(globalSendFormModel);
    }

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.receiver.DefaultFormViewHolder
    /* renamed from: BuiltInFictitiousFunctionClassFactory */
    public final void getAuthRequestContext(GlobalSendFormModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        super.getAuthRequestContext(p0);
        ItemDefaultFormBinding itemDefaultFormBinding = (ItemDefaultFormBinding) this.MyBillsEntityDataFactory;
        itemDefaultFormBinding.KClassImpl$Data$declaredNonStaticMembers$2.setNeedToShowIconSpinner(true);
        itemDefaultFormBinding.KClassImpl$Data$declaredNonStaticMembers$2.setFormEnabled(false);
    }
}
