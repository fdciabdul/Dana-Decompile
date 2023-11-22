package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes7.dex */
public final class Batch extends BasePendingResult<BatchResult> {
    private int zae;
    private boolean zaf;
    private boolean zag;
    private final PendingResult<?>[] zah;
    private final Object zai;

    /* loaded from: classes7.dex */
    public static final class Builder {
        private List<PendingResult<?>> zaa = new ArrayList();
        private GoogleApiClient zab;

        public Builder(GoogleApiClient googleApiClient) {
            this.zab = googleApiClient;
        }

        public final <R extends Result> BatchResultToken<R> add(PendingResult<R> pendingResult) {
            BatchResultToken<R> batchResultToken = new BatchResultToken<>(this.zaa.size());
            this.zaa.add(pendingResult);
            return batchResultToken;
        }

        public final Batch build() {
            return new Batch(this.zaa, this.zab, null);
        }
    }

    /* synthetic */ Batch(List list, GoogleApiClient googleApiClient, zac zacVar) {
        super(googleApiClient);
        this.zai = new Object();
        int size = list.size();
        this.zae = size;
        PendingResult<?>[] pendingResultArr = new PendingResult[size];
        this.zah = pendingResultArr;
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                PendingResult<?> pendingResult = (PendingResult) list.get(i);
                this.zah[i] = pendingResult;
                pendingResult.addStatusListener(new zab(this));
            }
            return;
        }
        setResult(new BatchResult(Status.RESULT_SUCCESS, pendingResultArr));
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult, com.google.android.gms.common.api.PendingResult
    public final void cancel() {
        super.cancel();
        for (PendingResult<?> pendingResult : this.zah) {
            pendingResult.cancel();
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final BatchResult createFailedResult(Status status) {
        return new BatchResult(status, this.zah);
    }
}
