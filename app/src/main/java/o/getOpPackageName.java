package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.cardbinding.data.model.SupportedCardEntity;
import id.dana.cardbinding.data.model.SupportedCardsConfigEntity;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class getOpPackageName extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getOpPackageName(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SupportedCardsConfigEntity supportedCardsConfigEntity = (SupportedCardsConfigEntity) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        String str = supportedCardsConfigEntity.PlaceComponentResult;
        j.PlaceComponentResult(jsonWriter, 163);
        jsonWriter.value(supportedCardsConfigEntity.PlaceComponentResult);
        String str2 = supportedCardsConfigEntity.KClassImpl$Data$declaredNonStaticMembers$2;
        j.PlaceComponentResult(jsonWriter, 307);
        jsonWriter.value(supportedCardsConfigEntity.KClassImpl$Data$declaredNonStaticMembers$2);
        String str3 = supportedCardsConfigEntity.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 347);
        jsonWriter.value(supportedCardsConfigEntity.MyBillsEntityDataFactory);
        if (supportedCardsConfigEntity != supportedCardsConfigEntity.getAuthRequestContext) {
            j.PlaceComponentResult(jsonWriter, 69);
            UnicastProcessor$UnicastQueueSubscription unicastProcessor$UnicastQueueSubscription = new UnicastProcessor$UnicastQueueSubscription();
            List<SupportedCardEntity> list = supportedCardsConfigEntity.getAuthRequestContext;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, unicastProcessor$UnicastQueueSubscription, list).write(jsonWriter, list);
        }
        String str4 = supportedCardsConfigEntity.BuiltInFictitiousFunctionClassFactory;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(supportedCardsConfigEntity.BuiltInFictitiousFunctionClassFactory);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SupportedCardsConfigEntity supportedCardsConfigEntity = new SupportedCardsConfigEntity();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 469) {
                    if (authRequestContext != 518) {
                        if (authRequestContext != 572) {
                            if (authRequestContext != 598) {
                                jsonReader.skipValue();
                            } else if (z) {
                                supportedCardsConfigEntity.PlaceComponentResult = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                supportedCardsConfigEntity.PlaceComponentResult = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            supportedCardsConfigEntity.getAuthRequestContext = (List) gson.getAdapter(new UnicastProcessor$UnicastQueueSubscription()).read2(jsonReader);
                        } else {
                            supportedCardsConfigEntity.getAuthRequestContext = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        supportedCardsConfigEntity.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        supportedCardsConfigEntity.MyBillsEntityDataFactory = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    supportedCardsConfigEntity.KClassImpl$Data$declaredNonStaticMembers$2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    supportedCardsConfigEntity.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                supportedCardsConfigEntity.BuiltInFictitiousFunctionClassFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                supportedCardsConfigEntity.BuiltInFictitiousFunctionClassFactory = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return supportedCardsConfigEntity;
    }
}
