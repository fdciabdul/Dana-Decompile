package com.yarolegovich.discretescrollview;

/* loaded from: classes8.dex */
enum Direction {
    START { // from class: com.yarolegovich.discretescrollview.Direction.1
        @Override // com.yarolegovich.discretescrollview.Direction
        public final int applyTo(int i) {
            return i * (-1);
        }

        @Override // com.yarolegovich.discretescrollview.Direction
        public final boolean sameAs(int i) {
            return i < 0;
        }
    },
    END { // from class: com.yarolegovich.discretescrollview.Direction.2
        @Override // com.yarolegovich.discretescrollview.Direction
        public final int applyTo(int i) {
            return i;
        }

        @Override // com.yarolegovich.discretescrollview.Direction
        public final boolean sameAs(int i) {
            return i > 0;
        }
    };

    public abstract int applyTo(int i);

    public abstract boolean sameAs(int i);

    public static Direction fromDelta(int i) {
        return i > 0 ? END : START;
    }
}
