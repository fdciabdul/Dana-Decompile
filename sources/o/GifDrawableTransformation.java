package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.zoloz.toyger.blob.BlobStatic;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.sendmoney.model.AddPayMethod;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class GifDrawableTransformation extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;

    public GifDrawableTransformation(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        AddPayMethod addPayMethod = (AddPayMethod) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(addPayMethod.enable);
        if (addPayMethod != addPayMethod.instId) {
            j.PlaceComponentResult(jsonWriter, 332);
            jsonWriter.value(addPayMethod.instId);
        }
        if (addPayMethod != addPayMethod.instLocalName) {
            j.PlaceComponentResult(jsonWriter, BlobStatic.MONITOR_IMAGE_WIDTH);
            jsonWriter.value(addPayMethod.instLocalName);
        }
        if (addPayMethod != addPayMethod.key) {
            j.PlaceComponentResult(jsonWriter, 318);
            jsonWriter.value(addPayMethod.key);
        }
        if (addPayMethod != addPayMethod.payMethod) {
            j.PlaceComponentResult(jsonWriter, 50);
            jsonWriter.value(addPayMethod.payMethod);
        }
        if (addPayMethod != addPayMethod.url) {
            j.PlaceComponentResult(jsonWriter, 320);
            jsonWriter.value(addPayMethod.url);
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
        AddPayMethod addPayMethod = new AddPayMethod();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 72) {
                if (authRequestContext != 95) {
                    if (authRequestContext != 167) {
                        if (authRequestContext != 175) {
                            if (authRequestContext != 255) {
                                if (authRequestContext != 303) {
                                    jsonReader.skipValue();
                                } else if (z) {
                                    addPayMethod.instLocalName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                } else {
                                    addPayMethod.instLocalName = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                addPayMethod.instId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                addPayMethod.instId = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            addPayMethod.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        addPayMethod.payMethod = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        addPayMethod.payMethod = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    addPayMethod.url = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    addPayMethod.url = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                addPayMethod.key = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                addPayMethod.key = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return addPayMethod;
    }
}
