package com.mixpanel.android.java_websocket;

import com.mixpanel.android.java_websocket.WebSocket;
import com.mixpanel.android.java_websocket.drafts.Draft;
import com.mixpanel.android.java_websocket.drafts.Draft_10;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.drafts.Draft_75;
import com.mixpanel.android.java_websocket.drafts.Draft_76;
import com.mixpanel.android.java_websocket.exceptions.IncompleteHandshakeException;
import com.mixpanel.android.java_websocket.exceptions.InvalidDataException;
import com.mixpanel.android.java_websocket.exceptions.InvalidHandshakeException;
import com.mixpanel.android.java_websocket.framing.CloseFrame;
import com.mixpanel.android.java_websocket.framing.CloseFrameBuilder;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.java_websocket.handshake.ClientHandshake;
import com.mixpanel.android.java_websocket.handshake.Handshakedata;
import com.mixpanel.android.java_websocket.handshake.ServerHandshake;
import com.mixpanel.android.java_websocket.util.Charsetfunctions;
import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes3.dex */
public class WebSocketImpl implements WebSocket {
    public static final List<Draft> BuiltInFictitiousFunctionClassFactory;
    public static int MyBillsEntityDataFactory = 16384;
    public static boolean PlaceComponentResult = false;
    public final WebSocketListener DatabaseTableConfigUtil;
    public WebSocket.Role GetContactSyncConfig;
    public Draft KClassImpl$Data$declaredNonStaticMembers$2;
    public final BlockingQueue<ByteBuffer> NetworkUserEntityData$$ExternalSyntheticLambda0;
    private List<Draft> PrepareContext;
    public ByteChannel getAuthRequestContext;
    public SelectionKey getErrorConfigVersion;
    public final BlockingQueue<ByteBuffer> scheduleImpl;
    private volatile boolean newProxyInstance = false;
    private WebSocket.READYSTATE NetworkUserEntityData$$ExternalSyntheticLambda8 = WebSocket.READYSTATE.NOT_YET_CONNECTED;
    private Framedata.Opcode NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
    private ByteBuffer isLayoutRequested = ByteBuffer.allocate(0);
    public ClientHandshake lookAheadTest = null;
    private String NetworkUserEntityData$$ExternalSyntheticLambda1 = null;
    private Integer NetworkUserEntityData$$ExternalSyntheticLambda2 = null;
    private Boolean initRecordTimeStamp = null;
    public String moveToNextValue = null;

    static {
        ArrayList arrayList = new ArrayList(4);
        BuiltInFictitiousFunctionClassFactory = arrayList;
        arrayList.add(new Draft_17());
        arrayList.add(new Draft_10());
        arrayList.add(new Draft_76());
        arrayList.add(new Draft_75());
    }

    public WebSocketImpl(WebSocketListener webSocketListener, Draft draft) {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = null;
        if (draft == null && this.GetContactSyncConfig == WebSocket.Role.SERVER) {
            throw new IllegalArgumentException("parameters must not be null");
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new LinkedBlockingQueue();
        this.scheduleImpl = new LinkedBlockingQueue();
        this.DatabaseTableConfigUtil = webSocketListener;
        this.GetContactSyncConfig = WebSocket.Role.CLIENT;
        if (draft != null) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = draft.getAuthRequestContext();
        }
    }

    public final void BuiltInFictitiousFunctionClassFactory(ByteBuffer byteBuffer) {
        if (PlaceComponentResult) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("process(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array(), byteBuffer.position(), byteBuffer.remaining()));
            sb.append("}");
            printStream.println(sb.toString());
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            MyBillsEntityDataFactory(byteBuffer);
        } else if (KClassImpl$Data$declaredNonStaticMembers$2(byteBuffer)) {
            if (byteBuffer.hasRemaining()) {
                MyBillsEntityDataFactory(byteBuffer);
            } else if (this.isLayoutRequested.hasRemaining()) {
                MyBillsEntityDataFactory(this.isLayoutRequested);
            }
        }
    }

