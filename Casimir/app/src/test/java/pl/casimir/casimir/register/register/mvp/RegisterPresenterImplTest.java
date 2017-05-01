package pl.casimir.casimir.register.register.mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import pl.casimir.casimir.SchedulerHolders;

import static org.mockito.Mockito.when;

/**
 * Created by hp on 2017-03-30.
 */
public class RegisterPresenterImplTest {

    @Mock
    RegisterMVP.View view;

    @Mock
    RegisterModelImpl model;

    private RegisterPresenterImpl presenter;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new RegisterPresenterImpl(view, model,
                new SchedulerHolders(Schedulers.trampoline(), Schedulers.trampoline()));
    }
    @Test
    public void registerSuccesful() throws Exception {
        when(model.isCorrect("nic", "raz", "raz")).thenReturn(Observable.just(true));
        presenter.register("nic", "raz", "raz");

        Mockito.verify(view).signUp();

    }

    @Test
    public void registerFailed() throws Exception {
        when(model.isCorrect("nic", "ra", "raz")).thenReturn(Observable.just(false));
        presenter.register("nic", "ra", "raz");

        Mockito.verify(view).error();

    }
}