package id.dana.domain.util;

import com.google.firebase.remoteconfig.RemoteConfigConstants;
import id.dana.cashier.view.InputCardNumberView;
import j$.util.DesugarTimeZone;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u0017\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\t\u0010\u0005J)\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0011\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0002*\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0005"}, d2 = {"Lid/dana/domain/util/StringUtil;", "", "", "camelCaseString", "camelToSentenceCase", "(Ljava/lang/String;)Ljava/lang/String;", "input", "convertToTitleCase", "keyword", "filterKeyword", "pattern", "Ljava/util/Locale;", "locale", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "getDateTime", "(Ljava/lang/String;Ljava/util/Locale;Ljava/lang/String;)Ljava/lang/String;", "givenName", "maskName", "capitalizeWords", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StringUtil {
    public static final StringUtil INSTANCE = new StringUtil();

    private StringUtil() {
    }

    @JvmStatic
    public static final String maskName(String givenName) {
        Intrinsics.checkNotNullParameter(givenName, "");
        StringBuilder sb = new StringBuilder();
        String str = givenName;
        if (str.length() > 0) {
            Object[] array = new Regex(" ").split(StringsKt.trim((CharSequence) str).toString(), 0).toArray(new String[0]);
            if (array != null) {
                for (String str2 : (String[]) array) {
                    int i = 3;
                    if (str2.length() <= 3) {
                        i = str2.length() > 0 ? 1 : 0;
                    }
                    String substring = str2.substring(0, i);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    String substring2 = str2.substring(i, str2.length());
                    Intrinsics.checkNotNullExpressionValue(substring2, "");
                    String replace = new Regex("(?s).").replace(substring2, "•");
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(substring);
                    sb2.append(replace);
                    String obj = sb2.toString();
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(obj);
                    sb3.append(InputCardNumberView.DIVIDER);
                    sb.append(sb3.toString());
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
        }
        String obj2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        return obj2;
    }

    @JvmStatic
    public static final String camelToSentenceCase(String camelCaseString) {
        Intrinsics.checkNotNullParameter(camelCaseString, "");
        return INSTANCE.capitalizeWords(new Regex("(?<=[a-zA-Z])[A-Z]").replace(camelCaseString, new Function1<MatchResult, CharSequence>() { // from class: id.dana.domain.util.StringUtil$camelToSentenceCase$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(MatchResult matchResult) {
                Intrinsics.checkNotNullParameter(matchResult, "");
                StringBuilder sb = new StringBuilder();
                sb.append(InputCardNumberView.DIVIDER);
                sb.append(matchResult.getValue());
                return sb.toString();
            }
        }));
    }

    public final String convertToTitleCase(String input) {
        Intrinsics.checkNotNullParameter(input, "");
        return CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) input, new String[]{" "}, false, 0, 6, (Object) null), " ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: id.dana.domain.util.StringUtil$convertToTitleCase$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str) {
                String valueOf;
                Intrinsics.checkNotNullParameter(str, "");
                String lowerCase = str.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "");
                if (lowerCase.length() > 0) {
                    StringBuilder sb = new StringBuilder();
                    char charAt = lowerCase.charAt(0);
                    if (Character.isLowerCase(charAt)) {
                        Locale locale = Locale.getDefault();
                        Intrinsics.checkNotNullExpressionValue(locale, "");
                        valueOf = CharsKt.titlecase(charAt, locale);
                    } else {
                        valueOf = String.valueOf(charAt);
                    }
                    sb.append((Object) valueOf);
                    String substring = lowerCase.substring(1);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    sb.append(substring);
                    lowerCase = sb.toString();
                }
                return lowerCase;
            }
        }, 30, null);
    }

    public final String capitalizeWords(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return CollectionsKt.joinToString$default(StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null), " ", null, null, 0, null, new Function1<String, CharSequence>() { // from class: id.dana.domain.util.StringUtil$capitalizeWords$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return StringsKt.capitalize(str2);
            }
        }, 30, null);
    }

    @JvmStatic
    public static final String getDateTime(String pattern, Locale locale, String timeZone) {
        Intrinsics.checkNotNullParameter(pattern, "");
        Intrinsics.checkNotNullParameter(locale, "");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, locale);
        if (timeZone != null) {
            simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory(timeZone));
        }
        String format = simpleDateFormat.format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    @JvmStatic
    public static final String filterKeyword(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "");
        String obj = StringsKt.trim((CharSequence) keyword).toString();
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return new Regex("\\s+").replace(lowerCase, " ");
    }
}
