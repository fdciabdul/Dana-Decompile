package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.DiagnosticLogConfig;
import id.dana.domain.featureconfig.model.SplunkConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class getDirName extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;

    public getDirName(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        DiagnosticLogConfig diagnosticLogConfig = (DiagnosticLogConfig) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 434);
        jsonWriter.value(diagnosticLogConfig.enabled);
        j.PlaceComponentResult(jsonWriter, 213);
        jsonWriter.value(diagnosticLogConfig.firebase);
        Long l = diagnosticLogConfig.lastUpdatedTime;
        j.PlaceComponentResult(jsonWriter, 98);
        Long l2 = diagnosticLogConfig.lastUpdatedTime;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Long.class, l2).write(jsonWriter, l2);
        SplunkConfig splunkConfig = diagnosticLogConfig.splunkConfig;
        j.PlaceComponentResult(jsonWriter, 64);
        SplunkConfig splunkConfig2 = diagnosticLogConfig.splunkConfig;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, SplunkConfig.class, splunkConfig2).write(jsonWriter, splunkConfig2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DiagnosticLogConfig diagnosticLogConfig = new DiagnosticLogConfig();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 92) {
                if (authRequestContext != 102) {
                    if (authRequestContext != 182) {
                        if (authRequestContext != 447) {
                            jsonReader.skipValue();
                        } else if (z) {
                            diagnosticLogConfig.firebase = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        diagnosticLogConfig.splunkConfig = (SplunkConfig) gson.getAdapter(SplunkConfig.class).read2(jsonReader);
                    } else {
                        diagnosticLogConfig.splunkConfig = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    diagnosticLogConfig.enabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                diagnosticLogConfig.lastUpdatedTime = (Long) gson.getAdapter(Long.class).read2(jsonReader);
            } else {
                diagnosticLogConfig.lastUpdatedTime = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return diagnosticLogConfig;
    }
}
