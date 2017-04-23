package pl.casimir.casimir.register.register.mvp;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import pl.casimir.casimir.SchedulerHolders;

/**
 * Created by hp on 2017-03-11.
 */

public class RegisterPresenterImpl implements RegisterMVP.Presenter {

    private RegisterMVP.View view;
    private RegisterModelImpl model;

    private SchedulerHolders schedulerHolders;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public RegisterPresenterImpl(RegisterMVP.View view, RegisterModelImpl model, SchedulerHolders schedulerHolders)
    {
        this.view = view;
        this.model = model;
        this.schedulerHolders = schedulerHolders;
    }


    @Override
    public void register(String username, String password1, String password2) {
        compositeDisposable.add(model.isCorrect(username, password1, password2)
                .observeOn(schedulerHolders.observ())
                .subscribeOn(schedulerHolders.subscribe())
            .subscribeWith(new DisposableObserver<Boolean>(){
                @Override
                public void onNext(Boolean result) {
                    if(result){
                        view.signUp();
                    }
                    else{
                        view.error();
                    }
                }

                @Override
                public void onError(Throwable e) {
                    view.handleError(e);
                }

                @Override
                public void onComplete() {

                }
            }));
    }

    @Override
    public void clearDisposables() {
        compositeDisposable.dispose();
    }
}
