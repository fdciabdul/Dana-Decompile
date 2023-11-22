package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.social.model.FeedConfig;
import id.dana.domain.social.model.ShareActivityConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class AttributeView extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;

    public AttributeView(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        FeedConfig feedConfig = (FeedConfig) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_ILLEGEL_KEY);
        jsonWriter.value(Integer.valueOf(feedConfig.activitiesPerRequest));
        j.PlaceComponentResult(jsonWriter, 240);
        jsonWriter.value(Integer.valueOf(feedConfig.feedVersion));
        j.PlaceComponentResult(jsonWriter, 103);
        jsonWriter.value(Integer.valueOf(feedConfig.homeFeedVersion));
        j.PlaceComponentResult(jsonWriter, 74);
        jsonWriter.value(Integer.valueOf(feedConfig.interval));
        j.PlaceComponentResult(jsonWriter, 270);
        jsonWriter.value(feedConfig.isAddFriendEnabled);
        j.PlaceComponentResult(jsonWriter, 359);
        jsonWriter.value(feedConfig.isCreateActivityEnabled);
        j.PlaceComponentResult(jsonWriter, 466);
        jsonWriter.value(feedConfig.isFeedCommentEnabled);
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE);
        jsonWriter.value(feedConfig.isFeedEnabled);
        j.PlaceComponentResult(jsonWriter, 455);
        jsonWriter.value(feedConfig.isFeedNotificationEnabled);
        j.PlaceComponentResult(jsonWriter, 234);
        jsonWriter.value(feedConfig.isFeedWidgetEnabled);
        j.PlaceComponentResult(jsonWriter, 611);
        jsonWriter.value(feedConfig.isMaintenance);
        j.PlaceComponentResult(jsonWriter, 543);
        jsonWriter.value(feedConfig.isRealtimeFeedEnabled);
        j.PlaceComponentResult(jsonWriter, 184);
        jsonWriter.value(feedConfig.isReciprocalFeedEnabled);
        j.PlaceComponentResult(jsonWriter, 131);
        jsonWriter.value(feedConfig.isReplyCommentEnabled);
        ShareActivityConfig shareActivityConfig = feedConfig.shareActivity;
        j.PlaceComponentResult(jsonWriter, 195);
        ShareActivityConfig shareActivityConfig2 = feedConfig.shareActivity;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, ShareActivityConfig.class, shareActivityConfig2).write(jsonWriter, shareActivityConfig2);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        FeedConfig feedConfig = new FeedConfig();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 29:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isRealtimeFeedEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 54:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isReplyCommentEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 57:
                    if (!z) {
                        break;
                    } else {
                        try {
                            feedConfig.activitiesPerRequest = jsonReader.nextInt();
                            continue;
                        } catch (NumberFormatException e) {
                            throw new JsonSyntaxException(e);
                        }
                    }
                case 60:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isAddFriendEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 63:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isFeedWidgetEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 103:
                    if (!z) {
                        break;
                    } else {
                        try {
                            feedConfig.homeFeedVersion = jsonReader.nextInt();
                            continue;
                        } catch (NumberFormatException e2) {
                            throw new JsonSyntaxException(e2);
                        }
                    }
                case 133:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isCreateActivityEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 137:
                    if (!z) {
                        feedConfig.shareActivity = null;
                        break;
                    } else {
                        feedConfig.shareActivity = (ShareActivityConfig) gson.getAdapter(ShareActivityConfig.class).read2(jsonReader);
                        continue;
                    }
                case 162:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isFeedCommentEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 226:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isFeedEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 234:
                    if (!z) {
                        break;
                    } else {
                        try {
                            feedConfig.feedVersion = jsonReader.nextInt();
                            continue;
                        } catch (NumberFormatException e3) {
                            throw new JsonSyntaxException(e3);
                        }
                    }
                case 235:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isFeedNotificationEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 287:
                    if (!z) {
                        break;
                    } else {
                        try {
                            feedConfig.interval = jsonReader.nextInt();
                            continue;
                        } catch (NumberFormatException e4) {
                            throw new JsonSyntaxException(e4);
                        }
                    }
                case 522:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isMaintenance = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 592:
                    if (!z) {
                        break;
                    } else {
                        feedConfig.isReciprocalFeedEnabled = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return feedConfig;
    }
}
