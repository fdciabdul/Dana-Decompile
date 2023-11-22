package id.dana.service.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.model.ThirdPartyService;
import id.dana.service.viewholder.CategoryViewHolder;
import id.dana.service.viewholder.EditServiceItemViewHolder;
import id.dana.service.viewholder.EditableServiceItemViewHolder;
import id.dana.service.viewholder.EmptyItemViewHolder;
import id.dana.service.viewholder.ServiceItemViewHolder;
import id.dana.service.viewholder.SpaceItemViewHolder;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class ServiceAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<ThirdPartyService>, ThirdPartyService> {
    private boolean BuiltInFictitiousFunctionClassFactory;
    public EditItemBadgeViewHasAttached KClassImpl$Data$declaredNonStaticMembers$2;
    public boolean PlaceComponentResult = false;
    public EditItemBadgeLookup getAuthRequestContext;

    /* loaded from: classes5.dex */
    public interface EditItemBadgeLookup {
        int MyBillsEntityDataFactory(ThirdPartyService thirdPartyService);
    }

    /* loaded from: classes5.dex */
    public interface EditItemBadgeViewHasAttached {
        void getAuthRequestContext();
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        onBindViewHolder((ServiceAdapter) ((BaseRecyclerViewHolder) viewHolder), i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        EditItemBadgeViewHasAttached editItemBadgeViewHasAttached;
        BaseRecyclerViewHolder baseRecyclerViewHolder = (BaseRecyclerViewHolder) viewHolder;
        super.onViewAttachedToWindow(baseRecyclerViewHolder);
        if (baseRecyclerViewHolder.getItemViewType() == 4 && (editItemBadgeViewHasAttached = this.KClassImpl$Data$declaredNonStaticMembers$2) != null && this.PlaceComponentResult) {
            editItemBadgeViewHasAttached.getAuthRequestContext();
            this.PlaceComponentResult = false;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (i < 0 || i >= getItems().size() || getItem(i) == null) {
            return 0;
        }
        int i2 = getItem(i).D;
        if (i2 != 3) {
            if (i2 != 4) {
                if (i2 != 5) {
                    return i2 != 6 ? 2 : 5;
                }
                return 4;
            }
            return 3;
        }
        return 1;
    }

    @Override // id.dana.base.BaseRecyclerViewAdapter
    public void onBindViewHolder(BaseRecyclerViewHolder<ThirdPartyService> baseRecyclerViewHolder, int i) {
        if (baseRecyclerViewHolder instanceof EditableServiceItemViewHolder) {
            ((EditableServiceItemViewHolder) baseRecyclerViewHolder).BuiltInFictitiousFunctionClassFactory = this.BuiltInFictitiousFunctionClassFactory;
        }
        super.onBindViewHolder((ServiceAdapter) baseRecyclerViewHolder, i);
    }

    public final boolean MyBillsEntityDataFactory(ThirdPartyService thirdPartyService) {
        if (getItems() == null || getItems().isEmpty()) {
            return false;
        }
        return getItems().contains(thirdPartyService);
    }

    public final void MyBillsEntityDataFactory(boolean z) {
        if (this.BuiltInFictitiousFunctionClassFactory == z) {
            return;
        }
        this.BuiltInFictitiousFunctionClassFactory = z;
        PlaceComponentResult(z);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i != 1) {
            if (i != 3) {
                if (i != 4) {
                    if (i == 5) {
                        return new EmptyItemViewHolder(viewGroup);
                    }
                    return new ServiceItemViewHolder(viewGroup, this.getAuthRequestContext);
                }
                return new EditServiceItemViewHolder(viewGroup, this.getAuthRequestContext);
            }
            return new SpaceItemViewHolder(viewGroup);
        }
        return new CategoryViewHolder(viewGroup);
    }

    protected void PlaceComponentResult(boolean z) {
        if (z) {
            ArrayList<ThirdPartyService> arrayList = new ArrayList(getItems());
            ArrayList arrayList2 = new ArrayList(getItems());
            for (ThirdPartyService thirdPartyService : arrayList) {
                if (thirdPartyService.getNetworkUserEntityData$$ExternalSyntheticLambda7()) {
                    arrayList2.remove(thirdPartyService);
                }
            }
            setItems(arrayList2);
        }
    }
}
