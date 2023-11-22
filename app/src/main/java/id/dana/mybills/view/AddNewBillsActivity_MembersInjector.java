package id.dana.mybills.view;

import dagger.MembersInjector;
import id.dana.contract.services.ServicesContract;
import id.dana.mybills.di.MyBillsContract;

/* loaded from: classes5.dex */
public final class AddNewBillsActivity_MembersInjector implements MembersInjector<AddNewBillsActivity> {
    public static void BuiltInFictitiousFunctionClassFactory(AddNewBillsActivity addNewBillsActivity, MyBillsContract.Presenter presenter) {
        addNewBillsActivity.presenter = presenter;
    }

    public static void MyBillsEntityDataFactory(AddNewBillsActivity addNewBillsActivity, ServicesContract.Presenter presenter) {
        addNewBillsActivity.servicesPresenter = presenter;
    }
}
