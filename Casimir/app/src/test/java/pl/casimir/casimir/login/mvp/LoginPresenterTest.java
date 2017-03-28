package pl.casimir.casimir.login.mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class LoginPresenterTest {

    @Mock
    LoginView loginView;

    @Mock
    LoginModel loginModel;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(loginView, loginModel);
    }

    @Test
    public void login_successful() throws Exception {
        Mockito.when(loginModel.login("Jerzy", "Marek")).thenReturn(true);

        presenter.login("Jerzy", "Marek");

        Mockito.verify(loginView).toNextActivity();
    }

    @Test
    public void login_failed() throws Exception {
        Mockito.when(loginModel.login("Jerzy", "Marek")).thenReturn(true);

        presenter.login("Je", "Mare");

        Mockito.verify(loginView).badLogin();
    }
}