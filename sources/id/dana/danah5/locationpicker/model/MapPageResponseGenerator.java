package id.dana.danah5.locationpicker.model;

import com.alibaba.fastjson.JSONObject;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ!\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010"}, d2 = {"Lid/dana/danah5/locationpicker/model/MapPageResponseGenerator;", "", "Lcom/alibaba/fastjson/JSONObject;", "cancel", "()Lcom/alibaba/fastjson/JSONObject;", "chooseAnotherAddress", "Lid/dana/danah5/locationpicker/model/MapPageResult;", "result", "chooseThisLocation", "(Lid/dana/danah5/locationpicker/model/MapPageResult;)Lcom/alibaba/fastjson/JSONObject;", "", "choice", "generate", "(Ljava/lang/String;Lid/dana/danah5/locationpicker/model/MapPageResult;)Lcom/alibaba/fastjson/JSONObject;", "unknownError", "UNKNOWN_ERROR", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MapPageResponseGenerator {
    public static final MapPageResponseGenerator INSTANCE = new MapPageResponseGenerator();
    private static final String UNKNOWN_ERROR = "UNKNOWN_ERROR";

    private MapPageResponseGenerator() {
    }

    public final JSONObject generate(String choice, MapPageResult result) {
        if (choice == null) {
            choice = "CANCEL";
        }
        int hashCode = choice.hashCode();
        if (hashCode != -339127282) {
            if (hashCode != 1287618640) {
                if (hashCode == 1980572282 && choice.equals("CANCEL")) {
                    return cancel();
                }
            } else if (choice.equals("CHOOSE_ANOTHER_ADDRESS")) {
                return chooseAnotherAddress();
            }
        } else if (choice.equals("CHOOSE_THIS_LOCATION")) {
            return chooseThisLocation(result);
        }
        return unknownError();
    }

    private final JSONObject chooseThisLocation(MapPageResult result) {
        JSONObject jSONObject = new JSONObject();
        if (result == null) {
            return INSTANCE.unknownError();
        }
        double latitude = result.getLatitude();
        double longitude = result.getLongitude();
        MapPageResponse mapPageResponse = new MapPageResponse("CHOOSE_THIS_LOCATION", Double.valueOf(latitude), Double.valueOf(longitude), result.getCountryCode(), result.getCountryName(), result.getProvinceName(), result.getCityName(), result.getDistrictName(), result.getSubdistrictName(), result.getStreetName(), result.getPostalCode());
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", (Object) mapPageResponse);
        return jSONObject;
    }

    private final JSONObject chooseAnotherAddress() {
        JSONObject jSONObject = new JSONObject();
        MapPageResponse mapPageResponse = new MapPageResponse("CHOOSE_ANOTHER_ADDRESS", null, null, null, null, null, null, null, null, null, null, 2046, null);
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", (Object) mapPageResponse);
        return jSONObject;
    }

    private final JSONObject cancel() {
        JSONObject jSONObject = new JSONObject();
        MapPageResponse mapPageResponse = new MapPageResponse("CANCEL", null, null, null, null, null, null, null, null, null, null, 2046, null);
        jSONObject.put("success", (Object) Boolean.TRUE);
        jSONObject.put("data", (Object) mapPageResponse);
        return jSONObject;
    }

    private final JSONObject unknownError() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("success", (Object) Boolean.FALSE);
        jSONObject.put("error", (Object) "UNKNOWN_ERROR");
        return jSONObject;
    }
}