    private boolean KClassImpl$Data$declaredNonStaticMembers$2(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        Handshakedata KClassImpl$Data$declaredNonStaticMembers$2;
        Draft.HandshakeState handshakeState;
        if (this.isLayoutRequested.capacity() == 0) {
            byteBuffer2 = byteBuffer;
        } else {
            if (this.isLayoutRequested.remaining() < byteBuffer.remaining()) {
                ByteBuffer allocate = ByteBuffer.allocate(this.isLayoutRequested.capacity() + byteBuffer.remaining());
                this.isLayoutRequested.flip();
                allocate.put(this.isLayoutRequested);
                this.isLayoutRequested = allocate;
            }
            this.isLayoutRequested.put(byteBuffer);
            this.isLayoutRequested.flip();
            byteBuffer2 = this.isLayoutRequested;
        }
        byteBuffer2.mark();
        try {
            if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                byteBuffer2.mark();
                if (byteBuffer2.limit() > Draft.getAuthRequestContext.length) {
                    handshakeState = Draft.HandshakeState.NOT_MATCHED;
                } else if (byteBuffer2.limit() < Draft.getAuthRequestContext.length) {
                    throw new IncompleteHandshakeException(Draft.getAuthRequestContext.length);
                } else {
                    int i = 0;
                    while (true) {
                        if (byteBuffer2.hasRemaining()) {
                            if (Draft.getAuthRequestContext[i] != byteBuffer2.get()) {
                                byteBuffer2.reset();
                                handshakeState = Draft.HandshakeState.NOT_MATCHED;
                                break;
                            }
                            i++;
                        } else {
                            handshakeState = Draft.HandshakeState.MATCHED;
                            break;
                        }
                    }
                }
                if (handshakeState == Draft.HandshakeState.MATCHED) {
                    try {
                        PlaceComponentResult(ByteBuffer.wrap(Charsetfunctions.PlaceComponentResult(this.DatabaseTableConfigUtil.getAuthRequestContext(this))));
                        getAuthRequestContext(-3, "");
                    } catch (InvalidDataException unused) {
                        getAuthRequestContext(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
                    }
                    return false;
                }
            }
            try {
            } catch (InvalidHandshakeException e) {
                getAuthRequestContext(e.getCloseCode(), e.getMessage(), false);
            }
        } catch (IncompleteHandshakeException e2) {
            if (this.isLayoutRequested.capacity() == 0) {
                byteBuffer2.reset();
                int preferedSize = e2.getPreferedSize();
                if (preferedSize == 0) {
                    preferedSize = byteBuffer2.capacity() + 16;
                }
                ByteBuffer allocate2 = ByteBuffer.allocate(preferedSize);
                this.isLayoutRequested = allocate2;
                allocate2.put(byteBuffer);
            } else {
                ByteBuffer byteBuffer3 = this.isLayoutRequested;
                byteBuffer3.position(byteBuffer3.limit());
                ByteBuffer byteBuffer4 = this.isLayoutRequested;
                byteBuffer4.limit(byteBuffer4.capacity());
            }
        }
        if (this.GetContactSyncConfig == WebSocket.Role.SERVER) {
            Draft draft = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (draft == null) {
                Iterator<Draft> it = this.PrepareContext.iterator();
                while (it.hasNext()) {
                    Draft authRequestContext = it.next().getAuthRequestContext();
                    try {
                        authRequestContext.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig);
                        byteBuffer2.reset();
                        KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(byteBuffer2);
                    } catch (InvalidHandshakeException unused2) {
                    }
                    if (!(KClassImpl$Data$declaredNonStaticMembers$2 instanceof ClientHandshake)) {
                        PlaceComponentResult(1002, "wrong http function", false);
                        return false;
                    }
                    ClientHandshake clientHandshake = (ClientHandshake) KClassImpl$Data$declaredNonStaticMembers$2;
                    if (authRequestContext.getAuthRequestContext(clientHandshake) == Draft.HandshakeState.MATCHED) {
                        this.moveToNextValue = clientHandshake.getAuthRequestContext();
                        try {
                            BuiltInFictitiousFunctionClassFactory(Draft.getAuthRequestContext(authRequestContext.getAuthRequestContext(clientHandshake, this.DatabaseTableConfigUtil.PlaceComponentResult())));
                            this.KClassImpl$Data$declaredNonStaticMembers$2 = authRequestContext;
                            getAuthRequestContext(clientHandshake);
                            return true;
                        } catch (InvalidDataException e3) {
                            PlaceComponentResult(e3.getCloseCode(), e3.getMessage(), false);
                            return false;
                        } catch (RuntimeException e4) {
                            this.DatabaseTableConfigUtil.getAuthRequestContext(e4);
                            PlaceComponentResult(-1, e4.getMessage(), false);
                            return false;
                        }
                    }
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    getAuthRequestContext(1002, "no draft matches");
                }
                return false;
            }
            Handshakedata KClassImpl$Data$declaredNonStaticMembers$22 = draft.KClassImpl$Data$declaredNonStaticMembers$2(byteBuffer2);
            if (!(KClassImpl$Data$declaredNonStaticMembers$22 instanceof ClientHandshake)) {
                PlaceComponentResult(1002, "wrong http function", false);
                return false;
            }
            ClientHandshake clientHandshake2 = (ClientHandshake) KClassImpl$Data$declaredNonStaticMembers$22;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(clientHandshake2) == Draft.HandshakeState.MATCHED) {
                getAuthRequestContext(clientHandshake2);
                return true;
            }
            getAuthRequestContext(1002, "the handshake did finaly not match");
            return false;
        }
        if (this.GetContactSyncConfig == WebSocket.Role.CLIENT) {
            this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.GetContactSyncConfig);
            Handshakedata KClassImpl$Data$declaredNonStaticMembers$23 = this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(byteBuffer2);
            if (!(KClassImpl$Data$declaredNonStaticMembers$23 instanceof ServerHandshake)) {
                PlaceComponentResult(1002, "wrong http function", false);
                return false;
            }
            ServerHandshake serverHandshake = (ServerHandshake) KClassImpl$Data$declaredNonStaticMembers$23;
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(this.lookAheadTest, serverHandshake) == Draft.HandshakeState.MATCHED) {
                getAuthRequestContext(serverHandshake);
                return true;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("draft ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append(" refuses handshake");
            getAuthRequestContext(1002, sb.toString());
        }
        return false;
    }

    private void MyBillsEntityDataFactory(ByteBuffer byteBuffer) {
        String str;
        try {
        } catch (InvalidDataException e) {
            this.DatabaseTableConfigUtil.getAuthRequestContext(e);
            getAuthRequestContext(e.getCloseCode(), e.getMessage(), false);
            return;
        }
        for (Framedata framedata : this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(byteBuffer)) {
            if (PlaceComponentResult) {
                PrintStream printStream = System.out;
                StringBuilder sb = new StringBuilder();
                sb.append("matched frame: ");
                sb.append(framedata);
                printStream.println(sb.toString());
            }
            Framedata.Opcode PlaceComponentResult2 = framedata.PlaceComponentResult();
            boolean moveToNextValue = framedata.moveToNextValue();
            if (PlaceComponentResult2 == Framedata.Opcode.CLOSING) {
                int i = 1005;
                if (framedata instanceof CloseFrame) {
                    CloseFrame closeFrame = (CloseFrame) framedata;
                    i = closeFrame.KClassImpl$Data$declaredNonStaticMembers$2();
                    str = closeFrame.MyBillsEntityDataFactory();
                } else {
                    str = "";
                }
                if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.CLOSING) {
                    PlaceComponentResult(i, str);
                } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() == Draft.CloseHandshakeType.TWOWAY) {
                    getAuthRequestContext(i, str, true);
                } else {
                    PlaceComponentResult(i, str, false);
                }
            } else if (PlaceComponentResult2 == Framedata.Opcode.PING) {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(this, framedata);
            } else if (PlaceComponentResult2 != Framedata.Opcode.PONG) {
                if (moveToNextValue && PlaceComponentResult2 != Framedata.Opcode.CONTINUOUS) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                        throw new InvalidDataException(1002, "Continuous frame sequence not completed.");
                    }
                    if (PlaceComponentResult2 == Framedata.Opcode.TEXT) {
                        try {
                            this.DatabaseTableConfigUtil.PlaceComponentResult(Charsetfunctions.PlaceComponentResult(framedata.BuiltInFictitiousFunctionClassFactory()));
                        } catch (RuntimeException e2) {
                            this.DatabaseTableConfigUtil.getAuthRequestContext(e2);
                        }
                    } else if (PlaceComponentResult2 == Framedata.Opcode.BINARY) {
                        try {
                            framedata.BuiltInFictitiousFunctionClassFactory();
                        } catch (RuntimeException e3) {
                            this.DatabaseTableConfigUtil.getAuthRequestContext(e3);
                        }
                    } else {
                        throw new InvalidDataException(1002, "non control or continious frame expected");
                    }
                    this.DatabaseTableConfigUtil.getAuthRequestContext(e);
                    getAuthRequestContext(e.getCloseCode(), e.getMessage(), false);
                    return;
                }
                if (PlaceComponentResult2 != Framedata.Opcode.CONTINUOUS) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 != null) {
                        throw new InvalidDataException(1002, "Previous continuous frame sequence not completed.");
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = PlaceComponentResult2;
                } else if (moveToNextValue) {
                    if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                        throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                    }
                    this.NetworkUserEntityData$$ExternalSyntheticLambda7 = null;
                } else if (this.NetworkUserEntityData$$ExternalSyntheticLambda7 == null) {
                    throw new InvalidDataException(1002, "Continuous frame sequence was not started.");
                }
            }
        }
    }

    private void getAuthRequestContext(int i, String str, boolean z) {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.CLOSING || this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.CLOSED) {
            return;
        }
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.OPEN) {
            if (i == 1006) {
                this.NetworkUserEntityData$$ExternalSyntheticLambda8 = WebSocket.READYSTATE.CLOSING;
                PlaceComponentResult(i, str, false);
                return;
            }
            if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() != Draft.CloseHandshakeType.NONE) {
                try {
                    getAuthRequestContext(new CloseFrameBuilder(i, str));
                } catch (InvalidDataException e) {
                    this.DatabaseTableConfigUtil.getAuthRequestContext(e);
                    PlaceComponentResult(1006, "generated frame is invalid", false);
                }
            }
            PlaceComponentResult(i, str, z);
        } else if (i == -3) {
            PlaceComponentResult(-3, str, true);
        } else {
            PlaceComponentResult(-1, str, false);
        }
        if (i == 1002) {
            PlaceComponentResult(i, str, z);
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = WebSocket.READYSTATE.CLOSING;
        this.isLayoutRequested = null;
    }

    private void getAuthRequestContext(int i, String str) {
        getAuthRequestContext(i, str, false);
    }

    public final void PlaceComponentResult(int i, String str) {
        synchronized (this) {
            if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.CLOSED) {
                return;
            }
            SelectionKey selectionKey = this.getErrorConfigVersion;
            if (selectionKey != null) {
                selectionKey.cancel();
            }
            ByteChannel byteChannel = this.getAuthRequestContext;
            if (byteChannel != null) {
                try {
                    byteChannel.close();
                } catch (IOException e) {
                    this.DatabaseTableConfigUtil.getAuthRequestContext(e);
                }
            }
            try {
                this.DatabaseTableConfigUtil.KClassImpl$Data$declaredNonStaticMembers$2(i, str);
            } catch (RuntimeException e2) {
                this.DatabaseTableConfigUtil.getAuthRequestContext(e2);
            }
            Draft draft = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (draft != null) {
                draft.BuiltInFictitiousFunctionClassFactory();
            }
            this.lookAheadTest = null;
            this.NetworkUserEntityData$$ExternalSyntheticLambda8 = WebSocket.READYSTATE.CLOSED;
            this.NetworkUserEntityData$$ExternalSyntheticLambda0.clear();
        }
    }

    private void PlaceComponentResult(int i, String str, boolean z) {
        synchronized (this) {
            if (this.newProxyInstance) {
                return;
            }
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = Integer.valueOf(i);
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = str;
            this.initRecordTimeStamp = Boolean.valueOf(z);
            this.newProxyInstance = true;
            Draft draft = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (draft != null) {
                draft.BuiltInFictitiousFunctionClassFactory();
            }
            this.lookAheadTest = null;
        }
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public final void getAuthRequestContext(Framedata framedata) {
        if (PlaceComponentResult) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("send frame: ");
            sb.append(framedata);
            printStream.println(sb.toString());
        }
        PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(framedata));
    }

    private void PlaceComponentResult(ByteBuffer byteBuffer) {
        if (PlaceComponentResult) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("write(");
            sb.append(byteBuffer.remaining());
            sb.append("): {");
            sb.append(byteBuffer.remaining() > 1000 ? "too big to display" : new String(byteBuffer.array()));
            sb.append("}");
            printStream.println(sb.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda0.add(byteBuffer);
    }

    public final void BuiltInFictitiousFunctionClassFactory(List<ByteBuffer> list) {
        Iterator<ByteBuffer> it = list.iterator();
        while (it.hasNext()) {
            PlaceComponentResult(it.next());
        }
    }

    private void getAuthRequestContext(Handshakedata handshakedata) {
        if (PlaceComponentResult) {
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("open using draft: ");
            sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.getClass().getSimpleName());
            printStream.println(sb.toString());
        }
        this.NetworkUserEntityData$$ExternalSyntheticLambda8 = WebSocket.READYSTATE.OPEN;
        try {
            this.DatabaseTableConfigUtil.BuiltInFictitiousFunctionClassFactory(handshakedata);
        } catch (RuntimeException e) {
            this.DatabaseTableConfigUtil.getAuthRequestContext(e);
        }
    }

    public final boolean getErrorConfigVersion() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.OPEN;
    }

    public final boolean getAuthRequestContext() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.CLOSING;
    }

    public final boolean PlaceComponentResult() {
        return this.newProxyInstance;
    }

    public final boolean KClassImpl$Data$declaredNonStaticMembers$2() {
        return this.NetworkUserEntityData$$ExternalSyntheticLambda8 == WebSocket.READYSTATE.CLOSED;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.mixpanel.android.java_websocket.WebSocket
    public final InetSocketAddress BuiltInFictitiousFunctionClassFactory() {
        return this.DatabaseTableConfigUtil.getAuthRequestContext();
    }

    public final void MyBillsEntityDataFactory() {
        if (this.NetworkUserEntityData$$ExternalSyntheticLambda8 != WebSocket.READYSTATE.NOT_YET_CONNECTED) {
            if (this.newProxyInstance) {
                PlaceComponentResult(this.NetworkUserEntityData$$ExternalSyntheticLambda2.intValue(), this.NetworkUserEntityData$$ExternalSyntheticLambda1);
                return;
            } else if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() != Draft.CloseHandshakeType.NONE) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2() == Draft.CloseHandshakeType.ONEWAY && this.GetContactSyncConfig != WebSocket.Role.SERVER) {
                    PlaceComponentResult(1000, "");
                    return;
                } else {
                    PlaceComponentResult(1006, "");
                    return;
                }
            } else {
                PlaceComponentResult(1000, "");
                return;
            }
        }
        PlaceComponentResult(-1, "");
    }
}
