package com.alibaba.griver.image.photo.utils;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.text.DecimalFormat;

/* loaded from: classes6.dex */
public class DiskFormatter {
    public static final String B = "B";
    public static final String FORMAT = "#.00";
    public static final String GB = "G";
    public static final String KB = "K";
    public static final String MB = "M";
    public static final String TB = "T";
    public static final int UNIT = 1024;

    /* renamed from: a  reason: collision with root package name */
    private double f6616a;
    private double b;
    private double c;
    private double d;
    private String e = FORMAT;
    private int f = 1024;

    public DiskFormatter() {
        a();
    }

    public void setUnit(int i) {
        if (i > 0) {
            this.f = i;
            a();
        }
    }

    private void a() {
        double d = this.f;
        this.f6616a = d;
        Double.isNaN(d);
        Double.isNaN(d);
        double d2 = d * d;
        this.b = d2;
        Double.isNaN(d);
        double d3 = d2 * d;
        this.c = d3;
        Double.isNaN(d);
        this.d = d * d3;
    }

    public void setFormat(String str) {
        this.e = str;
    }

    public String format(double d) {
        if (d < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return null;
        }
        if (d < this.f6616a) {
            StringBuilder sb = new StringBuilder();
            sb.append(d);
            sb.append(B);
            return sb.toString();
        } else if (d < this.b) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a(d, this.f6616a));
            sb2.append("KB");
            return sb2.toString();
        } else if (d < this.c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(a(d, this.b));
            sb3.append("MB");
            return sb3.toString();
        } else if (d < this.d) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(a(d, this.c));
            sb4.append("GB");
            return sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(a(d, this.d));
            sb5.append("TB");
            return sb5.toString();
        }
    }

    private String a(double d, double d2) {
        return new DecimalFormat(this.e).format(d / d2);
    }
}
