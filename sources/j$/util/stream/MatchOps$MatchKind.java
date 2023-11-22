package j$.util.stream;

/* loaded from: classes.dex */
enum MatchOps$MatchKind {
    ANY(true, true),
    ALL(false, false),
    NONE(true, false);

    private final boolean shortCircuitResult;
    private final boolean stopOnPredicateMatches;

    MatchOps$MatchKind(boolean z, boolean z2) {
        this.stopOnPredicateMatches = z;
        this.shortCircuitResult = z2;
    }
}
