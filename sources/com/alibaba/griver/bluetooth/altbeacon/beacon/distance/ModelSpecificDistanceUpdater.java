package com.alibaba.griver.bluetooth.altbeacon.beacon.distance;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;

/* loaded from: classes6.dex */
public class ModelSpecificDistanceUpdater extends AsyncTask<Void, Void, Void> {
    private static final String TAG = "ModelSpecificDistanceUpdater";
    private CompletionHandler mCompletionHandler;
    private Context mContext;
    private DistanceConfigFetcher mDistanceConfigFetcher;
    private Exception exception = null;
    private String urlString = null;
    private String response = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface CompletionHandler {
        void onComplete(String str, Exception exc, int i);
    }

    private String getVersion() {
        return "1.0";
    }

    protected void onPostExecute() {
    }

    public ModelSpecificDistanceUpdater(Context context, String str, CompletionHandler completionHandler) {
        this.mContext = context;
        this.mDistanceConfigFetcher = new DistanceConfigFetcher(str, getUserAgentString());
        this.mCompletionHandler = completionHandler;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Void doInBackground(Void... voidArr) {
        this.mDistanceConfigFetcher.request();
        CompletionHandler completionHandler = this.mCompletionHandler;
        if (completionHandler != null) {
            completionHandler.onComplete(this.mDistanceConfigFetcher.getResponseString(), this.mDistanceConfigFetcher.getException(), this.mDistanceConfigFetcher.getResponseCode());
            return null;
        }
        return null;
    }

    private String getUserAgentString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Android Beacon Library;");
        sb.append(getVersion());
        sb.append(";");
        sb.append(getPackage());
        sb.append(";");
        sb.append(getInstallId());
        sb.append(";");
        sb.append(getModel());
        return sb.toString();
    }

    private String getPackage() {
        return this.mContext.getPackageName();
    }

    private String getModel() {
        return AndroidModel.forThisDevice().toString();
    }

    private String getInstallId() {
        return Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
    }
}
