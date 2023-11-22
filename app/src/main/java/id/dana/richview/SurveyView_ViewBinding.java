package id.dana.richview;

import android.view.View;
import android.widget.FrameLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import id.dana.R;

/* loaded from: classes9.dex */
public class SurveyView_ViewBinding implements Unbinder {
    private View MyBillsEntityDataFactory;
    private SurveyView getAuthRequestContext;

    public SurveyView_ViewBinding(final SurveyView surveyView, View view) {
        this.getAuthRequestContext = surveyView;
        View BuiltInFictitiousFunctionClassFactory = Utils.BuiltInFictitiousFunctionClassFactory(view, R.id.fl_home_survey, "field 'flhomeSurvey' and method 'onClickSurvey'");
        surveyView.flhomeSurvey = (FrameLayout) Utils.BuiltInFictitiousFunctionClassFactory(BuiltInFictitiousFunctionClassFactory, R.id.fl_home_survey, "field 'flhomeSurvey'", FrameLayout.class);
        this.MyBillsEntityDataFactory = BuiltInFictitiousFunctionClassFactory;
        BuiltInFictitiousFunctionClassFactory.setOnClickListener(new DebouncingOnClickListener() { // from class: id.dana.richview.SurveyView_ViewBinding.1
            @Override // butterknife.internal.DebouncingOnClickListener
            public final void KClassImpl$Data$declaredNonStaticMembers$2(View view2) {
                surveyView.onClickSurvey();
            }
        });
    }

    @Override // butterknife.Unbinder
    public final void getAuthRequestContext() {
        SurveyView surveyView = this.getAuthRequestContext;
        if (surveyView == null) {
            throw new IllegalStateException("Bindings already cleared.");
        }
        this.getAuthRequestContext = null;
        surveyView.flhomeSurvey = null;
        this.MyBillsEntityDataFactory.setOnClickListener(null);
        this.MyBillsEntityDataFactory = null;
    }
}
