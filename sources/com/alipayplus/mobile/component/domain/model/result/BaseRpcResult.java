package com.alipayplus.mobile.component.domain.model.result;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import o.AppCompatEmojiTextHelper;
import o.GetContactSyncConfig;
import o.J;
import o.initRecordTimeStamp;

/* loaded from: classes2.dex */
public class BaseRpcResult implements Serializable {
    public String errorCode;
    public String errorMessage;
    public String interaction;
    public String traceId;
    public boolean success = false;
    public Map<String, String> extendInfo = new HashMap();
    public Map<String, String> errorActions = new HashMap();

    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Gson gson, JsonReader jsonReader, int i) {
        boolean z = jsonReader.peek() != JsonToken.NULL;
        if (i == 146) {
            if (!z) {
                this.interaction = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.interaction = jsonReader.nextString();
            } else {
                this.interaction = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 238) {
            if (z) {
                this.success = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
            } else {
                jsonReader.nextNull();
            }
        } else if (i == 289) {
            if (!z) {
                this.errorCode = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.errorCode = jsonReader.nextString();
            } else {
                this.errorCode = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i == 344) {
            if (z) {
                this.extendInfo = (Map) gson.getAdapter(new GetContactSyncConfig()).read2(jsonReader);
                return;
            }
            this.extendInfo = null;
            jsonReader.nextNull();
        } else if (i == 434) {
            if (z) {
                this.errorActions = (Map) gson.getAdapter(new initRecordTimeStamp()).read2(jsonReader);
                return;
            }
            this.errorActions = null;
            jsonReader.nextNull();
        } else if (i == 608) {
            if (!z) {
                this.traceId = null;
                jsonReader.nextNull();
            } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                this.traceId = jsonReader.nextString();
            } else {
                this.traceId = Boolean.toString(jsonReader.nextBoolean());
            }
        } else if (i != 614) {
            jsonReader.skipValue();
        } else if (!z) {
            this.errorMessage = null;
            jsonReader.nextNull();
        } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
            this.errorMessage = jsonReader.nextString();
        } else {
            this.errorMessage = Boolean.toString(jsonReader.nextBoolean());
        }
    }

    public final /* synthetic */ void PlaceComponentResult(Gson gson, JsonWriter jsonWriter, J j) {
        if (this != this.errorActions) {
            j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_WHITE_SCREEN);
            initRecordTimeStamp initrecordtimestamp = new initRecordTimeStamp();
            Map<String, String> map = this.errorActions;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, initrecordtimestamp, map).write(jsonWriter, map);
        }
        if (this != this.errorCode) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_FAILED);
            jsonWriter.value(this.errorCode);
        }
        if (this != this.errorMessage) {
            j.PlaceComponentResult(jsonWriter, 211);
            jsonWriter.value(this.errorMessage);
        }
        if (this != this.extendInfo) {
            j.PlaceComponentResult(jsonWriter, 214);
            GetContactSyncConfig getContactSyncConfig = new GetContactSyncConfig();
            Map<String, String> map2 = this.extendInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, getContactSyncConfig, map2).write(jsonWriter, map2);
        }
        if (this != this.interaction) {
            j.PlaceComponentResult(jsonWriter, 595);
            jsonWriter.value(this.interaction);
        }
        j.PlaceComponentResult(jsonWriter, 428);
        jsonWriter.value(this.success);
        if (this != this.traceId) {
            j.PlaceComponentResult(jsonWriter, 550);
            jsonWriter.value(this.traceId);
        }
    }
}
