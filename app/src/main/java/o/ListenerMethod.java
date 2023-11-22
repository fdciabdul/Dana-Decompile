package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.sharedpreference.SocialFeedModelEntityData;
import id.dana.data.config.source.sharedpreference.SocialFeedWrapperModelEntityData;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class ListenerMethod extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public ListenerMethod(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SocialFeedWrapperModelEntityData socialFeedWrapperModelEntityData = (SocialFeedWrapperModelEntityData) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (socialFeedWrapperModelEntityData != socialFeedWrapperModelEntityData.data) {
            j.PlaceComponentResult(jsonWriter, 584);
            DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider daggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider = new DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider();
            List<SocialFeedModelEntityData> list = socialFeedWrapperModelEntityData.data;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, daggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider, list).write(jsonWriter, list);
        }
        j.PlaceComponentResult(jsonWriter, 89);
        jsonWriter.value(socialFeedWrapperModelEntityData.fromCache);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SocialFeedWrapperModelEntityData socialFeedWrapperModelEntityData = new SocialFeedWrapperModelEntityData();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 44) {
                if (authRequestContext != 409) {
                    jsonReader.skipValue();
                } else if (z) {
                    socialFeedWrapperModelEntityData.data = (List) gson.getAdapter(new DaggerDanaProtectionWidgetComponent$DanaProtectionWidgetComponentImpl$ProvideEventTrackerQueueProvider()).read2(jsonReader);
                } else {
                    socialFeedWrapperModelEntityData.data = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                socialFeedWrapperModelEntityData.fromCache = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return socialFeedWrapperModelEntityData;
    }
}
