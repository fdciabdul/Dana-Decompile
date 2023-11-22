package androidx.work;

import android.os.Build;
import androidx.work.impl.model.WorkSpec;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public abstract class WorkRequest {
    public UUID KClassImpl$Data$declaredNonStaticMembers$2;
    public Set<String> MyBillsEntityDataFactory;
    public WorkSpec getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: protected */
    public WorkRequest(UUID uuid, WorkSpec workSpec, Set<String> set) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uuid;
        this.getAuthRequestContext = workSpec;
        this.MyBillsEntityDataFactory = set;
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<B extends Builder<?, ?>, W extends WorkRequest> {
        public WorkSpec KClassImpl$Data$declaredNonStaticMembers$2;
        Class<? extends ListenableWorker> getAuthRequestContext;
        boolean MyBillsEntityDataFactory = false;
        public Set<String> PlaceComponentResult = new HashSet();
        UUID BuiltInFictitiousFunctionClassFactory = UUID.randomUUID();

        public abstract B MyBillsEntityDataFactory();

        abstract W PlaceComponentResult();

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(Class<? extends ListenableWorker> cls) {
            this.getAuthRequestContext = cls;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new WorkSpec(this.BuiltInFictitiousFunctionClassFactory.toString(), cls.getName());
            this.PlaceComponentResult.add(cls.getName());
        }

        public final B getAuthRequestContext(BackoffPolicy backoffPolicy, long j, TimeUnit timeUnit) {
            this.MyBillsEntityDataFactory = true;
            this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext = backoffPolicy;
            WorkSpec workSpec = this.KClassImpl$Data$declaredNonStaticMembers$2;
            long millis = timeUnit.toMillis(j);
            if (millis > 18000000) {
                Logger.getAuthRequestContext().getAuthRequestContext(WorkSpec.KClassImpl$Data$declaredNonStaticMembers$2, "Backoff delay duration exceeds maximum value", new Throwable[0]);
                millis = 18000000;
            }
            if (millis < 10000) {
                Logger.getAuthRequestContext().getAuthRequestContext(WorkSpec.KClassImpl$Data$declaredNonStaticMembers$2, "Backoff delay duration less than minimum value", new Throwable[0]);
                millis = 10000;
            }
            workSpec.PlaceComponentResult = millis;
            return MyBillsEntityDataFactory();
        }

        public final B MyBillsEntityDataFactory(long j, TimeUnit timeUnit) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest = timeUnit.toMillis(j);
            if (LongCompanionObject.MAX_VALUE - System.currentTimeMillis() <= this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest) {
                throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!");
            }
            return MyBillsEntityDataFactory();
        }

        public final W KClassImpl$Data$declaredNonStaticMembers$2() {
            W PlaceComponentResult = PlaceComponentResult();
            Constraints constraints = this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory;
            boolean z = (Build.VERSION.SDK_INT >= 24 && constraints.KClassImpl$Data$declaredNonStaticMembers$2()) || constraints.BuiltInFictitiousFunctionClassFactory() || constraints.MyBillsEntityDataFactory() || (Build.VERSION.SDK_INT >= 23 && constraints.getAuthRequestContext());
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.scheduleImpl) {
                if (z) {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints");
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.lookAheadTest > 0) {
                    throw new IllegalArgumentException("Expedited jobs cannot be delayed");
                }
            }
            this.BuiltInFictitiousFunctionClassFactory = UUID.randomUUID();
            WorkSpec workSpec = new WorkSpec(this.KClassImpl$Data$declaredNonStaticMembers$2);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = workSpec;
            workSpec.getErrorConfigVersion = this.BuiltInFictitiousFunctionClassFactory.toString();
            return PlaceComponentResult;
        }
    }
}
