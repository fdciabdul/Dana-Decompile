package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.wallet_v3.model.Rules;
import id.dana.domain.wallet_v3.model.WalletV3RecommendationConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class NearbySearchPresenter$getNearbyTrendingKeyword$1 extends TypeAdapter implements G {
    private Gson MyBillsEntityDataFactory;
    private J PlaceComponentResult;
    private getValueOfTouchPositionAbsolute getAuthRequestContext;

    public NearbySearchPresenter$getNearbyTrendingKeyword$1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.MyBillsEntityDataFactory = gson;
        this.getAuthRequestContext = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        WalletV3RecommendationConfig walletV3RecommendationConfig = (WalletV3RecommendationConfig) obj;
        Gson gson = this.MyBillsEntityDataFactory;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = walletV3RecommendationConfig.btnTitleEn;
        j.PlaceComponentResult(jsonWriter, 274);
        jsonWriter.value(walletV3RecommendationConfig.btnTitleEn);
        String str2 = walletV3RecommendationConfig.btnTitleId;
        j.PlaceComponentResult(jsonWriter, 565);
        jsonWriter.value(walletV3RecommendationConfig.btnTitleId);
        String str3 = walletV3RecommendationConfig.descEn;
        j.PlaceComponentResult(jsonWriter, 122);
        jsonWriter.value(walletV3RecommendationConfig.descEn);
        String str4 = walletV3RecommendationConfig.descId;
        j.PlaceComponentResult(jsonWriter, 291);
        jsonWriter.value(walletV3RecommendationConfig.descId);
        String str5 = walletV3RecommendationConfig.imageUrl;
        j.PlaceComponentResult(jsonWriter, 57);
        jsonWriter.value(walletV3RecommendationConfig.imageUrl);
        if (walletV3RecommendationConfig != walletV3RecommendationConfig.keywords) {
            j.PlaceComponentResult(jsonWriter, 456);
            hideWorkerProperty hideworkerproperty = new hideWorkerProperty();
            List<String> list = walletV3RecommendationConfig.keywords;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, hideworkerproperty, list).write(jsonWriter, list);
        }
        String str6 = walletV3RecommendationConfig.recommendation;
        j.PlaceComponentResult(jsonWriter, 519);
        jsonWriter.value(walletV3RecommendationConfig.recommendation);
        Rules rules = walletV3RecommendationConfig.rules;
        j.PlaceComponentResult(jsonWriter, 183);
        Rules rules2 = walletV3RecommendationConfig.rules;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Rules.class, rules2).write(jsonWriter, rules2);
        String str7 = walletV3RecommendationConfig.titleEn;
        j.PlaceComponentResult(jsonWriter, 112);
        jsonWriter.value(walletV3RecommendationConfig.titleEn);
        String str8 = walletV3RecommendationConfig.titleId;
        j.PlaceComponentResult(jsonWriter, 17);
        jsonWriter.value(walletV3RecommendationConfig.titleId);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        WalletV3RecommendationConfig walletV3RecommendationConfig = new WalletV3RecommendationConfig();
        Gson gson = this.MyBillsEntityDataFactory;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.getAuthRequestContext;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 59) {
                if (authRequestContext != 140) {
                    if (authRequestContext != 154) {
                        if (authRequestContext != 192) {
                            if (authRequestContext != 271) {
                                if (authRequestContext != 312) {
                                    if (authRequestContext != 365) {
                                        if (authRequestContext != 431) {
                                            if (authRequestContext != 491) {
                                                if (authRequestContext != 509) {
                                                    jsonReader.skipValue();
                                                } else if (z) {
                                                    walletV3RecommendationConfig.btnTitleId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                                } else {
                                                    walletV3RecommendationConfig.btnTitleId = null;
                                                    jsonReader.nextNull();
                                                }
                                            } else if (z) {
                                                walletV3RecommendationConfig.keywords = (List) gson.getAdapter(new hideWorkerProperty()).read2(jsonReader);
                                            } else {
                                                walletV3RecommendationConfig.keywords = null;
                                                jsonReader.nextNull();
                                            }
                                        } else if (z) {
                                            walletV3RecommendationConfig.btnTitleEn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                        } else {
                                            walletV3RecommendationConfig.btnTitleEn = null;
                                            jsonReader.nextNull();
                                        }
                                    } else if (z) {
                                        walletV3RecommendationConfig.rules = (Rules) gson.getAdapter(Rules.class).read2(jsonReader);
                                    } else {
                                        walletV3RecommendationConfig.rules = null;
                                        jsonReader.nextNull();
                                    }
                                } else if (z) {
                                    walletV3RecommendationConfig.descEn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                                } else {
                                    walletV3RecommendationConfig.descEn = null;
                                    jsonReader.nextNull();
                                }
                            } else if (z) {
                                walletV3RecommendationConfig.recommendation = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                            } else {
                                walletV3RecommendationConfig.recommendation = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            walletV3RecommendationConfig.descId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        } else {
                            walletV3RecommendationConfig.descId = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        walletV3RecommendationConfig.titleId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                    } else {
                        walletV3RecommendationConfig.titleId = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    walletV3RecommendationConfig.imageUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    walletV3RecommendationConfig.imageUrl = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                walletV3RecommendationConfig.titleEn = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
            } else {
                walletV3RecommendationConfig.titleEn = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return walletV3RecommendationConfig;
    }
}
