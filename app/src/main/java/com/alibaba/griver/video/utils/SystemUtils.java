package com.alibaba.griver.video.utils;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Build;
import android.provider.Settings;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.H5ResourceHandlerUtil;
import java.lang.reflect.Method;

/* loaded from: classes6.dex */
public class SystemUtils {

    /* renamed from: a  reason: collision with root package name */
    private Activity f6787a;
    private int b;
    private float c;
    private float d;
    private float e;
    private OnAudioFocusChangedListener f;
    private AudioManager.OnAudioFocusChangeListener g = new AudioManager.OnAudioFocusChangeListener() { // from class: com.alibaba.griver.video.utils.SystemUtils.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append("onAudioFocusChange, focusChange=");
            sb.append(i);
            GriverLogger.d("BeeSystemUtils", sb.toString());
            if (i == -3) {
                GriverLogger.d("BeeSystemUtils", "onAudioFocusChange, AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK, do nothing");
                OnAudioFocusChangedListener unused = SystemUtils.this.f;
                return;
            }
            if (i == -2) {
                GriverLogger.d("BeeSystemUtils", "onAudioFocusChange, AUDIOFOCUS_LOSS_TRANSIENT, do nothing");
                boolean z = Build.VERSION.SDK_INT >= 30;
                if (SystemUtils.this.f == null || z) {
                    return;
                }
                SystemUtils.this.f.onLossFocus();
            } else if (i == -1) {
                GriverLogger.d("BeeSystemUtils", "onAudioFocusChange, AUDIOFOCUS_LOSS");
                if (SystemUtils.this.f != null) {
                    SystemUtils.this.f.onLossFocus();
                }
            } else if (i == 1) {
                GriverLogger.d("BeeSystemUtils", "onAudioFocusChange, AUDIOFOCUS_GAIN");
                if (SystemUtils.this.f != null) {
                    SystemUtils.this.f.onGainFocus();
                }
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface OnAudioFocusChangedListener {
        void onGainFocus();

        void onLossFocus();
    }

    public SystemUtils(Activity activity, OnAudioFocusChangedListener onAudioFocusChangedListener) {
        this.f6787a = activity;
        this.f = onAudioFocusChangedListener;
        this.b = (int) (activity.getWindow().getAttributes().screenBrightness * 255.0f);
        StringBuilder sb = new StringBuilder();
        sb.append("BeeSystemUtils, mCurrentBrightness=");
        sb.append(this.b);
        GriverLogger.d("BeeSystemUtils", sb.toString());
        if (this.b < 0) {
            try {
                this.b = Settings.System.getInt(activity.getContentResolver(), "screen_brightness");
            } catch (Settings.SettingNotFoundException unused) {
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("BeeSystemUtils, get from ContentResolver, mCurrentBrightness=");
            sb2.append(this.b);
            GriverLogger.d("BeeSystemUtils", sb2.toString());
        }
        AudioManager audioManager = (AudioManager) this.f6787a.getSystemService(H5ResourceHandlerUtil.AUDIO);
        this.c = audioManager.getStreamMaxVolume(3) + 0.15f;
        this.d = audioManager.getStreamVolume(3);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("BeeSystemUtils, mCurrentVolume=");
        sb3.append(this.d);
        sb3.append(", mMaxVolume=");
        sb3.append(this.c);
        GriverLogger.d("BeeSystemUtils", sb3.toString());
        new IntentFilter().addAction("android.media.VOLUME_CHANGED_ACTION");
    }

    public void requestAudioFocus() {
        GriverLogger.w("BeeSystemUtils", "requestAudioFocus");
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.utils.SystemUtils.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ((AudioManager) SystemUtils.this.f6787a.getSystemService(H5ResourceHandlerUtil.AUDIO)).requestAudioFocus(SystemUtils.this.g, 3, 1);
                } catch (Exception e) {
                    GriverLogger.e("BeeSystemUtils", "", e);
                }
            }
        });
    }

    public void abandonAudioFocus() {
        GriverLogger.w("BeeSystemUtils", "abandonAudioFocus");
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.utils.SystemUtils.3
            @Override // java.lang.Runnable
            public void run() {
                ((AudioManager) SystemUtils.this.f6787a.getSystemService(H5ResourceHandlerUtil.AUDIO)).abandonAudioFocus(SystemUtils.this.g);
            }
        });
    }

    public int adjustBrightness(int i) {
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append("adjustBrightness, type=");
        sb.append(i);
        GriverLogger.d("BeeSystemUtils", sb.toString());
        if (i == 0) {
            i2 = this.b;
        } else {
            if (i > 0) {
                int i3 = this.b + 5;
                this.b = i3;
                if (i3 >= 255) {
                    this.b = 255;
                }
            } else {
                int i4 = this.b - 5;
                this.b = i4;
                if (i4 <= 0) {
                    this.b = 0;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("adjustBrightness, mCurrentBrightness=");
            sb2.append(this.b);
            GriverLogger.d("BeeSystemUtils", sb2.toString());
            Window window = this.f6787a.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = this.b / 255.0f;
            window.setAttributes(attributes);
            i2 = this.b;
        }
        return (int) (((i2 / 255.0f) * 100.0f) + 0.5f);
    }

    public int adjustVolume(int i) {
        float f;
        float f2;
        StringBuilder sb = new StringBuilder();
        sb.append("adjustVolume, type=");
        sb.append(i);
        GriverLogger.d("BeeSystemUtils", sb.toString());
        if (i == 0) {
            f = this.d;
            f2 = this.c;
        } else {
            AudioManager audioManager = (AudioManager) this.f6787a.getSystemService(H5ResourceHandlerUtil.AUDIO);
            if (i > 0) {
                float f3 = this.d + 0.15f;
                this.d = f3;
                float f4 = this.c;
                if (f3 > f4) {
                    this.d = f4;
                }
            } else {
                float f5 = this.d - 0.15f;
                this.d = f5;
                if (f5 < 0.0f) {
                    this.d = 0.0f;
                }
            }
            audioManager.setStreamVolume(3, (int) this.d, 0);
            f = this.d;
            f2 = this.c;
        }
        return (int) (((f / f2) * 100.0f) + 0.5f);
    }

    public void muteVolume(boolean z) {
        AudioManager audioManager = (AudioManager) this.f6787a.getSystemService(H5ResourceHandlerUtil.AUDIO);
        if (z) {
            this.e = audioManager.getStreamVolume(3);
            audioManager.setStreamVolume(3, 0, 0);
            return;
        }
        float f = this.e;
        if (f == 0.0f) {
            audioManager.setStreamVolume(3, (int) (this.c / 2.0f), 0);
        } else {
            audioManager.setStreamVolume(3, (int) f, 0);
        }
    }

    public static void hideStatusAndNavigationBar(Activity activity) {
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) {
            activity.getWindow().getDecorView().setSystemUiVisibility(8);
            return;
        }
        activity.getWindow().clearFlags(2048);
        activity.getWindow().setFlags(1024, 1024);
        if (hasNavBar(activity)) {
            activity.getWindow().addFlags(134217728);
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(3846);
    }

    public static boolean hasNavBar(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        if (identifier != 0) {
            boolean z = resources.getBoolean(identifier);
            String a2 = a();
            if ("1".equals(a2)) {
                return false;
            }
            if ("0".equals(a2)) {
                return true;
            }
            return z;
        }
        return !ViewConfiguration.get(context).hasPermanentMenuKey();
    }

    private static String a() {
        if (Build.VERSION.SDK_INT >= 19) {
            try {
                Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                return (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public static boolean isCurOriLand(Context context) {
        try {
            int i = context.getResources().getConfiguration().orientation;
            return i == 2 || i != 1;
        } catch (Exception unused) {
            return true;
        }
    }
}
