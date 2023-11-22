package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.network.HttpClient;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.mysegments.MySegmentsBulkSyncTask;
import io.split.android.client.service.mysegments.MySegmentsSyncTask;
import io.split.android.client.storage.db.SplitRoomDatabase;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes6.dex */
public class MySegmentsSyncWorker extends SplitWorker {
    public MySegmentsSyncWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Object obj = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get("key");
        String[] strArr = obj instanceof String[] ? (String[]) obj : null;
        Object obj2 = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get("apiKey");
        String str = obj2 instanceof String ? (String) obj2 : null;
        boolean authRequestContext = workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED);
        boolean authRequestContext2 = workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.SHOULD_RECORD_TELEMETRY);
        try {
            if (strArr == null) {
                Logger.e("Error scheduling segments sync worker: Keys are null");
            } else {
                this.mSplitTask = new MySegmentsBulkSyncTask(Collections.unmodifiableSet(getIndividualMySegmentsSyncTasks(strArr, authRequestContext2, getHttpClient(), getEndPoint(), getDatabase(), str, authRequestContext)));
            }
        } catch (URISyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating Split worker: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
        }
    }

    private static Set<MySegmentsSyncTask> getIndividualMySegmentsSyncTasks(String[] strArr, boolean z, HttpClient httpClient, String str, SplitRoomDatabase splitRoomDatabase, String str2, boolean z2) throws URISyntaxException {
        HashSet hashSet = new HashSet();
        for (String str3 : strArr) {
            hashSet.add(new MySegmentsSyncTask(ServiceFactory.getMySegmentsFetcher(httpClient, str, str3), StorageFactory.getMySegmentsStorageForWorker(splitRoomDatabase, str2, z2).getStorageForKey(str3), false, null, StorageFactory.getTelemetryStorage(z)));
        }
        return hashSet;
    }
}
