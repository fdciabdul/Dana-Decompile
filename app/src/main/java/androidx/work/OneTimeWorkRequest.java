package androidx.work;

import android.os.Build;
import androidx.work.WorkRequest;

/* loaded from: classes.dex */
public final class OneTimeWorkRequest extends WorkRequest {
    OneTimeWorkRequest(Builder builder) {
        super(builder.BuiltInFictitiousFunctionClassFactory, builder.KClassImpl$Data$declaredNonStaticMembers$2, builder.PlaceComponentResult);
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends WorkRequest.Builder<Builder, OneTimeWorkRequest> {
        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.work.WorkRequest.Builder
        public final /* bridge */ /* synthetic */ Builder MyBillsEntityDataFactory() {
            return this;
        }

        public Builder(Class<? extends ListenableWorker> cls) {
            super(cls);
            this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda1 = OverwritingInputMerger.class.getName();
        }

        @Override // androidx.work.WorkRequest.Builder
        final /* synthetic */ OneTimeWorkRequest PlaceComponentResult() {
            if (this.MyBillsEntityDataFactory && Build.VERSION.SDK_INT >= 23 && this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory.getAuthRequestContext()) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job");
            }
            return new OneTimeWorkRequest(this);
        }
    }
}
