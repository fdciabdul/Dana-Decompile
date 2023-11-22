package id.dana.service.adapter;

import id.dana.model.ThirdPartyService;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b"}, d2 = {"Lid/dana/service/adapter/EditServiceAdapter;", "Lid/dana/service/adapter/ServiceAdapter;", "", "p0", "", "PlaceComponentResult", "(Z)V", "", "removeItem", "(I)V", "getAuthRequestContext", "()Z", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class EditServiceAdapter extends ServiceAdapter {
    @Override // id.dana.service.adapter.ServiceAdapter
    protected final void PlaceComponentResult(boolean p0) {
    }

    @JvmName(name = "getAuthRequestContext")
    public final boolean getAuthRequestContext() {
        List<ThirdPartyService> items = getItems();
        if (items != null) {
            Iterator<T> it = items.iterator();
            while (it.hasNext()) {
                if (((ThirdPartyService) it.next()).D == 6) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public final void removeItem(int p0) {
        if (p0 > getItems().size()) {
            return;
        }
        ThirdPartyService.Builder builder = new ThirdPartyService.Builder();
        builder.id.dana.sendmoney.summary.SummaryActivity.DAYS java.lang.String = 6;
        getItems().set(p0, builder.PlaceComponentResult());
        notifyItemChanged(p0);
    }
}
