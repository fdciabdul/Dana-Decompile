package id.dana.data.userconfig;

/* loaded from: classes2.dex */
public class BiztypeNotFoundException extends Exception {
    public BiztypeNotFoundException() {
        super("User config not found both in local & backend");
    }
}
