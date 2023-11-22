package id.dana.utils;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.net.Uri;
import android.text.Editable;
import android.text.Html;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.widget.TextView;
import com.j256.ormlite.stmt.query.SimpleComparison;

/* loaded from: classes2.dex */
public class TextUtil {
    private TextUtil() {
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str, int i) {
        String substring = str.substring(i);
        String substring2 = str.substring(0, i);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < 4; i2++) {
            sb.append(".");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(substring2.replaceAll(sb.toString(), "$0 "));
        sb2.append(substring);
        return sb2.toString();
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str, int i) {
        String substring = str.substring(i);
        String substring2 = str.substring(0, i);
        String str2 = "";
        for (int i2 = 0; i2 < 2; i2++) {
            StringBuilder sb = new StringBuilder();
            sb.append(str2);
            sb.append(".");
            str2 = sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(substring2.replaceAll(str2, "$0/"));
        sb2.append(substring);
        return sb2.toString();
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda0(String str) {
        String substring = str.substring(0, 4);
        String substring2 = str.substring(4);
        StringBuilder sb = new StringBuilder();
        sb.append(substring);
        sb.append(substring2.replaceAll(".", "•"));
        return sb.toString();
    }

    public static String getErrorConfigVersion(String str) {
        return str.length() >= 4 ? str.substring(str.length() - 4) : str;
    }

    public static String MyBillsEntityDataFactory(String str, String str2) {
        return str.replaceAll(str2, "•");
    }

    public static String PlaceComponentResult(String str) {
        return str.replace("[", "").replace("]", "");
    }

    public static String MyBillsEntityDataFactory(String str) {
        return !TextUtils.isEmpty(str) ? str.replace(" ", "") : str;
    }

    public static void getAuthRequestContext(TextView textView, ClickableSpan clickableSpan, String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        sb.append(str2);
        String obj = sb.toString();
        SpannableString spannableString = new SpannableString(obj);
        spannableString.setSpan(clickableSpan, obj.indexOf(str2), obj.length(), 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString, TextView.BufferType.SPANNABLE);
    }

    public static void getAuthRequestContext(TextView textView, ClickableSpan clickableSpan, int i, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.toLowerCase().contains(str2.toLowerCase())) {
            return;
        }
        SpannableString spannableString = new SpannableString(str);
        int indexOf = str.toLowerCase().indexOf(str2.toLowerCase());
        spannableString.setSpan(clickableSpan, indexOf, str2.length() + indexOf, 33);
        spannableString.setSpan(new ForegroundColorSpan(i), indexOf, str2.length() + indexOf, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
    }

    public static void PlaceComponentResult(TextView textView, ClickableSpan[] clickableSpanArr, int i, String str, String[] strArr) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int length = strArr.length;
        SpannableString spannableString = new SpannableString(str);
        for (int i2 = 0; i2 < clickableSpanArr.length; i2++) {
            if (strArr.length > i2 && str.toLowerCase().contains(strArr[i2].toLowerCase())) {
                int indexOf = str.toLowerCase().indexOf(strArr[i2].toLowerCase());
                spannableString.setSpan(clickableSpanArr[i2], indexOf, strArr[i2].length() + indexOf, 33);
                spannableString.setSpan(new ForegroundColorSpan(i), indexOf, strArr[i2].length() + indexOf, 33);
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                textView.setText(spannableString);
            }
        }
    }

    public static void MyBillsEntityDataFactory(TextView textView, ClickableSpan clickableSpan, int i, String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        TextPositionFinder textPositionFinder = new TextPositionFinder();
        textPositionFinder.BuiltInFictitiousFunctionClassFactory = str;
        textPositionFinder.MyBillsEntityDataFactory = str2;
        int i2 = textPositionFinder.getAuthRequestContext().PlaceComponentResult;
        TextPositionFinder authRequestContext = textPositionFinder.getAuthRequestContext();
        int length = authRequestContext.PlaceComponentResult + authRequestContext.MyBillsEntityDataFactory.length();
        spannableStringBuilder.setSpan(clickableSpan, i2, length, 33);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), i2, length, 33);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableStringBuilder);
        textView.setHighlightColor(0);
    }

    public static boolean MyBillsEntityDataFactory(Editable editable) {
        boolean isDigit;
        boolean z = editable.length() <= 19;
        for (int i = 0; i < editable.length(); i++) {
            if (i > 0 && (i + 1) % 5 == 0) {
                isDigit = ' ' == editable.charAt(i);
            } else {
                isDigit = Character.isDigit(editable.charAt(i));
            }
            z &= isDigit;
        }
        return z;
    }

    public static String scheduleImpl(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static String moveToNextValue(String str) {
        return str.replaceAll("[^\\d.]", "");
    }

    public static SpannableStringBuilder getAuthRequestContext(String str, String str2) {
        TextPositionFinder textPositionFinder = new TextPositionFinder();
        textPositionFinder.BuiltInFictitiousFunctionClassFactory = str;
        textPositionFinder.MyBillsEntityDataFactory = str2;
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        StyleSpan styleSpan = new StyleSpan(1);
        int i = textPositionFinder.getAuthRequestContext().PlaceComponentResult;
        TextPositionFinder authRequestContext = textPositionFinder.getAuthRequestContext();
        spannableStringBuilder.setSpan(styleSpan, i, authRequestContext.PlaceComponentResult + authRequestContext.MyBillsEntityDataFactory.length(), 33);
        return spannableStringBuilder;
    }

    public static SpannableStringBuilder PlaceComponentResult(String str, String... strArr) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int length = strArr.length;
        for (int i = 0; i < 2; i++) {
            String str2 = strArr[i];
            TextPositionFinder textPositionFinder = new TextPositionFinder();
            textPositionFinder.BuiltInFictitiousFunctionClassFactory = str;
            textPositionFinder.MyBillsEntityDataFactory = str2;
            StyleSpan styleSpan = new StyleSpan(1);
            int i2 = textPositionFinder.getAuthRequestContext().PlaceComponentResult;
            TextPositionFinder authRequestContext = textPositionFinder.getAuthRequestContext();
            spannableStringBuilder.setSpan(styleSpan, i2, authRequestContext.PlaceComponentResult + authRequestContext.MyBillsEntityDataFactory.length(), 33);
        }
        return spannableStringBuilder;
    }

    public static String PlaceComponentResult(Context context, double d) {
        return d >= 1.0d ? context.getString(id.dana.R.string.km_away, Double.valueOf(d)) : context.getString(id.dana.R.string.m_away, Double.valueOf(d * 1000.0d));
    }

    public static String getAuthRequestContext(Context context, double d) {
        return context.getString(id.dana.R.string.km_away, Double.valueOf(d));
    }

    public static String BuiltInFictitiousFunctionClassFactory(Context context, double d) {
        return d >= 1.0d ? context.getString(id.dana.R.string.km_away_with_dot, Double.valueOf(d)) : context.getString(id.dana.R.string.m_away_with_dot, Double.valueOf(d * 1000.0d));
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda2(String str) {
        return TextUtils.isEmpty(str) ? "" : String.format("\"%s\"", str);
    }

    public static String KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, 1).toUpperCase());
        sb.append(str.substring(1));
        return sb.toString();
    }

    public static String PlaceComponentResult(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(0, 1));
        sb.append(" ");
        sb.append(context.getString(id.dana.R.string.hide_value_with_space));
        sb.append(" ");
        sb.append(str.substring(str.indexOf(64)));
        return sb.toString();
    }

    public static String NetworkUserEntityData$$ExternalSyntheticLambda1(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String PlaceComponentResult(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("scene=");
        sb.append(str2);
        String obj = sb.toString();
        Uri parse = Uri.parse(str);
        if (!TextUtils.isEmpty(parse.getQueryParameter("params"))) {
            StringBuilder sb2 = new StringBuilder();
            String[] split = str.split("\\[", 2);
            sb2.append(split[0]);
            sb2.append("[");
            sb2.append("scene");
            sb2.append("=");
            sb2.append(str2);
            sb2.append(",");
            sb2.append(split[1]);
            return sb2.toString();
        }
        Uri.Builder buildUpon = parse.buildUpon();
        StringBuilder sb3 = new StringBuilder();
        sb3.append("[");
        sb3.append(obj);
        sb3.append("]");
        buildUpon.appendQueryParameter("params", sb3.toString());
        return buildUpon.toString();
    }

    public static String lookAheadTest(String str) {
        if (OSUtil.NetworkUserEntityData$$ExternalSyntheticLambda2()) {
            return Html.fromHtml(str, 0).toString();
        }
        return Html.fromHtml(str).toString();
    }

    public static boolean getAuthRequestContext(Context context, String str, String str2) {
        try {
            ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService("clipboard");
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(ClipData.newPlainText(str, str2));
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static String getAuthRequestContext(String str) {
        return str.replace("&lt;", SimpleComparison.LESS_THAN_OPERATION).replace("&gt;", SimpleComparison.GREATER_THAN_OPERATION);
    }

    public static String getAuthRequestContext(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("||");
        sb.append(str2);
        sb.append("||");
        sb.append(str3);
        return sb.toString();
    }

    public static String BuiltInFictitiousFunctionClassFactory(String str) {
        Object[] objArr = new Object[1];
        if (str.length() >= 4) {
            str = str.substring(str.length() - 4);
        }
        objArr[0] = str;
        return String.format("•••• %s", objArr);
    }
}
