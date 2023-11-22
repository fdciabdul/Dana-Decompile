package kotlin.text;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\r\u001a#\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0013\u0010\u0006\u001a\u00020\u0005*\u00020\u0000H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u001b\u0010\b\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001aL\u0010\u000e\u001a\u00020\u0000*\b\u0012\u0004\u0012\u00020\u00000\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00000\u00022\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u0002H\u0082\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001b\u0010\u0011\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u0000¢\u0006\u0004\b\u0011\u0010\t\u001a%\u0010\u0013\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0011\u0010\u0015\u001a\u00020\u0000*\u00020\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a\u001b\u0010\u0017\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u0000¢\u0006\u0004\b\u0017\u0010\t"}, d2 = {"", "indent", "Lkotlin/Function1;", "getIndentFunction$StringsKt__IndentKt", "(Ljava/lang/String;)Lkotlin/jvm/functions/Function1;", "", "indentWidth$StringsKt__IndentKt", "(Ljava/lang/String;)I", "prependIndent", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "", "resultSizeEstimate", "indentAddFunction", "indentCutFunction", "reindent$StringsKt__IndentKt", "(Ljava/util/List;ILkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "newIndent", "replaceIndent", "marginPrefix", "replaceIndentByMargin", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "trimIndent", "(Ljava/lang/String;)Ljava/lang/String;", "trimMargin"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static /* synthetic */ String trimMargin$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return StringsKt.trimMargin(str, str2);
    }

    public static final String trimMargin(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return StringsKt.replaceIndentByMargin(str, "", str2);
    }

    public static /* synthetic */ String replaceIndentByMargin$default(String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        if ((i & 2) != 0) {
            str3 = HiAnalyticsConstant.REPORT_VAL_SEPARATOR;
        }
        return StringsKt.replaceIndentByMargin(str, str2, str3);
    }

    public static final String replaceIndentByMargin(String str, String str2, String str3) {
        int i;
        String str4;
        String str5;
        String str6;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        if ((!StringsKt.isBlank(str3)) == false) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List<String> lines = StringsKt.lines(str);
        int length = str.length();
        int length2 = str2.length();
        int size = lines.size();
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(str2);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : lines) {
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str7 = (String) obj;
            if ((i2 == 0 || i2 == lastIndex) && StringsKt.isBlank(str7)) {
                i = i2;
                str4 = null;
            } else {
                int length3 = str7.length();
                int i3 = 0;
                while (true) {
                    if (i3 >= length3) {
                        i3 = -1;
                        break;
                    } else if ((!CharsKt.isWhitespace(r0.charAt(i3))) == true) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 != -1) {
                    int i4 = i3;
                    str5 = str7;
                    i = i2;
                    if (StringsKt.startsWith$default(str7, str3, i3, false, 4, (Object) null)) {
                        str6 = str5.substring(i4 + str3.length());
                        Intrinsics.checkNotNullExpressionValue(str6, "");
                        if (str6 != null || (str4 = indentFunction$StringsKt__IndentKt.invoke(str6)) == null) {
                            str4 = str5;
                        }
                    }
                } else {
                    str5 = str7;
                    i = i2;
                }
                str6 = null;
                if (str6 != null) {
                }
                str4 = str5;
            }
            if (str4 != null) {
                arrayList.add(str4);
            }
            i2 = i + 1;
        }
        String obj2 = ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(length + (length2 * size)), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        return obj2;
    }

    public static final String trimIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        return StringsKt.replaceIndent(str, "");
    }

    public static /* synthetic */ String replaceIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "";
        }
        return StringsKt.replaceIndent(str, str2);
    }

    public static final String replaceIndent(String str, String str2) {
        String invoke;
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        List<String> lines = StringsKt.lines(str);
        List<String> list = lines;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if ((!StringsKt.isBlank((String) obj)) != false) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(Integer.valueOf(indentWidth$StringsKt__IndentKt((String) it.next())));
        }
        Integer num = (Integer) CollectionsKt.minOrNull((Iterable) arrayList3);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length();
        int length2 = str2.length();
        int size = lines.size();
        Function1<String, String> indentFunction$StringsKt__IndentKt = getIndentFunction$StringsKt__IndentKt(str2);
        int lastIndex = CollectionsKt.getLastIndex(lines);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : list) {
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str3 = (String) obj2;
            if ((i == 0 || i == lastIndex) && StringsKt.isBlank(str3)) {
                str3 = null;
            } else {
                String drop = StringsKt.drop(str3, intValue);
                if (drop != null && (invoke = indentFunction$StringsKt__IndentKt.invoke(drop)) != null) {
                    str3 = invoke;
                }
            }
            if (str3 != null) {
                arrayList4.add(str3);
            }
            i++;
        }
        String obj3 = ((StringBuilder) CollectionsKt.joinTo$default(arrayList4, new StringBuilder(length + (length2 * size)), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(obj3, "");
        return obj3;
    }

    public static /* synthetic */ String prependIndent$default(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "    ";
        }
        return StringsKt.prependIndent(str, str2);
    }

    public static final String prependIndent(String str, final String str2) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return SequencesKt.joinToString$default(SequencesKt.map(StringsKt.lineSequence(str), new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$prependIndent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str3) {
                Intrinsics.checkNotNullParameter(str3, "");
                if (StringsKt.isBlank(str3)) {
                    return str3.length() < str2.length() ? str2 : str3;
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str2);
                sb.append(str3);
                return sb.toString();
            }
        }), "\n", null, null, 0, null, null, 62, null);
    }

    private static final int indentWidth$StringsKt__IndentKt(String str) {
        int length = str.length();
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if ((!CharsKt.isWhitespace(r0.charAt(i))) == true) {
                break;
            } else {
                i++;
            }
        }
        return i == -1 ? str.length() : i;
    }

    private static final Function1<String, String> getIndentFunction$StringsKt__IndentKt(final String str) {
        return str.length() == 0 ? new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                return str2;
            }
        } : new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String str2) {
                Intrinsics.checkNotNullParameter(str2, "");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(str2);
                return sb.toString();
            }
        };
    }

    private static final String reindent$StringsKt__IndentKt(List<String> list, int i, Function1<? super String, String> function1, Function1<? super String, String> function12) {
        String invoke;
        int lastIndex = CollectionsKt.getLastIndex(list);
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            String str = (String) obj;
            if ((i2 == 0 || i2 == lastIndex) && StringsKt.isBlank(str)) {
                str = null;
            } else {
                String invoke2 = function12.invoke(str);
                if (invoke2 != null && (invoke = function1.invoke(invoke2)) != null) {
                    str = invoke;
                }
            }
            if (str != null) {
                arrayList.add(str);
            }
            i2++;
        }
        String obj2 = ((StringBuilder) CollectionsKt.joinTo$default(arrayList, new StringBuilder(i), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.checkNotNullExpressionValue(obj2, "");
        return obj2;
    }
}
