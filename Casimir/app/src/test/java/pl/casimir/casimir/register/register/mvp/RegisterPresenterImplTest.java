package pl.casimir.casimir.register.register.mvp;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

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
        presenter = new RegisterPresenterImpl(view, model);
    }

    @Test
    public void register_succesful() throws Exception {
        Mockito.when(model.isCorrect("Czesiek", "Kazik", "Kazik")).thenReturn(true);

        presenter.register("Czesiek", "Kazik", "Kazik");

        Mockito.verify(view).signUp();
    }

    @Test
    public void register_failed() throws Exception{
        Mockito.when(model.isCorrect("Czesiek", "Kazik", "Kazik")).thenReturn(true);

        presenter.register("Czesiek", "Kazik", "Jasiek");

        Mockito.verify(view).error();
    }

}