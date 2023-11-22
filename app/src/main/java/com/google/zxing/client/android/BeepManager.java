package com.google.zxing.client.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Vibrator;
import com.fullstory.instrumentation.InstrumentInjector;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class BeepManager {
    private static final float BEEP_VOLUME = 0.1f;
    private static final String TAG = "BeepManager";
    private static final long VIBRATE_DURATION = 200;
    private final Context context;
    private boolean beepEnabled = true;
    private boolean vibrateEnabled = false;

    public BeepManager(Activity activity) {
        activity.setVolumeControlStream(3);
        this.context = activity.getApplicationContext();
    }

    public final boolean isBeepEnabled() {
        return this.beepEnabled;
    }

    public final void setBeepEnabled(boolean z) {
        this.beepEnabled = z;
    }

    public final boolean isVibrateEnabled() {
        return this.vibrateEnabled;
    }

    public final void setVibrateEnabled(boolean z) {
        this.vibrateEnabled = z;
    }

    public final void playBeepSoundAndVibrate() {
        Vibrator vibrator;
        synchronized (this) {
            if (this.beepEnabled) {
                playBeepSound();
            }
            if (this.vibrateEnabled && (vibrator = (Vibrator) this.context.getSystemService("vibrator")) != null) {
                vibrator.vibrate(VIBRATE_DURATION);
            }
        }
    }

    public final MediaPlayer playBeepSound() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder().setContentType(2).build());
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.google.zxing.client.android.BeepManager$$ExternalSyntheticLambda0
            @Override // android.media.MediaPlayer.OnCompletionListener
            public final void onCompletion(MediaPlayer mediaPlayer2) {
                BeepManager.lambda$playBeepSound$0(mediaPlayer2);
            }
        });
        mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.google.zxing.client.android.BeepManager$$ExternalSyntheticLambda1
            @Override // android.media.MediaPlayer.OnErrorListener
            public final boolean onError(MediaPlayer mediaPlayer2, int i, int i2) {
                return BeepManager.lambda$playBeepSound$1(mediaPlayer2, i, i2);
            }
        });
        try {
            AssetFileDescriptor openRawResourceFd = this.context.getResources().openRawResourceFd(R.raw.zxing_beep);
            try {
                mediaPlayer.setDataSource(openRawResourceFd.getFileDescriptor(), openRawResourceFd.getStartOffset(), openRawResourceFd.getLength());
                openRawResourceFd.close();
                mediaPlayer.setVolume(BEEP_VOLUME, BEEP_VOLUME);
                mediaPlayer.prepare();
                mediaPlayer.start();
                return mediaPlayer;
            } catch (Throwable th) {
                openRawResourceFd.close();
                throw th;
            }
        } catch (IOException e) {
            InstrumentInjector.log_w(TAG, e);
            mediaPlayer.reset();
            mediaPlayer.release();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$playBeepSound$0(MediaPlayer mediaPlayer) {
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$playBeepSound$1(MediaPlayer mediaPlayer, int i, int i2) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to beep ");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        InstrumentInjector.log_w(str, sb.toString());
        mediaPlayer.stop();
        mediaPlayer.reset();
        mediaPlayer.release();
        return true;
    }
}
