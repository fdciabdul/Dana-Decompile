package com.apiguard3.internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.media.AudioTrack;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alibaba.ariver.engine.common.track.recovery.DeepRecoverARiverProxy;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.wireless.security.SecExceptionCode;
import com.alipay.mobile.security.bio.api.BioError;
import com.apiguard3.internal.ConfigInstance;
import com.google.common.base.Ascii;
import com.google.firebase.FirebaseError;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import id.dana.data.here.HereOauthManager;
import java.nio.ByteBuffer;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public final class writeReplace {

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'values' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class getSharedInstance implements ConfigInstance.ConfigSerializationProxy.AGState {
        public static final getSharedInstance AGState;
        public static final getSharedInstance APIGuard;
        public static final getSharedInstance APIGuard$Callback;
        public static final getSharedInstance APIGuard$InitializationCallback;
        public static final getSharedInstance AnalysesEntry;
        public static final getSharedInstance BHT;
        public static final getSharedInstance BuildConfig;
        private static getSharedInstance C = null;
        public static final getSharedInstance Config;
        private static int D = 1;
        public static final getSharedInstance FraudScore;
        @Deprecated
        private static getSharedInstance SConfig;
        public static final getSharedInstance ScoredEntry;
        private static char am;
        public static final getSharedInstance analyzeResponse;
        @Deprecated
        private static getSharedInstance ce;
        private static char cf;
        public static final getSharedInstance checkCertificates;
        public static final getSharedInstance clearCallback;

        /* renamed from: de  reason: collision with root package name */
        private static long f7416de;
        private static int gc;
        public static final getSharedInstance generateHeaders;
        public static final getSharedInstance getRequestHeaders;
        public static final getSharedInstance getSharedInstance;
        public static final getSharedInstance getState;
        public static final getSharedInstance getVersion;
        private static char[] gt;
        public static final getSharedInstance initialize;
        public static final getSharedInstance log;
        public static final getSharedInstance onInitializationFailure;
        public static final getSharedInstance onInitializationSuccess;
        public static final getSharedInstance parseResponseHeaders;
        public static final getSharedInstance pushMaxPayload;
        public static final getSharedInstance pushMinPayload;
        private static final /* synthetic */ getSharedInstance[] rf;
        private static char rm;
        public static final getSharedInstance send;
        private static char ss;
        public static final getSharedInstance updateKernel;
        public static final getSharedInstance valueOf;
        public static final getSharedInstance values;
        private String code;

        static void APIGuard() {
            cf = (char) 24013;
            ss = (char) 42064;
            am = (char) 32278;
            rm = (char) 25733;
            f7416de = -3069001172844999823L;
            gt = new char[]{62098, 63892, 'B', 2878, 5798, 8714, 11675, 14708, 17636, 20548, 23501, 26295, 29246, 32132, 35081, 38127, 41084, 43968, 46941, 49874, 52661, 'E', 2889, 27523, 24819, 32123, 18881, 17991, 21181, 12095, 15245, 12298, 3430, 6636, 5705, 58068, 65314, 52143, 49165, 56472, 43294, 42605, 45809, 36692, 39899, 36924, 44835, 42022, 47542, 'C', 2878, 5804, 8725, 11661, 14706, 17657, 20565, 23492, 26294, 29225, 32144, 35091, 38123, 41067, 43981, 46915, 49864, 52669, 55597, 58507, 61451, 64505, 1907, 4807, 7770, 10543, 13499, 16396, 19330, 22380, 25339, 28261, 31189, 'E', 2880, 5841, 'E', 2883, 5847, 55893, 53546, 52398, 63491, 63391, 58215, 40679, 35405, 33241, 48304, 43066, 42889, 21277, 20194, 31348, 29150, 27976, 6366, 6053, 817, 16015, 10783, 'E', 2883, 5844, 385, 2694, 5911, 36311, 34465, 39722, 44940, 40982, 46306, 51580, 56790, 54869, 60200, 65466, 61443, 1179, 6500, 11759, 9815, 15055, 20307, 16441, 21688, 28686, 31497, 26268, 25774, 28585, 29247, 'E', 2882, 5845, 18074, 19962, 20593, 25813, 27457, 32702, 552, 5762, 7427, 8311, 13540, 15192, 53202, 53822, 59051, 60699, 61829, 33805, 35705, 40928, 41554, 46810, 48430, 16808, 64059, 61789, 60622, 55394, 55272, 49940, 48785, 43559, 41376, 40134, 34904, 34796, 29558, 28316, 23045, 20913, 19754, 14526, 14296, 9048, 7925, 2670, 410, 64789, 59577, 58426, 54085, 52933, 47741, 45560, 44293, 39048, 'E', 2885, 5846, 21996, 24223, 17153, 30640, 30761, 27867, 4426, 1523, 3704, 13074, 10124, 10279, 56499, 49491, 62933, 65139, 58103, 38769, 38939, 35981, 45362, 42406, 44636, 21196, 61444, 64354, 59134, 53851, 56797, 51501, 46245, 40991, 43917, 38635, 33404, 36296, 31042, 25781, 20525, 23431, 18200, 12946, 15840, 10615, 5324, '@', 2976, 63268, 57994, 'E', 2884, 5851, 'S', 2869, 5801, 8716, 11658, 14714, 17650, 20552, 23514, 26300, 29227, 32159, 35093, 38114, 41082, 43984, 46927, 49873, 52659, 55601, 58503, 61440, 64489, 1909, 4829, 7770, 10538, 13476, 16402, 19358, 22395, 'N', 2852, 5806, 8735, 11675, 14695, 17635, 20550, 23517, 26300, 29241, 32143, 35091, 38130, 41068, 43989, 46933, 49858, 52646, 55612, 58525, 61451, 64489, 1907, 4810, 7752, 10548, 13496, 16410, 19330, 22380, 25314, 28287, 31171, 34119, 36898, 39857, 42768, 45717, 48739, 'E', 2887, 5843, 2714, 496, 7290, 10443, 10063, 13235, 20023, 23184, 20748, 27746, 30960, 30556, 33757, 40502, 43701, 41225, 48526, 51216, 51045, 54243, 61023, 64216, 61740, 3500, 6172, 5276, 9212, 15980, 19149, 16710, 23992, 26686, 25767, 29461, 36761, 39657, 37219, 44484, 'E', 2887, 5840, 19007, 16729, 23749, 26720, 26593, 29463, 3715, 6703, 4517, 11481, 14415, 14317, 50017, 56965, 59915, 57788, 64818, 34994, 34776, 37710, 44785, 47717, 45471, 19727, 51180, 52375, 53515, 58798, 59954, 65238, 33603, 38890, 40036, 41236, 46492, 47654, 20143, 21321, 26573, 27764, 28926, 1378, 2578, 7821, 9011, 52378, 51197, 55833};
        }

        public static getSharedInstance valueOf(String str) {
            int i = D + 5;
            gc = i % 128;
            boolean z = i % 2 == 0;
            getSharedInstance getsharedinstance = (getSharedInstance) Enum.valueOf(getSharedInstance.class, str);
            if (z) {
                return getsharedinstance;
            }
            throw new ArithmeticException();
        }

        public static getSharedInstance[] values() {
            int i = gc + 1;
            D = i % 128;
            if (!(i % 2 != 0)) {
                getSharedInstance[] getsharedinstanceArr = (getSharedInstance[]) rf.clone();
                throw null;
            }
            getSharedInstance[] getsharedinstanceArr2 = (getSharedInstance[]) rf.clone();
            int i2 = gc + 67;
            D = i2 % 128;
            if ((i2 % 2 == 0 ? 'W' : '3') != 'W') {
                return getsharedinstanceArr2;
            }
            throw null;
        }

        static {
            APIGuard();
            Object[] objArr = new Object[1];
            AGState("䩶蹲︂\ueb13振玉懋땽軨⸨\u0ebe뽆Ꮲ̆酌\ue7fe獙䒸\uf377⬡絙볨⤼뉈陕盿\uf377⬡툺ᢸ", TextUtils.getOffsetBefore("", 0) + 30, objArr);
            String intern = ((String) objArr[0]).intern();
            Object[] objArr2 = new Object[1];
            AGState("\uf485鐋", (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 1, objArr2);
            getSharedInstance getsharedinstance = new getSharedInstance(intern, 0, ((String) objArr2[0]).intern());
            values = getsharedinstance;
            Object[] objArr3 = new Object[1];
            AGState("貗Ⴎ\u0ebe뽆쓲ꁢ澫勛\udf79ሗ\udd10ﹰꖋ滤롉ᦴ\udb8b혾\uf877텪", 19 - KeyEvent.getDeadChar(0, 0), objArr3);
            String intern2 = ((String) objArr3[0]).intern();
            Object[] objArr4 = new Object[1];
            values((char) ((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 62167), 2 - View.resolveSize(0, 0), 1 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr4);
            getSharedInstance getsharedinstance2 = new getSharedInstance(intern2, 1, ((String) objArr4[0]).intern());
            AGState = getsharedinstance2;
            Object[] objArr5 = new Object[1];
            AGState("ꖋ滤貗Ⴎ䕀㋎\uf083弹澫勛瘄쟙ｺვሰ䒆ᱠᜨ旳ᓡ", 20 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr5);
            String intern3 = ((String) objArr5[0]).intern();
            Object[] objArr6 = new Object[1];
            AGState("ৠ\uf06f", 2 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr6);
            getSharedInstance getsharedinstance3 = new getSharedInstance(intern3, 2, ((String) objArr6[0]).intern());
            getSharedInstance = getsharedinstance3;
            Object[] objArr7 = new Object[1];
            AGState("ᚽ\ua4c7﹩箍坊묨姅ꏊ夻\ueaf3梵囮䕀㋎\uf377⬡툺ᢸ", 17 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr7);
            String intern4 = ((String) objArr7[0]).intern();
            Object[] objArr8 = new Object[1];
            AGState("\uea1cꮷ", Color.blue(0) + 2, objArr8);
            getSharedInstance getsharedinstance4 = new getSharedInstance(intern4, 3, ((String) objArr8[0]).intern());
            valueOf = getsharedinstance4;
            Object[] objArr9 = new Object[1];
            values((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), Drawable.resolveOpacity(0, 0) + 19, 2 - TextUtils.getCapsMode("", 0, 0), objArr9);
            String intern5 = ((String) objArr9[0]).intern();
            Object[] objArr10 = new Object[1];
            AGState("鱔᜔", 2 - View.MeasureSpec.getMode(0), objArr10);
            getSharedInstance getsharedinstance5 = new getSharedInstance(intern5, 4, ((String) objArr10[0]).intern());
            APIGuard = getsharedinstance5;
            Object[] objArr11 = new Object[1];
            AGState("㐌轭뚄\uf5b4\ued46ߔᏢ̆좋咅㑢貯陕盿냜ɷ梵囮䕀㋎\uf377⬡툺ᢸ", 24 - ExpandableListView.getPackedPositionType(0L), objArr11);
            String intern6 = ((String) objArr11[0]).intern();
            Object[] objArr12 = new Object[1];
            AGState("⎞퉦", View.MeasureSpec.getSize(0) + 2, objArr12);
            getSharedInstance getsharedinstance6 = new getSharedInstance(intern6, 5, ((String) objArr12[0]).intern());
            generateHeaders = getsharedinstance6;
            Object[] objArr13 = new Object[1];
            AGState("ᚽ\ua4c7쇇㽿跕한﹩箍Ꮲ̆鳇텺\udb8b혾\uf877텪", KeyEvent.normalizeMetaState(0) + 15, objArr13);
            String intern7 = ((String) objArr13[0]).intern();
            Object[] objArr14 = new Object[1];
            values((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), TextUtils.indexOf((CharSequence) "", '0', 0) + 3, (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 20, objArr14);
            getSharedInstance getsharedinstance7 = new getSharedInstance(intern7, 6, ((String) objArr14[0]).intern());
            analyzeResponse = getsharedinstance7;
            Object[] objArr15 = new Object[1];
            values((char) (27596 - ExpandableListView.getPackedPositionChild(0L)), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 23, (KeyEvent.getMaxKeyCode() >> 16) + 23, objArr15);
            String intern8 = ((String) objArr15[0]).intern();
            Object[] objArr16 = new Object[1];
            AGState("\udadb⻰", 3 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr16);
            getSharedInstance getsharedinstance8 = new getSharedInstance(intern8, 7, ((String) objArr16[0]).intern());
            initialize = getsharedinstance8;
            Object[] objArr17 = new Object[1];
            AGState("貗Ⴎ\uf406뇴牔鈮▨䖧焐轕懋땽耒팿Ꮲ̆⤼뉈跕한\uf377⬡絙볨⤼뉈陕盿", 28 - KeyEvent.normalizeMetaState(0), objArr17);
            String intern9 = ((String) objArr17[0]).intern();
            Object[] objArr18 = new Object[1];
            values((char) (44902 - TextUtils.getCapsMode("", 0, 0)), 3 - View.combineMeasuredStates(0, 0), MotionEvent.axisFromString("") + 47, objArr18);
            SConfig = new getSharedInstance(intern9, 8, ((String) objArr18[0]).intern());
            Object[] objArr19 = new Object[1];
            values((char) (ExpandableListView.getPackedPositionChild(0L) + 1), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 33, 49 - TextUtils.indexOf("", ""), objArr19);
            String intern10 = ((String) objArr19[0]).intern();
            Object[] objArr20 = new Object[1];
            values((char) ((Process.getThreadPriority(0) + 20) >> 6), 3 - TextUtils.getCapsMode("", 0, 0), Process.getGidForName("") + 84, objArr20);
            ce = new getSharedInstance(intern10, 9, ((String) objArr20[0]).intern());
            Object[] objArr21 = new Object[1];
            AGState("ꖋ滤䩹⻨䭎㽀⟢䰚ꖋ滤↫宗괍旊麌枟땪\uf1ab認ᵰ", (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 18, objArr21);
            String intern11 = ((String) objArr21[0]).intern();
            Object[] objArr22 = new Object[1];
            values((char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 3, 86 - (Process.myPid() >> 22), objArr22);
            C = new getSharedInstance(intern11, 10, ((String) objArr22[0]).intern());
            Object[] objArr23 = new Object[1];
            values((char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 55839), 22 - TextUtils.getOffsetAfter("", 0), 90 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr23);
            String intern12 = ((String) objArr23[0]).intern();
            Object[] objArr24 = new Object[1];
            values((char) (ViewConfiguration.getJumpTapTimeout() >> 16), 3 - Color.alpha(0), 111 - ExpandableListView.getPackedPositionType(0L), objArr24);
            getSharedInstance getsharedinstance9 = new getSharedInstance(intern12, 11, ((String) objArr24[0]).intern());
            parseResponseHeaders = getsharedinstance9;
            Object[] objArr25 = new Object[1];
            AGState("ꖋ滤䩹⻨䭎㽀⟢䰚貗Ⴎ\uf406뇴牔鈮▨䖧킬张꒰ⶸ", Color.argb(0, 0, 0, 0) + 19, objArr25);
            String intern13 = ((String) objArr25[0]).intern();
            Object[] objArr26 = new Object[1];
            AGState("笺\udc5e먍퉷", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 2, objArr26);
            getSharedInstance getsharedinstance10 = new getSharedInstance(intern13, 12, ((String) objArr26[0]).intern());
            getRequestHeaders = getsharedinstance10;
            Object[] objArr27 = new Object[1];
            AGState("⼐\uecfa\uf751䣦쌉영藡䳉\u0eceᡐ⥁뇔酌\ue7fe候䲱\uedd0攁", 18 - (ViewConfiguration.getEdgeSlop() >> 16), objArr27);
            String intern14 = ((String) objArr27[0]).intern();
            Object[] objArr28 = new Object[1];
            AGState("ৠ\uf06f붙鷤", 3 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr28);
            getSharedInstance getsharedinstance11 = new getSharedInstance(intern14, 13, ((String) objArr28[0]).intern());
            checkCertificates = getsharedinstance11;
            Object[] objArr29 = new Object[1];
            AGState("振玉坊묨칯藜Ꮲ̆␆镩奜\ue451ꖋ滤↫宗但녶ᤑﱏ㑢貯\ueb56瀎", 22 - Process.getGidForName(""), objArr29);
            String intern15 = ((String) objArr29[0]).intern();
            Object[] objArr30 = new Object[1];
            values((char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 453), (Process.myPid() >> 22) + 3, 113 - ExpandableListView.getPackedPositionChild(0L), objArr30);
            getSharedInstance getsharedinstance12 = new getSharedInstance(intern15, 14, ((String) objArr30[0]).intern());
            updateKernel = getsharedinstance12;
            Object[] objArr31 = new Object[1];
            values((char) (36254 - Color.blue(0)), 20 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 116 - TextUtils.indexOf((CharSequence) "", '0'), objArr31);
            String intern16 = ((String) objArr31[0]).intern();
            Object[] objArr32 = new Object[1];
            AGState("ৠ\uf06f鶗좭", 3 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr32);
            getSharedInstance getsharedinstance13 = new getSharedInstance(intern16, 15, ((String) objArr32[0]).intern());
            APIGuard$Callback = getsharedinstance13;
            Object[] objArr33 = new Object[1];
            AGState("ǀ劖ﻰ橧䭎㽀삗\ud7fdⷱͅꪏ礑焐轕ؤ\uedc8但녶ᤑﱏ膙豁夻\ueaf3", 25 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr33);
            String intern17 = ((String) objArr33[0]).intern();
            Object[] objArr34 = new Object[1];
            values((char) (((Process.getThreadPriority(0) + 20) >> 6) + 28747), 3 - KeyEvent.normalizeMetaState(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 137, objArr34);
            getSharedInstance getsharedinstance14 = new getSharedInstance(intern17, 16, ((String) objArr34[0]).intern());
            log = getsharedinstance14;
            Object[] objArr35 = new Object[1];
            AGState("\uec73ԣ猀\ue2c3絙볨ሰ䒆⟢䰚⼐\uecfa\uf751䣦쌉영梵囮㫲쫛䬧㈍酌\ue7fe候䲱\uedd0攁괍旊﹩箍焐轕ؤ\uedc8", 36 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr35);
            String intern18 = ((String) objArr35[0]).intern();
            Object[] objArr36 = new Object[1];
            values((char) (View.MeasureSpec.getMode(0) + 25835), ExpandableListView.getPackedPositionGroup(0L) + 3, (-16777076) - Color.rgb(0, 0, 0), objArr36);
            getSharedInstance getsharedinstance15 = new getSharedInstance(intern18, 17, ((String) objArr36[0]).intern());
            getState = getsharedinstance15;
            Object[] objArr37 = new Object[1];
            AGState("埏챴\uf356돌⩌퐩藡䳉牔鈮埏챴奜\ue451ؤ\uedc8ᇟඍ\uf356돌跕한但녶ᤑﱏ膙豁夻\ueaf3", 30 - (ViewConfiguration.getPressedStateDuration() >> 16), objArr37);
            String intern19 = ((String) objArr37[0]).intern();
            Object[] objArr38 = new Object[1];
            values((char) View.resolveSize(0, 0), 3 - (ViewConfiguration.getScrollBarSize() >> 8), 143 - ExpandableListView.getPackedPositionGroup(0L), objArr38);
            getSharedInstance getsharedinstance16 = new getSharedInstance(intern19, 18, ((String) objArr38[0]).intern());
            BuildConfig = getsharedinstance16;
            Object[] objArr39 = new Object[1];
            values((char) (18122 - View.MeasureSpec.getSize(0)), 24 - TextUtils.indexOf("", "", 0, 0), 145 - Process.getGidForName(""), objArr39);
            String intern20 = ((String) objArr39[0]).intern();
            Object[] objArr40 = new Object[1];
            AGState("ৠ\uf06f㜐\uee30", (ViewConfiguration.getTapTimeout() >> 16) + 3, objArr40);
            getSharedInstance getsharedinstance17 = new getSharedInstance(intern20, 19, ((String) objArr40[0]).intern());
            pushMinPayload = getsharedinstance17;
            Object[] objArr41 = new Object[1];
            AGState("Ꮲ̆밸腂鳇텺夻\ueaf3ؤ\uedc8ꖋ滤롉ᦴ瘄쟙ｺვሰ䒆ᱠᜨ旳ᓡ\uf377⬡ᖹ拗", TextUtils.lastIndexOf("", '0', 0) + 29, objArr41);
            String intern21 = ((String) objArr41[0]).intern();
            Object[] objArr42 = new Object[1];
            AGState("㲥\ue426붙鷤", (ViewConfiguration.getLongPressTimeout() >> 16) + 3, objArr42);
            getSharedInstance getsharedinstance18 = new getSharedInstance(intern21, 20, ((String) objArr42[0]).intern());
            onInitializationFailure = getsharedinstance18;
            Object[] objArr43 = new Object[1];
            values((char) (KeyEvent.keyCodeFromString("") + 64126), TextUtils.indexOf("", "", 0) + 32, View.MeasureSpec.makeMeasureSpec(0, 0) + 170, objArr43);
            String intern22 = ((String) objArr43[0]).intern();
            Object[] objArr44 = new Object[1];
            AGState("㲥\ue426鶗좭", 3 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr44);
            getSharedInstance getsharedinstance19 = new getSharedInstance(intern22, 21, ((String) objArr44[0]).intern());
            onInitializationSuccess = getsharedinstance19;
            Object[] objArr45 = new Object[1];
            AGState("Ꮲ̆밸腂鳇텺챗鐗㔛פּխ蓇᧗乢⟢䰚恟ﱳ\uea03\ue2a0", ((Process.getThreadPriority(0) + 20) >> 6) + 19, objArr45);
            String intern23 = ((String) objArr45[0]).intern();
            Object[] objArr46 = new Object[1];
            values((char) (ViewConfiguration.getEdgeSlop() >> 16), KeyEvent.normalizeMetaState(0) + 3, 202 - KeyEvent.getDeadChar(0, 0), objArr46);
            getSharedInstance getsharedinstance20 = new getSharedInstance(intern23, 22, ((String) objArr46[0]).intern());
            APIGuard$InitializationCallback = getsharedinstance20;
            Object[] objArr47 = new Object[1];
            values((char) (21936 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), TextUtils.lastIndexOf("", '0', 0) + 25, 206 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr47);
            String intern24 = ((String) objArr47[0]).intern();
            Object[] objArr48 = new Object[1];
            AGState("\uea1cꮷ㜐\uee30", TextUtils.getCapsMode("", 0, 0) + 3, objArr48);
            getSharedInstance getsharedinstance21 = new getSharedInstance(intern24, 23, ((String) objArr48[0]).intern());
            pushMaxPayload = getsharedinstance21;
            Object[] objArr49 = new Object[1];
            values((char) (61527 - (ViewConfiguration.getTapTimeout() >> 16)), (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 26, (Process.myTid() >> 22) + 229, objArr49);
            String intern25 = ((String) objArr49[0]).intern();
            Object[] objArr50 = new Object[1];
            values((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 1), 3 - View.MeasureSpec.getSize(0), 254 - (KeyEvent.getMaxKeyCode() >> 16), objArr50);
            getSharedInstance getsharedinstance22 = new getSharedInstance(intern25, 24, ((String) objArr50[0]).intern());
            clearCallback = getsharedinstance22;
            Object[] objArr51 = new Object[1];
            values((char) Color.blue(0), 31 - Color.alpha(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + DeepRecoverARiverProxy.TYPE_ENTITY_APP, objArr51);
            String intern26 = ((String) objArr51[0]).intern();
            Object[] objArr52 = new Object[1];
            AGState("鱔᜔붙鷤", 3 - View.resolveSize(0, 0), objArr52);
            getSharedInstance getsharedinstance23 = new getSharedInstance(intern26, 25, ((String) objArr52[0]).intern());
            getVersion = getsharedinstance23;
            Object[] objArr53 = new Object[1];
            values((char) (ViewConfiguration.getWindowTouchSlop() >> 8), (ViewConfiguration.getScrollBarSize() >> 8) + 40, 288 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr53);
            String intern27 = ((String) objArr53[0]).intern();
            Object[] objArr54 = new Object[1];
            values((char) ((-1) - ImageFormat.getBitsPerPixel(0)), 3 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 328 - (ViewConfiguration.getEdgeSlop() >> 16), objArr54);
            getSharedInstance getsharedinstance24 = new getSharedInstance(intern27, 26, ((String) objArr54[0]).intern());
            send = getsharedinstance24;
            Object[] objArr55 = new Object[1];
            values((char) ((ViewConfiguration.getScrollBarSize() >> 8) + 2772), 38 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 331 - TextUtils.indexOf("", "", 0, 0), objArr55);
            String intern28 = ((String) objArr55[0]).intern();
            Object[] objArr56 = new Object[1];
            values((char) Drawable.resolveOpacity(0, 0), 3 - (Process.myPid() >> 22), 369 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr56);
            getSharedInstance getsharedinstance25 = new getSharedInstance(intern28, 27, ((String) objArr56[0]).intern());
            AnalysesEntry = getsharedinstance25;
            Object[] objArr57 = new Object[1];
            values((char) (19052 - View.combineMeasuredStates(0, 0)), 24 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 372 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), objArr57);
            String intern29 = ((String) objArr57[0]).intern();
            Object[] objArr58 = new Object[1];
            AGState("鱔᜔琇⊴", View.getDefaultSize(0, 0) + 3, objArr58);
            getSharedInstance getsharedinstance26 = new getSharedInstance(intern29, 28, ((String) objArr58[0]).intern());
            ScoredEntry = getsharedinstance26;
            Object[] objArr59 = new Object[1];
            values((char) (View.MeasureSpec.getMode(0) + 51106), 21 - View.combineMeasuredStates(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 396, objArr59);
            String intern30 = ((String) objArr59[0]).intern();
            Object[] objArr60 = new Object[1];
            AGState("鱔᜔侨\ued31", AndroidCharacter.getMirror('0') - '-', objArr60);
            getSharedInstance getsharedinstance27 = new getSharedInstance(intern30, 29, ((String) objArr60[0]).intern());
            FraudScore = getsharedinstance27;
            Object[] objArr61 = new Object[1];
            AGState("笺䥲ⳣ¢麌枟ꪏ礑恟ﱳ\uea03\ue2a0", View.getDefaultSize(0, 0) + 11, objArr61);
            String intern31 = ((String) objArr61[0]).intern();
            Object[] objArr62 = new Object[1];
            AGState("坊묨鋵ⶶ", 2 - MotionEvent.axisFromString(""), objArr62);
            getSharedInstance getsharedinstance28 = new getSharedInstance(intern31, 30, ((String) objArr62[0]).intern());
            Config = getsharedinstance28;
            Object[] objArr63 = new Object[1];
            AGState("笺䥲夻\ueaf3䄶張哃횕ሰ䒆⟢䰚恟ﱳ奜\ue451絙볨\uf377⬡㔽錅５큞题\uf031\uedd0攁", 27 - TextUtils.indexOf((CharSequence) "", '0'), objArr63);
            String intern32 = ((String) objArr63[0]).intern();
            Object[] objArr64 = new Object[1];
            values((char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 52425), 3 - KeyEvent.getDeadChar(0, 0), 417 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr64);
            getSharedInstance getsharedinstance29 = new getSharedInstance(intern32, 31, ((String) objArr64[0]).intern());
            BHT = getsharedinstance29;
            rf = new getSharedInstance[]{getsharedinstance, getsharedinstance2, getsharedinstance3, getsharedinstance4, getsharedinstance5, getsharedinstance6, getsharedinstance7, getsharedinstance8, SConfig, ce, C, getsharedinstance9, getsharedinstance10, getsharedinstance11, getsharedinstance12, getsharedinstance13, getsharedinstance14, getsharedinstance15, getsharedinstance16, getsharedinstance17, getsharedinstance18, getsharedinstance19, getsharedinstance20, getsharedinstance21, getsharedinstance22, getsharedinstance23, getsharedinstance24, getsharedinstance25, getsharedinstance26, getsharedinstance27, getsharedinstance28, getsharedinstance29};
            gc = (D + 7) % 128;
        }

        private getSharedInstance(String str, int i, String str2) {
            this.code = str2;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
        public final String getSharedInstance() {
            int i = (D + 19) % 128;
            gc = i;
            String str = this.code;
            int i2 = i + 33;
            D = i2 % 128;
            if (i2 % 2 != 0) {
                return str;
            }
            throw null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r13 = r13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void AGState(java.lang.String r13, int r14, java.lang.Object[] r15) {
            /*
                if (r13 == 0) goto L6
                char[] r13 = r13.toCharArray()
            L6:
                char[] r13 = (char[]) r13
                java.lang.Object r0 = com.apiguard3.internal.setBackgroundDrawable.getSharedInstance
                monitor-enter(r0)
                int r1 = r13.length     // Catch: java.lang.Throwable -> L7a
                char[] r1 = new char[r1]     // Catch: java.lang.Throwable -> L7a
                r2 = 0
                com.apiguard3.internal.setBackgroundDrawable.valueOf = r2     // Catch: java.lang.Throwable -> L7a
                r3 = 2
                char[] r4 = new char[r3]     // Catch: java.lang.Throwable -> L7a
            L14:
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                int r6 = r13.length     // Catch: java.lang.Throwable -> L7a
                if (r5 >= r6) goto L71
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
                r4[r2] = r5     // Catch: java.lang.Throwable -> L7a
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                r6 = 1
                int r5 = r5 + r6
                char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
                r4[r6] = r5     // Catch: java.lang.Throwable -> L7a
                r5 = 58224(0xe370, float:8.1589E-41)
                r7 = 0
            L2b:
                r8 = 16
                if (r7 >= r8) goto L5e
                char r8 = r4[r6]     // Catch: java.lang.Throwable -> L7a
                char r9 = r4[r2]     // Catch: java.lang.Throwable -> L7a
                int r10 = r9 + r5
                int r11 = r9 << 4
                char r12 = com.apiguard3.internal.writeReplace.getSharedInstance.cf     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                r10 = r10 ^ r11
                int r11 = r9 >>> 5
                char r12 = com.apiguard3.internal.writeReplace.getSharedInstance.ss     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                r10 = r10 ^ r11
                int r8 = r8 - r10
                char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
                r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
                char r10 = com.apiguard3.internal.writeReplace.getSharedInstance.am     // Catch: java.lang.Throwable -> L7a
                int r11 = r8 >>> 5
                char r12 = com.apiguard3.internal.writeReplace.getSharedInstance.rm     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                int r12 = r8 + r5
                int r8 = r8 << 4
                int r8 = r8 + r10
                r8 = r8 ^ r12
                r8 = r8 ^ r11
                int r9 = r9 - r8
                char r8 = (char) r9     // Catch: java.lang.Throwable -> L7a
                r4[r2] = r8     // Catch: java.lang.Throwable -> L7a
                r8 = 40503(0x9e37, float:5.6757E-41)
                int r5 = r5 - r8
                int r7 = r7 + 1
                goto L2b
            L5e:
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                char r7 = r4[r2]     // Catch: java.lang.Throwable -> L7a
                r1[r5] = r7     // Catch: java.lang.Throwable -> L7a
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                int r5 = r5 + r6
                char r6 = r4[r6]     // Catch: java.lang.Throwable -> L7a
                r1[r5] = r6     // Catch: java.lang.Throwable -> L7a
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                int r5 = r5 + r3
                com.apiguard3.internal.setBackgroundDrawable.valueOf = r5     // Catch: java.lang.Throwable -> L7a
                goto L14
            L71:
                java.lang.String r13 = new java.lang.String     // Catch: java.lang.Throwable -> L7a
                r13.<init>(r1, r2, r14)     // Catch: java.lang.Throwable -> L7a
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L7a
                r15[r2] = r13
                return
            L7a:
                r13 = move-exception
                monitor-exit(r0)
                goto L7e
            L7d:
                throw r13
            L7e:
                goto L7d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.writeReplace.getSharedInstance.AGState(java.lang.String, int, java.lang.Object[]):void");
        }

        private static void values(char c, int i, int i2, Object[] objArr) {
            String str;
            synchronized (setBackgroundTintList.AGState) {
                char[] cArr = new char[i];
                setBackgroundTintList.getSharedInstance = 0;
                while (setBackgroundTintList.getSharedInstance < i) {
                    cArr[setBackgroundTintList.getSharedInstance] = (char) ((gt[setBackgroundTintList.getSharedInstance + i2] ^ (setBackgroundTintList.getSharedInstance * f7416de)) ^ c);
                    setBackgroundTintList.getSharedInstance++;
                }
                str = new String(cArr);
            }
            objArr[0] = str;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'getSharedInstance' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class values implements ConfigInstance.ConfigSerializationProxy.AGState {
        private static final /* synthetic */ values[] AGState;
        public static final values APIGuard;
        private static int generateHeaders = 0;
        public static final values getSharedInstance;
        private static int parseResponseHeaders = 1;
        private static int[] valueOf;
        public static final values values;
        private String code;

        static void AGState() {
            valueOf = new int[]{-1354458879, -198881718, -2079986827, -1945217318, 11234995, -700068528, 923982627, 1876135090, 2130256709, 1063069942, -1120406207, 418649106, 1056739346, 337790195, -2002741942, -1070807345, -2075701844, 1195872019};
        }

        public static values valueOf(String str) {
            int i = parseResponseHeaders + 43;
            generateHeaders = i % 128;
            char c = i % 2 != 0 ? '8' : 'H';
            values valuesVar = (values) Enum.valueOf(values.class, str);
            if (c == 'H') {
                return valuesVar;
            }
            throw null;
        }

        public static values[] values() {
            int i = generateHeaders + 69;
            parseResponseHeaders = i % 128;
            if (i % 2 != 0) {
                return (values[]) AGState.clone();
            }
            values[] valuesVarArr = (values[]) AGState.clone();
            throw new ArithmeticException();
        }

        static {
            AGState();
            Object[] objArr = new Object[1];
            AGState(new int[]{-2096315005, -1737358039, -88370820, -2026981291, -1516057588, -2096212823, -871124024, -170776007, 952133060, -1021745695, -1004148439, 1247617224, 1973810751, -1115985755}, 28 - (ViewConfiguration.getEdgeSlop() >> 16), objArr);
            String intern = ((String) objArr[0]).intern();
            Object[] objArr2 = new Object[1];
            AGState(new int[]{-1465996991, 1961598197}, 3 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr2);
            values valuesVar = new values(intern, 0, ((String) objArr2[0]).intern());
            getSharedInstance = valuesVar;
            Object[] objArr3 = new Object[1];
            AGState(new int[]{1486291970, -177291135, -1306114745, 1709121296, 1018030863, 869137749, 1390714174, 1080493411, 15757372, 300847375, 2143706734, 352769000, -159916776, 843292717}, Color.argb(0, 0, 0, 0) + 26, objArr3);
            String intern2 = ((String) objArr3[0]).intern();
            Object[] objArr4 = new Object[1];
            AGState(new int[]{398526424, -724161891}, TextUtils.getOffsetAfter("", 0) + 2, objArr4);
            values valuesVar2 = new values(intern2, 1, ((String) objArr4[0]).intern());
            APIGuard = valuesVar2;
            Object[] objArr5 = new Object[1];
            AGState(new int[]{1486291970, -177291135, -1306114745, 1709121296, 1018030863, 869137749, 1390714174, 1080493411, 952133060, -1021745695, -1004148439, 1247617224, 1973810751, -1115985755}, 28 - (ViewConfiguration.getEdgeSlop() >> 16), objArr5);
            String intern3 = ((String) objArr5[0]).intern();
            Object[] objArr6 = new Object[1];
            AGState(new int[]{-2116703817, -73591404}, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 2, objArr6);
            values valuesVar3 = new values(intern3, 2, ((String) objArr6[0]).intern());
            values = valuesVar3;
            AGState = new values[]{valuesVar, valuesVar2, valuesVar3};
            generateHeaders = (parseResponseHeaders + 67) % 128;
        }

        private values(String str, int i, String str2) {
            this.code = str2;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
        public final String getSharedInstance() {
            int i = (parseResponseHeaders + 53) % 128;
            generateHeaders = i;
            String str = this.code;
            parseResponseHeaders = (i + 23) % 128;
            return str;
        }

        private static void AGState(int[] iArr, int i, Object[] objArr) {
            String str;
            synchronized (setBackgroundTintBlendMode.getSharedInstance) {
                char[] cArr = new char[4];
                char[] cArr2 = new char[iArr.length << 1];
                int[] iArr2 = (int[]) valueOf.clone();
                setBackgroundTintBlendMode.valueOf = 0;
                while (setBackgroundTintBlendMode.valueOf < iArr.length) {
                    cArr[0] = (char) (iArr[setBackgroundTintBlendMode.valueOf] >> 16);
                    cArr[1] = (char) iArr[setBackgroundTintBlendMode.valueOf];
                    cArr[2] = (char) (iArr[setBackgroundTintBlendMode.valueOf + 1] >> 16);
                    cArr[3] = (char) iArr[setBackgroundTintBlendMode.valueOf + 1];
                    setBackgroundTintBlendMode.values = (cArr[0] << 16) + cArr[1];
                    setBackgroundTintBlendMode.AGState = (cArr[2] << 16) + cArr[3];
                    setBackgroundTintBlendMode.values(iArr2);
                    for (int i2 = 0; i2 < 16; i2++) {
                        int i3 = setBackgroundTintBlendMode.values ^ iArr2[i2];
                        setBackgroundTintBlendMode.values = i3;
                        setBackgroundTintBlendMode.AGState = setBackgroundTintBlendMode.valueOf(i3) ^ setBackgroundTintBlendMode.AGState;
                        int i4 = setBackgroundTintBlendMode.values;
                        setBackgroundTintBlendMode.values = setBackgroundTintBlendMode.AGState;
                        setBackgroundTintBlendMode.AGState = i4;
                    }
                    int i5 = setBackgroundTintBlendMode.values;
                    setBackgroundTintBlendMode.values = setBackgroundTintBlendMode.AGState;
                    setBackgroundTintBlendMode.AGState = i5;
                    setBackgroundTintBlendMode.AGState = i5 ^ iArr2[16];
                    setBackgroundTintBlendMode.values ^= iArr2[17];
                    int i6 = setBackgroundTintBlendMode.values;
                    int i7 = setBackgroundTintBlendMode.AGState;
                    cArr[0] = (char) (setBackgroundTintBlendMode.values >>> 16);
                    cArr[1] = (char) setBackgroundTintBlendMode.values;
                    cArr[2] = (char) (setBackgroundTintBlendMode.AGState >>> 16);
                    cArr[3] = (char) setBackgroundTintBlendMode.AGState;
                    setBackgroundTintBlendMode.values(iArr2);
                    cArr2[setBackgroundTintBlendMode.valueOf << 1] = cArr[0];
                    cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 1] = cArr[1];
                    cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 2] = cArr[2];
                    cArr2[(setBackgroundTintBlendMode.valueOf << 1) + 3] = cArr[3];
                    setBackgroundTintBlendMode.valueOf += 2;
                }
                str = new String(cArr2, 0, i);
            }
            objArr[0] = str;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'setOnClickListener' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class APIGuard implements ConfigInstance.ConfigSerializationProxy.AGState {
        public static final APIGuard AGState;
        public static final APIGuard APIGuard;
        public static final APIGuard APIGuard$Callback;
        public static final APIGuard APIGuard$InitializationCallback;
        public static final APIGuard AnalysesEntry;
        public static final APIGuard BHT;
        public static final APIGuard BuildConfig;
        public static final APIGuard C;
        public static final APIGuard Config;
        public static final APIGuard ConfigInstance;
        public static final APIGuard ConfigInstance$ConfigSerializationProxy;
        public static final APIGuard D;
        public static final APIGuard E;
        public static final APIGuard E$CvmPayloadSerializationProxy;
        public static final APIGuard FU;
        public static final APIGuard FraudScore;
        public static final APIGuard KernelPayloadInstance;
        public static final APIGuard KernelPayloadInstance$KernelPayloadSerializationProxy;
        public static final APIGuard MT;
        public static final APIGuard MatchConfig;
        public static final APIGuard MatchConfig$Match;
        public static final APIGuard MatchesConfig;
        public static final APIGuard MatchesConfig$Matches;
        public static final APIGuard NTE;
        public static final APIGuard RB;
        public static final APIGuard SConfig;
        public static final APIGuard SLE;
        public static final APIGuard ScoredEntry;
        public static final APIGuard UriFilter;
        public static final APIGuard UriFilter$1;
        public static final APIGuard UriFilter$UrlMatcherSpec;
        public static final APIGuard UriFilter$UrlTest;
        public static final APIGuard UrlMatcher;
        public static final APIGuard UrlMatcherConfig;
        public static final APIGuard am;
        public static final APIGuard analyzeResponse;
        public static final APIGuard ce;
        public static final APIGuard cf;
        public static final APIGuard checkCertificates;
        public static final APIGuard clearCallback;
        public static final APIGuard cs;

        /* renamed from: de  reason: collision with root package name */
        public static final APIGuard f7415de;
        public static final APIGuard dpi;
        public static final APIGuard gc;
        public static final APIGuard generateHeaders;
        public static final APIGuard getRequestHeaders;
        public static final APIGuard getSharedInstance;
        public static final APIGuard getState;
        public static final APIGuard getVersion;
        public static final APIGuard gt;
        public static final APIGuard initialize;
        public static final APIGuard ipi;
        public static final APIGuard log;
        public static final APIGuard onContextItemSelected;
        public static final APIGuard onInitializationFailure;
        public static final APIGuard onInitializationSuccess;
        public static final APIGuard onOptionsItemSelected;
        public static final APIGuard openContextMenu;
        public static final APIGuard parseResponseHeaders;
        public static final APIGuard pushMaxPayload;
        public static final APIGuard pushMinPayload;
        public static final APIGuard readObject;
        public static final APIGuard readResolve;
        public static final APIGuard registerForContextMenu;
        public static final APIGuard rf;
        public static final APIGuard rm;
        public static final APIGuard sc;
        public static final APIGuard sdf;
        public static final APIGuard send;
        private static APIGuard setAccessibilityDelegate = null;
        private static APIGuard setAccessibilityPaneTitle = null;
        private static APIGuard setAccessibilityTraversalAfter = null;
        private static APIGuard setAccessibilityTraversalBefore = null;
        private static APIGuard setAutofillId = null;
        private static APIGuard setContentCaptureSession = null;
        private static APIGuard setContentDescription = null;
        public static final APIGuard setContentView;
        private static APIGuard setDrawingCacheQuality = null;
        public static final APIGuard setFadingEdgeLength;
        public static final APIGuard setHorizontalScrollbarThumbDrawable;
        public static final APIGuard setHorizontalScrollbarTrackDrawable;
        private static APIGuard setImportantForAutofill = null;
        private static APIGuard setKeepScreenOn = null;
        private static long setLabelFor = 0;
        private static int setNextFocusDownId = 1;
        private static int setNextFocusForwardId;
        private static final /* synthetic */ APIGuard[] setNextFocusLeftId;
        private static APIGuard setOnClickListener;
        public static final APIGuard setOnContextClickListener;
        private static APIGuard setOnCreateContextMenuListener;
        private static APIGuard setOnDragListener;
        public static final APIGuard setOnFocusChangeListener;
        private static APIGuard setOnGenericMotionListener;
        private static APIGuard setOnHoverListener;
        private static APIGuard setOnKeyListener;
        private static APIGuard setOnLongClickListener;
        public static final APIGuard setOnScrollChangeListener;
        private static APIGuard setOnTouchListener;
        private static APIGuard setRevealOnFocusHint;
        private static char[] setScrollContainer;
        public static final APIGuard setScrollIndicators;
        public static final APIGuard setVerticalScrollbarPosition;
        public static final APIGuard setVerticalScrollbarThumbDrawable;
        public static final APIGuard setVerticalScrollbarTrackDrawable;
        public static final APIGuard spi;
        public static final APIGuard ss;
        public static final APIGuard unregisterForContextMenu;
        public static final APIGuard updateKernel;
        public static final APIGuard valueOf;
        public static final APIGuard values;
        public static final APIGuard values$605170aa;
        public static final APIGuard writeReplace;
        private String code;

        static void AGState() {
            setLabelFor = 2461893765291417408L;
            char[] cArr = new char[3084];
            ByteBuffer.wrap("\u0000E\u009f\r>ÐÝ\u0094}Y\u001c\u001f»ÓZ\u0094úR\u0099\t8Î×\u0087w_\u0016\u0006µÏT\u0092ô_\u0093\u00142ÅÑ\u0093qT\u0010\u0013bãý¢\\r¿(\u001fÿ~¿Ùb8?q\u001cî)\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8Ï×\u0090wE\u0016\u000eµßT\u0083ôO\u0093\u000e2ÆÑ\u0089qG\u0010\u001f¯ÂN\u008cîO\u008d\u0003,Ë\u0000E\u009ftf\u0090ùÅX\u0012»S\u001b\u0089zÓÝ\u0014<_\u009c\u0085ÿÒ^\u0012±O\u0011\u0092pßÓ\r2S\u0092\u0087\u0000E\u009fq>°¿\u0083 Ò\u0081\nb_Â\u009c£Ò\u0004\u0017åLE\u0083&Ö\u0087\u0001h@È\u009a©À\n\u0007ëVK\u009d,Ð\u008d\u0016nLÎ\u0095¯Ò\u0010\u001añ_Q\u00962×\u0000E\u009fq>±\u0000W\u009f\t>ÎÝ\u0084}O\u001c\u0017»ßZ\u008dúA\u0099\u000e8Á×\u0087wE\u0016\u0012µßT\u008dôI\u0093\u00132ÓÑ\u0089qN\u0010\u0007\u0080\u0096\u001f¢¾g\u000f®\u0090ø13Ònr²\u0013ï´\"Upõ¼\u0096ó7<Øzx¸\u0019ïº\"[pû´\u009cî=.Þt~³\u001fú¡\u0018>,\u009fèÐöO\u00adîh\r-\u00adìÌ´km\u008a<*ðIªèd\u0007-§âÆ¯e|\u0084-$âC®âfî;q\u000fÐÈ5óª°\u000buè.Hâ)¸\u008evo?Ïð¬½\rnâ0Bã#¶\u0080da<Áô¦¿\u0007eñ5n\u0001ÏÇD¡Ûûz5\u0099|9³Xþÿ-\u001e|¾½Ýæ|-\u0093s3¤Róñ;\u0010~°³×ðv>\u0095w}nâZC\u0093Ð¼Oåî9\rx\u00ad©Ìák$\u008a\u007f*¢Ióè)\u0007p§·Æÿe:\u0084s$²\u0000E\u009fq>¹áÖ~\u0080ßG<\u0007\u009cÐý\u009bZV»\f\u001bÊx\u009cÙ[6\u0006\u0096Á÷\u0094T[µ\u0016\u0015Ðr\u008aÓS0\u0014\u0090Üñ\u0099NP¯\u0011\u0000E\u009fr>°µ£*î\u008b*hoÈ®©ù\u000e4ïmO¤,ù\u008d&bjÂ¿£ô\u0000)ájA¯\u0000E\u009fr>±\u0000N\u009f\u0015>ÌÝ\u008c}_\u001c\u0003»ÏZ\u008eúF\u0099\t8Ç×\u009fwH\u0016\u0005µÁT\u0084ôE\u0093\u00122ßÑ\u0096qA\u0010\f¯ÕN\u0085õ\u001bj,Ëì\u0000M\u009f\u0013>ÇÝ\u009f}U\u001c\u0012»ÉZ\u009fúF\u0099\u00018É×\u008cwE\u0016\u0004µßT\u0086ôI\u0093\f2ÔÑ\u0085qRÜðCÇâ\u0006\u0000E\u009f\u000e>ÃÝ\u008f}D\u001c\t»ÎZ\u0087ú_\u0099\u00058Ò×\u0092wO\u0016\u0012b\u0095ý¢\\d\\eÃ)bè\u0081 !o@!çù\u0006³¦vÅ\"dç\u008b²+cJ9éç\bª¨tÏ#nç\u008d¢-\u007fL9óï\u0012¨²yÑ6pô\u0097©7aV4õã\u0014µ´u\u001c \u0083\u0017\"Ý\u0000A\u009f\u0013>ÓÝ\u0085}R\u001c\u0014»ÉZ\u008fúN\u0099\u001f8Õ×\u0090wD\u0016\u0001µÔT\u0085ô_\u0093\r2ÁÑ\u008eqA\u0010\u0007¯ÅN\u0092î_\u008d\u0012,ÕË\u008ekN\n\t©ÎH\u0087\u0000E\u009fr>¹\u0000U\u009f\u000e>ËÝ\u008e}O\u001c\u0017»ÎZ\u009fúM\u0099\u00058Ó×\u0093wA\u0016\u0007µÅ\u0085\u008f\u001a¹»y\u0000M\u009f\u0001>ÌÝ\u0086}O\u001c\u0012»ÍZ\u0085úD\u0099\u001f8Í×\u0085wS\u0016\u0013µÁT\u0087ôE\u0000E\u009fs>´\u0000R\u009f\u0005>ÓÝ\u0090}O\u001c\u000e»ÓZ\u0085ú_\u0099\u00158Ð×\u0084wA\u0016\u0014µÅT\u009fôK\u0093\u00052ÒÑ\u008eqE\u0010\f¯ßN\u0086îA\u008d\t,ÌË\u0095kR\n\u0005\u0000E\u009fs>¹\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÓZ\u0083úH\u0099\u00058Ä×\u0095wL\u0016\tµÎT\u0087ô_\u0093\u00152ÐÑ\u0084qA\u0010\u0014¯Å\u0000E\u009ft>±\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÕZ\u008eúK\u0099\u000e8Ï×\u0097wN\u0016\u001fµÍT\u0081ôT\u0093\u00032ÈÑ\u009fqT\u0010\u0019¯ÐN\u0085\u0083\u001d\u001c,½íÒ'Mpì°\u000fí¯0Î}i·\u0088ì()Klê\u00ad\u0005õ¥,Ä}g¯\u0086ã&6Aaàª\u0003ç£1Â}}¶\u009cû<2_g³\u0087,¶\u008dt\u0000W\u009f\u0005>ÂÝ\u0096}I\u001c\u0005»×Z\u009fúI\u0099\u000e8É×\u0094w_\u0016\u0006µÁT\u0089ôL\u0093\u00052ÄãX|iÝª|nã9Bù¡¤\u0001y`4Çû&®\u0086yå8Dâ«¸\u000b\u007fj\"Éå(¬\u0088tï(Nä\u00ad¥\rml\"Óì\u0000E\u009ft>¸RáÍ¶lv\u008f+/öN»ét\b!¨öË·jm\u00857%ðD\u00adçj\u0006#¦ûÁ´`e\u0083=#èB«ýe\u001c \u0000E\u009ft>¹\u0000J\u009f\u0013>ÅÝ\u008e}V\u001c\t»ÒZ\u008fúN\u0099\r8Å×\u008ewT\u0016\u001fµÓT\u0094ôO\u0093\u00102ßÑ\u0086qA\u0010\t¯ÌN\u0085îD\u0000E\u009fu>°\u0000J\u009f\u0013>ßÝ\u0085}V\u001c\u0001»ÌZ\u009fúF\u0099\u00018É×\u008cwE\u0016\u0004\u0000E\u009fu>±\u0000N\u009f\u0004>ËÝ\u009f}M\u001c\u0005»ÓZ\u0093úA\u0099\u00078Å×\u009fwH\u0016\u0001µÎT\u0084ôL\u0093\t2ÎÑ\u0087q_\u0010\u0006¯ÁN\u0089îL\u008d\u0015,ÒË\u0085]âÂÒc\u0015\u0097Ì\b\u0083©VJ\u000bêÔ\u008b\u0087,]Í\u0011mË\u000e\u0085¯L@\u0003àÎ\u0081\u009d\"AÃ\rcÎ\u0004\u008e¥GF\u0001æÖ\u0087\u008b8MÙ\fyÝ\u001a\u0084»C\\\u000büÎ\u009d\u0097>Pß\u00070]¯m\u000e«\u0000N\u009f\u0004>ËÝ\u009f}L\u001c\t»ÂZ\u0092úA\u0099\u00128Ù×\u009fwN\u0016\u000fµÔT\u009fôL\u0093\u000f2ÁÑ\u0084qE\u0010\u0004â\r}=Üü\u0010T\u008f\u0013.ËÍ\u009cmQ\f\u0014«ÙJ\u0082êN\u0089\t(ÒÇ\u008fgX\u0006\u0002¥ÍD\u0094äY\u0083\u0002\"ËÁ\u009caQ\u0000\b¿Øú\fe<Äü\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÄZ\u0085úL\u0099\u00058Ô×\u0089wN\u0016\u0007µßT\u008eôD\u0093\u000b2ßÑ\u0090qI\u0010\u0004\u0000E\u009fu>¶ã\u0010|WÝ\u008f>Ø\u009e\u0015ÿPX\u009d¹Æ\u0019\u0015zVÛ\u009e4Æ\u0094\u0015õ\\V\u008f·Ü\u0017\u0015\u0000E\u009fu>·\u0000S\u009f\u0001>ÕÝ\u0092}O\u001c\u000e»ßZ\u0085úR\u0099\u00128ß×\u008dwE\u0016\u0013µÓT\u0081ôG\u0093\u0005\u0000E\u009fs>³Ýó\u0098Ô\u0007\u0083¦CE\u001eåÃ\u0084\u008e#FÂ\u0019bØ\u0001\u009d TO\u000eïÃ\u008e\u0094-PÌ\u0015lØ\u000b\u009fªVI\u000eé×\u0088\u00987]Ö\u0014vÎ\u0015\u0082´HS\u0002óÅ\u0092\u00941\\Ð\u000epÔ\u001f\u0083¾C]\u001eýÃ\u009c\u0082\u0000T\u009fq\u0083ó\u001cµ½b^$þï\u009f³8xÙ5yó\u001a»»oT9ôþ\u0095¤6u×\"wó\u0010µ±`R$òÿ\u0093¢,oÍ>må\u000e¼¯|H/èâ\u0089µ*cË kÿ\u0004¾¥cF5\u001aÁ\u0085ç\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÆZ\u0089úL\u0099\f8É×\u008ewG\u0016\u001fµÔT\u0081ôG\u0093\u001f2ÑÑ\u0095qE\u0010\u0015¯Å\u0000T\u009fs,Ï³\u0098\u0012Xñ\u0005QØ0\u0095\u0097Iv\u0006ÖÏµ\u008b\u0014Xû\u0003[Ä:\u008d\u0099Ux\u001eØË¿\u008d\u001eUý\u001b]ß<\u008f\u0083_b\u000f,Þ³þ\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8Ä×\u0085wC\u0016\u0012µÙT\u0090ôT\u0093\u001f2ÃÑ\u008fqN\u0010\u0006¯ÉN\u00875,ª\r\u0093t\f3\u00adëN¼îq\u008f4(ùÉ¢i~\n2«óD»ät\u0085:&âÇ¸gs\u0000>¡ïB¤âm\u0083)<ôÝ²}s\u001e\"¿üX±øz\u00992:ïÛ´{i\u00145µð\u0000T\u009fvfÓù\u0095XO»\b\u001bÁz\u0099ÝV<\n\u009cÇÿ\u008f^H±\u0019\u0011Òp\u0083Ó^2\u0012\u0092Ùõ\u0085TI·\b\u0017Àv\u008fÉA\u0000T\u009fw\u0000M\u009f\u0001>ÌÝ\u0086}O\u001c\u0012»ÍZ\u0085úD\u0099\u001f8Å×\u008ewC\u0016\u0012µÙT\u0090ôT\u0093\u00052ÄÑ\u009fqC\u0010\u000f¯ÎN\u0086îI\u008d\u0007wOèc\u0000T\u009f\u0001>ÓÝ\u008b}_\u001c\u0005»ØZ\u0085úC\u0099\u00158Ô×\u0089wO\u0016\u000eµßT\u0086ôA\u0093\t2ÌÑ\u0085qDçîxÃ\u0000T\u009f\u0001>ÓÝ\u008b}_\u001c\t»ÎZ\u0094úE\u0099\u00128Ò×\u0095wP\u0016\u0014µÅT\u0084ô_\u0093\u00172ÈÑ\u0089qL\u0010\u0005¯ßN\u0097îA\u008d\t,ÔË\u0089kN\n\u0007\u0000T\u009fq>°\u0000T\u009f\u0001>ÓÝ\u008b}_\u001c\u0014»ÉZ\u008dúE\u0099\u00048ß×\u008fwU\u0016\u0014\u0000T\u009fq>±\u0000E\u009f\u0018>ÃÝ\u0085}P\u001c\u0014»ÉZ\u008fúN\u0099\u001f8××\u0088wI\u0016\fµÅT\u009fôE\u0093\u00182ÅÑ\u0083qU\u0010\u0014¯ÉN\u008eîG\u008d\u001f,ÔË\u0081kS\n\u000b;}¤X\u0005\u009b\u0000R\u009f\u0005>ÔÝ\u0092}Y\u001c\t»ÎZ\u0087ú_\u0099\u00148Á×\u0093wK\u0016\u001fµÅT\u0098ôE\u0093\u00032ÕÑ\u0094qI\u0010\u000f¯Î\u0000T\u009fq>³\u0000S\u009f\t>ÇÝ\u008e}A\u001c\f»ßZ\u0084úI\u0099\u00138Ð×\u0081wT\u0016\u0003µÈT\u009fôF\u0093\u00012ÉÑ\u008cqE\u0010\u0004ÛSDvå³\u0000T\u009f\u0001>ÇÝ\u009f}N\u001c\u000f»ÔZ\u009fúA\u0099\u00168Á×\u0089wL\u0016\u0001µÂT\u008côE\u0012\u0017\u008d2,ö\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÅZ\u0098úE\u0099\u00038Õ×\u0094wI\u0016\u000eµÇT\u009fôN\u0093\u00042ËÑ\u009fqC\u0010\u0001¯ÌN\u008c\u0000T\u009fq>¶Ù\u009eFÈç\u0019\u0004R¤\u009eÅÂb\u000e\u0083F#\u0088@Ùá\u0012\u000eK®\u008cÏÎl\u0019\u008dB-\u009fJÔë\u0012\bH¨\u009fÉßv\u0002\u0097_gjøOY\u0089\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÇZ\u0085úT\u0099\u00148É×\u008ewG\u0016\u001fµÐT\u0081ôC\u0093\u000b2ÁÑ\u0087qE\u0010\u001f¯ÉN\u008eîF\u008d\u000f\u0000T\u009fq>¸\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÒZ\u0095úN\u0099\u000e8É×\u008ewG\u0016\u001fµÄT\u0085ôX\u0093\u00072ÕÑ\u0081qR\u0010\u0004¯ßN\u0084îE\u008d\u0014,ÅË\u0083kT\n\t©ÏH\u008e\u0000T\u009fq>¹+m´*\u0015âö§Vn7/\u0090ôq¿Ñd²4\u0013êü¯\\o=4\u009eè\u007f½ßf¸4\u0019ûúªZr;'\u0084äeªÅo\u0000T\u009fr>°\u0000I\u009f\u000e>ÖÝ\u0081}L\u001c\t»ÄZ\u009fúC\u0099\u00168Í×\u009fwM\u0016\u000fµÄT\u0095ôL\u0093\u00052ßÑ\u0083qO\u0010\u000e¯ÔN\u0085îN\u008d\u0014B8Ý\u001e|Ý»÷$°\u0085xf=Æî§²\u0000gá<Aî\"·\u0083dl?Ìò\u00ad¥\u000exï>Oÿ(®\u0089rj0Êý«½ I¿o\u001e¯\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0090úE\u0099\u00128Ó×\u0089wS\u0016\u0014µÉT\u008eôG\u0093\u001f2ÃÑ\u0096qM\u0010\u001f¯ÔN\u008fî_\u008d\u0004,ÉË\u0093kKÇ¡X\u0087ùFY\u0080ÆÁg\u001a\u0084Q$\u009bEÝâ\u000b\u0003J£\u0091ÀÁa\u0000\u008eQ.\u008fOÀì\n\r\\\u00ad\u0081ÊÇk\n\u0088Q(ÿ\u0000T\u009fr>´\u001aa\u0085&$þÇ©gd\u0006!¡ì@·àk\u0083>\"åÍ·mc\f-¯úN¦îm\u0089$(÷Ë¬ki\n<µé\u009e:\u0001\u001c Û\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u008cúO\u0099\u00018Ä×\u009fwC\u0016\u0016µÍT\u009fôB\u0093\u00152ÆÑ\u0086qE\u0010\u0012lÔóòR6\u0000N\u009f\u000f>ÔÝ\u009f}U\u001c\u0013»ÅZ\u0084ú_\u0099\u000f8Î×\u009fwA\u0016\u000eµÄT\u0092ôO\u0093\t2ÄÑ\u009fq2\u0000T\u009fr>·Æ\u0004YQø\u008a\u001bØ»\u0014ÚS}\u0086\u009cÓ<\u0002_Xþ\u0081\u0011Æ±\u000eÐKs\u0082\u0092Ã2\u0018USô\u0088\u0017Ø·\u000eÖIi\u008e\u0088Ó(\u000eKFê\u008b\rÎ\u00ad\u001dÌB\u0000T\u009fr>¸\u0000N\u009f\u000f>ÔÝ\u009f}U\u001c\u0013»ÅZ\u0084ú_\u0099\u000f8Î×\u009fwA\u0016\u000eµÄT\u0092ôO\u0093\t2ÄÑ\u009fq3\u0000T\u009fr>¹\u0000N\u009f\u000f>ÔÝ\u009f}U\u001c\u0013»ÅZ\u0084ú_\u0099\u000f8Î×\u009fwA\u0016\u000eµÄT\u0092ôO\u0093\t2ÄÑ\u009fq4\u0000T\u009fs>°\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8Ì×\u008fwA\u0016\u0004µßT\u0083ôV\u0093\r2ßÑ\u008dqO\u0010\u0004¯ÕN\u008cîE\u0000T\u009fs>±Â\u001f]Jü\u0091\u001fÃ¿\u0019ÞDy\u0099\u0098ß8\t[Hú\u0093\u0015Îµ\u0003ÔYw\u0084\u0096ß6\u0019QLð\u0088\u0013Õ³\u0013ÒRMPÒws¶\u0000L\u009f\u0015>ÁÝ\u009f}R\u001c\u0015»ÎZ\u008eúE\u0099\u00128ß×\u0085wX\u0016\u0003µÅT\u0090ôT\u0093\t2ÏÑ\u008e(s·T\u0016\u0094\u0010s\u008f4.üÍ¹mp\f1«êJ¡êz\u0089*(ùÇºgt\u00061¥êD±äp\u0083&\"áÁ§az\u0000,¿ð^±þj\u009d6<ãÛ¸\u0000T\u009fs>´\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8Ò×\u0095wN\u0016\u001fµÄT\u0085ôS\u0093\u00142ÒÑ\u008fqY\u0010\u0005¯ÄN\u009fîC\u008d\u0016,Í\u0000T\u009fs>µ\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8Ð×\u0083wA\u0016\fµÌT\u009fôD\u0093\u00152ÒÑ\u0089qN\u0010\u0007¯ßN\u008cîO\u008d\u0001,Ä¬â3Å\u0092\u0000\u0095\u009e\nÙ«\u0001HVè\u009b\u0089Þ.\u0013ÏHo\u0092\fÙ\u00ad\u0016BUâ\u009b\u0083Ò \bÁTa\u0081\u0006Ú§\bDAä\u0096\u0085Û:\u0002ÛR\u0000T\u009fs>·\u0087\u0006\u0018S¹\u0088ZÚú\u0016\u009bQ<\u008aÝÕ}\u001a\u001eW¿\u0080PÔð\u0010\u0091@2\u0096ÓÑs\u001a\u0014Qµ\u008cVÈö\u0000\u0097A(\u009aÉÊi\u0010\nQ\u0000T\u009fs>¸èÙw\u009eÖV5\u0013\u0095Úô\u009bS@²\u000b\u0012Ðq\u0080Ð^?\u001b\u009fÛþ\u0080]\\¼\t\u001cÒ{\u0080ÚR9\u0010\u0099Ûø\u008aGS¦\u001a\u0000T\u009fs>¹\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÒZ\u0085úF\u0099\u00128Å×\u0093wH\u0016\tµÎT\u0087ô_\u0093\u000e2ÁÑ\u0094qI\u0010\u0016¯ÅN\u009fîH\u008d\u0005,ÁË\u0084kE\n\u0012©ßH\u0083èA\u0087\u0003&ÈÅ\u0085d\u0099û¹Z}h0÷gV§µú\u0015'tjÓ³2ü\u00929ñyP¼¿û\u001f2~jÝ»<ô\u009c!û|Z£¹ð\u0019*x}Ç°&ô\u00861åpD§£ê\u00036btÁ¶ ý\u00800\u0092\u0094\r´¬q\u0000E\u009f\u0018>ÃÝ\u0085}P\u001c\u0014»ÉZ\u008fúN\u0099\u001f8××\u0088wI\u0016\fµÅT\u009fôF\u0093\t2ÌÑ\u008cqI\u0010\u000e¯ÇN\u009fîA\u008d\u0004,ÁË\u0090kT\n\t©ÖH\u0085è_\u0087\u0011&ÕÅ\u0085eU\u0004\u0005Ä\u008e[®úh\u0011e\u008e8/ãÌ¥lp\r4ªéK¯ën\u0088?)÷Æ¨fi\u0007,¤åE¿åc\u0082!#ìÀ¬`i\u0001.¾ç_¿ÿd\u009c!=ôÚ¡z\u007f\u001b'¸åY®ùe\u009627áÔ´to\u00152²ÿS¦óu\u0090.1ã®´Niï/\u008cîåGzgÛ \u0000A\u009f\u0004>ÄÝ\u0089}N\u001c\u0007»ßZ\u008eúU\u0099\f8Ì×\u009fwO\u0016\u0012µßT\u0085ôM\u0093\u00102ÔÑ\u0099q_\u0010\u0005¯ÌN\u0085îM\u008d\u0005,ÎË\u0094k_\n\u0014©ÏH\u009fèN\u0087\u0001&ÔÅ\u0089eV\u0004\u0005£ßB\u0088âE\u0081\u0001 Ä¿\u0085_Rþ\u001f\u009dÃ<\u0081ÜC{\b\u001aÅÁ4^\u0014ÿÔ\u0000N\u009f\u0001>ÔÝ\u0089}V\u001c\u0005»ßZ\u0088úE\u0099\u00018Ä×\u0085wR\u0016\u001fµÃT\u0081ôC\u0093\b2ÅÑ\u009fqD\u0010\t¯ÓN\u0081îB\u008d\f,ÅË\u0084S\u008cÌ¬mm\u0000A\u009f\u0004>ÄÝ\u0089}N\u001c\u0007»ßZ\u008eúU\u0099\f8Ì×\u009fwE\u0016\fµÅT\u008dôE\u0093\u000e2ÔÑ\u009fqT\u0010\u000f¯ßN\u0081îD\u008d\u0001,ÐË\u0094kI\n\u0016©ÅH\u009fèQ\u0087\u0015&ÅÅ\u0095eE\u0000T\u009ft>¶\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8È×\u0081wN\u0016\u0004µÌT\u0085ô_\u0093\u00012ÐÑ\u0090q_\u0010\r¯ÅN\u0093îS\u008d\u0001,ÇË\u0085\u0000T\u009ft>·\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u0094úO\u0099\u001f8È×\u0081wN\u0016\u0004µÌT\u0085ô_\u0093\u00032ÖÑ\u008dq_\u0010\r¯ÅN\u0093îS\u008d\u0001,ÇË\u0085\u0000T\u009ft>¸ÕYJ\u001eëÖ\b\u0093¨ZÉ\u001bnÀ\u008f\u008b/PL\u0000í×\u0002\u009e¢QÃ\u001b`Ó\u0081\u009a!@F\fçÚ\u0004\u009c¤JÅ\rzÚ\u009b\u0080;\\X\u0017ùÞ\u001e\u0091¾Qß\u001a|ÓËYTyõ´¡t>\"\u009fä|²Üu½\"\u001aøû¤[o8&\u0099év©Öb·+\u0014øõ¤Uq2*\u0093\u0095p¦Ðw±7\u000eøï²Oi,,\u008déj¨Êp«)\bøé¤Ih&*\u0087êd¦Äi¥#í\u0013r2Ó÷\u0000E\u009f\u0012>ÒÝ\u008f}R\u001c\u001f»ÃZ\u0081úC\u0099\b8Å×\u0084w_\u0016\u0003µÏT\u008eôF\u0093\t2ÇÑ\u009fqC\u0010\f¯ÅN\u0081îR\u008d\u0005,ÄþÊaëÀ/\u0000F\u009f\u0001>ÉÝ\u008c}E\u001c\u0004»ßZ\u008búE\u0099\u00128Î×\u0085wL\u0016\u001fµÉT\u008eôI\u0093\u0014\"ë½Ê\u001c\r\u008eæ\u0011±°qS,óñ\u0092¼5dÔ&t÷\u0017·¶jY-ùä\u0098¼;eÚ*zñ\u001d¦¼a_\"ÿð\u009e¦!|À*`ç\u0000T\u009fu>³\u0000C\u009f\u000f>ÎÝ\u0086}I\u001c\u0007»ßZ\u0095úP\u0099\u00048Á×\u0094wE\u0016\u001fµÅT\u0092ôR\u0093\u000f2ÒÑ\u009fqT\u0010\u0014¯ÌN\u009fîE\u008d\u0018,ÃË\u0085kE\n\u0004©ÅH\u0084a¨þ\u0089_Hèrw>Öÿ5·\u0095xô6Sî²¢\u0012dq!Ðá?¾\u009fcþ%]î¼¼\u001c~{5Úô\u0000T\u009fq>°Ýð½À\"\u0081\u0083\\`\u0003ÀÑ¡\u0085\u0006Vç\u0000GÛ$\u0080\u0085Aj\u0010ÊÁ«\u0087\bPé\rIË.\u008a\u008f[l\u0016ÌÁ\u00ad\u0097\u0012Qó\bSÐ¸('\t\u0086Ìe\u008c\u00834\u001cx½¹^ñþ>\u009fp8¨Ùây'\u001as»¶Tãô2\u0095h6±×öw>\u0010{±²Ró\u0000T\u009fu>°Ýñ\u0000S\u009f\u001f>ÒÝ\u0085}A\u001c\u0004»ßZ\u0092úE\u0099\u00118Õ×\u0085wS\u0016\u0014µßT\u0082ôO\u0093\u00042ÙÑ\u009fqE\u0010\u0012¯ÒN\u008fîR\u0000S\u009f\u0014>³Ê»U÷ô:\u0017m·©Öìq7\u0090z0\u00adSûò8\u001dg½¦Üû\u007f-\u009ew>ªYçø,\u001bq»·Úíe:\u0084z$§Gú\u0000S\u009f\u0014>´¢¼=ð\u009c!\u007fjß»¾ð\u00199øfX¼;æ\u009a-ufÕ£´æ\u0017;övV°1é\u0090.sfÓ£²ê\r+ìpL»/à\u008e0i|Éª¨á\u000b+êpJ¢%ê\u0084<g|Ç®¦è\u0001*|\\ã\u001bBºa\tþE_\u0099¼Õ\u001c\u0014}\\Ú\u0093;Ý\u009b\u0005øJY\u009b¶È\u0016\twSÔ\u00945Ý\u0095\u0005ò_S\u0088°È\u0010\u0015qH24\u00ads\fÑ\u0000S\u009f\u001f>ÃÝ\u008f}N\u001c\u0006»ÉZ\u0087ú_\u0099\u00058Î×\u0084wP\u0016\u000fµÉT\u008eôT\u0093\u00132ßÑ\u0081qN\u0010\u0001¯ÌN\u0099îZ\u008d\u0005,ÄË\u009fkA\n\u0012©ÅH\u009fèE\u0087\r&ÐÅ\u0094eY\u0000S\u009f\u0014>·\u0000S\u009f\u001f>ÎÝ\u0085}T\u001c\u001f»ÖZ\u0089úS\u0099\t8Â×\u0089wL\u0016\tµÔT\u0099ô_\u0093\u00062ÁÑ\u0089qL\u0010\u0005¯ÄN\u009fîT\u008d\u000f,ßË\u0083kR\n\u0005©ÁH\u0094èE\u0087\u001f&ÅÅ\u0096eE\u0004\u000e£ÔÓïL¨í\u0005\u0097V\b\u001a©ÆJ\u008aêK\u008b\u0003,ÌÍ\u0082mZ\u000e\u0000¯Ë@\u0081àU\u0081\n\"ÌÃ\u008bcQ\u0004\u0016¥ÚF\u0096æF\u0087\n8×Ù\u0080yA\u001a\u001a»Ä\\\u0097ü@\u009d\u001a>Àß\u0088\u007fU\u0010\u0011±Ü\u0013\u0093\u008cÔ-qÎ0\u00002\u009f~>§Ýó} \u001ct»¥Zþú2\u0099b8®×ów$\u0016~µ¥Täô2\u0093d2³Ñèq \u0010m¯¨Nûî \u008du,¨Ëîk/\n~©¤Hóè3\u0087n&³\u0000S\u009f\u0014>±ÝñØ\u0001GMæ\u0091\u0005Ý¥\u001cÄTc\u009b\u0082Õ\"\rAWà\u009c\u000fÖ¯\u0002Î]m\u009b\u008cÜ,\u0006KAê\u008d\tÓ©\u001cÈSw\u009e\u0096Ë6\bUWô\u0096\u0013Í³\u0002ÒSq\u0080\u0090Á0\u001b_\\þ\u0095\u001dÍ½\u0017Ü@{\u0080\u009aÝ:\u0000\u001aF\u0085\u0001$¤Çç?¢ î\u00012â~B¿#÷\u00848evÅ®¦ô\u0007?èuH¡)þ\u008a8k\u007fË¥¬â\r.îbN²/þ\u0090#qtÑµ²î\u0013!ôpT£5â\u00968w\u007f×¶¸î\u00194úcZ£;þ\u009c#\u009dc\u0002$£\u0081@Ãé\u007fv3×ê4¾\u0094mõ9Rè³³\u0013\u007fp/Ñã>¾\u009eiÿ3\\ù½¼\u001dhz-Ûø8©\u0098sù)Fþ§¾\u0007cd>\u0011[\u008e\u001c/¹Ìüm+ògS»°÷\u00106q~Ö±7ÿ\u0097'ô|U½ºë\u001a={jØ±9ù\u00994þq_¢¼ù\u001c,}qÂ·#ö\u0083'à}Aª¦ê\u00067gj\u0083\u0087\u001cÀ½e^!?K \u0007\u0001Ûâ\u0097BV#\u001e\u0084Ñe\u009fÅG¦\r\u0007Èè\u009cHY)\f\u008aÝk\u0087Ë]¬\n\rÊî\u0097NJ\u0000S\u009f\u0014>²Ýðòsm0Ìò/º\u008fvî#Iþ¨¤\b\u007fk5Êî%¥\u0085yä#Gô¦°\u0006ua.Àô#©\u0083râ4]á¼¥\u001cx\u007f>Þÿ\u0000B\u009f\u0014>ÅÝñ".getBytes("ISO-8859-1")).asCharBuffer().get(cArr, 0, 3084);
            setScrollContainer = cArr;
        }

        public static APIGuard valueOf(String str) {
            int i = setNextFocusDownId + 117;
            setNextFocusForwardId = i % 128;
            char c = i % 2 != 0 ? Typography.quote : 'X';
            APIGuard aPIGuard = (APIGuard) Enum.valueOf(APIGuard.class, str);
            if (c == 'X') {
                return aPIGuard;
            }
            throw new ArithmeticException();
        }

        public static APIGuard[] values() {
            int i = setNextFocusDownId + 47;
            setNextFocusForwardId = i % 128;
            if (i % 2 != 0) {
                APIGuard[] aPIGuardArr = (APIGuard[]) setNextFocusLeftId.clone();
                throw new ArithmeticException();
            }
            APIGuard[] aPIGuardArr2 = (APIGuard[]) setNextFocusLeftId.clone();
            int i2 = setNextFocusForwardId + 67;
            setNextFocusDownId = i2 % 128;
            if ((i2 % 2 == 0 ? (char) 27 : 'c') == 'c') {
                return aPIGuardArr2;
            }
            throw null;
        }

        static {
            AGState();
            Object[] objArr = new Object[1];
            APIGuard((char) TextUtils.getCapsMode("", 0, 0), 21 - Process.getGidForName(""), View.MeasureSpec.getSize(0), objArr);
            setOnClickListener = new APIGuard(((String) objArr[0]).intern(), 0, "");
            Object[] objArr2 = new Object[1];
            APIGuard((char) (25261 - Drawable.resolveOpacity(0, 0)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 8, 22 - View.MeasureSpec.getSize(0), objArr2);
            String intern = ((String) objArr2[0]).intern();
            Object[] objArr3 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getEdgeSlop() >> 16) + 29017), 2 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 30 - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr3);
            APIGuard aPIGuard = new APIGuard(intern, 1, ((String) objArr3[0]).intern());
            AGState = aPIGuard;
            Object[] objArr4 = new Object[1];
            APIGuard((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), 27 - Color.argb(0, 0, 0, 0), MotionEvent.axisFromString("") + 33, objArr4);
            String intern2 = ((String) objArr4[0]).intern();
            Object[] objArr5 = new Object[1];
            APIGuard((char) (ViewConfiguration.getTapTimeout() >> 16), (ViewConfiguration.getScrollBarSize() >> 8) + 2, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 59, objArr5);
            APIGuard aPIGuard2 = new APIGuard(intern2, 2, ((String) objArr5[0]).intern());
            valueOf = aPIGuard2;
            Object[] objArr6 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 26303), TextUtils.getOffsetAfter("", 0) + 17, AndroidCharacter.getMirror('0') + '\r', objArr6);
            String intern3 = ((String) objArr6[0]).intern();
            Object[] objArr7 = new Object[1];
            APIGuard((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, 78 - TextUtils.getOffsetBefore("", 0), objArr7);
            APIGuard aPIGuard3 = new APIGuard(intern3, 3, ((String) objArr7[0]).intern());
            APIGuard = aPIGuard3;
            Object[] objArr8 = new Object[1];
            APIGuard((char) (49107 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24)), (ViewConfiguration.getTouchSlop() >> 8) + 26, (ViewConfiguration.getTapTimeout() >> 16) + 81, objArr8);
            String intern4 = ((String) objArr8[0]).intern();
            Object[] objArr9 = new Object[1];
            APIGuard((char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), (ViewConfiguration.getPressedStateDuration() >> 16) + 3, 107 - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr9);
            APIGuard aPIGuard4 = new APIGuard(intern4, 4, ((String) objArr9[0]).intern());
            getSharedInstance = aPIGuard4;
            Object[] objArr10 = new Object[1];
            APIGuard((char) Color.red(0), 22 - TextUtils.getOffsetAfter("", 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 110, objArr10);
            String intern5 = ((String) objArr10[0]).intern();
            Object[] objArr11 = new Object[1];
            APIGuard((char) (32978 - ImageFormat.getBitsPerPixel(0)), ExpandableListView.getPackedPositionType(0L) + 3, Process.getGidForName("") + 133, objArr11);
            APIGuard aPIGuard5 = new APIGuard(intern5, 5, ((String) objArr11[0]).intern());
            values = aPIGuard5;
            Object[] objArr12 = new Object[1];
            APIGuard((char) (ExpandableListView.getPackedPositionGroup(0L) + 4093), View.getDefaultSize(0, 0) + 22, 134 - MotionEvent.axisFromString(""), objArr12);
            String intern6 = ((String) objArr12[0]).intern();
            Object[] objArr13 = new Object[1];
            APIGuard((char) (KeyEvent.getDeadChar(0, 0) + 41309), 3 - Color.red(0), 157 - TextUtils.getOffsetAfter("", 0), objArr13);
            APIGuard aPIGuard6 = new APIGuard(intern6, 6, ((String) objArr13[0]).intern());
            initialize = aPIGuard6;
            Object[] objArr14 = new Object[1];
            APIGuard((char) (53411 - KeyEvent.getDeadChar(0, 0)), 'C' - AndroidCharacter.getMirror('0'), TextUtils.lastIndexOf("", '0', 0) + 161, objArr14);
            String intern7 = ((String) objArr14[0]).intern();
            Object[] objArr15 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 61054), 3 - KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 179, objArr15);
            APIGuard aPIGuard7 = new APIGuard(intern7, 7, ((String) objArr15[0]).intern());
            parseResponseHeaders = aPIGuard7;
            Object[] objArr16 = new Object[1];
            APIGuard((char) ((Process.myPid() >> 22) + 13745), TextUtils.lastIndexOf("", '0') + 20, 182 - View.resolveSizeAndState(0, 0, 0), objArr16);
            String intern8 = ((String) objArr16[0]).intern();
            Object[] objArr17 = new Object[1];
            APIGuard((char) (61808 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1))), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, 200 - TextUtils.lastIndexOf("", '0'), objArr17);
            APIGuard aPIGuard8 = new APIGuard(intern8, 8, ((String) objArr17[0]).intern());
            analyzeResponse = aPIGuard8;
            Object[] objArr18 = new Object[1];
            APIGuard((char) (TextUtils.indexOf("", "", 0) + 17650), 20 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), Color.red(0) + 204, objArr18);
            String intern9 = ((String) objArr18[0]).intern();
            Object[] objArr19 = new Object[1];
            APIGuard((char) (Color.rgb(0, 0, 0) + 16809259), 3 - (ViewConfiguration.getWindowTouchSlop() >> 8), 224 - View.getDefaultSize(0, 0), objArr19);
            APIGuard aPIGuard9 = new APIGuard(intern9, 9, ((String) objArr19[0]).intern());
            getRequestHeaders = aPIGuard9;
            Object[] objArr20 = new Object[1];
            APIGuard((char) (53495 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), 17 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), 227 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr20);
            String intern10 = ((String) objArr20[0]).intern();
            Object[] objArr21 = new Object[1];
            APIGuard((char) (TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1), 4 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 244 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr21);
            APIGuard aPIGuard10 = new APIGuard(intern10, 10, ((String) objArr21[0]).intern());
            generateHeaders = aPIGuard10;
            Object[] objArr22 = new Object[1];
            APIGuard((char) (Color.green(0) + 57749), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 24, ExpandableListView.getPackedPositionChild(0L) + 248, objArr22);
            String intern11 = ((String) objArr22[0]).intern();
            Object[] objArr23 = new Object[1];
            APIGuard((char) (TextUtils.lastIndexOf("", '0') + 1), Color.alpha(0) + 3, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 270, objArr23);
            APIGuard aPIGuard11 = new APIGuard(intern11, 11, ((String) objArr23[0]).intern());
            checkCertificates = aPIGuard11;
            Object[] objArr24 = new Object[1];
            APIGuard((char) (46571 - (ViewConfiguration.getScrollBarFadeDuration() >> 16)), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 17, 274 - View.MeasureSpec.getSize(0), objArr24);
            String intern12 = ((String) objArr24[0]).intern();
            Object[] objArr25 = new Object[1];
            APIGuard((char) (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 3, 339 - AndroidCharacter.getMirror('0'), objArr25);
            APIGuard aPIGuard12 = new APIGuard(intern12, 12, ((String) objArr25[0]).intern());
            log = aPIGuard12;
            Object[] objArr26 = new Object[1];
            APIGuard((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) - 1), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 24, (ViewConfiguration.getWindowTouchSlop() >> 8) + 294, objArr26);
            String intern13 = ((String) objArr26[0]).intern();
            Object[] objArr27 = new Object[1];
            APIGuard((char) (Color.red(0) + 62814), (ViewConfiguration.getScrollBarSize() >> 8) + 3, TextUtils.getCapsMode("", 0, 0) + 318, objArr27);
            APIGuard aPIGuard13 = new APIGuard(intern13, 13, ((String) objArr27[0]).intern());
            updateKernel = aPIGuard13;
            Object[] objArr28 = new Object[1];
            APIGuard((char) (ViewConfiguration.getScrollBarFadeDuration() >> 16), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 21, Color.argb(0, 0, 0, 0) + 321, objArr28);
            String intern14 = ((String) objArr28[0]).intern();
            Object[] objArr29 = new Object[1];
            APIGuard((char) (56501 - Gravity.getAbsoluteGravity(0, 0)), (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 2, 342 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr29);
            setOnLongClickListener = new APIGuard(intern14, 14, ((String) objArr29[0]).intern());
            Object[] objArr30 = new Object[1];
            APIGuard((char) (TextUtils.indexOf((CharSequence) "", '0') + 1), 15 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 345 - TextUtils.indexOf("", "", 0, 0), objArr30);
            String intern15 = ((String) objArr30[0]).intern();
            Object[] objArr31 = new Object[1];
            APIGuard((char) (25297 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), ExpandableListView.getPackedPositionGroup(0L) + 3, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 359, objArr31);
            setOnGenericMotionListener = new APIGuard(intern15, 15, ((String) objArr31[0]).intern());
            Object[] objArr32 = new Object[1];
            APIGuard((char) (23589 - TextUtils.indexOf((CharSequence) "", '0')), 33 - ExpandableListView.getPackedPositionGroup(0L), 362 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr32);
            String intern16 = ((String) objArr32[0]).intern();
            Object[] objArr33 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getScrollBarSize() >> 8) + 7269), (KeyEvent.getMaxKeyCode() >> 16) + 3, TextUtils.lastIndexOf("", '0', 0) + 396, objArr33);
            APIGuard aPIGuard14 = new APIGuard(intern16, 16, ((String) objArr33[0]).intern());
            APIGuard$Callback = aPIGuard14;
            Object[] objArr34 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", ""), (Process.myPid() >> 22) + 32, 399 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr34);
            String intern17 = ((String) objArr34[0]).intern();
            Object[] objArr35 = new Object[1];
            APIGuard((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), TextUtils.getOffsetBefore("", 0) + 3, (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + HereOauthManager.TOO_MANY_REQUEST_CODE, objArr35);
            APIGuard aPIGuard15 = new APIGuard(intern17, 17, ((String) objArr35[0]).intern());
            getState = aPIGuard15;
            Object[] objArr36 = new Object[1];
            APIGuard((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 15 - (KeyEvent.getMaxKeyCode() >> 16), 433 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr36);
            String intern18 = ((String) objArr36[0]).intern();
            Object[] objArr37 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 34250), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 448, objArr37);
            APIGuard aPIGuard16 = new APIGuard(intern18, 18, ((String) objArr37[0]).intern());
            APIGuard$InitializationCallback = aPIGuard16;
            Object[] objArr38 = new Object[1];
            APIGuard((char) ExpandableListView.getPackedPositionType(0L), 17 - (Process.myTid() >> 22), 452 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr38);
            String intern19 = ((String) objArr38[0]).intern();
            Object[] objArr39 = new Object[1];
            APIGuard((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), TextUtils.indexOf((CharSequence) "", '0') + 4, (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 468, objArr39);
            APIGuard aPIGuard17 = new APIGuard(intern19, 19, ((String) objArr39[0]).intern());
            BuildConfig = aPIGuard17;
            Object[] objArr40 = new Object[1];
            APIGuard((char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1), 30 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 471, objArr40);
            String intern20 = ((String) objArr40[0]).intern();
            Object[] objArr41 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", "", 0), 3 - TextUtils.indexOf("", "", 0), 502 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr41);
            APIGuard aPIGuard18 = new APIGuard(intern20, 20, ((String) objArr41[0]).intern());
            pushMinPayload = aPIGuard18;
            Object[] objArr42 = new Object[1];
            APIGuard((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 23, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + SecExceptionCode.SEC_ERROR_DYN_STORE_GET_ENCRYPT_KEY_FAILED, objArr42);
            String intern21 = ((String) objArr42[0]).intern();
            Object[] objArr43 = new Object[1];
            APIGuard((char) View.MeasureSpec.makeMeasureSpec(0, 0), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 3, Color.blue(0) + 527, objArr43);
            APIGuard aPIGuard19 = new APIGuard(intern21, 21, ((String) objArr43[0]).intern());
            onInitializationFailure = aPIGuard19;
            Object[] objArr44 = new Object[1];
            APIGuard((char) (ImageFormat.getBitsPerPixel(0) + 1), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 24, (ViewConfiguration.getWindowTouchSlop() >> 8) + 530, objArr44);
            String intern22 = ((String) objArr44[0]).intern();
            Object[] objArr45 = new Object[1];
            APIGuard((char) (33624 - (ViewConfiguration.getScrollBarSize() >> 8)), ((byte) KeyEvent.getModifierMetaStateMask()) + 4, 553 - Process.getGidForName(""), objArr45);
            APIGuard aPIGuard20 = new APIGuard(intern22, 22, ((String) objArr45[0]).intern());
            onInitializationSuccess = aPIGuard20;
            Object[] objArr46 = new Object[1];
            APIGuard((char) (53858 - (ViewConfiguration.getWindowTouchSlop() >> 8)), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 25, 557 - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr46);
            String intern23 = ((String) objArr46[0]).intern();
            Object[] objArr47 = new Object[1];
            APIGuard((char) (TextUtils.indexOf("", "", 0) + 46018), (ViewConfiguration.getTapTimeout() >> 16) + 3, (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 583, objArr47);
            APIGuard aPIGuard21 = new APIGuard(intern23, 23, ((String) objArr47[0]).intern());
            clearCallback = aPIGuard21;
            Object[] objArr48 = new Object[1];
            APIGuard((char) ((-1) - ExpandableListView.getPackedPositionChild(0L)), (ViewConfiguration.getTapTimeout() >> 16) + 19, (ViewConfiguration.getFadingEdgeLength() >> 16) + 586, objArr48);
            String intern24 = ((String) objArr48[0]).intern();
            Object[] objArr49 = new Object[1];
            APIGuard((char) (58140 - MotionEvent.axisFromString("")), (KeyEvent.getMaxKeyCode() >> 16) + 3, 605 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr49);
            APIGuard aPIGuard22 = new APIGuard(intern24, 24, ((String) objArr49[0]).intern());
            pushMaxPayload = aPIGuard22;
            Object[] objArr50 = new Object[1];
            APIGuard((char) (TextUtils.indexOf("", "") + 31787), 22 - ImageFormat.getBitsPerPixel(0), 608 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), objArr50);
            String intern25 = ((String) objArr50[0]).intern();
            Object[] objArr51 = new Object[1];
            APIGuard((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 2 - TextUtils.indexOf((CharSequence) "", '0'), (-16776585) - Color.rgb(0, 0, 0), objArr51);
            APIGuard aPIGuard23 = new APIGuard(intern25, 25, ((String) objArr51[0]).intern());
            getVersion = aPIGuard23;
            Object[] objArr52 = new Object[1];
            APIGuard((char) (21157 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1))), Color.red(0) + 24, 634 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr52);
            String intern26 = ((String) objArr52[0]).intern();
            Object[] objArr53 = new Object[1];
            APIGuard((char) (Process.myTid() >> 22), KeyEvent.getDeadChar(0, 0) + 3, 658 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr53);
            APIGuard aPIGuard24 = new APIGuard(intern26, 26, ((String) objArr53[0]).intern());
            send = aPIGuard24;
            Object[] objArr54 = new Object[1];
            APIGuard((char) TextUtils.getOffsetBefore("", 0), 25 - (ViewConfiguration.getKeyRepeatDelay() >> 16), (ViewConfiguration.getKeyRepeatDelay() >> 16) + 661, objArr54);
            String intern27 = ((String) objArr54[0]).intern();
            Object[] objArr55 = new Object[1];
            APIGuard((char) View.MeasureSpec.getMode(0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 3, 685 - ExpandableListView.getPackedPositionChild(0L), objArr55);
            APIGuard aPIGuard25 = new APIGuard(intern27, 27, ((String) objArr55[0]).intern());
            AnalysesEntry = aPIGuard25;
            Object[] objArr56 = new Object[1];
            APIGuard((char) KeyEvent.normalizeMetaState(0), 14 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getScrollBarSize() >> 8) + 689, objArr56);
            String intern28 = ((String) objArr56[0]).intern();
            Object[] objArr57 = new Object[1];
            APIGuard((char) (ViewConfiguration.getEdgeSlop() >> 16), TextUtils.getOffsetAfter("", 0) + 3, 702 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr57);
            APIGuard aPIGuard26 = new APIGuard(intern28, 28, ((String) objArr57[0]).intern());
            Config = aPIGuard26;
            Object[] objArr58 = new Object[1];
            APIGuard((char) ((Process.getThreadPriority(0) + 20) >> 6), TextUtils.indexOf((CharSequence) "", '0', 0) + 29, Color.red(0) + 706, objArr58);
            String intern29 = ((String) objArr58[0]).intern();
            Object[] objArr59 = new Object[1];
            APIGuard((char) (23975 - View.MeasureSpec.getSize(0)), Drawable.resolveOpacity(0, 0) + 3, (KeyEvent.getMaxKeyCode() >> 16) + 734, objArr59);
            APIGuard aPIGuard27 = new APIGuard(intern29, 29, ((String) objArr59[0]).intern());
            FraudScore = aPIGuard27;
            Object[] objArr60 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getTouchSlop() >> 8) + 38786), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 31, (ViewConfiguration.getKeyRepeatDelay() >> 16) + 737, objArr60);
            String intern30 = ((String) objArr60[0]).intern();
            Object[] objArr61 = new Object[1];
            APIGuard((char) (12313 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), 3 - View.resolveSizeAndState(0, 0, 0), 769 - (Process.myPid() >> 22), objArr61);
            APIGuard aPIGuard28 = new APIGuard(intern30, 30, ((String) objArr61[0]).intern());
            SConfig = aPIGuard28;
            Object[] objArr62 = new Object[1];
            APIGuard((char) ('0' - AndroidCharacter.getMirror('0')), KeyEvent.getDeadChar(0, 0) + 22, (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 772, objArr62);
            String intern31 = ((String) objArr62[0]).intern();
            Object[] objArr63 = new Object[1];
            APIGuard((char) (57928 - Color.red(0)), 3 - TextUtils.getTrimmedLength(""), 794 - TextUtils.indexOf("", ""), objArr63);
            APIGuard aPIGuard29 = new APIGuard(intern31, 31, ((String) objArr63[0]).intern());
            ScoredEntry = aPIGuard29;
            Object[] objArr64 = new Object[1];
            APIGuard((char) (4126 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 23 - (ViewConfiguration.getScrollBarFadeDuration() >> 16), 797 - (ViewConfiguration.getTouchSlop() >> 8), objArr64);
            String intern32 = ((String) objArr64[0]).intern();
            Object[] objArr65 = new Object[1];
            APIGuard((char) (64073 - KeyEvent.keyCodeFromString("")), 3 - ExpandableListView.getPackedPositionType(0L), 820 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr65);
            APIGuard aPIGuard30 = new APIGuard(intern32, 32, ((String) objArr65[0]).intern());
            BHT = aPIGuard30;
            Object[] objArr66 = new Object[1];
            APIGuard((char) View.MeasureSpec.getSize(0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) + 22, TextUtils.getTrimmedLength("") + 823, objArr66);
            String intern33 = ((String) objArr66[0]).intern();
            Object[] objArr67 = new Object[1];
            APIGuard((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 3, ExpandableListView.getPackedPositionChild(0L) + 846, objArr67);
            APIGuard aPIGuard31 = new APIGuard(intern33, 33, ((String) objArr67[0]).intern());
            ce = aPIGuard31;
            Object[] objArr68 = new Object[1];
            APIGuard((char) (Color.argb(0, 0, 0, 0) + 58201), KeyEvent.getDeadChar(0, 0) + 17, 848 - (Process.myTid() >> 22), objArr68);
            String intern34 = ((String) objArr68[0]).intern();
            Object[] objArr69 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", "", 0), (ViewConfiguration.getEdgeSlop() >> 16) + 3, 865 - (Process.myTid() >> 22), objArr69);
            APIGuard aPIGuard32 = new APIGuard(intern34, 34, ((String) objArr69[0]).intern());
            rm = aPIGuard32;
            Object[] objArr70 = new Object[1];
            APIGuard((char) (ViewConfiguration.getTapTimeout() >> 16), 18 - Drawable.resolveOpacity(0, 0), TextUtils.indexOf((CharSequence) "", '0') + 869, objArr70);
            String intern35 = ((String) objArr70[0]).intern();
            Object[] objArr71 = new Object[1];
            APIGuard((char) (TextUtils.lastIndexOf("", '0') + 1), 4 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), View.MeasureSpec.getSize(0) + 886, objArr71);
            APIGuard aPIGuard33 = new APIGuard(intern35, 35, ((String) objArr71[0]).intern());
            C = aPIGuard33;
            Object[] objArr72 = new Object[1];
            APIGuard((char) (39056 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 38 - Gravity.getAbsoluteGravity(0, 0), 890 - (ViewConfiguration.getLongPressTimeout() >> 16), objArr72);
            String intern36 = ((String) objArr72[0]).intern();
            Object[] objArr73 = new Object[1];
            APIGuard((char) TextUtils.getCapsMode("", 0, 0), 2 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 927, objArr73);
            APIGuard aPIGuard34 = new APIGuard(intern36, 36, ((String) objArr73[0]).intern());
            am = aPIGuard34;
            Object[] objArr74 = new Object[1];
            APIGuard((char) (((byte) KeyEvent.getModifierMetaStateMask()) + 33713), 36 - (ViewConfiguration.getTapTimeout() >> 16), Gravity.getAbsoluteGravity(0, 0) + 930, objArr74);
            String intern37 = ((String) objArr74[0]).intern();
            Object[] objArr75 = new Object[1];
            APIGuard((char) (View.MeasureSpec.makeMeasureSpec(0, 0) + 6805), (ViewConfiguration.getScrollBarSize() >> 8) + 2, (ViewConfiguration.getWindowTouchSlop() >> 8) + 966, objArr75);
            APIGuard aPIGuard35 = new APIGuard(intern37, 37, ((String) objArr75[0]).intern());
            rf = aPIGuard35;
            Object[] objArr76 = new Object[1];
            APIGuard((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 23, ((byte) KeyEvent.getModifierMetaStateMask()) + 969, objArr76);
            String intern38 = ((String) objArr76[0]).intern();
            Object[] objArr77 = new Object[1];
            APIGuard((char) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), 2 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 991 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr77);
            setOnKeyListener = new APIGuard(intern38, 38, ((String) objArr77[0]).intern());
            Object[] objArr78 = new Object[1];
            APIGuard((char) (TextUtils.lastIndexOf("", '0') + 11403), TextUtils.indexOf("", "", 0, 0) + 24, 993 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr78);
            String intern39 = ((String) objArr78[0]).intern();
            Object[] objArr79 = new Object[1];
            APIGuard((char) (11402 - Color.blue(0)), TextUtils.getCapsMode("", 0, 0) + 2, (-16776199) - Color.rgb(0, 0, 0), objArr79);
            setOnTouchListener = new APIGuard(intern39, 39, ((String) objArr79[0]).intern());
            Object[] objArr80 = new Object[1];
            APIGuard((char) ExpandableListView.getPackedPositionGroup(0L), MotionEvent.axisFromString("") + 25, (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 1020, objArr80);
            String intern40 = ((String) objArr80[0]).intern();
            Object[] objArr81 = new Object[1];
            APIGuard((char) (13688 - Color.argb(0, 0, 0, 0)), 2 - TextUtils.getCapsMode("", 0, 0), 1043 - TextUtils.indexOf("", "", 0, 0), objArr81);
            APIGuard aPIGuard36 = new APIGuard(intern40, 40, ((String) objArr81[0]).intern());
            gc = aPIGuard36;
            Object[] objArr82 = new Object[1];
            APIGuard((char) (37693 - TextUtils.getOffsetAfter("", 0)), 35 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), 1044 - ExpandableListView.getPackedPositionChild(0L), objArr82);
            String intern41 = ((String) objArr82[0]).intern();
            Object[] objArr83 = new Object[1];
            APIGuard((char) TextUtils.getTrimmedLength(""), 2 - (ViewConfiguration.getFadingEdgeLength() >> 16), View.resolveSizeAndState(0, 0, 0) + 1080, objArr83);
            APIGuard aPIGuard37 = new APIGuard(intern41, 41, ((String) objArr83[0]).intern());
            f7415de = aPIGuard37;
            Object[] objArr84 = new Object[1];
            APIGuard((char) (26246 - ExpandableListView.getPackedPositionType(0L)), 'G' - AndroidCharacter.getMirror('0'), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1082, objArr84);
            String intern42 = ((String) objArr84[0]).intern();
            Object[] objArr85 = new Object[1];
            APIGuard((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), 1 - Process.getGidForName(""), (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + SecExceptionCode.SEC_ERROE_OPENSDK_UNSUPPORTED_VERSION, objArr85);
            APIGuard aPIGuard38 = new APIGuard(intern42, 42, ((String) objArr85[0]).intern());
            cf = aPIGuard38;
            Object[] objArr86 = new Object[1];
            APIGuard((char) Color.red(0), 26 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + SecExceptionCode.SEC_ERROE_OPENSDK_NO_MEMORY, objArr86);
            String intern43 = ((String) objArr86[0]).intern();
            Object[] objArr87 = new Object[1];
            APIGuard((char) (TextUtils.indexOf((CharSequence) "", '0') + 30492), 1 - TextUtils.indexOf((CharSequence) "", '0', 0), 1132 - TextUtils.indexOf((CharSequence) "", '0', 0), objArr87);
            APIGuard aPIGuard39 = new APIGuard(intern43, 43, ((String) objArr87[0]).intern());
            gt = aPIGuard39;
            Object[] objArr88 = new Object[1];
            APIGuard((char) View.resolveSizeAndState(0, 0, 0), 21 - View.MeasureSpec.makeMeasureSpec(0, 0), AndroidCharacter.getMirror('0') + 1087, objArr88);
            String intern44 = ((String) objArr88[0]).intern();
            Object[] objArr89 = new Object[1];
            APIGuard((char) (View.resolveSizeAndState(0, 0, 0) + 59322), 2 - View.MeasureSpec.getSize(0), 1156 - View.MeasureSpec.getSize(0), objArr89);
            setOnCreateContextMenuListener = new APIGuard(intern44, 44, ((String) objArr89[0]).intern());
            Object[] objArr90 = new Object[1];
            APIGuard((char) (1 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1))), View.combineMeasuredStates(0, 0) + 30, 1157 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr90);
            String intern45 = ((String) objArr90[0]).intern();
            Object[] objArr91 = new Object[1];
            APIGuard((char) (Process.myTid() >> 22), 3 - TextUtils.getOffsetBefore("", 0), 1188 - Color.argb(0, 0, 0, 0), objArr91);
            APIGuard aPIGuard40 = new APIGuard(intern45, 45, ((String) objArr91[0]).intern());
            ss = aPIGuard40;
            Object[] objArr92 = new Object[1];
            APIGuard((char) KeyEvent.normalizeMetaState(0), (ViewConfiguration.getEdgeSlop() >> 16) + 14, (ViewConfiguration.getDoubleTapTimeout() >> 16) + 1191, objArr92);
            String intern46 = ((String) objArr92[0]).intern();
            Object[] objArr93 = new Object[1];
            APIGuard((char) ((Process.getThreadPriority(0) + 20) >> 6), 4 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 1205 - View.MeasureSpec.getSize(0), objArr93);
            APIGuard aPIGuard41 = new APIGuard(intern46, 46, ((String) objArr93[0]).intern());
            spi = aPIGuard41;
            Object[] objArr94 = new Object[1];
            APIGuard((char) (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 29, 1208 - KeyEvent.normalizeMetaState(0), objArr94);
            String intern47 = ((String) objArr94[0]).intern();
            Object[] objArr95 = new Object[1];
            APIGuard((char) (View.MeasureSpec.getSize(0) + 15145), 3 - Color.red(0), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 1237, objArr95);
            APIGuard aPIGuard42 = new APIGuard(intern47, 47, ((String) objArr95[0]).intern());
            cs = aPIGuard42;
            Object[] objArr96 = new Object[1];
            APIGuard((char) (ViewConfiguration.getTapTimeout() >> 16), 23 - ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) + 1240, objArr96);
            String intern48 = ((String) objArr96[0]).intern();
            Object[] objArr97 = new Object[1];
            APIGuard((char) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), 3 - View.MeasureSpec.makeMeasureSpec(0, 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1264, objArr97);
            APIGuard aPIGuard43 = new APIGuard(intern48, 48, ((String) objArr97[0]).intern());
            sc = aPIGuard43;
            Object[] objArr98 = new Object[1];
            APIGuard((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 22, (ViewConfiguration.getScrollBarFadeDuration() >> 16) + 1267, objArr98);
            String intern49 = ((String) objArr98[0]).intern();
            Object[] objArr99 = new Object[1];
            APIGuard((char) (56071 - View.combineMeasuredStates(0, 0)), ImageFormat.getBitsPerPixel(0) + 4, (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 1289, objArr99);
            APIGuard aPIGuard44 = new APIGuard(intern49, 49, ((String) objArr99[0]).intern());
            D = aPIGuard44;
            Object[] objArr100 = new Object[1];
            APIGuard((char) ((-1) - TextUtils.lastIndexOf("", '0', 0)), (Process.myPid() >> 22) + 17, Color.alpha(0) + 1292, objArr100);
            String intern50 = ((String) objArr100[0]).intern();
            Object[] objArr101 = new Object[1];
            APIGuard((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 4674), 3 - (ViewConfiguration.getJumpTapTimeout() >> 16), (Process.myPid() >> 22) + 1309, objArr101);
            APIGuard aPIGuard45 = new APIGuard(intern50, 50, ((String) objArr101[0]).intern());
            ipi = aPIGuard45;
            Object[] objArr102 = new Object[1];
            APIGuard((char) View.MeasureSpec.makeMeasureSpec(0, 0), 24 - (Process.myPid() >> 22), Color.rgb(0, 0, 0) + 16778528, objArr102);
            String intern51 = ((String) objArr102[0]).intern();
            Object[] objArr103 = new Object[1];
            APIGuard((char) ((-1) - ((byte) KeyEvent.getModifierMetaStateMask())), TextUtils.indexOf("", "", 0, 0) + 3, 1335 - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr103);
            APIGuard aPIGuard46 = new APIGuard(intern51, 51, ((String) objArr103[0]).intern());
            E = aPIGuard46;
            Object[] objArr104 = new Object[1];
            APIGuard((char) (55758 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, 1340 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr104);
            String intern52 = ((String) objArr104[0]).intern();
            Object[] objArr105 = new Object[1];
            APIGuard((char) (AndroidCharacter.getMirror('0') + 26382), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2, 1363 - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr105);
            APIGuard aPIGuard47 = new APIGuard(intern52, 52, ((String) objArr105[0]).intern());
            dpi = aPIGuard47;
            Object[] objArr106 = new Object[1];
            APIGuard((char) (ViewConfiguration.getScrollDefaultDelay() >> 16), MotionEvent.axisFromString("") + 27, 1366 - View.combineMeasuredStates(0, 0), objArr106);
            String intern53 = ((String) objArr106[0]).intern();
            Object[] objArr107 = new Object[1];
            APIGuard((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), MotionEvent.axisFromString("") + 4, Gravity.getAbsoluteGravity(0, 0) + 1392, objArr107);
            APIGuard aPIGuard48 = new APIGuard(intern53, 53, ((String) objArr107[0]).intern());
            sdf = aPIGuard48;
            Object[] objArr108 = new Object[1];
            APIGuard((char) View.resolveSize(0, 0), (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 31, 1394 - ExpandableListView.getPackedPositionChild(0L), objArr108);
            String intern54 = ((String) objArr108[0]).intern();
            Object[] objArr109 = new Object[1];
            APIGuard((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 3 - (ViewConfiguration.getTouchSlop() >> 8), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1427, objArr109);
            APIGuard aPIGuard49 = new APIGuard(intern54, 54, ((String) objArr109[0]).intern());
            writeReplace = aPIGuard49;
            Object[] objArr110 = new Object[1];
            APIGuard((char) (TextUtils.indexOf((CharSequence) "", '0') + 11052), (ViewConfiguration.getTapTimeout() >> 16) + 25, 1430 - View.MeasureSpec.getMode(0), objArr110);
            String intern55 = ((String) objArr110[0]).intern();
            Object[] objArr111 = new Object[1];
            APIGuard((char) KeyEvent.normalizeMetaState(0), 3 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 1454 - TextUtils.lastIndexOf("", '0'), objArr111);
            APIGuard aPIGuard50 = new APIGuard(intern55, 55, ((String) objArr111[0]).intern());
            readObject = aPIGuard50;
            Object[] objArr112 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", "", 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 26, 1458 - (ViewConfiguration.getKeyRepeatDelay() >> 16), objArr112);
            String intern56 = ((String) objArr112[0]).intern();
            Object[] objArr113 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + FirebaseError.ERROR_INVALID_CREDENTIAL), 4 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), View.MeasureSpec.makeMeasureSpec(0, 0) + 1484, objArr113);
            APIGuard aPIGuard51 = new APIGuard(intern56, 56, ((String) objArr113[0]).intern());
            E$CvmPayloadSerializationProxy = aPIGuard51;
            Object[] objArr114 = new Object[1];
            APIGuard((char) (48048 - ((byte) KeyEvent.getModifierMetaStateMask())), 22 - Color.red(0), 1487 - TextUtils.getOffsetBefore("", 0), objArr114);
            String intern57 = ((String) objArr114[0]).intern();
            Object[] objArr115 = new Object[1];
            APIGuard((char) ((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 8220), MotionEvent.axisFromString("") + 4, 1510 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr115);
            APIGuard aPIGuard52 = new APIGuard(intern57, 57, ((String) objArr115[0]).intern());
            FU = aPIGuard52;
            Object[] objArr116 = new Object[1];
            APIGuard((char) (ViewConfiguration.getKeyRepeatDelay() >> 16), 29 - (ViewConfiguration.getLongPressTimeout() >> 16), (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 1512, objArr116);
            String intern58 = ((String) objArr116[0]).intern();
            Object[] objArr117 = new Object[1];
            APIGuard((char) (51189 - View.MeasureSpec.makeMeasureSpec(0, 0)), AndroidCharacter.getMirror('0') - '-', Color.red(0) + 1541, objArr117);
            APIGuard aPIGuard53 = new APIGuard(intern58, 58, ((String) objArr117[0]).intern());
            readResolve = aPIGuard53;
            Object[] objArr118 = new Object[1];
            APIGuard((char) (22990 - View.getDefaultSize(0, 0)), View.MeasureSpec.makeMeasureSpec(0, 0) + 21, 1543 - ImageFormat.getBitsPerPixel(0), objArr118);
            String intern59 = ((String) objArr118[0]).intern();
            Object[] objArr119 = new Object[1];
            APIGuard((char) Gravity.getAbsoluteGravity(0, 0), 3 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 1565 - ExpandableListView.getPackedPositionGroup(0L), objArr119);
            setOnHoverListener = new APIGuard(intern59, 59, ((String) objArr119[0]).intern());
            Object[] objArr120 = new Object[1];
            APIGuard((char) (6696 - (ViewConfiguration.getKeyRepeatTimeout() >> 16)), View.combineMeasuredStates(0, 0) + 23, 1569 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), objArr120);
            String intern60 = ((String) objArr120[0]).intern();
            Object[] objArr121 = new Object[1];
            APIGuard((char) (Color.green(0) + 40558), (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, 1591 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr121);
            APIGuard aPIGuard54 = new APIGuard(intern60, 60, ((String) objArr121[0]).intern());
            NTE = aPIGuard54;
            Object[] objArr122 = new Object[1];
            APIGuard((char) ((Process.getThreadPriority(0) + 20) >> 6), 22 - (ViewConfiguration.getScrollDefaultDelay() >> 16), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1594, objArr122);
            String intern61 = ((String) objArr122[0]).intern();
            Object[] objArr123 = new Object[1];
            APIGuard((char) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 27776), TextUtils.getTrimmedLength("") + 3, 1616 - KeyEvent.keyCodeFromString(""), objArr123);
            APIGuard aPIGuard55 = new APIGuard(intern61, 61, ((String) objArr123[0]).intern());
            MT = aPIGuard55;
            Object[] objArr124 = new Object[1];
            APIGuard((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0')), 21 - (ViewConfiguration.getJumpTapTimeout() >> 16), (ViewConfiguration.getEdgeSlop() >> 16) + 1619, objArr124);
            String intern62 = ((String) objArr124[0]).intern();
            Object[] objArr125 = new Object[1];
            APIGuard((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 3 - View.resolveSize(0, 0), TextUtils.lastIndexOf("", '0', 0, 0) + 1641, objArr125);
            setAutofillId = new APIGuard(intern62, 62, ((String) objArr125[0]).intern());
            Object[] objArr126 = new Object[1];
            APIGuard((char) (50759 - TextUtils.indexOf("", "", 0)), 31 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), 1643 - Gravity.getAbsoluteGravity(0, 0), objArr126);
            String intern63 = ((String) objArr126[0]).intern();
            Object[] objArr127 = new Object[1];
            APIGuard((char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), ((Process.getThreadPriority(0) + 20) >> 6) + 3, 1673 - View.resolveSize(0, 0), objArr127);
            APIGuard aPIGuard56 = new APIGuard(intern63, 63, ((String) objArr127[0]).intern());
            RB = aPIGuard56;
            Object[] objArr128 = new Object[1];
            APIGuard((char) Color.red(0), (ViewConfiguration.getTapTimeout() >> 16) + 21, 1677 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr128);
            String intern64 = ((String) objArr128[0]).intern();
            Object[] objArr129 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", ""), ((Process.getThreadPriority(0) + 20) >> 6) + 3, (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 1696, objArr129);
            setAccessibilityPaneTitle = new APIGuard(intern64, 64, ((String) objArr129[0]).intern());
            Object[] objArr130 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) - 1), 21 - Color.blue(0), 1700 - (ViewConfiguration.getTouchSlop() >> 8), objArr130);
            String intern65 = ((String) objArr130[0]).intern();
            Object[] objArr131 = new Object[1];
            APIGuard((char) TextUtils.getCapsMode("", 0, 0), 3 - (ViewConfiguration.getLongPressTimeout() >> 16), 1720 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr131);
            setOnDragListener = new APIGuard(intern65, 65, ((String) objArr131[0]).intern());
            Object[] objArr132 = new Object[1];
            APIGuard((char) (1 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1))), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 25, 1723 - MotionEvent.axisFromString(""), objArr132);
            String intern66 = ((String) objArr132[0]).intern();
            Object[] objArr133 = new Object[1];
            APIGuard((char) (Process.myPid() >> 22), 3 - (ViewConfiguration.getJumpTapTimeout() >> 16), 1748 - ((byte) KeyEvent.getModifierMetaStateMask()), objArr133);
            APIGuard aPIGuard57 = new APIGuard(intern66, 66, ((String) objArr133[0]).intern());
            ConfigInstance = aPIGuard57;
            Object[] objArr134 = new Object[1];
            APIGuard((char) (49756 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), 22 - ExpandableListView.getPackedPositionType(0L), 1753 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr134);
            String intern67 = ((String) objArr134[0]).intern();
            Object[] objArr135 = new Object[1];
            APIGuard((char) (ExpandableListView.getPackedPositionGroup(0L) + 19716), ImageFormat.getBitsPerPixel(0) + 4, 1774 - Color.blue(0), objArr135);
            APIGuard aPIGuard58 = new APIGuard(intern67, 67, ((String) objArr135[0]).intern());
            SLE = aPIGuard58;
            Object[] objArr136 = new Object[1];
            APIGuard((char) Drawable.resolveOpacity(0, 0), 20 - TextUtils.getOffsetBefore("", 0), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 1777, objArr136);
            String intern68 = ((String) objArr136[0]).intern();
            Object[] objArr137 = new Object[1];
            APIGuard((char) ((AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 10278), TextUtils.getOffsetBefore("", 0) + 3, 1798 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), objArr137);
            APIGuard aPIGuard59 = new APIGuard(intern68, 68, ((String) objArr137[0]).intern());
            KernelPayloadInstance = aPIGuard59;
            Object[] objArr138 = new Object[1];
            APIGuard((char) (4149 - View.resolveSizeAndState(0, 0, 0)), 28 - (ViewConfiguration.getPressedStateDuration() >> 16), TextUtils.indexOf("", "", 0, 0) + 1800, objArr138);
            String intern69 = ((String) objArr138[0]).intern();
            Object[] objArr139 = new Object[1];
            APIGuard((char) (Process.myPid() >> 22), Color.green(0) + 3, KeyEvent.keyCodeFromString("") + 1828, objArr139);
            APIGuard aPIGuard60 = new APIGuard(intern69, 69, ((String) objArr139[0]).intern());
            ConfigInstance$ConfigSerializationProxy = aPIGuard60;
            Object[] objArr140 = new Object[1];
            APIGuard((char) (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), ExpandableListView.getPackedPositionChild(0L) + 28, 1831 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr140);
            String intern70 = ((String) objArr140[0]).intern();
            Object[] objArr141 = new Object[1];
            APIGuard((char) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), View.MeasureSpec.makeMeasureSpec(0, 0) + 3, (ViewConfiguration.getFadingEdgeLength() >> 16) + 1858, objArr141);
            APIGuard aPIGuard61 = new APIGuard(intern70, 70, ((String) objArr141[0]).intern());
            KernelPayloadInstance$KernelPayloadSerializationProxy = aPIGuard61;
            Object[] objArr142 = new Object[1];
            APIGuard((char) (MotionEvent.axisFromString("") + 1), ExpandableListView.getPackedPositionType(0L) + 27, 1861 - (ViewConfiguration.getWindowTouchSlop() >> 8), objArr142);
            String intern71 = ((String) objArr142[0]).intern();
            Object[] objArr143 = new Object[1];
            APIGuard((char) (AndroidCharacter.getMirror('0') + 44166), 4 - (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)), 1888 - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr143);
            APIGuard aPIGuard62 = new APIGuard(intern71, 71, ((String) objArr143[0]).intern());
            UriFilter = aPIGuard62;
            Object[] objArr144 = new Object[1];
            APIGuard((char) (38360 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), (-16777192) - Color.rgb(0, 0, 0), 1892 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr144);
            String intern72 = ((String) objArr144[0]).intern();
            Object[] objArr145 = new Object[1];
            APIGuard((char) (TextUtils.lastIndexOf("", '0', 0) + 1), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 3, TextUtils.indexOf("", "") + 1915, objArr145);
            APIGuard aPIGuard63 = new APIGuard(intern72, 72, ((String) objArr145[0]).intern());
            UriFilter$UrlTest = aPIGuard63;
            Object[] objArr146 = new Object[1];
            APIGuard((char) (34629 - (Process.myPid() >> 22)), 26 - KeyEvent.getDeadChar(0, 0), (ViewConfiguration.getFadingEdgeLength() >> 16) + 1918, objArr146);
            String intern73 = ((String) objArr146[0]).intern();
            Object[] objArr147 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)) - 1), Color.blue(0) + 3, (ViewConfiguration.getScrollDefaultDelay() >> 16) + 1944, objArr147);
            APIGuard aPIGuard64 = new APIGuard(intern73, 73, ((String) objArr147[0]).intern());
            values$605170aa = aPIGuard64;
            Object[] objArr148 = new Object[1];
            APIGuard((char) (59551 - Gravity.getAbsoluteGravity(0, 0)), 24 - (ViewConfiguration.getTapTimeout() >> 16), 1947 - (ViewConfiguration.getTouchSlop() >> 8), objArr148);
            String intern74 = ((String) objArr148[0]).intern();
            Object[] objArr149 = new Object[1];
            APIGuard((char) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 3, 1971 - View.MeasureSpec.getMode(0), objArr149);
            APIGuard aPIGuard65 = new APIGuard(intern74, 74, ((String) objArr149[0]).intern());
            UriFilter$UrlMatcherSpec = aPIGuard65;
            Object[] objArr150 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", ""), 36 - TextUtils.getCapsMode("", 0, 0), TextUtils.indexOf((CharSequence) "", '0') + 1975, objArr150);
            String intern75 = ((String) objArr150[0]).intern();
            Object[] objArr151 = new Object[1];
            APIGuard((char) (25805 - KeyEvent.normalizeMetaState(0)), Color.green(0) + 3, 2010 - KeyEvent.getDeadChar(0, 0), objArr151);
            APIGuard aPIGuard66 = new APIGuard(intern75, 75, ((String) objArr151[0]).intern());
            MatchesConfig = aPIGuard66;
            Object[] objArr152 = new Object[1];
            APIGuard((char) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 26741), 34 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (ViewConfiguration.getPressedStateDuration() >> 16) + BioError.RESULT_FACEID_HIGH_RISK, objArr152);
            String intern76 = ((String) objArr152[0]).intern();
            Object[] objArr153 = new Object[1];
            APIGuard((char) (37568 - Color.blue(0)), 3 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (Process.myTid() >> 22) + 2046, objArr153);
            setRevealOnFocusHint = new APIGuard(intern76, 76, ((String) objArr153[0]).intern());
            Object[] objArr154 = new Object[1];
            APIGuard((char) KeyEvent.keyCodeFromString(""), 39 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 2097 - AndroidCharacter.getMirror('0'), objArr154);
            String intern77 = ((String) objArr154[0]).intern();
            Object[] objArr155 = new Object[1];
            APIGuard((char) (50394 - TextUtils.getTrimmedLength("")), Color.rgb(0, 0, 0) + 16777219, Color.rgb(0, 0, 0) + 16779303, objArr155);
            setImportantForAutofill = new APIGuard(intern77, 77, ((String) objArr155[0]).intern());
            Object[] objArr156 = new Object[1];
            APIGuard((char) (TextUtils.lastIndexOf("", '0') + 4385), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 47, View.resolveSizeAndState(0, 0, 0) + 2090, objArr156);
            String intern78 = ((String) objArr156[0]).intern();
            Object[] objArr157 = new Object[1];
            APIGuard((char) (58642 - TextUtils.indexOf((CharSequence) "", '0')), TextUtils.indexOf((CharSequence) "", '0', 0) + 4, TextUtils.indexOf("", "", 0, 0) + 2137, objArr157);
            setAccessibilityTraversalBefore = new APIGuard(intern78, 78, ((String) objArr157[0]).intern());
            Object[] objArr158 = new Object[1];
            APIGuard((char) KeyEvent.keyCodeFromString(""), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 50, 2139 - TextUtils.lastIndexOf("", '0', 0, 0), objArr158);
            String intern79 = ((String) objArr158[0]).intern();
            Object[] objArr159 = new Object[1];
            APIGuard((char) (Color.blue(0) + 49504), (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 3, 2191 - ((Process.getThreadPriority(0) + 20) >> 6), objArr159);
            APIGuard aPIGuard67 = new APIGuard(intern79, 79, ((String) objArr159[0]).intern());
            UriFilter$1 = aPIGuard67;
            Object[] objArr160 = new Object[1];
            APIGuard((char) (ViewConfiguration.getWindowTouchSlop() >> 8), 28 - Color.alpha(0), ExpandableListView.getPackedPositionGroup(0L) + 2194, objArr160);
            String intern80 = ((String) objArr160[0]).intern();
            Object[] objArr161 = new Object[1];
            APIGuard((char) (21464 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), '3' - AndroidCharacter.getMirror('0'), 2222 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), objArr161);
            APIGuard aPIGuard68 = new APIGuard(intern80, 80, ((String) objArr161[0]).intern());
            MatchConfig = aPIGuard68;
            Object[] objArr162 = new Object[1];
            APIGuard((char) TextUtils.indexOf("", "", 0, 0), 37 - TextUtils.indexOf("", "", 0), 2225 - View.MeasureSpec.getMode(0), objArr162);
            String intern81 = ((String) objArr162[0]).intern();
            Object[] objArr163 = new Object[1];
            APIGuard((char) View.MeasureSpec.getMode(0), 3 - Color.alpha(0), 2263 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr163);
            setContentDescription = new APIGuard(intern81, 81, ((String) objArr163[0]).intern());
            Object[] objArr164 = new Object[1];
            APIGuard((char) (ViewConfiguration.getWindowTouchSlop() >> 8), TextUtils.getOffsetBefore("", 0) + 28, 2265 - TextUtils.indexOf("", "", 0), objArr164);
            String intern82 = ((String) objArr164[0]).intern();
            Object[] objArr165 = new Object[1];
            APIGuard((char) (Color.rgb(0, 0, 0) + 16777216), (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 2, 2292 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), objArr165);
            setAccessibilityDelegate = new APIGuard(intern82, 82, ((String) objArr165[0]).intern());
            Object[] objArr166 = new Object[1];
            APIGuard((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 29 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), (-16774920) - Color.rgb(0, 0, 0), objArr166);
            String intern83 = ((String) objArr166[0]).intern();
            Object[] objArr167 = new Object[1];
            APIGuard((char) TextUtils.getTrimmedLength(""), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 2, 2324 - (ViewConfiguration.getEdgeSlop() >> 16), objArr167);
            setContentCaptureSession = new APIGuard(intern83, 83, ((String) objArr167[0]).intern());
            Object[] objArr168 = new Object[1];
            APIGuard((char) (54559 - (ViewConfiguration.getMaximumFlingVelocity() >> 16)), (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 31, (Process.myTid() >> 22) + 2327, objArr168);
            String intern84 = ((String) objArr168[0]).intern();
            Object[] objArr169 = new Object[1];
            APIGuard((char) (View.combineMeasuredStates(0, 0) + 51981), TextUtils.indexOf("", "", 0) + 3, View.resolveSizeAndState(0, 0, 0) + 2358, objArr169);
            APIGuard aPIGuard69 = new APIGuard(intern84, 84, ((String) objArr169[0]).intern());
            MatchConfig$Match = aPIGuard69;
            Object[] objArr170 = new Object[1];
            APIGuard((char) (41255 - KeyEvent.getDeadChar(0, 0)), 38 - View.resolveSize(0, 0), TextUtils.getTrimmedLength("") + 2361, objArr170);
            String intern85 = ((String) objArr170[0]).intern();
            Object[] objArr171 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getLongPressTimeout() >> 16) + 60743), 3 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 2399 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr171);
            APIGuard aPIGuard70 = new APIGuard(intern85, 85, ((String) objArr171[0]).intern());
            MatchesConfig$Matches = aPIGuard70;
            Object[] objArr172 = new Object[1];
            APIGuard((char) Color.blue(0), 27 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), View.getDefaultSize(0, 0) + SecExceptionCode.SEC_ERROR_UNIFIED_SECURITY_NO_APPKEY, objArr172);
            String intern86 = ((String) objArr172[0]).intern();
            Object[] objArr173 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getTapTimeout() >> 16) + 65182), TextUtils.indexOf("", "", 0) + 3, KeyEvent.normalizeMetaState(0) + 2429, objArr173);
            APIGuard aPIGuard71 = new APIGuard(intern86, 86, ((String) objArr173[0]).intern());
            setContentView = aPIGuard71;
            Object[] objArr174 = new Object[1];
            APIGuard((char) Drawable.resolveOpacity(0, 0), TextUtils.getTrimmedLength("") + 18, 2432 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), objArr174);
            String intern87 = ((String) objArr174[0]).intern();
            Object[] objArr175 = new Object[1];
            APIGuard((char) (8895 - (ViewConfiguration.getLongPressTimeout() >> 16)), 3 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), 2449 - TextUtils.indexOf((CharSequence) "", '0'), objArr175);
            APIGuard aPIGuard72 = new APIGuard(intern87, 87, ((String) objArr175[0]).intern());
            registerForContextMenu = aPIGuard72;
            Object[] objArr176 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getTapTimeout() >> 16) + 36515), 24 - ImageFormat.getBitsPerPixel(0), 2453 - (Process.myPid() >> 22), objArr176);
            String intern88 = ((String) objArr176[0]).intern();
            Object[] objArr177 = new Object[1];
            APIGuard((char) (Process.myPid() >> 22), (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, 2478 - (ViewConfiguration.getScrollDefaultDelay() >> 16), objArr177);
            setAccessibilityTraversalAfter = new APIGuard(intern88, 88, ((String) objArr177[0]).intern());
            Object[] objArr178 = new Object[1];
            APIGuard((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), ExpandableListView.getPackedPositionType(0L) + 32, TextUtils.indexOf("", "", 0) + 2481, objArr178);
            String intern89 = ((String) objArr178[0]).intern();
            Object[] objArr179 = new Object[1];
            APIGuard((char) (View.combineMeasuredStates(0, 0) + 25084), 3 - View.MeasureSpec.getSize(0), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 2513, objArr179);
            APIGuard aPIGuard73 = new APIGuard(intern89, 89, ((String) objArr179[0]).intern());
            UrlMatcherConfig = aPIGuard73;
            Object[] objArr180 = new Object[1];
            APIGuard((char) (59441 - View.MeasureSpec.makeMeasureSpec(0, 0)), (ViewConfiguration.getWindowTouchSlop() >> 8) + 19, 2516 - View.combineMeasuredStates(0, 0), objArr180);
            String intern90 = ((String) objArr180[0]).intern();
            Object[] objArr181 = new Object[1];
            APIGuard((char) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), 4 - (ViewConfiguration.getTapTimeout() >> 16), 2535 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr181);
            APIGuard aPIGuard74 = new APIGuard(intern90, 90, ((String) objArr181[0]).intern());
            UrlMatcher = aPIGuard74;
            Object[] objArr182 = new Object[1];
            APIGuard((char) (Color.green(0) + 48516), (-16777191) - Color.rgb(0, 0, 0), 2539 - (ViewConfiguration.getTapTimeout() >> 16), objArr182);
            String intern91 = ((String) objArr182[0]).intern();
            Object[] objArr183 = new Object[1];
            APIGuard((char) (47229 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1))), 4 - Gravity.getAbsoluteGravity(0, 0), Color.red(0) + 2564, objArr183);
            APIGuard aPIGuard75 = new APIGuard(intern91, 91, ((String) objArr183[0]).intern());
            onOptionsItemSelected = aPIGuard75;
            Object[] objArr184 = new Object[1];
            APIGuard((char) (33655 - TextUtils.indexOf("", "")), 20 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), 2568 - (ViewConfiguration.getTouchSlop() >> 8), objArr184);
            String intern92 = ((String) objArr184[0]).intern();
            Object[] objArr185 = new Object[1];
            APIGuard((char) (ViewConfiguration.getMinimumFlingVelocity() >> 16), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 3, MotionEvent.axisFromString("") + 2589, objArr185);
            APIGuard aPIGuard76 = new APIGuard(intern92, 92, ((String) objArr185[0]).intern());
            unregisterForContextMenu = aPIGuard76;
            Object[] objArr186 = new Object[1];
            APIGuard((char) Color.blue(0), (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 25, TextUtils.lastIndexOf("", '0', 0) + 2593, objArr186);
            String intern93 = ((String) objArr186[0]).intern();
            Object[] objArr187 = new Object[1];
            APIGuard((char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), 3 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 2617 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr187);
            setDrawingCacheQuality = new APIGuard(intern93, 93, ((String) objArr187[0]).intern());
            Object[] objArr188 = new Object[1];
            APIGuard((char) ((ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)) + 51945), 26 - (ViewConfiguration.getKeyRepeatDelay() >> 16), 2620 - View.resolveSizeAndState(0, 0, 0), objArr188);
            String intern94 = ((String) objArr188[0]).intern();
            Object[] objArr189 = new Object[1];
            APIGuard((char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.MeasureSpec.getSize(0) + 3, 2646 - (KeyEvent.getMaxKeyCode() >> 16), objArr189);
            setKeepScreenOn = new APIGuard(intern94, 94, ((String) objArr189[0]).intern());
            Object[] objArr190 = new Object[1];
            APIGuard((char) (41711 - Drawable.resolveOpacity(0, 0)), 39 - (ViewConfiguration.getDoubleTapTimeout() >> 16), (-16774567) - Color.rgb(0, 0, 0), objArr190);
            String intern95 = ((String) objArr190[0]).intern();
            Object[] objArr191 = new Object[1];
            APIGuard((char) (31758 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)), 3 - (ViewConfiguration.getEdgeSlop() >> 16), 2688 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr191);
            APIGuard aPIGuard77 = new APIGuard(intern95, 95, ((String) objArr191[0]).intern());
            openContextMenu = aPIGuard77;
            Object[] objArr192 = new Object[1];
            APIGuard((char) ((Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 24921), 22 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), 2691 - TextUtils.getTrimmedLength(""), objArr192);
            String intern96 = ((String) objArr192[0]).intern();
            Object[] objArr193 = new Object[1];
            APIGuard((char) (TextUtils.getOffsetBefore("", 0) + 12903), 3 - View.MeasureSpec.getSize(0), TextUtils.lastIndexOf("", '0', 0) + 2714, objArr193);
            APIGuard aPIGuard78 = new APIGuard(intern96, 96, ((String) objArr193[0]).intern());
            setVerticalScrollbarThumbDrawable = aPIGuard78;
            Object[] objArr194 = new Object[1];
            APIGuard((char) (ExpandableListView.getPackedPositionChild(0L) + 1), 37 - View.combineMeasuredStates(0, 0), TextUtils.lastIndexOf("", '0') + 2717, objArr194);
            String intern97 = ((String) objArr194[0]).intern();
            Object[] objArr195 = new Object[1];
            APIGuard((char) TextUtils.getOffsetBefore("", 0), (ViewConfiguration.getDoubleTapTimeout() >> 16) + 3, (-16774463) - Color.rgb(0, 0, 0), objArr195);
            APIGuard aPIGuard79 = new APIGuard(intern97, 97, ((String) objArr195[0]).intern());
            onContextItemSelected = aPIGuard79;
            Object[] objArr196 = new Object[1];
            APIGuard((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.getOffsetBefore("", 0) + 39, 2756 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr196);
            String intern98 = ((String) objArr196[0]).intern();
            Object[] objArr197 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 54204), (ViewConfiguration.getLongPressTimeout() >> 16) + 3, 2795 - (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), objArr197);
            APIGuard aPIGuard80 = new APIGuard(intern98, 98, ((String) objArr197[0]).intern());
            setFadingEdgeLength = aPIGuard80;
            Object[] objArr198 = new Object[1];
            APIGuard((char) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 38661), 34 - TextUtils.lastIndexOf("", '0', 0, 0), 2799 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr198);
            String intern99 = ((String) objArr198[0]).intern();
            Object[] objArr199 = new Object[1];
            APIGuard((char) (5055 - ImageFormat.getBitsPerPixel(0)), 4 - ExpandableListView.getPackedPositionGroup(0L), 2834 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), objArr199);
            APIGuard aPIGuard81 = new APIGuard(intern99, 99, ((String) objArr199[0]).intern());
            setVerticalScrollbarTrackDrawable = aPIGuard81;
            Object[] objArr200 = new Object[1];
            APIGuard((char) (145 - AndroidCharacter.getMirror('0')), (ViewConfiguration.getTapTimeout() >> 16) + 35, (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) + 2836, objArr200);
            String intern100 = ((String) objArr200[0]).intern();
            Object[] objArr201 = new Object[1];
            APIGuard((char) ((SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 1), 4 - (ViewConfiguration.getKeyRepeatTimeout() >> 16), Gravity.getAbsoluteGravity(0, 0) + 2872, objArr201);
            APIGuard aPIGuard82 = new APIGuard(intern100, 100, ((String) objArr201[0]).intern());
            setHorizontalScrollbarThumbDrawable = aPIGuard82;
            Object[] objArr202 = new Object[1];
            APIGuard((char) (55378 - View.combineMeasuredStates(0, 0)), 42 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), 2876 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), objArr202);
            String intern101 = ((String) objArr202[0]).intern();
            Object[] objArr203 = new Object[1];
            APIGuard((char) (6676 - ((byte) KeyEvent.getModifierMetaStateMask())), (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 4, View.MeasureSpec.getMode(0) + 2917, objArr203);
            APIGuard aPIGuard83 = new APIGuard(intern101, 101, ((String) objArr203[0]).intern());
            setHorizontalScrollbarTrackDrawable = aPIGuard83;
            Object[] objArr204 = new Object[1];
            APIGuard((char) (16368 - TextUtils.indexOf((CharSequence) "", '0')), TextUtils.lastIndexOf("", '0') + 40, 2921 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr204);
            String intern102 = ((String) objArr204[0]).intern();
            Object[] objArr205 = new Object[1];
            APIGuard((char) (40239 - ImageFormat.getBitsPerPixel(0)), 4 - (ViewConfiguration.getTouchSlop() >> 8), AndroidCharacter.getMirror('0') + 2912, objArr205);
            APIGuard aPIGuard84 = new APIGuard(intern102, 102, ((String) objArr205[0]).intern());
            setVerticalScrollbarPosition = aPIGuard84;
            Object[] objArr206 = new Object[1];
            APIGuard((char) (TextUtils.indexOf("", "", 0, 0) + 59692), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 25, 2964 - (ViewConfiguration.getMaximumFlingVelocity() >> 16), objArr206);
            String intern103 = ((String) objArr206[0]).intern();
            Object[] objArr207 = new Object[1];
            APIGuard((char) (4360 - View.resolveSizeAndState(0, 0, 0)), 4 - ((Process.getThreadPriority(0) + 20) >> 6), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 2990, objArr207);
            APIGuard aPIGuard85 = new APIGuard(intern103, 103, ((String) objArr207[0]).intern());
            setScrollIndicators = aPIGuard85;
            Object[] objArr208 = new Object[1];
            APIGuard((char) (Drawable.resolveOpacity(0, 0) + 28024), TextUtils.indexOf("", "") + 30, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 2993, objArr208);
            String intern104 = ((String) objArr208[0]).intern();
            Object[] objArr209 = new Object[1];
            APIGuard((char) (33748 - ExpandableListView.getPackedPositionType(0L)), 4 - (ViewConfiguration.getKeyRepeatDelay() >> 16), ((byte) KeyEvent.getModifierMetaStateMask()) + 3025, objArr209);
            APIGuard aPIGuard86 = new APIGuard(intern104, 104, ((String) objArr209[0]).intern());
            setOnFocusChangeListener = aPIGuard86;
            Object[] objArr210 = new Object[1];
            APIGuard((char) (16152 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), (ViewConfiguration.getLongPressTimeout() >> 16) + 21, (ViewConfiguration.getMaximumFlingVelocity() >> 16) + 3028, objArr210);
            String intern105 = ((String) objArr210[0]).intern();
            Object[] objArr211 = new Object[1];
            APIGuard((char) (ViewConfiguration.getMaximumFlingVelocity() >> 16), 4 - (ViewConfiguration.getDoubleTapTimeout() >> 16), 3049 - View.MeasureSpec.makeMeasureSpec(0, 0), objArr211);
            APIGuard aPIGuard87 = new APIGuard(intern105, 105, ((String) objArr211[0]).intern());
            setOnContextClickListener = aPIGuard87;
            Object[] objArr212 = new Object[1];
            APIGuard((char) (62001 - (ViewConfiguration.getEdgeSlop() >> 16)), View.MeasureSpec.makeMeasureSpec(0, 0) + 27, 3053 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), objArr212);
            String intern106 = ((String) objArr212[0]).intern();
            Object[] objArr213 = new Object[1];
            APIGuard((char) TextUtils.getOffsetBefore("", 0), ExpandableListView.getPackedPositionChild(0L) + 5, ExpandableListView.getPackedPositionType(0L) + 3080, objArr213);
            APIGuard aPIGuard88 = new APIGuard(intern106, 106, ((String) objArr213[0]).intern());
            setOnScrollChangeListener = aPIGuard88;
            setNextFocusLeftId = new APIGuard[]{setOnClickListener, aPIGuard, aPIGuard2, aPIGuard3, aPIGuard4, aPIGuard5, aPIGuard6, aPIGuard7, aPIGuard8, aPIGuard9, aPIGuard10, aPIGuard11, aPIGuard12, aPIGuard13, setOnLongClickListener, setOnGenericMotionListener, aPIGuard14, aPIGuard15, aPIGuard16, aPIGuard17, aPIGuard18, aPIGuard19, aPIGuard20, aPIGuard21, aPIGuard22, aPIGuard23, aPIGuard24, aPIGuard25, aPIGuard26, aPIGuard27, aPIGuard28, aPIGuard29, aPIGuard30, aPIGuard31, aPIGuard32, aPIGuard33, aPIGuard34, aPIGuard35, setOnKeyListener, setOnTouchListener, aPIGuard36, aPIGuard37, aPIGuard38, aPIGuard39, setOnCreateContextMenuListener, aPIGuard40, aPIGuard41, aPIGuard42, aPIGuard43, aPIGuard44, aPIGuard45, aPIGuard46, aPIGuard47, aPIGuard48, aPIGuard49, aPIGuard50, aPIGuard51, aPIGuard52, aPIGuard53, setOnHoverListener, aPIGuard54, aPIGuard55, setAutofillId, aPIGuard56, setAccessibilityPaneTitle, setOnDragListener, aPIGuard57, aPIGuard58, aPIGuard59, aPIGuard60, aPIGuard61, aPIGuard62, aPIGuard63, aPIGuard64, aPIGuard65, aPIGuard66, setRevealOnFocusHint, setImportantForAutofill, setAccessibilityTraversalBefore, aPIGuard67, aPIGuard68, setContentDescription, setAccessibilityDelegate, setContentCaptureSession, aPIGuard69, aPIGuard70, aPIGuard71, aPIGuard72, setAccessibilityTraversalAfter, aPIGuard73, aPIGuard74, aPIGuard75, aPIGuard76, setDrawingCacheQuality, setKeepScreenOn, aPIGuard77, aPIGuard78, aPIGuard79, aPIGuard80, aPIGuard81, aPIGuard82, aPIGuard83, aPIGuard84, aPIGuard85, aPIGuard86, aPIGuard87, aPIGuard88};
            setNextFocusDownId = (setNextFocusForwardId + 57) % 128;
        }

        private APIGuard(String str, int i, String str2) {
            this.code = str2;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
        public final String getSharedInstance() {
            int i = setNextFocusForwardId;
            setNextFocusDownId = (i + 53) % 128;
            String str = this.code;
            int i2 = i + 25;
            setNextFocusDownId = i2 % 128;
            if ((i2 % 2 == 0 ? Typography.quote : (char) 0) != '\"') {
                return str;
            }
            throw null;
        }

        private static void APIGuard(char c, int i, int i2, Object[] objArr) {
            String str;
            synchronized (setBackgroundTintList.AGState) {
                char[] cArr = new char[i];
                setBackgroundTintList.getSharedInstance = 0;
                while (setBackgroundTintList.getSharedInstance < i) {
                    cArr[setBackgroundTintList.getSharedInstance] = (char) ((setScrollContainer[setBackgroundTintList.getSharedInstance + i2] ^ (setBackgroundTintList.getSharedInstance * setLabelFor)) ^ c);
                    setBackgroundTintList.getSharedInstance++;
                }
                str = new String(cArr);
            }
            objArr[0] = str;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'getSharedInstance' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class getRequestHeaders implements ConfigInstance.ConfigSerializationProxy.AGState {
        private static final /* synthetic */ getRequestHeaders[] AGState;
        public static final getRequestHeaders APIGuard;
        private static int APIGuard$Callback = 1;
        private static int analyzeResponse;
        private static int checkCertificates;
        private static int generateHeaders;
        private static short[] getRequestHeaders;
        public static final getRequestHeaders getSharedInstance;
        private static int initialize;
        private static byte[] parseResponseHeaders;
        public static final getRequestHeaders valueOf;
        public static final getRequestHeaders values;
        private String code;

        static void AGState() {
            generateHeaders = -1217121122;
            analyzeResponse = -887590005;
            parseResponseHeaders = new byte[]{32, -33, 60, -45, 41, 41, -51, TarHeader.LF_NORMAL, -47, 45, -34, -42, -34, 47, 39, 43, 41, -37, 42, -39, 37, 37, 41, 43, -44, -43, -63, 60, 47, -39, -78, -83, -95, -81, 92, -84, 81, -86, -83, 94, -74, 89, 87, 83, -67, 95, 95, -93, 90, 81, 81, -75, 68, -91, -81, -56, -35, -47, -33, 44, -36, 33, -38, -35, 46, -58, 41, 39, 35, -51, 46, 34, TarHeader.LF_NORMAL, -45, -43, TarHeader.LF_DIR, -63, TarHeader.LF_BLK, -43, -33, 100, -118, Byte.MIN_VALUE, 125, 116, -126, -119, 124, 102, -110, -125, 109, -119, -124, -117, 109, -109, 100, -106, 123, -127, 122, -127, -115, 117, 109, -114, -4, 34, 0, 0, 0, 0, 0, 0, 0, 0};
            initialize = 39;
        }

        public static getRequestHeaders valueOf(String str) {
            int i = checkCertificates + 65;
            APIGuard$Callback = i % 128;
            boolean z = i % 2 == 0;
            getRequestHeaders getrequestheaders = (getRequestHeaders) Enum.valueOf(getRequestHeaders.class, str);
            if (z) {
                throw new ArithmeticException();
            }
            checkCertificates = (APIGuard$Callback + 39) % 128;
            return getrequestheaders;
        }

        public static getRequestHeaders[] values() {
            int i = checkCertificates + 85;
            APIGuard$Callback = i % 128;
            if ((i % 2 == 0 ? 'A' : (char) 11) != 'A') {
                return (getRequestHeaders[]) AGState.clone();
            }
            getRequestHeaders[] getrequestheadersArr = (getRequestHeaders[]) AGState.clone();
            throw new NullPointerException();
        }

        static {
            AGState();
            Object[] objArr = new Object[1];
            valueOf((short) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), (byte) ((ViewConfiguration.getTapTimeout() >> 16) + 40), TextUtils.indexOf((CharSequence) "", '0', 0) + 1217121123, 887590088 - Color.argb(0, 0, 0, 0), (-8) - (ViewConfiguration.getDoubleTapTimeout() >> 16), objArr);
            String intern = ((String) objArr[0]).intern();
            Object[] objArr2 = new Object[1];
            valueOf((short) TextUtils.getTrimmedLength(""), (byte) (103 - TextUtils.indexOf((CharSequence) "", '0')), 1217121151 - ExpandableListView.getPackedPositionChild(0L), 887590092 - View.resolveSizeAndState(0, 0, 0), (ViewConfiguration.getMinimumFlingVelocity() >> 16) - 37, objArr2);
            getRequestHeaders getrequestheaders = new getRequestHeaders(intern, 0, ((String) objArr2[0]).intern());
            getSharedInstance = getrequestheaders;
            Object[] objArr3 = new Object[1];
            valueOf((short) ((-1) - TextUtils.indexOf((CharSequence) "", '0', 0)), (byte) (((byte) KeyEvent.getModifierMetaStateMask()) + 83), TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 1217121154, (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 887590090, (-15) - TextUtils.lastIndexOf("", '0'), objArr3);
            String intern2 = ((String) objArr3[0]).intern();
            Object[] objArr4 = new Object[1];
            valueOf((short) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) - 1), (byte) (19 - Color.argb(0, 0, 0, 0)), ImageFormat.getBitsPerPixel(0) + 1217121178, 887590092 - (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (-36) - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)), objArr4);
            getRequestHeaders getrequestheaders2 = new getRequestHeaders(intern2, 1, ((String) objArr4[0]).intern());
            valueOf = getrequestheaders2;
            Object[] objArr5 = new Object[1];
            valueOf((short) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) - 1), (byte) ('R' - AndroidCharacter.getMirror('0')), 1217121177 - TextUtils.lastIndexOf("", '0', 0, 0), ImageFormat.getBitsPerPixel(0) + 887590091, (-15) - TextUtils.lastIndexOf("", '0'), objArr5);
            String intern3 = ((String) objArr5[0]).intern();
            Object[] objArr6 = new Object[1];
            valueOf((short) (AndroidCharacter.getMirror('0') - '0'), (byte) ((Process.myPid() >> 22) - 72), 1217121202 - ExpandableListView.getPackedPositionType(0L), 887590091 - TextUtils.lastIndexOf("", '0', 0), (-37) - KeyEvent.keyCodeFromString(""), objArr6);
            getRequestHeaders getrequestheaders3 = new getRequestHeaders(intern3, 2, ((String) objArr6[0]).intern());
            APIGuard = getrequestheaders3;
            Object[] objArr7 = new Object[1];
            valueOf((short) TextUtils.indexOf("", "", 0), (byte) (Gravity.getAbsoluteGravity(0, 0) - 126), TextUtils.getCapsMode("", 0, 0) + 1217121203, 887590087 - ((byte) KeyEvent.getModifierMetaStateMask()), (ViewConfiguration.getKeyRepeatDelay() >> 16) - 12, objArr7);
            String intern4 = ((String) objArr7[0]).intern();
            Object[] objArr8 = new Object[1];
            valueOf((short) (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)), (byte) (View.MeasureSpec.getMode(0) + 38), 1217121229 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), View.resolveSizeAndState(0, 0, 0) + 887590088, (-37) - TextUtils.indexOf((CharSequence) "", '0'), objArr8);
            getRequestHeaders getrequestheaders4 = new getRequestHeaders(intern4, 3, ((String) objArr8[0]).intern());
            values = getrequestheaders4;
            AGState = new getRequestHeaders[]{getrequestheaders, getrequestheaders2, getrequestheaders3, getrequestheaders4};
            int i = APIGuard$Callback + 39;
            checkCertificates = i % 128;
            if ((i % 2 != 0 ? ',' : (char) 14) == 14) {
                return;
            }
            throw new ArithmeticException();
        }

        private getRequestHeaders(String str, int i, String str2) {
            this.code = str2;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
        public final String getSharedInstance() {
            int i = APIGuard$Callback;
            checkCertificates = (i + 95) % 128;
            String str = this.code;
            checkCertificates = (i + 59) % 128;
            return str;
        }

        private static void valueOf(short s, byte b, int i, int i2, int i3, Object[] objArr) {
            String obj;
            synchronized (setBackground.AGState) {
                StringBuilder sb = new StringBuilder();
                int i4 = initialize;
                int i5 = i3 + i4;
                int i6 = i5 == -1 ? 1 : 0;
                if (i6 != 0) {
                    byte[] bArr = parseResponseHeaders;
                    if (bArr != null) {
                        i5 = (byte) (bArr[generateHeaders + i] + i4);
                    } else {
                        i5 = (short) (getRequestHeaders[generateHeaders + i] + i4);
                    }
                }
                if (i5 > 0) {
                    setBackground.values = ((i + i5) - 2) + generateHeaders + i6;
                    setBackground.APIGuard = (char) (i2 + analyzeResponse);
                    sb.append(setBackground.APIGuard);
                    setBackground.getSharedInstance = setBackground.APIGuard;
                    setBackground.valueOf = 1;
                    while (setBackground.valueOf < i5) {
                        byte[] bArr2 = parseResponseHeaders;
                        if (bArr2 != null) {
                            int i7 = setBackground.values;
                            setBackground.values = i7 - 1;
                            setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((byte) (bArr2[i7] + s)) ^ b));
                        } else {
                            short[] sArr = getRequestHeaders;
                            int i8 = setBackground.values;
                            setBackground.values = i8 - 1;
                            setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((short) (sArr[i8] + s)) ^ b));
                        }
                        sb.append(setBackground.APIGuard);
                        setBackground.getSharedInstance = setBackground.APIGuard;
                        setBackground.valueOf++;
                    }
                }
                obj = sb.toString();
            }
            objArr[0] = obj;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'onInitializationSuccess' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes3.dex */
    public static final class AGState implements ConfigInstance.ConfigSerializationProxy.AGState {
        public static final AGState AGState;
        public static final AGState APIGuard;
        public static final AGState APIGuard$Callback;
        private static AGState APIGuard$InitializationCallback = null;
        private static int AnalysesEntry = 0;
        private static char BuildConfig = 0;
        private static int FraudScore = 0;
        private static int SConfig = 1;
        private static char ScoredEntry;
        public static final AGState analyzeResponse;
        public static final AGState checkCertificates;
        private static char clearCallback;
        public static final AGState generateHeaders;
        public static final AGState getRequestHeaders;
        public static final AGState getSharedInstance;
        public static final AGState getState;
        private static char getVersion;
        public static final AGState initialize;
        public static final AGState log;
        private static AGState onInitializationFailure;
        private static AGState onInitializationSuccess;
        public static final AGState parseResponseHeaders;
        private static char pushMaxPayload;
        private static final /* synthetic */ AGState[] pushMinPayload;
        private static long send;
        public static final AGState updateKernel;
        public static final AGState valueOf;
        public static final AGState values;
        private String code;

        static void APIGuard() {
            clearCallback = (char) 11559;
            pushMaxPayload = (char) 50702;
            BuildConfig = (char) 55722;
            getVersion = (char) 64100;
            AnalysesEntry = 0;
            ScoredEntry = (char) 64900;
            send = 0L;
        }

        public static AGState valueOf(String str) {
            int i = FraudScore + 37;
            SConfig = i % 128;
            char c = i % 2 == 0 ? (char) 18 : (char) 16;
            AGState aGState = (AGState) Enum.valueOf(AGState.class, str);
            if (c == 18) {
                throw null;
            }
            int i2 = FraudScore + 63;
            SConfig = i2 % 128;
            if (i2 % 2 != 0) {
                return aGState;
            }
            throw new NullPointerException();
        }

        public static AGState[] values() {
            int i = FraudScore + 107;
            SConfig = i % 128;
            if (i % 2 == 0) {
                AGState[] aGStateArr = (AGState[]) pushMinPayload.clone();
                throw null;
            }
            AGState[] aGStateArr2 = (AGState[]) pushMinPayload.clone();
            SConfig = (FraudScore + 109) % 128;
            return aGStateArr2;
        }

        static {
            APIGuard();
            Object[] objArr = new Object[1];
            APIGuard("窝饢⃕ꐀ犈欆졸櫇\udc1d殤\ue5cd䨖ᘅ瑇膋໌䲷㊹ꢪ쬸\ud896ࡀ觽਼붩Ṟ겡肗䖩\ue465薾죪", (ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 30, objArr);
            String intern = ((String) objArr[0]).intern();
            Object[] objArr2 = new Object[1];
            valueOf((char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 56072), ViewConfiguration.getKeyRepeatDelay() >> 16, "ݰም", "\u0000\u0000\u0000\u0000", "缾﹆ࣙ㓛", objArr2);
            onInitializationSuccess = new AGState(intern, 0, ((String) objArr2[0]).intern());
            Object[] objArr3 = new Object[1];
            valueOf((char) (48707 - TextUtils.indexOf("", "", 0, 0)), Process.myTid() >> 22, "翯༙ຖ⫩儅仗ℨ\ueca2듺拷ӝ㪑쌹螭떍까얣\ud81a\uefb7씝➰\uf3ad\ue8b4㊢꾺㪄", "\u0000\u0000\u0000\u0000", "閩\u0a45䏮\udebe", objArr3);
            String intern2 = ((String) objArr3[0]).intern();
            Object[] objArr4 = new Object[1];
            APIGuard("ᅴ완", 1 - ImageFormat.getBitsPerPixel(0), objArr4);
            AGState aGState = new AGState(intern2, 1, ((String) objArr4[0]).intern());
            APIGuard = aGState;
            Object[] objArr5 = new Object[1];
            APIGuard("窝饢⃕ꐀ☪輣膋໌䲷㊹瓑贽ᄗ㋤뵻ℷ援残餧ㆥ빃\udabb扷ၤ\uf675ὂ", MotionEvent.axisFromString("") + 27, objArr5);
            String intern3 = ((String) objArr5[0]).intern();
            Object[] objArr6 = new Object[1];
            valueOf((char) ((ViewConfiguration.getScrollDefaultDelay() >> 16) + 45013), Process.myPid() >> 22, "䐡\ud8d6", "\u0000\u0000\u0000\u0000", "瀙ᅂ픹\uf7af", objArr6);
            AGState aGState2 = new AGState(intern3, 2, ((String) objArr6[0]).intern());
            getSharedInstance = aGState2;
            Object[] objArr7 = new Object[1];
            valueOf((char) (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), TextUtils.lastIndexOf("", '0') + 1775859324, "︹퐏\ue1a7埐䑋縕乘厯⪍\udc77\ufaef䖋ꮫﯵ郫낉嚰\uf369\uef9b\uf364궏", "\u0000\u0000\u0000\u0000", "篙\ud976鹩沿", objArr7);
            String intern4 = ((String) objArr7[0]).intern();
            Object[] objArr8 = new Object[1];
            APIGuard("媻曌", TextUtils.indexOf("", "", 0, 0) + 2, objArr8);
            AGState aGState3 = new AGState(intern4, 3, ((String) objArr8[0]).intern());
            values = aGState3;
            Object[] objArr9 = new Object[1];
            APIGuard("窝饢⃕ꐀ뿡㷱䲷㊹鼂쯓䠔㧟\u0ef8⇗⠛\uaac7⭐馥瑾㘳럞ﳠᲾᯉ惌\udf4a", 26 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), objArr9);
            String intern5 = ((String) objArr9[0]).intern();
            Object[] objArr10 = new Object[1];
            APIGuard("䀙玁", 3 - (ViewConfiguration.getZoomControlsTimeout() > 0L ? 1 : (ViewConfiguration.getZoomControlsTimeout() == 0L ? 0 : -1)), objArr10);
            AGState aGState4 = new AGState(intern5, 4, ((String) objArr10[0]).intern());
            AGState = aGState4;
            Object[] objArr11 = new Object[1];
            APIGuard("☪輣폮\ue008솅睔䰯샽鼂쯓귭쁳⡅皤빍샺甀\ud920迷癜겡肗겵쇦铁쑹덳\uec93", (ViewConfiguration.getKeyRepeatDelay() >> 16) + 28, objArr11);
            String intern6 = ((String) objArr11[0]).intern();
            Object[] objArr12 = new Object[1];
            APIGuard("钽ↂ", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 1, objArr12);
            AGState aGState5 = new AGState(intern6, 5, ((String) objArr12[0]).intern());
            valueOf = aGState5;
            Object[] objArr13 = new Object[1];
            valueOf((char) (ExpandableListView.getPackedPositionChild(0L) + 1), ViewConfiguration.getTapTimeout() >> 16, "价醓콏툂\ue3cc泈萙㨟焫艨\udb2b苬즹벻\udb44Ꮳ\ue473헮滹\ue0ff툝斷遭\uf510", "\u0000\u0000\u0000\u0000", "棼각↧嵸", objArr13);
            String intern7 = ((String) objArr13[0]).intern();
            Object[] objArr14 = new Object[1];
            APIGuard("▛之", (-16777214) - Color.rgb(0, 0, 0), objArr14);
            AGState aGState6 = new AGState(intern7, 6, ((String) objArr14[0]).intern());
            parseResponseHeaders = aGState6;
            Object[] objArr15 = new Object[1];
            APIGuard("☪輣폮\ue008솅睔䰯샽鼂쯓귭쁳⡅皤ㅤ\ua7e3援残ᘮꄷ竼䁝惸\ue911㻀卍", 26 - Gravity.getAbsoluteGravity(0, 0), objArr15);
            String intern8 = ((String) objArr15[0]).intern();
            Object[] objArr16 = new Object[1];
            APIGuard("仫韚", View.getDefaultSize(0, 0) + 2, objArr16);
            AGState aGState7 = new AGState(intern8, 7, ((String) objArr16[0]).intern());
            analyzeResponse = aGState7;
            Object[] objArr17 = new Object[1];
            APIGuard("窝饢⃕ꐀ☪輣膋໌䲷㊹瓑贽ᄗ㋤뵻ℷ援残餧ㆥ껳\uf685氍슕䰯샽\u0ef8⇗㝏ɋ", (ViewConfiguration.getDoubleTapTimeout() >> 16) + 30, objArr17);
            String intern9 = ((String) objArr17[0]).intern();
            Object[] objArr18 = new Object[1];
            APIGuard("\u202e\ue9fa", 2 - KeyEvent.getDeadChar(0, 0), objArr18);
            AGState aGState8 = new AGState(intern9, 8, ((String) objArr18[0]).intern());
            generateHeaders = aGState8;
            Object[] objArr19 = new Object[1];
            APIGuard("咦낀ꏾᏡ䉾嘗縊\uf30e䮝苂鼂쯓륕돑䖩\ue465\ue3e0\ud933졸櫇鳵角䵿嘮瑾㘳덳\uec93薾죪", (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 28, objArr19);
            String intern10 = ((String) objArr19[0]).intern();
            Object[] objArr20 = new Object[1];
            APIGuard("툘㪡⚣\ue334", (ViewConfiguration.getPressedStateDuration() >> 16) + 3, objArr20);
            AGState aGState9 = new AGState(intern10, 9, ((String) objArr20[0]).intern());
            initialize = aGState9;
            Object[] objArr21 = new Object[1];
            APIGuard("咦낀ꏾᏡ䉾嘗\uef9b齼ꦷ拓ၮᩭ湘쐉\uee90\uf306\ud83e耟毷剒", ExpandableListView.getPackedPositionType(0L) + 20, objArr21);
            String intern11 = ((String) objArr21[0]).intern();
            Object[] objArr22 = new Object[1];
            APIGuard("툘㪡젂釒", 3 - (ViewConfiguration.getTapTimeout() >> 16), objArr22);
            AGState aGState10 = new AGState(intern11, 10, ((String) objArr22[0]).intern());
            getRequestHeaders = aGState10;
            Object[] objArr23 = new Object[1];
            valueOf((char) ((-16747475) - Color.rgb(0, 0, 0)), (ViewConfiguration.getTouchSlop() >> 8) - 491575653, "\u2431絪料䖋䤣ђ挩뀳搦\ue00a韯\uf3f0᳀뱅㏂쳯\u242a\ueb94\ue6c2", "\u0000\u0000\u0000\u0000", "魟댦ⷢ䥴", objArr23);
            String intern12 = ((String) objArr23[0]).intern();
            Object[] objArr24 = new Object[1];
            APIGuard("툘㪡蘿뛥", TextUtils.lastIndexOf("", '0', 0, 0) + 4, objArr24);
            AGState aGState11 = new AGState(intern12, 11, ((String) objArr24[0]).intern());
            getState = aGState11;
            Object[] objArr25 = new Object[1];
            valueOf((char) (63929 - (ViewConfiguration.getScrollDefaultDelay() >> 16)), 690733001 - View.MeasureSpec.makeMeasureSpec(0, 0), "뒐\uea44㜌᪅괰ᜫ긴䄄ﭯ錎跀ᴞ賾➒불⢉온랒촿", "\u0000\u0000\u0000\u0000", "쥉⮿뤩᧹", objArr25);
            String intern13 = ((String) objArr25[0]).intern();
            Object[] objArr26 = new Object[1];
            valueOf((char) (30763 - Process.getGidForName("")), (-597125084) - TextUtils.indexOf("", "", 0), "뢜Ⰺ糆", "\u0000\u0000\u0000\u0000", "␁梘Ⳝᙸ", objArr26);
            AGState aGState12 = new AGState(intern13, 12, ((String) objArr26[0]).intern());
            updateKernel = aGState12;
            Object[] objArr27 = new Object[1];
            valueOf((char) (ViewConfiguration.getDoubleTapTimeout() >> 16), (-291246410) - ((Process.getThreadPriority(0) + 20) >> 6), "抨籄흘̡폚\ue8c3௸퀡雓і휤루⽨钹\ue3b9⓹㰱縋종\uf0c8责\ueea5쇤뽊뫆歝圸鳨ﱋ槹簮\uf5d4\uf53b麈삯盛겙", "\u0000\u0000\u0000\u0000", "뚜ꏮ矮梕", objArr27);
            String intern14 = ((String) objArr27[0]).intern();
            Object[] objArr28 = new Object[1];
            APIGuard("툘㪡䕃빑", (ViewConfiguration.getJumpTapTimeout() >> 16) + 3, objArr28);
            AGState aGState13 = new AGState(intern14, 13, ((String) objArr28[0]).intern());
            APIGuard$Callback = aGState13;
            Object[] objArr29 = new Object[1];
            valueOf((char) TextUtils.indexOf("", ""), (ViewConfiguration.getFadingEdgeLength() >> 16) - 1284668408, "ụ횡䁕뛋\ude74㑖滵蛦퀬枃\uee87钼颛❽骃趕ᓤ씱쪸捭䢤썻静都틘슴\ue5e6揞싡ᅣ率ꡑ盂\ue64aវ᱐ꩴ覞鎉ʠॕ◗⡨ទ웺娐慚萄ﷸ\ua8db㣼", "\u0000\u0000\u0000\u0000", "\u086c涄ᢳ녴", objArr29);
            String intern15 = ((String) objArr29[0]).intern();
            Object[] objArr30 = new Object[1];
            valueOf((char) (16440 - TextUtils.getOffsetBefore("", 0)), (-1742356872) - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)), "齃⏾휫", "\u0000\u0000\u0000\u0000", "砑▾㢘啀", objArr30);
            AGState aGState14 = new AGState(intern15, 14, ((String) objArr30[0]).intern());
            checkCertificates = aGState14;
            Object[] objArr31 = new Object[1];
            valueOf((char) Color.alpha(0), (ViewConfiguration.getEdgeSlop() >> 16) - 1894801965, "㭮苴発\ue712쎾鱽炍䱰\udabc됩ꯙ\ude15睌鏙䢁ꁻㆸ䪢\ue5f3꼡䯋䞇⥨", "\u0000\u0000\u0000\u0000", "팶ྜྷ겏ࠟ", objArr31);
            String intern16 = ((String) objArr31[0]).intern();
            Object[] objArr32 = new Object[1];
            APIGuard("䫾䋣젂釒", Gravity.getAbsoluteGravity(0, 0) + 3, objArr32);
            AGState aGState15 = new AGState(intern16, 15, ((String) objArr32[0]).intern());
            log = aGState15;
            Object[] objArr33 = new Object[1];
            APIGuard("붩Ṟ둗椣␘鼪痫㣙욂ഄ畯鱞├턝䮝苂鍯\u2fee檆腫䜭ꅋ⃕ꐀ咦낀\udaad團ᛨ꺽", 30 - View.MeasureSpec.getMode(0), objArr33);
            String intern17 = ((String) objArr33[0]).intern();
            Object[] objArr34 = new Object[1];
            APIGuard("ᅴ완\u0094獝", 3 - TextUtils.lastIndexOf("", '0'), objArr34);
            APIGuard$InitializationCallback = new AGState(intern17, 16, ((String) objArr34[0]).intern());
            Object[] objArr35 = new Object[1];
            valueOf((char) (55431 - TextUtils.indexOf((CharSequence) "", '0')), ViewConfiguration.getScrollBarFadeDuration() >> 16, "Θꓝ㍆ꭟ瞛\uf019ላ퓣糂ᔉ\uef07祍玽拎꼣絝耐붃襳╡㈪䷳울痈ꐽ闱痱䨆\ue17fꫡ", "\u0000\u0000\u0000\u0000", "冝ࡣ裘\uf0d8", objArr35);
            String intern18 = ((String) objArr35[0]).intern();
            Object[] objArr36 = new Object[1];
            valueOf((char) (38711 - ((Process.getThreadPriority(0) + 20) >> 6)), KeyEvent.keyCodeFromString(""), "쪲ޒ䒐쇚", "\u0000\u0000\u0000\u0000", "脐\uea02㟵玗", objArr36);
            AGState aGState16 = new AGState(intern18, 17, ((String) objArr36[0]).intern());
            onInitializationFailure = aGState16;
            pushMinPayload = new AGState[]{onInitializationSuccess, aGState, aGState2, aGState3, aGState4, aGState5, aGState6, aGState7, aGState8, aGState9, aGState10, aGState11, aGState12, aGState13, aGState14, aGState15, APIGuard$InitializationCallback, aGState16};
            int i = SConfig + 97;
            FraudScore = i % 128;
            if (i % 2 != 0) {
                throw null;
            }
        }

        private AGState(String str, int i, String str2) {
            this.code = str2;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
        public final String getSharedInstance() {
            int i = FraudScore + 35;
            int i2 = i % 128;
            SConfig = i2;
            if ((i % 2 == 0 ? '\'' : 'F') != 'F') {
                throw new NullPointerException();
            }
            String str = this.code;
            int i3 = i2 + 125;
            FraudScore = i3 % 128;
            if ((i3 % 2 != 0 ? 'J' : 'I') == 'I') {
                return str;
            }
            throw null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r13 = r13;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void APIGuard(java.lang.String r13, int r14, java.lang.Object[] r15) {
            /*
                if (r13 == 0) goto L6
                char[] r13 = r13.toCharArray()
            L6:
                char[] r13 = (char[]) r13
                java.lang.Object r0 = com.apiguard3.internal.setBackgroundDrawable.getSharedInstance
                monitor-enter(r0)
                int r1 = r13.length     // Catch: java.lang.Throwable -> L7a
                char[] r1 = new char[r1]     // Catch: java.lang.Throwable -> L7a
                r2 = 0
                com.apiguard3.internal.setBackgroundDrawable.valueOf = r2     // Catch: java.lang.Throwable -> L7a
                r3 = 2
                char[] r4 = new char[r3]     // Catch: java.lang.Throwable -> L7a
            L14:
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                int r6 = r13.length     // Catch: java.lang.Throwable -> L7a
                if (r5 >= r6) goto L71
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
                r4[r2] = r5     // Catch: java.lang.Throwable -> L7a
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                r6 = 1
                int r5 = r5 + r6
                char r5 = r13[r5]     // Catch: java.lang.Throwable -> L7a
                r4[r6] = r5     // Catch: java.lang.Throwable -> L7a
                r5 = 58224(0xe370, float:8.1589E-41)
                r7 = 0
            L2b:
                r8 = 16
                if (r7 >= r8) goto L5e
                char r8 = r4[r6]     // Catch: java.lang.Throwable -> L7a
                char r9 = r4[r2]     // Catch: java.lang.Throwable -> L7a
                int r10 = r9 + r5
                int r11 = r9 << 4
                char r12 = com.apiguard3.internal.writeReplace.AGState.clearCallback     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                r10 = r10 ^ r11
                int r11 = r9 >>> 5
                char r12 = com.apiguard3.internal.writeReplace.AGState.pushMaxPayload     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                r10 = r10 ^ r11
                int r8 = r8 - r10
                char r8 = (char) r8     // Catch: java.lang.Throwable -> L7a
                r4[r6] = r8     // Catch: java.lang.Throwable -> L7a
                char r10 = com.apiguard3.internal.writeReplace.AGState.BuildConfig     // Catch: java.lang.Throwable -> L7a
                int r11 = r8 >>> 5
                char r12 = com.apiguard3.internal.writeReplace.AGState.getVersion     // Catch: java.lang.Throwable -> L7a
                int r11 = r11 + r12
                int r12 = r8 + r5
                int r8 = r8 << 4
                int r8 = r8 + r10
                r8 = r8 ^ r12
                r8 = r8 ^ r11
                int r9 = r9 - r8
                char r8 = (char) r9     // Catch: java.lang.Throwable -> L7a
                r4[r2] = r8     // Catch: java.lang.Throwable -> L7a
                r8 = 40503(0x9e37, float:5.6757E-41)
                int r5 = r5 - r8
                int r7 = r7 + 1
                goto L2b
            L5e:
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                char r7 = r4[r2]     // Catch: java.lang.Throwable -> L7a
                r1[r5] = r7     // Catch: java.lang.Throwable -> L7a
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                int r5 = r5 + r6
                char r6 = r4[r6]     // Catch: java.lang.Throwable -> L7a
                r1[r5] = r6     // Catch: java.lang.Throwable -> L7a
                int r5 = com.apiguard3.internal.setBackgroundDrawable.valueOf     // Catch: java.lang.Throwable -> L7a
                int r5 = r5 + r3
                com.apiguard3.internal.setBackgroundDrawable.valueOf = r5     // Catch: java.lang.Throwable -> L7a
                goto L14
            L71:
                java.lang.String r13 = new java.lang.String     // Catch: java.lang.Throwable -> L7a
                r13.<init>(r1, r2, r14)     // Catch: java.lang.Throwable -> L7a
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L7a
                r15[r2] = r13
                return
            L7a:
                r13 = move-exception
                monitor-exit(r0)
                goto L7e
            L7d:
                throw r13
            L7e:
                goto L7d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.writeReplace.AGState.APIGuard(java.lang.String, int, java.lang.Object[]):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r12 = r12;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void valueOf(char r8, int r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.Object[] r13) {
            /*
                if (r12 == 0) goto L6
                char[] r12 = r12.toCharArray()
            L6:
                char[] r12 = (char[]) r12
                if (r11 == 0) goto Le
                char[] r11 = r11.toCharArray()
            Le:
                char[] r11 = (char[]) r11
                if (r10 == 0) goto L16
                char[] r10 = r10.toCharArray()
            L16:
                char[] r10 = (char[]) r10
                java.lang.Object r0 = com.apiguard3.internal.setForegroundGravity.AGState
                monitor-enter(r0)
                java.lang.Object r12 = r12.clone()     // Catch: java.lang.Throwable -> L94
                char[] r12 = (char[]) r12     // Catch: java.lang.Throwable -> L94
                java.lang.Object r11 = r11.clone()     // Catch: java.lang.Throwable -> L94
                char[] r11 = (char[]) r11     // Catch: java.lang.Throwable -> L94
                r1 = 0
                char r2 = r12[r1]     // Catch: java.lang.Throwable -> L94
                r8 = r8 ^ r2
                char r8 = (char) r8     // Catch: java.lang.Throwable -> L94
                r12[r1] = r8     // Catch: java.lang.Throwable -> L94
                r8 = 2
                char r2 = r11[r8]     // Catch: java.lang.Throwable -> L94
                char r9 = (char) r9     // Catch: java.lang.Throwable -> L94
                int r2 = r2 + r9
                char r9 = (char) r2     // Catch: java.lang.Throwable -> L94
                r11[r8] = r9     // Catch: java.lang.Throwable -> L94
                int r9 = r10.length     // Catch: java.lang.Throwable -> L94
                char[] r2 = new char[r9]     // Catch: java.lang.Throwable -> L94
                com.apiguard3.internal.setForegroundGravity.valueOf = r1     // Catch: java.lang.Throwable -> L94
            L3b:
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                if (r3 >= r9) goto L8b
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r3 = r3 + r8
                int r3 = r3 % 4
                int r4 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r4 = r4 + 3
                int r4 = r4 % 4
                int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r5 = r5 % 4
                char r5 = r12[r5]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 * 32718
                char r6 = r11[r3]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 + r6
                r6 = 65535(0xffff, float:9.1834E-41)
                int r5 = r5 % r6
                char r5 = (char) r5     // Catch: java.lang.Throwable -> L94
                com.apiguard3.internal.setForegroundGravity.APIGuard = r5     // Catch: java.lang.Throwable -> L94
                char r5 = r12[r4]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 * 32718
                char r3 = r11[r3]     // Catch: java.lang.Throwable -> L94
                int r5 = r5 + r3
                int r5 = r5 / r6
                char r3 = (char) r5     // Catch: java.lang.Throwable -> L94
                r11[r4] = r3     // Catch: java.lang.Throwable -> L94
                char r3 = com.apiguard3.internal.setForegroundGravity.APIGuard     // Catch: java.lang.Throwable -> L94
                r12[r4] = r3     // Catch: java.lang.Throwable -> L94
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r5 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                char r5 = r10[r5]     // Catch: java.lang.Throwable -> L94
                char r4 = r12[r4]     // Catch: java.lang.Throwable -> L94
                r4 = r4 ^ r5
                long r4 = (long) r4     // Catch: java.lang.Throwable -> L94
                long r6 = com.apiguard3.internal.writeReplace.AGState.send     // Catch: java.lang.Throwable -> L94
                long r4 = r4 ^ r6
                int r6 = com.apiguard3.internal.writeReplace.AGState.AnalysesEntry     // Catch: java.lang.Throwable -> L94
                long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
                long r4 = r4 ^ r6
                char r6 = com.apiguard3.internal.writeReplace.AGState.ScoredEntry     // Catch: java.lang.Throwable -> L94
                long r6 = (long) r6     // Catch: java.lang.Throwable -> L94
                long r4 = r4 ^ r6
                int r5 = (int) r4     // Catch: java.lang.Throwable -> L94
                char r4 = (char) r5     // Catch: java.lang.Throwable -> L94
                r2[r3] = r4     // Catch: java.lang.Throwable -> L94
                int r3 = com.apiguard3.internal.setForegroundGravity.valueOf     // Catch: java.lang.Throwable -> L94
                int r3 = r3 + 1
                com.apiguard3.internal.setForegroundGravity.valueOf = r3     // Catch: java.lang.Throwable -> L94
                goto L3b
            L8b:
                java.lang.String r8 = new java.lang.String     // Catch: java.lang.Throwable -> L94
                r8.<init>(r2)     // Catch: java.lang.Throwable -> L94
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L94
                r13[r1] = r8
                return
            L94:
                r8 = move-exception
                monitor-exit(r0)
                goto L98
            L97:
                throw r8
            L98:
                goto L97
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.writeReplace.AGState.valueOf(char, int, java.lang.String, java.lang.String, java.lang.String, java.lang.Object[]):void");
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'getSharedInstance' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes7.dex */
    public static final class valueOf implements ConfigInstance.ConfigSerializationProxy.AGState {
        public static final valueOf AGState;
        public static final valueOf APIGuard;
        private static valueOf APIGuard$Callback = null;
        private static valueOf APIGuard$InitializationCallback = null;
        private static byte[] AnalysesEntry = null;
        private static valueOf BuildConfig = null;
        private static int Config = 1;
        private static int FraudScore;
        public static final valueOf analyzeResponse;
        public static final valueOf checkCertificates;
        private static int clearCallback;
        public static final valueOf generateHeaders;
        public static final valueOf getRequestHeaders;
        public static final valueOf getSharedInstance;
        public static final valueOf getState;
        private static int getVersion;
        public static final valueOf initialize;
        public static final valueOf log;
        private static char onInitializationFailure;
        private static final /* synthetic */ valueOf[] onInitializationSuccess;
        public static final valueOf parseResponseHeaders;
        private static int pushMaxPayload;
        private static char[] pushMinPayload;
        private static short[] send;
        public static final valueOf updateKernel;
        public static final valueOf valueOf;
        public static final valueOf values;
        private String code;

        static void AGState() {
            onInitializationFailure = (char) 6;
            pushMinPayload = new char[]{13743, 13785, 13777, 13770, 13748, 13788, 13745, 13789, 13780, 13779, 13736, 13787, 13744, 13790, 13762, 13747, 13772, 13781, 13749, 13775, 13778, 13746, 13782, 13742, 13740, 13741, 13791, 13739, 13784, 13774, 13765, 13783, 13768, 13769, 13737, 13763};
            clearCallback = 959010433;
            pushMaxPayload = -214995700;
            AnalysesEntry = new byte[]{-104, -21, -104, -20, -84, -2, 3, -8, -1, 12, -28, Ascii.SUB, -14, 18, -1, -29, 6, 5, 4, 3, 8, -26, 19, 3, 8, -5, -104, -19, -104, -18, -83, -8, 0, -11, Ascii.ESC, -5, -3, 11, -21, 8, 5, -22, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -71, 11, -21, 4, 13, -15, 6, 5, -22, Ascii.SUB, -15, 19, -3, -12, -5, -10, Ascii.ESC, -5, -3, 11, -21, 8, 5, -22, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -104, -15, -72, -1, 6, 10, -8, 4, -11, -11, Ascii.SUB, -15, 19, -3, -12, -5, -10, Ascii.ESC, -5, -3, 11, -21, 8, 5, -22, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -104, -14, -104, -13, -74, -8, 2, 8, 8, -2, -3, 5, -28, 19, -6, -3, -10, Ascii.ESC, -5, -3, 11, -21, 8, 5, -22, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -103, -1, -21, -103, 0, -21, -85, 7, -9, -4, 13, -6, -20, 16, 1, -17, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -82, 7, -9, -4, 13, -6, -20, 6, 5, 4, 3, 8, -26, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -76, -6, -3, -10, Ascii.SUB, -15, 19, -3, -12, -5, -10, Ascii.ESC, -5, -3, 11, -21, 8, 5, -22, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -70, -1, 6, 10, -8, 4, -11, -11, Ascii.ESC, 3, -14, 3, -2, -9, 8, 11, -27, Ascii.ESC, -5, -3, 11, -21, 8, 5, -22, Ascii.CAN, -2, 3, -8, -1, 12, -28, 19, 3, 8, -5, -83, -1, 6, -11, 19, -25, 17, -3, 11, -8, -11, 11, -5, 5, -22, Ascii.DC4, 7, -15, -12, 19, 3, 8, -5};
            getVersion = 106;
        }

        public static valueOf valueOf(String str) {
            int i = FraudScore + 39;
            Config = i % 128;
            char c = i % 2 == 0 ? '\f' : 'G';
            valueOf valueof = (valueOf) Enum.valueOf(valueOf.class, str);
            if (c != '\f') {
                return valueof;
            }
            throw new ArithmeticException();
        }

        public static valueOf[] values() {
            FraudScore = (Config + 45) % 128;
            valueOf[] valueofArr = (valueOf[]) onInitializationSuccess.clone();
            FraudScore = (Config + 101) % 128;
            return valueofArr;
        }

        static {
            AGState();
            Object[] objArr = new Object[1];
            getSharedInstance(TextUtils.indexOf((CharSequence) "", '0', 0, 0) + 20, (byte) ((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 43), "\u000b\u0011\n\u0015#\u0018\f#\u0017\u0010\u0007\u0011\u001f\u0000\u000e\u000b\u0003\u000b㘈", objArr);
            String intern = ((String) objArr[0]).intern();
            Object[] objArr2 = new Object[1];
            getSharedInstance((short) Color.blue(0), (byte) TextUtils.getCapsMode("", 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) - 959010433, 214995770 - View.MeasureSpec.getMode(0), (Process.myTid() >> 22) - 107, objArr2);
            valueOf valueof = new valueOf(intern, 0, ((String) objArr2[0]).intern());
            getSharedInstance = valueof;
            Object[] objArr3 = new Object[1];
            getSharedInstance((SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)) + 18, (byte) (49 - View.MeasureSpec.getMode(0)), "\u000b\u0011\n\u0015!\u0006\n\u000e\n\u0017\u0007\u000f\u001f\u0000\u000e\u000b\u0003\u000b㘎", objArr3);
            String intern2 = ((String) objArr3[0]).intern();
            Object[] objArr4 = new Object[1];
            getSharedInstance((short) (Process.myPid() >> 22), (byte) (1 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1))), (-959010431) - View.resolveSizeAndState(0, 0, 0), 214995770 - View.MeasureSpec.makeMeasureSpec(0, 0), (-107) - TextUtils.getTrimmedLength(""), objArr4);
            valueOf valueof2 = new valueOf(intern2, 1, ((String) objArr4[0]).intern());
            APIGuard = valueof2;
            Object[] objArr5 = new Object[1];
            getSharedInstance((short) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (byte) TextUtils.getTrimmedLength(""), (-959010430) - TextUtils.lastIndexOf("", '0'), 214995770 - (ViewConfiguration.getPressedStateDuration() >> 16), (-107) - TextUtils.indexOf("", ""), objArr5);
            String intern3 = ((String) objArr5[0]).intern();
            Object[] objArr6 = new Object[1];
            getSharedInstance((short) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (Process.myTid() >> 22) - 959010407, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 214995770, (-107) - Color.blue(0), objArr6);
            valueOf valueof3 = new valueOf(intern3, 2, ((String) objArr6[0]).intern());
            valueOf = valueof3;
            Object[] objArr7 = new Object[1];
            getSharedInstance(TextUtils.indexOf("", "") + 31, (byte) (37 - View.MeasureSpec.getSize(0)), "\u000b\u0011\n\u0015\u001f\u0012\t \u0015\u0001\u0005\u000f#\u001a\u0019\u000e\u001f\u0000\u000e\u000b\u0003\u000b\u0006\u001f\u000e\u001c!\"\u000b\u000f㗹", objArr7);
            String intern4 = ((String) objArr7[0]).intern();
            Object[] objArr8 = new Object[1];
            getSharedInstance((short) (Process.myPid() >> 22), (byte) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 959010404, 214995769 - TextUtils.indexOf((CharSequence) "", '0', 0), (-107) - (ViewConfiguration.getJumpTapTimeout() >> 16), objArr8);
            valueOf valueof4 = new valueOf(intern4, 3, ((String) objArr8[0]).intern());
            values = valueof4;
            Object[] objArr9 = new Object[1];
            getSharedInstance((short) TextUtils.getOffsetBefore("", 0), (byte) ((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) - 1), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 959010404, (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 214995770, (-108) - MotionEvent.axisFromString(""), objArr9);
            String intern5 = ((String) objArr9[0]).intern();
            Object[] objArr10 = new Object[1];
            getSharedInstance(Color.green(0) + 2, (byte) ((ViewConfiguration.getScrollBarFadeDuration() >> 16) + 91), "\u0000\u0001", objArr10);
            valueOf valueof5 = new valueOf(intern5, 4, ((String) objArr10[0]).intern());
            AGState = valueof5;
            Object[] objArr11 = new Object[1];
            getSharedInstance((short) (ViewConfiguration.getMaximumDrawingCacheSize() >> 24), (byte) Color.green(0), (-959010381) - TextUtils.lastIndexOf("", '0', 0, 0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 214995769, (-107) - (ViewConfiguration.getEdgeSlop() >> 16), objArr11);
            String intern6 = ((String) objArr11[0]).intern();
            Object[] objArr12 = new Object[1];
            getSharedInstance(Color.green(0) + 2, (byte) (TextUtils.lastIndexOf("", '0', 0) + 114), "\u0000\u001d", objArr12);
            valueOf valueof6 = new valueOf(intern6, 5, ((String) objArr12[0]).intern());
            analyzeResponse = valueof6;
            Object[] objArr13 = new Object[1];
            getSharedInstance(39 - (KeyEvent.getMaxKeyCode() >> 16), (byte) (86 - ExpandableListView.getPackedPositionGroup(0L)), "\u000b\u0011\n\u0015\u001f\u0000\u000e\u000b\u0003\u000b\u0006\u001f\n\t\u0011\n\u0015\n\f\u001f#\u0007\f \u0015\u0001\u0011\u0007\u0018\u001b!\u0006\u000b\u001a \u0002\u0011\n㘬", objArr13);
            String intern7 = ((String) objArr13[0]).intern();
            Object[] objArr14 = new Object[1];
            getSharedInstance((short) TextUtils.indexOf("", ""), (byte) ((-1) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1))), View.combineMeasuredStates(0, 0) - 959010345, 214995770 - (Process.myPid() >> 22), Color.blue(0) - 107, objArr14);
            valueOf valueof7 = new valueOf(intern7, 6, ((String) objArr14[0]).intern());
            getRequestHeaders = valueof7;
            Object[] objArr15 = new Object[1];
            getSharedInstance((short) (1 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1))), (byte) (ExpandableListView.getPackedPositionChild(0L) + 1), (ViewConfiguration.getJumpTapTimeout() >> 16) - 959010343, (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 214995769, ImageFormat.getBitsPerPixel(0) - 106, objArr15);
            String intern8 = ((String) objArr15[0]).intern();
            Object[] objArr16 = new Object[1];
            getSharedInstance((short) Gravity.getAbsoluteGravity(0, 0), (byte) (AndroidCharacter.getMirror('0') - '0'), TextUtils.indexOf((CharSequence) "", '0', 0) - 959010308, Color.blue(0) + 214995770, (Process.myTid() >> 22) - 107, objArr16);
            valueOf valueof8 = new valueOf(intern8, 7, ((String) objArr16[0]).intern());
            generateHeaders = valueof8;
            Object[] objArr17 = new Object[1];
            getSharedInstance(33 - Color.alpha(0), (byte) ((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 101), "\u000b\u0011\n\u0015\u001f\u0000\u000e\u000b\u0003\u000b\u0006\u001f\n\t\u0011\n\u0015\n\f\u001f\u001d\u0010\u0011\u001f\u001f\u0000\u001a \u0002\u0003\u001f\u0015㘼", objArr17);
            String intern9 = ((String) objArr17[0]).intern();
            Object[] objArr18 = new Object[1];
            getSharedInstance((short) (ViewConfiguration.getTapTimeout() >> 16), (byte) TextUtils.indexOf("", ""), (-959010308) - MotionEvent.axisFromString(""), View.MeasureSpec.getSize(0) + 214995770, ExpandableListView.getPackedPositionChild(0L) - 106, objArr18);
            valueOf valueof9 = new valueOf(intern9, 8, ((String) objArr18[0]).intern());
            initialize = valueof9;
            Object[] objArr19 = new Object[1];
            getSharedInstance((short) (TextUtils.lastIndexOf("", '0', 0, 0) + 1), (byte) (TextUtils.lastIndexOf("", '0', 0) + 1), (ViewConfiguration.getScrollDefaultDelay() >> 16) - 959010305, 214995770 - Color.argb(0, 0, 0, 0), (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) - 107, objArr19);
            String intern10 = ((String) objArr19[0]).intern();
            Object[] objArr20 = new Object[1];
            getSharedInstance((short) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)), (byte) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)), (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1)) - 959010274, TextUtils.indexOf("", "", 0) + 214995770, (-107) - (ViewConfiguration.getFadingEdgeLength() >> 16), objArr20);
            valueOf valueof10 = new valueOf(intern10, 9, ((String) objArr20[0]).intern());
            parseResponseHeaders = valueof10;
            Object[] objArr21 = new Object[1];
            getSharedInstance(Color.green(0) + 18, (byte) (64 - (SystemClock.uptimeMillis() > 0L ? 1 : (SystemClock.uptimeMillis() == 0L ? 0 : -1))), "\u000b\u0011\n\u0015\u001f\u0000\u000e\u000b\u0003\u000b\u0006\u001f\u000b\u000e \u0000\u0007\u000f", objArr21);
            String intern11 = ((String) objArr21[0]).intern();
            Object[] objArr22 = new Object[1];
            getSharedInstance((short) View.combineMeasuredStates(0, 0), (byte) Color.red(0), (-959010270) - Color.blue(0), 198218554 - Color.rgb(0, 0, 0), (ViewConfiguration.getScrollBarSize() >> 8) - 107, objArr22);
            valueOf valueof11 = new valueOf(intern11, 10, ((String) objArr22[0]).intern());
            updateKernel = valueof11;
            Object[] objArr23 = new Object[1];
            getSharedInstance((short) (ViewConfiguration.getFadingEdgeLength() >> 16), (byte) KeyEvent.normalizeMetaState(0), TextUtils.indexOf((CharSequence) "", '0', 0, 0) - 959010266, 214995770 - (ViewConfiguration.getWindowTouchSlop() >> 8), (-107) - KeyEvent.keyCodeFromString(""), objArr23);
            String intern12 = ((String) objArr23[0]).intern();
            Object[] objArr24 = new Object[1];
            getSharedInstance((CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)) + 3, (byte) ((ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 31), "\u0003\u001d㗈", objArr24);
            valueOf valueof12 = new valueOf(intern12, 11, ((String) objArr24[0]).intern());
            checkCertificates = valueof12;
            Object[] objArr25 = new Object[1];
            getSharedInstance((short) (ViewConfiguration.getEdgeSlop() >> 16), (byte) (KeyEvent.getMaxKeyCode() >> 16), Process.getGidForName("") - 959010245, (Process.myPid() >> 22) + 214995770, (-106) - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), objArr25);
            String intern13 = ((String) objArr25[0]).intern();
            Object[] objArr26 = new Object[1];
            getSharedInstance(3 - (AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)), (byte) ((ViewConfiguration.getWindowTouchSlop() >> 8) + 92), "\u0003\u001d㘅", objArr26);
            valueOf valueof13 = new valueOf(intern13, 12, ((String) objArr26[0]).intern());
            log = valueof13;
            Object[] objArr27 = new Object[1];
            getSharedInstance((short) KeyEvent.getDeadChar(0, 0), (byte) (ViewConfiguration.getJumpTapTimeout() >> 16), (-959010223) - TextUtils.lastIndexOf("", '0', 0, 0), (ViewConfiguration.getKeyRepeatTimeout() >> 16) + 214995770, (-108) - (ExpandableListView.getPackedPositionForChild(0, 0) > 0L ? 1 : (ExpandableListView.getPackedPositionForChild(0, 0) == 0L ? 0 : -1)), objArr27);
            String intern14 = ((String) objArr27[0]).intern();
            Object[] objArr28 = new Object[1];
            getSharedInstance((ViewConfiguration.getScrollFriction() > 0.0f ? 1 : (ViewConfiguration.getScrollFriction() == 0.0f ? 0 : -1)) + 2, (byte) (101 - (ViewConfiguration.getWindowTouchSlop() >> 8)), "\u0003\u001d㘓", objArr28);
            valueOf valueof14 = new valueOf(intern14, 13, ((String) objArr28[0]).intern());
            getState = valueof14;
            Object[] objArr29 = new Object[1];
            getSharedInstance((short) TextUtils.indexOf("", "", 0, 0), (byte) Gravity.getAbsoluteGravity(0, 0), (-959010192) - (ViewConfiguration.getScrollDefaultDelay() >> 16), 214995771 - (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)), (-107) - (ViewConfiguration.getPressedStateDuration() >> 16), objArr29);
            String intern15 = ((String) objArr29[0]).intern();
            Object[] objArr30 = new Object[1];
            getSharedInstance((ViewConfiguration.getWindowTouchSlop() >> 8) + 3, (byte) ((ViewConfiguration.getLongPressTimeout() >> 16) + 25), "\u0003\u001d㗈", objArr30);
            APIGuard$Callback = new valueOf(intern15, 14, ((String) objArr30[0]).intern());
            Object[] objArr31 = new Object[1];
            getSharedInstance(20 - TextUtils.getOffsetBefore("", 0), (byte) ((ViewConfiguration.getTapTimeout() >> 16) + 32), "\u000b\u0011\n\u0015#\u0018\f#\u0005\t!\"\u0018 \u0005\r\u000b\u0002\n\b", objArr31);
            String intern16 = ((String) objArr31[0]).intern();
            Object[] objArr32 = new Object[1];
            getSharedInstance(2 - TextUtils.indexOf((CharSequence) "", '0'), (byte) ((TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)) + 19), "\u0003\u001d㖿", objArr32);
            APIGuard$InitializationCallback = new valueOf(intern16, 15, ((String) objArr32[0]).intern());
            Object[] objArr33 = new Object[1];
            getSharedInstance((short) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))), (byte) View.MeasureSpec.makeMeasureSpec(0, 0), (-959010156) - Gravity.getAbsoluteGravity(0, 0), (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)) + 214995769, TextUtils.indexOf("", "") - 107, objArr33);
            String intern17 = ((String) objArr33[0]).intern();
            Object[] objArr34 = new Object[1];
            getSharedInstance(3 - View.getDefaultSize(0, 0), (byte) (72 - (PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1))), "\u0003\u001d㗵", objArr34);
            valueOf valueof15 = new valueOf(intern17, 16, ((String) objArr34[0]).intern());
            BuildConfig = valueof15;
            onInitializationSuccess = new valueOf[]{valueof, valueof2, valueof3, valueof4, valueof5, valueof6, valueof7, valueof8, valueof9, valueof10, valueof11, valueof12, valueof13, valueof14, APIGuard$Callback, APIGuard$InitializationCallback, valueof15};
            int i = Config + 29;
            FraudScore = i % 128;
            if ((i % 2 != 0 ? '^' : (char) 23) != '^') {
                return;
            }
            throw new NullPointerException();
        }

        private valueOf(String str, int i, String str2) {
            this.code = str2;
        }

        @Override // com.apiguard3.internal.ConfigInstance.ConfigSerializationProxy.AGState
        public final String getSharedInstance() {
            int i = (FraudScore + 125) % 128;
            Config = i;
            String str = this.code;
            FraudScore = (i + 71) % 128;
            return str;
        }

        /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
        
            r14 = r14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void getSharedInstance(int r12, byte r13, java.lang.String r14, java.lang.Object[] r15) {
            /*
                Method dump skipped, instructions count: 257
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.internal.writeReplace.valueOf.getSharedInstance(int, byte, java.lang.String, java.lang.Object[]):void");
        }

        private static void getSharedInstance(short s, byte b, int i, int i2, int i3, Object[] objArr) {
            String obj;
            synchronized (setBackground.AGState) {
                StringBuilder sb = new StringBuilder();
                int i4 = getVersion;
                int i5 = i3 + i4;
                int i6 = i5 == -1 ? 1 : 0;
                if (i6 != 0) {
                    byte[] bArr = AnalysesEntry;
                    if (bArr != null) {
                        i5 = (byte) (bArr[clearCallback + i] + i4);
                    } else {
                        i5 = (short) (send[clearCallback + i] + i4);
                    }
                }
                if (i5 > 0) {
                    setBackground.values = ((i + i5) - 2) + clearCallback + i6;
                    setBackground.APIGuard = (char) (i2 + pushMaxPayload);
                    sb.append(setBackground.APIGuard);
                    setBackground.getSharedInstance = setBackground.APIGuard;
                    setBackground.valueOf = 1;
                    while (setBackground.valueOf < i5) {
                        byte[] bArr2 = AnalysesEntry;
                        if (bArr2 != null) {
                            int i7 = setBackground.values;
                            setBackground.values = i7 - 1;
                            setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((byte) (bArr2[i7] + s)) ^ b));
                        } else {
                            short[] sArr = send;
                            int i8 = setBackground.values;
                            setBackground.values = i8 - 1;
                            setBackground.APIGuard = (char) (setBackground.getSharedInstance + (((short) (sArr[i8] + s)) ^ b));
                        }
                        sb.append(setBackground.APIGuard);
                        setBackground.getSharedInstance = setBackground.APIGuard;
                        setBackground.valueOf++;
                    }
                }
                obj = sb.toString();
            }
            objArr[0] = obj;
        }
    }
}
