package com.iap.ac.android.gol.google.supergw;

/* loaded from: classes8.dex */
public class SuperGwRequest<T> {
    public Request<T> request;
    public String signature;

    /* loaded from: classes8.dex */
    public static class Request<U> {
        public U body;
        public SuperGwHead head;
    }
}
