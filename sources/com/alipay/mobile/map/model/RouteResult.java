package com.alipay.mobile.map.model;

import java.util.List;

/* loaded from: classes6.dex */
public class RouteResult {

    /* renamed from: a  reason: collision with root package name */
    private List<Path> f7197a;
    private String b;
    private String c;

    public String getStatus() {
        return this.b;
    }

    public void setStatus(String str) {
        this.b = str;
    }

    public String getErrorMessage() {
        return this.c;
    }

    public void setErrorMessage(String str) {
        this.c = str;
    }

    public List<Path> getPaths() {
        return this.f7197a;
    }

    public void setPaths(List<Path> list) {
        this.f7197a = list;
    }

    /* loaded from: classes6.dex */
    public static class Path {

        /* renamed from: a  reason: collision with root package name */
        private long f7198a;
        private long b;
        private List<Step> c;

        public long getDuration() {
            return this.b;
        }

        public void setDuration(long j) {
            this.b = j;
        }

        public long getDistance() {
            return this.f7198a;
        }

        public void setDistance(long j) {
            this.f7198a = j;
        }

        public List<Step> getSteps() {
            return this.c;
        }

        public void setSteps(List<Step> list) {
            this.c = list;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Path{distance=");
            sb.append(this.f7198a);
            sb.append(", duration=");
            sb.append(this.b);
            sb.append(", steps=");
            sb.append(this.c);
            sb.append('}');
            return sb.toString();
        }
    }

    /* loaded from: classes6.dex */
    public static class Step {

        /* renamed from: a  reason: collision with root package name */
        private long f7199a;
        private long b;
        private List<LatLonPoint> c;

        public long getDistance() {
            return this.f7199a;
        }

        public void setDistance(long j) {
            this.f7199a = j;
        }

        public long getDuration() {
            return this.b;
        }

        public void setDuration(long j) {
            this.b = j;
        }

        public List<LatLonPoint> getPoints() {
            return this.c;
        }

        public void setPoints(List<LatLonPoint> list) {
            this.c = list;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Step{distance=");
            sb.append(this.f7199a);
            sb.append(", duration=");
            sb.append(this.b);
            sb.append(", points=");
            sb.append(this.c);
            sb.append('}');
            return sb.toString();
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RouteResult{paths=");
        sb.append(this.f7197a);
        sb.append('}');
        return sb.toString();
    }
}
