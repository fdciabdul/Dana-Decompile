package id.dana.di;

import id.dana.di.component.ApplicationComponent;

/* loaded from: classes.dex */
public class ComponentHolder {
    private static ComponentHolder getAuthRequestContext;
    private final ApplicationComponent BuiltInFictitiousFunctionClassFactory;

    private ComponentHolder(ApplicationComponent applicationComponent) {
        this.BuiltInFictitiousFunctionClassFactory = applicationComponent;
    }

    public static void getAuthRequestContext(ApplicationComponent applicationComponent) {
        if (getAuthRequestContext == null) {
            getAuthRequestContext = new ComponentHolder(applicationComponent);
        }
    }

    public static ApplicationComponent getAuthRequestContext() {
        ComponentHolder componentHolder = getAuthRequestContext;
        if (componentHolder == null) {
            throw new IllegalStateException("Application components needs to be set in Application");
        }
        return componentHolder.BuiltInFictitiousFunctionClassFactory;
    }
}
