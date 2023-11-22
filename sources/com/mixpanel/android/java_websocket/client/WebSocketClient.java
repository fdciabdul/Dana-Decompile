package com.mixpanel.android.java_websocket.client;

import com.alibaba.ariver.resource.parser.tar.TarHeader;
import com.alibaba.ariver.websocket.WSConstant;
import com.google.common.base.Ascii;
import com.google.common.net.HttpHeaders;
import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.WebSocketAdapter;
import com.mixpanel.android.java_websocket.WebSocketImpl;
import com.mixpanel.android.java_websocket.WebSocketListener;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.ClientHandshakeBuilder;
import com.mixpanel.android.java_websocket.handshake.HandshakeImpl1Client;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes3.dex */
public abstract class WebSocketClient extends WebSocketAdapter implements Runnable, WebSocket {
    private Thread DatabaseTableConfigUtil;
    protected URI KClassImpl$Data$declaredNonStaticMembers$2;
    private InputStream NetworkUserEntityData$$ExternalSyntheticLambda0;
    private int PlaceComponentResult;
    private Draft getAuthRequestContext;
    private Map<String, String> lookAheadTest;
    private WebSocketImpl moveToNextValue;
    private OutputStream scheduleImpl;
    private Socket NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    private Proxy getErrorConfigVersion = Proxy.NO_PROXY;
    private CountDownLatch BuiltInFictitiousFunctionClassFactory = new CountDownLatch(1);
    private CountDownLatch MyBillsEntityDataFactory = new CountDownLatch(1);

    public abstract void MyBillsEntityDataFactory(Exception exc);

    public abstract void MyBillsEntityDataFactory(String str);

    public abstract void PlaceComponentResult(int i, String str);

    public abstract void scheduleImpl();

