package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.image.framework.utils.FileUtils;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.mybills.data.model.request.CreateSubscriptionExtendInfoEntity;
import id.dana.network.response.expresspurchase.MoneyViewEntity;
import java.io.IOException;

/* loaded from: classes5.dex */
public final class clearName extends TypeAdapter implements G {
    private Gson BuiltInFictitiousFunctionClassFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public clearName(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.BuiltInFictitiousFunctionClassFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        CreateSubscriptionExtendInfoEntity createSubscriptionExtendInfoEntity = (CreateSubscriptionExtendInfoEntity) obj;
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = createSubscriptionExtendInfoEntity.billerDenomText;
        j.PlaceComponentResult(jsonWriter, 285);
        jsonWriter.value(createSubscriptionExtendInfoEntity.billerDenomText);
        String str2 = createSubscriptionExtendInfoEntity.cardIndexNo;
        j.PlaceComponentResult(jsonWriter, 136);
        jsonWriter.value(createSubscriptionExtendInfoEntity.cardIndexNo);
        MoneyViewEntity moneyViewEntity = createSubscriptionExtendInfoEntity.denom;
        j.PlaceComponentResult(jsonWriter, 179);
        MoneyViewEntity moneyViewEntity2 = createSubscriptionExtendInfoEntity.denom;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, MoneyViewEntity.class, moneyViewEntity2).write(jsonWriter, moneyViewEntity2);
        String str3 = createSubscriptionExtendInfoEntity.payMode;
        j.PlaceComponentResult(jsonWriter, 556);
        jsonWriter.value(createSubscriptionExtendInfoEntity.payMode);
        String str4 = createSubscriptionExtendInfoEntity.paymentMethod;
        j.PlaceComponentResult(jsonWriter, WSContextConstant.HANDSHAKE_RECEIVE_SIZE);
        jsonWriter.value(createSubscriptionExtendInfoEntity.paymentMethod);
        String str5 = createSubscriptionExtendInfoEntity.productTitle;
        j.PlaceComponentResult(jsonWriter, 496);
        jsonWriter.value(createSubscriptionExtendInfoEntity.productTitle);
        String str6 = createSubscriptionExtendInfoEntity.provider;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_PAGE);
        jsonWriter.value(createSubscriptionExtendInfoEntity.provider);
        String str7 = createSubscriptionExtendInfoEntity.queryUrlProvider;
        j.PlaceComponentResult(jsonWriter, 538);
        jsonWriter.value(createSubscriptionExtendInfoEntity.queryUrlProvider);
        String str8 = createSubscriptionExtendInfoEntity.timezone;
        j.PlaceComponentResult(jsonWriter, 512);
        jsonWriter.value(createSubscriptionExtendInfoEntity.timezone);
        String str9 = createSubscriptionExtendInfoEntity.title;
        j.PlaceComponentResult(jsonWriter, 403);
        jsonWriter.value(createSubscriptionExtendInfoEntity.title);
        MoneyViewEntity moneyViewEntity3 = createSubscriptionExtendInfoEntity.totalAmount;
        j.PlaceComponentResult(jsonWriter, FileUtils.JPEG_MARKER_EOI);
        MoneyViewEntity moneyViewEntity4 = createSubscriptionExtendInfoEntity.totalAmount;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, MoneyViewEntity.class, moneyViewEntity4).write(jsonWriter, moneyViewEntity4);
        String str10 = createSubscriptionExtendInfoEntity.type;
        j.PlaceComponentResult(jsonWriter, 237);
        jsonWriter.value(createSubscriptionExtendInfoEntity.type);
        createSubscriptionExtendInfoEntity.PlaceComponentResult(gson, jsonWriter, j);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        CreateSubscriptionExtendInfoEntity createSubscriptionExtendInfoEntity = new CreateSubscriptionExtendInfoEntity();
        Gson gson = this.BuiltInFictitiousFunctionClassFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 37) {
                if (authRequestContext != 76) {
                    if (authRequestContext != 190) {
                        if (authRequestContext != 283) {
                            if (authRequestContext != 353) {
                                if (authRequestContext != 382) {
                                    if (authRequestContext != 389) {
                                        if (authRequestContext != 448) {
                                            if (authRequestContext != 467) {
                                                if (authRequestContext != 470) {
                                                    if (authRequestContext != 538) {
                                                        if (authRequestContext != 539) {
                                                            createSubscriptionExtendInfoEntity.getAuthRequestContext(gson, jsonReader, authRequestContext);
                                                        } else if (z) {
                                                            createSubscriptionExtendInfoEntity.denom = (MoneyViewEntity) gson.getAdapter(MoneyViewEntity.class).read2(jsonReader);
                                                        } else {
                                                            createSubscriptionExtendInfoEntity.denom = null;
                                                            jsonReader.nextNull();
                                                        }
                                                    } else if (z) {
                                                        createSubscriptionExtendInfoEntity.provider = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                                    } else {
                                                        createSubscriptionExtendInfoEntity.provider = null;
                                                        jsonReader.nextNull();
                                                    }
                                                } else if (z) {
                                                    createSubscriptionExtendInfoEntity.totalAmount = (MoneyViewEntity) gson.getAdapter(MoneyViewEntity.class).read2(jsonReader);
                                                } else {
                                                    createSubscriptionExtendInfoEntity.totalAmount = null;
                                                    jsonReader.nextNull();
                                                }
                                            } else if (z) {
                                                createSubscriptionExtendInfoEntity.billerDenomText = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                            } else {
                                                createSubscriptionExtendInfoEntity.billerDenomText = null;
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            createSubscriptionExtendInfoEntity.payMode = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                        } else {
                                            createSubscriptionExtendInfoEntity.payMode = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        createSubscriptionExtendInfoEntity.productTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                    } else {
                                        createSubscriptionExtendInfoEntity.productTitle = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    createSubscriptionExtendInfoEntity.cardIndexNo = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                } else {
                                    createSubscriptionExtendInfoEntity.cardIndexNo = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                createSubscriptionExtendInfoEntity.paymentMethod = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                createSubscriptionExtendInfoEntity.paymentMethod = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            createSubscriptionExtendInfoEntity.type = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            createSubscriptionExtendInfoEntity.type = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        createSubscriptionExtendInfoEntity.title = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        createSubscriptionExtendInfoEntity.title = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    createSubscriptionExtendInfoEntity.queryUrlProvider = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    createSubscriptionExtendInfoEntity.queryUrlProvider = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                createSubscriptionExtendInfoEntity.timezone = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                createSubscriptionExtendInfoEntity.timezone = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return createSubscriptionExtendInfoEntity;
    }
}
