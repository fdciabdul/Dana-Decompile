package io.opentelemetry.exporter.zipkin;

import j$.util.function.Supplier;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* loaded from: classes6.dex */
class LocalInetAddressSupplier implements Supplier<InetAddress> {
    @Nullable
    private final InetAddress inetAddress;
    private static final Logger logger = Logger.getLogger(LocalInetAddressSupplier.class.getName());
    private static final LocalInetAddressSupplier INSTANCE = new LocalInetAddressSupplier(findLocalIp());

    private LocalInetAddressSupplier(@Nullable InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    @Override // j$.util.function.Supplier
    @Nullable
    public InetAddress get() {
        return this.inetAddress;
    }

    @Nullable
    private static InetAddress findLocalIp() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (nextElement.isSiteLocalAddress()) {
                        return nextElement;
                    }
                }
            }
            return null;
        } catch (Exception e) {
            logger.log(Level.FINE, "error reading nics", (Throwable) e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LocalInetAddressSupplier getInstance() {
        return INSTANCE;
    }
}
