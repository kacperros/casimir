package pl.casimir.casimir.register.register.mvp;


public interface RegisterMVP {

    interface Model {
        boolean isCorrect(String login, String password1, String password2);

        void saveData(String login, String password);
    }


    interface Presenter {

        void register(String username, String password1, String password2);

    }

    interface View {
        void signUp();

        void error();
    }

}
