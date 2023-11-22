package com.alibaba.griver.video.utils;

/* loaded from: classes6.dex */
public class ProgressUtils {
    public static String getDurationString(int i) {
        int i2;
        String str;
        String obj;
        int i3 = i / 1000;
        int i4 = 0;
        if (i3 > 60) {
            i2 = i3 / 60;
            if (i2 > 60) {
                i4 = i2 / 60;
                i2 %= 60;
            }
            i3 %= 60;
        } else {
            i2 = 0;
        }
        if (i4 > 9) {
            StringBuilder sb = new StringBuilder();
            sb.append(i4);
            sb.append(":");
            str = sb.toString();
        } else if (i4 > 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("0");
            sb2.append(i4);
            sb2.append(":");
            str = sb2.toString();
        } else {
            str = "";
        }
        if (i2 > 9) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(i2);
            sb3.append(":");
            obj = sb3.toString();
        } else if (i2 > 0) {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append("0");
            sb4.append(i2);
            sb4.append(":");
            obj = sb4.toString();
        } else {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("00:");
            obj = sb5.toString();
        }
        if (i3 > 9) {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(obj);
            sb6.append(i3);
            return sb6.toString();
        } else if (i3 > 0) {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(obj);
            sb7.append("0");
            sb7.append(i3);
            return sb7.toString();
        } else {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(obj);
            sb8.append("00");
            return sb8.toString();
        }
    }
}
