package id.dana.sendmoney.ui.globalsend.form.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import id.dana.sendmoney.databinding.ItemEmptyViewholderBinding;
import id.dana.sendmoney.ui.globalsend.form.model.common.GlobalSendFormModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00072\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/EmptyFormViewHolder;", "Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Lid/dana/sendmoney/databinding/ItemEmptyViewholderBinding;", "Lid/dana/sendmoney/ui/globalsend/form/model/common/GlobalSendFormModel;", "p0", "<init>", "(Lid/dana/sendmoney/databinding/ItemEmptyViewholderBinding;)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes9.dex */
public final class EmptyFormViewHolder extends BaseGlobalSendFormViewHolder<ItemEmptyViewholderBinding, GlobalSendFormModel> {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Override // id.dana.sendmoney.ui.globalsend.form.viewholder.BaseGlobalSendFormViewHolder
    public final /* synthetic */ void getAuthRequestContext(GlobalSendFormModel globalSendFormModel) {
        Intrinsics.checkNotNullParameter(globalSendFormModel, "");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyFormViewHolder(ItemEmptyViewholderBinding itemEmptyViewholderBinding) {
        super(itemEmptyViewholderBinding);
        Intrinsics.checkNotNullParameter(itemEmptyViewholderBinding, "");
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/EmptyFormViewHolder$Companion;", "", "Landroid/view/ViewGroup;", "p0", "Lid/dana/sendmoney/databinding/ItemEmptyViewholderBinding;", "PlaceComponentResult", "(Landroid/view/ViewGroup;)Lid/dana/sendmoney/databinding/ItemEmptyViewholderBinding;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes9.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static ItemEmptyViewholderBinding PlaceComponentResult(ViewGroup p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            ItemEmptyViewholderBinding MyBillsEntityDataFactory = ItemEmptyViewholderBinding.MyBillsEntityDataFactory(LayoutInflater.from(p0.getContext()), p0);
            Intrinsics.checkNotNullExpressionValue(MyBillsEntityDataFactory, "");
            return MyBillsEntityDataFactory;
        }
    }
}
