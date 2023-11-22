package id.dana.data.deeplink.repository.source.branch.result;

import android.view.Gravity;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import id.dana.cashier.view.InputCardNumberView;
import id.dana.utils.foundation.logger.log.DanaLog;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;
import o.C;
import o.J;
import o.getValueOfTouchPositionAbsolute;

/* loaded from: classes2.dex */
public class DeepLinkPayloadEntity {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static char KClassImpl$Data$declaredNonStaticMembers$2 = 0;
    private static char MyBillsEntityDataFactory = 0;
    private static char PlaceComponentResult = 0;
    private static final String TAG = "DeepLinkPayloadEntity";
    private static char getAuthRequestContext = 0;
    private static int lookAheadTest = 1;
    private String acqSiteId;
    private String action;
    private String android_url;
    private String authCode;
    private String bindDanaType;
    private String bizOrderId;
    private String bizType;
    private String cacheKey;
    private String clientId;
    private String codeChallenge;
    private String codeValue;
    private String destinationPath;
    private String encodedParams;
    private String encoding;
    private String extendedInfo;
    private String fullUrl;
    private String innerUrl;
    private String invitationId;
    private boolean isIpgBinding;
    private boolean isNeedAuth;
    private String mcc;
    private String merchantId;
    private String merchantName;
    private boolean needMobileToken;
    private boolean needOauth;
    private String netAuthId;
    private String orderId;
    private String organizerName;
    private String ott;
    private String params;
    private String path;
    private String paySiteId;
    private String paymentOrderId;
    private String phoneNumber;
    private String promoCode;
    private String qrisString;
    private String redirectUrl;
    private String referralCode;
    private String referringLink;
    private String responseType;
    private String scope;
    private String seamlessData;
    private String seamlessSign;
    private String serviceKey;
    private String shortCode;
    private String signature;
    private boolean skipHomePage;
    private String source;
    private String state;
    private String terminalType;
    private String token;
    private String transactionId;
    private String url;

