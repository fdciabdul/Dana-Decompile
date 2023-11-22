package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.impressions.ImpressionsRecorderTask;
import io.split.android.client.service.impressions.ImpressionsRecorderTaskConfig;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;

/* loaded from: classes6.dex */
public class ImpressionsRecorderWorker extends SplitWorker {
    public ImpressionsRecorderWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        try {
            Object obj = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_IMPRESSIONS_PER_PUSH);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 100;
            boolean authRequestContext = workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.SHOULD_RECORD_TELEMETRY);
            Object obj2 = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get("apiKey");
            String str = obj2 instanceof String ? (String) obj2 : null;
            boolean authRequestContext2 = workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED);
            ImpressionsRecorderTaskConfig impressionsRecorderTaskConfig = new ImpressionsRecorderTaskConfig(intValue, 150L, authRequestContext);
            this.mSplitTask = new ImpressionsRecorderTask(ServiceFactory.getImpressionsRecorder(getHttpClient(), getEndPoint()), StorageFactory.getPersistentImpressionsStorageForWorker(getDatabase(), str, authRequestContext2), impressionsRecorderTaskConfig, StorageFactory.getTelemetryStorage(impressionsRecorderTaskConfig.shouldRecordTelemetry()));
        } catch (URISyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating Split worker: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
        }
    }
}
