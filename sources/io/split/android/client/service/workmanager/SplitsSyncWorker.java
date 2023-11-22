package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.WorkerParameters;
import io.split.android.client.dtos.SplitChange;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.ServiceFactory;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.splits.SplitChangeProcessor;
import io.split.android.client.service.splits.SplitsSyncHelper;
import io.split.android.client.service.splits.SplitsSyncTask;
import io.split.android.client.storage.db.StorageFactory;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorage;
import io.split.android.client.utils.logger.Logger;
import java.net.URISyntaxException;

/* loaded from: classes6.dex */
public class SplitsSyncWorker extends SplitWorker {
    public SplitsSyncWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        try {
            boolean authRequestContext = workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.SHOULD_RECORD_TELEMETRY);
            Object obj = workerParameters.BuiltInFictitiousFunctionClassFactory.MyBillsEntityDataFactory.get("apiKey");
            SplitsStorage splitsStorageForWorker = StorageFactory.getSplitsStorageForWorker(getDatabase(), obj instanceof String ? (String) obj : null, workerParameters.BuiltInFictitiousFunctionClassFactory.getAuthRequestContext(ServiceConstants.WORKER_PARAM_ENCRYPTION_ENABLED));
            splitsStorageForWorker.loadLocal();
            HttpFetcher<SplitChange> splitsFetcher = ServiceFactory.getSplitsFetcher(getHttpClient(), getEndPoint(), splitsStorageForWorker.getSplitsFilterQueryString());
            TelemetryStorage telemetryStorage = StorageFactory.getTelemetryStorage(authRequestContext);
            this.mSplitTask = buildSplitSyncTask(splitsStorageForWorker, telemetryStorage, new SplitsSyncHelper(splitsFetcher, splitsStorageForWorker, new SplitChangeProcessor(), telemetryStorage));
        } catch (URISyntaxException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Error creating Split worker: ");
            sb.append(e.getMessage());
            Logger.e(sb.toString());
        }
    }

    private SplitTask buildSplitSyncTask(SplitsStorage splitsStorage, TelemetryStorage telemetryStorage, SplitsSyncHelper splitsSyncHelper) {
        return SplitsSyncTask.buildForBackground(splitsSyncHelper, splitsStorage, false, getCacheExpirationInSeconds(), splitsStorage.getSplitsFilterQueryString(), telemetryStorage);
    }
}