    static {
        try {
            MyBillsEntityDataFactory();
            int i = BuiltInFictitiousFunctionClassFactory + 65;
            lookAheadTest = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(JsonWriter jsonWriter, J j) {
        Object[] objArr = null;
        if (this != this.acqSiteId) {
            int i = lookAheadTest + 115;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            j.PlaceComponentResult(jsonWriter, 297);
            if (i2 != 0) {
                jsonWriter.value(this.acqSiteId);
                int length = objArr.length;
            } else {
                jsonWriter.value(this.acqSiteId);
            }
        }
        if (this != this.action) {
            int i3 = lookAheadTest + 31;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            j.PlaceComponentResult(jsonWriter, 438);
            if (i4 != 0) {
                jsonWriter.value(this.action);
                objArr.hashCode();
            } else {
                jsonWriter.value(this.action);
            }
        }
        if (this != this.android_url) {
            j.PlaceComponentResult(jsonWriter, 458);
            jsonWriter.value(this.android_url);
        }
        if (this != this.authCode) {
            j.PlaceComponentResult(jsonWriter, 172);
            jsonWriter.value(this.authCode);
        }
        if (this != this.bindDanaType) {
            j.PlaceComponentResult(jsonWriter, 371);
            jsonWriter.value(this.bindDanaType);
        }
        if (this != this.bizOrderId) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_INVALID_ENCRYPTED_DATA);
            jsonWriter.value(this.bizOrderId);
        }
        if (this != this.bizType) {
            j.PlaceComponentResult(jsonWriter, 79);
            jsonWriter.value(this.bizType);
        }
        if ((this != this.cacheKey ? (char) 28 : '/') != '/') {
            int i5 = BuiltInFictitiousFunctionClassFactory + 21;
            lookAheadTest = i5 % 128;
            int i6 = i5 % 2;
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_NO_DATA_FILE);
            if (i6 == 0) {
                jsonWriter.value(this.cacheKey);
                objArr.hashCode();
            } else {
                jsonWriter.value(this.cacheKey);
            }
        }
        if (this != this.clientId) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_STA_KEY_NOT_EXISTED);
            jsonWriter.value(this.clientId);
        }
        if (this != this.codeChallenge) {
            j.PlaceComponentResult(jsonWriter, 410);
            jsonWriter.value(this.codeChallenge);
        }
        if (this != this.codeValue) {
            j.PlaceComponentResult(jsonWriter, 121);
            jsonWriter.value(this.codeValue);
        }
        if (this != this.destinationPath) {
            j.PlaceComponentResult(jsonWriter, 330);
            jsonWriter.value(this.destinationPath);
        }
        if (this != this.encodedParams) {
            int i7 = BuiltInFictitiousFunctionClassFactory + 75;
            lookAheadTest = i7 % 128;
            int i8 = i7 % 2;
            j.PlaceComponentResult(jsonWriter, 518);
            jsonWriter.value(this.encodedParams);
        }
        if (this != this.encoding) {
            j.PlaceComponentResult(jsonWriter, 415);
            jsonWriter.value(this.encoding);
        }
        if ((this != this.extendedInfo ? '_' : 'L') == '_') {
            j.PlaceComponentResult(jsonWriter, 557);
            jsonWriter.value(this.extendedInfo);
        }
        if (this != this.fullUrl) {
            j.PlaceComponentResult(jsonWriter, 468);
            jsonWriter.value(this.fullUrl);
        }
        if (this != this.innerUrl) {
            j.PlaceComponentResult(jsonWriter, 351);
            jsonWriter.value(this.innerUrl);
        }
        if ((this != this.invitationId ? JSONLexer.EOI : 'U') == 26) {
            j.PlaceComponentResult(jsonWriter, 204);
            jsonWriter.value(this.invitationId);
        }
        j.PlaceComponentResult(jsonWriter, 18);
        jsonWriter.value(this.isIpgBinding);
        j.PlaceComponentResult(jsonWriter, 186);
        jsonWriter.value(this.isNeedAuth);
        if (this != this.mcc) {
            j.PlaceComponentResult(jsonWriter, 598);
            jsonWriter.value(this.mcc);
        }
        if (this != this.merchantId) {
            int i9 = lookAheadTest + 91;
            BuiltInFictitiousFunctionClassFactory = i9 % 128;
            int i10 = i9 % 2;
            j.PlaceComponentResult(jsonWriter, 478);
            if (i10 != 0) {
                jsonWriter.value(this.merchantId);
                int i11 = 22 / 0;
            } else {
                jsonWriter.value(this.merchantId);
            }
        }
        if (this != this.merchantName) {
            j.PlaceComponentResult(jsonWriter, 105);
            jsonWriter.value(this.merchantName);
        }
        j.PlaceComponentResult(jsonWriter, 413);
        jsonWriter.value(this.needMobileToken);
        j.PlaceComponentResult(jsonWriter, 400);
        jsonWriter.value(this.needOauth);
        if (this != this.netAuthId) {
            j.PlaceComponentResult(jsonWriter, 426);
            jsonWriter.value(this.netAuthId);
        }
        if (this != this.orderId) {
            j.PlaceComponentResult(jsonWriter, DeepRecoverARiverProxy.TYPE_EXCEPTION_CANNOT_CRASH_APP);
            jsonWriter.value(this.orderId);
        }
        if (this != this.organizerName) {
            j.PlaceComponentResult(jsonWriter, 171);
            jsonWriter.value(this.organizerName);
        }
        if (this != this.ott) {
            int i12 = lookAheadTest + 119;
            BuiltInFictitiousFunctionClassFactory = i12 % 128;
            boolean z = i12 % 2 != 0;
            j.PlaceComponentResult(jsonWriter, 471);
            if (!z) {
                jsonWriter.value(this.ott);
            } else {
                jsonWriter.value(this.ott);
                int i13 = 89 / 0;
            }
        }
        if (this != this.params) {
            j.PlaceComponentResult(jsonWriter, 427);
            jsonWriter.value(this.params);
        }
        if (this != this.path) {
            int i14 = BuiltInFictitiousFunctionClassFactory + 3;
            lookAheadTest = i14 % 128;
            char c = i14 % 2 == 0 ? (char) 23 : ';';
            j.PlaceComponentResult(jsonWriter, WebSocket.DEFAULT_WSS_PORT);
            if (c != ';') {
                jsonWriter.value(this.path);
                objArr.hashCode();
            } else {
                jsonWriter.value(this.path);
            }
        }
        if (!(this == this.paySiteId)) {
            j.PlaceComponentResult(jsonWriter, 382);
            jsonWriter.value(this.paySiteId);
        }
        if (this != this.paymentOrderId) {
            j.PlaceComponentResult(jsonWriter, 560);
            jsonWriter.value(this.paymentOrderId);
        }
        if (!(this == this.phoneNumber)) {
            j.PlaceComponentResult(jsonWriter, 201);
            jsonWriter.value(this.phoneNumber);
        }
        if (this != this.promoCode) {
            j.PlaceComponentResult(jsonWriter, 129);
            jsonWriter.value(this.promoCode);
        }
        if (this != this.qrisString) {
            j.PlaceComponentResult(jsonWriter, 13);
            jsonWriter.value(this.qrisString);
        }
        if (this != this.redirectUrl) {
            j.PlaceComponentResult(jsonWriter, 467);
            jsonWriter.value(this.redirectUrl);
        }
        if ((this != this.referralCode ? 'Z' : (char) 5) == 'Z') {
            j.PlaceComponentResult(jsonWriter, 317);
            jsonWriter.value(this.referralCode);
        }
        if (this != this.referringLink) {
            int i15 = BuiltInFictitiousFunctionClassFactory + 75;
            lookAheadTest = i15 % 128;
            int i16 = i15 % 2;
            j.PlaceComponentResult(jsonWriter, 141);
            jsonWriter.value(this.referringLink);
        }
        if (this != this.responseType) {
            j.PlaceComponentResult(jsonWriter, 572);
            jsonWriter.value(this.responseType);
        }
        if (this != this.scope) {
            j.PlaceComponentResult(jsonWriter, 392);
            jsonWriter.value(this.scope);
        }
        if (this != this.seamlessData) {
            j.PlaceComponentResult(jsonWriter, 497);
            jsonWriter.value(this.seamlessData);
        }
        if (this != this.seamlessSign) {
            j.PlaceComponentResult(jsonWriter, 574);
            jsonWriter.value(this.seamlessSign);
        }
        if (this != this.serviceKey) {
            j.PlaceComponentResult(jsonWriter, 284);
            jsonWriter.value(this.serviceKey);
        }
        if (this != this.shortCode) {
            j.PlaceComponentResult(jsonWriter, 547);
            jsonWriter.value(this.shortCode);
        }
        if (this != this.signature) {
            j.PlaceComponentResult(jsonWriter, 288);
            jsonWriter.value(this.signature);
        }
        j.PlaceComponentResult(jsonWriter, 278);
        jsonWriter.value(this.skipHomePage);
        if (this != this.source) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_DYN_STORE_DDPEX_KEY_VALUE_NOT_EXSIT);
            jsonWriter.value(this.source);
        }
        if (this != this.state) {
            j.PlaceComponentResult(jsonWriter, SecExceptionCode.SEC_ERROR_SIGNATURE_BLOWFISH_FAILED);
            jsonWriter.value(this.state);
        }
        if (this != this.terminalType) {
            int i17 = lookAheadTest + 61;
            BuiltInFictitiousFunctionClassFactory = i17 % 128;
            char c2 = i17 % 2 != 0 ? 'D' : 'H';
            j.PlaceComponentResult(jsonWriter, 277);
            if (c2 != 'D') {
                jsonWriter.value(this.terminalType);
            } else {
                jsonWriter.value(this.terminalType);
                int i18 = 82 / 0;
            }
        }
        if (this != this.token) {
            j.PlaceComponentResult(jsonWriter, 412);
            jsonWriter.value(this.token);
        }
        if (this != this.transactionId) {
            int i19 = lookAheadTest + 99;
            BuiltInFictitiousFunctionClassFactory = i19 % 128;
            int i20 = i19 % 2;
            j.PlaceComponentResult(jsonWriter, 331);
            if (i20 != 0) {
                jsonWriter.value(this.transactionId);
                int length2 = objArr.length;
            } else {
                jsonWriter.value(this.transactionId);
            }
        }
        if (this != this.url) {
            j.PlaceComponentResult(jsonWriter, 320);
            jsonWriter.value(this.url);
        }
    }

    static void MyBillsEntityDataFactory() {
        MyBillsEntityDataFactory = (char) 19973;
        getAuthRequestContext = (char) 42452;
        PlaceComponentResult = (char) 38152;
        KClassImpl$Data$declaredNonStaticMembers$2 = (char) 12360;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0097, code lost:
    
        if (r7 != r9) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a2, code lost:
    
        if (r8.peek() != com.google.gson.stream.JsonToken.BOOLEAN) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00a4, code lost:
    
        r6.codeValue = r8.nextString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00aa, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ab, code lost:
    
        r6.codeValue = java.lang.Boolean.toString(r8.nextBoolean());
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b5, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private /* synthetic */ void MyBillsEntityDataFactory(com.google.gson.Gson r7, com.google.gson.stream.JsonReader r8, int r9) {
        /*
            Method dump skipped, instructions count: 2220
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.data.deeplink.repository.source.branch.result.DeepLinkPayloadEntity.MyBillsEntityDataFactory(com.google.gson.Gson, com.google.gson.stream.JsonReader, int):void");
    }

    public final /* synthetic */ void MyBillsEntityDataFactory(Gson gson, JsonReader jsonReader, getValueOfTouchPositionAbsolute getvalueoftouchpositionabsolute) {
        int i = lookAheadTest + 73;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        jsonReader.beginObject();
        if (i2 != 0) {
            int i3 = 0 / 0;
        }
        try {
            int i4 = lookAheadTest + 93;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            while (true) {
                int i5 = i4 % 2;
                if (!(jsonReader.hasNext())) {
                    jsonReader.endObject();
                    return;
                }
                int i6 = BuiltInFictitiousFunctionClassFactory + 53;
                lookAheadTest = i6 % 128;
                boolean z = i6 % 2 == 0;
                MyBillsEntityDataFactory(gson, jsonReader, getvalueoftouchpositionabsolute.getAuthRequestContext(jsonReader));
                if (z) {
                    Object[] objArr = null;
                    int length = objArr.length;
                }
                i4 = lookAheadTest + 35;
                BuiltInFictitiousFunctionClassFactory = i4 % 128;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public final /* synthetic */ void getAuthRequestContext(JsonWriter jsonWriter, J j) {
        int i = lookAheadTest + 121;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        jsonWriter.beginObject();
        KClassImpl$Data$declaredNonStaticMembers$2(jsonWriter, j);
        jsonWriter.endObject();
        int i3 = BuiltInFictitiousFunctionClassFactory + 97;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    public String getExtendedInfo() {
        int i = lookAheadTest + 113;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? 'B' : '_') != 'B') {
            return this.extendedInfo;
        }
        String str = this.extendedInfo;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public void setExtendedInfo(String str) {
        try {
            int i = lookAheadTest + 101;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (!(i % 2 != 0)) {
                this.extendedInfo = str;
            } else {
                try {
                    this.extendedInfo = str;
                    Object obj = null;
                    obj.hashCode();
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 37;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getInnerUrl() {
        String str;
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 11;
            lookAheadTest = i % 128;
            if (!(i % 2 != 0)) {
                str = this.innerUrl;
                Object[] objArr = null;
                int length = objArr.length;
            } else {
                str = this.innerUrl;
            }
            int i2 = lookAheadTest + 71;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setInnerUrl(String str) {
        int i = lookAheadTest + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? (char) 29 : '2') != 29) {
            this.innerUrl = str;
        } else {
            try {
                this.innerUrl = str;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 49;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 == 0 ? 'Q' : Typography.less) != '<') {
            obj.hashCode();
        }
    }

    public String getDestinationPath() {
        int i = BuiltInFictitiousFunctionClassFactory + 63;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            String str = this.destinationPath;
            int i3 = lookAheadTest + 115;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setDestinationPath(String str) {
        int i = lookAheadTest + 65;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            this.destinationPath = str;
            int i3 = BuiltInFictitiousFunctionClassFactory + 29;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? '/' : ')') != '/') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public String getOrderId() {
        String str;
        int i = lookAheadTest + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 != 0)) {
            str = this.orderId;
        } else {
            str = this.orderId;
            int i2 = 36 / 0;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 115;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public void setOrderId(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            this.orderId = str;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            this.orderId = str;
        }
        int i2 = lookAheadTest + 117;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int i3 = 55 / 0;
        }
    }

    public String getPath() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 79;
        lookAheadTest = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? 'E' : '[') != 'E') {
            str = this.path;
        } else {
            str = this.path;
            int length = objArr.length;
        }
        try {
            int i2 = lookAheadTest + 95;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            if ((i2 % 2 != 0 ? ',' : 'L') != ',') {
                return str;
            }
            objArr.hashCode();
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setPath(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 115;
            lookAheadTest = i % 128;
            if (!(i % 2 == 0)) {
                this.path = str;
                return;
            }
            try {
                this.path = str;
                Object[] objArr = null;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getFullUrl() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 119;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            try {
                str = this.fullUrl;
            } catch (Exception e) {
                throw e;
            }
        } else {
            str = this.fullUrl;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 29;
        lookAheadTest = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 63 / 0;
            return str;
        }
        return str;
    }

    public void setFullUrl(String str) {
        int i = lookAheadTest + 117;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.fullUrl = str;
        int i3 = lookAheadTest + 53;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 18 : 'K') != 'K') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public String getShortCode() {
        int i = lookAheadTest + 85;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 == 0) {
            return this.shortCode;
        }
        int i2 = 97 / 0;
        return this.shortCode;
    }

    public void setShortCode(String str) {
        int i = lookAheadTest + 55;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 != 0 ? 'U' : 'K';
        this.shortCode = str;
        if (c == 'U') {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 81;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getReferralCode() {
        int i = BuiltInFictitiousFunctionClassFactory + 121;
        lookAheadTest = i % 128;
        if (!(i % 2 == 0)) {
            return this.referralCode;
        }
        String str = this.referralCode;
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public void setReferralCode(String str) {
        try {
            int i = lookAheadTest + 55;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            this.referralCode = str;
            int i3 = BuiltInFictitiousFunctionClassFactory + 5;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getAction() {
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.action;
        int i3 = BuiltInFictitiousFunctionClassFactory + 79;
        lookAheadTest = i3 % 128;
        if (i3 % 2 == 0) {
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return str;
    }

    public void setAction(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 95;
            lookAheadTest = i % 128;
            char c = i % 2 == 0 ? '^' : (char) 19;
            this.action = str;
            if (c == '^') {
                int i2 = 57 / 0;
            }
            int i3 = lookAheadTest + 87;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 != 0 ? '5' : '\f') != '5') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isSkipHomePage() {
        int i = lookAheadTest + 29;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        boolean z = this.skipHomePage;
        try {
            int i3 = lookAheadTest + 103;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
                return z;
            }
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setSkipHomePage(boolean z) {
        int i = lookAheadTest + 7;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.skipHomePage = z;
        int i3 = lookAheadTest + 7;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 != 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public String getResponseType() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            try {
                str = this.responseType;
            } catch (Exception e) {
                throw e;
            }
        } else {
            str = this.responseType;
            int i2 = 78 / 0;
        }
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 35;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setResponseType(String str) {
        int i = lookAheadTest + 103;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '^' : (char) 28) != '^') {
            try {
                this.responseType = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.responseType = str;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 7;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
    }

    public String getClientId() {
        int i = BuiltInFictitiousFunctionClassFactory + 63;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? (char) 5 : '`') != 5) {
            return this.clientId;
        }
        String str = this.clientId;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public void setClientId(String str) {
        int i = lookAheadTest + 73;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.clientId = str;
        try {
            int i3 = lookAheadTest + 11;
            try {
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getPhoneNumber() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 37;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? (char) 24 : '2') != 24) {
            str = this.phoneNumber;
        } else {
            str = this.phoneNumber;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = lookAheadTest + 51;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (!(i2 % 2 == 0)) {
            int i3 = 32 / 0;
            return str;
        }
        return str;
    }

    public void setPhoneNumber(String str) {
        try {
            int i = lookAheadTest + 65;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 == 0) {
                try {
                    this.phoneNumber = str;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                this.phoneNumber = str;
                int i2 = 75 / 0;
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 125;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getScope() {
        int i = lookAheadTest + 97;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.scope;
        int i3 = BuiltInFictitiousFunctionClassFactory + 79;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public void setScope(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 63;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            this.scope = str;
            int i3 = lookAheadTest + 109;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getState() {
        int i = lookAheadTest + 43;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.state;
        int i3 = lookAheadTest + 93;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public void setState(String str) {
        try {
            int i = lookAheadTest + 47;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            this.state = str;
            int i3 = lookAheadTest + 21;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 == 0) {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getCodeChallenge() {
        int i = BuiltInFictitiousFunctionClassFactory + 115;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'S' : '1') != '1') {
            int i2 = 38 / 0;
            return this.codeChallenge;
        }
        try {
            return this.codeChallenge;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setCodeChallenge(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            try {
                this.codeChallenge = str;
                Object obj = null;
                obj.hashCode();
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        this.codeChallenge = str;
    }

    public String getRedirectUrl() {
        int i = BuiltInFictitiousFunctionClassFactory + 39;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.redirectUrl;
        int i3 = lookAheadTest + 47;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public void setRedirectUrl(String str) {
        int i = lookAheadTest + 41;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object obj = null;
        if ((i % 2 != 0 ? '9' : '7') != '9') {
            try {
                this.redirectUrl = str;
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.redirectUrl = str;
            obj.hashCode();
        }
        int i2 = lookAheadTest + 87;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        if (i2 % 2 != 0) {
            obj.hashCode();
        }
    }

    public boolean isNeedMobileToken() {
        int i = lookAheadTest + 57;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        boolean z = this.needMobileToken;
        int i3 = lookAheadTest + 101;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
        return z;
    }

    public void setNeedMobileToken(boolean z) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 85;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            this.needMobileToken = z;
            int i3 = lookAheadTest + 121;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getPromoCode() {
        int i = BuiltInFictitiousFunctionClassFactory + 101;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            String str = this.promoCode;
            try {
                int i3 = BuiltInFictitiousFunctionClassFactory + 79;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setPromoCode(String str) {
        int i = lookAheadTest + 111;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 != 0;
        Object[] objArr = null;
        this.promoCode = str;
        if (z) {
            int length = objArr.length;
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 59;
            lookAheadTest = i2 % 128;
            if (!(i2 % 2 != 0)) {
                int length2 = objArr.length;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String getSource() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 27;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            String str = this.source;
            int i3 = lookAheadTest + 69;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getBindDanaType() {
        int i = BuiltInFictitiousFunctionClassFactory + 85;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.bindDanaType;
        int i3 = BuiltInFictitiousFunctionClassFactory + 87;
        lookAheadTest = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return str;
        }
        int i4 = 65 / 0;
        return str;
    }

    public void setBindDanaType(String str) {
        int i = lookAheadTest + 103;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.bindDanaType = str;
        int i3 = BuiltInFictitiousFunctionClassFactory + 29;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? '+' : '\b') != '\b') {
            int i4 = 52 / 0;
        }
    }

    public String getAcqSiteId() {
        int i = lookAheadTest + 61;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            String str = this.acqSiteId;
            int i3 = BuiltInFictitiousFunctionClassFactory + 61;
            try {
                lookAheadTest = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    Object obj = null;
                    obj.hashCode();
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setAcqSiteId(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            this.acqSiteId = str;
            return;
        }
        this.acqSiteId = str;
        Object[] objArr = null;
        int length = objArr.length;
    }

    public String getMerchantId() {
        int i = BuiltInFictitiousFunctionClassFactory + 15;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? InputCardNumberView.DIVIDER : 'c') != 'c') {
            try {
                int i2 = 40 / 0;
                return this.merchantId;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.merchantId;
    }

    public void setMerchantId(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 113;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        this.merchantId = str;
        if (!z) {
            int i2 = 3 / 0;
        }
        int i3 = BuiltInFictitiousFunctionClassFactory + 17;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? 'C' : '!') != '!') {
            int i4 = 31 / 0;
        }
    }

    public String getMerchantName() {
        int i = BuiltInFictitiousFunctionClassFactory + 75;
        lookAheadTest = i % 128;
        if (i % 2 != 0) {
            try {
                return this.merchantName;
            } catch (Exception e) {
                throw e;
            }
        }
        String str = this.merchantName;
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public void setMerchantName(String str) {
        try {
            int i = lookAheadTest + 97;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                this.merchantName = str;
                int i3 = lookAheadTest + 89;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    return;
                }
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getNetAuthId() {
        int i = BuiltInFictitiousFunctionClassFactory + 39;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.netAuthId;
        int i3 = BuiltInFictitiousFunctionClassFactory + 17;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public void setNetAuthId(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 87;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.netAuthId = str;
        int i3 = BuiltInFictitiousFunctionClassFactory + 41;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    public String getPaySiteId() {
        int i = lookAheadTest + 99;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '.' : 'O') == '.') {
            int i2 = 19 / 0;
            return this.paySiteId;
        }
        try {
            return this.paySiteId;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setPaySiteId(String str) {
        int i = lookAheadTest + 33;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        char c = i % 2 != 0 ? Typography.dollar : (char) 27;
        this.paySiteId = str;
        if (c != '$') {
            return;
        }
        int i2 = 25 / 0;
    }

    public String getTerminalType() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 59;
            lookAheadTest = i % 128;
            if (!(i % 2 != 0)) {
                String str = this.terminalType;
                Object[] objArr = null;
                int length = objArr.length;
                return str;
            }
            return this.terminalType;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setTerminalType(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 89;
        lookAheadTest = i % 128;
        boolean z = i % 2 != 0;
        this.terminalType = str;
        if (!z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 109;
            lookAheadTest = i2 % 128;
            int i3 = i2 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getSignature() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 79;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            String str = this.signature;
            int i3 = BuiltInFictitiousFunctionClassFactory + 37;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setSignature(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? '^' : '\\') != '\\') {
            this.signature = str;
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            this.signature = str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getMcc() {
        int i = BuiltInFictitiousFunctionClassFactory + 107;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.mcc;
        int i3 = BuiltInFictitiousFunctionClassFactory + 13;
        lookAheadTest = i3 % 128;
        if (!(i3 % 2 != 0)) {
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return str;
    }

    public void setMcc(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 55;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.mcc = str;
        int i3 = lookAheadTest + 51;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 17 : 'a') != 'a') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    public Map<String, String> getParams() {
        Iterator<Map.Entry<String, String>> it;
        HashMap hashMap = new HashMap();
        String str = this.params;
        if ((str != null ? '@' : 'S') != 'S') {
            int i = lookAheadTest + 107;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            if (i % 2 != 0) {
                try {
                    it = getAttributes(str.replace("[", "").replace("]", "")).entrySet().iterator();
                    int i2 = 36 / 0;
                } catch (Exception e) {
                    throw e;
                }
            } else {
                it = getAttributes(str.replace("[", "").replace("]", "")).entrySet().iterator();
            }
            while (true) {
                if ((it.hasNext() ? Typography.greater : '7') == '7') {
                    break;
                }
                int i3 = BuiltInFictitiousFunctionClassFactory + 7;
                lookAheadTest = i3 % 128;
                if (i3 % 2 != 0) {
                    Map.Entry<String, String> next = it.next();
                    hashMap.put(next.getKey().toString(), next.getValue().toString());
                } else {
                    Map.Entry<String, String> next2 = it.next();
                    hashMap.put(next2.getKey().toString(), next2.getValue().toString());
                    int i4 = 6 / 0;
                }
            }
        }
        int i5 = BuiltInFictitiousFunctionClassFactory + 75;
        lookAheadTest = i5 % 128;
        if (i5 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return hashMap;
        }
        return hashMap;
    }

    public void setParams(String str) {
        int i = lookAheadTest + 47;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.params = str;
        int i3 = BuiltInFictitiousFunctionClassFactory + 105;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    private Map<String, String> getAttributes(String str) {
        HashMap hashMap = new HashMap();
        try {
            Matcher matcher = Pattern.compile("(\\w+)=(.*?)(?=,\\w+=|$)").matcher(str);
            int i = lookAheadTest + 111;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            while (true) {
                if (!(matcher.find())) {
                    break;
                }
                hashMap.put(matcher.group(1), matcher.group(2));
            }
            int i3 = BuiltInFictitiousFunctionClassFactory + 25;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 != 0)) {
                int i4 = 34 / 0;
                return hashMap;
            }
            return hashMap;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> getScopes() {
        ArrayList arrayList = new ArrayList();
        try {
            String str = this.scope;
            Object[] objArr = new Object[1];
            a(Gravity.getAbsoluteGravity(0, 0) + 5, new char[]{2596, 15383, 16835, 60252, 7943, 26109}, objArr);
            arrayList.addAll(Arrays.asList(URLDecoder.decode(str, ((String) objArr[0]).intern()).replaceAll("[\\[\\]\"]", "").split(",")));
            int i = lookAheadTest + 125;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
        } catch (UnsupportedEncodingException e) {
            DanaLog.BuiltInFictitiousFunctionClassFactory(TAG, e.getMessage());
        }
        return arrayList;
    }

    public boolean isNeedAuth() {
        int i = BuiltInFictitiousFunctionClassFactory + 23;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        boolean z = this.isNeedAuth;
        try {
            int i3 = lookAheadTest + 115;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setNeedAuth(boolean z) {
        int i = lookAheadTest + 39;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (i % 2 != 0) {
            this.isNeedAuth = z;
            Object[] objArr = null;
            int length = objArr.length;
            return;
        }
        try {
            this.isNeedAuth = z;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getServiceKey() {
        int i = BuiltInFictitiousFunctionClassFactory + 23;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            try {
                String str = this.serviceKey;
                Object[] objArr = null;
                int length = objArr.length;
                return str;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.serviceKey;
    }

    public void setServiceKey(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 45;
            try {
                lookAheadTest = i % 128;
                char c = i % 2 == 0 ? Typography.quote : '!';
                Object[] objArr = null;
                this.serviceKey = str;
                if (c == '\"') {
                    objArr.hashCode();
                }
                int i2 = lookAheadTest + 13;
                BuiltInFictitiousFunctionClassFactory = i2 % 128;
                if ((i2 % 2 != 0 ? (char) 27 : (char) 11) != 11) {
                    int length = objArr.length;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getAuthCode() {
        int i = BuiltInFictitiousFunctionClassFactory + 73;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? '7' : (char) 18) != 18) {
            int i2 = 4 / 0;
            return this.authCode;
        }
        try {
            return this.authCode;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setAuthCode(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 15;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.authCode = str;
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 93;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? 'Q' : '6') != 'Q') {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public String getOtt() {
        int i = lookAheadTest + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.ott;
        int i3 = BuiltInFictitiousFunctionClassFactory + 87;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? (char) 19 : (char) 4) != 4) {
            int i4 = 48 / 0;
            return str;
        }
        return str;
    }

    public void setOtt(String str) {
        try {
            int i = lookAheadTest + 125;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                this.ott = str;
                int i3 = lookAheadTest + 25;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getAndroidUrl() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 7;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            String str = this.android_url;
            int i3 = lookAheadTest + 111;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setAndroidUrl(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'U' : (char) 15) != 'U') {
            this.android_url = str;
        } else {
            this.android_url = str;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 105;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
    }

    public String getReferringLink() {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.referringLink;
        int i3 = lookAheadTest + 41;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if ((i3 % 2 != 0 ? 'A' : 'H') != 'A') {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public void setReferringLink(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 51;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            this.referringLink = str;
            int i3 = BuiltInFictitiousFunctionClassFactory + 97;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getUrl() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 119;
        lookAheadTest = i % 128;
        if (!(i % 2 != 0)) {
            str = this.url;
            Object obj = null;
            obj.hashCode();
        } else {
            str = this.url;
        }
        try {
            int i2 = BuiltInFictitiousFunctionClassFactory + 87;
            try {
                lookAheadTest = i2 % 128;
                int i3 = i2 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setUrl(String str) {
        int i = lookAheadTest + 19;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.url = str;
        int i3 = BuiltInFictitiousFunctionClassFactory + 53;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    public String getCodeValue() {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 93;
            lookAheadTest = i % 128;
            int i2 = i % 2;
            try {
                String str = this.codeValue;
                int i3 = lookAheadTest + 11;
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 != 0 ? JSONLexer.EOI : (char) 22) != 22) {
                    Object obj = null;
                    obj.hashCode();
                    return str;
                }
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setCodeValue(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 105;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? 'I' : Typography.quote) == 'I') {
                this.codeValue = str;
                int i2 = 10 / 0;
                return;
            }
            try {
                this.codeValue = str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getEncodedParams() {
        int i = BuiltInFictitiousFunctionClassFactory + 71;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.encodedParams;
        int i3 = BuiltInFictitiousFunctionClassFactory + 103;
        lookAheadTest = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return str;
        }
        int i4 = 83 / 0;
        return str;
    }

    public void setEncodedParams(String str) {
        int i = lookAheadTest + 81;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.encodedParams = str;
        int i3 = lookAheadTest + 121;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 == 0) {
            return;
        }
        Object obj = null;
        obj.hashCode();
    }

    public boolean isIpgBinding() {
        boolean z;
        int i = lookAheadTest + 63;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? (char) 4 : 'D') != 4) {
            z = this.isIpgBinding;
        } else {
            try {
                z = this.isIpgBinding;
                int length = objArr.length;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 1;
        lookAheadTest = i2 % 128;
        if (i2 % 2 == 0) {
            objArr.hashCode();
            return z;
        }
        return z;
    }

    public void setIpgBinding(boolean z) {
        int i = BuiltInFictitiousFunctionClassFactory + 35;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.isIpgBinding = z;
        try {
            int i3 = lookAheadTest + 91;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getEncoding() {
        String str;
        int i = lookAheadTest + 41;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 != 0)) {
            try {
                str = this.encoding;
            } catch (Exception e) {
                throw e;
            }
        } else {
            str = this.encoding;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = lookAheadTest + 3;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        return str;
    }

    public void setEncoding(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 33;
            lookAheadTest = i % 128;
            Object obj = null;
            if ((i % 2 == 0 ? 'P' : '4') != '4') {
                this.encoding = str;
                obj.hashCode();
            } else {
                this.encoding = str;
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 87;
            lookAheadTest = i2 % 128;
            if (!(i2 % 2 != 0)) {
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public String getSeamlessData() {
        int i = BuiltInFictitiousFunctionClassFactory + 33;
        lookAheadTest = i % 128;
        if (i % 2 == 0) {
            try {
                int i2 = 88 / 0;
                return this.seamlessData;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.seamlessData;
    }

    public void setSeamlessData(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 69;
        lookAheadTest = i % 128;
        char c = i % 2 != 0 ? (char) 25 : (char) 2;
        this.seamlessData = str;
        if (c != 25) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public String getSeamlessSign() {
        int i = lookAheadTest + 15;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.seamlessSign;
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 67;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setSeamlessSign(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 93;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? (char) 21 : (char) 0) != 21) {
            try {
                this.seamlessSign = str;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        this.seamlessSign = str;
        Object[] objArr = null;
        int length = objArr.length;
    }

    public String getInvitationId() {
        int i = BuiltInFictitiousFunctionClassFactory + 5;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.invitationId;
        try {
            int i3 = BuiltInFictitiousFunctionClassFactory + 107;
            lookAheadTest = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 21 : '`') != '`') {
                Object obj = null;
                obj.hashCode();
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setInvitationId(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 123;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            this.invitationId = str;
            int i3 = BuiltInFictitiousFunctionClassFactory + 77;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getOrganizerName() {
        try {
            int i = lookAheadTest + 85;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            String str = this.organizerName;
            int i3 = BuiltInFictitiousFunctionClassFactory + 7;
            lookAheadTest = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setOrganizerName(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 103;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.organizerName = str;
        int i3 = BuiltInFictitiousFunctionClassFactory + 111;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
    }

    public String getQrisString() {
        int i = BuiltInFictitiousFunctionClassFactory + 67;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        String str = this.qrisString;
        int i3 = BuiltInFictitiousFunctionClassFactory + 17;
        lookAheadTest = i3 % 128;
        if ((i3 % 2 == 0 ? 'X' : (char) 0) != 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return str;
    }

    public void setQrisString(String str) {
        try {
            int i = lookAheadTest + 49;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            this.qrisString = str;
            int i3 = lookAheadTest + 89;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            int i4 = i3 % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getBizType() {
        int i = BuiltInFictitiousFunctionClassFactory + 49;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            String str = this.bizType;
            int i3 = BuiltInFictitiousFunctionClassFactory + 69;
            lookAheadTest = i3 % 128;
            if (!(i3 % 2 == 0)) {
                return str;
            }
            int i4 = 61 / 0;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setBizType(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 45;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            this.bizType = str;
            int i3 = lookAheadTest + 71;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 != 0 ? (char) 11 : ')') != ')') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isNeedOauth() {
        boolean z;
        int i = lookAheadTest + 35;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        Object[] objArr = null;
        if ((i % 2 != 0 ? '4' : '/') != '/') {
            try {
                z = this.needOauth;
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            z = this.needOauth;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 21;
        lookAheadTest = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.less : Typography.dollar) != '<') {
            return z;
        }
        int length = objArr.length;
        return z;
    }

    public void setNeedOauth(boolean z) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 47;
            lookAheadTest = i % 128;
            Object obj = null;
            if ((i % 2 == 0 ? 'b' : 'F') != 'F') {
                this.needOauth = z;
                obj.hashCode();
            } else {
                try {
                    this.needOauth = z;
                } catch (Exception e) {
                    throw e;
                }
            }
            int i2 = BuiltInFictitiousFunctionClassFactory + 61;
            lookAheadTest = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 7 : '\r') != '\r') {
                obj.hashCode();
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getBizOrderId() {
        try {
            int i = lookAheadTest + 53;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if (i % 2 != 0) {
                    String str = this.bizOrderId;
                    Object obj = null;
                    obj.hashCode();
                    return str;
                }
                return this.bizOrderId;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setBizOrderId(String str) {
        try {
            int i = lookAheadTest + 17;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            try {
                this.bizOrderId = str;
                int i3 = BuiltInFictitiousFunctionClassFactory + 113;
                lookAheadTest = i3 % 128;
                if (!(i3 % 2 != 0)) {
                    int i4 = 14 / 0;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getPaymentOrderId() {
        String str;
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        lookAheadTest = i % 128;
        if ((i % 2 == 0 ? 'P' : '*') != 'P') {
            str = this.paymentOrderId;
        } else {
            str = this.paymentOrderId;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 123;
        lookAheadTest = i2 % 128;
        if (i2 % 2 == 0) {
            int i3 = 28 / 0;
            return str;
        }
        return str;
    }

    public void setPaymentOrderId(String str) {
        int i = lookAheadTest + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? (char) 14 : 'X') == 'X') {
            this.paymentOrderId = str;
            return;
        }
        this.paymentOrderId = str;
        Object[] objArr = null;
        int length = objArr.length;
    }

    public String getToken() {
        int i = lookAheadTest + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.token;
        int i3 = BuiltInFictitiousFunctionClassFactory + 75;
        lookAheadTest = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public void setToken(String str) {
        int i = BuiltInFictitiousFunctionClassFactory + 47;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        this.token = str;
        int i3 = lookAheadTest + 103;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    public String getTransactionId() {
        try {
            int i = lookAheadTest + 61;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                int i2 = i % 2;
                String str = this.transactionId;
                int i3 = BuiltInFictitiousFunctionClassFactory + 85;
                lookAheadTest = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public void setTransactionId(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 21;
            lookAheadTest = i % 128;
            char c = i % 2 == 0 ? (char) 27 : '!';
            this.transactionId = str;
            if (c != 27) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public String getCacheKey() {
        int i = BuiltInFictitiousFunctionClassFactory + 95;
        lookAheadTest = i % 128;
        int i2 = i % 2;
        try {
            String str = this.cacheKey;
            int i3 = lookAheadTest + 47;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if ((i3 % 2 != 0 ? JSONLexer.EOI : Typography.amp) != 26) {
                return str;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setCacheKey(String str) {
        int i = lookAheadTest + 27;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        boolean z = i % 2 != 0;
        this.cacheKey = str;
        if (z) {
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = BuiltInFictitiousFunctionClassFactory + 33;
        lookAheadTest = i2 % 128;
        int i3 = i2 % 2;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DeepLinkPayloadEntity{authCode='");
        sb.append(this.authCode);
        sb.append('\'');
        sb.append(", fullUrl='");
        sb.append(this.fullUrl);
        sb.append('\'');
        sb.append(", innerUrl='");
        sb.append(this.innerUrl);
        sb.append('\'');
        sb.append(", path='");
        sb.append(this.path);
        sb.append('\'');
        sb.append(", referralCode='");
        sb.append(this.referralCode);
        sb.append('\'');
        sb.append(", shortCode='");
        sb.append(this.shortCode);
        sb.append('\'');
        sb.append(", promoCode='");
        sb.append(this.promoCode);
        sb.append('\'');
        sb.append(", action='");
        sb.append(this.action);
        sb.append('\'');
        sb.append(", params='");
        sb.append(this.params);
        sb.append('\'');
        sb.append(", skipHomePage=");
        sb.append(this.skipHomePage);
        sb.append(", responseType='");
        sb.append(this.responseType);
        sb.append('\'');
        sb.append(", clientId='");
        sb.append(this.clientId);
        sb.append('\'');
        sb.append(", phoneNumber='");
        sb.append(this.phoneNumber);
        sb.append('\'');
        sb.append(", scope='");
        sb.append(this.scope);
        sb.append('\'');
        sb.append(", state='");
        sb.append(this.state);
        sb.append('\'');
        sb.append(", codeChallenge='");
        sb.append(this.codeChallenge);
        sb.append('\'');
        sb.append(", redirectUrl='");
        sb.append(this.redirectUrl);
        sb.append('\'');
        sb.append(", needMobileToken=");
        sb.append(this.needMobileToken);
        sb.append(", isNeedAuth=");
        sb.append(this.isNeedAuth);
        sb.append(", serviceKey='");
        sb.append(this.serviceKey);
        sb.append('\'');
        sb.append(", source='");
        sb.append(this.source);
        sb.append('\'');
        sb.append(", bindDanaType='");
        sb.append(this.bindDanaType);
        sb.append('\'');
        sb.append(", acqSiteId='");
        sb.append(this.acqSiteId);
        sb.append('\'');
        sb.append(", merchantId='");
        sb.append(this.merchantId);
        sb.append('\'');
        sb.append(", merchantName='");
        sb.append(this.merchantName);
        sb.append('\'');
        sb.append(", netAuthId='");
        sb.append(this.netAuthId);
        sb.append('\'');
        sb.append(", paySiteId='");
        sb.append(this.paySiteId);
        sb.append('\'');
        sb.append(", terminalType='");
        sb.append(this.terminalType);
        sb.append('\'');
        sb.append(", signature='");
        sb.append(this.signature);
        sb.append('\'');
        sb.append(", mcc='");
        sb.append(this.mcc);
        sb.append('\'');
        sb.append(", ott='");
        sb.append(this.ott);
        sb.append('\'');
        sb.append(", android_url='");
        sb.append(this.android_url);
        sb.append('\'');
        sb.append(", referringLink='");
        sb.append(this.referringLink);
        sb.append('\'');
        sb.append(", url='");
        sb.append(this.url);
        sb.append('\'');
        sb.append(", extendedInfo='");
        sb.append(this.extendedInfo);
        sb.append('\'');
        sb.append(", codeValue='");
        sb.append(this.codeValue);
        sb.append('\'');
        sb.append(", destinationPath='");
        sb.append(this.destinationPath);
        sb.append('\'');
        sb.append(", orderId='");
        sb.append(this.orderId);
        sb.append('\'');
        sb.append(", invitationId='");
        sb.append(this.invitationId);
        sb.append('\'');
        sb.append(", organizerName='");
        sb.append(this.organizerName);
        sb.append('\'');
        sb.append(", encodedParams='");
        sb.append(this.encodedParams);
        sb.append('\'');
        sb.append(", isIpgBinding=");
        sb.append(this.isIpgBinding);
        sb.append(", seamlessData='");
        sb.append(this.seamlessData);
        sb.append('\'');
        sb.append(", seamlessSign='");
        sb.append(this.seamlessSign);
        sb.append('\'');
        sb.append(", qrisString='");
        sb.append(this.qrisString);
        sb.append('\'');
        sb.append(", encoding='");
        sb.append(this.encoding);
        sb.append('\'');
        sb.append(", bizType='");
        sb.append(this.bizType);
        sb.append('\'');
        sb.append(", needOauth=");
        sb.append(this.needOauth);
        sb.append(", bizOrderId='");
        sb.append(this.bizOrderId);
        sb.append('\'');
        sb.append(", paymentOrderId='");
        sb.append(this.paymentOrderId);
        sb.append('\'');
        sb.append(", token='");
        sb.append(this.token);
        sb.append('\'');
        sb.append(", transactionId='");
        sb.append(this.transactionId);
        sb.append('\'');
        sb.append(", cacheKey='");
        sb.append(this.cacheKey);
        sb.append('\'');
        sb.append('}');
        String obj = sb.toString();
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 55;
            lookAheadTest = i % 128;
            if ((i % 2 == 0 ? '4' : (char) 31) != '4') {
                return obj;
            }
            Object[] objArr = null;
            int length = objArr.length;
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(int i, char[] cArr, Object[] objArr) {
        C c = new C();
        char[] cArr2 = new char[cArr.length];
        c.BuiltInFictitiousFunctionClassFactory = 0;
        char[] cArr3 = new char[2];
        int i2 = $11 + 13;
        $10 = i2 % 128;
        int i3 = i2 % 2;
        while (true) {
            if ((c.BuiltInFictitiousFunctionClassFactory < cArr.length ? '%' : '7') == '%') {
                cArr3[0] = cArr[c.BuiltInFictitiousFunctionClassFactory];
                cArr3[1] = cArr[c.BuiltInFictitiousFunctionClassFactory + 1];
                int i4 = 58224;
                int i5 = 0;
                while (true) {
                    if (!(i5 >= 16)) {
                        int i6 = $10 + 63;
                        $11 = i6 % 128;
                        int i7 = i6 % 2;
                        cArr3[1] = (char) (cArr3[1] - (((cArr3[0] + i4) ^ ((cArr3[0] << 4) + ((char) (KClassImpl$Data$declaredNonStaticMembers$2 ^ 6353485791441662354L)))) ^ ((cArr3[0] >>> 5) + ((char) (PlaceComponentResult ^ 6353485791441662354L)))));
                        cArr3[0] = (char) (cArr3[0] - (((cArr3[1] + i4) ^ ((cArr3[1] << 4) + ((char) (getAuthRequestContext ^ 6353485791441662354L)))) ^ ((cArr3[1] >>> 5) + ((char) (MyBillsEntityDataFactory ^ 6353485791441662354L)))));
                        i4 -= 40503;
                        i5++;
                    }
                }
                cArr2[c.BuiltInFictitiousFunctionClassFactory] = cArr3[0];
                cArr2[c.BuiltInFictitiousFunctionClassFactory + 1] = cArr3[1];
                c.BuiltInFictitiousFunctionClassFactory += 2;
            } else {
                objArr[0] = new String(cArr2, 0, i);
                return;
            }
        }
    }
}
