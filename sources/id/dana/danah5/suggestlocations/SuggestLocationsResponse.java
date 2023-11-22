package id.dana.danah5.suggestlocations;

import com.alibaba.fastjson.JSONObject;
import id.dana.domain.nearbyplaces.model.SuggestedLocation;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0005J\u001b\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lid/dana/danah5/suggestlocations/SuggestLocationsResponse;", "", "", "error", "Lcom/alibaba/fastjson/JSONObject;", "(Ljava/lang/String;)Lcom/alibaba/fastjson/JSONObject;", "", "Lid/dana/domain/nearbyplaces/model/SuggestedLocation;", "locations", "success", "(Ljava/util/List;)Lcom/alibaba/fastjson/JSONObject;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SuggestLocationsResponse {
    public static final SuggestLocationsResponse INSTANCE = new SuggestLocationsResponse();

    private SuggestLocationsResponse() {
    }

    public final JSONObject success(List<SuggestedLocation> locations) {
        Intrinsics.checkNotNullParameter(locations, "");
        if (locations.isEmpty()) {
            return error("LOCATIONS_NOT_FOUND");
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", (Object) locations);
        return jSONObject;
    }

    public final JSONObject error(String error) {
        Intrinsics.checkNotNullParameter(error, "");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) error);
        return jSONObject;
    }
}
