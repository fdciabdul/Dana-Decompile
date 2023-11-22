package kotlin.text;

import com.google.firebase.analytics.FirebaseAnalytics;
import id.dana.data.here.model.HereUrlConstant;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0007\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0086\b¢\u0006\u0004\b\u0003\u0010\n\u001a \u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\u0003\u0010\r\u001a(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0011\u001a0\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0012\u001a\u0018\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0086\b¢\u0006\u0004\b\u0003\u0010\u0015\u001a(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0016\u001a(\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\u0003\u0010\u0019\u001a\u0013\u0010\u001a\u001a\u00020\u0002*\u00020\u0002H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001a\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b\u001a\u0010\u001e\u001a\u001c\u0010 \u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b \u0010!\u001a\u001c\u0010\"\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b\"\u0010!\u001a$\u0010%\u001a\u00020\u000e*\u00020\u00022\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b%\u0010&\u001a#\u0010*\u001a\u00020\u000e*\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+\u001a\u0011\u0010,\u001a\u00020\u0002*\u00020\u0013¢\u0006\u0004\b,\u0010\u0015\u001a%\u0010,\u001a\u00020\u0002*\u00020\u00132\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e¢\u0006\u0004\b,\u0010\u0016\u001a \u0010/\u001a\u00020(*\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010.H\u0086\u0004¢\u0006\u0004\b/\u00100\u001a%\u0010/\u001a\u00020(*\u0004\u0018\u00010.2\b\u0010'\u001a\u0004\u0018\u00010.2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b/\u00101\u001a\u001c\u0010/\u001a\u00020(*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0000H\u0086\b¢\u0006\u0004\b/\u00102\u001a\u001c\u0010/\u001a\u00020(*\u00020\u00022\u0006\u00103\u001a\u00020.H\u0086\b¢\u0006\u0004\b/\u00104\u001a\u0013\u00105\u001a\u00020\u0002*\u00020\u0002H\u0007¢\u0006\u0004\b5\u0010\u001b\u001a\u001b\u00105\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0007¢\u0006\u0004\b5\u0010\u001e\u001a\u0011\u00106\u001a\u00020\u0002*\u00020\b¢\u0006\u0004\b6\u0010\n\u001a/\u00106\u001a\u00020\u0002*\u00020\b2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020(¢\u0006\u0004\b6\u00108\u001a\u0011\u00109\u001a\u00020\b*\u00020\u0002¢\u0006\u0004\b9\u0010:\u001a/\u00109\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e2\b\b\u0002\u00107\u001a\u00020(¢\u0006\u0004\b9\u0010;\u001a#\u0010=\u001a\u00020(*\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b=\u0010>\u001a'\u0010?\u001a\u00020(*\u0004\u0018\u00010\u00022\b\u0010'\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\b?\u0010>\u001a4\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001c2\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010AH\u0087\b¢\u0006\u0004\bC\u0010D\u001a6\u0010E\u001a\u00020\u0002*\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010AH\u0086\b¢\u0006\u0004\bE\u0010D\u001a,\u0010C\u001a\u00020\u0002*\u00020\u00022\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010AH\u0086\b¢\u0006\u0004\bC\u0010F\u001a<\u0010C\u001a\u00020\u0002*\u00020G2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010C\u001a\u00020\u00022\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010AH\u0087\b¢\u0006\u0004\bC\u0010H\u001a>\u0010E\u001a\u00020\u0002*\u00020G2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010C\u001a\u00020\u00022\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010AH\u0086\b¢\u0006\u0004\bE\u0010H\u001a4\u0010C\u001a\u00020\u0002*\u00020G2\u0006\u0010C\u001a\u00020\u00022\u0016\u0010B\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010A0@\"\u0004\u0018\u00010AH\u0086\b¢\u0006\u0004\bC\u0010I\u001a\u0014\u0010J\u001a\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0004\bJ\u0010\u001b\u001a\u0011\u0010K\u001a\u00020(*\u00020.¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010M\u001a\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0004\bM\u0010\u001b\u001a\u001c\u0010M\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0086\b¢\u0006\u0004\bM\u0010\u001e\u001a$\u0010Q\u001a\u00020\u000e*\u00020\u00022\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\bQ\u0010R\u001a$\u0010Q\u001a\u00020\u000e*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\bQ\u0010T\u001a$\u0010U\u001a\u00020\u000e*\u00020\u00022\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\bU\u0010R\u001a$\u0010U\u001a\u00020\u000e*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010P\u001a\u00020\u000eH\u0080\b¢\u0006\u0004\bU\u0010T\u001a$\u0010W\u001a\u00020\u000e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010V\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\bW\u0010&\u001a;\u0010Z\u001a\u00020(*\u00020.2\u0006\u0010X\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020.2\u0006\u0010Y\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bZ\u0010[\u001a;\u0010Z\u001a\u00020(*\u00020\u00022\u0006\u0010X\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020\u00022\u0006\u0010Y\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bZ\u0010\\\u001a\u0019\u0010^\u001a\u00020\u0002*\u00020.2\u0006\u0010]\u001a\u00020\u000e¢\u0006\u0004\b^\u0010_\u001a+\u0010b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010`\u001a\u00020N2\u0006\u0010a\u001a\u00020N2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bb\u0010c\u001a+\u0010b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010d\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bb\u0010f\u001a+\u0010g\u001a\u00020\u0002*\u00020\u00022\u0006\u0010`\u001a\u00020N2\u0006\u0010a\u001a\u00020N2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bg\u0010c\u001a+\u0010g\u001a\u00020\u0002*\u00020\u00022\u0006\u0010d\u001a\u00020\u00022\u0006\u0010e\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bg\u0010f\u001a)\u0010l\u001a\b\u0012\u0004\u0012\u00020\u00020k*\u00020.2\u0006\u0010i\u001a\u00020h2\b\b\u0002\u0010j\u001a\u00020\u000e¢\u0006\u0004\bl\u0010m\u001a#\u0010o\u001a\u00020(*\u00020\u00022\u0006\u0010n\u001a\u00020\u00022\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bo\u0010>\u001a+\u0010o\u001a\u00020(*\u00020\u00022\u0006\u0010n\u001a\u00020\u00022\u0006\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010)\u001a\u00020(¢\u0006\u0004\bo\u0010p\u001a\u001c\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\bq\u0010r\u001a$\u0010q\u001a\u00020\u0002*\u00020\u00022\u0006\u0010-\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\bq\u0010s\u001a\u001e\u0010t\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u000bH\u0086\b¢\u0006\u0004\bt\u0010u\u001a\u0014\u0010v\u001a\u00020\u0013*\u00020\u0002H\u0086\b¢\u0006\u0004\bv\u0010w\u001a:\u0010v\u001a\u00020\u0013*\u00020\u00022\u0006\u0010x\u001a\u00020\u00132\b\b\u0002\u0010y\u001a\u00020\u000e2\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\bv\u0010z\u001a%\u0010v\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010-\u001a\u00020\u000e2\b\b\u0002\u0010$\u001a\u00020\u000e¢\u0006\u0004\bv\u0010{\u001a\u0014\u0010|\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0004\b|\u0010\u001b\u001a\u001c\u0010|\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\b¢\u0006\u0004\b|\u0010\u001e\u001a\u001e\u0010~\u001a\u00020h*\u00020\u00022\b\b\u0002\u0010}\u001a\u00020\u000eH\u0086\b¢\u0006\u0004\b~\u0010\u007f\u001a\u0016\u0010\u0080\u0001\u001a\u00020\u0002*\u00020\u0002H\u0087\b¢\u0006\u0005\b\u0080\u0001\u0010\u001b\u001a\u001e\u0010\u0080\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0087\b¢\u0006\u0005\b\u0080\u0001\u0010\u001e\u001a\u0016\u0010\u0081\u0001\u001a\u00020\u0002*\u00020\u0002H\u0086\b¢\u0006\u0005\b\u0081\u0001\u0010\u001b\u001a\u001e\u0010\u0081\u0001\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cH\u0086\b¢\u0006\u0005\b\u0081\u0001\u0010\u001e\"*\u0010\u0086\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u00020\u0082\u0001j\t\u0012\u0004\u0012\u00020\u0002`\u0083\u0001*\u00020G8G¢\u0006\b\u001a\u0006\b\u0084\u0001\u0010\u0085\u0001"}, d2 = {"Ljava/lang/StringBuffer;", "stringBuffer", "", "String", "(Ljava/lang/StringBuffer;)Ljava/lang/String;", "Ljava/lang/StringBuilder;", "stringBuilder", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "", "bytes", "([B)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "([BLjava/nio/charset/Charset;)Ljava/lang/String;", "", "offset", "length", "([BII)Ljava/lang/String;", "([BIILjava/nio/charset/Charset;)Ljava/lang/String;", "", "chars", "([C)Ljava/lang/String;", "([CII)Ljava/lang/String;", "", "codePoints", "([III)Ljava/lang/String;", "capitalize", "(Ljava/lang/String;)Ljava/lang/String;", "Ljava/util/Locale;", "locale", "(Ljava/lang/String;Ljava/util/Locale;)Ljava/lang/String;", "index", "codePointAt", "(Ljava/lang/String;I)I", "codePointBefore", "beginIndex", "endIndex", "codePointCount", "(Ljava/lang/String;II)I", "other", "", "ignoreCase", "compareTo", "(Ljava/lang/String;Ljava/lang/String;Z)I", "concatToString", "startIndex", "", "contentEquals", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Z", "(Ljava/lang/String;Ljava/lang/StringBuffer;)Z", "charSequence", "(Ljava/lang/String;Ljava/lang/CharSequence;)Z", "decapitalize", "decodeToString", "throwOnInvalidSequence", "([BIIZ)Ljava/lang/String;", "encodeToByteArray", "(Ljava/lang/String;)[B", "(Ljava/lang/String;IIZ)[B", "suffix", "endsWith", "(Ljava/lang/String;Ljava/lang/String;Z)Z", "equals", "", "", "args", "format", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "formatNullable", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/String$Companion;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "isBlank", "(Ljava/lang/CharSequence;)Z", "lowercase", "", "ch", "fromIndex", "nativeIndexOf", "(Ljava/lang/String;CI)I", "str", "(Ljava/lang/String;Ljava/lang/String;I)I", "nativeLastIndexOf", "codePointOffset", "offsetByCodePoints", "thisOffset", "otherOffset", "regionMatches", "(Ljava/lang/CharSequence;ILjava/lang/CharSequence;IIZ)Z", "(Ljava/lang/String;ILjava/lang/String;IIZ)Z", "n", "repeat", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", "oldChar", "newChar", "replace", "(Ljava/lang/String;CCZ)Ljava/lang/String;", "oldValue", "newValue", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Ljava/lang/String;", "replaceFirst", "Ljava/util/regex/Pattern;", "regex", HereUrlConstant.LIMIT, "", "split", "(Ljava/lang/CharSequence;Ljava/util/regex/Pattern;I)Ljava/util/List;", "prefix", "startsWith", "(Ljava/lang/String;Ljava/lang/String;IZ)Z", "substring", "(Ljava/lang/String;I)Ljava/lang/String;", "(Ljava/lang/String;II)Ljava/lang/String;", "toByteArray", "(Ljava/lang/String;Ljava/nio/charset/Charset;)[B", "toCharArray", "(Ljava/lang/String;)[C", FirebaseAnalytics.Param.DESTINATION, "destinationOffset", "(Ljava/lang/String;[CIII)[C", "(Ljava/lang/String;II)[C", "toLowerCase", "flags", "toPattern", "(Ljava/lang/String;I)Ljava/util/regex/Pattern;", "toUpperCase", "uppercase", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "CASE_INSENSITIVE_ORDER"}, k = 5, mv = {1, 6, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    private static final int nativeIndexOf(String str, char c, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.indexOf(c, i);
    }

    private static final int nativeIndexOf(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return str.indexOf(str2, i);
    }

    private static final int nativeLastIndexOf(String str, char c, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.lastIndexOf(c, i);
    }

    private static final int nativeLastIndexOf(String str, String str2, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        return str.lastIndexOf(str2, i);
    }

    public static /* synthetic */ boolean equals$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.equals(str, str2, z);
    }

    public static final boolean equals(String str, String str2, boolean z) {
        if (str == null) {
            return str2 == null;
        } else if (!z) {
            return str.equals(str2);
        } else {
            return str.equalsIgnoreCase(str2);
        }
    }

    public static /* synthetic */ String replace$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, c, c2, z);
    }

    public static final String replace(String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        if (!z) {
            String replace = str.replace(c, c2);
            Intrinsics.checkNotNullExpressionValue(replace, "");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        String str2 = str;
        for (int i = 0; i < str2.length(); i++) {
            char charAt = str2.charAt(i);
            if (CharsKt.equals(charAt, c, z)) {
                charAt = c2;
            }
            sb.append(charAt);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static /* synthetic */ String replace$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replace(str, str2, str3, z);
    }

    public static final String replace(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str4 = str;
        int i = 0;
        int indexOf = StringsKt.indexOf(str4, str2, 0, z);
        if (indexOf < 0) {
            return str;
        }
        int length = str2.length();
        int coerceAtLeast = RangesKt.coerceAtLeast(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str4, i, indexOf);
            sb.append(str3);
            i = indexOf + length;
            if (indexOf >= str.length()) {
                break;
            }
            indexOf = StringsKt.indexOf(str4, str2, indexOf + coerceAtLeast, z);
        } while (indexOf > 0);
        sb.append((CharSequence) str4, i, str.length());
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static /* synthetic */ String replaceFirst$default(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(str, c, c2, z);
    }

    public static final String replaceFirst(String str, char c, char c2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        String str2 = str;
        int indexOf$default = StringsKt.indexOf$default(str2, c, 0, z, 2, (Object) null);
        return indexOf$default >= 0 ? StringsKt.replaceRange((CharSequence) str2, indexOf$default, indexOf$default + 1, (CharSequence) String.valueOf(c2)).toString() : str;
    }

    public static /* synthetic */ String replaceFirst$default(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.replaceFirst(str, str2, str3, z);
    }

    public static final String replaceFirst(String str, String str2, String str3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        String str4 = str;
        int indexOf$default = StringsKt.indexOf$default(str4, str2, 0, z, 2, (Object) null);
        return indexOf$default >= 0 ? StringsKt.replaceRange((CharSequence) str4, indexOf$default, str2.length() + indexOf$default, (CharSequence) str3).toString() : str;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String upperCase = str.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    private static final String uppercase(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String upperCase = str.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String lowerCase = str.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    private static final String lowercase(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    public static final String concatToString(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "");
        return new String(cArr);
    }

    public static /* synthetic */ String concatToString$default(char[] cArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = cArr.length;
        }
        return StringsKt.concatToString(cArr, i, i2);
    }

    public static final String concatToString(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    public static /* synthetic */ char[] toCharArray$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return StringsKt.toCharArray(str, i, i2);
    }

    public static final char[] toCharArray(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        char[] cArr = new char[i2 - i];
        str.getChars(i, i2, cArr, 0);
        return cArr;
    }

    public static final String decodeToString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return new String(bArr, Charsets.UTF_8);
    }

    public static /* synthetic */ String decodeToString$default(byte[] bArr, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt.decodeToString(bArr, i, i2, z);
    }

    public static final String decodeToString(byte[] bArr, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(bArr, "");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (!z) {
            return new String(bArr, i, i2 - i, Charsets.UTF_8);
        }
        String obj = Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(bArr, i, i2 - i)).toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public static final byte[] encodeToByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        byte[] bytes = str.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        return bytes;
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String str, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        return StringsKt.encodeToByteArray(str, i, i2, z);
    }

    public static final byte[] encodeToByteArray(String str, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (!z) {
            String substring = str.substring(i, i2);
            Intrinsics.checkNotNullExpressionValue(substring, "");
            byte[] bytes = substring.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            return bytes;
        }
        ByteBuffer encode = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(str, i, i2));
        if (encode.hasArray() && encode.arrayOffset() == 0) {
            int remaining = encode.remaining();
            byte[] array = encode.array();
            Intrinsics.checkNotNull(array);
            if (remaining == array.length) {
                byte[] array2 = encode.array();
                Intrinsics.checkNotNullExpressionValue(array2, "");
                return array2;
            }
        }
        byte[] bArr = new byte[encode.remaining()];
        encode.get(bArr);
        return bArr;
    }

    private static final char[] toCharArray(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        char[] charArray = str.toCharArray();
        Intrinsics.checkNotNullExpressionValue(charArray, "");
        return charArray;
    }

    static /* synthetic */ char[] toCharArray$default(String str, char[] cArr, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = str.length();
        }
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        str.getChars(i2, i3, cArr, i);
        return cArr;
    }

    private static final char[] toCharArray(String str, char[] cArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(cArr, "");
        str.getChars(i2, i3, cArr, i);
        return cArr;
    }

    private static final String format(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private static final String format(StringCompanionObject stringCompanionObject, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        String format = String.format(str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final /* synthetic */ String format(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private static final String formatNullable(String str, Locale locale, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    @Deprecated(message = "Use Kotlin compiler 1.4 to avoid deprecation warning.")
    @DeprecatedSinceKotlin(hiddenSince = "1.4")
    private static final /* synthetic */ String format(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "");
        Intrinsics.checkNotNullParameter(locale, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    private static final String formatNullable(StringCompanionObject stringCompanionObject, Locale locale, String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "");
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(objArr, "");
        String format = String.format(locale, str, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(format, "");
        return format;
    }

    public static /* synthetic */ List split$default(CharSequence charSequence, Pattern pattern, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return StringsKt.split(charSequence, pattern, i);
    }

    public static final List<String> split(CharSequence charSequence, Pattern pattern, int i) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(pattern, "");
        StringsKt.requireNonNegativeLimit(i);
        if (i == 0) {
            i = -1;
        }
        String[] split = pattern.split(charSequence, i);
        Intrinsics.checkNotNullExpressionValue(split, "");
        return ArraysKt.asList(split);
    }

    private static final String substring(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        String substring = str.substring(i);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }

    private static final String substring(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return substring;
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, z);
    }

    public static final boolean startsWith(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (!z) {
            return str.startsWith(str2);
        }
        return StringsKt.regionMatches(str, 0, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean startsWith$default(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.startsWith(str, str2, i, z);
    }

    public static final boolean startsWith(String str, String str2, int i, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (!z) {
            return str.startsWith(str2, i);
        }
        return StringsKt.regionMatches(str, i, str2, 0, str2.length(), z);
    }

    public static /* synthetic */ boolean endsWith$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.endsWith(str, str2, z);
    }

    public static final boolean endsWith(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (!z) {
            return str.endsWith(str2);
        }
        return StringsKt.regionMatches(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    private static final String String(byte[] bArr, int i, int i2, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new String(bArr, i, i2, charset);
    }

    private static final String String(byte[] bArr, Charset charset) {
        Intrinsics.checkNotNullParameter(bArr, "");
        Intrinsics.checkNotNullParameter(charset, "");
        return new String(bArr, charset);
    }

    private static final String String(byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return new String(bArr, i, i2, Charsets.UTF_8);
    }

    private static final String String(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "");
        return new String(bArr, Charsets.UTF_8);
    }

    private static final String String(char[] cArr) {
        Intrinsics.checkNotNullParameter(cArr, "");
        return new String(cArr);
    }

    private static final String String(char[] cArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(cArr, "");
        return new String(cArr, i, i2);
    }

    private static final String String(int[] iArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(iArr, "");
        return new String(iArr, i, i2);
    }

    private static final String String(StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(stringBuffer, "");
        return new String(stringBuffer);
    }

    private static final String String(StringBuilder sb) {
        Intrinsics.checkNotNullParameter(sb, "");
        return new String(sb);
    }

    private static final int codePointAt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.codePointAt(i);
    }

    private static final int codePointBefore(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.codePointBefore(i);
    }

    private static final int codePointCount(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.codePointCount(i, i2);
    }

    public static /* synthetic */ int compareTo$default(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.compareTo(str, str2, z);
    }

    public static final int compareTo(String str, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (z) {
            return str.compareToIgnoreCase(str2);
        }
        return str.compareTo(str2);
    }

    private static final boolean contentEquals(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        return str.contentEquals(charSequence);
    }

    private static final boolean contentEquals(String str, StringBuffer stringBuffer) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(stringBuffer, "");
        return str.contentEquals(stringBuffer);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && charSequence2 != null) {
            return ((String) charSequence).contentEquals(charSequence2);
        }
        return StringsKt.contentEqualsImpl(charSequence, charSequence2);
    }

    public static final boolean contentEquals(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        if (z) {
            return StringsKt.contentEqualsIgnoreCaseImpl(charSequence, charSequence2);
        }
        return StringsKt.contentEquals(charSequence, charSequence2);
    }

    private static final String intern(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        String intern = str.intern();
        Intrinsics.checkNotNullExpressionValue(intern, "");
        return intern;
    }

    public static final boolean isBlank(CharSequence charSequence) {
        boolean z;
        Intrinsics.checkNotNullParameter(charSequence, "");
        if (charSequence.length() != 0) {
            IntRange indices = StringsKt.getIndices(charSequence);
            if (!(indices instanceof Collection) || !((Collection) indices).isEmpty()) {
                Iterator<Integer> it = indices.iterator();
                while (it.hasNext()) {
                    if (!CharsKt.isWhitespace(charSequence.charAt(((IntIterator) it).nextInt()))) {
                        z = false;
                        break;
                    }
                }
            }
            z = true;
            return z;
        }
        return true;
    }

    private static final int offsetByCodePoints(String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(str, "");
        return str.offsetByCodePoints(i, i2);
    }

    public static final boolean regionMatches(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(charSequence, "");
        Intrinsics.checkNotNullParameter(charSequence2, "");
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return StringsKt.regionMatches((String) charSequence, i, (String) charSequence2, i2, i3, z);
        }
        return StringsKt.regionMatchesImpl(charSequence, i, charSequence2, i2, i3, z);
    }

    public static final boolean regionMatches(String str, int i, String str2, int i2, int i3, boolean z) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        if (!z) {
            return str.regionMatches(i, str2, i2, i3);
        }
        return str.regionMatches(z, i, str2, i2, i3);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    private static final String lowercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        return lowerCase;
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    private static final String uppercase(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "");
        return upperCase;
    }

    private static final byte[] toByteArray(String str, Charset charset) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        return bytes;
    }

    static /* synthetic */ byte[] toByteArray$default(String str, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(charset, "");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        return bytes;
    }

    static /* synthetic */ Pattern toPattern$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        Intrinsics.checkNotNullParameter(str, "");
        Pattern compile = Pattern.compile(str, i);
        Intrinsics.checkNotNullExpressionValue(compile, "");
        return compile;
    }

    private static final Pattern toPattern(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Pattern compile = Pattern.compile(str, i);
        Intrinsics.checkNotNullExpressionValue(compile, "");
        return compile;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "");
        return StringsKt.capitalize(str, locale);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    String upperCase = substring.toUpperCase(locale);
                    Intrinsics.checkNotNullExpressionValue(upperCase, "");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring2, "");
                sb.append(substring2);
                String obj = sb.toString();
                Intrinsics.checkNotNullExpressionValue(obj, "");
                return obj;
            }
            return str;
        }
        return str;
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String lowerCase = substring.toLowerCase();
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        sb.append(substring2);
        return sb.toString();
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String str, Locale locale) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(locale, "");
        if (!(str.length() > 0) || Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String substring = str.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        String lowerCase = substring.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        sb.append(lowerCase);
        String substring2 = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "");
        sb.append(substring2);
        return sb.toString();
    }

    public static final String repeat(CharSequence charSequence, int i) {
        String str;
        Intrinsics.checkNotNullParameter(charSequence, "");
        int i2 = 1;
        if (!(i >= 0)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Count 'n' must be non-negative, but was ");
            sb.append(i);
            sb.append('.');
            throw new IllegalArgumentException(sb.toString().toString());
        } else if (i != 0) {
            if (i == 1) {
                return charSequence.toString();
            }
            int length = charSequence.length();
            if (length != 0) {
                if (length == 1) {
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i];
                    for (int i3 = 0; i3 < i; i3++) {
                        cArr[i3] = charAt;
                    }
                    str = new String(cArr);
                } else {
                    StringBuilder sb2 = new StringBuilder(charSequence.length() * i);
                    if (i > 0) {
                        while (true) {
                            sb2.append(charSequence);
                            if (i2 == i) {
                                break;
                            }
                            i2++;
                        }
                    }
                    str = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(str, "");
                }
                return str;
            }
            return "";
        } else {
            return "";
        }
    }

    @JvmName(name = "getCASE_INSENSITIVE_ORDER")
    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject stringCompanionObject) {
        Intrinsics.checkNotNullParameter(stringCompanionObject, "");
        Comparator<String> comparator = String.CASE_INSENSITIVE_ORDER;
        Intrinsics.checkNotNullExpressionValue(comparator, "");
        return comparator;
    }
}
