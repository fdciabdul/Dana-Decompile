package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.yellowmessenger.ymchat.models.YellowUnreadMessageResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class PlaybackStateCompat$MediaKeyAction extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public PlaybackStateCompat$MediaKeyAction(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        YellowUnreadMessageResponse yellowUnreadMessageResponse = (YellowUnreadMessageResponse) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        if (yellowUnreadMessageResponse != yellowUnreadMessageResponse.PlaceComponentResult) {
            j.PlaceComponentResult(jsonWriter, 416);
            jsonWriter.value(yellowUnreadMessageResponse.PlaceComponentResult);
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
        YellowUnreadMessageResponse yellowUnreadMessageResponse = new YellowUnreadMessageResponse();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 18) {
                jsonReader.skipValue();
            } else if (z) {
                yellowUnreadMessageResponse.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                yellowUnreadMessageResponse.PlaceComponentResult = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return yellowUnreadMessageResponse;
    }
}
