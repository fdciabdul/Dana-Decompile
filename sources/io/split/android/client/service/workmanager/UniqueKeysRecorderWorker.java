package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.Data;
import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.impressions.unique.MTK;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTask;
import io.split.android.client.service.impressions.unique.UniqueKeysRecorderTaskConfig;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.storage.impressions.PersistentImpressionsUniqueStorage;
import io.split.android.client.utils.logger.Logger;

/* loaded from: classes6.dex */
public class UniqueKeysRecorderWorker extends SplitWorker {
    public UniqueKeysRecorderWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        try {
            Data data = workerParameters.BuiltInFictitiousFunctionClassFactory;
            Object obj = data.MyBillsEntityDataFactory.get("apiKey");
            String str = obj instanceof String ? (String) obj : null;
            boolean authRequestContext = data.getAuthRequestContext(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED);
            HttpRecorder<MTK> uniqueKeysRecorder = ServiceFactory.getUniqueKeysRecorder(getHttpClient(), getEndPoint());
            PersistentImpressionsUniqueStorage persistentImpressionsUniqueStorageForWorker = StorageFactory.getPersistentImpressionsUniqueStorageForWorker(getDatabase(), str, authRequestContext);
            Object obj2 = data.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_PER_PUSH);
            int intValue = obj2 instanceof Integer ? ((Integer) obj2).intValue() : 100;
            Object obj3 = data.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_UNIQUE_KEYS_ESTIMATED_SIZE_IN_BYTES);
            this.mSplitTask = new UniqueKeysRecorderTask(uniqueKeysRecorder, persistentImpressionsUniqueStorageForWorker, new UniqueKeysRecorderTaskConfig(intValue, obj3 instanceof Long ? ((Long) obj3).longValue() : 150L));
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating unique keys Split worker: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
        }
    }
}
