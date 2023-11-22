package com.mixpanel.android.viewcrawler;

import com.mixpanel.android.java_websocket.client.WebSocketClient;
import com.mixpanel.android.java_websocket.drafts.Draft_17;
import com.mixpanel.android.java_websocket.exceptions.NotSendableException;
import com.mixpanel.android.java_websocket.exceptions.WebsocketNotConnectedException;
import com.mixpanel.android.java_websocket.framing.Framedata;
import com.mixpanel.android.util.MPLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class EditorConnection {
    private static final ByteBuffer MyBillsEntityDataFactory = ByteBuffer.allocate(0);
    private final URI BuiltInFictitiousFunctionClassFactory;
    private final Editor KClassImpl$Data$declaredNonStaticMembers$2;
    private final EditorClient getAuthRequestContext;

    /* loaded from: classes.dex */
    public interface Editor {
        void BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject);

        void KClassImpl$Data$declaredNonStaticMembers$2();

        void KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject);

        void MyBillsEntityDataFactory(JSONObject jSONObject);

        void PlaceComponentResult();

        void PlaceComponentResult(JSONObject jSONObject);

        void getAuthRequestContext(JSONObject jSONObject);
    }

    /* loaded from: classes.dex */
    public class EditorConnectionException extends IOException {
        private static final long serialVersionUID = -1884953175346045636L;

        public EditorConnectionException(Throwable th) {
            super(th.getMessage());
        }
    }

    public EditorConnection(URI uri, Editor editor, Socket socket) throws EditorConnectionException {
        this.KClassImpl$Data$declaredNonStaticMembers$2 = editor;
        this.BuiltInFictitiousFunctionClassFactory = uri;
        try {
            EditorClient editorClient = new EditorClient(uri, socket);
            this.getAuthRequestContext = editorClient;
            editorClient.KClassImpl$Data$declaredNonStaticMembers$2();
        } catch (InterruptedException e) {
            throw new EditorConnectionException(e);
        }
    }

    public final boolean BuiltInFictitiousFunctionClassFactory() {
        return (this.getAuthRequestContext.MyBillsEntityDataFactory() || this.getAuthRequestContext.moveToNextValue() || this.getAuthRequestContext.lookAheadTest()) ? false : true;
    }

    public final boolean getAuthRequestContext() {
        return this.getAuthRequestContext.getErrorConfigVersion();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class EditorClient extends WebSocketClient {
        public EditorClient(URI uri, Socket socket) throws InterruptedException {
            super(uri, new Draft_17());
            KClassImpl$Data$declaredNonStaticMembers$2(socket);
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public final void scheduleImpl() {
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.EditorCnctn", "Websocket connected");
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public final void MyBillsEntityDataFactory(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("Received message from editor:\n");
            sb.append(str);
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.EditorCnctn", sb.toString());
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("type");
                if (string.equals("device_info_request")) {
                    EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2();
                } else if (string.equals("snapshot_request")) {
                    EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2(jSONObject);
                } else if (string.equals("change_request")) {
                    EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory(jSONObject);
                } else if (string.equals("event_binding_request")) {
                    EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.MyBillsEntityDataFactory(jSONObject);
                } else if (string.equals("clear_request")) {
                    EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult(jSONObject);
                } else if (string.equals("tweak_request")) {
                    EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(jSONObject);
                }
            } catch (JSONException e) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Bad JSON received:");
                sb2.append(str);
                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.EditorCnctn", sb2.toString(), e);
            }
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public final void PlaceComponentResult(int i, String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("WebSocket closed. Code: ");
            sb.append(i);
            sb.append(", reason: ");
            sb.append(str);
            sb.append("\nURI: ");
            sb.append(EditorConnection.this.BuiltInFictitiousFunctionClassFactory);
            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.EditorCnctn", sb.toString());
            EditorConnection.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult();
        }

        @Override // com.mixpanel.android.java_websocket.client.WebSocketClient
        public final void MyBillsEntityDataFactory(Exception exc) {
            if (exc != null && exc.getMessage() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Websocket Error: ");
                sb.append(exc.getMessage());
                MPLog.getAuthRequestContext("MixpanelAPI.EditorCnctn", sb.toString());
                return;
            }
            MPLog.getAuthRequestContext("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class WebSocketOutputStream extends OutputStream {
        private WebSocketOutputStream() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ WebSocketOutputStream(EditorConnection editorConnection, byte b) {
            this();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws EditorConnectionException {
            write(new byte[]{(byte) i}, 0, 1);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws EditorConnectionException {
            write(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws EditorConnectionException {
            try {
                EditorConnection.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(Framedata.Opcode.TEXT, ByteBuffer.wrap(bArr, i, i2), false);
            } catch (NotSendableException e) {
                throw new EditorConnectionException(e);
            } catch (WebsocketNotConnectedException e2) {
                throw new EditorConnectionException(e2);
            }
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws EditorConnectionException {
            try {
                EditorConnection.this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2(Framedata.Opcode.TEXT, EditorConnection.MyBillsEntityDataFactory, true);
            } catch (NotSendableException e) {
                throw new EditorConnectionException(e);
            } catch (WebsocketNotConnectedException e2) {
                throw new EditorConnectionException(e2);
            }
        }
    }
}
