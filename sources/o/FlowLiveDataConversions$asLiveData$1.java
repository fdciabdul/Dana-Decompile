package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.social.model.ShareActivityConfig;
import id.dana.feeds.data.config.model.FeedConfigResult;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class FlowLiveDataConversions$asLiveData$1 extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson getAuthRequestContext;

    public FlowLiveDataConversions$asLiveData$1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
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
        FeedConfigResult feedConfigResult = (FeedConfigResult) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        Integer num = feedConfigResult.activitiesPerRequest;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_ILLEGEL_KEY);
        Integer num2 = feedConfigResult.activitiesPerRequest;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        Integer num3 = feedConfigResult.feedVersion;
        j.PlaceComponentResult(jsonWriter, 240);
        Integer num4 = feedConfigResult.feedVersion;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        Integer num5 = feedConfigResult.homeFeedVersion;
        j.PlaceComponentResult(jsonWriter, 103);
        Integer num6 = feedConfigResult.homeFeedVersion;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num6).write(jsonWriter, num6);
        Integer num7 = feedConfigResult.interval;
        j.PlaceComponentResult(jsonWriter, 74);
        Integer num8 = feedConfigResult.interval;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num8).write(jsonWriter, num8);
        Boolean bool = feedConfigResult.isAddFriendEnabled;
        j.PlaceComponentResult(jsonWriter, 270);
        jsonWriter.value(feedConfigResult.isAddFriendEnabled);
        Boolean bool2 = feedConfigResult.isCreateActivityEnabled;
        j.PlaceComponentResult(jsonWriter, 359);
        jsonWriter.value(feedConfigResult.isCreateActivityEnabled);
        Boolean bool3 = feedConfigResult.isFeedCommentEnabled;
        j.PlaceComponentResult(jsonWriter, 466);
        jsonWriter.value(feedConfigResult.isFeedCommentEnabled);
        Boolean bool4 = feedConfigResult.isFeedEnabled;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_ENTITY_ONLINE_PAGE);
        jsonWriter.value(feedConfigResult.isFeedEnabled);
        Boolean bool5 = feedConfigResult.isFeedNotificationEnabled;
        j.PlaceComponentResult(jsonWriter, 455);
        jsonWriter.value(feedConfigResult.isFeedNotificationEnabled);
        Boolean bool6 = feedConfigResult.isFeedWidgetEnabled;
        j.PlaceComponentResult(jsonWriter, 234);
        jsonWriter.value(feedConfigResult.isFeedWidgetEnabled);
        Boolean bool7 = feedConfigResult.isMaintenance;
        j.PlaceComponentResult(jsonWriter, 611);
        jsonWriter.value(feedConfigResult.isMaintenance);
        Boolean bool8 = feedConfigResult.isRealtimeFeedEnabled;
        j.PlaceComponentResult(jsonWriter, 543);
        jsonWriter.value(feedConfigResult.isRealtimeFeedEnabled);
        Boolean bool9 = feedConfigResult.isReciprocalFeedEnabled;
        j.PlaceComponentResult(jsonWriter, 184);
        jsonWriter.value(feedConfigResult.isReciprocalFeedEnabled);
        Boolean bool10 = feedConfigResult.isReplyCommentEnabled;
        j.PlaceComponentResult(jsonWriter, 131);
        jsonWriter.value(feedConfigResult.isReplyCommentEnabled);
        ShareActivityConfig shareActivityConfig = feedConfigResult.shareActivity;
        j.PlaceComponentResult(jsonWriter, 195);
        ShareActivityConfig shareActivityConfig2 = feedConfigResult.shareActivity;
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
        FeedConfigResult feedConfigResult = new FeedConfigResult();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 29:
                    if (!z) {
                        feedConfigResult.isRealtimeFeedEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isRealtimeFeedEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 54:
                    if (!z) {
                        feedConfigResult.isReplyCommentEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isReplyCommentEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 57:
                    if (!z) {
                        feedConfigResult.activitiesPerRequest = null;
                        break;
                    } else {
                        feedConfigResult.activitiesPerRequest = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 60:
                    if (!z) {
                        feedConfigResult.isAddFriendEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isAddFriendEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 63:
                    if (!z) {
                        feedConfigResult.isFeedWidgetEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isFeedWidgetEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 103:
                    if (!z) {
                        feedConfigResult.homeFeedVersion = null;
                        break;
                    } else {
                        feedConfigResult.homeFeedVersion = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 133:
                    if (!z) {
                        feedConfigResult.isCreateActivityEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isCreateActivityEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 137:
                    if (!z) {
                        feedConfigResult.shareActivity = null;
                        break;
                    } else {
                        feedConfigResult.shareActivity = (ShareActivityConfig) gson.getAdapter(ShareActivityConfig.class).read2(jsonReader);
                        continue;
                    }
                case 162:
                    if (!z) {
                        feedConfigResult.isFeedCommentEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isFeedCommentEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 226:
                    if (!z) {
                        feedConfigResult.isFeedEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isFeedEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 234:
                    if (!z) {
                        feedConfigResult.feedVersion = null;
                        break;
                    } else {
                        feedConfigResult.feedVersion = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 235:
                    if (!z) {
                        feedConfigResult.isFeedNotificationEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isFeedNotificationEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 287:
                    if (!z) {
                        feedConfigResult.interval = null;
                        break;
                    } else {
                        feedConfigResult.interval = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 522:
                    if (!z) {
                        feedConfigResult.isMaintenance = null;
                        break;
                    } else {
                        feedConfigResult.isMaintenance = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 592:
                    if (!z) {
                        feedConfigResult.isReciprocalFeedEnabled = null;
                        break;
                    } else {
                        feedConfigResult.isReciprocalFeedEnabled = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return feedConfigResult;
    }
}
