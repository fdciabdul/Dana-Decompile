package com.apiguard3.domain;

import android.graphics.Color;
import android.media.AudioTrack;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import android.widget.ExpandableListView;
import com.apiguard3.internal.AGState;
import com.apiguard3.internal.ConfigInstance;
import com.apiguard3.internal.writeReplace;

/* loaded from: classes7.dex */
public class APIGuard extends Exception {
    private static char[] getSharedInstance = {13754, 13813, 13823, 13821, 13755, 13800, 13782, 13817, 13822};
    private static char valueOf = 3;
    final ConfigInstance.ConfigSerializationProxy.AGState code;

    public APIGuard(String str) {
        super(str);
        this.code = writeReplace.getSharedInstance.APIGuard$Callback;
    }

    public APIGuard(ConfigInstance.ConfigSerializationProxy.AGState aGState) {
        super(aGState.getSharedInstance());
        Object[] objArr = new Object[1];
        APIGuard("\u0007\u0000㙁㙁\u0005\b\u0001\u0006\u0002\u0007㙃", (byte) (Color.argb(0, 0, 0, 0) + 68), (AudioTrack.getMaxVolume() > 0.0f ? 1 : (AudioTrack.getMaxVolume() == 0.0f ? 0 : -1)) + 10, objArr);
        try {
            ((Class) AGState.values(6608 - KeyEvent.getDeadChar(0, 0), ExpandableListView.getPackedPositionType(0L) + 41, (char) (26076 - (ViewConfiguration.getEdgeSlop() >> 16)))).getMethod("valueOf", Object.class, String.class).invoke(null, aGState, ((String) objArr[0]).intern());
            this.code = aGState;
        } catch (Throwable th) {
            Throwable cause = th.getCause();
            if (cause == null) {
                throw th;
            }
            throw cause;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r12 = r12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void APIGuard(java.lang.String r12, byte r13, int r14, java.lang.Object[] r15) {
        /*
            Method dump skipped, instructions count: 257
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apiguard3.domain.APIGuard.APIGuard(java.lang.String, byte, int, java.lang.Object[]):void");
    }
}
