package id.dana.sendmoney.ui.groupsend.recipient.viewholder;

import android.content.Context;
import id.dana.sendmoney.databinding.ItemGroupRecipientContactNoPermissionBinding;
import id.dana.sendmoney.ui.common.EmptyStateView;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.EmptyStateViewModel;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/EmptyStateViewHolder;", "Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/BaseRecipientViewHolder;", "Lid/dana/sendmoney/databinding/ItemGroupRecipientContactNoPermissionBinding;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;)V", "Lkotlin/Function0;", "PlaceComponentResult", "Lkotlin/jvm/functions/Function0;", "getAuthRequestContext", "p1", "<init>", "(Lid/dana/sendmoney/databinding/ItemGroupRecipientContactNoPermissionBinding;Lkotlin/jvm/functions/Function0;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EmptyStateViewHolder extends BaseRecipientViewHolder<ItemGroupRecipientContactNoPermissionBinding> {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final Function0<Unit> getAuthRequestContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyStateViewHolder(ItemGroupRecipientContactNoPermissionBinding itemGroupRecipientContactNoPermissionBinding, Function0<Unit> function0) {
        super(itemGroupRecipientContactNoPermissionBinding);
        Intrinsics.checkNotNullParameter(itemGroupRecipientContactNoPermissionBinding, "");
        Intrinsics.checkNotNullParameter(function0, "");
        this.getAuthRequestContext = function0;
    }

    @Override // id.dana.sendmoney.ui.groupsend.recipient.viewholder.BaseRecipientViewHolder
    public final void MyBillsEntityDataFactory(RecipientViewModel p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        EmptyStateView emptyStateView = PlaceComponentResult().KClassImpl$Data$declaredNonStaticMembers$2;
        EmptyStateViewModel emptyStateViewModel = p0 instanceof EmptyStateViewModel ? (EmptyStateViewModel) p0 : null;
        if (emptyStateViewModel != null) {
            Context context = emptyStateView.getContext();
            String string = context != null ? context.getString(emptyStateViewModel.MyBillsEntityDataFactory) : null;
            if (string == null) {
                string = "";
            }
            emptyStateView.setTitle(string);
            Context context2 = emptyStateView.getContext();
            String string2 = context2 != null ? context2.getString(emptyStateViewModel.BuiltInFictitiousFunctionClassFactory) : null;
            if (string2 == null) {
                string2 = "";
            }
            emptyStateView.setDesc(string2);
            emptyStateView.setIcon(emptyStateViewModel.PlaceComponentResult);
            Context context3 = emptyStateView.getContext();
            String string3 = context3 != null ? context3.getString(emptyStateViewModel.KClassImpl$Data$declaredNonStaticMembers$2) : null;
            emptyStateView.setCenterAction(string3 != null ? string3 : "");
            emptyStateView.setHasCenterAction(emptyStateViewModel.getGetAuthRequestContext());
        }
        emptyStateView.setOnCenterActionClickListener(this.getAuthRequestContext);
    }
}
