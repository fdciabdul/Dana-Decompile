package com.alipay.android.phone.mobilesdk.socketcraft.client;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.ariver.websocket.WSConstant;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocket;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocketAdapter;
import com.alipay.android.phone.mobilesdk.socketcraft.WebSocketImpl;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft;
import com.alipay.android.phone.mobilesdk.socketcraft.drafts.Draft_17;
import com.alipay.android.phone.mobilesdk.socketcraft.framing.Framedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.HandshakeImpl1Client;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.Handshakedata;
import com.alipay.android.phone.mobilesdk.socketcraft.handshake.ServerHandshake;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.logcat.SCLogCatUtil;
import com.alipay.android.phone.mobilesdk.socketcraft.platform.ssl.SSLExtensionsFactory;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes6.dex */
public abstract class WebSocketClient extends WebSocketAdapter implements WebSocket, Runnable {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* renamed from: a */
    private WebSocketImpl f6900a;
    private Socket b;
    private InputStream c;
    private OutputStream d;
    private Proxy e;
    private Thread f;
    private Draft g;
    private Map<String, String> h;
    private CountDownLatch i;
    private CountDownLatch j;
    private int k;
    private SSLSocketFactory l;
    protected URI uri;

    public abstract void onClose(int i, String str, boolean z);

    public void onCloseInitiated(int i, String str) {
    }

    public void onClosing(int i, String str, boolean z) {
    }

    public void onDns(String str, long j) {
    }

    public abstract void onError(Exception exc);

    public void onFragment(Framedata framedata) {
    }

    public abstract void onMessage(String str);

    public void onMessage(ByteBuffer byteBuffer) {
    }

    public abstract void onOpen(ServerHandshake serverHandshake);

    public void onSSLHandshake(long j) {
    }

