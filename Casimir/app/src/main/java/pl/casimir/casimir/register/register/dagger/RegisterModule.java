package pl.casimir.casimir.register.register.dagger;

import dagger.Module;
import dagger.Provides;
import pl.casimir.casimir.SchedulerHolders;
import pl.casimir.casimir.dagger.ActivityScope;
import pl.casimir.casimir.register.register.mvp.RegisterMVP;
import pl.casimir.casimir.register.register.mvp.RegisterModelImpl;
import pl.casimir.casimir.register.register.mvp.RegisterPresenterImpl;

/**
 * Created by hp on 2017-03-11.
 */
@Module
public class RegisterModule {

    private RegisterMVP.View view;

    public RegisterModule(RegisterMVP.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    public RegisterPresenterImpl registerPresenterProvider(RegisterModelImpl model, SchedulerHolders schedulerHolders) {
        return new RegisterPresenterImpl(view, model, schedulerHolders);
    }

}
