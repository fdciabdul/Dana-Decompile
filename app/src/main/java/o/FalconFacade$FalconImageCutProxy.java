package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alipay.mobile.verifyidentity.business.securitycommon.widget.WheelView;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.mybills.data.model.response.ExtendInfoQuerySubscriptionResult;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class FalconFacade$FalconImageCutProxy extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public FalconFacade$FalconImageCutProxy(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.MyBillsEntityDataFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ExtendInfoQuerySubscriptionResult extendInfoQuerySubscriptionResult = (ExtendInfoQuerySubscriptionResult) obj;
        J j = this.MyBillsEntityDataFactory;
        jsonWriter.beginObject();
        String str = extendInfoQuerySubscriptionResult.nickname;
        j.PlaceComponentResult(jsonWriter, WheelView.DIVIDER_ALPHA);
        jsonWriter.value(extendInfoQuerySubscriptionResult.nickname);
        String str2 = extendInfoQuerySubscriptionResult.provider;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_PAGE);
        jsonWriter.value(extendInfoQuerySubscriptionResult.provider);
        String str3 = extendInfoQuerySubscriptionResult.totalAmount;
        j.PlaceComponentResult(jsonWriter, FileUtils.JPEG_MARKER_EOI);
        jsonWriter.value(extendInfoQuerySubscriptionResult.totalAmount);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ExtendInfoQuerySubscriptionResult extendInfoQuerySubscriptionResult = new ExtendInfoQuerySubscriptionResult();
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 470) {
                if (authRequestContext != 538) {
                    if (authRequestContext != 557) {
                        jsonReader.skipValue();
                    } else if (z) {
                        extendInfoQuerySubscriptionResult.nickname = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        extendInfoQuerySubscriptionResult.nickname = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    extendInfoQuerySubscriptionResult.provider = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    extendInfoQuerySubscriptionResult.provider = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                extendInfoQuerySubscriptionResult.totalAmount = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                extendInfoQuerySubscriptionResult.totalAmount = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return extendInfoQuerySubscriptionResult;
    }
}
