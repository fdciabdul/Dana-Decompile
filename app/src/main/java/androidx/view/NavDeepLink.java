package androidx.view;

import android.net.Uri;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 02\u00020\u0001:\u00041023B'\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b.\u0010/J+\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ-\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0003\u001a\u00020\u000e2\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0002X\u0006¢\u0006\u0006\n\u0004\b\n\u0010\u001aR\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u001b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010\n\u001a\u00020\t8GX\u0086\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b\u001e\u0010!R\u0016\u0010\u0012\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b#\u0010 R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0015\u0010&\u001a\u0004\u0018\u00010\u0007X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b\u0012\u0010%R \u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020(0'8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010)R\u0015\u0010#\u001a\u0004\u0018\u00010\u0007X\u0083\u0080\u0002¢\u0006\u0006\n\u0004\b+\u0010%R\u0018\u0010+\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b,\u0010\u001aR\u0013\u0010-\u001a\u0004\u0018\u00010\u0002X\u0007¢\u0006\u0006\n\u0004\b&\u0010\u001a"}, d2 = {"Landroidx/navigation/NavDeepLink;", "", "", "p0", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "p1", "Ljava/util/regex/Pattern;", "p2", "", "KClassImpl$Data$declaredNonStaticMembers$2", "(Ljava/lang/String;Ljava/lang/StringBuilder;Ljava/util/regex/Pattern;)Z", "equals", "(Ljava/lang/Object;)Z", "Landroid/net/Uri;", "", "Landroidx/navigation/NavArgument;", "Landroid/os/Bundle;", "BuiltInFictitiousFunctionClassFactory", "(Landroid/net/Uri;Ljava/util/Map;)Landroid/os/Bundle;", "", "hashCode", "()I", "p3", "PlaceComponentResult", "(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Landroidx/navigation/NavArgument;)Z", "Ljava/lang/String;", "", "getAuthRequestContext", "Ljava/util/List;", "MyBillsEntityDataFactory", "scheduleImpl", "Z", "()Z", "NetworkUserEntityData$$ExternalSyntheticLambda0", "moveToNextValue", "initRecordTimeStamp", "Lkotlin/Lazy;", "getErrorConfigVersion", "", "Landroidx/navigation/NavDeepLink$ParamQuery;", "Ljava/util/Map;", "lookAheadTest", "NetworkUserEntityData$$ExternalSyntheticLambda1", "DatabaseTableConfigUtil", "NetworkUserEntityData$$ExternalSyntheticLambda2", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "Builder", "MimeType", "ParamQuery"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class NavDeepLink {
    private static final Companion Companion = new Companion(null);
    @Deprecated
    private static final Pattern lookAheadTest = Pattern.compile("^[a-zA-Z]+[+\\w\\-.]*:");

    /* renamed from: DatabaseTableConfigUtil  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda1;

    /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
    final String PlaceComponentResult;

    /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
    final String scheduleImpl;

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda0  reason: from kotlin metadata */
    private boolean BuiltInFictitiousFunctionClassFactory;

    /* renamed from: getErrorConfigVersion  reason: from kotlin metadata */
    final String NetworkUserEntityData$$ExternalSyntheticLambda2;

    /* renamed from: initRecordTimeStamp  reason: from kotlin metadata */
    private String NetworkUserEntityData$$ExternalSyntheticLambda0;

    /* renamed from: moveToNextValue  reason: from kotlin metadata */
    private boolean getAuthRequestContext;

    /* renamed from: scheduleImpl  reason: from kotlin metadata */
    private boolean KClassImpl$Data$declaredNonStaticMembers$2;

    /* renamed from: getAuthRequestContext  reason: from kotlin metadata */
    final List<String> MyBillsEntityDataFactory = new ArrayList();

    /* renamed from: PlaceComponentResult  reason: from kotlin metadata */
    final Map<String, ParamQuery> lookAheadTest = new LinkedHashMap();

    /* renamed from: NetworkUserEntityData$$ExternalSyntheticLambda1  reason: from kotlin metadata */
    private final Lazy moveToNextValue = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$pattern$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str != null) {
                return Pattern.compile(str, 2);
            }
            return null;
        }
    });

    /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
    final Lazy getErrorConfigVersion = LazyKt.lazy(new Function0<Pattern>() { // from class: androidx.navigation.NavDeepLink$mimeTypePattern$2
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Pattern invoke() {
            String str;
            str = NavDeepLink.this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (str != null) {
                return Pattern.compile(str);
            }
            return null;
        }
    });

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\t\b\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004"}, d2 = {"Landroidx/navigation/NavDeepLink$Builder;", "", "", "MyBillsEntityDataFactory", "Ljava/lang/String;", "BuiltInFictitiousFunctionClassFactory", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "PlaceComponentResult", "<init>", "()V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Builder {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        String getAuthRequestContext;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String PlaceComponentResult;
        String MyBillsEntityDataFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0006¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Landroidx/navigation/NavDeepLink$ParamQuery;", "", "", "", "KClassImpl$Data$declaredNonStaticMembers$2", "Ljava/util/List;", "PlaceComponentResult", "BuiltInFictitiousFunctionClassFactory", "Ljava/lang/String;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class ParamQuery {

        /* renamed from: BuiltInFictitiousFunctionClassFactory  reason: from kotlin metadata */
        String KClassImpl$Data$declaredNonStaticMembers$2;

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        final List<String> PlaceComponentResult = new ArrayList();
    }

    public NavDeepLink(String str, String str2, String str3) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = str;
        this.PlaceComponentResult = str2;
        this.scheduleImpl = str3;
        if (str != null) {
            Uri parse = Uri.parse(str);
            this.BuiltInFictitiousFunctionClassFactory = parse.getQuery() != null;
            StringBuilder sb = new StringBuilder("^");
            String str4 = str;
            if (!lookAheadTest.matcher(str4).find()) {
                sb.append("http[s]?://");
            }
            Pattern compile = Pattern.compile("\\{(.+?)\\}");
            if (this.BuiltInFictitiousFunctionClassFactory) {
                Matcher matcher = Pattern.compile("(\\?)").matcher(str4);
                if (matcher.find()) {
                    String substring = str.substring(0, matcher.start());
                    Intrinsics.checkNotNullExpressionValue(substring, "");
                    Intrinsics.checkNotNullExpressionValue(compile, "");
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(substring, sb, compile);
                }
                for (String str5 : parse.getQueryParameterNames()) {
                    StringBuilder sb2 = new StringBuilder();
                    String queryParameter = parse.getQueryParameter(str5);
                    if (queryParameter == null) {
                        this.getAuthRequestContext = true;
                        queryParameter = str5;
                    }
                    Matcher matcher2 = compile.matcher(queryParameter);
                    ParamQuery paramQuery = new ParamQuery();
                    int i = 0;
                    while (matcher2.find()) {
                        String group = matcher2.group(1);
                        if (group == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                        }
                        Intrinsics.checkNotNullParameter(group, "");
                        paramQuery.PlaceComponentResult.add(group);
                        Intrinsics.checkNotNullExpressionValue(queryParameter, "");
                        String substring2 = queryParameter.substring(i, matcher2.start());
                        Intrinsics.checkNotNullExpressionValue(substring2, "");
                        sb2.append(Pattern.quote(substring2));
                        sb2.append("(.+?)?");
                        i = matcher2.end();
                    }
                    if (i < queryParameter.length()) {
                        Intrinsics.checkNotNullExpressionValue(queryParameter, "");
                        String substring3 = queryParameter.substring(i);
                        Intrinsics.checkNotNullExpressionValue(substring3, "");
                        sb2.append(Pattern.quote(substring3));
                    }
                    String obj = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(obj, "");
                    paramQuery.KClassImpl$Data$declaredNonStaticMembers$2 = StringsKt.replace$default(obj, ".*", "\\E.*\\Q", false, 4, (Object) null);
                    Map<String, ParamQuery> map = this.lookAheadTest;
                    Intrinsics.checkNotNullExpressionValue(str5, "");
                    map.put(str5, paramQuery);
                }
            } else {
                Intrinsics.checkNotNullExpressionValue(compile, "");
                this.KClassImpl$Data$declaredNonStaticMembers$2 = KClassImpl$Data$declaredNonStaticMembers$2(str, sb, compile);
            }
            String obj2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(obj2, "");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = StringsKt.replace$default(obj2, ".*", "\\E.*\\Q", false, 4, (Object) null);
        }
        if (this.scheduleImpl != null) {
            if (!Pattern.compile("^[\\s\\S]+/[\\s\\S]+$").matcher(this.scheduleImpl).matches()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append("The given mimeType ");
                sb3.append(this.scheduleImpl);
                sb3.append(" does not match to required \"type/subtype\" format");
                throw new IllegalArgumentException(sb3.toString().toString());
            }
            MimeType mimeType = new MimeType(this.scheduleImpl);
            StringBuilder sb4 = new StringBuilder();
            sb4.append("^(");
            sb4.append(mimeType.MyBillsEntityDataFactory);
            sb4.append("|[*]+)/(");
            sb4.append(mimeType.getAuthRequestContext);
            sb4.append("|[*]+)$");
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = StringsKt.replace$default(sb4.toString(), "*|[*]", "[\\s\\S]", false, 4, (Object) null);
        }
    }

    @JvmName(name = "MyBillsEntityDataFactory")
    /* renamed from: MyBillsEntityDataFactory  reason: from getter */
    public final boolean getKClassImpl$Data$declaredNonStaticMembers$2() {
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    private final boolean KClassImpl$Data$declaredNonStaticMembers$2(String p0, StringBuilder p1, Pattern p2) {
        String str = p0;
        Matcher matcher = p2.matcher(str);
        boolean z = !StringsKt.contains$default((CharSequence) str, (CharSequence) ".*", false, 2, (Object) null);
        int i = 0;
        while (matcher.find()) {
            String group = matcher.group(1);
            if (group == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            this.MyBillsEntityDataFactory.add(group);
            String substring = p0.substring(i, matcher.start());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            p1.append(Pattern.quote(substring));
            p1.append("([^/]+?)");
            i = matcher.end();
            z = false;
        }
        if (i < p0.length()) {
            String substring2 = p0.substring(i);
            Intrinsics.checkNotNullExpressionValue(substring2, "");
            p1.append(Pattern.quote(substring2));
        }
        p1.append("($|(\\?(.)*)|(\\#(.)*))");
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\u0004\u0010\u0007R\u0012\u0010\u0004\u001a\u00020\u0006X\u0086\u0002¢\u0006\u0006\n\u0004\b\t\u0010\u0007"}, d2 = {"Landroidx/navigation/NavDeepLink$MimeType;", "", "p0", "", "MyBillsEntityDataFactory", "(Landroidx/navigation/NavDeepLink$MimeType;)I", "", "Ljava/lang/String;", "getAuthRequestContext", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "(Ljava/lang/String;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class MimeType implements Comparable<MimeType> {

        /* renamed from: KClassImpl$Data$declaredNonStaticMembers$2  reason: from kotlin metadata */
        String MyBillsEntityDataFactory;

        /* renamed from: MyBillsEntityDataFactory  reason: from kotlin metadata */
        String getAuthRequestContext;

        public MimeType(String str) {
            List emptyList;
            Intrinsics.checkNotNullParameter(str, "");
            List<String> split = new Regex("/").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (!(listIterator.previous().length() == 0)) {
                        emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt.emptyList();
            this.MyBillsEntityDataFactory = (String) emptyList.get(0);
            this.getAuthRequestContext = (String) emptyList.get(1);
        }

        @Override // java.lang.Comparable
        /* renamed from: MyBillsEntityDataFactory  reason: merged with bridge method [inline-methods] */
        public final int compareTo(MimeType p0) {
            Intrinsics.checkNotNullParameter(p0, "");
            int i = Intrinsics.areEqual(this.MyBillsEntityDataFactory, p0.MyBillsEntityDataFactory) ? 2 : 0;
            return Intrinsics.areEqual(this.getAuthRequestContext, p0.getAuthRequestContext) ? i + 1 : i;
        }
    }

    public final boolean equals(Object p0) {
        if (p0 == null || !(p0 instanceof NavDeepLink)) {
            return false;
        }
        NavDeepLink navDeepLink = (NavDeepLink) p0;
        return Intrinsics.areEqual(this.NetworkUserEntityData$$ExternalSyntheticLambda2, navDeepLink.NetworkUserEntityData$$ExternalSyntheticLambda2) && Intrinsics.areEqual(this.PlaceComponentResult, navDeepLink.PlaceComponentResult) && Intrinsics.areEqual(this.scheduleImpl, navDeepLink.scheduleImpl);
    }

    public final int hashCode() {
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.PlaceComponentResult;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        String str3 = this.scheduleImpl;
        return ((((hashCode + 0) * 31) + hashCode2) * 31) + (str3 != null ? str3.hashCode() : 0);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0005\u001a\u0006*\u00020\u00020\u00028\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004"}, d2 = {"Landroidx/navigation/NavDeepLink$Companion;", "", "Ljava/util/regex/Pattern;", "lookAheadTest", "Ljava/util/regex/Pattern;", "KClassImpl$Data$declaredNonStaticMembers$2", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    private static boolean PlaceComponentResult(Bundle p0, String p1, String p2, NavArgument p3) {
        if (p3 == null) {
            p0.putString(p1, p2);
            return false;
        }
        NavType<Object> navType = p3.BuiltInFictitiousFunctionClassFactory;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Intrinsics.checkNotNullParameter(p2, "");
        navType.MyBillsEntityDataFactory(p0, p1, navType.PlaceComponentResult(p2));
        return false;
    }

    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.os.Bundle, java.lang.Object, java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    public final Bundle BuiltInFictitiousFunctionClassFactory(Uri p0, Map<String, NavArgument> p1) {
        Matcher matcher;
        String str;
        Intrinsics.checkNotNullParameter(p0, "");
        Intrinsics.checkNotNullParameter(p1, "");
        Pattern pattern = (Pattern) this.moveToNextValue.getValue();
        ?? r5 = 0;
        Matcher matcher2 = pattern != null ? pattern.matcher(p0.toString()) : null;
        if (matcher2 != null && matcher2.matches()) {
            Bundle bundle = new Bundle();
            int size = this.MyBillsEntityDataFactory.size();
            int i = 0;
            while (i < size) {
                String str2 = this.MyBillsEntityDataFactory.get(i);
                i++;
                String decode = Uri.decode(matcher2.group(i));
                NavArgument navArgument = p1.get(str2);
                try {
                    Intrinsics.checkNotNullExpressionValue(decode, "");
                    PlaceComponentResult(bundle, str2, decode, navArgument);
                } catch (IllegalArgumentException unused) {
                    return null;
                }
            }
            if (this.BuiltInFictitiousFunctionClassFactory) {
                for (String str3 : this.lookAheadTest.keySet()) {
                    ParamQuery paramQuery = this.lookAheadTest.get(str3);
                    String queryParameter = p0.getQueryParameter(str3);
                    if (this.getAuthRequestContext) {
                        String obj = p0.toString();
                        Intrinsics.checkNotNullExpressionValue(obj, "");
                        String substringAfter$default = StringsKt.substringAfter$default(obj, '?', (String) r5, 2, (Object) r5);
                        if (!Intrinsics.areEqual(substringAfter$default, obj)) {
                            queryParameter = substringAfter$default;
                        }
                    }
                    if (queryParameter != null) {
                        Intrinsics.checkNotNull(paramQuery);
                        matcher = Pattern.compile(paramQuery.KClassImpl$Data$declaredNonStaticMembers$2, 32).matcher(queryParameter);
                        if (!matcher.matches()) {
                            return r5;
                        }
                    } else {
                        matcher = r5;
                    }
                    Bundle bundle2 = new Bundle();
                    try {
                        Intrinsics.checkNotNull(paramQuery);
                        int size2 = paramQuery.PlaceComponentResult.size();
                        int i2 = 0;
                        String str4 = r5;
                        while (i2 < size2) {
                            if (matcher != null) {
                                str = matcher.group(i2 + 1);
                                if (str == null) {
                                    str = "";
                                }
                            } else {
                                str = str4;
                            }
                            String str5 = paramQuery.PlaceComponentResult.get(i2);
                            NavArgument navArgument2 = p1.get(str5);
                            if (str != null) {
                                StringBuilder sb = new StringBuilder();
                                sb.append('{');
                                sb.append(str5);
                                sb.append('}');
                                if (!Intrinsics.areEqual(str, sb.toString())) {
                                    PlaceComponentResult(bundle2, str5, str, navArgument2);
                                }
                            }
                            i2++;
                            str4 = null;
                        }
                        bundle.putAll(bundle2);
                    } catch (IllegalArgumentException unused2) {
                    }
                    r5 = 0;
                }
            }
            for (Map.Entry<String, NavArgument> entry : p1.entrySet()) {
                String key = entry.getKey();
                NavArgument value = entry.getValue();
                if (((value == null || value.getGetAuthRequestContext() || value.getKClassImpl$Data$declaredNonStaticMembers$2()) ? false : true) && !bundle.containsKey(key)) {
                    return null;
                }
            }
            return bundle;
        }
        return null;
    }
}
