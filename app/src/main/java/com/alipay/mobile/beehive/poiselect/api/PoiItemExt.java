package com.alipay.mobile.beehive.poiselect.api;

import android.graphics.Bitmap;
import android.view.ViewConfiguration;
import com.alibaba.ariver.kernel.common.utils.StringUtils;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.JSONLexer;
import com.alibaba.griver.base.common.config.GriverConfig;
import com.alipay.mobile.map.model.geocode.PoiItem;
import com.ap.zoloz.hummer.biz.HummerConstants;
import id.dana.data.geocode.mapper.GeocoderResultMapperKt;
import java.net.URLEncoder;
import kotlin.text.Typography;
import o.VerifyPinStateManager$executeRiskChallenge$2$1;

/* loaded from: classes6.dex */
public class PoiItemExt extends PoiItem {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int BuiltInFictitiousFunctionClassFactory = 0;
    private static final String DEF_OVERSEAS_POI_URL_WITH_POI_ID = "https://render.alipay.com/p/z/fd-lifecircle/location.html?";
    private static final String DEF_POI_URL_WITH_POI_ID = "https://m.amap.com/detail/index/poiid=%s&src=alipay";
    private static final String DEF_POI_URL_WITH_SHOP_ID = "alipays://platformapi/startapp?appId=20000238&target=merchant&shopId=%s";
    private static int[] KClassImpl$Data$declaredNonStaticMembers$2 = {96165753, 869912699, -849569138, -736979609, -1448396271, 793159659, -1813641946, -728186906, -254371907, -702191640, -198369417, -2051940834, 2071945336, -231371778, 517359260, -1266374909, 30878476, 1960036977};
    private static String POI_URL_WITH_POI_ID = null;
    private static String POI_URL_WITH_SHOP_ID = null;
    private static int PlaceComponentResult = 1;
    private boolean isLocateOverseas;
    private String keyword;
    private int poiPage;
    private int poiRank;
    private Bitmap resizeBmp;
    private CharSequence snippetSpan;
    private CharSequence titleSpan;
    private String url;

