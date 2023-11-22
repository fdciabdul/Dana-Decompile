package com.alibaba.griver.beehive.lottie;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.CDPLottiePlayer;
import com.alibaba.griver.beehive.lottie.adapter.impl.APImageQueryResultAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter;
import com.alibaba.griver.beehive.lottie.player.DynamicLayerModel;
import com.alibaba.griver.beehive.lottie.player.GrayHelper;
import com.alibaba.griver.beehive.lottie.player.ILottieDataStatus;
import com.alibaba.griver.beehive.lottie.player.LottieHelper;
import com.alibaba.griver.beehive.lottie.player.LottieParams;
import com.alibaba.griver.beehive.lottie.util.DownloadFileUtils;
import com.alibaba.griver.beehive.lottie.util.MultiThreadUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;
import o.whenAvailable;

/* loaded from: classes6.dex */
public class BeeLottiePlayerBuilder {
    private static int $10 = 0;
    private static int $11 = 1;
    private static char[] BuiltInFictitiousFunctionClassFactory = null;
    public static String FILE_LOCAL_TYPE_ASSETS = "assets";
    public static String FILE_LOCAL_TYPE_DJANGOID = "djangoId";
    public static final int KClassImpl$Data$declaredNonStaticMembers$2;
    private static long MyBillsEntityDataFactory = 0;
    public static final short[] PlaceComponentResult;
    private static String TAG = "LottiePlayer:Builder";
    private static int getAuthRequestContext = 0;
    private static int scheduleImpl = 1;
    private String animationFileLocalType;
    private AnimationInitCallback animationInitCallback;
    private String assetsAnimationPath;
    private String assetsImageDir;
    private BeeLottiePlayer beeLottiePlayer;
    private String bizId;
    private boolean canDowngradeOnEmptyPlaceHolder;
    private Context context;
    private String downgrade;
    private String downgradeLevel;
    private Boolean downgradleToPlaceholder;
    private String dynamicLayer;
    private List<DynamicLayerModel> dynamicLayerModelList;
    private boolean hasDestroyed;
    private boolean hasLoadPlaceholder;
    private boolean loadPlaceholderFirst;
    private String lottieDjangoId;
    private String lottieMd5;
    private Map<String, String> lottieVariableParams;
    private boolean optimize;
    private LottieParams params;
    private String path;
    private String placeHolderDjangoId;
    private String renderType;
    private int repeatCount;
    private String scene;
    private String source;
    private boolean variableLottie;

