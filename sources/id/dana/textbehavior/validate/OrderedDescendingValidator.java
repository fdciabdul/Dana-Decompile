package id.dana.textbehavior.validate;

/* loaded from: classes5.dex */
public class OrderedDescendingValidator implements Validator {
    @Override // id.dana.textbehavior.validate.Validator
    public final String KClassImpl$Data$declaredNonStaticMembers$2() {
        return "Text cannot use descending sequence number";
    }

    @Override // id.dana.textbehavior.validate.Validator
    public final boolean MyBillsEntityDataFactory(String str) {
        int i = 1;
        while (i < str.length()) {
            int numericValue = Character.getNumericValue(str.charAt(i));
            int i2 = i - 1;
            if (numericValue != Character.getNumericValue(str.charAt(i2)) - 1) {
                return true;
            }
            i = i2 + 1 + 1;
        }
        return false;
    }
}
