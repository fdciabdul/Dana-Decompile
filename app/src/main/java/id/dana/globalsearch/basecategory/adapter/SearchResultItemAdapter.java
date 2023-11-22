package id.dana.globalsearch.basecategory.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.base.BaseRecyclerViewAdapter;
import id.dana.base.BaseRecyclerViewHolder;
import id.dana.globalsearch.dfrestaurant.adapter.RestaurantViewHolder;
import id.dana.globalsearch.model.PaySearchInfoModel;
import id.dana.globalsearch.offlinemerchant.adapter.OfflineMerchantItemViewHolder;
import id.dana.globalsearch.onlinemerchant.adapter.OnlineMerchantItemViewHolder;
import id.dana.globalsearch.service.adapter.ServiceViewHolder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\t"}, d2 = {"Lid/dana/globalsearch/basecategory/adapter/SearchResultItemAdapter;", "Lid/dana/base/BaseRecyclerViewAdapter;", "Lid/dana/base/BaseRecyclerViewHolder;", "Lid/dana/globalsearch/model/PaySearchInfoModel;", "PlaceComponentResult", "()Lid/dana/globalsearch/model/PaySearchInfoModel;", "", "p0", "getItemViewType", "(I)I", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SearchResultItemAdapter extends BaseRecyclerViewAdapter<BaseRecyclerViewHolder<PaySearchInfoModel>, PaySearchInfoModel> {
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        RestaurantViewHolder restaurantViewHolder;
        Intrinsics.checkNotNullParameter(viewGroup, "");
        if (i == 1) {
            restaurantViewHolder = new RestaurantViewHolder(viewGroup);
        } else if (i == 2) {
            restaurantViewHolder = new ServiceViewHolder(viewGroup);
        } else if (i == 3) {
            restaurantViewHolder = new OfflineMerchantItemViewHolder(viewGroup);
        } else if (i == 4) {
            restaurantViewHolder = new OnlineMerchantItemViewHolder(viewGroup);
        } else {
            restaurantViewHolder = new GlobalSearchShimmerItemViewHolder(viewGroup);
        }
        return restaurantViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int p0) {
        String str = getItems().get(p0).getAuthRequestContext;
        int hashCode = str.hashCode();
        if (hashCode != -1592831339) {
            if (hashCode != -667013580) {
                if (hashCode != 2178) {
                    if (hashCode == 1016896708 && str.equals("OFFLINE_MERCHANT")) {
                        return 3;
                    }
                } else if (str.equals("DF")) {
                    return 1;
                }
            } else if (str.equals("ONLINE_MERCHANT")) {
                return 4;
            }
        } else if (str.equals("SERVICE")) {
            return 2;
        }
        return 0;
    }

    public static PaySearchInfoModel PlaceComponentResult() {
        return new PaySearchInfoModel(null, null, null, null, null, null, null, null, null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, null, null, null, null, null, null, false, false, false, 1048575, null);
    }
}
