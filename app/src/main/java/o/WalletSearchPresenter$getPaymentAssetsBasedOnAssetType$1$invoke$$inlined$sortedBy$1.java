package o;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.featureconfig.model.QueryUserDataConfig;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1 extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private Gson getAuthRequestContext;

    public WalletSearchPresenter$getPaymentAssetsBasedOnAssetType$1$invoke$$inlined$sortedBy$1(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        QueryUserDataConfig queryUserDataConfig = (QueryUserDataConfig) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (queryUserDataConfig != queryUserDataConfig.queryType) {
            j.PlaceComponentResult(jsonWriter, 367);
            access$loadDashboardData access_loaddashboarddata = new access$loadDashboardData();
            List<String> list = queryUserDataConfig.queryType;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, access_loaddashboarddata, list).write(jsonWriter, list);
        }
        j.PlaceComponentResult(jsonWriter, 144);
        jsonWriter.value(queryUserDataConfig.seperatePaylaterChannel);
        j.PlaceComponentResult(jsonWriter, 338);
        jsonWriter.value(queryUserDataConfig.seperateProcessTrans);
        j.PlaceComponentResult(jsonWriter, 256);
        jsonWriter.value(queryUserDataConfig.seperateSurveyInfo);
        j.PlaceComponentResult(jsonWriter, 576);
        jsonWriter.value(queryUserDataConfig.seperateUserInfo);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        QueryUserDataConfig queryUserDataConfig = new QueryUserDataConfig();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 16) {
                if (authRequestContext != 141) {
                    if (authRequestContext != 274) {
                        if (authRequestContext != 406) {
                            if (authRequestContext != 580) {
                                jsonReader.skipValue();
                            } else if (z) {
                                queryUserDataConfig.seperateUserInfo = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                            } else {
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            queryUserDataConfig.seperateSurveyInfo = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        } else {
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        queryUserDataConfig.seperatePaylaterChannel = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                    } else {
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    queryUserDataConfig.seperateProcessTrans = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                } else {
                    jsonReader.nextNull();
                }
            } else if (z) {
                queryUserDataConfig.queryType = (List) gson.getAdapter(new access$loadDashboardData()).read2(jsonReader);
            } else {
                queryUserDataConfig.queryType = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return queryUserDataConfig;
    }
}
