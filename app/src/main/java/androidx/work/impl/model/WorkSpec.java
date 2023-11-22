package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class WorkSpec {
    public OutOfQuotaPolicy DatabaseTableConfigUtil;
    public long GetContactSyncConfig;
    public Constraints MyBillsEntityDataFactory;
    public long NetworkUserEntityData$$ExternalSyntheticLambda0;
    public String NetworkUserEntityData$$ExternalSyntheticLambda1;
    public Data NetworkUserEntityData$$ExternalSyntheticLambda2;
    public WorkInfo.State NetworkUserEntityData$$ExternalSyntheticLambda7;
    public long NetworkUserEntityData$$ExternalSyntheticLambda8;
    public long PlaceComponentResult;
    public long PrepareContext;
    public BackoffPolicy getAuthRequestContext;
    public String getErrorConfigVersion;
    public long initRecordTimeStamp;
    public int isLayoutRequested;
    public long lookAheadTest;
    public Data moveToNextValue;
    public String newProxyInstance;
    public boolean scheduleImpl;
    public static final String KClassImpl$Data$declaredNonStaticMembers$2 = Logger.MyBillsEntityDataFactory("WorkSpec");
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> BuiltInFictitiousFunctionClassFactory = new Function<List<WorkInfoPojo>, List<WorkInfo>>() { // from class: androidx.work.impl.model.WorkSpec.1
        @Override // androidx.arch.core.util.Function
        public /* synthetic */ List<WorkInfo> getAuthRequestContext(List<WorkInfoPojo> list) {
            List<WorkInfoPojo> list2 = list;
            if (list2 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list2.size());
            Iterator<WorkInfoPojo> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().MyBillsEntityDataFactory());
            }
            return arrayList;
        }
    };

    public WorkSpec(String str, String str2) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkInfo.State.ENQUEUED;
        this.moveToNextValue = Data.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = Constraints.PlaceComponentResult;
        this.getAuthRequestContext = BackoffPolicy.EXPONENTIAL;
        this.PlaceComponentResult = 30000L;
        this.PrepareContext = -1L;
        this.DatabaseTableConfigUtil = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.getErrorConfigVersion = str;
        this.newProxyInstance = str2;
    }

    public WorkSpec(WorkSpec workSpec) {
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = WorkInfo.State.ENQUEUED;
        this.moveToNextValue = Data.BuiltInFictitiousFunctionClassFactory;
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Data.BuiltInFictitiousFunctionClassFactory;
        this.MyBillsEntityDataFactory = Constraints.PlaceComponentResult;
        this.getAuthRequestContext = BackoffPolicy.EXPONENTIAL;
        this.PlaceComponentResult = 30000L;
        this.PrepareContext = -1L;
        this.DatabaseTableConfigUtil = OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST;
        this.getErrorConfigVersion = workSpec.getErrorConfigVersion;
        this.newProxyInstance = workSpec.newProxyInstance;
        this.NetworkUserEntityData$$ExternalSyntheticLambda7 = workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7;
        this.NetworkUserEntityData$$ExternalSyntheticLambda1 = workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1;
        this.moveToNextValue = new Data(workSpec.moveToNextValue);
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Data(workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2);
        this.lookAheadTest = workSpec.lookAheadTest;
        this.initRecordTimeStamp = workSpec.initRecordTimeStamp;
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0;
        this.MyBillsEntityDataFactory = new Constraints(workSpec.MyBillsEntityDataFactory);
        this.isLayoutRequested = workSpec.isLayoutRequested;
        this.getAuthRequestContext = workSpec.getAuthRequestContext;
        this.PlaceComponentResult = workSpec.PlaceComponentResult;
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8;
        this.GetContactSyncConfig = workSpec.GetContactSyncConfig;
        this.PrepareContext = workSpec.PrepareContext;
        this.scheduleImpl = workSpec.scheduleImpl;
        this.DatabaseTableConfigUtil = workSpec.DatabaseTableConfigUtil;
    }

    public final boolean getAuthRequestContext() {
        return this.initRecordTimeStamp != 0;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda7 == WorkInfo.State.ENQUEUED && this.isLayoutRequested > 0;
    }

    public final long PlaceComponentResult() {
        long scalb;
        if (KClassImpl$Data$declaredNonStaticMembers$2()) {
            if (this.getAuthRequestContext == BackoffPolicy.LINEAR) {
                scalb = this.PlaceComponentResult * this.isLayoutRequested;
            } else {
                scalb = Math.scalb((float) this.PlaceComponentResult, this.isLayoutRequested - 1);
            }
            return this.NetworkUserEntityData$$ExternalSyntheticLambda8 + Math.min(18000000L, scalb);
        }
        if (getAuthRequestContext()) {
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
            long j2 = j == 0 ? currentTimeMillis + this.lookAheadTest : j;
            long j3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            long j4 = this.initRecordTimeStamp;
            if (j3 != j4) {
                return j2 + j4 + (j == 0 ? j3 * (-1) : 0L);
            }
            return j2 + (j != 0 ? j4 : 0L);
        }
        long j5 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        if (j5 == 0) {
            j5 = System.currentTimeMillis();
        }
        return j5 + this.lookAheadTest;
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return !Constraints.PlaceComponentResult.equals(this.MyBillsEntityDataFactory);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        if (this.lookAheadTest == workSpec.lookAheadTest && this.initRecordTimeStamp == workSpec.initRecordTimeStamp && this.NetworkUserEntityData$$ExternalSyntheticLambda0 == workSpec.NetworkUserEntityData$$ExternalSyntheticLambda0 && this.isLayoutRequested == workSpec.isLayoutRequested && this.PlaceComponentResult == workSpec.PlaceComponentResult && this.NetworkUserEntityData$$ExternalSyntheticLambda8 == workSpec.NetworkUserEntityData$$ExternalSyntheticLambda8 && this.GetContactSyncConfig == workSpec.GetContactSyncConfig && this.PrepareContext == workSpec.PrepareContext && this.scheduleImpl == workSpec.scheduleImpl && this.getErrorConfigVersion.equals(workSpec.getErrorConfigVersion) && this.NetworkUserEntityData$$ExternalSyntheticLambda7 == workSpec.NetworkUserEntityData$$ExternalSyntheticLambda7 && this.newProxyInstance.equals(workSpec.newProxyInstance)) {
            String str = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
            if (str == null ? workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1 == null : str.equals(workSpec.NetworkUserEntityData$$ExternalSyntheticLambda1)) {
                return this.moveToNextValue.equals(workSpec.moveToNextValue) && this.NetworkUserEntityData$$ExternalSyntheticLambda2.equals(workSpec.NetworkUserEntityData$$ExternalSyntheticLambda2) && this.MyBillsEntityDataFactory.equals(workSpec.MyBillsEntityDataFactory) && this.getAuthRequestContext == workSpec.getAuthRequestContext && this.DatabaseTableConfigUtil == workSpec.DatabaseTableConfigUtil;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.getErrorConfigVersion.hashCode();
        int hashCode2 = this.NetworkUserEntityData$$ExternalSyntheticLambda7.hashCode();
        int hashCode3 = this.newProxyInstance.hashCode();
        String str = this.NetworkUserEntityData$$ExternalSyntheticLambda1;
        int hashCode4 = str != null ? str.hashCode() : 0;
        int hashCode5 = this.moveToNextValue.hashCode();
        int hashCode6 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.hashCode();
        long j = this.lookAheadTest;
        int i = (int) (j ^ (j >>> 32));
        long j2 = this.initRecordTimeStamp;
        int i2 = (int) (j2 ^ (j2 >>> 32));
        long j3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
        int i3 = (int) (j3 ^ (j3 >>> 32));
        int hashCode7 = this.MyBillsEntityDataFactory.hashCode();
        int i4 = this.isLayoutRequested;
        int hashCode8 = this.getAuthRequestContext.hashCode();
        long j4 = this.PlaceComponentResult;
        int i5 = (int) (j4 ^ (j4 >>> 32));
        long j5 = this.NetworkUserEntityData$$ExternalSyntheticLambda8;
        int i6 = (int) (j5 ^ (j5 >>> 32));
        long j6 = this.GetContactSyncConfig;
        int i7 = (int) (j6 ^ (j6 >>> 32));
        long j7 = this.PrepareContext;
        return (((((((((((((((((((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i) * 31) + i2) * 31) + i3) * 31) + hashCode7) * 31) + i4) * 31) + hashCode8) * 31) + i5) * 31) + i6) * 31) + i7) * 31) + ((int) (j7 ^ (j7 >>> 32)))) * 31) + (this.scheduleImpl ? 1 : 0)) * 31) + this.DatabaseTableConfigUtil.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{WorkSpec: ");
        sb.append(this.getErrorConfigVersion);
        sb.append("}");
        return sb.toString();
    }

    /* loaded from: classes3.dex */
    public static class IdAndState {
        public WorkInfo.State KClassImpl$Data$declaredNonStaticMembers$2;
        public String MyBillsEntityDataFactory;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof IdAndState) {
                IdAndState idAndState = (IdAndState) obj;
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 != idAndState.KClassImpl$Data$declaredNonStaticMembers$2) {
                    return false;
                }
                return this.MyBillsEntityDataFactory.equals(idAndState.MyBillsEntityDataFactory);
            }
            return false;
        }

        public int hashCode() {
            return (this.MyBillsEntityDataFactory.hashCode() * 31) + this.KClassImpl$Data$declaredNonStaticMembers$2.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static class WorkInfoPojo {
        public WorkInfo.State BuiltInFictitiousFunctionClassFactory;
        public String KClassImpl$Data$declaredNonStaticMembers$2;
        public int MyBillsEntityDataFactory;
        public Data PlaceComponentResult;
        public List<Data> getAuthRequestContext;
        public List<String> scheduleImpl;

        public final WorkInfo MyBillsEntityDataFactory() {
            Data data;
            List<Data> list = this.getAuthRequestContext;
            if (list != null && !list.isEmpty()) {
                data = this.getAuthRequestContext.get(0);
            } else {
                data = Data.BuiltInFictitiousFunctionClassFactory;
            }
            return new WorkInfo(UUID.fromString(this.KClassImpl$Data$declaredNonStaticMembers$2), this.BuiltInFictitiousFunctionClassFactory, this.PlaceComponentResult, this.scheduleImpl, data, this.MyBillsEntityDataFactory);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof WorkInfoPojo) {
                WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
                if (this.MyBillsEntityDataFactory != workInfoPojo.MyBillsEntityDataFactory) {
                    return false;
                }
                String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
                if (str == null ? workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2 == null : str.equals(workInfoPojo.KClassImpl$Data$declaredNonStaticMembers$2)) {
                    if (this.BuiltInFictitiousFunctionClassFactory != workInfoPojo.BuiltInFictitiousFunctionClassFactory) {
                        return false;
                    }
                    Data data = this.PlaceComponentResult;
                    if (data == null ? workInfoPojo.PlaceComponentResult == null : data.equals(workInfoPojo.PlaceComponentResult)) {
                        List<String> list = this.scheduleImpl;
                        if (list == null ? workInfoPojo.scheduleImpl == null : list.equals(workInfoPojo.scheduleImpl)) {
                            List<Data> list2 = this.getAuthRequestContext;
                            List<Data> list3 = workInfoPojo.getAuthRequestContext;
                            return list2 != null ? list2.equals(list3) : list3 == null;
                        }
                        return false;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            String str = this.KClassImpl$Data$declaredNonStaticMembers$2;
            int hashCode = str != null ? str.hashCode() : 0;
            WorkInfo.State state = this.BuiltInFictitiousFunctionClassFactory;
            int hashCode2 = state != null ? state.hashCode() : 0;
            Data data = this.PlaceComponentResult;
            int hashCode3 = data != null ? data.hashCode() : 0;
            int i = this.MyBillsEntityDataFactory;
            List<String> list = this.scheduleImpl;
            int hashCode4 = list != null ? list.hashCode() : 0;
            List<Data> list2 = this.getAuthRequestContext;
            return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + hashCode4) * 31) + (list2 != null ? list2.hashCode() : 0);
        }
    }
}
