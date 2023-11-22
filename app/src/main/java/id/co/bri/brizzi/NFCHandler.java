package id.co.bri.brizzi;

import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import java.io.IOException;

/* loaded from: classes8.dex */
public class NFCHandler {

    /* renamed from: a  reason: collision with root package name */
    public IsoDep f8015a;
    public String b = " ";
    public CardData c;
    public String d;

    static {
        System.loadLibrary("r1bd3c");
    }

    public NFCHandler(IsoDep isoDep, String str) {
        this.f8015a = isoDep;
        new Utility();
        new RCOptions();
        this.d = str;
    }

    public static native long bjYhHYiaCcaxWLbT();

    public static native long dlkmbZodhbjiPljl(IsoDep isoDep, Tag tag, String str, CardData cardData);

    public static native long klbOjZvklaiXhjbi(IsoDep isoDep, Tag tag, String str, String str2, CardData cardData);

    public static native long liiAApdhjCpdjcrc(IsoDep isoDep, Tag tag, String str, CardData cardData);

    public static native long sfcbcWabYjdlxofl(IsoDep isoDep, Tag tag, String str, String str2, CardData cardData);

    public static native long xiaaIilbaTajlhls(IsoDep isoDep, Tag tag, String str, String str2, CardData cardData);

    public CardData getCardData() {
        return this.c;
    }

    public String initInquiry() {
        try {
            this.c = new CardData();
            IsoDep isoDep = this.f8015a;
            return Long.toString(dlkmbZodhbjiPljl(isoDep, isoDep.getTag(), this.d, this.c));
        } catch (IOException unused) {
            return Long.toString(bjYhHYiaCcaxWLbT());
        }
    }

    public String klbOjZvklaiXhjbi(String str) {
        try {
            IsoDep isoDep = this.f8015a;
            return Long.toString(klbOjZvklaiXhjbi(isoDep, isoDep.getTag(), str, this.b, this.c));
        } catch (IOException unused) {
            return Long.toString(bjYhHYiaCcaxWLbT());
        }
    }

    public String liiAApdhjCpdjcrc(String str) {
        try {
            IsoDep isoDep = this.f8015a;
            return Long.toString(liiAApdhjCpdjcrc(isoDep, isoDep.getTag(), str, this.c));
        } catch (IOException unused) {
            return Long.toString(bjYhHYiaCcaxWLbT());
        }
    }

    public String sfcbcWabYjdlxofl(String str) {
        try {
            IsoDep isoDep = this.f8015a;
            return Long.toString(sfcbcWabYjdlxofl(isoDep, isoDep.getTag(), str, this.b, this.c));
        } catch (IOException unused) {
            return Long.toString(bjYhHYiaCcaxWLbT());
        }
    }

    public String xiaaIilbaTajlhls() {
        try {
            this.c = new CardData();
            IsoDep isoDep = this.f8015a;
            return Long.toString(xiaaIilbaTajlhls(isoDep, isoDep.getTag(), this.d, this.b, this.c));
        } catch (IOException unused) {
            return Long.toString(bjYhHYiaCcaxWLbT());
        }
    }
}
