package com.appsflyer.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Process;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.Gravity;
import android.webkit.URLUtil;
import com.alibaba.ariver.remotedebug.RDConstant;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.appsflyer.AFLogger;
import com.google.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class d {
    private static char AFInAppEventParameterName = 37945;
    private static char AFInAppEventType = 2566;
    private static char AFKeystoreWrapper = 53514;
    private static int AFVersionDeclaration = 0;
    private static int getLevel = 1;
    private static char valueOf = 4568;
    private static long values = 123364835749994368L;

    d() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String values(Context context, long j) {
        String AFInAppEventParameterName2;
        String intern;
        String AFInAppEventParameterName3;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb2.append((valueOf(AFInAppEventParameterName("閺ﱤ⭾\ud861툗룹㮄\udec8镣뛫煄깅\ue9f4猽嵵䑱柖㼜\uf675鉀煄깅\ue9f4猽嵵䑱柖㼜\uf262∩핁\u17ed䝟燎卭瑕").intern()) ? values("師䆚") : AFInAppEventParameterName("큮\ud8fc")).intern());
        StringBuilder sb4 = new StringBuilder();
        String packageName = context.getPackageName();
        String AFKeystoreWrapper2 = AFKeystoreWrapper(packageName);
        sb2.append(values("師䆚").intern());
        sb4.append(AFKeystoreWrapper2);
        if (values(context) == null) {
            sb2.append(AFInAppEventParameterName("큮\ud8fc").intern());
            sb4.append(packageName);
        } else {
            sb2.append(values("師䆚").intern());
            sb4.append(packageName);
            getLevel = (AFVersionDeclaration + 111) % 128;
        }
        String valueOf2 = valueOf(context);
        if (valueOf2 == null) {
            sb2.append(AFInAppEventParameterName("큮\ud8fc").intern());
            sb4.append(packageName);
        } else {
            sb2.append(values("師䆚").intern());
            sb4.append(valueOf2);
        }
        sb4.append(values(context, packageName));
        sb.append(sb4.toString());
        try {
            sb.append(new SimpleDateFormat(values("ދᡲჯक़Ǖ㨚㊏⬀⏵將咊䴦䕌緇癷滈权鿈頜").intern(), Locale.US).format(new Date(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime)));
            sb.append(j);
            if ((!valueOf(AFInAppEventParameterName("洰⊭⭾\ud861툗룹㮄\udec8\uf4b9թ\uef45㧀\uf21d䕻錰䇷\udb0d\ue1aa\ue2d6噗ᬤ㸬㏡⅀\udb0d\ue1aa").intern())) != true) {
                AFVersionDeclaration = (getLevel + 33) % 128;
                AFInAppEventParameterName2 = values("師䆚");
            } else {
                AFInAppEventParameterName2 = AFInAppEventParameterName("큮\ud8fc");
            }
            sb3.append(AFInAppEventParameterName2.intern());
            if (valueOf(values("룷꜖渀㔁ﰮ茼䨣ᄥ\ud816齇♇\ued6f둰筼ɣ즋邕埉ẍꖰ沢㎰𥉉臃").intern())) {
                int i = AFVersionDeclaration + 57;
                getLevel = i % 128;
                if ((i % 2 == 0 ? '0' : (char) 0) != 0) {
                    values("師䆚").intern();
                    throw new NullPointerException();
                }
                intern = values("師䆚").intern();
                AFVersionDeclaration = (getLevel + 21) % 128;
            } else {
                intern = AFInAppEventParameterName("큮\ud8fc").intern();
            }
            sb3.append(intern);
            if (valueOf(AFInAppEventParameterName("\ude82\ue6a8⭾\ud861툗룹㮄\udec8\uf4b9թ\uef45㧀⋽䜪嗚\uee4fᵧ߂왴֙\ude9b죷").intern())) {
                AFVersionDeclaration = (getLevel + 77) % 128;
                AFInAppEventParameterName3 = values("師䆚");
            } else {
                AFInAppEventParameterName3 = AFInAppEventParameterName("큮\ud8fc");
            }
            sb3.append(AFInAppEventParameterName3.intern());
            sb3.append((valueOf(values("㧥☄氤뉋\uf866㺖䒷誧킆ᛣ崗挣ꤒ\uef74㕴箂").intern()) ? values("師䆚") : AFInAppEventParameterName("큮\ud8fc")).intern());
            String AFInAppEventType2 = af.AFInAppEventType(af.values(sb.toString()));
            String obj = sb2.toString();
            StringBuilder sb5 = new StringBuilder(AFInAppEventType2);
            sb5.setCharAt(17, Integer.toString(Integer.parseInt(obj, 2), 16).charAt(0));
            String obj2 = sb5.toString();
            String obj3 = sb3.toString();
            StringBuilder sb6 = new StringBuilder(obj2);
            sb6.setCharAt(27, Integer.toString(Integer.parseInt(obj3, 2), 16).charAt(0));
            return AFKeystoreWrapper(sb6.toString(), Long.valueOf(j));
        } catch (PackageManager.NameNotFoundException unused) {
            return values("嗧䨅됯ṗ䡹뉢\u1c8f䛡낍᪦䓢꽘ᥧ䍚굀ᜰ䇃ꯣᗘ羑ꧩᑇ縿꡵መ籫ꛏწ窢꒙ຢ祈ꍑ").intern();
        }
    }

    private static String AFKeystoreWrapper(String str, Long l) {
        if (str != null && l != null) {
            AFVersionDeclaration = (getLevel + 49) % 128;
            if (str.length() == 32) {
                StringBuilder sb = new StringBuilder(str);
                String obj = l.toString();
                long j = 0;
                int i = 0;
                int i2 = 0;
                while (true) {
                    if (i >= obj.length()) {
                        break;
                    }
                    int i3 = getLevel + 85;
                    AFVersionDeclaration = i3 % 128;
                    if ((i3 % 2 != 0 ? '4' : '\r') != '4') {
                        i2 += Character.getNumericValue(obj.charAt(i));
                        i++;
                    } else {
                        i2 >>= Character.getNumericValue(obj.charAt(i));
                        i += 49;
                    }
                }
                String hexString = Integer.toHexString(i2);
                sb.replace(7, hexString.length() + 7, hexString);
                int i4 = 0;
                while (true) {
                    if (i4 >= sb.length()) {
                        break;
                    }
                    j += Character.getNumericValue(sb.charAt(i4));
                    i4++;
                }
                while (true) {
                    if ((j > 100 ? (char) 28 : (char) 24) == 24) {
                        break;
                    }
                    int i5 = getLevel + 13;
                    int i6 = i5 % 128;
                    AFVersionDeclaration = i6;
                    j = i5 % 2 != 0 ? j & 100 : j % 100;
                    getLevel = (i6 + 3) % 128;
                }
                sb.insert(23, (int) j);
                if (j < 10) {
                    sb.insert(23, AFInAppEventParameterName("큮\ud8fc").intern());
                }
                return sb.toString();
            }
        }
        return values("嗧䨅됯ṗ䡹뉢\u1c8f䛡낍᪦䓢꽘ᥧ䍚굀ᜰ䇃ꯣᗘ羑ꧩᑇ縿꡵መ籫ꛏწ窢꒙ຢ祈ꍑ").intern();
    }

    private static boolean valueOf(String str) {
        getLevel = (AFVersionDeclaration + 51) % 128;
        try {
            Class.forName(str);
            getLevel = (AFVersionDeclaration + 79) % 128;
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String AFKeystoreWrapper(String str) {
        int i = 1;
        if (!str.contains(values("\udb3b쒕").intern())) {
            int i2 = AFVersionDeclaration + 97;
            getLevel = i2 % 128;
            if (!(i2 % 2 == 0)) {
                return str;
            }
            throw new NullPointerException();
        }
        String[] split = str.split(AFInAppEventParameterName("귫౮ቮ᪺").intern());
        int length = split.length;
        StringBuilder sb = new StringBuilder();
        int i3 = length - 1;
        sb.append(split[i3]);
        sb.append(values("\udb3b쒕").intern());
        getLevel = (AFVersionDeclaration + 79) % 128;
        while (true) {
            if ((i < i3 ? (char) 31 : '\f') == '\f') {
                sb.append(split[0]);
                return sb.toString();
            }
            AFVersionDeclaration = (getLevel + 107) % 128;
            sb.append(split[i]);
            sb.append(values("\udb3b쒕").intern());
            i++;
        }
    }

    private static String values(Context context) {
        String str = null;
        if ((System.getProperties().containsKey(values("\ue219ﷳ\udbd3립鞅痓卿ㅀས\ued15쬗꣣蛈撬䊬").intern()) ? 'A' : '[') == 'A') {
            try {
                Matcher matcher = Pattern.compile(AFInAppEventParameterName("쨩ℏ즼㊈視鹫缡ꭖ㚛泧䕰뫰").intern()).matcher(context.getCacheDir().getPath().replace(AFInAppEventParameterName("ᨎ쭜䶴陊\uf408帬祖軖").intern(), ""));
                if ((matcher.find() ? '/' : (char) 19) != 19) {
                    getLevel = (AFVersionDeclaration + 109) % 128;
                    str = matcher.group(1);
                    AFVersionDeclaration = (getLevel + 117) % 128;
                }
            } catch (Exception e2) {
                aj valueOf2 = aj.valueOf();
                String intern = AFInAppEventParameterName("湀\ud841倴連断\u2fec팷惂뤚뫗\uf31d戴\ue9f4猽㪬⎮髼ᐁ").intern();
                StringBuilder sb = new StringBuilder();
                sb.append(AFInAppEventParameterName("壐樅\ueda7弙삤烉ӯ븢꜡㙤㕌櫩钴후嫶䌌볃놙倴連ᷤ蓉섎奱걏︠\uf837푤ꍟԅଣ窀\uf31d戴\ue9f4猽㪬⎮髼ᐁ륞㠻").intern());
                sb.append(e2);
                valueOf2.AFInAppEventType(null, intern, sb.toString());
                return null;
            }
        }
        return str;
    }

    private static String valueOf(Context context) {
        int i = getLevel + 41;
        AFVersionDeclaration = i % 128;
        if (i % 2 != 0) {
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
            getLevel = (AFVersionDeclaration + 47) % 128;
            return str;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private static String values(Context context, String str) {
        try {
            Iterator it = ((List) PackageManager.class.getDeclaredMethod(AFInAppEventParameterName("\uf6b8鿮钴후돘≷蕃昴钸䙡삤烉迏꣪璿\ue58b荤ᑪ䶴陊㪬⎮髼ᐁ쓎\ud849").intern(), Integer.TYPE).invoke(context.getPackageManager(), 0)).iterator();
            AFVersionDeclaration = (getLevel + 123) % 128;
            while (it.hasNext()) {
                AFVersionDeclaration = (getLevel + 39) % 128;
                if ((!((PackageItemInfo) it.next()).packageName.equals(str)) == false) {
                    int i = getLevel + 13;
                    AFVersionDeclaration = i % 128;
                    if (!(i % 2 != 0)) {
                        return Boolean.TRUE.toString();
                    }
                    throw null;
                }
            }
        } catch (IllegalAccessException e2) {
            aj valueOf2 = aj.valueOf();
            String intern = AFInAppEventParameterName("꾭孶倴連断\u2fec팷惂偸빁㛓ே삤烉⸳\uf401篛䠭쑅뒕䥦\uf855铺ꢻ㜃ꨍ").intern();
            StringBuilder sb = new StringBuilder();
            sb.append(AFInAppEventParameterName("求좌\ueda7弙삤烉ӯ븢寬쇈䃺裒ꠃ\u0a57榐햘㛓ே삤烉⸳\uf401鞾嗉\udbf1㛐钴후嵵䑱ӯ븢\uf837푤ꍟԅଣ窀\uf31d戴\ue9f4猽㪬⎮髼ᐁ륞㠻").intern());
            sb.append(e2);
            valueOf2.AFInAppEventType(null, intern, sb.toString());
        } catch (NoSuchMethodException e3) {
            aj valueOf3 = aj.valueOf();
            String intern2 = AFInAppEventParameterName("꾭孶倴連断\u2fec팷惂偸빁㛓ே삤烉⸳\uf401篛䠭쑅뒕䥦\uf855铺ꢻ㜃ꨍ").intern();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(AFInAppEventParameterName("求좌\ueda7弙삤烉ӯ븢寬쇈䃺裒ꠃ\u0a57榐햘㛓ே삤烉⸳\uf401鞾嗉\udbf1㛐钴후嵵䑱ӯ븢\uf837푤ꍟԅଣ窀\uf31d戴\ue9f4猽㪬⎮髼ᐁ륞㠻").intern());
            sb2.append(e3);
            valueOf3.AFInAppEventType(null, intern2, sb2.toString());
        } catch (InvocationTargetException e4) {
            aj valueOf4 = aj.valueOf();
            String intern3 = AFInAppEventParameterName("꾭孶倴連断\u2fec팷惂偸빁㛓ே삤烉⸳\uf401篛䠭쑅뒕䥦\uf855铺ꢻ㜃ꨍ").intern();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(AFInAppEventParameterName("求좌\ueda7弙삤烉ӯ븢寬쇈䃺裒ꠃ\u0a57榐햘㛓ே삤烉⸳\uf401鞾嗉\udbf1㛐钴후嵵䑱ӯ븢\uf837푤ꍟԅଣ窀\uf31d戴\ue9f4猽㪬⎮髼ᐁ륞㠻").intern());
            sb3.append(e4);
            valueOf4.AFInAppEventType(null, intern3, sb3.toString());
        }
        return Boolean.FALSE.toString();
    }

    /* loaded from: classes.dex */
    static final class e extends HashMap<String, Object> {
        private static int AFInAppEventParameterName = 0;
        private static int AFLogger$LogLevel = 1;
        private static long values = 3100330032987487916L;
        private final Context AFInAppEventType;
        private final Map<String, Object> AFKeystoreWrapper;
        public static final byte[] getAuthRequestContext = {8, -125, -40, -38, Ascii.NAK, -2, 22, 5, 2, 3, -46, 61, Ascii.DC4, 7, 14, -7, 17, 14, -62, Ascii.GS, TarHeader.LF_BLK, 7, 14, -7, Ascii.ESC, 4, 6, Ascii.ETB, -43, TarHeader.LF_CONTIG, 8, 4, 5, 2, 6, Ascii.ESC, -3, 14, 7, -29, 45, 0, 17};
        public static final int MyBillsEntityDataFactory = 103;
        private static char[] valueOf = {28, '9', '9', '9', 'O', 'e', 'h', 129, 260, 266, 271, 272, 253, 243, 264, 270, 261, 258, 243, 239, 263, 265, 'g', 209, 207, 205, 205, '2', 'J', '2', '4', '2', 'J', 'N', '5', 'K', 'L', '1', '0', '4', 'M', 'a', 'a', 'c', 'c', 's', 231, 233, 237, 234, 231, 232, 244, 255, 248, 238, 239, 247, 237, 228, 219, 241, 273, 271, 273, 270, 261, 234, 244, 276, 268, 271, 276, 270, 238, 236, 265, 271, 275, 270, 268, 266, ':', 'l', 'i', 'n', 'j', 'k', 'i', 'j', 't', 's', 'k', Typography.less, 'X', '7', 166, 'g', 166, 'g', Typography.section, 'f', Typography.section, 'f', 156, Typography.pound, 151, 170, 158, 153, 'h', 'h'};

        /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x002a -> B:11:0x0033). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(byte r7, short r8, byte r9, java.lang.Object[] r10) {
            /*
                int r9 = r9 * 22
                int r9 = 26 - r9
                byte[] r0 = com.appsflyer.internal.d.e.getAuthRequestContext
                int r8 = r8 * 5
                int r8 = 23 - r8
                int r7 = r7 * 6
                int r7 = r7 + 97
                byte[] r1 = new byte[r8]
                r2 = 0
                if (r0 != 0) goto L1a
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r10
                r10 = r9
                r9 = r8
                goto L33
            L1a:
                r3 = 0
            L1b:
                int r4 = r3 + 1
                byte r5 = (byte) r7
                r1[r3] = r5
                if (r4 != r8) goto L2a
                java.lang.String r7 = new java.lang.String
                r7.<init>(r1, r2)
                r10[r2] = r7
                return
            L2a:
                r3 = r0[r9]
                r6 = r9
                r9 = r8
                r8 = r3
                r3 = r1
                r1 = r0
                r0 = r10
                r10 = r6
            L33:
                int r10 = r10 + 1
                int r7 = r7 + r8
                int r7 = r7 + (-8)
                r8 = r9
                r9 = r10
                r10 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                goto L1b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.d.e.a(byte, short, byte, java.lang.Object[]):void");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Map<String, Object> map, Context context) {
            this.AFKeystoreWrapper = map;
            this.AFInAppEventType = context;
            put(valueOf(), AFInAppEventParameterName());
        }

        private static StringBuilder valueOf(String... strArr) throws Exception {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (true) {
                if (i >= 3) {
                    break;
                }
                int i2 = AFLogger$LogLevel + 19;
                AFInAppEventParameterName = i2 % 128;
                if ((i2 % 2 != 0 ? Typography.less : ')') != '<') {
                    arrayList.add(Integer.valueOf(strArr[i].length()));
                    i++;
                } else {
                    arrayList.add(Integer.valueOf(strArr[i].length()));
                    i += 0;
                }
            }
            Collections.sort(arrayList);
            int intValue = ((Integer) arrayList.get(0)).intValue();
            StringBuilder sb = new StringBuilder();
            int i3 = 0;
            while (i3 < intValue) {
                AFInAppEventParameterName = (AFLogger$LogLevel + 75) % 128;
                Integer num = null;
                for (int i4 = 0; i4 < 3; i4++) {
                    AFInAppEventParameterName = (AFLogger$LogLevel + 31) % 128;
                    int charAt = strArr[i4].charAt(i3);
                    if ((num == null ? 'U' : '8') != 'U') {
                        charAt ^= num.intValue();
                    }
                    num = Integer.valueOf(charAt);
                }
                sb.append(Integer.toHexString(num.intValue()));
                i3++;
                AFInAppEventParameterName = (AFLogger$LogLevel + 1) % 128;
            }
            return sb;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
        private String valueOf() {
            AFInAppEventParameterName = (AFLogger$LogLevel + 49) % 128;
            int i = 4;
            try {
                String num = Integer.toString(Build.VERSION.SDK_INT);
                String obj = this.AFKeystoreWrapper.get(AFInAppEventParameterName("薝ṹ藼ꂳ鎙\uee9e덭輝缥ᦂ雳맚烨ᓞ鱋븉").intern()).toString();
                String obj2 = this.AFKeystoreWrapper.get(AFInAppEventParameterName("羹毌翛픒࠻甂ឞ⯴蔏").intern()).toString();
                if ((obj2 == null ? (char) 27 : '%') != '%') {
                    AFInAppEventParameterName = (AFLogger$LogLevel + 81) % 128;
                    obj2 = AFInAppEventParameterName("墧꺥壩၆❫婬矶䮰ꈋ\ua95b∪絀").intern();
                }
                StringBuilder sb = new StringBuilder(obj);
                sb.reverse();
                StringBuilder valueOf2 = valueOf(num, obj2, sb.toString());
                int length = valueOf2.length();
                if (length > 4) {
                    valueOf2.delete(4, length);
                } else {
                    while (true) {
                        if ((length < 4 ? '\f' : '9') != '\f') {
                            break;
                        }
                        length++;
                        valueOf2.append('1');
                    }
                }
                valueOf2.insert(0, AFInAppEventParameterName("骭\ue135髆忼㴛䀥䧐").intern());
                i = valueOf2.toString();
                return i;
            } catch (Exception e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(AFInAppEventParameterName("㘷栢㙑훯᥄摵쪏\uf6e7첄濗ᱝ쀴썔抍ᚨ쟱옠砧ॴ\ub74f6羣ఆ큆퍇狓ۖퟶ혈䠃㥺\ueaaa\uecf5俻㱽\ue056\ue3a9䊠㛈\ue713\ue615塚⦒諾ﲋ彃").intern());
                sb2.append(e);
                AFLogger.AFInAppEventParameterName(sb2.toString());
                int[] iArr = new int[i];
                // fill-array-data instruction
                iArr[0] = 0;
                iArr[1] = 7;
                iArr[2] = 0;
                iArr[3] = 7;
                return AFInAppEventParameterName(iArr, "\u0001\u0000\u0000\u0000\u0001\u0001\u0000", Process.supportsProcesses()).intern();
            }
        }

        private String AFInAppEventParameterName() {
            String obj;
            int i;
            try {
                String obj2 = this.AFKeystoreWrapper.get(AFInAppEventParameterName("薝ṹ藼ꂳ鎙\uee9e덭輝缥ᦂ雳맚烨ᓞ鱋븉").intern()).toString();
                String obj3 = this.AFKeystoreWrapper.get(AFInAppEventParameterName(new int[]{7, 15, 157, 0}, "\u0001\u0001\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001", !URLUtil.isJavaScriptUrl(RDConstant.JAVASCRIPT_SCHEME)).intern()).toString();
                String replaceAll = AFInAppEventParameterName(new int[]{22, 5, 157, 1}, "\u0001\u0000\u0000\u0001\u0001", !TextUtils.equals("", "")).intern().replaceAll(AFInAppEventParameterName("툮\ueaaf툃呱꺒펩\uf849쑣⢙").intern(), "");
                StringBuilder sb = new StringBuilder();
                sb.append(obj2);
                sb.append(obj3);
                sb.append(replaceAll);
                String values2 = af.values(sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append(values2.substring(0, 16));
                obj = sb2.toString();
            } catch (Exception e) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(AFInAppEventParameterName("꾊偓꿬\uee9e层ⅳㆁ෩唹垦奛㬺嫩嫼厮㳿徝䁖䱲↓䕋䟒䤀⭈䫺䪢䏍⳼侠瀧籮ᇭ畋瞋礯᭕穌竗珓ᰎ羹怲沏ƴ散杼楱ଭ").intern());
                sb3.append(e);
                AFLogger.AFInAppEventParameterName(sb3.toString());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(AFInAppEventParameterName(new int[]{27, 18, 0, 13}, "\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0001\u0000", PhoneNumberUtils.isGlobalPhoneNumber("")).intern());
                obj = sb4.toString();
            }
            String str = obj;
            try {
                Intent registerReceiver = this.AFInAppEventType.registerReceiver(null, new IntentFilter(AFInAppEventParameterName(new int[]{45, 37, 163, 0}, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0000\u0000\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0000\u0001\u0001\u0000\u0001\u0001\u0000\u0001\u0000\u0001\u0000\u0000\u0001", !TextUtils.isGraphic("")).intern()));
                int i2 = -2700;
                if ((registerReceiver != null ? 'a' : 'D') == 'a') {
                    AFLogger$LogLevel = (AFInAppEventParameterName + 17) % 128;
                    i2 = registerReceiver.getIntExtra(AFInAppEventParameterName(new int[]{82, 11, 0, 0}, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001", !URLUtil.isJavaScriptUrl(RDConstant.JAVASCRIPT_SCHEME)).intern(), -2700);
                }
                Context context = this.AFInAppEventType;
                try {
                    byte b = getAuthRequestContext[41];
                    byte b2 = b;
                    Object[] objArr = new Object[1];
                    a(b, b2, (byte) (b2 + 1), objArr);
                    Class<?> cls = Class.forName((String) objArr[0]);
                    byte b3 = (byte) (MyBillsEntityDataFactory & 1);
                    Object[] objArr2 = new Object[1];
                    a(b3, b3, getAuthRequestContext[41], objArr2);
                    String str2 = ((ApplicationInfo) cls.getMethod((String) objArr2[0], null).invoke(context, null)).nativeLibraryDir;
                    if (str2 != null) {
                        AFLogger$LogLevel = (AFInAppEventParameterName + 107) % 128;
                        if (str2.contains(AFInAppEventParameterName(new int[]{93, 3, 0, 3}, "\u0000\u0000\u0000", !URLUtil.isHttpUrl("http://")).intern())) {
                            int i3 = AFLogger$LogLevel + 73;
                            AFInAppEventParameterName = i3 % 128;
                            if ((i3 % 2 != 0 ? (char) 16 : Typography.quote) != 16) {
                                i = 1;
                                int size = ((SensorManager) this.AFInAppEventType.getSystemService(AFInAppEventParameterName("妿ટ姌둖篔ۢ䒔磣ꌓ൸").intern())).getSensorList(-1).size();
                                StringBuilder sb5 = new StringBuilder();
                                sb5.append(AFInAppEventParameterName("涞淼颍㲲ⓔ").intern());
                                sb5.append(i2);
                                sb5.append(AFInAppEventParameterName("㓷印㓑\ueda4ʵ脧").intern());
                                sb5.append(i);
                                sb5.append(AFInAppEventParameterName("ᓹꮼᓟᕣ襺瑞").intern());
                                sb5.append(size);
                                sb5.append(AFInAppEventParameterName("⳰赻Ⳗ㎧鱤盬").intern());
                                sb5.append(this.AFKeystoreWrapper.size());
                                String obj4 = sb5.toString();
                                StringBuilder sb6 = new StringBuilder();
                                sb6.append(str);
                                sb6.append(C0089d.values(C0089d.AFInAppEventType(C0089d.valueOf(obj4))));
                                return sb6.toString();
                            }
                        }
                    }
                    i = 0;
                    int size2 = ((SensorManager) this.AFInAppEventType.getSystemService(AFInAppEventParameterName("妿ટ姌둖篔ۢ䒔磣ꌓ൸").intern())).getSensorList(-1).size();
                    StringBuilder sb52 = new StringBuilder();
                    sb52.append(AFInAppEventParameterName("涞淼颍㲲ⓔ").intern());
                    sb52.append(i2);
                    sb52.append(AFInAppEventParameterName("㓷印㓑\ueda4ʵ脧").intern());
                    sb52.append(i);
                    sb52.append(AFInAppEventParameterName("ᓹꮼᓟᕣ襺瑞").intern());
                    sb52.append(size2);
                    sb52.append(AFInAppEventParameterName("⳰赻Ⳗ㎧鱤盬").intern());
                    sb52.append(this.AFKeystoreWrapper.size());
                    String obj42 = sb52.toString();
                    StringBuilder sb62 = new StringBuilder();
                    sb62.append(str);
                    sb62.append(C0089d.values(C0089d.AFInAppEventType(C0089d.valueOf(obj42))));
                    return sb62.toString();
                } catch (Throwable th) {
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        throw cause;
                    }
                    throw th;
                }
            } catch (Exception e2) {
                StringBuilder sb7 = new StringBuilder();
                sb7.append(AFInAppEventParameterName("꾊偓꿬\uee9e层ⅳㆁ෩唹垦奛㬺嫩嫼厮㳿徝䁖䱲↓䕋䟒䤀⭈䫺䪢䏍⳼侠瀧籮ᇭ畋瞋礯᭕穌竗珓ᰎ羹怲沏ƴ散杼楱ଭ").intern());
                sb7.append(e2);
                AFLogger.AFInAppEventParameterName(sb7.toString());
                StringBuilder sb8 = new StringBuilder();
                sb8.append(str);
                sb8.append(AFInAppEventParameterName(new int[]{96, 16, 54, 9}, null, !Gravity.isHorizontal(0)).intern());
                return sb8.toString();
            }
        }

        /* renamed from: com.appsflyer.internal.d$e$d  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0089d {
            Boolean AFInAppEventParameterName;
            public final Boolean valueOf;
            public final String values;

            C0089d() {
            }

            static byte[] valueOf(String str) throws Exception {
                return str.getBytes();
            }

            static byte[] AFInAppEventType(byte[] bArr) throws Exception {
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = (byte) (bArr[i] ^ ((i % 2) + 42));
                }
                return bArr;
            }

            static String values(byte[] bArr) throws Exception {
                StringBuilder sb = new StringBuilder();
                for (byte b : bArr) {
                    String hexString = Integer.toHexString(b);
                    if (hexString.length() == 1) {
                        hexString = "0".concat(String.valueOf(hexString));
                    }
                    sb.append(hexString);
                }
                return sb.toString();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0089d(String str, Boolean bool) {
                this.values = str;
                this.valueOf = bool;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r10v1 */
        /* JADX WARN: Type inference failed for: r10v12, types: [char[]] */
        private static String AFInAppEventParameterName(String str) {
            if (!(str == 0)) {
                AFInAppEventParameterName = (AFLogger$LogLevel + 3) % 128;
                str = str.toCharArray();
            }
            char[] valueOf2 = bz.valueOf(values, (char[]) str);
            int i = 4;
            while (true) {
                if (!(i < valueOf2.length)) {
                    break;
                }
                AFInAppEventParameterName = (AFLogger$LogLevel + 39) % 128;
                valueOf2[i] = (char) ((valueOf2[i] ^ valueOf2[i % 4]) ^ (((long) (i - 4)) * values));
                i++;
            }
            String str2 = new String(valueOf2, 4, valueOf2.length - 4);
            int i2 = AFInAppEventParameterName + 19;
            AFLogger$LogLevel = i2 % 128;
            if ((i2 % 2 == 0 ? '!' : '7') == '7') {
                return str2;
            }
            throw null;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r13v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r13v1 */
        /* JADX WARN: Type inference failed for: r13v21, types: [byte[]] */
        private static String AFInAppEventParameterName(int[] iArr, String str, boolean z) {
            int i = 0;
            if (!(str == 0)) {
                str = str.getBytes("ISO-8859-1");
            }
            byte[] bArr = (byte[]) str;
            int i2 = iArr[0];
            int i3 = iArr[1];
            int i4 = iArr[2];
            int i5 = iArr[3];
            char[] cArr = new char[i3];
            System.arraycopy(valueOf, i2, cArr, 0, i3);
            if (bArr != null) {
                char[] cArr2 = new char[i3];
                char c = 0;
                for (int i6 = 0; i6 < i3; i6++) {
                    if ((bArr[i6] == 1 ? 'b' : (char) 20) != 20) {
                        cArr2[i6] = (char) (((cArr[i6] << 1) + 1) - c);
                    } else {
                        cArr2[i6] = (char) ((cArr[i6] << 1) - c);
                    }
                    c = cArr2[i6];
                }
                cArr = cArr2;
            }
            if (i5 > 0) {
                int i7 = AFInAppEventParameterName + 125;
                AFLogger$LogLevel = i7 % 128;
                if (i7 % 2 == 0) {
                    char[] cArr3 = new char[i3];
                    System.arraycopy(cArr, 0, cArr3, 0, i3);
                    System.arraycopy(cArr3, 1, cArr, i3 >>> i5, i5);
                    System.arraycopy(cArr3, i5, cArr, 1, i3 << i5);
                } else {
                    char[] cArr4 = new char[i3];
                    System.arraycopy(cArr, 0, cArr4, 0, i3);
                    int i8 = i3 - i5;
                    System.arraycopy(cArr4, 0, cArr, i8, i5);
                    System.arraycopy(cArr4, i5, cArr, 0, i8);
                }
            }
            if (z) {
                char[] cArr5 = new char[i3];
                for (int i9 = 0; i9 < i3; i9++) {
                    cArr5[i9] = cArr[(i3 - i9) - 1];
                }
                cArr = cArr5;
            }
            if (i4 > 0) {
                int i10 = AFInAppEventParameterName + 65;
                while (true) {
                    AFLogger$LogLevel = i10 % 128;
                    if (i >= i3) {
                        break;
                    }
                    cArr[i] = (char) (cArr[i] - iArr[2]);
                    i++;
                    i10 = AFInAppEventParameterName + 7;
                }
            }
            return new String(cArr);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v4, types: [char[]] */
    private static String AFInAppEventParameterName(String str) {
        if (str != 0) {
            AFVersionDeclaration = (getLevel + 121) % 128;
            str = str.toCharArray();
        }
        char[] cArr = (char[]) str;
        char[] cArr2 = new char[cArr.length];
        char[] cArr3 = new char[2];
        int i = 0;
        while (true) {
            if ((i < cArr.length ? ']' : 'S') == ']') {
                getLevel = (AFVersionDeclaration + 99) % 128;
                cArr3[0] = cArr[i];
                int i2 = i + 1;
                cArr3[1] = cArr[i2];
                by.AFInAppEventParameterName(cArr3, AFKeystoreWrapper, AFInAppEventParameterName, valueOf, AFInAppEventType);
                cArr2[i] = cArr3[0];
                cArr2[i2] = cArr3[1];
                i += 2;
            } else {
                return new String(cArr2, 1, (int) cArr2[0]);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v7, types: [char[]] */
    private static String values(String str) {
        if (str != 0) {
            int i = getLevel + 1;
            AFVersionDeclaration = i % 128;
            if ((i % 2 != 0 ? (char) 11 : '\n') != '\n') {
                throw new NullPointerException();
            }
            str = str.toCharArray();
        }
        char[] cArr = (char[]) str;
        char c = cArr[0];
        char[] cArr2 = new char[cArr.length - 1];
        for (int i2 = 1; i2 < cArr.length; i2++) {
            int i3 = getLevel + 119;
            AFVersionDeclaration = i3 % 128;
            if ((i3 % 2 != 0 ? '3' : '#') == '3') {
                throw new ArithmeticException();
            }
            cArr2[i2 - 1] = (char) ((cArr[i2] ^ (i2 * c)) ^ values);
        }
        return new String(cArr2);
    }
}
