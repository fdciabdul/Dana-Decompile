package id.dana.data.nearbyplaces.mapper;

import id.dana.data.nearbyplaces.repository.source.network.result.PlacePredictionResult;
import id.dana.domain.nearbyplaces.model.NearbyLocation;
import id.dana.domain.nearbyplaces.model.SuggestedLocation;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001d\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0000*\b\u0012\u0004\u0012\u00020\u00010\u0000¢\u0006\u0004\b\u0006\u0010\u0004\u001a\u0011\u0010\u0007\u001a\u00020\u0002*\u00020\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0011\u0010\t\u001a\u00020\u0005*\u00020\u0001¢\u0006\u0004\b\t\u0010\n"}, d2 = {"", "Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;", "Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "toListNearbyLocation", "(Ljava/util/List;)Ljava/util/List;", "Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "toListSuggestedLocation", "toNearbyLocation", "(Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;)Lid/dana/domain/nearbyplaces/model/NearbyLocation;", "toSuggestionLocation", "(Lid/dana/data/nearbyplaces/repository/source/network/result/PlacePredictionResult;)Lid/dana/domain/nearbyplaces/model/SuggestedLocation;"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PlaceResultMapperKt {
    public static final List<NearbyLocation> toListNearbyLocation(List<PlacePredictionResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PlacePredictionResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toNearbyLocation((PlacePredictionResult) it.next()));
        }
        return arrayList;
    }

    public static final List<SuggestedLocation> toListSuggestedLocation(List<PlacePredictionResult> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<PlacePredictionResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toSuggestionLocation((PlacePredictionResult) it.next()));
        }
        return arrayList;
    }

    public static final NearbyLocation toNearbyLocation(PlacePredictionResult placePredictionResult) {
        Intrinsics.checkNotNullParameter(placePredictionResult, "");
        String mainText = placePredictionResult.getStructuredFormatting().getMainText();
        String secondaryText = placePredictionResult.getStructuredFormatting().getSecondaryText();
        String placeId = placePredictionResult.getPlaceId();
        long distanceInMeters = placePredictionResult.getDistanceInMeters();
        String chainQueryUrl = placePredictionResult.getChainQueryUrl();
        boolean isFollowUpQuery = placePredictionResult.isFollowUpQuery();
        return new NearbyLocation(mainText, secondaryText, placeId, distanceInMeters, chainQueryUrl, isFollowUpQuery ? 1 : 0, placePredictionResult.getLocation());
    }

    public static final SuggestedLocation toSuggestionLocation(PlacePredictionResult placePredictionResult) {
        Intrinsics.checkNotNullParameter(placePredictionResult, "");
        return new SuggestedLocation(placePredictionResult.getStructuredFormatting().getMainText(), placePredictionResult.getStructuredFormatting().getSecondaryText(), placePredictionResult.getPlaceId(), placePredictionResult.getLocation().getLatitude(), placePredictionResult.getLocation().getLongitude());
    }
}
