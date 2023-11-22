package com.alibaba.ariver.websocket.core;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alipay.android.phone.mobilesdk.socketcraft.api.BasicWebSocketContext;
import com.alipay.android.phone.mobilesdk.socketcraft.api.DefaultWebSocketClient;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WSContextConstant;
import com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketCallback;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.DefaultMonitorPrinter;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.monitor.MonitorPrinterFactory;
import com.google.common.base.Ascii;
import com.google.zxing.pdf417.PDF417Common;
import id.dana.onboarding.splash.LauncherActivity;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import o.SummaryVoucherView$$ExternalSyntheticLambda0;

/* loaded from: classes6.dex */
public class DefaultRVWebSocketClient extends BaseWebSocketClient implements WebSocketCallback {
    private static boolean b;

    /* renamed from: a  reason: collision with root package name */
    private DefaultWebSocketClient f6250a;
    public static final byte[] $$d = {37, 81, 122, 15, 1, -48, 4, -25, -7, 35, -43, -10, -3, 65, -39, -36, -26, 12, TarHeader.LF_FIFO, -71, -8, -5, -16, 4, -24, 6, -6, 15, -40, -6, Ascii.DC4, -40, 12, -26, 4, -1, 15, -31, -15, 4, -10, -20, -8, 72, -21};
    public static final int $$e = 151;
    public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {41, -91, 83, 107, -7, -1, 7, 4, -13, 9, 3, -51, Ascii.ETB, 16, -13, -39, 42, -13, -1, -11, 19, -23, -53, 60, -13, 11, -9, -59, 35, 36, -8, -1, -17, 6};
    public static final int getAuthRequestContext = 70;

