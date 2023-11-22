package pl.charmas.android.reactivelocation2.observables.activity;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.ActivityRecognition;
import com.google.android.gms.location.ActivityRecognitionResult;
import io.reactivex.ObservableEmitter;

/* loaded from: classes9.dex */
public class ActivityUpdatesObservableOnSubscribe extends BaseActivityObservableOnSubscribe<ActivityRecognitionResult> {
    private ActivityUpdatesBroadcastReceiver KClassImpl$Data$declaredNonStaticMembers$2;
    private final int PlaceComponentResult;
    private final Context getAuthRequestContext;

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void KClassImpl$Data$declaredNonStaticMembers$2(GoogleApiClient googleApiClient, ObservableEmitter<? super ActivityRecognitionResult> observableEmitter) {
        ActivityUpdatesBroadcastReceiver activityUpdatesBroadcastReceiver = new ActivityUpdatesBroadcastReceiver(observableEmitter);
        this.KClassImpl$Data$declaredNonStaticMembers$2 = activityUpdatesBroadcastReceiver;
        this.getAuthRequestContext.registerReceiver(activityUpdatesBroadcastReceiver, new IntentFilter("pl.charmas.android.reactivelocation2.ACTION_ACTIVITY_UPDATE_DETECTED"));
        ActivityRecognition.ActivityRecognitionApi.requestActivityUpdates(googleApiClient, this.PlaceComponentResult, PendingIntent.getBroadcast(this.getAuthRequestContext, 0, new Intent("pl.charmas.android.reactivelocation2.ACTION_ACTIVITY_UPDATE_DETECTED"), 134217728));
    }

    @Override // pl.charmas.android.reactivelocation2.observables.BaseObservableOnSubscribe
    public final void getAuthRequestContext(GoogleApiClient googleApiClient) {
        if (googleApiClient.isConnected()) {
            ActivityRecognition.ActivityRecognitionApi.removeActivityUpdates(googleApiClient, PendingIntent.getBroadcast(this.getAuthRequestContext, 0, new Intent("pl.charmas.android.reactivelocation2.ACTION_ACTIVITY_UPDATE_DETECTED"), 134217728));
        }
        ActivityUpdatesBroadcastReceiver activityUpdatesBroadcastReceiver = this.KClassImpl$Data$declaredNonStaticMembers$2;
        if (activityUpdatesBroadcastReceiver != null) {
            this.getAuthRequestContext.unregisterReceiver(activityUpdatesBroadcastReceiver);
            this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        }
    }

    /* loaded from: classes9.dex */
    static class ActivityUpdatesBroadcastReceiver extends BroadcastReceiver {
        private final ObservableEmitter<? super ActivityRecognitionResult> KClassImpl$Data$declaredNonStaticMembers$2;

        public ActivityUpdatesBroadcastReceiver(ObservableEmitter<? super ActivityRecognitionResult> observableEmitter) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = observableEmitter;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (ActivityRecognitionResult.hasResult(intent)) {
                this.KClassImpl$Data$declaredNonStaticMembers$2.onNext(ActivityRecognitionResult.extractResult(intent));
            }
        }
    }
}
