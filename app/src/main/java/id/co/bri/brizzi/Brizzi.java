package id.co.bri.brizzi;

import a.a.a.a.a.b;
import a.a.a.a.a.d;
import a.a.a.a.a.e.a;
import a.a.a.a.a.e.c;
import android.content.Context;
import android.content.Intent;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import id.co.bri.brizzi.exception.BrizziException;
import id.co.bri.brizzi.hostService.APIData;
import id.co.bri.brizzi.hostService.HostUtil;
import java.util.HashMap;

/* loaded from: classes8.dex */
public class Brizzi {

    /* renamed from: a  reason: collision with root package name */
    public NFCHandler f8008a;
    public CardData b;
    public Utility c;
    public b d;
    public APIData e;
    public HostUtil f;
    public Context g;
    public NfcAdapter h;
    public RCOptions rcOptions;

    /* renamed from: id.co.bri.brizzi.Brizzi$2  reason: invalid class name */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 implements a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Callback f8010a;
        public final /* synthetic */ String b;

        public AnonymousClass2(Callback callback, String str) {
            this.f8010a = callback;
            this.b = str;
        }

        @Override // a.a.a.a.a.e.a
        public void onFailure(BrizziException brizziException) {
            this.f8010a.onFailure(brizziException);
        }

        @Override // a.a.a.a.a.e.a
        public void onReceive(String str) {
            Brizzi brizzi = Brizzi.this;
            APIData aPIData = brizzi.e;
            HostUtil hostUtil = brizzi.f;
            aPIData.setPath(HostUtil.c);
            if (!Brizzi.this.f8008a.klbOjZvklaiXhjbi(str).equalsIgnoreCase("2")) {
                String a2 = Brizzi.this.f.a();
                if (a2.equalsIgnoreCase("")) {
                    this.f8010a.onFailure(new BrizziException("03"));
                    return;
                } else {
                    this.f8010a.onFailure(Brizzi.a(Brizzi.this, a2));
                    return;
                }
            }
            Brizzi brizzi2 = Brizzi.this;
            brizzi2.f.b(brizzi2.e);
            Brizzi brizzi3 = Brizzi.this;
            b bVar = brizzi3.d;
            APIData aPIData2 = brizzi3.e;
            String str2 = this.b;
            a.a.a.a.a.e.b bVar2 = new a.a.a.a.a.e.b() { // from class: id.co.bri.brizzi.Brizzi.2.1
                @Override // a.a.a.a.a.e.b
                public void onFailure(BrizziException brizziException) {
                    AnonymousClass2.this.f8010a.onFailure(brizziException);
                }

                @Override // a.a.a.a.a.e.b
                public void onReceive(String str3) {
                    Brizzi.this.c.writeAdvanceDebuggingLog("onReceive Updatebalance");
                    final String sfcbcWabYjdlxofl = Brizzi.this.f8008a.sfcbcWabYjdlxofl(str3);
                    Utility utility = Brizzi.this.c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("CommitRC : ");
                    sb.append(sfcbcWabYjdlxofl);
                    utility.writeAdvanceDebuggingLog(sb.toString());
                    if (!sfcbcWabYjdlxofl.equalsIgnoreCase("0") && !sfcbcWabYjdlxofl.equalsIgnoreCase("88") && !sfcbcWabYjdlxofl.equalsIgnoreCase("44") && !sfcbcWabYjdlxofl.equalsIgnoreCase("11")) {
                        String b = Brizzi.this.f.b();
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        anonymousClass2.f8010a.onFailure(Brizzi.a(Brizzi.this, b));
                        return;
                    }
                    Brizzi brizzi4 = Brizzi.this;
                    brizzi4.b = brizzi4.f8008a.getCardData();
                    if (sfcbcWabYjdlxofl.equalsIgnoreCase("88")) {
                        CardData cardData = Brizzi.this.b;
                        cardData.d = String.valueOf(Integer.parseInt(cardData.getCardBalance()) + Integer.parseInt(Brizzi.this.b.getActivatedBalance()));
                    }
                    Brizzi brizzi5 = Brizzi.this;
                    APIData aPIData3 = brizzi5.e;
                    HostUtil hostUtil2 = brizzi5.f;
                    aPIData3.setPath(HostUtil.d);
                    Brizzi brizzi6 = Brizzi.this;
                    brizzi6.f.c(brizzi6.e);
                    AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                    Brizzi brizzi7 = Brizzi.this;
                    b bVar3 = brizzi7.d;
                    APIData aPIData4 = brizzi7.e;
                    String str4 = anonymousClass22.b;
                    c cVar = new c() { // from class: id.co.bri.brizzi.Brizzi.2.1.1
                        @Override // a.a.a.a.a.e.c
                        public void onFailure(BrizziException brizziException) {
                            if (!sfcbcWabYjdlxofl.equalsIgnoreCase("0") && !sfcbcWabYjdlxofl.equalsIgnoreCase("88")) {
                                AnonymousClass2.this.f8010a.onFailure(brizziException);
                                return;
                            }
                            AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                            anonymousClass23.f8010a.onSuccess(Brizzi.this.b);
                        }

                        @Override // a.a.a.a.a.e.c
                        public void onReceive(String str5) {
                            String a3 = Brizzi.this.f.a(str5);
                            if (a3.equalsIgnoreCase("00")) {
                                AnonymousClass2 anonymousClass23 = AnonymousClass2.this;
                                anonymousClass23.f8010a.onSuccess(Brizzi.this.b);
                            } else if (sfcbcWabYjdlxofl.equalsIgnoreCase("0") || sfcbcWabYjdlxofl.equalsIgnoreCase("88")) {
                                AnonymousClass2 anonymousClass24 = AnonymousClass2.this;
                                anonymousClass24.f8010a.onSuccess(Brizzi.this.b);
                            } else {
                                BrizziException a4 = Brizzi.a(Brizzi.this, a3);
                                if (!a4.getErrorCode().equalsIgnoreCase("91")) {
                                    AnonymousClass2.this.f8010a.onFailure(a4);
                                } else if (!sfcbcWabYjdlxofl.equalsIgnoreCase("0") && !sfcbcWabYjdlxofl.equalsIgnoreCase("88")) {
                                    AnonymousClass2.this.f8010a.onFailure(a4);
                                } else {
                                    AnonymousClass2 anonymousClass25 = AnonymousClass2.this;
                                    anonymousClass25.f8010a.onSuccess(Brizzi.this.b);
                                }
                            }
                        }
                    };
                    bVar3.KClassImpl$Data$declaredNonStaticMembers$2.writeAdvanceDebuggingLog(aPIData4.getBody());
                    HashMap hashMap = new HashMap();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Bearer ");
                    sb2.append(aPIData4.ldUfdlAlicDjlJVa());
                    hashMap.put("Authorization", sb2.toString());
                    hashMap.put("Content-Type", "text/plain; charset=UTF-8");
                    hashMap.put("BRI-Signature", aPIData4.getSignature());
                    hashMap.put("BRI-Timestamp", aPIData4.getTimestamp());
                    hashMap.put("BRI-External-Id", str4);
                    bVar3.MyBillsEntityDataFactory.KClassImpl$Data$declaredNonStaticMembers$2(aPIData4.getBody(), hashMap).MyBillsEntityDataFactory(new d(bVar3, cVar));
                }
            };
            bVar.KClassImpl$Data$declaredNonStaticMembers$2.writeAdvanceDebuggingLog(aPIData2.getBody());
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            sb.append("Bearer ");
            sb.append(aPIData2.ldUfdlAlicDjlJVa());
            hashMap.put("Authorization", sb.toString());
            hashMap.put("Content-Type", "text/plain; charset=UTF-8");
            hashMap.put("BRI-Signature", aPIData2.getSignature());
            hashMap.put("BRI-Timestamp", aPIData2.getTimestamp());
            hashMap.put("BRI-External-Id", str2);
            bVar.MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory(aPIData2.getBody(), hashMap).MyBillsEntityDataFactory(new a.a.a.a.a.c(bVar, bVar2));
        }
    }

    public Brizzi(String str, String str2) {
        APIData aPIData = new APIData();
        this.e = aPIData;
        aPIData.setConsumerKey(str2);
        this.e.setConsumerSecret(str);
        this.d = new b();
        this.f = new HostUtil();
        this.c = new Utility();
    }

    public static BrizziException a(Brizzi brizzi, String str) {
        BrizziException brizziException;
        if (str.equalsIgnoreCase("q4") || str.equalsIgnoreCase("q1")) {
            return new BrizziException("91");
        }
        if (str.equalsIgnoreCase("54")) {
            return new BrizziException("08");
        }
        if (str.equalsIgnoreCase("62")) {
            return new BrizziException("06");
        }
        if (str.equalsIgnoreCase("ev")) {
            return new BrizziException("92");
        }
        if (str.equalsIgnoreCase("nv")) {
            return new BrizziException("98");
        }
        if (str.equalsIgnoreCase("nf")) {
            return new BrizziException("09");
        }
        if (str.equalsIgnoreCase("93")) {
            brizziException = new BrizziException("93");
        } else if (!str.equalsIgnoreCase("97")) {
            return str.equalsIgnoreCase("ir") ? new BrizziException("96") : str.equalsIgnoreCase("zb") ? new BrizziException("04") : str.equalsIgnoreCase("ov") ? new BrizziException("05") : new BrizziException("98");
        } else {
            brizziException = new BrizziException("97");
        }
        return brizziException;
    }

    public final Boolean a(Intent intent, String str) {
        String action = intent.getAction();
        if ("android.nfc.action.TAG_DISCOVERED".equals(action) || "android.nfc.action.TECH_DISCOVERED".equals(action)) {
            Tag tag = (Tag) intent.getParcelableExtra("android.nfc.extra.TAG");
            String[] techList = tag.getTechList();
            String name = IsoDep.class.getName();
            for (String str2 : techList) {
                if (name.equals(str2)) {
                    this.f8008a = new NFCHandler(IsoDep.get(tag), str);
                    this.rcOptions = new RCOptions();
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }

    public final boolean a() {
        return (this.e.ldUfdlAlicDjlJVa() == null || this.e.rffebichdIWhbanb() == null || this.e.rjMffkMbfljIkilp() == null || this.e.getConsumerSecret() == null) ? false : true;
    }

    public void checkBalancePartner(Intent intent, final Callback callback) {
        if (!isNFCAvailable().booleanValue()) {
            callback.onFailure(new BrizziException("81"));
        } else if (!a(intent, this.e.getPackagename()).booleanValue()) {
            callback.onFailure(new BrizziException("64"));
        } else if (!a()) {
            callback.onFailure(new BrizziException("64"));
        } else {
            if (!(this.d != null)) {
                callback.onFailure(new BrizziException("99"));
                return;
            }
            this.e.setPath(HostUtil.b);
            this.f8008a.initInquiry();
            this.f.a(this.e);
            this.d.getAuthRequestContext(this.e, String.valueOf(System.currentTimeMillis()), new a() { // from class: id.co.bri.brizzi.Brizzi.1
                @Override // a.a.a.a.a.e.a
                public void onFailure(BrizziException brizziException) {
                    callback.onFailure(brizziException);
                }

                @Override // a.a.a.a.a.e.a
                public void onReceive(String str) {
                    if (!Brizzi.this.f8008a.liiAApdhjCpdjcrc(str).equalsIgnoreCase("0")) {
                        callback.onFailure(Brizzi.a(Brizzi.this, Brizzi.this.f.a()));
                        return;
                    }
                    Brizzi brizzi = Brizzi.this;
                    brizzi.b = brizzi.f8008a.getCardData();
                    callback.onSuccess(Brizzi.this.b);
                }
            });
        }
    }

    public NfcAdapter getNFCAdapter() {
        return this.h;
    }

    public Boolean isNFCAvailable() {
        return this.h == null ? Boolean.FALSE : Boolean.TRUE;
    }

    public void setNFCAdapter(Context context) {
        this.g = context;
        this.e.setPackagename(context.getPackageName());
        this.h = NfcAdapter.getDefaultAdapter(context);
    }

    public void setToken(String str) {
        this.e.setToken(str);
    }

    public void setUsername(String str) {
        this.e.setUsername(str);
    }

    public void updateBalancePartner(Intent intent, String str, Callback callback) {
        if (!isNFCAvailable().booleanValue()) {
            callback.onFailure(new BrizziException("81"));
        } else if (!a(intent, this.e.getPackagename()).booleanValue()) {
            callback.onFailure(new BrizziException("64"));
        } else if (!a()) {
            callback.onFailure(new BrizziException("64"));
        } else {
            if (!(this.d != null)) {
                callback.onFailure(new BrizziException("99"));
                return;
            }
            this.e.setPath(HostUtil.b);
            this.e.setPackagename(this.g.getPackageName());
            this.e.setReff(str);
            this.f8008a.xiaaIilbaTajlhls();
            this.f.a(this.e);
            this.d.getAuthRequestContext(this.e, str, new AnonymousClass2(callback, str));
        }
    }
}
