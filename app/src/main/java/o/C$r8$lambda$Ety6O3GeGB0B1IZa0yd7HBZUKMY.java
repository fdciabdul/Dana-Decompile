package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.sendmoney.model.BillerX2BEntity;
import java.io.IOException;

/* renamed from: o.$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY  reason: invalid class name */
/* loaded from: classes4.dex */
public final class C$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;

    public C$r8$lambda$Ety6O3GeGB0B1IZa0yd7HBZUKMY(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        BillerX2BEntity billerX2BEntity = (BillerX2BEntity) obj;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 341);
        jsonWriter.value(billerX2BEntity.agreed);
        String str = billerX2BEntity.billerName;
        j.PlaceComponentResult(jsonWriter, 264);
        jsonWriter.value(billerX2BEntity.billerName);
        String str2 = billerX2BEntity.clientId;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED);
        jsonWriter.value(billerX2BEntity.clientId);
        String str3 = billerX2BEntity.instId;
        j.PlaceComponentResult(jsonWriter, 332);
        jsonWriter.value(billerX2BEntity.instId);
        String str4 = billerX2BEntity.prefix;
        j.PlaceComponentResult(jsonWriter, 358);
        jsonWriter.value(billerX2BEntity.prefix);
        String str5 = billerX2BEntity.redirectUrl;
        j.PlaceComponentResult(jsonWriter, 467);
        jsonWriter.value(billerX2BEntity.redirectUrl);
        String str6 = billerX2BEntity.scopes;
        j.PlaceComponentResult(jsonWriter, 392);
        jsonWriter.value(billerX2BEntity.scopes);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        BillerX2BEntity billerX2BEntity = new BillerX2BEntity();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 125) {
                if (authRequestContext != 255) {
                    if (authRequestContext != 306) {
                        if (authRequestContext != 348) {
                            if (authRequestContext != 360) {
                                if (authRequestContext != 421) {
                                    if (authRequestContext != 553) {
                                        jsonReader.skipValue();
                                    } else if (z) {
                                        billerX2BEntity.billerName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        billerX2BEntity.billerName = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    billerX2BEntity.agreed = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                } else {
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                billerX2BEntity.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                billerX2BEntity.redirectUrl = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            billerX2BEntity.prefix = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            billerX2BEntity.prefix = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        billerX2BEntity.clientId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        billerX2BEntity.clientId = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    billerX2BEntity.instId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    billerX2BEntity.instId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                billerX2BEntity.scopes = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                billerX2BEntity.scopes = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return billerX2BEntity;
    }
}
