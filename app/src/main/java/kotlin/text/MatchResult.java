package kotlin.text;

import com.ap.zoloz.hummer.biz.HummerConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\u0018J\u0011\u0010\u0002\u001a\u0004\u0018\u00010\u0000H&¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00048WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0010\u001a\u00020\r8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0017\u001a\u00020\t8'X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016"}, d2 = {"Lkotlin/text/MatchResult;", "", HummerConstants.HUMMER_NEXT, "()Lkotlin/text/MatchResult;", "Lkotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "destructured", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groups", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "range", "getValue", "()Ljava/lang/String;", "value", "Destructured"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MatchResult {
    @JvmName(name = "getDestructured")
    Destructured getDestructured();

    @JvmName(name = "getGroupValues")
    List<String> getGroupValues();

    @JvmName(name = "getGroups")
    MatchGroupCollection getGroups();

    @JvmName(name = "getRange")
    IntRange getRange();

    @JvmName(name = "getValue")
    String getValue();

    MatchResult next();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Destructured getDestructured(MatchResult matchResult) {
            return new Destructured(matchResult);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0003\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\t\u0010\u0004J\u0010\u0010\n\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\u000b\u0010\u0004J\u0010\u0010\f\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\r\u001a\u00020\u0002H\u0086\n¢\u0006\u0004\b\r\u0010\u0004J\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00118\u0007¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015"}, d2 = {"Lkotlin/text/MatchResult$Destructured;", "", "", "component1", "()Ljava/lang/String;", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "", "toList", "()Ljava/util/List;", "Lkotlin/text/MatchResult;", "match", "Lkotlin/text/MatchResult;", "getMatch", "()Lkotlin/text/MatchResult;", "<init>", "(Lkotlin/text/MatchResult;)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Destructured {
        private final MatchResult match;

        public Destructured(MatchResult matchResult) {
            Intrinsics.checkNotNullParameter(matchResult, "");
            this.match = matchResult;
        }

        @JvmName(name = "getMatch")
        public final MatchResult getMatch() {
            return this.match;
        }

        private final String component1() {
            return getMatch().getGroupValues().get(1);
        }

        private final String component2() {
            return getMatch().getGroupValues().get(2);
        }

        private final String component3() {
            return getMatch().getGroupValues().get(3);
        }

        private final String component4() {
            return getMatch().getGroupValues().get(4);
        }

        private final String component5() {
            return getMatch().getGroupValues().get(5);
        }

        private final String component6() {
            return getMatch().getGroupValues().get(6);
        }

        private final String component7() {
            return getMatch().getGroupValues().get(7);
        }

        private final String component8() {
            return getMatch().getGroupValues().get(8);
        }

        private final String component9() {
            return getMatch().getGroupValues().get(9);
        }

        private final String component10() {
            return getMatch().getGroupValues().get(10);
        }

        public final List<String> toList() {
            return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
        }
    }
}
