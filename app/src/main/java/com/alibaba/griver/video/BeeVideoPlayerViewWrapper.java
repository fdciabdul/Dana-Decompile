package com.alibaba.griver.video;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.video.H5Event;
import com.alibaba.griver.video.base.BasePlayer;
import com.alibaba.griver.video.base.UIConfig;
import com.alibaba.griver.video.base.VideoConfig;
import com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener;
import com.alibaba.griver.video.player.GRVAndroidMediaPlayer;
import com.alibaba.griver.video.utils.SystemUtils;
import com.alibaba.griver.video.view.PlayerDownGradeView;
import com.alipay.mobile.zebra.data.BoxData;
import java.io.Serializable;

/* loaded from: classes6.dex */
public class BeeVideoPlayerViewWrapper extends FrameLayout {
    private boolean A;
    private boolean B;
    private Handler C;
    private int D;
    private Runnable E;
    private Runnable F;
    private Activity G;
    private int H;
    private int I;

    /* renamed from: a  reason: collision with root package name */
    private final String f6781a;
    private Context b;
    private FrameLayout c;
    private FrameLayout d;
    private BasePlayer e;
    private PlayerDownGradeView f;
    private String g;
    private VideoConfig h;
    private UIConfig i;
    private IEventListener j;
    private boolean k;
    private int l;
    private int m;
    public boolean mIsFullScreen;
    private int n;

    /* renamed from: o  reason: collision with root package name */
    private String f6782o;
    private String p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private Bitmap v;
    private boolean w;
    private boolean x;
    private boolean y;
    private long z;

    /* loaded from: classes6.dex */
    public interface IEventListener {
        void onReceiveNativeEvent(H5Event h5Event);
    }

    public void onSwitchToLandscape() {
    }

    public void onSwitchToPortrait() {
    }

    public void visChanged(int i) {
    }

    static /* synthetic */ int access$808(BeeVideoPlayerViewWrapper beeVideoPlayerViewWrapper) {
        int i = beeVideoPlayerViewWrapper.q;
        beeVideoPlayerViewWrapper.q = i + 1;
        return i;
    }

