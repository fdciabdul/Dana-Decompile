package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.cancelsurvey.model.CancellationSurveyConfigModel;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getStackFromEnd extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getStackFromEnd(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CancellationSurveyConfigModel cancellationSurveyConfigModel = (CancellationSurveyConfigModel) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = cancellationSurveyConfigModel.ctaText;
        j.PlaceComponentResult(jsonWriter, 324);
        jsonWriter.value(cancellationSurveyConfigModel.ctaText);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(cancellationSurveyConfigModel.enable);
        String str2 = cancellationSurveyConfigModel.headerText;
        j.PlaceComponentResult(jsonWriter, 363);
        jsonWriter.value(cancellationSurveyConfigModel.headerText);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CancellationSurveyConfigModel cancellationSurveyConfigModel = new CancellationSurveyConfigModel();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 175) {
                if (authRequestContext != 184) {
                    if (authRequestContext != 441) {
                        jsonReader.skipValue();
                    } else if (z) {
                        cancellationSurveyConfigModel.headerText = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        cancellationSurveyConfigModel.headerText = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    cancellationSurveyConfigModel.ctaText = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    cancellationSurveyConfigModel.ctaText = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                cancellationSurveyConfigModel.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return cancellationSurveyConfigModel;
    }
}
