package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.phototips.model.PhotoTipsModel;
import java.io.IOException;
import java.util.List;

/* loaded from: classes5.dex */
public final class getMaxAppJavaHeapMemoryKb extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public getMaxAppJavaHeapMemoryKb(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        PhotoTipsModel photoTipsModel = (PhotoTipsModel) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 511);
        jsonWriter.value(Integer.valueOf(photoTipsModel.getAuthRequestContext));
        String str = photoTipsModel.MyBillsEntityDataFactory;
        j.PlaceComponentResult(jsonWriter, 419);
        jsonWriter.value(photoTipsModel.MyBillsEntityDataFactory);
        j.PlaceComponentResult(jsonWriter, 384);
        jsonWriter.value(Integer.valueOf(photoTipsModel.BuiltInFictitiousFunctionClassFactory));
        j.PlaceComponentResult(jsonWriter, 564);
        jsonWriter.value(Integer.valueOf(photoTipsModel.PlaceComponentResult));
        if (photoTipsModel != photoTipsModel.KClassImpl$Data$declaredNonStaticMembers$2) {
            j.PlaceComponentResult(jsonWriter, 488);
            setRightEdgeEffectColor setrightedgeeffectcolor = new setRightEdgeEffectColor();
            List<String> list = photoTipsModel.KClassImpl$Data$declaredNonStaticMembers$2;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, setrightedgeeffectcolor, list).write(jsonWriter, list);
        }
        String str2 = photoTipsModel.lookAheadTest;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(photoTipsModel.lookAheadTest);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        PhotoTipsModel photoTipsModel = new PhotoTipsModel();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 190) {
                if (authRequestContext != 215) {
                    if (authRequestContext != 368) {
                        if (authRequestContext != 505) {
                            if (authRequestContext != 472) {
                                if (authRequestContext != 473) {
                                    jsonReader.skipValue();
                                } else if (z) {
                                    try {
                                        photoTipsModel.BuiltInFictitiousFunctionClassFactory = jsonReader.nextInt();
                                    } catch (NumberFormatException e) {
                                        throw new JsonSyntaxException(e);
                                    }
                                } else {
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                try {
                                    photoTipsModel.getAuthRequestContext = jsonReader.nextInt();
                                } catch (NumberFormatException e2) {
                                    throw new JsonSyntaxException(e2);
                                }
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            photoTipsModel.MyBillsEntityDataFactory = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            photoTipsModel.MyBillsEntityDataFactory = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        photoTipsModel.KClassImpl$Data$declaredNonStaticMembers$2 = (List) gson.getAdapter(new setRightEdgeEffectColor()).read2(jsonReader);
                    } else {
                        photoTipsModel.KClassImpl$Data$declaredNonStaticMembers$2 = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        photoTipsModel.PlaceComponentResult = jsonReader.nextInt();
                    } catch (NumberFormatException e3) {
                        throw new JsonSyntaxException(e3);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                photoTipsModel.lookAheadTest = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                photoTipsModel.lookAheadTest = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return photoTipsModel;
    }
}
