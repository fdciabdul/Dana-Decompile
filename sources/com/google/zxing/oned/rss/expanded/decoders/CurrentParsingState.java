package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
final class CurrentParsingState {
    private int position = 0;
    private State encoding = State.NUMERIC;

    /* loaded from: classes3.dex */
    enum State {
        NUMERIC,
        ALPHA,
        ISO_IEC_646
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int getPosition() {
        return this.position;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setPosition(int i) {
        this.position = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void incrementPosition(int i) {
        this.position += i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isAlpha() {
        return this.encoding == State.ALPHA;
    }

    final boolean isNumeric() {
        return this.encoding == State.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isIsoIec646() {
        return this.encoding == State.ISO_IEC_646;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setNumeric() {
        this.encoding = State.NUMERIC;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setAlpha() {
        this.encoding = State.ALPHA;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setIsoIec646() {
        this.encoding = State.ISO_IEC_646;
    }
}
