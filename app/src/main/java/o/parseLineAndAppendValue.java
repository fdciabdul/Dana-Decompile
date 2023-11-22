package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.utils.config.model.Display;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class parseLineAndAppendValue extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private J PlaceComponentResult;

    public parseLineAndAppendValue(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        Display display = (Display) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 354);
        jsonWriter.value(Integer.valueOf(display.KClassImpl$Data$declaredNonStaticMembers$2));
        j.PlaceComponentResult(jsonWriter, 308);
        jsonWriter.value(Integer.valueOf(display.BuiltInFictitiousFunctionClassFactory));
        j.PlaceComponentResult(jsonWriter, 563);
        jsonWriter.value(Integer.valueOf(display.MyBillsEntityDataFactory));
        j.PlaceComponentResult(jsonWriter, 440);
        jsonWriter.value(Integer.valueOf(display.PlaceComponentResult));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        Display display = new Display();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 11) {
                if (authRequestContext != 260) {
                    if (authRequestContext != 386) {
                        if (authRequestContext != 616) {
                            jsonReader.skipValue();
                        } else if (z) {
                            try {
                                display.PlaceComponentResult = jsonReader.nextInt();
                            } catch (NumberFormatException e) {
                                throw new JsonSyntaxException(e);
                            }
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        try {
                            display.MyBillsEntityDataFactory = jsonReader.nextInt();
                        } catch (NumberFormatException e2) {
                            throw new JsonSyntaxException(e2);
                        }
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        display.BuiltInFictitiousFunctionClassFactory = jsonReader.nextInt();
                    } catch (NumberFormatException e3) {
                        throw new JsonSyntaxException(e3);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    display.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.nextInt();
                } catch (NumberFormatException e4) {
                    throw new JsonSyntaxException(e4);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return display;
    }
}
