package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.referralwidget.model.ReferralWidgetResult;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ListPopupWindow$Api29Impl extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private Gson getAuthRequestContext;

    public ListPopupWindow$Api29Impl(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.BuiltInFictitiousFunctionClassFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ReferralWidgetResult referralWidgetResult = (ReferralWidgetResult) obj;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(referralWidgetResult.enable);
        if (referralWidgetResult != referralWidgetResult.key) {
            j.PlaceComponentResult(jsonWriter, 318);
            jsonWriter.value(referralWidgetResult.key);
        }
        if (referralWidgetResult != referralWidgetResult.redirectUrl) {
            j.PlaceComponentResult(jsonWriter, 467);
            jsonWriter.value(referralWidgetResult.redirectUrl);
        }
        if (referralWidgetResult != referralWidgetResult.title) {
            j.PlaceComponentResult(jsonWriter, 403);
            jsonWriter.value(referralWidgetResult.title);
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
        ReferralWidgetResult referralWidgetResult = new ReferralWidgetResult();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.BuiltInFictitiousFunctionClassFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 72) {
                if (authRequestContext != 175) {
                    if (authRequestContext != 190) {
                        if (authRequestContext != 360) {
                            jsonReader.skipValue();
                        } else if (z) {
                            referralWidgetResult.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            referralWidgetResult.redirectUrl = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        referralWidgetResult.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        referralWidgetResult.title = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    referralWidgetResult.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                referralWidgetResult.key = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                referralWidgetResult.key = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return referralWidgetResult;
    }
}
