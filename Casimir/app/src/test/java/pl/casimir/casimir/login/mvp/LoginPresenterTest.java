package pl.casimir.casimir.login.mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import pl.casimir.casimir.SchedulerHolders;

public class LoginPresenterTest {

    @Mock
    LoginMVP.View loginView;

    @Mock
    LoginModel loginModel;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(loginView, loginModel,
                new SchedulerHolders(Schedulers.trampoline(), Schedulers.trampoline()));
    }

    @Test
    public void login_successful() throws Exception {
        Mockito.when(loginModel.login("Jerzy", "Marek")).thenReturn(Observable.just(true));

        presenter.login("Jerzy", "Marek");

        Mockito.verify(loginView).loginSuccessful();
    }

    @Test
    public void login_failed() throws Exception {
        Mockito.when(loginModel.login("Je", "Mare")).thenReturn(Observable.just(false));

        presenter.login("Je", "Mare");

        Mockito.verify(loginView).loginFailed();
    }
}