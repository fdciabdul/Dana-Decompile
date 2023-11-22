package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.login.source.network.result.RetryConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson PlaceComponentResult;

    public DaggerGlobalSearchBottomSheetComponent$GlobalSearchBottomSheetComponentImpl$ProvideFeedsConfigRepositoryProvider(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        RetryConfig retryConfig = (RetryConfig) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 529);
        jsonWriter.value(Integer.valueOf(retryConfig.maxRetry));
        j.PlaceComponentResult(jsonWriter, 441);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(retryConfig.retryDelay);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        RetryConfig retryConfig = new RetryConfig();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 17) {
                if (authRequestContext != 458) {
                    jsonReader.skipValue();
                } else if (z) {
                    try {
                        retryConfig.maxRetry = jsonReader.nextInt();
                    } catch (NumberFormatException e) {
                        throw new JsonSyntaxException(e);
                    }
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                retryConfig.retryDelay = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return retryConfig;
    }
}
