package kotlin.text;

import com.alipay.mobile.verifyidentity.business.securitycommon.bean.SecurityConstants;
import id.dana.data.here.model.HereUrlConstant;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 =2\u00060\u0001j\u0002`\u0002:\u0002=>B\u0011\b\u0016\u0012\u0006\u00106\u001a\u00020\u0019¢\u0006\u0004\b7\u00108B\u0019\b\u0016\u0012\u0006\u00106\u001a\u00020\u0019\u0012\u0006\u00109\u001a\u00020-¢\u0006\u0004\b7\u0010:B\u001f\b\u0016\u0012\u0006\u00106\u001a\u00020\u0019\u0012\f\u00104\u001a\b\u0012\u0004\u0012\u00020-0,¢\u0006\u0004\b7\u0010;B\u0011\b\u0000\u0012\u0006\u00100\u001a\u00020$¢\u0006\u0004\b7\u0010<J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0011\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\fJ\u0017\u0010\u0012\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0086\u0004¢\u0006\u0004\b\u0014\u0010\u0007J\u001d\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u001d\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001e\u0010\u001dJ%\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00190 2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b!\u0010\"J%\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190\r2\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\b¢\u0006\u0004\b#\u0010\u000fJ\r\u0010%\u001a\u00020$¢\u0006\u0004\b%\u0010&J\u000f\u0010'\u001a\u00020\u0019H\u0016¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b*\u0010+R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00100\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020-0,8G¢\u0006\u0006\u001a\u0004\b2\u00103R\u0011\u00106\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b5\u0010("}, d2 = {"Lkotlin/text/Regex;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "input", "", "containsMatchIn", "(Ljava/lang/CharSequence;)Z", "", "startIndex", "Lkotlin/text/MatchResult;", "find", "(Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;", "Lkotlin/sequences/Sequence;", "findAll", "(Ljava/lang/CharSequence;I)Lkotlin/sequences/Sequence;", "index", "matchAt", "matchEntire", "(Ljava/lang/CharSequence;)Lkotlin/text/MatchResult;", "matches", "matchesAt", "(Ljava/lang/CharSequence;I)Z", "Lkotlin/Function1;", "transform", "", "replace", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/String;", "replacement", "(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;", "replaceFirst", HereUrlConstant.LIMIT, "", "split", "(Ljava/lang/CharSequence;I)Ljava/util/List;", "splitToSequence", "Ljava/util/regex/Pattern;", "toPattern", "()Ljava/util/regex/Pattern;", "toString", "()Ljava/lang/String;", "", "writeReplace", "()Ljava/lang/Object;", "", "Lkotlin/text/RegexOption;", "_options", "Ljava/util/Set;", "nativePattern", "Ljava/util/regex/Pattern;", "getOptions", "()Ljava/util/Set;", SecurityConstants.KEY_OPTIONS, "getPattern", "pattern", "<init>", "(Ljava/lang/String;)V", "option", "(Ljava/lang/String;Lkotlin/text/RegexOption;)V", "(Ljava/lang/String;Ljava/util/Set;)V", "(Ljava/util/regex/Pattern;)V", "Companion", "Serialized"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Regex implements Serializable {

    /* renamed from: Companion  reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Set<? extends RegexOption> _options;
    private final Pattern nativePattern;

    public Regex(Pattern pattern) {
        Intrinsics.checkNotNullParameter(pattern, "");
        this.nativePattern = pattern;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r3, kotlin.text.RegexOption r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.text.Regex$Companion r1 = kotlin.text.Regex.INSTANCE
            int r4 = r4.getValue()
            int r4 = kotlin.text.Regex.Companion.access$ensureUnicodeCase(r1, r4)
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, kotlin.text.RegexOption):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Regex(java.lang.String r3, java.util.Set<? extends kotlin.text.RegexOption> r4) {
        /*
            r2 = this;
            java.lang.String r0 = ""
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.text.Regex$Companion r1 = kotlin.text.Regex.INSTANCE
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            int r4 = kotlin.text.RegexKt.access$toInt(r4)
            int r4 = kotlin.text.Regex.Companion.access$ensureUnicodeCase(r1, r4)
            java.util.regex.Pattern r3 = java.util.regex.Pattern.compile(r3, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String, java.util.Set):void");
    }

    @JvmName(name = "getPattern")
    public final String getPattern() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "");
        return pattern;
    }

    @JvmName(name = "getOptions")
    public final Set<RegexOption> getOptions() {
        Set set = this._options;
        if (set == null) {
            final int flags = this.nativePattern.flags();
            EnumSet allOf = EnumSet.allOf(RegexOption.class);
            Intrinsics.checkNotNullExpressionValue(allOf, "");
            CollectionsKt.retainAll(allOf, new Function1<RegexOption, Boolean>() { // from class: kotlin.text.Regex$special$$inlined$fromInt$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(RegexOption regexOption) {
                    RegexOption regexOption2 = regexOption;
                    return Boolean.valueOf((flags & regexOption2.getMask()) == regexOption2.getValue());
                }
            });
            Set<RegexOption> unmodifiableSet = Collections.unmodifiableSet(allOf);
            Intrinsics.checkNotNullExpressionValue(unmodifiableSet, "");
            this._options = unmodifiableSet;
            return unmodifiableSet;
        }
        return set;
    }

    public final boolean matches(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "");
        return this.nativePattern.matcher(input).matches();
    }

    public final boolean containsMatchIn(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "");
        return this.nativePattern.matcher(input).find();
    }

    public static /* synthetic */ MatchResult find$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.find(charSequence, i);
    }

    public final MatchResult find(CharSequence input, int startIndex) {
        Intrinsics.checkNotNullParameter(input, "");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "");
        return RegexKt.access$findNext(matcher, startIndex, input);
    }

    public static /* synthetic */ Sequence findAll$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.findAll(charSequence, i);
    }

    public final Sequence<MatchResult> findAll(final CharSequence input, final int startIndex) {
        Intrinsics.checkNotNullParameter(input, "");
        if (startIndex < 0 || startIndex > input.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append("Start index out of bounds: ");
            sb.append(startIndex);
            sb.append(", input length: ");
            sb.append(input.length());
            throw new IndexOutOfBoundsException(sb.toString());
        }
        return SequencesKt.generateSequence((Function0) new Function0<MatchResult>() { // from class: kotlin.text.Regex$findAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final MatchResult invoke() {
                return Regex.this.find(input, startIndex);
            }
        }, (Function1) Regex$findAll$2.INSTANCE);
    }

    public final MatchResult matchEntire(CharSequence input) {
        Intrinsics.checkNotNullParameter(input, "");
        Matcher matcher = this.nativePattern.matcher(input);
        Intrinsics.checkNotNullExpressionValue(matcher, "");
        return RegexKt.access$matchEntire(matcher, input);
    }

    public final MatchResult matchAt(CharSequence input, int index) {
        MatcherMatchResult matcherMatchResult;
        Intrinsics.checkNotNullParameter(input, "");
        Matcher region = this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length());
        if (region.lookingAt()) {
            Intrinsics.checkNotNullExpressionValue(region, "");
            matcherMatchResult = new MatcherMatchResult(region, input);
        } else {
            matcherMatchResult = null;
        }
        return matcherMatchResult;
    }

    public final boolean matchesAt(CharSequence input, int index) {
        Intrinsics.checkNotNullParameter(input, "");
        return this.nativePattern.matcher(input).useAnchoringBounds(false).useTransparentBounds(true).region(index, input.length()).lookingAt();
    }

    public final String replace(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "");
        Intrinsics.checkNotNullParameter(replacement, "");
        String replaceAll = this.nativePattern.matcher(input).replaceAll(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceAll, "");
        return replaceAll;
    }

    public final String replace(CharSequence input, Function1<? super MatchResult, ? extends CharSequence> transform) {
        Intrinsics.checkNotNullParameter(input, "");
        Intrinsics.checkNotNullParameter(transform, "");
        int i = 0;
        MatchResult find$default = find$default(this, input, 0, 2, null);
        if (find$default == null) {
            return input.toString();
        }
        int length = input.length();
        StringBuilder sb = new StringBuilder(length);
        do {
            sb.append(input, i, find$default.getRange().getStart().intValue());
            sb.append(transform.invoke(find$default));
            i = find$default.getRange().getEndInclusive().intValue() + 1;
            find$default = find$default.next();
            if (i >= length) {
                break;
            }
        } while (find$default != null);
        if (i < length) {
            sb.append(input, i, length);
        }
        String obj = sb.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    public final String replaceFirst(CharSequence input, String replacement) {
        Intrinsics.checkNotNullParameter(input, "");
        Intrinsics.checkNotNullParameter(replacement, "");
        String replaceFirst = this.nativePattern.matcher(input).replaceFirst(replacement);
        Intrinsics.checkNotNullExpressionValue(replaceFirst, "");
        return replaceFirst;
    }

    public static /* synthetic */ List split$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.split(charSequence, i);
    }

    public final List<String> split(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "");
        StringsKt.requireNonNegativeLimit(limit);
        Matcher matcher = this.nativePattern.matcher(input);
        if (limit == 1 || !matcher.find()) {
            return CollectionsKt.listOf(input.toString());
        }
        ArrayList arrayList = new ArrayList(limit > 0 ? RangesKt.coerceAtMost(limit, 10) : 10);
        int i = limit - 1;
        int i2 = 0;
        do {
            arrayList.add(input.subSequence(i2, matcher.start()).toString());
            i2 = matcher.end();
            if (i >= 0 && arrayList.size() == i) {
                break;
            }
        } while (matcher.find());
        arrayList.add(input.subSequence(i2, input.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ Sequence splitToSequence$default(Regex regex, CharSequence charSequence, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return regex.splitToSequence(charSequence, i);
    }

    public final Sequence<String> splitToSequence(CharSequence input, int limit) {
        Intrinsics.checkNotNullParameter(input, "");
        StringsKt.requireNonNegativeLimit(limit);
        return SequencesKt.sequence(new Regex$splitToSequence$1(this, input, limit, null));
    }

    public final String toString() {
        String obj = this.nativePattern.toString();
        Intrinsics.checkNotNullExpressionValue(obj, "");
        return obj;
    }

    /* renamed from: toPattern  reason: from getter */
    public final Pattern getNativePattern() {
        return this.nativePattern;
    }

    private final Object writeReplace() {
        String pattern = this.nativePattern.pattern();
        Intrinsics.checkNotNullExpressionValue(pattern, "");
        return new Serialized(pattern, this.nativePattern.flags());
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00122\u00060\u0001j\u0002`\u0002:\u0001\u0012B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0017\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0007X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f"}, d2 = {"Lkotlin/text/Regex$Serialized;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "", "readResolve", "()Ljava/lang/Object;", "", "flags", "I", "getFlags", "()I", "", "pattern", "Ljava/lang/String;", "getPattern", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;I)V", "Companion"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes2.dex */
    static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;
        private final int flags;
        private final String pattern;

        public Serialized(String str, int i) {
            Intrinsics.checkNotNullParameter(str, "");
            this.pattern = str;
            this.flags = i;
        }

        @JvmName(name = "getFlags")
        public final int getFlags() {
            return this.flags;
        }

        @JvmName(name = "getPattern")
        public final String getPattern() {
            return this.pattern;
        }

        private final Object readResolve() {
            Pattern compile = Pattern.compile(this.pattern, this.flags);
            Intrinsics.checkNotNullExpressionValue(compile, "");
            return new Regex(compile);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\n\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\tJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\r"}, d2 = {"Lkotlin/text/Regex$Companion;", "", "", "flags", "ensureUnicodeCase", "(I)I", "", "literal", "escape", "(Ljava/lang/String;)Ljava/lang/String;", "escapeReplacement", "Lkotlin/text/Regex;", "fromLiteral", "(Ljava/lang/String;)Lkotlin/text/Regex;", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int ensureUnicodeCase(int flags) {
            return (flags & 2) != 0 ? flags | 64 : flags;
        }

        private Companion() {
        }

        public final Regex fromLiteral(String literal) {
            Intrinsics.checkNotNullParameter(literal, "");
            return new Regex(literal, RegexOption.LITERAL);
        }

        public final String escape(String literal) {
            Intrinsics.checkNotNullParameter(literal, "");
            String quote = Pattern.quote(literal);
            Intrinsics.checkNotNullExpressionValue(quote, "");
            return quote;
        }

        public final String escapeReplacement(String literal) {
            Intrinsics.checkNotNullParameter(literal, "");
            String quoteReplacement = Matcher.quoteReplacement(literal);
            Intrinsics.checkNotNullExpressionValue(quoteReplacement, "");
            return quoteReplacement;
        }
    }
}
