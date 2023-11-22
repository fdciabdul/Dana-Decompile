package com.alibaba.griver.core.webview;

import android.net.http.SslCertificate;
import android.net.http.SslError;

/* loaded from: classes6.dex */
class AndroidSslError extends SslError {

    /* renamed from: a  reason: collision with root package name */
    private SslError f6482a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AndroidSslError(int i, SslCertificate sslCertificate, SslError sslError) {
        super(i, sslCertificate);
        if (sslError == null) {
            this.f6482a = new NullSslError(i, sslCertificate);
        } else {
            this.f6482a = sslError;
        }
    }

    @Override // android.net.http.SslError
    public SslCertificate getCertificate() {
        return this.f6482a.getCertificate();
    }

    @Override // android.net.http.SslError
    public String getUrl() {
        SslError sslError = this.f6482a;
        return sslError != null ? sslError.getUrl() : "";
    }

    @Override // android.net.http.SslError
    public boolean addError(int i) {
        SslError sslError = this.f6482a;
        return sslError != null && sslError.addError(i);
    }

    @Override // android.net.http.SslError
    public boolean hasError(int i) {
        return this.f6482a.hasError(i);
    }

    @Override // android.net.http.SslError
    public int getPrimaryError() {
        return this.f6482a.getPrimaryError();
    }

    /* loaded from: classes6.dex */
    class NullSslError extends SslError {
        @Override // android.net.http.SslError
        public boolean addError(int i) {
            return false;
        }

        @Override // android.net.http.SslError
        public String getUrl() {
            return null;
        }

        @Override // android.net.http.SslError
        public boolean hasError(int i) {
            return false;
        }

        @Override // android.net.http.SslError
        public String toString() {
            return "Null SslError instance";
        }

        public NullSslError(int i, SslCertificate sslCertificate) {
            super(i, sslCertificate);
        }

        @Override // android.net.http.SslError
        public int getPrimaryError() {
            return super.getPrimaryError();
        }
    }
}
