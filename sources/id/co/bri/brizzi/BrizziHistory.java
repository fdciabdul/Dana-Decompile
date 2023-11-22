package id.co.bri.brizzi;

import id.dana.analytics.tracker.TrackerKey;

/* loaded from: classes8.dex */
public class BrizziHistory {

    /* renamed from: a  reason: collision with root package name */
    public String f8013a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;

    public BrizziHistory(String str) {
        Utility utility = new Utility();
        this.f8013a = str.substring(0, 5).equalsIgnoreCase("00000") ? str.substring(0, 16) : utility.a(str.substring(0, 16));
        this.b = utility.a(str.substring(16, 32));
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(32, 34));
        sb.append("/");
        sb.append(str.substring(34, 36));
        sb.append("/");
        sb.append(str.substring(36, 38));
        this.c = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str.substring(38, 40));
        sb2.append(":");
        sb2.append(str.substring(40, 42));
        sb2.append(":");
        sb2.append(str.substring(42, 44));
        this.d = sb2.toString();
        this.e = a(str.substring(44, 46));
        this.f = String.format("%,.2f", Double.valueOf(Integer.parseInt(utility.c(str.substring(46, 52)), 16)));
        this.g = String.format("%,.2f", Double.valueOf(Integer.parseInt(utility.c(str.substring(52, 58)), 16)));
        this.h = String.format("%,.2f", Double.valueOf(Integer.parseInt(utility.c(str.substring(58, 64)), 16)));
    }

    public final String a(String str) {
        return str.equalsIgnoreCase("EB") ? TrackerKey.DanaWalletSectionName.WALLET_PAYMENT : str.equalsIgnoreCase("EC") ? "Topup Online" : str.equalsIgnoreCase("ED") ? "Void Payment" : str.equalsIgnoreCase("EF") ? "Update Balance" : str.equalsIgnoreCase("5F") ? "Reaktivasi" : "Lain-lain";
    }

    public String getAmount() {
        return this.f;
    }

    public String getBalAfter() {
        return this.h;
    }

    public String getBalBefore() {
        return this.g;
    }

    public String getMid() {
        return this.f8013a;
    }

    public String getTid() {
        return this.b;
    }

    public String getTrxDate() {
        return this.c;
    }

    public String getTrxTime() {
        return this.d;
    }

    public String getTrxType() {
        return this.e;
    }
}
