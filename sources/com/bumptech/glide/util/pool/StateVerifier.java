package com.bumptech.glide.util.pool;

/* loaded from: classes3.dex */
public abstract class StateVerifier {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void MyBillsEntityDataFactory(boolean z);

    public abstract void PlaceComponentResult();

    /* synthetic */ StateVerifier(byte b) {
        this();
    }

    public static StateVerifier KClassImpl$Data$declaredNonStaticMembers$2() {
        return new DefaultStateVerifier();
    }

    private StateVerifier() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class DefaultStateVerifier extends StateVerifier {
        private volatile boolean MyBillsEntityDataFactory;

        DefaultStateVerifier() {
            super((byte) 0);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public final void PlaceComponentResult() {
            if (this.MyBillsEntityDataFactory) {
                throw new IllegalStateException("Already released");
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public final void MyBillsEntityDataFactory(boolean z) {
            this.MyBillsEntityDataFactory = z;
        }
    }

    /* loaded from: classes7.dex */
    static class DebugStateVerifier extends StateVerifier {
        private volatile RuntimeException getAuthRequestContext;

        DebugStateVerifier() {
            super((byte) 0);
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        public final void PlaceComponentResult() {
            if (this.getAuthRequestContext != null) {
                throw new IllegalStateException("Already released", this.getAuthRequestContext);
            }
        }

        @Override // com.bumptech.glide.util.pool.StateVerifier
        final void MyBillsEntityDataFactory(boolean z) {
            if (z) {
                this.getAuthRequestContext = new RuntimeException("Released");
            } else {
                this.getAuthRequestContext = null;
            }
        }
    }
}
