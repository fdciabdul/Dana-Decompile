package id.dana.drawable.search;

import android.location.Location;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.nearbyme.model.ShopModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u001e\u0010\n\u001a\u00020\u00032\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J&\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\r2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0012À\u0006\u0001"}, d2 = {"Lid/dana/nearbyrevamp/search/NearbySearchResultListener;", "", "onClearButtonClicked", "", "onLocationSelected", "location", "Landroid/location/Location;", "onPlaceSelected", "nearbyLocation", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "onSeeOnMapClicked", "shopModel", "", "Lid/dana/nearbyme/model/ShopModel;", "hasMore", "", "onShopSelected", "allShops", "app_productionRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface NearbySearchResultListener {

    /* renamed from: id.dana.nearbyrevamp.search.NearbySearchResultListener$-CC  reason: invalid class name */
    /* loaded from: classes5.dex */
    public final /* synthetic */ class CC {
        public static void BuiltInFictitiousFunctionClassFactory() {
        }

        public static void getAuthRequestContext(NearbyLocation nearbyLocation) {
            Intrinsics.checkNotNullParameter(nearbyLocation, "");
        }
    }

    void BuiltInFictitiousFunctionClassFactory(ShopModel shopModel, List<? extends ShopModel> list, boolean z);

    void BuiltInFictitiousFunctionClassFactory(List<? extends ShopModel> list, boolean z);

    void PlaceComponentResult();

    void PlaceComponentResult(NearbyLocation nearbyLocation);

    void getAuthRequestContext(Location location);
}
