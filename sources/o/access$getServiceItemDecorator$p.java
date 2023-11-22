package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class access$getServiceItemDecorator$p extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;

    public access$getServiceItemDecorator$p(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            ((DeepLinkPayloadEntity) obj).getAuthRequestContext(jsonWriter, this.BuiltInFictitiousFunctionClassFactory);
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        DeepLinkPayloadEntity deepLinkPayloadEntity = new DeepLinkPayloadEntity();
        deepLinkPayloadEntity.MyBillsEntityDataFactory(this.MyBillsEntityDataFactory, jsonReader, this.KClassImpl$Data$declaredNonStaticMembers$2);
        return deepLinkPayloadEntity;
    }
}
