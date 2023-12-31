package kotlin.text;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.List;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.text.MatchResult;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b!\u0010\"J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0016¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001a\u0010\f\u001a\u00020\u000b8\u0017X\u0097\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138CX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u001a8WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f"}, d2 = {"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", HummerConstants.HUMMER_NEXT, "()Lkotlin/text/MatchResult;", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues", "groupValues_", "Ljava/util/List;", "Lkotlin/text/MatchGroupCollection;", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "", "input", "Ljava/lang/CharSequence;", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "matchResult", "Ljava/util/regex/Matcher;", "matcher", "Ljava/util/regex/Matcher;", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "range", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
final class MatcherMatchResult implements MatchResult {
    private List<String> groupValues_;
    private final MatchGroupCollection groups;
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(matcher, "");
        Intrinsics.checkNotNullParameter(charSequence, "");
        this.matcher = matcher;
        this.input = charSequence;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    @Override // kotlin.text.MatchResult
    public final MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmName(name = "getMatchResult")
    public final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override // kotlin.text.MatchResult
    @JvmName(name = "getRange")
    public final IntRange getRange() {
        return RegexKt.access$range(getMatchResult());
    }

    @Override // kotlin.text.MatchResult
    @JvmName(name = "getValue")
    public final String getValue() {
        String group = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(group, "");
        return group;
    }

    @Override // kotlin.text.MatchResult
    @JvmName(name = "getGroups")
    public final MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override // kotlin.text.MatchResult
    @JvmName(name = "getGroupValues")
    public final List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new AbstractList<String>() { // from class: kotlin.text.MatcherMatchResult$groupValues$1
                @Override // kotlin.collections.AbstractCollection, java.util.Collection
                public final /* bridge */ boolean contains(Object obj) {
                    if (obj instanceof String) {
                        return contains((String) obj);
                    }
                    return false;
                }

                public final /* bridge */ boolean contains(String str) {
                    return super.contains((MatcherMatchResult$groupValues$1) str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int indexOf(Object obj) {
                    if (obj instanceof String) {
                        return indexOf((String) obj);
                    }
                    return -1;
                }

                public final /* bridge */ int indexOf(String str) {
                    return super.indexOf((MatcherMatchResult$groupValues$1) str);
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final /* bridge */ int lastIndexOf(Object obj) {
                    if (obj instanceof String) {
                        return lastIndexOf((String) obj);
                    }
                    return -1;
                }

                public final /* bridge */ int lastIndexOf(String str) {
                    return super.lastIndexOf((MatcherMatchResult$groupValues$1) str);
                }

                @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
                @JvmName(name = "getSize")
                /* renamed from: getSize */
                public final int get_size() {
                    java.util.regex.MatchResult matchResult;
                    matchResult = MatcherMatchResult.this.getMatchResult();
                    return matchResult.groupCount() + 1;
                }

                @Override // kotlin.collections.AbstractList, java.util.List
                public final String get(int index) {
                    java.util.regex.MatchResult matchResult;
                    matchResult = MatcherMatchResult.this.getMatchResult();
                    String group = matchResult.group(index);
                    return group == null ? "" : group;
                }
            };
        }
        List<String> list = this.groupValues_;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override // kotlin.text.MatchResult
    public final MatchResult next() {
        int end = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (end <= this.input.length()) {
            Matcher matcher = this.matcher.pattern().matcher(this.input);
            Intrinsics.checkNotNullExpressionValue(matcher, "");
            return RegexKt.access$findNext(matcher, end, this.input);
        }
        return null;
    }
}
