package com.google.firebase.perf.network;

import com.google.firebase.perf.metrics.NetworkRequestMetricBuilder;
import com.google.firebase.perf.util.Timer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.security.Permission;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class InstrHttpURLConnection extends HttpURLConnection {
    private final InstrURLConnectionBase delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public InstrHttpURLConnection(HttpURLConnection httpURLConnection, Timer timer, NetworkRequestMetricBuilder networkRequestMetricBuilder) {
        super(httpURLConnection.getURL());
        this.delegate = new InstrURLConnectionBase(httpURLConnection, timer, networkRequestMetricBuilder);
    }

    @Override // java.net.URLConnection
    public final void connect() throws IOException {
        this.delegate.connect();
    }

    @Override // java.net.HttpURLConnection
    public final void disconnect() {
        this.delegate.disconnect();
    }

    @Override // java.net.URLConnection
    public final Object getContent() throws IOException {
        return this.delegate.getContent();
    }

    @Override // java.net.URLConnection
    public final Object getContent(Class[] clsArr) throws IOException {
        return this.delegate.getContent(clsArr);
    }

    @Override // java.net.URLConnection
    public final InputStream getInputStream() throws IOException {
        return this.delegate.getInputStream();
    }

    @Override // java.net.URLConnection
    public final long getLastModified() {
        return this.delegate.getLastModified();
    }

    @Override // java.net.URLConnection
    public final OutputStream getOutputStream() throws IOException {
        return this.delegate.getOutputStream();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final Permission getPermission() throws IOException {
        return this.delegate.getPermission();
    }

    @Override // java.net.HttpURLConnection
    public final int getResponseCode() throws IOException {
        return this.delegate.getResponseCode();
    }

    @Override // java.net.HttpURLConnection
    public final String getResponseMessage() throws IOException {
        return this.delegate.getResponseMessage();
    }

    @Override // java.net.URLConnection
    public final long getExpiration() {
        return this.delegate.getExpiration();
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderField(int i) {
        return this.delegate.getHeaderField(i);
    }

    @Override // java.net.URLConnection
    public final String getHeaderField(String str) {
        return this.delegate.getHeaderField(str);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final long getHeaderFieldDate(String str, long j) {
        return this.delegate.getHeaderFieldDate(str, j);
    }

    @Override // java.net.URLConnection
    public final int getHeaderFieldInt(String str, int i) {
        return this.delegate.getHeaderFieldInt(str, i);
    }

    @Override // java.net.URLConnection
    public final long getHeaderFieldLong(String str, long j) {
        return this.delegate.getHeaderFieldLong(str, j);
    }

    @Override // java.net.HttpURLConnection, java.net.URLConnection
    public final String getHeaderFieldKey(int i) {
        return this.delegate.getHeaderFieldKey(i);
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getHeaderFields() {
        return this.delegate.getHeaderFields();
    }

    @Override // java.net.URLConnection
    public final String getContentEncoding() {
        return this.delegate.getContentEncoding();
    }

    @Override // java.net.URLConnection
    public final int getContentLength() {
        return this.delegate.getContentLength();
    }

    @Override // java.net.URLConnection
    public final long getContentLengthLong() {
        return this.delegate.getContentLengthLong();
    }

    @Override // java.net.URLConnection
    public final String getContentType() {
        return this.delegate.getContentType();
    }

    @Override // java.net.URLConnection
    public final long getDate() {
        return this.delegate.getDate();
    }

    @Override // java.net.URLConnection
    public final void addRequestProperty(String str, String str2) {
        this.delegate.addRequestProperty(str, str2);
    }

    public final boolean equals(Object obj) {
        return this.delegate.equals(obj);
    }

    @Override // java.net.URLConnection
    public final boolean getAllowUserInteraction() {
        return this.delegate.getAllowUserInteraction();
    }

    @Override // java.net.URLConnection
    public final int getConnectTimeout() {
        return this.delegate.getConnectTimeout();
    }

    @Override // java.net.URLConnection
    public final boolean getDefaultUseCaches() {
        return this.delegate.getDefaultUseCaches();
    }

    @Override // java.net.URLConnection
    public final boolean getDoInput() {
        return this.delegate.getDoInput();
    }

    @Override // java.net.URLConnection
    public final boolean getDoOutput() {
        return this.delegate.getDoOutput();
    }

    @Override // java.net.HttpURLConnection
    public final InputStream getErrorStream() {
        return this.delegate.getErrorStream();
    }

    @Override // java.net.URLConnection
    public final long getIfModifiedSince() {
        return this.delegate.getIfModifiedSince();
    }

    @Override // java.net.HttpURLConnection
    public final boolean getInstanceFollowRedirects() {
        return this.delegate.getInstanceFollowRedirects();
    }

    @Override // java.net.URLConnection
    public final int getReadTimeout() {
        return this.delegate.getReadTimeout();
    }

    @Override // java.net.HttpURLConnection
    public final String getRequestMethod() {
        return this.delegate.getRequestMethod();
    }

    @Override // java.net.URLConnection
    public final Map<String, List<String>> getRequestProperties() {
        return this.delegate.getRequestProperties();
    }

    @Override // java.net.URLConnection
    public final String getRequestProperty(String str) {
        return this.delegate.getRequestProperty(str);
    }

    @Override // java.net.URLConnection
    public final URL getURL() {
        return this.delegate.getURL();
    }

    @Override // java.net.URLConnection
    public final boolean getUseCaches() {
        return this.delegate.getUseCaches();
    }

    public final int hashCode() {
        return this.delegate.hashCode();
    }

    @Override // java.net.URLConnection
    public final void setAllowUserInteraction(boolean z) {
        this.delegate.setAllowUserInteraction(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setChunkedStreamingMode(int i) {
        this.delegate.setChunkedStreamingMode(i);
    }

    @Override // java.net.URLConnection
    public final void setConnectTimeout(int i) {
        this.delegate.setConnectTimeout(i);
    }

    @Override // java.net.URLConnection
    public final void setDefaultUseCaches(boolean z) {
        this.delegate.setDefaultUseCaches(z);
    }

    @Override // java.net.URLConnection
    public final void setDoInput(boolean z) {
        this.delegate.setDoInput(z);
    }

    @Override // java.net.URLConnection
    public final void setDoOutput(boolean z) {
        this.delegate.setDoOutput(z);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(int i) {
        this.delegate.setFixedLengthStreamingMode(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setFixedLengthStreamingMode(long j) {
        this.delegate.setFixedLengthStreamingMode(j);
    }

    @Override // java.net.URLConnection
    public final void setIfModifiedSince(long j) {
        this.delegate.setIfModifiedSince(j);
    }

    @Override // java.net.HttpURLConnection
    public final void setInstanceFollowRedirects(boolean z) {
        this.delegate.setInstanceFollowRedirects(z);
    }

    @Override // java.net.URLConnection
    public final void setReadTimeout(int i) {
        this.delegate.setReadTimeout(i);
    }

    @Override // java.net.HttpURLConnection
    public final void setRequestMethod(String str) throws ProtocolException {
        this.delegate.setRequestMethod(str);
    }

    @Override // java.net.URLConnection
    public final void setRequestProperty(String str, String str2) {
        this.delegate.setRequestProperty(str, str2);
    }

    @Override // java.net.URLConnection
    public final void setUseCaches(boolean z) {
        this.delegate.setUseCaches(z);
    }

    @Override // java.net.URLConnection
    public final String toString() {
        return this.delegate.toString();
    }

    @Override // java.net.HttpURLConnection
    public final boolean usingProxy() {
        return this.delegate.usingProxy();
    }
}
