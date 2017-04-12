package pl.casimir.casimir.login.mvp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.observers.DisposableObserver;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;
import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacadeImpl;

import static org.junit.Assert.*;

public class LoginModelTest {

    @Mock
    private SharedPreferencesFacade sharedPreferencesFacade;

    private LoginModel loginModel;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        Mockito.when(sharedPreferencesFacade.getString("LOGIN")).thenReturn("Andrzej");
        Mockito.when(sharedPreferencesFacade.getString("PASSWORD")).thenReturn("Pietruszka");
        loginModel = new LoginModel(sharedPreferencesFacade);
    }

    @Test
    public void login_successful() throws Exception {
        loginModel.login("Andrzej", "Pietruszka").subscribeWith(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(Boolean loginResult) {
                Assert.assertTrue(loginResult);
            }

            @Override
            public void onError(Throwable e) {
                Assert.fail();
            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Test
    public void login_failed() throws Exception {
        loginModel.login("Jerzy", "Pietruszka").subscribeWith(new DisposableObserver<Boolean>() {
            @Override
            public void onNext(Boolean loginResult) {
                Assert.assertTrue(!loginResult);
            }

            @Override
            public void onError(Throwable e) {
                Assert.fail();
            }

            @Override
            public void onComplete() {

            }
        });
    }

}