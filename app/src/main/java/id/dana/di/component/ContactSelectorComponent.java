package id.dana.di.component;

import dagger.Component;
import id.dana.di.PerActivity;
import id.dana.di.modules.DanaContactModule;
import id.dana.richview.contactselector.ContactSelectorView;

@Component(dependencies = {ApplicationComponent.class}, modules = {DanaContactModule.class})
@PerActivity
/* loaded from: classes4.dex */
public interface ContactSelectorComponent {
    void BuiltInFictitiousFunctionClassFactory(ContactSelectorView contactSelectorView);
}
