package pl.casimir.casimir.login.mvp;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by hp on 2017-02-26.
 */

public class LoginPresenter implements LoginMVP.Presenter {

    private LoginMVP.View view;
    private LoginModel model;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public LoginPresenter(LoginMVP.View view, LoginModel loginModel) {
        this.view = view;
        this.model = loginModel;
    }

    @Override
    public void login(String login, String password) {
        compositeDisposable.add(model.login(login, password).observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<Boolean>() {
                    @Override
                    public void onNext(Boolean loginResult) {
                        if (loginResult) {
                            view.loginSuccessful();
                        } else {
                            view.loginFailed();
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

    public void updateData() {
        model.update();
    }

    @Override
    public void clearDisposables() {
        compositeDisposable.dispose();
    }
}
