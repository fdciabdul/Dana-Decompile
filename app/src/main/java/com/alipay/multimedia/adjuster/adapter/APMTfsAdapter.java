package com.alipay.multimedia.adjuster.adapter;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.multimedia.adjuster.config.ConfigConst;
import com.alipay.multimedia.adjuster.config.ConfigMgr;
import com.alipay.multimedia.adjuster.data.APMImageInfo;
import com.alipay.multimedia.adjuster.data.UrlInfo;
import com.alipay.multimedia.adjuster.utils.AliCdnUtils;
import com.alipay.multimedia.adjuster.utils.Log;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class APMTfsAdapter implements ICdnAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final Log f7325a = Log.getLogger("APMTfsAdapter");
    private static Pattern b;
    private static Pattern c;
    private static Pattern d;

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public boolean canExecAdapterForUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getHost()) || AliCdnUtils.checkUrlHostWithExact(parse.getHost(), ConfigMgr.getInc().getCdnConfigItem().tfsCdnDomainExactBlackList) || AliCdnUtils.checkUrlWithFuzzy(str, ConfigMgr.getInc().getCdnConfigItem().tfsCdnDomainFuzzyBlackList)) {
            return false;
        }
        return AliCdnUtils.checkUrlWithFuzzy(str, ConfigMgr.getInc().getCdnConfigItem().tfsCdnDomainList);
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public UrlInfo getBaseUrlAndImageSize(String str) {
        int i;
        int i2;
        int indexOf;
        String str2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UrlInfo urlInfo = new UrlInfo();
        urlInfo.baseUrl = str;
        int lastIndexOf = str.lastIndexOf("/");
        String substring = (lastIndexOf <= 0 || lastIndexOf >= str.length()) ? str : str.substring(lastIndexOf + 1, str.length());
        int indexOf2 = substring.indexOf("_");
        if (indexOf2 > 0 && indexOf2 < substring.length()) {
            str2 = substring.substring(indexOf2, substring.length());
        }
        if (!TextUtils.isEmpty(str2)) {
            if (!str2.contains("q90") && !str2.contains("Q90")) {
                if (!str2.contains("q75") && !str2.contains("Q75")) {
                    if (!str2.contains("q60") && !str2.contains("Q60")) {
                        if (!str2.contains("q50") && !str2.contains("Q50")) {
                            if (str2.contains("q30") || str2.contains("Q30")) {
                                urlInfo.quality = 30;
                            }
                        } else {
                            urlInfo.quality = 50;
                        }
                    } else {
                        urlInfo.quality = 60;
                    }
                } else {
                    urlInfo.quality = 75;
                }
            } else {
                urlInfo.quality = 90;
            }
            if (ConfigMgr.getInc().getCdnConfigItem().useOldCdnParseImageSizeRegex()) {
                Matcher a2 = a(str2);
                if (a2 != null && a2.matches() && a2.groupCount() == 5) {
                    int parseInt = Integer.parseInt(a2.group(2));
                    int parseInt2 = Integer.parseInt(a2.group(3));
                    if (parseInt > 0 && parseInt2 > 0) {
                        urlInfo.originSize = new UrlInfo.Size(parseInt, parseInt2);
                        if (!TextUtils.isEmpty(a2.group(0)) && str.length() > (indexOf = str.indexOf(a2.group(0)))) {
                            urlInfo.baseUrl = str.substring(0, indexOf);
                        }
                        return urlInfo;
                    }
                }
                Matcher b2 = b(str2);
                if (b2 != null && b2.matches() && b2.groupCount() == 3) {
                    int parseInt3 = Integer.parseInt(b2.group(1));
                    int parseInt4 = Integer.parseInt(b2.group(2));
                    if (parseInt3 > 0 && parseInt4 > 0) {
                        urlInfo.originSize = new UrlInfo.Size(parseInt3, parseInt4);
                    }
                    urlInfo.baseUrl = str.substring(0, str.length() - b2.group(0).length());
                    return urlInfo;
                }
            } else {
                Matcher c2 = c(str);
                if (c2 != null && c2.matches() && c2.groupCount() > 4) {
                    int parseInt5 = !TextUtils.isEmpty(c2.group(3)) ? Integer.parseInt(c2.group(3)) : 0;
                    int parseInt6 = !TextUtils.isEmpty(c2.group(4)) ? Integer.parseInt(c2.group(4)) : 0;
                    if (parseInt5 > 0 || parseInt6 > 0) {
                        urlInfo.originSize = new UrlInfo.Size(parseInt5, parseInt6);
                        if (!TextUtils.isEmpty(c2.group(1))) {
                            urlInfo.baseUrl = c2.group(1);
                        }
                        return urlInfo;
                    }
                }
            }
        }
        int indexOf3 = str.indexOf(".png");
        if (indexOf3 > 0 && str.length() > (i2 = indexOf3 + 4)) {
            urlInfo.baseUrl = str.substring(0, i2);
            return urlInfo;
        }
        int indexOf4 = str.indexOf(".jpg");
        if (indexOf4 > 0 && str.length() > (i = indexOf4 + 4)) {
            urlInfo.baseUrl = str.substring(0, i);
        }
        return urlInfo;
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public String adapterCdnZoomResult(String str, APMImageInfo.Format format, APMImageInfo.CutType cutType, int i, int i2, int i3, int i4, Map map) {
        String format2 = (i2 == 0 && i3 == 0) ? "_" : String.format("_%dx%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (APMImageInfo.CutType.CUT_TYPE_CROP == cutType && i2 != 0 && i3 != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(format2);
            sb.append("xz");
            format2 = sb.toString();
        }
        if (i > 0 && i <= 100) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(format2);
            sb2.append(String.format("q%d", Integer.valueOf(i)));
            format2 = sb2.toString();
        }
        if (i4 > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(format2);
            sb3.append(String.format("s%d", Integer.valueOf(i4)));
            format2 = sb3.toString();
        }
        if (APMImageInfo.Format.FORMAT_HEIC == format) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(format2);
            sb4.append("_.heic");
            return sb4.toString();
        } else if (APMImageInfo.Format.FORMAT_WEBP == format) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(format2);
            sb5.append(".jpg_.webp");
            return sb5.toString();
        } else {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(format2);
            sb6.append(".jpg");
            return sb6.toString();
        }
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public boolean hasNotSupportCdnRule(String str, UrlInfo.Size size, APMImageInfo.CutType cutType) {
        if (!TextUtils.isEmpty(str) && size != null && cutType != null) {
            Uri parse = Uri.parse(str);
            if (TextUtils.isEmpty(parse.getPath())) {
                return false;
            }
            if (APMImageInfo.CutType.CUT_TYPE_CROP == cutType && Math.abs((size.mWidth / size.mHeight) - 1) > 0.1d) {
                return true;
            }
            String path = parse.getPath();
            int indexOf = path.indexOf("_");
            if (indexOf > 0 && indexOf < path.length()) {
                String substring = path.substring(indexOf, path.length());
                if (substring.indexOf("xz") > 0 || substring.indexOf("co0") > 0) {
                    return true;
                }
                return substring.matches("cy(\\d+)i|cx(\\d+)i");
            }
        }
        return false;
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public UrlInfo.Size adjustImageSize(String str, UrlInfo.Size size, UrlInfo.Size size2, APMImageInfo.CutType cutType) {
        if (size == null) {
            return size;
        }
        int i = size.mWidth;
        int i2 = size.mHeight;
        if (size.mHeight >= 10000) {
            int i3 = size.mWidth;
            if (size2 != null && size2.mWidth > 0) {
                i3 = (int) a(size2.mWidth);
            }
            return new UrlInfo.Size(adaptWidthOf10000HeightWithImageWidth(i3), i2);
        } else if (size.mWidth >= 10000) {
            int i4 = size.mHeight;
            if (size2 != null && size2.mHeight > 0) {
                i4 = (int) a(size2.mHeight);
            }
            return new UrlInfo.Size(i, adaptHeightOf10000WidthWithImageHeight(i4));
        } else {
            return adaptImageSizeWithImageSize(size, cutType);
        }
    }

    private float a(float f) {
        float screenScale = AliCdnUtils.getScreenScale();
        return screenScale > 2.0f ? f * 3.0f : screenScale > 1.0f ? f * 2.0f : f;
    }

    public int adaptWidthOf10000HeightWithImageWidth(int i) {
        int[] iArr = ConfigMgr.getInc().getCdnConfigItem().cdnWidthListOf10000Height;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i4 = iArr[i2];
            if (i4 >= i) {
                i = i4 - i > i - i3 ? i3 : i4;
            } else {
                i2++;
                i3 = i4;
            }
        }
        int i5 = iArr[0];
        if (i < i5) {
            i = i5;
        }
        return i > iArr[iArr.length + (-1)] ? iArr[iArr.length - 1] : i;
    }

    public int adaptHeightOf10000WidthWithImageHeight(int i) {
        int[] iArr = ConfigMgr.getInc().getCdnConfigItem().cdnHeightListOf10000Width;
        int length = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i4 = iArr[i2];
            if (i4 >= i) {
                i = i4 - i > i - i3 ? i3 : i4;
            } else {
                i2++;
                i3 = i4;
            }
        }
        int i5 = iArr[0];
        if (i < i5) {
            i = i5;
        }
        return i > iArr[iArr.length + (-1)] ? iArr[iArr.length - 1] : i;
    }

    public UrlInfo.Size adaptImageSizeWithImageSize(UrlInfo.Size size, APMImageInfo.CutType cutType) {
        int[] iArr;
        int max = Math.max(size.mWidth, size.mHeight);
        if (APMImageInfo.CutType.CUT_TYPE_SCALE != cutType && APMImageInfo.CutType.CUT_TYPE_CROP == cutType) {
            iArr = ConfigMgr.getInc().getCdnConfigItem().cdnXZImageSizeList;
        } else {
            iArr = ConfigMgr.getInc().getCdnConfigItem().cdnImageSizeList;
        }
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i3 = iArr[i];
            if (i3 >= max) {
                max = ((float) max) < ((float) i2) * 1.0f ? i2 : i3;
            } else {
                i++;
                i2 = i3;
            }
        }
        int i4 = iArr[0];
        if (max < i4) {
            max = i4;
        }
        if (max > iArr[iArr.length - 1]) {
            max = iArr[iArr.length - 1];
        }
        return new UrlInfo.Size(max, max);
    }

    private static Matcher a(String str) {
        try {
            if (b == null) {
                b = Pattern.compile(ConfigConst.TFS_ZOOM_REGEX);
            }
            return b.matcher(str);
        } catch (Exception e) {
            f7325a.e(e, "parseTfsRule exp!", new Object[0]);
            return null;
        }
    }

    private static Matcher b(String str) {
        try {
            if (c == null) {
                c = Pattern.compile(ConfigConst.TFS_ZOOM_WH_REGEX);
            }
            return c.matcher(str);
        } catch (Exception e) {
            f7325a.e(e, "parseTfsWHRule exp!", new Object[0]);
            return null;
        }
    }

    private static Matcher c(String str) {
        try {
            if (d == null) {
                d = Pattern.compile(ConfigMgr.getInc().getCdnConfigItem().tfsCdnParseImageSizeRegex);
            }
            return d.matcher(str);
        } catch (Exception e) {
            f7325a.e(e, "parseNewTfsRule exp!", new Object[0]);
            return null;
        }
    }
}
