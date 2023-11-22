package com.alipay.multimedia.adjuster.adapter;

import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.griver.image.framework.utils.Format;
import com.alibaba.griver.ui.ant.utils.AUScreenAdaptTool;
import com.alipay.multimedia.adjuster.config.ConfigConst;
import com.alipay.multimedia.adjuster.config.ConfigMgr;
import com.alipay.multimedia.adjuster.data.APMImageInfo;
import com.alipay.multimedia.adjuster.data.UrlInfo;
import com.alipay.multimedia.adjuster.utils.AliCdnUtils;
import com.alipay.multimedia.adjuster.utils.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes7.dex */
public class APMOssAdapter implements ICdnAdapter {

    /* renamed from: a  reason: collision with root package name */
    private static final Log f7324a = Log.getLogger("APMOssAdapter");
    private static Pattern b;

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public UrlInfo.Size adjustImageSize(String str, UrlInfo.Size size, UrlInfo.Size size2, APMImageInfo.CutType cutType) {
        return size;
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public boolean canExecAdapterForUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (TextUtils.isEmpty(parse.getHost()) || str.contains("_") || AliCdnUtils.checkUrlHostWithExact(parse.getHost(), ConfigMgr.getInc().getCdnConfigItem().ossCdnDomainExactBlackList) || AliCdnUtils.checkUrlWithFuzzy(str, ConfigMgr.getInc().getCdnConfigItem().ossCdnDomainFuzzyBlackList)) {
            return false;
        }
        return AliCdnUtils.checkUrlWithFuzzy(str, ConfigMgr.getInc().getCdnConfigItem().ossCdnDomainList);
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public UrlInfo getBaseUrlAndImageSize(String str) {
        int i;
        int i2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        UrlInfo urlInfo = new UrlInfo();
        urlInfo.baseUrl = str;
        int lastIndexOf = str.lastIndexOf(AUScreenAdaptTool.PREFIX_ID);
        if (lastIndexOf > 0) {
            urlInfo.baseUrl = str.substring(0, lastIndexOf);
            return a(urlInfo, str.substring(lastIndexOf, str.length()));
        }
        int indexOf = str.indexOf(".png");
        if (indexOf > 0 && str.length() > (i2 = indexOf + 4)) {
            urlInfo.baseUrl = str.substring(0, i2);
            return urlInfo;
        }
        int indexOf2 = str.indexOf(".jpg");
        if (indexOf2 > 0 && str.length() > (i = indexOf2 + 4)) {
            urlInfo.baseUrl = str.substring(0, i);
        }
        return urlInfo;
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public String adapterCdnZoomResult(String str, APMImageInfo.Format format, APMImageInfo.CutType cutType, int i, int i2, int i3, int i4, Map map) {
        String format2 = (i2 == 0 && i3 == 0) ? AUScreenAdaptTool.PREFIX_ID : String.format("@%dw_%dh_1l", Integer.valueOf(i2), Integer.valueOf(i3));
        if (APMImageInfo.CutType.CUT_TYPE_CROP == cutType) {
            StringBuilder sb = new StringBuilder();
            sb.append(format2);
            sb.append("_1e_1c");
            format2 = sb.toString();
        }
        if (i > 0 && i < 100) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(format2);
            sb2.append(String.format("_%dq", Integer.valueOf(i)));
            format2 = sb2.toString();
        }
        if (i4 > 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(format2);
            sb3.append(String.format("_%ds", Integer.valueOf(i4)));
            format2 = sb3.toString();
        }
        if (APMImageInfo.Format.FORMAT_WEBP == format) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(format2);
            sb4.append(Format.SUFFIX_WEBP);
            return sb4.toString();
        } else if (str.contains(".png")) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(format2);
            sb5.append(".src");
            return sb5.toString();
        } else {
            return format2;
        }
    }

    @Override // com.alipay.multimedia.adjuster.adapter.ICdnAdapter
    public boolean hasNotSupportCdnRule(String str, UrlInfo.Size size, APMImageInfo.CutType cutType) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String path = Uri.parse(str).getPath();
        int indexOf = path.indexOf(AUScreenAdaptTool.PREFIX_ID);
        if (indexOf > 0) {
            path = path.substring(indexOf, path.length());
        }
        return path.contains("_2e") || path.contains("_1e_1c_") || path.contains("-") || (path.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) && !path.contains("_1l_"));
    }

    private static UrlInfo a(UrlInfo urlInfo, String str) {
        try {
            if (b == null) {
                b = Pattern.compile(ConfigConst.OSS_ZOOM_REGEX);
            }
            Matcher matcher = b.matcher(str);
            if (matcher.matches() && matcher.groupCount() == 5) {
                String group = matcher.group(1);
                if (group == null) {
                    group = matcher.group(2);
                }
                String group2 = matcher.group(3);
                String group3 = matcher.group(4);
                urlInfo.originSize = new UrlInfo.Size(!TextUtils.isEmpty(group) ? Integer.parseInt(group) : 0, !TextUtils.isEmpty(group2) ? Integer.parseInt(group2) : 0);
                if (!TextUtils.isEmpty(group3)) {
                    urlInfo.quality = Integer.parseInt(group3);
                }
            }
        } catch (Exception e) {
            f7324a.e(e, "parseOssRule exp!", new Object[0]);
        }
        return urlInfo;
    }
}
