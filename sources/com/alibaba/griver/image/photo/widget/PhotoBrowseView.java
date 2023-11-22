package com.alibaba.griver.image.photo.widget;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVConfigService;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.utils.ToastUtils;
import com.alibaba.griver.image.R;
import com.alibaba.griver.image.activity.GriverPhotoSelectActivity;
import com.alibaba.griver.image.framework.meta.APImageDownloadRsp;
import com.alibaba.griver.image.framework.meta.APImageRetMsg;
import com.alibaba.griver.image.photo.PhotoContext;
import com.alibaba.griver.image.photo.listener.PhotoPagerListener;
import com.alibaba.griver.image.photo.meta.LoadInfo;
import com.alibaba.griver.image.photo.meta.PhotoGroup;
import com.alibaba.griver.image.photo.meta.PhotoInfo;
import com.alibaba.griver.image.photo.meta.PhotoItem;
import com.alibaba.griver.image.photo.meta.PhotoMenu;
import com.alibaba.griver.image.photo.meta.PhotoParam;
import com.alibaba.griver.image.photo.utils.AnimationUtil;
import com.alibaba.griver.image.photo.utils.CommonUtils;
import com.alibaba.griver.image.photo.utils.DiskFormatter;
import com.alibaba.griver.image.photo.utils.ImageHelper;
import com.alibaba.griver.image.photo.utils.PhotoUtil;
import com.alibaba.griver.ui.ant.dialog.AUListDialog;
import com.alibaba.griver.ui.ant.model.PopMenuItem;
import com.alipay.mobile.security.faceauth.api.AntDetector;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class PhotoBrowseView extends FrameLayout implements ViewPager.OnPageChangeListener, View.OnClickListener, ViewTreeObserver.OnGlobalLayoutListener, CompoundButton.OnCheckedChangeListener {
    public static final int NO_CUSTOM_FINISH_BTN_BG_COLOR = -1;
    public static final int PREFER_WIDTH_THUMB_DP = 125;
    public static int PREFER_WIDTH_THUMB_PX;
    public static boolean gDisablePhotoViewHardwareAcc;
    public static boolean hasSameGifInContext;
    public static int maxGifPixelCanSend;
    public static int maxGifSizeCanSend;
    public static boolean sDisableVideoStreamPlay;
    public static boolean selectPhoto;
    private String A;
    private boolean B;
    private int C;
    private String D;
    private boolean E;
    private String F;
    private String G;
    private TextView H;
    private View I;
    private ArrayList<PhotoMenu> J;
    private boolean K;
    private boolean L;
    private int M;
    private int N;
    private IndicatorView O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private boolean S;
    private boolean T;
    private RelativeLayout U;
    private NumberProgressBar V;
    private ImageButton W;

    /* renamed from: a  reason: collision with root package name */
    private ViewPager f6626a;
    private boolean aA;
    private boolean aB;
    private Handler aC;
    private String aD;
    private boolean aE;
    private boolean aF;
    private boolean aG;
    private boolean aH;
    private int aI;
    private TextView aJ;
    private boolean aK;
    private boolean aL;
    private TextView aM;
    private View aN;
    private View.OnLongClickListener aO;
    private PhotoPreview aP;
    private Map<String, View> aQ;
    private PhotoPagerAdapter aR;
    private long aS;
    private int aT;
    private View.OnClickListener aU;
    private boolean aV;
    private boolean aW;
    private Runnable aX;
    private boolean aa;
    private boolean ab;
    private int ac;
    private int ad;
    private long ae;
    private long af;
    private boolean ag;
    private boolean ah;
    private int ai;
    private Drawable aj;
    private CheckBox ak;
    private boolean al;
    private Activity am;
    private BroadcastReceiver an;
    private boolean ao;
    private boolean ap;
    private PhotoPagerListener aq;
    private List<PhotoGroup> ar;
    private boolean as;

    /* renamed from: at  reason: collision with root package name */
    private int f6627at;
    private boolean au;
    private boolean av;
    private float aw;
    private int ax;
    private boolean ay;
    private TextView az;
    private RelativeLayout b;
    private RelativeLayout c;
    private RelativeLayout d;
    private View e;
    private View f;
    private ImageButton g;
    private ImageButton h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;
    ImageHelper.LoadListener loadListener;
    private List<PhotoItem> m;
    private List<PhotoItem> n;

    /* renamed from: o  reason: collision with root package name */
    private Map<PhotoItem, LoadInfo> f6628o;
    private int p;
    private Button q;
    private CheckBox r;
    private CheckBox s;
    private TextView t;
    private View u;
    private boolean v;
    private String w;
    private PhotoContext x;
    private String y;
    private int z;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(PhotoMenu photoMenu) {
        return true;
    }

    private void getSpecialConfig() {
        try {
            RVConfigService rVConfigService = (RVConfigService) RVProxy.get(RVConfigService.class);
            if (rVConfigService != null) {
                if (TextUtils.equals(rVConfigService.getConfig("photoview_disable_hardware_acc", ""), SummaryActivity.CHECKED)) {
                    RVLogger.d("PhotoBrowseView", "DISABLE hardware acc");
                    gDisablePhotoViewHardwareAcc = true;
                } else {
                    RVLogger.d("PhotoBrowseView", "ENABLE hardware acc");
                    gDisablePhotoViewHardwareAcc = false;
                }
                if (TextUtils.equals(rVConfigService.getConfig("photo_browse_view_disable_landscape_support", ""), SummaryActivity.CHECKED)) {
                    RVLogger.d("PhotoBrowseView", "CloudConfig:Disable landscape browse");
                    this.aF = true;
                } else {
                    RVLogger.d("PhotoBrowseView", "CloudConfig:Enable landscape browse");
                    this.aF = false;
                }
                if (TextUtils.equals(rVConfigService.getConfig("disable_gif_dynamic_browse", ""), SummaryActivity.CHECKED)) {
                    RVLogger.d("PhotoBrowseView", "CloudConfig:Disable gif dynamic browse");
                    this.aH = true;
                } else {
                    RVLogger.d("PhotoBrowseView", "CloudConfig:Enable gif dynamic browse");
                    this.aH = false;
                }
                if (TextUtils.equals(rVConfigService.getConfig("disable_video_stream_play", ""), SummaryActivity.CHECKED)) {
                    RVLogger.d("PhotoBrowseView", "CloudConfig:Disable video stream play");
                    sDisableVideoStreamPlay = true;
                } else {
                    RVLogger.d("PhotoBrowseView", "CloudConfig:Enable video stream play");
                    sDisableVideoStreamPlay = false;
                }
                if (TextUtils.equals(rVConfigService.getConfig("disable_photo_preview_pull_down_finish", ""), SummaryActivity.CHECKED)) {
                    RVLogger.d("PhotoBrowseView", "DISABLE pull down finish");
                    this.aL = true;
                    return;
                }
                RVLogger.d("PhotoBrowseView", "ENABLE pull down finish");
                this.aL = false;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("readSpecialConfig exception,");
            sb.append(e.getMessage());
            RVLogger.w("PhotoBrowseView", sb.toString());
        }
    }

    public PhotoBrowseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ah = false;
        this.ai = 0;
        this.al = false;
        this.av = false;
        this.ay = true;
        this.aC = new Handler(Looper.getMainLooper());
        this.aG = true;
        this.aL = false;
        this.aO = new View.OnLongClickListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PhotoBrowseView.this.aq != null) {
                    PhotoItem photoItem = (PhotoItem) PhotoBrowseView.this.m.get(PhotoBrowseView.this.p);
                    if (PhotoBrowseView.this.ar != null && photoItem.getPhotoGroupIndex() < PhotoBrowseView.this.ar.size()) {
                        PhotoGroup photoGroup = (PhotoGroup) PhotoBrowseView.this.ar.get(photoItem.getPhotoGroupIndex());
                        PhotoBrowseView.this.aq.onPageLongClicked(photoGroup.getId(), PhotoBrowseView.this.p - photoGroup.getOffset());
                    }
                }
                if (PhotoBrowseView.this.J != null && !PhotoBrowseView.this.J.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    PhotoItem photoItem2 = (PhotoItem) PhotoBrowseView.this.m.get(PhotoBrowseView.this.p);
                    String photoPath = photoItem2.getPhotoPath();
                    for (int i2 = 0; i2 < PhotoBrowseView.this.J.size(); i2++) {
                        PhotoMenu photoMenu = (PhotoMenu) PhotoBrowseView.this.J.get(i2);
                        if (photoMenu.isPhotoSupport() && photoMenu.enabled) {
                            if (PhotoBrowseView.this.b(photoMenu)) {
                                RVLogger.debug("PhotoBrowseView", "Gif not ready, ignore save menu.");
                            } else if (photoItem2.isGif() && TextUtils.equals("collect", photoMenu.tag)) {
                                RVLogger.debug("PhotoBrowseView", "Giff not support collect,ignore it.");
                            } else {
                                arrayList.add(photoMenu);
                            }
                        }
                    }
                    if (!arrayList.isEmpty() && PhotoBrowseView.this.am != null && !PhotoBrowseView.this.am.isFinishing()) {
                        PhotoBrowseView.this.a(photoPath, arrayList, photoItem2.isGif());
                    }
                }
                return true;
            }
        };
        this.aQ = new HashMap();
        this.aR = new PhotoPagerAdapter();
        this.aS = 0L;
        this.aT = -1;
        this.aU = new View.OnClickListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PhotoBrowseView.this.R) {
                    if (PhotoBrowseView.this.aq != null) {
                        PhotoBrowseView.this.aq.onPageClicked();
                    }
                    PhotoBrowseView.this.o();
                    return;
                }
                PhotoBrowseView.this.toggleFinish();
            }
        };
        this.aV = false;
        this.aW = false;
        this.aX = new Runnable() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.6
            @Override // java.lang.Runnable
            public void run() {
                PhotoBrowseView.this.I.setVisibility(4);
                PhotoBrowseView.this.aN.setVisibility(4);
            }
        };
        this.loadListener = new ImageHelper.LoadListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.8
            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadProgress(LoadInfo loadInfo, int i2, int i3) {
                PhotoBrowseView.this.a(loadInfo, i2, i3);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadComplete(LoadInfo loadInfo) {
                PhotoBrowseView.this.c(loadInfo);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadCanceled(LoadInfo loadInfo) {
                PhotoBrowseView.this.f(loadInfo);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadFailed(LoadInfo loadInfo, APImageDownloadRsp aPImageDownloadRsp) {
                PhotoBrowseView.this.a(loadInfo, aPImageDownloadRsp);
            }
        };
        a(context);
    }

    public PhotoBrowseView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ah = false;
        this.ai = 0;
        this.al = false;
        this.av = false;
        this.ay = true;
        this.aC = new Handler(Looper.getMainLooper());
        this.aG = true;
        this.aL = false;
        this.aO = new View.OnLongClickListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PhotoBrowseView.this.aq != null) {
                    PhotoItem photoItem = (PhotoItem) PhotoBrowseView.this.m.get(PhotoBrowseView.this.p);
                    if (PhotoBrowseView.this.ar != null && photoItem.getPhotoGroupIndex() < PhotoBrowseView.this.ar.size()) {
                        PhotoGroup photoGroup = (PhotoGroup) PhotoBrowseView.this.ar.get(photoItem.getPhotoGroupIndex());
                        PhotoBrowseView.this.aq.onPageLongClicked(photoGroup.getId(), PhotoBrowseView.this.p - photoGroup.getOffset());
                    }
                }
                if (PhotoBrowseView.this.J != null && !PhotoBrowseView.this.J.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    PhotoItem photoItem2 = (PhotoItem) PhotoBrowseView.this.m.get(PhotoBrowseView.this.p);
                    String photoPath = photoItem2.getPhotoPath();
                    for (int i2 = 0; i2 < PhotoBrowseView.this.J.size(); i2++) {
                        PhotoMenu photoMenu = (PhotoMenu) PhotoBrowseView.this.J.get(i2);
                        if (photoMenu.isPhotoSupport() && photoMenu.enabled) {
                            if (PhotoBrowseView.this.b(photoMenu)) {
                                RVLogger.debug("PhotoBrowseView", "Gif not ready, ignore save menu.");
                            } else if (photoItem2.isGif() && TextUtils.equals("collect", photoMenu.tag)) {
                                RVLogger.debug("PhotoBrowseView", "Giff not support collect,ignore it.");
                            } else {
                                arrayList.add(photoMenu);
                            }
                        }
                    }
                    if (!arrayList.isEmpty() && PhotoBrowseView.this.am != null && !PhotoBrowseView.this.am.isFinishing()) {
                        PhotoBrowseView.this.a(photoPath, arrayList, photoItem2.isGif());
                    }
                }
                return true;
            }
        };
        this.aQ = new HashMap();
        this.aR = new PhotoPagerAdapter();
        this.aS = 0L;
        this.aT = -1;
        this.aU = new View.OnClickListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PhotoBrowseView.this.R) {
                    if (PhotoBrowseView.this.aq != null) {
                        PhotoBrowseView.this.aq.onPageClicked();
                    }
                    PhotoBrowseView.this.o();
                    return;
                }
                PhotoBrowseView.this.toggleFinish();
            }
        };
        this.aV = false;
        this.aW = false;
        this.aX = new Runnable() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.6
            @Override // java.lang.Runnable
            public void run() {
                PhotoBrowseView.this.I.setVisibility(4);
                PhotoBrowseView.this.aN.setVisibility(4);
            }
        };
        this.loadListener = new ImageHelper.LoadListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.8
            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadProgress(LoadInfo loadInfo, int i2, int i3) {
                PhotoBrowseView.this.a(loadInfo, i2, i3);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadComplete(LoadInfo loadInfo) {
                PhotoBrowseView.this.c(loadInfo);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadCanceled(LoadInfo loadInfo) {
                PhotoBrowseView.this.f(loadInfo);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadFailed(LoadInfo loadInfo, APImageDownloadRsp aPImageDownloadRsp) {
                PhotoBrowseView.this.a(loadInfo, aPImageDownloadRsp);
            }
        };
        a(context);
    }

    public PhotoBrowseView(Context context) {
        super(context);
        this.ah = false;
        this.ai = 0;
        this.al = false;
        this.av = false;
        this.ay = true;
        this.aC = new Handler(Looper.getMainLooper());
        this.aG = true;
        this.aL = false;
        this.aO = new View.OnLongClickListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                if (PhotoBrowseView.this.aq != null) {
                    PhotoItem photoItem = (PhotoItem) PhotoBrowseView.this.m.get(PhotoBrowseView.this.p);
                    if (PhotoBrowseView.this.ar != null && photoItem.getPhotoGroupIndex() < PhotoBrowseView.this.ar.size()) {
                        PhotoGroup photoGroup = (PhotoGroup) PhotoBrowseView.this.ar.get(photoItem.getPhotoGroupIndex());
                        PhotoBrowseView.this.aq.onPageLongClicked(photoGroup.getId(), PhotoBrowseView.this.p - photoGroup.getOffset());
                    }
                }
                if (PhotoBrowseView.this.J != null && !PhotoBrowseView.this.J.isEmpty()) {
                    ArrayList arrayList = new ArrayList();
                    PhotoItem photoItem2 = (PhotoItem) PhotoBrowseView.this.m.get(PhotoBrowseView.this.p);
                    String photoPath = photoItem2.getPhotoPath();
                    for (int i2 = 0; i2 < PhotoBrowseView.this.J.size(); i2++) {
                        PhotoMenu photoMenu = (PhotoMenu) PhotoBrowseView.this.J.get(i2);
                        if (photoMenu.isPhotoSupport() && photoMenu.enabled) {
                            if (PhotoBrowseView.this.b(photoMenu)) {
                                RVLogger.debug("PhotoBrowseView", "Gif not ready, ignore save menu.");
                            } else if (photoItem2.isGif() && TextUtils.equals("collect", photoMenu.tag)) {
                                RVLogger.debug("PhotoBrowseView", "Giff not support collect,ignore it.");
                            } else {
                                arrayList.add(photoMenu);
                            }
                        }
                    }
                    if (!arrayList.isEmpty() && PhotoBrowseView.this.am != null && !PhotoBrowseView.this.am.isFinishing()) {
                        PhotoBrowseView.this.a(photoPath, arrayList, photoItem2.isGif());
                    }
                }
                return true;
            }
        };
        this.aQ = new HashMap();
        this.aR = new PhotoPagerAdapter();
        this.aS = 0L;
        this.aT = -1;
        this.aU = new View.OnClickListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!PhotoBrowseView.this.R) {
                    if (PhotoBrowseView.this.aq != null) {
                        PhotoBrowseView.this.aq.onPageClicked();
                    }
                    PhotoBrowseView.this.o();
                    return;
                }
                PhotoBrowseView.this.toggleFinish();
            }
        };
        this.aV = false;
        this.aW = false;
        this.aX = new Runnable() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.6
            @Override // java.lang.Runnable
            public void run() {
                PhotoBrowseView.this.I.setVisibility(4);
                PhotoBrowseView.this.aN.setVisibility(4);
            }
        };
        this.loadListener = new ImageHelper.LoadListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.8
            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadProgress(LoadInfo loadInfo, int i2, int i3) {
                PhotoBrowseView.this.a(loadInfo, i2, i3);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadComplete(LoadInfo loadInfo) {
                PhotoBrowseView.this.c(loadInfo);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadCanceled(LoadInfo loadInfo) {
                PhotoBrowseView.this.f(loadInfo);
            }

            @Override // com.alibaba.griver.image.photo.utils.ImageHelper.LoadListener
            public void onLoadFailed(LoadInfo loadInfo, APImageDownloadRsp aPImageDownloadRsp) {
                PhotoBrowseView.this.a(loadInfo, aPImageDownloadRsp);
            }
        };
        a(context);
    }

    private void a(Context context) {
        hasSameGifInContext = false;
        getSpecialConfig();
        LayoutInflater.from(context).inflate(R.layout.griver_image_photo_browse, (ViewGroup) this, true);
        this.p = 0;
        this.aj = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.griver_image_default_photo);
        this.f6628o = DesugarCollections.MyBillsEntityDataFactory(new HashMap());
        View findViewById = findViewById(R.id.iv_download_entry);
        this.aN = findViewById;
        findViewById.setOnClickListener(this);
        View findViewById2 = findViewById(R.id.iv_grid);
        this.I = findViewById2;
        findViewById2.setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.tv_left);
        this.j = textView;
        textView.setMovementMethod(new ScrollingMovementMethod());
        this.f = findViewById(R.id.ll_select);
        TextView textView2 = (TextView) findViewById(R.id.tv_right);
        this.k = textView2;
        textView2.setMovementMethod(new ScrollingMovementMethod());
        this.l = (TextView) findViewById(R.id.tv_text_divider);
        this.e = (LinearLayout) findViewById(R.id.ll_bottom_text);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_option_bar);
        this.d = relativeLayout;
        relativeLayout.setOnClickListener(this);
        this.H = (TextView) findViewById(R.id.tv_text_indicator);
        RelativeLayout relativeLayout2 = (RelativeLayout) findViewById(R.id.rl_top_bar);
        this.b = relativeLayout2;
        relativeLayout2.setOnClickListener(this);
        RelativeLayout relativeLayout3 = (RelativeLayout) findViewById(R.id.rl_bottom_bar);
        this.c = relativeLayout3;
        relativeLayout3.setOnClickListener(this);
        this.O = (IndicatorView) findViewById(R.id.iv_indicator);
        RelativeLayout relativeLayout4 = (RelativeLayout) findViewById(R.id.rl_show_origin);
        this.U = relativeLayout4;
        relativeLayout4.setOnClickListener(this);
        NumberProgressBar numberProgressBar = (NumberProgressBar) findViewById(R.id.pb_show_origin);
        this.V = numberProgressBar;
        numberProgressBar.setText(getContext().getString(R.string.griver_image_show_origin)).setProgress(0);
        ImageButton imageButton = (ImageButton) findViewById(R.id.ib_cancel_show);
        this.W = imageButton;
        imageButton.setOnClickListener(this);
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.bt_back);
        this.g = imageButton2;
        CommonUtils.setTitleBarBackDrawable(imageButton2);
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.option_bt_back);
        this.h = imageButton3;
        CommonUtils.setTitleBarBackDrawable(imageButton3);
        this.i = (TextView) findViewById(R.id.tv_index);
        this.f6626a = (ViewPager) findViewById(R.id.vp_base_app);
        this.r = (CheckBox) findViewById(R.id.cb_select);
        TextView textView3 = (TextView) findViewById(R.id.tv_select);
        this.aM = textView3;
        ViewCompat.moveToNextValue((View) textView3, 2);
        this.r.setOnCheckedChangeListener(this);
        TextView textView4 = (TextView) findViewById(R.id.tv_edit);
        this.az = textView4;
        textView4.setOnClickListener(this);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_select_top);
        this.ak = checkBox;
        checkBox.setOnCheckedChangeListener(this);
        Button button = (Button) findViewById(R.id.bt_finish);
        this.q = button;
        button.setOnClickListener(this);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.cb_origin);
        this.s = checkBox2;
        checkBox2.setOnCheckedChangeListener(this);
        TextView textView5 = (TextView) findViewById(R.id.tv_origin);
        this.t = textView5;
        ViewCompat.moveToNextValue((View) textView5, 2);
        this.g.setOnClickListener(this);
        this.h.setOnClickListener(this);
        this.f6626a.setOnPageChangeListener(this);
        this.b.getViewTreeObserver().addOnGlobalLayoutListener(this);
        TextView textView6 = (TextView) findViewById(R.id.tv_edit_photo);
        this.aJ = textView6;
        textView6.setOnClickListener(this);
    }

    public void setActivity(Activity activity) {
        if (activity != null) {
            if (PREFER_WIDTH_THUMB_PX <= 0) {
                PREFER_WIDTH_THUMB_PX = PhotoUtil.reorderSize(PhotoUtil.dp2px(activity, 125)).getWidth();
            }
            a(activity);
            this.ap = false;
        } else {
            if (this.ay) {
                RVLogger.debug("PhotoBrowseView", "Cancel all downloading task.");
                Iterator<LoadInfo> it = this.f6628o.values().iterator();
                while (it.hasNext()) {
                    ImageHelper.cancel(it.next().taskId);
                }
            } else {
                RVLogger.debug("PhotoBrowseView", "Keep download task in background!");
            }
            this.f6628o.clear();
            if (this.x != null && !this.ap) {
                PhotoContext.contextMap.clear();
            }
            this.x = null;
            b(this.am);
            l();
        }
        this.am = activity;
    }

    private void a() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < this.m.size(); i++) {
            PhotoItem photoItem = this.m.get(i);
            if (photoItem.isGif()) {
                linkedList.add(photoItem);
            }
        }
        if (linkedList.size() > 1) {
            HashSet hashSet = new HashSet();
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                hashSet.add(((PhotoInfo) linkedList.get(i2)).getPhotoPath());
            }
            hasSameGifInContext = hashSet.size() != linkedList.size();
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Has same gif file = ");
        sb.append(hasSameGifInContext);
        RVLogger.debug("PhotoBrowseView", sb.toString());
    }

    private void b() {
        if (this.aE && !this.aF) {
            if (this.am != null) {
                RVLogger.w("PhotoBrowseView", "adaptLandscapeConfig: Enable landscape browse!");
                this.am.setRequestedOrientation(2);
                return;
            }
            RVLogger.w("PhotoBrowseView", "adaptLandscapeConfig:Activity is null.");
            return;
        }
        RVLogger.w("PhotoBrowseView", "adaptLandscapeConfig: Disable landscape browse!");
    }

    private void c() {
        this.aN.setVisibility(this.au ? 0 : 8);
        this.I.setVisibility(this.L ? 0 : 4);
        this.d.setVisibility((this.K || this.Q) ? 0 : 8);
        this.e.setVisibility(this.E ? 8 : 0);
        if (this.E) {
            this.b.setVisibility(8);
            this.c.setVisibility(8);
        }
        this.H.setVisibility((this.K || this.Q) ? 0 : 8);
        this.b.setVisibility(selectPhoto ? 0 : 8);
        this.c.setVisibility(selectPhoto ? 0 : 8);
        this.O.setVisibility(this.P ? 0 : 8);
        boolean z = this.al && (this.E || !(this.P || this.Q));
        this.ak.setVisibility(z ? 0 : 8);
        if (z) {
            this.L = false;
            this.I.setVisibility(4);
        }
        View findViewById = findViewById(R.id.ll_origin);
        this.u = findViewById;
        findViewById.setOnClickListener(this);
        int i = this.C;
        if (i < 0 || i >= this.x.photoList.size()) {
            this.C = 0;
        }
        if (this.ag && this.z == 1) {
            if (this.x.photoList != null && this.x.photoList.size() > 0) {
                this.m.clear();
                this.m.add(this.x.photoList.get(this.C));
                this.C = 0;
            }
            this.i.setVisibility(4);
        }
        updateContent();
        this.f6626a.setAdapter(this.aR);
        this.f6626a.setCurrentItem(this.C);
        this.O.setCount(this.m.size());
        this.O.setSelection(this.C);
        onPageScrollStateChanged(0);
        if (this.z == 1) {
            this.f.setVisibility(8);
            this.c.setVisibility(0);
            this.b.setVisibility(0);
        }
        int i2 = this.aI;
        if (i2 != -1) {
            this.q.setBackgroundColor(i2);
        }
        j();
    }

    private void a(Activity activity) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(GriverPhotoSelectActivity.ACTION_PHOTO_ADAPTER_CHANGE);
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.2
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                if (PhotoBrowseView.this.aR != null) {
                    PhotoBrowseView.this.aR.clear();
                    PhotoBrowseView.this.aR.addPhotos(PhotoBrowseView.this.x.photoList);
                    PhotoBrowseView.this.aR.notifyDataSetChanged();
                    PhotoBrowseView.this.f6626a.setAdapter(PhotoBrowseView.this.aR);
                    int size = PhotoBrowseView.this.x.photoList.size();
                    PhotoBrowseView.this.O.setCount(size);
                    if (size != 0) {
                        if (PhotoBrowseView.this.p >= size) {
                            PhotoBrowseView.this.p = size - 1;
                        }
                        PhotoBrowseView.this.f6626a.setCurrentItem(PhotoBrowseView.this.p);
                        if (PhotoBrowseView.this.p == 0) {
                            PhotoBrowseView.this.onPageSelected(0);
                            return;
                        }
                        return;
                    }
                    PhotoBrowseView.this.toggleFinish();
                }
            }
        };
        this.an = broadcastReceiver;
        try {
            activity.registerReceiver(broadcastReceiver, intentFilter);
        } catch (Throwable th) {
            StringBuilder sb = new StringBuilder();
            sb.append("registerReceiver exception,");
            sb.append(th.getMessage());
            RVLogger.debug("PhotoBrowseView", sb.toString());
        }
    }

    private void b(Activity activity) {
        if (activity != null) {
            RVLogger.debug("PhotoBrowseView", "unregisterReceiver called");
            activity.unregisterReceiver(this.an);
        }
    }

    public void setBundle(Bundle bundle) {
        if (bundle != null) {
            this.au = bundle.getBoolean(PhotoParam.KEY_ENABLE_SHOW_PHOTO_DOWNLOAD, false);
            maxGifPixelCanSend = PhotoParam.DEFAULT_MAX_GIF_PIXEL_CAN_SEND;
            maxGifSizeCanSend = 5242880;
            boolean z = bundle.getBoolean(PhotoParam.ENABLE_EDIT_WHEN_PREVIEW_IMAGE, false);
            this.aK = z;
            this.aJ.setVisibility(z ? 0 : 8);
            this.aB = bundle.getBoolean(PhotoParam.ENABLE_VIDEO_CUT, false);
            this.aE = bundle.getBoolean(PhotoParam.ENABLE_PHOTO_LANDSCAPE_BROWSE, false);
            this.aG = bundle.getBoolean(PhotoParam.ENABLE_GIF_DYNAMIC_PREVIEW, true);
            maxGifSizeCanSend = bundle.getInt(PhotoParam.MAX_SIZE_GIF_SEND, 5242880);
            maxGifPixelCanSend = bundle.getInt(PhotoParam.MAX_GIF_PIXEL_CAN_SEND, PhotoParam.DEFAULT_MAX_GIF_PIXEL_CAN_SEND);
            b();
            String string = bundle.getString("businessId");
            this.aD = string;
            ImageHelper.updateBusinessId(string, "PhotoBrowseView");
            boolean z2 = bundle.getBoolean(PhotoParam.ENABLE_EDIT_PHOTO, false);
            this.aA = z2;
            this.az.setVisibility(z2 ? 0 : 8);
            this.ay = bundle.getBoolean(PhotoParam.CANCEL_DOWNLOAD_WHEN_QUIT_PREVIEW, true);
            this.aw = bundle.getFloat(PhotoParam.BEAUTY_IMAGE_LEVEL, -1.0f);
            this.ax = bundle.getInt(PhotoParam.COMPRESS_IMAGE_QUALITY, -1);
            this.av = bundle.getBoolean(PhotoParam.SHOW_PHOTO_LOAD_PROGRESS, true);
            this.f6627at = bundle.getInt(PhotoParam.PHOTOVIEW_DISPLAY_TYPE, 2);
            this.J = bundle.getParcelableArrayList(PhotoParam.LONG_CLICK_MENU);
            selectPhoto = bundle.getBoolean(PhotoParam.PHOTO_SELECT, false);
            this.K = bundle.getBoolean(PhotoParam.ENABLE_DELETE, false);
            this.y = getResources().getString(R.string.griver_image_origin_photo);
            this.z = bundle.getInt(PhotoParam.MAX_SELECT, 9);
            String string2 = bundle.getString(PhotoParam.MAX_SELECT_MSG);
            this.A = string2;
            if (TextUtils.isEmpty(string2)) {
                this.A = getResources().getString(R.string.griver_image_max_message, Integer.valueOf(this.z));
            }
            this.M = bundle.getInt(PhotoParam.PREVIEW_IMG_WIDTH);
            this.N = bundle.getInt(PhotoParam.PREVIEW_IMG_HEIGHT);
            this.ab = bundle.getBoolean(PhotoParam.ENABLE_SHOW_ORIGIN, false);
            this.aa = bundle.getBoolean(PhotoParam.AUTO_HIDE_GRID_GROUP, true);
            this.T = bundle.getBoolean(PhotoParam.FIT_SPACE, true);
            this.S = bundle.getBoolean(PhotoParam.ENABLE_PINCH, true);
            this.R = bundle.getBoolean(PhotoParam.PREVIEW_CLICK_EXIT, false);
            this.L = bundle.getBoolean(PhotoParam.ENABLE_GRID_GROUP, false);
            this.B = bundle.getBoolean(PhotoParam.ENABLE_SELECT_ORIGIN, true);
            this.C = bundle.getInt(PhotoParam.PREVIEW_POSITION, 0);
            String string3 = bundle.getString(PhotoParam.FINISH_TEXT);
            this.D = string3;
            if (TextUtils.isEmpty(string3)) {
                this.D = getResources().getString(R.string.griver_image_send);
            }
            this.aI = bundle.getInt(PhotoParam.FINISH_BTN_BG_COLOR, -1);
            this.E = bundle.getBoolean(PhotoParam.FULLSCREEN_PREVIEW, false);
            this.P = bundle.getBoolean(PhotoParam.SHOW_DOT_INDICATOR, false);
            this.Q = bundle.getBoolean(PhotoParam.SHOW_TEXT_INDICATOR, false);
            this.ag = bundle.getBoolean(PhotoParam.ONLY_PREVIEW_SELECT, false);
            this.ao = bundle.getBoolean(PhotoParam.FORCE_FULLSCREEN_PREVIEW, false);
            this.al = bundle.getBoolean(PhotoParam.SELECT_GRID, false);
            this.as = bundle.getBoolean(PhotoParam.FORCE_FETCCH_ORIGINAL_PHOTO, false);
            String string4 = bundle.getString(PhotoParam.CONTEXT_INDEX);
            this.w = string4;
            this.x = PhotoContext.get(string4);
            PhotoContext.remove(this.w);
            if (this.x.photoList == null || this.x.photoList.isEmpty()) {
                this.am.finish();
                AnimationUtil.fadeInFadeOut(this.am);
                return;
            }
            this.aR.addPhotos(this.x.photoList);
            this.m = this.aR.getPhotoList();
            try {
                a();
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("updateHasSameGifInContextFlag Exception :");
                sb.append(e.getMessage());
                RVLogger.e("PhotoBrowseView", sb.toString());
            }
            this.n = this.x.selectedList;
            this.x.userOriginPhoto = bundle.getBoolean(PhotoParam.USE_ORIGIN_PHOTO, false);
            this.s.setChecked(this.x.userOriginPhoto);
        }
        c();
    }

    public void resume() {
        RVLogger.debug("PhotoBrowseView", "resume");
        if (this.ah) {
            if (this.aV) {
                RVLogger.debug("PhotoBrowseView", "deleteGroup called before resume ,do nothing onResume!");
                this.aV = false;
            } else if (this.ai != this.aR.getCount()) {
                this.aR.clear();
                this.aR.addPhotos(this.x.photoList);
                this.aR.notifyDataSetChanged();
                this.f6626a.setAdapter(this.aR);
                int size = this.m.size();
                this.O.setCount(size);
                if (size == 0) {
                    toggleFinish();
                    return;
                }
                int i = this.p;
                if (i >= size) {
                    int i2 = size - 1;
                    this.p = i2;
                    this.f6626a.setCurrentItem(i2);
                } else {
                    this.f6626a.setCurrentItem(i);
                    onPageSelected(this.p);
                }
            } else {
                this.f6626a.setCurrentItem(this.p);
                onPageSelected(this.p);
            }
        }
        this.ah = false;
        this.aW = true;
    }

    public void newIntent(Intent intent) {
        PhotoContext.remove(this.w);
        boolean booleanExtra = intent.getBooleanExtra(PhotoParam.SELECT_GRID, false);
        this.al = booleanExtra;
        boolean z = booleanExtra && (this.E || !(this.P || this.Q));
        this.ak.setVisibility(z ? 0 : 8);
        if (z) {
            this.L = false;
            this.I.setVisibility(4);
        }
        if (this.aa) {
            this.I.removeCallbacks(this.aX);
        }
        int intExtra = intent.getIntExtra(PhotoParam.PREVIEW_POSITION, -1);
        if (intExtra == -1 || intExtra == this.p || intExtra < 0 || intExtra >= this.m.size()) {
            return;
        }
        this.f6626a.setCurrentItem(intExtra, false);
    }

    public void saveInstanceState(Intent intent, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("onSaveInstanceState ");
        sb.append(this.w);
        RVLogger.debug("PhotoBrowseView", sb.toString());
        this.ap = true;
        bundle.putAll(intent.getExtras());
        bundle.putInt(PhotoParam.PREVIEW_POSITION, this.p);
        bundle.putString(PhotoParam.CONTEXT_INDEX, this.w);
        PhotoContext.contextMap.put(this.w, this.x);
    }

    public void pause() {
        RVLogger.debug("PhotoBrowseView", "pause");
        this.ah = true;
        this.ai = this.aR.getCount();
        Map<String, View> map = this.aQ;
        StringBuilder sb = new StringBuilder();
        sb.append(this.aT);
        if (((PhotoPreview) map.get(sb.toString())) != null) {
            this.aT = -1;
        }
        this.aW = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View a(int i) {
        ViewPager viewPager = this.f6626a;
        PhotoPreview photoPreview = this.aP;
        LayoutInflater from = LayoutInflater.from(viewPager.getContext());
        if (photoPreview == null) {
            RVLogger.debug("videoCompact", "viewPager  no cached View,create it!");
            photoPreview = (PhotoPreview) from.inflate(R.layout.griver_image_photo_preview, (ViewGroup) viewPager, false);
        } else {
            this.aP = null;
        }
        viewPager.addView(photoPreview);
        a(a(i, photoPreview), photoPreview);
        return photoPreview;
    }

    private void a(PhotoPreview photoPreview, PhotoItem photoItem) {
        if (photoItem.getMediaType() == 0) {
            photoPreview.getPhotoView().setOnLongClickListener(this.aO);
        }
    }

    private PhotoItem a(int i, PhotoPreview photoPreview) {
        PhotoView photoView = photoPreview.getPhotoView();
        photoView.setDisplayType(this.f6627at);
        if (this.N != 0 && this.M != 0) {
            ViewGroup.LayoutParams layoutParams = photoView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-2, -2);
            }
            layoutParams.height = dip2px(getContext(), this.N);
            layoutParams.width = dip2px(getContext(), this.M);
            photoView.setLayoutParams(layoutParams);
        }
        photoView.setOnClickListener(this.aU);
        photoView.setEnableScale(this.S);
        photoView.setFitSpace(this.T);
        if (this.ao) {
            photoView.setDisplayType(4);
        }
        photoPreview.setTag(Integer.valueOf(i));
        PhotoItem photoItem = this.m.get(i);
        a(photoPreview, photoItem);
        return photoItem;
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private void a(PhotoItem photoItem, PhotoPreview photoPreview) {
        RVLogger.debug("PhotoBrowseView", "dispatchLoadAction");
        photoPreview.dismissProgress();
        if (photoItem.isVideo()) {
            return;
        }
        b(photoItem, photoPreview);
    }

    private void b(PhotoItem photoItem, PhotoPreview photoPreview) {
        photoPreview.changeViewType(0);
        String photoPath = photoItem.getPhotoPath();
        PhotoView photoView = photoPreview.getPhotoView();
        photoView.setTag(R.id.griver_image_id_photo_info_tag, photoItem);
        if (TextUtils.isEmpty(photoPath)) {
            RVLogger.debug("PhotoBrowseView", "invalid photo path.");
            Drawable Resources_getDrawable = photoItem.getFail() == null ? InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.griver_image_load_fail) : photoItem.getFail();
            photoPreview.getPhotoView().failDrawableHashCode = Resources_getDrawable.hashCode();
            photoPreview.getPhotoView().setImageDrawable(Resources_getDrawable);
        } else if (photoItem.getPhoto() != null) {
            RVLogger.debug("PhotoBrowseView", "set photo view from photo info");
            photoView.setImageDrawable(photoItem.getPhoto());
        } else {
            boolean hasOriginPhoto = ImageHelper.hasOriginPhoto(photoPath);
            Drawable a2 = a(photoItem, photoView);
            LoadInfo c = c(photoItem, photoPreview);
            if (hasOriginPhoto) {
                a(c, -1, -1, false);
                a(photoPreview, c);
                ImageHelper.load(photoView, photoPath, a2, -1, -1, c);
            } else if (this.as) {
                if (c != null) {
                    c.loadingOrigin = true;
                    c.thumbHeight = dip2px(getContext(), a2.getIntrinsicHeight());
                    c.thumbWidth = dip2px(getContext(), a2.getIntrinsicWidth());
                    a(c, -1, -1, !hasOriginPhoto);
                }
                a(photoPreview, c);
                ImageHelper.load(photoView, photoPath, a2, -1, -1, c);
            } else {
                int largePhotoWidth = photoItem.getLargePhotoWidth();
                int largePhotoHeight = photoItem.getLargePhotoHeight();
                a(c, largePhotoWidth, largePhotoHeight, !hasOriginPhoto);
                a(photoPreview, c);
                ImageHelper.load(photoView, photoPath, a2, largePhotoWidth, largePhotoHeight, c);
            }
        }
    }

    private void a(PhotoPreview photoPreview, LoadInfo loadInfo) {
        if (loadInfo.isShowingPie) {
            photoPreview.showProgress(true);
            photoPreview.setProgress(loadInfo.progress);
            return;
        }
        photoPreview.showProgress(false);
    }

    private void a(LoadInfo loadInfo, int i, int i2, boolean z) {
        loadInfo.loadingWidth = i;
        loadInfo.loadingHeight = i2;
        loadInfo.isShowingPie = this.av && z;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.graphics.drawable.Drawable a(com.alibaba.griver.image.photo.meta.PhotoItem r5, com.alibaba.griver.image.photo.widget.PhotoView r6) {
        /*
            r4 = this;
            java.lang.String r0 = "PhotoBrowseView"
            java.lang.String r1 = "getAndSetThumbDrawable()"
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
            java.lang.String r1 = r5.getThumbPath()
            android.graphics.drawable.Drawable r2 = r5.getThumb()
            if (r2 == 0) goto L28
            java.lang.String r1 = "set photo view from thumb drawable"
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
            android.graphics.drawable.Drawable r1 = r5.getThumb()
            int r1 = r1.hashCode()
            r6.thumbDrawableHashCode = r1
            android.graphics.drawable.Drawable r5 = r5.getThumb()
            r6.setImageDrawable(r5)
            goto L7c
        L28:
            int r2 = com.alibaba.griver.image.photo.widget.PhotoBrowseView.PREFER_WIDTH_THUMB_PX
            android.graphics.Bitmap r5 = com.alibaba.griver.image.photo.utils.ImageHelper.loadThumbPhoto(r5, r2)
            if (r5 == 0) goto L39
            java.lang.String r1 = "set photo view from cache image"
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
            r4.a(r6, r5)
            goto L7c
        L39:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 != 0) goto L7e
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r2 = "photo thumb path "
            r5.append(r2)
            r5.append(r1)
            java.lang.String r5 = r5.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r5)
            r5 = 0
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeFile(r1)     // Catch: java.lang.Throwable -> L59
            goto L72
        L59:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "decode bitmap exception."
            r2.append(r3)
            java.lang.String r1 = r1.toString()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
        L72:
            if (r5 == 0) goto L7e
            java.lang.String r1 = "set photo view from local thumb path"
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
            r4.a(r6, r5)
        L7c:
            r5 = 1
            goto L7f
        L7e:
            r5 = 0
        L7f:
            if (r5 == 0) goto L86
            android.graphics.drawable.Drawable r1 = r6.getDrawable()
            goto L88
        L86:
            android.graphics.drawable.Drawable r1 = r4.aj
        L88:
            if (r5 != 0) goto L95
            int r1 = r1.hashCode()
            r6.defaultDrawableHashCode = r1
            java.lang.String r1 = "cann`t find thumbnail,show default drawable"
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
        L95:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "hasThumb:"
            r1.append(r2)
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r0, r1)
            if (r5 == 0) goto Lb0
            android.graphics.drawable.Drawable r5 = r6.getDrawable()
            goto Lb2
        Lb0:
            android.graphics.drawable.Drawable r5 = r4.aj
        Lb2:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.photo.widget.PhotoBrowseView.a(com.alibaba.griver.image.photo.meta.PhotoItem, com.alibaba.griver.image.photo.widget.PhotoView):android.graphics.drawable.Drawable");
    }

    private void a(PhotoView photoView, Bitmap bitmap) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(getContext().getResources(), bitmap);
        photoView.thumbDrawableHashCode = bitmapDrawable.hashCode();
        photoView.setImageDrawable(bitmapDrawable);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Activity activity;
        if (System.currentTimeMillis() - this.aS < 200) {
            return;
        }
        this.aS = System.currentTimeMillis();
        if ((view.equals(this.g) || view.equals(this.h)) && (activity = this.am) != null) {
            activity.onBackPressed();
        } else if (view == this.u) {
            this.s.setChecked(!this.s.isChecked());
        } else if (view.equals(this.q)) {
            if (this.z == 1 && !this.n.isEmpty()) {
                this.n.clear();
            }
            if (this.n.isEmpty()) {
                PhotoItem photoItem = this.m.get(this.p);
                photoItem.setSelected(true);
                this.n.add(photoItem);
            }
            d();
        } else if (view.equals(this.I)) {
            i();
        } else if (view.equals(this.U)) {
            g();
        } else if (view.equals(this.W)) {
            h();
        }
    }

    private void d() {
        this.x.sendSelectedPhoto(this.am, this.aw, this.ax, new Runnable() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.3
            @Override // java.lang.Runnable
            public void run() {
                if (PhotoBrowseView.this.am != null) {
                    PhotoBrowseView.this.am.setResult(-1);
                } else {
                    RVLogger.w("PhotoBrowseView", "activity is Null.");
                }
                PhotoBrowseView.this.toggleFinish();
            }
        }, this.s.isChecked());
    }

    public void backPressed() {
        Activity activity = this.am;
        if (activity != null) {
            Intent intent = activity.getIntent();
            intent.putExtra(PhotoParam.USE_ORIGIN_PHOTO, this.s.isChecked());
            this.am.setResult(0, intent);
            toggleFinish();
        }
    }

    private boolean e() {
        if (SystemClock.elapsedRealtime() - this.af > 200) {
            this.af = SystemClock.elapsedRealtime();
            return true;
        }
        return false;
    }

    private boolean f() {
        if (SystemClock.elapsedRealtime() - this.ae > 200) {
            this.ae = SystemClock.elapsedRealtime();
            return true;
        }
        return false;
    }

    private void g() {
        if (f()) {
            if (this.W.getVisibility() != 0) {
                this.W.setVisibility(0);
                PhotoItem photoItem = this.m.get(this.p);
                PhotoPreview photoPreview = (PhotoPreview) this.f6626a.findViewWithTag(Integer.valueOf(this.p));
                PhotoView photoView = photoPreview.getPhotoView();
                String photoPath = photoItem.getPhotoPath();
                LoadInfo c = c(photoItem, photoPreview);
                c.loadingOrigin = true;
                NumberProgressBar numberProgressBar = this.V;
                StringBuilder sb = new StringBuilder();
                sb.append(c.progress);
                sb.append("%");
                numberProgressBar.setText(sb.toString()).setProgress(c.progress);
                ImageHelper.load(photoView, photoPath, photoView.getDrawable(), -1, -1, c);
                return;
            }
            h();
        }
    }

    private LoadInfo c(PhotoItem photoItem, PhotoPreview photoPreview) {
        LoadInfo loadInfo = this.f6628o.get(photoItem);
        if (loadInfo == null) {
            loadInfo = new LoadInfo();
            loadInfo.setProxy(this.loadListener);
            loadInfo.loading = false;
            loadInfo.photoItem = photoItem;
            loadInfo.progress = 0;
        }
        loadInfo.setPhotoPreview(photoPreview);
        this.f6628o.put(photoItem, loadInfo);
        return loadInfo;
    }

    private void h() {
        if (e()) {
            RVLogger.debug("PhotoBrowseView", "cancelShowOrigin");
            PhotoItem photoItem = this.m.get(this.p);
            this.W.setVisibility(8);
            setOriginText(photoItem.getPhotoSize());
            LoadInfo remove = this.f6628o.remove(photoItem);
            if (remove == null) {
                RVLogger.debug("PhotoBrowseView", "failed to cancel load!");
                return;
            }
            remove.setProxy(null);
            ImageHelper.cancel(remove.taskId);
        }
    }

    private void i() {
        if (this.am != null) {
            PhotoContext.contextMap.put(this.w, this.x);
            Intent intent = new Intent(this.am, GriverPhotoSelectActivity.class);
            intent.putExtras(this.am.getIntent().getExtras());
            intent.putExtra(PhotoParam.PREVIEW_POSITION, this.p);
            intent.putExtra(PhotoParam.AUTO_PLAY_PREVIEW_POSITION, false);
            intent.addFlags(AntDetector.SCENE_ID_LOGIN_REGIST);
            GriverEnv.getApplicationContext().startActivity(intent);
            AnimationUtil.fadeInFadeOut(this.am);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        if (this.aa && i == 1) {
            l();
        }
        if (i == 0) {
            j();
        }
    }

    private void j() {
        n();
        if (this.aa) {
            k();
        }
    }

    private void k() {
        RVLogger.debug("PhotoBrowseView", "triggerAutoDismiss:###");
        this.aC.postDelayed(this.aX, 3000L);
    }

    private void l() {
        RVLogger.debug("PhotoBrowseView", "clearAutoDismiss:###");
        this.aC.removeCallbacksAndMessages(null);
    }

    private void m() {
        if (this.au) {
            PhotoItem photoItem = this.m.get(this.p);
            if (photoItem.getMediaType() == 0 && !photoItem.isGif()) {
                this.aN.setVisibility(0);
                return;
            } else {
                this.aN.setVisibility(4);
                return;
            }
        }
        this.aN.setVisibility(8);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
        n();
    }

    private void n() {
        if (this.L) {
            this.I.setVisibility(0);
        }
        m();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        List<PhotoItem> list = this.m;
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("onPageSelected index = ");
        sb.append(i);
        RVLogger.debug("PhotoBrowseView", sb.toString());
        this.p = i;
        PhotoItem photoItem = this.m.get(i);
        PhotoPreview photoPreview = (PhotoPreview) this.f6626a.findViewWithTag(Integer.valueOf(this.p));
        if (photoPreview != null) {
            photoPreview.getPhotoView().onShow();
        }
        this.u.setVisibility((photoItem.isVideo() || !this.B) ? 8 : 0);
        boolean selected = photoItem.getSelected();
        this.r.setChecked(selected);
        this.ak.setChecked(selected);
        c(photoItem);
        a(photoItem);
        updateContent();
        if (this.aq != null) {
            List<PhotoGroup> list2 = this.ar;
            String id2 = list2 == null ? "" : list2.get(photoItem.getPhotoGroupIndex()).getId();
            int offset = i - this.ar.get(photoItem.getPhotoGroupIndex()).getOffset();
            this.aq.onPageSelected(offset, photoItem.getPhotoGroupIndex(), id2);
            PhotoPagerListener photoPagerListener = this.aq;
            if (photoPagerListener instanceof PhotoPagerListener.V3) {
                ((PhotoPagerListener.V3) photoPagerListener).onPageSelected(offset, photoItem);
            }
        }
    }

    private void a(PhotoItem photoItem) {
        boolean loadOrigin = photoItem.getLoadOrigin();
        boolean hasOriginPhoto = ImageHelper.hasOriginPhoto(photoItem.getPhotoPath());
        StringBuilder sb = new StringBuilder();
        sb.append("updateShowOrigin enableOrigin ");
        sb.append(loadOrigin);
        sb.append(" showOrigin ");
        sb.append(this.ab);
        sb.append(" hasOrigin ");
        sb.append(hasOriginPhoto);
        RVLogger.debug("PhotoBrowseView", sb.toString());
        boolean z = (loadOrigin && this.ab && !hasOriginPhoto) ? false : true;
        boolean z2 = !z && b(photoItem);
        photoItem.isDisabledByIntercept = z2;
        if (z || z2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("hide show origin area.");
            sb2.append(z2 ? "isDisabledByIntercept" : "isNaturallyDisabled");
            RVLogger.debug("PhotoBrowseView", sb2.toString());
            this.U.setVisibility(8);
            return;
        }
        this.U.setVisibility(0);
        LoadInfo loadInfo = this.f6628o.get(photoItem);
        if (loadInfo != null && loadInfo.loadingOrigin) {
            NumberProgressBar numberProgressBar = this.V;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(loadInfo.progress);
            sb3.append("%");
            numberProgressBar.setText(sb3.toString()).setProgress(loadInfo.progress);
            this.W.setVisibility(0);
            return;
        }
        setOriginText(photoItem.getPhotoSize());
        this.W.setVisibility(8);
    }

    private boolean b(PhotoItem photoItem) {
        if (photoItem == null || !this.av || photoItem.isLoadedOnce) {
            return false;
        }
        RVLogger.debug("PhotoBrowseView", "Intercept show \"load origin image\"");
        return true;
    }

    private void setOriginText(long j) {
        String string = getResources().getString(R.string.griver_image_show_origin);
        String format = new DiskFormatter().format(j);
        StringBuilder sb = new StringBuilder();
        sb.append(string);
        sb.append("(");
        sb.append(format);
        sb.append(")");
        this.V.setText(sb.toString()).setProgress(0);
    }

    protected void updateContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.p + 1);
        sb.append("/");
        sb.append(this.m.size());
        String obj = sb.toString();
        this.i.setText(obj);
        this.H.setText(obj);
        this.O.setSelection(this.p);
        int i = this.z;
        long j = 0;
        int i2 = 0;
        if (i > 1) {
            for (PhotoItem photoItem : this.n) {
                if (photoItem.getSelected()) {
                    i2++;
                    j += photoItem.getPhotoSize();
                }
            }
        } else if (i == 1) {
            j = this.m.get(this.p).getPhotoSize();
        }
        if (i2 > 0 && this.z != 1) {
            Button button = this.q;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.D);
            sb2.append("(");
            sb2.append(i2);
            sb2.append("/");
            sb2.append(this.z);
            sb2.append(")");
            button.setText(sb2.toString());
        } else {
            this.q.setText(this.D);
            a(this.y);
        }
        this.az.setEnabled(b(i2));
        if (this.aJ.getVisibility() != 8) {
            this.aJ.setVisibility(4);
        }
        if (i2 > 0 || this.z == 1) {
            String format = new DiskFormatter().format(j);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.y);
            sb3.append("(");
            sb3.append(format);
            sb3.append(")");
            a(sb3.toString());
        }
    }

    private void a(String str) {
        this.t.setText(str);
        this.s.setContentDescription(str);
    }

    private boolean b(int i) {
        PhotoContext photoContext;
        PhotoContext photoContext2;
        RVLogger.debug("PhotoBrowseView", "checkEditable:###");
        if (i == 1 && (photoContext2 = this.x) != null && photoContext2.selectedList != null && !this.x.selectedList.isEmpty() && this.x.selectedList.get(0).getMediaType() == 0) {
            RVLogger.debug("PhotoBrowseView", "Return True.");
            return true;
        } else if (i == 0 && (photoContext = this.x) != null && photoContext.photoList != null && this.x.photoList.size() > this.p && this.x.photoList.get(this.p).getMediaType() == 0) {
            RVLogger.debug("PhotoBrowseView", "Return True.");
            return true;
        } else {
            RVLogger.debug("PhotoBrowseView", "checkEditable return False.");
            return false;
        }
    }

    protected void toggleFinish() {
        toggleFinish(true);
    }

    protected void toggleFinish(boolean z) {
        PhotoContext photoContext;
        if (this.K && (photoContext = this.x) != null) {
            photoContext.sendDeletedPhoto();
        }
        Activity activity = this.am;
        if (activity != null) {
            activity.finish();
            if (z) {
                AnimationUtil.fadeInFadeOut(this.am);
            } else {
                this.am.overridePendingTransition(0, 0);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        Activity activity = this.am;
        if (!this.v) {
            this.v = true;
            if (activity != null) {
                if (this.b.getVisibility() != 8) {
                    new AnimationUtil(activity, R.anim.griver_image_slide_up).setFillAfter(true).startAnimation(this.b);
                }
                if (this.d.getVisibility() != 8) {
                    new AnimationUtil(activity, R.anim.griver_image_slide_up).setFillAfter(true).startAnimation(this.d);
                }
                if (this.c.getVisibility() != 8) {
                    new AnimationUtil(activity, R.anim.griver_image_effect_select_pop_down).setFillAfter(true).startAnimation(this.c);
                    return;
                }
                return;
            }
            return;
        }
        this.v = false;
        if (activity != null) {
            if (this.b.getVisibility() != 8) {
                new AnimationUtil(activity, R.anim.griver_image_slide_down).setFillAfter(true).startAnimation(this.b);
            }
            if (this.d.getVisibility() != 8) {
                new AnimationUtil(activity, R.anim.griver_image_slide_down).setFillAfter(true).startAnimation(this.d);
            }
            if (this.c.getVisibility() != 8) {
                new AnimationUtil(activity, R.anim.griver_image_select_pop_up).setFillAfter(true).startAnimation(this.c);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, List<PhotoMenu> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(new PopMenuItem(list.get(i).title));
        }
        AUListDialog aUListDialog = new AUListDialog(arrayList, this.am);
        aUListDialog.setOnItemClickListener(a(this.m.get(this.p), list));
        aUListDialog.setCanceledOnTouchOutside(true);
        aUListDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.5
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
            }
        });
        aUListDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.alibaba.griver.image.photo.meta.PhotoMenu r7) {
        /*
            r6 = this;
            java.util.List<com.alibaba.griver.image.photo.meta.PhotoItem> r0 = r6.m
            java.lang.String r1 = "PhotoBrowseView"
            if (r0 == 0) goto L6b
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L6b
            com.alibaba.griver.image.photo.PhotoContext r0 = r6.x
            if (r0 == 0) goto L6b
            java.util.List<com.alibaba.griver.image.photo.meta.PhotoItem> r0 = r6.m
            int r2 = r6.p
            java.lang.Object r0 = r0.get(r2)
            com.alibaba.griver.image.photo.meta.PhotoItem r0 = (com.alibaba.griver.image.photo.meta.PhotoItem) r0
            com.alibaba.griver.image.photo.PhotoContext r2 = r6.x
            android.app.Activity r3 = r6.am
            boolean r2 = r2.photoLongPressMenuClick(r3, r0, r7)
            com.alibaba.griver.image.photo.listener.PhotoPagerListener r3 = r6.aq
            boolean r4 = r3 instanceof com.alibaba.griver.image.photo.listener.PhotoPagerListener.V4
            if (r4 == 0) goto L3d
            com.alibaba.griver.image.photo.listener.PhotoPagerListener$V4 r3 = (com.alibaba.griver.image.photo.listener.PhotoPagerListener.V4) r3
            androidx.viewpager.widget.ViewPager r4 = r6.f6626a
            int r5 = r6.p
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            android.view.View r4 = r4.findViewWithTag(r5)
            com.alibaba.griver.image.photo.widget.PhotoPreview r4 = (com.alibaba.griver.image.photo.widget.PhotoPreview) r4
            boolean r0 = r3.onMenuClicked(r7, r0, r4)
            goto L47
        L3d:
            boolean r0 = r3 instanceof com.alibaba.griver.image.photo.listener.PhotoPagerListener.V2
            if (r0 == 0) goto L48
            com.alibaba.griver.image.photo.listener.PhotoPagerListener$V2 r3 = (com.alibaba.griver.image.photo.listener.PhotoPagerListener.V2) r3
            boolean r0 = r3.onMenuClicked(r7)
        L47:
            r2 = r2 | r0
        L48:
            if (r2 == 0) goto L50
            java.lang.String r7 = "press listener processed"
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r1, r7)
            return
        L50:
            boolean r0 = r7.enableImpl
            if (r0 != 0) goto L6a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "default impl not enabled for "
            r0.append(r2)
            java.lang.String r7 = r7.tag
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.alibaba.ariver.kernel.common.utils.RVLogger.debug(r1, r7)
        L6a:
            return
        L6b:
            java.lang.String r7 = "processMenu called when photoList is Empty!"
            com.alibaba.ariver.kernel.common.utils.RVLogger.w(r1, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.image.photo.widget.PhotoBrowseView.a(com.alibaba.griver.image.photo.meta.PhotoMenu):void");
    }

    private MenuItemOnClickListener a(PhotoInfo photoInfo, List<PhotoMenu> list) {
        int mediaType = photoInfo.getMediaType();
        if (mediaType == 0 || mediaType == 1 || mediaType == 2) {
            return new MenuItemOnClickListener(list);
        }
        RVLogger.w("PhotoBrowseView", "buildListener():mediaType exception!");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class MenuItemOnClickListener implements AUListDialog.OnItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private List<PhotoMenu> f6629a;

        public MenuItemOnClickListener(List<PhotoMenu> list) {
            this.f6629a = list;
        }

        public void resetData(List<PhotoMenu> list) {
            this.f6629a = list;
        }

        @Override // com.alibaba.griver.ui.ant.dialog.AUListDialog.OnItemClickListener
        public void onItemClick(int i) {
            PhotoMenu photoMenu = this.f6629a.get(i);
            if (photoMenu.enableImpl) {
                return;
            }
            PhotoBrowseView.this.a(photoMenu);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        List<PhotoItem> list = this.m;
        if (list == null) {
            return;
        }
        PhotoItem photoItem = list.get(this.p);
        int size = this.n.size();
        if (compoundButton.equals(this.s)) {
            this.x.userOriginPhoto = z;
            if (size == 0) {
                this.r.setChecked(true);
            } else {
                updateContent();
            }
        } else if (compoundButton.equals(this.r) || compoundButton.equals(this.ak)) {
            boolean selected = photoItem.getSelected();
            if (z && selected) {
                return;
            }
            if (z || selected) {
                if (z && !selected) {
                    if (size >= this.z) {
                        this.r.setChecked(false);
                        ToastUtils.showToast(getContext(), this.A, 0);
                        return;
                    }
                    photoItem.setSelected(true);
                    this.n.add(photoItem);
                } else {
                    photoItem.setSelected(false);
                    this.n.remove(photoItem);
                }
                photoItem.setSelected(z);
                updateContent();
            }
        }
    }

    private boolean a(LoadInfo loadInfo) {
        int indexOf;
        if (!loadInfo.loadingOrigin || loadInfo.progress < 100) {
            return false;
        }
        PhotoPreview photoPreview = loadInfo.getPhotoPreview();
        if (photoPreview == null && (indexOf = this.m.indexOf(loadInfo.photoItem)) >= 0) {
            Map<String, View> map = this.aQ;
            StringBuilder sb = new StringBuilder();
            sb.append(indexOf);
            photoPreview = (PhotoPreview) map.get(sb.toString());
        }
        if (photoPreview != null) {
            loadInfo.setPhotoPreview(photoPreview);
            ImageHelper.load(photoPreview.getPhotoView(), loadInfo.photoItem.getPhotoPath(), photoPreview.getPhotoView().getDrawable(), -1, -1, loadInfo);
            return true;
        }
        return false;
    }

    private void c(PhotoItem photoItem) {
        this.F = photoItem.getLeftText();
        this.G = photoItem.getRightText();
        this.e.setVisibility(TextUtils.isEmpty(this.F) && TextUtils.isEmpty(this.G) ? 8 : 0);
        this.l.setVisibility((TextUtils.isEmpty(this.F) || TextUtils.isEmpty(this.G)) ? false : true ? 0 : 8);
        this.j.setText(this.F);
        this.j.scrollTo(0, 0);
        this.j.setVisibility(TextUtils.isEmpty(this.F) ? 8 : 0);
        this.k.setText(this.G);
        this.k.scrollTo(0, 0);
        this.k.setVisibility(TextUtils.isEmpty(this.G) ? 8 : 0);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        this.ac = this.f6626a.getMeasuredWidth();
        this.ad = this.f6626a.getMeasuredHeight();
        StringBuilder sb = new StringBuilder();
        sb.append("photoViewWidth ");
        sb.append(this.ac);
        sb.append(" photoViewHeight ");
        sb.append(this.ad);
        RVLogger.debug("PhotoBrowseView", sb.toString());
        onPageSelected(this.C);
    }

    private void b(LoadInfo loadInfo) {
        PhotoItem photoItem = this.m.get(this.p);
        if (photoItem == null || photoItem != loadInfo.photoItem) {
            return;
        }
        this.V.setText(getResources().getString(R.string.griver_image_finished));
        this.U.postDelayed(new Runnable() { // from class: com.alibaba.griver.image.photo.widget.PhotoBrowseView.7
            @Override // java.lang.Runnable
            public void run() {
                PhotoBrowseView.this.U.setVisibility(8);
                PhotoUtil.startAnimation(PhotoBrowseView.this.U, R.anim.griver_image_fade_out);
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadInfo loadInfo, APImageDownloadRsp aPImageDownloadRsp) {
        a(aPImageDownloadRsp);
        APImageRetMsg retmsg = aPImageDownloadRsp.getRetmsg();
        if (retmsg != null && retmsg.getCode() == APImageRetMsg.RETCODE.REUSE) {
            RVLogger.debug("PhotoBrowseView", "Reuse fail ####");
            if (a(loadInfo)) {
                RVLogger.debug("PhotoBrowseView", "Reuse fail,but perform load original photo again.");
                return;
            } else if (loadInfo.getPhotoPreview() == null) {
                RVLogger.debug("PhotoBrowseView", "Remove loadInfo when no view is related.");
                this.f6628o.remove(loadInfo.photoItem);
                return;
            } else {
                RVLogger.debug("PhotoBrowseView", "Ignore Reuse fail ####");
                return;
            }
        }
        String str = null;
        if (retmsg != null && retmsg.getCode() == APImageRetMsg.RETCODE.CURRENT_LIMIT) {
            str = getContext().getString(R.string.griver_image_current_limit);
        }
        a(loadInfo, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(LoadInfo loadInfo, int i, int i2) {
        if (loadInfo == null) {
            return;
        }
        loadInfo.loading = true;
        loadInfo.progress = i;
        d(loadInfo);
        if (!loadInfo.loadingOrigin) {
            RVLogger.debug("PhotoBrowseView", "not loading origin image");
            return;
        }
        try {
            if (loadInfo.photoItem != this.m.get(this.p)) {
                RVLogger.debug("PhotoBrowseView", "This loadInfo`s target view is not in Foreground.");
                return;
            }
            NumberProgressBar numberProgressBar = this.V;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            sb.append("%");
            numberProgressBar.setText(sb.toString()).setProgress(i);
        } catch (IndexOutOfBoundsException unused) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onLoadProgress_ get photo at ");
            sb2.append(this.p);
            sb2.append(" exception!PhotoList may changed already.");
            RVLogger.debug("PhotoBrowseView", sb2.toString());
        }
    }

    private void a(APImageDownloadRsp aPImageDownloadRsp) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("file at :");
        sb.append(aPImageDownloadRsp.getSourcePath());
        sb.append("\n---> fail msg :");
        String obj = sb.toString();
        APImageRetMsg retmsg = aPImageDownloadRsp.getRetmsg();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(obj);
        String str2 = "";
        if (retmsg != null) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("code = ");
            sb3.append(retmsg.getCode());
            sb3.append(",");
            sb3.append(retmsg.getMsg());
            str = sb3.toString();
        } else {
            str = "";
        }
        sb2.append(str);
        String obj2 = sb2.toString();
        APImageRetMsg aPImageRetMsg = aPImageDownloadRsp.originalRetMsg;
        StringBuilder sb4 = new StringBuilder();
        sb4.append(obj2);
        if (aPImageRetMsg != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("code = ");
            sb5.append(aPImageRetMsg.getCode());
            sb5.append(",");
            sb5.append(aPImageRetMsg.getMsg());
            str2 = sb5.toString();
        }
        sb4.append(str2);
        RVLogger.debug("PhotoBrowseView", sb4.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(LoadInfo loadInfo) {
        float width;
        float height;
        StringBuilder sb = new StringBuilder();
        sb.append("onLoadComplete_, path:");
        sb.append(loadInfo.toString());
        RVLogger.debug("PhotoBrowseView", sb.toString());
        LoadInfo remove = this.f6628o.remove(loadInfo.photoItem);
        e(remove);
        if (remove == null || remove.getPhotoPreview() == null) {
            return;
        }
        remove.loading = false;
        PhotoPreview photoPreview = remove.getPhotoPreview();
        photoPreview.dismissProgress();
        if (remove.loadingOrigin) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("rect width:");
            sb2.append(photoPreview.getPhotoView().getPhotoRect().width());
            sb2.append(",rect height:");
            sb2.append(photoPreview.getPhotoView().getPhotoRect().height());
            RVLogger.debug("PhotoBrowseView", sb2.toString());
            if (photoPreview.getPhotoView().getPhotoRect().width() > 0.0f && photoPreview.getPhotoView().getPhotoRect().height() > 0.0f) {
                width = photoPreview.getPhotoView().getPhotoRect().width();
                height = photoPreview.getPhotoView().getPhotoRect().height();
            } else {
                width = photoPreview.getPhotoView().getWidth();
                height = photoPreview.getPhotoView().getHeight();
            }
            if (remove.thumbWidth > 0 && remove.thumbHeight > 0 && height > 0.0f && width > 0.0f) {
                float max = Math.max(remove.thumbWidth / width, remove.thumbHeight / height);
                if (max < 1.0f) {
                    ScaleAnimation scaleAnimation = new ScaleAnimation(max, 1.0f, max, 1.0f, 1, 0.5f, 1, 0.5f);
                    scaleAnimation.setDuration(300L);
                    photoPreview.getPhotoView().startAnimation(scaleAnimation);
                }
            }
            b(loadInfo);
        }
    }

    private void d(LoadInfo loadInfo) {
        if (!this.av || loadInfo == null) {
            return;
        }
        PhotoPreview photoPreview = loadInfo.getPhotoPreview();
        if (photoPreview != null) {
            photoPreview.setProgress(loadInfo.progress);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("ignore pie progress,");
        sb.append(loadInfo.progress);
        RVLogger.debug("PhotoBrowseView", sb.toString());
    }

    private void e(LoadInfo loadInfo) {
        if (loadInfo != null) {
            PhotoItem photoItem = loadInfo.photoItem;
            if (photoItem != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("mark path:");
                sb.append(photoItem.getPhotoPath());
                sb.append(" has loaded");
                RVLogger.debug("PhotoBrowseView", sb.toString());
                photoItem.isLoadedOnce = true;
                if (photoItem.isDisabledByIntercept && this.m.get(this.p) == photoItem) {
                    RVLogger.debug("PhotoBrowseView", "When \"updateShowOrigin\" isDisabledByIntercept ,Call \"updateShowOrigin()\" again.");
                    a(loadInfo.photoItem);
                    return;
                }
                return;
            }
            RVLogger.debug("PhotoBrowseView", "Photoitem should not be null!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class PhotoPagerAdapter extends PagerAdapter {

        /* renamed from: a  reason: collision with root package name */
        private List<PhotoItem> f6630a = new ArrayList();

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        PhotoPagerAdapter() {
        }

        public void addPhotos(List<PhotoItem> list) {
            if (list == null || list.isEmpty()) {
                return;
            }
            if (PhotoBrowseView.this.aB) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size(); i++) {
                    PhotoItem photoItem = list.get(i);
                    if (!photoItem.isVideo()) {
                        arrayList.add(photoItem);
                    }
                }
                this.f6630a.addAll(arrayList);
                return;
            }
            this.f6630a.addAll(list);
        }

        public void clear() {
            this.f6630a.clear();
        }

        public PhotoItem getItemData(int i) {
            if (i < 0 || i >= this.f6630a.size()) {
                return null;
            }
            return this.f6630a.get(i);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            List<PhotoItem> list = this.f6630a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup viewGroup, int i) {
            Map map = PhotoBrowseView.this.aQ;
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            View view = (View) map.get(sb.toString());
            if (view == null) {
                View a2 = PhotoBrowseView.this.a(i);
                Map map2 = PhotoBrowseView.this.aQ;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i);
                map2.put(sb2.toString(), a2);
                return a2;
            }
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            if (obj instanceof PhotoPreview) {
                PhotoPreview photoPreview = (PhotoPreview) obj;
                viewGroup.removeView(photoPreview);
                Iterator it = PhotoBrowseView.this.f6628o.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    LoadInfo loadInfo = (LoadInfo) it.next();
                    if (loadInfo.getPhotoPreview() == photoPreview) {
                        loadInfo.setPhotoPreview(null);
                        break;
                    }
                }
                Map map = PhotoBrowseView.this.aQ;
                StringBuilder sb = new StringBuilder();
                sb.append(i);
                map.remove(sb.toString());
                PhotoBrowseView.this.aP = photoPreview;
            }
        }

        public List<PhotoItem> getPhotoList() {
            return this.f6630a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(LoadInfo loadInfo) {
        a(loadInfo, (String) null);
    }

    private void a(LoadInfo loadInfo, String str) {
        LoadInfo remove = this.f6628o.remove(loadInfo.photoItem);
        if (remove == null || remove.getPhotoPreview() == null) {
            return;
        }
        PhotoItem photoItem = remove.photoItem;
        PhotoPreview photoPreview = remove.getPhotoPreview();
        photoPreview.dismissProgress();
        if (photoPreview.getPhotoView().isShowingThumbnail()) {
            RVLogger.debug("PhotoBrowseView", "Thumbnail is showing when load failed,do nothing but toast.");
        } else {
            Drawable fail = photoItem.getFail();
            if (fail != null) {
                photoPreview.getPhotoView().failDrawableHashCode = fail.hashCode();
                photoPreview.getPhotoView().setImageDrawable(fail);
            } else {
                Drawable Resources_getDrawable = InstrumentInjector.Resources_getDrawable(getResources(), R.drawable.griver_image_load_fail);
                photoPreview.getPhotoView().failDrawableHashCode = Resources_getDrawable.hashCode();
                photoPreview.getPhotoView().setImageDrawable(Resources_getDrawable);
            }
        }
        if (this.m.get(this.p) == photoItem) {
            String string = getResources().getString(R.string.griver_image_download_fail);
            if (TextUtils.isEmpty(str)) {
                str = string;
            }
            ToastUtils.showToast(getContext(), str, 0);
        }
    }
}
