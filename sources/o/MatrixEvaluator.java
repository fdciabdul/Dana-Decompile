package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Wifi;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class MatrixEvaluator extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public MatrixEvaluator(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Wifi wifi = (Wifi) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = wifi.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 562);
        jsonWriter.value(wifi.MyBillsEntityDataFactory);
        j.PlaceComponentResult(jsonWriter, 450);
        jsonWriter.value(Integer.valueOf(wifi.getAuthRequestContext));
        j.PlaceComponentResult(jsonWriter, 368);
        jsonWriter.value(wifi.PlaceComponentResult);
        j.PlaceComponentResult(jsonWriter, 475);
        jsonWriter.value(Integer.valueOf(wifi.BuiltInFictitiousFunctionClassFactory));
        String str2 = wifi.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 289);
        jsonWriter.value(wifi.KClassImpl$Data$declaredNonStaticMembers$2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Wifi wifi = new Wifi();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 30) {
                if (authRequestContext != 151) {
                    if (authRequestContext != 341) {
                        if (authRequestContext != 387) {
                            if (authRequestContext != 511) {
                                jsonReader.skipValue();
                            } else if (z) {
                                wifi.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                wifi.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            try {
                                wifi.getAuthRequestContext = jsonReader.nextInt();
                            } catch (NumberFormatException e) {
                                throw new JsonSyntaxException(e);
                            }
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        wifi.PlaceComponentResult = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    wifi.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    wifi.MyBillsEntityDataFactory = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    wifi.BuiltInFictitiousFunctionClassFactory = jsonReader.nextInt();
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return wifi;
    }
}
