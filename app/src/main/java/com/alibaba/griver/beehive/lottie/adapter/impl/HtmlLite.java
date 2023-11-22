package com.alibaba.griver.beehive.lottie.adapter.impl;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TextAppearanceSpan;
import android.text.style.TypefaceSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import com.alibaba.griver.api.common.monitor.GriverMonitorConstants;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alipay.mobile.zebra.data.TextData;
import com.alipay.mobile.zebra.data.ZebraData;
import com.caverock.androidsvg.SVGParser;
import com.huawei.hms.framework.common.ContainerUtils;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes6.dex */
public class HtmlLite {
    private static final String TAG = "HtmlLite";
    private static final Pattern pattern = Pattern.compile("\\s*([\\w|-]+)\\s*=\\s*[\"|']?([^\"'\\s]+)[\"|']?");
    private static final HashMap<String, Integer> sColorNameMap;
    private static final HashMap<String, String> sHtmlEntities;
    private static final HashMap<String, Integer> sWeight;

    /* loaded from: classes6.dex */
    public interface UrlSpanFactory {
        URLSpan createInstance(String str);
    }

    static {
        HashMap<String, String> hashMap = new HashMap<>();
        sHtmlEntities = hashMap;
        HashMap<String, Integer> hashMap2 = new HashMap<>();
        sColorNameMap = hashMap2;
        HashMap<String, Integer> hashMap3 = new HashMap<>();
        sWeight = hashMap3;
        hashMap.put("&nbsp;", " ");
        hashMap.put("&lt;", SimpleComparison.LESS_THAN_OPERATION);
        hashMap.put("&gt;", SimpleComparison.GREATER_THAN_OPERATION);
        hashMap.put("&amp;", ContainerUtils.FIELD_DELIMITER);
        hashMap.put("&quot;", "\"");
        hashMap.put("&apos;", "'");
        hashMap.put("&cent;", "￠");
        hashMap.put("&pound;", "");
        hashMap.put("&yen;", "¥");
        hashMap.put("&euro;", "€");
        hashMap.put("&sect;", "§");
        hashMap.put("&copy;", "©");
        hashMap.put("&reg;", "®");
        hashMap.put("&trade;", "™");
        hashMap.put("&times;", "×");
        hashMap.put("&divide;", "÷");
        hashMap.put("&middot;", "·");
        hashMap2.put("black", -16777216);
        hashMap2.put("darkgray", -12303292);
        hashMap2.put("gray", -7829368);
        hashMap2.put("lightgray", -3355444);
        hashMap2.put("white", -1);
        hashMap2.put("red", -65536);
        hashMap2.put("green", -16711936);
        hashMap2.put("blue", -16776961);
        hashMap2.put("yellow", -256);
        hashMap2.put("cyan", -16711681);
        hashMap2.put("magenta", -65281);
        hashMap2.put("aqua", -16711681);
        hashMap2.put("fuchsia", -65281);
        hashMap2.put("darkgrey", -12303292);
        hashMap2.put("grey", -7829368);
        hashMap2.put("lightgrey", -3355444);
        hashMap2.put("lime", -16711936);
        hashMap2.put("maroon", -8388608);
        hashMap2.put("navy", -16777088);
        hashMap2.put("olive", -8355840);
        hashMap2.put("purple", -8388480);
        hashMap2.put("silver", -4144960);
        hashMap2.put("teal", -16744320);
        hashMap3.put(TextData.FONT_WEIGHT_BOLD, 1);
        hashMap3.put("normal", 0);
        hashMap3.put("italic", 2);
    }

    /* loaded from: classes6.dex */
    public static class E {
        public static final String TEXT = "text";
        public ArrayList<E> children;
        public Map<String, String> props;
        public String tag;
        public String text;