    public WebSocketClient(URI uri, Draft draft) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        this.moveToNextValue = null;
        this.PlaceComponentResult = 0;
        if (uri == null) {
            throw new IllegalArgumentException();
        }
        this.KClassImpl$Data$declaredNonStaticMembers$2 = uri;
        this.getAuthRequestContext = draft;
        this.lookAheadTest = null;
        this.PlaceComponentResult = 5000;
        this.moveToNextValue = new WebSocketImpl(this, draft);
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        int read;
        try {
            Socket socket = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (socket == null) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new Socket(this.getErrorConfigVersion);
            } else if (socket.isClosed()) {
                throw new IOException();
            }
            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2.isBound()) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda2.connect(new InetSocketAddress(this.KClassImpl$Data$declaredNonStaticMembers$2.getHost(), NetworkUserEntityData$$ExternalSyntheticLambda0()), this.PlaceComponentResult);
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda0 = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getInputStream();
            this.scheduleImpl = this.NetworkUserEntityData$$ExternalSyntheticLambda2.getOutputStream();
            String path = this.KClassImpl$Data$declaredNonStaticMembers$2.getPath();
            String query = this.KClassImpl$Data$declaredNonStaticMembers$2.getQuery();
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
            int NetworkUserEntityData$$ExternalSyntheticLambda0 = NetworkUserEntityData$$ExternalSyntheticLambda0();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getHost());
            if (NetworkUserEntityData$$ExternalSyntheticLambda0 != 80) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(":");
                sb3.append(NetworkUserEntityData$$ExternalSyntheticLambda0);
                str = sb3.toString();
            } else {
                str = "";
            }
            sb2.append(str);
            String obj = sb2.toString();
            HandshakeImpl1Client handshakeImpl1Client = new HandshakeImpl1Client();
            if (path == null) {
                throw new IllegalArgumentException("http resource descriptor must not be null");
            }
            handshakeImpl1Client.PlaceComponentResult = path;
            handshakeImpl1Client.getAuthRequestContext.put(HttpHeaders.HOST, obj);
            Map<String, String> map = this.lookAheadTest;
            if (map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    handshakeImpl1Client.getAuthRequestContext.put(entry.getKey(), entry.getValue());
                }
            }
            WebSocketImpl webSocketImpl = this.moveToNextValue;
            webSocketImpl.lookAheadTest = webSocketImpl.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext((ClientHandshakeBuilder) handshakeImpl1Client);
            webSocketImpl.moveToNextValue = handshakeImpl1Client.getAuthRequestContext();
            try {
                WebSocketListener webSocketListener = webSocketImpl.DatabaseTableConfigUtil;
                ClientHandshake clientHandshake = webSocketImpl.lookAheadTest;
                Draft draft = webSocketImpl.KClassImpl$Data$declaredNonStaticMembers$2;
                ClientHandshake clientHandshake2 = webSocketImpl.lookAheadTest;
                WebSocket.Role role = webSocketImpl.GetContactSyncConfig;
                webSocketImpl.BuiltInFictitiousFunctionClassFactory(Draft.getAuthRequestContext((Handshakedata) clientHandshake2));
                Thread thread = new Thread(new WebsocketWriteThread(this, (byte) 0));
                this.DatabaseTableConfigUtil = thread;
                thread.start();
                byte[] bArr = new byte[WebSocketImpl.MyBillsEntityDataFactory];
                while (!MyBillsEntityDataFactory() && (read = this.NetworkUserEntityData$$ExternalSyntheticLambda0.read(bArr)) != -1) {
                    try {
                        this.moveToNextValue.BuiltInFictitiousFunctionClassFactory(ByteBuffer.wrap(bArr, 0, read));
                    } catch (IOException unused) {
                        this.moveToNextValue.MyBillsEntityDataFactory();
                        return;
                    } catch (RuntimeException e) {
                        MyBillsEntityDataFactory(e);
                        this.moveToNextValue.PlaceComponentResult(1006, e.getMessage());
                        return;
                    }
                }
                this.moveToNextValue.MyBillsEntityDataFactory();
            } catch (InvalidDataException unused2) {
                throw new InvalidHandshakeException("Handshake data rejected by client.");
            } catch (RuntimeException e2) {
                webSocketImpl.DatabaseTableConfigUtil.getAuthRequestContext(e2);
                StringBuilder sb4 = new StringBuilder();
                sb4.append("rejected because of");
                sb4.append(e2);
                throw new InvalidHandshakeException(sb4.toString());
            }
        } catch (Exception e3) {
            MyBillsEntityDataFactory(e3);
            this.moveToNextValue.PlaceComponentResult(-1, e3.getMessage());
        }
    }

    private int NetworkUserEntityData$$ExternalSyntheticLambda0() {
        int port = this.KClassImpl$Data$declaredNonStaticMembers$2.getPort();
        if (port == -1) {
            String scheme = this.KClassImpl$Data$declaredNonStaticMembers$2.getScheme();
            if (scheme.equals(WSConstant.SCHEME_WSS)) {
                return com.alipay.android.phone.mobilesdk.socketcraft.WebSocket.DEFAULT_WSS_PORT;
            }
            if (scheme.equals(WSConstant.SCHEME_WS)) {
                return 80;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("unkonow scheme");
            sb.append(scheme);
            throw new RuntimeException(sb.toString());
        }
        return port;
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void PlaceComponentResult(String str) {
        MyBillsEntityDataFactory(str);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void BuiltInFictitiousFunctionClassFactory(Handshakedata handshakedata) {
        this.BuiltInFictitiousFunctionClassFactory.countDown();
        ServerHandshake serverHandshake = (ServerHandshake) handshakedata;
        scheduleImpl();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void KClassImpl$Data$declaredNonStaticMembers$2(int i, String str) {
        this.BuiltInFictitiousFunctionClassFactory.countDown();
        this.MyBillsEntityDataFactory.countDown();
        Thread thread = this.DatabaseTableConfigUtil;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            Socket socket = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            MyBillsEntityDataFactory(e);
        }
        PlaceComponentResult(i, str);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final void getAuthRequestContext(Exception exc) {
        MyBillsEntityDataFactory(exc);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocketListener
    public final InetSocketAddress getAuthRequestContext() {
        Socket socket = this.NetworkUserEntityData$$ExternalSyntheticLambda2;
        if (socket != null) {
            return (InetSocketAddress) socket.getLocalSocketAddress();
        }
        return null;
    }

    /* loaded from: classes3.dex */
    class WebsocketWriteThread implements Runnable {
        public static final byte[] KClassImpl$Data$declaredNonStaticMembers$2 = {61, 16, -46, 32, -16, 5, 2, 15, -7, -4, 34, -18, -8, 15, 6, -1, 11, -19, Ascii.ETB, TarHeader.LF_DIR, -60, 13, -11, 9, 59, -36, -18, -8, 15, 6, -1};
        public static final int getAuthRequestContext = 176;

        private static void a(short s, byte b, int i, Object[] objArr) {
            int i2 = (i * 7) + 99;
            int i3 = 16 - (b * 3);
            int i4 = 16 - (s * 12);
            byte[] bArr = KClassImpl$Data$declaredNonStaticMembers$2;
            byte[] bArr2 = new byte[i3];
            int i5 = -1;
            int i6 = i3 - 1;
            if (bArr == null) {
                i4++;
                i2 = i6 + (-i2) + 2;
                i6 = i6;
            }
            while (true) {
                i5++;
                bArr2[i5] = (byte) i2;
                if (i5 == i6) {
                    objArr[0] = new String(bArr2, 0);
                    return;
                }
                byte b2 = bArr[i4];
                i4++;
                i2 = i2 + (-b2) + 2;
                i6 = i6;
            }
        }

        private WebsocketWriteThread() {
        }

        /* synthetic */ WebsocketWriteThread(WebSocketClient webSocketClient, byte b) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                byte b = (byte) (KClassImpl$Data$declaredNonStaticMembers$2[15] + 1);
                Object[] objArr = new Object[1];
                a(b, b, (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]), objArr);
                Class<?> cls = Class.forName((String) objArr[0]);
                byte b2 = (byte) (-KClassImpl$Data$declaredNonStaticMembers$2[15]);
                byte b3 = b2;
                Object[] objArr2 = new Object[1];
                a(b2, b3, (byte) (b3 - 1), objArr2);
                ((Thread) cls.getMethod((String) objArr2[0], null).invoke(null, null)).setName("WebsocketWriteThread");
                while (!Thread.interrupted()) {
                    try {
                        ByteBuffer take = WebSocketClient.this.moveToNextValue.NetworkUserEntityData$$ExternalSyntheticLambda0.take();
                        WebSocketClient.this.scheduleImpl.write(take.array(), 0, take.limit());
                        WebSocketClient.this.scheduleImpl.flush();
                    } catch (IOException unused) {
                        WebSocketClient.this.moveToNextValue.MyBillsEntityDataFactory();
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

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Socket socket) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda2 != null) {
            throw new IllegalStateException("socket has already been set");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda2 = socket;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(Framedata.Opcode opcode, ByteBuffer byteBuffer, boolean z) {
        WebSocketImpl webSocketImpl = this.moveToNextValue;
        List<Framedata> authRequestContext = webSocketImpl.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(opcode, byteBuffer, z);
        if (!webSocketImpl.getErrorConfigVersion()) {
            throw new WebsocketNotConnectedException();
        }
        Iterator<Framedata> it = authRequestContext.iterator();
        while (it.hasNext()) {
            webSocketImpl.getAuthRequestContext(it.next());
        }
    }

    public final boolean getErrorConfigVersion() {
        return this.moveToNextValue.getErrorConfigVersion();
    }

    public final boolean lookAheadTest() {
        return this.moveToNextValue.PlaceComponentResult();
    }

    public final boolean MyBillsEntityDataFactory() {
        return this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2();
    }

    public final boolean moveToNextValue() {
        return this.moveToNextValue.getAuthRequestContext();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public final void getAuthRequestContext(Framedata framedata) {
        this.moveToNextValue.getAuthRequestContext(framedata);
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public final InetSocketAddress BuiltInFictitiousFunctionClassFactory() {
        return this.moveToNextValue.DatabaseTableConfigUtil.getAuthRequestContext();
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() throws InterruptedException {
        if (this.DatabaseTableConfigUtil != null) {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        }
        Thread thread = new Thread(this);
        this.DatabaseTableConfigUtil = thread;
        thread.start();
        this.BuiltInFictitiousFunctionClassFactory.await();
        return this.moveToNextValue.getErrorConfigVersion();
    }
}
