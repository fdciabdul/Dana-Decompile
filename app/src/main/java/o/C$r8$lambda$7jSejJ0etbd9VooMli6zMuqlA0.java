package o;

import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.feeds.model.ActivityEntity;
import java.io.IOException;

/* renamed from: o.$r8$lambda$7jSe-jJ0etbd9VooMli6zMuqlA0  reason: invalid class name */
/* loaded from: classes4.dex */
public final class C$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;
    private Gson getAuthRequestContext;

    public C$r8$lambda$7jSejJ0etbd9VooMli6zMuqlA0(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ActivityEntity activityEntity = (ActivityEntity) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        if (activityEntity != activityEntity.activityContent) {
            j.PlaceComponentResult(jsonWriter, 62);
            jsonWriter.value(activityEntity.activityContent);
        }
        if (activityEntity != activityEntity.activityId) {
            j.PlaceComponentResult(jsonWriter, 33);
            jsonWriter.value(activityEntity.activityId);
        }
        if (activityEntity != activityEntity.activityTitle) {
            j.PlaceComponentResult(jsonWriter, 483);
            jsonWriter.value(activityEntity.activityTitle);
        }
        if (activityEntity != activityEntity.actorAvatar) {
            j.PlaceComponentResult(jsonWriter, 252);
            jsonWriter.value(activityEntity.actorAvatar);
        }
        if (activityEntity != activityEntity.actorNickname) {
            j.PlaceComponentResult(jsonWriter, 302);
            jsonWriter.value(activityEntity.actorNickname);
        }
        if (activityEntity != activityEntity.bizType) {
            j.PlaceComponentResult(jsonWriter, 79);
            jsonWriter.value(activityEntity.bizType);
        }
        j.PlaceComponentResult(jsonWriter, 94);
        jsonWriter.value(activityEntity.clickable);
        if (activityEntity != activityEntity.content) {
            j.PlaceComponentResult(jsonWriter, 175);
            jsonWriter.value(activityEntity.content);
        }
        j.PlaceComponentResult(jsonWriter, 225);
        Class cls = Long.TYPE;
        Long valueOf = Long.valueOf(activityEntity.createdTime);
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, cls, valueOf).write(jsonWriter, valueOf);
        if (activityEntity != activityEntity.feedType) {
            j.PlaceComponentResult(jsonWriter, 554);
            jsonWriter.value(activityEntity.feedType);
        }
        if (activityEntity != activityEntity.imageUrl) {
            j.PlaceComponentResult(jsonWriter, 92);
            jsonWriter.value(activityEntity.imageUrl);
        }
        if (activityEntity != activityEntity.redirectUrl) {
            j.PlaceComponentResult(jsonWriter, 467);
            jsonWriter.value(activityEntity.redirectUrl);
        }
        if (activityEntity != activityEntity.targetNickname) {
            j.PlaceComponentResult(jsonWriter, 54);
            jsonWriter.value(activityEntity.targetNickname);
        }
        if (activityEntity != activityEntity.verb) {
            j.PlaceComponentResult(jsonWriter, 255);
            jsonWriter.value(activityEntity.verb);
        }
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ActivityEntity activityEntity = new ActivityEntity();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 40:
                    if (!z) {
                        activityEntity.actorNickname = null;
                        break;
                    } else {
                        activityEntity.actorNickname = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 45:
                    if (!z) {
                        activityEntity.feedType = null;
                        break;
                    } else {
                        activityEntity.feedType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 85:
                    if (!z) {
                        activityEntity.bizType = null;
                        break;
                    } else {
                        activityEntity.bizType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 139:
                    if (!z) {
                        activityEntity.activityContent = null;
                        break;
                    } else {
                        activityEntity.activityContent = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 202:
                    if (!z) {
                        activityEntity.activityId = null;
                        break;
                    } else {
                        activityEntity.activityId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 208:
                    if (!z) {
                        activityEntity.verb = null;
                        break;
                    } else {
                        activityEntity.verb = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 240:
                    if (!z) {
                        activityEntity.activityTitle = null;
                        break;
                    } else {
                        activityEntity.activityTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 295:
                    if (!z) {
                        activityEntity.imageUrl = null;
                        break;
                    } else {
                        activityEntity.imageUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 315:
                    if (!z) {
                        break;
                    } else {
                        activityEntity.createdTime = ((Long) gson.getAdapter(Long.class).read2(jsonReader)).longValue();
                        continue;
                    }
                case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                    if (!z) {
                        activityEntity.redirectUrl = null;
                        break;
                    } else {
                        activityEntity.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 363:
                    if (!z) {
                        break;
                    } else {
                        activityEntity.clickable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 372:
                    if (!z) {
                        activityEntity.targetNickname = null;
                        break;
                    } else {
                        activityEntity.targetNickname = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 383:
                    if (!z) {
                        activityEntity.actorAvatar = null;
                        break;
                    } else {
                        activityEntity.actorAvatar = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_DYN_ENC_UNKNOWN_ERROR /* 499 */:
                    if (!z) {
                        activityEntity.content = null;
                        break;
                    } else {
                        activityEntity.content = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return activityEntity;
    }
}
