package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.services.repository.source.model.CategoryHighlightedFeature;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class BarcodeUtil$$ExternalSyntheticLambda0 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;

    public BarcodeUtil$$ExternalSyntheticLambda0(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        CategoryHighlightedFeature categoryHighlightedFeature = (CategoryHighlightedFeature) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(categoryHighlightedFeature.enable);
        j.PlaceComponentResult(jsonWriter, 124);
        jsonWriter.value(Integer.valueOf(categoryHighlightedFeature.expired));
        if (categoryHighlightedFeature != categoryHighlightedFeature.featureHighlight) {
            j.PlaceComponentResult(jsonWriter, 349);
            MapPageContract$Presenter mapPageContract$Presenter = new MapPageContract$Presenter();
            List<String> list = categoryHighlightedFeature.featureHighlight;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, mapPageContract$Presenter, list).write(jsonWriter, list);
        }
        j.PlaceComponentResult(jsonWriter, 327);
        jsonWriter.value(Integer.valueOf(categoryHighlightedFeature.resetCounter));
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CategoryHighlightedFeature categoryHighlightedFeature = new CategoryHighlightedFeature();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 107) {
                if (authRequestContext != 116) {
                    if (authRequestContext != 175) {
                        if (authRequestContext != 450) {
                            jsonReader.skipValue();
                        } else if (z) {
                            categoryHighlightedFeature.featureHighlight = (List) gson.getAdapter(new MapPageContract$Presenter()).read2(jsonReader);
                        } else {
                            categoryHighlightedFeature.featureHighlight = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        categoryHighlightedFeature.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    try {
                        categoryHighlightedFeature.expired = jsonReader.nextInt();
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    categoryHighlightedFeature.resetCounter = jsonReader.nextInt();
                } catch (NumberFormatException e2) {
                    throw new JsonSyntaxException(e2);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return categoryHighlightedFeature;
    }
}
