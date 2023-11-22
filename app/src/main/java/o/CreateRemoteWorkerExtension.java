package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.config.source.sharedpreference.SocialFeedModelEntityData;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes4.dex */
public final class CreateRemoteWorkerExtension extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private J getAuthRequestContext;

    public CreateRemoteWorkerExtension(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        SocialFeedModelEntityData socialFeedModelEntityData = (SocialFeedModelEntityData) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        Integer num = socialFeedModelEntityData.actorCount;
        j.PlaceComponentResult(jsonWriter, 140);
        Integer num2 = socialFeedModelEntityData.actorCount;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        String str = socialFeedModelEntityData.contentType;
        j.PlaceComponentResult(jsonWriter, 11);
        jsonWriter.value(socialFeedModelEntityData.contentType);
        Long l = socialFeedModelEntityData.createdTime;
        j.PlaceComponentResult(jsonWriter, 225);
        Long l2 = socialFeedModelEntityData.createdTime;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Long.class, l2).write(jsonWriter, l2);
        String str2 = socialFeedModelEntityData.description;
        j.PlaceComponentResult(jsonWriter, 388);
        jsonWriter.value(socialFeedModelEntityData.description);
        if (socialFeedModelEntityData != socialFeedModelEntityData.extendInfo) {
            j.PlaceComponentResult(jsonWriter, 214);
            ImageWithDescriptionView$showImage$1 imageWithDescriptionView$showImage$1 = new ImageWithDescriptionView$showImage$1();
            HashMap<String, String> hashMap = socialFeedModelEntityData.extendInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, imageWithDescriptionView$showImage$1, hashMap).write(jsonWriter, hashMap);
        }
        String str3 = socialFeedModelEntityData.iconUrl;
        j.PlaceComponentResult(jsonWriter, 454);
        jsonWriter.value(socialFeedModelEntityData.iconUrl);
        String str4 = socialFeedModelEntityData.iconUrl2;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_BASE64_FAILED);
        jsonWriter.value(socialFeedModelEntityData.iconUrl2);
        String str5 = socialFeedModelEntityData.id;
        j.PlaceComponentResult(jsonWriter, 150);
        jsonWriter.value(socialFeedModelEntityData.id);
        String str6 = socialFeedModelEntityData.redirectType;
        j.PlaceComponentResult(jsonWriter, 22);
        jsonWriter.value(socialFeedModelEntityData.redirectType);
        String str7 = socialFeedModelEntityData.redirectValue;
        j.PlaceComponentResult(jsonWriter, 262);
        jsonWriter.value(socialFeedModelEntityData.redirectValue);
        Integer num3 = socialFeedModelEntityData.viewType;
        j.PlaceComponentResult(jsonWriter, 379);
        Integer num4 = socialFeedModelEntityData.viewType;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        SocialFeedModelEntityData socialFeedModelEntityData = new SocialFeedModelEntityData();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 117:
                    if (!z) {
                        socialFeedModelEntityData.actorCount = null;
                        break;
                    } else {
                        socialFeedModelEntityData.actorCount = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 149:
                    if (!z) {
                        socialFeedModelEntityData.contentType = null;
                        break;
                    } else {
                        socialFeedModelEntityData.contentType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case DeepRecoverARiverProxy.TYPE_ENTITY_APP /* 257 */:
                    if (!z) {
                        socialFeedModelEntityData.iconUrl = null;
                        break;
                    } else {
                        socialFeedModelEntityData.iconUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 315:
                    if (!z) {
                        socialFeedModelEntityData.createdTime = null;
                        break;
                    } else {
                        socialFeedModelEntityData.createdTime = (Long) gson.getAdapter(Long.class).read2(jsonReader);
                        continue;
                    }
                case 344:
                    if (!z) {
                        socialFeedModelEntityData.extendInfo = null;
                        break;
                    } else {
                        socialFeedModelEntityData.extendInfo = (HashMap) gson.getAdapter(new ImageWithDescriptionView$showImage$1()).read2(jsonReader);
                        continue;
                    }
                case 356:
                    if (!z) {
                        socialFeedModelEntityData.viewType = null;
                        break;
                    } else {
                        socialFeedModelEntityData.viewType = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 358:
                    if (!z) {
                        socialFeedModelEntityData.iconUrl2 = null;
                        break;
                    } else {
                        socialFeedModelEntityData.iconUrl2 = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 384:
                    if (!z) {
                        socialFeedModelEntityData.description = null;
                        break;
                    } else {
                        socialFeedModelEntityData.description = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 410:
                    if (!z) {
                        socialFeedModelEntityData.id = null;
                        break;
                    } else {
                        socialFeedModelEntityData.id = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 521:
                    if (!z) {
                        socialFeedModelEntityData.redirectValue = null;
                        break;
                    } else {
                        socialFeedModelEntityData.redirectValue = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 566:
                    if (!z) {
                        socialFeedModelEntityData.redirectType = null;
                        break;
                    } else {
                        socialFeedModelEntityData.redirectType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return socialFeedModelEntityData;
    }
}
