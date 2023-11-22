package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.explore.data.globalsearch.model.ExplorePromoConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchConfigResponse;
import id.dana.explore.data.globalsearch.model.GlobalSearchWidgetResponse;
import id.dana.explore.domain.globalsearch.model.PopularPlaceInfo;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class OtpChallengeUIState$VerifyInvalidOtp extends TypeAdapter implements G {
    private Gson MyBillsEntityDataFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public OtpChallengeUIState$VerifyInvalidOtp(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        GlobalSearchConfigResponse globalSearchConfigResponse = (GlobalSearchConfigResponse) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        Boolean bool = globalSearchConfigResponse.exploreDanaBottomNav;
        j.PlaceComponentResult(jsonWriter, 444);
        jsonWriter.value(globalSearchConfigResponse.exploreDanaBottomNav);
        Boolean bool2 = globalSearchConfigResponse.exploreOnlineMerchantWidget;
        j.PlaceComponentResult(jsonWriter, 532);
        jsonWriter.value(globalSearchConfigResponse.exploreOnlineMerchantWidget);
        if (globalSearchConfigResponse != globalSearchConfigResponse.explorePopularPlaces) {
            j.PlaceComponentResult(jsonWriter, 333);
            validateScopes validatescopes = new validateScopes();
            List<PopularPlaceInfo> list = globalSearchConfigResponse.explorePopularPlaces;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, validatescopes, list).write(jsonWriter, list);
        }
        ExplorePromoConfigResponse explorePromoConfigResponse = globalSearchConfigResponse.explorePromoConfig;
        j.PlaceComponentResult(jsonWriter, 353);
        ExplorePromoConfigResponse explorePromoConfigResponse2 = globalSearchConfigResponse.explorePromoConfig;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, ExplorePromoConfigResponse.class, explorePromoConfigResponse2).write(jsonWriter, explorePromoConfigResponse2);
        Boolean bool3 = globalSearchConfigResponse.explorePromoWidget;
        j.PlaceComponentResult(jsonWriter, 97);
        jsonWriter.value(globalSearchConfigResponse.explorePromoWidget);
        Boolean bool4 = globalSearchConfigResponse.exploreShowPopularPlacesWidget;
        j.PlaceComponentResult(jsonWriter, 370);
        jsonWriter.value(globalSearchConfigResponse.exploreShowPopularPlacesWidget);
        Boolean bool5 = globalSearchConfigResponse.exploreSkuWidget;
        j.PlaceComponentResult(jsonWriter, 168);
        jsonWriter.value(globalSearchConfigResponse.exploreSkuWidget);
        if (globalSearchConfigResponse != globalSearchConfigResponse.widgetOrder) {
            j.PlaceComponentResult(jsonWriter, 362);
            GetKybCompressQrConfig_Factory getKybCompressQrConfig_Factory = new GetKybCompressQrConfig_Factory();
            List<GlobalSearchWidgetResponse> list2 = globalSearchConfigResponse.widgetOrder;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getKybCompressQrConfig_Factory, list2).write(jsonWriter, list2);
        }
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        GlobalSearchConfigResponse globalSearchConfigResponse = new GlobalSearchConfigResponse();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 43) {
                if (authRequestContext != 81) {
                    if (authRequestContext != 160) {
                        if (authRequestContext != 213) {
                            if (authRequestContext != 217) {
                                if (authRequestContext != 290) {
                                    if (authRequestContext != 343) {
                                        if (authRequestContext != 357) {
                                            jsonReader.skipValue();
                                        } else if (z) {
                                            globalSearchConfigResponse.exploreShowPopularPlacesWidget = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                        } else {
                                            globalSearchConfigResponse.exploreShowPopularPlacesWidget = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        globalSearchConfigResponse.explorePromoWidget = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                    } else {
                                        globalSearchConfigResponse.explorePromoWidget = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    globalSearchConfigResponse.exploreOnlineMerchantWidget = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                                } else {
                                    globalSearchConfigResponse.exploreOnlineMerchantWidget = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                globalSearchConfigResponse.exploreSkuWidget = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                            } else {
                                globalSearchConfigResponse.exploreSkuWidget = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            globalSearchConfigResponse.widgetOrder = (List) gson.getAdapter(new GetKybCompressQrConfig_Factory()).read2(jsonReader);
                        } else {
                            globalSearchConfigResponse.widgetOrder = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        globalSearchConfigResponse.explorePopularPlaces = (List) gson.getAdapter(new validateScopes()).read2(jsonReader);
                    } else {
                        globalSearchConfigResponse.explorePopularPlaces = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    globalSearchConfigResponse.exploreDanaBottomNav = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    globalSearchConfigResponse.exploreDanaBottomNav = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                globalSearchConfigResponse.explorePromoConfig = (ExplorePromoConfigResponse) gson.getAdapter(ExplorePromoConfigResponse.class).read2(jsonReader);
            } else {
                globalSearchConfigResponse.explorePromoConfig = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return globalSearchConfigResponse;
    }
}
