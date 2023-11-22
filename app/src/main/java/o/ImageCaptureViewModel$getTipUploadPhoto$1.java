package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.homeinfo.model.BannerLottieEntity;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ImageCaptureViewModel$getTipUploadPhoto$1 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public ImageCaptureViewModel$getTipUploadPhoto$1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        BannerLottieEntity bannerLottieEntity = (BannerLottieEntity) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = bannerLottieEntity.en;
        j.PlaceComponentResult(jsonWriter, 520);
        jsonWriter.value(bannerLottieEntity.en);
        String str2 = bannerLottieEntity.id;
        j.PlaceComponentResult(jsonWriter, 150);
        jsonWriter.value(bannerLottieEntity.id);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        BannerLottieEntity bannerLottieEntity = new BannerLottieEntity();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 334) {
                if (authRequestContext != 410) {
                    jsonReader.skipValue();
                } else if (z) {
                    bannerLottieEntity.id = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    bannerLottieEntity.id = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                bannerLottieEntity.en = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                bannerLottieEntity.en = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return bannerLottieEntity;
    }
}
