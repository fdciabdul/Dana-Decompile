package com.alipay.android.phone.mobilesdk.socketcraft.api;

import com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_17;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.DataflowMonitorModel;
import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorHelper;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.threadpool.SCNetworkAsyncTaskUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.util.Charsetfunctions;
import com.alipay.android.phone.mobilesdk.socketcraft.util.WsMessageConstants;
import id.dana.myprofile.SettingMoreProfileActivity;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
public class DefaultWebSocketClient extends WebSocketClient {
    public static final int DEFAULT_CONNECTION_TIMEOUT = 60000;
    public static final int MIN_CONNECTION_TIMEOUT = 4000;

    /* renamed from: a  reason: collision with root package name */
    private WebSocketCallback f6898a;
    private Framedata b;
    private String c;
    private long d;
    private ScheduledFuture<?> e;
    private WebSocketContext f;
    private MonitorHelper g;
    private boolean h;

    public DefaultWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i, WebSocketCallback webSocketCallback, WebSocketContext webSocketContext) {
        super(uri, draft, map, i);
        this.h = false;
        this.f6898a = webSocketCallback;
        this.c = uri.toString();
        this.f = webSocketContext;
        if (i > 4000) {
            this.d = i;
        } else {
            this.d = SettingMoreProfileActivity.TOAST_DURATION;
        }
        this.g = new MonitorHelper(this);
    }

    public DefaultWebSocketClient(URI uri, Draft draft, Map<String, String> map, int i, WebSocketCallback webSocketCallback) {
        this(uri, draft, map, i, webSocketCallback, new BasicWebSocketContext());
    }

    public DefaultWebSocketClient(URI uri, Map<String, String> map, WebSocketCallback webSocketCallback) {
        this(uri, new Draft_17(), map, 60000, webSocketCallback);
    }

    public DefaultWebSocketClient(URI uri, Map<String, String> map, WebSocketCallback webSocketCallback, WebSocketContext webSocketContext) {
        this(uri, new Draft_17(), map, 60000, webSocketCallback, webSocketContext);
    }

    public void connectBlockingWithSSL() {
        setSslSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
        connectBlocking();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public boolean connectBlocking() {
        c();
        return super.connectBlocking();
    }

    public void connectWithSSL() {
        setSslSocketFactory((SSLSocketFactory) SSLSocketFactory.getDefault());
        connect();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void connect() {
        c();
        super.connect();
        a();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(String str) {
        if (str == null) {
            SCLogCatUtil.warn("WebSocketClient", "[send] text is null");
            return;
        }
        if (str.length() <= 0) {
            SCLogCatUtil.warn("WebSocketClient", "[send] text is empty, but continue send.");
        }
        super.send(str);
        this.g.recordMonitorOfSndMsg(str.length());
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), DataflowMonitorModel.METHOD_NAME_SEND, str.length(), 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            SCLogCatUtil.warn("WebSocketClient", "[send] byte[] is null or length <= 0.");
            return;
        }
        super.send(bArr);
        this.g.recordMonitorOfSndMsg(bArr.length);
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), DataflowMonitorModel.METHOD_NAME_SEND, bArr.length, 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void send(ByteBuffer byteBuffer) {
        if (byteBuffer == null || byteBuffer.array().length <= 0) {
            SCLogCatUtil.warn("WebSocketClient", "[send] ByteBuffer is null or length <= 0.");
            return;
        }
        super.send(byteBuffer);
        this.g.recordMonitorOfSndMsg(byteBuffer.array().length);
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), DataflowMonitorModel.METHOD_NAME_SEND, byteBuffer.array().length, 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onDns(String str, long j) {
        this.g.recordDnsTime(j);
        this.g.recordTargetHost(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onTcpConnect(String str, long j) {
        this.g.recordTcpTime(j);
        this.g.recordTargetHost(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onSSLHandshake(long j) {
        this.g.recordSSLTime(j);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onWsHandshake(long j) {
        StringBuilder sb = new StringBuilder("onWsHandshake cost: ");
        sb.append(j);
        SCLogCatUtil.info("WebSocketClient", sb.toString());
        this.g.recordWsHsTime(j);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onOpen(ServerHandshake serverHandshake) {
        d();
        b();
        SCLogCatUtil.info("WebSocketClient", String.format("onOpen. url is %s , state: opened", this.c));
        this.f6898a.onSocketOpen();
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), DataflowMonitorModel.METHOD_NAME_CONNECTION, this.c.length() + WSContextConstant.HANDSHAKE_SEND_SIZE, WSContextConstant.HANDSHAKE_RECEIVE_SIZE));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onMessage(String str) {
        Object[] objArr = new Object[2];
        objArr[0] = this.c;
        objArr[1] = Integer.valueOf(str != null ? str.length() : -1);
        SCLogCatUtil.info("WebSocketClient", String.format("onMessage. url is %s ,socket onmessage length :%d", objArr));
        if (str == null || str.length() <= 0) {
            return;
        }
        this.f6898a.onSocketMessage(str);
        this.g.recordMonitorOfRecvMsg(str.length());
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), "receive", 0, str.length()));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onMessage(ByteBuffer byteBuffer) {
        Object[] objArr = new Object[2];
        objArr[0] = this.c;
        objArr[1] = Integer.valueOf(byteBuffer != null ? byteBuffer.position() : -1);
        SCLogCatUtil.info("WebSocketClient", String.format("onMessage. url is %s , socket onMessage buffer length : %d", objArr));
        if (byteBuffer == null) {
            return;
        }
        this.f6898a.onSocketMessage(byteBuffer);
        this.g.recordMonitorOfRecvMsg(byteBuffer.position());
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), "receive", 0, byteBuffer.array().length));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onClose(int i, String str, boolean z) {
        b();
        SCLogCatUtil.info("WebSocketClient", String.format("onClose. url is %s ,state: closed ,reason: %s, errCode = %d, remote = %s", this.c, str, Integer.valueOf(i), Boolean.toString(z)));
        if (!this.h && (i == -1 || i == -2 || i == -3)) {
            onError(str);
        } else {
            this.f6898a.onSocketClose();
        }
        this.g.printDisconnMonitorLog();
        this.g.noteTraficConsume(new DataflowMonitorModel(this.c, getBizUniqId(), "close", 0, 0));
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onError(Exception exc) {
        SCLogCatUtil.error("WebSocketClient", String.format("onError. url is %s ,error is %s", this.c, exc.toString()), exc);
        StringBuilder sb = new StringBuilder("exception: ");
        sb.append(exc.getMessage());
        onSocketError(sb.toString());
    }

    public void onError(String str) {
        SCLogCatUtil.error("WebSocketClient", String.format("onError. url is %s ,error is %s", this.c, str));
        onSocketError(str);
    }

    public void onSocketError(String str) {
        this.f6898a.onSocketError(str);
        this.g.printErrorMonitorLog("1", str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient
    public void onFragment(Framedata framedata) {
        Framedata framedata2;
        if (framedata.getOpcode() != Framedata.Opcode.CONTINUOUS && !framedata.isFin()) {
            this.b = framedata;
        } else if (framedata.getOpcode() != Framedata.Opcode.CONTINUOUS || (framedata2 = this.b) == null) {
        } else {
            if (framedata2.getPayloadData().position() > 10485760) {
                SCLogCatUtil.warn("WebSocketClient", "onFragment. Pending frame exploded");
                onError(new RuntimeException(WsMessageConstants.MSG_PENDING_FRAME_EXPLODED));
                close();
                this.b = null;
                return;
            }
            try {
                this.b.append(framedata);
            } catch (Throwable th) {
                SCLogCatUtil.warn("WebSocketClient", "onFragment. append frame err. ", th);
            }
            if (framedata.isFin()) {
                if (this.b.getOpcode() == Framedata.Opcode.BINARY) {
                    onMessage(this.b.getPayloadData());
                } else if (this.b.getOpcode() == Framedata.Opcode.TEXT) {
                    try {
                        String stringUtf8 = Charsetfunctions.stringUtf8(this.b.getPayloadData());
                        if (stringUtf8 == null) {
                            stringUtf8 = "";
                        }
                        onMessage(stringUtf8);
                    } catch (Throwable th2) {
                        SCLogCatUtil.warn("WebSocketClient", "onFragment. ByteBuffer to String err ", th2);
                    }
                }
                this.b = null;
            }
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close() {
        try {
            SCLogCatUtil.info("WebSocketClient", "close. try to close socket");
            this.h = true;
            super.close();
        } catch (Throwable th) {
            SCLogCatUtil.error("WebSocketClient", "send err. ", th);
        }
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient, com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close(int i, String str) {
        try {
            SCLogCatUtil.info("WebSocketClient", "close. try to close socket");
            this.h = true;
            super.close(i, str);
        } catch (Throwable th) {
            SCLogCatUtil.error("WebSocketClient", "send err. ", th);
        }
    }

    private void a() {
        b();
        this.e = SCNetworkAsyncTaskUtil.schedule(new SCConnectionTimerRunnable(this, this.f6898a), this.d, TimeUnit.MILLISECONDS);
    }

    private void b() {
        try {
            SCLogCatUtil.info("WebSocketClient", "cancelTimeoutScheduleFuture. try to stop connectTimer");
            ScheduledFuture<?> scheduledFuture = this.e;
            if (scheduledFuture == null) {
                return;
            }
            scheduledFuture.cancel(true);
            this.e = null;
        } catch (Throwable th) {
            SCLogCatUtil.error("WebSocketClient", "cancelTimeoutScheduleFuture. Cancel old timeoutScheduleFuture error", th);
        }
    }

    public WebSocketContext getWebSocketContext() {
        WebSocketContext webSocketContext = this.f;
        if (webSocketContext != null) {
            return webSocketContext;
        }
        synchronized (this) {
            WebSocketContext webSocketContext2 = this.f;
            if (webSocketContext2 != null) {
                return webSocketContext2;
            }
            BasicWebSocketContext basicWebSocketContext = new BasicWebSocketContext();
            this.f = basicWebSocketContext;
            return basicWebSocketContext;
        }
    }

    public void setWebSocketContext(WebSocketContext webSocketContext) {
        this.f = webSocketContext;
    }

    public WebSocketCallback getWebSocketCallback() {
        return this.f6898a;
    }

    public String getUrl() {
        return this.c;
    }

    public String getBizUniqId() {
        Object attribute = getWebSocketContext().getAttribute(WSContextConstant.BIZ_UNIQUE_ID);
        return (attribute == null || !(attribute instanceof String)) ? "unkown" : String.valueOf(attribute);
    }

    private void c() {
        SCLogCatUtil.info("WebSocketClient", "enter beforeConnect");
        this.g.recordStartConnAllTime();
    }

    private void d() {
        SCLogCatUtil.info("WebSocketClient", "enter afterConnect");
        this.g.recordConnectedTime();
        this.g.printConnMonitorLog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class SCConnectionTimerRunnable implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private DefaultWebSocketClient f6899a;
        public WebSocketCallback webSocketCallback;

        SCConnectionTimerRunnable(DefaultWebSocketClient defaultWebSocketClient, WebSocketCallback webSocketCallback) {
            this.f6899a = defaultWebSocketClient;
            this.webSocketCallback = webSocketCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            SCLogCatUtil.error("SCConnectionTimerRunnable", "connect response time out");
            try {
                DefaultWebSocketClient.this.onError(WsMessageConstants.MSG_CONNECTION_TIME_OUT);
            } catch (Throwable th) {
                SCLogCatUtil.error("SCConnectionTimerRunnable", "onSocketError error", th);
            }
            try {
                this.f6899a.close();
            } catch (Throwable th2) {
                SCLogCatUtil.error("SCConnectionTimerRunnable", "close socket error", th2);
            }
        }
    }
}
