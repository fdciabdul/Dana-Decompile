package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.events.EventsRecorderTask;
import io.split.android.client.service.events.EventsRecorderTaskConfig;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;

/* loaded from: classes6.dex */
public class EventsRecorderWorker extends SplitWorker {
    public EventsRecorderWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        try {
            Object obj = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_EVENTS_PER_PUSH);
            int intValue = obj instanceof Integer ? ((Integer) obj).intValue() : 100;
            boolean authRequestContext = workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.SHOULD_RECORD_TELEMETRY);
            Object obj2 = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get("apiKey");
            this.mSplitTask = new EventsRecorderTask(ServiceFactory.getEventsRecorder(getHttpClient(), getEndPoint()), StorageFactory.getPersistentEventsStorageForWorker(getDatabase(), obj2 instanceof String ? (String) obj2 : null, workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED)), new EventsRecorderTaskConfig(intValue), StorageFactory.getTelemetryStorage(authRequestContext));
        } catch (URISyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating Split worker: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
        }
    }
}
