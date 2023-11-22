package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.wallet.acl.base.Callback;
import com.alipay.iap.android.wallet.acl.oauth.OAuthCodeFlowType;
import com.alipay.iap.android.wallet.acl.oauth.OAuthResult;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.globalnetwork.model.GnAuthResult;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/* loaded from: classes4.dex */
public final class onGetActiveNotifications extends TypeAdapter implements G {
    private J BuiltInFictitiousFunctionClassFactory;
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private Gson PlaceComponentResult;

    public onGetActiveNotifications(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.PlaceComponentResult = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.BuiltInFictitiousFunctionClassFactory = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        GnAuthResult gnAuthResult = (GnAuthResult) obj;
        Gson gson = this.PlaceComponentResult;
        J j = this.BuiltInFictitiousFunctionClassFactory;
        jsonWriter.beginObject();
        if (gnAuthResult != gnAuthResult.callback) {
            j.PlaceComponentResult(jsonWriter, 147);
            NearbyConstantsKt nearbyConstantsKt = new NearbyConstantsKt();
            Callback<OAuthResult> callback = gnAuthResult.callback;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, nearbyConstantsKt, callback).write(jsonWriter, callback);
        }
        String str = gnAuthResult.clientId;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED);
        jsonWriter.value(gnAuthResult.clientId);
        if (gnAuthResult != gnAuthResult.extendInfo) {
            j.PlaceComponentResult(jsonWriter, 214);
            setRibbonLineTopText setribbonlinetoptext = new setRibbonLineTopText();
            Map<String, String> map = gnAuthResult.extendInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, setribbonlinetoptext, map).write(jsonWriter, map);
        }
        OAuthCodeFlowType oAuthCodeFlowType = gnAuthResult.oAuthCodeFlowType;
        j.PlaceComponentResult(jsonWriter, 166);
        OAuthCodeFlowType oAuthCodeFlowType2 = gnAuthResult.oAuthCodeFlowType;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, OAuthCodeFlowType.class, oAuthCodeFlowType2).write(jsonWriter, oAuthCodeFlowType2);
        if (gnAuthResult != gnAuthResult.scopes) {
            j.PlaceComponentResult(jsonWriter, 392);
            access$showKycAmlEddDialog access_showkycamledddialog = new access$showKycAmlEddDialog();
            Set<String> set = gnAuthResult.scopes;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, access_showkycamledddialog, set).write(jsonWriter, set);
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
        GnAuthResult gnAuthResult = new GnAuthResult();
        Gson gson = this.PlaceComponentResult;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            if (authRequestContext != 125) {
                if (authRequestContext != 306) {
                    if (authRequestContext != 326) {
                        if (authRequestContext != 344) {
                            if (authRequestContext != 369) {
                                jsonReader.skipValue();
                            } else if (z) {
                                gnAuthResult.oAuthCodeFlowType = (OAuthCodeFlowType) gson.getAdapter(OAuthCodeFlowType.class).read2(jsonReader);
                            } else {
                                gnAuthResult.oAuthCodeFlowType = null;
                                jsonReader.nextNull();
                            }
                        } else if (z) {
                            gnAuthResult.extendInfo = (Map) gson.getAdapter(new setRibbonLineTopText()).read2(jsonReader);
                        } else {
                            gnAuthResult.extendInfo = null;
                            jsonReader.nextNull();
                        }
                    } else if (z) {
                        gnAuthResult.callback = (Callback) gson.getAdapter(new NearbyConstantsKt()).read2(jsonReader);
                    } else {
                        gnAuthResult.callback = null;
                        jsonReader.nextNull();
                    }
                } else if (z) {
                    gnAuthResult.clientId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                } else {
                    gnAuthResult.clientId = null;
                    jsonReader.nextNull();
                }
            } else if (z) {
                gnAuthResult.scopes = (Set) gson.getAdapter(new access$showKycAmlEddDialog()).read2(jsonReader);
            } else {
                gnAuthResult.scopes = null;
                jsonReader.nextNull();
            }
        }
        jsonReader.endObject();
        return gnAuthResult;
    }
}
