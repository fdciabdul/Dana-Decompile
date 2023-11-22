package com.alipayplus.mobile.component.domain.model.request;

import com.alipayplus.mobile.component.common.facade.base.MobileEnvInfo;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import o.AppCompatEmojiTextHelper;
import o.J;
import o.NetworkUserEntityData$$ExternalSyntheticLambda0;

/* loaded from: classes2.dex */
public class BaseRpcRequest implements Serializable {
    public MobileEnvInfo envInfo;
    public Map<String, String> extParams = new HashMap();

    public final /* synthetic */ void PlaceComponentResult(Gson gson, JsonWriter jsonWriter, J j) {
        if (this != this.envInfo) {
            j.PlaceComponentResult(jsonWriter, 40);
            MobileEnvInfo mobileEnvInfo = this.envInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, MobileEnvInfo.class, mobileEnvInfo).write(jsonWriter, mobileEnvInfo);
        }
        if (this != this.extParams) {
            j.PlaceComponentResult(jsonWriter, 464);
            NetworkUserEntityData$$ExternalSyntheticLambda0 networkUserEntityData$$ExternalSyntheticLambda0 = new NetworkUserEntityData$$ExternalSyntheticLambda0();
            Map<String, String> map = this.extParams;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, networkUserEntityData$$ExternalSyntheticLambda0, map).write(jsonWriter, map);
        }
    }

    public final /* synthetic */ void getAuthRequestContext(Gson gson, JsonReader jsonReader, int i) {
        boolean z = jsonReader.peek() != JsonToken.NULL;
        if (i == 270) {
            if (z) {
                this.extParams = (Map) gson.getAdapter(new NetworkUserEntityData$$ExternalSyntheticLambda0()).read2(jsonReader);
                return;
            }
            this.extParams = null;
            jsonReader.nextNull();
        } else if (i != 540) {
            jsonReader.skipValue();
        } else if (z) {
            this.envInfo = (MobileEnvInfo) gson.getAdapter(MobileEnvInfo.class).read2(jsonReader);
        } else {
            this.envInfo = null;
            jsonReader.nextNull();
        }
    }
}
