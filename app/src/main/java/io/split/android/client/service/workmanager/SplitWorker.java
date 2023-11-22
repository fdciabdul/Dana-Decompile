package io.split.android.client.service.workmanager;

import android.content.Context;
import androidx.work.Data;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.common.base.Preconditions;
import io.split.android.android_client.BuildConfig;
import io.split.android.client.network.HttpClient;
import io.split.android.client.network.HttpClientImpl;
import io.split.android.client.network.SplitHttpHeadersBuilder;
import io.split.android.client.service.ServiceConstants;
import io.split.android.client.service.executor.SplitTask;
import io.split.android.client.storage.db.SplitRoomDatabase;

/* loaded from: classes6.dex */
public abstract class SplitWorker extends Worker {
    private final long mCacheExpirationInSeconds;
    private final SplitRoomDatabase mDatabase;
    private final String mEndpoint;
    private final HttpClient mHttpClient;
    protected SplitTask mSplitTask;

    public SplitWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Data data = workerParameters.BuiltInFictitiousFunctionClassFactory;
        Object obj = data.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_DATABASE_NAME);
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = data.MyBillsEntityDataFactory.get("apiKey");
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = data.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_ENDPOINT);
        this.mEndpoint = obj3 instanceof String ? (String) obj3 : null;
        this.mDatabase = SplitRoomDatabase.getDatabase(context, str);
        Object obj4 = data.MyBillsEntityDataFactory.get(ServiceConstants.WORKER_PARAM_SPLIT_CACHE_EXPIRATION);
        this.mCacheExpirationInSeconds = obj4 instanceof Long ? ((Long) obj4).longValue() : 864000L;
        SplitHttpHeadersBuilder splitHttpHeadersBuilder = new SplitHttpHeadersBuilder();
        splitHttpHeadersBuilder.setClientVersion(BuildConfig.SPLIT_VERSION_NAME);
        splitHttpHeadersBuilder.setApiToken(str2);
        splitHttpHeadersBuilder.addJsonTypeHeaders();
        HttpClient build = new HttpClientImpl.Builder().build();
        this.mHttpClient = build;
        build.addHeaders(splitHttpHeadersBuilder.build());
    }

    @Override // androidx.work.Worker
    public ListenableWorker.Result doWork() {
        Preconditions.checkNotNull(this.mSplitTask);
        this.mSplitTask.execute();
        return ListenableWorker.Result.BuiltInFictitiousFunctionClassFactory();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public SplitRoomDatabase getDatabase() {
        return this.mDatabase;
    }

    public HttpClient getHttpClient() {
        return this.mHttpClient;
    }

    public String getEndPoint() {
        return this.mEndpoint;
    }

    public long getCacheExpirationInSeconds() {
        return this.mCacheExpirationInSeconds;
    }
}
