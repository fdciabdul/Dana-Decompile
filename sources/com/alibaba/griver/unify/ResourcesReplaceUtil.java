package com.alibaba.griver.unify;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.unify.model.IconModel;
import com.alibaba.griver.unify.model.ReplaceModel;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes6.dex */
public class ResourcesReplaceUtil {
    private static final String TAG = "ResourcesReplaceUtil";
    private static final Map<Integer, ReplaceModel> replaceMap = new HashMap();
    private static final Map<String, IconModel> iconfontReplaceMap = new HashMap();
    private static final Map<String, String> lottieReplaceMap = new HashMap();
    private static final Map<String, String> lottieReplaceMd5 = new HashMap();
    private static String iconfontKeyList = null;
    private static boolean isInit = false;
    private static boolean isIconFontInit = false;
    private static boolean isLottieInit = false;
    private static boolean hasIconFont = false;

    public static String getReplaceString(Resources resources, int i) {
        ReplaceModel replaceModel;
        tryInitReplaceMap(resources);
        Map<Integer, ReplaceModel> map = replaceMap;
        if (!map.containsKey(Integer.valueOf(i)) || (replaceModel = map.get(Integer.valueOf(i))) == null) {
            return null;
        }
        return getLocaleDes(replaceModel.value);
    }

    public static Drawable getReplaceDrawable(Resources resources, int i) {
        ReplaceModel replaceModel;
        tryInitReplaceMap(resources);
        Map<Integer, ReplaceModel> map = replaceMap;
        if (!map.containsKey(Integer.valueOf(i)) || (replaceModel = map.get(Integer.valueOf(i))) == null || TextUtils.isEmpty(replaceModel.value)) {
            return null;
        }
        if (replaceModel.drawable != null) {
            return replaceModel.drawable;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, replaceModel.value);
        replaceModel.drawable = bitmapDrawable;
        return bitmapDrawable;
    }