    static {
        getAuthRequestContext();
        PlaceComponentResult = new short[]{116, 44, -28, -115, -14107, -14107, -14117, -14153, -14121, -14110, -14110, -14066, -14104, -14092, -14110, -14124, -14095, -14133, -14156, -12087, 14180, -14075, -14105, -14110, -14121, -14114, -14179, -14068, -14101, -14114, -14111, 6798, 3073, 13315, -14036, -14131, -14093, -14119, -14118, -14109, -14100, -14117, -14135, -14075, -14105, -14110, -14121, -14114, -14150};
        KClassImpl$Data$declaredNonStaticMembers$2 = 37;
        int i = scheduleImpl + 41;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0025, code lost:
    
        if ((r0 == null ? 'T' : 16) != 'T') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0031, code lost:
    
        if (r0 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0033, code lost:
    
        r8 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext + 37;
        com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl = r8 % 128;
        r8 = r8 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003d, code lost:
    
        r8 = r9;
        r4 = 0;
        r6 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0042, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0043, code lost:
    
        throw r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0044, code lost:
    
        r4 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0052  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x005a -> B:48:0x0045). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void b(int r8, byte r9, java.lang.Object[] r10) {
        /*
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl
            int r0 = r0 + 47
            int r1 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r1
            int r0 = r0 % 2
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L10
            r0 = 1
            goto L11
        L10:
            r0 = 0
        L11:
            r3 = 15
            r4 = 16
            if (r0 == r1) goto L28
            int r9 = r9 + 4
            short[] r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.PlaceComponentResult
            int r8 = r8 + 44
            char[] r5 = new char[r4]
            r6 = 84
            if (r0 != 0) goto L25
            r4 = 84
        L25:
            if (r4 == r6) goto L33
            goto L44
        L28:
            int r9 = r9 + r4
            short[] r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.PlaceComponentResult
            int r8 = r8 + 17
            r4 = 24
            char[] r5 = new char[r4]
            if (r0 != 0) goto L44
        L33:
            int r8 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext     // Catch: java.lang.Exception -> L42
            int r8 = r8 + 37
            int r4 = r8 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl = r4     // Catch: java.lang.Exception -> L42
            int r8 = r8 % 2
            r8 = r9
            r4 = 0
            r6 = 15
            goto L5a
        L42:
            r8 = move-exception
            throw r8
        L44:
            r4 = 0
        L45:
            char r6 = (char) r8
            r5[r4] = r6
            if (r4 != r3) goto L52
            java.lang.String r8 = new java.lang.String
            r8.<init>(r5)
            r10[r2] = r8
            return
        L52:
            int r9 = r9 + r1
            short r6 = r0[r9]
            int r4 = r4 + 1
            r7 = r9
            r9 = r8
            r8 = r7
        L5a:
            int r9 = r9 + r6
            int r9 = r9 + 14110
            r7 = r9
            r9 = r8
            r8 = r7
            goto L45
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.b(int, byte, java.lang.Object[]):void");
    }

    static void getAuthRequestContext() {
        BuiltInFictitiousFunctionClassFactory = new char[]{33093, 58426, 19370, 45383, 5328};
        MyBillsEntityDataFactory = 3019175647020881456L;
    }

    public BeeLottiePlayerBuilder() {
        try {
            this.animationFileLocalType = FILE_LOCAL_TYPE_DJANGOID;
            this.repeatCount = 0;
            this.loadPlaceholderFirst = true;
            this.downgradleToPlaceholder = null;
            this.hasLoadPlaceholder = false;
            this.hasDestroyed = false;
            this.canDowngradeOnEmptyPlaceHolder = false;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$000(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        int i = getAuthRequestContext + 97;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = beeLottiePlayerBuilder.assetsImageDir;
        try {
            int i3 = getAuthRequestContext + 41;
            scheduleImpl = i3 % 128;
            if (i3 % 2 == 0) {
                int i4 = 18 / 0;
                return str;
            }
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$100(BeeLottiePlayerBuilder beeLottiePlayerBuilder, String str) {
        int i = getAuthRequestContext + 117;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        beeLottiePlayerBuilder.prepareAssetPlaceHolder(str);
        int i3 = scheduleImpl + 123;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
    }

    static /* synthetic */ void access$1000(BeeLottiePlayerBuilder beeLottiePlayerBuilder, boolean z, Rect rect) {
        int i = getAuthRequestContext + 111;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        beeLottiePlayerBuilder.fireOnSuccess(z, rect);
        int i3 = scheduleImpl + 63;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? '(' : (char) 16) != '(') {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    static /* synthetic */ String access$200() {
        try {
            int i = scheduleImpl + 103;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            try {
                String str = TAG;
                int i3 = getAuthRequestContext + 109;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return str;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void access$300(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        try {
            int i = getAuthRequestContext + 71;
            scheduleImpl = i % 128;
            if (!(i % 2 == 0)) {
                beeLottiePlayerBuilder.preparePlaceHolderFirst();
                return;
            }
            beeLottiePlayerBuilder.preparePlaceHolderFirst();
            Object[] objArr = null;
            int length = objArr.length;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void access$400(BeeLottiePlayerBuilder beeLottiePlayerBuilder, int i, String str) {
        int i2 = getAuthRequestContext + 109;
        scheduleImpl = i2 % 128;
        if ((i2 % 2 == 0 ? Typography.greater : 'O') != 'O') {
            beeLottiePlayerBuilder.fireOnFail(i, str);
            Object obj = null;
            obj.hashCode();
            return;
        }
        beeLottiePlayerBuilder.fireOnFail(i, str);
    }

    static /* synthetic */ AnimationInitCallback access$500(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        try {
            int i = scheduleImpl + 13;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            AnimationInitCallback animationInitCallback = beeLottiePlayerBuilder.animationInitCallback;
            int i3 = getAuthRequestContext + 59;
            scheduleImpl = i3 % 128;
            if ((i3 % 2 == 0 ? 'W' : (char) 17) != 17) {
                Object obj = null;
                obj.hashCode();
                return animationInitCallback;
            }
            return animationInitCallback;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ boolean access$600(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        boolean z;
        try {
            int i = getAuthRequestContext + 125;
            scheduleImpl = i % 128;
            if (i % 2 != 0) {
                z = beeLottiePlayerBuilder.hasDestroyed;
            } else {
                z = beeLottiePlayerBuilder.hasDestroyed;
                int i2 = 8 / 0;
            }
            int i3 = scheduleImpl + 85;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$700(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        try {
            int i = getAuthRequestContext + 117;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            String str = beeLottiePlayerBuilder.lottieDjangoId;
            int i3 = scheduleImpl + 125;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ String access$800(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        try {
            int i = getAuthRequestContext + 59;
            try {
                scheduleImpl = i % 128;
                if ((i % 2 == 0 ? '\r' : 'R') != 'R') {
                    int i2 = 23 / 0;
                    return beeLottiePlayerBuilder.path;
                }
                return beeLottiePlayerBuilder.path;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ String access$900(BeeLottiePlayerBuilder beeLottiePlayerBuilder) {
        int i = getAuthRequestContext + 103;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? '3' : '\f') != '\f') {
            String str = beeLottiePlayerBuilder.scene;
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return beeLottiePlayerBuilder.scene;
    }

    public boolean isCanDowngradeOnEmptyPlaceHolder() {
        int i = getAuthRequestContext + 93;
        scheduleImpl = i % 128;
        if (i % 2 != 0) {
            return this.canDowngradeOnEmptyPlaceHolder;
        }
        try {
            boolean z = this.canDowngradeOnEmptyPlaceHolder;
            Object[] objArr = null;
            int length = objArr.length;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayerBuilder setCanDowngradeOnEmptyPlaceHolder(boolean z) {
        int i = scheduleImpl + 63;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '\\' : (char) 20) != 20) {
            this.canDowngradeOnEmptyPlaceHolder = z;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            this.canDowngradeOnEmptyPlaceHolder = z;
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0014, code lost:
    
        if ((r3.beeLottiePlayer == null) != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0024, code lost:
    
        if ((r3.beeLottiePlayer == null ? 'L' : '\\') != 'L') goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0027, code lost:
    
        build();
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x002a, code lost:
    
        r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl + 75;
        com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x003d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x003e, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initLottieAnimationAsync() {
        /*
            r3 = this;
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext
            int r0 = r0 + 123
            int r1 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl = r1
            int r0 = r0 % 2
            if (r0 != 0) goto L19
            com.alibaba.griver.beehive.lottie.BeeLottiePlayer r0 = r3.beeLottiePlayer
            r1 = 2
            r2 = 0
            int r1 = r1 / r2
            if (r0 != 0) goto L14
            r2 = 1
        L14:
            if (r2 == 0) goto L34
            goto L27
        L17:
            r0 = move-exception
            throw r0
        L19:
            com.alibaba.griver.beehive.lottie.BeeLottiePlayer r0 = r3.beeLottiePlayer
            r1 = 76
            if (r0 != 0) goto L22
            r0 = 76
            goto L24
        L22:
            r0 = 92
        L24:
            if (r0 == r1) goto L27
            goto L34
        L27:
            r3.build()     // Catch: java.lang.Exception -> L3d
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl
            int r0 = r0 + 75
            int r1 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r1
            int r0 = r0 % 2
        L34:
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder$1 r0 = new com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder$1
            r0.<init>()
            com.alibaba.griver.beehive.lottie.util.MultiThreadUtils.runOnBackgroundThread(r0)
            return
        L3d:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.initLottieAnimationAsync():void");
    }

    private void preparePlaceHolderFirst() {
        if ((this.loadPlaceholderFirst ? (char) 18 : (char) 30) != 30) {
            try {
                int i = getAuthRequestContext + 39;
                scheduleImpl = i % 128;
                Object[] objArr = null;
                if (i % 2 == 0) {
                    boolean z = this.hasLoadPlaceholder;
                    int length = objArr.length;
                    if (z) {
                        return;
                    }
                } else {
                    try {
                        if (this.hasLoadPlaceholder) {
                            return;
                        }
                    } catch (Exception e) {
                        throw e;
                    }
                }
                String str = TAG;
                StringBuilder sb = new StringBuilder();
                sb.append("preparePlaceHolderFirst,loadPlaceholderFirst=");
                sb.append(this.loadPlaceholderFirst);
                sb.append(",hasLoadPlaceholder=");
                sb.append(this.hasLoadPlaceholder);
                GriverLogger.d(str, sb.toString());
                this.hasLoadPlaceholder = true;
                this.beeLottiePlayer.preparePlaceHolder(getPlaceHolderDjangoId(), false, true, null);
                int i2 = getAuthRequestContext + 39;
                scheduleImpl = i2 % 128;
                int i3 = i2 % 2;
            } catch (Exception e2) {
                throw e2;
            }
        }
    }

    private void fireOnFail(final int i, final String str) {
        try {
            MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.2
                {
                    BeeLottiePlayerBuilder.this = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (BeeLottiePlayerBuilder.access$500(BeeLottiePlayerBuilder.this) != null && !BeeLottiePlayerBuilder.access$600(BeeLottiePlayerBuilder.this)) {
                        BeeLottiePlayerBuilder.access$500(BeeLottiePlayerBuilder.this).onFail(i, str);
                        return;
                    }
                    String access$200 = BeeLottiePlayerBuilder.access$200();
                    StringBuilder sb = new StringBuilder();
                    sb.append("fireOnFail 回调失败，DjangoId=");
                    sb.append(BeeLottiePlayerBuilder.access$700(BeeLottiePlayerBuilder.this));
                    sb.append(",path=");
                    sb.append(BeeLottiePlayerBuilder.access$800(BeeLottiePlayerBuilder.this));
                    sb.append(",callback=");
                    sb.append(BeeLottiePlayerBuilder.access$500(BeeLottiePlayerBuilder.this));
                    sb.append(",hasDestroyed=");
                    sb.append(BeeLottiePlayerBuilder.access$600(BeeLottiePlayerBuilder.this));
                    sb.append(",scene=");
                    sb.append(BeeLottiePlayerBuilder.access$900(BeeLottiePlayerBuilder.this));
                    GriverLogger.e(access$200, sb.toString());
                }
            });
            int i2 = getAuthRequestContext + 115;
            scheduleImpl = i2 % 128;
            if (!(i2 % 2 != 0)) {
                Object obj = null;
                obj.hashCode();
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0020, code lost:
    
        if ((r1) != true) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0038, code lost:
    
        if ((!android.text.TextUtils.isEmpty(r8.path) ? kotlin.text.Typography.less : '7') != '7') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x003e, code lost:
    
        if (isJustLoadPlaceHolder() == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0044, code lost:
    
        if (android.text.TextUtils.isEmpty(r0) == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0046, code lost:
    
        r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext + 121;
        com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl = r0 % 128;
        r0 = r0 % 2;
        com.alibaba.griver.base.common.logger.GriverLogger.w(com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG, "downgrade but placeHolderImageDjangoId are not set.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0057, code lost:
    
        if (r9 == null) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0059, code lost:
    
        r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl + 63;
        com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r0 % 128;
        r0 = r0 % 2;
        r9.onFail(11, "downgrade but placeHolderImageDjangoId are not set.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0068, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0069, code lost:
    
        loadPlaceholdImage(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x006c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0072, code lost:
    
        com.alibaba.griver.beehive.lottie.player.LottieHelper.getResourceWithUrl(r8.path, new com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.AnonymousClass3(), r8.context, r8.source);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x007b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x007c, code lost:
    
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x007d, code lost:
    
        throw r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x007e, code lost:
    
        com.alibaba.griver.beehive.lottie.BeeLottiePlayer.loadLottieResource(r8.lottieDjangoId, r8.lottieMd5, r0, r8.optimize, r9, r8.scene, false, r8.source);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x008e, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadLottieResource(final com.alibaba.griver.beehive.lottie.CDPLottiePlayer.ResourceLoadCallback r9) {
        /*
            r8 = this;
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl
            int r0 = r0 + 63
            int r1 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r1
            int r0 = r0 % 2
            if (r0 == 0) goto L25
            java.lang.String r0 = r8.getDowngrade()
            java.lang.String r1 = r8.path
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 0
            r2.hashCode()     // Catch: java.lang.Throwable -> L23
            r2 = 1
            if (r1 != 0) goto L1f
            r1 = 0
            goto L20
        L1f:
            r1 = 1
        L20:
            if (r1 == r2) goto L7e
            goto L3a
        L23:
            r9 = move-exception
            throw r9
        L25:
            java.lang.String r0 = r8.getDowngrade()
            java.lang.String r1 = r8.path
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            r2 = 55
            if (r1 != 0) goto L36
            r1 = 60
            goto L38
        L36:
            r1 = 55
        L38:
            if (r1 == r2) goto L7e
        L3a:
            boolean r1 = r8.isJustLoadPlaceHolder()
            if (r1 == 0) goto L6d
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L69
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext
            int r0 = r0 + 121
            int r1 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl = r1
            int r0 = r0 % 2
            java.lang.String r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG
            java.lang.String r1 = "downgrade but placeHolderImageDjangoId are not set."
            com.alibaba.griver.base.common.logger.GriverLogger.w(r0, r1)
            if (r9 == 0) goto L8e
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl
            int r0 = r0 + 63
            int r2 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r2
            int r0 = r0 % 2
            r0 = 11
            r9.onFail(r0, r1)
            return
        L69:
            r8.loadPlaceholdImage(r9)
            return
        L6d:
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder$3 r0 = new com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder$3
            r0.<init>()
            java.lang.String r9 = r8.path     // Catch: java.lang.Exception -> L7c
            android.content.Context r1 = r8.context     // Catch: java.lang.Exception -> L7c
            java.lang.String r2 = r8.source     // Catch: java.lang.Exception -> L7c
            com.alibaba.griver.beehive.lottie.player.LottieHelper.getResourceWithUrl(r9, r0, r1, r2)     // Catch: java.lang.Exception -> L7c
            return
        L7c:
            r9 = move-exception
            throw r9
        L7e:
            r2 = r0
            java.lang.String r0 = r8.lottieDjangoId
            java.lang.String r1 = r8.lottieMd5
            boolean r3 = r8.optimize
            java.lang.String r5 = r8.scene
            r6 = 0
            java.lang.String r7 = r8.source
            r4 = r9
            com.alibaba.griver.beehive.lottie.BeeLottiePlayer.loadLottieResource(r0, r1, r2, r3, r4, r5, r6, r7)
        L8e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.loadLottieResource(com.alibaba.griver.beehive.lottie.CDPLottiePlayer$ResourceLoadCallback):void");
    }

    private void loadPlaceholdImage(final CDPLottiePlayer.ResourceLoadCallback resourceLoadCallback) {
        MultimediaServiceAdapter.loadImageAsync(this.placeHolderDjangoId, new MultimediaServiceAdapter.ImageLoadCallback() { // from class: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.4
            {
                BeeLottiePlayerBuilder.this = this;
            }

            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.ImageLoadCallback
            public void onSuccess() {
                CDPLottiePlayer.ResourceLoadCallback resourceLoadCallback2 = resourceLoadCallback;
                if (resourceLoadCallback2 != null) {
                    resourceLoadCallback2.onSuccess();
                }
            }

            @Override // com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter.ImageLoadCallback
            public void onFail(int i, String str) {
                CDPLottiePlayer.ResourceLoadCallback resourceLoadCallback2 = resourceLoadCallback;
                if (resourceLoadCallback2 != null) {
                    resourceLoadCallback2.onFail(i, str);
                }
            }
        });
        try {
            int i = scheduleImpl + 13;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private void initPlaceholder() {
        try {
            try {
                this.beeLottiePlayer.setLottieDjangoId(this.lottieDjangoId);
                this.beeLottiePlayer.setLottieMd5(this.lottieMd5);
                this.beeLottiePlayer.setPlaceHolderDjangoId(getDowngrade());
                this.beeLottiePlayer.setOptimize(this.optimize);
                this.beeLottiePlayer.setScene(this.scene);
                this.beeLottiePlayer.initPlaceholder(new CDPLottiePlayer.LottieInitCallback() { // from class: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.5
                    {
                        BeeLottiePlayerBuilder.this = this;
                    }

                    @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.LottieInitCallback
                    public void onSuccess(boolean z, Rect rect) {
                        BeeLottiePlayerBuilder.access$1000(BeeLottiePlayerBuilder.this, z, rect);
                    }

                    @Override // com.alibaba.griver.beehive.lottie.CDPLottiePlayer.LottieInitCallback
                    public void onFail(int i, String str) {
                        BeeLottiePlayerBuilder.access$400(BeeLottiePlayerBuilder.this, i, str);
                    }
                });
                int i = getAuthRequestContext + 35;
                scheduleImpl = i % 128;
                int i2 = i % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    private void fireOnSuccess(final boolean z, final Rect rect) {
        MultiThreadUtils.runOnUiThread(new Runnable() { // from class: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.6
            {
                BeeLottiePlayerBuilder.this = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (BeeLottiePlayerBuilder.access$500(BeeLottiePlayerBuilder.this) != null && !BeeLottiePlayerBuilder.access$600(BeeLottiePlayerBuilder.this)) {
                    BeeLottiePlayerBuilder.access$500(BeeLottiePlayerBuilder.this).onSuccess(z, rect);
                    return;
                }
                String access$200 = BeeLottiePlayerBuilder.access$200();
                StringBuilder sb = new StringBuilder();
                sb.append("fireOnSuccess 回调失败，DjangoId=");
                sb.append(BeeLottiePlayerBuilder.access$700(BeeLottiePlayerBuilder.this));
                sb.append(",path=");
                sb.append(BeeLottiePlayerBuilder.access$800(BeeLottiePlayerBuilder.this));
                sb.append(",callback=");
                sb.append(BeeLottiePlayerBuilder.access$500(BeeLottiePlayerBuilder.this));
                sb.append(",hasDestroyed=");
                sb.append(BeeLottiePlayerBuilder.access$600(BeeLottiePlayerBuilder.this));
                sb.append(",scene=");
                sb.append(BeeLottiePlayerBuilder.access$900(BeeLottiePlayerBuilder.this));
                GriverLogger.e(access$200, sb.toString());
            }
        });
        int i = scheduleImpl + 113;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? Typography.dollar : '(') != '(') {
            Object[] objArr = null;
            int length = objArr.length;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:116:0x0136, code lost:
    
        if (r0 != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0143, code lost:
    
        if (android.text.TextUtils.isEmpty(getDowngrade()) != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0145, code lost:
    
        r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG;
        r1 = new java.lang.StringBuilder();
        r1.append("兜底图为空，降级失败.DjangoId=");
        r1.append(r4.lottieDjangoId);
        r1.append(",path=");
        r1.append(r4.path);
        r1.append(",scene=");
        r1.append(r4.scene);
        com.alibaba.griver.base.common.logger.GriverLogger.e(r0, r1.toString());
        fireOnFail(14, "兜底图为空，降级失败.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x017a, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void initLottieAnimationSync() {
        /*
            Method dump skipped, instructions count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.initLottieAnimationSync():void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0078, code lost:
    
        if (r0.isEmpty() != false) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void initAnimation() {
        /*
            r6 = this;
            java.lang.String r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "不降级，准备加载动画："
            r1.append(r2)
            java.lang.String r2 = r6.lottieDjangoId
            r1.append(r2)
            java.lang.String r2 = ",path="
            r1.append(r2)
            java.lang.String r2 = r6.path
            r1.append(r2)
            java.lang.String r2 = ":"
            r1.append(r2)
            java.lang.String r3 = r6.getDowngrade()
            r1.append(r3)
            r1.append(r2)
            boolean r2 = r6.optimize
            r1.append(r2)
            r2 = 29
            r3 = 1
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r5 = 0
            b(r5, r2, r4)
            r2 = r4[r5]
            java.lang.String r2 = (java.lang.String) r2
            r1.append(r2)
            boolean r2 = r6.variableLottie
            r1.append(r2)
            java.lang.String r2 = ",lottieVariableParams="
            r1.append(r2)
            java.util.Map<java.lang.String, java.lang.String> r2 = r6.lottieVariableParams
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.alibaba.griver.base.common.logger.GriverLogger.d(r0, r1)
            r6.preparePlaceHolderFirst()
            boolean r0 = r6.variableLottie
            if (r0 == 0) goto L5f
            r0 = 1
            goto L60
        L5f:
            r0 = 0
        L60:
            if (r0 == 0) goto La0
            java.util.Map<java.lang.String, java.lang.String> r0 = r6.lottieVariableParams     // Catch: java.lang.Exception -> L9e
            if (r0 == 0) goto L67
            goto L68
        L67:
            r5 = 1
        L68:
            if (r5 == r3) goto L7a
            int r1 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext
            int r1 = r1 + 21
            int r2 = r1 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl = r2
            int r1 = r1 % 2
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto La0
        L7a:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "参数化动画并未设置参数,variableLottie=true,lottieParams为空:"
            r0.append(r1)
            java.util.Map<java.lang.String, java.lang.String> r1 = r6.lottieVariableParams
            r0.append(r1)
            r1 = 11
            java.lang.String r0 = r0.toString()
            r6.fireOnFail(r1, r0)
            int r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl
            int r0 = r0 + 79
            int r1 = r0 % 128
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r1
            int r0 = r0 % 2
            return
        L9e:
            r0 = move-exception
            throw r0
        La0:
            com.alibaba.griver.beehive.lottie.BeeLottiePlayer r0 = r6.beeLottiePlayer
            boolean r1 = r6.loadPlaceholderFirst
            r0.setLoadPlaceholderFirst(r1)
            com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder$7 r0 = new com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder$7
            r0.<init>()
            com.alibaba.griver.beehive.lottie.player.LottieParams r1 = r6.params
            com.alibaba.griver.beehive.lottie.BeeLottiePlayer r2 = r6.beeLottiePlayer
            r6.parseAnimationFile(r1, r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.initAnimation():void");
    }

    private void parseAnimationFile(LottieParams lottieParams, final BeeLottiePlayer beeLottiePlayer, final CDPLottiePlayer.LottieInitCallback lottieInitCallback) {
        try {
            if (FILE_LOCAL_TYPE_ASSETS.equals(this.animationFileLocalType)) {
                int i = scheduleImpl + 79;
                getAuthRequestContext = i % 128;
                int i2 = i % 2;
                parseAssetsAnimationFile(lottieParams, beeLottiePlayer, lottieInitCallback);
            } else if (!TextUtils.isEmpty(this.path)) {
                beeLottiePlayer.setLottieDataStatus(new ILottieDataStatus() { // from class: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.8
                    {
                        BeeLottiePlayerBuilder.this = this;
                    }

                    @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
                    public void onDataLoadReady() {
                        String access$200 = BeeLottiePlayerBuilder.access$200();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onDataLoadReady:");
                        sb.append(BeeLottiePlayerBuilder.access$800(BeeLottiePlayerBuilder.this));
                        GriverLogger.d(access$200, sb.toString());
                    }

                    @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
                    public void onDataReady() {
                        String access$200 = BeeLottiePlayerBuilder.access$200();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onDataReady:");
                        sb.append(BeeLottiePlayerBuilder.access$800(BeeLottiePlayerBuilder.this));
                        GriverLogger.d(access$200, sb.toString());
                        lottieInitCallback.onSuccess(false, beeLottiePlayer.getLottieRect());
                    }

                    @Override // com.alibaba.griver.beehive.lottie.player.ILottieDataStatus
                    public void onDataFailed(String str) {
                        String access$200 = BeeLottiePlayerBuilder.access$200();
                        StringBuilder sb = new StringBuilder();
                        sb.append("onDataFailed:");
                        sb.append(BeeLottiePlayerBuilder.access$800(BeeLottiePlayerBuilder.this));
                        sb.append(",");
                        sb.append(str);
                        GriverLogger.e(access$200, sb.toString());
                        lottieInitCallback.onFail(16, str);
                    }
                });
                beeLottiePlayer.applyParams(lottieParams);
                int i3 = scheduleImpl + 27;
                getAuthRequestContext = i3 % 128;
                int i4 = i3 % 2;
            } else {
                beeLottiePlayer.parseLottieUnZipFile(lottieParams, lottieInitCallback);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:223:0x00e4, code lost:
    
        if (((java.lang.Boolean) java.lang.String.class.getMethod("equals", java.lang.Object.class).invoke(com.alibaba.griver.beehive.lottie.constants.LottieConstants.RENDER_TYPE_ANTMATIONS, r10)).booleanValue() != false) goto L224;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:341:0x0318 A[Catch: all -> 0x033a, TRY_LEAVE, TryCatch #17 {all -> 0x033a, blocks: (B:339:0x02ef, B:341:0x0318), top: B:375:0x02ef }] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0334 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:344:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:377:0x033d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parseAssetsAnimationFile(com.alibaba.griver.beehive.lottie.player.LottieParams r21, final com.alibaba.griver.beehive.lottie.BeeLottiePlayer r22, final com.alibaba.griver.beehive.lottie.CDPLottiePlayer.LottieInitCallback r23) {
        /*
            Method dump skipped, instructions count: 835
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.parseAssetsAnimationFile(com.alibaba.griver.beehive.lottie.player.LottieParams, com.alibaba.griver.beehive.lottie.BeeLottiePlayer, com.alibaba.griver.beehive.lottie.CDPLottiePlayer$LottieInitCallback):void");
    }

    public boolean checkLottieResourceIsReady() {
        try {
            try {
                if (FILE_LOCAL_TYPE_ASSETS.equals(this.animationFileLocalType)) {
                    int i = getAuthRequestContext + 103;
                    scheduleImpl = i % 128;
                    int i2 = i % 2;
                    int i3 = scheduleImpl + 63;
                    getAuthRequestContext = i3 % 128;
                    int i4 = i3 % 2;
                    return true;
                }
                if (isJustLoadPlaceHolder()) {
                    int i5 = getAuthRequestContext + 27;
                    scheduleImpl = i5 % 128;
                    int i6 = i5 % 2;
                    if (!TextUtils.isEmpty(getDowngrade())) {
                        int i7 = scheduleImpl + 35;
                        getAuthRequestContext = i7 % 128;
                        int i8 = i7 % 2;
                        APImageQueryResultAdapter doImageQuery = MultimediaServiceAdapter.doImageQuery(getDowngrade());
                        if (!(doImageQuery == null)) {
                            if ((doImageQuery.success ? (char) 6 : ':') == 6) {
                                return true;
                            }
                        }
                        return false;
                    }
                }
                if ((isJustLoadPlaceHolder()) && TextUtils.isEmpty(getDowngrade())) {
                    String str = TAG;
                    StringBuilder sb = new StringBuilder();
                    sb.append("兜底图为空，降级失败.DjangoId=");
                    sb.append(this.lottieDjangoId);
                    sb.append(",scene=");
                    sb.append(this.scene);
                    GriverLogger.e(str, sb.toString());
                    return false;
                } else if (TextUtils.isEmpty(this.path)) {
                    File lottieUnzipDir = DownloadFileUtils.getLottieUnzipDir(this.lottieDjangoId);
                    if (lottieUnzipDir != null && lottieUnzipDir.exists()) {
                        File[] listFiles = lottieUnzipDir.listFiles(new FilenameFilter() { // from class: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.10
                            {
                                BeeLottiePlayerBuilder.this = this;
                            }

                            @Override // java.io.FilenameFilter
                            public boolean accept(File file, String str2) {
                                return str2.endsWith(".json");
                            }
                        });
                        if ((listFiles != null ? 'L' : (char) 14) != 14 && listFiles.length > 0) {
                            int i9 = getAuthRequestContext + 5;
                            scheduleImpl = i9 % 128;
                            return i9 % 2 != 0;
                        }
                        DownloadFileUtils.delFile(lottieUnzipDir);
                    }
                    return false;
                } else {
                    return false;
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:103:0x0093, code lost:
    
        if (r0 != false) goto L113;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x00a3, code lost:
    
        if ((android.text.TextUtils.isEmpty(r6.assetsAnimationPath)) != true) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x00aa, code lost:
    
        if (canDowngrade() == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x00ac, code lost:
    
        r0 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl + 97;
        com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r0 % 128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x00b6, code lost:
    
        if ((r0 % 2) == 0) goto L118;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x00b9, code lost:
    
        r2 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x00ba, code lost:
    
        if (r2 == false) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x00bc, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w(com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG, "无Lottie相关数据，并设置了Placeholder，直接降级：");
        r0 = java.lang.Boolean.TRUE;
        r6.downgradleToPlaceholder = r0;
        r0 = r0.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00c9, code lost:
    
        r1 = r4.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00cd, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00ce, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00cf, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.w(com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG, "无Lottie相关数据，并设置了Placeholder，直接降级：");
        r0 = java.lang.Boolean.TRUE;
        r6.downgradleToPlaceholder = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x00dc, code lost:
    
        return r0.booleanValue();
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:?, code lost:
    
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isJustLoadPlaceHolder() {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.isJustLoadPlaceHolder():boolean");
    }

    private boolean canDowngrade() {
        int i = scheduleImpl + 51;
        getAuthRequestContext = i % 128;
        boolean isEmpty = i % 2 != 0 ? TextUtils.isEmpty(getDowngrade()) & true : !TextUtils.isEmpty(getDowngrade());
        int i2 = scheduleImpl + 45;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return isEmpty;
    }

    public String getLottieDjangoId() {
        String str;
        int i = getAuthRequestContext + 121;
        scheduleImpl = i % 128;
        if (!(i % 2 == 0)) {
            str = this.lottieDjangoId;
        } else {
            str = this.lottieDjangoId;
            Object[] objArr = null;
            int length = objArr.length;
        }
        int i2 = scheduleImpl + 119;
        getAuthRequestContext = i2 % 128;
        if (i2 % 2 != 0) {
            int i3 = 55 / 0;
            return str;
        }
        return str;
    }

    public BeeLottiePlayerBuilder setLottieDjangoId(String str) {
        int i = scheduleImpl + 75;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.lottieDjangoId = GrayHelper.getReplaceDjangoId(str);
        Object obj = null;
        if (!(TextUtils.isEmpty(str))) {
            Object[] objArr = new Object[1];
            b(58, (byte) -1, objArr);
            if ((str.startsWith((String) objArr[0]) ? '8' : (char) 29) != 29) {
                try {
                    this.lottieDjangoId = null;
                    String substring = str.substring(16);
                    setAssetsAnimationPath(substring);
                    setAnimationFileLocalType(FILE_LOCAL_TYPE_ASSETS);
                    if (substring.endsWith(".json")) {
                        setAssetsImageDir(substring.substring(0, substring.lastIndexOf("/")));
                    } else {
                        int i3 = scheduleImpl + 43;
                        getAuthRequestContext = i3 % 128;
                        if ((i3 % 2 != 0 ? Typography.amp : '#') != '#') {
                            setAssetsImageDir(substring);
                            obj.hashCode();
                        } else {
                            setAssetsImageDir(substring);
                        }
                    }
                    return this;
                } catch (Exception e) {
                    throw e;
                }
            }
        }
        setAssetsAnimationPath(null);
        setAssetsImageDir(null);
        setAnimationFileLocalType(FILE_LOCAL_TYPE_DJANGOID);
        return this;
    }

    public String getAssetsAnimationPath() {
        int i = getAuthRequestContext + 107;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = this.assetsAnimationPath;
        int i3 = getAuthRequestContext + 87;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    @Deprecated
    public BeeLottiePlayerBuilder setAssetsAnimationPath(String str) {
        try {
            int i = getAuthRequestContext + 11;
            try {
                scheduleImpl = i % 128;
                boolean z = i % 2 == 0;
                this.assetsAnimationPath = str;
                if (z) {
                    int i2 = 83 / 0;
                }
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getLottieMd5() {
        int i = scheduleImpl + 105;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            String str = this.lottieMd5;
            Object[] objArr = null;
            int length = objArr.length;
            return str;
        }
        return this.lottieMd5;
    }

    public BeeLottiePlayerBuilder setLottieMd5(String str) {
        int i = getAuthRequestContext + 37;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            this.lottieMd5 = str;
            try {
                int i3 = getAuthRequestContext + 109;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getPlaceHolderDjangoId() {
        int i = scheduleImpl + 49;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String str = this.placeHolderDjangoId;
        int i3 = getAuthRequestContext + 27;
        scheduleImpl = i3 % 128;
        if (!(i3 % 2 != 0)) {
            int i4 = 84 / 0;
            return str;
        }
        return str;
    }

    public BeeLottiePlayerBuilder setPlaceHolderDjangoId(String str) {
        int i = scheduleImpl + 101;
        getAuthRequestContext = i % 128;
        if (i % 2 != 0) {
            this.placeHolderDjangoId = str;
            Object[] objArr = null;
            int length = objArr.length;
        } else {
            try {
                this.placeHolderDjangoId = str;
            } catch (Exception e) {
                throw e;
            }
        }
        int i2 = getAuthRequestContext + 87;
        scheduleImpl = i2 % 128;
        if (!(i2 % 2 != 0)) {
            int i3 = 81 / 0;
            return this;
        }
        return this;
    }

    public BeeLottiePlayerBuilder setPlaceHolder(String str) {
        int i = scheduleImpl + 89;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            this.placeHolderDjangoId = str;
            int i3 = scheduleImpl + 43;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isOptimize() {
        int i = getAuthRequestContext + 25;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        try {
            boolean z = this.optimize;
            int i3 = getAuthRequestContext + 17;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return z;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayerBuilder setOptimize(boolean z) {
        int i = scheduleImpl + 83;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.optimize = z;
        int i3 = scheduleImpl + 115;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return this;
    }

    public String getScene() {
        String str;
        int i = getAuthRequestContext + 49;
        scheduleImpl = i % 128;
        if (i % 2 == 0) {
            str = this.scene;
            int i2 = 50 / 0;
        } else {
            str = this.scene;
        }
        try {
            int i3 = getAuthRequestContext + 73;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayerBuilder setScene(String str) {
        try {
            int i = getAuthRequestContext + 17;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            this.scene = str;
            int i3 = scheduleImpl + 85;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public boolean isVariableLottie() {
        int i = scheduleImpl + 71;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? '6' : (char) 1) != '6') {
            return this.variableLottie;
        }
        boolean z = this.variableLottie;
        Object obj = null;
        obj.hashCode();
        return z;
    }

    public BeeLottiePlayerBuilder setVariableLottie(boolean z) {
        int i = getAuthRequestContext + 89;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        this.variableLottie = z;
        int i3 = scheduleImpl + 105;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return this;
    }

    public Context getContext() {
        try {
            int i = scheduleImpl + 51;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            try {
                Context context = this.context;
                int i3 = getAuthRequestContext + 91;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return context;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public BeeLottiePlayerBuilder setContext(Context context) {
        int i = scheduleImpl + 59;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.context = context;
        int i3 = getAuthRequestContext + 27;
        scheduleImpl = i3 % 128;
        if (i3 % 2 == 0) {
            Object[] objArr = null;
            int length = objArr.length;
            return this;
        }
        return this;
    }

    public int getRepeatCount() {
        try {
            int i = getAuthRequestContext + 11;
            try {
                scheduleImpl = i % 128;
                int i2 = i % 2;
                int i3 = this.repeatCount;
                int i4 = scheduleImpl + 39;
                getAuthRequestContext = i4 % 128;
                if (!(i4 % 2 == 0)) {
                    Object obj = null;
                    obj.hashCode();
                    return i3;
                }
                return i3;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public BeeLottiePlayerBuilder setRepeatCount(int i) {
        try {
            int i2 = scheduleImpl + 107;
            try {
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                this.repeatCount = i;
                int i4 = getAuthRequestContext + 77;
                scheduleImpl = i4 % 128;
                int i5 = i4 % 2;
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getSource() {
        int i = getAuthRequestContext + 123;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? 'G' : ',') != ',') {
            String str = this.source;
            Object obj = null;
            obj.hashCode();
            return str;
        }
        return this.source;
    }

    public BeeLottiePlayerBuilder setSource(String str) {
        int i = scheduleImpl + 33;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.source = str;
        try {
            int i3 = getAuthRequestContext + 15;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public AnimationInitCallback getAnimationInitCallback() {
        int i = scheduleImpl + 43;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        AnimationInitCallback animationInitCallback = this.animationInitCallback;
        try {
            int i3 = getAuthRequestContext + 121;
            scheduleImpl = i3 % 128;
            if (i3 % 2 == 0) {
                Object obj = null;
                obj.hashCode();
                return animationInitCallback;
            }
            return animationInitCallback;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayerBuilder setAnimationInitCallback(AnimationInitCallback animationInitCallback) {
        int i = getAuthRequestContext + 123;
        scheduleImpl = i % 128;
        if ((i % 2 == 0 ? '\t' : '1') != '\t') {
            this.animationInitCallback = animationInitCallback;
        } else {
            this.animationInitCallback = animationInitCallback;
            int i2 = 92 / 0;
        }
        int i3 = getAuthRequestContext + 123;
        scheduleImpl = i3 % 128;
        if (i3 % 2 == 0) {
            int i4 = 71 / 0;
            return this;
        }
        return this;
    }

    public String getAssetsImageDir() {
        String str;
        int i = getAuthRequestContext + 73;
        scheduleImpl = i % 128;
        Object obj = null;
        if ((i % 2 == 0 ? 'G' : 'Y') != 'Y') {
            try {
                str = this.assetsImageDir;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            str = this.assetsImageDir;
        }
        int i2 = scheduleImpl + 11;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 != 0 ? Typography.dollar : (char) 30) != '$') {
            return str;
        }
        obj.hashCode();
        return str;
    }

    @Deprecated
    public BeeLottiePlayerBuilder setAssetsImageDir(String str) {
        int i = getAuthRequestContext + 113;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        this.assetsImageDir = str;
        int i3 = scheduleImpl + 27;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return this;
    }

    public String getAnimationFileLocalType() {
        String str;
        int i = getAuthRequestContext + 33;
        scheduleImpl = i % 128;
        try {
            if ((i % 2 == 0 ? '8' : (char) 20) != '8') {
                str = this.animationFileLocalType;
            } else {
                str = this.animationFileLocalType;
                Object[] objArr = null;
                int length = objArr.length;
            }
            int i2 = scheduleImpl + 27;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    @Deprecated
    public BeeLottiePlayerBuilder setAnimationFileLocalType(String str) {
        int i = scheduleImpl + 107;
        getAuthRequestContext = i % 128;
        char c = i % 2 != 0 ? (char) 0 : ':';
        this.animationFileLocalType = str;
        if (c != ':') {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = scheduleImpl + 17;
            getAuthRequestContext = i2 % 128;
            int i3 = i2 % 2;
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayer getLottiePlayer() {
        BeeLottiePlayer beeLottiePlayer;
        int i = scheduleImpl + 77;
        getAuthRequestContext = i % 128;
        if ((i % 2 != 0 ? 'Q' : (char) 18) != 'Q') {
            beeLottiePlayer = this.beeLottiePlayer;
        } else {
            beeLottiePlayer = this.beeLottiePlayer;
            Object obj = null;
            obj.hashCode();
        }
        int i2 = scheduleImpl + 31;
        getAuthRequestContext = i2 % 128;
        int i3 = i2 % 2;
        return beeLottiePlayer;
    }

    public String getRenderType() {
        try {
            int i = getAuthRequestContext + 83;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            String str = this.renderType;
            int i3 = getAuthRequestContext + 65;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return str;
        } catch (Exception e) {
            throw e;
        }
    }

    public String getDowngradeLevel() {
        int i = scheduleImpl + 7;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        String str = this.downgradeLevel;
        int i3 = scheduleImpl + 111;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? 'N' : 'R') != 'N') {
            return str;
        }
        Object[] objArr = null;
        int length = objArr.length;
        return str;
    }

    public BeeLottiePlayerBuilder setDowngradeLevel(String str) {
        int i = scheduleImpl + 25;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.downgradeLevel = str;
        int i3 = scheduleImpl + 23;
        getAuthRequestContext = i3 % 128;
        if (!(i3 % 2 == 0)) {
            int i4 = 55 / 0;
            return this;
        }
        return this;
    }

    public Map<String, String> getLottieVariableParams() {
        int i = scheduleImpl + 33;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            return this.lottieVariableParams;
        }
        try {
            int i2 = 37 / 0;
            return this.lottieVariableParams;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayerBuilder setLottieVariableParams(Map<String, String> map) {
        try {
            int i = scheduleImpl + 29;
            getAuthRequestContext = i % 128;
            if (i % 2 == 0) {
                this.lottieVariableParams = map;
            } else {
                this.lottieVariableParams = map;
                int i2 = 20 / 0;
            }
            int i3 = getAuthRequestContext + 99;
            scheduleImpl = i3 % 128;
            int i4 = i3 % 2;
            return this;
        } catch (Exception e) {
            throw e;
        }
    }

    public BeeLottiePlayerBuilder setDowngrade(String str) {
        int i = scheduleImpl + 107;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        try {
            this.downgrade = str;
            try {
                int i3 = getAuthRequestContext + 27;
                scheduleImpl = i3 % 128;
                int i4 = i3 % 2;
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public String getDowngrade() {
        String str;
        if (TextUtils.isEmpty(this.downgrade)) {
            int i = scheduleImpl + 67;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
            str = this.placeHolderDjangoId;
            int i3 = scheduleImpl + 71;
            getAuthRequestContext = i3 % 128;
            int i4 = i3 % 2;
        } else {
            str = this.downgrade;
        }
        return (TextUtils.isEmpty(str) ? (char) 17 : 'C') != 17 ? str : LottieHelper.getLocalDowngradeFilePath(this.lottieDjangoId);
    }

    public BeeLottiePlayerBuilder setRenderType(String str) {
        int i = scheduleImpl + 79;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.renderType = str;
        int i3 = scheduleImpl + 43;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return this;
    }

    public BeeLottiePlayerBuilder setLoadPlaceholderFirst(boolean z) {
        int i = getAuthRequestContext + 119;
        scheduleImpl = i % 128;
        char c = i % 2 == 0 ? Typography.greater : '!';
        this.loadPlaceholderFirst = z;
        if (c == '>') {
            Object obj = null;
            obj.hashCode();
        }
        try {
            int i2 = scheduleImpl + 45;
            try {
                getAuthRequestContext = i2 % 128;
                int i3 = i2 % 2;
                return this;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    public boolean isLoadPlaceholderFirst() {
        int i = getAuthRequestContext + 91;
        scheduleImpl = i % 128;
        if (!(i % 2 == 0)) {
            return this.loadPlaceholderFirst;
        }
        boolean z = this.loadPlaceholderFirst;
        Object[] objArr = null;
        int length = objArr.length;
        return z;
    }

    public static String getAssetsFileString(InputStream inputStream) {
        try {
            Object[] objArr = new Object[1];
            a(TextUtils.indexOf("", ""), 5 - Drawable.resolveOpacity(0, 0), (char) (29278 - TextUtils.getCapsMode("", 0, 0)), objArr);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, ((String) objArr[0]).intern()));
            StringBuffer stringBuffer = new StringBuffer("");
            int i = getAuthRequestContext + 5;
            scheduleImpl = i % 128;
            int i2 = i % 2;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        try {
                            int i3 = getAuthRequestContext + 119;
                            scheduleImpl = i3 % 128;
                            int i4 = i3 % 2;
                            if ((stringBuffer.length() > 0 ? '^' : (char) 3) == '^') {
                                stringBuffer.append("\n");
                            }
                            stringBuffer.append(readLine);
                        } catch (Exception e) {
                            throw e;
                        }
                    } else {
                        String obj = stringBuffer.toString();
                        int i5 = getAuthRequestContext + 33;
                        scheduleImpl = i5 % 128;
                        int i6 = i5 % 2;
                        return obj;
                    }
                } catch (IOException e2) {
                    GriverLogger.w(TAG, "getAssetsFileString", e2);
                    return null;
                }
            }
        } catch (UnsupportedEncodingException e3) {
            GriverLogger.w(TAG, "getAssetsFileString", e3);
            return null;
        }
    }

    public BeeLottiePlayer build() {
        if (this.beeLottiePlayer == null) {
            this.beeLottiePlayer = new BeeLottiePlayer(this.context, this.source);
            int i = scheduleImpl + 29;
            getAuthRequestContext = i % 128;
            int i2 = i % 2;
        }
        BeeLottiePlayer beeLottiePlayer = this.beeLottiePlayer;
        int i3 = scheduleImpl + 17;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return beeLottiePlayer;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x004f, code lost:
    
        if (r3 == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0055, code lost:
    
        if (r13.endsWith("/") != false) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0057, code lost:
    
        r3 = new java.lang.StringBuilder();
        r3.append(r13);
        r3.append("/");
        r13 = r3.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0066, code lost:
    
        r2 = com.alibaba.griver.beehive.lottie.player.LottieHelper.listAssetsDir(r12.context, r13);
        r3 = r2.length;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x006d, code lost:
    
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x006e, code lost:
    
        if (r6 >= r3) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0070, code lost:
    
        r7 = 20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0073, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0074, code lost:
    
        if (r7 == 0) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x0076, code lost:
    
        r7 = com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.scheduleImpl + 45;
        com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.getAuthRequestContext = r7 % 128;
        r7 = r7 % 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0080, code lost:
    
        r7 = r2[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0088, code lost:
    
        if ("placeHolder.png".equals(r7) == false) goto L114;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x008a, code lost:
    
        r8 = '!';
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x008d, code lost:
    
        r8 = '6';
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0092, code lost:
    
        if (r8 == '6') goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x009a, code lost:
    
        if (android.text.TextUtils.isEmpty(r12.placeHolderDjangoId) == false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x009c, code lost:
    
        r7 = new java.lang.StringBuilder();
        r8 = new java.lang.Object[1];
        b(58, (byte) -1, r8);
        r7.append((java.lang.String) r8[0]);
        r7.append(r13);
        r7.append("placeHolder.png");
        r12.placeHolderDjangoId = r7.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x00be, code lost:
    
        if ("downgrade.png".equals(r7) == false) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x00c6, code lost:
    
        if (android.text.TextUtils.isEmpty(r12.downgrade) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x00c8, code lost:
    
        r7 = new java.lang.StringBuilder();
        r8 = new java.lang.Object[1];
        b(58, (byte) -1, r8);
        r7.append((java.lang.String) r8[0]);
        r7.append(r13);
        r7.append("downgrade.png");
        r12.downgrade = r7.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x00e5, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x00e8, code lost:
    
        r13 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x00e9, code lost:
    
        com.alibaba.griver.base.common.logger.GriverLogger.e(com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.TAG, "prepareAssetPlaceHolder异常:", r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0037, code lost:
    
        if ((!r3) != true) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0042, code lost:
    
        if (android.text.TextUtils.isEmpty(r12.placeHolderDjangoId) == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x004a, code lost:
    
        if (android.text.TextUtils.isEmpty(r12.downgrade) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x004c, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x004e, code lost:
    
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void prepareAssetPlaceHolder(java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder.prepareAssetPlaceHolder(java.lang.String):void");
    }

    public void destroy() {
        int i = scheduleImpl + 123;
        getAuthRequestContext = i % 128;
        int i2 = i % 2;
        this.hasDestroyed = true;
        BeeLottiePlayer beeLottiePlayer = this.beeLottiePlayer;
        if ((beeLottiePlayer != null ? '=' : '+') != '+') {
            int i3 = getAuthRequestContext + 25;
            scheduleImpl = i3 % 128;
            if (i3 % 2 != 0) {
                beeLottiePlayer.destroy();
            } else {
                beeLottiePlayer.destroy();
                Object[] objArr = null;
                int length = objArr.length;
            }
        }
        int i4 = scheduleImpl + 79;
        getAuthRequestContext = i4 % 128;
        int i5 = i4 % 2;
    }

    public String getBizId() {
        int i = getAuthRequestContext + 81;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = this.bizId;
        int i3 = scheduleImpl + 63;
        getAuthRequestContext = i3 % 128;
        if ((i3 % 2 != 0 ? (char) 6 : '@') != '@') {
            int i4 = 95 / 0;
            return str;
        }
        return str;
    }

    public BeeLottiePlayerBuilder setBizId(String str) {
        int i = scheduleImpl + 53;
        getAuthRequestContext = i % 128;
        if (i % 2 == 0) {
            this.bizId = str;
        } else {
            try {
                this.bizId = str;
                int i2 = 87 / 0;
            } catch (Exception e) {
                throw e;
            }
        }
        int i3 = scheduleImpl + 25;
        getAuthRequestContext = i3 % 128;
        int i4 = i3 % 2;
        return this;
    }

    public BeeLottiePlayerBuilder setPath(String str) {
        int i = scheduleImpl + 105;
        getAuthRequestContext = i % 128;
        boolean z = i % 2 != 0;
        this.path = GrayHelper.getReplaceDjangoId(str);
        if (z) {
            Object obj = null;
            obj.hashCode();
        }
        return this;
    }

    public String getDynamicLayer() {
        int i = getAuthRequestContext + 81;
        scheduleImpl = i % 128;
        int i2 = i % 2;
        String str = this.dynamicLayer;
        int i3 = getAuthRequestContext + 55;
        scheduleImpl = i3 % 128;
        int i4 = i3 % 2;
        return str;
    }

    public BeeLottiePlayerBuilder setDynamicLayer(String str) {
        int i = getAuthRequestContext + 55;
        scheduleImpl = i % 128;
        Object[] objArr = null;
        if ((i % 2 == 0 ? (char) 16 : (char) 0) != 0) {
            try {
                this.dynamicLayer = str;
                objArr.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } else {
            this.dynamicLayer = str;
        }
        int i2 = scheduleImpl + 125;
        getAuthRequestContext = i2 % 128;
        if ((i2 % 2 != 0 ? ',' : 'U') != 'U') {
            int length = objArr.length;
            return this;
        }
        return this;
    }

    private static void a(int i, int i2, char c, Object[] objArr) {
        whenAvailable whenavailable = new whenAvailable();
        long[] jArr = new long[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? (char) 31 : '4') != 31) {
                break;
            }
            int i3 = $10 + 99;
            $11 = i3 % 128;
            int i4 = i3 % 2;
            try {
                jArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (((char) (BuiltInFictitiousFunctionClassFactory[whenavailable.BuiltInFictitiousFunctionClassFactory + i] ^ (-4773380863230414002L))) ^ (whenavailable.BuiltInFictitiousFunctionClassFactory * ((-4773380863230414002L) ^ MyBillsEntityDataFactory))) ^ c;
                whenavailable.BuiltInFictitiousFunctionClassFactory++;
            } catch (Exception e) {
                throw e;
            }
        }
        char[] cArr = new char[i2];
        whenavailable.BuiltInFictitiousFunctionClassFactory = 0;
        while (true) {
            if ((whenavailable.BuiltInFictitiousFunctionClassFactory < i2 ? 'K' : '[') == '[') {
                objArr[0] = new String(cArr);
                return;
            }
            int i5 = $11 + 37;
            $10 = i5 % 128;
            if (i5 % 2 != 0) {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            } else {
                cArr[whenavailable.BuiltInFictitiousFunctionClassFactory] = (char) jArr[whenavailable.BuiltInFictitiousFunctionClassFactory];
            }
            whenavailable.BuiltInFictitiousFunctionClassFactory++;
            int i6 = $10 + 25;
            $11 = i6 % 128;
            int i7 = i6 % 2;
        }
    }
}
