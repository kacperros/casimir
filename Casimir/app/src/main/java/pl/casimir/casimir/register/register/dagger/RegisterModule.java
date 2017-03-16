package pl.casimir.casimir.register.register.dagger;

import dagger.Module;
import dagger.Provides;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.register.register.mvp.RegisterModel;
import pl.casimir.casimir.register.register.mvp.RegisterModelImpl;
import pl.casimir.casimir.register.register.mvp.RegisterPresenter;
import pl.casimir.casimir.register.register.mvp.RegisterPresenterImpl;
import pl.casimir.casimir.register.register.mvp.RegisterView;

/**
 * Created by hp on 2017-03-11.
 */
@Module
public class RegisterModule {

    private RegisterView view;

    public RegisterModule(RegisterView view){
        this.view = view;
    }

    @Provides
    @ActivityScope
    public RegisterPresenterImpl registerPresenterProvider(RegisterModelImpl model){
        return new RegisterPresenterImpl(view, model);
    }

}
