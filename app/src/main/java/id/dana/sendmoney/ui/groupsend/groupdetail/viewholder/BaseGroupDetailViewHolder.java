package id.dana.sendmoney.ui.groupsend.groupdetail.viewholder;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import id.dana.sendmoney.ui.groupsend.groupdetail.model.GroupDetailModel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0017\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\r\u001a\u00028\u00008\u0007¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0007\u001a\u00020\u000e8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\r\u0010\u0010"}, d2 = {"Lid/dana/sendmoney/ui/groupsend/groupdetail/viewholder/BaseGroupDetailViewHolder;", "Landroidx/viewbinding/ViewBinding;", "VB", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;", "p0", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Lid/dana/sendmoney/ui/groupsend/groupdetail/model/GroupDetailModel;)V", "PlaceComponentResult", "Landroidx/viewbinding/ViewBinding;", "MyBillsEntityDataFactory", "()Landroidx/viewbinding/ViewBinding;", "BuiltInFictitiousFunctionClassFactory", "Landroid/content/Context;", "Landroid/content/Context;", "()Landroid/content/Context;", "p1", "<init>", "(Landroidx/viewbinding/ViewBinding;Landroid/content/Context;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseGroupDetailViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    private final Context KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    private final VB BuiltInFictitiousFunctionClassFactory;

    public abstract void KClassImpl$Data$declaredNonStaticMembers$2(GroupDetailModel p0);

    @JvmName(name = "BuiltInFictitiousFunctionClassFactory")
    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from getter */
    public final Context getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    public final VB MyBillsEntityDataFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseGroupDetailViewHolder(VB vb, Context context) {
        super(vb.KClassImpl$Data$declaredNonStaticMembers$2());
        Intrinsics.checkNotNullParameter(vb, "");
        Intrinsics.checkNotNullParameter(context, "");
        this.BuiltInFictitiousFunctionClassFactory = vb;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = context;
    }
}