    public void onTcpConnect(String str, long j) {
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWriteDemand(WebSocket webSocket) {
    }

    public void onWsHandshake(long j) {
    }

    public WebSocketClient(URI uri) {
        this(uri, new Draft_17());
    }

    public WebSocketClient(URI uri, Draft draft) {
        this(uri, draft, null, 0);
    }

    public WebSocketClient(URI uri, Draft draft, Map<String, String> map, int i) {
        this.uri = null;
        this.f6900a = null;
        this.b = null;
        this.e = Proxy.NO_PROXY;
        this.i = new CountDownLatch(1);
        this.j = new CountDownLatch(1);
        this.k = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        if (draft == null) {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        }
        this.uri = uri;
        this.g = draft;
        this.h = map;
        this.k = i;
        this.f6900a = new WebSocketImpl(this, draft);
    }

    public URI getURI() {
        return this.uri;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public Draft getDraft() {
        return this.g;
    }

    public void connect() {
        if (this.f != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.f = thread;
        thread.start();
    }

    public boolean connectBlocking() {
        connect();
        this.i.await();
        return this.f6900a.isOpen();
    }

    public void close() {
        if (this.f != null) {
            this.f6900a.close(1000);
        }
    }

    public void closeBlocking() {
        close();
        this.j.await();
    }

    public void send(String str) {
        this.f6900a.send(str);
    }

    public void send(byte[] bArr) {
        this.f6900a.send(bArr);
    }

    @Override // java.lang.Runnable
    public void run() {
        int read;
        try {
            Socket socket = this.b;
            if (socket == null) {
                this.b = new Socket(this.e);
            } else if (socket.isClosed()) {
                throw new SocketException("Socket is closed");
            }
            if (!this.b.isBound()) {
                a();
            }
            this.c = this.b.getInputStream();
            this.d = this.b.getOutputStream();
            long currentTimeMillis = System.currentTimeMillis();
            try {
                c();
                Thread thread = new Thread(new WebsocketWriteThread());
                this.f = thread;
                thread.start();
                byte[] bArr = new byte[WebSocketImpl.RCVBUF];
                while (!isClosed() && !isClosing() && (read = this.c.read(bArr)) != -1) {
                    try {
                        this.f6900a.decode(ByteBuffer.wrap(bArr, 0, read));
                    } catch (IOException unused) {
                        this.f6900a.eot();
                        return;
                    } catch (RuntimeException e) {
                        onError(e);
                        this.f6900a.closeConnection(1006, e.getMessage());
                        return;
                    }
                }
                this.f6900a.eot();
            } finally {
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                onWsHandshake(currentTimeMillis2);
                StringBuilder sb = new StringBuilder("WebSocketHandshark timing: ");
                sb.append(currentTimeMillis2);
                SCLogCatUtil.info("WebSocketClient", sb.toString());
            }
        } catch (Exception e2) {
            onWebsocketError(this.f6900a, e2);
            this.f6900a.closeConnection(-1, e2.getMessage());
        }
    }

    private void a() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            InetAddress[] allByName = InetAddress.getAllByName(this.uri.getHost());
            if (allByName == null || allByName.length <= 0) {
                StringBuilder sb = new StringBuilder("Unknown host : ");
                sb.append(this.uri.getHost());
                throw new UnknownHostException(sb.toString());
            }
            InetAddress inetAddress = allByName[0];
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            String hostAddress = inetAddress != null ? inetAddress.getHostAddress() : " null ";
            onDns(hostAddress, currentTimeMillis2);
            StringBuilder sb2 = new StringBuilder("DNS timing: ");
            sb2.append(currentTimeMillis2);
            sb2.append(", ip: ");
            sb2.append(hostAddress);
            SCLogCatUtil.info("WebSocketClient", sb2.toString());
            long currentTimeMillis3 = System.currentTimeMillis();
            try {
                this.b.connect(new InetSocketAddress(inetAddress, b()), this.k);
                long currentTimeMillis4 = System.currentTimeMillis() - currentTimeMillis3;
                String hostAddress2 = inetAddress.getHostAddress();
                onTcpConnect(hostAddress2, currentTimeMillis4);
                StringBuilder sb3 = new StringBuilder("Connection timing: ");
                sb3.append(currentTimeMillis4);
                sb3.append(", ip: ");
                sb3.append(hostAddress2);
                SCLogCatUtil.info("WebSocketClient", sb3.toString());
                SSLSocketFactory sSLSocketFactory = this.l;
                if (sSLSocketFactory == null) {
                    return;
                }
                SSLSocket sSLSocket = (SSLSocket) sSLSocketFactory.createSocket(this.b, this.uri.getHost(), b(), true);
                SSLExtensionsFactory.getInstance().enableTlsExtensions(sSLSocket, this.uri.getHost());
                long currentTimeMillis5 = System.currentTimeMillis();
                try {
                    sSLSocket.startHandshake();
                    long currentTimeMillis6 = System.currentTimeMillis() - currentTimeMillis5;
                    onSSLHandshake(currentTimeMillis6);
                    StringBuilder sb4 = new StringBuilder("SSL timing: ");
                    sb4.append(currentTimeMillis6);
                    sb4.append(", ip: ");
                    sb4.append(inetAddress.getHostAddress());
                    SCLogCatUtil.info("WebSocketClient", sb4.toString());
                    this.b = sSLSocket;
                } catch (Throwable th) {
                    long currentTimeMillis7 = System.currentTimeMillis() - currentTimeMillis5;
                    onSSLHandshake(currentTimeMillis7);
                    StringBuilder sb5 = new StringBuilder("SSL timing: ");
                    sb5.append(currentTimeMillis7);
                    sb5.append(", ip: ");
                    sb5.append(inetAddress.getHostAddress());
                    SCLogCatUtil.info("WebSocketClient", sb5.toString());
                    throw th;
                }
            } catch (Throwable th2) {
                long currentTimeMillis8 = System.currentTimeMillis() - currentTimeMillis3;
                String hostAddress3 = inetAddress.getHostAddress();
                onTcpConnect(hostAddress3, currentTimeMillis8);
                StringBuilder sb6 = new StringBuilder("Connection timing: ");
                sb6.append(currentTimeMillis8);
                sb6.append(", ip: ");
                sb6.append(hostAddress3);
                SCLogCatUtil.info("WebSocketClient", sb6.toString());
                throw th2;
            }
        } catch (Throwable th3) {
            long currentTimeMillis9 = System.currentTimeMillis() - currentTimeMillis;
            onDns(" null ", currentTimeMillis9);
            StringBuilder sb7 = new StringBuilder("DNS timing: ");
            sb7.append(currentTimeMillis9);
            sb7.append(", ip: ");
            sb7.append(" null ");
            SCLogCatUtil.info("WebSocketClient", sb7.toString());
            throw th3;
        }
    }

    private int b() {
        int port = this.uri.getPort();
        if (port == -1) {
            String scheme = this.uri.getScheme();
            if (scheme.equals(WSConstant.SCHEME_WSS)) {
                return WebSocket.DEFAULT_WSS_PORT;
            }
            if (scheme.equals(WSConstant.SCHEME_WS)) {
                return 80;
            }
            StringBuilder sb = new StringBuilder("unkonow scheme");
            sb.append(scheme);
            throw new RuntimeException(sb.toString());
        }
        return port;
    }

    private void c() {
        String str;
        String path = this.uri.getPath();
        String query = this.uri.getQuery();
        if (path == null || path.length() == 0) {
            path = "/";
        }
        if (query != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(path);
            sb.append("?");
            sb.append(query);
            path = sb.toString();
        }
        int b = b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.uri.getHost());
        if (b != 80) {
            StringBuilder sb3 = new StringBuilder(":");
            sb3.append(b);
            str = sb3.toString();
        } else {
            str = "";
        }
        sb2.append(str);
        String obj = sb2.toString();
        HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
        handshakeImpl1Client.setResourceDescriptor(path);
        handshakeImpl1Client.put(HttpHeaders.HOST, obj);
        Map<String, String> map = this.h;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                handshakeImpl1Client.put(entry.getKey(), entry.getValue());
            }
        }
        this.f6900a.startHandshake(handshakeImpl1Client);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public WebSocket.READYSTATE getReadyState() {
        return this.f6900a.getReadyState();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, String str) {
        onMessage(str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketMessage(WebSocket webSocket, ByteBuffer byteBuffer) {
        onMessage(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketAdapter, com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketMessageFragment(WebSocket webSocket, Framedata framedata) {
        onFragment(framedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketOpen(WebSocket webSocket, Handshakedata handshakedata) {
        this.i.countDown();
        onOpen((ServerHandshake) handshakedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketClose(WebSocket webSocket, int i, String str, boolean z) {
        this.i.countDown();
        this.j.countDown();
        Thread thread = this.f;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.b;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            onWebsocketError(this, e);
        }
        onClose(i, str, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public final void onWebsocketError(WebSocket webSocket, Exception exc) {
        onError(exc);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketCloseInitiated(WebSocket webSocket, int i, String str) {
        onCloseInitiated(i, str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public void onWebsocketClosing(WebSocket webSocket, int i, String str, boolean z) {
        onClosing(i, str, z);
    }

    public WebSocket getConnection() {
        return this.f6900a;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public InetSocketAddress getLocalSocketAddress(WebSocket webSocket) {
        Socket socket = this.b;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocketListener
    public InetSocketAddress getRemoteSocketAddress(WebSocket webSocket) {
        Socket socket = this.b;
        if (socket != null) {
            return (InetSocketAddress) socket.getRemoteSocketAddress();
        }
        return null;
    }

    /* loaded from: classes6.dex */
    class WebsocketWriteThread implements Runnable {
        public static final byte[] PlaceComponentResult = {75, -120, 119, 39, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int KClassImpl$Data$declaredNonStaticMembers$2 = 103;

        /* JADX WARN: Removed duplicated region for block: B:20:0x0025  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x002d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x002d -> B:23:0x003a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static void a(short r6, int r7, int r8, java.lang.Object[] r9) {
            /*
                byte[] r0 = com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient.WebsocketWriteThread.PlaceComponentResult
                int r8 = r8 * 7
                int r8 = 106 - r8
                int r6 = r6 * 3
                int r6 = r6 + 13
                int r7 = r7 * 12
                int r7 = 15 - r7
                byte[] r1 = new byte[r6]
                int r6 = r6 + (-1)
                r2 = 0
                if (r0 != 0) goto L1d
                r3 = r1
                r4 = 0
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                goto L3a
            L1d:
                r3 = 0
            L1e:
                byte r4 = (byte) r8
                r1[r3] = r4
                int r7 = r7 + 1
                if (r3 != r6) goto L2d
                java.lang.String r6 = new java.lang.String
                r6.<init>(r1, r2)
                r9[r2] = r6
                return
            L2d:
                int r3 = r3 + 1
                r4 = r0[r7]
                r5 = r7
                r7 = r6
                r6 = r4
                r4 = r3
                r3 = r1
                r1 = r0
                r0 = r9
                r9 = r8
                r8 = r5
            L3a:
                int r6 = -r6
                int r9 = r9 + r6
                int r6 = r9 + 2
                r9 = r0
                r0 = r1
                r1 = r3
                r3 = r4
                r5 = r8
                r8 = r6
                r6 = r7
                r7 = r5
                goto L1e
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.android.phone.mobilesdk.socketcraft.client.WebSocketClient.WebsocketWriteThread.a(short, int, int, java.lang.Object[]):void");
        }

        private WebsocketWriteThread() {
            WebSocketClient.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte b = (byte) (-PlaceComponentResult[15]);
                byte b2 = (byte) (b - 1);
                Object[] objArr = new Object[1];
                a(b, b2, b2, objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b3 = (byte) (PlaceComponentResult[15] + 1);
                byte b4 = (byte) (-PlaceComponentResult[15]);
                Object[] objArr2 = new Object[1];
                a(b3, b4, b4, objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).setName("WebsocketWriteThread");
                while (!Thread.interrupted()) {
                    try {
                        ByteBuffer take = WebSocketClient.this.f6900a.outQueue.take();
                        WebSocketClient.this.d.write(take.array(), 0, take.limit());
                        WebSocketClient.this.d.flush();
                    } catch (IOException unused) {
                        WebSocketClient.this.f6900a.eot();
                        return;
                    } catch (InterruptedException unused2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                Throwable cause = th.getCause();
                if (cause == null) {
                    throw th;
                }
                throw cause;
            }
        }
    }

    public void setProxy(Proxy proxy) {
        if (proxy == null) {
            throw new IllegalArgumentException();
        }
        this.e = proxy;
    }

    public void setSocket(Socket socket) {
        if (this.b != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.b = socket;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.l = sSLSocketFactory;
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void sendFragmentedFrame(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        this.f6900a.sendFragmentedFrame(opcode, byteBuffer, z);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isOpen() {
        return this.f6900a.isOpen();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isFlushAndClose() {
        return this.f6900a.isFlushAndClose();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isClosed() {
        return this.f6900a.isClosed();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isClosing() {
        return this.f6900a.isClosing();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean isConnecting() {
        return this.f6900a.isConnecting();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public boolean hasBufferedData() {
        return this.f6900a.hasBufferedData();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void close(int i) {
        this.f6900a.close();
    }

    public void close(int i, String str) {
        this.f6900a.close(i, str);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void closeConnection(int i, String str) {
        this.f6900a.closeConnection(i, str);
    }

    public void send(ByteBuffer byteBuffer) {
        this.f6900a.send(byteBuffer);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public void sendFrame(Framedata framedata) {
        this.f6900a.sendFrame(framedata);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress getLocalSocketAddress() {
        return this.f6900a.getLocalSocketAddress();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public InetSocketAddress getRemoteSocketAddress() {
        return this.f6900a.getRemoteSocketAddress();
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.WebSocket
    public String getResourceDescriptor() {
        return this.uri.getPath();
    }
}
