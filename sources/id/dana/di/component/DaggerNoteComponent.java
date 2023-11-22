package id.dana.di.component;

import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import id.dana.di.modules.NoteModule;
import id.dana.di.modules.NoteModule_ProvideNotePresenterFactory;
import id.dana.di.modules.NoteModule_ProvideNoteViewFactory;
import id.dana.domain.featureconfig.FeatureConfigRepository;
import id.dana.domain.sendmoney.interactor.GetNoteMaxChar;
import id.dana.domain.sendmoney.interactor.GetNoteMaxChar_Factory;
import id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment;
import id.dana.sendmoney.remarks.NoteBottomSheetDialogFragment_MembersInjector;
import id.dana.sendmoney.remarks.NoteContract;
import id.dana.sendmoney.remarks.NotePresenter;
import id.dana.sendmoney.remarks.NotePresenter_Factory;
import javax.inject.Provider;

/* loaded from: classes4.dex */
public final class DaggerNoteComponent {
    private DaggerNoteComponent() {
    }

    public static Builder BuiltInFictitiousFunctionClassFactory() {
        return new Builder((byte) 0);
    }

    /* loaded from: classes4.dex */
    public static final class Builder {
        public NoteModule BuiltInFictitiousFunctionClassFactory;
        public ApplicationComponent MyBillsEntityDataFactory;

        /* synthetic */ Builder(byte b) {
            this();
        }

        private Builder() {
        }
    }

    /* loaded from: classes4.dex */
    public static final class NoteComponentImpl implements NoteComponent {
        private Provider<GetNoteMaxChar> BuiltInFictitiousFunctionClassFactory;
        private final NoteComponentImpl KClassImpl$Data$declaredNonStaticMembers$2;
        private Provider<NoteContract.Presenter> MyBillsEntityDataFactory;
        private Provider<FeatureConfigRepository> PlaceComponentResult;
        private Provider<NotePresenter> getAuthRequestContext;
        private Provider<NoteContract.View> moveToNextValue;

        public /* synthetic */ NoteComponentImpl(NoteModule noteModule, ApplicationComponent applicationComponent, byte b) {
            this(noteModule, applicationComponent);
        }

        private NoteComponentImpl(NoteModule noteModule, ApplicationComponent applicationComponent) {
            this.KClassImpl$Data$declaredNonStaticMembers$2 = this;
            FeatureConfigRepositoryProvider featureConfigRepositoryProvider = new FeatureConfigRepositoryProvider(applicationComponent);
            this.PlaceComponentResult = featureConfigRepositoryProvider;
            this.BuiltInFictitiousFunctionClassFactory = GetNoteMaxChar_Factory.create(featureConfigRepositoryProvider);
            Provider<NoteContract.View> authRequestContext = DoubleCheck.getAuthRequestContext(NoteModule_ProvideNoteViewFactory.PlaceComponentResult(noteModule));
            this.moveToNextValue = authRequestContext;
            NotePresenter_Factory BuiltInFictitiousFunctionClassFactory = NotePresenter_Factory.BuiltInFictitiousFunctionClassFactory(this.BuiltInFictitiousFunctionClassFactory, authRequestContext);
            this.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory;
            this.MyBillsEntityDataFactory = DoubleCheck.getAuthRequestContext(NoteModule_ProvideNotePresenterFactory.getAuthRequestContext(noteModule, BuiltInFictitiousFunctionClassFactory));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes4.dex */
        public static final class FeatureConfigRepositoryProvider implements Provider<FeatureConfigRepository> {
            private final ApplicationComponent PlaceComponentResult;

            FeatureConfigRepositoryProvider(ApplicationComponent applicationComponent) {
                this.PlaceComponentResult = applicationComponent;
            }

            @Override // javax.inject.Provider
            public final /* synthetic */ FeatureConfigRepository get() {
                return (FeatureConfigRepository) Preconditions.PlaceComponentResult(this.PlaceComponentResult.NetworkUserEntityData$$ExternalSyntheticLambda5());
            }
        }

        @Override // id.dana.di.component.NoteComponent
        public final void PlaceComponentResult(NoteBottomSheetDialogFragment noteBottomSheetDialogFragment) {
            NoteBottomSheetDialogFragment_MembersInjector.getAuthRequestContext(noteBottomSheetDialogFragment, this.MyBillsEntityDataFactory.get());
        }
    }
}
