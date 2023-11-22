package com.alipayplus.mobile.component.common.facade.base;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import o.AppCompatEmojiTextHelper;
import o.J;
import o.lookAheadTest;

/* loaded from: classes2.dex */
public class MobileEnvInfo implements Serializable {
    public String LBSType;
    public String LBSUpdateTime;
    public String appVersion;
    public String cashierSdkVersion;
    public String channel;
    public String clientIp;
    public String clientKey;
    public String deliveryToken;
    public Map<String, String> extendInfo = new HashMap();
    public String imei;
    public String imsi;
    public String latitude;
    public String locale;
    public MobileEnvLocationInfo locationInfo;
    public String longitude;
    public String model;
    public String networkType;
    public String orderTerminalType;
    public String osType;
    public String osVersion;
    public String sdkVersion;
    public String sourcePlatForm;
    public String terminalType;
    public int thirdChannel;
    public String thirdChannelDeviceToken;
    public String tokenId;

    public final /* synthetic */ void BuiltInFictitiousFunctionClassFactory(Gson gson, JsonWriter jsonWriter, J j) {
        if (this != this.LBSType) {
            j.PlaceComponentResult(jsonWriter, 30);
            jsonWriter.value(this.LBSType);
        }
        if (this != this.LBSUpdateTime) {
            j.PlaceComponentResult(jsonWriter, 335);
            jsonWriter.value(this.LBSUpdateTime);
        }
        if (this != this.appVersion) {
            j.PlaceComponentResult(jsonWriter, 61);
            jsonWriter.value(this.appVersion);
        }
        if (this != this.cashierSdkVersion) {
            j.PlaceComponentResult(jsonWriter, 597);
            jsonWriter.value(this.cashierSdkVersion);
        }
        if (this != this.channel) {
            j.PlaceComponentResult(jsonWriter, 490);
            jsonWriter.value(this.channel);
        }
        if (this != this.clientIp) {
            j.PlaceComponentResult(jsonWriter, 198);
            jsonWriter.value(this.clientIp);
        }
        if (this != this.clientKey) {
            j.PlaceComponentResult(jsonWriter, 364);
            jsonWriter.value(this.clientKey);
        }
        if (this != this.deliveryToken) {
            j.PlaceComponentResult(jsonWriter, 420);
            jsonWriter.value(this.deliveryToken);
        }
        if (this != this.extendInfo) {
            j.PlaceComponentResult(jsonWriter, 214);
            lookAheadTest lookaheadtest = new lookAheadTest();
            Map<String, String> map = this.extendInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, lookaheadtest, map).write(jsonWriter, map);
        }
        if (this != this.imei) {
            j.PlaceComponentResult(jsonWriter, 235);
            jsonWriter.value(this.imei);
        }
        if (this != this.imsi) {
            j.PlaceComponentResult(jsonWriter, 374);
            jsonWriter.value(this.imsi);
        }
        if (this != this.latitude) {
            j.PlaceComponentResult(jsonWriter, 503);
            jsonWriter.value(this.latitude);
        }
        if (this != this.locale) {
            j.PlaceComponentResult(jsonWriter, 135);
            jsonWriter.value(this.locale);
        }
        if (this != this.locationInfo) {
            j.PlaceComponentResult(jsonWriter, 295);
            MobileEnvLocationInfo mobileEnvLocationInfo = this.locationInfo;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, MobileEnvLocationInfo.class, mobileEnvLocationInfo).write(jsonWriter, mobileEnvLocationInfo);
        }
        if (this != this.longitude) {
            j.PlaceComponentResult(jsonWriter, 583);
            jsonWriter.value(this.longitude);
        }
        if (this != this.model) {
            j.PlaceComponentResult(jsonWriter, 4);
            jsonWriter.value(this.model);
        }
        if (this != this.networkType) {
            j.PlaceComponentResult(jsonWriter, 577);
            jsonWriter.value(this.networkType);
        }
        if (this != this.orderTerminalType) {
            j.PlaceComponentResult(jsonWriter, 115);
            jsonWriter.value(this.orderTerminalType);
        }
        if (this != this.osType) {
            j.PlaceComponentResult(jsonWriter, 485);
            jsonWriter.value(this.osType);
        }
        if (this != this.osVersion) {
            j.PlaceComponentResult(jsonWriter, 293);
            jsonWriter.value(this.osVersion);
        }
        if (this != this.sdkVersion) {
            j.PlaceComponentResult(jsonWriter, 19);
            jsonWriter.value(this.sdkVersion);
        }
        if (this != this.sourcePlatForm) {
            j.PlaceComponentResult(jsonWriter, 424);
            jsonWriter.value(this.sourcePlatForm);
        }
        if (this != this.terminalType) {
            j.PlaceComponentResult(jsonWriter, 277);
            jsonWriter.value(this.terminalType);
        }
        j.PlaceComponentResult(jsonWriter, 80);
        jsonWriter.value(Integer.valueOf(this.thirdChannel));
        if (this != this.thirdChannelDeviceToken) {
            j.PlaceComponentResult(jsonWriter, 393);
            jsonWriter.value(this.thirdChannelDeviceToken);
        }
        if (this != this.tokenId) {
            j.PlaceComponentResult(jsonWriter, 239);
            jsonWriter.value(this.tokenId);
        }
    }

    public final /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(Gson gson, JsonReader jsonReader, int i) {
        boolean z = jsonReader.peek() != JsonToken.NULL;
        switch (i) {
            case 13:
                if (!z) {
                    this.locale = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.locale = jsonReader.nextString();
                    return;
                } else {
                    this.locale = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 28:
                if (!z) {
                    this.appVersion = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.appVersion = jsonReader.nextString();
                    return;
                } else {
                    this.appVersion = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 82:
                if (!z) {
                    this.osType = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.osType = jsonReader.nextString();
                    return;
                } else {
                    this.osType = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 84:
                if (!z) {
                    this.imsi = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.imsi = jsonReader.nextString();
                    return;
                } else {
                    this.imsi = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 89:
                if (!z) {
                    this.LBSType = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.LBSType = jsonReader.nextString();
                    return;
                } else {
                    this.LBSType = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 106:
                if (!z) {
                    this.networkType = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.networkType = jsonReader.nextString();
                    return;
                } else {
                    this.networkType = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 148:
                if (!z) {
                    this.cashierSdkVersion = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.cashierSdkVersion = jsonReader.nextString();
                    return;
                } else {
                    this.cashierSdkVersion = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case TarHeader.USTAR_FILENAME_PREFIX /* 155 */:
                if (!z) {
                    this.osVersion = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.osVersion = jsonReader.nextString();
                    return;
                } else {
                    this.osVersion = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 165:
                if (!z) {
                    this.thirdChannelDeviceToken = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.thirdChannelDeviceToken = jsonReader.nextString();
                    return;
                } else {
                    this.thirdChannelDeviceToken = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 166:
                if (!z) {
                    this.tokenId = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.tokenId = jsonReader.nextString();
                    return;
                } else {
                    this.tokenId = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 173:
                if (!z) {
                    this.LBSUpdateTime = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.LBSUpdateTime = jsonReader.nextString();
                    return;
                } else {
                    this.LBSUpdateTime = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 183:
                if (!z) {
                    this.deliveryToken = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.deliveryToken = jsonReader.nextString();
                    return;
                } else {
                    this.deliveryToken = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 243:
                if (!z) {
                    this.clientKey = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.clientKey = jsonReader.nextString();
                    return;
                } else {
                    this.clientKey = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 253:
                if (!z) {
                    this.longitude = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.longitude = jsonReader.nextString();
                    return;
                } else {
                    this.longitude = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 280:
                if (z) {
                    this.locationInfo = (MobileEnvLocationInfo) gson.getAdapter(MobileEnvLocationInfo.class).read2(jsonReader);
                    return;
                }
                this.locationInfo = null;
                jsonReader.nextNull();
                return;
            case 328:
                if (!z) {
                    this.sourcePlatForm = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.sourcePlatForm = jsonReader.nextString();
                    return;
                } else {
                    this.sourcePlatForm = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 344:
                if (z) {
                    this.extendInfo = (Map) gson.getAdapter(new lookAheadTest()).read2(jsonReader);
                    return;
                }
                this.extendInfo = null;
                jsonReader.nextNull();
                return;
            case 347:
                if (!z) {
                    jsonReader.nextNull();
                    return;
                }
                try {
                    this.thirdChannel = jsonReader.nextInt();
                    return;
                } catch (NumberFormatException e) {
                    throw new JsonSyntaxException(e);
                }
            case 370:
                if (!z) {
                    this.terminalType = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.terminalType = jsonReader.nextString();
                    return;
                } else {
                    this.terminalType = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 374:
                if (!z) {
                    this.sdkVersion = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.sdkVersion = jsonReader.nextString();
                    return;
                } else {
                    this.sdkVersion = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 408:
                if (!z) {
                    this.model = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.model = jsonReader.nextString();
                    return;
                } else {
                    this.model = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 412:
                if (!z) {
                    this.latitude = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.latitude = jsonReader.nextString();
                    return;
                } else {
                    this.latitude = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 419:
                if (!z) {
                    this.channel = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.channel = jsonReader.nextString();
                    return;
                } else {
                    this.channel = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case WebSocket.DEFAULT_WSS_PORT /* 443 */:
                if (!z) {
                    this.clientIp = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.clientIp = jsonReader.nextString();
                    return;
                } else {
                    this.clientIp = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 533:
                if (!z) {
                    this.orderTerminalType = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.orderTerminalType = jsonReader.nextString();
                    return;
                } else {
                    this.orderTerminalType = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            case 597:
                if (!z) {
                    this.imei = null;
                    jsonReader.nextNull();
                    return;
                } else if (jsonReader.peek() != JsonToken.BOOLEAN) {
                    this.imei = jsonReader.nextString();
                    return;
                } else {
                    this.imei = Boolean.toString(jsonReader.nextBoolean());
                    return;
                }
            default:
                jsonReader.skipValue();
                return;
        }
    }
}
