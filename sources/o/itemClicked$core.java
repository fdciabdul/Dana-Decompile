package o;

import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.iap.android.aplog.util.zip.LZMA_Base;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.data.here.HereOauthManager;
import id.dana.data.homeinfo.model.BannerLottieEntity;
import id.dana.data.homeinfo.model.SkuAttributeEntity;
import id.dana.data.homeinfo.model.ThirdPartyEntity;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class itemClicked$core extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute KClassImpl$Data$declaredNonStaticMembers$2;
    private J PlaceComponentResult;
    private Gson getAuthRequestContext;

    public itemClicked$core(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        ThirdPartyEntity thirdPartyEntity = (ThirdPartyEntity) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        String str = thirdPartyEntity.action;
        j.PlaceComponentResult(jsonWriter, 438);
        jsonWriter.value(thirdPartyEntity.action);
        Boolean bool = thirdPartyEntity.alwaysConsult;
        j.PlaceComponentResult(jsonWriter, 372);
        jsonWriter.value(thirdPartyEntity.alwaysConsult);
        String str2 = thirdPartyEntity.appId;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_DECRYPT_MISMATCH_KEY_DATA);
        jsonWriter.value(thirdPartyEntity.appId);
        BannerLottieEntity bannerLottieEntity = thirdPartyEntity.bannerLottie;
        j.PlaceComponentResult(jsonWriter, 157);
        BannerLottieEntity bannerLottieEntity2 = thirdPartyEntity.bannerLottie;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, BannerLottieEntity.class, bannerLottieEntity2).write(jsonWriter, bannerLottieEntity2);
        String str3 = thirdPartyEntity.bizType;
        j.PlaceComponentResult(jsonWriter, 79);
        jsonWriter.value(thirdPartyEntity.bizType);
        String str4 = thirdPartyEntity.buttonTitle;
        j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_ENTITY_TEMPLATE);
        jsonWriter.value(thirdPartyEntity.buttonTitle);
        String str5 = thirdPartyEntity.clientId;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED);
        jsonWriter.value(thirdPartyEntity.clientId);
        String str6 = thirdPartyEntity.description;
        j.PlaceComponentResult(jsonWriter, 388);
        jsonWriter.value(thirdPartyEntity.description);
        String str7 = thirdPartyEntity.directOpen;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_INIT_UNKNOWN_ERROR);
        jsonWriter.value(thirdPartyEntity.directOpen);
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_ENC_NO_MEMORY);
        jsonWriter.value(thirdPartyEntity.enable);
        j.PlaceComponentResult(jsonWriter, 494);
        jsonWriter.value(thirdPartyEntity.hasRedDot);
        String str8 = thirdPartyEntity.headerBackgroundColor;
        j.PlaceComponentResult(jsonWriter, 530);
        jsonWriter.value(thirdPartyEntity.headerBackgroundColor);
        String str9 = thirdPartyEntity.icon;
        j.PlaceComponentResult(jsonWriter, 418);
        jsonWriter.value(thirdPartyEntity.icon);
        String str10 = thirdPartyEntity.iconLottie;
        j.PlaceComponentResult(jsonWriter, 49);
        jsonWriter.value(thirdPartyEntity.iconLottie);
        j.PlaceComponentResult(jsonWriter, 73);
        jsonWriter.value(thirdPartyEntity.isBiller);
        String str11 = thirdPartyEntity.key;
        j.PlaceComponentResult(jsonWriter, 318);
        jsonWriter.value(thirdPartyEntity.key);
        String str12 = thirdPartyEntity.keyword;
        j.PlaceComponentResult(jsonWriter, 507);
        jsonWriter.value(thirdPartyEntity.keyword);
        String str13 = thirdPartyEntity.link;
        j.PlaceComponentResult(jsonWriter, 395);
        jsonWriter.value(thirdPartyEntity.link);
        String str14 = thirdPartyEntity.name;
        j.PlaceComponentResult(jsonWriter, 552);
        jsonWriter.value(thirdPartyEntity.name);
        String str15 = thirdPartyEntity.nameInd;
        j.PlaceComponentResult(jsonWriter, 472);
        jsonWriter.value(thirdPartyEntity.nameInd);
        String str16 = thirdPartyEntity.nameTag;
        j.PlaceComponentResult(jsonWriter, 409);
        jsonWriter.value(thirdPartyEntity.nameTag);
        j.PlaceComponentResult(jsonWriter, 232);
        jsonWriter.value(thirdPartyEntity.needConsult);
        String str17 = thirdPartyEntity.needOauth;
        j.PlaceComponentResult(jsonWriter, 400);
        jsonWriter.value(thirdPartyEntity.needOauth);
        String str18 = thirdPartyEntity.operationType;
        j.PlaceComponentResult(jsonWriter, 104);
        jsonWriter.value(thirdPartyEntity.operationType);
        String str19 = thirdPartyEntity.redirectUrl;
        j.PlaceComponentResult(jsonWriter, 467);
        jsonWriter.value(thirdPartyEntity.redirectUrl);
        String str20 = thirdPartyEntity.ribbonText;
        j.PlaceComponentResult(jsonWriter, 208);
        jsonWriter.value(thirdPartyEntity.ribbonText);
        Integer num = thirdPartyEntity.rotationDelayTime;
        j.PlaceComponentResult(jsonWriter, 263);
        Integer num2 = thirdPartyEntity.rotationDelayTime;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        String str21 = thirdPartyEntity.scopes;
        j.PlaceComponentResult(jsonWriter, 392);
        jsonWriter.value(thirdPartyEntity.scopes);
        String str22 = thirdPartyEntity.screenOrientation;
        j.PlaceComponentResult(jsonWriter, 390);
        jsonWriter.value(thirdPartyEntity.screenOrientation);
        SkuAttributeEntity skuAttributeEntity = thirdPartyEntity.skuAttr;
        j.PlaceComponentResult(jsonWriter, 298);
        SkuAttributeEntity skuAttributeEntity2 = thirdPartyEntity.skuAttr;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, SkuAttributeEntity.class, skuAttributeEntity2).write(jsonWriter, skuAttributeEntity2);
        if (thirdPartyEntity != thirdPartyEntity.spaceCodes) {
            j.PlaceComponentResult(jsonWriter, HereOauthManager.TOO_MANY_REQUEST_CODE);
            ResourceResponseInfo resourceResponseInfo = new ResourceResponseInfo();
            List<String> list = thirdPartyEntity.spaceCodes;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, resourceResponseInfo, list).write(jsonWriter, list);
        }
        String str23 = thirdPartyEntity.spmId;
        j.PlaceComponentResult(jsonWriter, LZMA_Base.kMatchMaxLen);
        jsonWriter.value(thirdPartyEntity.spmId);
        String str24 = thirdPartyEntity.subtitleBorderColor;
        j.PlaceComponentResult(jsonWriter, 231);
        jsonWriter.value(thirdPartyEntity.subtitleBorderColor);
        String str25 = thirdPartyEntity.subtitleColor;
        j.PlaceComponentResult(jsonWriter, 209);
        jsonWriter.value(thirdPartyEntity.subtitleColor);
        String str26 = thirdPartyEntity.userAction;
        j.PlaceComponentResult(jsonWriter, 236);
        jsonWriter.value(thirdPartyEntity.userAction);
        jsonWriter.endObject();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public final Object read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.skipValue();
            return null;
        }
        ThirdPartyEntity thirdPartyEntity = new ThirdPartyEntity();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.KClassImpl$Data$declaredNonStaticMembers$2;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 5:
                    if (!z) {
                        thirdPartyEntity.buttonTitle = null;
                        break;
                    } else {
                        thirdPartyEntity.buttonTitle = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 23:
                    if (!z) {
                        thirdPartyEntity.appId = null;
                        break;
                    } else {
                        thirdPartyEntity.appId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 72:
                    if (!z) {
                        thirdPartyEntity.key = null;
                        break;
                    } else {
                        thirdPartyEntity.key = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 80:
                    if (!z) {
                        thirdPartyEntity.subtitleColor = null;
                        break;
                    } else {
                        thirdPartyEntity.subtitleColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 83:
                    if (!z) {
                        thirdPartyEntity.ribbonText = null;
                        break;
                    } else {
                        thirdPartyEntity.ribbonText = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 85:
                    if (!z) {
                        thirdPartyEntity.bizType = null;
                        break;
                    } else {
                        thirdPartyEntity.bizType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 124:
                    if (!z) {
                        thirdPartyEntity.screenOrientation = null;
                        break;
                    } else {
                        thirdPartyEntity.screenOrientation = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 125:
                    if (!z) {
                        thirdPartyEntity.scopes = null;
                        break;
                    } else {
                        thirdPartyEntity.scopes = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 175:
                    if (!z) {
                        break;
                    } else {
                        thirdPartyEntity.enable = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 186:
                    if (!z) {
                        break;
                    } else {
                        thirdPartyEntity.needConsult = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 211:
                    if (!z) {
                        thirdPartyEntity.operationType = null;
                        break;
                    } else {
                        thirdPartyEntity.operationType = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_STA_STORE_LOW_VERSION_DATA_FILE /* 212 */:
                    if (!z) {
                        thirdPartyEntity.action = null;
                        break;
                    } else {
                        thirdPartyEntity.action = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 216:
                    if (!z) {
                        thirdPartyEntity.headerBackgroundColor = null;
                        break;
                    } else {
                        thirdPartyEntity.headerBackgroundColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 232:
                    if (!z) {
                        thirdPartyEntity.directOpen = null;
                        break;
                    } else {
                        thirdPartyEntity.directOpen = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 236:
                    if (!z) {
                        thirdPartyEntity.nameInd = null;
                        break;
                    } else {
                        thirdPartyEntity.nameInd = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 288:
                    if (!z) {
                        thirdPartyEntity.iconLottie = null;
                        break;
                    } else {
                        thirdPartyEntity.iconLottie = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED /* 306 */:
                    if (!z) {
                        thirdPartyEntity.clientId = null;
                        break;
                    } else {
                        thirdPartyEntity.clientId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 323:
                    if (!z) {
                        break;
                    } else {
                        thirdPartyEntity.isBiller = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 324:
                    if (!z) {
                        thirdPartyEntity.keyword = null;
                        break;
                    } else {
                        thirdPartyEntity.keyword = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 350:
                    if (!z) {
                        thirdPartyEntity.nameTag = null;
                        break;
                    } else {
                        thirdPartyEntity.nameTag = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case AUScreenAdaptTool.WIDTH_BASE /* 360 */:
                    if (!z) {
                        thirdPartyEntity.redirectUrl = null;
                        break;
                    } else {
                        thirdPartyEntity.redirectUrl = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 384:
                    if (!z) {
                        thirdPartyEntity.description = null;
                        break;
                    } else {
                        thirdPartyEntity.description = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 397:
                    if (!z) {
                        break;
                    } else {
                        thirdPartyEntity.hasRedDot = ((Boolean) gson.getAdapter(Boolean.class).read2(jsonReader)).booleanValue();
                        continue;
                    }
                case 474:
                    if (!z) {
                        thirdPartyEntity.name = null;
                        break;
                    } else {
                        thirdPartyEntity.name = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 477:
                    if (!z) {
                        thirdPartyEntity.spaceCodes = null;
                        break;
                    } else {
                        thirdPartyEntity.spaceCodes = (List) gson.getAdapter(new ResourceResponseInfo()).read2(jsonReader);
                        continue;
                    }
                case 482:
                    if (!z) {
                        thirdPartyEntity.skuAttr = null;
                        break;
                    } else {
                        thirdPartyEntity.skuAttr = (SkuAttributeEntity) gson.getAdapter(SkuAttributeEntity.class).read2(jsonReader);
                        continue;
                    }
                case 497:
                    if (!z) {
                        thirdPartyEntity.rotationDelayTime = null;
                        break;
                    } else {
                        thirdPartyEntity.rotationDelayTime = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_PAGE /* 516 */:
                    if (!z) {
                        thirdPartyEntity.spmId = null;
                        break;
                    } else {
                        thirdPartyEntity.spmId = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 524:
                    if (!z) {
                        thirdPartyEntity.icon = null;
                        break;
                    } else {
                        thirdPartyEntity.icon = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 562:
                    if (!z) {
                        thirdPartyEntity.alwaysConsult = null;
                        break;
                    } else {
                        thirdPartyEntity.alwaysConsult = (Boolean) gson.getAdapter(Boolean.class).read2(jsonReader);
                        continue;
                    }
                case 593:
                    if (!z) {
                        thirdPartyEntity.subtitleBorderColor = null;
                        break;
                    } else {
                        thirdPartyEntity.subtitleBorderColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATRUE_INVALID_INPUT /* 601 */:
                    if (!z) {
                        thirdPartyEntity.bannerLottie = null;
                        break;
                    } else {
                        thirdPartyEntity.bannerLottie = (BannerLottieEntity) gson.getAdapter(BannerLottieEntity.class).read2(jsonReader);
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_NO_MEM /* 602 */:
                    if (!z) {
                        thirdPartyEntity.needOauth = null;
                        break;
                    } else {
                        thirdPartyEntity.needOauth = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_NO_SEEDSECRET /* 606 */:
                    if (!z) {
                        thirdPartyEntity.userAction = null;
                        break;
                    } else {
                        thirdPartyEntity.userAction = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_SIGNATURE_DATA_FILE_MISMATCH /* 607 */:
                    if (!z) {
                        thirdPartyEntity.link = null;
                        break;
                    } else {
                        thirdPartyEntity.link = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return thirdPartyEntity;
    }
}
