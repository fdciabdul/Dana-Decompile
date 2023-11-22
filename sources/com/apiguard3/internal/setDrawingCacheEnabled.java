package com.apiguard3.internal;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.PointF;
import android.os.Process;
import android.os.SystemClock;
import android.telephony.cdma.CdmaCellLocation;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.google.common.base.Ascii;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.huawei.hms.push.e;

/* loaded from: classes7.dex */
public final class setDrawingCacheEnabled {
    private static void getSharedInstance(Object[] objArr) {
        objArr[0] = a.class;
        objArr[1] = e.PlaceComponentResult;
        objArr[2] = "(Ljava/lang/String;[B)V";
        objArr[3] = "Java_com_apiguard3_internal_a_e";
        objArr[4] = a.class;
        objArr[5] = "c";
        objArr[6] = "(Ljava/lang/String;[Ljava/lang/Object;)V";
        objArr[7] = "Java_com_apiguard3_internal_a_c";
    }

    private static void valueOf(Object[] objArr) {
        objArr[0] = (Class) AGState.values((ViewConfiguration.getScrollDefaultDelay() >> 16) + 7303, 23 - ImageFormat.getBitsPerPixel(0), (char) (49277 - View.getDefaultSize(0, 0)));
        objArr[1] = "a";
        objArr[2] = "(II)[B";
        objArr[3] = "Java_com_apiguard3_internal_f_a";
        objArr[4] = (Class) AGState.values(View.MeasureSpec.getSize(0) + 7359, ((byte) KeyEvent.getModifierMetaStateMask()) + Ascii.EM, (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
        objArr[5] = "c";
        objArr[6] = "(I)J";
        objArr[7] = "Java_com_apiguard3_internal_g_c";
        objArr[8] = (Class) AGState.values((SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)) + 8427, 24 - Gravity.getAbsoluteGravity(0, 0), (char) (ViewConfiguration.getScrollBarSize() >> 8));
        objArr[9] = d.f7256a;
        objArr[10] = "(Ljava/lang/String;)Ljava/lang/String;";
        objArr[11] = "Java_com_apiguard3_internal_p_d";
        objArr[12] = (Class) AGState.values(6778 - TextUtils.indexOf((CharSequence) "", '0', 0), (Process.myPid() >> 22) + 24, (char) ((ViewConfiguration.getFadingEdgeLength() >> 16) + 60048));
        objArr[13] = "c";
        objArr[14] = "(Ljava/lang/String;)I";
        objArr[15] = "Java_com_apiguard3_internal_b_c";
        objArr[16] = (Class) AGState.values(TextUtils.lastIndexOf("", '0', 0, 0) + 6780, 25 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (char) (60048 - (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1))));
        objArr[17] = "b";
        objArr[18] = "(Ljava/lang/String;)I";
        objArr[19] = "Java_com_apiguard3_internal_b_b";
        objArr[20] = (Class) AGState.values((ViewConfiguration.getJumpTapTimeout() >> 16) + 8380, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, (char) (ViewConfiguration.getMaximumFlingVelocity() >> 16));
        objArr[21] = e.PlaceComponentResult;
        objArr[22] = "(Ljava/lang/String;)I";
        objArr[23] = "Java_com_apiguard3_internal_q_e";
        objArr[24] = (Class) AGState.values((ViewConfiguration.getMinimumFlingVelocity() >> 16) + 8219, 23 - TextUtils.lastIndexOf("", '0', 0, 0), (char) (23563 - View.resolveSize(0, 0)));
        objArr[25] = "c";
        objArr[26] = "(Ljava/lang/String;Ljava/lang/String;)I";
        objArr[27] = "Java_com_apiguard3_internal_n_c";
        objArr[28] = (Class) AGState.values(8453 - (SystemClock.elapsedRealtime() > 0L ? 1 : (SystemClock.elapsedRealtime() == 0L ? 0 : -1)), KeyEvent.keyCodeFromString("") + 24, (char) (TextUtils.indexOf("", "") + 22546));
        objArr[29] = d.f7256a;
        objArr[30] = "(Ljava/lang/String;)I";
        objArr[31] = "Java_com_apiguard3_internal_s_d";
        objArr[32] = (Class) AGState.values((PointF.length(0.0f, 0.0f) > 0.0f ? 1 : (PointF.length(0.0f, 0.0f) == 0.0f ? 0 : -1)) + 8794, 23 - TextUtils.lastIndexOf("", '0'), (char) (CdmaCellLocation.convertQuartSecToDecDegrees(0) > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 1 : (CdmaCellLocation.convertQuartSecToDecDegrees(0) == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE ? 0 : -1)));
        objArr[33] = d.f7256a;
        objArr[34] = "(Ljava/lang/String;)J";
        objArr[35] = "Java_com_apiguard3_internal_w_d";
        objArr[36] = (Class) AGState.values(View.resolveSizeAndState(0, 0, 0) + 8476, TextUtils.indexOf("", "", 0, 0) + 24, (char) ((TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)) + 21682));
        objArr[37] = "b";
        objArr[38] = "(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;";
        objArr[39] = "Java_com_apiguard3_internal_x_b";
        objArr[40] = (Class) AGState.values(8308 - (ViewConfiguration.getFadingEdgeLength() >> 16), 25 - (Process.getElapsedCpuTime() > 0L ? 1 : (Process.getElapsedCpuTime() == 0L ? 0 : -1)), (char) (17758 - View.resolveSize(0, 0)));
        objArr[41] = d.f7256a;
        objArr[42] = "(Ljava/lang/String;I)I";
        objArr[43] = "Java_com_apiguard3_internal_k_d";
        objArr[44] = (Class) AGState.values(TextUtils.indexOf("", "") + 8243, (ViewConfiguration.getMaximumDrawingCacheSize() >> 24) + 24, (char) (ExpandableListView.getPackedPositionType(0L) + 38562));
        objArr[45] = "c";
        objArr[46] = "()I";
        objArr[47] = "Java_com_apiguard3_internal_m_c";
        objArr[48] = (Class) AGState.values(8195 - Color.red(0), (ViewConfiguration.getTouchSlop() >> 8) + 24, (char) ((SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)) + 60965));
        objArr[49] = d.f7256a;
        objArr[50] = "()I";
        objArr[51] = "Java_com_apiguard3_internal_l_d";
        objArr[52] = (Class) AGState.values((ViewConfiguration.getKeyRepeatDelay() >> 16) + 7656, 24 - (TypedValue.complexToFraction(0, 0.0f, 0.0f) > 0.0f ? 1 : (TypedValue.complexToFraction(0, 0.0f, 0.0f) == 0.0f ? 0 : -1)), (char) (40687 - TextUtils.indexOf((CharSequence) "", '0', 0, 0)));
        objArr[53] = "a";
        objArr[54] = "()I";
        objArr[55] = "Java_com_apiguard3_internal_j_a";
        objArr[56] = (Class) AGState.values(8357 - (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)), (ViewConfiguration.getGlobalActionKeyTimeout() > 0L ? 1 : (ViewConfiguration.getGlobalActionKeyTimeout() == 0L ? 0 : -1)) + 23, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
        objArr[57] = d.f7256a;
        objArr[58] = "()I";
        objArr[59] = "Java_com_apiguard3_internal_r_d";
        objArr[60] = (Class) AGState.values(((byte) KeyEvent.getModifierMetaStateMask()) + 6845, (Process.myPid() >> 22) + 24, (char) (TextUtils.indexOf((CharSequence) "", '0', 0) + 1));
        objArr[61] = "b";
        objArr[62] = "()I";
        objArr[63] = "Java_com_apiguard3_internal_h_b";
        objArr[64] = (Class) AGState.values(8405 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1)), 25 - (SystemClock.elapsedRealtimeNanos() > 0L ? 1 : (SystemClock.elapsedRealtimeNanos() == 0L ? 0 : -1)), (char) (1 - (SystemClock.currentThreadTimeMillis() > (-1L) ? 1 : (SystemClock.currentThreadTimeMillis() == (-1L) ? 0 : -1))));
        objArr[65] = "b";
        objArr[66] = "()I";
        objArr[67] = "Java_com_apiguard3_internal_t_b";
        objArr[68] = (Class) AGState.values(7053 - (ViewConfiguration.getEdgeSlop() >> 16), 23 - TextUtils.indexOf((CharSequence) "", '0', 0, 0), (char) (10675 - TextUtils.indexOf("", "")));
        objArr[69] = "b";
        objArr[70] = "()I";
        objArr[71] = "Java_com_apiguard3_internal_i_b";
        objArr[72] = (Class) AGState.values(8332 - (ViewConfiguration.getMinimumFlingVelocity() >> 16), (ViewConfiguration.getLongPressTimeout() >> 16) + 24, (char) (ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)));
        objArr[73] = "b";
        objArr[74] = "()I";
        objArr[75] = "Java_com_apiguard3_internal_o_b";
    }

    public static int values(byte[] bArr) {
        int i = -2128831035;
        for (byte b : bArr) {
            i = (i ^ b) * 16777619;
        }
        return i;
    }

    public static void AGState(int i, String str) {
        Object[] objArr;
        if (i == -1112382603) {
            objArr = new Object[8];
            getSharedInstance(objArr);
        } else if (i != -860837030) {
            objArr = null;
        } else {
            objArr = new Object[76];
            valueOf(objArr);
        }
        if (objArr != null) {
            a.c(str, objArr);
        }
    }
}
