package id.dana.extension.lang;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import com.alipay.mobile.zebra.data.TextData;
import id.dana.utils.TextUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import kotlin.text.Typography;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0001\u001a\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00010\u0003\u001a\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u001a \u0010\b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\t\u001a%\u0010\f\u001a\u00020\t*\u0004\u0018\u00010\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\u000f\"\u00020\r¢\u0006\u0002\u0010\u0010\u001a\n\u0010\u0011\u001a\u00020\t*\u00020\r\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u0001\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0001\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0001\u001a\u001c\u0010\u0018\u001a\u00020\u0016*\u00020\r2\u0006\u0010\u0019\u001a\u00020\u00012\b\b\u0001\u0010\u001a\u001a\u00020\u001b\u001a\"\u0010\u001c\u001a\u00020\t*\u00020\u00012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\u001e\u001a\u00020\u0001*\u00020\u0001¨\u0006\u001f"}, d2 = {"addCurrency", "", "appendQuotes", "", TextData.FONT_WEIGHT_BOLD, "Landroid/text/SpannableStringBuilder;", "targetText", "resultSpannable", "contains", "", "s", "ignoreCase", "equalsAny", "", "find", "", "(Ljava/lang/CharSequence;[Ljava/lang/CharSequence;)Z", "isAlphanumeric", "or", "defaultValue", "replaceNewLineWithSpace", "setBoldedText", "Landroid/text/Spannable;", "boldedText", "setColoredText", "coloredText", "colorRes", "", "startsWith", "prefixes", "trimWhitespaces", "app_productionRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class StringExtKt {
    public static final boolean MyBillsEntityDataFactory(CharSequence charSequence, CharSequence... charSequenceArr) {
        Intrinsics.checkNotNullParameter(charSequenceArr, "");
        return ArraysKt.contains(charSequenceArr, charSequence);
    }

    public static final boolean BuiltInFictitiousFunctionClassFactory(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        return new Regex("[A-Za-z0-9]+").matches(charSequence);
    }

    public static /* synthetic */ SpannableStringBuilder MyBillsEntityDataFactory(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        SpannableStringBuilder authRequestContext = TextUtil.getAuthRequestContext(str, str2);
        Intrinsics.checkNotNullExpressionValue(authRequestContext, "");
        return authRequestContext;
    }

    public static final Spannable BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, String str) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(str, "");
        int indexOf$default = StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null);
        int length = str.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new StyleSpan(1), indexOf$default, length + indexOf$default, 33);
        return spannableStringBuilder;
    }

    public static final Spannable BuiltInFictitiousFunctionClassFactory(CharSequence charSequence, String str, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(str, "");
        int indexOf$default = StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null);
        int length = str.length();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i), indexOf$default, length + indexOf$default, 33);
        return spannableStringBuilder;
    }

    public static final String PlaceComponentResult(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return StringsKt.isBlank(str) ? str2 : str;
    }

    public static final String BuiltInFictitiousFunctionClassFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        StringBuilder sb = new StringBuilder();
        sb.append("Rp");
        sb.append(str);
        return sb.toString();
    }

    public static final boolean KClassImpl$Data$declaredNonStaticMembers$2(List<String> list, String str) {
        Intrinsics.checkNotNullParameter(list, "");
        Intrinsics.checkNotNullParameter(str, "");
        List<String> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (StringsKt.equals((String) it.next(), str, true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final List<String> BuiltInFictitiousFunctionClassFactory(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "");
        List<String> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        for (String str : list2) {
            Intrinsics.checkNotNullParameter(str, "");
            StringBuilder sb = new StringBuilder();
            sb.append(Typography.quote);
            sb.append(str);
            sb.append(Typography.quote);
            arrayList.add(sb.toString());
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean BuiltInFictitiousFunctionClassFactory(String str, List<String> list) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(list, "");
        List<String> list2 = list;
        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                if (StringsKt.startsWith(str, (String) it.next(), true)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final String MyBillsEntityDataFactory(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.replace$default(str, "\n", " ", false, 4, (Object) null);
    }

    public static final String PlaceComponentResult(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        int length = str2.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean z2 = Intrinsics.compare((int) str2.charAt(!z ? i : length), 32) <= 0;
            if (z) {
                if (!z2) {
                    break;
                }
                length--;
            } else if (z2) {
                i++;
            } else {
                z = true;
            }
        }
        return str2.subSequence(i, length + 1).toString();
    }
}
