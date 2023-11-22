package o;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.social.model.ShareActivityConfig;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ViewPayConfirmationAddOnBinding extends TypeAdapter implements G {
    private J MyBillsEntityDataFactory;
    private getValueOfTouchPositionAbsolute PlaceComponentResult;
    private Gson getAuthRequestContext;

    public ViewPayConfirmationAddOnBinding(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.PlaceComponentResult = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ShareActivityConfig shareActivityConfig = (ShareActivityConfig) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        j.PlaceComponentResult(jsonWriter, 581);
        jsonWriter.value(Integer.valueOf(shareActivityConfig.bannerLimit));
        j.PlaceComponentResult(jsonWriter, 425);
        jsonWriter.value(shareActivityConfig.feedOnlineMerchantBanner);
        j.PlaceComponentResult(jsonWriter, 491);
        jsonWriter.value(shareActivityConfig.paymentSuccess);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ShareActivityConfig shareActivityConfig = new ShareActivityConfig();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.PlaceComponentResult;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 14) {
                if (authRequestContext != 561) {
                    if (authRequestContext != 589) {
                        jsonReader.skipValue();
                    } else if (z) {
                        shareActivityConfig.paymentSuccess = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    shareActivityConfig.feedOnlineMerchantBanner = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                try {
                    shareActivityConfig.bannerLimit = jsonReader.nextInt();
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            } else {
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return shareActivityConfig;
    }
}