    public BeeVideoPlayerViewWrapper(Context context, String str, boolean z) {
        super(context);
        StringBuilder sb = new StringBuilder();
        sb.append("BeeVideoPlayerViewWrapper[");
        sb.append(hashCode());
        sb.append("]");
        this.f6781a = sb.toString();
        this.e = null;
        this.k = false;
        this.n = -100;
        this.f6782o = "";
        this.p = "";
        this.r = 0;
        this.u = false;
        this.w = false;
        this.x = false;
        this.y = true;
        this.z = 0L;
        this.A = true;
        this.B = true;
        this.C = new Handler(Looper.getMainLooper());
        this.D = -1;
        this.E = new Runnable() { // from class: com.alibaba.griver.video.BeeVideoPlayerViewWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                if (BeeVideoPlayerViewWrapper.this.b == null || !(BeeVideoPlayerViewWrapper.this.b instanceof Activity)) {
                    return;
                }
                Activity activity = (Activity) BeeVideoPlayerViewWrapper.this.b;
                if (activity.getRequestedOrientation() == BeeVideoPlayerViewWrapper.this.D) {
                    GriverLogger.d(BeeVideoPlayerViewWrapper.this.f6781a, "hideNavRunnable, screen finished, hide Status And NavigationBar");
                    SystemUtils.hideStatusAndNavigationBar(activity);
                    return;
                }
                BeeVideoPlayerViewWrapper.this.C.postDelayed(BeeVideoPlayerViewWrapper.this.E, 300L);
            }
        };
        this.F = new Runnable() { // from class: com.alibaba.griver.video.BeeVideoPlayerViewWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                BeeVideoPlayerViewWrapper.this.a(3);
            }
        };
        this.H = 0;
        this.I = 0;
        this.b = context;
        this.g = str;
        LayoutInflater.from(context).inflate(R.layout.grv_video_layout_bee_player_wrapper, this);
        this.c = (FrameLayout) findViewById(R.id.fl_bee_player_view_container);
        this.d = (FrameLayout) findViewById(R.id.fl_player_container);
        PlayerDownGradeView playerDownGradeView = (PlayerDownGradeView) findViewById(R.id.rl_player_downgrade);
        this.f = playerDownGradeView;
        playerDownGradeView.setVisibility(8);
        this.q = 0;
        this.B = z;
    }

    private void a(Context context, int i) {
        if (!this.B) {
            this.f.setVisibility(0);
            return;
        }
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("BeePlayerViewWrapper, initPlayer, playerType=");
        sb.append(i);
        GriverLogger.d(str, sb.toString());
        if (this.e == null) {
            this.e = new GRVAndroidMediaPlayer(context);
            this.d.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        } else {
            this.d.removeAllViews();
            this.e = new GRVAndroidMediaPlayer(context);
            this.d.addView(this.e, new FrameLayout.LayoutParams(-1, -1));
        }
        this.e.setBeeVideoPlayerListener(new DefaultBeeVideoPlayerListener() { // from class: com.alibaba.griver.video.BeeVideoPlayerViewWrapper.3
            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onLossAudioFocus() {
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerPrepared(Bundle bundle) {
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerSeekComplete(boolean z) {
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener
            public void reportFirstFrameRendered() {
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerPlayCompletion() {
                if (BeeVideoPlayerViewWrapper.this.h != null && BeeVideoPlayerViewWrapper.this.h.isLooping) {
                    String str2 = BeeVideoPlayerViewWrapper.this.f6781a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("playerPlayCompletion, loopCount=");
                    sb2.append(BeeVideoPlayerViewWrapper.this.h.loopCount);
                    GriverLogger.w(str2, sb2.toString());
                    BeeVideoPlayerViewWrapper.this.a(5);
                    if (BeeVideoPlayerViewWrapper.this.h.loopCount > 1) {
                        BeeVideoPlayerViewWrapper.this.h.loopCount--;
                        BeeVideoPlayerViewWrapper.this.startPlay(0L);
                        return;
                    }
                    BeeVideoPlayerViewWrapper.this.stopPlay();
                    return;
                }
                BeeVideoPlayerViewWrapper.this.exitFullScreen();
                BeeVideoPlayerViewWrapper.this.a(5);
                BeeVideoPlayerViewWrapper.this.a(0);
                BeeVideoPlayerViewWrapper.this.a(false);
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerStopped() {
                BeeVideoPlayerViewWrapper.this.exitFullScreen();
                BeeVideoPlayerViewWrapper.this.a(0);
                BeeVideoPlayerViewWrapper.this.a(false);
                BeeVideoPlayerViewWrapper.this.q = 0;
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerPlaying() {
                String str2 = BeeVideoPlayerViewWrapper.this.f6781a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("playerPlaying, mPlayTimes=");
                sb2.append(BeeVideoPlayerViewWrapper.this.q);
                GriverLogger.d(str2, sb2.toString());
                if (BeeVideoPlayerViewWrapper.this.q > 1) {
                    BeeVideoPlayerViewWrapper.this.a(1);
                }
                BeeVideoPlayerViewWrapper.this.a(true);
                BeeVideoPlayerViewWrapper.this.setVisibility(0);
                BeeVideoPlayerViewWrapper.this.f.setVisibility(8);
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerPaused() {
                BeeVideoPlayerViewWrapper.this.a(2);
                BeeVideoPlayerViewWrapper.this.a(false);
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerBuffering() {
                if (BeeVideoPlayerViewWrapper.this.q == 1) {
                    BeeVideoPlayerViewWrapper.this.a(3);
                } else {
                    BeeVideoPlayerViewWrapper.this.C.postDelayed(BeeVideoPlayerViewWrapper.this.F, 500L);
                }
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerBufferingEnd() {
                BeeVideoPlayerViewWrapper.this.C.removeCallbacks(BeeVideoPlayerViewWrapper.this.F);
                BeeVideoPlayerViewWrapper.this.a(4);
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onProgressUpdate(long j, long j2, long j3) {
                if (BeeVideoPlayerViewWrapper.this.A && BeeVideoPlayerViewWrapper.this.y) {
                    if (BeeVideoPlayerViewWrapper.this.z == 0) {
                        BeeVideoPlayerViewWrapper.this.z = System.currentTimeMillis();
                    } else if (BeeVideoPlayerViewWrapper.this.z > 0 && System.currentTimeMillis() - BeeVideoPlayerViewWrapper.this.z >= 3000) {
                        String str2 = BeeVideoPlayerViewWrapper.this.f6781a;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("isDetachedFromWindow,pausePlay force,detachedPlayingTimestamp=");
                        sb2.append(BeeVideoPlayerViewWrapper.this.z);
                        sb2.append(",curMill=");
                        sb2.append(System.currentTimeMillis());
                        GriverLogger.d(str2, sb2.toString());
                        BeeVideoPlayerViewWrapper.this.z = 0L;
                        BeeVideoPlayerViewWrapper.this.pausePlay();
                    }
                }
                H5Event h5Event = new H5Event(1, 0, "");
                h5Event.extra = new H5Event.TimeStruct(j, j2, j3);
                if (BeeVideoPlayerViewWrapper.this.j != null) {
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(h5Event);
                }
                BeeVideoPlayerViewWrapper.this.a(true);
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onFirstFrameRendered() {
                String str2 = BeeVideoPlayerViewWrapper.this.f6781a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onFirstFrameRendered, mPlayTimes=");
                sb2.append(BeeVideoPlayerViewWrapper.this.q);
                sb2.append(", mPausedWhenFirstFrameArrived=");
                sb2.append(BeeVideoPlayerViewWrapper.this.w);
                GriverLogger.d(str2, sb2.toString());
                BeeVideoPlayerViewWrapper.this.x = true;
                if (!BeeVideoPlayerViewWrapper.this.w) {
                    if (BeeVideoPlayerViewWrapper.this.q == 1) {
                        BeeVideoPlayerViewWrapper.this.a(1);
                        BeeVideoPlayerViewWrapper.this.a(6);
                        BeeVideoPlayerViewWrapper.access$808(BeeVideoPlayerViewWrapper.this);
                        return;
                    }
                    return;
                }
                BeeVideoPlayerViewWrapper.this.pausePlay();
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onVideoSizeChanged(int i2, int i3, Bundle bundle) {
                BeeVideoPlayerViewWrapper.this.s = i2;
                BeeVideoPlayerViewWrapper.this.t = i3;
                H5Event h5Event = new H5Event(0, 7, "");
                Bundle bundle2 = new Bundle();
                bundle2.putInt("videoWidth", i2);
                bundle2.putInt("videoHeight", i3);
                h5Event.extra = bundle2;
                if (BeeVideoPlayerViewWrapper.this.j != null) {
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(h5Event);
                }
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerToolbarAction(String str2, Object obj, boolean z) {
                String str3 = BeeVideoPlayerViewWrapper.this.f6781a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("playerToolbarAction, mContext=");
                sb2.append(BeeVideoPlayerViewWrapper.this.b);
                sb2.append("action=");
                sb2.append(str2);
                sb2.append(", other=");
                sb2.append(obj);
                GriverLogger.d(str3, sb2.toString());
                if (BasePlayer.ACTION_TOOLBAR_FULLSCREEN.equals(str2) && (BeeVideoPlayerViewWrapper.this.b instanceof Activity)) {
                    Activity activity = (Activity) BeeVideoPlayerViewWrapper.this.b;
                    if (((Boolean) obj).booleanValue()) {
                        int i2 = (BeeVideoPlayerViewWrapper.this.e == null || BeeVideoPlayerViewWrapper.this.e.getVideoWidth() >= BeeVideoPlayerViewWrapper.this.e.getVideoHeight()) ? 0 : 1;
                        if (z) {
                            BeeVideoPlayerViewWrapper beeVideoPlayerViewWrapper = BeeVideoPlayerViewWrapper.this;
                            beeVideoPlayerViewWrapper.n = beeVideoPlayerViewWrapper.i.direction;
                        }
                        if (BeeVideoPlayerViewWrapper.this.n == 0) {
                            i2 = 1;
                        } else if (BeeVideoPlayerViewWrapper.this.n == 90) {
                            i2 = 0;
                        } else if (BeeVideoPlayerViewWrapper.this.n == -90) {
                            i2 = 8;
                        }
                        BeeVideoPlayerViewWrapper.this.a(activity, true, i2);
                        BeeVideoPlayerViewWrapper.this.e.setScreenDirection(i2);
                    } else {
                        BeeVideoPlayerViewWrapper.this.a(activity, false, 1);
                        BeeVideoPlayerViewWrapper.this.e.setScreenDirection(1);
                    }
                    if (BeeVideoPlayerViewWrapper.this.j != null) {
                        BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(3, 0, "fullscreen", null));
                    }
                } else if (BasePlayer.ACTION_TOOLBAR_PLAY.equals(str2)) {
                    if (BeeVideoPlayerViewWrapper.this.w && z && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        BeeVideoPlayerViewWrapper.this.a();
                    }
                    if (BeeVideoPlayerViewWrapper.this.j != null) {
                        BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(3, 0, "play", null));
                    }
                } else if (BasePlayer.ACTION_CENTER_PLAY.equals(str2)) {
                    if (BeeVideoPlayerViewWrapper.this.w && z && (obj instanceof Boolean) && ((Boolean) obj).booleanValue()) {
                        BeeVideoPlayerViewWrapper.this.a();
                    }
                    if (BeeVideoPlayerViewWrapper.this.j != null) {
                        BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(3, 0, "centerplay", null));
                    }
                } else if (BasePlayer.ACTION_TOOLBAR_MUTE.equals(str2)) {
                    if (BeeVideoPlayerViewWrapper.this.j != null) {
                        BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(3, 0, H5Constants.ACTION_MUTE, null));
                    }
                } else if (BasePlayer.ACTION_ERROR_REPLAY.equals(str2)) {
                    if (BeeVideoPlayerViewWrapper.this.j != null) {
                        BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(3, 0, "retry", null));
                    }
                } else if (!BasePlayer.ACTION_MOBILENET_PLAY.equals(str2) || BeeVideoPlayerViewWrapper.this.j == null) {
                } else {
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(3, 0, "mobilenetplay", null));
                }
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onViewClicked(Point point, Point point2) {
                H5Event h5Event = new H5Event(5, 0, "", point2);
                if (BeeVideoPlayerViewWrapper.this.j != null) {
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(h5Event);
                }
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void playerError(int i2, String str2, Bundle bundle) {
                Serializable serializable;
                String str3 = BeeVideoPlayerViewWrapper.this.f6781a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("playerError, code=");
                sb2.append(i2);
                sb2.append(", desc=");
                sb2.append(str2);
                sb2.append(", bundle=");
                sb2.append(bundle);
                GriverLogger.e(str3, sb2.toString());
                H5Event h5Event = new H5Event(-1, i2, str2, (bundle == null || (serializable = bundle.getSerializable("pay-info")) == null || !(serializable instanceof JSONObject)) ? null : (JSONObject) serializable);
                if (BeeVideoPlayerViewWrapper.this.j != null) {
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(h5Event);
                }
                BeeVideoPlayerViewWrapper.this.a(false);
                BeeVideoPlayerViewWrapper.this.f.setVisibility(0);
                BeeVideoPlayerViewWrapper.this.q = 0;
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onPlayerInfo(int i2, String str2, Bundle bundle) {
                String str3;
                String str4 = BeeVideoPlayerViewWrapper.this.f6781a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onPlayerInfo, code=");
                sb2.append(i2);
                sb2.append(", info=");
                sb2.append(str2);
                sb2.append(", bundle=");
                sb2.append(bundle);
                GriverLogger.d(str4, sb2.toString());
                if (bundle != null) {
                    Serializable serializable = bundle.getSerializable("pay-info");
                    if (serializable != null && (serializable instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) serializable;
                        if (jSONObject.size() > 0) {
                            H5Event h5Event = new H5Event(-1, 0, str2, jSONObject);
                            if (BeeVideoPlayerViewWrapper.this.j != null) {
                                BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(h5Event);
                            }
                        }
                    }
                    str3 = bundle.getString("ups-raw");
                } else {
                    str3 = null;
                }
                if (TextUtils.isEmpty(str3) || BeeVideoPlayerViewWrapper.this.j == null || !BeeVideoPlayerViewWrapper.this.k) {
                    if (i2 != 8004 || BeeVideoPlayerViewWrapper.this.j == null) {
                        return;
                    }
                    String str5 = BeeVideoPlayerViewWrapper.this.f6781a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("onPlayerInfo, INFO_SEI_GOT, info=");
                    sb3.append(str2);
                    GriverLogger.w(str5, sb3.toString());
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(9, i2, str2, bundle));
                    return;
                }
                BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(new H5Event(8, i2, str3, null));
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onControlsShow(String str2, boolean z, Object obj) {
                H5Event h5Event = new H5Event(4, 0, "", Boolean.valueOf(z));
                if (BeeVideoPlayerViewWrapper.this.j != null) {
                    BeeVideoPlayerViewWrapper.this.j.onReceiveNativeEvent(h5Event);
                }
            }

            @Override // com.alibaba.griver.video.listeners.DefaultBeeVideoPlayerListener, com.alibaba.griver.video.listeners.BeeVideoPlayerListener
            public void onHeadsetConnectChanged(boolean z, boolean z2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(BeeVideoPlayerViewWrapper.this.f6781a);
                sb2.append("HeadsetUtil");
                String obj = sb2.toString();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("onConnectChanged, isWireConnect=");
                sb3.append(z);
                sb3.append(", isBluetoothConnect=");
                sb3.append(z2);
                GriverLogger.w(obj, sb3.toString());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        this.w = false;
    }

    public void setEventListener(IEventListener iEventListener) {
        this.j = iEventListener;
    }

    public void setPlayerConfig(VideoConfig videoConfig, UIConfig uIConfig, boolean z) {
        VideoConfig videoConfig2;
        UIConfig uIConfig2;
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("setPlayerConfig, key=");
        sb.append(this.g);
        sb.append(", videoConfig=");
        sb.append(videoConfig);
        sb.append(", uiConfig=");
        sb.append(uIConfig);
        GriverLogger.d(str, sb.toString());
        if (videoConfig == null || uIConfig == null) {
            GriverLogger.e(this.f6781a, "setPlayerConfig, config invalid or is playing, do nothing!");
        } else if (isPlaying()) {
            GriverLogger.e(this.f6781a, "setPlayerConfig, beevideo_enable_multiple_play is false, do nothing!");
        } else {
            this.h = videoConfig;
            this.i = uIConfig;
            if (TextUtils.isEmpty(videoConfig.videoId)) {
                videoConfig.videoId = " ";
            }
            a(this.b, 1);
            BasePlayer basePlayer = this.e;
            if (basePlayer == null || (videoConfig2 = this.h) == null || (uIConfig2 = this.i) == null) {
                return;
            }
            basePlayer.setPlayerConfig(videoConfig2, uIConfig2);
            if (!z || this.e.isPaused()) {
                return;
            }
            startPlay(videoConfig.startPlayPos);
        }
    }

    public void takeSnapshot() {
        GriverLogger.d(this.f6781a, "takeSnapshot");
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            Bitmap takeSnapshot = basePlayer.takeSnapshot();
            this.v = takeSnapshot;
            if (takeSnapshot != null) {
                String str = this.f6781a;
                StringBuilder sb = new StringBuilder();
                sb.append("takeSnapshot finished, mSnapshot.dimension=");
                sb.append(this.v.getWidth());
                sb.append("x");
                sb.append(this.v.getHeight());
                GriverLogger.d(str, sb.toString());
            }
        }
    }

    public Bitmap getSnapshot() {
        int i;
        Bitmap bitmap = null;
        if (this.v == null) {
            return null;
        }
        try {
            Resources resources = getResources();
            int i2 = 1;
            if (resources != null) {
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                i2 = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            } else {
                i = 1;
            }
            Bitmap createBitmap = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(createBitmap);
                Rect rect = new Rect();
                rect.top = 0;
                rect.left = 0;
                rect.right = i2;
                rect.bottom = i;
                canvas.drawBitmap(this.v, (Rect) null, rect, (Paint) null);
                return createBitmap;
            } catch (Error e) {
                e = e;
                bitmap = createBitmap;
                GriverLogger.e(this.f6781a, "", e);
                return bitmap;
            }
        } catch (Error e2) {
            e = e2;
        }
    }

    public void startPlay(long j) {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("BeeVideoPlayerViewWrapper.startPlay, ms=");
        sb.append(j);
        GriverLogger.d(str, sb.toString());
        a();
        BasePlayer basePlayer = this.e;
        if (basePlayer != null && basePlayer.isPlaying()) {
            GriverLogger.w(this.f6781a, "startPlay, player already playing, just do nothing");
            return;
        }
        if (this.x) {
            String str2 = this.f6781a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("resumePlay, mFirstFrameArrived=");
            sb2.append(this.x);
            GriverLogger.d(str2, sb2.toString());
            int i = this.q;
            if (i == 1) {
                this.q = i + 1;
            }
        }
        if (this.q == 0) {
            b();
        }
        BasePlayer basePlayer2 = this.e;
        if (basePlayer2 != null) {
            basePlayer2.play(j);
        }
    }

    private void b() {
        this.x = false;
        this.q = 1;
    }

    public void pausePlay() {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("pausePlay, key=");
        sb.append(this.g);
        GriverLogger.d(str, sb.toString());
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.pause();
        }
    }

    public void stopPlay() {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("stopPlay, key=");
        sb.append(this.g);
        GriverLogger.d(str, sb.toString());
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.stop();
        }
        if (!this.B) {
            a(0);
        }
        this.C.removeCallbacks(null);
        this.q = 0;
    }

    public void setPlayRate(float f) {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("setPlayRate, mKey=");
        sb.append(this.g);
        sb.append(", rate=");
        sb.append(f);
        GriverLogger.d(str, sb.toString());
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.setPlayRate(f);
        }
    }

    public void setMute(boolean z) {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("setMute, mute=");
        sb.append(z);
        GriverLogger.d(str, sb.toString());
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.mute(z);
        }
    }

    public void seekTo(long j) {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("seekTo, dest=");
        sb.append(j);
        GriverLogger.d(str, sb.toString());
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.seek(j);
        }
    }

    public void destroyPlay() {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("destroyPlay, this=");
        sb.append(this);
        GriverLogger.d(str, sb.toString());
        exitFullScreen();
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.stopBeforeRelease();
            this.e.release();
        }
    }

    public boolean isPlaying() {
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            return basePlayer.isPlaying();
        }
        return false;
    }

    public String getKey() {
        return this.g;
    }

    public long getCurrentPosition() {
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            return basePlayer.getCurrentPosition();
        }
        return 0L;
    }

    public void setFullScreenDirection(int i) {
        this.n = i;
    }

    public void enterFullScreen(int i) {
        this.n = i;
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.switchFullScreen(true, false);
        }
    }

    public void exitFullScreen() {
        BasePlayer basePlayer = this.e;
        if (basePlayer != null) {
            basePlayer.switchFullScreen(false, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity, boolean z, int i) {
        if (activity.getWindow().getDecorView() instanceof ViewGroup) {
            this.G = activity;
            this.mIsFullScreen = z;
            H5Event h5Event = new H5Event(2, 0, (i == 0 || i == 8) ? BoxData.LAYOUT_HORIZONTAL : BoxData.LAYOUT_VERTICAL, Boolean.valueOf(z));
            IEventListener iEventListener = this.j;
            if (iEventListener != null) {
                iEventListener.onReceiveNativeEvent(h5Event);
            }
            if (this.mIsFullScreen) {
                GriverLogger.d(this.f6781a, "do full screen");
                this.l = activity.getWindow().getAttributes().flags;
                this.m = activity.getWindow().getDecorView().getSystemUiVisibility();
                activity.setRequestedOrientation(i);
                this.D = i;
                this.r = this.c.indexOfChild(this.d);
                this.c.removeView(this.d);
                ((ViewGroup) activity.getWindow().getDecorView()).addView(this.d, new FrameLayout.LayoutParams(-1, -1));
                this.C.postDelayed(this.E, 300L);
                return;
            }
            GriverLogger.d(this.f6781a, "do normal");
            activity.setRequestedOrientation(i);
            this.D = i;
            if (this.d.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.d.getParent()).removeView(this.d);
            }
            this.c.addView(this.d, this.r, new FrameLayout.LayoutParams(-1, -1));
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            attributes.flags = this.l;
            activity.getWindow().setAttributes(attributes);
            activity.getWindow().getDecorView().setSystemUiVisibility(this.m);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i) {
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("postStateInfo, code=");
        sb.append(i);
        GriverLogger.w(str, sb.toString());
        H5Event h5Event = new H5Event(0, i, null);
        IEventListener iEventListener = this.j;
        if (iEventListener != null) {
            iEventListener.onReceiveNativeEvent(h5Event);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final boolean z) {
        GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.BeeVideoPlayerViewWrapper.4
            @Override // java.lang.Runnable
            public void run() {
                if (BeeVideoPlayerViewWrapper.this.b == null || !(BeeVideoPlayerViewWrapper.this.b instanceof Activity)) {
                    return;
                }
                Activity activity = (Activity) BeeVideoPlayerViewWrapper.this.b;
                if (z) {
                    activity.getWindow().addFlags(128);
                } else {
                    activity.getWindow().clearFlags(128);
                }
            }
        });
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("onMeasure, dimension=");
        sb.append(View.MeasureSpec.getSize(i));
        sb.append("x");
        sb.append(View.MeasureSpec.getSize(i2));
        GriverLogger.d(str, sb.toString());
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int i4 = this.H;
        if (i4 <= 0 || (i3 = this.I) <= 0) {
            return;
        }
        if (size > i4 || size2 > i3) {
            String str2 = this.f6781a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onMeasure, exceeded max size, curW=");
            sb2.append(i4);
            sb2.append("， curH=");
            sb2.append(i3);
            GriverLogger.e(str2, sb2.toString());
            setMeasuredDimension(i4, i3);
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                getChildAt(i5).measure(View.MeasureSpec.makeMeasureSpec(i4, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("onAttachedToWindow, parent=");
        sb.append(getParent());
        GriverLogger.d(str, sb.toString());
        this.y = false;
        this.z = 0L;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        String str = this.f6781a;
        StringBuilder sb = new StringBuilder();
        sb.append("onDetachedFromWindow, parent=");
        sb.append(getParent());
        GriverLogger.d(str, sb.toString());
    }
}
