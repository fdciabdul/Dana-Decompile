package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.homeinfo.model.SkuAttributeEntity;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class ImageCaptureViewModel$getTipUploadPhoto$2 extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public ImageCaptureViewModel$getTipUploadPhoto$2(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SkuAttributeEntity skuAttributeEntity = (SkuAttributeEntity) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        String str = skuAttributeEntity.backgroundColor;
        j.PlaceComponentResult(jsonWriter, 267);
        jsonWriter.value(skuAttributeEntity.backgroundColor);
        String str2 = skuAttributeEntity.buttonDescription;
        j.PlaceComponentResult(jsonWriter, 70);
        jsonWriter.value(skuAttributeEntity.buttonDescription);
        String str3 = skuAttributeEntity.icon;
        j.PlaceComponentResult(jsonWriter, 418);
        jsonWriter.value(skuAttributeEntity.icon);
        String str4 = skuAttributeEntity.link;
        j.PlaceComponentResult(jsonWriter, 395);
        jsonWriter.value(skuAttributeEntity.link);
        if (skuAttributeEntity != skuAttributeEntity.postpaidKey) {
            j.PlaceComponentResult(jsonWriter, 479);
            setMatchingBeaconTypeCode setmatchingbeacontypecode = new setMatchingBeaconTypeCode();
            List<String> list = skuAttributeEntity.postpaidKey;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, setmatchingbeacontypecode, list).write(jsonWriter, list);
        }
        if (skuAttributeEntity != skuAttributeEntity.prepaidKey) {
            j.PlaceComponentResult(jsonWriter, 21);
            GetExpressPurchaseResponse$PriceEntity getExpressPurchaseResponse$PriceEntity = new GetExpressPurchaseResponse$PriceEntity();
            List<String> list2 = skuAttributeEntity.prepaidKey;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getExpressPurchaseResponse$PriceEntity, list2).write(jsonWriter, list2);
        }
        if (skuAttributeEntity != skuAttributeEntity.serviceKey) {
            j.PlaceComponentResult(jsonWriter, 32);
            parametersAsMap parametersasmap = new parametersAsMap();
            List<String> list3 = skuAttributeEntity.serviceKey;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, parametersasmap, list3).write(jsonWriter, list3);
        }
        String str5 = skuAttributeEntity.serviceName;
        j.PlaceComponentResult(jsonWriter, 509);
        jsonWriter.value(skuAttributeEntity.serviceName);
        String str6 = skuAttributeEntity.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(skuAttributeEntity.title);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SkuAttributeEntity skuAttributeEntity = new SkuAttributeEntity();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 10) {
                if (authRequestContext != 97) {
                    if (authRequestContext != 152) {
                        if (authRequestContext != 190) {
                            if (authRequestContext != 332) {
                                if (authRequestContext != 439) {
                                    if (authRequestContext != 524) {
                                        if (authRequestContext != 541) {
                                            if (authRequestContext != 607) {
                                                jsonReader.skipValue();
                                            } else if (z) {
                                                skuAttributeEntity.link = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                            } else {
                                                skuAttributeEntity.link = null;
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            skuAttributeEntity.backgroundColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                        } else {
                                            skuAttributeEntity.backgroundColor = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        skuAttributeEntity.icon = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        skuAttributeEntity.icon = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    skuAttributeEntity.serviceName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                } else {
                                    skuAttributeEntity.serviceName = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                skuAttributeEntity.postpaidKey = (List) gson.getAdapter(new setMatchingBeaconTypeCode()).read2(jsonReader);
                            } else {
                                skuAttributeEntity.postpaidKey = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            skuAttributeEntity.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            skuAttributeEntity.title = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        skuAttributeEntity.buttonDescription = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        skuAttributeEntity.buttonDescription = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    skuAttributeEntity.prepaidKey = (List) gson.getAdapter(new GetExpressPurchaseResponse$PriceEntity()).read2(jsonReader);
                } else {
                    skuAttributeEntity.prepaidKey = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                skuAttributeEntity.serviceKey = (List) gson.getAdapter(new parametersAsMap()).read2(jsonReader);
            } else {
                skuAttributeEntity.serviceKey = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return skuAttributeEntity;
    }
}