        public String toString() {
            Object obj;
            StringBuilder sb = new StringBuilder();
            sb.append("tag: ");
            sb.append(this.tag);
            sb.append(", text: ");
            sb.append(this.text);
            sb.append(" children: ");
            if (this.children == null) {
                obj = 0;
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.children.size());
                sb2.append(", props: ");
                sb2.append(this.props);
                obj = sb2.toString();
            }
            sb.append(obj);
            return sb.toString();
        }
    }

    public static Spannable fromHtml(Context context, float f, String str, UrlSpanFactory urlSpanFactory) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        boolean z = str.indexOf(ContainerUtils.FIELD_DELIMITER) != -1;
        if (str.indexOf(SimpleComparison.LESS_THAN_OPERATION) == -1 && !z) {
            spannableStringBuilder.append((CharSequence) str);
            return spannableStringBuilder;
        }
        E e = new E();
        if (z) {
            str = convertHtmlEntities(str);
        }
        parse(str, e);
        return buildSpan(e, spannableStringBuilder, f, urlSpanFactory, context);
    }

    private static Spannable buildSpan(E e, SpannableStringBuilder spannableStringBuilder, float f, UrlSpanFactory urlSpanFactory, Context context) {
        URLSpan uRLSpan;
        int htmlColor;
        if (e != null && e.children == null && !TextUtils.isEmpty(e.text)) {
            if (e.props != null) {
                int length = spannableStringBuilder.length();
                spannableStringBuilder.append((CharSequence) e.text);
                int length2 = spannableStringBuilder.length();
                for (String str : e.props.keySet()) {
                    String str2 = e.props.get(str);
                    if (GriverMonitorConstants.KEY_SIZE.equals(str)) {
                        int fontSize = getFontSize(f, str2);
                        if (fontSize != 0) {
                            spannableStringBuilder.setSpan(new TextAppearanceSpan(null, 0, fontSize, null, null), length, length2, 17);
                        }
                    } else if ("color".equals(str)) {
                        int htmlColor2 = getHtmlColor(str2);
                        if (htmlColor2 != -1) {
                            spannableStringBuilder.setSpan(new ForegroundColorSpan(htmlColor2 | (-16777216)), length, length2, 17);
                        }
                    } else if (ZebraData.ATTR_BACKGROUND.equals(str) || ZebraData.ATTR_BG_COLOR.equals(str)) {
                        int htmlColor3 = getHtmlColor(str2);
                        if (htmlColor3 != -1) {
                            spannableStringBuilder.setSpan(new BackgroundColorSpan(htmlColor3 | (-16777216)), length, length2, 17);
                        }
                    } else if ("weight".equals(str)) {
                        spannableStringBuilder.setSpan(new StyleSpan(getFontWeight(str2)), length, length2, 17);
                    } else if ("decoration".equals(str)) {
                        if ("line-through".equals(str2)) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), length, length2, 17);
                        } else if ("underline".equals(str2)) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), length, length2, 17);
                        }
                    } else if (SVGParser.XML_STYLESHEET_ATTR_HREF.equals(str)) {
                        if (urlSpanFactory != null) {
                            uRLSpan = urlSpanFactory.createInstance(str2);
                        } else {
                            uRLSpan = new URLSpan(str2);
                        }
                        spannableStringBuilder.setSpan(uRLSpan, length, length2, 17);
                    } else if ("alinkcolor".equals(str) && (htmlColor = getHtmlColor(str2)) != -1) {
                        spannableStringBuilder.setSpan(new LinkColorSpan(htmlColor | (-16777216)), length, length2, 17);
                    }
                }
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("append: e.text: ");
                sb.append(e);
                GriverLogger.d(TAG, sb.toString());
                spannableStringBuilder.append((CharSequence) e.text);
            }
        } else {
            for (int i = 0; i < e.children.size(); i++) {
                buildSpan(e.children.get(i), spannableStringBuilder, f, urlSpanFactory, context);
            }
        }
        return spannableStringBuilder;
    }

    private static void parse(String str, E e) {
        String substring;
        while (true) {
            int i = 0;
            if (str.startsWith(SimpleComparison.LESS_THAN_OPERATION)) {
                int indexOf = str.indexOf(" ");
                HashMap hashMap = null;
                if (indexOf != -1) {
                    i = indexOf;
                    substring = str.substring(1, indexOf);
                } else {
                    substring = str.substring(1, str.indexOf(SimpleComparison.GREATER_THAN_OPERATION));
                }
                int indexOf2 = str.indexOf(SimpleComparison.GREATER_THAN_OPERATION, i);
                if (indexOf2 == -1) {
                    return;
                }
                Matcher matcher = pattern.matcher(str.substring(i, indexOf2).trim());
                while (matcher.find()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    if (hashMap == null) {
                        hashMap = new HashMap();
                    }
                    hashMap.put(group, group2);
                }
                StringBuilder sb = new StringBuilder();
                sb.append("</");
                sb.append(substring);
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                String obj = sb.toString();
                int indexOf3 = str.indexOf(obj);
                if (indexOf3 == -1) {
                    return;
                }
                E e2 = new E();
                e2.tag = substring;
                e2.props = hashMap;
                String substring2 = str.substring(indexOf2 + 1, indexOf3);
                if ("font".equals(substring)) {
                    e2.text = substring2;
                } else if ("a".equals(substring)) {
                    if (substring2.indexOf(SimpleComparison.LESS_THAN_OPERATION) == -1) {
                        e2.text = substring2;
                    } else {
                        parse(substring2, e2);
                    }
                }
                if (e.children == null) {
                    e.children = new ArrayList<>();
                }
                e.children.add(e2);
                if (e.tag != null || obj.length() + indexOf3 > str.length() - 1) {
                    return;
                }
                str = str.substring(indexOf3 + obj.length(), str.length());
            } else {
                int indexOf4 = str.indexOf(SimpleComparison.LESS_THAN_OPERATION);
                if (e.children == null) {
                    e.children = new ArrayList<>();
                }
                if (indexOf4 != -1) {
                    E e3 = new E();
                    e3.text = str.substring(0, indexOf4);
                    e3.tag = "text";
                    e.children.add(e3);
                    str = str.substring(indexOf4, str.length());
                } else {
                    E e4 = new E();
                    e4.text = str;
                    e4.tag = "text";
                    e.children.add(e4);
                    return;
                }
            }
        }
    }

    public static String convertHtmlEntities(String str) {
        for (String str2 : sHtmlEntities.keySet()) {
            str = str.replace(str2, sHtmlEntities.get(str2));
        }
        return str;
    }

    public static boolean hasHtmlEntityChar(String str) {
        if (str == null) {
            return false;
        }
        Iterator<String> it = sHtmlEntities.keySet().iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static int getHtmlColor(String str) {
        Integer num = sColorNameMap.get(str.toLowerCase(Locale.ROOT));
        if (num != null) {
            return num.intValue();
        }
        try {
            return convertValueToInt(str, -1);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static int getFontWeight(String str) {
        Integer num = sWeight.get(str.toLowerCase(Locale.ROOT));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    private static int getFontSize(float f, String str) {
        String substring;
        if (str == null) {
            return 0;
        }
        String trim = str.trim();
        try {
            try {
                if (!trim.endsWith("px") && !trim.endsWith("pt")) {
                    substring = trim;
                    return (int) (Integer.valueOf(substring).intValue() * f);
                }
                substring = trim.substring(0, trim.length() - 2);
                return (int) (Integer.valueOf(substring).intValue() * f);
            } catch (Throwable th) {
                GriverLogger.e(TAG, "mpaas-tag", th);
                return 0;
            }
        } catch (Throwable unused) {
            return (int) (Integer.valueOf(trim).intValue() * f);
        }
    }

    public static final int convertValueToInt(CharSequence charSequence, int i) {
        int i2;
        int i3;
        if (charSequence == null) {
            return i;
        }
        String charSequence2 = charSequence.toString();
        int length = charSequence2.length();
        int i4 = 10;
        if ('-' == charSequence2.charAt(0)) {
            i2 = -1;
            i3 = 1;
        } else {
            i2 = 1;
            i3 = 0;
        }
        if ('0' == charSequence2.charAt(i3)) {
            if (i3 == length - 1) {
                return 0;
            }
            int i5 = i3 + 1;
            char charAt = charSequence2.charAt(i5);
            if ('x' == charAt || 'X' == charAt) {
                i3 += 2;
                i4 = 16;
            } else {
                i4 = 8;
                i3 = i5;
            }
        } else if ('#' == charSequence2.charAt(i3)) {
            i3++;
            i4 = 16;
        }
        return Integer.parseInt(charSequence2.substring(i3), i4) * i2;
    }

    /* loaded from: classes6.dex */
    public static class CustomTypefaceSpan extends TypefaceSpan {
        private final Typeface newType;

        public CustomTypefaceSpan(String str, Typeface typeface) {
            super(str);
            this.newType = typeface;
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            applyCustomTypeFace(textPaint, this.newType);
        }

        @Override // android.text.style.TypefaceSpan, android.text.style.MetricAffectingSpan
        public void updateMeasureState(TextPaint textPaint) {
            applyCustomTypeFace(textPaint, this.newType);
        }

        private static void applyCustomTypeFace(Paint paint, Typeface typeface) {
            Typeface typeface2 = paint.getTypeface();
            int style = (typeface2 == null ? 0 : typeface2.getStyle()) & (typeface.getStyle() ^ (-1));
            if ((style & 1) != 0) {
                paint.setFakeBoldText(true);
            }
            if ((style & 2) != 0) {
                paint.setTextSkewX(-0.25f);
            }
            paint.setTypeface(typeface);
        }
    }
}
