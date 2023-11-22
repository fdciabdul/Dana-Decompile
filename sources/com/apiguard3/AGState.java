package com.apiguard3;

import android.media.AudioTrack;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.setBackgroundTintList;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'APIGuardStateNotReady' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class AGState {
    private static long AGState = 0;
    private static int APIGuard = 1;
    public static final AGState APIGuardStateFailed;
    public static final AGState APIGuardStateInProgress;
    public static final AGState APIGuardStateNotReady;
    public static final AGState APIGuardStateReady;
    private static int getSharedInstance;
    private static final /* synthetic */ AGState[] valueOf;
    private static char[] values;

    static void AGState() {
        AGState = -23237595132502604L;
        values = new char[]{'A', 24036, 47905, 6491, 30373, 54501, 12874, 36744, 60915, 19232, 43369, 1736, 25621, 49770, 8119, 32248, 56082, 14481, 38601, 62520, 21097, 'A', 24036, 47905, 6491, 30373, 54501, 12874, 36744, 60915, 19232, 43369, 1736, 25621, 49773, 8118, 32220, 56114, 14491, 38607, 62510, 21109, 44983, 3339, 'A', 24036, 47905, 6491, 30373, 54501, 12874, 36744, 60915, 19232, 43369, 1736, 25621, 49762, 8121, 32229, 56108, 14481, 38604, 31159, 9234, 49879, 24749, 3923, 44307, 19388, 63102, 37893, 13014, 53407, 32574, 7651, 48000, 26187, 1051, 41682, 16763};
    }

    private AGState(String str, int i) {
    }

    public static AGState valueOf(String str) {
        int i = getSharedInstance + 119;
        APIGuard = i % 128;
        boolean z = i % 2 != 0;
        AGState aGState = (AGState) Enum.valueOf(AGState.class, str);
        if (!z) {
            throw null;
        }
        int i2 = getSharedInstance + 83;
        APIGuard = i2 % 128;
        if (i2 % 2 != 0) {
            return aGState;
        }
        throw null;
    }

    public static AGState[] values() {
        getSharedInstance = (APIGuard + 59) % 128;
        AGState[] aGStateArr = (AGState[]) valueOf.clone();
        int i = APIGuard + 33;
        getSharedInstance = i % 128;
        if ((i % 2 != 0 ? 'C' : '6') != 'C') {
            return aGStateArr;
        }
        throw new ArithmeticException();
    }

    static {
        AGState();
        Object[] objArr = new Object[1];
        AGState(ViewConfiguration.getMaximumDrawingCacheSize() >> 24, (char) TextUtils.indexOf("", "", 0, 0), (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 21, objArr);
        AGState aGState = new AGState(((String) objArr[0]).intern(), 0);
        APIGuardStateNotReady = aGState;
        Object[] objArr2 = new Object[1];
        AGState(22 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (ViewConfiguration.getKeyRepeatTimeout() >> 16), 23 - (ViewConfiguration.getTapTimeout() >> 16), objArr2);
        AGState aGState2 = new AGState(((String) objArr2[0]).intern(), 1);
        APIGuardStateInProgress = aGState2;
        Object[] objArr3 = new Object[1];
        AGState(43 - TextUtils.lastIndexOf("", '0'), (char) ExpandableListView.getPackedPositionType(0L), (ViewConfiguration.getScrollDefaultDelay() >> 16) + 19, objArr3);
        AGState aGState3 = new AGState(((String) objArr3[0]).intern(), 2);
        APIGuardStateFailed = aGState3;
        Object[] objArr4 = new Object[1];
        AGState((AudioTrack.getMinVolume() > 0.0f ? 1 : (AudioTrack.getMinVolume() == 0.0f ? 0 : -1)) + 63, (char) (31222 - (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1))), (ViewConfiguration.getLongPressTimeout() >> 16) + 18, objArr4);
        AGState aGState4 = new AGState(((String) objArr4[0]).intern(), 3);
        APIGuardStateReady = aGState4;
        valueOf = new AGState[]{aGState, aGState2, aGState3, aGState4};
        int i = APIGuard + 31;
        getSharedInstance = i % 128;
        if ((i % 2 != 0 ? '7' : '=') == '=') {
            return;
        }
        throw new ArithmeticException();
    }

    private static void AGState(int i, char c, int i2, Object[] objArr) {
        String str;
        synchronized (setBackgroundTintList.AGState) {
            char[] cArr = new char[i2];
            setBackgroundTintList.getSharedInstance = 0;
            while (setBackgroundTintList.getSharedInstance < i2) {
                cArr[setBackgroundTintList.getSharedInstance] = (char) ((values[setBackgroundTintList.getSharedInstance + i] ^ (setBackgroundTintList.getSharedInstance * AGState)) ^ c);
                setBackgroundTintList.getSharedInstance++;
            }
            str = new String(cArr);
        }
        objArr[0] = str;
    }
}
