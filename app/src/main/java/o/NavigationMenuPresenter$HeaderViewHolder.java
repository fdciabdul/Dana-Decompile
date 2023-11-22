package o;

import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.model.MarmotDanaPromotionResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class NavigationMenuPresenter$HeaderViewHolder extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public NavigationMenuPresenter$HeaderViewHolder(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        MarmotDanaPromotionResponse marmotDanaPromotionResponse = (MarmotDanaPromotionResponse) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        Boolean bool = marmotDanaPromotionResponse.migrationStatus;
        j.PlaceComponentResult(jsonWriter, 433);
        jsonWriter.value(marmotDanaPromotionResponse.migrationStatus);
        String str = marmotDanaPromotionResponse.path;
        j.PlaceComponentResult(jsonWriter, WebSocket.DEFAULT_WSS_PORT);
        jsonWriter.value(marmotDanaPromotionResponse.path);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        MarmotDanaPromotionResponse marmotDanaPromotionResponse = new MarmotDanaPromotionResponse();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 267) {
                if (authRequestContext != 430) {
                    jsonReader.skipValue();
                } else if (z) {
                    marmotDanaPromotionResponse.migrationStatus = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                } else {
                    marmotDanaPromotionResponse.migrationStatus = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                marmotDanaPromotionResponse.path = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                marmotDanaPromotionResponse.path = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return marmotDanaPromotionResponse;
    }
}
