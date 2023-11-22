package o;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.banner.model.BannerEntity;
import java.io.IOException;
import java.util.Date;

/* loaded from: classes4.dex */
public final class SplitSavingConfigEntityData extends TypeAdapter implements G {
    private J KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public SplitSavingConfigEntityData(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        BannerEntity bannerEntity = (BannerEntity) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonWriter.beginObject();
        String str = bannerEntity.bizType;
        j.PlaceComponentResult(jsonWriter, 79);
        jsonWriter.value(bannerEntity.bizType);
        String str2 = bannerEntity.contentId;
        j.PlaceComponentResult(jsonWriter, 575);
        jsonWriter.value(bannerEntity.contentId);
        String str3 = bannerEntity.contentName;
        j.PlaceComponentResult(jsonWriter, 253);
        jsonWriter.value(bannerEntity.contentName);
        String str4 = bannerEntity.contentType;
        j.PlaceComponentResult(jsonWriter, 11);
        jsonWriter.value(bannerEntity.contentType);
        String str5 = bannerEntity.contentValue;
        j.PlaceComponentResult(jsonWriter, 522);
        jsonWriter.value(bannerEntity.contentValue);
        if (bannerEntity != bannerEntity.effectiveDate) {
            j.PlaceComponentResult(jsonWriter, 145);
            Date date = bannerEntity.effectiveDate;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, Date.class, date).write(jsonWriter, date);
        }
        if (bannerEntity != bannerEntity.expireDate) {
            j.PlaceComponentResult(jsonWriter, 86);
            Date date2 = bannerEntity.expireDate;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, Date.class, date2).write(jsonWriter, date2);
        }
        String str6 = bannerEntity.extendInfo;
        j.PlaceComponentResult(jsonWriter, 214);
        jsonWriter.value(bannerEntity.extendInfo);
        Integer num = bannerEntity.priority;
        j.PlaceComponentResult(jsonWriter, 43);
        Integer num2 = bannerEntity.priority;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        String str7 = bannerEntity.redirectUrl;
        j.PlaceComponentResult(jsonWriter, 467);
        jsonWriter.value(bannerEntity.redirectUrl);
        String str8 = bannerEntity.status;
        j.PlaceComponentResult(jsonWriter, 95);
        jsonWriter.value(bannerEntity.status);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        BannerEntity bannerEntity = new BannerEntity();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 79:
                    if (!z) {
                        bannerEntity.contentValue = null;
                        break;
                    } else {
                        bannerEntity.contentValue = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 85:
                    if (!z) {
                        bannerEntity.bizType = null;
                        break;
                    } else {
                        bannerEntity.bizType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 149:
                    if (!z) {
                        bannerEntity.contentType = null;
                        break;
                    } else {
                        bannerEntity.contentType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 219:
                    if (!z) {
                        bannerEntity.priority = null;
                        break;
                    } else {
                        bannerEntity.priority = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 344:
                    if (!z) {
                        bannerEntity.extendInfo = null;
                        break;
                    } else {
                        bannerEntity.extendInfo = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                    if (!z) {
                        bannerEntity.redirectUrl = null;
                        break;
                    } else {
                        bannerEntity.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 486:
                    if (!z) {
                        bannerEntity.effectiveDate = null;
                        break;
                    } else {
                        bannerEntity.effectiveDate = (Date) gson.getAdapter(Date.class).read2(jsonReader);
                        continue;
                    }
                case 510:
                    if (!z) {
                        bannerEntity.expireDate = null;
                        break;
                    } else {
                        bannerEntity.expireDate = (Date) gson.getAdapter(Date.class).read2(jsonReader);
                        continue;
                    }
                case 579:
                    if (!z) {
                        bannerEntity.contentId = null;
                        break;
                    } else {
                        bannerEntity.contentId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_BASE64_FAILED /* 604 */:
                    if (!z) {
                        bannerEntity.contentName = null;
                        break;
                    } else {
                        bannerEntity.contentName = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_ATLAS_KEY_NOT_EXSITED /* 613 */:
                    if (!z) {
                        bannerEntity.status = null;
                        break;
                    } else {
                        bannerEntity.status = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return bannerEntity;
    }
}
