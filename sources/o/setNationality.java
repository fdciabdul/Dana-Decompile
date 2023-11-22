package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.feeds.domain.timeline.model.ActivityWidget;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes5.dex */
public final class setNationality extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private Gson MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public setNationality(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ActivityWidget activityWidget = (ActivityWidget) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        if (activityWidget != activityWidget.extendInfo) {
            j.PlaceComponentResult(jsonWriter, 214);
            CaptureStatus captureStatus = new CaptureStatus();
            HashMap<String, Object> hashMap = activityWidget.extendInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, captureStatus, hashMap).write(jsonWriter, hashMap);
        }
        String str = activityWidget.iconUrl;
        j.PlaceComponentResult(jsonWriter, 454);
        jsonWriter.value(activityWidget.iconUrl);
        String str2 = activityWidget.redirectType;
        j.PlaceComponentResult(jsonWriter, 22);
        jsonWriter.value(activityWidget.redirectType);
        String str3 = activityWidget.redirectValue;
        j.PlaceComponentResult(jsonWriter, 262);
        jsonWriter.value(activityWidget.redirectValue);
        String str4 = activityWidget.subtitleType;
        j.PlaceComponentResult(jsonWriter, 447);
        jsonWriter.value(activityWidget.subtitleType);
        String str5 = activityWidget.subtitleValue;
        j.PlaceComponentResult(jsonWriter, 6);
        jsonWriter.value(activityWidget.subtitleValue);
        String str6 = activityWidget.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(activityWidget.title);
        j.PlaceComponentResult(jsonWriter, 549);
        jsonWriter.value(activityWidget.uniqueValue);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ActivityWidget activityWidget = new ActivityWidget();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 9) {
                if (authRequestContext != 134) {
                    if (authRequestContext != 190) {
                        if (authRequestContext != 257) {
                            if (authRequestContext != 344) {
                                if (authRequestContext != 513) {
                                    if (authRequestContext != 521) {
                                        if (authRequestContext != 566) {
                                            jsonReader.skipValue();
                                        } else if (z) {
                                            activityWidget.redirectType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                        } else {
                                            activityWidget.redirectType = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        activityWidget.redirectValue = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        activityWidget.redirectValue = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    activityWidget.uniqueValue = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                                } else {
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                activityWidget.extendInfo = (HashMap) gson.getAdapter(new CaptureStatus()).read2(jsonReader);
                            } else {
                                activityWidget.extendInfo = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            activityWidget.iconUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            activityWidget.iconUrl = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        activityWidget.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        activityWidget.title = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    activityWidget.subtitleType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    activityWidget.subtitleType = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                activityWidget.subtitleValue = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                activityWidget.subtitleValue = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return activityWidget;
    }
}
