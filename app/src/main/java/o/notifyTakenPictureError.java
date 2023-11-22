package o;

import com.alibaba.wireless.security.SecExceptionCode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import id.dana.domain.wallet_v3.model.WalletV3AddAssetServices;
import id.dana.domain.wallet_v3.model.WalletV3Config;
import java.io.IOException;
import java.util.List;

/* loaded from: classes4.dex */
public final class notifyTakenPictureError extends TypeAdapter implements G {
    private getValueOfTouchPositionAbsolute MyBillsEntityDataFactory;
    private J PlaceComponentResult;
    private Gson getAuthRequestContext;

    public notifyTakenPictureError(Gson gson, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute, J j) {
        this.getAuthRequestContext = gson;
        this.MyBillsEntityDataFactory = getvalueoftouchpositionabsolute;
        this.PlaceComponentResult = j;
    }

    @Override // com.google.gson.TypeAdapter
    public final void write(JsonWriter jsonWriter, Object obj) throws IOException {
        if (obj == null) {
            jsonWriter.nullValue();
            return;
        }
        WalletV3Config walletV3Config = (WalletV3Config) obj;
        Gson gson = this.getAuthRequestContext;
        J j = this.PlaceComponentResult;
        jsonWriter.beginObject();
        Integer num = walletV3Config.cacheDuration;
        j.PlaceComponentResult(jsonWriter, 197);
        Integer num2 = walletV3Config.cacheDuration;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num2).write(jsonWriter, num2);
        WalletV3AddAssetServices walletV3AddAssetServices = walletV3Config.categoryFinancial;
        j.PlaceComponentResult(jsonWriter, 500);
        WalletV3AddAssetServices walletV3AddAssetServices2 = walletV3Config.categoryFinancial;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, WalletV3AddAssetServices.class, walletV3AddAssetServices2).write(jsonWriter, walletV3AddAssetServices2);
        WalletV3AddAssetServices walletV3AddAssetServices3 = walletV3Config.categoryIdentity;
        j.PlaceComponentResult(jsonWriter, 27);
        WalletV3AddAssetServices walletV3AddAssetServices4 = walletV3Config.categoryIdentity;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, WalletV3AddAssetServices.class, walletV3AddAssetServices4).write(jsonWriter, walletV3AddAssetServices4);
        WalletV3AddAssetServices walletV3AddAssetServices5 = walletV3Config.categoryLoyalty;
        j.PlaceComponentResult(jsonWriter, 533);
        WalletV3AddAssetServices walletV3AddAssetServices6 = walletV3Config.categoryLoyalty;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, WalletV3AddAssetServices.class, walletV3AddAssetServices6).write(jsonWriter, walletV3AddAssetServices6);
        WalletV3AddAssetServices walletV3AddAssetServices7 = walletV3Config.categoryPayment;
        j.PlaceComponentResult(jsonWriter, 39);
        WalletV3AddAssetServices walletV3AddAssetServices8 = walletV3Config.categoryPayment;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, WalletV3AddAssetServices.class, walletV3AddAssetServices8).write(jsonWriter, walletV3AddAssetServices8);
        WalletV3AddAssetServices walletV3AddAssetServices9 = walletV3Config.categoryVoucherAndTicket;
        j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_ATLAS_KEY_NOT_EXSITED);
        WalletV3AddAssetServices walletV3AddAssetServices10 = walletV3Config.categoryVoucherAndTicket;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, WalletV3AddAssetServices.class, walletV3AddAssetServices10).write(jsonWriter, walletV3AddAssetServices10);
        Integer num3 = walletV3Config.danaDealsVersion;
        j.PlaceComponentResult(jsonWriter, 385);
        Integer num4 = walletV3Config.danaDealsVersion;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num4).write(jsonWriter, num4);
        String str = walletV3Config.defaultBackgroundColor;
        j.PlaceComponentResult(jsonWriter, 238);
        jsonWriter.value(walletV3Config.defaultBackgroundColor);
        String str2 = walletV3Config.defaultFontColor;
        j.PlaceComponentResult(jsonWriter, 63);
        jsonWriter.value(walletV3Config.defaultFontColor);
        String str3 = walletV3Config.discountCouponDefaultBackgroundColor;
        j.PlaceComponentResult(jsonWriter, 223);
        jsonWriter.value(walletV3Config.discountCouponDefaultBackgroundColor);
        String str4 = walletV3Config.discountCouponDefaultFontColor;
        j.PlaceComponentResult(jsonWriter, 585);
        jsonWriter.value(walletV3Config.discountCouponDefaultFontColor);
        Integer num5 = walletV3Config.discountCouponVersion;
        j.PlaceComponentResult(jsonWriter, 250);
        Integer num6 = walletV3Config.discountCouponVersion;
        AppCompatEmojiTextHelper.getAuthRequestContext(gson, Integer.class, num6).write(jsonWriter, num6);
        if (walletV3Config != walletV3Config.sectionOrderingV3) {
            j.PlaceComponentResult(jsonWriter, 116);
            NearbySearchPresenter$getNearbyTrendingKeyword$2 nearbySearchPresenter$getNearbyTrendingKeyword$2 = new NearbySearchPresenter$getNearbyTrendingKeyword$2();
            List<String> list = walletV3Config.sectionOrderingV3;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, nearbySearchPresenter$getNearbyTrendingKeyword$2, list).write(jsonWriter, list);
        }
        String str5 = walletV3Config.voucherInjectionDefaultBackgroundColor;
        j.PlaceComponentResult(jsonWriter, 282);
        jsonWriter.value(walletV3Config.voucherInjectionDefaultBackgroundColor);
        String str6 = walletV3Config.voucherInjectionDefaultFontColor;
        j.PlaceComponentResult(jsonWriter, 389);
        jsonWriter.value(walletV3Config.voucherInjectionDefaultFontColor);
        if (walletV3Config != walletV3Config.walletFinancialSection) {
            j.PlaceComponentResult(jsonWriter, 59);
            appendStatementEnd appendstatementend = new appendStatementEnd();
            List<String> list2 = walletV3Config.walletFinancialSection;
            AppCompatEmojiTextHelper.getAuthRequestContext(gson, appendstatementend, list2).write(jsonWriter, list2);
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
        WalletV3Config walletV3Config = new WalletV3Config();
        Gson gson = this.getAuthRequestContext;
        getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute = this.MyBillsEntityDataFactory;
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            int authRequestContext = getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader);
            boolean z = jsonReader.peek() != JsonToken.NULL;
            switch (authRequestContext) {
                case 3:
                    if (!z) {
                        walletV3Config.defaultFontColor = null;
                        break;
                    } else {
                        walletV3Config.defaultFontColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 206:
                    if (!z) {
                        walletV3Config.categoryPayment = null;
                        break;
                    } else {
                        walletV3Config.categoryPayment = (WalletV3AddAssetServices) gson.getAdapter(WalletV3AddAssetServices.class).read2(jsonReader);
                        continue;
                    }
                case 237:
                    if (!z) {
                        walletV3Config.cacheDuration = null;
                        break;
                    } else {
                        walletV3Config.cacheDuration = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 281:
                    if (!z) {
                        walletV3Config.walletFinancialSection = null;
                        break;
                    } else {
                        walletV3Config.walletFinancialSection = (List) gson.getAdapter(new appendStatementEnd()).read2(jsonReader);
                        continue;
                    }
                case 296:
                    if (!z) {
                        walletV3Config.categoryVoucherAndTicket = null;
                        break;
                    } else {
                        walletV3Config.categoryVoucherAndTicket = (WalletV3AddAssetServices) gson.getAdapter(WalletV3AddAssetServices.class).read2(jsonReader);
                        continue;
                    }
                case 349:
                    if (!z) {
                        walletV3Config.defaultBackgroundColor = null;
                        break;
                    } else {
                        walletV3Config.defaultBackgroundColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 378:
                    if (!z) {
                        walletV3Config.categoryIdentity = null;
                        break;
                    } else {
                        walletV3Config.categoryIdentity = (WalletV3AddAssetServices) gson.getAdapter(WalletV3AddAssetServices.class).read2(jsonReader);
                        continue;
                    }
                case SecExceptionCode.SEC_ERROR_DYN_ENC_BASE64_DECODE_FAILED /* 423 */:
                    if (!z) {
                        walletV3Config.categoryLoyalty = null;
                        break;
                    } else {
                        walletV3Config.categoryLoyalty = (WalletV3AddAssetServices) gson.getAdapter(WalletV3AddAssetServices.class).read2(jsonReader);
                        continue;
                    }
                case 446:
                    if (!z) {
                        walletV3Config.sectionOrderingV3 = null;
                        break;
                    } else {
                        walletV3Config.sectionOrderingV3 = (List) gson.getAdapter(new NearbySearchPresenter$getNearbyTrendingKeyword$2()).read2(jsonReader);
                        continue;
                    }
                case 453:
                    if (!z) {
                        walletV3Config.discountCouponDefaultFontColor = null;
                        break;
                    } else {
                        walletV3Config.discountCouponDefaultFontColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 479:
                    if (!z) {
                        walletV3Config.categoryFinancial = null;
                        break;
                    } else {
                        walletV3Config.categoryFinancial = (WalletV3AddAssetServices) gson.getAdapter(WalletV3AddAssetServices.class).read2(jsonReader);
                        continue;
                    }
                case 529:
                    if (!z) {
                        walletV3Config.discountCouponDefaultBackgroundColor = null;
                        break;
                    } else {
                        walletV3Config.discountCouponDefaultBackgroundColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 545:
                    if (!z) {
                        walletV3Config.voucherInjectionDefaultBackgroundColor = null;
                        break;
                    } else {
                        walletV3Config.voucherInjectionDefaultBackgroundColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                case 567:
                    if (!z) {
                        walletV3Config.discountCouponVersion = null;
                        break;
                    } else {
                        walletV3Config.discountCouponVersion = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 583:
                    if (!z) {
                        walletV3Config.danaDealsVersion = null;
                        break;
                    } else {
                        walletV3Config.danaDealsVersion = (Integer) gson.getAdapter(Integer.class).read2(jsonReader);
                        continue;
                    }
                case 586:
                    if (!z) {
                        walletV3Config.voucherInjectionDefaultFontColor = null;
                        break;
                    } else {
                        walletV3Config.voucherInjectionDefaultFontColor = jsonReader.peek() != JsonToken.BOOLEAN ? jsonReader.nextString() : Boolean.toString(jsonReader.nextBoolean());
                        continue;
                    }
                default:
                    jsonReader.skipValue();
                    continue;
            }
            jsonReader.nextNull();
        }
        jsonReader.endObject();
        return walletV3Config;
    }
}
