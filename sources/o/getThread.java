package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.permissionprompt.model.NumberOfLocationPermissionPromptShown;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getThread extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public getThread(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown = (NumberOfLocationPermissionPromptShown) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 461);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(numberOfLocationPermissionPromptShown.lastReminderUIShowed);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        j.PlaceComponentResult(jsonWriter, 99);
        jsonWriter.value(Integer.valueOf(numberOfLocationPermissionPromptShown.totalReminderUIShowed));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        NumberOfLocationPermissionPromptShown numberOfLocationPermissionPromptShown = new NumberOfLocationPermissionPromptShown();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 101) {
                if (authRequestContext != 249) {
                    jsonReader.skipValue();
                } else if (z) {
                    numberOfLocationPermissionPromptShown.lastReminderUIShowed = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    numberOfLocationPermissionPromptShown.totalReminderUIShowed = jsonReader.nextInt();
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return numberOfLocationPermissionPromptShown;
    }
}
