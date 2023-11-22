package com.alibaba.griver.beehive.lottie.player;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.beehive.lottie.BeeLottiePlayerBuilder;
import com.alibaba.griver.beehive.lottie.adapter.impl.APDecodeResultAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.MultimediaServiceAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.NumberFontUtilAdapter;
import com.alibaba.griver.beehive.lottie.adapter.impl.SwitchConfigUtilsAdapter;
import com.alibaba.griver.beehive.lottie.constants.LottieConstants;
import com.alibaba.griver.beehive.lottie.util.ParseUtils;
import com.alibaba.griver.beehive.lottie.util.SceneUtils;
import com.alibaba.griver.beehive.lottie.util.StringUtils;
import com.alibaba.griver.lottie.LottieComposition;
import com.google.common.base.Ascii;
import id.dana.sendmoney.summary.SummaryActivity;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class LottieParams {
    public static final String KEY_ASSETS_PATH = "assetsPath";
    public static final String KEY_AUTO_PLAY = "autoplay";
    public static final String KEY_AUTO_REVERSE = "autoReverse";
    public static final String KEY_DJANGO_ID = "djangoId";
    public static final String KEY_DOWNGRADE = "downgrade";
    public static final String KEY_DOWNGRADE_LEVEL = "downgradeLevel";
    public static final String KEY_ELEMENT_ID = "element";
    public static final String KEY_LOTTIE_CONTENT = "lottieContent";
    public static final String KEY_MD5 = "md5";
    public static final String KEY_OPTIMIZE = "optimize";
    public static final String KEY_PATH = "path";
    public static final String KEY_PLACEHOLDER = "placeholder";
    public static final String KEY_RENDER_TYPE = "renderType";
    public static final String KEY_REPEAT_COUNT = "repeatCount";
    public static final String KEY_SCENE = "scene";
    public static final String KEY_SPEED = "speed";
    public static final String KEY_VARIABLE_LOTTIE = "variableLottie";
    public static final String KEY_VARIABLE_MAP = "variableMap";
    private static final String TAG = "LottieParams";
    Map<String, String> animationAssetsMap;
    private String animationFileLocalType;
    Map<String, String> animationFontsMap;
    Map<String, String> antmationConfigParams;
    AntmationRuntimeModel antmationRuntime;
    HashMap<String, AbstractLottieAsset> assets;
    private String assetsAnimationPath;
    private String assetsImageDir;
    private String bizId;
    public boolean dynamicLayerEnable;
    public List<DynamicLayerModel> dynamicLayerModelList;
    HashMap<String, Typeface> fonts;
    private int fps;
    private List<String> frames;
    private int height;
    public List<String> imageList;
    private boolean isAutoPlay;
    private LottieComposition lottieComposition;
    private File lottieFile;
    private String mAssetsPath;
    private boolean mAutoReverse;
    private String mDjangoId;
    private String mDowngrade;
    private String mDowngradeLevel;
    private String mElementId;
    private String mLottieJson;
    private Map<String, String> mLottieParams;
    private String mMd5;
    private boolean mOptimize;
    private String mPath;
    private String mPlaceholder;
    private String mRenderType;
    private int mRepeatCount;
    private Map<String, String> mSourceData;
    private float mSpeed;
    private boolean mVariableLottie;
    MarsRuntimeModel marsRuntimeModel;
    List<PreloadModel> preloadModelList;
    private String scene;
    private int width;
    public static final byte[] BuiltInFictitiousFunctionClassFactory = {122, TarHeader.LF_CONTIG, -29, -99, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int PlaceComponentResult = 6;

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0035). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void a(int r6, byte r7, byte r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 15
            int r8 = r8 + 4
            int r6 = 106 - r6
            byte[] r0 = com.alibaba.griver.beehive.lottie.player.LottieParams.BuiltInFictitiousFunctionClassFactory
            int r7 = r7 * 2
            int r7 = r7 + 16
            byte[] r1 = new byte[r7]
            int r7 = r7 + (-1)
            r2 = 0
            if (r0 != 0) goto L19
            r3 = r1
            r4 = 0
            r1 = r0
            r0 = r9
            r9 = r8
            goto L35
        L19:
            r3 = 0
            r5 = r8
            r8 = r6
            r6 = r5
        L1d:
            byte r4 = (byte) r8
            r1[r3] = r4
            if (r3 != r7) goto L2a
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L2a:
            int r3 = r3 + 1
            r4 = r0[r6]
            r5 = r9
            r9 = r6
            r6 = r4
            r4 = r3
            r3 = r1
            r1 = r0
            r0 = r5
        L35:
            int r8 = r8 + r6
            int r6 = r9 + 1
            int r8 = r8 + 2
            r9 = r0
            r0 = r1
            r1 = r3
            r3 = r4
            goto L1d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.griver.beehive.lottie.player.LottieParams.a(int, byte, byte, java.lang.Object[]):void");
    }

    public LottieParams() {
        this.animationFileLocalType = BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_DJANGOID;
        init();
    }

    public LottieParams(LottieParams lottieParams) {
        this.animationFileLocalType = BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_DJANGOID;
        if (lottieParams != null) {
            this.mElementId = lottieParams.mElementId;
            this.isAutoPlay = lottieParams.isAutoPlay;
            this.mPath = lottieParams.mPath;
            this.mSpeed = lottieParams.mSpeed;
            this.mRepeatCount = lottieParams.mRepeatCount;
            this.mAutoReverse = lottieParams.mAutoReverse;
            this.mAssetsPath = lottieParams.mAssetsPath;
            this.mPlaceholder = lottieParams.mPlaceholder;
            this.mDowngrade = lottieParams.mDowngrade;
            this.mDjangoId = lottieParams.mDjangoId;
            this.mMd5 = lottieParams.mMd5;
            this.mOptimize = lottieParams.mOptimize;
            this.mVariableLottie = lottieParams.mVariableLottie;
            this.mLottieJson = lottieParams.mLottieJson;
            this.lottieComposition = lottieParams.lottieComposition;
            this.lottieFile = lottieParams.lottieFile;
            this.assets = lottieParams.assets;
            this.fonts = lottieParams.fonts;
            this.mSourceData = lottieParams.mSourceData;
            this.mDowngradeLevel = lottieParams.mDowngradeLevel;
            this.mRenderType = lottieParams.mRenderType;
            this.scene = lottieParams.scene;
            this.mLottieParams = lottieParams.mLottieParams;
            this.animationFileLocalType = lottieParams.animationFileLocalType;
            this.assetsImageDir = lottieParams.assetsImageDir;
            this.assetsAnimationPath = lottieParams.assetsAnimationPath;
            this.animationAssetsMap = lottieParams.animationAssetsMap;
            this.animationFontsMap = lottieParams.animationFontsMap;
            this.antmationRuntime = lottieParams.antmationRuntime;
            this.preloadModelList = lottieParams.preloadModelList;
            this.imageList = lottieParams.imageList;
            this.marsRuntimeModel = lottieParams.marsRuntimeModel;
            this.antmationConfigParams = lottieParams.antmationConfigParams;
            this.bizId = lottieParams.bizId;
            this.dynamicLayerEnable = lottieParams.dynamicLayerEnable;
            this.dynamicLayerModelList = lottieParams.dynamicLayerModelList;
            return;
        }
        init();
    }

    private void init() {
        this.mElementId = "";
        this.isAutoPlay = false;
        this.mPath = "";
        this.mSpeed = 1.0f;
        this.mRepeatCount = 0;
        this.mAutoReverse = false;
        this.mAssetsPath = "";
        this.mPlaceholder = "";
        this.mDowngrade = "";
        this.mDjangoId = "";
        this.mMd5 = "";
        this.mOptimize = false;
        this.mVariableLottie = false;
        this.mLottieJson = null;
        this.lottieComposition = null;
        this.lottieFile = null;
        this.assets = new HashMap<>();
        this.fonts = new HashMap<>();
        this.mSourceData = new HashMap();
        this.mDowngradeLevel = null;
        this.mRenderType = null;
        this.scene = null;
        this.animationFileLocalType = BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_DJANGOID;
        this.assetsImageDir = null;
        this.assetsAnimationPath = null;
        this.bizId = null;
        this.dynamicLayerEnable = false;
    }

    public LottieParams parseMap(Map<String, ?> map, String str) {
        if (map == null || map.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            sb.append("parse");
            sb.append(str);
            sb.append(":attrs is null.");
            GriverLogger.d(TAG, sb.toString());
            return this;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parse");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(map);
        GriverLogger.d(TAG, sb2.toString());
        insert2SourceData(map);
        this.animationFileLocalType = BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_DJANGOID;
        this.assetsImageDir = null;
        this.assetsAnimationPath = null;
        this.isAutoPlay = ParseUtils.getBoolean(map, "autoplay", this.isAutoPlay);
        this.mPath = GrayHelper.getReplaceDjangoId(ParseUtils.getString(map, "path", this.mPath));
        this.mSpeed = getFloat(map, KEY_SPEED, this.mSpeed);
        this.mRepeatCount = getInt(map, KEY_REPEAT_COUNT, this.mRepeatCount);
        this.mAutoReverse = ParseUtils.getBoolean(map, KEY_AUTO_REVERSE, this.mAutoReverse);
        this.mAssetsPath = ParseUtils.getString(map, KEY_ASSETS_PATH, this.mAssetsPath);
        String string = ParseUtils.getString(map, "placeholder", this.mPlaceholder);
        this.mPlaceholder = string;
        this.mDowngrade = ParseUtils.getString(map, KEY_DOWNGRADE, string);
        setDjangoId(GrayHelper.getReplaceDjangoId(ParseUtils.getString(map, KEY_DJANGO_ID, this.mDjangoId)));
        this.mMd5 = ParseUtils.getString(map, KEY_MD5, this.mMd5);
        this.mOptimize = ParseUtils.getBoolean(map, "optimize", this.mOptimize);
        this.mVariableLottie = ParseUtils.getBoolean(map, KEY_VARIABLE_LOTTIE, this.mVariableLottie);
        setLottieParams(ParseUtils.getVariableMap(map, KEY_VARIABLE_MAP));
        setLottieJson(ParseUtils.getString(map, KEY_LOTTIE_CONTENT, ""));
        this.mRenderType = ParseUtils.getString(map, KEY_RENDER_TYPE, LottieConstants.RENDER_TYPE_LOTTIE);
        this.mDowngradeLevel = ParseUtils.getString(map, KEY_DOWNGRADE_LEVEL, "");
        this.scene = ParseUtils.getString(map, "scene", (String) null);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("parse");
        sb3.append(str);
        sb3.append(": ");
        sb3.append(this);
        GriverLogger.d(TAG, sb3.toString());
        return this;
    }

    public LottieParams parseH5Bee(JSONObject jSONObject) {
        if (jSONObject == null) {
            GriverLogger.d(TAG, "parseH5Bee: json is null.");
            return this;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("parseH5Bee: ");
        sb.append(jSONObject);
        GriverLogger.d(TAG, sb.toString());
        insert2SourceData(jSONObject);
        this.animationFileLocalType = BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_DJANGOID;
        this.assetsImageDir = null;
        this.assetsAnimationPath = null;
        this.mElementId = ParseUtils.getString(jSONObject, KEY_ELEMENT_ID, this.mElementId);
        this.isAutoPlay = ParseUtils.getBoolean(jSONObject, "autoplay", this.isAutoPlay);
        this.mPath = GrayHelper.getReplaceDjangoId(ParseUtils.getString(jSONObject, "path", this.mPath));
        this.mSpeed = getFloat(jSONObject, KEY_SPEED, this.mSpeed);
        this.mRepeatCount = getInt(jSONObject, KEY_REPEAT_COUNT, this.mRepeatCount);
        this.mAutoReverse = ParseUtils.getBoolean(jSONObject, KEY_AUTO_REVERSE, this.mAutoReverse);
        this.mAssetsPath = ParseUtils.getString(jSONObject, KEY_ASSETS_PATH, this.mAssetsPath);
        String string = ParseUtils.getString(jSONObject, "placeholder", this.mPlaceholder);
        this.mPlaceholder = string;
        this.mDowngrade = ParseUtils.getString(jSONObject, KEY_DOWNGRADE, string);
        setDjangoId(GrayHelper.getReplaceDjangoId(ParseUtils.getString(jSONObject, KEY_DJANGO_ID, this.mDjangoId)));
        this.mMd5 = ParseUtils.getString(jSONObject, KEY_MD5, this.mMd5);
        this.mOptimize = ParseUtils.getBoolean(jSONObject, "optimize", this.mOptimize);
        this.mVariableLottie = ParseUtils.getBoolean(jSONObject, KEY_VARIABLE_LOTTIE, this.mVariableLottie);
        setLottieParams(ParseUtils.getVariableMap(jSONObject, KEY_VARIABLE_MAP));
        setLottieJson(ParseUtils.getString(jSONObject, KEY_LOTTIE_CONTENT, ""));
        this.mRenderType = ParseUtils.getString(jSONObject, KEY_RENDER_TYPE, LottieConstants.RENDER_TYPE_LOTTIE);
        this.mDowngradeLevel = ParseUtils.getString(jSONObject, KEY_DOWNGRADE_LEVEL, "");
        this.scene = ParseUtils.getString(jSONObject, "scene", (String) null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("parseH5Bee: ");
        sb2.append(this);
        GriverLogger.d(TAG, sb2.toString());
        return this;
    }

    private void insert2SourceData(Map<String, ?> map) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            try {
                this.mSourceData.put(entry.getKey(), String.valueOf(entry.getValue()));
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void insert2SourceData(JSONObject jSONObject) {
        try {
            for (Map.Entry entry : ((Map) JSONObject.toJavaObject(jSONObject, Map.class)).entrySet()) {
                try {
                    this.mSourceData.put(entry.getKey(), String.valueOf(entry.getValue()));
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
        }
    }

    public String getElementId() {
        String str = this.mElementId;
        return str == null ? "" : str;
    }

    public boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public String getPath() {
        String str = this.mPath;
        return str == null ? "" : str;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public int getRepeatCount() {
        return this.mRepeatCount;
    }

    public boolean isAutoReverse() {
        return this.mAutoReverse;
    }

    public String getAssetsPath() {
        if (TextUtils.isEmpty(this.mAssetsPath)) {
            return "";
        }
        if (!this.mAssetsPath.endsWith("/")) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.mAssetsPath);
            sb.append("/");
            this.mAssetsPath = sb.toString();
        }
        return this.mAssetsPath;
    }

    public String getPlaceholder() {
        String str = this.mPlaceholder;
        if (str == null) {
            str = "";
        }
        if (TextUtils.isEmpty(str)) {
            str = LottieHelper.getLocalPlaceHolderFilePath(getDjangoId());
        }
        return (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.assetsImageDir)) ? str : LottieHelper.getAssetPlaceHolderFilePath(this.assetsImageDir);
    }

    public boolean canDowngrade() {
        return !TextUtils.isEmpty(getDowngrade());
    }

    public String getDowngrade() {
        String str = TextUtils.isEmpty(this.mDowngrade) ? this.mPlaceholder : this.mDowngrade;
        if (TextUtils.isEmpty(str)) {
            str = LottieHelper.getLocalDowngradeFilePath(getDjangoId());
        }
        return (!TextUtils.isEmpty(str) || TextUtils.isEmpty(this.assetsImageDir)) ? str : LottieHelper.getAssetDowngradeFilePath(this.assetsImageDir);
    }

    public String getDjangoId() {
        String str = this.mDjangoId;
        return str == null ? "" : str;
    }

    public String getMd5() {
        String str = this.mMd5;
        return str == null ? "" : str;
    }

    public boolean isOptimize() {
        return this.mOptimize;
    }

    public boolean isVariableLottie() {
        return this.mVariableLottie;
    }

    public String getLottieJson() {
        return this.mLottieJson;
    }

    public File getLottieFile() {
        return this.lottieFile;
    }

    public HashMap<String, AbstractLottieAsset> getAssets() {
        return this.assets;
    }

    public HashMap<String, Typeface> getFonts() {
        return this.fonts;
    }

    public Map<String, String> getSourceData() {
        if (this.mSourceData == null) {
            this.mSourceData = new ConcurrentHashMap();
        }
        return this.mSourceData;
    }

    public Map<String, String> getLottieParams() {
        return this.mLottieParams;
    }

    public String getRenderType() {
        return this.mRenderType;
    }

    public String getDowngradeLevel() {
        return this.mDowngradeLevel;
    }

    public void setDowngradeLevel(String str) {
        this.mDowngradeLevel = str;
        getSourceData().put(KEY_DOWNGRADE_LEVEL, str);
    }

    public void setRenderType(String str) {
        this.mRenderType = str;
        getSourceData().put(KEY_RENDER_TYPE, str);
    }

    public void setElementId(String str) {
        this.mElementId = str;
    }

    public void setAutoPlay(boolean z) {
        this.isAutoPlay = z;
        getSourceData().put("autoplay", String.valueOf(z));
    }

    public void setPath(String str) {
        this.mPath = str;
    }

    public void setSpeed(float f) {
        this.mSpeed = f;
        getSourceData().put(KEY_SPEED, String.valueOf(f));
    }

    public void setRepeatCount(int i) {
        this.mRepeatCount = i;
        getSourceData().put(KEY_REPEAT_COUNT, String.valueOf(i));
    }

    public void setAutoReverse(boolean z) {
        this.mAutoReverse = z;
    }

    public void setAssetsPath(String str) {
        this.mAssetsPath = str;
        getSourceData().put(KEY_ASSETS_PATH, str);
    }

    public void setPlaceholder(String str) {
        this.mPlaceholder = str;
        getSourceData().put("placeholder", str);
    }

    public void setDowngrade(String str) {
        this.mDowngrade = str;
    }

    public void setDjangoId(String str) {
        this.mDjangoId = str;
        if (!TextUtils.isEmpty(str) && str.startsWith("file:///[asset]/")) {
            this.mDjangoId = "";
            String substring = str.substring(16);
            setAssetsAnimationPath(substring);
            setAnimationFileLocalType(BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_ASSETS);
            if (!substring.endsWith(".json")) {
                setAssetsImageDir(substring);
            } else {
                setAssetsImageDir(substring.substring(0, substring.lastIndexOf("/")));
            }
        } else {
            setAssetsAnimationPath(null);
            setAssetsImageDir(null);
            setAnimationFileLocalType(BeeLottiePlayerBuilder.FILE_LOCAL_TYPE_DJANGOID);
        }
        getSourceData().put(KEY_DJANGO_ID, str);
    }

    public void setMd5(String str) {
        this.mMd5 = str;
    }

    public void setOptimize(boolean z) {
        this.mOptimize = z;
        getSourceData().put("optimize", String.valueOf(z));
    }

    public void setLottieJson(String str) {
        if (this.lottieComposition != null && !StringUtils.equal(this.mLottieJson, str)) {
            setLottieComposition(null);
        }
        setFrames(null);
        this.mLottieJson = str;
    }

    public void setLottieFile(File file) {
        this.lottieFile = file;
    }

    public void setAssets(HashMap<String, AbstractLottieAsset> hashMap) {
        this.assets = hashMap;
    }

    public void setLottieParams(Map<String, String> map) {
        this.mLottieParams = map;
        if (map != null && !map.isEmpty()) {
            for (Map.Entry<String, String> entry : this.mLottieParams.entrySet()) {
                String value = entry.getValue();
                if ("${DINPRO_FONT_PATH}".equals(value)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("file:///[asset]/");
                    sb.append(NumberFontUtilAdapter.getDINProTtfPath());
                    entry.setValue(sb.toString());
                } else if ("${DINPRO_FONT_NAME}".equals(value)) {
                    entry.setValue(NumberFontUtilAdapter.DIN_PRO_FILE_NAME);
                } else if ("${ALIPAY_NUM_FONT_PATH}".equals(value)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("file:///[asset]/");
                    sb2.append(NumberFontUtilAdapter.getAlipayNumberTtfPath());
                    entry.setValue(sb2.toString());
                } else if ("${ALIPAY_NUM_FONT_NAME}".equals(value)) {
                    entry.setValue(NumberFontUtilAdapter.AMOUNT_NUM_FILE_NAME);
                }
            }
        }
        getSourceData().put(KEY_VARIABLE_MAP, String.valueOf(map));
    }

    public void setVariableLottie(boolean z) {
        this.mVariableLottie = z;
        getSourceData().put(KEY_VARIABLE_LOTTIE, String.valueOf(z));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{mElementId: ");
        sb.append(this.mElementId);
        sb.append(", isAutoPlay: ");
        sb.append(this.isAutoPlay);
        sb.append(", mPath: ");
        sb.append(this.mPath);
        sb.append(", mSpeed: ");
        sb.append(this.mSpeed);
        sb.append(", mRepeatCount: ");
        sb.append(this.mRepeatCount);
        sb.append(", mAutoReverse: ");
        sb.append(this.mAutoReverse);
        sb.append(", mAssetsPath: ");
        sb.append(this.mAssetsPath);
        sb.append(", mPlaceholder: ");
        sb.append(this.mPlaceholder);
        sb.append(", mDjangoId: ");
        sb.append(this.mDjangoId);
        sb.append(", mMd5: ");
        sb.append(this.mMd5);
        sb.append(", mOptimize: ");
        sb.append(this.mOptimize);
        sb.append(", mVariableLottie: ");
        sb.append(this.mVariableLottie);
        sb.append(", mRenderType: ");
        sb.append(this.mRenderType);
        sb.append(", mSourceData: ");
        sb.append(this.mSourceData);
        sb.append("}@");
        try {
            Object[] objArr = {this};
            byte b = (byte) (BuiltInFictitiousFunctionClassFactory[5] + 1);
            Object[] objArr2 = new Object[1];
            a(b, b, (byte) (-BuiltInFictitiousFunctionClassFactory[5]), objArr2);
            Class<?> cls = Class.forName((String) objArr2[0]);
            byte b2 = (byte) (-BuiltInFictitiousFunctionClassFactory[5]);
            byte b3 = (byte) (b2 - 1);
            Object[] objArr3 = new Object[1];
            a(b2, b3, b3, objArr3);
            sb.append(((Integer) cls.getMethod((String) objArr3[0], Object.class).invoke(null, objArr)).intValue());
            return sb.toString();
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause != null) {
                throw cause;
            }
            throw th;
        }
    }

    public void setLottieComposition(LottieComposition lottieComposition) {
        this.lottieComposition = lottieComposition;
    }

    public LottieComposition getLottieComposition() {
        return this.lottieComposition;
    }

    public void setupLottieJsonWithVariableParams() {
        setLottieJson(LottieHelper.replaceLottieStringWithParams(this.mLottieJson, this.mLottieParams));
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public void setFps(int i) {
        this.fps = i;
    }

    public void setFrames(List<String> list) {
        this.frames = list;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public int getFps() {
        return this.fps;
    }

    public List<String> getFrames() {
        return this.frames;
    }

    public String getScene() {
        return this.scene;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public void setAnimationFileLocalType(String str) {
        this.animationFileLocalType = str;
    }

    public String getAnimationFileLocalType() {
        return this.animationFileLocalType;
    }

    public void setAssetsImageDir(String str) {
        this.assetsImageDir = str;
    }

    public String getAssetsImageDir() {
        return this.assetsImageDir;
    }

    /* loaded from: classes6.dex */
    public static class Asset extends AbstractLottieAsset {
        private static final String TAG = "DefaultLottieAsset";
        private Bitmap mBitmap;
        private byte[] mBytes;

        public Asset(byte[] bArr) {
            if (bArr == null || bArr.length == 0) {
                GriverLogger.e(TAG, "bytes is null");
            } else {
                this.mBytes = bArr;
            }
        }

        public Asset(InputStream inputStream) {
            this(LottieParams.is2Bytes(inputStream));
        }

        @Override // com.alibaba.griver.beehive.lottie.player.AbstractLottieAsset
        public Bitmap getBitmap() {
            Bitmap bitmap = this.mBitmap;
            if (bitmap == null || bitmap.isRecycled()) {
                byte[] bArr = this.mBytes;
                if (bArr == null || bArr.length == 0) {
                    GriverLogger.e(TAG, "fetchBitmap failed: bytes is null");
                    return null;
                }
                Bitmap bitmap2 = this.mBitmap;
                if (bitmap2 == null || bitmap2.isRecycled()) {
                    APDecodeResultAdapter decodeBitmap = MultimediaServiceAdapter.decodeBitmap(this.mBytes);
                    if (decodeBitmap != null && decodeBitmap.isSuccess()) {
                        this.mBitmap = decodeBitmap.bitmap;
                    }
                    if (this.mBitmap == null) {
                        GriverLogger.d(TAG, "decode bitmap failed.");
                    }
                }
                return this.mBitmap;
            }
            return this.mBitmap;
        }

        @Override // com.alibaba.griver.beehive.lottie.player.AbstractLottieAsset
        public void destory() {
            Bitmap bitmap;
            if (!SummaryActivity.CHECKED.equals(SwitchConfigUtilsAdapter.getConfigValue("LottiePlayer_recycle_bitmap_rollback")) && (bitmap = this.mBitmap) != null && !bitmap.isRecycled()) {
                this.mBitmap.recycle();
            }
            this.mBitmap = null;
            this.mBytes = null;
        }
    }

    public static byte[] is2Bytes(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
        } catch (IOException unused) {
            byteArrayOutputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = inputStream.read(bArr, 0, 8192);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException unused3) {
            }
            return byteArray;
        } catch (IOException unused4) {
            try {
                inputStream.close();
            } catch (IOException unused5) {
            }
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused6) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream2 = byteArrayOutputStream;
            try {
                inputStream.close();
            } catch (IOException unused7) {
            }
            if (byteArrayOutputStream2 != null) {
                try {
                    byteArrayOutputStream2.close();
                    throw th;
                } catch (IOException unused8) {
                    throw th;
                }
            }
            throw th;
        }
    }

    public String getAssetsAnimationPath() {
        return this.assetsAnimationPath;
    }

    public LottieParams setAssetsAnimationPath(String str) {
        this.assetsAnimationPath = str;
        getSourceData().put("localPath", str);
        return this;
    }

    public int getInt(JSONObject jSONObject, String str, int i) {
        return ParseUtils.getInt(jSONObject, str, i);
    }

    public static float getFloat(JSONObject jSONObject, String str, float f) {
        return ParseUtils.getFloat(jSONObject, str, f);
    }

    public int getInt(Map<String, ?> map, String str, int i) {
        return ParseUtils.getInt(map, str, i);
    }

    public static float getFloat(Map<String, ?> map, String str, float f) {
        return ParseUtils.getFloat(map, str, f);
    }

    public void setBizId(String str) {
        this.bizId = str;
    }

    public String getBizId() {
        return this.bizId;
    }

    public boolean getDynamicLayerEnable() {
        return this.dynamicLayerEnable;
    }

    public void setDynamicLayerEnable(boolean z) {
        this.dynamicLayerEnable = z;
    }

    public String getResourceId() {
        return SceneUtils.getResourceId(getDjangoId(), getPath(), getAssetsAnimationPath());
    }

    public String getPreviewSchema() {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(this.mPath)) {
            sb.append("path=");
        } else {
            sb.append("djangoId=");
        }
        sb.append(getResourceId());
        if (isVariableLottie()) {
            sb.append("&variableLottie=true");
        }
        Map<String, String> map = this.mLottieParams;
        if (map != null && !map.isEmpty()) {
            sb.append("&variableMap=");
            sb.append(JSONObject.toJSONString(this.mLottieParams));
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("alipays://platformapi/startapp?appId=2019043064371585&page=pages%2Flottie%2Fpreview%2Fpreview&query=");
        sb2.append(URLEncoder.encode(sb.toString()));
        return sb2.toString();
    }

    public List<DynamicLayerModel> getDynamicLayerModelList() {
        return this.dynamicLayerModelList;
    }

    public void setDynamicLayerModelList(List<DynamicLayerModel> list) {
        this.dynamicLayerModelList = list;
        this.dynamicLayerEnable = list != null && list.size() > 0;
    }
}
