package com.iap.ac.config.lite.a;

import com.iap.ac.android.common.log.ACLog;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.security.SecureRandom;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a  reason: collision with root package name */
    private static final String f7622a = com.iap.ac.config.lite.d.e.b("NioUdpClient");
    private static final SecureRandom b = new SecureRandom();
    private static Selector c;

    private static byte[] a(String str, int i) throws Exception {
        Iterator<SelectionKey> it = c.selectedKeys().iterator();
        while (it.hasNext()) {
            SelectionKey next = it.next();
            it.remove();
            String str2 = (String) next.attachment();
            if (str != null && str.equals(str2)) {
                return a(next, i);
            }
        }
        return null;
    }

    private static byte[] a(SelectionKey selectionKey, int i) throws Exception {
        if (selectionKey.isReadable()) {
            DatagramChannel datagramChannel = (DatagramChannel) selectionKey.channel();
            ByteBuffer allocate = ByteBuffer.allocate(i);
            int read = datagramChannel.read(allocate);
            if (read > 0) {
                allocate.flip();
                byte[] bArr = new byte[read];
                System.arraycopy(allocate.array(), 0, bArr, 0, read);
                try {
                    datagramChannel.disconnect();
                    datagramChannel.close();
                } catch (IOException unused) {
                }
                return bArr;
            }
            throw new EOFException();
        }
        throw new EOFException("channel not readable");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] a(InetSocketAddress inetSocketAddress, byte[] bArr, long j) throws Exception {
        c = Selector.open();
        DatagramChannel open = DatagramChannel.open();
        try {
            try {
                byte[] a2 = a(inetSocketAddress, bArr, j, open);
                try {
                    open.disconnect();
                    open.close();
                    c.wakeup();
                    c.close();
                } catch (IOException e) {
                    String str = f7622a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("sendRecvSync IOException: ");
                    sb.append(e);
                    ACLog.e(str, sb.toString());
                }
                return a2;
            } catch (Throwable th) {
                try {
                    open.disconnect();
                    open.close();
                    c.wakeup();
                    c.close();
                } catch (IOException e2) {
                    String str2 = f7622a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("sendRecvSync IOException: ");
                    sb2.append(e2);
                    ACLog.e(str2, sb2.toString());
                }
                throw th;
            }
        } catch (Exception e3) {
            String str3 = f7622a;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("sendRecvSync: ");
            sb3.append(e3);
            ACLog.e(str3, sb3.toString());
            throw e3;
        }
    }

    private static byte[] a(InetSocketAddress inetSocketAddress, byte[] bArr, long j, DatagramChannel datagramChannel) throws Exception {
        boolean z = false;
        datagramChannel.configureBlocking(false);
        int i = 0;
        while (true) {
            if (i >= 1024) {
                break;
            }
            try {
                datagramChannel.socket().bind(new InetSocketAddress(b.nextInt(28231) + 32768));
                z = true;
                break;
            } catch (SocketException unused) {
                i++;
            }
        }
        if (z) {
            datagramChannel.connect(inetSocketAddress);
            long currentTimeMillis = System.currentTimeMillis();
            String obj = UUID.randomUUID().toString();
            datagramChannel.register(c, 1, obj);
            if (datagramChannel.send(ByteBuffer.wrap(bArr), datagramChannel.socket().getRemoteSocketAddress()) > 0) {
                if (c.select(1000L) >= 0) {
                    if (System.currentTimeMillis() - (currentTimeMillis + j) <= 0) {
                        return a(obj, 512);
                    }
                    throw new SocketTimeoutException("Query timed out");
                }
                throw new IOException("not complete nio udp request");
            }
            throw new EOFException();
        }
        throw new IOException("No available source port found");
    }
}
