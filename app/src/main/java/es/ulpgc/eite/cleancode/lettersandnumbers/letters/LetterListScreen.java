package es.ulpgc.eite.cleancode.lettersandnumbers.letters;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.lettersandnumbers.R;
import es.ulpgc.eite.cleancode.lettersandnumbers.app.AppMediator;

public class LetterListScreen {

  public static void configure(LetterListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();

    LetterListContract.Presenter presenter = new LetterListPresenter(mediator);
    LetterListContract.Model model = new LetterListModel();
    presenter.injectModel(model);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