    public static Bitmap getIconFontDrawable(Resources resources, String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (iconfontKeyList == null) {
            iconfontKeyList = ConfigHelper.getDefaultSharedPreference().getString(ConfigHelper.ICONFONT_KEY_CACHE_KEY, "");
        }
        String format = String.format("%04x", Integer.valueOf(str.charAt(0)));
        if (iconfontKeyList.contains(format)) {
            tryInitIconFontMap("getIconFontDrawable");
            if (hasIconFont) {
                Map<String, IconModel> map = iconfontReplaceMap;
                if (map.containsKey(format)) {
                    IconModel iconModel = map.get(format);
                    float f = resources.getDisplayMetrics().density;
                    if (iconModel != null && getDensitySize(f, iconModel.size) == i && iconModel.color == i2) {
                        if (iconModel.bitmap == null) {
                            Bitmap decodeFile = BitmapFactory.decodeFile(iconModel.filePath);
                            StringBuilder sb = new StringBuilder();
                            sb.append("getIconFontDrawable new bitmap, bitmap = null?");
                            sb.append(decodeFile == null);
                            GriverLogger.debug(TAG, sb.toString());
                            iconModel.bitmap = decodeFile;
                            return decodeFile;
                        }
                        return iconModel.bitmap;
                    }
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("getIconFontDrawable size = ");
                    sb2.append(i);
                    sb2.append("， color = ");
                    sb2.append(getHexString(i2));
                    sb2.append("，density =");
                    sb2.append(f);
                    GriverLogger.debug(TAG, sb2.toString());
                    return null;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public static String getLottieId(String str) {
        String str2;
        String str3;
        String[] split;
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        if (isLottieInit && lottieReplaceMap.isEmpty()) {
            return str;
        }
        tryInitLottieMap("getLottieId");
        String str4 = lottieReplaceMap.get(str);
        if (TextUtils.isEmpty(str4)) {
            return str;
        }
        String localeDes = getLocaleDes(str4);
        str2 = "";
        if (TextUtils.isEmpty(localeDes) || (split = localeDes.split("\\|")) == null || split.length <= 0) {
            str3 = "";
        } else {
            String str5 = split[0];
            str2 = split.length >= 2 ? split[1] : "";
            lottieReplaceMd5.put(str5, str2);
            str3 = str2;
            str2 = str5;
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getLottieId new lottie = ");
        sb.append(str2);
        sb.append(", original lottie = ");
        sb.append(str);
        sb.append(", md5 = ");
        sb.append(str3);
        GriverLogger.debug(TAG, sb.toString());
        return str2;
    }

    public static boolean isLottieReplaced(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Map<String, String> map = lottieReplaceMd5;
        if (map.isEmpty()) {
            return false;
        }
        return map.containsKey(str);
    }

    public static String getReplacedLottieMd5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Map<String, String> map = lottieReplaceMd5;
        return map.isEmpty() ? "" : map.get(str);
    }

    private static void tryInitLottieMap(String str) {
        String[] split;
        if (isLottieInit) {
            return;
        }
        isLottieInit = true;
        try {
            String string = ConfigHelper.getDefaultSharedPreference().getString(ConfigHelper.LOTTIE_CACHE_KEY, "");
            if (!TextUtils.isEmpty(string)) {
                StringBuilder sb = new StringBuilder();
                sb.append("initLottieInCache, has config, src = ");
                sb.append(str);
                GriverLogger.debug(TAG, sb.toString());
                String[] split2 = string.split("_;");
                if (split2 == null || split2.length <= 0) {
                    return;
                }
                for (int i = 0; i < split2.length; i++) {
                    if (!TextUtils.isEmpty(split2[i]) && (split = split2[i].split("_:")) != null && split.length >= 2) {
                        String str2 = split[0];
                        String localeDes = getLocaleDes(split[1]);
                        lottieReplaceMap.put(str2, localeDes);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("lottie key = ");
                        sb2.append(str2);
                        sb2.append(", new djangoId = ");
                        sb2.append(localeDes);
                        GriverLogger.debug(TAG, sb2.toString());
                    }
                }
                return;
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("initLottieInCache, has no config, src = ");
            sb3.append(str);
            GriverLogger.debug(TAG, sb3.toString());
        } catch (Exception e) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append("initLottieInCache, e = ");
            sb4.append(e);
            GriverLogger.e(TAG, sb4.toString());
        }
    }

    private static int getDensitySize(float f, float f2) {
        if (f2 == 0.0f) {
            return 0;
        }
        double d = f * f2;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    private static String getHexString(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        sb.append(Integer.toHexString((i & 65280) | ((-16777216) & i) | (16711680 & i) | (i & 255)));
        return sb.toString();
    }

    private static void tryInitReplaceMap(Resources resources) {
        if (isInit) {
            return;
        }
        isInit = true;
        GriverLogger.debug(TAG, "initReplaceInfoInCache");
        initReplaceInfoInCache(resources);
    }

    private static void tryInitIconFontMap(String str) {
        Map<String, IconModel> iconFontModel;
        if (isIconFontInit) {
            return;
        }
        isIconFontInit = true;
        try {
            boolean contains = ConfigHelper.getDefaultSharedPreference().contains(ConfigHelper.ICONFONT_CACHE_KEY);
            StringBuilder sb = new StringBuilder();
            sb.append("initIconfontInCache, hasConfig = ");
            sb.append(contains);
            sb.append(", src = ");
            sb.append(str);
            GriverLogger.debug(TAG, sb.toString());
            if (!contains || (iconFontModel = ConfigHelper.getIconFontModel(ConfigHelper.getDefaultSharedPreference().getString(ConfigHelper.ICONFONT_CACHE_KEY, ""))) == null || iconFontModel.size() <= 0) {
                return;
            }
            Map<String, IconModel> map = iconfontReplaceMap;
            map.clear();
            map.putAll(iconFontModel);
            hasIconFont = true;
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initIconfontInCache, e = ");
            sb2.append(e);
            GriverLogger.e(TAG, sb2.toString());
        }
    }

    private static void initReplaceInfoInCache(Resources resources) {
        String[] split;
        String[] split2;
        String string = ConfigHelper.getDefaultSharedPreference().getString(ConfigHelper.CACHE_KEY, "");
        try {
            if (TextUtils.isEmpty(string) || (split = string.split("_;")) == null || split.length <= 0) {
                return;
            }
            for (int i = 0; i < split.length; i++) {
                if (!TextUtils.isEmpty(split[i]) && (split2 = split[i].split("_:")) != null && split2.length >= 2) {
                    int identifier = resources.getIdentifier(split2[0], null, null);
                    String str = split2[1];
                    if (identifier != 0 && !TextUtils.isEmpty(str)) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("resourceId = ");
                        sb.append(identifier);
                        sb.append(", new value = ");
                        sb.append(str);
                        GriverLogger.debug(TAG, sb.toString());
                        replaceMap.put(Integer.valueOf(identifier), new ReplaceModel(split2[0], str));
                    }
                }
            }
        } catch (Exception e) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initReplaceInfoInCache, e = ");
            sb2.append(e);
            GriverLogger.e(TAG, sb2.toString());
        }
    }

    private static String getLocaleDes(String str) {
        if (TextUtils.isEmpty(str)) {
            GriverLogger.debug(TAG, "getLocaleDes return empty");
            return "";
        }
        String[] split = str.split(ConfigHelper.LANGUAGE_SPIT_KEY);
        if (split == null || split.length <= 0) {
            return "";
        }
        int length = split.length;
        int alipayLocaleFlag = LocaleHelper.getInstance().getAlipayLocaleFlag();
        String str2 = split[0];
        if (alipayLocaleFlag != -1) {
            if (alipayLocaleFlag != 1) {
                if (alipayLocaleFlag != 2) {
                    if (alipayLocaleFlag != 3) {
                        if (alipayLocaleFlag != 4) {
                            str2 = null;
                        }
                    } else if (length > 3) {
                        str2 = split[3];
                    }
                } else if (length > 2) {
                    str2 = split[2];
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("getLocaleDes = ");
            sb.append(str2);
            GriverLogger.debug(TAG, sb.toString());
            return str2;
        }
        if (length > 1) {
            str2 = split[1];
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getLocaleDes = ");
        sb2.append(str2);
        GriverLogger.debug(TAG, sb2.toString());
        return str2;
    }

    public static void initDrawableInPipeline() {
        tryInitIconFontMap("initDrawableInPipeline");
        Map<String, IconModel> map = iconfontReplaceMap;
        if (map.size() > 0) {
            for (IconModel iconModel : map.values()) {
                if (iconModel.bitmap == null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("initDrawableInPipline, iconModel.key = ");
                    sb.append(iconModel.key);
                    GriverLogger.debug(TAG, sb.toString());
                    iconModel.bitmap = BitmapFactory.decodeFile(iconModel.filePath);
                }
            }
        }
        tryInitLottieMap("initDrawableInPipeline");
    }
}
