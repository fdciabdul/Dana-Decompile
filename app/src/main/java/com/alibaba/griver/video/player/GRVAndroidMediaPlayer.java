package com.alibaba.griver.video.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.video.R;
import com.alibaba.griver.video.base.BasePlayer;
import com.alibaba.griver.video.base.PlayerErrorCode;
import com.alibaba.griver.video.base.UIConfig;
import com.alibaba.griver.video.base.VideoConfig;
import com.alibaba.griver.video.utils.ProgressUtils;
import com.alibaba.griver.video.view.GRVTextureView;
import com.fullstory.instrumentation.InstrumentInjector;

/* loaded from: classes6.dex */
public class GRVAndroidMediaPlayer extends BasePlayer {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f6784a;
    private ImageView b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private RelativeLayout f;
    private TextView g;
    private TextView h;
    private SeekBar i;
    private LinearLayout j;
    private Handler k;
    private int l;
    private int m;
    private GRVTextureView n;

    /* renamed from: o  reason: collision with root package name */
    private MediaPlayer f6785o;
    private int p;
    private long q;
    private final Runnable r;
    private final Runnable s;
    private final View.OnClickListener t;

    @Override // com.alibaba.griver.video.base.BasePlayer
    public int getPlayerType() {
        return 1;
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void setPlayRate(float f) {
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void setScreenDirection(int i) {
    }

    public GRVAndroidMediaPlayer(Context context) {
        super(context);
        this.k = new Handler(Looper.getMainLooper());
        this.p = 0;
        this.q = 0L;
        this.r = new Runnable() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.1
            @Override // java.lang.Runnable
            public void run() {
                GRVAndroidMediaPlayer gRVAndroidMediaPlayer = GRVAndroidMediaPlayer.this;
                gRVAndroidMediaPlayer.l = gRVAndroidMediaPlayer.f6785o.getCurrentPosition();
                GRVAndroidMediaPlayer.this.h.setText(ProgressUtils.getDurationString(GRVAndroidMediaPlayer.this.l));
                GRVAndroidMediaPlayer.this.i.setProgress(GRVAndroidMediaPlayer.this.l);
                GRVAndroidMediaPlayer.this.k.postDelayed(GRVAndroidMediaPlayer.this.r, 500L);
            }
        };
        this.s = new Runnable() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (GRVAndroidMediaPlayer.this.isPlaying()) {
                    GRVAndroidMediaPlayer.this.setControlVisible(4);
                }
            }
        };
        this.t = new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int state = GRVAndroidMediaPlayer.this.mStateMachine.getState();
                if (state == 2) {
                    GRVAndroidMediaPlayer.this.pause();
                } else if (state == 3 || state == 4) {
                    GRVAndroidMediaPlayer.this.play(0L);
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.grv_video_layout_media_player, this);
        this.n = (GRVTextureView) findViewById(R.id.tv_player);
        this.f6785o = new MediaPlayer();
        this.n.setPlayerView(this);
        this.f6785o.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.4
            @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
            public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
                GRVAndroidMediaPlayer.this.n.setVideoSize(i, i2);
            }
        });
        this.b = (ImageView) findViewById(R.id.iv_play);
        this.f6784a = (ImageView) findViewById(R.id.iv_mute);
        this.c = (ImageView) findViewById(R.id.iv_controller_play);
        this.d = (ImageView) findViewById(R.id.iv_controller_full);
        this.i = (SeekBar) findViewById(R.id.sb_controller);
        this.f = (RelativeLayout) findViewById(R.id.rl_controller);
        this.g = (TextView) findViewById(R.id.tv_duration);
        this.h = (TextView) findViewById(R.id.tv_current_position);
        this.j = (LinearLayout) findViewById(R.id.ll_loading);
        this.f.setVisibility(4);
        setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GRVAndroidMediaPlayer.this.setControlVisible(0);
                GRVAndroidMediaPlayer.this.hideRLController();
            }
        });
        this.b.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GRVAndroidMediaPlayer.this.mPlayerListener != null) {
                    GRVAndroidMediaPlayer.this.mPlayerListener.playerToolbarAction(BasePlayer.ACTION_CENTER_PLAY, null, true);
                }
                GRVAndroidMediaPlayer.this.t.onClick(view);
            }
        });
        this.c.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (GRVAndroidMediaPlayer.this.mPlayerListener != null) {
                    GRVAndroidMediaPlayer.this.mPlayerListener.playerToolbarAction(BasePlayer.ACTION_TOOLBAR_PLAY, null, true);
                }
                GRVAndroidMediaPlayer.this.t.onClick(view);
            }
        });
        this.i.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.8
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (GRVAndroidMediaPlayer.this.p < i) {
                    GRVAndroidMediaPlayer.this.mPlayTime += i - GRVAndroidMediaPlayer.this.p;
                    GRVAndroidMediaPlayer.this.mPlayerListener.onProgressUpdate(i, GRVAndroidMediaPlayer.this.mPlayTime, GRVAndroidMediaPlayer.this.m);
                }
                GRVAndroidMediaPlayer.this.p = i;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                GRVAndroidMediaPlayer.this.seek(seekBar.getProgress());
            }
        });
        ImageView imageView = (ImageView) findViewById(R.id.iv_back);
        this.e = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GRVAndroidMediaPlayer.this.switchFullScreen(false, true);
            }
        });
        this.f6785o.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.10
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                GRVAndroidMediaPlayer.this.mStateMachine.switchState(3);
                InstrumentInjector.Resources_setImageResource(GRVAndroidMediaPlayer.this.b, R.drawable.grv_video_play);
                InstrumentInjector.Resources_setImageResource(GRVAndroidMediaPlayer.this.c, R.drawable.grv_video_controller_play);
                GRVAndroidMediaPlayer.this.seek(0L);
                GRVAndroidMediaPlayer.this.mPlayerListener.playerPlayCompletion();
                GRVAndroidMediaPlayer.this.mPlayerListener.onProgressUpdate(GRVAndroidMediaPlayer.this.m, GRVAndroidMediaPlayer.this.mPlayTime, GRVAndroidMediaPlayer.this.m);
            }
        });
        this.f6785o.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.11
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) {
                GRVAndroidMediaPlayer.this.mPlayerListener.onFirstFrameRendered();
                GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.11.1
                    @Override // java.lang.Runnable
                    public void run() {
                        GRVAndroidMediaPlayer.this.j.setVisibility(8);
                    }
                });
                GRVAndroidMediaPlayer gRVAndroidMediaPlayer = GRVAndroidMediaPlayer.this;
                gRVAndroidMediaPlayer.m = gRVAndroidMediaPlayer.f6785o.getDuration();
                GRVAndroidMediaPlayer.this.g.setText(ProgressUtils.getDurationString(GRVAndroidMediaPlayer.this.m));
                GRVAndroidMediaPlayer.this.i.setMax(GRVAndroidMediaPlayer.this.m);
                GRVAndroidMediaPlayer.this.k.removeCallbacks(GRVAndroidMediaPlayer.this.r);
                GRVAndroidMediaPlayer.this.k.postDelayed(GRVAndroidMediaPlayer.this.r, 500L);
                GRVAndroidMediaPlayer.this.mPrepareType = 2;
                GRVAndroidMediaPlayer gRVAndroidMediaPlayer2 = GRVAndroidMediaPlayer.this;
                gRVAndroidMediaPlayer2.onPlay(gRVAndroidMediaPlayer2.q);
            }
        });
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GRVAndroidMediaPlayer.this.switchFullScreen(!r3.mIsFullScreen, true);
            }
        });
        this.f6784a.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                GRVAndroidMediaPlayer.this.mute(!r4.mIsMute);
                if (GRVAndroidMediaPlayer.this.mPlayerListener != null) {
                    GRVAndroidMediaPlayer.this.mPlayerListener.playerToolbarAction(BasePlayer.ACTION_TOOLBAR_MUTE, Boolean.valueOf(GRVAndroidMediaPlayer.this.mIsFullScreen), true);
                }
            }
        });
        this.f6785o.setOnInfoListener(new MediaPlayer.OnInfoListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.14
            @Override // android.media.MediaPlayer.OnInfoListener
            public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
                if (i == 701) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.14.1
                        @Override // java.lang.Runnable
                        public void run() {
                            GRVAndroidMediaPlayer.this.j.setVisibility(0);
                        }
                    });
                    GRVAndroidMediaPlayer.this.playerBuffering();
                    return false;
                } else if (i == 702) {
                    GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.14.2
                        @Override // java.lang.Runnable
                        public void run() {
                            GRVAndroidMediaPlayer.this.j.setVisibility(8);
                        }
                    });
                    GRVAndroidMediaPlayer.this.playerBufferingEnd();
                    return false;
                } else {
                    return false;
                }
            }
        });
        this.f6785o.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.15
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                StringBuilder sb = new StringBuilder();
                sb.append("error = ");
                sb.append(i);
                sb.append(", extra");
                sb.append(i2);
                GriverLogger.e("GRVAndroidMediaPlayer", sb.toString());
                if (i == -1010) {
                    GRVAndroidMediaPlayer.this.playerError(PlayerErrorCode.MEDIA_ERROR_UNSUPPORTED.getCode(), PlayerErrorCode.MEDIA_ERROR_UNSUPPORTED.getMsg(), null);
                } else if (i == -1007) {
                    GRVAndroidMediaPlayer.this.playerError(PlayerErrorCode.MEDIA_ERROR_MALFORMED.getCode(), PlayerErrorCode.MEDIA_ERROR_MALFORMED.getMsg(), null);
                } else if (i == -1004 || i == -110) {
                    GRVAndroidMediaPlayer.this.playerError(PlayerErrorCode.MEDIA_ERROR_IO.getCode(), PlayerErrorCode.MEDIA_ERROR_IO.getMsg(), null);
                } else if (i == 1) {
                    GRVAndroidMediaPlayer.this.playerError(PlayerErrorCode.MEDIA_ERROR_UNKNOWN.getCode(), PlayerErrorCode.MEDIA_ERROR_UNKNOWN.getMsg(), null);
                }
                mediaPlayer.reset();
                GRVAndroidMediaPlayer.this.stop();
                return false;
            }
        });
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onSetPlayerConfig(VideoConfig videoConfig, UIConfig uIConfig) {
        if (videoConfig != null) {
            try {
                if (!TextUtils.isEmpty(videoConfig.videoId) && videoConfig.videoId.startsWith("https")) {
                    Uri parse = Uri.parse(videoConfig.videoId);
                    if (parse == null) {
                        playerError(PlayerErrorCode.MEDIA_ERROR_PLAYER_SOURCE_ERROR.getCode(), PlayerErrorCode.MEDIA_ERROR_PLAYER_SOURCE_ERROR.getMsg(), null);
                        return;
                    }
                    if (this.mUIConfig.needBottomToolbar) {
                        this.c.setVisibility(0);
                        this.i.setVisibility(0);
                        this.g.setVisibility(0);
                        this.h.setVisibility(0);
                    } else {
                        this.c.setVisibility(4);
                        this.i.setVisibility(4);
                        this.g.setVisibility(4);
                        this.h.setVisibility(4);
                    }
                    this.f6785o.setDataSource(parse.toString());
                    this.f6785o.setAudioStreamType(-1);
                    return;
                }
            } catch (Throwable unused) {
                playerError(PlayerErrorCode.MEDIA_ERROR_PLAYER_SOURCE_ERROR.getCode(), PlayerErrorCode.MEDIA_ERROR_PLAYER_SOURCE_ERROR.getMsg(), null);
                return;
            }
        }
        playerError(PlayerErrorCode.MEDIA_ERROR_PLAYER_SOURCE_ERROR.getCode(), PlayerErrorCode.MEDIA_ERROR_PLAYER_SOURCE_ERROR.getMsg(), null);
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onPlay(long j) {
        MediaPlayer mediaPlayer = this.f6785o;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            return;
        }
        InstrumentInjector.Resources_setImageResource(this.b, R.drawable.grv_video_pause);
        InstrumentInjector.Resources_setImageResource(this.c, R.drawable.grv_video_controller_pause);
        if (this.mPrepareType == 0) {
            try {
                GriverExecutors.getExecutor(ExecutorType.UI).execute(new Runnable() { // from class: com.alibaba.griver.video.player.GRVAndroidMediaPlayer.16
                    @Override // java.lang.Runnable
                    public void run() {
                        GRVAndroidMediaPlayer.this.j.setVisibility(0);
                    }
                });
                this.mPrepareType = 1;
                this.f6785o.prepareAsync();
                this.q = j;
            } catch (Throwable unused) {
                playerError(PlayerErrorCode.MEDIA_ERROR_PLAYER_PREPARE_ERROR.getCode(), PlayerErrorCode.MEDIA_ERROR_PLAYER_PREPARE_ERROR.getMsg(), null);
            }
        } else if (this.mPrepareType == 1) {
            this.q = j;
        } else if (this.mPrepareType == 2) {
            this.f6785o.start();
            if (j != 0) {
                if (Build.VERSION.SDK_INT >= 26) {
                    this.f6785o.seekTo((int) j, 3);
                } else {
                    this.f6785o.seekTo((int) j);
                }
            }
            hideRLController();
        }
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onPause() {
        if (this.f6785o != null) {
            InstrumentInjector.Resources_setImageResource(this.b, R.drawable.grv_video_play);
            InstrumentInjector.Resources_setImageResource(this.c, R.drawable.grv_video_controller_play);
            this.f6785o.pause();
            showRLController();
        }
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onRelease() {
        MediaPlayer mediaPlayer = this.f6785o;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.f6785o.release();
            this.k.removeCallbacksAndMessages(null);
            this.k = null;
        }
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onPlayerError() {
        InstrumentInjector.Resources_setImageResource(this.b, R.drawable.grv_video_play);
        InstrumentInjector.Resources_setImageResource(this.c, R.drawable.grv_video_controller_play);
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void showRLController() {
        this.k.removeCallbacks(this.s);
        setControlVisible(0);
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void hideRLController() {
        this.k.removeCallbacks(this.s);
        this.k.postDelayed(this.s, 3000L);
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onStop() {
        if (this.f6785o != null) {
            seek(0L);
            this.f6785o.stop();
            this.mPrepareType = 0;
        }
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onMute(boolean z) {
        if (z) {
            InstrumentInjector.Resources_setImageResource(this.f6784a, R.drawable.grv_video_mute);
            this.f6785o.setVolume(0.0f, 0.0f);
            return;
        }
        InstrumentInjector.Resources_setImageResource(this.f6784a, R.drawable.grv_video_no_mute);
        this.f6785o.setVolume(1.0f, 1.0f);
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void onSeek(long j) {
        if (this.f6785o != null) {
            if (Build.VERSION.SDK_INT >= 26) {
                this.f6785o.seekTo((int) j, 3);
            } else {
                this.f6785o.seekTo((int) j);
            }
        }
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void stopBeforeRelease() {
        MediaPlayer mediaPlayer = this.f6785o;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void switchFullScreen(boolean z, boolean z2) {
        super.switchFullScreen(z, z2);
        if (z) {
            this.e.setVisibility(0);
            InstrumentInjector.Resources_setImageResource(this.d, R.drawable.grv_video_controller_full_out);
        } else {
            this.e.setVisibility(8);
            InstrumentInjector.Resources_setImageResource(this.d, R.drawable.grv_video_controller_full);
        }
        this.n.setFullScreen(z);
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer = this.f6785o;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer = this.f6785o;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public long getCurrentPosition() {
        if (this.f6785o != null) {
            return r0.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.alibaba.griver.video.base.BasePlayer
    public void setPlayerSurface(Surface surface, int i, int i2) {
        if (surface != null) {
            this.f6785o.setSurface(surface);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setControlVisible(int i) {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            relativeLayout.setVisibility(i);
        }
    }
}
