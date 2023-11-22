package id.co.bri.brizzi;

import java.util.ArrayList;

/* loaded from: classes8.dex */
public class CardData<Static> {

    /* renamed from: a  reason: collision with root package name */
    public Utility f8014a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;

    public CardData() {
        this.f8014a = new Utility();
    }

    public CardData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Utility utility = new Utility();
        this.f8014a = utility;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = utility.b(str6);
        this.h = str7;
        this.i = str8;
        this.j = str9;
        this.k = "";
        this.l = "";
    }

    public String getActivatedBalance() {
        return this.l;
    }

    public String getCardBalance() {
        return this.d;
    }

    public ArrayList<BrizziHistory> getCardHistory() {
        String str = this.h;
        if (str.isEmpty()) {
            return null;
        }
        ArrayList<BrizziHistory> arrayList = new ArrayList<>();
        int length = (str.length() % 64 == 0 ? str.length() / 64 : 0) - 1;
        for (int i = length; i >= 0; i--) {
            arrayList.add(length - i, new BrizziHistory(str.substring(i * 64, (i + 1) * 64)));
        }
        return arrayList;
    }

    public String getCardIssuerCode() {
        return this.f;
    }

    public String getCardNumber() {
        return this.c;
    }

    public String getCardPerso() {
        return this.e;
    }

    public String getCardStatus() {
        return this.g;
    }

    public String getCardUID() {
        return this.b;
    }

    public String getPendingBalance() {
        return this.k;
    }

    public String getRandomSAM() {
        return this.i;
    }

    public String getValidateRandom() {
        return this.j;
    }

    public void setCardData(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = this.f8014a.b(str6);
        this.h = str7;
        this.i = str8;
        this.j = str9;
    }

    public void setValidateRandom(String str) {
        this.j = str;
    }

    public void tKccfjijKAksjiaj(String str, String str2) {
        this.k = str;
        this.l = str2;
    }
}
