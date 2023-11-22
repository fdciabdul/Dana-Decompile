package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.h5event.sendmoney.Attributes;
import id.dana.data.h5event.sendmoney.PayQueryResponse;
import java.io.IOException;

/* loaded from: classes4.dex */
public final class ContentDeliveryCacheEntityDataFactory extends TypeAdapter implements G {
    private Gson KClassImpl$Data$declaredNonStaticMembers$2;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J getAuthRequestContext;

    public ContentDeliveryCacheEntityDataFactory(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.getAuthRequestContext = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        PayQueryResponse payQueryResponse = (PayQueryResponse) obj;
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        J j = this.getAuthRequestContext;
        jsonWriter.beginObject();
        Attributes attributes = payQueryResponse.attributes;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED);
        Attributes attributes2 = payQueryResponse.attributes;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Attributes.class, attributes2).write(jsonWriter, attributes2);
        String str = payQueryResponse.cashierOrderId;
        j.PlaceComponentResult(jsonWriter, 107);
        jsonWriter.value(payQueryResponse.cashierOrderId);
        String str2 = payQueryResponse.errorCode;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED);
        jsonWriter.value(payQueryResponse.errorCode);
        String str3 = payQueryResponse.errorMsg;
        j.PlaceComponentResult(jsonWriter, 551);
        jsonWriter.value(payQueryResponse.errorMsg);
        String str4 = payQueryResponse.oauthRedirectUrl;
        j.PlaceComponentResult(jsonWriter, 200);
        jsonWriter.value(payQueryResponse.oauthRedirectUrl);
        String str5 = payQueryResponse.redirectUrl;
        j.PlaceComponentResult(jsonWriter, 467);
        jsonWriter.value(payQueryResponse.redirectUrl);
        Boolean bool = payQueryResponse.success;
        j.PlaceComponentResult(jsonWriter, 428);
        jsonWriter.value(payQueryResponse.success);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        PayQueryResponse payQueryResponse = new PayQueryResponse();
        Gson gson = this.KClassImpl$Data$declaredNonStaticMembers$2;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 108) {
                if (authRequestContext != 185) {
                    if (authRequestContext != 238) {
                        if (authRequestContext != 289) {
                            if (authRequestContext != 360) {
                                if (authRequestContext != 364) {
                                    if (authRequestContext != 517) {
                                        jsonReader.skipValue();
                                    } else if (z) {
                                        payQueryResponse.errorMsg = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        payQueryResponse.errorMsg = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    payQueryResponse.attributes = (Attributes) gson.getAdapter(Attributes.class).read2(jsonReader);
                                } else {
                                    payQueryResponse.attributes = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                payQueryResponse.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                payQueryResponse.redirectUrl = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            payQueryResponse.errorCode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            payQueryResponse.errorCode = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        payQueryResponse.success = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                    } else {
                        payQueryResponse.success = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    payQueryResponse.cashierOrderId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    payQueryResponse.cashierOrderId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                payQueryResponse.oauthRedirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                payQueryResponse.oauthRedirectUrl = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return payQueryResponse;
    }
}
