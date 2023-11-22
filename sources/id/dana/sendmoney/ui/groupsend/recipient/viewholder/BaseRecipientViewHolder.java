package id.dana.sendmoney.ui.groupsend.recipient.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import id.dana.sendmoney.ui.groupsend.recipient.model.viewmodel.RecipientViewModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00028\u00008\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/recipient/viewholder/BaseRecipientViewHolder;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;", "p0", "", "MyBillsEntityDataFactory", "(Lid/dana/sendmoney/ui/groupsend/recipient/model/viewmodel/RecipientViewModel;)V", "PlaceComponentResult", "Landroidx/viewbinding/ViewBinding;", "()Landroidx/viewbinding/ViewBinding;", "BuiltInFictitiousFunctionClassFactory", "<init>", "(Landroidx/viewbinding/ViewBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseRecipientViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final VB BuiltInFictitiousFunctionClassFactory;

    public abstract void MyBillsEntityDataFactory(RecipientViewModel p0);

    @JvmName(name = "PlaceComponentResult")
    public final VB PlaceComponentResult() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseRecipientViewHolder(VB vb) {
        super(vb.KClassImpl$Data$declaredNonStaticMembers$2());
        Intrinsics.checkNotNullParameter(vb, "");
        this.BuiltInFictitiousFunctionClassFactory = vb;
    }
}