    private static void g(int i, short s, short s2, Object[] objArr) {
        int i2 = 16 - (i * 2);
        byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
        int i3 = 106 - s2;
        int i4 = s + 4;
        byte[] bArr2 = new byte[i2];
        int i5 = -1;
        int i6 = i2 - 1;
        if (bArr == null) {
            i3 = i4 + i3 + 2;
            i4 = i4;
        }
        while (true) {
            i5++;
            bArr2[i5] = (byte) i3;
            if (i5 == i6) {
                objArr[0] = new String(bArr2, 0);
                return;
            }
            int i7 = i4 + 1;
            i3 = i3 + bArr[i7] + 2;
            i4 = i7;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:11:0x002e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void h(short r6, int r7, short r8, java.lang.Object[] r9) {
        /*
            int r8 = r8 * 4
            int r8 = 75 - r8
            int r6 = r6 * 4
            int r6 = 42 - r6
            byte[] r0 = com.alibaba.ariver.websocket.core.DefaultRVWebSocketClient.$$d
            int r7 = r7 * 4
            int r7 = 4 - r7
            byte[] r1 = new byte[r6]
            r2 = 0
            if (r0 != 0) goto L18
            r4 = r8
            r3 = 0
            r8 = r7
            r7 = r6
            goto L2e
        L18:
            r3 = 0
        L19:
            byte r4 = (byte) r8
            r1[r3] = r4
            int r3 = r3 + 1
            if (r3 != r6) goto L28
            java.lang.String r6 = new java.lang.String
            r6.<init>(r1, r2)
            r9[r2] = r6
            return
        L28:
            r4 = r0[r7]
            r5 = r7
            r7 = r6
            r6 = r8
            r8 = r5
        L2e:
            int r4 = -r4
            int r8 = r8 + 1
            int r6 = r6 + r4
            int r6 = r6 + (-7)
            r5 = r8
            r8 = r6
            r6 = r7
            r7 = r5
            goto L19
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.ariver.websocket.core.DefaultRVWebSocketClient.h(short, int, short, java.lang.Object[]):void");
    }

    public DefaultRVWebSocketClient(String str, URI uri, Map<String, String> map, RVWebSocketCallback rVWebSocketCallback) {
        super(str, uri.toString(), map, rVWebSocketCallback);
        BasicWebSocketContext basicWebSocketContext = new BasicWebSocketContext();
        basicWebSocketContext.setAttribute(WSContextConstant.BIZ_UNIQUE_ID, str);
        this.f6250a = new DefaultWebSocketClient(uri, map, this, basicWebSocketContext);
    }

    @Override // com.alibaba.ariver.websocket.core.BaseWebSocketClient
    protected void onCreate() {
        try {
            byte b2 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            Object[] objArr = new Object[1];
            g(b2, (byte) (b2 | 14), (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1), objArr);
            Class<?> cls = Class.forName((String) objArr[0]);
            byte b3 = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[5] + 1);
            byte b4 = KClassImpl$Data$declaredNonStaticMembers$2[5];
            Object[] objArr2 = new Object[1];
            g(b3, b4, (byte) (-b4), objArr2);
            try {
                Object[] objArr3 = {Integer.valueOf(((Integer) cls.getMethod((String) objArr2[0], Object.class).invoke(null, this)).intValue())};
                Object obj = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(25207140);
                if (obj == null) {
                    Class cls2 = (Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext((ViewConfiguration.getMaximumFlingVelocity() >> 16) + 494, (ViewConfiguration.getTapTimeout() >> 16) + 4, (char) (TypedValue.complexToFloat(0) > 0.0f ? 1 : (TypedValue.complexToFloat(0) == 0.0f ? 0 : -1)));
                    byte b5 = (byte) ($$d[4] - 1);
                    byte b6 = b5;
                    Object[] objArr4 = new Object[1];
                    h(b5, b6, b6, objArr4);
                    obj = cls2.getMethod((String) objArr4[0], Integer.TYPE);
                    SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(25207140, obj);
                }
                Object[] objArr5 = (Object[]) ((Method) obj).invoke(null, objArr3);
                int i = ((int[]) objArr5[1])[0];
                if (((int[]) objArr5[0])[0] != i) {
                    long j = ((r2 ^ i) & 4294967295L) | 42949672960L;
                    try {
                        Object obj2 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(783490791);
                        if (obj2 == null) {
                            obj2 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(View.MeasureSpec.getSize(0) + PDF417Common.NUMBER_OF_CODEWORDS, 35 - View.MeasureSpec.getMode(0), (char) TextUtils.indexOf("", "", 0, 0))).getMethod("BuiltInFictitiousFunctionClassFactory", null);
                            SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(783490791, obj2);
                        }
                        Object invoke = ((Method) obj2).invoke(null, null);
                        try {
                            Object[] objArr6 = {454794601, Long.valueOf(j), new ArrayList(), LauncherActivity.getAuid()};
                            Object obj3 = SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.get(1759031285);
                            if (obj3 == null) {
                                obj3 = ((Class) SummaryVoucherView$$ExternalSyntheticLambda0.getAuthRequestContext(911 - Color.green(0), 18 - KeyEvent.normalizeMetaState(0), (char) Color.red(0))).getMethod("MyBillsEntityDataFactory", Integer.TYPE, Long.TYPE, List.class, String.class);
                                SummaryVoucherView$$ExternalSyntheticLambda0.PrepareContext.put(1759031285, obj3);
                            }
                            ((Method) obj3).invoke(invoke, objArr6);
                        } catch (Throwable th) {
                            Throwable cause = th.getCause();
                            if (cause == null) {
                                throw th;
                            }
                            throw cause;
                        }
                    } catch (Throwable th2) {
                        Throwable cause2 = th2.getCause();
                        if (cause2 == null) {
                            throw th2;
                        }
                        throw cause2;
                    }
                }
                if (b) {
                    return;
                }
                MonitorPrinterFactory.setMonitorPrinter(new DefaultMonitorPrinter());
                b = true;
            } catch (Throwable th3) {
                Throwable cause3 = th3.getCause();
                if (cause3 == null) {
                    throw th3;
                }
                throw cause3;
            }
        } catch (Throwable th4) {
            Throwable cause4 = th4.getCause();
            if (cause4 == null) {
                throw th4;
            }
            throw cause4;
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketClient
    public void connect() {
        this.f6250a.connect();
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketClient
    public void connectWithSSL() throws IOException {
        this.f6250a.connectWithSSL();
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketClient
    public void send(byte[] bArr) throws NotYetConnectedException {
        StringBuilder sb = new StringBuilder();
        sb.append("send bytes: ");
        sb.append(bArr);
        RVLogger.d("AriverWebSocket:NXWebSocketClientAdapter", sb.toString());
        this.f6250a.send(ByteBuffer.wrap(Base64.decode(bArr, 2)));
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketClient
    public void send(String str) throws NotYetConnectedException {
        StringBuilder sb = new StringBuilder();
        sb.append("send msg: ");
        sb.append(str);
        RVLogger.d("AriverWebSocket:NXWebSocketClientAdapter", sb.toString());
        this.f6250a.send(str);
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketClient
    public void close() {
        if (this.f6250a.isClosing() || this.f6250a.isClosed()) {
            RVLogger.w("AriverWebSocket:NXWebSocketClientAdapter", "close but already closed!");
        } else {
            this.f6250a.close();
        }
    }

    @Override // com.alibaba.ariver.websocket.core.RVWebSocketClient
    public boolean isOpen() {
        return this.f6250a.isOpen();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketCallback
    public void onSocketOpen() {
        if (getCallback() != null) {
            getCallback().onSocketOpen();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketCallback
    public void onSocketClose() {
        if (getCallback() != null) {
            getCallback().onSocketClose();
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketCallback
    public void onSocketMessage(ByteBuffer byteBuffer) {
        if (getCallback() != null) {
            getCallback().onSocketMessage(byteBuffer.array());
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketCallback
    public void onSocketMessage(String str) {
        if (getCallback() != null) {
            getCallback().onSocketMessage(str);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.api.WebSocketCallback
    public void onSocketError(String str) {
        if (getCallback() != null) {
            getCallback().onSocketError(WebSocketResultEnum.getResultEnumByWsMsg(str).getErrCode(), str);
        }
    }
}
