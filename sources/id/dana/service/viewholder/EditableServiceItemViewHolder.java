package id.dana.service.viewholder;

import android.content.Context;
import android.view.ViewGroup;
import id.dana.R;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.ThirdPartyService;
import id.dana.service.adapter.ServiceAdapter;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\bR\u001a\u0010\u0005\u001a\u00020\n8\u0007X\u0086\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r"}, d2 = {"Lid/dana/service/viewholder/EditableServiceItemViewHolder;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/model/ThirdPartyService;", "p0", "", "BuiltInFictitiousFunctionClassFactory", "(Lid/dana/model/ThirdPartyService;)I", "Lid/dana/service/adapter/ServiceAdapter$EditItemBadgeLookup;", "Lid/dana/service/adapter/ServiceAdapter$EditItemBadgeLookup;", "KClassImpl$Data$declaredNonStaticMembers$2", "", "getAuthRequestContext", "Z", "()Z", "Landroid/content/Context;", "p1", "Landroid/view/ViewGroup;", "p2", "p3", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Lid/dana/service/adapter/ServiceAdapter$EditItemBadgeLookup;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class EditableServiceItemViewHolder extends BaseRecyclerViewHolder<ThirdPartyService> {

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    private final ServiceAdapter.EditItemBadgeLookup KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    public boolean BuiltInFictitiousFunctionClassFactory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditableServiceItemViewHolder(Context context, ViewGroup viewGroup, ServiceAdapter.EditItemBadgeLookup editItemBadgeLookup) {
        super(context, R.layout.layout_custom_gridview, viewGroup);
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(viewGroup, "");
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editItemBadgeLookup;
    }

    @JvmName(name = "getAuthRequestContext")
    /* renamed from: getAuthRequestContext  reason: from getter */
    public final boolean getBuiltInFictitiousFunctionClassFactory() {
        return this.BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int BuiltInFictitiousFunctionClassFactory(ThirdPartyService p0) {
        Intrinsics.checkNotNullParameter(p0, "");
        ServiceAdapter.EditItemBadgeLookup editItemBadgeLookup = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (editItemBadgeLookup != null) {
            return editItemBadgeLookup.MyBillsEntityDataFactory(p0);
        }
        return 0;
    }
}
