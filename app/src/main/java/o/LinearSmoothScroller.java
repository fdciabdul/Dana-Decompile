package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.HelpButtonChatBot;
import id.dana.domain.featureconfig.model.HelpButtonConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class LinearSmoothScroller extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public LinearSmoothScroller(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        HelpButtonChatBot helpButtonChatBot = (HelpButtonChatBot) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        if (helpButtonChatBot != helpButtonChatBot.urls) {
            j.PlaceComponentResult(jsonWriter, 376);
            Code128Reader code128Reader = new Code128Reader();
            List<HelpButtonConfig> list = helpButtonChatBot.urls;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, code128Reader, list).write(jsonWriter, list);
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
        HelpButtonChatBot helpButtonChatBot = new HelpButtonChatBot();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 352) {
                jsonReader.skipValue();
            } else if (z) {
                helpButtonChatBot.urls = (List) gson.getAdapter(new Code128Reader()).read2(jsonReader);
            } else {
                helpButtonChatBot.urls = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return helpButtonChatBot;
    }
}
