package id.dana.textbehavior.validate;

/* loaded from: classes5.dex */
public class RepeatedStringValidator implements Validator {
    @Override // id.dana.textbehavior.validate.Validator
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "Text cannot use repeated character";
    }

    @Override // id.dana.textbehavior.validate.Validator
    public final boolean MyBillsEntityDataFactory(String str) {
        return !str.matches("\\b(\\d)\\1+\\b");
    }
}