    private String getStringValue(String str) {
        if (str == null) {
            int i = BuiltInFictitiousFunctionClassFactory + 109;
            PlaceComponentResult = i % 128;
            if (i % 2 == 0) {
                int i2 = 97 / 0;
            }
            str = "";
        }
        try {
            int i3 = PlaceComponentResult + 7;
            BuiltInFictitiousFunctionClassFactory = i3 % 128;
            if (i3 % 2 != 0) {
                int i4 = 54 / 0;
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getKeyword() {
        try {
            int i = PlaceComponentResult + 41;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            String str = this.keyword;
            int i3 = BuiltInFictitiousFunctionClassFactory + 79;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setKeyword(String str) {
        int i = PlaceComponentResult + 99;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if (!(i % 2 != 0)) {
            try {
                this.keyword = str;
                return;
            } catch (Exception e) {
                throw e;
            }
        }
        try {
            this.keyword = str;
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e2) {
            throw e2;
        }
    }

    public int getPoiPage() {
        int i = PlaceComponentResult + 31;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            int i3 = this.poiPage;
            int i4 = BuiltInFictitiousFunctionClassFactory + 47;
            PlaceComponentResult = i4 % 128;
            int i5 = i4 % 2;
            return i3;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setPoiPage(int i) {
        try {
            int i2 = PlaceComponentResult + 3;
            BuiltInFictitiousFunctionClassFactory = i2 % 128;
            int i3 = i2 % 2;
            this.poiPage = i;
            int i4 = PlaceComponentResult + 107;
            BuiltInFictitiousFunctionClassFactory = i4 % 128;
            if ((i4 % 2 != 0 ? '?' : '#') != '?') {
                return;
            }
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    public int getPoiRank() {
        int i = BuiltInFictitiousFunctionClassFactory + 25;
        PlaceComponentResult = i % 128;
        if (!(i % 2 != 0)) {
            try {
                int i2 = this.poiRank;
                Object[] objArr = null;
                int length = objArr.length;
                return i2;
            } catch (Exception e) {
                throw e;
            }
        }
        return this.poiRank;
    }

    public void setPoiRank(int i) {
        int i2 = PlaceComponentResult + 5;
        BuiltInFictitiousFunctionClassFactory = i2 % 128;
        int i3 = i2 % 2;
        this.poiRank = i;
        int i4 = PlaceComponentResult + 49;
        BuiltInFictitiousFunctionClassFactory = i4 % 128;
        if ((i4 % 2 != 0 ? Typography.less : '[') != '<') {
            return;
        }
        int i5 = 50 / 0;
    }

    public PoiItemExt() {
    }

    public PoiItemExt(PoiItem poiItem) {
        this(poiItem, false);
    }

    public PoiItemExt(PoiItem poiItem, boolean z) {
        setAdCode(poiItem.getAdCode());
        setAdName(poiItem.getAdName());
        setCityCode(poiItem.getCityCode());
        setCityName(poiItem.getCityName());
        setDirection(poiItem.getDirection());
        setDistance(poiItem.getDistance());
        setEmail(poiItem.getEmail());
        setEnter(poiItem.getEnter());
        setExit(poiItem.getExit());
        setLatLonPoint(poiItem.getLatLonPoint());
        setPoiId(poiItem.getPoiId());
        setPostcode(poiItem.getPostcode());
        setProvinceName(poiItem.getProvinceName());
        setProvinceCode(poiItem.getProvinceCode());
        setSnippet(poiItem.getSnippet());
        setTel(poiItem.getTel());
        setTitle(poiItem.getTitle());
        setTypeDes(poiItem.getTypeDes());
        setWebsite(poiItem.getWebsite());
        setShopID(poiItem.getShopID());
        setDtLogMonitor(poiItem.getDtLogMonitor());
        setCountry(poiItem.getCountry());
        setState(poiItem.getState());
        this.isLocateOverseas = z;
        this.url = buildUrl(z);
    }

    public JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("adCode", (Object) getAdCode());
        jSONObject.put("adName", (Object) getAdName());
        jSONObject.put("cityCode", (Object) getCityCode());
        jSONObject.put("cityName", (Object) getCityName());
        jSONObject.put("direction", (Object) getDirection());
        jSONObject.put("distance", (Object) Integer.valueOf(getDistance()));
        jSONObject.put("email", (Object) getEmail());
        jSONObject.put("enter", (Object) getEnter());
        jSONObject.put(HummerConstants.EXIT_H5_PAGE, (Object) getExit());
        jSONObject.put("latLonPoint", (Object) getLatLonPoint());
        jSONObject.put("poiId", (Object) getPoiId());
        jSONObject.put("postcode", (Object) getPostcode());
        jSONObject.put("provinceName", (Object) getProvinceName());
        jSONObject.put("provinceCode", (Object) getProvinceCode());
        jSONObject.put("snippet", (Object) getSnippet());
        jSONObject.put("tel", (Object) getTel());
        jSONObject.put("title", (Object) getTitle());
        jSONObject.put("typeDes", (Object) getTypeDes());
        jSONObject.put("website", (Object) getWebsite());
        jSONObject.put("shopID", (Object) getShopID());
        jSONObject.put("dtLogMonitor", (Object) getDtLogMonitor());
        jSONObject.put(GeocoderResultMapperKt.COUNTRY, (Object) getCountry());
        jSONObject.put("state", (Object) getState());
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 67;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            return jSONObject;
        } catch (Exception e) {
            throw e;
        }
    }

    public String buildUrl() {
        int i = BuiltInFictitiousFunctionClassFactory + 33;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        String buildUrl = buildUrl(false);
        int i3 = PlaceComponentResult + 117;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return buildUrl;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return buildUrl;
    }

    public String buildUrl(boolean z) {
        String str;
        String config;
        Object[] objArr = new Object[1];
        a((ViewConfiguration.getTouchSlop() >> 8) + 5, new int[]{-115760536, 939431463, 495560691, 535349986}, objArr);
        String intern = ((String) objArr[0]).intern();
        if (z) {
            StringBuffer stringBuffer = new StringBuffer(DEF_OVERSEAS_POI_URL_WITH_POI_ID);
            try {
                stringBuffer.append("name=");
                stringBuffer.append(URLEncoder.encode(getStringValue(getTitle()), intern));
                stringBuffer.append("&type=");
                stringBuffer.append(URLEncoder.encode(getStringValue(getTypeDes()), intern));
                stringBuffer.append("&address=");
                stringBuffer.append(URLEncoder.encode(getStringValue(getSnippet()), intern));
                if (getLatLonPoint() != null) {
                    stringBuffer.append("&latitude=");
                    stringBuffer.append(getLatLonPoint().getLatitude());
                    stringBuffer.append("&longtitude=");
                    stringBuffer.append(getLatLonPoint().getLongitude());
                }
                stringBuffer.append("&alipayCountry=");
                stringBuffer.append(URLEncoder.encode(getStringValue(getCountry()), intern));
                stringBuffer.append("&city=");
                stringBuffer.append(URLEncoder.encode(getStringValue(getCityName()), intern));
                return stringBuffer.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        if (POI_URL_WITH_POI_ID == null) {
            if (getConfig("POI_SCHEME_WITH_POI_ID") != null) {
                config = getConfig("POI_SCHEME_WITH_POI_ID");
            } else {
                int i = BuiltInFictitiousFunctionClassFactory + 121;
                PlaceComponentResult = i % 128;
                int i2 = i % 2;
                config = DEF_POI_URL_WITH_POI_ID;
            }
            POI_URL_WITH_POI_ID = config;
        }
        if (POI_URL_WITH_SHOP_ID == null) {
            int i3 = BuiltInFictitiousFunctionClassFactory + 11;
            PlaceComponentResult = i3 % 128;
            int i4 = i3 % 2;
            if ((getConfig("POI_SCHEME_WITH_SHOP_ID") == null ? 'O' : 'N') != 'O') {
                str = getConfig("POI_SCHEME_WITH_SHOP_ID");
                int i5 = BuiltInFictitiousFunctionClassFactory + 5;
                PlaceComponentResult = i5 % 128;
                int i6 = i5 % 2;
            } else {
                str = DEF_POI_URL_WITH_SHOP_ID;
            }
            POI_URL_WITH_SHOP_ID = str;
            int i7 = BuiltInFictitiousFunctionClassFactory + 47;
            PlaceComponentResult = i7 % 128;
            int i8 = i7 % 2;
        }
        if (StringUtils.isEmpty(getShopID())) {
            if (!(!StringUtils.isEmpty(getPoiId()))) {
                return null;
            }
            return String.format(POI_URL_WITH_POI_ID, getPoiId());
        }
        return String.format(POI_URL_WITH_SHOP_ID, getShopID());
    }

    public boolean isLocateOverseas() {
        int i = PlaceComponentResult + 9;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        if ((i % 2 != 0 ? '2' : (char) 16) != '2') {
            return this.isLocateOverseas;
        }
        int i2 = 10 / 0;
        return this.isLocateOverseas;
    }

    public void setLocateOverseas(boolean z) {
        int i = PlaceComponentResult + 89;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        this.isLocateOverseas = z;
        int i3 = PlaceComponentResult + 69;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        int i4 = i3 % 2;
    }

    protected String getConfig(String str) {
        try {
            int i = PlaceComponentResult + 103;
            try {
                BuiltInFictitiousFunctionClassFactory = i % 128;
                if ((i % 2 != 0 ? '`' : (char) 1) != '`') {
                    return GriverConfig.getConfig(str);
                }
                String config = GriverConfig.getConfig(str);
                Object obj = null;
                obj.hashCode();
                return config;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getUrl() {
        int i = PlaceComponentResult + 45;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        String str = this.url;
        int i3 = PlaceComponentResult + 19;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (i3 % 2 == 0) {
            return str;
        }
        Object obj = null;
        obj.hashCode();
        return str;
    }

    public void setUrl(String str) {
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 23;
            PlaceComponentResult = i % 128;
            int i2 = i % 2;
            this.url = str;
            int i3 = BuiltInFictitiousFunctionClassFactory + 83;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? (char) 1 : '/') != '/') {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public Bitmap getResizeBmp() {
        int i = BuiltInFictitiousFunctionClassFactory + 67;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        Bitmap bitmap = this.resizeBmp;
        int i3 = BuiltInFictitiousFunctionClassFactory + 5;
        PlaceComponentResult = i3 % 128;
        if (i3 % 2 != 0) {
            return bitmap;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return bitmap;
    }

    public void setResizeBmp(Bitmap bitmap) {
        int i = BuiltInFictitiousFunctionClassFactory + 59;
        PlaceComponentResult = i % 128;
        int i2 = i % 2;
        this.resizeBmp = bitmap;
        try {
            int i3 = PlaceComponentResult + 59;
            try {
                BuiltInFictitiousFunctionClassFactory = i3 % 128;
                if ((i3 % 2 != 0 ? 'T' : '\n') != 'T') {
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PoiItemExt{title='");
        sb.append(getTitle());
        sb.append('\'');
        sb.append("snippet='");
        sb.append(getSnippet());
        sb.append('\'');
        sb.append("poiId='");
        sb.append(getPoiId());
        sb.append('\'');
        sb.append("shopId='");
        sb.append(getShopID());
        sb.append('\'');
        sb.append("url='");
        sb.append(getUrl());
        sb.append('\'');
        sb.append('}');
        String obj = sb.toString();
        try {
            int i = BuiltInFictitiousFunctionClassFactory + 1;
            PlaceComponentResult = i % 128;
            if ((i % 2 == 0 ? (char) 5 : '\r') != 5) {
                return obj;
            }
            Object obj2 = null;
            obj2.hashCode();
            return obj;
        } catch (Exception e) {
            throw e;
        }
    }

    public CharSequence getTitleSpan() {
        int i = PlaceComponentResult + 9;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        try {
            CharSequence charSequence = this.titleSpan;
            int i3 = BuiltInFictitiousFunctionClassFactory + 65;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? 'U' : '6') != '6') {
                Object[] objArr = null;
                int length = objArr.length;
                return charSequence;
            }
            return charSequence;
        } catch (Exception e) {
            throw e;
        }
    }

    public void setTitleSpan(CharSequence charSequence) {
        try {
            int i = PlaceComponentResult + 39;
            BuiltInFictitiousFunctionClassFactory = i % 128;
            int i2 = i % 2;
            this.titleSpan = charSequence;
            int i3 = BuiltInFictitiousFunctionClassFactory + 25;
            PlaceComponentResult = i3 % 128;
            if ((i3 % 2 == 0 ? JSONLexer.EOI : '\'') != 26) {
                return;
            }
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    public CharSequence getSnippetSpan() {
        int i = PlaceComponentResult + 83;
        BuiltInFictitiousFunctionClassFactory = i % 128;
        int i2 = i % 2;
        CharSequence charSequence = this.snippetSpan;
        int i3 = PlaceComponentResult + 31;
        BuiltInFictitiousFunctionClassFactory = i3 % 128;
        if (!(i3 % 2 != 0)) {
            return charSequence;
        }
        int i4 = 16 / 0;
        return charSequence;
    }

    public void setSnippetSpan(CharSequence charSequence) {
        int i = BuiltInFictitiousFunctionClassFactory + 35;
        PlaceComponentResult = i % 128;
        if ((i % 2 == 0 ? (char) 31 : '[') == '[') {
            this.snippetSpan = charSequence;
            return;
        }
        this.snippetSpan = charSequence;
        Object obj = null;
        obj.hashCode();
    }

    private static void a(int i, int[] iArr, Object[] objArr) {
        int i2;
        int i3;
        VerifyPinStateManager$executeRiskChallenge$2$1 verifyPinStateManager$executeRiskChallenge$2$1 = new VerifyPinStateManager$executeRiskChallenge$2$1();
        char c = 4;
        char[] cArr = new char[4];
        int i4 = 2;
        char[] cArr2 = new char[iArr.length * 2];
        int[] iArr2 = KClassImpl$Data$declaredNonStaticMembers$2;
        if (iArr2 != null) {
            int length = iArr2.length;
            int[] iArr3 = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                int i6 = $10 + 15;
                $11 = i6 % 128;
                int i7 = i6 % 2;
                iArr3[i5] = (int) (iArr2[i5] ^ (-3152031022165484798L));
            }
            iArr2 = iArr3;
        }
        int length2 = iArr2.length;
        int[] iArr4 = new int[length2];
        int[] iArr5 = KClassImpl$Data$declaredNonStaticMembers$2;
        if ((iArr5 != null ? ';' : ',') != ';') {
            i2 = length2;
        } else {
            int length3 = iArr5.length;
            int[] iArr6 = new int[length3];
            int i8 = $11 + 73;
            $10 = i8 % 128;
            int i9 = i8 % 2;
            int i10 = 0;
            while (true) {
                if ((i10 < length3 ? 'D' : (char) 4) == c) {
                    break;
                }
                int i11 = $10 + 67;
                $11 = i11 % 128;
                if (i11 % i4 == 0) {
                    i3 = length2;
                    iArr6[i10] = (int) (iArr5[i10] * (-3152031022165484798L));
                    i10 >>= 1;
                } else {
                    i3 = length2;
                    iArr6[i10] = (int) (iArr5[i10] ^ (-3152031022165484798L));
                    i10++;
                }
                length2 = i3;
                c = 4;
                i4 = 2;
            }
            i2 = length2;
            iArr5 = iArr6;
        }
        System.arraycopy(iArr5, 0, iArr4, 0, i2);
        verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory = 0;
        while (verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory < iArr.length) {
            cArr[0] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory] >> 16);
            cArr[1] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory];
            cArr[2] = (char) (iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1] >> 16);
            cArr[3] = (char) iArr[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory + 1];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = (cArr[0] << 16) + cArr[1];
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = (cArr[2] << 16) + cArr[3];
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            for (int i12 = 0; i12 < 16; i12++) {
                int i13 = $10 + 39;
                $11 = i13 % 128;
                int i14 = i13 % 2;
                try {
                    try {
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[i12];
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = VerifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext(verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext) ^ verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        int i15 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
                        verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
                        verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i15;
                    } catch (Exception e) {
                        throw e;
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
            int i16 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult = i16;
            verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult ^= iArr4[16];
            verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext ^= iArr4[17];
            int i17 = verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            int i18 = verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            cArr[0] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext >>> 16);
            cArr[1] = (char) verifyPinStateManager$executeRiskChallenge$2$1.getAuthRequestContext;
            cArr[2] = (char) (verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult >>> 16);
            cArr[3] = (char) verifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult;
            VerifyPinStateManager$executeRiskChallenge$2$1.PlaceComponentResult(iArr4);
            cArr2[verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2] = cArr[0];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 1] = cArr[1];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 2] = cArr[2];
            cArr2[(verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory * 2) + 3] = cArr[3];
            verifyPinStateManager$executeRiskChallenge$2$1.BuiltInFictitiousFunctionClassFactory += 2;
        }
        objArr[0] = new String(cArr2, 0, i);
    }
}
