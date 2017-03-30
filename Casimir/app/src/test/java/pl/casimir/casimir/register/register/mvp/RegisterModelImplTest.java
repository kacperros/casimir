package pl.casimir.casimir.register.register.mvp;

import android.support.v4.media.MediaMetadataCompat;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import pl.casimir.casimir.persistance.shared_prefs.SharedPreferencesFacade;

import static org.junit.Assert.*;

/**
 * Created by hp on 2017-03-30.
 */
public class RegisterModelImplTest {

    @Mock
    SharedPreferencesFacade facade;

    private RegisterModelImpl registerModel;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
        registerModel = new RegisterModelImpl(facade);
    }
    @Test
    public void isCorrect() throws Exception {
        Assert.assertTrue(registerModel.isCorrect("nic", "Jasio", "Jasio"));
    }

    @Test
    public void isNotCorrect() throws Exception {
        Assert.assertFalse(registerModel.isCorrect("nic", "Kazi1o", "Kazio"));
    }
}