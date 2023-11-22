package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Bluetooth;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class getHashMap extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getHashMap(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Bluetooth bluetooth = (Bluetooth) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = bluetooth.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 570);
        jsonWriter.value(bluetooth.PlaceComponentResult);
        j.PlaceComponentResult(jsonWriter, 249);
        jsonWriter.value(Integer.valueOf(bluetooth.getAuthRequestContext));
        j.PlaceComponentResult(jsonWriter, 566);
        jsonWriter.value(bluetooth.BuiltInFictitiousFunctionClassFactory);
        j.PlaceComponentResult(jsonWriter, 521);
        jsonWriter.value(bluetooth.MyBillsEntityDataFactory);
        j.PlaceComponentResult(jsonWriter, 237);
        jsonWriter.value(Integer.valueOf(bluetooth.KClassImpl$Data$declaredNonStaticMembers$2));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Bluetooth bluetooth = new Bluetooth();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 283) {
                if (authRequestContext != 297) {
                    if (authRequestContext != 454) {
                        if (authRequestContext != 496) {
                            if (authRequestContext != 571) {
                                jsonReader.skipValue();
                            } else if (z) {
                                try {
                                    bluetooth.getAuthRequestContext = jsonReader.nextInt();
                                } catch (NumberFormatException e) {
                                    throw new JsonSyntaxException(e);
                                }
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            bluetooth.MyBillsEntityDataFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        bluetooth.BuiltInFictitiousFunctionClassFactory = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    bluetooth.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    bluetooth.PlaceComponentResult = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    bluetooth.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.nextInt();
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return bluetooth;
    }
}
