package com.xiaomi.push;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.bc;
import com.xiaomi.push.service.XMJobService;

/* loaded from: classes8.dex */
public class be implements bc.a {
    Context KClassImpl$Data$declaredNonStaticMembers$2;
    private boolean MyBillsEntityDataFactory;
    JobScheduler PlaceComponentResult;

    @Override // com.xiaomi.push.bc.a
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.MyBillsEntityDataFactory = false;
        this.PlaceComponentResult.cancel(1);
    }

    @Override // com.xiaomi.push.bc.a
    public final boolean MyBillsEntityDataFactory() {
        return this.MyBillsEntityDataFactory;
    }

    @Override // com.xiaomi.push.bc.a
    public final void MyBillsEntityDataFactory(boolean z) {
        if (z || this.MyBillsEntityDataFactory) {
            long PlaceComponentResult = by.PlaceComponentResult();
            if (z) {
                this.MyBillsEntityDataFactory = false;
                this.PlaceComponentResult.cancel(1);
                PlaceComponentResult -= SystemClock.elapsedRealtime() % PlaceComponentResult;
            }
            this.MyBillsEntityDataFactory = true;
            JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.KClassImpl$Data$declaredNonStaticMembers$2.getPackageName(), XMJobService.class.getName()));
            builder.setMinimumLatency(PlaceComponentResult);
            builder.setOverrideDeadline(PlaceComponentResult);
            builder.setRequiredNetworkType(1);
            builder.setPersisted(false);
            JobInfo build = builder.build();
            StringBuilder sb = new StringBuilder();
            sb.append("schedule Job = ");
            sb.append(build.getId());
            sb.append(" in ");
            sb.append(PlaceComponentResult);
            com.xiaomi.channel.commonutils.logger.b.BuiltInFictitiousFunctionClassFactory(sb.toString());
            this.PlaceComponentResult.schedule(builder.build());
        }
    }
}
