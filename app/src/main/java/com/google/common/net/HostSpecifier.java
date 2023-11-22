package com.google.common.net;

import com.google.common.base.Preconditions;
import java.net.InetAddress;
import java.text.ParseException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes7.dex */
public final class HostSpecifier {
    private final String canonicalForm;

    private HostSpecifier(String str) {
        this.canonicalForm = str;
    }

    public static HostSpecifier fromValid(String str) {
        InetAddress inetAddress;
        HostAndPort fromString = HostAndPort.fromString(str);
        Preconditions.checkArgument(!fromString.hasPort());
        String host = fromString.getHost();
        try {
            inetAddress = InetAddresses.forString(host);
        } catch (IllegalArgumentException unused) {
            inetAddress = null;
        }
        if (inetAddress != null) {
            return new HostSpecifier(InetAddresses.toUriString(inetAddress));
        }
        InternetDomainName from = InternetDomainName.from(host);
        if (from.hasPublicSuffix()) {
            return new HostSpecifier(from.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Domain name does not have a recognized public suffix: ");
        sb.append(host);
        throw new IllegalArgumentException(sb.toString());
    }

    public static HostSpecifier from(String str) throws ParseException {
        try {
            return fromValid(str);
        } catch (IllegalArgumentException e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Invalid host specifier: ");
            sb.append(str);
            ParseException parseException = new ParseException(sb.toString(), 0);
            parseException.initCause(e);
            throw parseException;
        }
    }

    public static boolean isValid(String str) {
        try {
            fromValid(str);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HostSpecifier) {
            return this.canonicalForm.equals(((HostSpecifier) obj).canonicalForm);
        }
        return false;
    }

    public final int hashCode() {
        return this.canonicalForm.hashCode();
    }

    public final String toString() {
        return this.canonicalForm;
    }
}
