package com.twilio.verify.data;

import com.twilio.security.logger.Level;
import com.twilio.security.logger.Logger;
import j$.util.DesugarTimeZone;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0017\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0006\u0010\u0007\"\u0011\u0010\u0005\u001a\u00020\bX\u0000¢\u0006\u0006\n\u0004\b\u0005\u0010\t\"\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\t"}, d2 = {"", "p0", "Ljava/util/Date;", "MyBillsEntityDataFactory", "(Ljava/lang/String;)Ljava/util/Date;", "KClassImpl$Data$declaredNonStaticMembers$2", "getAuthRequestContext", "(Ljava/util/Date;)Ljava/lang/String;", "Ljava/text/SimpleDateFormat;", "Ljava/text/SimpleDateFormat;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory"}, k = 2, mv = {1, 8, 0})
/* loaded from: classes3.dex */
public final class DateParserKt {
    public static final SimpleDateFormat KClassImpl$Data$declaredNonStaticMembers$2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);
    private static final SimpleDateFormat PlaceComponentResult;

    static {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpleDateFormat.setTimeZone(DesugarTimeZone.BuiltInFictitiousFunctionClassFactory("UTC"));
        PlaceComponentResult = simpleDateFormat;
    }

    public static final Date KClassImpl$Data$declaredNonStaticMembers$2(String str) {
        Intrinsics.checkParameterIsNotNull(str, "");
        try {
            if (StringsKt.endsWith$default(str, "Z", false, 2, (Object) null)) {
                Date parse = PlaceComponentResult.parse(str);
                Intrinsics.checkExpressionValueIsNotNull(parse, "");
                return parse;
            }
            String substring = str.substring(0, StringsKt.lastIndexOf$default((CharSequence) str, '-', 0, false, 6, (Object) null));
            Intrinsics.checkExpressionValueIsNotNull(substring, "");
            String substring2 = str.substring(StringsKt.lastIndexOf$default((CharSequence) str, '-', 0, false, 6, (Object) null));
            Intrinsics.checkExpressionValueIsNotNull(substring2, "");
            StringBuilder sb = new StringBuilder();
            int indexOf$default = StringsKt.indexOf$default((CharSequence) substring2, ':', 0, false, 6, (Object) null);
            if (substring2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring3 = substring2.substring(0, indexOf$default);
            Intrinsics.checkExpressionValueIsNotNull(substring3, "");
            sb.append(substring3);
            int indexOf$default2 = StringsKt.indexOf$default((CharSequence) substring2, ':', 0, false, 6, (Object) null);
            if (substring2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String substring4 = substring2.substring(indexOf$default2 + 1);
            Intrinsics.checkExpressionValueIsNotNull(substring4, "");
            sb.append(substring4);
            String obj = sb.toString();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(substring);
            sb2.append(obj);
            Date parse2 = KClassImpl$Data$declaredNonStaticMembers$2.parse(sb2.toString());
            Intrinsics.checkExpressionValueIsNotNull(parse2, "");
            return parse2;
        } catch (ParseException e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj2 = e.toString();
            ParseException parseException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj2, parseException);
            throw parseException;
        } catch (Exception e2) {
            Logger logger2 = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e2.toString(), e2);
            throw new ParseException(e2.getMessage(), 0);
        }
    }

    public static final String getAuthRequestContext(Date date) {
        Intrinsics.checkParameterIsNotNull(date, "");
        String format = PlaceComponentResult.format(date);
        Intrinsics.checkExpressionValueIsNotNull(format, "");
        return format;
    }

    public static final Date MyBillsEntityDataFactory(String str) {
        Intrinsics.checkParameterIsNotNull(str, "");
        try {
            Date parse = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US).parse(str);
            Intrinsics.checkExpressionValueIsNotNull(parse, "");
            return parse;
        } catch (ParseException e) {
            Logger logger = Logger.PlaceComponentResult;
            Level level = Level.Error;
            String obj = e.toString();
            ParseException parseException = e;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(level, obj, parseException);
            throw parseException;
        } catch (Exception e2) {
            Logger logger2 = Logger.PlaceComponentResult;
            Logger.KClassImpl$Data$declaredNonStaticMembers$2(Level.Error, e2.toString(), e2);
            throw new ParseException(e2.getMessage(), 0);
        }
    }
}
