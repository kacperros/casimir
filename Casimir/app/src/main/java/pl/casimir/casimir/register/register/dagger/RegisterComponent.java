package pl.casimir.casimir.register.register.dagger;

import dagger.Component;
import pl.casimir.casimir.dagger.CasimirComponent;
import pl.casimir.casimir.register.register.ui.RegisterActivity;


/**
 * Created by hp on 2017-03-11.
 */
@Component(modules = {RegisterModule.class}, dependencies = {CasimirComponent.class})
public interface RegisterComponent {

    void inject(RegisterActivity registerActivity);

}
