package id.dana.sendmoney.ui.globalsend.form.viewholder;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u00020\u0005B\u000f\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0001H&¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00028\u0000X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/sendmoney/ui/globalsend/form/viewholder/BaseGlobalSendFormViewHolder;", "Landroidx/viewbinding/ViewBinding;", "VB", "", "T", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "p0", "", "getAuthRequestContext", "(Ljava/lang/Object;)V", "BuiltInFictitiousFunctionClassFactory", "Landroidx/viewbinding/ViewBinding;", "MyBillsEntityDataFactory", "<init>", "(Landroidx/viewbinding/ViewBinding;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseGlobalSendFormViewHolder<VB extends ViewBinding, T> extends RecyclerView.ViewHolder {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    public final VB MyBillsEntityDataFactory;

    public abstract void getAuthRequestContext(T p0);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseGlobalSendFormViewHolder(VB vb) {
        super(vb.KClassImpl$Data$declaredNonStaticMembers$2());
        Intrinsics.checkNotNullParameter(vb, "");
        this.MyBillsEntityDataFactory = vb;
    }
}
