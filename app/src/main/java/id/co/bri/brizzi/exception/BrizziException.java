package id.co.bri.brizzi.exception;

/* loaded from: classes8.dex */
public class BrizziException {

    /* renamed from: a  reason: collision with root package name */
    private ExceptionList f8017a;
    private String b;
    private String c;

    public BrizziException(String str) {
        ExceptionList exceptionList = new ExceptionList();
        this.f8017a = exceptionList;
        this.b = str;
        this.c = exceptionList.a(str);
    }

    public String getErrorCode() {
        return this.b;
    }

    public String getMessage() {
        return this.c;
    }
}
